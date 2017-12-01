package iih.ci.rcm.au.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.rcm.au.d.desc.AntibioticUseDODesc;
import java.math.BigDecimal;

/**
 * 抗菌用药 DO数据 
 * 
 */
public class AntibioticUseDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_AU= "Id_au";
	public static final String ID_HOSPITALREPORT= "Id_hospitalreport";
	public static final String ISUSEANTIBI= "Isuseantibi";
	public static final String ID_DRUG= "Id_drug";
	public static final String SD_DRUG= "Sd_drug";
	public static final String NAME_DRUG= "Name_drug";
	public static final String ID_ROUTE_ADMINIS= "Id_route_adminis";
	public static final String SD_ROUTE_ADMINIS= "Sd_route_adminis";
	public static final String NAME_ROUTE_ADMINIS= "Name_route_adminis";
	public static final String DOSE= "Dose";
	public static final String ID_DOSE_UNIT= "Id_dose_unit";
	public static final String SD_DOSE_UNIT= "Sd_dose_unit";
	public static final String NAME_DOSE_UNIT= "Name_dose_unit";
	public static final String USAGE= "Usage";
	public static final String DT_START= "Dt_start";
	public static final String DT_END= "Dt_end";
	public static final String ID_MEDI_METHODS= "Id_medi_methods";
	public static final String SD_MEDI_METHODS= "Sd_medi_methods";
	public static final String NAME_MEDI_METHODS= "Name_medi_methods";
	public static final String ID_OBJECTIVE= "Id_objective";
	public static final String SD_OBJECTIVE= "Sd_objective";
	public static final String NAME_OBJECTIVE= "Name_objective";
	public static final String ID_TREAT_METHODS= "Id_treat_methods";
	public static final String SD_TREAT_METHODS= "Sd_treat_methods";
	public static final String NAME_TREAT_METHODS= "Name_treat_methods";
	public static final String ID_PRE_METHODS= "Id_pre_methods";
	public static final String SD_PRE_METHODS= "Sd_pre_methods";
	public static final String NAME_PRE_METHODS= "Name_pre_methods";
	public static final String IS_PRE_DRUG_USE= "Is_pre_drug_use";
	public static final String ID_PRE_EFFECT= "Id_pre_effect";
	public static final String SD_PRE_EFFECT= "Sd_pre_effect";
	public static final String NAME_PRE_EFFECT= "Name_pre_effect";
	public static final String ID_COM_MEDI= "Id_com_medi";
	public static final String SD_COM_MEDI= "Sd_com_medi";
	public static final String NAME_COM_MEDI= "Name_com_medi";
	public static final String PRE_MEDI_TIME= "Pre_medi_time";
	public static final String DAYS_AFTER_OPER= "Days_after_oper";
	public static final String ADV_DRUG_REACTIONS= "Adv_drug_reactions";
	public static final String DOUBLE_INFECTION= "Double_infection";
	public static final String DRUG_CODE= "Drug_code";
	public static final String DRUG_NAME= "Drug_name";
	public static final String ROUTE_ADMINIS_CODE= "Route_adminis_code";
	public static final String ROUTE_ADMINIS_NAME= "Route_adminis_name";
	public static final String DOSE_UNIT_CODE= "Dose_unit_code";
	public static final String DOSE_UNIT_NAME= "Dose_unit_name";
	public static final String MEDI_METHODS_CODE= "Medi_methods_code";
	public static final String MEDI_METHODS_NAME= "Medi_methods_name";
	public static final String OBJECTIVE_CODE= "Objective_code";
	public static final String OBJECTIVE_NAME= "Objective_name";
	public static final String TREAT_METHODS_CODE= "Treat_methods_code";
	public static final String TREAT_METHODS_NAME= "Treat_methods_name";
	public static final String PRE_METHODS_CODE= "Pre_methods_code";
	public static final String PRE_METHODS_NAME= "Pre_methods_name";
	public static final String PRE_EFFECT_CODE= "Pre_effect_code";
	public static final String PRE_EFFECT_NAME= "Pre_effect_name";
	public static final String COM_MEDI_CODE= "Com_medi_code";
	public static final String COM_MEDI_NAME= "Com_medi_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_au() {
		return ((String) getAttrVal("Id_au"));
	}	
	public void setId_au(String Id_au) {
		setAttrVal("Id_au", Id_au);
	}
	public String getId_hospitalreport() {
		return ((String) getAttrVal("Id_hospitalreport"));
	}	
	public void setId_hospitalreport(String Id_hospitalreport) {
		setAttrVal("Id_hospitalreport", Id_hospitalreport);
	}
	public FBoolean getIsuseantibi() {
		return ((FBoolean) getAttrVal("Isuseantibi"));
	}	
	public void setIsuseantibi(FBoolean Isuseantibi) {
		setAttrVal("Isuseantibi", Isuseantibi);
	}
	public String getId_drug() {
		return ((String) getAttrVal("Id_drug"));
	}	
	public void setId_drug(String Id_drug) {
		setAttrVal("Id_drug", Id_drug);
	}
	public String getSd_drug() {
		return ((String) getAttrVal("Sd_drug"));
	}	
	public void setSd_drug(String Sd_drug) {
		setAttrVal("Sd_drug", Sd_drug);
	}
	public String getName_drug() {
		return ((String) getAttrVal("Name_drug"));
	}	
	public void setName_drug(String Name_drug) {
		setAttrVal("Name_drug", Name_drug);
	}
	public String getId_route_adminis() {
		return ((String) getAttrVal("Id_route_adminis"));
	}	
	public void setId_route_adminis(String Id_route_adminis) {
		setAttrVal("Id_route_adminis", Id_route_adminis);
	}
	public String getSd_route_adminis() {
		return ((String) getAttrVal("Sd_route_adminis"));
	}	
	public void setSd_route_adminis(String Sd_route_adminis) {
		setAttrVal("Sd_route_adminis", Sd_route_adminis);
	}
	public String getName_route_adminis() {
		return ((String) getAttrVal("Name_route_adminis"));
	}	
	public void setName_route_adminis(String Name_route_adminis) {
		setAttrVal("Name_route_adminis", Name_route_adminis);
	}
	public String getDose() {
		return ((String) getAttrVal("Dose"));
	}	
	public void setDose(String Dose) {
		setAttrVal("Dose", Dose);
	}
	public String getId_dose_unit() {
		return ((String) getAttrVal("Id_dose_unit"));
	}	
	public void setId_dose_unit(String Id_dose_unit) {
		setAttrVal("Id_dose_unit", Id_dose_unit);
	}
	public String getSd_dose_unit() {
		return ((String) getAttrVal("Sd_dose_unit"));
	}	
	public void setSd_dose_unit(String Sd_dose_unit) {
		setAttrVal("Sd_dose_unit", Sd_dose_unit);
	}
	public String getName_dose_unit() {
		return ((String) getAttrVal("Name_dose_unit"));
	}	
	public void setName_dose_unit(String Name_dose_unit) {
		setAttrVal("Name_dose_unit", Name_dose_unit);
	}
	public Integer getUsage() {
		return ((Integer) getAttrVal("Usage"));
	}	
	public void setUsage(Integer Usage) {
		setAttrVal("Usage", Usage);
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
	public String getId_medi_methods() {
		return ((String) getAttrVal("Id_medi_methods"));
	}	
	public void setId_medi_methods(String Id_medi_methods) {
		setAttrVal("Id_medi_methods", Id_medi_methods);
	}
	public String getSd_medi_methods() {
		return ((String) getAttrVal("Sd_medi_methods"));
	}	
	public void setSd_medi_methods(String Sd_medi_methods) {
		setAttrVal("Sd_medi_methods", Sd_medi_methods);
	}
	public String getName_medi_methods() {
		return ((String) getAttrVal("Name_medi_methods"));
	}	
	public void setName_medi_methods(String Name_medi_methods) {
		setAttrVal("Name_medi_methods", Name_medi_methods);
	}
	public String getId_objective() {
		return ((String) getAttrVal("Id_objective"));
	}	
	public void setId_objective(String Id_objective) {
		setAttrVal("Id_objective", Id_objective);
	}
	public String getSd_objective() {
		return ((String) getAttrVal("Sd_objective"));
	}	
	public void setSd_objective(String Sd_objective) {
		setAttrVal("Sd_objective", Sd_objective);
	}
	public String getName_objective() {
		return ((String) getAttrVal("Name_objective"));
	}	
	public void setName_objective(String Name_objective) {
		setAttrVal("Name_objective", Name_objective);
	}
	public String getId_treat_methods() {
		return ((String) getAttrVal("Id_treat_methods"));
	}	
	public void setId_treat_methods(String Id_treat_methods) {
		setAttrVal("Id_treat_methods", Id_treat_methods);
	}
	public String getSd_treat_methods() {
		return ((String) getAttrVal("Sd_treat_methods"));
	}	
	public void setSd_treat_methods(String Sd_treat_methods) {
		setAttrVal("Sd_treat_methods", Sd_treat_methods);
	}
	public String getName_treat_methods() {
		return ((String) getAttrVal("Name_treat_methods"));
	}	
	public void setName_treat_methods(String Name_treat_methods) {
		setAttrVal("Name_treat_methods", Name_treat_methods);
	}
	public String getId_pre_methods() {
		return ((String) getAttrVal("Id_pre_methods"));
	}	
	public void setId_pre_methods(String Id_pre_methods) {
		setAttrVal("Id_pre_methods", Id_pre_methods);
	}
	public String getSd_pre_methods() {
		return ((String) getAttrVal("Sd_pre_methods"));
	}	
	public void setSd_pre_methods(String Sd_pre_methods) {
		setAttrVal("Sd_pre_methods", Sd_pre_methods);
	}
	public String getName_pre_methods() {
		return ((String) getAttrVal("Name_pre_methods"));
	}	
	public void setName_pre_methods(String Name_pre_methods) {
		setAttrVal("Name_pre_methods", Name_pre_methods);
	}
	public FBoolean getIs_pre_drug_use() {
		return ((FBoolean) getAttrVal("Is_pre_drug_use"));
	}	
	public void setIs_pre_drug_use(FBoolean Is_pre_drug_use) {
		setAttrVal("Is_pre_drug_use", Is_pre_drug_use);
	}
	public String getId_pre_effect() {
		return ((String) getAttrVal("Id_pre_effect"));
	}	
	public void setId_pre_effect(String Id_pre_effect) {
		setAttrVal("Id_pre_effect", Id_pre_effect);
	}
	public String getSd_pre_effect() {
		return ((String) getAttrVal("Sd_pre_effect"));
	}	
	public void setSd_pre_effect(String Sd_pre_effect) {
		setAttrVal("Sd_pre_effect", Sd_pre_effect);
	}
	public String getName_pre_effect() {
		return ((String) getAttrVal("Name_pre_effect"));
	}	
	public void setName_pre_effect(String Name_pre_effect) {
		setAttrVal("Name_pre_effect", Name_pre_effect);
	}
	public String getId_com_medi() {
		return ((String) getAttrVal("Id_com_medi"));
	}	
	public void setId_com_medi(String Id_com_medi) {
		setAttrVal("Id_com_medi", Id_com_medi);
	}
	public String getSd_com_medi() {
		return ((String) getAttrVal("Sd_com_medi"));
	}	
	public void setSd_com_medi(String Sd_com_medi) {
		setAttrVal("Sd_com_medi", Sd_com_medi);
	}
	public String getName_com_medi() {
		return ((String) getAttrVal("Name_com_medi"));
	}	
	public void setName_com_medi(String Name_com_medi) {
		setAttrVal("Name_com_medi", Name_com_medi);
	}
	public String getPre_medi_time() {
		return ((String) getAttrVal("Pre_medi_time"));
	}	
	public void setPre_medi_time(String Pre_medi_time) {
		setAttrVal("Pre_medi_time", Pre_medi_time);
	}
	public Integer getDays_after_oper() {
		return ((Integer) getAttrVal("Days_after_oper"));
	}	
	public void setDays_after_oper(Integer Days_after_oper) {
		setAttrVal("Days_after_oper", Days_after_oper);
	}
	public FBoolean getAdv_drug_reactions() {
		return ((FBoolean) getAttrVal("Adv_drug_reactions"));
	}	
	public void setAdv_drug_reactions(FBoolean Adv_drug_reactions) {
		setAttrVal("Adv_drug_reactions", Adv_drug_reactions);
	}
	public FBoolean getDouble_infection() {
		return ((FBoolean) getAttrVal("Double_infection"));
	}	
	public void setDouble_infection(FBoolean Double_infection) {
		setAttrVal("Double_infection", Double_infection);
	}
	public String getDrug_code() {
		return ((String) getAttrVal("Drug_code"));
	}	
	public void setDrug_code(String Drug_code) {
		setAttrVal("Drug_code", Drug_code);
	}
	public String getDrug_name() {
		return ((String) getAttrVal("Drug_name"));
	}	
	public void setDrug_name(String Drug_name) {
		setAttrVal("Drug_name", Drug_name);
	}
	public String getRoute_adminis_code() {
		return ((String) getAttrVal("Route_adminis_code"));
	}	
	public void setRoute_adminis_code(String Route_adminis_code) {
		setAttrVal("Route_adminis_code", Route_adminis_code);
	}
	public String getRoute_adminis_name() {
		return ((String) getAttrVal("Route_adminis_name"));
	}	
	public void setRoute_adminis_name(String Route_adminis_name) {
		setAttrVal("Route_adminis_name", Route_adminis_name);
	}
	public String getDose_unit_code() {
		return ((String) getAttrVal("Dose_unit_code"));
	}	
	public void setDose_unit_code(String Dose_unit_code) {
		setAttrVal("Dose_unit_code", Dose_unit_code);
	}
	public String getDose_unit_name() {
		return ((String) getAttrVal("Dose_unit_name"));
	}	
	public void setDose_unit_name(String Dose_unit_name) {
		setAttrVal("Dose_unit_name", Dose_unit_name);
	}
	public String getMedi_methods_code() {
		return ((String) getAttrVal("Medi_methods_code"));
	}	
	public void setMedi_methods_code(String Medi_methods_code) {
		setAttrVal("Medi_methods_code", Medi_methods_code);
	}
	public String getMedi_methods_name() {
		return ((String) getAttrVal("Medi_methods_name"));
	}	
	public void setMedi_methods_name(String Medi_methods_name) {
		setAttrVal("Medi_methods_name", Medi_methods_name);
	}
	public String getObjective_code() {
		return ((String) getAttrVal("Objective_code"));
	}	
	public void setObjective_code(String Objective_code) {
		setAttrVal("Objective_code", Objective_code);
	}
	public String getObjective_name() {
		return ((String) getAttrVal("Objective_name"));
	}	
	public void setObjective_name(String Objective_name) {
		setAttrVal("Objective_name", Objective_name);
	}
	public String getTreat_methods_code() {
		return ((String) getAttrVal("Treat_methods_code"));
	}	
	public void setTreat_methods_code(String Treat_methods_code) {
		setAttrVal("Treat_methods_code", Treat_methods_code);
	}
	public String getTreat_methods_name() {
		return ((String) getAttrVal("Treat_methods_name"));
	}	
	public void setTreat_methods_name(String Treat_methods_name) {
		setAttrVal("Treat_methods_name", Treat_methods_name);
	}
	public String getPre_methods_code() {
		return ((String) getAttrVal("Pre_methods_code"));
	}	
	public void setPre_methods_code(String Pre_methods_code) {
		setAttrVal("Pre_methods_code", Pre_methods_code);
	}
	public String getPre_methods_name() {
		return ((String) getAttrVal("Pre_methods_name"));
	}	
	public void setPre_methods_name(String Pre_methods_name) {
		setAttrVal("Pre_methods_name", Pre_methods_name);
	}
	public String getPre_effect_code() {
		return ((String) getAttrVal("Pre_effect_code"));
	}	
	public void setPre_effect_code(String Pre_effect_code) {
		setAttrVal("Pre_effect_code", Pre_effect_code);
	}
	public String getPre_effect_name() {
		return ((String) getAttrVal("Pre_effect_name"));
	}	
	public void setPre_effect_name(String Pre_effect_name) {
		setAttrVal("Pre_effect_name", Pre_effect_name);
	}
	public String getCom_medi_code() {
		return ((String) getAttrVal("Com_medi_code"));
	}	
	public void setCom_medi_code(String Com_medi_code) {
		setAttrVal("Com_medi_code", Com_medi_code);
	}
	public String getCom_medi_name() {
		return ((String) getAttrVal("Com_medi_name"));
	}	
	public void setCom_medi_name(String Com_medi_name) {
		setAttrVal("Com_medi_name", Com_medi_name);
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
		return "Id_au";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_MR_CONTAGION_CARD_AU";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(AntibioticUseDODesc.class);
	}
	
}