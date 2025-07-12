package com.finance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.finance.entity.YiPolicyDetail;

public interface YiPolicyDetailRepository  extends JpaRepository<YiPolicyDetail,String > , JpaSpecificationExecutor<YiPolicyDetail> {

	YiPolicyDetail findByQuotationPolicyNo(String policyNo);
}
