package com.finance.entity;



import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;




/**
* Domain class for entity "HomePositionMaster"
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
@IdClass(HomePositionMasterId.class)
@Table(name="home_position_master")


public class HomePositionMaster implements Serializable {
 
private static final long serialVersionUID = 1L;
 
//--- ENTITY PRIMARY KEY 
@Id
@Column(name="REQUEST_REFERENCE_NO", nullable=false, length=20)
private String     requestReferenceNo ;

@Id
@Column(name="QUOTE_NO", nullable=false)
private String    quoteNo ;

@Id
@Column(name="NO_OF_VEHICLES", nullable=false)
private Integer    noOfVehicles ;

@Id
@Column(name="AGENCY_CODE", nullable=false)
private Integer    agencyCode ;

@Column(name="ADMIN_LOGIN_ID")
private String    adminLoginId ;

//--- ENTITY DATA FIELDS 
@Column(name="CUSTOMER_ID", nullable=false)
private String    customerId ;

@Column(name="PRODUCT_ID", nullable=false)
private Integer    productId ;

@Column(name="COMPANY_ID", nullable=false, length=20)
private String     companyId ;

@Column(name="PROPOSAL_NO", length=15)
private String     proposalNo ;

@Column(name="APPLICATION_NO", nullable=false)
private Long       applicationNo ;

@Column(name="LOGIN_ID", nullable=false, length=50)
private String     loginId ;

@Column(name="APPLICATION_ID", length=100)
private String     applicationId ;

@Column(name="CUSTOMER_NAME", length=50)
private String     customerName;

@Column(name="SECTION_ID", nullable=false)
private Integer    sectionId ;

@Column(name="BROKER_CODE", length=25)
private String     brokerCode ;

@Column(name="AC_EXECUTIVE_ID")
private Long       acExecutiveId ;

@Column(name="STATUS", length=3)
private String     status ;

@Column(name="POLICY_NO", length=100)
private String     policyNo ;

@Column(name="ORIGINAL_POLICY_NO", length=100)
private String     originalPolicyNo ;

@Column(name="POLICY_TERM", length=20)
private String     policyTerm ;

@Column(name="EMI_YN", length=20)
private String     emiYn;

@Column(name="INSTALLMENT_PERIOD", length=20)
private String     installmentPeriod ;

@Column(name="AMEND_ID", nullable=false)
private Integer    amendId ;

@Temporal(TemporalType.TIMESTAMP)
@Column(name="QUOTE_CREATED_DATE")
private Date       quoteCreatedDate ;

@Temporal(TemporalType.TIMESTAMP)
@Column(name="ENTRY_DATE")
private Date       entryDate ;

@Temporal(TemporalType.TIMESTAMP)
@Column(name="INCEPTION_DATE")
private Date       inceptionDate ;

@Temporal(TemporalType.TIMESTAMP)
@Column(name="EXPIRY_DATE")
private Date       expiryDate ;

@Temporal(TemporalType.TIMESTAMP)
@Column(name="EFFECTIVE_DATE")
private Date       effectiveDate ;

@Column(name="HIJRI_POLICY_START_DATE", length=40)
private String     hijriPolicyStartDate ;

@Column(name="HIJRI_POLICY_END_DATE", length=40)
private String     hijriPolicyEndDate ;

@Temporal(TemporalType.TIMESTAMP)
@Column(name="LAPSED_DATE")
private Date       lapsedDate ;

@Column(name="LAPSED_REMARKS", length=250)
private String     lapsedRemarks ;

@Column(name="LAPSED_UPDATED_BY", length=50)
private String     lapsedUpdatedBy ;

@Column(name="CURRENCY", length=50)
private String     currency ;

@Column(name="REMARKS", length=100)
private String     remarks ;

@Column(name="EXCHANGE_RATE")
private BigDecimal     exchangeRate ;

@Column(name="EXCESS_SIGN", length=1)
private String     excessSign ;

@Column(name="PREMIUM_FC")
private BigDecimal     premiumFc ;

@Column(name="EXCESS_PREMIUM")
private BigDecimal excessPremium ;

@Column(name="PREMIUM_LC")
private BigDecimal     premiumLc ;

@Column(name="DISCOUNT_PREMIUM")
private BigDecimal     discountPremium ;

@Column(name="POLICY_FEE")
private BigDecimal policyFee ;

@Column(name="OTHER_FEE")
private BigDecimal     otherFee ;

@Column(name="VAT_PERCENT")
private BigDecimal     vatPercent ;

@Column(name="TAX1")
private BigDecimal     tax1 ;

@Column(name="TAX2")
private BigDecimal     tax2 ;

@Column(name="COMMISSION_PERCENTAGE")
private BigDecimal commissionPercentage ;

@Column(name="TAX3")
private BigDecimal     tax3 ;

@Column(name="VAT_PREMIUM_LC")
private BigDecimal     vatPremiumLc ;

@Column(name="VAT_COMMISSION")
private BigDecimal vatCommission ;

@Column(name="COMMISSION")
private BigDecimal commission ;

@Column(name="VAT_PREMIUM_FC")
private BigDecimal     vatPremiumFc ;

@Column(name="OVERALL_PREMIUM_LC")
private BigDecimal     overallPremiumLc ;

@Column(name="CALC_PREMIUM")
private BigDecimal     calcPremium ;

@Column(name="ADMIN_REMARKS", length=470)
private String     adminRemarks ;

@Column(name="OVERALL_PREMIUM_FC")
private BigDecimal     overallPremiumFc ;

@Column(name="ADMIN_REFERRAL_STATUS", length=1)
private String     adminReferralStatus ;

@Column(name="REFERRAL_DESCRIPTION", length=500)
private String     referralDescription ;

@Column(name="BRANCH_CODE", length=8)
private String     branchCode ;

@Column(name="BRANCH_NAME", length=8)
private String     branchName ;

@Column(name="FINALIZE_YN", length=10)
private String     finalizeYn ;

@Column(name="APPROVED_BY", length=30)
private String     approvedBy ;

@Column(name="APPR_CAN_BY", length=100)
private String     apprCanBy ;

@Temporal(TemporalType.TIMESTAMP)
@Column(name="APPR_CAN_DT")
private Date       apprCanDt ;

@Column(name="APPR_CAN_REMARKS", length=500)
private String     apprCanRemarks ;

@Column(name="CANCELLED_REASON", length=200)
private String     cancelledReason ;

@Temporal(TemporalType.TIMESTAMP)
@Column(name="CANCELLED_DATE")
private Date       cancelledDate ;

@Column(name="CANCELLED_BY", length=20)
private String     cancelledBy ;

@Column(name="DEBIT_AC_NO", length=80)
private String     debitAcNo ;

@Column(name="DEBIT_TO", length=10)
private String     debitTo ;

@Column(name="DEBIT_TO_ID", length=10)
private String     debitToId ;

@Column(name="DEBIT_NOTE_NO", length=50)
private String     debitNoteNo ;

@Temporal(TemporalType.TIMESTAMP)
@Column(name="DEBIT_NOTE_DATE")
private Date       debitNoteDate ;

@Column(name="CREDIT_TO", length=10)
private String     creditTo ;

@Column(name="CREDIT_TO_ID", length=10)
private String     creditToId ;

@Column(name="CREDIT_NO", length=50)
private String     creditNo ;

@Temporal(TemporalType.TIMESTAMP)
@Column(name="CREDIT_DATE")
private Date       creditDate ;

@Column(name="RECEIPT_NO", length=25)
private String     receiptNo ;

@Temporal(TemporalType.TIMESTAMP)
@Column(name="RECEIPT_DATE")
private Date       receiptDate ;

@Column(name="DECLARATION_STATUS", length=10)
private String     declarationStatus ;

@Column(name="PDF_BROKER_STATUS")
private Short      pdfBrokerStatus ;

@Column(name="SUMMARY_CLAUSES", length=470)
private String     summaryClauses ;

@Column(name="SUMMARY_REMARKS", length=2000)
private String     summaryRemarks ;

@Column(name="BROKER_ADDITIONAL_COMMISSION")
private BigDecimal brokerAdditionalCommission ;

@Column(name="PAYMENT_MODE", length=20)
private String     paymentMode ;

@Column(name="PAYMENT_STATUS", length=1)
private String     paymentStatus ;

@Column(name="RENEWAL_STATUS", length=10)
private String     renewalStatus ;

@Column(name="RENEWAL_OLD_POLICY", length=100)
private String     renewalOldPolicy ;

@Column(name="ENDT_STATUS", length=10)
private String     endtStatus ;

@Column(name="ENDT_TYPE_ID", length=100)
private String     endtTypeId ;

@Temporal(TemporalType.TIMESTAMP)
@Column(name="ENDT_DATE")
private Date       endtDate ;

@Column(name="ENDT_BY", length=100)
private String     endtBy ;



@Column(name="ENDT_COMMISSION")
private BigDecimal endtCommission ;

@Column(name="ADMIN_SUMMARY_STATUS", length=1)
private String     adminSummaryStatus ;

@Column(name="CLASS_ID", length=1)
private String     classId ;

@Column(name="COVER_NOTE_NUMBER")
private BigDecimal coverNoteNumber ;

@Column(name="CSH_ID_TYP_CODE")
private Short      cshIdTypCode ;

@Column(name="INGSERIAL_NUMBER", length=20)
private String     ingserialNumber ;

@Column(name="CHQ_INV_NO", length=10)
private String     chqInvNo ;

@Column(name="OWNNERDRIVER_YN", length=1)
private String     ownnerdriverYn ;

@Temporal(TemporalType.TIMESTAMP)
@Column(name="RENEWAL_OLD_EXP_DATE")
private Date       renewalOldExpDate ;

@Column(name="RENEWAL_DATE_YN", length=1)
private String     renewalDateYn ;

@Column(name="VEHICLE_NO")
private Integer    vehicleNo ;

@Column(name="MIN_PREMIUM_YN", length=10)
private String     minPremiumYn ;

@Column(name="SMS_YN", length=10)
private String     smsYn ;

@Column(name="HAVEPROMO_YN", length=50)
private String     havepromoYn ;

@Column(name="PROMO_YN", length=10)
private String     promoYn ;

@Column(name="PROMOCODE", length=100)
private String     promocode ;

@Column(name="PROMO_AGENCY_CODE", length=60)
private String     promoAgencyCode ;

@Column(name="EMPCODE", length=30)
private String     empcode ;

@Column(name="NO_OF_INSTALLMENT")
private String     noOfInstallment ;

@Column(name="INSURED_BY", length=25)
private String     insuredBy ;

@Column(name="INTEGRATION_STATUS", length=20)
private String     integrationStatus ;

@Column(name="INTEGRATION_ERROR", length=800)
private String     integrationError ;

@Column(name="CORE_POLICY_NO", length=80)
private String     corePolicyNo ;

@Column(name="CORE_DEBIT_NOTE", length=80)
private String     coreDebitNote ;

@Column(name="CORE_CREDIT_NOTE", length=80)
private String     coreCreditNote ;

@Column(name="CORE_INTG_STATUS", length=80)
private String     coreIntgStatus ;

@Column(name="CORE_INTG_REMARKS", length=1000)
private String     coreIntgRemarks ;

@Column(name="CORE_INTG_QUEUE")
private BigDecimal     coreIntgQueue ;

@Column(name="OTHER_FEE_1")
private BigDecimal     otherFee1 ;

@Column(name="OTHER_FEE_2")
private BigDecimal     otherFee2 ;

@Column(name="OTHER_FEE_3")
private BigDecimal     otherFee3 ;

@Column(name="OTHER_FEE_PERC_1")
private BigDecimal     otherFeePerc1 ;

@Column(name="OTHER_FEE_PERC_2")
private BigDecimal     otherFeePerc2 ;

@Column(name="OTHER_FEE_PERC_3")
private BigDecimal     otherFeePerc3 ;

@Column(name="PROMO_RATE")
private BigDecimal     promoRate ;

@Column(name="PROMO_PREMIUM")
private BigDecimal     promoPremium ;

@Column(name="DRAFT_STATUS", length=10)
private String     draftStatus ;

@Column(name="TRAN_CODE", length=100)
private String     tranCode ;

@Column(name="DOC_NO", length=100)
private String     docNo ;

@Column(name="AAA_CARDNO", length=20)
private String     aaaCardno ;

@Column(name="RSA_CARDNO", length=20)
private String     rsaCardno ;

@Column(name="ORANGE_CARDNO", length=20)
private String     orangeCardno ;

@Column(name="CHANNEL_LIST", length=50)
private String     channelList ;

@Column(name="SOURCE_TYPE", length=100)
private String     sourceType ;

@Column(name="MODE_OF_PAYMENT", length=50)
private String     modeOfPayment ;

@Column(name="PAYMENT_TYPE", length=50)
private String     paymentType ;

@Column(name="CUST_APPROVE_STATUS", length=10)
private String     custApproveStatus ;

@Column(name="CUST_REJECT_REMARKS", length=1000)
private String     custRejectRemarks ;

@Temporal(TemporalType.TIMESTAMP)
@Column(name="CUST_APPROVE_DATE")
private Date       custApproveDate ;

@Column(name="CREDIT_LIMIT_STATUS", length=10)
private String     creditLimitStatus ;

@Column(name="POL_INTEG_STATUS", length=50)
private String     polIntegStatus ;

@Column(name="INTEG_PRODUCT", length=12)
private String     integProduct ;

@Column(name="BDM_CODE", length=20)
private String     bdmCode ;

@Column(name="ADD_CONDITION", length=1000)
private String     addCondition ;

@Column(name="ORANGE_CARDURL", length=1000)
private String     orangeCardurl ;

@Column(name="HOD_LOGINID", length=100)
private String     hodLoginid ;

@Column(name="CEO_REFERRAL", length=30)
private String     ceoReferral ;

@Column(name="EMIINSTALL_YN", length=10)
private String     emiinstallYn ;

@Column(name="COLL_BRANCH_CODE", length=8)
private String     collBranchCode ;

@Column(name="EMI_ID")
private BigDecimal     emiId ;

@Column(name="EMI_PREMIUM")
private BigDecimal     emiPremium ;

@Column(name="POLICY_TINYURL", length=250)
private String     policyTinyurl ;

@Column(name="REFERAL_CODES", length=250)
private String     referalCodes ;

@Column(name="OLD_APPLICATION_ID", length=80)
private String     oldApplicationId ;

@Column(name="PROMOTYPE", length=15)
private String     promotype ;

@Column(name="PREV_POLICYTYPE", length=10)
private String     prevPolicytype ;

@Column(name="TINY_URL", length=500)
private String     tinyUrl ;

@Column(name="TARGET_PRICE")
private BigDecimal     targetPrice ;

@Column(name="VISION_REPLACEMENT")
private BigDecimal     visionReplacement ;

@Column(name="VISION_MAINTENANCE")
private BigDecimal     visionMaintenance ;

@Column(name="AGGR_REFERENCEID", length=80)
private String     aggrReferenceid ;

@Column(name="PREMIUMWOVAT")
private BigDecimal     premiumwovat ;

@Column(name="VERIFICATION_CODE")
private BigDecimal     verificationCode ;

@Column(name="MMM_CARDNO", length=20)
private String     mmmCardno ;

@Column(name="NAJM_FEE")
private BigDecimal najmFee ;

@Column(name="NO_CLAIM_DISCOUNT_VALUE")
private BigDecimal noClaimDiscountValue ;

@Column(name="NO_CLAIM_DISCOUNT", length=10)
private String     noClaimDiscount ;

@Column(name="IS_FINACIAL_ENDT", length=20)
private String     isFinacialEndt ;

@Column(name="BROKER_BRANCH_CODE", length=20)
private String     brokerBranchCode ;

@Column(name="MANUAL_REFERAL_YN", length=100)
private String  manualReferalYn;

@Column(name="CUSTOMER_CODE", length=100)
private String  customerCode;

@Column(name="BROKER_BRANCH_NAME", length=100)
private String  brokerBranchName;

@Column(name="COMPANY_NAME", length=100)
private String  companyName;

@Column(name="PRODUCT_NAME", length=100)
private String  productName;

@Column(name="USER_TYPE", length=100)
private String  userType;

@Column(name="SUB_USER_TYPE", length=100)
private String  subUserType;

@Column(name="COMMISSION_TYPE", length=100)
private String  commissionType;

@Column(name="COMMISSION_TYPE_DESC", length=100)
private String  commissionTypeDesc;

@Column(name="ENDT_CATEG_DESC", length=100)
private String     endtCategDesc ;

@Column(name="ENDORSEMENT_REMARKS", length=500)
private String     endorsementRemarks ;

@Temporal(TemporalType.TIMESTAMP)
@Column(name="ENDORSEMENT_EFFDATE")
private Date       endorsementEffdate ;

@Column(name="ENDT_PREV_POLICY_NO", length=100)
private String     endtPrevPolicyNo ;

@Column(name="ENDT_PREV_QUOTE_NO", length=50)
private String     endtPrevQuoteNo ;

@Column(name="ENDT_COUNT")
private Integer    endtCount ;

@Column(name="IS_CHARG_REFUND")
private String isChargRefund;

@Column(name="ENDT_TYPE_DESC")
private String endtTypeDesc;

@Column(name="ENDT_PREMIUM_TAX")
private BigDecimal endtPremiumTax;

@Column(name="TIRA_COVER_NOTE_NO")
private String tiraCoverNoteNo;

@Column(name="TIRA_REQUEST_ID")
private String tiraRequestId;

@Column(name="TIRA_RESPONSE_ID")
private String tiraResponseId;

@Column(name="COVERNOTE_REFERENCENO")
private String coverNoteReferenceNo;

@Column(name="STICKER_NUMBER")
private String stickerNumber;

@Column(name="RESPONSE_STATUS_CODE")
private String responseStatusCode;

@Column(name="RESPONSE_STATUS_DESC")
private String responseStatusDesc;

@Column(name="PREV_COVERNOTE_REFNO")
private String prevCoverNoteRefNo;
@Column(name="ENDT_PREMIUM")
private BigDecimal       endtPremium ;
@Column(name="ENDT_PREMIUM_LC")
private BigDecimal       endtPremiumLc ;

@Temporal(TemporalType.TIMESTAMP)
@Column(name="POLICY_COVERTED_DATE")
private Date       policyCovertedDate ;

@Column(name="COMMISSION_MODIFY_YN")
private String commissionModifyYn;

@Column(name="SALE_POINT_CODE", length=200)
private String    salePointCode;

@Column(name="POLICY_PERIOD", length=20)
private String    policyPeriod;

@Column(name="BROKER_TIRA_CODE")
private String brokerTiraCode;

@Column(name="SOURCE_TYPE_ID")
private String sourceTypeId;

@Column(name="CORE_QUOTE_NO")
private String coreQuoteNo;
 
@Column(name="CORE_SGS_ID")
private String coreSgsId;

@Column(name="REFERAL_REMAKS", length=500)
private String referalRemarks;
 

@Column(name = "LEAD_SEQNO")
private Long leadSeqNo;

@Column(name = "QUOTE_STATUS", length = 300)
private String quotestatus;


@Column(name = "uw_sys_id")
private Long uwsysId;

@Column(name = "ah_pol_idx")
private Long ahpolIdx;
}



