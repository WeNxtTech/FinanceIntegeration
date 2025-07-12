package com.finance.entity;



import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.finance.bean.EmiTransactionDetailsId;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@DynamicInsert
@DynamicUpdate
@Builder
@IdClass(EmiTransactionDetailsId.class)
@Table(name="emi_transaction_details")


public class EmiTransactionDetails implements Serializable {
 
private static final long serialVersionUID = 1L;
 
    //--- ENTITY PRIMARY KEY 
    @Id
    @Column(name="QUOTE_NO", nullable=false, length=20)
    private String     quoteNo ;

    @Id
    @Column(name="PRODUCT_ID", nullable=false, length=20)
    private String     productId ;

    @Id
    @Column(name="INSTALMENT", nullable=false, length=20)
    private String     instalment ;
    
    @Id
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="DUE_DATE", nullable=false)
    private Date       dueDate ;

    //--- ENTITY DATA FIELDS 
    @Column(name="PREMIUM_WITH_TAX")
    private Double     premiumWithTax ;

    @Column(name="INSTALLMENT_PERIOD", length=20)
    private String     installmentPeriod ;
    
    @Column(name="INSTALLMENT_DESC", length=20)
    private String     installmentDesc ;
    
    @Column(name="COMPANY_ID", length=20)
    private String     companyId ;
    
    @Column(name="INTEREST")
    private Double     interest ;
    
    @Column(name="INTEREST_AMOUNT")
    private Double     interestAmount ;
    
    @Column(name="TOTAL_LOAN_AMOUNT")
    private Double     totalLoanAmount ;
    
    @Column(name="ADVANCE", length=20)
    private String     advance ;
    
    @Column(name="DUE_AMOUNT")
    private Double     dueAmount ;
    
    @Column(name="BALANCE_AMOUNT")
    private Double     balanceAmount ;
    
    @Column(name="PAYMENT_STATUS", length=1)
    private String     paymentStatus ;

    @Column(name="PAYMENT_DETAILS", length=20)
    private String     paymentDetails ;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="PAYMENT_DATE")
    private Date       paymentDate ;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="ENTRY_DATE")
    private Date       entryDate ;

    @Column(name="STATUS", length=1)
    private String     status ;

    @Column(name="REMARKS", length=100)
    private String     remarks ;

    @Column(name="CREATED_BY", length=100)
    private String     createdBy ;

    @Column(name="UPDATED_BY", length=100)
    private String     updatedBy ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="UPDATED_DATE")
    private Date       updatedDate ;

    @Column(name="SELECT_YN", length=100)
    private String     selectYn ;
    
    @Column(name="PAYMENT_ID", length=20)
    private String     paymentId ;
    
    @Column(name="MERCHANT_REFERENCE", length=100)
    private String     merchantReference ;
    
    //Endt Fields
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
    
    @Column(name="ENDT_STATUS", length=10)
    private String     endtStatus ;

    @Column(name="ENDT_TYPE_ID", length=100)
    private String     endtTypeId ;

    @Column(name="ENDT_COUNT")
    private Integer    endtCount ;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="ENDT_DATE")
    private Date       endtDate ;
    
    @Column(name="ENDT_BY")
    private String    endtBy ;

    @Column(name="IS_CHARG_REFUND")
    private String isChargRefund;

    @Column(name="ENDT_TYPE_DESC")
    private String endtTypeDesc;

    @Column(name="ENDT_PREMIUM_TAX")
    private BigDecimal endtPremiumTax;
    
    @Column(name="POLICY_NO", length=100)
    private String     policyNo ;

    @Column(name="ORIGINAL_POLICY_NO", length=100)
    private String     originalPolicyNo ;
    
    @Column(name="ENDT_PREMIUM")
    private BigDecimal       endtPremium ;
    
    @Column(name="ENDT_PREMIUM_LC")
    private BigDecimal       endtPremiumLc ;
    
    @Column(name="IS_FINACIAL_ENDT", length=20)
    private String     isFinacialEndt ;
    
    @Column(name="ENDT_COMMISSION")
    private BigDecimal endtCommission ;

    @Column(name="INSTALLMENT_TYPE_ID")
    private String installmentTypeId;
    
    @Column(name="INSTALLMENT_TYPE_DESC")
    private String installmentTypeDesc;
}



