package iih.ci.ord.iemsg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * IE门诊治疗医嘱就诊信息DTO DTO数据 
 * 
 */
public class IEOpTreatOrEnDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * IE治疗医嘱就诊主键标识
	 * @return String
	 */
	public String getId_ietreatoren() {
		return ((String) getAttrVal("Id_ietreatoren"));
	}	
	/**
	 * IE治疗医嘱就诊主键标识
	 * @param Id_ietreatoren
	 */
	public void setId_ietreatoren(String Id_ietreatoren) {
		setAttrVal("Id_ietreatoren", Id_ietreatoren);
	}
	/**
	 * IE治疗医嘱集合
	 * @return FArrayList2
	 */
	public FArrayList2 getIetreators() {
		return ((FArrayList2) getAttrVal("Ietreators"));
	}	
	/**
	 * IE治疗医嘱集合
	 * @param Ietreators
	 */
	public void setIetreators(FArrayList2 Ietreators) {
		setAttrVal("Ietreators", Ietreators);
	}
	/**
	 * IE治疗费用项集合
	 * @return FArrayList2
	 */
	public FArrayList2 getIetreatfees() {
		return ((FArrayList2) getAttrVal("Ietreatfees"));
	}	
	/**
	 * IE治疗费用项集合
	 * @param Ietreatfees
	 */
	public void setIetreatfees(FArrayList2 Ietreatfees) {
		setAttrVal("Ietreatfees", Ietreatfees);
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
	 * 医嘱确认时间
	 * @return FDateTime
	 */
	public FDateTime getConfrim_date() {
		return ((FDateTime) getAttrVal("Confrim_date"));
	}	
	/**
	 * 医嘱确认时间
	 * @param Confrim_date
	 */
	public void setConfrim_date(FDateTime Confrim_date) {
		setAttrVal("Confrim_date", Confrim_date);
	}
	/**
	 * 确认护士编码
	 * @return String
	 */
	public String getConfirm_opera() {
		return ((String) getAttrVal("Confirm_opera"));
	}	
	/**
	 * 确认护士编码
	 * @param Confirm_opera
	 */
	public void setConfirm_opera(String Confirm_opera) {
		setAttrVal("Confirm_opera", Confirm_opera);
	}
	/**
	 * 确认护士姓名
	 * @return String
	 */
	public String getConfrim_opera_name() {
		return ((String) getAttrVal("Confrim_opera_name"));
	}	
	/**
	 * 确认护士姓名
	 * @param Confrim_opera_name
	 */
	public void setConfrim_opera_name(String Confrim_opera_name) {
		setAttrVal("Confrim_opera_name", Confrim_opera_name);
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
	 * 医疗机构编码
	 * @return String
	 */
	public String getOrgcode() {
		return ((String) getAttrVal("Orgcode"));
	}	
	/**
	 * 医疗机构编码
	 * @param Orgcode
	 */
	public void setOrgcode(String Orgcode) {
		setAttrVal("Orgcode", Orgcode);
	}
	/**
	 * 医疗机构名称
	 * @return String
	 */
	public String getOrgname() {
		return ((String) getAttrVal("Orgname"));
	}	
	/**
	 * 医疗机构名称
	 * @param Orgname
	 */
	public void setOrgname(String Orgname) {
		setAttrVal("Orgname", Orgname);
	}
	/**
	 * 执行科室编码
	 * @return String
	 */
	public String getExec_sn() {
		return ((String) getAttrVal("Exec_sn"));
	}	
	/**
	 * 执行科室编码
	 * @param Exec_sn
	 */
	public void setExec_sn(String Exec_sn) {
		setAttrVal("Exec_sn", Exec_sn);
	}
}