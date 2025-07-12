package com.finance.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;




/**
* Domain class for entity "YiPolicyDetail"
*
* @author Telosys Tools Generator
*
*/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@DynamicInsert
@DynamicUpdate
@Builder
@Table(name="yi_policy_detail")


public class YiPolicyDetail implements Serializable {
 
private static final long serialVersionUID = 1L;
 
    //--- ENTITY PRIMARY KEY 
@Id
@Column(name="REQUESTREFERENCENO", nullable=false, length=15)
private String     requestreferenceno ;

//--- ENTITY DATA FIELDS 
@Column(name="SERVICE_ID", length=40)
private String     serviceId ;

@Column(name="SERVICE_ACTION", length=40)
private String     serviceAction ;

@Column(name="QUOTATION_POLICY_NO", length=60)
private String     quotationPolicyNo ;

@Column(name="INDEX_NO", length=5)
private String     indexNo ;

@Column(name="DIVISION_CODE", length=12)
private String     divisionCode ;

@Column(name="PRODUCT", length=12)
private String     product ;

@Column(name="POLICY_TYPE", length=12)
private String     policyType ;

@Column(name="BUSINESS_TYPE", length=12)
private String     businessType ;

@Column(name="CUSTOMER", length=100)
private String     customer ;

@Column(name="SOURCE_TYPE", length=12)
private String     sourceType ;

@Column(name="SOURCE_CODE", length=12)
private String     sourceCode ;

@Column(name="DEPARTMENT", length=12)
private String     department ;

@Temporal(TemporalType.TIMESTAMP)
@Column(name="POLICY_ISSUE_DT")
private Date       policyIssueDt ;

@Temporal(TemporalType.TIMESTAMP)
@Column(name="PERIOD_FROM")
private Date       periodFrom ;

@Temporal(TemporalType.TIMESTAMP)
@Column(name="PERIOD_TO")
private Date       periodTo ;

@Column(name="DUR_TYPE", length=12)
private String     durType ;

@Column(name="CIVIL_ID", length=60)
private String     civilId ;

@Column(name="CONTACT_EMAIL_ID", length=240)
private String     contactEmailId ;

@Column(name="CONTACT_NUMBER", length=240)
private String     contactNumber ;

@Column(name="CONTACT_PER_NAME", length=240)
private String     contactPerName ;

@Column(name="COVER_NOTE_NO", length=60)
private String     coverNoteNo ;

@Column(name="PREM_CURR", length=12)
private String     premCurr ;

@Temporal(TemporalType.TIMESTAMP)
@Column(name="QUOTE_RECEIVED_DT")
private Date       quoteReceivedDt ;

@Column(name="RA_ALLOCATION_AT", length=12)
private String     raAllocationAt ;

@Column(name="RA_APPL_YN", length=1)
private String     raApplYn ;

@Column(name="RENEWAL_RECORD_YN", length=1)
private String     renewalRecordYn ;

@Column(name="SI_CURR", length=12)
private String     siCurr ;

@Column(name="SIC_CODE", length=12)
private String     sicCode ;

@Column(name="SIC_GROUP", length=12)
private String     sicGroup ;

@Column(name="TERR_ACCEPTED_YN", length=1)
private String     terrAcceptedYn ;

@Column(name="TERRITORYJURISDICTION", length=240)
private String     territoryjurisdiction ;

@Column(name="TERRORISM_FOR_ALL_RISK", length=12)
private String     terrorismForAllRisk ;

@Temporal(TemporalType.TIMESTAMP)
@Column(name="CN_ISSUE_DATE")
private Date       cnIssueDate ;

@Column(name="DONOTRENEWYN", length=1)
private String     donotrenewyn ;

@Column(name="ADVICE_DATE", length=1)
private String     adviceDate ;

@Column(name="BOOK_ID")
private BigDecimal bookId ;

@Column(name="BROKER_REF_NO", length=60)
private String     brokerRefNo ;

@Column(name="BROKING_SLIP", length=240)
private String     brokingSlip ;

@Column(name="ADDRESS_LINE1", length=240)
private String     addressLine1 ;

@Column(name="ADDRESS_LINE2", length=240)
private String     addressLine2 ;

@Column(name="ADDRESS_LINE3", length=240)
private String     addressLine3 ;

@Column(name="STATE", length=100)
private String     state ;

@Column(name="CITY", length=12)
private String     city ;

@Column(name="COUNTRY", length=12)
private String     country ;

@Column(name="CUST_REF", length=2000)
private String     custRef ;

@Column(name="ISSUED_AT", length=240)
private String     issuedAt ;

@Column(name="METHOD", length=12)
private String     method ;

@Column(name="MODE_OF_PAYMENT", length=12)
private String     modeOfPayment ;

@Column(name="FAC_YN", length=1)
private String     facYn ;

@Column(name="HYPOTHECATION_YN", length=1)
private String     hypothecationYn ;

@Column(name="INSTALLMENT_YN", length=1)
private String     installmentYn ;

@Column(name="POLICY_PERIOD",length=100)
private String policyPeriod ;

@Column(name="PRE_INSP_REQ_YN", length=1)
private String     preInspReqYn ;

@Column(name="PREM_CALC_TYPE", length=12)
private String     premCalcType ;

@Column(name="INSURED_FIRSTNAME", length=240)
private String     insuredFirstname ;

@Column(name="INSURED_MIDDLENAME", length=240)
private String     insuredMiddlename ;

@Column(name="INSURED_LASTNAME", length=240)
private String     insuredLastname ;

@Column(name="INSURED_PHONE_NUMBER", length=240)
private String     insuredPhoneNumber ;

@Column(name="INSURED_EMAILID", length=240)
private String     insuredEmailid ;

@Column(name="INSURED_OCCUPATION", length=100)
private String     insuredOccupation ;

@Temporal(TemporalType.TIMESTAMP)
@Column(name="REQUEST_TIME")
private Date       requestTime ;

@Temporal(TemporalType.TIMESTAMP)
@Column(name="RESPONSE_TIME")
private Date       responseTime ;

@Column(name="STATUS", length=10)
private String     status ;

@Column(name="P_WS_RESPONSE_TYPE", length=100)
private String     pWsResponseType ;

@Column(name="P_WS_ERROR", length=500)
private String     pWsError ;

@Column(name="CURRENT_STATUS", length=50)
private String     currentStatus ;

@Column(name="CLAIM_INTM_DAYS")
private Double     claimIntmDays ;

@Column(name="CN_NO_AS_POLICY_NO_YN", length=10)
private String     cnNoAsPolicyNoYn ;

@Column(name="INSURED", length=100)
private String     insured ;

@Column(name="INTEG_STATUS", length=100)
private String     integStatus ;

@Column(name="QUOTATION_TYPE", length=12)
private String     quotationType ;

@Column(name="OLD_POLICY_NO", length=60)
private String     oldPolicyNo ;

@Temporal(TemporalType.TIMESTAMP)
@Column(name="QUOTATION_ISSUE_DT")
private Date       quotationIssueDt ;

@Column(name="VALIDITY_PERIOD", length=100)
private String     validityPeriod ;

@Column(name="UW_ID", length=10)
private String     uwId ;

@Column(name="PREM_WARRENTY_YN", length=5)
private String     premWarrentyYn ;

@Column(name="EXCESS_OF_LOSS_INDICATOR", length=10)
private String     excessOfLossIndicator ;

@Column(name="INDIVIDUAL_AC_NO", length=60)
private String     individualAcNo ;

@Column(name="SEC_CODE", length=50)
private String     secCode ;

@Column(name="POL_FLEET_YN", length=50)
private String     polFleetYn ;

@Column(name="PAY_MODE", length=10)
private String     payMode ;

@Column(name="BANK_NAME", length=200)
private String     bankName ;

@Column(name="BRANCH_NAME", length=200)
private String     branchName ;

@Temporal(TemporalType.TIMESTAMP)
@Column(name="DATE_OF_COLLECTION")
private Date       dateOfCollection ;

@Column(name="CHEQUE_NO", length=100)
private String     chequeNo ;

@Temporal(TemporalType.TIMESTAMP)
@Column(name="CHEQUE_DATE")
private Date       chequeDate ;

@Column(name="CREDIT_CARD_NO", length=100)
private String     creditCardNo ;

@Column(name="CARD_TYPE", length=50)
private String     cardType ;

@Column(name="AUTHORIZATION_CODE", length=50)
private String     authorizationCode ;

@Column(name="TRANSACTION_ID", length=60)
private String     transactionId ;

@Temporal(TemporalType.TIMESTAMP)
@Column(name="TRANSACTION_DATE")
private Date       transactionDate ;

@Column(name="REQUEST_USER_ID", length=13)
private String     requestUserId ;

@Column(name="NET_PREMIUM", length=50)
private String     netPremium ;

@Column(name="INSURED_WILAYAT", length=250)
private String     insuredWilayat ;

@Column(name="INSURED_VISA_STATUS", length=250)
private String     insuredVisaStatus ;

@Column(name="PROMOCODE", length=50)
private String     promocode ;

@Column(name="POL_CUST_CODE", length=50)
private String     polCustCode ;

@Column(name="POL_NO_RISK")
private Integer     polNoRisk ;

@Column(name="ASSR_CODE_YN")
private Integer     assrCodeYn ;

@Column(name="NET_PREMIUM_FC")
private BigDecimal     netPremiumFc ;

@Column(name="COMPANY_ID")
private String     companyId ;

//--- ENTITY LINKS ( RELATIONSHIP )

@Column(name = "POL_SRC_TYPE", length = 200)
private String polSrcType;

@Column(name = "POL_SRC_CODE", length = 200)
private String polSrcCode;

@Column(name = "POL_BUS_TYPE", length = 200)
private String polBusType;

@Column(name = "POL_ASSR_CODE", length = 200)
private String polAssrCode;

@Column(name = "POL_TEL_NO", length = 200)
private String polTelNo;

@Column(name = "POL_EMAIL_ID", length = 200)
private String polEmailId;

@Column(name = "POL_NO", length = 200)
private String polNo;

@Column(name = "POL_PREM_LC_1", length = 200)
private String polPremLc1;

@Column(name = "POL_CATG", length = 200)
private String polCatg;

@Column(name = "POL_PREM_CALC_TYPE", length = 200)
private String polPremCalcType;

@Column(name = "POL_APPR_DT", length = 200)
private String polApprDt;

@Column(name = "POL_APPR_UID", length = 200)
private String polApprUid;

@Column(name = "POL_EXCHG_RATE", length = 200)
private String polExchgRate;

@Column(name = "POL_CUST_NATIONAL_ID", length = 200)
private String polCustNationalId;

@Column(name = "POL_CUST_NATIONAL_ID_TYPE", length = 200)
private String polCustNationalIdType;

@Column(name = "POL_TYPE_OF_CUSTOMER", length = 200)
private String polTypeOfCustomer;
@Column(name = "POL_AG_BRK_MOBILE_NO", length = 200)
private String polAgBrkMobileNo;

@Column(name = "POL_AG_BRK_COMM_PERC", length = 200)
private String polAgBrkCommPerc;

@Column(name = "POL_AG_BRK_COMM_AMT", length = 200)
private String polAgBrkCommAmt;

@Column(name = "POL_USD_EXCH_RATE", length = 200)
private String polUsdExchRate;

@Column(name = "POL_END_NO_IDX", length = 200)
private String polEndNoIdx;

@Column(name = "NO_OF_INSTALLMENT", length = 10)
private String noOfInstallment;

}



