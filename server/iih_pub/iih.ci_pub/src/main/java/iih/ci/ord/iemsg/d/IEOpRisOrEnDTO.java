package iih.ci.ord.iemsg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * IE门诊检查申请就诊信息DTO DTO数据 
 * 
 */
public class IEOpRisOrEnDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * IE检查申请就诊主键标识
	 * @return String
	 */
	public String getId_ierisoren() {
		return ((String) getAttrVal("Id_ierisoren"));
	}	
	/**
	 * IE检查申请就诊主键标识
	 * @param Id_ierisoren
	 */
	public void setId_ierisoren(String Id_ierisoren) {
		setAttrVal("Id_ierisoren", Id_ierisoren);
	}
	/**
	 * IE检查申请集合
	 * @return FArrayList2
	 */
	public FArrayList2 getIerisors() {
		return ((FArrayList2) getAttrVal("Ierisors"));
	}	
	/**
	 * IE检查申请集合
	 * @param Ierisors
	 */
	public void setIerisors(FArrayList2 Ierisors) {
		setAttrVal("Ierisors", Ierisors);
	}
	/**
	 * IE检查病史集合
	 * @return FArrayList2
	 */
	public FArrayList2 getIerishises() {
		return ((FArrayList2) getAttrVal("Ierishises"));
	}	
	/**
	 * IE检查病史集合
	 * @param Ierishises
	 */
	public void setIerishises(FArrayList2 Ierishises) {
		setAttrVal("Ierishises", Ierishises);
	}
	/**
	 * 域id
	 * @return String
	 */
	public String getDomain_id() {
		return ((String) getAttrVal("Domain_id"));
	}	
	/**
	 * 域id
	 * @param Domain_id
	 */
	public void setDomain_id(String Domain_id) {
		setAttrVal("Domain_id", Domain_id);
	}
	/**
	 * 患者ID
	 * @return String
	 */
	public String getPatient_id() {
		return ((String) getAttrVal("Patient_id"));
	}	
	/**
	 * 患者ID
	 * @param Patient_id
	 */
	public void setPatient_id(String Patient_id) {
		setAttrVal("Patient_id", Patient_id);
	}
	/**
	 * 就诊号
	 * @return String
	 */
	public String getP_bar_code() {
		return ((String) getAttrVal("P_bar_code"));
	}	
	/**
	 * 就诊号
	 * @param P_bar_code
	 */
	public void setP_bar_code(String P_bar_code) {
		setAttrVal("P_bar_code", P_bar_code);
	}
	/**
	 * 病区编码
	 * @return String
	 */
	public String getWard_code() {
		return ((String) getAttrVal("Ward_code"));
	}	
	/**
	 * 病区编码
	 * @param Ward_code
	 */
	public void setWard_code(String Ward_code) {
		setAttrVal("Ward_code", Ward_code);
	}
	/**
	 * 病区名
	 * @return String
	 */
	public String getWard_code_name() {
		return ((String) getAttrVal("Ward_code_name"));
	}	
	/**
	 * 病区名
	 * @param Ward_code_name
	 */
	public void setWard_code_name(String Ward_code_name) {
		setAttrVal("Ward_code_name", Ward_code_name);
	}
	/**
	 * 床号
	 * @return String
	 */
	public String getBed_no() {
		return ((String) getAttrVal("Bed_no"));
	}	
	/**
	 * 床号
	 * @param Bed_no
	 */
	public void setBed_no(String Bed_no) {
		setAttrVal("Bed_no", Bed_no);
	}
	/**
	 * 身份证号
	 * @return String
	 */
	public String getSocial_no() {
		return ((String) getAttrVal("Social_no"));
	}	
	/**
	 * 身份证号
	 * @param Social_no
	 */
	public void setSocial_no(String Social_no) {
		setAttrVal("Social_no", Social_no);
	}
	/**
	 * 医保卡号
	 * @return String
	 */
	public String getAddition_no() {
		return ((String) getAttrVal("Addition_no"));
	}	
	/**
	 * 医保卡号
	 * @param Addition_no
	 */
	public void setAddition_no(String Addition_no) {
		setAttrVal("Addition_no", Addition_no);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 姓名
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 联系电话
	 * @return String
	 */
	public String getHome_tel() {
		return ((String) getAttrVal("Home_tel"));
	}	
	/**
	 * 联系电话
	 * @param Home_tel
	 */
	public void setHome_tel(String Home_tel) {
		setAttrVal("Home_tel", Home_tel);
	}
	/**
	 * 性别编码
	 * @return String
	 */
	public String getSexid() {
		return ((String) getAttrVal("Sexid"));
	}	
	/**
	 * 性别编码
	 * @param Sexid
	 */
	public void setSexid(String Sexid) {
		setAttrVal("Sexid", Sexid);
	}
	/**
	 * 出生日期
	 * @return FDate
	 */
	public FDate getBirthday() {
		return ((FDate) getAttrVal("Birthday"));
	}	
	/**
	 * 出生日期
	 * @param Birthday
	 */
	public void setBirthday(FDate Birthday) {
		setAttrVal("Birthday", Birthday);
	}
	/**
	 * 年龄
	 * @return String
	 */
	public String getAge() {
		return ((String) getAttrVal("Age"));
	}	
	/**
	 * 年龄
	 * @param Age
	 */
	public void setAge(String Age) {
		setAttrVal("Age", Age);
	}
	/**
	 * 住址
	 * @return String
	 */
	public String getHome_street() {
		return ((String) getAttrVal("Home_street"));
	}	
	/**
	 * 住址
	 * @param Home_street
	 */
	public void setHome_street(String Home_street) {
		setAttrVal("Home_street", Home_street);
	}
	/**
	 * 婚姻状况类别编码
	 * @return String
	 */
	public String getMarry_code() {
		return ((String) getAttrVal("Marry_code"));
	}	
	/**
	 * 婚姻状况类别编码
	 * @param Marry_code
	 */
	public void setMarry_code(String Marry_code) {
		setAttrVal("Marry_code", Marry_code);
	}
	/**
	 * 民族编码
	 * @return String
	 */
	public String getNation_code() {
		return ((String) getAttrVal("Nation_code"));
	}	
	/**
	 * 民族编码
	 * @param Nation_code
	 */
	public void setNation_code(String Nation_code) {
		setAttrVal("Nation_code", Nation_code);
	}
	/**
	 * 职业编码
	 * @return String
	 */
	public String getOccupation_type() {
		return ((String) getAttrVal("Occupation_type"));
	}	
	/**
	 * 职业编码
	 * @param Occupation_type
	 */
	public void setOccupation_type(String Occupation_type) {
		setAttrVal("Occupation_type", Occupation_type);
	}
	/**
	 * 职业
	 * @return String
	 */
	public String getOccupation_type_name() {
		return ((String) getAttrVal("Occupation_type_name"));
	}	
	/**
	 * 职业
	 * @param Occupation_type_name
	 */
	public void setOccupation_type_name(String Occupation_type_name) {
		setAttrVal("Occupation_type_name", Occupation_type_name);
	}
	/**
	 * 工作单位名称 
	 * @return String
	 */
	public String getWork_unit() {
		return ((String) getAttrVal("Work_unit"));
	}	
	/**
	 * 工作单位名称 
	 * @param Work_unit
	 */
	public void setWork_unit(String Work_unit) {
		setAttrVal("Work_unit", Work_unit);
	}
	/**
	 * 国籍编码
	 * @return String
	 */
	public String getCountry_code() {
		return ((String) getAttrVal("Country_code"));
	}	
	/**
	 * 国籍编码
	 * @param Country_code
	 */
	public void setCountry_code(String Country_code) {
		setAttrVal("Country_code", Country_code);
	}
	/**
	 * 国家 
	 * @return String
	 */
	public String getCountry_code_name() {
		return ((String) getAttrVal("Country_code_name"));
	}	
	/**
	 * 国家 
	 * @param Country_code_name
	 */
	public void setCountry_code_name(String Country_code_name) {
		setAttrVal("Country_code_name", Country_code_name);
	}
	/**
	 * 联系人电话
	 * @return String
	 */
	public String getRelation_tel() {
		return ((String) getAttrVal("Relation_tel"));
	}	
	/**
	 * 联系人电话
	 * @param Relation_tel
	 */
	public void setRelation_tel(String Relation_tel) {
		setAttrVal("Relation_tel", Relation_tel);
	}
	/**
	 * 联系人姓名
	 * @return String
	 */
	public String getRelation_tel_name() {
		return ((String) getAttrVal("Relation_tel_name"));
	}	
	/**
	 * 联系人姓名
	 * @param Relation_tel_name
	 */
	public void setRelation_tel_name(String Relation_tel_name) {
		setAttrVal("Relation_tel_name", Relation_tel_name);
	}
	/**
	 * 病人科室编码
	 * @return String
	 */
	public String getCode_dep_ns() {
		return ((String) getAttrVal("Code_dep_ns"));
	}	
	/**
	 * 病人科室编码
	 * @param Code_dep_ns
	 */
	public void setCode_dep_ns(String Code_dep_ns) {
		setAttrVal("Code_dep_ns", Code_dep_ns);
	}
	/**
	 * 病人科室名称
	 * @return String
	 */
	public String getName_dep_ns() {
		return ((String) getAttrVal("Name_dep_ns"));
	}	
	/**
	 * 病人科室名称
	 * @param Name_dep_ns
	 */
	public void setName_dep_ns(String Name_dep_ns) {
		setAttrVal("Name_dep_ns", Name_dep_ns);
	}
	/**
	 * 医疗机构代码
	 * @return String
	 */
	public String getOrg_code() {
		return ((String) getAttrVal("Org_code"));
	}	
	/**
	 * 医疗机构代码
	 * @param Org_code
	 */
	public void setOrg_code(String Org_code) {
		setAttrVal("Org_code", Org_code);
	}
	/**
	 * 医疗机构名称
	 * @return String
	 */
	public String getOrg_name() {
		return ((String) getAttrVal("Org_name"));
	}	
	/**
	 * 医疗机构名称
	 * @param Org_name
	 */
	public void setOrg_name(String Org_name) {
		setAttrVal("Org_name", Org_name);
	}
	/**
	 * 申请医院
	 * @return String
	 */
	public String getApply_hospital() {
		return ((String) getAttrVal("Apply_hospital"));
	}	
	/**
	 * 申请医院
	 * @param Apply_hospital
	 */
	public void setApply_hospital(String Apply_hospital) {
		setAttrVal("Apply_hospital", Apply_hospital);
	}
	/**
	 * 开单时间
	 * @return FDateTime
	 */
	public FDateTime getEnter_date() {
		return ((FDateTime) getAttrVal("Enter_date"));
	}	
	/**
	 * 开单时间
	 * @param Enter_date
	 */
	public void setEnter_date(FDateTime Enter_date) {
		setAttrVal("Enter_date", Enter_date);
	}
	/**
	 * 开单医生编码
	 * @return String
	 */
	public String getApply_doctor() {
		return ((String) getAttrVal("Apply_doctor"));
	}	
	/**
	 * 开单医生编码
	 * @param Apply_doctor
	 */
	public void setApply_doctor(String Apply_doctor) {
		setAttrVal("Apply_doctor", Apply_doctor);
	}
	/**
	 * 开单医生姓名
	 * @return String
	 */
	public String getApply_doctor_name() {
		return ((String) getAttrVal("Apply_doctor_name"));
	}	
	/**
	 * 开单医生姓名
	 * @param Apply_doctor_name
	 */
	public void setApply_doctor_name(String Apply_doctor_name) {
		setAttrVal("Apply_doctor_name", Apply_doctor_name);
	}
	/**
	 * 申请科室编码
	 * @return String
	 */
	public String getApply_unit() {
		return ((String) getAttrVal("Apply_unit"));
	}	
	/**
	 * 申请科室编码
	 * @param Apply_unit
	 */
	public void setApply_unit(String Apply_unit) {
		setAttrVal("Apply_unit", Apply_unit);
	}
	/**
	 * 申请科室名称
	 * @return String
	 */
	public String getApply_unit_name() {
		return ((String) getAttrVal("Apply_unit_name"));
	}	
	/**
	 * 申请科室名称
	 * @param Apply_unit_name
	 */
	public void setApply_unit_name(String Apply_unit_name) {
		setAttrVal("Apply_unit_name", Apply_unit_name);
	}
	/**
	 * 确认时间
	 * @return FDateTime
	 */
	public FDateTime getConfirm_date() {
		return ((FDateTime) getAttrVal("Confirm_date"));
	}	
	/**
	 * 确认时间
	 * @param Confirm_date
	 */
	public void setConfirm_date(FDateTime Confirm_date) {
		setAttrVal("Confirm_date", Confirm_date);
	}
	/**
	 * 确认人编码
	 * @return String
	 */
	public String getConfirm_opera() {
		return ((String) getAttrVal("Confirm_opera"));
	}	
	/**
	 * 确认人编码
	 * @param Confirm_opera
	 */
	public void setConfirm_opera(String Confirm_opera) {
		setAttrVal("Confirm_opera", Confirm_opera);
	}
	/**
	 * 确认人姓名
	 * @return String
	 */
	public String getConfirm_opera_name() {
		return ((String) getAttrVal("Confirm_opera_name"));
	}	
	/**
	 * 确认人姓名
	 * @param Confirm_opera_name
	 */
	public void setConfirm_opera_name(String Confirm_opera_name) {
		setAttrVal("Confirm_opera_name", Confirm_opera_name);
	}
	/**
	 * 病人类型编码
	 * @return String
	 */
	public String getResponse_type() {
		return ((String) getAttrVal("Response_type"));
	}	
	/**
	 * 病人类型编码
	 * @param Response_type
	 */
	public void setResponse_type(String Response_type) {
		setAttrVal("Response_type", Response_type);
	}
	/**
	 * 就诊次数
	 * @return String
	 */
	public String getTimes() {
		return ((String) getAttrVal("Times"));
	}	
	/**
	 * 就诊次数
	 * @param Times
	 */
	public void setTimes(String Times) {
		setAttrVal("Times", Times);
	}
	/**
	 * 诊断类别编码
	 * @return String
	 */
	public String getDiag_type_code() {
		return ((String) getAttrVal("Diag_type_code"));
	}	
	/**
	 * 诊断类别编码
	 * @param Diag_type_code
	 */
	public void setDiag_type_code(String Diag_type_code) {
		setAttrVal("Diag_type_code", Diag_type_code);
	}
	/**
	 * 诊断类别名称
	 * @return String
	 */
	public String getDiag_type_name() {
		return ((String) getAttrVal("Diag_type_name"));
	}	
	/**
	 * 诊断类别名称
	 * @param Diag_type_name
	 */
	public void setDiag_type_name(String Diag_type_name) {
		setAttrVal("Diag_type_name", Diag_type_name);
	}
	/**
	 * 诊断日期
	 * @return FDateTime
	 */
	public FDateTime getDiag_input_date() {
		return ((FDateTime) getAttrVal("Diag_input_date"));
	}	
	/**
	 * 诊断日期
	 * @param Diag_input_date
	 */
	public void setDiag_input_date(FDateTime Diag_input_date) {
		setAttrVal("Diag_input_date", Diag_input_date);
	}
	/**
	 * 疾病编码
	 * @return String
	 */
	public String getDiag_code() {
		return ((String) getAttrVal("Diag_code"));
	}	
	/**
	 * 疾病编码
	 * @param Diag_code
	 */
	public void setDiag_code(String Diag_code) {
		setAttrVal("Diag_code", Diag_code);
	}
	/**
	 * 疾病名称
	 * @return String
	 */
	public String getDiag_str() {
		return ((String) getAttrVal("Diag_str"));
	}	
	/**
	 * 疾病名称
	 * @param Diag_str
	 */
	public void setDiag_str(String Diag_str) {
		setAttrVal("Diag_str", Diag_str);
	}
}