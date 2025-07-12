package com.finance.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "wnm_accounting_entry_mapping")
public class WnmAccountingEntryMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aem_sys_id")
    private Long aemSysId;

    @Column(name = "acnt_type", length = 30)
    private String acntType;

    @Column(name = "acnt_type_desc", length = 240)
    private String acntTypeDesc;

    @Column(name = "acnt_sub_type", length = 30)
    private String acntSubType;

    @Column(name = "acnt_sub_type_desc", length = 240)
    private String acntSubTypeDesc;

    @Column(name = "acnt_table", length = 240)
    private String acntTable;

    @Column(name = "acnt_column", length = 240)
    private String acntColumn;

    @Column(name = "acnt_column_type", length = 30)
    private String acntColumnType;

    @Column(name = "acnt_column_desc", length = 240)
    private String acntColumnDesc;

    @Column(name = "acnt_value_type", length = 240)
    private String acntValueType;

    @Column(name = "acnt_sql_stmt", columnDefinition = "TEXT")
    private String acntSqlStmt;

    @Column(name = "acnt_cr_uid", length = 100)
    private String acntCrUid;

    @Column(name = "acnt_cr_dt")
    private LocalDateTime acntCrDt;

    @Column(name = "acnt_upd_uid", length = 100)
    private String acntUpdUid;

    @Column(name = "acnt_upd_dt")
    private LocalDateTime acntUpdDt;

    // Getters and Setters

    public Long getAemSysId() {
        return aemSysId;
    }

    public void setAemSysId(Long aemSysId) {
        this.aemSysId = aemSysId;
    }

    public String getAcntType() {
        return acntType;
    }

    public void setAcntType(String acntType) {
        this.acntType = acntType;
    }

    public String getAcntTypeDesc() {
        return acntTypeDesc;
    }

    public void setAcntTypeDesc(String acntTypeDesc) {
        this.acntTypeDesc = acntTypeDesc;
    }

    public String getAcntSubType() {
        return acntSubType;
    }

    public void setAcntSubType(String acntSubType) {
        this.acntSubType = acntSubType;
    }

    public String getAcntSubTypeDesc() {
        return acntSubTypeDesc;
    }

    public void setAcntSubTypeDesc(String acntSubTypeDesc) {
        this.acntSubTypeDesc = acntSubTypeDesc;
    }

    public String getAcntTable() {
        return acntTable;
    }

    public void setAcntTable(String acntTable) {
        this.acntTable = acntTable;
    }

    public String getAcntColumn() {
        return acntColumn;
    }

    public void setAcntColumn(String acntColumn) {
        this.acntColumn = acntColumn;
    }

    public String getAcntColumnType() {
        return acntColumnType;
    }

    public void setAcntColumnType(String acntColumnType) {
        this.acntColumnType = acntColumnType;
    }

    public String getAcntColumnDesc() {
        return acntColumnDesc;
    }

    public void setAcntColumnDesc(String acntColumnDesc) {
        this.acntColumnDesc = acntColumnDesc;
    }

    public String getAcntValueType() {
        return acntValueType;
    }

    public void setAcntValueType(String acntValueType) {
        this.acntValueType = acntValueType;
    }

    public String getAcntSqlStmt() {
        return acntSqlStmt;
    }

    public void setAcntSqlStmt(String acntSqlStmt) {
        this.acntSqlStmt = acntSqlStmt;
    }

    public String getAcntCrUid() {
        return acntCrUid;
    }

    public void setAcntCrUid(String acntCrUid) {
        this.acntCrUid = acntCrUid;
    }

    public LocalDateTime getAcntCrDt() {
        return acntCrDt;
    }

    public void setAcntCrDt(LocalDateTime acntCrDt) {
        this.acntCrDt = acntCrDt;
    }

    public String getAcntUpdUid() {
        return acntUpdUid;
    }

    public void setAcntUpdUid(String acntUpdUid) {
        this.acntUpdUid = acntUpdUid;
    }

    public LocalDateTime getAcntUpdDt() {
        return acntUpdDt;
    }

    public void setAcntUpdDt(LocalDateTime acntUpdDt) {
        this.acntUpdDt = acntUpdDt;
    }
}
