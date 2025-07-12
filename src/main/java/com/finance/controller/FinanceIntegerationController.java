package com.finance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finance.bean.IntegerationBean;
import com.finance.service.FinanceIntegerationservice;

@RestController
@RequestMapping("/finance")
public class FinanceIntegerationController {
	@Autowired
	private FinanceIntegerationservice integrationService;

	@PostMapping("/createForFreshPolicy")
	public ResponseEntity<?> createHdrForFreshPolicy1(@RequestBody IntegerationBean integerationBean) {
		 ResponseEntity<?> hdrForFreshPolicy = integrationService.createForFreshPolicy(integerationBean);
		 callExternalApi(integerationBean);
		 return hdrForFreshPolicy;
	}

	@PostMapping("/createAccountDtlForFreshPolicy")
	public ResponseEntity<?> createAccountDtlForFreshPolicy(@RequestBody IntegerationBean integerationBean) {
		return integrationService.createaccountDetailsForFreshPolicy(integerationBean);
	}
	@PostMapping("/callExternalApi")
	public ResponseEntity<?> callExternalApi(@RequestBody IntegerationBean integerationBean) {
		return integrationService.callExternalApi(integerationBean.getPolicyNo());
	}
}
