package com.finance.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.finance.bean.IntegerationBean;

public interface FinanceIntegerationservice {

	ResponseEntity<?> createForFreshPolicy(IntegerationBean integerationBean);

	ResponseEntity<?> createaccountDetailsForFreshPolicy(IntegerationBean integerationBean);


	ResponseEntity<?> createCustomerDeatil(String policyNo);

	ResponseEntity<?> customerCreation(IntegerationBean integerationBean);

	ResponseEntity<?> callExternalCreateAccountingApi(String policyNo, String uwsysId, String polIdxId);

	ResponseEntity<String> subledgerIntegrationExternalApi(String polCustCode);

}
