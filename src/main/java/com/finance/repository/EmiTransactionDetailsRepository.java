package com.finance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.finance.bean.EmiTransactionDetailsId;
import com.finance.bean.PaymentDetailDTO;
import com.finance.entity.EmiTransactionDetails;

public interface EmiTransactionDetailsRepository extends JpaRepository<EmiTransactionDetails, EmiTransactionDetailsId>,
		JpaSpecificationExecutor<EmiTransactionDetails> {

	List<EmiTransactionDetails> findByQuoteNoAndCompanyId(String quoteNo, String companyId);

	@Query(value = "SELECT pd.PAYMENT_TYPEDESC AS paymentMode, pd.PayeeName AS payeeName FROM payment_detail pd WHERE pd.payment_id = :paymentId", nativeQuery = true)
	PaymentDetailDTO findPaymentDetailByPaymentId(@Param("paymentId") String paymentId);



	@Query(value = "select pd.PAYMENT_TYPEDESC AS paymentMode, pd.PayeeName AS payeeName from home_position_master em  join payment_detail pd on em.quote_no=pd.quote_no where em.quote_no= :quoteno", nativeQuery = true)
	PaymentDetailDTO findHomePositionMaster(@Param("quoteno") String quoteno);
	


	@Query(value = "SELECT COALESCE(MAX(ah_uw_sys_id), 0) FROM wnt_acnt_hdr", nativeQuery = true)
	Integer findMaxwnt_acnt_hdrAhSysId();
	


	@Query(value = "SELECT  COALESCE(MAX(ah_pol_idx), 0) FROM wnt_acnt_hdr", nativeQuery = true)
	Integer findMaxwnt_acnt_hdrAhpolId();
	
}
