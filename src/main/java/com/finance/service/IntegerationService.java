package com.finance.service;

import org.springframework.http.ResponseEntity;

import com.finance.bean.IntegerationBean;

public interface IntegerationService {

	ResponseEntity<?> createHdrForFreshPolicy(IntegerationBean integerationBean);

	ResponseEntity<?> createaccountDetailsForFreshPolicy(IntegerationBean integerationBean);

}
