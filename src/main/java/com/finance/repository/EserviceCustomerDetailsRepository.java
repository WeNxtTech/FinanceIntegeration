package com.finance.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.finance.entity.EserviceCustomerDetails;
import com.finance.entity.EserviceCustomerDetailsId;

import jakarta.transaction.Transactional;

@Transactional
public interface EserviceCustomerDetailsRepository  extends JpaRepository<EserviceCustomerDetails,EserviceCustomerDetailsId > , JpaSpecificationExecutor<EserviceCustomerDetails> {

	Optional<EserviceCustomerDetails> findByPolCustCode(String sysId);

}
