package iih.ci.mr.cimr.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.wf.af.server.WfFormInfoCtx;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.cimr.d.desc.CiMrDODesc;
import java.math.BigDecimal;

/**
 * 临床医疗记录 DO数据 
 * 
 */
public class CiMrDO extends BaseDO implements WfFormInfoCtx{
	private static final long serialVersionUID = 1L;

	public static final String ID_MR= "Id_mr";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_PAT= "Id_pat";
	public static final String NAME= "Name";
	public static final String ID_MRCACTM= "Id_mrcactm";
	public static final String ID_MRTP= "Id_mrtp";
	public static final String ID_SU_MR= "Id_su_mr";
	public static final String SD_SU_MR= "Sd_su_mr";
	public static final String FG_COMPLETE= "Fg_complete";
	public static final String ID_REVIEWTP= "Id_reviewtp";
	public static final String SD_REVIEWTP= "Sd_reviewtp";
	public static final String ID_MRTPL= "Id_mrtpl";
	public static final String ID_MRED= "Id_mred";
	public static final String STARTPARAED= "Startparaed";
	public static final String ID_MRTPLSTMD= "Id_mrtplstmd";
	public static final String SD_MRTPLSTMD= "Sd_mrtplstmd";
	public static final String URL_FILE= "Url_file";
	public static final String ID_EMP_SUBMIT= "Id_emp_submit";
	public static final String DATE_SUBMIT= "Date_submit";
	public static final String DATE_TIME_SHOW= "Date_time_show";
	public static final String ID_SUBMIT_DEPT= "Id_submit_dept";
	public static final String CODE_DEPT_PAT= "Code_dept_pat";
	public static final String ID_TREAT_DOCTOR= "Id_treat_doctor";
	public static final String ID_MAST_DOCTOR= "Id_mast_doctor";
	public static final String MAST_DOCTOR_DATE= "Mast_doctor_date";
	public static final String ID_DIR_DOCTOR= "Id_dir_doctor";
	public static final String DIR_DOCTOR_DATE= "Dir_doctor_date";
	public static final String ID_ENTP= "Id_entp";
	public static final String CODE_ENTP= "Code_entp";
	public static final String FG_DUTY_DOCTOR= "Fg_duty_doctor";
	public static final String DT_RD= "Dt_rd";
	public static final String ID_EMP= "Id_emp";
	public static final String ID_DEP= "Id_dep";
	public static final String ID_EMP_HIGHER= "Id_emp_higher";
	public static final String DT_SIGN= "Dt_sign";
	public static final String ID_EMP_LAT= "Id_emp_lat";
	public static final String DT_SIGN_LAT= "Dt_sign_lat";
	public static final String ID_EMP_AUDIT= "Id_emp_audit";
	public static final String DT_AUDIT_LAT= "Dt_audit_lat";
	public static final String SCOREQALAT= "Scoreqalat";
	public static final String FG_EDIT= "Fg_edit";
	public static final String FG_SUBMIT= "Fg_submit";
	public static final String FG_REJECT= "Fg_reject";
	public static final String FG_SEAL= "Fg_seal";
	public static final String FG_ARC= "Fg_arc";
	public static final String FG_PRN= "Fg_prn";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String TASK_ID= "Task_id";
	public static final String ID_DEP_PAT= "Id_dep_pat";
	public static final String ID_FLOWTYPE= "Id_flowtype";
	public static final String ID_DEP_NURADM= "Id_dep_nuradm";
	public static final String ID_BED= "Id_bed";
	public static final String ID_SEX= "Id_sex";
	public static final String PAT_AGE= "Pat_age";
	public static final String NEWTOP= "Newtop";
	public static final String NEWEND= "Newend";
	public static final String SIGN_SUGGESTION= "Sign_suggestion";
	public static final String FG_SIGN= "Fg_sign";
	public static final String GRP_CODE= "Grp_code";
	public static final String GRP_NAME= "Grp_name";
	public static final String ORG_CODE= "Org_code";
	public static final String ORG_NAME= "Org_name";
	public static final String PAT_CODE= "Pat_code";
	public static final String PAT_NAME= "Pat_name";
	public static final String MRCACTM_CODE= "Mrcactm_code";
	public static final String MRCACTM_NAME= "Mrcactm_name";
	public static final String MRTP_CODE= "Mrtp_code";
	public static final String MRTP_NAME= "Mrtp_name";
	public static final String SU_MR_CODE= "Su_mr_code";
	public static final String SU_MR_NAME= "Su_mr_name";
	public static final String REVIEWTP_CODE= "Reviewtp_code";
	public static final String REVIEWTP_NAME= "Reviewtp_name";
	public static final String ID_MR_FINISH_STATUS= "Id_mr_finish_status";
	public static final String MRTPL_CODE= "Mrtpl_code";
	public static final String MRTPL_NAME= "Mrtpl_name";
	public static final String MRED_CODE= "Mred_code";
	public static final String MRED_NAME= "Mred_name";
	public static final String MRTPLSTMD_CODE= "Mrtplstmd_code";
	public static final String MRTPLSTMD_NAME= "Mrtplstmd_name";
	public static final String EMP_SUBMIT_NAME= "Emp_submit_name";
	public static final String EMP_SUBMIT_CODE= "Emp_submit_code";
	public static final String SUBMIT_DEPT_CODE= "Submit_dept_code";
	public static final String SUBMIT_DEPT_NAME= "Submit_dept_name";
	public static final String TREAT_NAME= "Treat_name";
	public static final String TREAT_CODE= "Treat_code";
	public static final String MAST_NAME= "Mast_name";
	public static final String MAST_CODE= "Mast_code";
	public static final String DIR_NAME= "Dir_name";
	public static final String DIR_CODE= "Dir_code";
	public static final String ENTP_CODE= "Entp_code";
	public static final String ENTP_NAME= "Entp_name";
	public static final String EMP_NAME= "Emp_name";
	public static final String EMP_CODE= "Emp_code";
	public static final String DEP_CODE= "Dep_code";
	public static final String DEP_NAME= "Dep_name";
	public static final String EMP_HIGHER_NAME= "Emp_higher_name";
	public static final String EMP_HIGHER_CODE= "Emp_higher_code";
	public static final String EMP_LAT_NAME= "Emp_lat_name";
	public static final String EMP_LAT_CODE= "Emp_lat_code";
	public static final String EMP_AUDIT_NAME= "Emp_audit_name";
	public static final String EMP_AUDIT_CODE= "Emp_audit_code";
	public static final String CREATEBY_NAME= "Createby_name";
	public static final String CREATEBY_CODE= "Createby_code";
	public static final String MODIFIEDBY_NAME= "Modifiedby_name";
	public static final String MODIFIEDBY_CODE= "Modifiedby_code";
	public static final String DEP_PAT_CODE= "Dep_pat_code";
	public static final String DEP_PAT_NAME= "Dep_pat_name";
	public static final String FLOWTYPE_TYPECODE= "Flowtype_typecode";
	public static final String FLOWTYPE_TYPENAME= "Flowtype_typename";
	public static final String DEPTLINE_CODE= "Deptline_code";
	public static final String DEPTLINE_NAME= "Deptline_name";
	public static final String BED_CODE= "Bed_code";
	public static final String BED_NAME= "Bed_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_mr() {
		return ((String) getAttrVal("Id_mr"));
	}	
	public void setId_mr(String Id_mr) {
		setAttrVal("Id_mr", Id_mr);
	}
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public String getId_mrcactm() {
		return ((String) getAttrVal("Id_mrcactm"));
	}	
	public void setId_mrcactm(String Id_mrcactm) {
		setAttrVal("Id_mrcactm", Id_mrcactm);
	}
	public String getId_mrtp() {
		return ((String) getAttrVal("Id_mrtp"));
	}	
	public void setId_mrtp(String Id_mrtp) {
		setAttrVal("Id_mrtp", Id_mrtp);
	}
	public String getId_su_mr() {
		return ((String) getAttrVal("Id_su_mr"));
	}	
	public void setId_su_mr(String Id_su_mr) {
		setAttrVal("Id_su_mr", Id_su_mr);
	}
	public String getSd_su_mr() {
		return ((String) getAttrVal("Sd_su_mr"));
	}	
	public void setSd_su_mr(String Sd_su_mr) {
		setAttrVal("Sd_su_mr", Sd_su_mr);
	}
	public FBoolean getFg_complete() {
		return ((FBoolean) getAttrVal("Fg_complete"));
	}	
	public void setFg_complete(FBoolean Fg_complete) {
		setAttrVal("Fg_complete", Fg_complete);
	}
	public String getId_reviewtp() {
		return ((String) getAttrVal("Id_reviewtp"));
	}	
	public void setId_reviewtp(String Id_reviewtp) {
		setAttrVal("Id_reviewtp", Id_reviewtp);
	}
	public String getSd_reviewtp() {
		return ((String) getAttrVal("Sd_reviewtp"));
	}	
	public void setSd_reviewtp(String Sd_reviewtp) {
		setAttrVal("Sd_reviewtp", Sd_reviewtp);
	}
	public String getId_mrtpl() {
		return ((String) getAttrVal("Id_mrtpl"));
	}	
	public void setId_mrtpl(String Id_mrtpl) {
		setAttrVal("Id_mrtpl", Id_mrtpl);
	}
	public String getId_mred() {
		return ((String) getAttrVal("Id_mred"));
	}	
	public void setId_mred(String Id_mred) {
		setAttrVal("Id_mred", Id_mred);
	}
	public String getStartparaed() {
		return ((String) getAttrVal("Startparaed"));
	}	
	public void setStartparaed(String Startparaed) {
		setAttrVal("Startparaed", Startparaed);
	}
	public String getId_mrtplstmd() {
		return ((String) getAttrVal("Id_mrtplstmd"));
	}	
	public void setId_mrtplstmd(String Id_mrtplstmd) {
		setAttrVal("Id_mrtplstmd", Id_mrtplstmd);
	}
	public String getSd_mrtplstmd() {
		return ((String) getAttrVal("Sd_mrtplstmd"));
	}	
	public void setSd_mrtplstmd(String Sd_mrtplstmd) {
		setAttrVal("Sd_mrtplstmd", Sd_mrtplstmd);
	}
	public String getUrl_file() {
		return ((String) getAttrVal("Url_file"));
	}	
	public void setUrl_file(String Url_file) {
		setAttrVal("Url_file", Url_file);
	}
	public String getId_emp_submit() {
		return ((String) getAttrVal("Id_emp_submit"));
	}	
	public void setId_emp_submit(String Id_emp_submit) {
		setAttrVal("Id_emp_submit", Id_emp_submit);
	}
	public FDateTime getDate_submit() {
		return ((FDateTime) getAttrVal("Date_submit"));
	}	
	public void setDate_submit(FDateTime Date_submit) {
		setAttrVal("Date_submit", Date_submit);
	}
	public String getDate_time_show() {
		return ((String) getAttrVal("Date_time_show"));
	}	
	public void setDate_time_show(String Date_time_show) {
		setAttrVal("Date_time_show", Date_time_show);
	}
	public String getId_submit_dept() {
		return ((String) getAttrVal("Id_submit_dept"));
	}	
	public void setId_submit_dept(String Id_submit_dept) {
		setAttrVal("Id_submit_dept", Id_submit_dept);
	}
	public String getCode_dept_pat() {
		return ((String) getAttrVal("Code_dept_pat"));
	}	
	public void setCode_dept_pat(String Code_dept_pat) {
		setAttrVal("Code_dept_pat", Code_dept_pat);
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
	public FDateTime getMast_doctor_date() {
		return ((FDateTime) getAttrVal("Mast_doctor_date"));
	}	
	public void setMast_doctor_date(FDateTime Mast_doctor_date) {
		setAttrVal("Mast_doctor_date", Mast_doctor_date);
	}
	public String getId_dir_doctor() {
		return ((String) getAttrVal("Id_dir_doctor"));
	}	
	public void setId_dir_doctor(String Id_dir_doctor) {
		setAttrVal("Id_dir_doctor", Id_dir_doctor);
	}
	public FDateTime getDir_doctor_date() {
		return ((FDateTime) getAttrVal("Dir_doctor_date"));
	}	
	public void setDir_doctor_date(FDateTime Dir_doctor_date) {
		setAttrVal("Dir_doctor_date", Dir_doctor_date);
	}
	public String getId_entp() {
		return ((String) getAttrVal("Id_entp"));
	}	
	public void setId_entp(String Id_entp) {
		setAttrVal("Id_entp", Id_entp);
	}
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}	
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	public FBoolean getFg_duty_doctor() {
		return ((FBoolean) getAttrVal("Fg_duty_doctor"));
	}	
	public void setFg_duty_doctor(FBoolean Fg_duty_doctor) {
		setAttrVal("Fg_duty_doctor", Fg_duty_doctor);
	}
	public FDateTime getDt_rd() {
		return ((FDateTime) getAttrVal("Dt_rd"));
	}	
	public void setDt_rd(FDateTime Dt_rd) {
		setAttrVal("Dt_rd", Dt_rd);
	}
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}	
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	public String getId_emp_higher() {
		return ((String) getAttrVal("Id_emp_higher"));
	}	
	public void setId_emp_higher(String Id_emp_higher) {
		setAttrVal("Id_emp_higher", Id_emp_higher);
	}
	public FDateTime getDt_sign() {
		return ((FDateTime) getAttrVal("Dt_sign"));
	}	
	public void setDt_sign(FDateTime Dt_sign) {
		setAttrVal("Dt_sign", Dt_sign);
	}
	public String getId_emp_lat() {
		return ((String) getAttrVal("Id_emp_lat"));
	}	
	public void setId_emp_lat(String Id_emp_lat) {
		setAttrVal("Id_emp_lat", Id_emp_lat);
	}
	public FDateTime getDt_sign_lat() {
		return ((FDateTime) getAttrVal("Dt_sign_lat"));
	}	
	public void setDt_sign_lat(FDateTime Dt_sign_lat) {
		setAttrVal("Dt_sign_lat", Dt_sign_lat);
	}
	public String getId_emp_audit() {
		return ((String) getAttrVal("Id_emp_audit"));
	}	
	public void setId_emp_audit(String Id_emp_audit) {
		setAttrVal("Id_emp_audit", Id_emp_audit);
	}
	public FDateTime getDt_audit_lat() {
		return ((FDateTime) getAttrVal("Dt_audit_lat"));
	}	
	public void setDt_audit_lat(FDateTime Dt_audit_lat) {
		setAttrVal("Dt_audit_lat", Dt_audit_lat);
	}
	public FDouble getScoreqalat() {
		return ((FDouble) getAttrVal("Scoreqalat"));
	}	
	public void setScoreqalat(FDouble Scoreqalat) {
		setAttrVal("Scoreqalat", Scoreqalat);
	}
	public FBoolean getFg_edit() {
		return ((FBoolean) getAttrVal("Fg_edit"));
	}	
	public void setFg_edit(FBoolean Fg_edit) {
		setAttrVal("Fg_edit", Fg_edit);
	}
	public FBoolean getFg_submit() {
		return ((FBoolean) getAttrVal("Fg_submit"));
	}	
	public void setFg_submit(FBoolean Fg_submit) {
		setAttrVal("Fg_submit", Fg_submit);
	}
	public FBoolean getFg_reject() {
		return ((FBoolean) getAttrVal("Fg_reject"));
	}	
	public void setFg_reject(FBoolean Fg_reject) {
		setAttrVal("Fg_reject", Fg_reject);
	}
	public FBoolean getFg_seal() {
		return ((FBoolean) getAttrVal("Fg_seal"));
	}	
	public void setFg_seal(FBoolean Fg_seal) {
		setAttrVal("Fg_seal", Fg_seal);
	}
	public FBoolean getFg_arc() {
		return ((FBoolean) getAttrVal("Fg_arc"));
	}	
	public void setFg_arc(FBoolean Fg_arc) {
		setAttrVal("Fg_arc", Fg_arc);
	}
	public FBoolean getFg_prn() {
		return ((FBoolean) getAttrVal("Fg_prn"));
	}	
	public void setFg_prn(FBoolean Fg_prn) {
		setAttrVal("Fg_prn", Fg_prn);
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
	public String getTask_id() {
		return ((String) getAttrVal("Task_id"));
	}	
	public void setTask_id(String Task_id) {
		setAttrVal("Task_id", Task_id);
	}
	public String getId_dep_pat() {
		return ((String) getAttrVal("Id_dep_pat"));
	}	
	public void setId_dep_pat(String Id_dep_pat) {
		setAttrVal("Id_dep_pat", Id_dep_pat);
	}
	public String getId_flowtype() {
		return ((String) getAttrVal("Id_flowtype"));
	}	
	public void setId_flowtype(String Id_flowtype) {
		setAttrVal("Id_flowtype", Id_flowtype);
	}
	public String getId_dep_nuradm() {
		return ((String) getAttrVal("Id_dep_nuradm"));
	}	
	public void setId_dep_nuradm(String Id_dep_nuradm) {
		setAttrVal("Id_dep_nuradm", Id_dep_nuradm);
	}
	public String getId_bed() {
		return ((String) getAttrVal("Id_bed"));
	}	
	public void setId_bed(String Id_bed) {
		setAttrVal("Id_bed", Id_bed);
	}
	public Integer getId_sex() {
		return ((Integer) getAttrVal("Id_sex"));
	}	
	public void setId_sex(Integer Id_sex) {
		setAttrVal("Id_sex", Id_sex);
	}
	public String getPat_age() {
		return ((String) getAttrVal("Pat_age"));
	}	
	public void setPat_age(String Pat_age) {
		setAttrVal("Pat_age", Pat_age);
	}
	public FBoolean getNewtop() {
		return ((FBoolean) getAttrVal("Newtop"));
	}	
	public void setNewtop(FBoolean Newtop) {
		setAttrVal("Newtop", Newtop);
	}
	public FBoolean getNewend() {
		return ((FBoolean) getAttrVal("Newend"));
	}	
	public void setNewend(FBoolean Newend) {
		setAttrVal("Newend", Newend);
	}
	public String getSign_suggestion() {
		return ((String) getAttrVal("Sign_suggestion"));
	}	
	public void setSign_suggestion(String Sign_suggestion) {
		setAttrVal("Sign_suggestion", Sign_suggestion);
	}
	public FBoolean getFg_sign() {
		return ((FBoolean) getAttrVal("Fg_sign"));
	}	
	public void setFg_sign(FBoolean Fg_sign) {
		setAttrVal("Fg_sign", Fg_sign);
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
	public String getPat_code() {
		return ((String) getAttrVal("Pat_code"));
	}	
	public void setPat_code(String Pat_code) {
		setAttrVal("Pat_code", Pat_code);
	}
	public String getPat_name() {
		return ((String) getAttrVal("Pat_name"));
	}	
	public void setPat_name(String Pat_name) {
		setAttrVal("Pat_name", Pat_name);
	}
	public String getMrcactm_code() {
		return ((String) getAttrVal("Mrcactm_code"));
	}	
	public void setMrcactm_code(String Mrcactm_code) {
		setAttrVal("Mrcactm_code", Mrcactm_code);
	}
	public String getMrcactm_name() {
		return ((String) getAttrVal("Mrcactm_name"));
	}	
	public void setMrcactm_name(String Mrcactm_name) {
		setAttrVal("Mrcactm_name", Mrcactm_name);
	}
	public String getMrtp_code() {
		return ((String) getAttrVal("Mrtp_code"));
	}	
	public void setMrtp_code(String Mrtp_code) {
		setAttrVal("Mrtp_code", Mrtp_code);
	}
	public String getMrtp_name() {
		return ((String) getAttrVal("Mrtp_name"));
	}	
	public void setMrtp_name(String Mrtp_name) {
		setAttrVal("Mrtp_name", Mrtp_name);
	}
	public String getSu_mr_code() {
		return ((String) getAttrVal("Su_mr_code"));
	}	
	public void setSu_mr_code(String Su_mr_code) {
		setAttrVal("Su_mr_code", Su_mr_code);
	}
	public String getSu_mr_name() {
		return ((String) getAttrVal("Su_mr_name"));
	}	
	public void setSu_mr_name(String Su_mr_name) {
		setAttrVal("Su_mr_name", Su_mr_name);
	}
	public String getReviewtp_code() {
		return ((String) getAttrVal("Reviewtp_code"));
	}	
	public void setReviewtp_code(String Reviewtp_code) {
		setAttrVal("Reviewtp_code", Reviewtp_code);
	}
	public String getReviewtp_name() {
		return ((String) getAttrVal("Reviewtp_name"));
	}	
	public void setReviewtp_name(String Reviewtp_name) {
		setAttrVal("Reviewtp_name", Reviewtp_name);
	}
	public String getId_mr_finish_status() {
		return ((String) getAttrVal("Id_mr_finish_status"));
	}	
	public void setId_mr_finish_status(String Id_mr_finish_status) {
		setAttrVal("Id_mr_finish_status", Id_mr_finish_status);
	}
	public String getMrtpl_code() {
		return ((String) getAttrVal("Mrtpl_code"));
	}	
	public void setMrtpl_code(String Mrtpl_code) {
		setAttrVal("Mrtpl_code", Mrtpl_code);
	}
	public String getMrtpl_name() {
		return ((String) getAttrVal("Mrtpl_name"));
	}	
	public void setMrtpl_name(String Mrtpl_name) {
		setAttrVal("Mrtpl_name", Mrtpl_name);
	}
	public String getMred_code() {
		return ((String) getAttrVal("Mred_code"));
	}	
	public void setMred_code(String Mred_code) {
		setAttrVal("Mred_code", Mred_code);
	}
	public String getMred_name() {
		return ((String) getAttrVal("Mred_name"));
	}	
	public void setMred_name(String Mred_name) {
		setAttrVal("Mred_name", Mred_name);
	}
	public String getMrtplstmd_code() {
		return ((String) getAttrVal("Mrtplstmd_code"));
	}	
	public void setMrtplstmd_code(String Mrtplstmd_code) {
		setAttrVal("Mrtplstmd_code", Mrtplstmd_code);
	}
	public String getMrtplstmd_name() {
		return ((String) getAttrVal("Mrtplstmd_name"));
	}	
	public void setMrtplstmd_name(String Mrtplstmd_name) {
		setAttrVal("Mrtplstmd_name", Mrtplstmd_name);
	}
	public String getEmp_submit_name() {
		return ((String) getAttrVal("Emp_submit_name"));
	}	
	public void setEmp_submit_name(String Emp_submit_name) {
		setAttrVal("Emp_submit_name", Emp_submit_name);
	}
	public String getEmp_submit_code() {
		return ((String) getAttrVal("Emp_submit_code"));
	}	
	public void setEmp_submit_code(String Emp_submit_code) {
		setAttrVal("Emp_submit_code", Emp_submit_code);
	}
	public String getSubmit_dept_code() {
		return ((String) getAttrVal("Submit_dept_code"));
	}	
	public void setSubmit_dept_code(String Submit_dept_code) {
		setAttrVal("Submit_dept_code", Submit_dept_code);
	}
	public String getSubmit_dept_name() {
		return ((String) getAttrVal("Submit_dept_name"));
	}	
	public void setSubmit_dept_name(String Submit_dept_name) {
		setAttrVal("Submit_dept_name", Submit_dept_name);
	}
	public String getTreat_name() {
		return ((String) getAttrVal("Treat_name"));
	}	
	public void setTreat_name(String Treat_name) {
		setAttrVal("Treat_name", Treat_name);
	}
	public String getTreat_code() {
		return ((String) getAttrVal("Treat_code"));
	}	
	public void setTreat_code(String Treat_code) {
		setAttrVal("Treat_code", Treat_code);
	}
	public String getMast_name() {
		return ((String) getAttrVal("Mast_name"));
	}	
	public void setMast_name(String Mast_name) {
		setAttrVal("Mast_name", Mast_name);
	}
	public String getMast_code() {
		return ((String) getAttrVal("Mast_code"));
	}	
	public void setMast_code(String Mast_code) {
		setAttrVal("Mast_code", Mast_code);
	}
	public String getDir_name() {
		return ((String) getAttrVal("Dir_name"));
	}	
	public void setDir_name(String Dir_name) {
		setAttrVal("Dir_name", Dir_name);
	}
	public String getDir_code() {
		return ((String) getAttrVal("Dir_code"));
	}	
	public void setDir_code(String Dir_code) {
		setAttrVal("Dir_code", Dir_code);
	}
	public String getEntp_code() {
		return ((String) getAttrVal("Entp_code"));
	}	
	public void setEntp_code(String Entp_code) {
		setAttrVal("Entp_code", Entp_code);
	}
	public String getEntp_name() {
		return ((String) getAttrVal("Entp_name"));
	}	
	public void setEntp_name(String Entp_name) {
		setAttrVal("Entp_name", Entp_name);
	}
	public String getEmp_name() {
		return ((String) getAttrVal("Emp_name"));
	}	
	public void setEmp_name(String Emp_name) {
		setAttrVal("Emp_name", Emp_name);
	}
	public String getEmp_code() {
		return ((String) getAttrVal("Emp_code"));
	}	
	public void setEmp_code(String Emp_code) {
		setAttrVal("Emp_code", Emp_code);
	}
	public String getDep_code() {
		return ((String) getAttrVal("Dep_code"));
	}	
	public void setDep_code(String Dep_code) {
		setAttrVal("Dep_code", Dep_code);
	}
	public String getDep_name() {
		return ((String) getAttrVal("Dep_name"));
	}	
	public void setDep_name(String Dep_name) {
		setAttrVal("Dep_name", Dep_name);
	}
	public String getEmp_higher_name() {
		return ((String) getAttrVal("Emp_higher_name"));
	}	
	public void setEmp_higher_name(String Emp_higher_name) {
		setAttrVal("Emp_higher_name", Emp_higher_name);
	}
	public String getEmp_higher_code() {
		return ((String) getAttrVal("Emp_higher_code"));
	}	
	public void setEmp_higher_code(String Emp_higher_code) {
		setAttrVal("Emp_higher_code", Emp_higher_code);
	}
	public String getEmp_lat_name() {
		return ((String) getAttrVal("Emp_lat_name"));
	}	
	public void setEmp_lat_name(String Emp_lat_name) {
		setAttrVal("Emp_lat_name", Emp_lat_name);
	}
	public String getEmp_lat_code() {
		return ((String) getAttrVal("Emp_lat_code"));
	}	
	public void setEmp_lat_code(String Emp_lat_code) {
		setAttrVal("Emp_lat_code", Emp_lat_code);
	}
	public String getEmp_audit_name() {
		return ((String) getAttrVal("Emp_audit_name"));
	}	
	public void setEmp_audit_name(String Emp_audit_name) {
		setAttrVal("Emp_audit_name", Emp_audit_name);
	}
	public String getEmp_audit_code() {
		return ((String) getAttrVal("Emp_audit_code"));
	}	
	public void setEmp_audit_code(String Emp_audit_code) {
		setAttrVal("Emp_audit_code", Emp_audit_code);
	}
	public String getCreateby_name() {
		return ((String) getAttrVal("Createby_name"));
	}	
	public void setCreateby_name(String Createby_name) {
		setAttrVal("Createby_name", Createby_name);
	}
	public String getCreateby_code() {
		return ((String) getAttrVal("Createby_code"));
	}	
	public void setCreateby_code(String Createby_code) {
		setAttrVal("Createby_code", Createby_code);
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
	public String getDep_pat_code() {
		return ((String) getAttrVal("Dep_pat_code"));
	}	
	public void setDep_pat_code(String Dep_pat_code) {
		setAttrVal("Dep_pat_code", Dep_pat_code);
	}
	public String getDep_pat_name() {
		return ((String) getAttrVal("Dep_pat_name"));
	}	
	public void setDep_pat_name(String Dep_pat_name) {
		setAttrVal("Dep_pat_name", Dep_pat_name);
	}
	public String getFlowtype_typecode() {
		return ((String) getAttrVal("Flowtype_typecode"));
	}	
	public void setFlowtype_typecode(String Flowtype_typecode) {
		setAttrVal("Flowtype_typecode", Flowtype_typecode);
	}
	public String getFlowtype_typename() {
		return ((String) getAttrVal("Flowtype_typename"));
	}	
	public void setFlowtype_typename(String Flowtype_typename) {
		setAttrVal("Flowtype_typename", Flowtype_typename);
	}
	public String getDeptline_code() {
		return ((String) getAttrVal("Deptline_code"));
	}	
	public void setDeptline_code(String Deptline_code) {
		setAttrVal("Deptline_code", Deptline_code);
	}
	public String getDeptline_name() {
		return ((String) getAttrVal("Deptline_name"));
	}	
	public void setDeptline_name(String Deptline_name) {
		setAttrVal("Deptline_name", Deptline_name);
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
		return "Id_mr";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_mr";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiMrDODesc.class);
	}
	
	@Override
	public Object getAllLevelAttributeValue(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getAttributeNames() {
		return getAttrNames();
	}

	@Override
	public Object getAttributeValue(String arg0) {
//		if(TITLE_FIELD.equalsIgnoreCase(arg0)){
//			String plName = this.getParentDO().getName();
//			String createUserId = this.getParentDO().getCreatedby();
//			StringBuffer title = new StringBuffer();
//			
//			String createUserName = "iih";
//			
//			
//			String opt = "提交";
////			String sdSuPl = this.getParentDO().getSd_su_pl();
////			if (IMmDictCodeConst.SD_SU_PL_SUBMIT.equals(sdSuPl)) {
////				opt = "提交";
////			} else if (IMmDictCodeConst.SD_SU_PL_CONFIRN_PASS.equals(sdSuPl)) {
////				opt = "审核通过";
////			} else if (IMmDictCodeConst.SD_SU_PL_CONFIRN_REFUSE.equals(sdSuPl)) {
////				opt = "审核驳回";
////			} else {
////				opt = "修改";
////			}
//			
//			
//			title.append("用户[" + createUserName + "]" + opt + "了[" + plName + "]");
//			return title.toString();
//		}
		return getAttrVal(arg0);
	}

	@Override
	public String getBillMakeDateField() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBillMakeDeptField() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBillMakeNumbField() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBillMakeUserField() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFrmAuditDateField() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFrmAuditUserField() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFrmInsPk() {
		return getId_mr();
	}

	@Override
	public String getFrmStateField() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFrmTitileField() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void setAttributeValue(String arg0, Object arg1) {
		if(arg0 == null || arg1 == null) return;
	    this.setAttrVal(arg0, arg1);
		
	}
	@Override
	public String getFrmTaskPkField() {
		return TASK_ID;
	}

}