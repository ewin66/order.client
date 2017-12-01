package iih.ci.rcm.operinciinfect.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.rcm.operinciinfect.d.desc.OperIncInfectDODesc;
import java.math.BigDecimal;

/**
 * 手术切口感染 DO数据 
 * 
 */
public class OperIncInfectDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_OPERINCIINFECT= "Id_operinciinfect";
	public static final String ID_HOSPITALREPORT= "Id_hospitalreport";
	public static final String ID_OPER= "Id_oper";
	public static final String SD_OPER= "Sd_oper";
	public static final String NAME_OPER= "Name_oper";
	public static final String ISEMERGENCY= "Isemergency";
	public static final String ID_OPER_TYPE= "Id_oper_type";
	public static final String SD_OPER_TYPE= "Sd_oper_type";
	public static final String NAME_OPER_TYPE= "Name_oper_type";
	public static final String ID_TYPE_SURINCI= "Id_type_surinci";
	public static final String SD_TYPE_SURINCI= "Sd_type_surinci";
	public static final String NAME_TYPE_SURINCI= "Name_type_surinci";
	public static final String ISCAUSEINCI= "Iscauseinci";
	public static final String DT_START= "Dt_start";
	public static final String DT_END= "Dt_end";
	public static final String ID_ANES_METHODS= "Id_anes_methods";
	public static final String SD_ANES_METHODS= "Sd_anes_methods";
	public static final String NAME_ANES_METHODS= "Name_anes_methods";
	public static final String OPER_DOCTOR= "Oper_doctor";
	public static final String TECH_TITLE= "Tech_title";
	public static final String ID_INCISION_TYPE= "Id_incision_type";
	public static final String SD_INCISION_TYPE= "Sd_incision_type";
	public static final String NAME_INCISION_TYPE= "Name_incision_type";
	public static final String ID_HEAL_CONDITION= "Id_heal_condition";
	public static final String SD_HEAL_CONDITION= "Sd_heal_condition";
	public static final String NAME_HEAL_CONDITION= "Name_heal_condition";
	public static final String IS_INCI_INFECTION= "Is_inci_infection";
	public static final String ID_TYPE_SURG_SITEINFE= "Id_type_surg_siteinfe";
	public static final String SD_TYPE_SURG_SITEINFE= "Sd_type_surg_siteinfe";
	public static final String NAME_TYPE_SURG_SITEINFE= "Name_type_surg_siteinfe";
	public static final String COUNT_WHITE_CELL= "Count_white_cell";
	public static final String ID_ASA_SCORE= "Id_asa_score";
	public static final String SD_ASA_SCORE= "Sd_asa_score";
	public static final String NAME_ASA_SCORE= "Name_asa_score";
	public static final String ID_CLASS_PHY_CONDITION= "Id_class_phy_condition";
	public static final String SD_CLASS_PHY_CONDITION= "Sd_class_phy_condition";
	public static final String NAME_CLASS_PHY_CONDITION= "Name_class_phy_condition";
	public static final String ID_MULT_OPER= "Id_mult_oper";
	public static final String SD_MULT_OPER= "Sd_mult_oper";
	public static final String NAME_MULT_OPER= "Name_mult_oper";
	public static final String ID_ENDOS_SURG= "Id_endos_surg";
	public static final String SD_ENDOS_SURG= "Sd_endos_surg";
	public static final String NAME_ENDOS_SURG= "Name_endos_surg";
	public static final String ID_PROS_GRAFT= "Id_pros_graft";
	public static final String SD_PROS_GRAFT= "Sd_pros_graft";
	public static final String NAME_PROS_GRAFT= "Name_pros_graft";
	public static final String ID_SURG_SITE_NFE= "Id_surg_site_nfe";
	public static final String SD_SURG_SITE_NFE= "Sd_surg_site_nfe";
	public static final String NAME_SURG_SITE_NFE= "Name_surg_site_nfe";
	public static final String OPER_CODE= "Oper_code";
	public static final String OPER_NAME= "Oper_name";
	public static final String OPER_TYPE_CODE= "Oper_type_code";
	public static final String OPER_TYPE_NAME= "Oper_type_name";
	public static final String TYPE_SURINCI_CODE= "Type_surinci_code";
	public static final String TYPE_SURINCI_NAME= "Type_surinci_name";
	public static final String ANES_METHODS_CODE= "Anes_methods_code";
	public static final String ANES_METHODS_NAME= "Anes_methods_name";
	public static final String INCISION_TYPE_CODE= "Incision_type_code";
	public static final String INCISION_TYPE_NAME= "Incision_type_name";
	public static final String HEAL_CONDITION_CODE= "Heal_condition_code";
	public static final String HEAL_CONDITION_NAME= "Heal_condition_name";
	public static final String TYPE_SURG_SITEINFE_CODE= "Type_surg_siteinfe_code";
	public static final String TYPE_SURG_SITEINFE_NAME= "Type_surg_siteinfe_name";
	public static final String ASA_SCORE_CODE= "Asa_score_code";
	public static final String ASA_SCORE_NAME= "Asa_score_name";
	public static final String CLASS_PHY_CONDITION_CODE= "Class_phy_condition_code";
	public static final String CLASS_PHY_CONDITION_NAME= "Class_phy_condition_name";
	public static final String MULT_OPER_CODE= "Mult_oper_code";
	public static final String MULT_OPER_NAME= "Mult_oper_name";
	public static final String ENDOS_SURG_CODE= "Endos_surg_code";
	public static final String ENDOS_SURG_NAME= "Endos_surg_name";
	public static final String PROS_GRAFT_CODE= "Pros_graft_code";
	public static final String PROS_GRAFT_NAME= "Pros_graft_name";
	public static final String SURG_SITE_NFE_CODE= "Surg_site_nfe_code";
	public static final String SURG_SITE_NFE_NAME= "Surg_site_nfe_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_operinciinfect() {
		return ((String) getAttrVal("Id_operinciinfect"));
	}	
	public void setId_operinciinfect(String Id_operinciinfect) {
		setAttrVal("Id_operinciinfect", Id_operinciinfect);
	}
	public String getId_hospitalreport() {
		return ((String) getAttrVal("Id_hospitalreport"));
	}	
	public void setId_hospitalreport(String Id_hospitalreport) {
		setAttrVal("Id_hospitalreport", Id_hospitalreport);
	}
	public String getId_oper() {
		return ((String) getAttrVal("Id_oper"));
	}	
	public void setId_oper(String Id_oper) {
		setAttrVal("Id_oper", Id_oper);
	}
	public String getSd_oper() {
		return ((String) getAttrVal("Sd_oper"));
	}	
	public void setSd_oper(String Sd_oper) {
		setAttrVal("Sd_oper", Sd_oper);
	}
	public String getName_oper() {
		return ((String) getAttrVal("Name_oper"));
	}	
	public void setName_oper(String Name_oper) {
		setAttrVal("Name_oper", Name_oper);
	}
	public FBoolean getIsemergency() {
		return ((FBoolean) getAttrVal("Isemergency"));
	}	
	public void setIsemergency(FBoolean Isemergency) {
		setAttrVal("Isemergency", Isemergency);
	}
	public String getId_oper_type() {
		return ((String) getAttrVal("Id_oper_type"));
	}	
	public void setId_oper_type(String Id_oper_type) {
		setAttrVal("Id_oper_type", Id_oper_type);
	}
	public String getSd_oper_type() {
		return ((String) getAttrVal("Sd_oper_type"));
	}	
	public void setSd_oper_type(String Sd_oper_type) {
		setAttrVal("Sd_oper_type", Sd_oper_type);
	}
	public String getName_oper_type() {
		return ((String) getAttrVal("Name_oper_type"));
	}	
	public void setName_oper_type(String Name_oper_type) {
		setAttrVal("Name_oper_type", Name_oper_type);
	}
	public String getId_type_surinci() {
		return ((String) getAttrVal("Id_type_surinci"));
	}	
	public void setId_type_surinci(String Id_type_surinci) {
		setAttrVal("Id_type_surinci", Id_type_surinci);
	}
	public String getSd_type_surinci() {
		return ((String) getAttrVal("Sd_type_surinci"));
	}	
	public void setSd_type_surinci(String Sd_type_surinci) {
		setAttrVal("Sd_type_surinci", Sd_type_surinci);
	}
	public String getName_type_surinci() {
		return ((String) getAttrVal("Name_type_surinci"));
	}	
	public void setName_type_surinci(String Name_type_surinci) {
		setAttrVal("Name_type_surinci", Name_type_surinci);
	}
	public FBoolean getIscauseinci() {
		return ((FBoolean) getAttrVal("Iscauseinci"));
	}	
	public void setIscauseinci(FBoolean Iscauseinci) {
		setAttrVal("Iscauseinci", Iscauseinci);
	}
	public FDateTime getDt_start() {
		return ((FDateTime) getAttrVal("Dt_start"));
	}	
	public void setDt_start(FDateTime Dt_start) {
		setAttrVal("Dt_start", Dt_start);
	}
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}	
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	public String getId_anes_methods() {
		return ((String) getAttrVal("Id_anes_methods"));
	}	
	public void setId_anes_methods(String Id_anes_methods) {
		setAttrVal("Id_anes_methods", Id_anes_methods);
	}
	public String getSd_anes_methods() {
		return ((String) getAttrVal("Sd_anes_methods"));
	}	
	public void setSd_anes_methods(String Sd_anes_methods) {
		setAttrVal("Sd_anes_methods", Sd_anes_methods);
	}
	public String getName_anes_methods() {
		return ((String) getAttrVal("Name_anes_methods"));
	}	
	public void setName_anes_methods(String Name_anes_methods) {
		setAttrVal("Name_anes_methods", Name_anes_methods);
	}
	public String getOper_doctor() {
		return ((String) getAttrVal("Oper_doctor"));
	}	
	public void setOper_doctor(String Oper_doctor) {
		setAttrVal("Oper_doctor", Oper_doctor);
	}
	public String getTech_title() {
		return ((String) getAttrVal("Tech_title"));
	}	
	public void setTech_title(String Tech_title) {
		setAttrVal("Tech_title", Tech_title);
	}
	public String getId_incision_type() {
		return ((String) getAttrVal("Id_incision_type"));
	}	
	public void setId_incision_type(String Id_incision_type) {
		setAttrVal("Id_incision_type", Id_incision_type);
	}
	public String getSd_incision_type() {
		return ((String) getAttrVal("Sd_incision_type"));
	}	
	public void setSd_incision_type(String Sd_incision_type) {
		setAttrVal("Sd_incision_type", Sd_incision_type);
	}
	public String getName_incision_type() {
		return ((String) getAttrVal("Name_incision_type"));
	}	
	public void setName_incision_type(String Name_incision_type) {
		setAttrVal("Name_incision_type", Name_incision_type);
	}
	public String getId_heal_condition() {
		return ((String) getAttrVal("Id_heal_condition"));
	}	
	public void setId_heal_condition(String Id_heal_condition) {
		setAttrVal("Id_heal_condition", Id_heal_condition);
	}
	public String getSd_heal_condition() {
		return ((String) getAttrVal("Sd_heal_condition"));
	}	
	public void setSd_heal_condition(String Sd_heal_condition) {
		setAttrVal("Sd_heal_condition", Sd_heal_condition);
	}
	public String getName_heal_condition() {
		return ((String) getAttrVal("Name_heal_condition"));
	}	
	public void setName_heal_condition(String Name_heal_condition) {
		setAttrVal("Name_heal_condition", Name_heal_condition);
	}
	public FBoolean getIs_inci_infection() {
		return ((FBoolean) getAttrVal("Is_inci_infection"));
	}	
	public void setIs_inci_infection(FBoolean Is_inci_infection) {
		setAttrVal("Is_inci_infection", Is_inci_infection);
	}
	public String getId_type_surg_siteinfe() {
		return ((String) getAttrVal("Id_type_surg_siteinfe"));
	}	
	public void setId_type_surg_siteinfe(String Id_type_surg_siteinfe) {
		setAttrVal("Id_type_surg_siteinfe", Id_type_surg_siteinfe);
	}
	public String getSd_type_surg_siteinfe() {
		return ((String) getAttrVal("Sd_type_surg_siteinfe"));
	}	
	public void setSd_type_surg_siteinfe(String Sd_type_surg_siteinfe) {
		setAttrVal("Sd_type_surg_siteinfe", Sd_type_surg_siteinfe);
	}
	public String getName_type_surg_siteinfe() {
		return ((String) getAttrVal("Name_type_surg_siteinfe"));
	}	
	public void setName_type_surg_siteinfe(String Name_type_surg_siteinfe) {
		setAttrVal("Name_type_surg_siteinfe", Name_type_surg_siteinfe);
	}
	public Integer getCount_white_cell() {
		return ((Integer) getAttrVal("Count_white_cell"));
	}	
	public void setCount_white_cell(Integer Count_white_cell) {
		setAttrVal("Count_white_cell", Count_white_cell);
	}
	public String getId_asa_score() {
		return ((String) getAttrVal("Id_asa_score"));
	}	
	public void setId_asa_score(String Id_asa_score) {
		setAttrVal("Id_asa_score", Id_asa_score);
	}
	public String getSd_asa_score() {
		return ((String) getAttrVal("Sd_asa_score"));
	}	
	public void setSd_asa_score(String Sd_asa_score) {
		setAttrVal("Sd_asa_score", Sd_asa_score);
	}
	public String getName_asa_score() {
		return ((String) getAttrVal("Name_asa_score"));
	}	
	public void setName_asa_score(String Name_asa_score) {
		setAttrVal("Name_asa_score", Name_asa_score);
	}
	public String getId_class_phy_condition() {
		return ((String) getAttrVal("Id_class_phy_condition"));
	}	
	public void setId_class_phy_condition(String Id_class_phy_condition) {
		setAttrVal("Id_class_phy_condition", Id_class_phy_condition);
	}
	public String getSd_class_phy_condition() {
		return ((String) getAttrVal("Sd_class_phy_condition"));
	}	
	public void setSd_class_phy_condition(String Sd_class_phy_condition) {
		setAttrVal("Sd_class_phy_condition", Sd_class_phy_condition);
	}
	public String getName_class_phy_condition() {
		return ((String) getAttrVal("Name_class_phy_condition"));
	}	
	public void setName_class_phy_condition(String Name_class_phy_condition) {
		setAttrVal("Name_class_phy_condition", Name_class_phy_condition);
	}
	public String getId_mult_oper() {
		return ((String) getAttrVal("Id_mult_oper"));
	}	
	public void setId_mult_oper(String Id_mult_oper) {
		setAttrVal("Id_mult_oper", Id_mult_oper);
	}
	public String getSd_mult_oper() {
		return ((String) getAttrVal("Sd_mult_oper"));
	}	
	public void setSd_mult_oper(String Sd_mult_oper) {
		setAttrVal("Sd_mult_oper", Sd_mult_oper);
	}
	public String getName_mult_oper() {
		return ((String) getAttrVal("Name_mult_oper"));
	}	
	public void setName_mult_oper(String Name_mult_oper) {
		setAttrVal("Name_mult_oper", Name_mult_oper);
	}
	public String getId_endos_surg() {
		return ((String) getAttrVal("Id_endos_surg"));
	}	
	public void setId_endos_surg(String Id_endos_surg) {
		setAttrVal("Id_endos_surg", Id_endos_surg);
	}
	public String getSd_endos_surg() {
		return ((String) getAttrVal("Sd_endos_surg"));
	}	
	public void setSd_endos_surg(String Sd_endos_surg) {
		setAttrVal("Sd_endos_surg", Sd_endos_surg);
	}
	public String getName_endos_surg() {
		return ((String) getAttrVal("Name_endos_surg"));
	}	
	public void setName_endos_surg(String Name_endos_surg) {
		setAttrVal("Name_endos_surg", Name_endos_surg);
	}
	public String getId_pros_graft() {
		return ((String) getAttrVal("Id_pros_graft"));
	}	
	public void setId_pros_graft(String Id_pros_graft) {
		setAttrVal("Id_pros_graft", Id_pros_graft);
	}
	public String getSd_pros_graft() {
		return ((String) getAttrVal("Sd_pros_graft"));
	}	
	public void setSd_pros_graft(String Sd_pros_graft) {
		setAttrVal("Sd_pros_graft", Sd_pros_graft);
	}
	public String getName_pros_graft() {
		return ((String) getAttrVal("Name_pros_graft"));
	}	
	public void setName_pros_graft(String Name_pros_graft) {
		setAttrVal("Name_pros_graft", Name_pros_graft);
	}
	public String getId_surg_site_nfe() {
		return ((String) getAttrVal("Id_surg_site_nfe"));
	}	
	public void setId_surg_site_nfe(String Id_surg_site_nfe) {
		setAttrVal("Id_surg_site_nfe", Id_surg_site_nfe);
	}
	public String getSd_surg_site_nfe() {
		return ((String) getAttrVal("Sd_surg_site_nfe"));
	}	
	public void setSd_surg_site_nfe(String Sd_surg_site_nfe) {
		setAttrVal("Sd_surg_site_nfe", Sd_surg_site_nfe);
	}
	public String getName_surg_site_nfe() {
		return ((String) getAttrVal("Name_surg_site_nfe"));
	}	
	public void setName_surg_site_nfe(String Name_surg_site_nfe) {
		setAttrVal("Name_surg_site_nfe", Name_surg_site_nfe);
	}
	public String getOper_code() {
		return ((String) getAttrVal("Oper_code"));
	}	
	public void setOper_code(String Oper_code) {
		setAttrVal("Oper_code", Oper_code);
	}
	public String getOper_name() {
		return ((String) getAttrVal("Oper_name"));
	}	
	public void setOper_name(String Oper_name) {
		setAttrVal("Oper_name", Oper_name);
	}
	public String getOper_type_code() {
		return ((String) getAttrVal("Oper_type_code"));
	}	
	public void setOper_type_code(String Oper_type_code) {
		setAttrVal("Oper_type_code", Oper_type_code);
	}
	public String getOper_type_name() {
		return ((String) getAttrVal("Oper_type_name"));
	}	
	public void setOper_type_name(String Oper_type_name) {
		setAttrVal("Oper_type_name", Oper_type_name);
	}
	public String getType_surinci_code() {
		return ((String) getAttrVal("Type_surinci_code"));
	}	
	public void setType_surinci_code(String Type_surinci_code) {
		setAttrVal("Type_surinci_code", Type_surinci_code);
	}
	public String getType_surinci_name() {
		return ((String) getAttrVal("Type_surinci_name"));
	}	
	public void setType_surinci_name(String Type_surinci_name) {
		setAttrVal("Type_surinci_name", Type_surinci_name);
	}
	public String getAnes_methods_code() {
		return ((String) getAttrVal("Anes_methods_code"));
	}	
	public void setAnes_methods_code(String Anes_methods_code) {
		setAttrVal("Anes_methods_code", Anes_methods_code);
	}
	public String getAnes_methods_name() {
		return ((String) getAttrVal("Anes_methods_name"));
	}	
	public void setAnes_methods_name(String Anes_methods_name) {
		setAttrVal("Anes_methods_name", Anes_methods_name);
	}
	public String getIncision_type_code() {
		return ((String) getAttrVal("Incision_type_code"));
	}	
	public void setIncision_type_code(String Incision_type_code) {
		setAttrVal("Incision_type_code", Incision_type_code);
	}
	public String getIncision_type_name() {
		return ((String) getAttrVal("Incision_type_name"));
	}	
	public void setIncision_type_name(String Incision_type_name) {
		setAttrVal("Incision_type_name", Incision_type_name);
	}
	public String getHeal_condition_code() {
		return ((String) getAttrVal("Heal_condition_code"));
	}	
	public void setHeal_condition_code(String Heal_condition_code) {
		setAttrVal("Heal_condition_code", Heal_condition_code);
	}
	public String getHeal_condition_name() {
		return ((String) getAttrVal("Heal_condition_name"));
	}	
	public void setHeal_condition_name(String Heal_condition_name) {
		setAttrVal("Heal_condition_name", Heal_condition_name);
	}
	public String getType_surg_siteinfe_code() {
		return ((String) getAttrVal("Type_surg_siteinfe_code"));
	}	
	public void setType_surg_siteinfe_code(String Type_surg_siteinfe_code) {
		setAttrVal("Type_surg_siteinfe_code", Type_surg_siteinfe_code);
	}
	public String getType_surg_siteinfe_name() {
		return ((String) getAttrVal("Type_surg_siteinfe_name"));
	}	
	public void setType_surg_siteinfe_name(String Type_surg_siteinfe_name) {
		setAttrVal("Type_surg_siteinfe_name", Type_surg_siteinfe_name);
	}
	public String getAsa_score_code() {
		return ((String) getAttrVal("Asa_score_code"));
	}	
	public void setAsa_score_code(String Asa_score_code) {
		setAttrVal("Asa_score_code", Asa_score_code);
	}
	public String getAsa_score_name() {
		return ((String) getAttrVal("Asa_score_name"));
	}	
	public void setAsa_score_name(String Asa_score_name) {
		setAttrVal("Asa_score_name", Asa_score_name);
	}
	public String getClass_phy_condition_code() {
		return ((String) getAttrVal("Class_phy_condition_code"));
	}	
	public void setClass_phy_condition_code(String Class_phy_condition_code) {
		setAttrVal("Class_phy_condition_code", Class_phy_condition_code);
	}
	public String getClass_phy_condition_name() {
		return ((String) getAttrVal("Class_phy_condition_name"));
	}	
	public void setClass_phy_condition_name(String Class_phy_condition_name) {
		setAttrVal("Class_phy_condition_name", Class_phy_condition_name);
	}
	public String getMult_oper_code() {
		return ((String) getAttrVal("Mult_oper_code"));
	}	
	public void setMult_oper_code(String Mult_oper_code) {
		setAttrVal("Mult_oper_code", Mult_oper_code);
	}
	public String getMult_oper_name() {
		return ((String) getAttrVal("Mult_oper_name"));
	}	
	public void setMult_oper_name(String Mult_oper_name) {
		setAttrVal("Mult_oper_name", Mult_oper_name);
	}
	public String getEndos_surg_code() {
		return ((String) getAttrVal("Endos_surg_code"));
	}	
	public void setEndos_surg_code(String Endos_surg_code) {
		setAttrVal("Endos_surg_code", Endos_surg_code);
	}
	public String getEndos_surg_name() {
		return ((String) getAttrVal("Endos_surg_name"));
	}	
	public void setEndos_surg_name(String Endos_surg_name) {
		setAttrVal("Endos_surg_name", Endos_surg_name);
	}
	public String getPros_graft_code() {
		return ((String) getAttrVal("Pros_graft_code"));
	}	
	public void setPros_graft_code(String Pros_graft_code) {
		setAttrVal("Pros_graft_code", Pros_graft_code);
	}
	public String getPros_graft_name() {
		return ((String) getAttrVal("Pros_graft_name"));
	}	
	public void setPros_graft_name(String Pros_graft_name) {
		setAttrVal("Pros_graft_name", Pros_graft_name);
	}
	public String getSurg_site_nfe_code() {
		return ((String) getAttrVal("Surg_site_nfe_code"));
	}	
	public void setSurg_site_nfe_code(String Surg_site_nfe_code) {
		setAttrVal("Surg_site_nfe_code", Surg_site_nfe_code);
	}
	public String getSurg_site_nfe_name() {
		return ((String) getAttrVal("Surg_site_nfe_name"));
	}	
	public void setSurg_site_nfe_name(String Surg_site_nfe_name) {
		setAttrVal("Surg_site_nfe_name", Surg_site_nfe_name);
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
		return "Id_operinciinfect";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_MR_CONTAGION_CARD_INCISION";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OperIncInfectDODesc.class);
	}
	
}