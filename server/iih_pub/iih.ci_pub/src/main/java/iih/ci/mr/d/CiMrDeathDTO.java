package iih.ci.mr.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;

/**
 * 死亡信息 DTO数据 
 * 
 */
public class CiMrDeathDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 文档的操作版本
	 * @return String
	 */
	public String getDoc_version() {
		return ((String) getAttrVal("Doc_version"));
	}
	/**
	 * 文档的操作版本
	 * @param Doc_version
	 */
	public void setDoc_version(String Doc_version) {
		setAttrVal("Doc_version", Doc_version);
	}
	/**
	 * 接口服务ID
	 * @return String
	 */
	public String getId_interface() {
		return ((String) getAttrVal("Id_interface"));
	}
	/**
	 * 接口服务ID
	 * @param Id_interface
	 */
	public void setId_interface(String Id_interface) {
		setAttrVal("Id_interface", Id_interface);
	}
	/**
	 * 电子签章号
	 * @return String
	 */
	public String getSign_no() {
		return ((String) getAttrVal("Sign_no"));
	}
	/**
	 * 电子签章号
	 * @param Sign_no
	 */
	public void setSign_no(String Sign_no) {
		setAttrVal("Sign_no", Sign_no);
	}
	/**
	 * 文档标示ID
	 * @return String
	 */
	public String getId_doc() {
		return ((String) getAttrVal("Id_doc"));
	}
	/**
	 * 文档标示ID
	 * @param Id_doc
	 */
	public void setId_doc(String Id_doc) {
		setAttrVal("Id_doc", Id_doc);
	}
	/**
	 * 文档标题
	 * @return String
	 */
	public String getDoc_title() {
		return ((String) getAttrVal("Doc_title"));
	}
	/**
	 * 文档标题
	 * @param Doc_title
	 */
	public void setDoc_title(String Doc_title) {
		setAttrVal("Doc_title", Doc_title);
	}
	/**
	 * 域ID
	 * @return String
	 */
	public String getId_moudle() {
		return ((String) getAttrVal("Id_moudle"));
	}
	/**
	 * 域ID
	 * @param Id_moudle
	 */
	public void setId_moudle(String Id_moudle) {
		setAttrVal("Id_moudle", Id_moudle);
	}
	/**
	 * 患者ID
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者ID
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 就诊号
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊号
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 就诊次数
	 * @return String
	 */
	public String getCount_ent() {
		return ((String) getAttrVal("Count_ent"));
	}
	/**
	 * 就诊次数
	 * @param Count_ent
	 */
	public void setCount_ent(String Count_ent) {
		setAttrVal("Count_ent", Count_ent);
	}
	/**
	 * 就诊类别编码
	 * @return String
	 */
	public String getId_entp() {
		return ((String) getAttrVal("Id_entp"));
	}
	/**
	 * 就诊类别编码
	 * @param Id_entp
	 */
	public void setId_entp(String Id_entp) {
		setAttrVal("Id_entp", Id_entp);
	}
	/**
	 * 就诊类别名称
	 * @return String
	 */
	public String getName_entp() {
		return ((String) getAttrVal("Name_entp"));
	}
	/**
	 * 就诊类别名称
	 * @param Name_entp
	 */
	public void setName_entp(String Name_entp) {
		setAttrVal("Name_entp", Name_entp);
	}
	/**
	 * 病人名称
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 病人名称
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 患者年龄
	 * @return String
	 */
	public String getAge_pat() {
		return ((String) getAttrVal("Age_pat"));
	}
	/**
	 * 患者年龄
	 * @param Age_pat
	 */
	public void setAge_pat(String Age_pat) {
		setAttrVal("Age_pat", Age_pat);
	}
	/**
	 * 性别编码
	 * @return String
	 */
	public String getId_sex() {
		return ((String) getAttrVal("Id_sex"));
	}
	/**
	 * 性别编码
	 * @param Id_sex
	 */
	public void setId_sex(String Id_sex) {
		setAttrVal("Id_sex", Id_sex);
	}
	/**
	 * 性别名称
	 * @return String
	 */
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}
	/**
	 * 性别名称
	 * @param Name_sex
	 */
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
	}
	/**
	 * 出生日期
	 * @return FDateTime
	 */
	public FDateTime getBirth_date() {
		return ((FDateTime) getAttrVal("Birth_date"));
	}
	/**
	 * 出生日期
	 * @param Birth_date
	 */
	public void setBirth_date(FDateTime Birth_date) {
		setAttrVal("Birth_date", Birth_date);
	}
	/**
	 * 病人科室编码
	 * @return String
	 */
	public String getId_dept() {
		return ((String) getAttrVal("Id_dept"));
	}
	/**
	 * 病人科室编码
	 * @param Id_dept
	 */
	public void setId_dept(String Id_dept) {
		setAttrVal("Id_dept", Id_dept);
	}
	/**
	 * 病人科室名称
	 * @return String
	 */
	public String getName_dept() {
		return ((String) getAttrVal("Name_dept"));
	}
	/**
	 * 病人科室名称
	 * @param Name_dept
	 */
	public void setName_dept(String Name_dept) {
		setAttrVal("Name_dept", Name_dept);
	}
	/**
	 * 病区名称
	 * @return String
	 */
	public String getName_lession() {
		return ((String) getAttrVal("Name_lession"));
	}
	/**
	 * 病区名称
	 * @param Name_lession
	 */
	public void setName_lession(String Name_lession) {
		setAttrVal("Name_lession", Name_lession);
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
	 * 记录时间
	 * @return FDateTime
	 */
	public FDateTime getRecord_date() {
		return ((FDateTime) getAttrVal("Record_date"));
	}
	/**
	 * 记录时间
	 * @param Record_date
	 */
	public void setRecord_date(FDateTime Record_date) {
		setAttrVal("Record_date", Record_date);
	}
	/**
	 * 医生编码
	 * @return String
	 */
	public String getId_doctor() {
		return ((String) getAttrVal("Id_doctor"));
	}
	/**
	 * 医生编码
	 * @param Id_doctor
	 */
	public void setId_doctor(String Id_doctor) {
		setAttrVal("Id_doctor", Id_doctor);
	}
	/**
	 * 医生名称
	 * @return String
	 */
	public String getName_doctor() {
		return ((String) getAttrVal("Name_doctor"));
	}
	/**
	 * 医生名称
	 * @param Name_doctor
	 */
	public void setName_doctor(String Name_doctor) {
		setAttrVal("Name_doctor", Name_doctor);
	}
	/**
	 * 医疗机构编码
	 * @return String
	 */
	public String getId_hospital() {
		return ((String) getAttrVal("Id_hospital"));
	}
	/**
	 * 医疗机构编码
	 * @param Id_hospital
	 */
	public void setId_hospital(String Id_hospital) {
		setAttrVal("Id_hospital", Id_hospital);
	}
	/**
	 * 医疗机构名称
	 * @return String
	 */
	public String getName_hospital() {
		return ((String) getAttrVal("Name_hospital"));
	}
	/**
	 * 医疗机构名称
	 * @param Name_hospital
	 */
	public void setName_hospital(String Name_hospital) {
		setAttrVal("Name_hospital", Name_hospital);
	}
	/**
	 * 修改日期
	 * @return FDateTime
	 */
	public FDateTime getModify_date() {
		return ((FDateTime) getAttrVal("Modify_date"));
	}
	/**
	 * 修改日期
	 * @param Modify_date
	 */
	public void setModify_date(FDateTime Modify_date) {
		setAttrVal("Modify_date", Modify_date);
	}
	/**
	 * 修改医生编码
	 * @return String
	 */
	public String getId_modify_doctor() {
		return ((String) getAttrVal("Id_modify_doctor"));
	}
	/**
	 * 修改医生编码
	 * @param Id_modify_doctor
	 */
	public void setId_modify_doctor(String Id_modify_doctor) {
		setAttrVal("Id_modify_doctor", Id_modify_doctor);
	}
	/**
	 * 修改医生名称
	 * @return String
	 */
	public String getName_modify_doctor() {
		return ((String) getAttrVal("Name_modify_doctor"));
	}
	/**
	 * 修改医生名称
	 * @param Name_modify_doctor
	 */
	public void setName_modify_doctor(String Name_modify_doctor) {
		setAttrVal("Name_modify_doctor", Name_modify_doctor);
	}
	/**
	 * 审核日期
	 * @return FDateTime
	 */
	public FDateTime getVerify_date() {
		return ((FDateTime) getAttrVal("Verify_date"));
	}
	/**
	 * 审核日期
	 * @param Verify_date
	 */
	public void setVerify_date(FDateTime Verify_date) {
		setAttrVal("Verify_date", Verify_date);
	}
	/**
	 * 审核医生编码
	 * @return String
	 */
	public String getId_verify_doctor() {
		return ((String) getAttrVal("Id_verify_doctor"));
	}
	/**
	 * 审核医生编码
	 * @param Id_verify_doctor
	 */
	public void setId_verify_doctor(String Id_verify_doctor) {
		setAttrVal("Id_verify_doctor", Id_verify_doctor);
	}
	/**
	 * 审核医生姓名
	 * @return String
	 */
	public String getName_verify_doctor() {
		return ((String) getAttrVal("Name_verify_doctor"));
	}
	/**
	 * 审核医生姓名
	 * @param Name_verify_doctor
	 */
	public void setName_verify_doctor(String Name_verify_doctor) {
		setAttrVal("Name_verify_doctor", Name_verify_doctor);
	}
	/**
	 * 死亡日期
	 * @return FDateTime
	 */
	public FDateTime getDeath_date() {
		return ((FDateTime) getAttrVal("Death_date"));
	}
	/**
	 * 死亡日期
	 * @param Death_date
	 */
	public void setDeath_date(FDateTime Death_date) {
		setAttrVal("Death_date", Death_date);
	}
	/**
	 * 住院天数
	 * @return String
	 */
	public String getInhos_days() {
		return ((String) getAttrVal("Inhos_days"));
	}
	/**
	 * 住院天数
	 * @param Inhos_days
	 */
	public void setInhos_days(String Inhos_days) {
		setAttrVal("Inhos_days", Inhos_days);
	}
	/**
	 * 病理诊断
	 * @return String
	 */
	public String getDiag_pathology() {
		return ((String) getAttrVal("Diag_pathology"));
	}
	/**
	 * 病理诊断
	 * @param Diag_pathology
	 */
	public void setDiag_pathology(String Diag_pathology) {
		setAttrVal("Diag_pathology", Diag_pathology);
	}
	/**
	 * 病历摘要
	 * @return String
	 */
	public String getMr_general() {
		return ((String) getAttrVal("Mr_general"));
	}
	/**
	 * 病历摘要
	 * @param Mr_general
	 */
	public void setMr_general(String Mr_general) {
		setAttrVal("Mr_general", Mr_general);
	}
	/**
	 * 治疗过程
	 * @return String
	 */
	public String getTreatment_process() {
		return ((String) getAttrVal("Treatment_process"));
	}
	/**
	 * 治疗过程
	 * @param Treatment_process
	 */
	public void setTreatment_process(String Treatment_process) {
		setAttrVal("Treatment_process", Treatment_process);
	}
	/**
	 * 抢救过程
	 * @return String
	 */
	public String getRescue_process() {
		return ((String) getAttrVal("Rescue_process"));
	}
	/**
	 * 抢救过程
	 * @param Rescue_process
	 */
	public void setRescue_process(String Rescue_process) {
		setAttrVal("Rescue_process", Rescue_process);
	}
	/**
	 * 死亡原因
	 * @return String
	 */
	public String getDeath_reason() {
		return ((String) getAttrVal("Death_reason"));
	}
	/**
	 * 死亡原因
	 * @param Death_reason
	 */
	public void setDeath_reason(String Death_reason) {
		setAttrVal("Death_reason", Death_reason);
	}
	/**
	 * 诊断类别编码
	 * @return String
	 */
	public String getId_diag_type() {
		return ((String) getAttrVal("Id_diag_type"));
	}
	/**
	 * 诊断类别编码
	 * @param Id_diag_type
	 */
	public void setId_diag_type(String Id_diag_type) {
		setAttrVal("Id_diag_type", Id_diag_type);
	}
	/**
	 * 诊断类别名称
	 * @return String
	 */
	public String getName_diag_type() {
		return ((String) getAttrVal("Name_diag_type"));
	}
	/**
	 * 诊断类别名称
	 * @param Name_diag_type
	 */
	public void setName_diag_type(String Name_diag_type) {
		setAttrVal("Name_diag_type", Name_diag_type);
	}
	/**
	 * 疾病编码
	 * @return String
	 */
	public String getId_disease() {
		return ((String) getAttrVal("Id_disease"));
	}
	/**
	 * 疾病编码
	 * @param Id_disease
	 */
	public void setId_disease(String Id_disease) {
		setAttrVal("Id_disease", Id_disease);
	}
	/**
	 * 疾病名称
	 * @return String
	 */
	public String getName_disease() {
		return ((String) getAttrVal("Name_disease"));
	}
	/**
	 * 疾病名称
	 * @param Name_disease
	 */
	public void setName_disease(String Name_disease) {
		setAttrVal("Name_disease", Name_disease);
	}
	/**
	 * 诊断日期
	 * @return FDateTime
	 */
	public FDateTime getDiag_date() {
		return ((FDateTime) getAttrVal("Diag_date"));
	}
	/**
	 * 诊断日期
	 * @param Diag_date
	 */
	public void setDiag_date(FDateTime Diag_date) {
		setAttrVal("Diag_date", Diag_date);
	}
	/**
	 * 诊断描述
	 * @return String
	 */
	public String getDiag_des() {
		return ((String) getAttrVal("Diag_des"));
	}
	/**
	 * 诊断描述
	 * @param Diag_des
	 */
	public void setDiag_des(String Diag_des) {
		setAttrVal("Diag_des", Diag_des);
	}
}