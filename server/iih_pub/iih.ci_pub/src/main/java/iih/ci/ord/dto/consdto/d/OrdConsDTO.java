package iih.ci.ord.dto.consdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 会诊列表 DTO数据 
 * 
 */
public class OrdConsDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 加急
	 * @return String
	 */
	public String getUrgent() {
		return ((String) getAttrVal("Urgent"));
	}
	/**
	 * 加急
	 * @param Urgent
	 */
	public void setUrgent(String Urgent) {
		setAttrVal("Urgent", Urgent);
	}
	/**
	 * 计划会诊时间
	 * @return FDateTime
	 */
	public FDateTime getDt_plan() {
		return ((FDateTime) getAttrVal("Dt_plan"));
	}
	/**
	 * 计划会诊时间
	 * @param Dt_plan
	 */
	public void setDt_plan(FDateTime Dt_plan) {
		setAttrVal("Dt_plan", Dt_plan);
	}
	/**
	 * 会诊申请状态
	 * @return String
	 */
	public String getName_su_cons() {
		return ((String) getAttrVal("Name_su_cons"));
	}
	/**
	 * 会诊申请状态
	 * @param Name_su_cons
	 */
	public void setName_su_cons(String Name_su_cons) {
		setAttrVal("Name_su_cons", Name_su_cons);
	}
	/**
	 * 会诊医生
	 * @return String
	 */
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}
	/**
	 * 会诊医生
	 * @param Id_emp
	 */
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	/**
	 * 申请科室
	 * @return String
	 */
	public String getName_dep_or() {
		return ((String) getAttrVal("Name_dep_or"));
	}
	/**
	 * 申请科室
	 * @param Name_dep_or
	 */
	public void setName_dep_or(String Name_dep_or) {
		setAttrVal("Name_dep_or", Name_dep_or);
	}
	/**
	 * 审批通过标志
	 * @return FBoolean
	 */
	public FBoolean getFg_audit() {
		return ((FBoolean) getAttrVal("Fg_audit"));
	}
	/**
	 * 审批通过标志
	 * @param Fg_audit
	 */
	public void setFg_audit(FBoolean Fg_audit) {
		setAttrVal("Fg_audit", Fg_audit);
	}
	/**
	 * 审批意见
	 * @return String
	 */
	public String getDes_review() {
		return ((String) getAttrVal("Des_review"));
	}
	/**
	 * 审批意见
	 * @param Des_review
	 */
	public void setDes_review(String Des_review) {
		setAttrVal("Des_review", Des_review);
	}
	/**
	 * 会诊医生姓名
	 * @return String
	 */
	public String getEmp_name() {
		return ((String) getAttrVal("Emp_name"));
	}
	/**
	 * 会诊医生姓名
	 * @param Emp_name
	 */
	public void setEmp_name(String Emp_name) {
		setAttrVal("Emp_name", Emp_name);
	}
	/**
	 * 患者
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 患者
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 患者床号
	 * @return String
	 */
	public String getPat_bedno() {
		return ((String) getAttrVal("Pat_bedno"));
	}
	/**
	 * 患者床号
	 * @param Pat_bedno
	 */
	public void setPat_bedno(String Pat_bedno) {
		setAttrVal("Pat_bedno", Pat_bedno);
	}
	/**
	 * 申请类型
	 * @return String
	 */
	public String getName_constp() {
		return ((String) getAttrVal("Name_constp"));
	}
	/**
	 * 申请类型
	 * @param Name_constp
	 */
	public void setName_constp(String Name_constp) {
		setAttrVal("Name_constp", Name_constp);
	}
	/**
	 * 主键
	 * @return String
	 */
	public String getId_apcons() {
		return ((String) getAttrVal("Id_apcons"));
	}
	/**
	 * 主键
	 * @param Id_apcons
	 */
	public void setId_apcons(String Id_apcons) {
		setAttrVal("Id_apcons", Id_apcons);
	}
	/**
	 * 审批状态
	 * @return String
	 */
	public String getName_reviewtp() {
		return ((String) getAttrVal("Name_reviewtp"));
	}
	/**
	 * 审批状态
	 * @param Name_reviewtp
	 */
	public void setName_reviewtp(String Name_reviewtp) {
		setAttrVal("Name_reviewtp", Name_reviewtp);
	}
	/**
	 * 就诊号
	 * @return String
	 */
	public String getId_en() {
		return ((String) getAttrVal("Id_en"));
	}
	/**
	 * 就诊号
	 * @param Id_en
	 */
	public void setId_en(String Id_en) {
		setAttrVal("Id_en", Id_en);
	}
	/**
	 * 加急标识
	 * @return FBoolean
	 */
	public FBoolean getFg_urgent() {
		return ((FBoolean) getAttrVal("Fg_urgent"));
	}
	/**
	 * 加急标识
	 * @param Fg_urgent
	 */
	public void setFg_urgent(FBoolean Fg_urgent) {
		setAttrVal("Fg_urgent", Fg_urgent);
	}
	/**
	 * 是否院内会诊
	 * @return FBoolean
	 */
	public FBoolean getFg_inorg() {
		return ((FBoolean) getAttrVal("Fg_inorg"));
	}
	/**
	 * 是否院内会诊
	 * @param Fg_inorg
	 */
	public void setFg_inorg(FBoolean Fg_inorg) {
		setAttrVal("Fg_inorg", Fg_inorg);
	}
	/**
	 * 会诊申请状态编码
	 * @return String
	 */
	public String getSd_su_cons() {
		return ((String) getAttrVal("Sd_su_cons"));
	}
	/**
	 * 会诊申请状态编码
	 * @param Sd_su_cons
	 */
	public void setSd_su_cons(String Sd_su_cons) {
		setAttrVal("Sd_su_cons", Sd_su_cons);
	}
	/**
	 * 就诊编码
	 * @return String
	 */
	public String getCode_en() {
		return ((String) getAttrVal("Code_en"));
	}
	/**
	 * 就诊编码
	 * @param Code_en
	 */
	public void setCode_en(String Code_en) {
		setAttrVal("Code_en", Code_en);
	}
	/**
	 * 受邀医生是否职称限制
	 * @return FBoolean
	 */
	public FBoolean getFg_emptitlelimit() {
		return ((FBoolean) getAttrVal("Fg_emptitlelimit"));
	}
	/**
	 * 受邀医生是否职称限制
	 * @param Fg_emptitlelimit
	 */
	public void setFg_emptitlelimit(FBoolean Fg_emptitlelimit) {
		setAttrVal("Fg_emptitlelimit", Fg_emptitlelimit);
	}
	/**
	 * 受邀医生最低职称
	 * @return String
	 */
	public String getId_emptitle() {
		return ((String) getAttrVal("Id_emptitle"));
	}
	/**
	 * 受邀医生最低职称
	 * @param Id_emptitle
	 */
	public void setId_emptitle(String Id_emptitle) {
		setAttrVal("Id_emptitle", Id_emptitle);
	}
	/**
	 * 受邀医生最低职称编码
	 * @return String
	 */
	public String getSd_emptitle() {
		return ((String) getAttrVal("Sd_emptitle"));
	}
	/**
	 * 受邀医生最低职称编码
	 * @param Sd_emptitle
	 */
	public void setSd_emptitle(String Sd_emptitle) {
		setAttrVal("Sd_emptitle", Sd_emptitle);
	}
}