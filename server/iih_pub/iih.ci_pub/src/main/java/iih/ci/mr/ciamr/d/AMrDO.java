package iih.ci.mr.ciamr.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.ciamr.d.desc.AMrDODesc;
import java.math.BigDecimal;

/**
 * 就诊病案 DO数据 
 * 
 */
public class AMrDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_ENHR= "Id_enhr";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String CODE_AMR_IP= "Code_amr_ip";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_QA_DOCTOR_PART_STA= "Id_qa_doctor_part_sta";
	public static final String SD_QA_DOCTOR_PART_STA= "Sd_qa_doctor_part_sta";
	public static final String ID_QA_NURSE_PART_STA= "Id_qa_nurse_part_sta";
	public static final String SD_QA_NURSE_PART_STA= "Sd_qa_nurse_part_sta";
	public static final String ID_DIVIDE_LEVEL= "Id_divide_level";
	public static final String SCORE_TERMINAL_QA= "Score_terminal_qa";
	public static final String ID_EMP_TERMINAL_QA= "Id_emp_terminal_qa";
	public static final String DT_TERMINAL_QA= "Dt_terminal_qa";
	public static final String DEPT_TERMINAL_QA= "Dept_terminal_qa";
	public static final String FG_TERMINAL_QA= "Fg_terminal_qa";
	public static final String SCORE_DEPT_QA= "Score_dept_qa";
	public static final String ID_EMP_DEPT_QA= "Id_emp_dept_qa";
	public static final String DT_DEPT_QA= "Dt_dept_qa";
	public static final String DEPT_DEPT_QA= "Dept_dept_qa";
	public static final String FG_DEPT_QA= "Fg_dept_qa";
	public static final String ID_EMP_PROCESS_QA= "Id_emp_process_qa";
	public static final String DT_PROCESS_QA= "Dt_process_qa";
	public static final String DEPT_PROCESS_QA= "Dept_process_qa";
	public static final String FG_PROCESS_QA= "Fg_process_qa";
	public static final String FG_COMPLETE= "Fg_complete";
	public static final String FG_SEAL= "Fg_seal";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String ID_PAT= "Id_pat";
	public static final String PAT_NAME= "Pat_name";
	public static final String INHOS_TIMES= "Inhos_times";
	public static final String ID_BED= "Id_bed";
	public static final String ID_SEX= "Id_sex";
	public static final String SD_SEX= "Sd_sex";
	public static final String PAT_AGE= "Pat_age";
	public static final String CODE_ENTP= "Code_entp";
	public static final String ID_STATUS= "Id_status";
	public static final String ID_EMP_REG= "Id_emp_reg";
	public static final String DT_ENTRY= "Dt_entry";
	public static final String ID_DEP_REG= "Id_dep_reg";
	public static final String ID_USER_ACPT= "Id_user_acpt";
	public static final String DT_ACPT= "Dt_acpt";
	public static final String ID_DEP_ACPT= "Id_dep_acpt";
	public static final String ID_LEVEL_DISE= "Id_level_dise";
	public static final String ID_LEVEL_NUR= "Id_level_nur";
	public static final String ID_MAJOR_DI= "Id_major_di";
	public static final String ID_DEP_CUR= "Id_dep_cur";
	public static final String DT_DEP_CUR= "Dt_dep_cur";
	public static final String ID_DEP_NURADM= "Id_dep_nuradm";
	public static final String DT_EN_DEP_NURADM= "Dt_en_dep_nuradm";
	public static final String ID_WKG_PHY= "Id_wkg_phy";
	public static final String ID_TREAT_DOCTOR= "Id_treat_doctor";
	public static final String ID_MAST_DOCTOR= "Id_mast_doctor";
	public static final String ID_DIR_DOCTOR= "Id_dir_doctor";
	public static final String ID_EMP_NUR= "Id_emp_nur";
	public static final String FG_SURG= "Fg_surg";
	public static final String FG_DEATH= "Fg_death";
	public static final String FG_REENTRY= "Fg_reentry";
	public static final String FG_RECLALL= "Fg_reclall";
	public static final String FG_FLUP= "Fg_flup";
	public static final String ID_USER_END= "Id_user_end";
	public static final String DT_END= "Dt_end";
	public static final String ID_DEP_END= "Id_dep_end";
	public static final String REASON_DEPTQC_BACK= "Reason_deptqc_back";
	public static final String REASON_TERMINALTQC_BACK= "Reason_terminaltqc_back";
	public static final String FG_AMR_CALLBACK= "Fg_amr_callback";
	public static final String REASON_AMR_BACK= "Reason_amr_back";
	public static final String ID_USER_SIGNOFF= "Id_user_signoff";
	public static final String ID_DEP_SIGNOFF= "Id_dep_signoff";
	public static final String DT_SIGNOFF= "Dt_signoff";
	public static final String ID_USER_CATALOGUE= "Id_user_catalogue";
	public static final String ID_DEP_CATALOGUE= "Id_dep_catalogue";
	public static final String DT_CATALOGUE= "Dt_catalogue";
	public static final String ID_USER_PIGEONHOLE= "Id_user_pigeonhole";
	public static final String ID_DEP_PIGEONHOLE= "Id_dep_pigeonhole";
	public static final String DT_PIGEONHOLE= "Dt_pigeonhole";
	public static final String ORG_CODE= "Org_code";
	public static final String ORG_NAME= "Org_name";
	public static final String GRP_CODE= "Grp_code";
	public static final String GRP_NAME= "Grp_name";
	public static final String DOCTOR_QA_CODE= "Doctor_qa_code";
	public static final String DOCTOR_QA_NAME= "Doctor_qa_name";
	public static final String QA_NURSE_CODE= "Qa_nurse_code";
	public static final String QA_NURSE_NAME= "Qa_nurse_name";
	public static final String EMP_TERM_NAME= "Emp_term_name";
	public static final String EMP_TERM_CODE= "Emp_term_code";
	public static final String DEPT_TERM_NAME= "Dept_term_name";
	public static final String DEPT_TERM_CODE= "Dept_term_code";
	public static final String EMP_DEPT_QA_CODE= "Emp_dept_qa_code";
	public static final String EMP_DEPT_QA_NAME= "Emp_dept_qa_name";
	public static final String DEPT_DEPT_QA_CODE= "Dept_dept_qa_code";
	public static final String DEPT_DEPT_QA_NAME= "Dept_dept_qa_name";
	public static final String PROCESS_QA_NAME= "Process_qa_name";
	public static final String PROCESS_QA_CODE= "Process_qa_code";
	public static final String DEPT_PROCESS_QA_CODE= "Dept_process_qa_code";
	public static final String DEPT_PROCESS_QA_NAME= "Dept_process_qa_name";
	public static final String CREATEDBY_NAME= "Createdby_name";
	public static final String CREATEDBY_CODE= "Createdby_code";
	public static final String MODIFIEDBY_NAME= "Modifiedby_name";
	public static final String MODIFIEDBY_CODE= "Modifiedby_code";
	public static final String BED_CODE= "Bed_code";
	public static final String BED_NAME= "Bed_name";
	public static final String STATUS_CODE= "Status_code";
	public static final String STATUS_NAME= "Status_name";
	public static final String EMP_REG_NAME= "Emp_reg_name";
	public static final String EMP_REG_CODE= "Emp_reg_code";
	public static final String DEPT_REG_CODE= "Dept_reg_code";
	public static final String DEPT_REG_NAME= "Dept_reg_name";
	public static final String USER_ACPT_NAME= "User_acpt_name";
	public static final String USER_ACPT_CODE= "User_acpt_code";
	public static final String DEPT_ACPT_CODE= "Dept_acpt_code";
	public static final String DEPT_ACPT_NAME= "Dept_acpt_name";
	public static final String LEVEL_DISE_CODE= "Level_dise_code";
	public static final String LEVEL_DISE_NAME= "Level_dise_name";
	public static final String LEVEL_NUR_CODE= "Level_nur_code";
	public static final String LEVEL_NUR_NAME= "Level_nur_name";
	public static final String DEP_NURAM_CODE= "Dep_nuram_code";
	public static final String DEP_NURAM_NAME= "Dep_nuram_name";
	public static final String WKG_PHY_CODE= "Wkg_phy_code";
	public static final String WKG_PHY_NAME= "Wkg_phy_name";
	public static final String TREAT_DOCTOR_NAME= "Treat_doctor_name";
	public static final String TREAT_DOCTOR_CODE= "Treat_doctor_code";
	public static final String MAST_DOCTOR_NAME= "Mast_doctor_name";
	public static final String MAST_DOCTOR_CODE= "Mast_doctor_code";
	public static final String DIR_DOCTOR_NAME= "Dir_doctor_name";
	public static final String DIR_DOCTOR_CODE= "Dir_doctor_code";
	public static final String EMP_NUR_NAME= "Emp_nur_name";
	public static final String EMP_NUR_CODE= "Emp_nur_code";
	public static final String USER_END_NAME= "User_end_name";
	public static final String USER_END_CODE= "User_end_code";
	public static final String DEP_END_NAME= "Dep_end_name";
	public static final String DEP_END_CODE= "Dep_end_code";
	public static final String USER_SIGNOFF_NAME= "User_signoff_name";
	public static final String USER_SIGNOFF_CODE= "User_signoff_code";
	public static final String DEP_SIGNOFF_CODE= "Dep_signoff_code";
	public static final String DEP_SIGNOFF_NAME= "Dep_signoff_name";
	public static final String USER_CATALOGUE_NAME= "User_catalogue_name";
	public static final String USER_CATALOGUE_CODE= "User_catalogue_code";
	public static final String DEP_CATALOGUE_CODE= "Dep_catalogue_code";
	public static final String DEP_CATALOGUE_NAME= "Dep_catalogue_name";
	public static final String USER_PIGEONHOLE_NAME= "User_pigeonhole_name";
	public static final String USER_PIGEONHOLE_CODE= "User_pigeonhole_code";
	public static final String DEP_PIGEONHOLE_CODE= "Dep_pigeonhole_code";
	public static final String DEP_PIGEONHOLE_NAME= "Dep_pigeonhole_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_enhr() {
		return ((String) getAttrVal("Id_enhr"));
	}	
	public void setId_enhr(String Id_enhr) {
		setAttrVal("Id_enhr", Id_enhr);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}	
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	public String getId_qa_doctor_part_sta() {
		return ((String) getAttrVal("Id_qa_doctor_part_sta"));
	}	
	public void setId_qa_doctor_part_sta(String Id_qa_doctor_part_sta) {
		setAttrVal("Id_qa_doctor_part_sta", Id_qa_doctor_part_sta);
	}
	public String getSd_qa_doctor_part_sta() {
		return ((String) getAttrVal("Sd_qa_doctor_part_sta"));
	}	
	public void setSd_qa_doctor_part_sta(String Sd_qa_doctor_part_sta) {
		setAttrVal("Sd_qa_doctor_part_sta", Sd_qa_doctor_part_sta);
	}
	public String getId_qa_nurse_part_sta() {
		return ((String) getAttrVal("Id_qa_nurse_part_sta"));
	}	
	public void setId_qa_nurse_part_sta(String Id_qa_nurse_part_sta) {
		setAttrVal("Id_qa_nurse_part_sta", Id_qa_nurse_part_sta);
	}
	public String getSd_qa_nurse_part_sta() {
		return ((String) getAttrVal("Sd_qa_nurse_part_sta"));
	}	
	public void setSd_qa_nurse_part_sta(String Sd_qa_nurse_part_sta) {
		setAttrVal("Sd_qa_nurse_part_sta", Sd_qa_nurse_part_sta);
	}
	public String getId_divide_level() {
		return ((String) getAttrVal("Id_divide_level"));
	}	
	public void setId_divide_level(String Id_divide_level) {
		setAttrVal("Id_divide_level", Id_divide_level);
	}
	public FDouble getScore_terminal_qa() {
		return ((FDouble) getAttrVal("Score_terminal_qa"));
	}	
	public void setScore_terminal_qa(FDouble Score_terminal_qa) {
		setAttrVal("Score_terminal_qa", Score_terminal_qa);
	}
	public String getId_emp_terminal_qa() {
		return ((String) getAttrVal("Id_emp_terminal_qa"));
	}	
	public void setId_emp_terminal_qa(String Id_emp_terminal_qa) {
		setAttrVal("Id_emp_terminal_qa", Id_emp_terminal_qa);
	}
	public FDateTime getDt_terminal_qa() {
		return ((FDateTime) getAttrVal("Dt_terminal_qa"));
	}	
	public void setDt_terminal_qa(FDateTime Dt_terminal_qa) {
		setAttrVal("Dt_terminal_qa", Dt_terminal_qa);
	}
	public String getDept_terminal_qa() {
		return ((String) getAttrVal("Dept_terminal_qa"));
	}	
	public void setDept_terminal_qa(String Dept_terminal_qa) {
		setAttrVal("Dept_terminal_qa", Dept_terminal_qa);
	}
	public FBoolean getFg_terminal_qa() {
		return ((FBoolean) getAttrVal("Fg_terminal_qa"));
	}	
	public void setFg_terminal_qa(FBoolean Fg_terminal_qa) {
		setAttrVal("Fg_terminal_qa", Fg_terminal_qa);
	}
	public FDouble getScore_dept_qa() {
		return ((FDouble) getAttrVal("Score_dept_qa"));
	}	
	public void setScore_dept_qa(FDouble Score_dept_qa) {
		setAttrVal("Score_dept_qa", Score_dept_qa);
	}
	public String getId_emp_dept_qa() {
		return ((String) getAttrVal("Id_emp_dept_qa"));
	}	
	public void setId_emp_dept_qa(String Id_emp_dept_qa) {
		setAttrVal("Id_emp_dept_qa", Id_emp_dept_qa);
	}
	public FDateTime getDt_dept_qa() {
		return ((FDateTime) getAttrVal("Dt_dept_qa"));
	}	
	public void setDt_dept_qa(FDateTime Dt_dept_qa) {
		setAttrVal("Dt_dept_qa", Dt_dept_qa);
	}
	public String getDept_dept_qa() {
		return ((String) getAttrVal("Dept_dept_qa"));
	}	
	public void setDept_dept_qa(String Dept_dept_qa) {
		setAttrVal("Dept_dept_qa", Dept_dept_qa);
	}
	public FBoolean getFg_dept_qa() {
		return ((FBoolean) getAttrVal("Fg_dept_qa"));
	}	
	public void setFg_dept_qa(FBoolean Fg_dept_qa) {
		setAttrVal("Fg_dept_qa", Fg_dept_qa);
	}
	public String getId_emp_process_qa() {
		return ((String) getAttrVal("Id_emp_process_qa"));
	}	
	public void setId_emp_process_qa(String Id_emp_process_qa) {
		setAttrVal("Id_emp_process_qa", Id_emp_process_qa);
	}
	public FDateTime getDt_process_qa() {
		return ((FDateTime) getAttrVal("Dt_process_qa"));
	}	
	public void setDt_process_qa(FDateTime Dt_process_qa) {
		setAttrVal("Dt_process_qa", Dt_process_qa);
	}
	public String getDept_process_qa() {
		return ((String) getAttrVal("Dept_process_qa"));
	}	
	public void setDept_process_qa(String Dept_process_qa) {
		setAttrVal("Dept_process_qa", Dept_process_qa);
	}
	public FBoolean getFg_process_qa() {
		return ((FBoolean) getAttrVal("Fg_process_qa"));
	}	
	public void setFg_process_qa(FBoolean Fg_process_qa) {
		setAttrVal("Fg_process_qa", Fg_process_qa);
	}
	public FBoolean getFg_complete() {
		return ((FBoolean) getAttrVal("Fg_complete"));
	}	
	public void setFg_complete(FBoolean Fg_complete) {
		setAttrVal("Fg_complete", Fg_complete);
	}
	public FBoolean getFg_seal() {
		return ((FBoolean) getAttrVal("Fg_seal"));
	}	
	public void setFg_seal(FBoolean Fg_seal) {
		setAttrVal("Fg_seal", Fg_seal);
	}
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}	
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}	
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}	
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}	
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
	}
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	public String getPat_name() {
		return ((String) getAttrVal("Pat_name"));
	}	
	public void setPat_name(String Pat_name) {
		setAttrVal("Pat_name", Pat_name);
	}
	public String getInhos_times() {
		return ((String) getAttrVal("Inhos_times"));
	}	
	public void setInhos_times(String Inhos_times) {
		setAttrVal("Inhos_times", Inhos_times);
	}
	public String getId_bed() {
		return ((String) getAttrVal("Id_bed"));
	}	
	public void setId_bed(String Id_bed) {
		setAttrVal("Id_bed", Id_bed);
	}
	public String getId_sex() {
		return ((String) getAttrVal("Id_sex"));
	}	
	public void setId_sex(String Id_sex) {
		setAttrVal("Id_sex", Id_sex);
	}
	public String getSd_sex() {
		return ((String) getAttrVal("Sd_sex"));
	}	
	public void setSd_sex(String Sd_sex) {
		setAttrVal("Sd_sex", Sd_sex);
	}
	public String getPat_age() {
		return ((String) getAttrVal("Pat_age"));
	}	
	public void setPat_age(String Pat_age) {
		setAttrVal("Pat_age", Pat_age);
	}
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}	
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	public String getId_status() {
		return ((String) getAttrVal("Id_status"));
	}	
	public void setId_status(String Id_status) {
		setAttrVal("Id_status", Id_status);
	}
	public String getId_emp_reg() {
		return ((String) getAttrVal("Id_emp_reg"));
	}	
	public void setId_emp_reg(String Id_emp_reg) {
		setAttrVal("Id_emp_reg", Id_emp_reg);
	}
	public FDateTime getDt_entry() {
		return ((FDateTime) getAttrVal("Dt_entry"));
	}	
	public void setDt_entry(FDateTime Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	public String getId_dep_reg() {
		return ((String) getAttrVal("Id_dep_reg"));
	}	
	public void setId_dep_reg(String Id_dep_reg) {
		setAttrVal("Id_dep_reg", Id_dep_reg);
	}
	public String getId_user_acpt() {
		return ((String) getAttrVal("Id_user_acpt"));
	}	
	public void setId_user_acpt(String Id_user_acpt) {
		setAttrVal("Id_user_acpt", Id_user_acpt);
	}
	public FDateTime getDt_acpt() {
		return ((FDateTime) getAttrVal("Dt_acpt"));
	}	
	public void setDt_acpt(FDateTime Dt_acpt) {
		setAttrVal("Dt_acpt", Dt_acpt);
	}
	public String getId_dep_acpt() {
		return ((String) getAttrVal("Id_dep_acpt"));
	}	
	public void setId_dep_acpt(String Id_dep_acpt) {
		setAttrVal("Id_dep_acpt", Id_dep_acpt);
	}
	public String getId_level_dise() {
		return ((String) getAttrVal("Id_level_dise"));
	}	
	public void setId_level_dise(String Id_level_dise) {
		setAttrVal("Id_level_dise", Id_level_dise);
	}
	public String getId_level_nur() {
		return ((String) getAttrVal("Id_level_nur"));
	}	
	public void setId_level_nur(String Id_level_nur) {
		setAttrVal("Id_level_nur", Id_level_nur);
	}
	public String getId_major_di() {
		return ((String) getAttrVal("Id_major_di"));
	}	
	public void setId_major_di(String Id_major_di) {
		setAttrVal("Id_major_di", Id_major_di);
	}
	public String getId_dep_cur() {
		return ((String) getAttrVal("Id_dep_cur"));
	}	
	public void setId_dep_cur(String Id_dep_cur) {
		setAttrVal("Id_dep_cur", Id_dep_cur);
	}
	public FDateTime getDt_dep_cur() {
		return ((FDateTime) getAttrVal("Dt_dep_cur"));
	}	
	public void setDt_dep_cur(FDateTime Dt_dep_cur) {
		setAttrVal("Dt_dep_cur", Dt_dep_cur);
	}
	public String getId_dep_nuradm() {
		return ((String) getAttrVal("Id_dep_nuradm"));
	}	
	public void setId_dep_nuradm(String Id_dep_nuradm) {
		setAttrVal("Id_dep_nuradm", Id_dep_nuradm);
	}
	public FDateTime getDt_en_dep_nuradm() {
		return ((FDateTime) getAttrVal("Dt_en_dep_nuradm"));
	}	
	public void setDt_en_dep_nuradm(FDateTime Dt_en_dep_nuradm) {
		setAttrVal("Dt_en_dep_nuradm", Dt_en_dep_nuradm);
	}
	public String getId_wkg_phy() {
		return ((String) getAttrVal("Id_wkg_phy"));
	}	
	public void setId_wkg_phy(String Id_wkg_phy) {
		setAttrVal("Id_wkg_phy", Id_wkg_phy);
	}
	public String getId_treat_doctor() {
		return ((String) getAttrVal("Id_treat_doctor"));
	}	
	public void setId_treat_doctor(String Id_treat_doctor) {
		setAttrVal("Id_treat_doctor", Id_treat_doctor);
	}
	public String getId_mast_doctor() {
		return ((String) getAttrVal("Id_mast_doctor"));
	}	
	public void setId_mast_doctor(String Id_mast_doctor) {
		setAttrVal("Id_mast_doctor", Id_mast_doctor);
	}
	public String getId_dir_doctor() {
		return ((String) getAttrVal("Id_dir_doctor"));
	}	
	public void setId_dir_doctor(String Id_dir_doctor) {
		setAttrVal("Id_dir_doctor", Id_dir_doctor);
	}
	public String getId_emp_nur() {
		return ((String) getAttrVal("Id_emp_nur"));
	}	
	public void setId_emp_nur(String Id_emp_nur) {
		setAttrVal("Id_emp_nur", Id_emp_nur);
	}
	public FBoolean getFg_surg() {
		return ((FBoolean) getAttrVal("Fg_surg"));
	}	
	public void setFg_surg(FBoolean Fg_surg) {
		setAttrVal("Fg_surg", Fg_surg);
	}
	public FBoolean getFg_death() {
		return ((FBoolean) getAttrVal("Fg_death"));
	}	
	public void setFg_death(FBoolean Fg_death) {
		setAttrVal("Fg_death", Fg_death);
	}
	public FBoolean getFg_reentry() {
		return ((FBoolean) getAttrVal("Fg_reentry"));
	}	
	public void setFg_reentry(FBoolean Fg_reentry) {
		setAttrVal("Fg_reentry", Fg_reentry);
	}
	public FBoolean getFg_reclall() {
		return ((FBoolean) getAttrVal("Fg_reclall"));
	}	
	public void setFg_reclall(FBoolean Fg_reclall) {
		setAttrVal("Fg_reclall", Fg_reclall);
	}
	public FBoolean getFg_flup() {
		return ((FBoolean) getAttrVal("Fg_flup"));
	}	
	public void setFg_flup(FBoolean Fg_flup) {
		setAttrVal("Fg_flup", Fg_flup);
	}
	public String getId_user_end() {
		return ((String) getAttrVal("Id_user_end"));
	}	
	public void setId_user_end(String Id_user_end) {
		setAttrVal("Id_user_end", Id_user_end);
	}
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}	
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	public String getId_dep_end() {
		return ((String) getAttrVal("Id_dep_end"));
	}	
	public void setId_dep_end(String Id_dep_end) {
		setAttrVal("Id_dep_end", Id_dep_end);
	}
	public String getReason_deptqc_back() {
		return ((String) getAttrVal("Reason_deptqc_back"));
	}	
	public void setReason_deptqc_back(String Reason_deptqc_back) {
		setAttrVal("Reason_deptqc_back", Reason_deptqc_back);
	}
	public String getReason_terminaltqc_back() {
		return ((String) getAttrVal("Reason_terminaltqc_back"));
	}	
	public void setReason_terminaltqc_back(String Reason_terminaltqc_back) {
		setAttrVal("Reason_terminaltqc_back", Reason_terminaltqc_back);
	}
	public FBoolean getFg_amr_callback() {
		return ((FBoolean) getAttrVal("Fg_amr_callback"));
	}	
	public void setFg_amr_callback(FBoolean Fg_amr_callback) {
		setAttrVal("Fg_amr_callback", Fg_amr_callback);
	}
	public String getReason_amr_back() {
		return ((String) getAttrVal("Reason_amr_back"));
	}	
	public void setReason_amr_back(String Reason_amr_back) {
		setAttrVal("Reason_amr_back", Reason_amr_back);
	}
	public String getId_user_signoff() {
		return ((String) getAttrVal("Id_user_signoff"));
	}	
	public void setId_user_signoff(String Id_user_signoff) {
		setAttrVal("Id_user_signoff", Id_user_signoff);
	}
	public String getId_dep_signoff() {
		return ((String) getAttrVal("Id_dep_signoff"));
	}	
	public void setId_dep_signoff(String Id_dep_signoff) {
		setAttrVal("Id_dep_signoff", Id_dep_signoff);
	}
	public FDateTime getDt_signoff() {
		return ((FDateTime) getAttrVal("Dt_signoff"));
	}	
	public void setDt_signoff(FDateTime Dt_signoff) {
		setAttrVal("Dt_signoff", Dt_signoff);
	}
	public String getId_user_catalogue() {
		return ((String) getAttrVal("Id_user_catalogue"));
	}	
	public void setId_user_catalogue(String Id_user_catalogue) {
		setAttrVal("Id_user_catalogue", Id_user_catalogue);
	}
	public String getId_dep_catalogue() {
		return ((String) getAttrVal("Id_dep_catalogue"));
	}	
	public void setId_dep_catalogue(String Id_dep_catalogue) {
		setAttrVal("Id_dep_catalogue", Id_dep_catalogue);
	}
	public FDateTime getDt_catalogue() {
		return ((FDateTime) getAttrVal("Dt_catalogue"));
	}	
	public void setDt_catalogue(FDateTime Dt_catalogue) {
		setAttrVal("Dt_catalogue", Dt_catalogue);
	}
	public String getId_user_pigeonhole() {
		return ((String) getAttrVal("Id_user_pigeonhole"));
	}	
	public void setId_user_pigeonhole(String Id_user_pigeonhole) {
		setAttrVal("Id_user_pigeonhole", Id_user_pigeonhole);
	}
	public String getId_dep_pigeonhole() {
		return ((String) getAttrVal("Id_dep_pigeonhole"));
	}	
	public void setId_dep_pigeonhole(String Id_dep_pigeonhole) {
		setAttrVal("Id_dep_pigeonhole", Id_dep_pigeonhole);
	}
	public FDateTime getDt_pigeonhole() {
		return ((FDateTime) getAttrVal("Dt_pigeonhole"));
	}	
	public void setDt_pigeonhole(FDateTime Dt_pigeonhole) {
		setAttrVal("Dt_pigeonhole", Dt_pigeonhole);
	}
	public String getOrg_code() {
		return ((String) getAttrVal("Org_code"));
	}	
	public void setOrg_code(String Org_code) {
		setAttrVal("Org_code", Org_code);
	}
	public String getOrg_name() {
		return ((String) getAttrVal("Org_name"));
	}	
	public void setOrg_name(String Org_name) {
		setAttrVal("Org_name", Org_name);
	}
	public String getGrp_code() {
		return ((String) getAttrVal("Grp_code"));
	}	
	public void setGrp_code(String Grp_code) {
		setAttrVal("Grp_code", Grp_code);
	}
	public String getGrp_name() {
		return ((String) getAttrVal("Grp_name"));
	}	
	public void setGrp_name(String Grp_name) {
		setAttrVal("Grp_name", Grp_name);
	}
	public String getDoctor_qa_code() {
		return ((String) getAttrVal("Doctor_qa_code"));
	}	
	public void setDoctor_qa_code(String Doctor_qa_code) {
		setAttrVal("Doctor_qa_code", Doctor_qa_code);
	}
	public String getDoctor_qa_name() {
		return ((String) getAttrVal("Doctor_qa_name"));
	}	
	public void setDoctor_qa_name(String Doctor_qa_name) {
		setAttrVal("Doctor_qa_name", Doctor_qa_name);
	}
	public String getQa_nurse_code() {
		return ((String) getAttrVal("Qa_nurse_code"));
	}	
	public void setQa_nurse_code(String Qa_nurse_code) {
		setAttrVal("Qa_nurse_code", Qa_nurse_code);
	}
	public String getQa_nurse_name() {
		return ((String) getAttrVal("Qa_nurse_name"));
	}	
	public void setQa_nurse_name(String Qa_nurse_name) {
		setAttrVal("Qa_nurse_name", Qa_nurse_name);
	}
	public String getEmp_term_name() {
		return ((String) getAttrVal("Emp_term_name"));
	}	
	public void setEmp_term_name(String Emp_term_name) {
		setAttrVal("Emp_term_name", Emp_term_name);
	}
	public String getEmp_term_code() {
		return ((String) getAttrVal("Emp_term_code"));
	}	
	public void setEmp_term_code(String Emp_term_code) {
		setAttrVal("Emp_term_code", Emp_term_code);
	}
	public String getDept_term_name() {
		return ((String) getAttrVal("Dept_term_name"));
	}	
	public void setDept_term_name(String Dept_term_name) {
		setAttrVal("Dept_term_name", Dept_term_name);
	}
	public String getDept_term_code() {
		return ((String) getAttrVal("Dept_term_code"));
	}	
	public void setDept_term_code(String Dept_term_code) {
		setAttrVal("Dept_term_code", Dept_term_code);
	}
	public String getEmp_dept_qa_code() {
		return ((String) getAttrVal("Emp_dept_qa_code"));
	}	
	public void setEmp_dept_qa_code(String Emp_dept_qa_code) {
		setAttrVal("Emp_dept_qa_code", Emp_dept_qa_code);
	}
	public String getEmp_dept_qa_name() {
		return ((String) getAttrVal("Emp_dept_qa_name"));
	}	
	public void setEmp_dept_qa_name(String Emp_dept_qa_name) {
		setAttrVal("Emp_dept_qa_name", Emp_dept_qa_name);
	}
	public String getDept_dept_qa_code() {
		return ((String) getAttrVal("Dept_dept_qa_code"));
	}	
	public void setDept_dept_qa_code(String Dept_dept_qa_code) {
		setAttrVal("Dept_dept_qa_code", Dept_dept_qa_code);
	}
	public String getDept_dept_qa_name() {
		return ((String) getAttrVal("Dept_dept_qa_name"));
	}	
	public void setDept_dept_qa_name(String Dept_dept_qa_name) {
		setAttrVal("Dept_dept_qa_name", Dept_dept_qa_name);
	}
	public String getProcess_qa_name() {
		return ((String) getAttrVal("Process_qa_name"));
	}	
	public void setProcess_qa_name(String Process_qa_name) {
		setAttrVal("Process_qa_name", Process_qa_name);
	}
	public String getProcess_qa_code() {
		return ((String) getAttrVal("Process_qa_code"));
	}	
	public void setProcess_qa_code(String Process_qa_code) {
		setAttrVal("Process_qa_code", Process_qa_code);
	}
	public String getDept_process_qa_code() {
		return ((String) getAttrVal("Dept_process_qa_code"));
	}	
	public void setDept_process_qa_code(String Dept_process_qa_code) {
		setAttrVal("Dept_process_qa_code", Dept_process_qa_code);
	}
	public String getDept_process_qa_name() {
		return ((String) getAttrVal("Dept_process_qa_name"));
	}	
	public void setDept_process_qa_name(String Dept_process_qa_name) {
		setAttrVal("Dept_process_qa_name", Dept_process_qa_name);
	}
	public String getCreatedby_name() {
		return ((String) getAttrVal("Createdby_name"));
	}	
	public void setCreatedby_name(String Createdby_name) {
		setAttrVal("Createdby_name", Createdby_name);
	}
	public String getCreatedby_code() {
		return ((String) getAttrVal("Createdby_code"));
	}	
	public void setCreatedby_code(String Createdby_code) {
		setAttrVal("Createdby_code", Createdby_code);
	}
	public String getModifiedby_name() {
		return ((String) getAttrVal("Modifiedby_name"));
	}	
	public void setModifiedby_name(String Modifiedby_name) {
		setAttrVal("Modifiedby_name", Modifiedby_name);
	}
	public String getModifiedby_code() {
		return ((String) getAttrVal("Modifiedby_code"));
	}	
	public void setModifiedby_code(String Modifiedby_code) {
		setAttrVal("Modifiedby_code", Modifiedby_code);
	}
	public String getBed_code() {
		return ((String) getAttrVal("Bed_code"));
	}	
	public void setBed_code(String Bed_code) {
		setAttrVal("Bed_code", Bed_code);
	}
	public String getBed_name() {
		return ((String) getAttrVal("Bed_name"));
	}	
	public void setBed_name(String Bed_name) {
		setAttrVal("Bed_name", Bed_name);
	}
	public String getStatus_code() {
		return ((String) getAttrVal("Status_code"));
	}	
	public void setStatus_code(String Status_code) {
		setAttrVal("Status_code", Status_code);
	}
	public String getStatus_name() {
		return ((String) getAttrVal("Status_name"));
	}	
	public void setStatus_name(String Status_name) {
		setAttrVal("Status_name", Status_name);
	}
	public String getEmp_reg_name() {
		return ((String) getAttrVal("Emp_reg_name"));
	}	
	public void setEmp_reg_name(String Emp_reg_name) {
		setAttrVal("Emp_reg_name", Emp_reg_name);
	}
	public String getEmp_reg_code() {
		return ((String) getAttrVal("Emp_reg_code"));
	}	
	public void setEmp_reg_code(String Emp_reg_code) {
		setAttrVal("Emp_reg_code", Emp_reg_code);
	}
	public String getDept_reg_code() {
		return ((String) getAttrVal("Dept_reg_code"));
	}	
	public void setDept_reg_code(String Dept_reg_code) {
		setAttrVal("Dept_reg_code", Dept_reg_code);
	}
	public String getDept_reg_name() {
		return ((String) getAttrVal("Dept_reg_name"));
	}	
	public void setDept_reg_name(String Dept_reg_name) {
		setAttrVal("Dept_reg_name", Dept_reg_name);
	}
	public String getUser_acpt_name() {
		return ((String) getAttrVal("User_acpt_name"));
	}	
	public void setUser_acpt_name(String User_acpt_name) {
		setAttrVal("User_acpt_name", User_acpt_name);
	}
	public String getUser_acpt_code() {
		return ((String) getAttrVal("User_acpt_code"));
	}	
	public void setUser_acpt_code(String User_acpt_code) {
		setAttrVal("User_acpt_code", User_acpt_code);
	}
	public String getDept_acpt_code() {
		return ((String) getAttrVal("Dept_acpt_code"));
	}	
	public void setDept_acpt_code(String Dept_acpt_code) {
		setAttrVal("Dept_acpt_code", Dept_acpt_code);
	}
	public String getDept_acpt_name() {
		return ((String) getAttrVal("Dept_acpt_name"));
	}	
	public void setDept_acpt_name(String Dept_acpt_name) {
		setAttrVal("Dept_acpt_name", Dept_acpt_name);
	}
	public String getLevel_dise_code() {
		return ((String) getAttrVal("Level_dise_code"));
	}	
	public void setLevel_dise_code(String Level_dise_code) {
		setAttrVal("Level_dise_code", Level_dise_code);
	}
	public String getLevel_dise_name() {
		return ((String) getAttrVal("Level_dise_name"));
	}	
	public void setLevel_dise_name(String Level_dise_name) {
		setAttrVal("Level_dise_name", Level_dise_name);
	}
	public String getLevel_nur_code() {
		return ((String) getAttrVal("Level_nur_code"));
	}	
	public void setLevel_nur_code(String Level_nur_code) {
		setAttrVal("Level_nur_code", Level_nur_code);
	}
	public String getLevel_nur_name() {
		return ((String) getAttrVal("Level_nur_name"));
	}	
	public void setLevel_nur_name(String Level_nur_name) {
		setAttrVal("Level_nur_name", Level_nur_name);
	}
	public String getDep_nuram_code() {
		return ((String) getAttrVal("Dep_nuram_code"));
	}	
	public void setDep_nuram_code(String Dep_nuram_code) {
		setAttrVal("Dep_nuram_code", Dep_nuram_code);
	}
	public String getDep_nuram_name() {
		return ((String) getAttrVal("Dep_nuram_name"));
	}	
	public void setDep_nuram_name(String Dep_nuram_name) {
		setAttrVal("Dep_nuram_name", Dep_nuram_name);
	}
	public String getWkg_phy_code() {
		return ((String) getAttrVal("Wkg_phy_code"));
	}	
	public void setWkg_phy_code(String Wkg_phy_code) {
		setAttrVal("Wkg_phy_code", Wkg_phy_code);
	}
	public String getWkg_phy_name() {
		return ((String) getAttrVal("Wkg_phy_name"));
	}	
	public void setWkg_phy_name(String Wkg_phy_name) {
		setAttrVal("Wkg_phy_name", Wkg_phy_name);
	}
	public String getTreat_doctor_name() {
		return ((String) getAttrVal("Treat_doctor_name"));
	}	
	public void setTreat_doctor_name(String Treat_doctor_name) {
		setAttrVal("Treat_doctor_name", Treat_doctor_name);
	}
	public String getTreat_doctor_code() {
		return ((String) getAttrVal("Treat_doctor_code"));
	}	
	public void setTreat_doctor_code(String Treat_doctor_code) {
		setAttrVal("Treat_doctor_code", Treat_doctor_code);
	}
	public String getMast_doctor_name() {
		return ((String) getAttrVal("Mast_doctor_name"));
	}	
	public void setMast_doctor_name(String Mast_doctor_name) {
		setAttrVal("Mast_doctor_name", Mast_doctor_name);
	}
	public String getMast_doctor_code() {
		return ((String) getAttrVal("Mast_doctor_code"));
	}	
	public void setMast_doctor_code(String Mast_doctor_code) {
		setAttrVal("Mast_doctor_code", Mast_doctor_code);
	}
	public String getDir_doctor_name() {
		return ((String) getAttrVal("Dir_doctor_name"));
	}	
	public void setDir_doctor_name(String Dir_doctor_name) {
		setAttrVal("Dir_doctor_name", Dir_doctor_name);
	}
	public String getDir_doctor_code() {
		return ((String) getAttrVal("Dir_doctor_code"));
	}	
	public void setDir_doctor_code(String Dir_doctor_code) {
		setAttrVal("Dir_doctor_code", Dir_doctor_code);
	}
	public String getEmp_nur_name() {
		return ((String) getAttrVal("Emp_nur_name"));
	}	
	public void setEmp_nur_name(String Emp_nur_name) {
		setAttrVal("Emp_nur_name", Emp_nur_name);
	}
	public String getEmp_nur_code() {
		return ((String) getAttrVal("Emp_nur_code"));
	}	
	public void setEmp_nur_code(String Emp_nur_code) {
		setAttrVal("Emp_nur_code", Emp_nur_code);
	}
	public String getUser_end_name() {
		return ((String) getAttrVal("User_end_name"));
	}	
	public void setUser_end_name(String User_end_name) {
		setAttrVal("User_end_name", User_end_name);
	}
	public String getUser_end_code() {
		return ((String) getAttrVal("User_end_code"));
	}	
	public void setUser_end_code(String User_end_code) {
		setAttrVal("User_end_code", User_end_code);
	}
	public String getDep_end_name() {
		return ((String) getAttrVal("Dep_end_name"));
	}	
	public void setDep_end_name(String Dep_end_name) {
		setAttrVal("Dep_end_name", Dep_end_name);
	}
	public String getDep_end_code() {
		return ((String) getAttrVal("Dep_end_code"));
	}	
	public void setDep_end_code(String Dep_end_code) {
		setAttrVal("Dep_end_code", Dep_end_code);
	}
	public String getUser_signoff_name() {
		return ((String) getAttrVal("User_signoff_name"));
	}	
	public void setUser_signoff_name(String User_signoff_name) {
		setAttrVal("User_signoff_name", User_signoff_name);
	}
	public String getUser_signoff_code() {
		return ((String) getAttrVal("User_signoff_code"));
	}	
	public void setUser_signoff_code(String User_signoff_code) {
		setAttrVal("User_signoff_code", User_signoff_code);
	}
	public String getDep_signoff_code() {
		return ((String) getAttrVal("Dep_signoff_code"));
	}	
	public void setDep_signoff_code(String Dep_signoff_code) {
		setAttrVal("Dep_signoff_code", Dep_signoff_code);
	}
	public String getDep_signoff_name() {
		return ((String) getAttrVal("Dep_signoff_name"));
	}	
	public void setDep_signoff_name(String Dep_signoff_name) {
		setAttrVal("Dep_signoff_name", Dep_signoff_name);
	}
	public String getUser_catalogue_name() {
		return ((String) getAttrVal("User_catalogue_name"));
	}	
	public void setUser_catalogue_name(String User_catalogue_name) {
		setAttrVal("User_catalogue_name", User_catalogue_name);
	}
	public String getUser_catalogue_code() {
		return ((String) getAttrVal("User_catalogue_code"));
	}	
	public void setUser_catalogue_code(String User_catalogue_code) {
		setAttrVal("User_catalogue_code", User_catalogue_code);
	}
	public String getDep_catalogue_code() {
		return ((String) getAttrVal("Dep_catalogue_code"));
	}	
	public void setDep_catalogue_code(String Dep_catalogue_code) {
		setAttrVal("Dep_catalogue_code", Dep_catalogue_code);
	}
	public String getDep_catalogue_name() {
		return ((String) getAttrVal("Dep_catalogue_name"));
	}	
	public void setDep_catalogue_name(String Dep_catalogue_name) {
		setAttrVal("Dep_catalogue_name", Dep_catalogue_name);
	}
	public String getUser_pigeonhole_name() {
		return ((String) getAttrVal("User_pigeonhole_name"));
	}	
	public void setUser_pigeonhole_name(String User_pigeonhole_name) {
		setAttrVal("User_pigeonhole_name", User_pigeonhole_name);
	}
	public String getUser_pigeonhole_code() {
		return ((String) getAttrVal("User_pigeonhole_code"));
	}	
	public void setUser_pigeonhole_code(String User_pigeonhole_code) {
		setAttrVal("User_pigeonhole_code", User_pigeonhole_code);
	}
	public String getDep_pigeonhole_code() {
		return ((String) getAttrVal("Dep_pigeonhole_code"));
	}	
	public void setDep_pigeonhole_code(String Dep_pigeonhole_code) {
		setAttrVal("Dep_pigeonhole_code", Dep_pigeonhole_code);
	}
	public String getDep_pigeonhole_name() {
		return ((String) getAttrVal("Dep_pigeonhole_name"));
	}	
	public void setDep_pigeonhole_name(String Dep_pigeonhole_name) {
		setAttrVal("Dep_pigeonhole_name", Dep_pigeonhole_name);
	}

	public Integer getDs() {
		return ((Integer) getAttrVal(GlobalConst.DELETE_SIGN));
	}
	
	public void setDs(Integer ds) {
		setAttrVal(GlobalConst.DELETE_SIGN, ds);
	}
	
	public FDateTime getSv() {
		return ((FDateTime) getAttrVal(GlobalConst.SYSTEM_VERSION));
	}
	
	public void setSv(FDateTime sv) {
		setAttrVal(GlobalConst.SYSTEM_VERSION, sv);
	}

//	@Override
//	public java.lang.String getParentPKFieldName() {
//		return null;
//	}
  
	@Override
	public String getPKFieldName() {
		return "Id_enhr";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_amr";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(AMrDODesc.class);
	}
	
}