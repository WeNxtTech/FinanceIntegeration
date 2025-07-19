package com.finance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.transaction.annotation.Transactional;

import com.finance.entity.HomePositionMaster;
import com.finance.entity.HomePositionMasterId;

@Transactional
public interface HomepositionMasterRepository
		extends JpaRepository<HomePositionMaster, HomePositionMasterId>, JpaSpecificationExecutor<HomePositionMaster> {

	HomePositionMaster findByPolicyNo(String policyNo);

}
