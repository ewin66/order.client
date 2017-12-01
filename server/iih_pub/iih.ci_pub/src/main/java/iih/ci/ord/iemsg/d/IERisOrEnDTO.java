package iih.ci.ord.iemsg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * IE检查申请就诊信息DTO DTO数据 
 * 
 */
public class IERisOrEnDTO extends BaseDTO {
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
	public FArrayList2 getId_ierisors() {
		return ((FArrayList2) getAttrVal("Id_ierisors"));
	}	
	/**
	 * IE检查申请集合
	 * @param Id_ierisors
	 */
	public void setId_ierisors(FArrayList2 Id_ierisors) {
		setAttrVal("Id_ierisors", Id_ierisors);
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
	public String getPatientid() {
		return ((String) getAttrVal("Patientid"));
	}	
	/**
	 * 患者ID
	 * @param Patientid
	 */
	public void setPatientid(String Patientid) {
		setAttrVal("Patientid", Patientid);
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
	 * 就诊号
	 * @return String
	 */
	public String getPatientseqnum() {
		return ((String) getAttrVal("Patientseqnum"));
	}	
	/**
	 * 就诊号
	 * @param Patientseqnum
	 */
	public void setPatientseqnum(String Patientseqnum) {
		setAttrVal("Patientseqnum", Patientseqnum);
	}
	/**
	 * 病区名
	 * @return String
	 */
	public String getWardname() {
		return ((String) getAttrVal("Wardname"));
	}	
	/**
	 * 病区名
	 * @param Wardname
	 */
	public void setWardname(String Wardname) {
		setAttrVal("Wardname", Wardname);
	}
	/**
	 * 病区编码
	 * @return String
	 */
	public String getWardcode() {
		return ((String) getAttrVal("Wardcode"));
	}	
	/**
	 * 病区编码
	 * @param Wardcode
	 */
	public void setWardcode(String Wardcode) {
		setAttrVal("Wardcode", Wardcode);
	}
	/**
	 * 床号
	 * @return String
	 */
	public String getBedcode() {
		return ((String) getAttrVal("Bedcode"));
	}	
	/**
	 * 床号
	 * @param Bedcode
	 */
	public void setBedcode(String Bedcode) {
		setAttrVal("Bedcode", Bedcode);
	}
	/**
	 * 身份证号
	 * @return String
	 */
	public String getIdcard() {
		return ((String) getAttrVal("Idcard"));
	}	
	/**
	 * 身份证号
	 * @param Idcard
	 */
	public void setIdcard(String Idcard) {
		setAttrVal("Idcard", Idcard);
	}
	/**
	 * 医保卡号
	 * @return String
	 */
	public String getYbcode() {
		return ((String) getAttrVal("Ybcode"));
	}	
	/**
	 * 医保卡号
	 * @param Ybcode
	 */
	public void setYbcode(String Ybcode) {
		setAttrVal("Ybcode", Ybcode);
	}
	/**
	 * 联系电话
	 * @return String
	 */
	public String getTelephone() {
		return ((String) getAttrVal("Telephone"));
	}	
	/**
	 * 联系电话
	 * @param Telephone
	 */
	public void setTelephone(String Telephone) {
		setAttrVal("Telephone", Telephone);
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
	public FDate getBirthdaydate() {
		return ((FDate) getAttrVal("Birthdaydate"));
	}	
	/**
	 * 出生日期
	 * @param Birthdaydate
	 */
	public void setBirthdaydate(FDate Birthdaydate) {
		setAttrVal("Birthdaydate", Birthdaydate);
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
	public String getHomeaddress() {
		return ((String) getAttrVal("Homeaddress"));
	}	
	/**
	 * 住址
	 * @param Homeaddress
	 */
	public void setHomeaddress(String Homeaddress) {
		setAttrVal("Homeaddress", Homeaddress);
	}
	/**
	 * 婚姻状况类别编码
	 * @return String
	 */
	public String getMarrycode() {
		return ((String) getAttrVal("Marrycode"));
	}	
	/**
	 * 婚姻状况类别编码
	 * @param Marrycode
	 */
	public void setMarrycode(String Marrycode) {
		setAttrVal("Marrycode", Marrycode);
	}
	/**
	 * 民族编码
	 * @return String
	 */
	public String getFolkcode() {
		return ((String) getAttrVal("Folkcode"));
	}	
	/**
	 * 民族编码
	 * @param Folkcode
	 */
	public void setFolkcode(String Folkcode) {
		setAttrVal("Folkcode", Folkcode);
	}
	/**
	 * 职业编码
	 * @return String
	 */
	public String getProcode() {
		return ((String) getAttrVal("Procode"));
	}	
	/**
	 * 职业编码
	 * @param Procode
	 */
	public void setProcode(String Procode) {
		setAttrVal("Procode", Procode);
	}
	/**
	 * 职业
	 * @return String
	 */
	public String getProname() {
		return ((String) getAttrVal("Proname"));
	}	
	/**
	 * 职业
	 * @param Proname
	 */
	public void setProname(String Proname) {
		setAttrVal("Proname", Proname);
	}
	/**
	 * 工作单位名称 
	 * @return String
	 */
	public String getWorkunitname() {
		return ((String) getAttrVal("Workunitname"));
	}	
	/**
	 * 工作单位名称 
	 * @param Workunitname
	 */
	public void setWorkunitname(String Workunitname) {
		setAttrVal("Workunitname", Workunitname);
	}
	/**
	 * 国籍编码
	 * @return String
	 */
	public String getCountrycode() {
		return ((String) getAttrVal("Countrycode"));
	}	
	/**
	 * 国籍编码
	 * @param Countrycode
	 */
	public void setCountrycode(String Countrycode) {
		setAttrVal("Countrycode", Countrycode);
	}
	/**
	 * 国家 
	 * @return String
	 */
	public String getCountryname() {
		return ((String) getAttrVal("Countryname"));
	}	
	/**
	 * 国家 
	 * @param Countryname
	 */
	public void setCountryname(String Countryname) {
		setAttrVal("Countryname", Countryname);
	}
	/**
	 * 联系人电话
	 * @return String
	 */
	public String getR_tel() {
		return ((String) getAttrVal("R_tel"));
	}	
	/**
	 * 联系人电话
	 * @param R_tel
	 */
	public void setR_tel(String R_tel) {
		setAttrVal("R_tel", R_tel);
	}
	/**
	 * 联系人姓名
	 * @return String
	 */
	public String getR_name() {
		return ((String) getAttrVal("R_name"));
	}	
	/**
	 * 联系人姓名
	 * @param R_name
	 */
	public void setR_name(String R_name) {
		setAttrVal("R_name", R_name);
	}
	/**
	 * 病人科室编码
	 * @return String
	 */
	public String getDeptcode() {
		return ((String) getAttrVal("Deptcode"));
	}	
	/**
	 * 病人科室编码
	 * @param Deptcode
	 */
	public void setDeptcode(String Deptcode) {
		setAttrVal("Deptcode", Deptcode);
	}
	/**
	 * 病人科室名称
	 * @return String
	 */
	public String getDeptname() {
		return ((String) getAttrVal("Deptname"));
	}	
	/**
	 * 病人科室名称
	 * @param Deptname
	 */
	public void setDeptname(String Deptname) {
		setAttrVal("Deptname", Deptname);
	}
	/**
	 * 医疗机构代码
	 * @return String
	 */
	public String getHos_code() {
		return ((String) getAttrVal("Hos_code"));
	}	
	/**
	 * 医疗机构代码
	 * @param Hos_code
	 */
	public void setHos_code(String Hos_code) {
		setAttrVal("Hos_code", Hos_code);
	}
	/**
	 * 医疗机构名称
	 * @return String
	 */
	public String getHos_name() {
		return ((String) getAttrVal("Hos_name"));
	}	
	/**
	 * 医疗机构名称
	 * @param Hos_name
	 */
	public void setHos_name(String Hos_name) {
		setAttrVal("Hos_name", Hos_name);
	}
	/**
	 * 开单时间
	 * @return String
	 */
	public String getKd_date() {
		return ((String) getAttrVal("Kd_date"));
	}	
	/**
	 * 开单时间
	 * @param Kd_date
	 */
	public void setKd_date(String Kd_date) {
		setAttrVal("Kd_date", Kd_date);
	}
	/**
	 * 开单医生编码
	 * @return String
	 */
	public String getKd_doctorcode() {
		return ((String) getAttrVal("Kd_doctorcode"));
	}	
	/**
	 * 开单医生编码
	 * @param Kd_doctorcode
	 */
	public void setKd_doctorcode(String Kd_doctorcode) {
		setAttrVal("Kd_doctorcode", Kd_doctorcode);
	}
	/**
	 * 开单医生姓名
	 * @return String
	 */
	public String getKd_doctorname() {
		return ((String) getAttrVal("Kd_doctorname"));
	}	
	/**
	 * 开单医生姓名
	 * @param Kd_doctorname
	 */
	public void setKd_doctorname(String Kd_doctorname) {
		setAttrVal("Kd_doctorname", Kd_doctorname);
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
	public String getConfirm_nurse_code() {
		return ((String) getAttrVal("Confirm_nurse_code"));
	}	
	/**
	 * 确认人编码
	 * @param Confirm_nurse_code
	 */
	public void setConfirm_nurse_code(String Confirm_nurse_code) {
		setAttrVal("Confirm_nurse_code", Confirm_nurse_code);
	}
	/**
	 * 确认人姓名
	 * @return String
	 */
	public String getConfirm_nurse_name() {
		return ((String) getAttrVal("Confirm_nurse_name"));
	}	
	/**
	 * 确认人姓名
	 * @param Confirm_nurse_name
	 */
	public void setConfirm_nurse_name(String Confirm_nurse_name) {
		setAttrVal("Confirm_nurse_name", Confirm_nurse_name);
	}
	/**
	 * 就诊次数
	 * @return String
	 */
	public String getAdmiss_times() {
		return ((String) getAttrVal("Admiss_times"));
	}	
	/**
	 * 就诊次数
	 * @param Admiss_times
	 */
	public void setAdmiss_times(String Admiss_times) {
		setAttrVal("Admiss_times", Admiss_times);
	}
	/**
	 * 病人类型编码
	 * @return String
	 */
	public String getPatient_type() {
		return ((String) getAttrVal("Patient_type"));
	}	
	/**
	 * 病人类型编码
	 * @param Patient_type
	 */
	public void setPatient_type(String Patient_type) {
		setAttrVal("Patient_type", Patient_type);
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
	public FDateTime getDiag_date() {
		return ((FDateTime) getAttrVal("Diag_date"));
	}	
	/**
	 * 诊断日期
	 * @param Diag_date
	 */
	public void setDiag_date(FDateTime Diag_date) {
		setAttrVal("Diag_date", Diag_date);
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
	public String getDiag_name() {
		return ((String) getAttrVal("Diag_name"));
	}	
	/**
	 * 疾病名称
	 * @param Diag_name
	 */
	public void setDiag_name(String Diag_name) {
		setAttrVal("Diag_name", Diag_name);
	}
}