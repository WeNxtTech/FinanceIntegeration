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
@Table(name = "wnt_acnt_dtl")  
@Data
public class WntAcntDtl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ad_sys_id", nullable = false)
    private Long adSysId;

    @Column(name = "ad_ah_sys_id")
    private Long adAhSysId;

    @Column(name = "ad_amount_fc")
    private Double adAmountFc;

    @Column(name = "ad_amount_lc")
    private Double adAmountLc;

    @Column(name = "ad_brk_risk_note_no", length = 200)
    private String adBrkRiskNoteNo;

    @Column(name = "ad_bus_type", length = 30)
    private String adBusType;

    @Column(name = "ad_channel_code", length = 50)
    private String adChannelCode;

    @Column(name = "ad_channel_desc", length = 500)
    private String adChannelDesc;

    @Column(name = "ad_claim_no", length = 100)
    private String adClaimNo;

    @Column(name = "ad_comp_code", length = 10)
    private String adCompCode;

    @Column(name = "ad_comp_entry_yn")
    private Integer adCompEntryYn;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ad_cr_dt")
    private Date adCrDt;

    @Column(name = "ad_cr_uid", length = 50)
    private String adCrUid;

    @Column(name = "ad_currency_code", length = 30)
    private String adCurrencyCode;

    @Column(name = "ad_cust_code", length = 30)
    private String adCustCode;

    @Column(name = "ad_dept_code", length = 30)
    private String adDeptCode;

    @Column(name = "ad_divn_code", length = 30)
    private String adDivnCode;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ad_doc_dt")
    private Date adDocDt;

    @Column(name = "ad_doc_no")
    private Integer adDocNo;

    @Column(name = "ad_drcr_flag", length = 30)
    private String adDrcrFlag;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ad_due_dt")
    private Date adDueDt;

    @Column(name = "ad_end_code", length = 30)
    private String adEndCode;

    @Column(name = "ad_end_desc", length = 200)
    private String adEndDesc;

    @Column(name = "ad_end_no", length = 100)
    private String adEndNo;

    @Column(name = "ad_exchange_rate")
    private Double adExchangeRate;

    @Column(name = "ad_fac_plmt_no", length = 100)
    private String adFacPlmtNo;

    @Column(name = "ad_fin_amount_fc")
    private Double adFinAmountFc;

    @Column(name = "ad_fin_amount_lc")
    private Double adFinAmountLc;

    @Column(name = "ad_fin_doc_no", length = 100)
    private String adFinDocNo;

    @Column(name = "ad_fin_tran_ref_no", length = 100)
    private String adFinTranRefNo;

    @Column(name = "ad_inst_no")
    private Integer adInstNo;

    @Column(name = "ad_instru_type", length = 30)
    private String adInstruType;

    @Column(name = "ad_insured_code", length = 50)
    private String adInsuredCode;

    @Column(name = "ad_insured_name", length = 500)
    private String adInsuredName;

    @Column(name = "ad_lob_code", length = 30)
    private String adLobCode;

    @Column(name = "ad_main_ac_code", length = 50)
    private String adMainAcCode;

    @Column(name = "ad_narration", length = 2000)
    private String adNarration;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ad_pol_fm_dt")
    private Date adPolFmDt;

    @Column(name = "ad_pol_idx")
    private Integer adPolIdx;

    @Column(name = "ad_pol_no", length = 100)
    private String adPolNo;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ad_pol_to_dt")
    private Date adPolToDt;

    @Column(name = "ad_prod_code", length = 30)
    private String adProdCode;

    @Column(name = "ad_sr_no")
    private Integer adSrNo;

    @Column(name = "ad_src_code", length = 50)
    private String adSrcCode;

    @Column(name = "ad_src_name", length = 500)
    private String adSrcName;

    @Column(name = "ad_sub_ac_code", length = 50)
    private String adSubAcCode;

    @Column(name = "ad_tran_code", length = 30)
    private String adTranCode;

    @Column(name = "ad_tran_type", length = 30)
    private String adTranType;

    @Column(name = "ad_tty_code", length = 100)
    private String adTtyCode;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ad_upd_dt")
    private Date adUpdDt;

    @Column(name = "ad_upd_uid", length = 50)
    private String adUpdUid;

    @Column(name = "ad_uw_sys_id")
    private Integer adUwSysId;

    @Column(name = "businesscategory", length = 30)
    private String businessCategory;

    @Column(name = "businesschoice", length = 30)
    private String businessChoice;

    @Column(name = "businesscurrency", length = 30)
    private String businessCurrency;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "businessdocumentdate")
    private Date businessDocumentDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "businessduedate")
    private Date businessDueDate;

    @Column(name = "businessflag", length = 30)
    private String businessFlag;

    @Column(name = "businessgl", length = 50)
    private String businessGl;

    @Column(name = "businessmemo", length = 240)
    private String businessMemo;

    @Column(name = "businessreference", length = 100)
    private String businessReference;

    @Column(name = "businesstransactioncode", length = 30)
    private String businessTransactionCode;

    @Column(name = "businesstransactionstatus", length = 30)
    private String businessTransactionStatus;

    @Column(name = "businesstransactiontype", length = 30)
    private String businessTransactionType;

    @Column(name = "businesstransvalue")
    private Double businessTransactionValue;

    @Column(name = "ibnr_process_id", length = 50)
    private String ibnrProcessId;

    @Column(name = "oslr_process_id", length = 50)
    private String oslrProcessId;

    @Column(name = "takaful_process_id", length = 50)
    private String takafulProcessId;

    @Column(name = "tty_process_id", length = 50)
    private String ttyProcessId;

    @Column(name = "upr_process_id", length = 50)
    private String uprProcessId;

    @Column(name = "xol_process_id", length = 50)
    private String xolProcessId;

}
