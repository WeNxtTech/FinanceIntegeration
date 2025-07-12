package com.finance.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finance.bean.IntegerationBean;
import com.finance.service.IntegerationService;

@RestController
@RequestMapping("/integeration")
public class IntegerationController {
	@Autowired
	private IntegerationService integrationService;

	@PostMapping("/createHdrForFreshPolicy")
	public ResponseEntity<?> createHdrForFreshPolicy1(@RequestBody IntegerationBean integerationBean) {
		return  integrationService.createHdrForFreshPolicy(integerationBean);
		/**Map<String, String> response = new HashMap<>();
		response.put("status", "success");
		response.put("message", "Successfully inserted record into wnt_acnt_hdr for table");
		return ResponseEntity.ok(response);**/
	}

	@PostMapping("/createAccountDtlForFreshPolicy")
	public ResponseEntity<?> createAccountDtlForFreshPolicy(@RequestBody IntegerationBean integerationBean) {
		return integrationService.createaccountDetailsForFreshPolicy(integerationBean);
	/**	Map<String, String> response = new HashMap<>();
		response.put("status", "success");
		response.put("message", "Successfully inserted record into Fwnt_acnt_dtls for table");
		return ResponseEntity.ok(response);**/
	}

}
