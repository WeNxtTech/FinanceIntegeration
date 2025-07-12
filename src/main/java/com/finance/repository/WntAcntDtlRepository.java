package com.finance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.finance.entity.WntAcntDtl;

import jakarta.transaction.Transactional;

public interface WntAcntDtlRepository extends JpaRepository<WntAcntDtl, Long>{

    @Modifying
    @Transactional
    @Query(value="DELETE FROM wnt_acnt_dtl w WHERE w.ad_ah_sys_id = :ahSysId", nativeQuery = true)
    void deleteByAhSysId(@Param("ahSysId") Long ahSysId);
}
