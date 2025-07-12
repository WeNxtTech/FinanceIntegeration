package com.finance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.finance.entity.WnmPremiumAccountSetup;

public interface WnmPremiumAccountSetupRepository extends JpaRepository<WnmPremiumAccountSetup,Long > , JpaSpecificationExecutor<WnmPremiumAccountSetup>{

}
