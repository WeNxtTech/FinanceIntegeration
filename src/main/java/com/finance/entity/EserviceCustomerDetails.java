package com.finance.entity;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

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

/**
 * Domain class for entity "EserviceCustomerDetails"
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
@IdClass(EserviceCustomerDetailsId.class)
@Table(name = "eservice_customer_details")

public class EserviceCustomerDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	// --- ENTITY PRIMARY KEY
	@Id
	@Column(name = "CUSTOMER_REFERENCE_NO", nullable = false, length = 20)
	private String customerReferenceNo;

	@Id
	@Column(name = "COMPANY_ID", nullable = false, length = 20)
	private String companyId;

	// --- ENTITY DATA FIELDS
	// @Convert(converter = AttributeEncryptor.class)
	@Column(name = "PRODUCT_ID", nullable = false)
	private Integer productId;

	@Column(name = "CLIENT_NAME", length = 100)
	private String clientName;

	@Column(name = "ADDRESS_1", length = 100)
	private String address1;

	@Column(name = "ADDRESS_2", length = 100)
	private String address2;

	@Column(name = "TITLE", length = 1)
	private String title;

	@Column(name = "REGION_CODE", length = 20)
	private String regionCode;

	@Column(name = "TITLE_DESC", length = 20)
	private String titleDesc;

	@Column(name = "CLIENT_STATUS", length = 20)
	private String clientStatus;

	@Column(name = "STATE_CODE")
	private Integer stateCode;

	@Column(name = "VR_TIN_NO", length = 20)
	private String vrTinNo;

	@Column(name = "STATE_NAME", length = 100)
	private String stateName;

	@Column(name = "BROKER_BRANCH_CODE", length = 100)
	private String brokerBranchCode;

	@Column(name = "CLIENT_STATUS_DESC", length = 100)
	private String clientStatusDesc;

	@Column(name = "POLICY_HOLDER_TYPE", length = 2)
	private String policyHolderType;

	@Column(name = "CITY_CODE")
	private Integer cityCode;

	@Column(name = "CITY_NAME", length = 100)
	private String cityName;

	@Column(name = "POLICY_HOLDER_TYPEID", nullable = false, length = 100)
	private String policyHolderTypeid;

	@Column(name = "ID_TYPE", nullable = false, length = 100)
	private String idType;

	@Column(name = "ID_TYPE_DESC", length = 100)
	private String idTypeDesc;

	@Column(name = "ID_NUMBER", nullable = false, length = 100)
	private String idNumber;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DOB_OR_REG_DATE")
	private Date dobOrRegDate;

	@Column(name = "CREATED_BY", length = 100)
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ENTRY_DATE")
	private Date entryDate;

	@Column(name = "AGE", nullable = false)
	private Integer age;

	@Column(name = "NATIONALITY", length = 20)
	private String nationality;

	@Column(name = "STATUS", length = 1)
	private String status;

	@Column(name = "UPDATED_BY", length = 100)
	private String updatedBy;

	@Column(name = "PLACE_OF_BIRTH", length = 100)
	private String placeOfBirth;

	@Column(name = "GENDER", nullable = false, length = 1)
	private String gender;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATED_DATE")
	private Date updatedDate;

	@Column(name = "GENDER_DESC", length = 20)
	private String genderDesc;

	@Column(name = "OCCUPATION", nullable = false, length = 10)
	private String occupation;

	@Column(name = "OCCUPATION_DESC", length = 20)
	private String occupationDesc;

	@Column(name = "BUSINESS_TYPE", length = 1)
	private String businessType;

	@Column(name = "BUSINESS_TYPE_DESC", length = 20)
	private String businessTypeDesc;

	@Column(name = "VRN_GST", length = 20)
	private String vrnGst;

	@Column(name = "FAX", length = 20)
	private String fax;

	@Column(name = "TELEPHONE_NO_1", length = 20)
	private String telephoneNo1;

	@Column(name = "TELEPHONE_NO_2", length = 20)
	private String telephoneNo2;

	@Column(name = "TELEPHONE_NO_3", length = 20)
	private String telephoneNo3;

	@Column(name = "LANGUAGE", length = 1)
	private String language;

	@Column(name = "LANGUAGE_DESC", length = 20)
	private String languageDesc;

	@Column(name = "IS_TAX_EXEMPTED", nullable = false, length = 1)
	private String isTaxExempted;

	@Column(name = "TAX_EXEMPTED_ID", length = 20)
	private String taxExemptedId;

	@Column(name = "BRANCH_CODE", length = 20)
	private String branchCode;

//    @Column(name="POLICY_HODER_TYPE_DESC", length=100)
//    private String     policyHoderTypeDesc ;
//
//    @Column(name="POLICY_HODER_TYPE_ID_DESC", length=100)
//    private String     policyHoderTypeIdDesc ;

	@Column(name = "POLICY_HOLDER_TYPE_DESC", length = 100)
	private String policyHolderTypeDesc;

	@Column(name = "POLICY_HOLDER_TYPE_ID_DESC", length = 100)
	private String policyHolderTypeIdDesc;

	@Column(name = "STREET", length = 100)
	private String street;

	@Column(name = "MOBILE_CODE_1", length = 20)
	private String mobileCode1;
	@Column(name = "MOBILE_CODE_DESC_1", length = 20)
	private String mobileCodeDesc1;
	@Column(name = "MOBILE_NO_1", length = 20)
	private String mobileNo1;

	@Column(name = "MOBILE_CODE_2", length = 20)
	private String mobileCode2;
	@Column(name = "MOBILE_CODE_DESC_2", length = 20)
	private String mobileCodeDesc2;
	@Column(name = "MOBILE_NO_2", length = 20)
	private String mobileNo2;

	@Column(name = "MOBILE_CODE_3", length = 20)
	private String mobileCode3;
	@Column(name = "MOBILE_CODE_DESC_3", length = 20)
	private String mobileCodeDesc3;
	@Column(name = "MOBILE_NO_3", length = 20)
	private String mobileNo3;

	@Column(name = "WHATSAPP_CODE", length = 20)
	private String whatsappCode;
	@Column(name = "WHATSAPP_CODE_DESC", length = 20)
	private String whatsappCodeDesc;
	@Column(name = "WHATSAPP_NO", length = 20)
	private String whatsappNo;

	@Column(name = "EMAIL_1", length = 100)
	private String email1;

	@Column(name = "EMAIL_2", length = 20)
	private String email2;

	@Column(name = "EMAIL_3", length = 20)
	private String email3;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "APPOINTMENT_DATE")
	private Date appointmentDate;

	@Column(name = "PREFERRED_NOTIFICATION", length = 20)
	private String preferredNotification;

	@Column(name = "PIN_CODE", length = 20)
	private String pinCode;

	@Column(name = "OTHER_OCCUPATION")
	private String otherOccupation;

//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name="ENDORSEMENT_DATE")
//    private Date       endorsementDate ;
//
//    @Column(name="ENDORSEMENT_REMARKS", length=500)
//    private String     endorsementRemarks ;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name="ENDORSEMENT_EFFDATE")
//    private Date       endorsementEffdate ;
//
//    @Column(name="ORIGINAL_POLICY_NO", length=500)
//    private String     originalPolicyNo ;
//
//    @Column(name="ENDT_PREV_POLICY_NO", length=500)
//    private String     endtPrevPolicyNo ;
//
//    @Column(name="ENDT_PREV_QUOTE_NO", length=500)
//    private String     endtPrevQuoteNo ;
//
//    @Column(name="ENDT_COUNT")
//    private BigDecimal endtCount ;
//
//    @Column(name="ENDT_STATUS", length=10)
//    private String     endtStatus ;
//    
//    
//    
//    @Column(name="IS_FINYN", length=10)
//    private String     isFinaceYn ;
//    
//    
//    @Column(name="ENDT_CATEG_DESC", length=10)
//    private String     endtCategDesc ;
//    
//
//    @Column(name="ENDORSEMENT_TYPE")
//    private Integer    endorsementType ;
//
//    @Column(name="ENDORSEMENT_TYPE_DESC", length=100)
//    private String     endorsementTypeDesc ;
//    
//
//    
//    @Column(name="ENDT_PREMIUM")
//    private Double       endtPremium ;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LICENSE_ISSUED_DATE")
	private Date licenseIssuedDate;

	@Column(name = "LICENSE_DURATION", length = 100)
	private Integer licenseDuration;

	@Column(name = "AREA_GROUP", length = 100)
	private String areaGroup;

	@Column(name = "AREA_CLASIFICATION", length = 100)
	private String areaClasification;

	@Column(name = "MARITAL_STATUS", length = 100)
	private String maritalStatus;

	@Column(name = "POL_CUST_CODE", length = 50)
	private String polCustCode;

	@Column(name = "FIRST_NAME", length = 200)
	private String firstName;

	@Column(name = "MIDDLE_NAME", length = 200)
	private String middleName;

	@Column(name = "LAST_NAME", length = 200)
	private String lastName;

	@Column(name = "CUSTOMER_CODE", length = 100)
	private String customerCode;

	@Column(name = "ADDRESS_3", length = 100)
	private String address3;

	@Column(name = "ZONE")
	private Integer zone;

	@Column(name = "TITLE_DESC_LOCAL", length = 50)
	private String titleDescLocal;

	@Column(name = "GENDER_DESC_LOCAL", length = 50)
	private String genderDescLocal;

	@Column(name = "OCCUPATION_DESC_LOCAL", length = 50)
	private String occupationDescLocal;

	@Column(name = "BUSINESS_TYPE_DESC_LOCAL", length = 50)
	private String businessTypeDescLocal;

	@Column(name = "STATE_NAME_LOCAL", length = 50)
	private String stateNameLocal;

	@Column(name = "CITY_NAME_LOCAL", length = 50)
	private String cityNameLocal;

	@Column(name = "MOBILE_CODE_DESC_1_LOCAL", length = 50)
	private String mobileCodeDesc1Local;

	@Column(name = "MOBILE_CODE_DESC_2_LOCAL", length = 50)
	private String mobileCodeDesc2Local;

	@Column(name = "MOBILE_CODE_DESC_3_LOCAL", length = 50)
	private String mobileCodeDesc3Local;

	@Column(name = "WHATSAPP_CODE_DESC_LOCAL", length = 50)
	private String whatsappCodeDescLocal;

	@Column(name = "LANGUAGE_DESC_LOCAL", length = 50)
	private String languageDescLocal;

	@Column(name = "ID_TYPE_DESC_LOCAL", length = 50)
	private String idTypeDescLocal;

	@Column(name = "POLICY_HOLDER_TYPE_DESC_LOCAL", length = 50)
	private String policyHolderTypeDescLocal;

	@Column(name = "POLICY_HOLDER_TYPE_ID_DESC_LOCAL", length = 50)
	private String policyHolderTypeIdDescLocal;

	@Column(name = "MARITAL_STATUS_DESC_LOCAL", length = 50)
	private String maritalStatusDescLocal;

	@Column(name = "SOCIO_PROFESSIONAL_CATEGORY", length = 100)
	private String socioProfessionalCategory;

	@Column(name = "ACTIVITIES", length = 100)
	private String activities;

	@Column(name = "CUSTOMER_AS_INSURER", length = 100)
	private String customerAsInsurer;

	@Column(name = "COUNTRY", length = 50)
	private String country;

	@Column(name = "COUNTRY_NAME", length = 100)
	private String countryName;

	@Column(name = "NATIONALITY_NAME", length = 100)
	private String nationalityName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EXPIRY_DATE")
	private Date expiryDate;

	@Column(name = "KRA_PIN", length = 100)
	private String kraPin;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "RISK_ASSESSMENT_DATE")
	private Date riskAssessmentDate;

	@Column(name = "VIPFLAG", length = 20)
	private String vipFlag;

	@Column(name = "PHONENO_CODE", length = 20)
	private String phoneNoCode;

	@Column(name = "FATHER_NAME")
	private String father_name;

	@Column(name = "MOTHER_NAME")
	private String mother_name;

	@Column(name = "LEAD_SEQNO")
	private Long leadSeqNo;

	@Column(name = "QUOTE_STATUS", length = 300)
	private String quotestatus;

	@Column(name = "cc_cust_catg_code")
	private String ccCustCatgCode;

	@Column(name = "cc_cust_type")
	private String ccCustType;

}
