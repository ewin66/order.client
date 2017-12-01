package iih.ci.ord.iemsg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * IE用血申请信息DTO DTO数据 
 * 
 */
public class IEBtUseOrDTO extends BaseDTO {
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
	 * 病区名称
	 * @return String
	 */
	public String getWardname() {
		return ((String) getAttrVal("Wardname"));
	}	
	/**
	 * 病区名称
	 * @param Wardname
	 */
	public void setWardname(String Wardname) {
		setAttrVal("Wardname", Wardname);
	}
	/**
	 * 床位号
	 * @return String
	 */
	public String getBedcode() {
		return ((String) getAttrVal("Bedcode"));
	}	
	/**
	 * 床位号
	 * @param Bedcode
	 */
	public void setBedcode(String Bedcode) {
		setAttrVal("Bedcode", Bedcode);
	}
	/**
	 * 医嘱确认时间（-）
	 * @return FDateTime
	 */
	public FDateTime getConfirm_date() {
		return ((FDateTime) getAttrVal("Confirm_date"));
	}	
	/**
	 * 医嘱确认时间（-）
	 * @param Confirm_date
	 */
	public void setConfirm_date(FDateTime Confirm_date) {
		setAttrVal("Confirm_date", Confirm_date);
	}
	/**
	 * 确认护士编码（-）
	 * @return String
	 */
	public String getConfirm_nurse_code() {
		return ((String) getAttrVal("Confirm_nurse_code"));
	}	
	/**
	 * 确认护士编码（-）
	 * @param Confirm_nurse_code
	 */
	public void setConfirm_nurse_code(String Confirm_nurse_code) {
		setAttrVal("Confirm_nurse_code", Confirm_nurse_code);
	}
	/**
	 * 确认护士姓名（-）
	 * @return String
	 */
	public String getConfirm_nurse_name() {
		return ((String) getAttrVal("Confirm_nurse_name"));
	}	
	/**
	 * 确认护士姓名（-）
	 * @param Confirm_nurse_name
	 */
	public void setConfirm_nurse_name(String Confirm_nurse_name) {
		setAttrVal("Confirm_nurse_name", Confirm_nurse_name);
	}
	/**
	 * 输血申请单号
	 * @return String
	 */
	public String getSx_code() {
		return ((String) getAttrVal("Sx_code"));
	}	
	/**
	 * 输血申请单号
	 * @param Sx_code
	 */
	public void setSx_code(String Sx_code) {
		setAttrVal("Sx_code", Sx_code);
	}
	/**
	 * 取血单号
	 * @return String
	 */
	public String getQx_code() {
		return ((String) getAttrVal("Qx_code"));
	}	
	/**
	 * 取血单号
	 * @param Qx_code
	 */
	public void setQx_code(String Qx_code) {
		setAttrVal("Qx_code", Qx_code);
	}
	/**
	 * 取血次数
	 * @return String
	 */
	public String getQx_times() {
		return ((String) getAttrVal("Qx_times"));
	}	
	/**
	 * 取血次数
	 * @param Qx_times
	 */
	public void setQx_times(String Qx_times) {
		setAttrVal("Qx_times", Qx_times);
	}
	/**
	 * 医嘱号
	 * @return String
	 */
	public String getOrder_no() {
		return ((String) getAttrVal("Order_no"));
	}	
	/**
	 * 医嘱号
	 * @param Order_no
	 */
	public void setOrder_no(String Order_no) {
		setAttrVal("Order_no", Order_no);
	}
	/**
	 * 血液成分编码
	 * @return String
	 */
	public String getXy_code() {
		return ((String) getAttrVal("Xy_code"));
	}	
	/**
	 * 血液成分编码
	 * @param Xy_code
	 */
	public void setXy_code(String Xy_code) {
		setAttrVal("Xy_code", Xy_code);
	}
	/**
	 * 血液成分名称
	 * @return String
	 */
	public String getXy_name() {
		return ((String) getAttrVal("Xy_name"));
	}	
	/**
	 * 血液成分名称
	 * @param Xy_name
	 */
	public void setXy_name(String Xy_name) {
		setAttrVal("Xy_name", Xy_name);
	}
	/**
	 * 取血量
	 * @return String
	 */
	public String getQx_count() {
		return ((String) getAttrVal("Qx_count"));
	}	
	/**
	 * 取血量
	 * @param Qx_count
	 */
	public void setQx_count(String Qx_count) {
		setAttrVal("Qx_count", Qx_count);
	}
	/**
	 * 取血量单位
	 * @return String
	 */
	public String getQx_unit() {
		return ((String) getAttrVal("Qx_unit"));
	}	
	/**
	 * 取血量单位
	 * @param Qx_unit
	 */
	public void setQx_unit(String Qx_unit) {
		setAttrVal("Qx_unit", Qx_unit);
	}
	/**
	 * 取血日期
	 * @return FDateTime
	 */
	public FDateTime getQx_date() {
		return ((FDateTime) getAttrVal("Qx_date"));
	}	
	/**
	 * 取血日期
	 * @param Qx_date
	 */
	public void setQx_date(FDateTime Qx_date) {
		setAttrVal("Qx_date", Qx_date);
	}
	/**
	 * ABO血型编码
	 * @return String
	 */
	public String getAbo_code() {
		return ((String) getAttrVal("Abo_code"));
	}	
	/**
	 * ABO血型编码
	 * @param Abo_code
	 */
	public void setAbo_code(String Abo_code) {
		setAttrVal("Abo_code", Abo_code);
	}
	/**
	 * ABO血型名称
	 * @return String
	 */
	public String getAbo_name() {
		return ((String) getAttrVal("Abo_name"));
	}	
	/**
	 * ABO血型名称
	 * @param Abo_name
	 */
	public void setAbo_name(String Abo_name) {
		setAttrVal("Abo_name", Abo_name);
	}
	/**
	 * Rh血型编码
	 * @return String
	 */
	public String getRh_code() {
		return ((String) getAttrVal("Rh_code"));
	}	
	/**
	 * Rh血型编码
	 * @param Rh_code
	 */
	public void setRh_code(String Rh_code) {
		setAttrVal("Rh_code", Rh_code);
	}
	/**
	 * Rh血型名称
	 * @return String
	 */
	public String getRh_name() {
		return ((String) getAttrVal("Rh_name"));
	}	
	/**
	 * Rh血型名称
	 * @param Rh_name
	 */
	public void setRh_name(String Rh_name) {
		setAttrVal("Rh_name", Rh_name);
	}
	/**
	 * 申请医师编码
	 * @return String
	 */
	public String getDoctor_code() {
		return ((String) getAttrVal("Doctor_code"));
	}	
	/**
	 * 申请医师编码
	 * @param Doctor_code
	 */
	public void setDoctor_code(String Doctor_code) {
		setAttrVal("Doctor_code", Doctor_code);
	}
	/**
	 * 申请医师名称
	 * @return String
	 */
	public String getDoctor_name() {
		return ((String) getAttrVal("Doctor_name"));
	}	
	/**
	 * 申请医师名称
	 * @param Doctor_name
	 */
	public void setDoctor_name(String Doctor_name) {
		setAttrVal("Doctor_name", Doctor_name);
	}
	/**
	 * 申请医师联系电话
	 * @return String
	 */
	public String getDoctor_tel() {
		return ((String) getAttrVal("Doctor_tel"));
	}	
	/**
	 * 申请医师联系电话
	 * @param Doctor_tel
	 */
	public void setDoctor_tel(String Doctor_tel) {
		setAttrVal("Doctor_tel", Doctor_tel);
	}
	/**
	 * 手术间编码
	 * @return String
	 */
	public String getSsj_code() {
		return ((String) getAttrVal("Ssj_code"));
	}	
	/**
	 * 手术间编码
	 * @param Ssj_code
	 */
	public void setSsj_code(String Ssj_code) {
		setAttrVal("Ssj_code", Ssj_code);
	}
	/**
	 * 手术间名称（层）
	 * @return String
	 */
	public String getSsj_name() {
		return ((String) getAttrVal("Ssj_name"));
	}	
	/**
	 * 手术间名称（层）
	 * @param Ssj_name
	 */
	public void setSsj_name(String Ssj_name) {
		setAttrVal("Ssj_name", Ssj_name);
	}
	/**
	 * 手术间电话
	 * @return String
	 */
	public String getSsj_tel() {
		return ((String) getAttrVal("Ssj_tel"));
	}	
	/**
	 * 手术间电话
	 * @param Ssj_tel
	 */
	public void setSsj_tel(String Ssj_tel) {
		setAttrVal("Ssj_tel", Ssj_tel);
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