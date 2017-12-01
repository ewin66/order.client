package iih.ci.mrqc.qaflt.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 质控缺陷DTO DTO数据 
 * 
 */
public class QaFltDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 缺陷状态id
	 * @return String
	 */
	public String getId_flt_sta() {
		return ((String) getAttrVal("Id_flt_sta"));
	}
	/**
	 * 缺陷状态id
	 * @param Id_flt_sta
	 */
	public void setId_flt_sta(String Id_flt_sta) {
		setAttrVal("Id_flt_sta", Id_flt_sta);
	}
	/**
	 * 病历文书
	 * @return String
	 */
	public String getId_mr_name() {
		return ((String) getAttrVal("Id_mr_name"));
	}
	/**
	 * 病历文书
	 * @param Id_mr_name
	 */
	public void setId_mr_name(String Id_mr_name) {
		setAttrVal("Id_mr_name", Id_mr_name);
	}
	/**
	 * 缺陷描述
	 * @return String
	 */
	public String getRes() {
		return ((String) getAttrVal("Res"));
	}
	/**
	 * 缺陷描述
	 * @param Res
	 */
	public void setRes(String Res) {
		setAttrVal("Res", Res);
	}
	/**
	 * 扣分标准
	 * @return String
	 */
	public String getDeduct_des() {
		return ((String) getAttrVal("Deduct_des"));
	}
	/**
	 * 扣分标准
	 * @param Deduct_des
	 */
	public void setDeduct_des(String Deduct_des) {
		setAttrVal("Deduct_des", Deduct_des);
	}
	/**
	 * 缺陷扣分次数
	 * @return Integer
	 */
	public Integer getDeduct_scr_times() {
		return ((Integer) getAttrVal("Deduct_scr_times"));
	}
	/**
	 * 缺陷扣分次数
	 * @param Deduct_scr_times
	 */
	public void setDeduct_scr_times(Integer Deduct_scr_times) {
		setAttrVal("Deduct_scr_times", Deduct_scr_times);
	}
	/**
	 * 提出日期
	 * @return FDateTime
	 */
	public FDateTime getDt_sbmt() {
		return ((FDateTime) getAttrVal("Dt_sbmt"));
	}
	/**
	 * 提出日期
	 * @param Dt_sbmt
	 */
	public void setDt_sbmt(FDateTime Dt_sbmt) {
		setAttrVal("Dt_sbmt", Dt_sbmt);
	}
	/**
	 * 提出人id
	 * @return String
	 */
	public String getId_sbmt_user() {
		return ((String) getAttrVal("Id_sbmt_user"));
	}
	/**
	 * 提出人id
	 * @param Id_sbmt_user
	 */
	public void setId_sbmt_user(String Id_sbmt_user) {
		setAttrVal("Id_sbmt_user", Id_sbmt_user);
	}
	/**
	 * 整改说明
	 * @return String
	 */
	public String getRfm_req() {
		return ((String) getAttrVal("Rfm_req"));
	}
	/**
	 * 整改说明
	 * @param Rfm_req
	 */
	public void setRfm_req(String Rfm_req) {
		setAttrVal("Rfm_req", Rfm_req);
	}
	/**
	 * 整改人id
	 * @return String
	 */
	public String getId_treat_doctor() {
		return ((String) getAttrVal("Id_treat_doctor"));
	}
	/**
	 * 整改人id
	 * @param Id_treat_doctor
	 */
	public void setId_treat_doctor(String Id_treat_doctor) {
		setAttrVal("Id_treat_doctor", Id_treat_doctor);
	}
	/**
	 * 整改科室id
	 * @return String
	 */
	public String getId_dep_pat() {
		return ((String) getAttrVal("Id_dep_pat"));
	}
	/**
	 * 整改科室id
	 * @param Id_dep_pat
	 */
	public void setId_dep_pat(String Id_dep_pat) {
		setAttrVal("Id_dep_pat", Id_dep_pat);
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
	 * 主键标识
	 * @return String
	 */
	public String getId_qaflt() {
		return ((String) getAttrVal("Id_qaflt"));
	}
	/**
	 * 主键标识
	 * @param Id_qaflt
	 */
	public void setId_qaflt(String Id_qaflt) {
		setAttrVal("Id_qaflt", Id_qaflt);
	}
	/**
	 * 缺陷状态编码
	 * @return String
	 */
	public String getSd_flt_sta() {
		return ((String) getAttrVal("Sd_flt_sta"));
	}
	/**
	 * 缺陷状态编码
	 * @param Sd_flt_sta
	 */
	public void setSd_flt_sta(String Sd_flt_sta) {
		setAttrVal("Sd_flt_sta", Sd_flt_sta);
	}
	/**
	 * 提出人
	 * @return String
	 */
	public String getSbmt_user_name() {
		return ((String) getAttrVal("Sbmt_user_name"));
	}
	/**
	 * 提出人
	 * @param Sbmt_user_name
	 */
	public void setSbmt_user_name(String Sbmt_user_name) {
		setAttrVal("Sbmt_user_name", Sbmt_user_name);
	}
	/**
	 * 整改人
	 * @return String
	 */
	public String getTreat_doctor_name() {
		return ((String) getAttrVal("Treat_doctor_name"));
	}
	/**
	 * 整改人
	 * @param Treat_doctor_name
	 */
	public void setTreat_doctor_name(String Treat_doctor_name) {
		setAttrVal("Treat_doctor_name", Treat_doctor_name);
	}
	/**
	 * 整改科室
	 * @return String
	 */
	public String getDep_pat() {
		return ((String) getAttrVal("Dep_pat"));
	}
	/**
	 * 整改科室
	 * @param Dep_pat
	 */
	public void setDep_pat(String Dep_pat) {
		setAttrVal("Dep_pat", Dep_pat);
	}
	/**
	 * 缺陷状态
	 * @return String
	 */
	public String getFlt_sta_name() {
		return ((String) getAttrVal("Flt_sta_name"));
	}
	/**
	 * 缺陷状态
	 * @param Flt_sta_name
	 */
	public void setFlt_sta_name(String Flt_sta_name) {
		setAttrVal("Flt_sta_name", Flt_sta_name);
	}
	/**
	 * 缺陷id
	 * @return String
	 */
	public String getId_qa_flt() {
		return ((String) getAttrVal("Id_qa_flt"));
	}
	/**
	 * 缺陷id
	 * @param Id_qa_flt
	 */
	public void setId_qa_flt(String Id_qa_flt) {
		setAttrVal("Id_qa_flt", Id_qa_flt);
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
	 * 病历文书id
	 * @return String
	 */
	public String getId_mr() {
		return ((String) getAttrVal("Id_mr"));
	}
	/**
	 * 病历文书id
	 * @param Id_mr
	 */
	public void setId_mr(String Id_mr) {
		setAttrVal("Id_mr", Id_mr);
	}
	/**
	 * 接收人id
	 * @return String
	 */
	public String getId_emp_submit() {
		return ((String) getAttrVal("Id_emp_submit"));
	}
	/**
	 * 接收人id
	 * @param Id_emp_submit
	 */
	public void setId_emp_submit(String Id_emp_submit) {
		setAttrVal("Id_emp_submit", Id_emp_submit);
	}
	/**
	 * 接收人
	 * @return String
	 */
	public String getEmp_submit_name() {
		return ((String) getAttrVal("Emp_submit_name"));
	}
	/**
	 * 接收人
	 * @param Emp_submit_name
	 */
	public void setEmp_submit_name(String Emp_submit_name) {
		setAttrVal("Emp_submit_name", Emp_submit_name);
	}
	/**
	 * 接受科室id
	 * @return String
	 */
	public String getId_submit_dept() {
		return ((String) getAttrVal("Id_submit_dept"));
	}
	/**
	 * 接受科室id
	 * @param Id_submit_dept
	 */
	public void setId_submit_dept(String Id_submit_dept) {
		setAttrVal("Id_submit_dept", Id_submit_dept);
	}
	/**
	 * 接受科室
	 * @return String
	 */
	public String getSubmit_dept_name() {
		return ((String) getAttrVal("Submit_dept_name"));
	}
	/**
	 * 接受科室
	 * @param Submit_dept_name
	 */
	public void setSubmit_dept_name(String Submit_dept_name) {
		setAttrVal("Submit_dept_name", Submit_dept_name);
	}
	/**
	 * 质控扣分类型
	 * @return String
	 */
	public String getId_qa_drp_scr_tp() {
		return ((String) getAttrVal("Id_qa_drp_scr_tp"));
	}
	/**
	 * 质控扣分类型
	 * @param Id_qa_drp_scr_tp
	 */
	public void setId_qa_drp_scr_tp(String Id_qa_drp_scr_tp) {
		setAttrVal("Id_qa_drp_scr_tp", Id_qa_drp_scr_tp);
	}
	/**
	 * 单次扣分值
	 * @return FDouble
	 */
	public FDouble getOnce_drp_scr() {
		return ((FDouble) getAttrVal("Once_drp_scr"));
	}
	/**
	 * 单次扣分值
	 * @param Once_drp_scr
	 */
	public void setOnce_drp_scr(FDouble Once_drp_scr) {
		setAttrVal("Once_drp_scr", Once_drp_scr);
	}
	/**
	 * 最大扣分值
	 * @return FDouble
	 */
	public FDouble getMax_drp_scr() {
		return ((FDouble) getAttrVal("Max_drp_scr"));
	}
	/**
	 * 最大扣分值
	 * @param Max_drp_scr
	 */
	public void setMax_drp_scr(FDouble Max_drp_scr) {
		setAttrVal("Max_drp_scr", Max_drp_scr);
	}
	/**
	 * 质控项主键
	 * @return String
	 */
	public String getId_qa_itm() {
		return ((String) getAttrVal("Id_qa_itm"));
	}
	/**
	 * 质控项主键
	 * @param Id_qa_itm
	 */
	public void setId_qa_itm(String Id_qa_itm) {
		setAttrVal("Id_qa_itm", Id_qa_itm);
	}
	/**
	 * 一级分类最大分值(一级分类表)
	 * @return FDouble
	 */
	public FDouble getScore_fstmax() {
		return ((FDouble) getAttrVal("Score_fstmax"));
	}
	/**
	 * 一级分类最大分值(一级分类表)
	 * @param Score_fstmax
	 */
	public void setScore_fstmax(FDouble Score_fstmax) {
		setAttrVal("Score_fstmax", Score_fstmax);
	}
	/**
	 * 一级分类名称(一级分类表)
	 * @return String
	 */
	public String getFst_name() {
		return ((String) getAttrVal("Fst_name"));
	}
	/**
	 * 一级分类名称(一级分类表)
	 * @param Fst_name
	 */
	public void setFst_name(String Fst_name) {
		setAttrVal("Fst_name", Fst_name);
	}
	/**
	 * 一级分类id
	 * @return String
	 */
	public String getId_fst() {
		return ((String) getAttrVal("Id_fst"));
	}
	/**
	 * 一级分类id
	 * @param Id_fst
	 */
	public void setId_fst(String Id_fst) {
		setAttrVal("Id_fst", Id_fst);
	}
}