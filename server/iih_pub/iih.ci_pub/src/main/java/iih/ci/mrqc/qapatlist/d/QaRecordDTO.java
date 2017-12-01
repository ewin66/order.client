package iih.ci.mrqc.qapatlist.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 质控工作记录dto DTO数据 
 * 
 */
public class QaRecordDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * dto主键
	 * @return String
	 */
	public String getId_recorddto() {
		return ((String) getAttrVal("Id_recorddto"));
	}
	/**
	 * dto主键
	 * @param Id_recorddto
	 */
	public void setId_recorddto(String Id_recorddto) {
		setAttrVal("Id_recorddto", Id_recorddto);
	}
	/**
	 * 质控日期
	 * @return FDateTime
	 */
	public FDateTime getDt_plan() {
		return ((FDateTime) getAttrVal("Dt_plan"));
	}
	/**
	 * 质控日期
	 * @param Dt_plan
	 */
	public void setDt_plan(FDateTime Dt_plan) {
		setAttrVal("Dt_plan", Dt_plan);
	}
	/**
	 * 住院号
	 * @return String
	 */
	public String getCode_hospital() {
		return ((String) getAttrVal("Code_hospital"));
	}
	/**
	 * 住院号
	 * @param Code_hospital
	 */
	public void setCode_hospital(String Code_hospital) {
		setAttrVal("Code_hospital", Code_hospital);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 患者姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 主诊断
	 * @return String
	 */
	public String getName_di() {
		return ((String) getAttrVal("Name_di"));
	}
	/**
	 * 主诊断
	 * @param Name_di
	 */
	public void setName_di(String Name_di) {
		setAttrVal("Name_di", Name_di);
	}
	/**
	 * 通知书主键
	 * @return String
	 */
	public String getId_revision() {
		return ((String) getAttrVal("Id_revision"));
	}
	/**
	 * 通知书主键
	 * @param Id_revision
	 */
	public void setId_revision(String Id_revision) {
		setAttrVal("Id_revision", Id_revision);
	}
	/**
	 * 通知书状态
	 * @return String
	 */
	public String getId_status() {
		return ((String) getAttrVal("Id_status"));
	}
	/**
	 * 通知书状态
	 * @param Id_status
	 */
	public void setId_status(String Id_status) {
		setAttrVal("Id_status", Id_status);
	}
	/**
	 * 通知书状态名称
	 * @return String
	 */
	public String getStatus_name() {
		return ((String) getAttrVal("Status_name"));
	}
	/**
	 * 通知书状态名称
	 * @param Status_name
	 */
	public void setStatus_name(String Status_name) {
		setAttrVal("Status_name", Status_name);
	}
	/**
	 * 质控医生id
	 * @return String
	 */
	public String getId_exec_user() {
		return ((String) getAttrVal("Id_exec_user"));
	}
	/**
	 * 质控医生id
	 * @param Id_exec_user
	 */
	public void setId_exec_user(String Id_exec_user) {
		setAttrVal("Id_exec_user", Id_exec_user);
	}
	/**
	 * 质控医生
	 * @return String
	 */
	public String getExec_user_name() {
		return ((String) getAttrVal("Exec_user_name"));
	}
	/**
	 * 质控医生
	 * @param Exec_user_name
	 */
	public void setExec_user_name(String Exec_user_name) {
		setAttrVal("Exec_user_name", Exec_user_name);
	}
	/**
	 * 质控科室id
	 * @return String
	 */
	public String getId_exec_dept() {
		return ((String) getAttrVal("Id_exec_dept"));
	}
	/**
	 * 质控科室id
	 * @param Id_exec_dept
	 */
	public void setId_exec_dept(String Id_exec_dept) {
		setAttrVal("Id_exec_dept", Id_exec_dept);
	}
	/**
	 * 质控科室
	 * @return String
	 */
	public String getExec_dept_name() {
		return ((String) getAttrVal("Exec_dept_name"));
	}
	/**
	 * 质控科室
	 * @param Exec_dept_name
	 */
	public void setExec_dept_name(String Exec_dept_name) {
		setAttrVal("Exec_dept_name", Exec_dept_name);
	}
	/**
	 * 缺陷次数
	 * @return String
	 */
	public String getDeduct_times() {
		return ((String) getAttrVal("Deduct_times"));
	}
	/**
	 * 缺陷次数
	 * @param Deduct_times
	 */
	public void setDeduct_times(String Deduct_times) {
		setAttrVal("Deduct_times", Deduct_times);
	}
	/**
	 * 整改说明
	 * @return String
	 */
	public String getRes() {
		return ((String) getAttrVal("Res"));
	}
	/**
	 * 整改说明
	 * @param Res
	 */
	public void setRes(String Res) {
		setAttrVal("Res", Res);
	}
}