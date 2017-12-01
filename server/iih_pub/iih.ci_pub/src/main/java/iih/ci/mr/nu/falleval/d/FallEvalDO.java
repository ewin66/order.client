package iih.ci.mr.nu.falleval.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.falleval.d.desc.FallEvalDODesc;
import java.math.BigDecimal;

/**
 * 跌倒危险因素评估表 DO数据 
 * 
 */
public class FallEvalDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_FE= "Id_fe";
	public static final String ID_PAT= "Id_pat";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_DEP_PHY= "Id_dep_phy";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_SEX= "Id_sex";
	public static final String SD_SEX= "Sd_sex";
	public static final String AGE= "Age";
	public static final String NAME_BED= "Name_bed";
	public static final String CODE_AMR_IP= "Code_amr_ip";
	public static final String DT_ENTRY= "Dt_entry";
	public static final String NAME_DIAGNOSIS= "Name_diagnosis";
	public static final String ID_HISOFFALL= "Id_hisoffall";
	public static final String SD_HISOFFALL= "Sd_hisoffall";
	public static final String SCORE_HISOFFALL= "Score_hisoffall";
	public static final String ID_OVERADIAGN= "Id_overadiagn";
	public static final String SD_OVERADIAGN= "Sd_overadiagn";
	public static final String SCORE_OVERADIAGN= "Score_overadiagn";
	public static final String ID_WALKAUX= "Id_walkaux";
	public static final String SD_WALKAUX= "Sd_walkaux";
	public static final String SCORE_WALKAUX= "Score_walkaux";
	public static final String ID_VENTRANSFUS= "Id_ventransfus";
	public static final String SD_VENTRANSFUS= "Sd_ventransfus";
	public static final String SCORE_VENTRANSFUS= "Score_ventransfus";
	public static final String ID_GAIT_STATE= "Id_gait_state";
	public static final String SD_GAIT_STATE= "Sd_gait_state";
	public static final String SCORE_GAIT_STATE= "Score_gait_state";
	public static final String ID_COGNITIVE_STATE= "Id_cognitive_state";
	public static final String SD_COGNITIVE_STATE= "Sd_cognitive_state";
	public static final String SCORE_COGNITIVE_STATE= "Score_cognitive_state";
	public static final String TOTAL= "Total";
	public static final String ASSRESULT= "Assresult";
	public static final String DT_ASS= "Dt_ass";
	public static final String ID_NUR_PSN= "Id_nur_psn";
	public static final String ID_HDNUR_ROOM= "Id_hdnur_room";
	public static final String RALATION= "Ralation";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_PAT= "Name_pat";
	public static final String NAME_DEP_PHY= "Name_dep_phy";
	public static final String NAME_SEX= "Name_sex";
	public static final String NAME_HISOFFALL= "Name_hisoffall";
	public static final String NAME_OVERADIAGN= "Name_overadiagn";
	public static final String NAME_WALKAUX= "Name_walkaux";
	public static final String NAME_VENTRANSFUS= "Name_ventransfus";
	public static final String NAME_GAIT_STATE= "Name_gait_state";
	public static final String NAME_COGNITIVE_STATE= "Name_cognitive_state";
	public static final String NAME_NUR_PSN= "Name_nur_psn";
	public static final String NAME_HDNUR_ROOM= "Name_hdnur_room";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_fe() {
		return ((String) getAttrVal("Id_fe"));
	}	
	public void setId_fe(String Id_fe) {
		setAttrVal("Id_fe", Id_fe);
	}
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	public String getId_dep_phy() {
		return ((String) getAttrVal("Id_dep_phy"));
	}	
	public void setId_dep_phy(String Id_dep_phy) {
		setAttrVal("Id_dep_phy", Id_dep_phy);
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
	public String getName_bed() {
		return ((String) getAttrVal("Name_bed"));
	}	
	public void setName_bed(String Name_bed) {
		setAttrVal("Name_bed", Name_bed);
	}
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}	
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	public FDateTime getDt_entry() {
		return ((FDateTime) getAttrVal("Dt_entry"));
	}	
	public void setDt_entry(FDateTime Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	public String getName_diagnosis() {
		return ((String) getAttrVal("Name_diagnosis"));
	}	
	public void setName_diagnosis(String Name_diagnosis) {
		setAttrVal("Name_diagnosis", Name_diagnosis);
	}
	public String getId_hisoffall() {
		return ((String) getAttrVal("Id_hisoffall"));
	}	
	public void setId_hisoffall(String Id_hisoffall) {
		setAttrVal("Id_hisoffall", Id_hisoffall);
	}
	public String getSd_hisoffall() {
		return ((String) getAttrVal("Sd_hisoffall"));
	}	
	public void setSd_hisoffall(String Sd_hisoffall) {
		setAttrVal("Sd_hisoffall", Sd_hisoffall);
	}
	public String getScore_hisoffall() {
		return ((String) getAttrVal("Score_hisoffall"));
	}	
	public void setScore_hisoffall(String Score_hisoffall) {
		setAttrVal("Score_hisoffall", Score_hisoffall);
	}
	public String getId_overadiagn() {
		return ((String) getAttrVal("Id_overadiagn"));
	}	
	public void setId_overadiagn(String Id_overadiagn) {
		setAttrVal("Id_overadiagn", Id_overadiagn);
	}
	public String getSd_overadiagn() {
		return ((String) getAttrVal("Sd_overadiagn"));
	}	
	public void setSd_overadiagn(String Sd_overadiagn) {
		setAttrVal("Sd_overadiagn", Sd_overadiagn);
	}
	public String getScore_overadiagn() {
		return ((String) getAttrVal("Score_overadiagn"));
	}	
	public void setScore_overadiagn(String Score_overadiagn) {
		setAttrVal("Score_overadiagn", Score_overadiagn);
	}
	public String getId_walkaux() {
		return ((String) getAttrVal("Id_walkaux"));
	}	
	public void setId_walkaux(String Id_walkaux) {
		setAttrVal("Id_walkaux", Id_walkaux);
	}
	public String getSd_walkaux() {
		return ((String) getAttrVal("Sd_walkaux"));
	}	
	public void setSd_walkaux(String Sd_walkaux) {
		setAttrVal("Sd_walkaux", Sd_walkaux);
	}
	public String getScore_walkaux() {
		return ((String) getAttrVal("Score_walkaux"));
	}	
	public void setScore_walkaux(String Score_walkaux) {
		setAttrVal("Score_walkaux", Score_walkaux);
	}
	public String getId_ventransfus() {
		return ((String) getAttrVal("Id_ventransfus"));
	}	
	public void setId_ventransfus(String Id_ventransfus) {
		setAttrVal("Id_ventransfus", Id_ventransfus);
	}
	public String getSd_ventransfus() {
		return ((String) getAttrVal("Sd_ventransfus"));
	}	
	public void setSd_ventransfus(String Sd_ventransfus) {
		setAttrVal("Sd_ventransfus", Sd_ventransfus);
	}
	public String getScore_ventransfus() {
		return ((String) getAttrVal("Score_ventransfus"));
	}	
	public void setScore_ventransfus(String Score_ventransfus) {
		setAttrVal("Score_ventransfus", Score_ventransfus);
	}
	public String getId_gait_state() {
		return ((String) getAttrVal("Id_gait_state"));
	}	
	public void setId_gait_state(String Id_gait_state) {
		setAttrVal("Id_gait_state", Id_gait_state);
	}
	public String getSd_gait_state() {
		return ((String) getAttrVal("Sd_gait_state"));
	}	
	public void setSd_gait_state(String Sd_gait_state) {
		setAttrVal("Sd_gait_state", Sd_gait_state);
	}
	public String getScore_gait_state() {
		return ((String) getAttrVal("Score_gait_state"));
	}	
	public void setScore_gait_state(String Score_gait_state) {
		setAttrVal("Score_gait_state", Score_gait_state);
	}
	public String getId_cognitive_state() {
		return ((String) getAttrVal("Id_cognitive_state"));
	}	
	public void setId_cognitive_state(String Id_cognitive_state) {
		setAttrVal("Id_cognitive_state", Id_cognitive_state);
	}
	public String getSd_cognitive_state() {
		return ((String) getAttrVal("Sd_cognitive_state"));
	}	
	public void setSd_cognitive_state(String Sd_cognitive_state) {
		setAttrVal("Sd_cognitive_state", Sd_cognitive_state);
	}
	public String getScore_cognitive_state() {
		return ((String) getAttrVal("Score_cognitive_state"));
	}	
	public void setScore_cognitive_state(String Score_cognitive_state) {
		setAttrVal("Score_cognitive_state", Score_cognitive_state);
	}
	public Integer getTotal() {
		return ((Integer) getAttrVal("Total"));
	}	
	public void setTotal(Integer Total) {
		setAttrVal("Total", Total);
	}
	public String getAssresult() {
		return ((String) getAttrVal("Assresult"));
	}	
	public void setAssresult(String Assresult) {
		setAttrVal("Assresult", Assresult);
	}
	public FDateTime getDt_ass() {
		return ((FDateTime) getAttrVal("Dt_ass"));
	}	
	public void setDt_ass(FDateTime Dt_ass) {
		setAttrVal("Dt_ass", Dt_ass);
	}
	public String getId_nur_psn() {
		return ((String) getAttrVal("Id_nur_psn"));
	}	
	public void setId_nur_psn(String Id_nur_psn) {
		setAttrVal("Id_nur_psn", Id_nur_psn);
	}
	public String getId_hdnur_room() {
		return ((String) getAttrVal("Id_hdnur_room"));
	}	
	public void setId_hdnur_room(String Id_hdnur_room) {
		setAttrVal("Id_hdnur_room", Id_hdnur_room);
	}
	public String getRalation() {
		return ((String) getAttrVal("Ralation"));
	}	
	public void setRalation(String Ralation) {
		setAttrVal("Ralation", Ralation);
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
	public String getName_dep_phy() {
		return ((String) getAttrVal("Name_dep_phy"));
	}	
	public void setName_dep_phy(String Name_dep_phy) {
		setAttrVal("Name_dep_phy", Name_dep_phy);
	}
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}	
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
	}
	public String getName_hisoffall() {
		return ((String) getAttrVal("Name_hisoffall"));
	}	
	public void setName_hisoffall(String Name_hisoffall) {
		setAttrVal("Name_hisoffall", Name_hisoffall);
	}
	public String getName_overadiagn() {
		return ((String) getAttrVal("Name_overadiagn"));
	}	
	public void setName_overadiagn(String Name_overadiagn) {
		setAttrVal("Name_overadiagn", Name_overadiagn);
	}
	public String getName_walkaux() {
		return ((String) getAttrVal("Name_walkaux"));
	}	
	public void setName_walkaux(String Name_walkaux) {
		setAttrVal("Name_walkaux", Name_walkaux);
	}
	public String getName_ventransfus() {
		return ((String) getAttrVal("Name_ventransfus"));
	}	
	public void setName_ventransfus(String Name_ventransfus) {
		setAttrVal("Name_ventransfus", Name_ventransfus);
	}
	public String getName_gait_state() {
		return ((String) getAttrVal("Name_gait_state"));
	}	
	public void setName_gait_state(String Name_gait_state) {
		setAttrVal("Name_gait_state", Name_gait_state);
	}
	public String getName_cognitive_state() {
		return ((String) getAttrVal("Name_cognitive_state"));
	}	
	public void setName_cognitive_state(String Name_cognitive_state) {
		setAttrVal("Name_cognitive_state", Name_cognitive_state);
	}
	public String getName_nur_psn() {
		return ((String) getAttrVal("Name_nur_psn"));
	}	
	public void setName_nur_psn(String Name_nur_psn) {
		setAttrVal("Name_nur_psn", Name_nur_psn);
	}
	public String getName_hdnur_room() {
		return ((String) getAttrVal("Name_hdnur_room"));
	}	
	public void setName_hdnur_room(String Name_hdnur_room) {
		setAttrVal("Name_hdnur_room", Name_hdnur_room);
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
		return "Id_fe";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_MR_NU_MORSE";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(FallEvalDODesc.class);
	}
	
}