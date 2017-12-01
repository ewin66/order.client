package iih.ci.mr.cideathcert.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.cideathcert.d.desc.CideathcertDODesc;
import java.math.BigDecimal;

/**
 * 死亡诊断证明书 DO数据 
 * 
 */
public class CideathcertDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_DEATH_CERT= "Id_death_cert";
	public static final String TITLE= "Title";
	public static final String INHOS_NO= "Inhos_no";
	public static final String ID_PAT= "Id_pat";
	public static final String NAME_PAT= "Name_pat";
	public static final String ID_SEX= "Id_sex";
	public static final String SEX_CODE= "Sex_code";
	public static final String SEX_PAT= "Sex_pat";
	public static final String AGE_PAT= "Age_pat";
	public static final String ID_CARDTYPE= "Id_cardtype";
	public static final String CARD_TYPE_CODE= "Card_type_code";
	public static final String IDCARD_TYPE= "Idcard_type";
	public static final String IDCARD_NO= "Idcard_no";
	public static final String ID_COUNTRY= "Id_country";
	public static final String COUNTRY_PAT= "Country_pat";
	public static final String ID_NATION= "Id_nation";
	public static final String NATION_PAT= "Nation_pat";
	public static final String BIRTH_PAT= "Birth_pat";
	public static final String ID_MARRY= "Id_marry";
	public static final String MARRY_CODE= "Marry_code";
	public static final String MARRY_STATUS= "Marry_status";
	public static final String ID_DEGREE= "Id_degree";
	public static final String DEGREE_CODE= "Degree_code";
	public static final String DEGREE_PAT= "Degree_pat";
	public static final String ID_JOB= "Id_job";
	public static final String PERSONAL_IDENTITY_CODE= "Personal_identity_code";
	public static final String JOB_PAT= "Job_pat";
	public static final String ADDRESS_PROVINCE= "Address_province";
	public static final String ADDRESS_COUNTY= "Address_county";
	public static final String ADDRESS_DETAIL= "Address_detail";
	public static final String ADDRESS_PAT= "Address_pat";
	public static final String ADDRESS_PAT_CODE= "Address_pat_code";
	public static final String ADDRESS_PAT_NAME= "Address_pat_name";
	public static final String ADDRESS_PAT_STREET= "Address_pat_street";
	public static final String ADDRESS_CODE= "Address_code";
	public static final String ADDRESS_NO= "Address_no";
	public static final String UNKNOWN_DATE= "Unknown_date";
	public static final String DEATH_TIME= "Death_time";
	public static final String DEATH_SITE= "Death_site";
	public static final String DEATH_SITE_CODE= "Death_site_code";
	public static final String DEATH_SITE_NAME= "Death_site_name";
	public static final String IS_PREGNANT= "Is_pregnant";
	public static final String WORK_COMPANY= "Work_company";
	public static final String BIRTH_PLACE= "Birth_place";
	public static final String ADDRESS_USUAL= "Address_usual";
	public static final String RELATION_NAME= "Relation_name";
	public static final String RELATION_PHONE= "Relation_phone";
	public static final String RELATION_ADDRESS= "Relation_address";
	public static final String DEATH_A_DIAG= "Death_a_diag";
	public static final String DEATH_A_TIMESPAN= "Death_a_timespan";
	public static final String DEATH_B_DIAG= "Death_b_diag";
	public static final String DEATH_B_TIMESPAN= "Death_b_timespan";
	public static final String DEATH_C_DIAG= "Death_c_diag";
	public static final String DEATH_C_TIMESPAN= "Death_c_timespan";
	public static final String DEATH_D_DIAG= "Death_d_diag";
	public static final String DEATH_D_TIMESPAN= "Death_d_timespan";
	public static final String DEATH_OTHER_DIAG= "Death_other_diag";
	public static final String DEATH_OTHER_TIMESPAN= "Death_other_timespan";
	public static final String DIAG_BASIS= "Diag_basis";
	public static final String DIAG_BASIS_CODE= "Diag_basis_code";
	public static final String DIAG_BASIS_NAME= "Diag_basis_name";
	public static final String DIAG_HOSPITAL= "Diag_hospital";
	public static final String DIAG_HOSPITAL_CODE= "Diag_hospital_code";
	public static final String DIAG_HOSPITAL_NAME= "Diag_hospital_name";
	public static final String SIGN_DOCTOR= "Sign_doctor";
	public static final String DEATH_REASON= "Death_reason";
	public static final String DIAG_ICDCODE= "Diag_icdcode";
	public static final String DIAG_ICDNAME= "Diag_icdname";
	public static final String SYMPTOM_SIGN= "Symptom_sign";
	public static final String INVESTIGATE_NAME= "Investigate_name";
	public static final String INVESTIGATE_RELATION= "Investigate_relation";
	public static final String INVESTIGATE_PHONE= "Investigate_phone";
	public static final String INVESTIGATE_ADDRESS= "Investigate_address";
	public static final String DEATH_INFER= "Death_infer";
	public static final String INVESTIGATE_DATE= "Investigate_date";
	public static final String INVESTIGATER= "Investigater";
	public static final String CERT_STATUS= "Cert_status";
	public static final String VERIFIEDBY= "Verifiedby";
	public static final String VERIFIEDTIME= "Verifiedtime";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String CODE_SEX= "Code_sex";
	public static final String NAME_SEX= "Name_sex";
	public static final String CODE_CARDTYPE= "Code_cardtype";
	public static final String NAME_CARDTYPE= "Name_cardtype";
	public static final String CODE_COUNTRY= "Code_country";
	public static final String NAME_COUNTRY= "Name_country";
	public static final String CODETH_COUNTRY= "Codeth_country";
	public static final String FULLNAME_COUNTRY= "Fullname_country";
	public static final String CODE_NATION= "Code_nation";
	public static final String NAME_NATION= "Name_nation";
	public static final String CODE_MARRY= "Code_marry";
	public static final String NAME_MARRY= "Name_marry";
	public static final String CODE_DEGREE= "Code_degree";
	public static final String NAME_DEGREE= "Name_degree";
	public static final String CODE_JOB= "Code_job";
	public static final String NAME_JOB= "Name_job";
	public static final String CODE_ADDRESS= "Code_address";
	public static final String NAME_ADDRESS= "Name_address";
	public static final String CODE_DEATHSITE= "Code_deathsite";
	public static final String NAME_DEATHSITE= "Name_deathsite";
	public static final String CODE_DIAGBASIS= "Code_diagbasis";
	public static final String NAME_DIAGBASIS= "Name_diagbasis";
	public static final String CODE123= "Code123";
	public static final String NAME123= "Name123";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_death_cert() {
		return ((String) getAttrVal("Id_death_cert"));
	}	
	public void setId_death_cert(String Id_death_cert) {
		setAttrVal("Id_death_cert", Id_death_cert);
	}
	public String getTitle() {
		return ((String) getAttrVal("Title"));
	}	
	public void setTitle(String Title) {
		setAttrVal("Title", Title);
	}
	public String getInhos_no() {
		return ((String) getAttrVal("Inhos_no"));
	}	
	public void setInhos_no(String Inhos_no) {
		setAttrVal("Inhos_no", Inhos_no);
	}
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	public String getId_sex() {
		return ((String) getAttrVal("Id_sex"));
	}	
	public void setId_sex(String Id_sex) {
		setAttrVal("Id_sex", Id_sex);
	}
	public String getSex_code() {
		return ((String) getAttrVal("Sex_code"));
	}	
	public void setSex_code(String Sex_code) {
		setAttrVal("Sex_code", Sex_code);
	}
	public String getSex_pat() {
		return ((String) getAttrVal("Sex_pat"));
	}	
	public void setSex_pat(String Sex_pat) {
		setAttrVal("Sex_pat", Sex_pat);
	}
	public String getAge_pat() {
		return ((String) getAttrVal("Age_pat"));
	}	
	public void setAge_pat(String Age_pat) {
		setAttrVal("Age_pat", Age_pat);
	}
	public String getId_cardtype() {
		return ((String) getAttrVal("Id_cardtype"));
	}	
	public void setId_cardtype(String Id_cardtype) {
		setAttrVal("Id_cardtype", Id_cardtype);
	}
	public String getCard_type_code() {
		return ((String) getAttrVal("Card_type_code"));
	}	
	public void setCard_type_code(String Card_type_code) {
		setAttrVal("Card_type_code", Card_type_code);
	}
	public String getIdcard_type() {
		return ((String) getAttrVal("Idcard_type"));
	}	
	public void setIdcard_type(String Idcard_type) {
		setAttrVal("Idcard_type", Idcard_type);
	}
	public String getIdcard_no() {
		return ((String) getAttrVal("Idcard_no"));
	}	
	public void setIdcard_no(String Idcard_no) {
		setAttrVal("Idcard_no", Idcard_no);
	}
	public String getId_country() {
		return ((String) getAttrVal("Id_country"));
	}	
	public void setId_country(String Id_country) {
		setAttrVal("Id_country", Id_country);
	}
	public String getCountry_pat() {
		return ((String) getAttrVal("Country_pat"));
	}	
	public void setCountry_pat(String Country_pat) {
		setAttrVal("Country_pat", Country_pat);
	}
	public String getId_nation() {
		return ((String) getAttrVal("Id_nation"));
	}	
	public void setId_nation(String Id_nation) {
		setAttrVal("Id_nation", Id_nation);
	}
	public String getNation_pat() {
		return ((String) getAttrVal("Nation_pat"));
	}	
	public void setNation_pat(String Nation_pat) {
		setAttrVal("Nation_pat", Nation_pat);
	}
	public FDate getBirth_pat() {
		return ((FDate) getAttrVal("Birth_pat"));
	}	
	public void setBirth_pat(FDate Birth_pat) {
		setAttrVal("Birth_pat", Birth_pat);
	}
	public String getId_marry() {
		return ((String) getAttrVal("Id_marry"));
	}	
	public void setId_marry(String Id_marry) {
		setAttrVal("Id_marry", Id_marry);
	}
	public String getMarry_code() {
		return ((String) getAttrVal("Marry_code"));
	}	
	public void setMarry_code(String Marry_code) {
		setAttrVal("Marry_code", Marry_code);
	}
	public String getMarry_status() {
		return ((String) getAttrVal("Marry_status"));
	}	
	public void setMarry_status(String Marry_status) {
		setAttrVal("Marry_status", Marry_status);
	}
	public String getId_degree() {
		return ((String) getAttrVal("Id_degree"));
	}	
	public void setId_degree(String Id_degree) {
		setAttrVal("Id_degree", Id_degree);
	}
	public String getDegree_code() {
		return ((String) getAttrVal("Degree_code"));
	}	
	public void setDegree_code(String Degree_code) {
		setAttrVal("Degree_code", Degree_code);
	}
	public String getDegree_pat() {
		return ((String) getAttrVal("Degree_pat"));
	}	
	public void setDegree_pat(String Degree_pat) {
		setAttrVal("Degree_pat", Degree_pat);
	}
	public String getId_job() {
		return ((String) getAttrVal("Id_job"));
	}	
	public void setId_job(String Id_job) {
		setAttrVal("Id_job", Id_job);
	}
	public String getPersonal_identity_code() {
		return ((String) getAttrVal("Personal_identity_code"));
	}	
	public void setPersonal_identity_code(String Personal_identity_code) {
		setAttrVal("Personal_identity_code", Personal_identity_code);
	}
	public String getJob_pat() {
		return ((String) getAttrVal("Job_pat"));
	}	
	public void setJob_pat(String Job_pat) {
		setAttrVal("Job_pat", Job_pat);
	}
	public String getAddress_province() {
		return ((String) getAttrVal("Address_province"));
	}	
	public void setAddress_province(String Address_province) {
		setAttrVal("Address_province", Address_province);
	}
	public String getAddress_county() {
		return ((String) getAttrVal("Address_county"));
	}	
	public void setAddress_county(String Address_county) {
		setAttrVal("Address_county", Address_county);
	}
	public String getAddress_detail() {
		return ((String) getAttrVal("Address_detail"));
	}	
	public void setAddress_detail(String Address_detail) {
		setAttrVal("Address_detail", Address_detail);
	}
	public String getAddress_pat() {
		return ((String) getAttrVal("Address_pat"));
	}	
	public void setAddress_pat(String Address_pat) {
		setAttrVal("Address_pat", Address_pat);
	}
	public String getAddress_pat_code() {
		return ((String) getAttrVal("Address_pat_code"));
	}	
	public void setAddress_pat_code(String Address_pat_code) {
		setAttrVal("Address_pat_code", Address_pat_code);
	}
	public String getAddress_pat_name() {
		return ((String) getAttrVal("Address_pat_name"));
	}	
	public void setAddress_pat_name(String Address_pat_name) {
		setAttrVal("Address_pat_name", Address_pat_name);
	}
	public String getAddress_pat_street() {
		return ((String) getAttrVal("Address_pat_street"));
	}	
	public void setAddress_pat_street(String Address_pat_street) {
		setAttrVal("Address_pat_street", Address_pat_street);
	}
	public String getAddress_code() {
		return ((String) getAttrVal("Address_code"));
	}	
	public void setAddress_code(String Address_code) {
		setAttrVal("Address_code", Address_code);
	}
	public String getAddress_no() {
		return ((String) getAttrVal("Address_no"));
	}	
	public void setAddress_no(String Address_no) {
		setAttrVal("Address_no", Address_no);
	}
	public FDateTime getUnknown_date() {
		return ((FDateTime) getAttrVal("Unknown_date"));
	}	
	public void setUnknown_date(FDateTime Unknown_date) {
		setAttrVal("Unknown_date", Unknown_date);
	}
	public FDateTime getDeath_time() {
		return ((FDateTime) getAttrVal("Death_time"));
	}	
	public void setDeath_time(FDateTime Death_time) {
		setAttrVal("Death_time", Death_time);
	}
	public String getDeath_site() {
		return ((String) getAttrVal("Death_site"));
	}	
	public void setDeath_site(String Death_site) {
		setAttrVal("Death_site", Death_site);
	}
	public String getDeath_site_code() {
		return ((String) getAttrVal("Death_site_code"));
	}	
	public void setDeath_site_code(String Death_site_code) {
		setAttrVal("Death_site_code", Death_site_code);
	}
	public String getDeath_site_name() {
		return ((String) getAttrVal("Death_site_name"));
	}	
	public void setDeath_site_name(String Death_site_name) {
		setAttrVal("Death_site_name", Death_site_name);
	}
	public FBoolean getIs_pregnant() {
		return ((FBoolean) getAttrVal("Is_pregnant"));
	}	
	public void setIs_pregnant(FBoolean Is_pregnant) {
		setAttrVal("Is_pregnant", Is_pregnant);
	}
	public String getWork_company() {
		return ((String) getAttrVal("Work_company"));
	}	
	public void setWork_company(String Work_company) {
		setAttrVal("Work_company", Work_company);
	}
	public String getBirth_place() {
		return ((String) getAttrVal("Birth_place"));
	}	
	public void setBirth_place(String Birth_place) {
		setAttrVal("Birth_place", Birth_place);
	}
	public String getAddress_usual() {
		return ((String) getAttrVal("Address_usual"));
	}	
	public void setAddress_usual(String Address_usual) {
		setAttrVal("Address_usual", Address_usual);
	}
	public String getRelation_name() {
		return ((String) getAttrVal("Relation_name"));
	}	
	public void setRelation_name(String Relation_name) {
		setAttrVal("Relation_name", Relation_name);
	}
	public String getRelation_phone() {
		return ((String) getAttrVal("Relation_phone"));
	}	
	public void setRelation_phone(String Relation_phone) {
		setAttrVal("Relation_phone", Relation_phone);
	}
	public String getRelation_address() {
		return ((String) getAttrVal("Relation_address"));
	}	
	public void setRelation_address(String Relation_address) {
		setAttrVal("Relation_address", Relation_address);
	}
	public String getDeath_a_diag() {
		return ((String) getAttrVal("Death_a_diag"));
	}	
	public void setDeath_a_diag(String Death_a_diag) {
		setAttrVal("Death_a_diag", Death_a_diag);
	}
	public String getDeath_a_timespan() {
		return ((String) getAttrVal("Death_a_timespan"));
	}	
	public void setDeath_a_timespan(String Death_a_timespan) {
		setAttrVal("Death_a_timespan", Death_a_timespan);
	}
	public String getDeath_b_diag() {
		return ((String) getAttrVal("Death_b_diag"));
	}	
	public void setDeath_b_diag(String Death_b_diag) {
		setAttrVal("Death_b_diag", Death_b_diag);
	}
	public String getDeath_b_timespan() {
		return ((String) getAttrVal("Death_b_timespan"));
	}	
	public void setDeath_b_timespan(String Death_b_timespan) {
		setAttrVal("Death_b_timespan", Death_b_timespan);
	}
	public String getDeath_c_diag() {
		return ((String) getAttrVal("Death_c_diag"));
	}	
	public void setDeath_c_diag(String Death_c_diag) {
		setAttrVal("Death_c_diag", Death_c_diag);
	}
	public String getDeath_c_timespan() {
		return ((String) getAttrVal("Death_c_timespan"));
	}	
	public void setDeath_c_timespan(String Death_c_timespan) {
		setAttrVal("Death_c_timespan", Death_c_timespan);
	}
	public String getDeath_d_diag() {
		return ((String) getAttrVal("Death_d_diag"));
	}	
	public void setDeath_d_diag(String Death_d_diag) {
		setAttrVal("Death_d_diag", Death_d_diag);
	}
	public String getDeath_d_timespan() {
		return ((String) getAttrVal("Death_d_timespan"));
	}	
	public void setDeath_d_timespan(String Death_d_timespan) {
		setAttrVal("Death_d_timespan", Death_d_timespan);
	}
	public String getDeath_other_diag() {
		return ((String) getAttrVal("Death_other_diag"));
	}	
	public void setDeath_other_diag(String Death_other_diag) {
		setAttrVal("Death_other_diag", Death_other_diag);
	}
	public String getDeath_other_timespan() {
		return ((String) getAttrVal("Death_other_timespan"));
	}	
	public void setDeath_other_timespan(String Death_other_timespan) {
		setAttrVal("Death_other_timespan", Death_other_timespan);
	}
	public String getDiag_basis() {
		return ((String) getAttrVal("Diag_basis"));
	}	
	public void setDiag_basis(String Diag_basis) {
		setAttrVal("Diag_basis", Diag_basis);
	}
	public String getDiag_basis_code() {
		return ((String) getAttrVal("Diag_basis_code"));
	}	
	public void setDiag_basis_code(String Diag_basis_code) {
		setAttrVal("Diag_basis_code", Diag_basis_code);
	}
	public String getDiag_basis_name() {
		return ((String) getAttrVal("Diag_basis_name"));
	}	
	public void setDiag_basis_name(String Diag_basis_name) {
		setAttrVal("Diag_basis_name", Diag_basis_name);
	}
	public String getDiag_hospital() {
		return ((String) getAttrVal("Diag_hospital"));
	}	
	public void setDiag_hospital(String Diag_hospital) {
		setAttrVal("Diag_hospital", Diag_hospital);
	}
	public String getDiag_hospital_code() {
		return ((String) getAttrVal("Diag_hospital_code"));
	}	
	public void setDiag_hospital_code(String Diag_hospital_code) {
		setAttrVal("Diag_hospital_code", Diag_hospital_code);
	}
	public String getDiag_hospital_name() {
		return ((String) getAttrVal("Diag_hospital_name"));
	}	
	public void setDiag_hospital_name(String Diag_hospital_name) {
		setAttrVal("Diag_hospital_name", Diag_hospital_name);
	}
	public String getSign_doctor() {
		return ((String) getAttrVal("Sign_doctor"));
	}	
	public void setSign_doctor(String Sign_doctor) {
		setAttrVal("Sign_doctor", Sign_doctor);
	}
	public String getDeath_reason() {
		return ((String) getAttrVal("Death_reason"));
	}	
	public void setDeath_reason(String Death_reason) {
		setAttrVal("Death_reason", Death_reason);
	}
	public String getDiag_icdcode() {
		return ((String) getAttrVal("Diag_icdcode"));
	}	
	public void setDiag_icdcode(String Diag_icdcode) {
		setAttrVal("Diag_icdcode", Diag_icdcode);
	}
	public String getDiag_icdname() {
		return ((String) getAttrVal("Diag_icdname"));
	}	
	public void setDiag_icdname(String Diag_icdname) {
		setAttrVal("Diag_icdname", Diag_icdname);
	}
	public String getSymptom_sign() {
		return ((String) getAttrVal("Symptom_sign"));
	}	
	public void setSymptom_sign(String Symptom_sign) {
		setAttrVal("Symptom_sign", Symptom_sign);
	}
	public String getInvestigate_name() {
		return ((String) getAttrVal("Investigate_name"));
	}	
	public void setInvestigate_name(String Investigate_name) {
		setAttrVal("Investigate_name", Investigate_name);
	}
	public String getInvestigate_relation() {
		return ((String) getAttrVal("Investigate_relation"));
	}	
	public void setInvestigate_relation(String Investigate_relation) {
		setAttrVal("Investigate_relation", Investigate_relation);
	}
	public String getInvestigate_phone() {
		return ((String) getAttrVal("Investigate_phone"));
	}	
	public void setInvestigate_phone(String Investigate_phone) {
		setAttrVal("Investigate_phone", Investigate_phone);
	}
	public String getInvestigate_address() {
		return ((String) getAttrVal("Investigate_address"));
	}	
	public void setInvestigate_address(String Investigate_address) {
		setAttrVal("Investigate_address", Investigate_address);
	}
	public String getDeath_infer() {
		return ((String) getAttrVal("Death_infer"));
	}	
	public void setDeath_infer(String Death_infer) {
		setAttrVal("Death_infer", Death_infer);
	}
	public FDateTime getInvestigate_date() {
		return ((FDateTime) getAttrVal("Investigate_date"));
	}	
	public void setInvestigate_date(FDateTime Investigate_date) {
		setAttrVal("Investigate_date", Investigate_date);
	}
	public String getInvestigater() {
		return ((String) getAttrVal("Investigater"));
	}	
	public void setInvestigater(String Investigater) {
		setAttrVal("Investigater", Investigater);
	}
	public String getCert_status() {
		return ((String) getAttrVal("Cert_status"));
	}	
	public void setCert_status(String Cert_status) {
		setAttrVal("Cert_status", Cert_status);
	}
	public String getVerifiedby() {
		return ((String) getAttrVal("Verifiedby"));
	}	
	public void setVerifiedby(String Verifiedby) {
		setAttrVal("Verifiedby", Verifiedby);
	}
	public FDateTime getVerifiedtime() {
		return ((FDateTime) getAttrVal("Verifiedtime"));
	}	
	public void setVerifiedtime(FDateTime Verifiedtime) {
		setAttrVal("Verifiedtime", Verifiedtime);
	}
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}	
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}	
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}	
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}	
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
	}
	public String getCode_sex() {
		return ((String) getAttrVal("Code_sex"));
	}	
	public void setCode_sex(String Code_sex) {
		setAttrVal("Code_sex", Code_sex);
	}
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}	
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
	}
	public String getCode_cardtype() {
		return ((String) getAttrVal("Code_cardtype"));
	}	
	public void setCode_cardtype(String Code_cardtype) {
		setAttrVal("Code_cardtype", Code_cardtype);
	}
	public String getName_cardtype() {
		return ((String) getAttrVal("Name_cardtype"));
	}	
	public void setName_cardtype(String Name_cardtype) {
		setAttrVal("Name_cardtype", Name_cardtype);
	}
	public String getCode_country() {
		return ((String) getAttrVal("Code_country"));
	}	
	public void setCode_country(String Code_country) {
		setAttrVal("Code_country", Code_country);
	}
	public String getName_country() {
		return ((String) getAttrVal("Name_country"));
	}	
	public void setName_country(String Name_country) {
		setAttrVal("Name_country", Name_country);
	}
	public String getCodeth_country() {
		return ((String) getAttrVal("Codeth_country"));
	}	
	public void setCodeth_country(String Codeth_country) {
		setAttrVal("Codeth_country", Codeth_country);
	}
	public String getFullname_country() {
		return ((String) getAttrVal("Fullname_country"));
	}	
	public void setFullname_country(String Fullname_country) {
		setAttrVal("Fullname_country", Fullname_country);
	}
	public String getCode_nation() {
		return ((String) getAttrVal("Code_nation"));
	}	
	public void setCode_nation(String Code_nation) {
		setAttrVal("Code_nation", Code_nation);
	}
	public String getName_nation() {
		return ((String) getAttrVal("Name_nation"));
	}	
	public void setName_nation(String Name_nation) {
		setAttrVal("Name_nation", Name_nation);
	}
	public String getCode_marry() {
		return ((String) getAttrVal("Code_marry"));
	}	
	public void setCode_marry(String Code_marry) {
		setAttrVal("Code_marry", Code_marry);
	}
	public String getName_marry() {
		return ((String) getAttrVal("Name_marry"));
	}	
	public void setName_marry(String Name_marry) {
		setAttrVal("Name_marry", Name_marry);
	}
	public String getCode_degree() {
		return ((String) getAttrVal("Code_degree"));
	}	
	public void setCode_degree(String Code_degree) {
		setAttrVal("Code_degree", Code_degree);
	}
	public String getName_degree() {
		return ((String) getAttrVal("Name_degree"));
	}	
	public void setName_degree(String Name_degree) {
		setAttrVal("Name_degree", Name_degree);
	}
	public String getCode_job() {
		return ((String) getAttrVal("Code_job"));
	}	
	public void setCode_job(String Code_job) {
		setAttrVal("Code_job", Code_job);
	}
	public String getName_job() {
		return ((String) getAttrVal("Name_job"));
	}	
	public void setName_job(String Name_job) {
		setAttrVal("Name_job", Name_job);
	}
	public String getCode_address() {
		return ((String) getAttrVal("Code_address"));
	}	
	public void setCode_address(String Code_address) {
		setAttrVal("Code_address", Code_address);
	}
	public String getName_address() {
		return ((String) getAttrVal("Name_address"));
	}	
	public void setName_address(String Name_address) {
		setAttrVal("Name_address", Name_address);
	}
	public String getCode_deathsite() {
		return ((String) getAttrVal("Code_deathsite"));
	}	
	public void setCode_deathsite(String Code_deathsite) {
		setAttrVal("Code_deathsite", Code_deathsite);
	}
	public String getName_deathsite() {
		return ((String) getAttrVal("Name_deathsite"));
	}	
	public void setName_deathsite(String Name_deathsite) {
		setAttrVal("Name_deathsite", Name_deathsite);
	}
	public String getCode_diagbasis() {
		return ((String) getAttrVal("Code_diagbasis"));
	}	
	public void setCode_diagbasis(String Code_diagbasis) {
		setAttrVal("Code_diagbasis", Code_diagbasis);
	}
	public String getName_diagbasis() {
		return ((String) getAttrVal("Name_diagbasis"));
	}	
	public void setName_diagbasis(String Name_diagbasis) {
		setAttrVal("Name_diagbasis", Name_diagbasis);
	}
	public String getCode123() {
		return ((String) getAttrVal("Code123"));
	}	
	public void setCode123(String Code123) {
		setAttrVal("Code123", Code123);
	}
	public String getName123() {
		return ((String) getAttrVal("Name123"));
	}	
	public void setName123(String Name123) {
		setAttrVal("Name123", Name123);
	}

	public Integer getDs() {
		return ((Integer) getAttrVal(GlobalConst.DELETE_SIGN));
	}
	
	public void setDs(Integer ds) {
		setAttrVal(GlobalConst.DELETE_SIGN, ds);
	}
	
	public FDateTime getSv() {
		return ((FDateTime) getAttrVal(GlobalConst.SYSTEM_VERSION));
	}
	
	public void setSv(FDateTime sv) {
		setAttrVal(GlobalConst.SYSTEM_VERSION, sv);
	}

//	@Override
//	public java.lang.String getParentPKFieldName() {
//		return null;
//	}
  
	@Override
	public String getPKFieldName() {
		return "Id_death_cert";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_mr_death_cert";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CideathcertDODesc.class);
	}
	
}