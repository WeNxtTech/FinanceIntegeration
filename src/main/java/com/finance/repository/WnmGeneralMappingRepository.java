package com.finance.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finance.entity.WnmGeneralMapping;


@Repository
public interface WnmGeneralMappingRepository extends JpaRepository<WnmGeneralMapping, Long> {

	List<WnmGeneralMapping> findByGmTableAndCompanyId(String targetTable,String companyId);
}