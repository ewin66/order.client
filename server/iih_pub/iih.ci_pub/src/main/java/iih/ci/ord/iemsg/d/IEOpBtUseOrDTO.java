package iih.ci.ord.iemsg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * IE门诊用血申请信息DTO DTO数据 
 * 
 */
public class IEOpBtUseOrDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * IE用血申请主键标识
	 * @return String
	 */
	public String getId_iebtuseoren() {
		return ((String) getAttrVal("Id_iebtuseoren"));
	}	
	/**
	 * IE用血申请主键标识
	 * @param Id_iebtuseoren
	 */
	public void setId_iebtuseoren(String Id_iebtuseoren) {
		setAttrVal("Id_iebtuseoren", Id_iebtuseoren);
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
	 * 性别编码
	 * @return String
	 */
	public String getSex() {
		return ((String) getAttrVal("Sex"));
	}	
	/**
	 * 性别编码
	 * @param Sex
	 */
	public void setSex(String Sex) {
		setAttrVal("Sex", Sex);
	}
	/**
	 * 出生日期
	 * @return FDate
	 */
	public FDate getBrithday() {
		return ((FDate) getAttrVal("Brithday"));
	}	
	/**
	 * 出生日期
	 * @param Brithday
	 */
	public void setBrithday(FDate Brithday) {
		setAttrVal("Brithday", Brithday);
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
	 * 病人科室编码
	 * @return String
	 */
	public String getApply_unit() {
		return ((String) getAttrVal("Apply_unit"));
	}	
	/**
	 * 病人科室编码
	 * @param Apply_unit
	 */
	public void setApply_unit(String Apply_unit) {
		setAttrVal("Apply_unit", Apply_unit);
	}
	/**
	 * 病人科室名称
	 * @return String
	 */
	public String getApply_unit_name() {
		return ((String) getAttrVal("Apply_unit_name"));
	}	
	/**
	 * 病人科室名称
	 * @param Apply_unit_name
	 */
	public void setApply_unit_name(String Apply_unit_name) {
		setAttrVal("Apply_unit_name", Apply_unit_name);
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
	 * 病区名称
	 * @return String
	 */
	public String getWard_code_name() {
		return ((String) getAttrVal("Ward_code_name"));
	}	
	/**
	 * 病区名称
	 * @param Ward_code_name
	 */
	public void setWard_code_name(String Ward_code_name) {
		setAttrVal("Ward_code_name", Ward_code_name);
	}
	/**
	 * 床位号
	 * @return String
	 */
	public String getBed_no() {
		return ((String) getAttrVal("Bed_no"));
	}	
	/**
	 * 床位号
	 * @param Bed_no
	 */
	public void setBed_no(String Bed_no) {
		setAttrVal("Bed_no", Bed_no);
	}
	/**
	 * 医疗机构编码
	 * @return String
	 */
	public String getHospital_code() {
		return ((String) getAttrVal("Hospital_code"));
	}	
	/**
	 * 医疗机构编码
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
	 * 输血申请单号
	 * @return String
	 */
	public String getBill_id() {
		return ((String) getAttrVal("Bill_id"));
	}	
	/**
	 * 输血申请单号
	 * @param Bill_id
	 */
	public void setBill_id(String Bill_id) {
		setAttrVal("Bill_id", Bill_id);
	}
	/**
	 * 取血单号
	 * @return String
	 */
	public String getUse_sn() {
		return ((String) getAttrVal("Use_sn"));
	}	
	/**
	 * 取血单号
	 * @param Use_sn
	 */
	public void setUse_sn(String Use_sn) {
		setAttrVal("Use_sn", Use_sn);
	}
	/**
	 * 取血次数
	 * @return String
	 */
	public String getGet_times() {
		return ((String) getAttrVal("Get_times"));
	}	
	/**
	 * 取血次数
	 * @param Get_times
	 */
	public void setGet_times(String Get_times) {
		setAttrVal("Get_times", Get_times);
	}
	/**
	 * 医嘱号
	 * @return String
	 */
	public String getYz_no() {
		return ((String) getAttrVal("Yz_no"));
	}	
	/**
	 * 医嘱号
	 * @param Yz_no
	 */
	public void setYz_no(String Yz_no) {
		setAttrVal("Yz_no", Yz_no);
	}
	/**
	 * 血液成分编码
	 * @return String
	 */
	public String getBlood_class() {
		return ((String) getAttrVal("Blood_class"));
	}	
	/**
	 * 血液成分编码
	 * @param Blood_class
	 */
	public void setBlood_class(String Blood_class) {
		setAttrVal("Blood_class", Blood_class);
	}
	/**
	 * 血液成分名称
	 * @return String
	 */
	public String getBlood_class_name() {
		return ((String) getAttrVal("Blood_class_name"));
	}	
	/**
	 * 血液成分名称
	 * @param Blood_class_name
	 */
	public void setBlood_class_name(String Blood_class_name) {
		setAttrVal("Blood_class_name", Blood_class_name);
	}
	/**
	 * 取血量
	 * @return String
	 */
	public String getUse_amount() {
		return ((String) getAttrVal("Use_amount"));
	}	
	/**
	 * 取血量
	 * @param Use_amount
	 */
	public void setUse_amount(String Use_amount) {
		setAttrVal("Use_amount", Use_amount);
	}
	/**
	 * 取血量单位
	 * @return String
	 */
	public String getUse_amount_code() {
		return ((String) getAttrVal("Use_amount_code"));
	}	
	/**
	 * 取血量单位
	 * @param Use_amount_code
	 */
	public void setUse_amount_code(String Use_amount_code) {
		setAttrVal("Use_amount_code", Use_amount_code);
	}
	/**
	 * 取血日期
	 * @return FDateTime
	 */
	public FDateTime getUse_date() {
		return ((FDateTime) getAttrVal("Use_date"));
	}	
	/**
	 * 取血日期
	 * @param Use_date
	 */
	public void setUse_date(FDateTime Use_date) {
		setAttrVal("Use_date", Use_date);
	}
	/**
	 * ABO血型编码
	 * @return String
	 */
	public String getAbo_type() {
		return ((String) getAttrVal("Abo_type"));
	}	
	/**
	 * ABO血型编码
	 * @param Abo_type
	 */
	public void setAbo_type(String Abo_type) {
		setAttrVal("Abo_type", Abo_type);
	}
	/**
	 * ABO血型名称
	 * @return String
	 */
	public String getAbo_type_name() {
		return ((String) getAttrVal("Abo_type_name"));
	}	
	/**
	 * ABO血型名称
	 * @param Abo_type_name
	 */
	public void setAbo_type_name(String Abo_type_name) {
		setAttrVal("Abo_type_name", Abo_type_name);
	}
	/**
	 * Rh血型编码
	 * @return String
	 */
	public String getRh_d() {
		return ((String) getAttrVal("Rh_d"));
	}	
	/**
	 * Rh血型编码
	 * @param Rh_d
	 */
	public void setRh_d(String Rh_d) {
		setAttrVal("Rh_d", Rh_d);
	}
	/**
	 * Rh血型名称
	 * @return String
	 */
	public String getRh_d_name() {
		return ((String) getAttrVal("Rh_d_name"));
	}	
	/**
	 * Rh血型名称
	 * @param Rh_d_name
	 */
	public void setRh_d_name(String Rh_d_name) {
		setAttrVal("Rh_d_name", Rh_d_name);
	}
	/**
	 * 是否留观项目编码
	 * @return String
	 */
	public String getIs_lg() {
		return ((String) getAttrVal("Is_lg"));
	}	
	/**
	 * 是否留观项目编码
	 * @param Is_lg
	 */
	public void setIs_lg(String Is_lg) {
		setAttrVal("Is_lg", Is_lg);
	}
	/**
	 * 是否留观项目值
	 * @return String
	 */
	public String getIs_lg_r() {
		return ((String) getAttrVal("Is_lg_r"));
	}	
	/**
	 * 是否留观项目值
	 * @param Is_lg_r
	 */
	public void setIs_lg_r(String Is_lg_r) {
		setAttrVal("Is_lg_r", Is_lg_r);
	}
	/**
	 * 申请医师编码
	 * @return String
	 */
	public String getApp_doctor() {
		return ((String) getAttrVal("App_doctor"));
	}	
	/**
	 * 申请医师编码
	 * @param App_doctor
	 */
	public void setApp_doctor(String App_doctor) {
		setAttrVal("App_doctor", App_doctor);
	}
	/**
	 * 申请医师名称
	 * @return String
	 */
	public String getApp_doctor_name() {
		return ((String) getAttrVal("App_doctor_name"));
	}	
	/**
	 * 申请医师名称
	 * @param App_doctor_name
	 */
	public void setApp_doctor_name(String App_doctor_name) {
		setAttrVal("App_doctor_name", App_doctor_name);
	}
	/**
	 * 申请医师联系电话
	 * @return String
	 */
	public String getApp_tel() {
		return ((String) getAttrVal("App_tel"));
	}	
	/**
	 * 申请医师联系电话
	 * @param App_tel
	 */
	public void setApp_tel(String App_tel) {
		setAttrVal("App_tel", App_tel);
	}
	/**
	 * 手术间编码
	 * @return String
	 */
	public String getOp_loc() {
		return ((String) getAttrVal("Op_loc"));
	}	
	/**
	 * 手术间编码
	 * @param Op_loc
	 */
	public void setOp_loc(String Op_loc) {
		setAttrVal("Op_loc", Op_loc);
	}
	/**
	 * 手术间名称(层)
	 * @return String
	 */
	public String getOp_loc_name() {
		return ((String) getAttrVal("Op_loc_name"));
	}	
	/**
	 * 手术间名称(层)
	 * @param Op_loc_name
	 */
	public void setOp_loc_name(String Op_loc_name) {
		setAttrVal("Op_loc_name", Op_loc_name);
	}
	/**
	 * 手术间电话
	 * @return String
	 */
	public String getOp_tel() {
		return ((String) getAttrVal("Op_tel"));
	}	
	/**
	 * 手术间电话
	 * @param Op_tel
	 */
	public void setOp_tel(String Op_tel) {
		setAttrVal("Op_tel", Op_tel);
	}
	/**
	 * 就诊类别
	 * @return String
	 */
	public String getVisit_type() {
		return ((String) getAttrVal("Visit_type"));
	}	
	/**
	 * 就诊类别
	 * @param Visit_type
	 */
	public void setVisit_type(String Visit_type) {
		setAttrVal("Visit_type", Visit_type);
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
}