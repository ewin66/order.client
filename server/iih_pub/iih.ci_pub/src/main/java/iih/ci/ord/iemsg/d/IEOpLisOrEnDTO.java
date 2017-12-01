package iih.ci.ord.iemsg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * IE门诊检验申请就诊信息DTO DTO数据 
 * 
 */
public class IEOpLisOrEnDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * IE检验申请就诊主键标识
	 * @return String
	 */
	public String getId_ielisoren() {
		return ((String) getAttrVal("Id_ielisoren"));
	}	
	/**
	 * IE检验申请就诊主键标识
	 * @param Id_ielisoren
	 */
	public void setId_ielisoren(String Id_ielisoren) {
		setAttrVal("Id_ielisoren", Id_ielisoren);
	}
	/**
	 * IE检验申请集合
	 * @return FArrayList2
	 */
	public FArrayList2 getId_ielisors() {
		return ((FArrayList2) getAttrVal("Id_ielisors"));
	}	
	/**
	 * IE检验申请集合
	 * @param Id_ielisors
	 */
	public void setId_ielisors(FArrayList2 Id_ielisors) {
		setAttrVal("Id_ielisors", Id_ielisors);
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
	 * 患者姓名
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 患者姓名
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
	 * 移动电话
	 * @return String
	 */
	public String getCellphone() {
		return ((String) getAttrVal("Cellphone"));
	}	
	/**
	 * 移动电话
	 * @param Cellphone
	 */
	public void setCellphone(String Cellphone) {
		setAttrVal("Cellphone", Cellphone);
	}
	/**
	 * 性别代码
	 * @return String
	 */
	public String getSex() {
		return ((String) getAttrVal("Sex"));
	}	
	/**
	 * 性别代码
	 * @param Sex
	 */
	public void setSex(String Sex) {
		setAttrVal("Sex", Sex);
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
	 * 家庭住址
	 * @return String
	 */
	public String getHome_street() {
		return ((String) getAttrVal("Home_street"));
	}	
	/**
	 * 家庭住址
	 * @param Home_street
	 */
	public void setHome_street(String Home_street) {
		setAttrVal("Home_street", Home_street);
	}
	/**
	 * 邮政编码
	 * @return String
	 */
	public String getPost_code() {
		return ((String) getAttrVal("Post_code"));
	}	
	/**
	 * 邮政编码
	 * @param Post_code
	 */
	public void setPost_code(String Post_code) {
		setAttrVal("Post_code", Post_code);
	}
	/**
	 * 工作单位代码
	 * @return String
	 */
	public String getWork_place_code() {
		return ((String) getAttrVal("Work_place_code"));
	}	
	/**
	 * 工作单位代码
	 * @param Work_place_code
	 */
	public void setWork_place_code(String Work_place_code) {
		setAttrVal("Work_place_code", Work_place_code);
	}
	/**
	 * 工作单位名称
	 * @return String
	 */
	public String getWork_place() {
		return ((String) getAttrVal("Work_place"));
	}	
	/**
	 * 工作单位名称
	 * @param Work_place
	 */
	public void setWork_place(String Work_place) {
		setAttrVal("Work_place", Work_place);
	}
	/**
	 * 医疗机构代码
	 * @return String
	 */
	public String getHospital_code() {
		return ((String) getAttrVal("Hospital_code"));
	}	
	/**
	 * 医疗机构代码
	 * @param Hospital_code
	 */
	public void setHospital_code(String Hospital_code) {
		setAttrVal("Hospital_code", Hospital_code);
	}
	/**
	 * 医疗机构名称
	 * @return String
	 */
	public String getHospital_name() {
		return ((String) getAttrVal("Hospital_name"));
	}	
	/**
	 * 医疗机构名称
	 * @param Hospital_name
	 */
	public void setHospital_name(String Hospital_name) {
		setAttrVal("Hospital_name", Hospital_name);
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
	 * 录入日期开始时间
	 * @return FDateTime
	 */
	public FDateTime getInput_begindate() {
		return ((FDateTime) getAttrVal("Input_begindate"));
	}	
	/**
	 * 录入日期开始时间
	 * @param Input_begindate
	 */
	public void setInput_begindate(FDateTime Input_begindate) {
		setAttrVal("Input_begindate", Input_begindate);
	}
	/**
	 * 录入日期结束时间
	 * @return FDateTime
	 */
	public FDateTime getInput_enddate() {
		return ((FDateTime) getAttrVal("Input_enddate"));
	}	
	/**
	 * 录入日期结束时间
	 * @param Input_enddate
	 */
	public void setInput_enddate(FDateTime Input_enddate) {
		setAttrVal("Input_enddate", Input_enddate);
	}
	/**
	 * 录入人
	 * @return String
	 */
	public String getInput_opera() {
		return ((String) getAttrVal("Input_opera"));
	}	
	/**
	 * 录入人
	 * @param Input_opera
	 */
	public void setInput_opera(String Input_opera) {
		setAttrVal("Input_opera", Input_opera);
	}
	/**
	 * 录入人姓名
	 * @return String
	 */
	public String getInput_opera_name() {
		return ((String) getAttrVal("Input_opera_name"));
	}	
	/**
	 * 录入人姓名
	 * @param Input_opera_name
	 */
	public void setInput_opera_name(String Input_opera_name) {
		setAttrVal("Input_opera_name", Input_opera_name);
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
	 * 病人类型编码
	 * @return String
	 */
	public String getVisit_type() {
		return ((String) getAttrVal("Visit_type"));
	}	
	/**
	 * 病人类型编码
	 * @param Visit_type
	 */
	public void setVisit_type(String Visit_type) {
		setAttrVal("Visit_type", Visit_type);
	}
	/**
	 * 病人类型名称
	 * @return String
	 */
	public String getVisit_type_name() {
		return ((String) getAttrVal("Visit_type_name"));
	}	
	/**
	 * 病人类型名称
	 * @param Visit_type_name
	 */
	public void setVisit_type_name(String Visit_type_name) {
		setAttrVal("Visit_type_name", Visit_type_name);
	}
	/**
	 * 就诊院区编码
	 * @return String
	 */
	public String getYq_code() {
		return ((String) getAttrVal("Yq_code"));
	}	
	/**
	 * 就诊院区编码
	 * @param Yq_code
	 */
	public void setYq_code(String Yq_code) {
		setAttrVal("Yq_code", Yq_code);
	}
	/**
	 * 就诊院区名称
	 * @return String
	 */
	public String getYz_code_name() {
		return ((String) getAttrVal("Yz_code_name"));
	}	
	/**
	 * 就诊院区名称
	 * @param Yz_code_name
	 */
	public void setYz_code_name(String Yz_code_name) {
		setAttrVal("Yz_code_name", Yz_code_name);
	}
	/**
	 * 诊断类别
	 * @return String
	 */
	public String getDiag_type() {
		return ((String) getAttrVal("Diag_type"));
	}	
	/**
	 * 诊断类别
	 * @param Diag_type
	 */
	public void setDiag_type(String Diag_type) {
		setAttrVal("Diag_type", Diag_type);
	}
	/**
	 * 疾病代码
	 * @return String
	 */
	public String getDiag_code() {
		return ((String) getAttrVal("Diag_code"));
	}	
	/**
	 * 疾病代码
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
	 * 病人科室编码
	 * @return String
	 */
	public String getPatient_deptcode() {
		return ((String) getAttrVal("Patient_deptcode"));
	}	
	/**
	 * 病人科室编码
	 * @param Patient_deptcode
	 */
	public void setPatient_deptcode(String Patient_deptcode) {
		setAttrVal("Patient_deptcode", Patient_deptcode);
	}
	/**
	 * 病人科室名称
	 * @return String
	 */
	public String getPatient_deptname() {
		return ((String) getAttrVal("Patient_deptname"));
	}	
	/**
	 * 病人科室名称
	 * @param Patient_deptname
	 */
	public void setPatient_deptname(String Patient_deptname) {
		setAttrVal("Patient_deptname", Patient_deptname);
	}
}