package iih.ci.mrqc.qanoticedto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 整改通知DTO DTO数据 
 * 
 */
public class QaNoticeDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键标识
	 * @return String
	 */
	public String getId_noticedto() {
		return ((String) getAttrVal("Id_noticedto"));
	}
	/**
	 * 主键标识
	 * @param Id_noticedto
	 */
	public void setId_noticedto(String Id_noticedto) {
		setAttrVal("Id_noticedto", Id_noticedto);
	}
	/**
	 * 通知书id
	 * @return String
	 */
	public String getId_revision() {
		return ((String) getAttrVal("Id_revision"));
	}
	/**
	 * 通知书id
	 * @param Id_revision
	 */
	public void setId_revision(String Id_revision) {
		setAttrVal("Id_revision", Id_revision);
	}
	/**
	 * 通知书状态id
	 * @return String
	 */
	public String getId_status() {
		return ((String) getAttrVal("Id_status"));
	}
	/**
	 * 通知书状态id
	 * @param Id_status
	 */
	public void setId_status(String Id_status) {
		setAttrVal("Id_status", Id_status);
	}
	/**
	 * 通知书状态编码
	 * @return String
	 */
	public String getSd_status() {
		return ((String) getAttrVal("Sd_status"));
	}
	/**
	 * 通知书状态编码
	 * @param Sd_status
	 */
	public void setSd_status(String Sd_status) {
		setAttrVal("Sd_status", Sd_status);
	}
	/**
	 * 通知书状态
	 * @return String
	 */
	public String getStatus_name() {
		return ((String) getAttrVal("Status_name"));
	}
	/**
	 * 通知书状态
	 * @param Status_name
	 */
	public void setStatus_name(String Status_name) {
		setAttrVal("Status_name", Status_name);
	}
	/**
	 * 发送时间
	 * @return FDateTime
	 */
	public FDateTime getDt_send() {
		return ((FDateTime) getAttrVal("Dt_send"));
	}
	/**
	 * 发送时间
	 * @param Dt_send
	 */
	public void setDt_send(FDateTime Dt_send) {
		setAttrVal("Dt_send", Dt_send);
	}
	/**
	 * 质控医生id
	 * @return String
	 */
	public String getId_exec_doctor() {
		return ((String) getAttrVal("Id_exec_doctor"));
	}
	/**
	 * 质控医生id
	 * @param Id_exec_doctor
	 */
	public void setId_exec_doctor(String Id_exec_doctor) {
		setAttrVal("Id_exec_doctor", Id_exec_doctor);
	}
	/**
	 * 质控医生
	 * @return String
	 */
	public String getExec_doctor_name() {
		return ((String) getAttrVal("Exec_doctor_name"));
	}
	/**
	 * 质控医生
	 * @param Exec_doctor_name
	 */
	public void setExec_doctor_name(String Exec_doctor_name) {
		setAttrVal("Exec_doctor_name", Exec_doctor_name);
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
	 * 整改医生id
	 * @return String
	 */
	public String getId_rfm_doctor() {
		return ((String) getAttrVal("Id_rfm_doctor"));
	}
	/**
	 * 整改医生id
	 * @param Id_rfm_doctor
	 */
	public void setId_rfm_doctor(String Id_rfm_doctor) {
		setAttrVal("Id_rfm_doctor", Id_rfm_doctor);
	}
	/**
	 * 整改医生
	 * @return String
	 */
	public String getRfm_doctor_name() {
		return ((String) getAttrVal("Rfm_doctor_name"));
	}
	/**
	 * 整改医生
	 * @param Rfm_doctor_name
	 */
	public void setRfm_doctor_name(String Rfm_doctor_name) {
		setAttrVal("Rfm_doctor_name", Rfm_doctor_name);
	}
	/**
	 * 整改科室id
	 * @return String
	 */
	public String getId_rfm_dept() {
		return ((String) getAttrVal("Id_rfm_dept"));
	}
	/**
	 * 整改科室id
	 * @param Id_rfm_dept
	 */
	public void setId_rfm_dept(String Id_rfm_dept) {
		setAttrVal("Id_rfm_dept", Id_rfm_dept);
	}
	/**
	 * 整改科室
	 * @return String
	 */
	public String getRfm_dept_name() {
		return ((String) getAttrVal("Rfm_dept_name"));
	}
	/**
	 * 整改科室
	 * @param Rfm_dept_name
	 */
	public void setRfm_dept_name(String Rfm_dept_name) {
		setAttrVal("Rfm_dept_name", Rfm_dept_name);
	}
	/**
	 * 患者就诊主键
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 患者就诊主键
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
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
	 * 整改期限
	 * @return Integer
	 */
	public Integer getRfm_deadline() {
		return ((Integer) getAttrVal("Rfm_deadline"));
	}
	/**
	 * 整改期限
	 * @param Rfm_deadline
	 */
	public void setRfm_deadline(Integer Rfm_deadline) {
		setAttrVal("Rfm_deadline", Rfm_deadline);
	}
	/**
	 * 截止时间
	 * @return FDateTime
	 */
	public FDateTime getDt_deadline() {
		return ((FDateTime) getAttrVal("Dt_deadline"));
	}
	/**
	 * 截止时间
	 * @param Dt_deadline
	 */
	public void setDt_deadline(FDateTime Dt_deadline) {
		setAttrVal("Dt_deadline", Dt_deadline);
	}
	/**
	 * 整改说明
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}
	/**
	 * 整改说明
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 整改完成时间
	 * @return FDateTime
	 */
	public FDateTime getRfm_time() {
		return ((FDateTime) getAttrVal("Rfm_time"));
	}
	/**
	 * 整改完成时间
	 * @param Rfm_time
	 */
	public void setRfm_time(FDateTime Rfm_time) {
		setAttrVal("Rfm_time", Rfm_time);
	}
	/**
	 * 超时申请状态
	 * @return String
	 */
	public String getId_dead_apply_status() {
		return ((String) getAttrVal("Id_dead_apply_status"));
	}
	/**
	 * 超时申请状态
	 * @param Id_dead_apply_status
	 */
	public void setId_dead_apply_status(String Id_dead_apply_status) {
		setAttrVal("Id_dead_apply_status", Id_dead_apply_status);
	}
	/**
	 * 超时申请状态编码
	 * @return String
	 */
	public String getSd_dead_apply_status() {
		return ((String) getAttrVal("Sd_dead_apply_status"));
	}
	/**
	 * 超时申请状态编码
	 * @param Sd_dead_apply_status
	 */
	public void setSd_dead_apply_status(String Sd_dead_apply_status) {
		setAttrVal("Sd_dead_apply_status", Sd_dead_apply_status);
	}
	/**
	 * 超时申请原因
	 * @return String
	 */
	public String getDead_apply_reason() {
		return ((String) getAttrVal("Dead_apply_reason"));
	}
	/**
	 * 超时申请原因
	 * @param Dead_apply_reason
	 */
	public void setDead_apply_reason(String Dead_apply_reason) {
		setAttrVal("Dead_apply_reason", Dead_apply_reason);
	}
	/**
	 * 超时申请时间
	 * @return FDateTime
	 */
	public FDateTime getDt_dead_apply() {
		return ((FDateTime) getAttrVal("Dt_dead_apply"));
	}
	/**
	 * 超时申请时间
	 * @param Dt_dead_apply
	 */
	public void setDt_dead_apply(FDateTime Dt_dead_apply) {
		setAttrVal("Dt_dead_apply", Dt_dead_apply);
	}
	/**
	 * 超时申请驳回原因
	 * @return String
	 */
	public String getDead_callback_reason() {
		return ((String) getAttrVal("Dead_callback_reason"));
	}
	/**
	 * 超时申请驳回原因
	 * @param Dead_callback_reason
	 */
	public void setDead_callback_reason(String Dead_callback_reason) {
		setAttrVal("Dead_callback_reason", Dead_callback_reason);
	}
	/**
	 * 超时审批时间
	 * @return FDateTime
	 */
	public FDateTime getDt_dead_agree() {
		return ((FDateTime) getAttrVal("Dt_dead_agree"));
	}
	/**
	 * 超时审批时间
	 * @param Dt_dead_agree
	 */
	public void setDt_dead_agree(FDateTime Dt_dead_agree) {
		setAttrVal("Dt_dead_agree", Dt_dead_agree);
	}
	/**
	 * 超时申请状态名称
	 * @return String
	 */
	public String getDead_apply_status_name() {
		return ((String) getAttrVal("Dead_apply_status_name"));
	}
	/**
	 * 超时申请状态名称
	 * @param Dead_apply_status_name
	 */
	public void setDead_apply_status_name(String Dead_apply_status_name) {
		setAttrVal("Dead_apply_status_name", Dead_apply_status_name);
	}
}