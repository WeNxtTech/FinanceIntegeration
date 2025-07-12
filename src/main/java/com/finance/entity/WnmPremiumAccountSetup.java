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
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "wnm_premium_account_setup")
@Data
@Getter
@Setter
public class WnmPremiumAccountSetup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pas_sys_id")
    private Long pasSysId;

    @Column(name = "acnt_type")
    private String acntType;

    @Column(name = "acnt_type_desc")
    private String acntTypeDesc;

    @Column(name = "acnt_sub_type")
    private String acntSubType;

    @Column(name = "acnt_sub_type_desc")
    private String acntSubTypeDesc;

    @Column(name = "company_code_fm")
    private String companyCodeFm;

    @Column(name = "company_code_to")
    private String companyCodeTo;

    @Column(name = "division_code_fm")
    private String divisionCodeFm;

    @Column(name = "division_code_to")
    private String divisionCodeTo;

    @Column(name = "department_code_fm")
    private String departmentCodeFm;

    @Column(name = "department_code_to")
    private String departmentCodeTo;

    @Column(name = "bussiness_type_fm")
    private String businessTypeFm;

    @Column(name = "bussiness_type_to")
    private String businessTypeTo;

    @Column(name = "product_code_fm")
    private String productCodeFm;

    @Column(name = "product_code_to")
    private String productCodeTo;

    @Column(name = "section_code_fm")
    private String sectionCodeFm;

    @Column(name = "section_code_to")
    private String sectionCodeTo;

    @Column(name = "cover_code_fm")
    private String coverCodeFm;

    @Column(name = "cover_code_to")
    private String coverCodeTo;

    @Column(name = "main_acnt_code")
    private String mainAcntCode;

    @Column(name = "sub_acnt_code")
    private String subAcntCode;

    @Column(name = "acnt_comp_code")
    private String acntCompCode;

    @Column(name = "acnt_divn_code")
    private String acntDivnCode;

    @Column(name = "acnt_dept_code")
    private String acntDeptCode;

    @Column(name = "acnt_narration", columnDefinition = "text")
    private String acntNarration;

    @Column(name = "replace_text_1")
    private String replaceText1;

    @Column(name = "replace_text_2")
    private String replaceText2;

    @Column(name = "replace_text_3")
    private String replaceText3;

    @Column(name = "replace_text_4")
    private String replaceText4;

    @Column(name = "replace_text_5")
    private String replaceText5;

    @Column(name = "replace_text_6")
    private String replaceText6;

    @Column(name = "replace_text_7")
    private String replaceText7;

    @Column(name = "replace_text_8")
    private String replaceText8;

    @Column(name = "replace_text_9")
    private String replaceText9;

    @Column(name = "replace_text_10")
    private String replaceText10;

    @Column(name = "drcr_flag")
    private String drcrFlag;

    @Column(name = "transaction_code")
    private String transactionCode;

    @Column(name = "cust_entry_yn")
    private Integer custEntryYn;

    @Column(name = "post_online_yn")
    private Integer postOnlineYn;

    @Column(name = "effective_fm")
    @Temporal(TemporalType.DATE)
    private Date effectiveFm;

    @Column(name = "effective_to")
    @Temporal(TemporalType.DATE)
    private Date effectiveTo;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "updated_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;

}
