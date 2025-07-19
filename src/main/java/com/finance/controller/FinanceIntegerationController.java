package com.finance.controller;

import java.util.Map;

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
		if (hdrForFreshPolicy.getBody() instanceof Map) {
			@SuppressWarnings("unchecked")
			Map<String, String> responseMap = (Map<String, String>) hdrForFreshPolicy.getBody();

			String uwsysId = responseMap.get("uwsysId");
			String polIdxId = responseMap.get("polIdxId");

			return integrationService.callExternalCreateAccountingApi(integerationBean.getPolicyNo(), uwsysId, polIdxId);

		}
		return hdrForFreshPolicy;
	}

	@PostMapping("/customerCreation")
	public ResponseEntity<?> customerCreation(@RequestBody IntegerationBean integerationBean) {
		ResponseEntity<?> hdrForFreshPolicy = integrationService.customerCreation(integerationBean);
		if (hdrForFreshPolicy.getBody() instanceof Map) {
			@SuppressWarnings("unchecked")
			Map<String, String> responseMap = (Map<String, String>) hdrForFreshPolicy.getBody();

			String customerCode = responseMap.get("customerCode");
			integrationService.subledgerIntegrationExternalApi(customerCode);

		}

		return hdrForFreshPolicy;
	}

	@PostMapping("/createAccountDtlForFreshPolicy")
	public ResponseEntity<?> createAccountDtlForFreshPolicy(@RequestBody IntegerationBean integerationBean) {
		return integrationService.createaccountDetailsForFreshPolicy(integerationBean);
	}
//	@PostMapping("/callExternalApi")
//	public ResponseEntity<?> callExternalApi(@RequestBody IntegerationBean integerationBean) {
//		return integrationService.callExternalCreateAccountingApi(integerationBean.getPolicyNo());
//	}
}
