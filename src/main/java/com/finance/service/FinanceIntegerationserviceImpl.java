package com.finance.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.finance.bean.IntegerationBean;
import com.finance.bean.PaymentDetailDTO;
import com.finance.entity.EmiTransactionDetails;
import com.finance.entity.WnmAccountingEntryMapping;
import com.finance.entity.WnmUwAccountSetup;
import com.finance.entity.WntAcntHdr;
import com.finance.entity.YiPolicyDetail;
import com.finance.repository.EmiTransactionDetailsRepository;
import com.finance.repository.WnmAccountingEntryMappingRepository;
import com.finance.repository.WnmUwAccountSetupRepository;
import com.finance.repository.WntAcntDtlRepository;
import com.finance.repository.WntAcntHdrRepository;
import com.finance.repository.YiPolicyDetailRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Service
public class FinanceIntegerationserviceImpl implements FinanceIntegerationservice {

	private static final Logger logger = LoggerFactory.getLogger(IntegerationServiceImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private WnmAccountingEntryMappingRepository mappingRepo;

	@Autowired
	private WnmUwAccountSetupRepository accountSetUpRepo;

	@Autowired
	private EmiTransactionDetailsRepository emiTransactionDetailsRepo;

	@Autowired
	private YiPolicyDetailRepository yiPolicyDetailRepo;

	@Autowired
	private WntAcntHdrRepository wntAcntHdrRepo;

	@Autowired
	private WntAcntDtlRepository acntDtlRepository;

	@Transactional
	@Override
	public ResponseEntity<?> createForFreshPolicy(IntegerationBean integerationBean) {
		Map<String, String> response = new HashMap<>();
		try {
			String targetTable = "wnt_acnt_hdr";
			String loginUserId = integerationBean.getLoginUserId();
			String policyNo = integerationBean.getPolicyNo();
			String acntType = integerationBean.getAccountType();

			List<WnmAccountingEntryMapping> mappings = mappingRepo.findByAcntTableAndAcntType(targetTable, acntType);
			if (mappings.isEmpty()) {
				response.put("status", "Failed");
				response.put("message", "No mappings found for table: " + targetTable);
				return ResponseEntity.ok(response);
			}
			// Long ahSysId = wntAcntHdrRepo.findAhSysIdByPolicyNo(policyNo);
			WntAcntHdr byAhPolNo = wntAcntHdrRepo.findByAhPolNo(policyNo);
			if (byAhPolNo != null && byAhPolNo.getAhSysId() != null) {
				acntDtlRepository.deleteByAhSysId(byAhPolNo.getAhSysId());
				wntAcntHdrRepo.deleteByPolicyNo(policyNo);
			}
			Map<String, Object> resultMap = new HashMap<>();
			List<String> selectClauses = new ArrayList<>();
			List<String> fromScriptColumns = new ArrayList<>();
			for (WnmAccountingEntryMapping mapping : mappings) {
				String column = mapping.getAcntColumn();
				String valueType = mapping.getAcntValueType();
				String sqlOrValue = mapping.getAcntSqlStmt();

				if (column == null || valueType == null)
					continue;

				String normalizedType = valueType.toLowerCase().replaceAll("\\s", "");

				if ("fromscript".equals(normalizedType) && sqlOrValue != null) {
					selectClauses.add("(" + sqlOrValue + ") AS " + column);
					fromScriptColumns.add(column);
				}
			}

			// Execute SQL queries from "fromscript"
			if (!selectClauses.isEmpty()) {
				String combinedSql = "SELECT " + String.join(", ", selectClauses);
				Query combinedQuery = entityManager.createNativeQuery(combinedSql);
				combinedQuery.setParameter("policyno", policyNo);
				Object[] results = (Object[]) combinedQuery.getSingleResult();

				for (int i = 0; i < fromScriptColumns.size(); i++) {
					resultMap.put(fromScriptColumns.get(i), results[i]);
				}
			}

			// Fill remaining values based on valueType
			for (WnmAccountingEntryMapping mapping : mappings) {
				String column = mapping.getAcntColumn();
				String valueType = mapping.getAcntValueType();
				String sqlOrValue = mapping.getAcntSqlStmt();

				if (resultMap.containsKey(column))
					continue;
				if (column == null || valueType == null)
					continue;

				switch (valueType.toLowerCase().replaceAll("\\s", "")) {
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
					resultMap.put(column, null);
					break;
				default:
					logger.warn("Unknown valueType: {}", valueType);
				}
			}

			// Ensure required key is included
			resultMap.put("ah_pol_no", policyNo);

			if (resultMap.isEmpty()) {
				response.put("status", "Failed");
				response.put("message", "No values found to insert into table: " + targetTable);
				return ResponseEntity.ok(response);
			}

			// Set ah_uw_sys_id
			Integer uwSysId = emiTransactionDetailsRepo.findMaxwnt_acnt_hdrAhSysId();
			Long nextUwSysId = uwSysId != null ? uwSysId.longValue() + 1 : 1L;
			resultMap.put("ah_uw_sys_id", nextUwSysId);

			// Set ah_pol_idx
			Integer maxPolIdx = emiTransactionDetailsRepo.findMaxwnt_acnt_hdrAhpolId();
			Long nextPolIdx = maxPolIdx != null ? maxPolIdx.longValue() + 1 : 1L;
			resultMap.put("ah_pol_idx", nextPolIdx);

			StringBuilder columns = new StringBuilder();
			StringBuilder placeholders = new StringBuilder();
			int index = 1;
			for (String col : resultMap.keySet()) {
				if (index > 1) {
					columns.append(", ");
					placeholders.append(", ");
				}
				columns.append(col);
				placeholders.append("?");
				index++;
			}

			String insertSql = "INSERT INTO " + targetTable + " (" + columns + ") VALUES (" + placeholders + ")";
			Query insertQuery = entityManager.createNativeQuery(insertSql);

			index = 1;
			for (String col : resultMap.keySet()) {
				insertQuery.setParameter(index++, resultMap.get(col));
			}

			insertQuery.executeUpdate();

			entityManager.flush();
			Long adAhSysId = wntAcntHdrRepo.findLatestByPolicyNo(policyNo);
			if (adAhSysId == null) {
				logger.error("No record found after insert for policyNo: {}", policyNo);
				response.put("status", "Failed");
				response.put("message", "Insert succeeded, but retrieval failed.");
				return ResponseEntity.ok(response);
			}

			integerationBean.setAd_ah_sysId(adAhSysId.toString());
			integerationBean.setLoginUserId(loginUserId);

			createaccountDetailsForFreshPolicy(integerationBean);

			response.put("status", "success");
			response.put("message", "Successfully inserted record");
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			logger.error("Error in createHdrForFreshPolicy: ", e);
			response.put("status", "Failed");
			response.put("message", "Error in Saving");
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
			String quoteNo = integerationBean.getQuoteNo();
			String adAhSysId = integerationBean.getAd_ah_sysId();
			// String productId = integerationBean.getProductId();
			String companyId = integerationBean.getCompanyId();

			List<WnmUwAccountSetup> accountList = accountSetUpRepo.findByAcntTypeAndActiveStatusYN(acntType, "Y");
			YiPolicyDetail yipolicyDetail = yiPolicyDetailRepo.findByQuotationPolicyNo(policyNo);
			String sourceCode = yipolicyDetail.getSourceType();

			String expectedCustCatg = null;

			if ("1".equals(sourceCode)) {
				expectedCustCatg = "35";
			} else if ("2".equals(sourceCode)) {
				expectedCustCatg = "25";
			} else if ("3".equals(sourceCode)) {
				expectedCustCatg = "20";
			}
			String finalExpectedCustCatg = expectedCustCatg;

			List<WnmUwAccountSetup> filteredList = accountList.stream().filter(a -> {
				String subType = a.getAcntSubType();
				String custCatg = a.getCustCatg();
				if ("CUSTOMER_PREMIUM".equalsIgnoreCase(subType)) {
					return finalExpectedCustCatg != null && finalExpectedCustCatg.equalsIgnoreCase(custCatg);
				} else {
					return true;
				}
			}).collect(Collectors.toList());

			int installmentCount = Integer.parseInt(yipolicyDetail.getNoOfInstallment());

			List<EmiTransactionDetails> emiList = (installmentCount > 0)
					? emiTransactionDetailsRepo.findByQuoteNoAndCompanyId(quoteNo, companyId)
					: Collections.emptyList();
			int ad_sr_no = 1;
			for (WnmUwAccountSetup accountSetup : filteredList) {
				String acntSubType = accountSetup.getAcntSubType();

				if ("CUSTOMER_PREMIUM".equalsIgnoreCase(acntSubType)) {
					if (installmentCount == 0) {
						/** Insert one record for CUSTOMER_PREMIUM **/
						insertAccountingRecord(acntType, acntSubType, loginUserId, policyNo, quoteNo, adAhSysId,
								targetTable, null, ad_sr_no, finalExpectedCustCatg);
					} else {
						/** Multiple records using EMI list **/
						for (EmiTransactionDetails emiData : emiList) {
							insertAccountingRecord(acntType, acntSubType, loginUserId, policyNo, quoteNo, adAhSysId,
									targetTable, emiData, ad_sr_no, finalExpectedCustCatg);
						}
					}
				} else {
					/** For all other subtypes tables : Insert only one record **/
					insertAccountingRecord(acntType, acntSubType, loginUserId, policyNo, quoteNo, adAhSysId,
							targetTable, emiList != null && !emiList.isEmpty() ? emiList.get(0) : null, ad_sr_no,
							finalExpectedCustCatg);
				}
				ad_sr_no++;
			}
			response.put("status", "success");
			response.put("message", "Successfully inserted record(s) into wnt_acnt_dtl table");
			return ResponseEntity.ok(response);

		} catch (Exception e) {
			logger.error("Error in createaccountDetailsForFreshPolicy: ", e);
			response.put("status", "Failed");
			response.put("message", "Error in Saving PolicyDetails");
			return ResponseEntity.ok(response);
		}
	}

	private void insertAccountingRecord(String acntType, String acntSubType, String loginUserId, String policyNo,
			String quoteNo, String adAhSysId, String targetTable, EmiTransactionDetails emiData, int ad_sr_no,
			String finalExpectedCustCatg) {

		List<WnmAccountingEntryMapping> mappingList = mappingRepo.findByAcntTypeAndAcntSubType(acntType, acntSubType);
		if (mappingList.isEmpty()) {
			logger.warn("No mapping found for acntType={} and acntSubType={}", acntType, acntSubType);
			return;
		}

		Map<String, Object> insertValues = new LinkedHashMap<>();
		List<String> selectExpressions = new ArrayList<>();
		List<String> fromScriptColumns = new ArrayList<>();

		for (WnmAccountingEntryMapping mapping : mappingList) {
			String column = mapping.getAcntColumn();
			String valueType = mapping.getAcntValueType();
			String sqlStmt = mapping.getAcntSqlStmt();

			if (column == null || valueType == null)
				continue;

			String normalizedType = valueType.toLowerCase().replaceAll("\\s", "");
			if ("fromscript".equals(normalizedType) && sqlStmt != null && !sqlStmt.trim().isEmpty()) {
				String cleanSql = sqlStmt.replace('\u00A0', ' ').trim();
				selectExpressions.add("(" + cleanSql + ") AS " + column);
				fromScriptColumns.add(column);
			}
		}

		if (!selectExpressions.isEmpty()) {
			String combinedSql = "SELECT " + String.join(", ", selectExpressions);
			Query combinedQuery = entityManager.createNativeQuery(combinedSql);

			if (combinedSql.contains(":policyno"))
				combinedQuery.setParameter("policyno", policyNo);
			if (combinedSql.contains(":acntsubtype"))
				combinedQuery.setParameter("acntsubtype", acntSubType);
			if (combinedSql.contains(":loginuserid"))
				combinedQuery.setParameter("loginuserid", loginUserId);
			if (combinedSql.contains(":quoteNo"))
				combinedQuery.setParameter("quoteNo", quoteNo);
			if (combinedSql.contains(":castcatg"))
				combinedQuery.setParameter("castcatg", finalExpectedCustCatg);

			Object result = combinedQuery.getSingleResult();
			if (result instanceof Object[]) {
				Object[] values = (Object[]) result;
				for (int i = 0; i < fromScriptColumns.size(); i++) {
					insertValues.put(fromScriptColumns.get(i), values[i]);
				}
			} else {
				insertValues.put(fromScriptColumns.get(0), result);
			}
		}

		for (WnmAccountingEntryMapping mapping : mappingList) {
			String column = mapping.getAcntColumn();
			String valueType = mapping.getAcntValueType();
			String sqlStmt = mapping.getAcntSqlStmt();

			if (column == null || valueType == null || insertValues.containsKey(column))
				continue;

			String normalizedType = valueType.toLowerCase().replaceAll("\\s", "");

			switch (normalizedType) {
			case "constant":
				insertValues.put(column, parseValueFromString(sqlStmt));
				break;
			case "systemdate":
				insertValues.put(column, new java.sql.Date(System.currentTimeMillis()));
				break;
			case "loginuserid":
				insertValues.put(column, loginUserId);
				break;
			case "standardtext":
				insertValues.put(column, "Request Sent Successfully");
				break;
			case "default":
				insertValues.put(column, null);
				break;

			default:
				logger.warn("Unhandled valueType '{}' for column '{}'", valueType, column);
			}
		}

		insertValues.put("ad_ah_sys_id", adAhSysId);
		insertValues.put("ad_sr_no", ad_sr_no);
		if (emiData != null && emiData.getPaymentId() != null) {
			try {
				PaymentDetailDTO paymentData = emiTransactionDetailsRepo
						.findPaymentDetailByPaymentId(emiData.getPaymentId());
				if (paymentData != null) {
					insertValues.put("paymentMode", paymentData.getPaymentMode());
					insertValues.put("payeeName", paymentData.getPayeeName());
					if (targetTable.equalsIgnoreCase("COVER_PREMIUM")) {
						insertValues.put("ad_inst_no", emiData.getInstalment());
					} else if (targetTable.equalsIgnoreCase("CUSTOMER_PREMIUM")) {
						insertValues.put("ad_inst_no", null);
					} else if (targetTable.equalsIgnoreCase("VAT_ON_PREMIUM")) {
						insertValues.put("ad_inst_no", null);
					}
					insertValues.put("ad_instru_type", emiData.getPaymentDetails());

				}

			} catch (NoResultException e) {
				logger.warn("No payment detail found for paymentId={}", emiData.getPaymentId());
			} catch (Exception e) {
				logger.error("Error fetching payment details for paymentId={}", emiData.getPaymentId(), e);
			}
		} else {
			PaymentDetailDTO paymentInfoWithOutInstallMent = emiTransactionDetailsRepo.findHomePositionMaster(quoteNo);
			insertValues.put("paymentMode", paymentInfoWithOutInstallMent.getPaymentMode());
			insertValues.put("payeeName", paymentInfoWithOutInstallMent.getPayeeName());
			insertValues.put("ad_inst_no", null);
			insertValues.put("ad_instru_type", paymentInfoWithOutInstallMent.getPaymentMode());
		}

		if (!insertValues.isEmpty()) {
			String columns = String.join(", ", insertValues.keySet());
			String placeholders = insertValues.keySet().stream().map(k -> "?").collect(Collectors.joining(", "));
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

	@Override
	public ResponseEntity<?> callExternalApi(String policyNo) {
		Map<String, String> response = new HashMap<>();

		try {

			String authUrl = "http://192.168.1.140:8083/auth/generateToken";
			Map<String, String> authRequest = new HashMap<>();
			authRequest.put("username", "admin");
			authRequest.put("password", "admin");

			HttpHeaders authHeaders = new HttpHeaders();
			authHeaders.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<Map<String, String>> authEntity = new HttpEntity<>(authRequest, authHeaders);
			RestTemplate restTemplate = new RestTemplate();

			ResponseEntity<String> authResponse = restTemplate.postForEntity(authUrl, authEntity, String.class);

			String token = authResponse.getBody();

			String accountingUrl = "http://192.168.1.140:8083/stagingtoFin/createAccounting";

			Map<String, Object> accountingRequest = new HashMap<>();

			accountingRequest.put("uwId", 1);
			accountingRequest.put("polIdx", 1);
			accountingRequest.put("policyNo", policyNo);

			HttpHeaders accountingHeaders = new HttpHeaders();
			accountingHeaders.setContentType(MediaType.APPLICATION_JSON);
			accountingHeaders.setBearerAuth(token);

			HttpEntity<Map<String, Object>> accountingEntity = new HttpEntity<>(accountingRequest, accountingHeaders);
			ResponseEntity<String> accountingResponse = restTemplate.postForEntity(accountingUrl, accountingEntity,
					String.class);
			System.out.println("Accounting API Response: " + accountingResponse.getBody());
			response.put("status", "success");
			response.put("message", "Successfully inserted record(s) into wnt_acnt_dtl table");
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
