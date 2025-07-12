package com.finance.service;

import org.springframework.http.ResponseEntity;

import com.finance.bean.IntegerationBean;

public interface FinanceIntegerationservice {

	ResponseEntity<?> createForFreshPolicy(IntegerationBean integerationBean);

	ResponseEntity<?> createaccountDetailsForFreshPolicy(IntegerationBean integerationBean);

	ResponseEntity<?> callExternalApi(String policyNo);

}
