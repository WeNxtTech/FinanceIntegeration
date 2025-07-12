package com.finance.service;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finance.bean.IntegerationBean;
import com.finance.entity.WnmAccountingEntryMapping;
import com.finance.entity.WnmUwAccountSetup;
import com.finance.repository.WnmAccountingEntryMappingRepository;
import com.finance.repository.WnmUwAccountSetupRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Service
public class IntegerationServiceImpl implements IntegerationService {
	
	private static final Logger logger = LoggerFactory.getLogger(IntegerationServiceImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private WnmAccountingEntryMappingRepository mappingRepo;

	@Autowired
	private WnmUwAccountSetupRepository accountSetUpRepo;

	@Override
	@Transactional
	public ResponseEntity<?> createHdrForFreshPolicy(IntegerationBean integerationBean) {
		Map<String, String> response = new HashMap<>();
		try {
			String targetTable = "wnt_acnt_hdr";
			String loginUserId = integerationBean.getLoginUserId();
			String policyNo = integerationBean.getPolicyNo();

			List<WnmAccountingEntryMapping> mappings = mappingRepo.findByAcntTable(targetTable);

			if (mappings.isEmpty()) {
				logger.warn("No mappings found for table: {}", targetTable);
				response.put("status", "Failed");
				response.put("message", "no mapping data in WnmAccountingEntryMapping");
				return ResponseEntity.ok(response);
			}

			Map<String, Object> resultMap = new HashMap<>();

			for (WnmAccountingEntryMapping mapping : mappings) {
				String column = mapping.getAcntColumn();
				String valueType = mapping.getAcntValueType();
				String sqlOrValue = mapping.getAcntSqlStmt();
				System.out.println(column);
				if (valueType == null || column == null) {
					logger.warn("Skipping mapping with null valueType or column: {}", mapping);
					continue;
				}

				String normalizedValueType = valueType.toLowerCase().replaceAll("\\s", "");

				switch (normalizedValueType) {
				case "fromscript":
					if (sqlOrValue != null && !sqlOrValue.trim().isEmpty()) {
						try {
							String cleanedSql = sqlOrValue.replace('\u00A0', ' ').trim();
							Query query = entityManager.createNativeQuery(cleanedSql);

							if (cleanedSql.contains(":policyno")) {
								query.setParameter("policyno", policyNo);
							}

							Object result = query.getSingleResult();
							if (result instanceof Object[]) {
								resultMap.put(column, ((Object[]) result)[0]);
							} else {
								resultMap.put(column, result);
							}
						} catch (Exception e) {
							logger.error("Error executing SQL for column {}: {}", column, e.getMessage(), e);
						}
					}
					break;

				case "constant":
					resultMap.put(column, parseValueFromString(sqlOrValue));
					break;

				case "systemdate":
					resultMap.put(column, new Date());
					break;

				case "loginuserid":
					resultMap.put(column, loginUserId);
					break;

				case "standardtext":
					resultMap.put(column, "Request Sent Successfully");
					break;

				case "default":
					resultMap.put(column, policyNo);
					break;

				default:
					logger.warn("Unknown valueType: {}", valueType);
				}
			}

			if (resultMap.isEmpty()) {
				logger.warn("No values found to insert into table {}", targetTable);
				response.put("status", "Failed");
				response.put("message", "No values found to insert into table: " + targetTable);
				return ResponseEntity.ok(response);
			}

			StringBuilder columns = new StringBuilder();
			StringBuilder placeholders = new StringBuilder();
			int count = 0;
			for (String col : resultMap.keySet()) {
				if (count > 0) {
					columns.append(", ");
					placeholders.append(", ");
				}
				columns.append(col);
				placeholders.append("?");
				count++;
			}

			String sql = "INSERT INTO " + targetTable + " (" + columns + ") VALUES (" + placeholders + ")";
			Query insertQuery = entityManager.createNativeQuery(sql);

			int paramIndex = 1;
			for (String col : resultMap.keySet()) {
				insertQuery.setParameter(paramIndex++, resultMap.get(col));
			}

			int insertedCount = insertQuery.executeUpdate();

			if (insertedCount > 0) {
				logger.info("Successfully inserted record into '{}' for policyNo = {}", targetTable, policyNo);
			} else {
				logger.warn("Insert returned zero affected rows for policyNo = {}", policyNo);
			}
			response.put("status", "success");
			response.put("message", "Successfully inserted record into wnt_acnt_hdr for table");
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			logger.error("Error in createHdrForFreshPolicy: ", e);
			response.put("status", "Failed");
			response.put("message", "Error in Saving wnt_acnt_hdr");
			return ResponseEntity.ok(response);
		}
	}

	private Object parseValueFromString(String value) {
		if (value == null) {
			return null;
		}
		value = value.trim();

		try {
			if (value.matches("\\d+")) {
				return Integer.parseInt(value);
			} else if (value.matches("\\d+\\.\\d+")) {
				return Double.parseDouble(value);
			} else if ("true".equalsIgnoreCase(value) || "false".equalsIgnoreCase(value)) {
				return Boolean.parseBoolean(value);
			}
		} catch (NumberFormatException e) {
			logger.warn("Failed to parse value: {}", value, e);
		}

		return value;
	}

	@Override
	@Transactional
	public ResponseEntity<?> createaccountDetailsForFreshPolicy(IntegerationBean integerationBean) {
		Map<String, String> response = new HashMap<>();
		String targetTable = "wnt_acnt_dtl";
		try {
			String acntType = integerationBean.getAccountType();
			String loginUserId = integerationBean.getLoginUserId();
			String policyNo = integerationBean.getPolicyNo();

			List<WnmUwAccountSetup> accountList = accountSetUpRepo.findByAcntTypeAndActiveStatusYN(acntType, "Y");

			for (WnmUwAccountSetup accountSetup : accountList) {
				String acntSubType = accountSetup.getAcntSubType();

				List<WnmAccountingEntryMapping> mappingList = mappingRepo.findByAcntTypeAndAcntSubType(acntType,
						acntSubType);

				if (mappingList.isEmpty()) {
					logger.warn("No mapping found for acntType={} and acntSubType={}", acntType, acntSubType);
					continue;
				}
				Map<String, Object> insertValues = new LinkedHashMap<>();

				for (WnmAccountingEntryMapping mapping : mappingList) {
					String column = mapping.getAcntColumn();
					String valueType = mapping.getAcntValueType();
					String sqlStmt = mapping.getAcntSqlStmt();

					if (column == null || valueType == null)
						continue;

					try {
						String normalizedValueType = valueType.toLowerCase().replaceAll("\\s", "");
						switch (normalizedValueType) {
						case "fromscript":
							if (sqlStmt != null && !sqlStmt.trim().isEmpty()) {
								String cleanSql = sqlStmt.replace('\u00A0', ' ').trim();
								Query query = entityManager.createNativeQuery(cleanSql);

								if (cleanSql.contains(":policyno"))
									query.setParameter("policyno", policyNo);
								if (cleanSql.contains(":acntsubtype"))
									query.setParameter("acntsubtype", acntSubType);
								if (cleanSql.contains(":loginuserid"))
									query.setParameter("loginuserid", loginUserId);

								Object result = query.getSingleResult();
								insertValues.put(column, result);
							}
							break;

						case "constant":
							insertValues.put(column, parseValueFromString(sqlStmt));
							break;

						case "systemdate":
							insertValues.put(column, new java.sql.Date(System.currentTimeMillis()));
							break;

						case "loginuserid":
							insertValues.put(column, loginUserId);
							break;

						case "sequencenumber":
							insertValues.put(column, null);
							break;

						case "standardtext":
							insertValues.put(column, "Request Sent Successfully");
							break;
						case "default":
							insertValues.put(column, policyNo);
							break;
						default:
							logger.warn("Unhandled valueType '{}' for column '{}'", valueType, column);
						}
					} catch (Exception e) {
						logger.error("Error processing mapping for column '{}': {}", column, e.getMessage(), e);
					}
				}

				if (!insertValues.isEmpty()) {
					String columns = String.join(", ", insertValues.keySet());
					String placeholders = insertValues.keySet().stream().map(k -> "?")
							.collect(Collectors.joining(", "));

					String sql = "INSERT INTO " + targetTable + " (" + columns + ") VALUES (" + placeholders + ")";
					Query insertQuery = entityManager.createNativeQuery(sql);

					int index = 1;
					for (Object val : insertValues.values()) {
						insertQuery.setParameter(index++, val);
					}
					insertQuery.executeUpdate();
					logger.info("Inserted record into {} for policyNo={} and acntSubType={}", targetTable, policyNo,
							acntSubType);
				}
			}
			response.put("status", "success");
			response.put("message", "Successfully inserted record into Fwnt_acnt_dtls for table");
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			logger.error("Error in createPolicyDetailsForFreshPolicy: ", e);
			response.put("status", "Failed");
			response.put("message", "Error in Saving PolicyDetails");
			return ResponseEntity.ok(response);
		}
	}

}
