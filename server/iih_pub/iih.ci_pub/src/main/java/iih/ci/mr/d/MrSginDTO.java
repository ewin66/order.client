package iih.ci.mr.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 实体 DTO数据 
 * 
 */
public class MrSginDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 流程任务
	 * @return String
	 */
	public String getId_task() {
		return ((String) getAttrVal("Id_task"));
	}
	/**
	 * 流程任务
	 * @param Id_task
	 */
	public void setId_task(String Id_task) {
		setAttrVal("Id_task", Id_task);
	}
	/**
	 * 任务状态
	 * @return String
	 */
	public String getState() {
		return ((String) getAttrVal("State"));
	}
	/**
	 * 任务状态
	 * @param State
	 */
	public void setState(String State) {
		setAttrVal("State", State);
	}
	/**
	 * 活动名称
	 * @return String
	 */
	public String getNodeins_name() {
		return ((String) getAttrVal("Nodeins_name"));
	}
	/**
	 * 活动名称
	 * @param Nodeins_name
	 */
	public void setNodeins_name(String Nodeins_name) {
		setAttrVal("Nodeins_name", Nodeins_name);
	}
	/**
	 * 审签人
	 * @return String
	 */
	public String getId_owner() {
		return ((String) getAttrVal("Id_owner"));
	}
	/**
	 * 审签人
	 * @param Id_owner
	 */
	public void setId_owner(String Id_owner) {
		setAttrVal("Id_owner", Id_owner);
	}
	/**
	 * 文书
	 * @return String
	 */
	public String getId_frmins() {
		return ((String) getAttrVal("Id_frmins"));
	}
	/**
	 * 文书
	 * @param Id_frmins
	 */
	public void setId_frmins(String Id_frmins) {
		setAttrVal("Id_frmins", Id_frmins);
	}
	/**
	 * 创建类型
	 * @return String
	 */
	public String getCreatetype() {
		return ((String) getAttrVal("Createtype"));
	}
	/**
	 * 创建类型
	 * @param Createtype
	 */
	public void setCreatetype(String Createtype) {
		setAttrVal("Createtype", Createtype);
	}
	/**
	 * 医疗记录
	 * @return String
	 */
	public String getId_mr() {
		return ((String) getAttrVal("Id_mr"));
	}
	/**
	 * 医疗记录
	 * @param Id_mr
	 */
	public void setId_mr(String Id_mr) {
		setAttrVal("Id_mr", Id_mr);
	}
	/**
	 * 文书名称
	 * @return String
	 */
	public String getMr_name() {
		return ((String) getAttrVal("Mr_name"));
	}
	/**
	 * 文书名称
	 * @param Mr_name
	 */
	public void setMr_name(String Mr_name) {
		setAttrVal("Mr_name", Mr_name);
	}
	/**
	 * 床号
	 * @return String
	 */
	public String getMr_bed_name() {
		return ((String) getAttrVal("Mr_bed_name"));
	}
	/**
	 * 床号
	 * @param Mr_bed_name
	 */
	public void setMr_bed_name(String Mr_bed_name) {
		setAttrVal("Mr_bed_name", Mr_bed_name);
	}
	/**
	 * 审签等级
	 * @return String
	 */
	public String getReviewtp_name() {
		return ((String) getAttrVal("Reviewtp_name"));
	}
	/**
	 * 审签等级
	 * @param Reviewtp_name
	 */
	public void setReviewtp_name(String Reviewtp_name) {
		setAttrVal("Reviewtp_name", Reviewtp_name);
	}
	/**
	 * 提交人
	 * @return String
	 */
	public String getMr_modifiedby() {
		return ((String) getAttrVal("Mr_modifiedby"));
	}
	/**
	 * 提交人
	 * @param Mr_modifiedby
	 */
	public void setMr_modifiedby(String Mr_modifiedby) {
		setAttrVal("Mr_modifiedby", Mr_modifiedby);
	}
	/**
	 * 提交时间
	 * @return String
	 */
	public String getMr_modifiedtime() {
		return ((String) getAttrVal("Mr_modifiedtime"));
	}
	/**
	 * 提交时间
	 * @param Mr_modifiedtime
	 */
	public void setMr_modifiedtime(String Mr_modifiedtime) {
		setAttrVal("Mr_modifiedtime", Mr_modifiedtime);
	}
	/**
	 * 审签意见
	 * @return String
	 */
	public String getMr_sign_suggestion() {
		return ((String) getAttrVal("Mr_sign_suggestion"));
	}
	/**
	 * 审签意见
	 * @param Mr_sign_suggestion
	 */
	public void setMr_sign_suggestion(String Mr_sign_suggestion) {
		setAttrVal("Mr_sign_suggestion", Mr_sign_suggestion);
	}
	/**
	 * 患者
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
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
	 * 患者性别
	 * @return String
	 */
	public String getPat_sex() {
		return ((String) getAttrVal("Pat_sex"));
	}
	/**
	 * 患者性别
	 * @param Pat_sex
	 */
	public void setPat_sex(String Pat_sex) {
		setAttrVal("Pat_sex", Pat_sex);
	}
	/**
	 * 就诊
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 完成类型
	 * @return String
	 */
	public String getFinishtype() {
		return ((String) getAttrVal("Finishtype"));
	}
	/**
	 * 完成类型
	 * @param Finishtype
	 */
	public void setFinishtype(String Finishtype) {
		setAttrVal("Finishtype", Finishtype);
	}
	/**
	 * 任务类型
	 * @return String
	 */
	public String getActiontype() {
		return ((String) getAttrVal("Actiontype"));
	}
	/**
	 * 任务类型
	 * @param Actiontype
	 */
	public void setActiontype(String Actiontype) {
		setAttrVal("Actiontype", Actiontype);
	}
	/**
	 * 说明
	 * @return String
	 */
	public String getOpinion() {
		return ((String) getAttrVal("Opinion"));
	}
	/**
	 * 说明
	 * @param Opinion
	 */
	public void setOpinion(String Opinion) {
		setAttrVal("Opinion", Opinion);
	}
}