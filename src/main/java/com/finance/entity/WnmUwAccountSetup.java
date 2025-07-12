package com.finance.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Table(name = "wnm_uw_account_setup")
@Data
public class WnmUwAccountSetup {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pas_sys_id")
	private Long pasSysId;

	@Column(name = "acnt_comp_code", length = 30)
	private String acntCompCode;

	@Column(name = "acnt_dept_code", length = 30)
	private String acntDeptCode;

	@Column(name = "acnt_divn_code", length = 30)
	private String acntDivnCode;

	@Column(name = "acnt_narration", columnDefinition = "TEXT")
	private String acntNarration;

	@Column(name = "acnt_sub_type", length = 30)
	private String acntSubType;

	@Column(name = "acnt_sub_type_desc", length = 240)
	private String acntSubTypeDesc;

	@Column(name = "acnt_type", length = 30)
	private String acntType;

	@Column(name = "acnt_type_desc", length = 240)
	private String acntTypeDesc;

	@Column(name = "bussiness_type_fm", length = 30)
	private String bussinessTypeFm;

	@Column(name = "bussiness_type_to", length = 30)
	private String bussinessTypeTo;

	@Column(name = "charge_code_fm", length = 30)
	private String chargeCodeFm;

	@Column(name = "charge_code_to", length = 30)
	private String chargeCodeTo;

	@Column(name = "comp_entry_yn")
	private Integer compEntryYn;

	@Column(name = "company_code_fm", length = 30)
	private String companyCodeFm;

	@Column(name = "company_code_to", length = 30)
	private String companyCodeTo;

	@Column(name = "cover_code_fm", length = 30)
	private String coverCodeFm;

	@Column(name = "cover_code_to", length = 30)
	private String coverCodeTo;

	@Column(name = "created_by", length = 100)
	private String createdBy;

	@Column(name = "created_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	@Column(name = "department_code_fm", length = 30)
	private String departmentCodeFm;

	@Column(name = "department_code_to", length = 30)
	private String departmentCodeTo;

	@Column(name = "division_code_fm", length = 30)
	private String divisionCodeFm;

	@Column(name = "division_code_to", length = 30)
	private String divisionCodeTo;

	@Column(name = "drcr_flag", length = 30)
	private String drcrFlag;

	@Column(name = "effective_fm")
	@Temporal(TemporalType.DATE)
	private Date effectiveFm;

	@Column(name = "effective_to")
	@Temporal(TemporalType.DATE)
	private Date effectiveTo;

	@Column(name = "instru_code_fm", length = 30)
	private String instruCodeFm;

	@Column(name = "instru_code_to", length = 30)
	private String instruCodeTo;

	@Column(name = "main_acnt_code", length = 30)
	private String mainAcntCode;

	@Column(name = "post_online_yn")
	private Integer postOnlineYn;

	@Column(name = "product_code_fm", length = 30)
	private String productCodeFm;

	@Column(name = "product_code_to", length = 30)
	private String productCodeTo;

	@Column(name = "replace_text_1", length = 100)
	private String replaceText1;

	@Column(name = "replace_text_2", length = 100)
	private String replaceText2;

	@Column(name = "replace_text_3", length = 100)
	private String replaceText3;

	@Column(name = "replace_text_4", length = 100)
	private String replaceText4;

	@Column(name = "replace_text_5", length = 100)
	private String replaceText5;

	@Column(name = "replace_text_6", length = 100)
	private String replaceText6;

	@Column(name = "replace_text_7", length = 100)
	private String replaceText7;

	@Column(name = "replace_text_8", length = 100)
	private String replaceText8;

	@Column(name = "replace_text_9", length = 100)
	private String replaceText9;

	@Column(name = "replace_text_10", length = 100)
	private String replaceText10;

	@Column(name = "section_code_fm", length = 30)
	private String sectionCodeFm;

	@Column(name = "section_code_to", length = 30)
	private String sectionCodeTo;

	@Column(name = "src_code_fm", length = 30)
	private String srcCodeFm;

	@Column(name = "src_code_to", length = 30)
	private String srcCodeTo;

	@Column(name = "src_type_fm", length = 30)
	private String srcTypeFm;

	@Column(name = "src_type_to", length = 30)
	private String srcTypeTo;

	@Column(name = "sub_acnt_code", length = 30)
	private String subAcntCode;

	@Column(name = "transaction_code", length = 30)
	private String transactionCode;

	@Column(name = "updated_by", length = 100)
	private String updatedBy;

	@Column(name = "updated_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;

	@Column(name = "vat_code_fm", length = 30)
	private String vatCodeFm;

	@Column(name = "vat_code_to", length = 30)
	private String vatCodeTo;
	
	@Column(name = "active_status_YN", length = 30)
	private String activeStatusYN;
	
	@Column(name = "cust_catg_desc")
	private String custCatdesc;
	
	@Column(name = "cust_catg")
	private String custCatg;
	
	
	

}
