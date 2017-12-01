package iih.ci.mr.nu.obstetrics.gynurafter.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.obstetrics.gynurafter.d.desc.GyNurAfterAssDODesc;
import java.math.BigDecimal;

/**
 * 简要评估 DO数据 
 * 
 */
public class GyNurAfterAssDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_ASS= "Id_ass";
	public static final String ID_PAT= "Id_pat";
	public static final String ID_ENT= "Id_ent";
	public static final String CODE_ENTP= "Code_entp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String CODE_AMR_IP= "Code_amr_ip";
	public static final String NAME_BED= "Name_bed";
	public static final String AGE= "Age";
	public static final String ID_DEP_PHY= "Id_dep_phy";
	public static final String DT_OPER= "Dt_oper";
	public static final String ID_ANESWAY= "Id_anesway";
	public static final String SD_ANESWAY= "Sd_anesway";
	public static final String OPER_DIAGNOSE= "Oper_diagnose";
	public static final String NAME_DIAGNOSE= "Name_diagnose";
	public static final String SPECASE= "Specase";
	public static final String BLEED= "Bleed";
	public static final String DT_BACK_ROOM= "Dt_back_room";
	public static final String EU_DRAFT_TUBE= "Eu_draft_tube";
	public static final String ID_PART= "Id_part";
	public static final String SD_PART= "Sd_part";
	public static final String DRAINAGE= "Drainage";
	public static final String ID_DRAINAGE_PROPER= "Id_drainage_proper";
	public static final String SD_DRAINAGE_PROPER= "Sd_drainage_proper";
	public static final String ID_DIET= "Id_diet";
	public static final String SD_DIET= "Sd_diet";
	public static final String DIETOTHER= "Dietother";
	public static final String ID_OXYGEN= "Id_oxygen";
	public static final String SD_OXYGEN= "Sd_oxygen";
	public static final String OXYGEN_TIME= "Oxygen_time";
	public static final String DT_OXYGEN_BEGIN= "Dt_oxygen_begin";
	public static final String DT_OXYGEN_END= "Dt_oxygen_end";
	public static final String OXYGEN_FLOW= "Oxygen_flow";
	public static final String ECG_TUTELAGE= "Ecg_tutelage";
	public static final String DT_ECG_BEGIN= "Dt_ecg_begin";
	public static final String DT_ECG_END= "Dt_ecg_end";
	public static final String ID_KEEPURETER= "Id_keepureter";
	public static final String SD_KEEPURETER= "Sd_keepureter";
	public static final String LONGOPEN= "Longopen";
	public static final String ID_ASS_PSN= "Id_ass_psn";
	public static final String DT_MOVEURETER= "Dt_moveureter";
	public static final String ID_MOVE_PSN= "Id_move_psn";
	public static final String DT_FIRSELFPEE= "Dt_firselfpee";
	public static final String ID_URINATECOND= "Id_urinatecond";
	public static final String SD_URINATECOND= "Sd_urinatecond";
	public static final String ID_PEESIGN_PSN= "Id_peesign_psn";
	public static final String DT_LEAVEHOS= "Dt_leavehos";
	public static final String ID_LEAVEHOS_PSN= "Id_leavehos_psn";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_PAT= "Name_pat";
	public static final String NAME_DEP_PHY= "Name_dep_phy";
	public static final String NAME_ANESWAY= "Name_anesway";
	public static final String NAME_PART= "Name_part";
	public static final String NAME_DRAINAGE_PROPER= "Name_drainage_proper";
	public static final String NAME_DIET= "Name_diet";
	public static final String NAME_OXYGEN= "Name_oxygen";
	public static final String NAME_KEEPURETER= "Name_keepureter";
	public static final String NAME_ASS_PSN= "Name_ass_psn";
	public static final String NAME_MOVE_PSN= "Name_move_psn";
	public static final String NAME_URINATECOND= "Name_urinatecond";
	public static final String NAME_PEESIGN_PSN= "Name_peesign_psn";
	public static final String NAME_LEAVEHOS_PSN= "Name_leavehos_psn";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_ass() {
		return ((String) getAttrVal("Id_ass"));
	}	
	public void setId_ass(String Id_ass) {
		setAttrVal("Id_ass", Id_ass);
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
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}	
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
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
	public String getName_bed() {
		return ((String) getAttrVal("Name_bed"));
	}	
	public void setName_bed(String Name_bed) {
		setAttrVal("Name_bed", Name_bed);
	}
	public String getAge() {
		return ((String) getAttrVal("Age"));
	}	
	public void setAge(String Age) {
		setAttrVal("Age", Age);
	}
	public String getId_dep_phy() {
		return ((String) getAttrVal("Id_dep_phy"));
	}	
	public void setId_dep_phy(String Id_dep_phy) {
		setAttrVal("Id_dep_phy", Id_dep_phy);
	}
	public FDateTime getDt_oper() {
		return ((FDateTime) getAttrVal("Dt_oper"));
	}	
	public void setDt_oper(FDateTime Dt_oper) {
		setAttrVal("Dt_oper", Dt_oper);
	}
	public String getId_anesway() {
		return ((String) getAttrVal("Id_anesway"));
	}	
	public void setId_anesway(String Id_anesway) {
		setAttrVal("Id_anesway", Id_anesway);
	}
	public String getSd_anesway() {
		return ((String) getAttrVal("Sd_anesway"));
	}	
	public void setSd_anesway(String Sd_anesway) {
		setAttrVal("Sd_anesway", Sd_anesway);
	}
	public String getOper_diagnose() {
		return ((String) getAttrVal("Oper_diagnose"));
	}	
	public void setOper_diagnose(String Oper_diagnose) {
		setAttrVal("Oper_diagnose", Oper_diagnose);
	}
	public String getName_diagnose() {
		return ((String) getAttrVal("Name_diagnose"));
	}	
	public void setName_diagnose(String Name_diagnose) {
		setAttrVal("Name_diagnose", Name_diagnose);
	}
	public String getSpecase() {
		return ((String) getAttrVal("Specase"));
	}	
	public void setSpecase(String Specase) {
		setAttrVal("Specase", Specase);
	}
	public Integer getBleed() {
		return ((Integer) getAttrVal("Bleed"));
	}	
	public void setBleed(Integer Bleed) {
		setAttrVal("Bleed", Bleed);
	}
	public FDateTime getDt_back_room() {
		return ((FDateTime) getAttrVal("Dt_back_room"));
	}	
	public void setDt_back_room(FDateTime Dt_back_room) {
		setAttrVal("Dt_back_room", Dt_back_room);
	}
	public Integer getEu_draft_tube() {
		return ((Integer) getAttrVal("Eu_draft_tube"));
	}	
	public void setEu_draft_tube(Integer Eu_draft_tube) {
		setAttrVal("Eu_draft_tube", Eu_draft_tube);
	}
	public String getId_part() {
		return ((String) getAttrVal("Id_part"));
	}	
	public void setId_part(String Id_part) {
		setAttrVal("Id_part", Id_part);
	}
	public String getSd_part() {
		return ((String) getAttrVal("Sd_part"));
	}	
	public void setSd_part(String Sd_part) {
		setAttrVal("Sd_part", Sd_part);
	}
	public Integer getDrainage() {
		return ((Integer) getAttrVal("Drainage"));
	}	
	public void setDrainage(Integer Drainage) {
		setAttrVal("Drainage", Drainage);
	}
	public String getId_drainage_proper() {
		return ((String) getAttrVal("Id_drainage_proper"));
	}	
	public void setId_drainage_proper(String Id_drainage_proper) {
		setAttrVal("Id_drainage_proper", Id_drainage_proper);
	}
	public String getSd_drainage_proper() {
		return ((String) getAttrVal("Sd_drainage_proper"));
	}	
	public void setSd_drainage_proper(String Sd_drainage_proper) {
		setAttrVal("Sd_drainage_proper", Sd_drainage_proper);
	}
	public String getId_diet() {
		return ((String) getAttrVal("Id_diet"));
	}	
	public void setId_diet(String Id_diet) {
		setAttrVal("Id_diet", Id_diet);
	}
	public String getSd_diet() {
		return ((String) getAttrVal("Sd_diet"));
	}	
	public void setSd_diet(String Sd_diet) {
		setAttrVal("Sd_diet", Sd_diet);
	}
	public String getDietother() {
		return ((String) getAttrVal("Dietother"));
	}	
	public void setDietother(String Dietother) {
		setAttrVal("Dietother", Dietother);
	}
	public String getId_oxygen() {
		return ((String) getAttrVal("Id_oxygen"));
	}	
	public void setId_oxygen(String Id_oxygen) {
		setAttrVal("Id_oxygen", Id_oxygen);
	}
	public String getSd_oxygen() {
		return ((String) getAttrVal("Sd_oxygen"));
	}	
	public void setSd_oxygen(String Sd_oxygen) {
		setAttrVal("Sd_oxygen", Sd_oxygen);
	}
	public FDouble getOxygen_time() {
		return ((FDouble) getAttrVal("Oxygen_time"));
	}	
	public void setOxygen_time(FDouble Oxygen_time) {
		setAttrVal("Oxygen_time", Oxygen_time);
	}
	public FDateTime getDt_oxygen_begin() {
		return ((FDateTime) getAttrVal("Dt_oxygen_begin"));
	}	
	public void setDt_oxygen_begin(FDateTime Dt_oxygen_begin) {
		setAttrVal("Dt_oxygen_begin", Dt_oxygen_begin);
	}
	public FDateTime getDt_oxygen_end() {
		return ((FDateTime) getAttrVal("Dt_oxygen_end"));
	}	
	public void setDt_oxygen_end(FDateTime Dt_oxygen_end) {
		setAttrVal("Dt_oxygen_end", Dt_oxygen_end);
	}
	public FDouble getOxygen_flow() {
		return ((FDouble) getAttrVal("Oxygen_flow"));
	}	
	public void setOxygen_flow(FDouble Oxygen_flow) {
		setAttrVal("Oxygen_flow", Oxygen_flow);
	}
	public FDouble getEcg_tutelage() {
		return ((FDouble) getAttrVal("Ecg_tutelage"));
	}	
	public void setEcg_tutelage(FDouble Ecg_tutelage) {
		setAttrVal("Ecg_tutelage", Ecg_tutelage);
	}
	public FDateTime getDt_ecg_begin() {
		return ((FDateTime) getAttrVal("Dt_ecg_begin"));
	}	
	public void setDt_ecg_begin(FDateTime Dt_ecg_begin) {
		setAttrVal("Dt_ecg_begin", Dt_ecg_begin);
	}
	public FDateTime getDt_ecg_end() {
		return ((FDateTime) getAttrVal("Dt_ecg_end"));
	}	
	public void setDt_ecg_end(FDateTime Dt_ecg_end) {
		setAttrVal("Dt_ecg_end", Dt_ecg_end);
	}
	public String getId_keepureter() {
		return ((String) getAttrVal("Id_keepureter"));
	}	
	public void setId_keepureter(String Id_keepureter) {
		setAttrVal("Id_keepureter", Id_keepureter);
	}
	public String getSd_keepureter() {
		return ((String) getAttrVal("Sd_keepureter"));
	}	
	public void setSd_keepureter(String Sd_keepureter) {
		setAttrVal("Sd_keepureter", Sd_keepureter);
	}
	public String getLongopen() {
		return ((String) getAttrVal("Longopen"));
	}	
	public void setLongopen(String Longopen) {
		setAttrVal("Longopen", Longopen);
	}
	public String getId_ass_psn() {
		return ((String) getAttrVal("Id_ass_psn"));
	}	
	public void setId_ass_psn(String Id_ass_psn) {
		setAttrVal("Id_ass_psn", Id_ass_psn);
	}
	public FDateTime getDt_moveureter() {
		return ((FDateTime) getAttrVal("Dt_moveureter"));
	}	
	public void setDt_moveureter(FDateTime Dt_moveureter) {
		setAttrVal("Dt_moveureter", Dt_moveureter);
	}
	public String getId_move_psn() {
		return ((String) getAttrVal("Id_move_psn"));
	}	
	public void setId_move_psn(String Id_move_psn) {
		setAttrVal("Id_move_psn", Id_move_psn);
	}
	public FDateTime getDt_firselfpee() {
		return ((FDateTime) getAttrVal("Dt_firselfpee"));
	}	
	public void setDt_firselfpee(FDateTime Dt_firselfpee) {
		setAttrVal("Dt_firselfpee", Dt_firselfpee);
	}
	public String getId_urinatecond() {
		return ((String) getAttrVal("Id_urinatecond"));
	}	
	public void setId_urinatecond(String Id_urinatecond) {
		setAttrVal("Id_urinatecond", Id_urinatecond);
	}
	public String getSd_urinatecond() {
		return ((String) getAttrVal("Sd_urinatecond"));
	}	
	public void setSd_urinatecond(String Sd_urinatecond) {
		setAttrVal("Sd_urinatecond", Sd_urinatecond);
	}
	public String getId_peesign_psn() {
		return ((String) getAttrVal("Id_peesign_psn"));
	}	
	public void setId_peesign_psn(String Id_peesign_psn) {
		setAttrVal("Id_peesign_psn", Id_peesign_psn);
	}
	public FDateTime getDt_leavehos() {
		return ((FDateTime) getAttrVal("Dt_leavehos"));
	}	
	public void setDt_leavehos(FDateTime Dt_leavehos) {
		setAttrVal("Dt_leavehos", Dt_leavehos);
	}
	public String getId_leavehos_psn() {
		return ((String) getAttrVal("Id_leavehos_psn"));
	}	
	public void setId_leavehos_psn(String Id_leavehos_psn) {
		setAttrVal("Id_leavehos_psn", Id_leavehos_psn);
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
	public String getName_anesway() {
		return ((String) getAttrVal("Name_anesway"));
	}	
	public void setName_anesway(String Name_anesway) {
		setAttrVal("Name_anesway", Name_anesway);
	}
	public String getName_part() {
		return ((String) getAttrVal("Name_part"));
	}	
	public void setName_part(String Name_part) {
		setAttrVal("Name_part", Name_part);
	}
	public String getName_drainage_proper() {
		return ((String) getAttrVal("Name_drainage_proper"));
	}	
	public void setName_drainage_proper(String Name_drainage_proper) {
		setAttrVal("Name_drainage_proper", Name_drainage_proper);
	}
	public String getName_diet() {
		return ((String) getAttrVal("Name_diet"));
	}	
	public void setName_diet(String Name_diet) {
		setAttrVal("Name_diet", Name_diet);
	}
	public String getName_oxygen() {
		return ((String) getAttrVal("Name_oxygen"));
	}	
	public void setName_oxygen(String Name_oxygen) {
		setAttrVal("Name_oxygen", Name_oxygen);
	}
	public String getName_keepureter() {
		return ((String) getAttrVal("Name_keepureter"));
	}	
	public void setName_keepureter(String Name_keepureter) {
		setAttrVal("Name_keepureter", Name_keepureter);
	}
	public String getName_ass_psn() {
		return ((String) getAttrVal("Name_ass_psn"));
	}	
	public void setName_ass_psn(String Name_ass_psn) {
		setAttrVal("Name_ass_psn", Name_ass_psn);
	}
	public String getName_move_psn() {
		return ((String) getAttrVal("Name_move_psn"));
	}	
	public void setName_move_psn(String Name_move_psn) {
		setAttrVal("Name_move_psn", Name_move_psn);
	}
	public String getName_urinatecond() {
		return ((String) getAttrVal("Name_urinatecond"));
	}	
	public void setName_urinatecond(String Name_urinatecond) {
		setAttrVal("Name_urinatecond", Name_urinatecond);
	}
	public String getName_peesign_psn() {
		return ((String) getAttrVal("Name_peesign_psn"));
	}	
	public void setName_peesign_psn(String Name_peesign_psn) {
		setAttrVal("Name_peesign_psn", Name_peesign_psn);
	}
	public String getName_leavehos_psn() {
		return ((String) getAttrVal("Name_leavehos_psn"));
	}	
	public void setName_leavehos_psn(String Name_leavehos_psn) {
		setAttrVal("Name_leavehos_psn", Name_leavehos_psn);
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
		return "Id_ass";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_MR_NU_GYAFTERASS";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(GyNurAfterAssDODesc.class);
	}
	
}