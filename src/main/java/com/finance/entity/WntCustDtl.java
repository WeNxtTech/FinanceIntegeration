package com.finance.entity;


import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "wnt_cust_dtl")
public class WntCustDtl {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sysId;

	private String code;

	private Boolean corporate;

	private Boolean credit;

	private Boolean gridGlLedgerStatus;

	private Boolean subGlobalLedgerStatus;

	private Double groupLimit;

	private Long groupId;

	private String nameAr;

	private String nameEn;

	private String partyType;

	private String glGroupLabel;

	private String glGroupValue;

	private String glLabel;

	private String glValue;

	private String parentPartyLabel;

	private String parentPartyValue;

	private String glCompLabel;

	private String glCompValue;

	private String glCurrLabel;

	private String glCurrValue;

	private Long custReqRespStatus;

	@Temporal(TemporalType.TIMESTAMP)
	private Date custReqSentDt;

	@Lob
	private String custReqMessage;

	@Temporal(TemporalType.TIMESTAMP)
	private Date custResRecdDt;

	// @Lob
	private String custRespMessage;

	private String custFinIntgStatus;

	private String custFinIntgRefNo;

	private String ledgerType;

	// You can generate them using Lombok or IDE tools
}
