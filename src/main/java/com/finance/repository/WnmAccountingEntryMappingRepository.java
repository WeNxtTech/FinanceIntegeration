package com.finance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.finance.entity.WnmAccountingEntryMapping;

public interface WnmAccountingEntryMappingRepository
		extends JpaRepository<WnmAccountingEntryMapping, Long>, JpaSpecificationExecutor<WnmAccountingEntryMapping> {

	List<WnmAccountingEntryMapping> findByAcntTableAndAcntType(String acntTable,String acntType);

	List<WnmAccountingEntryMapping> findByAcntTableAndAcntSubType(String acntTable, String acntSubType);
	List<WnmAccountingEntryMapping> findByAcntTypeAndAcntSubType(String acntType, String acntSubType);

	List<WnmAccountingEntryMapping> findByAcntTable(String targetTable);


}