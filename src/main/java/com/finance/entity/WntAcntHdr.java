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
import jakarta.persistence.Version;
import lombok.Data;

@Entity
@Table(name = "wnt_acnt_hdr")
@Data
public class WntAcntHdr {
//	@Version
//	@Column(name = "version") // Change this to your actual version column name in the table
//	private Long version;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ah_sys_id")
	private Long ahSysId;

	@Column(name = "ah_clm_no", length = 240)
	private String ahClmNo;

	@Column(name = "ah_cr_dt")
	@Temporal(TemporalType.TIMESTAMP)
	private Date ahCrDt;

	@Column(name = "ah_cr_uid", length = 12)
	private String ahCrUid;

	@Column(name = "ah_doc_dt")
	@Temporal(TemporalType.TIMESTAMP)
	private Date ahDocDt;

	@Column(name = "ah_doc_no")
	private Integer ahDocNo;

	@Column(name = "ah_end_no", length = 240)
	private String ahEndNo;

	@Column(name = "ah_fac_place_no", length = 240)
	private String ahFacPlaceNo;

	@Column(name = "ah_fin_intg_ref_no", length = 240)
	private String ahFinIntgRefNo;

	@Column(name = "ah_fin_intg_status", length = 2000)
	private String ahFinIntgStatus;

	@Column(name = "ah_no_of_rec")
	private Integer ahNoOfRec;

	@Column(name = "ah_pol_no", length = 240)
	private String ahPolNo;

//	@Column(name = "ah_req_dt")
//	@Temporal(TemporalType.TIMESTAMP)
//	private Date ahReqDt;

	@Column(name = "ah_req_message", columnDefinition = "TEXT")
	private String ahReqMessage;

	@Column(name = "ah_req_resp_status")
	private Integer ahReqRespStatus;

	@Column(name = "ah_req_sent_dt")
	@Temporal(TemporalType.TIMESTAMP)
	private Date ahReqSentDt;

	@Column(name = "ah_res_recd_dt")
	@Temporal(TemporalType.TIMESTAMP)
	private Date ahResRecdDt;

//	@Column(name = "ah_resp_dt")
//	@Temporal(TemporalType.TIMESTAMP)
//	private Date ahRespDt;

	@Column(name = "ah_resp_message", columnDefinition = "TEXT")
	private String ahRespMessage;

//	@Column(name = "ah_status", length = 20)
//	private String ahStatus;

	@Column(name = "ah_tran_code", length = 12)
	private String ahTranCode;

	@Column(name = "ah_upd_dt")
	@Temporal(TemporalType.TIMESTAMP)
	private Date ahUpdDt;

	@Column(name = "ah_upd_uid", length = 12)
	private String ahUpdUid;

	// Getters and Setters

	public Long getAhSysId() {
		return ahSysId;
	}

	public void setAhSysId(Long ahSysId) {
		this.ahSysId = ahSysId;
	}

	public String getAhClmNo() {
		return ahClmNo;
	}

	public void setAhClmNo(String ahClmNo) {
		this.ahClmNo = ahClmNo;
	}

	public Date getAhCrDt() {
		return ahCrDt;
	}

	public void setAhCrDt(Date ahCrDt) {
		this.ahCrDt = ahCrDt;
	}

	public String getAhCrUid() {
		return ahCrUid;
	}

	public void setAhCrUid(String ahCrUid) {
		this.ahCrUid = ahCrUid;
	}

	public Date getAhDocDt() {
		return ahDocDt;
	}

	public void setAhDocDt(Date ahDocDt) {
		this.ahDocDt = ahDocDt;
	}

	public Integer getAhDocNo() {
		return ahDocNo;
	}

	public void setAhDocNo(Integer ahDocNo) {
		this.ahDocNo = ahDocNo;
	}

	public String getAhEndNo() {
		return ahEndNo;
	}

	public void setAhEndNo(String ahEndNo) {
		this.ahEndNo = ahEndNo;
	}

	public String getAhFacPlaceNo() {
		return ahFacPlaceNo;
	}

	public void setAhFacPlaceNo(String ahFacPlaceNo) {
		this.ahFacPlaceNo = ahFacPlaceNo;
	}

	public String getAhFinIntgRefNo() {
		return ahFinIntgRefNo;
	}

	public void setAhFinIntgRefNo(String ahFinIntgRefNo) {
		this.ahFinIntgRefNo = ahFinIntgRefNo;
	}

	public String getAhFinIntgStatus() {
		return ahFinIntgStatus;
	}

	public void setAhFinIntgStatus(String ahFinIntgStatus) {
		this.ahFinIntgStatus = ahFinIntgStatus;
	}

	public Integer getAhNoOfRec() {
		return ahNoOfRec;
	}

	public void setAhNoOfRec(Integer ahNoOfRec) {
		this.ahNoOfRec = ahNoOfRec;
	}

	public String getAhPolNo() {
		return ahPolNo;
	}

	public void setAhPolNo(String ahPolNo) {
		this.ahPolNo = ahPolNo;
	}

//	public Date getAhReqDt() {
//		return ahReqDt;
//	}
//
//	public void setAhReqDt(Date ahReqDt) {
//		this.ahReqDt = ahReqDt;
//	}

	public String getAhReqMessage() {
		return ahReqMessage;
	}

	public void setAhReqMessage(String ahReqMessage) {
		this.ahReqMessage = ahReqMessage;
	}

	public Integer getAhReqRespStatus() {
		return ahReqRespStatus;
	}

	public void setAhReqRespStatus(Integer ahReqRespStatus) {
		this.ahReqRespStatus = ahReqRespStatus;
	}

	public Date getAhReqSentDt() {
		return ahReqSentDt;
	}

	public void setAhReqSentDt(Date ahReqSentDt) {
		this.ahReqSentDt = ahReqSentDt;
	}

	public Date getAhResRecdDt() {
		return ahResRecdDt;
	}

	public void setAhResRecdDt(Date ahResRecdDt) {
		this.ahResRecdDt = ahResRecdDt;
	}

//	public Date getAhRespDt() {
//		return ahRespDt;
//	}
//
//	public void setAhRespDt(Date ahRespDt) {
//		this.ahRespDt = ahRespDt;
//	}

	public String getAhRespMessage() {
		return ahRespMessage;
	}

	public void setAhRespMessage(String ahRespMessage) {
		this.ahRespMessage = ahRespMessage;
	}

//	public String getAhStatus() {
//		return ahStatus;
//	}
//
//	public void setAhStatus(String ahStatus) {
//		this.ahStatus = ahStatus;
//	}

	public String getAhTranCode() {
		return ahTranCode;
	}

	public void setAhTranCode(String ahTranCode) {
		this.ahTranCode = ahTranCode;
	}

	public Date getAhUpdDt() {
		return ahUpdDt;
	}

	public void setAhUpdDt(Date ahUpdDt) {
		this.ahUpdDt = ahUpdDt;
	}

	public String getAhUpdUid() {
		return ahUpdUid;
	}

	public void setAhUpdUid(String ahUpdUid) {
		this.ahUpdUid = ahUpdUid;
	}
}
