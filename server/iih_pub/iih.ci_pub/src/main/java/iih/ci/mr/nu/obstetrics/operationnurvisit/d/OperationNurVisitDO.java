package iih.ci.mr.nu.obstetrics.operationnurvisit.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.obstetrics.operationnurvisit.d.desc.OperationNurVisitDODesc;
import java.math.BigDecimal;

/**
 * 手术患者术前术后护理访视表 DO数据 
 * 
 */
public class OperationNurVisitDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_OPERNUR= "Id_opernur";
	public static final String ID_GROUP= "Id_group";
	public static final String ID_ORG= "Id_org";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_PAT= "Id_pat";
	public static final String ID_SEX= "Id_sex";
	public static final String SD_SEX= "Sd_sex";
	public static final String AGE= "Age";
	public static final String CODE_AMR_IP= "Code_amr_ip";
	public static final String ID_DEP_PHY= "Id_dep_phy";
	public static final String NAME_DEP_PHY= "Name_dep_phy";
	public static final String ID_DEP_NUR= "Id_dep_nur";
	public static final String NAME_DEP_NUR= "Name_dep_nur";
	public static final String DT_OPERATION= "Dt_operation";
	public static final String ID_ANESTHESIA= "Id_anesthesia";
	public static final String SD_ANESTHESIA= "Sd_anesthesia";
	public static final String NAME_DIAGNOSIS= "Name_diagnosis";
	public static final String NAME_OPERATION= "Name_operation";
	public static final String DT_BEGINVISIT= "Dt_beginvisit";
	public static final String ID_LIVER_FUN= "Id_liver_fun";
	public static final String SD_LIVER_FUN= "Sd_liver_fun";
	public static final String ID_O= "Id_o";
	public static final String SD_O= "Sd_o";
	public static final String NAME_DISEASEHIS= "Name_diseasehis";
	public static final String NAME_OPER_HIS= "Name_oper_his";
	public static final String NAME_ALLERGY= "Name_allergy";
	public static final String ID_PHY_CON= "Id_phy_con";
	public static final String SD_PHY_CON= "Sd_phy_con";
	public static final String ID_SHAPE= "Id_shape";
	public static final String SD_SHAPE= "Sd_shape";
	public static final String ID_MENTALITY= "Id_mentality";
	public static final String SD_MENTALITY= "Sd_mentality";
	public static final String EU_DYSKINESIA= "Eu_dyskinesia";
	public static final String ID_BLOOD_VESSEL= "Id_blood_vessel";
	public static final String SD_BLOOD_VESSEL= "Sd_blood_vessel";
	public static final String DES_OPER= "Des_oper";
	public static final String ID_EMP_VISIT= "Id_emp_visit";
	public static final String DT_AFTEROPER= "Dt_afteroper";
	public static final String DAYAFTEROPER= "Dayafteroper";
	public static final String ID_SPIRIT= "Id_spirit";
	public static final String SD_SPIRIT= "Sd_spirit";
	public static final String EU_PAIN= "Eu_pain";
	public static final String ID_TEM= "Id_tem";
	public static final String SD_TEM= "Sd_tem";
	public static final String ID_WOUND_HEALING= "Id_wound_healing";
	public static final String SD_WOUND_HEALING= "Sd_wound_healing";
	public static final String EU_SKIN_BURN= "Eu_skin_burn";
	public static final String ID_OPER_EVAL= "Id_oper_eval";
	public static final String SD_OPER_EVAL= "Sd_oper_eval";
	public static final String EU_VISIT_ATTI= "Eu_visit_atti";
	public static final String SPECIALOPINION= "Specialopinion";
	public static final String ID_EMP_BACK= "Id_emp_back";
	public static final String ID_MENTAL_STATE= "Id_mental_state";
	public static final String SD_MENTAL_STATE= "Sd_mental_state";
	public static final String ID_PAT_COOPER= "Id_pat_cooper";
	public static final String SD_PAT_COOPER= "Sd_pat_cooper";
	public static final String ID_ITEM_PRE= "Id_item_pre";
	public static final String SD_ITEM_PRE= "Sd_item_pre";
	public static final String EU_NURREC= "Eu_nurrec";
	public static final String SIGNATURE_NUR= "Signature_nur";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_PAT= "Name_pat";
	public static final String NAME_SEX= "Name_sex";
	public static final String NAME_ANESTHESIA= "Name_anesthesia";
	public static final String NAME_LIVER_FUN= "Name_liver_fun";
	public static final String NAME_O= "Name_o";
	public static final String NAME_PHY_CON= "Name_phy_con";
	public static final String NAME_SHAPE= "Name_shape";
	public static final String NAME_MENTALITY= "Name_mentality";
	public static final String NAME_BLOOD_VESSEL= "Name_blood_vessel";
	public static final String NAME_EMP_VISIT= "Name_emp_visit";
	public static final String NAME_SPIRIT= "Name_spirit";
	public static final String NAME_TEM= "Name_tem";
	public static final String NAME_WOUND_HEALING= "Name_wound_healing";
	public static final String NAME_OPER_EVAL= "Name_oper_eval";
	public static final String NAME_EMP_BACK= "Name_emp_back";
	public static final String NAME_MENTAL_STATE= "Name_mental_state";
	public static final String NAME_PAT_COOPER= "Name_pat_cooper";
	public static final String NAME_ITEM_PRE= "Name_item_pre";
	public static final String NAME_NUR= "Name_nur";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_opernur() {
		return ((String) getAttrVal("Id_opernur"));
	}	
	public void setId_opernur(String Id_opernur) {
		setAttrVal("Id_opernur", Id_opernur);
	}
	public String getId_group() {
		return ((String) getAttrVal("Id_group"));
	}	
	public void setId_group(String Id_group) {
		setAttrVal("Id_group", Id_group);
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
	public String getAge() {
		return ((String) getAttrVal("Age"));
	}	
	public void setAge(String Age) {
		setAttrVal("Age", Age);
	}
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}	
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	public String getId_dep_phy() {
		return ((String) getAttrVal("Id_dep_phy"));
	}	
	public void setId_dep_phy(String Id_dep_phy) {
		setAttrVal("Id_dep_phy", Id_dep_phy);
	}
	public String getName_dep_phy() {
		return ((String) getAttrVal("Name_dep_phy"));
	}	
	public void setName_dep_phy(String Name_dep_phy) {
		setAttrVal("Name_dep_phy", Name_dep_phy);
	}
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}	
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	public String getName_dep_nur() {
		return ((String) getAttrVal("Name_dep_nur"));
	}	
	public void setName_dep_nur(String Name_dep_nur) {
		setAttrVal("Name_dep_nur", Name_dep_nur);
	}
	public FDate getDt_operation() {
		return ((FDate) getAttrVal("Dt_operation"));
	}	
	public void setDt_operation(FDate Dt_operation) {
		setAttrVal("Dt_operation", Dt_operation);
	}
	public String getId_anesthesia() {
		return ((String) getAttrVal("Id_anesthesia"));
	}	
	public void setId_anesthesia(String Id_anesthesia) {
		setAttrVal("Id_anesthesia", Id_anesthesia);
	}
	public String getSd_anesthesia() {
		return ((String) getAttrVal("Sd_anesthesia"));
	}	
	public void setSd_anesthesia(String Sd_anesthesia) {
		setAttrVal("Sd_anesthesia", Sd_anesthesia);
	}
	public String getName_diagnosis() {
		return ((String) getAttrVal("Name_diagnosis"));
	}	
	public void setName_diagnosis(String Name_diagnosis) {
		setAttrVal("Name_diagnosis", Name_diagnosis);
	}
	public String getName_operation() {
		return ((String) getAttrVal("Name_operation"));
	}	
	public void setName_operation(String Name_operation) {
		setAttrVal("Name_operation", Name_operation);
	}
	public FDate getDt_beginvisit() {
		return ((FDate) getAttrVal("Dt_beginvisit"));
	}	
	public void setDt_beginvisit(FDate Dt_beginvisit) {
		setAttrVal("Dt_beginvisit", Dt_beginvisit);
	}
	public String getId_liver_fun() {
		return ((String) getAttrVal("Id_liver_fun"));
	}	
	public void setId_liver_fun(String Id_liver_fun) {
		setAttrVal("Id_liver_fun", Id_liver_fun);
	}
	public String getSd_liver_fun() {
		return ((String) getAttrVal("Sd_liver_fun"));
	}	
	public void setSd_liver_fun(String Sd_liver_fun) {
		setAttrVal("Sd_liver_fun", Sd_liver_fun);
	}
	public String getId_o() {
		return ((String) getAttrVal("Id_o"));
	}	
	public void setId_o(String Id_o) {
		setAttrVal("Id_o", Id_o);
	}
	public String getSd_o() {
		return ((String) getAttrVal("Sd_o"));
	}	
	public void setSd_o(String Sd_o) {
		setAttrVal("Sd_o", Sd_o);
	}
	public String getName_diseasehis() {
		return ((String) getAttrVal("Name_diseasehis"));
	}	
	public void setName_diseasehis(String Name_diseasehis) {
		setAttrVal("Name_diseasehis", Name_diseasehis);
	}
	public String getName_oper_his() {
		return ((String) getAttrVal("Name_oper_his"));
	}	
	public void setName_oper_his(String Name_oper_his) {
		setAttrVal("Name_oper_his", Name_oper_his);
	}
	public String getName_allergy() {
		return ((String) getAttrVal("Name_allergy"));
	}	
	public void setName_allergy(String Name_allergy) {
		setAttrVal("Name_allergy", Name_allergy);
	}
	public String getId_phy_con() {
		return ((String) getAttrVal("Id_phy_con"));
	}	
	public void setId_phy_con(String Id_phy_con) {
		setAttrVal("Id_phy_con", Id_phy_con);
	}
	public String getSd_phy_con() {
		return ((String) getAttrVal("Sd_phy_con"));
	}	
	public void setSd_phy_con(String Sd_phy_con) {
		setAttrVal("Sd_phy_con", Sd_phy_con);
	}
	public String getId_shape() {
		return ((String) getAttrVal("Id_shape"));
	}	
	public void setId_shape(String Id_shape) {
		setAttrVal("Id_shape", Id_shape);
	}
	public String getSd_shape() {
		return ((String) getAttrVal("Sd_shape"));
	}	
	public void setSd_shape(String Sd_shape) {
		setAttrVal("Sd_shape", Sd_shape);
	}
	public String getId_mentality() {
		return ((String) getAttrVal("Id_mentality"));
	}	
	public void setId_mentality(String Id_mentality) {
		setAttrVal("Id_mentality", Id_mentality);
	}
	public String getSd_mentality() {
		return ((String) getAttrVal("Sd_mentality"));
	}	
	public void setSd_mentality(String Sd_mentality) {
		setAttrVal("Sd_mentality", Sd_mentality);
	}
	public Integer getEu_dyskinesia() {
		return ((Integer) getAttrVal("Eu_dyskinesia"));
	}	
	public void setEu_dyskinesia(Integer Eu_dyskinesia) {
		setAttrVal("Eu_dyskinesia", Eu_dyskinesia);
	}
	public String getId_blood_vessel() {
		return ((String) getAttrVal("Id_blood_vessel"));
	}	
	public void setId_blood_vessel(String Id_blood_vessel) {
		setAttrVal("Id_blood_vessel", Id_blood_vessel);
	}
	public String getSd_blood_vessel() {
		return ((String) getAttrVal("Sd_blood_vessel"));
	}	
	public void setSd_blood_vessel(String Sd_blood_vessel) {
		setAttrVal("Sd_blood_vessel", Sd_blood_vessel);
	}
	public String getDes_oper() {
		return ((String) getAttrVal("Des_oper"));
	}	
	public void setDes_oper(String Des_oper) {
		setAttrVal("Des_oper", Des_oper);
	}
	public String getId_emp_visit() {
		return ((String) getAttrVal("Id_emp_visit"));
	}	
	public void setId_emp_visit(String Id_emp_visit) {
		setAttrVal("Id_emp_visit", Id_emp_visit);
	}
	public FDate getDt_afteroper() {
		return ((FDate) getAttrVal("Dt_afteroper"));
	}	
	public void setDt_afteroper(FDate Dt_afteroper) {
		setAttrVal("Dt_afteroper", Dt_afteroper);
	}
	public Integer getDayafteroper() {
		return ((Integer) getAttrVal("Dayafteroper"));
	}	
	public void setDayafteroper(Integer Dayafteroper) {
		setAttrVal("Dayafteroper", Dayafteroper);
	}
	public String getId_spirit() {
		return ((String) getAttrVal("Id_spirit"));
	}	
	public void setId_spirit(String Id_spirit) {
		setAttrVal("Id_spirit", Id_spirit);
	}
	public String getSd_spirit() {
		return ((String) getAttrVal("Sd_spirit"));
	}	
	public void setSd_spirit(String Sd_spirit) {
		setAttrVal("Sd_spirit", Sd_spirit);
	}
	public Integer getEu_pain() {
		return ((Integer) getAttrVal("Eu_pain"));
	}	
	public void setEu_pain(Integer Eu_pain) {
		setAttrVal("Eu_pain", Eu_pain);
	}
	public String getId_tem() {
		return ((String) getAttrVal("Id_tem"));
	}	
	public void setId_tem(String Id_tem) {
		setAttrVal("Id_tem", Id_tem);
	}
	public String getSd_tem() {
		return ((String) getAttrVal("Sd_tem"));
	}	
	public void setSd_tem(String Sd_tem) {
		setAttrVal("Sd_tem", Sd_tem);
	}
	public String getId_wound_healing() {
		return ((String) getAttrVal("Id_wound_healing"));
	}	
	public void setId_wound_healing(String Id_wound_healing) {
		setAttrVal("Id_wound_healing", Id_wound_healing);
	}
	public String getSd_wound_healing() {
		return ((String) getAttrVal("Sd_wound_healing"));
	}	
	public void setSd_wound_healing(String Sd_wound_healing) {
		setAttrVal("Sd_wound_healing", Sd_wound_healing);
	}
	public Integer getEu_skin_burn() {
		return ((Integer) getAttrVal("Eu_skin_burn"));
	}	
	public void setEu_skin_burn(Integer Eu_skin_burn) {
		setAttrVal("Eu_skin_burn", Eu_skin_burn);
	}
	public String getId_oper_eval() {
		return ((String) getAttrVal("Id_oper_eval"));
	}	
	public void setId_oper_eval(String Id_oper_eval) {
		setAttrVal("Id_oper_eval", Id_oper_eval);
	}
	public String getSd_oper_eval() {
		return ((String) getAttrVal("Sd_oper_eval"));
	}	
	public void setSd_oper_eval(String Sd_oper_eval) {
		setAttrVal("Sd_oper_eval", Sd_oper_eval);
	}
	public Integer getEu_visit_atti() {
		return ((Integer) getAttrVal("Eu_visit_atti"));
	}	
	public void setEu_visit_atti(Integer Eu_visit_atti) {
		setAttrVal("Eu_visit_atti", Eu_visit_atti);
	}
	public String getSpecialopinion() {
		return ((String) getAttrVal("Specialopinion"));
	}	
	public void setSpecialopinion(String Specialopinion) {
		setAttrVal("Specialopinion", Specialopinion);
	}
	public String getId_emp_back() {
		return ((String) getAttrVal("Id_emp_back"));
	}	
	public void setId_emp_back(String Id_emp_back) {
		setAttrVal("Id_emp_back", Id_emp_back);
	}
	public String getId_mental_state() {
		return ((String) getAttrVal("Id_mental_state"));
	}	
	public void setId_mental_state(String Id_mental_state) {
		setAttrVal("Id_mental_state", Id_mental_state);
	}
	public String getSd_mental_state() {
		return ((String) getAttrVal("Sd_mental_state"));
	}	
	public void setSd_mental_state(String Sd_mental_state) {
		setAttrVal("Sd_mental_state", Sd_mental_state);
	}
	public String getId_pat_cooper() {
		return ((String) getAttrVal("Id_pat_cooper"));
	}	
	public void setId_pat_cooper(String Id_pat_cooper) {
		setAttrVal("Id_pat_cooper", Id_pat_cooper);
	}
	public String getSd_pat_cooper() {
		return ((String) getAttrVal("Sd_pat_cooper"));
	}	
	public void setSd_pat_cooper(String Sd_pat_cooper) {
		setAttrVal("Sd_pat_cooper", Sd_pat_cooper);
	}
	public String getId_item_pre() {
		return ((String) getAttrVal("Id_item_pre"));
	}	
	public void setId_item_pre(String Id_item_pre) {
		setAttrVal("Id_item_pre", Id_item_pre);
	}
	public String getSd_item_pre() {
		return ((String) getAttrVal("Sd_item_pre"));
	}	
	public void setSd_item_pre(String Sd_item_pre) {
		setAttrVal("Sd_item_pre", Sd_item_pre);
	}
	public Integer getEu_nurrec() {
		return ((Integer) getAttrVal("Eu_nurrec"));
	}	
	public void setEu_nurrec(Integer Eu_nurrec) {
		setAttrVal("Eu_nurrec", Eu_nurrec);
	}
	public String getSignature_nur() {
		return ((String) getAttrVal("Signature_nur"));
	}	
	public void setSignature_nur(String Signature_nur) {
		setAttrVal("Signature_nur", Signature_nur);
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
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}	
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
	}
	public String getName_anesthesia() {
		return ((String) getAttrVal("Name_anesthesia"));
	}	
	public void setName_anesthesia(String Name_anesthesia) {
		setAttrVal("Name_anesthesia", Name_anesthesia);
	}
	public String getName_liver_fun() {
		return ((String) getAttrVal("Name_liver_fun"));
	}	
	public void setName_liver_fun(String Name_liver_fun) {
		setAttrVal("Name_liver_fun", Name_liver_fun);
	}
	public String getName_o() {
		return ((String) getAttrVal("Name_o"));
	}	
	public void setName_o(String Name_o) {
		setAttrVal("Name_o", Name_o);
	}
	public String getName_phy_con() {
		return ((String) getAttrVal("Name_phy_con"));
	}	
	public void setName_phy_con(String Name_phy_con) {
		setAttrVal("Name_phy_con", Name_phy_con);
	}
	public String getName_shape() {
		return ((String) getAttrVal("Name_shape"));
	}	
	public void setName_shape(String Name_shape) {
		setAttrVal("Name_shape", Name_shape);
	}
	public String getName_mentality() {
		return ((String) getAttrVal("Name_mentality"));
	}	
	public void setName_mentality(String Name_mentality) {
		setAttrVal("Name_mentality", Name_mentality);
	}
	public String getName_blood_vessel() {
		return ((String) getAttrVal("Name_blood_vessel"));
	}	
	public void setName_blood_vessel(String Name_blood_vessel) {
		setAttrVal("Name_blood_vessel", Name_blood_vessel);
	}
	public String getName_emp_visit() {
		return ((String) getAttrVal("Name_emp_visit"));
	}	
	public void setName_emp_visit(String Name_emp_visit) {
		setAttrVal("Name_emp_visit", Name_emp_visit);
	}
	public String getName_spirit() {
		return ((String) getAttrVal("Name_spirit"));
	}	
	public void setName_spirit(String Name_spirit) {
		setAttrVal("Name_spirit", Name_spirit);
	}
	public String getName_tem() {
		return ((String) getAttrVal("Name_tem"));
	}	
	public void setName_tem(String Name_tem) {
		setAttrVal("Name_tem", Name_tem);
	}
	public String getName_wound_healing() {
		return ((String) getAttrVal("Name_wound_healing"));
	}	
	public void setName_wound_healing(String Name_wound_healing) {
		setAttrVal("Name_wound_healing", Name_wound_healing);
	}
	public String getName_oper_eval() {
		return ((String) getAttrVal("Name_oper_eval"));
	}	
	public void setName_oper_eval(String Name_oper_eval) {
		setAttrVal("Name_oper_eval", Name_oper_eval);
	}
	public String getName_emp_back() {
		return ((String) getAttrVal("Name_emp_back"));
	}	
	public void setName_emp_back(String Name_emp_back) {
		setAttrVal("Name_emp_back", Name_emp_back);
	}
	public String getName_mental_state() {
		return ((String) getAttrVal("Name_mental_state"));
	}	
	public void setName_mental_state(String Name_mental_state) {
		setAttrVal("Name_mental_state", Name_mental_state);
	}
	public String getName_pat_cooper() {
		return ((String) getAttrVal("Name_pat_cooper"));
	}	
	public void setName_pat_cooper(String Name_pat_cooper) {
		setAttrVal("Name_pat_cooper", Name_pat_cooper);
	}
	public String getName_item_pre() {
		return ((String) getAttrVal("Name_item_pre"));
	}	
	public void setName_item_pre(String Name_item_pre) {
		setAttrVal("Name_item_pre", Name_item_pre);
	}
	public String getName_nur() {
		return ((String) getAttrVal("Name_nur"));
	}	
	public void setName_nur(String Name_nur) {
		setAttrVal("Name_nur", Name_nur);
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
		return "Id_opernur";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_mr_nu_opernur";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OperationNurVisitDODesc.class);
	}
	
}