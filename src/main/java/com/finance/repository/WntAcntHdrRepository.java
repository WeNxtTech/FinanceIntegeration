package com.finance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.finance.entity.WntAcntHdr;

import jakarta.transaction.Transactional;

@Repository
public interface WntAcntHdrRepository extends JpaRepository<WntAcntHdr, Long> {

	@Query(value = "SELECT MAX(ah_sys_id) FROM wnt_acnt_hdr WHERE ah_pol_no = :policyNo", nativeQuery = true)
	Long findLatestByPolicyNo(@Param("policyNo") String policyNo);

	@Modifying
	@Transactional
	@Query(value="DELETE FROM wnt_acnt_hdr w WHERE w.ah_pol_no = :policyNo", nativeQuery = true)
	void deleteByPolicyNo(@Param("policyNo") String policyNo);

    
//    @Query(value = "SELECT ah_sys_id FROM wnt_acnt_hdr WHERE ah_pol_no = :policyNo", nativeQuery = true)
//    Long findAhSysIdByPolicyNo(@Param("policyNo") String policyNo);

    WntAcntHdr findByAhPolNo(String policyNo);
}
