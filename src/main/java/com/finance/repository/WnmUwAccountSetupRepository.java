package com.finance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finance.entity.WnmUwAccountSetup;

public interface WnmUwAccountSetupRepository extends JpaRepository<WnmUwAccountSetup, Long> {
    List<WnmUwAccountSetup> findByAcntTypeAndActiveStatusYN(String acntType,String activeStatusYN);
}