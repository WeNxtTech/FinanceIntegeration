package com.finance.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class IntegerationBean {
	@JsonProperty("AccountType")
	private String accountType;
	@JsonProperty("LoginUserId")
	private String loginUserId;
	@JsonProperty("AcntType")
	private String acntType;
	@JsonProperty("PolicyNo")
	private String policyNo;
	@JsonProperty("QuoteNo")
	private String quoteNo;
	@JsonProperty("AdAhSysId")
	private String ad_ah_sysId;
	@JsonProperty("InsuranceId")
	private String companyId;
	@JsonProperty("ProductId")
	private String productId;
	
	@JsonProperty("sysId")
	private String sysId;
	
}
