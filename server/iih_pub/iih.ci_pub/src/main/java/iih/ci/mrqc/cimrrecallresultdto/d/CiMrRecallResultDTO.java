package iih.ci.mrqc.cimrrecallresultdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊病历召回列表 DTO数据 
 * 
 */
public class CiMrRecallResultDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 就诊id
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊id
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 召回申请id
	 * @return String
	 */
	public String getId_recall() {
		return ((String) getAttrVal("Id_recall"));
	}
	/**
	 * 召回申请id
	 * @param Id_recall
	 */
	public void setId_recall(String Id_recall) {
		setAttrVal("Id_recall", Id_recall);
	}
	/**
	 *  审批状态
	 * @return String
	 */
	public String getName_state() {
		return ((String) getAttrVal("Name_state"));
	}
	/**
	 *  审批状态
	 * @param Name_state
	 */
	public void setName_state(String Name_state) {
		setAttrVal("Name_state", Name_state);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getPat_name() {
		return ((String) getAttrVal("Pat_name"));
	}
	/**
	 * 患者姓名
	 * @param Pat_name
	 */
	public void setPat_name(String Pat_name) {
		setAttrVal("Pat_name", Pat_name);
	}
	/**
	 * 性别
	 * @return String
	 */
	public String getPat_sex() {
		return ((String) getAttrVal("Pat_sex"));
	}
	/**
	 * 性别
	 * @param Pat_sex
	 */
	public void setPat_sex(String Pat_sex) {
		setAttrVal("Pat_sex", Pat_sex);
	}
	/**
	 * 年龄
	 * @return String
	 */
	public String getPat_age() {
		return ((String) getAttrVal("Pat_age"));
	}
	/**
	 * 年龄
	 * @param Pat_age
	 */
	public void setPat_age(String Pat_age) {
		setAttrVal("Pat_age", Pat_age);
	}
	/**
	 * 驳回原因
	 * @return String
	 */
	public String getReason_reject() {
		return ((String) getAttrVal("Reason_reject"));
	}
	/**
	 * 驳回原因
	 * @param Reason_reject
	 */
	public void setReason_reject(String Reason_reject) {
		setAttrVal("Reason_reject", Reason_reject);
	}
	/**
	 * 就诊时间
	 * @return FDateTime
	 */
	public FDateTime getDt_ent() {
		return ((FDateTime) getAttrVal("Dt_ent"));
	}
	/**
	 * 就诊时间
	 * @param Dt_ent
	 */
	public void setDt_ent(FDateTime Dt_ent) {
		setAttrVal("Dt_ent", Dt_ent);
	}
	/**
	 * 申请时间
	 * @return FDateTime
	 */
	public FDateTime getDt_apply() {
		return ((FDateTime) getAttrVal("Dt_apply"));
	}
	/**
	 * 申请时间
	 * @param Dt_apply
	 */
	public void setDt_apply(FDateTime Dt_apply) {
		setAttrVal("Dt_apply", Dt_apply);
	}
	/**
	 * 审批人
	 * @return String
	 */
	public String getName_psn_approve() {
		return ((String) getAttrVal("Name_psn_approve"));
	}
	/**
	 * 审批人
	 * @param Name_psn_approve
	 */
	public void setName_psn_approve(String Name_psn_approve) {
		setAttrVal("Name_psn_approve", Name_psn_approve);
	}
	/**
	 * 审批时间
	 * @return FDateTime
	 */
	public FDateTime getDt_approve() {
		return ((FDateTime) getAttrVal("Dt_approve"));
	}
	/**
	 * 审批时间
	 * @param Dt_approve
	 */
	public void setDt_approve(FDateTime Dt_approve) {
		setAttrVal("Dt_approve", Dt_approve);
	}
	/**
	 * 召回截止时间
	 * @return FDate
	 */
	public FDate getDt_end() {
		return ((FDate) getAttrVal("Dt_end"));
	}
	/**
	 * 召回截止时间
	 * @param Dt_end
	 */
	public void setDt_end(FDate Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 申请原因
	 * @return String
	 */
	public String getApply_reason() {
		return ((String) getAttrVal("Apply_reason"));
	}
	/**
	 * 申请原因
	 * @param Apply_reason
	 */
	public void setApply_reason(String Apply_reason) {
		setAttrVal("Apply_reason", Apply_reason);
	}
	/**
	 * 申请人
	 * @return String
	 */
	public String getName_psn_apply() {
		return ((String) getAttrVal("Name_psn_apply"));
	}
	/**
	 * 申请人
	 * @param Name_psn_apply
	 */
	public void setName_psn_apply(String Name_psn_apply) {
		setAttrVal("Name_psn_apply", Name_psn_apply);
	}
	/**
	 * 申请科室
	 * @return String
	 */
	public String getName_dep_apply() {
		return ((String) getAttrVal("Name_dep_apply"));
	}
	/**
	 * 申请科室
	 * @param Name_dep_apply
	 */
	public void setName_dep_apply(String Name_dep_apply) {
		setAttrVal("Name_dep_apply", Name_dep_apply);
	}
	/**
	 * 条码号
	 * @return String
	 */
	public String getBarcode_chis() {
		return ((String) getAttrVal("Barcode_chis"));
	}
	/**
	 * 条码号
	 * @param Barcode_chis
	 */
	public void setBarcode_chis(String Barcode_chis) {
		setAttrVal("Barcode_chis", Barcode_chis);
	}
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}
	/**
	 * 就诊类型
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	/**
	 * 是否超时
	 * @return String
	 */
	public String getFg_timeout() {
		return ((String) getAttrVal("Fg_timeout"));
	}
	/**
	 * 是否超时
	 * @param Fg_timeout
	 */
	public void setFg_timeout(String Fg_timeout) {
		setAttrVal("Fg_timeout", Fg_timeout);
	}
	/**
	 * 就诊编码
	 * @return String
	 */
	public String getEnt_code() {
		return ((String) getAttrVal("Ent_code"));
	}
	/**
	 * 就诊编码
	 * @param Ent_code
	 */
	public void setEnt_code(String Ent_code) {
		setAttrVal("Ent_code", Ent_code);
	}
}