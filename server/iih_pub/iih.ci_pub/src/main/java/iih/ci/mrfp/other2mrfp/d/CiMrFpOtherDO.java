package iih.ci.mrfp.other2mrfp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mrfp.other2mrfp.d.desc.CiMrFpOtherDODesc;
import java.math.BigDecimal;

/**
 * 病案首页其他信息 DO数据 
 * 
 */
public class CiMrFpOtherDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_CIMRFPOTHER= "Id_cimrfpother";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_PAT= "Id_pat";
	public static final String ID_MRTP= "Id_mrtp";
	public static final String ID_DRUG_ALLERGY= "Id_drug_allergy";
	public static final String NAME_DRUG_ALLERGY= "Name_drug_allergy";
	public static final String ALLERGIC_DRUGS= "Allergic_drugs";
	public static final String ID_BLOOD_TYPE= "Id_blood_type";
	public static final String NAME_BLOOD_TYPE= "Name_blood_type";
	public static final String ID_RH_TYPE= "Id_rh_type";
	public static final String NAME_RH_TYPE= "Name_rh_type";
	public static final String DIROFDEPT= "Dirofdept";
	public static final String NAME_ZR_DOC= "Name_zr_doc";
	public static final String NAME_ZZ_DOC= "Name_zz_doc";
	public static final String NAME_ZY_DOC= "Name_zy_doc";
	public static final String NAME_EMP_PHY= "Name_emp_phy";
	public static final String NAME_EMP_NUR= "Name_emp_nur";
	public static final String NAME_LEARN_DOC= "Name_learn_doc";
	public static final String NAME_INTERN_DOC= "Name_intern_doc";
	public static final String NAME_QCP_DOC= "Name_qcp_doc";
	public static final String NAME_QCP_NUR= "Name_qcp_nur";
	public static final String NAME_CODER= "Name_coder";
	public static final String ID_QOM_RECORD= "Id_qom_record";
	public static final String NAME_QOM_RECORD= "Name_qom_record";
	public static final String QC_DATE= "Qc_date";
	public static final String NUM_PATHO= "Num_patho";
	public static final String OUT_HOS_MODE= "Out_hos_mode";
	public static final String NAME_OUT_HOS_MODE= "Name_out_hos_mode";
	public static final String NAME_MED_IN_1= "Name_med_in_1";
	public static final String NAME_MED_IN_2= "Name_med_in_2";
	public static final String ID_AUT_DEAD_PAT= "Id_aut_dead_pat";
	public static final String NAME_AUT_DEAD_PAT= "Name_aut_dead_pat";
	public static final String ID_IS_HAVE_INHOS_PLAN= "Id_is_have_inhos_plan";
	public static final String NAME_IS_HAVE_INHOS_PLAN= "Name_is_have_inhos_plan";
	public static final String GOAL_INHOS_PLAN= "Goal_inhos_plan";
	public static final String COMA_TIME_BEF_INHOS_DAYS= "Coma_time_bef_inhos_days";
	public static final String COMA_TIME_BEF_INHOS_HOURS= "Coma_time_bef_inhos_hours";
	public static final String COMA_TIME_BEF_INHOS_MINS= "Coma_time_bef_inhos_mins";
	public static final String COMA_TIME_INHOS_DAYS= "Coma_time_inhos_days";
	public static final String COMA_TIME_INHOS_HOURS= "Coma_time_inhos_hours";
	public static final String COMA_TIME_INHOS_MINS= "Coma_time_inhos_mins";
	public static final String VENTILATOR_USE_TIME= "Ventilator_use_time";
	public static final String TUMOR_GRADE_T= "Tumor_grade_t";
	public static final String TUMOR_GRADE_N= "Tumor_grade_n";
	public static final String TUMOR_GRADE_M= "Tumor_grade_m";
	public static final String DLB_SCORE_IN= "Dlb_score_in";
	public static final String DLB_SCORE_OUT= "Dlb_score_out";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_cimrfpother() {
		return ((String) getAttrVal("Id_cimrfpother"));
	}	
	public void setId_cimrfpother(String Id_cimrfpother) {
		setAttrVal("Id_cimrfpother", Id_cimrfpother);
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
	public String getId_mrtp() {
		return ((String) getAttrVal("Id_mrtp"));
	}	
	public void setId_mrtp(String Id_mrtp) {
		setAttrVal("Id_mrtp", Id_mrtp);
	}
	public String getId_drug_allergy() {
		return ((String) getAttrVal("Id_drug_allergy"));
	}	
	public void setId_drug_allergy(String Id_drug_allergy) {
		setAttrVal("Id_drug_allergy", Id_drug_allergy);
	}
	public String getName_drug_allergy() {
		return ((String) getAttrVal("Name_drug_allergy"));
	}	
	public void setName_drug_allergy(String Name_drug_allergy) {
		setAttrVal("Name_drug_allergy", Name_drug_allergy);
	}
	public String getAllergic_drugs() {
		return ((String) getAttrVal("Allergic_drugs"));
	}	
	public void setAllergic_drugs(String Allergic_drugs) {
		setAttrVal("Allergic_drugs", Allergic_drugs);
	}
	public String getId_blood_type() {
		return ((String) getAttrVal("Id_blood_type"));
	}	
	public void setId_blood_type(String Id_blood_type) {
		setAttrVal("Id_blood_type", Id_blood_type);
	}
	public String getName_blood_type() {
		return ((String) getAttrVal("Name_blood_type"));
	}	
	public void setName_blood_type(String Name_blood_type) {
		setAttrVal("Name_blood_type", Name_blood_type);
	}
	public String getId_rh_type() {
		return ((String) getAttrVal("Id_rh_type"));
	}	
	public void setId_rh_type(String Id_rh_type) {
		setAttrVal("Id_rh_type", Id_rh_type);
	}
	public String getName_rh_type() {
		return ((String) getAttrVal("Name_rh_type"));
	}	
	public void setName_rh_type(String Name_rh_type) {
		setAttrVal("Name_rh_type", Name_rh_type);
	}
	public String getDirofdept() {
		return ((String) getAttrVal("Dirofdept"));
	}	
	public void setDirofdept(String Dirofdept) {
		setAttrVal("Dirofdept", Dirofdept);
	}
	public String getName_zr_doc() {
		return ((String) getAttrVal("Name_zr_doc"));
	}	
	public void setName_zr_doc(String Name_zr_doc) {
		setAttrVal("Name_zr_doc", Name_zr_doc);
	}
	public String getName_zz_doc() {
		return ((String) getAttrVal("Name_zz_doc"));
	}	
	public void setName_zz_doc(String Name_zz_doc) {
		setAttrVal("Name_zz_doc", Name_zz_doc);
	}
	public String getName_zy_doc() {
		return ((String) getAttrVal("Name_zy_doc"));
	}	
	public void setName_zy_doc(String Name_zy_doc) {
		setAttrVal("Name_zy_doc", Name_zy_doc);
	}
	public String getName_emp_phy() {
		return ((String) getAttrVal("Name_emp_phy"));
	}	
	public void setName_emp_phy(String Name_emp_phy) {
		setAttrVal("Name_emp_phy", Name_emp_phy);
	}
	public String getName_emp_nur() {
		return ((String) getAttrVal("Name_emp_nur"));
	}	
	public void setName_emp_nur(String Name_emp_nur) {
		setAttrVal("Name_emp_nur", Name_emp_nur);
	}
	public String getName_learn_doc() {
		return ((String) getAttrVal("Name_learn_doc"));
	}	
	public void setName_learn_doc(String Name_learn_doc) {
		setAttrVal("Name_learn_doc", Name_learn_doc);
	}
	public String getName_intern_doc() {
		return ((String) getAttrVal("Name_intern_doc"));
	}	
	public void setName_intern_doc(String Name_intern_doc) {
		setAttrVal("Name_intern_doc", Name_intern_doc);
	}
	public String getName_qcp_doc() {
		return ((String) getAttrVal("Name_qcp_doc"));
	}	
	public void setName_qcp_doc(String Name_qcp_doc) {
		setAttrVal("Name_qcp_doc", Name_qcp_doc);
	}
	public String getName_qcp_nur() {
		return ((String) getAttrVal("Name_qcp_nur"));
	}	
	public void setName_qcp_nur(String Name_qcp_nur) {
		setAttrVal("Name_qcp_nur", Name_qcp_nur);
	}
	public String getName_coder() {
		return ((String) getAttrVal("Name_coder"));
	}	
	public void setName_coder(String Name_coder) {
		setAttrVal("Name_coder", Name_coder);
	}
	public String getId_qom_record() {
		return ((String) getAttrVal("Id_qom_record"));
	}	
	public void setId_qom_record(String Id_qom_record) {
		setAttrVal("Id_qom_record", Id_qom_record);
	}
	public String getName_qom_record() {
		return ((String) getAttrVal("Name_qom_record"));
	}	
	public void setName_qom_record(String Name_qom_record) {
		setAttrVal("Name_qom_record", Name_qom_record);
	}
	public FDate getQc_date() {
		return ((FDate) getAttrVal("Qc_date"));
	}	
	public void setQc_date(FDate Qc_date) {
		setAttrVal("Qc_date", Qc_date);
	}
	public String getNum_patho() {
		return ((String) getAttrVal("Num_patho"));
	}	
	public void setNum_patho(String Num_patho) {
		setAttrVal("Num_patho", Num_patho);
	}
	public String getOut_hos_mode() {
		return ((String) getAttrVal("Out_hos_mode"));
	}	
	public void setOut_hos_mode(String Out_hos_mode) {
		setAttrVal("Out_hos_mode", Out_hos_mode);
	}
	public String getName_out_hos_mode() {
		return ((String) getAttrVal("Name_out_hos_mode"));
	}	
	public void setName_out_hos_mode(String Name_out_hos_mode) {
		setAttrVal("Name_out_hos_mode", Name_out_hos_mode);
	}
	public String getName_med_in_1() {
		return ((String) getAttrVal("Name_med_in_1"));
	}	
	public void setName_med_in_1(String Name_med_in_1) {
		setAttrVal("Name_med_in_1", Name_med_in_1);
	}
	public String getName_med_in_2() {
		return ((String) getAttrVal("Name_med_in_2"));
	}	
	public void setName_med_in_2(String Name_med_in_2) {
		setAttrVal("Name_med_in_2", Name_med_in_2);
	}
	public String getId_aut_dead_pat() {
		return ((String) getAttrVal("Id_aut_dead_pat"));
	}	
	public void setId_aut_dead_pat(String Id_aut_dead_pat) {
		setAttrVal("Id_aut_dead_pat", Id_aut_dead_pat);
	}
	public String getName_aut_dead_pat() {
		return ((String) getAttrVal("Name_aut_dead_pat"));
	}	
	public void setName_aut_dead_pat(String Name_aut_dead_pat) {
		setAttrVal("Name_aut_dead_pat", Name_aut_dead_pat);
	}
	public String getId_is_have_inhos_plan() {
		return ((String) getAttrVal("Id_is_have_inhos_plan"));
	}	
	public void setId_is_have_inhos_plan(String Id_is_have_inhos_plan) {
		setAttrVal("Id_is_have_inhos_plan", Id_is_have_inhos_plan);
	}
	public String getName_is_have_inhos_plan() {
		return ((String) getAttrVal("Name_is_have_inhos_plan"));
	}	
	public void setName_is_have_inhos_plan(String Name_is_have_inhos_plan) {
		setAttrVal("Name_is_have_inhos_plan", Name_is_have_inhos_plan);
	}
	public String getGoal_inhos_plan() {
		return ((String) getAttrVal("Goal_inhos_plan"));
	}	
	public void setGoal_inhos_plan(String Goal_inhos_plan) {
		setAttrVal("Goal_inhos_plan", Goal_inhos_plan);
	}
	public Integer getComa_time_bef_inhos_days() {
		return ((Integer) getAttrVal("Coma_time_bef_inhos_days"));
	}	
	public void setComa_time_bef_inhos_days(Integer Coma_time_bef_inhos_days) {
		setAttrVal("Coma_time_bef_inhos_days", Coma_time_bef_inhos_days);
	}
	public Integer getComa_time_bef_inhos_hours() {
		return ((Integer) getAttrVal("Coma_time_bef_inhos_hours"));
	}	
	public void setComa_time_bef_inhos_hours(Integer Coma_time_bef_inhos_hours) {
		setAttrVal("Coma_time_bef_inhos_hours", Coma_time_bef_inhos_hours);
	}
	public Integer getComa_time_bef_inhos_mins() {
		return ((Integer) getAttrVal("Coma_time_bef_inhos_mins"));
	}	
	public void setComa_time_bef_inhos_mins(Integer Coma_time_bef_inhos_mins) {
		setAttrVal("Coma_time_bef_inhos_mins", Coma_time_bef_inhos_mins);
	}
	public Integer getComa_time_inhos_days() {
		return ((Integer) getAttrVal("Coma_time_inhos_days"));
	}	
	public void setComa_time_inhos_days(Integer Coma_time_inhos_days) {
		setAttrVal("Coma_time_inhos_days", Coma_time_inhos_days);
	}
	public Integer getComa_time_inhos_hours() {
		return ((Integer) getAttrVal("Coma_time_inhos_hours"));
	}	
	public void setComa_time_inhos_hours(Integer Coma_time_inhos_hours) {
		setAttrVal("Coma_time_inhos_hours", Coma_time_inhos_hours);
	}
	public Integer getComa_time_inhos_mins() {
		return ((Integer) getAttrVal("Coma_time_inhos_mins"));
	}	
	public void setComa_time_inhos_mins(Integer Coma_time_inhos_mins) {
		setAttrVal("Coma_time_inhos_mins", Coma_time_inhos_mins);
	}
	public Integer getVentilator_use_time() {
		return ((Integer) getAttrVal("Ventilator_use_time"));
	}	
	public void setVentilator_use_time(Integer Ventilator_use_time) {
		setAttrVal("Ventilator_use_time", Ventilator_use_time);
	}
	public String getTumor_grade_t() {
		return ((String) getAttrVal("Tumor_grade_t"));
	}	
	public void setTumor_grade_t(String Tumor_grade_t) {
		setAttrVal("Tumor_grade_t", Tumor_grade_t);
	}
	public String getTumor_grade_n() {
		return ((String) getAttrVal("Tumor_grade_n"));
	}	
	public void setTumor_grade_n(String Tumor_grade_n) {
		setAttrVal("Tumor_grade_n", Tumor_grade_n);
	}
	public String getTumor_grade_m() {
		return ((String) getAttrVal("Tumor_grade_m"));
	}	
	public void setTumor_grade_m(String Tumor_grade_m) {
		setAttrVal("Tumor_grade_m", Tumor_grade_m);
	}
	public String getDlb_score_in() {
		return ((String) getAttrVal("Dlb_score_in"));
	}	
	public void setDlb_score_in(String Dlb_score_in) {
		setAttrVal("Dlb_score_in", Dlb_score_in);
	}
	public String getDlb_score_out() {
		return ((String) getAttrVal("Dlb_score_out"));
	}	
	public void setDlb_score_out(String Dlb_score_out) {
		setAttrVal("Dlb_score_out", Dlb_score_out);
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
		return "Id_cimrfpother";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_MR_FP_OTHER";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiMrFpOtherDODesc.class);
	}
	
}