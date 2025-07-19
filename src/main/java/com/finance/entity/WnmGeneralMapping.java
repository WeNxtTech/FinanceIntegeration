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
@Data
@Entity
@Table(name = "wnm_general_mapping")
public class WnmGeneralMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gm_sys_id")
    private Long gmSysId;

    @Column(name = "gm_map_type", length = 30)
    private String gmMapType;

    @Column(name = "gm_map_type_desc", length = 240)
    private String gmMapTypeDesc;

    @Column(name = "gm_table", length = 240)
    private String gmTable;

    @Column(name = "gm_column", length = 240)
    private String gmColumn;

    @Column(name = "gm_column_type", length = 30)
    private String gmColumnType;

    @Column(name = "gm_column_desc", length = 240)
    private String gmColumnDesc;

    @Column(name = "gm_value_type", length = 240)
    private String gmValueType;

    @Column(name = "gm_sql_stmt", columnDefinition = "TEXT")
    private String gmSqlStmt;

    @Column(name = "gm_cr_uid", length = 100)
    private String gmCrUid;

    @Column(name = "gm_cr_dt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date gmCrDt;

    @Column(name = "gm_upd_uid", length = 100)
    private String gmUpdUid;

    @Column(name = "gm_upd_dt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date gmUpdDt;
    @Column(name = "company_id")
    private String companyId;
    // Getters and Setters
    // You can use Lombok (@Getter, @Setter) to avoid boilerplate
}
