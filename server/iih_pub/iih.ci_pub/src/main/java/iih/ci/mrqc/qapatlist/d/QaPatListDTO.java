package iih.ci.mrqc.qapatlist.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 质控患者列表 DTO数据 
 * 
 */
public class QaPatListDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 环节质控标记
	 * @return FBoolean
	 */
	public FBoolean getFg_process_qa() {
		return ((FBoolean) getAttrVal("Fg_process_qa"));
	}
	/**
	 * 环节质控标记
	 * @param Fg_process_qa
	 */
	public void setFg_process_qa(FBoolean Fg_process_qa) {
		setAttrVal("Fg_process_qa", Fg_process_qa);
	}
	/**
	 * 病案号
	 * @return String
	 */
	public String getHospital_code() {
		return ((String) getAttrVal("Hospital_code"));
	}
	/**
	 * 病案号
	 * @param Hospital_code
	 */
	public void setHospital_code(String Hospital_code) {
		setAttrVal("Hospital_code", Hospital_code);
	}
	/**
	 * 床号
	 * @return String
	 */
	public String getBed_code() {
		return ((String) getAttrVal("Bed_code"));
	}
	/**
	 * 床号
	 * @param Bed_code
	 */
	public void setBed_code(String Bed_code) {
		setAttrVal("Bed_code", Bed_code);
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
	 * 性别id
	 * @return String
	 */
	public String getId_sex() {
		return ((String) getAttrVal("Id_sex"));
	}
	/**
	 * 性别id
	 * @param Id_sex
	 */
	public void setId_sex(String Id_sex) {
		setAttrVal("Id_sex", Id_sex);
	}
	/**
	 * 性别编码
	 * @return String
	 */
	public String getSd_sex() {
		return ((String) getAttrVal("Sd_sex"));
	}
	/**
	 * 性别编码
	 * @param Sd_sex
	 */
	public void setSd_sex(String Sd_sex) {
		setAttrVal("Sd_sex", Sd_sex);
	}
	/**
	 * 性别
	 * @return String
	 */
	public String getSex_name() {
		return ((String) getAttrVal("Sex_name"));
	}
	/**
	 * 性别
	 * @param Sex_name
	 */
	public void setSex_name(String Sex_name) {
		setAttrVal("Sex_name", Sex_name);
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
	 * 就诊科室编码
	 * @return String
	 */
	public String getId_dep_phy() {
		return ((String) getAttrVal("Id_dep_phy"));
	}
	/**
	 * 就诊科室编码
	 * @param Id_dep_phy
	 */
	public void setId_dep_phy(String Id_dep_phy) {
		setAttrVal("Id_dep_phy", Id_dep_phy);
	}
	/**
	 * 入院时间
	 * @return FDateTime
	 */
	public FDateTime getDt_acpt() {
		return ((FDateTime) getAttrVal("Dt_acpt"));
	}
	/**
	 * 入院时间
	 * @param Dt_acpt
	 */
	public void setDt_acpt(FDateTime Dt_acpt) {
		setAttrVal("Dt_acpt", Dt_acpt);
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
	 * 主管医师编码
	 * @return String
	 */
	public String getId_emp_phy() {
		return ((String) getAttrVal("Id_emp_phy"));
	}
	/**
	 * 主管医师编码
	 * @param Id_emp_phy
	 */
	public void setId_emp_phy(String Id_emp_phy) {
		setAttrVal("Id_emp_phy", Id_emp_phy);
	}
	/**
	 * 病危/病重
	 * @return String
	 */
	public String getId_level_dise() {
		return ((String) getAttrVal("Id_level_dise"));
	}
	/**
	 * 病危/病重
	 * @param Id_level_dise
	 */
	public void setId_level_dise(String Id_level_dise) {
		setAttrVal("Id_level_dise", Id_level_dise);
	}
	/**
	 * 缺陷数
	 * @return String
	 */
	public String getFlt_num() {
		return ((String) getAttrVal("Flt_num"));
	}
	/**
	 * 缺陷数
	 * @param Flt_num
	 */
	public void setFlt_num(String Flt_num) {
		setAttrVal("Flt_num", Flt_num);
	}
	/**
	 * 质控次数
	 * @return String
	 */
	public String getQa_num() {
		return ((String) getAttrVal("Qa_num"));
	}
	/**
	 * 质控次数
	 * @param Qa_num
	 */
	public void setQa_num(String Qa_num) {
		setAttrVal("Qa_num", Qa_num);
	}
	/**
	 * 质控医师编码
	 * @return String
	 */
	public String getId_emp_qa() {
		return ((String) getAttrVal("Id_emp_qa"));
	}
	/**
	 * 质控医师编码
	 * @param Id_emp_qa
	 */
	public void setId_emp_qa(String Id_emp_qa) {
		setAttrVal("Id_emp_qa", Id_emp_qa);
	}
	/**
	 * 出院时间
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}
	/**
	 * 出院时间
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
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
	 * 主键标识
	 * @return String
	 */
	public String getId_qapatlist() {
		return ((String) getAttrVal("Id_qapatlist"));
	}
	/**
	 * 主键标识
	 * @param Id_qapatlist
	 */
	public void setId_qapatlist(String Id_qapatlist) {
		setAttrVal("Id_qapatlist", Id_qapatlist);
	}
	/**
	 * 患者编码
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者编码
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 就诊科室
	 * @return String
	 */
	public String getDep_phy_name() {
		return ((String) getAttrVal("Dep_phy_name"));
	}
	/**
	 * 就诊科室
	 * @param Dep_phy_name
	 */
	public void setDep_phy_name(String Dep_phy_name) {
		setAttrVal("Dep_phy_name", Dep_phy_name);
	}
	/**
	 * 主管医师
	 * @return String
	 */
	public String getEmp_phy_name() {
		return ((String) getAttrVal("Emp_phy_name"));
	}
	/**
	 * 主管医师
	 * @param Emp_phy_name
	 */
	public void setEmp_phy_name(String Emp_phy_name) {
		setAttrVal("Emp_phy_name", Emp_phy_name);
	}
	/**
	 * 质控医师
	 * @return String
	 */
	public String getEmp_qa_name() {
		return ((String) getAttrVal("Emp_qa_name"));
	}
	/**
	 * 质控医师
	 * @param Emp_qa_name
	 */
	public void setEmp_qa_name(String Emp_qa_name) {
		setAttrVal("Emp_qa_name", Emp_qa_name);
	}
	/**
	 * 终末质控标志
	 * @return FBoolean
	 */
	public FBoolean getFg_terminal_qa() {
		return ((FBoolean) getAttrVal("Fg_terminal_qa"));
	}
	/**
	 * 终末质控标志
	 * @param Fg_terminal_qa
	 */
	public void setFg_terminal_qa(FBoolean Fg_terminal_qa) {
		setAttrVal("Fg_terminal_qa", Fg_terminal_qa);
	}
	/**
	 * 科室质控标志
	 * @return FBoolean
	 */
	public FBoolean getFg_dept_qa() {
		return ((FBoolean) getAttrVal("Fg_dept_qa"));
	}
	/**
	 * 科室质控标志
	 * @param Fg_dept_qa
	 */
	public void setFg_dept_qa(FBoolean Fg_dept_qa) {
		setAttrVal("Fg_dept_qa", Fg_dept_qa);
	}
	/**
	 * 医生部分病案状态
	 * @return String
	 */
	public String getId_qa_doctor_part_sta() {
		return ((String) getAttrVal("Id_qa_doctor_part_sta"));
	}
	/**
	 * 医生部分病案状态
	 * @param Id_qa_doctor_part_sta
	 */
	public void setId_qa_doctor_part_sta(String Id_qa_doctor_part_sta) {
		setAttrVal("Id_qa_doctor_part_sta", Id_qa_doctor_part_sta);
	}
	/**
	 * 医生部分病案状态编码
	 * @return String
	 */
	public String getSd_qa_doctor_part_sta() {
		return ((String) getAttrVal("Sd_qa_doctor_part_sta"));
	}
	/**
	 * 医生部分病案状态编码
	 * @param Sd_qa_doctor_part_sta
	 */
	public void setSd_qa_doctor_part_sta(String Sd_qa_doctor_part_sta) {
		setAttrVal("Sd_qa_doctor_part_sta", Sd_qa_doctor_part_sta);
	}
	/**
	 * 病案主键
	 * @return String
	 */
	public String getId_amr() {
		return ((String) getAttrVal("Id_amr"));
	}
	/**
	 * 病案主键
	 * @param Id_amr
	 */
	public void setId_amr(String Id_amr) {
		setAttrVal("Id_amr", Id_amr);
	}
	/**
	 * 缺陷主键标识
	 * @return String
	 */
	public String getId_qaflt() {
		return ((String) getAttrVal("Id_qaflt"));
	}
	/**
	 * 缺陷主键标识
	 * @param Id_qaflt
	 */
	public void setId_qaflt(String Id_qaflt) {
		setAttrVal("Id_qaflt", Id_qaflt);
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
	 * @return String
	 */
	public String getDeduct_scr_times() {
		return ((String) getAttrVal("Deduct_scr_times"));
	}
	/**
	 * 缺陷扣分次数
	 * @param Deduct_scr_times
	 */
	public void setDeduct_scr_times(String Deduct_scr_times) {
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
	 * 科室质控打回原因
	 * @return String
	 */
	public String getReason_deptqc_back() {
		return ((String) getAttrVal("Reason_deptqc_back"));
	}
	/**
	 * 科室质控打回原因
	 * @param Reason_deptqc_back
	 */
	public void setReason_deptqc_back(String Reason_deptqc_back) {
		setAttrVal("Reason_deptqc_back", Reason_deptqc_back);
	}
	/**
	 * 终末质控打回原因
	 * @return String
	 */
	public String getReason_terminaltqc_back() {
		return ((String) getAttrVal("Reason_terminaltqc_back"));
	}
	/**
	 * 终末质控打回原因
	 * @param Reason_terminaltqc_back
	 */
	public void setReason_terminaltqc_back(String Reason_terminaltqc_back) {
		setAttrVal("Reason_terminaltqc_back", Reason_terminaltqc_back);
	}
	/**
	 * 患者缺陷数
	 * @return Integer
	 */
	public Integer getFlt_times() {
		return ((Integer) getAttrVal("Flt_times"));
	}
	/**
	 * 患者缺陷数
	 * @param Flt_times
	 */
	public void setFlt_times(Integer Flt_times) {
		setAttrVal("Flt_times", Flt_times);
	}
	/**
	 * 出生日期
	 * @return FDate
	 */
	public FDate getDt_birth_pat() {
		return ((FDate) getAttrVal("Dt_birth_pat"));
	}
	/**
	 * 出生日期
	 * @param Dt_birth_pat
	 */
	public void setDt_birth_pat(FDate Dt_birth_pat) {
		setAttrVal("Dt_birth_pat", Dt_birth_pat);
	}
	/**
	 * 出院科室id
	 * @return String
	 */
	public String getId_dep_phydisc() {
		return ((String) getAttrVal("Id_dep_phydisc"));
	}
	/**
	 * 出院科室id
	 * @param Id_dep_phydisc
	 */
	public void setId_dep_phydisc(String Id_dep_phydisc) {
		setAttrVal("Id_dep_phydisc", Id_dep_phydisc);
	}
	/**
	 * 出院科室
	 * @return String
	 */
	public String getDep_phydisc() {
		return ((String) getAttrVal("Dep_phydisc"));
	}
	/**
	 * 出院科室
	 * @param Dep_phydisc
	 */
	public void setDep_phydisc(String Dep_phydisc) {
		setAttrVal("Dep_phydisc", Dep_phydisc);
	}
	/**
	 * 病案打回原因
	 * @return String
	 */
	public String getReason_amr_back() {
		return ((String) getAttrVal("Reason_amr_back"));
	}
	/**
	 * 病案打回原因
	 * @param Reason_amr_back
	 */
	public void setReason_amr_back(String Reason_amr_back) {
		setAttrVal("Reason_amr_back", Reason_amr_back);
	}
	/**
	 * 病案打回标志
	 * @return FBoolean
	 */
	public FBoolean getFg_amr_callback() {
		return ((FBoolean) getAttrVal("Fg_amr_callback"));
	}
	/**
	 * 病案打回标志
	 * @param Fg_amr_callback
	 */
	public void setFg_amr_callback(FBoolean Fg_amr_callback) {
		setAttrVal("Fg_amr_callback", Fg_amr_callback);
	}
	/**
	 * 签收人id
	 * @return String
	 */
	public String getId_user_signoff() {
		return ((String) getAttrVal("Id_user_signoff"));
	}
	/**
	 * 签收人id
	 * @param Id_user_signoff
	 */
	public void setId_user_signoff(String Id_user_signoff) {
		setAttrVal("Id_user_signoff", Id_user_signoff);
	}
	/**
	 * 签收科室id
	 * @return String
	 */
	public String getId_dep_signoff() {
		return ((String) getAttrVal("Id_dep_signoff"));
	}
	/**
	 * 签收科室id
	 * @param Id_dep_signoff
	 */
	public void setId_dep_signoff(String Id_dep_signoff) {
		setAttrVal("Id_dep_signoff", Id_dep_signoff);
	}
	/**
	 * 签收时间
	 * @return FDateTime
	 */
	public FDateTime getDt_signoff() {
		return ((FDateTime) getAttrVal("Dt_signoff"));
	}
	/**
	 * 签收时间
	 * @param Dt_signoff
	 */
	public void setDt_signoff(FDateTime Dt_signoff) {
		setAttrVal("Dt_signoff", Dt_signoff);
	}
	/**
	 * 编目人id
	 * @return String
	 */
	public String getId_user_catalogue() {
		return ((String) getAttrVal("Id_user_catalogue"));
	}
	/**
	 * 编目人id
	 * @param Id_user_catalogue
	 */
	public void setId_user_catalogue(String Id_user_catalogue) {
		setAttrVal("Id_user_catalogue", Id_user_catalogue);
	}
	/**
	 * 编目科室id
	 * @return String
	 */
	public String getId_dep_catalogue() {
		return ((String) getAttrVal("Id_dep_catalogue"));
	}
	/**
	 * 编目科室id
	 * @param Id_dep_catalogue
	 */
	public void setId_dep_catalogue(String Id_dep_catalogue) {
		setAttrVal("Id_dep_catalogue", Id_dep_catalogue);
	}
	/**
	 * 编目时间
	 * @return FDateTime
	 */
	public FDateTime getDt_catalogue() {
		return ((FDateTime) getAttrVal("Dt_catalogue"));
	}
	/**
	 * 编目时间
	 * @param Dt_catalogue
	 */
	public void setDt_catalogue(FDateTime Dt_catalogue) {
		setAttrVal("Dt_catalogue", Dt_catalogue);
	}
	/**
	 * 归档人id
	 * @return String
	 */
	public String getId_user_pigeonhole() {
		return ((String) getAttrVal("Id_user_pigeonhole"));
	}
	/**
	 * 归档人id
	 * @param Id_user_pigeonhole
	 */
	public void setId_user_pigeonhole(String Id_user_pigeonhole) {
		setAttrVal("Id_user_pigeonhole", Id_user_pigeonhole);
	}
	/**
	 * 归档科室id
	 * @return String
	 */
	public String getId_dep_pigeonhole() {
		return ((String) getAttrVal("Id_dep_pigeonhole"));
	}
	/**
	 * 归档科室id
	 * @param Id_dep_pigeonhole
	 */
	public void setId_dep_pigeonhole(String Id_dep_pigeonhole) {
		setAttrVal("Id_dep_pigeonhole", Id_dep_pigeonhole);
	}
	/**
	 * 归档时间
	 * @return FDateTime
	 */
	public FDateTime getDt_pigeonhole() {
		return ((FDateTime) getAttrVal("Dt_pigeonhole"));
	}
	/**
	 * 归档时间
	 * @param Dt_pigeonhole
	 */
	public void setDt_pigeonhole(FDateTime Dt_pigeonhole) {
		setAttrVal("Dt_pigeonhole", Dt_pigeonhole);
	}
	/**
	 * 签收人
	 * @return String
	 */
	public String getUser_signoff() {
		return ((String) getAttrVal("User_signoff"));
	}
	/**
	 * 签收人
	 * @param User_signoff
	 */
	public void setUser_signoff(String User_signoff) {
		setAttrVal("User_signoff", User_signoff);
	}
	/**
	 * 签收科室
	 * @return String
	 */
	public String getDep_signoff() {
		return ((String) getAttrVal("Dep_signoff"));
	}
	/**
	 * 签收科室
	 * @param Dep_signoff
	 */
	public void setDep_signoff(String Dep_signoff) {
		setAttrVal("Dep_signoff", Dep_signoff);
	}
	/**
	 * 编目人
	 * @return String
	 */
	public String getUser_catalogue() {
		return ((String) getAttrVal("User_catalogue"));
	}
	/**
	 * 编目人
	 * @param User_catalogue
	 */
	public void setUser_catalogue(String User_catalogue) {
		setAttrVal("User_catalogue", User_catalogue);
	}
	/**
	 * 编目科室
	 * @return String
	 */
	public String getDep_catalogue() {
		return ((String) getAttrVal("Dep_catalogue"));
	}
	/**
	 * 编目科室
	 * @param Dep_catalogue
	 */
	public void setDep_catalogue(String Dep_catalogue) {
		setAttrVal("Dep_catalogue", Dep_catalogue);
	}
	/**
	 * 归档人
	 * @return String
	 */
	public String getUser_pigeonhole() {
		return ((String) getAttrVal("User_pigeonhole"));
	}
	/**
	 * 归档人
	 * @param User_pigeonhole
	 */
	public void setUser_pigeonhole(String User_pigeonhole) {
		setAttrVal("User_pigeonhole", User_pigeonhole);
	}
	/**
	 * 归档科室
	 * @return String
	 */
	public String getDep_pigeonhole() {
		return ((String) getAttrVal("Dep_pigeonhole"));
	}
	/**
	 * 归档科室
	 * @param Dep_pigeonhole
	 */
	public void setDep_pigeonhole(String Dep_pigeonhole) {
		setAttrVal("Dep_pigeonhole", Dep_pigeonhole);
	}
	/**
	 * 住院病案编号
	 * @return String
	 */
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}
	/**
	 * 住院病案编号
	 * @param Code_amr_ip
	 */
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
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