package iih.ci.rcm.contagion.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.rcm.contagion.d.desc.ContagionDODesc;
import java.math.BigDecimal;

/**
 * 传染病报告卡 DO数据 
 * 
 */
public class ContagionDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_CONTAGION= "Id_contagion";
	public static final String ID_MR= "Id_mr";
	public static final String ID_ENT= "Id_ent";
	public static final String P_ID_CONTAGION= "P_id_contagion";
	public static final String ID_FORM= "Id_form";
	public static final String CODE= "Code";
	public static final String EU_BKLB= "Eu_bklb";
	public static final String EU_BKLB_CODE= "Eu_bklb_code";
	public static final String EU_BKLB_NAME= "Eu_bklb_name";
	public static final String ID_CON_CARDSU= "Id_con_cardsu";
	public static final String SD_CON_CARDSU= "Sd_con_cardsu";
	public static final String NAME_CON_CARDSU= "Name_con_cardsu";
	public static final String NAME= "Name";
	public static final String ID_CODE= "Id_code";
	public static final String REVISED_NAME= "Revised_name";
	public static final String RETREAT_REASON= "Retreat_reason";
	public static final String REPORT_UNIT= "Report_unit";
	public static final String REPORT_UNIT_CODE= "Report_unit_code";
	public static final String REPORT_UNIT_NAME= "Report_unit_name";
	public static final String DOCTOR_CARD= "Doctor_card";
	public static final String EU_JLCRB= "Eu_jlcrb";
	public static final String EU_JLCRB_CODE= "Eu_jlcrb_code";
	public static final String EU_JLCRB_NAME= "Eu_jlcrb_name";
	public static final String EU_YLCRB= "Eu_ylcrb";
	public static final String EU_YLCRB_CODE= "Eu_ylcrb_code";
	public static final String EU_YLCRB_NAME= "Eu_ylcrb_name";
	public static final String EU_BLCRB= "Eu_blcrb";
	public static final String EU_BLCRB_CODE= "Eu_blcrb_code";
	public static final String EU_BLCRB_NAME= "Eu_blcrb_name";
	public static final String ID_OTHER_DISEASES= "Id_other_diseases";
	public static final String SD_OTHER_DISEASES= "Sd_other_diseases";
	public static final String NAME_OTHER_DISEASES= "Name_other_diseases";
	public static final String IS_ALIKE= "Is_alike";
	public static final String EU_BLFL= "Eu_blfl";
	public static final String EU_BLFL_CODE= "Eu_blfl_code";
	public static final String EU_BLFL_NAME= "Eu_blfl_name";
	public static final String EU_BRSY= "Eu_brsy";
	public static final String EU_BRSY_CODE= "Eu_brsy_code";
	public static final String EU_BRSY_NAME= "Eu_brsy_name";
	public static final String EU_RQFL= "Eu_rqfl";
	public static final String EU_RQFL_CODE= "Eu_rqfl_code";
	public static final String EU_RQFL_NAME= "Eu_rqfl_name";
	public static final String HZJZXM= "Hzjzxm";
	public static final String FBRQ= "Fbrq";
	public static final String ZDRQ= "Zdrq";
	public static final String SWRQ= "Swrq";
	public static final String EU_NLDW= "Eu_nldw";
	public static final String EU_NLDW_CODE= "Eu_nldw_code";
	public static final String EU_NLDW_NAME= "Eu_nldw_name";
	public static final String ID_EMP_ENTRY= "Id_emp_entry";
	public static final String SD_EMP_ENTRY= "Sd_emp_entry";
	public static final String NAME_EMP_ENTRY= "Name_emp_entry";
	public static final String EXACT_AGE= "Exact_age";
	public static final String WORKUNIT= "Workunit";
	public static final String MOB= "Mob";
	public static final String ADDR_NOW= "Addr_now";
	public static final String ID_PROVINCE= "Id_province";
	public static final String SD_PROVINCE= "Sd_province";
	public static final String NAME_PROVINCE= "Name_province";
	public static final String STREET= "Street";
	public static final String VILLAGE= "Village";
	public static final String HOUSENUM= "Housenum";
	public static final String RESIDENCE_ADDR= "Residence_addr";
	public static final String RESIDENCE_CODE= "Residence_code";
	public static final String RESIDENCE= "Residence";
	public static final String ID_SEX= "Id_sex";
	public static final String SD_SEX= "Sd_sex";
	public static final String NAME_SEX= "Name_sex";
	public static final String DT_BIRTH= "Dt_birth";
	public static final String DT_CONTAGION= "Dt_contagion";
	public static final String TEL= "Tel";
	public static final String ID_GRP= "Id_grp";
	public static final String SD_GRP= "Sd_grp";
	public static final String NAME_GRP= "Name_grp";
	public static final String ID_ORG= "Id_org";
	public static final String SD_ORG= "Sd_org";
	public static final String NAME_ORG= "Name_org";
	public static final String REMARKS= "Remarks";
	public static final String DELETE_RESION= "Delete_resion";
	public static final String REHECT_REASON= "Rehect_reason";
	public static final String EU_BQFL= "Eu_bqfl";
	public static final String CODE_EU_BQFL= "Code_eu_bqfl";
	public static final String NAME_EU_BQFL= "Name_eu_bqfl";
	public static final String DEF1= "Def1";
	public static final String DEF2= "Def2";
	public static final String DEF3= "Def3";
	public static final String DEF4= "Def4";
	public static final String DEF5= "Def5";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String REF_BKLB_CODE= "Ref_bklb_code";
	public static final String REF_BKLB_NAME= "Ref_bklb_name";
	public static final String REF_CARDSU_CODE= "Ref_cardsu_code";
	public static final String REF_CARDSU_NAME= "Ref_cardsu_name";
	public static final String REF_CODE_REPORT_UNIT= "Ref_code_report_unit";
	public static final String REF_NAME_REPORT_UNIT= "Ref_name_report_unit";
	public static final String REF_CODE_EU_JLCRB= "Ref_code_eu_jlcrb";
	public static final String REF_NAME_EU_JLCRB= "Ref_name_eu_jlcrb";
	public static final String REF_CODE_EU_YLCRB= "Ref_code_eu_ylcrb";
	public static final String REF_NAME_EU_YLCRB= "Ref_name_eu_ylcrb";
	public static final String CODE_EU_BLCRB= "Code_eu_blcrb";
	public static final String NAME_EU_BLCRB= "Name_eu_blcrb";
	public static final String OTHER_DISEASES_CODE= "Other_diseases_code";
	public static final String OTHER_DISEASES_NAME= "Other_diseases_name";
	public static final String CODE_EU_RQFL= "Code_eu_rqfl";
	public static final String NAME_EU_RQFL= "Name_eu_rqfl";
	public static final String CODE_EU_BRSY= "Code_eu_brsy";
	public static final String NAME_EU_BRSY= "Name_eu_brsy";
	public static final String REF_CODE_EU_RQFL= "Ref_code_eu_rqfl";
	public static final String REF_NAME_EU_RQFL= "Ref_name_eu_rqfl";
	public static final String CODE_EU_NLDW= "Code_eu_nldw";
	public static final String NAME_EU_NLDW= "Name_eu_nldw";
	public static final String DOCTORCODE= "Doctorcode";
	public static final String DOCTORNAME= "Doctorname";
	public static final String PROVINCE_CODE= "Province_code";
	public static final String PROVINCE_NAME= "Province_name";
	public static final String AREACODE= "Areacode";
	public static final String AREAFULLNAME= "Areafullname";
	public static final String SEX_CODE= "Sex_code";
	public static final String SEX_NAME= "Sex_name";
	public static final String ORG_CODE= "Org_code";
	public static final String ORG_NAME= "Org_name";
	public static final String EU_BQFL_CODE= "Eu_bqfl_code";
	public static final String EU_BQFL_NAME= "Eu_bqfl_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_contagion() {
		return ((String) getAttrVal("Id_contagion"));
	}	
	public void setId_contagion(String Id_contagion) {
		setAttrVal("Id_contagion", Id_contagion);
	}
	public String getId_mr() {
		return ((String) getAttrVal("Id_mr"));
	}	
	public void setId_mr(String Id_mr) {
		setAttrVal("Id_mr", Id_mr);
	}
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	public String getP_id_contagion() {
		return ((String) getAttrVal("P_id_contagion"));
	}	
	public void setP_id_contagion(String P_id_contagion) {
		setAttrVal("P_id_contagion", P_id_contagion);
	}
	public String getId_form() {
		return ((String) getAttrVal("Id_form"));
	}	
	public void setId_form(String Id_form) {
		setAttrVal("Id_form", Id_form);
	}
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	public String getEu_bklb() {
		return ((String) getAttrVal("Eu_bklb"));
	}	
	public void setEu_bklb(String Eu_bklb) {
		setAttrVal("Eu_bklb", Eu_bklb);
	}
	public String getEu_bklb_code() {
		return ((String) getAttrVal("Eu_bklb_code"));
	}	
	public void setEu_bklb_code(String Eu_bklb_code) {
		setAttrVal("Eu_bklb_code", Eu_bklb_code);
	}
	public String getEu_bklb_name() {
		return ((String) getAttrVal("Eu_bklb_name"));
	}	
	public void setEu_bklb_name(String Eu_bklb_name) {
		setAttrVal("Eu_bklb_name", Eu_bklb_name);
	}
	public String getId_con_cardsu() {
		return ((String) getAttrVal("Id_con_cardsu"));
	}	
	public void setId_con_cardsu(String Id_con_cardsu) {
		setAttrVal("Id_con_cardsu", Id_con_cardsu);
	}
	public String getSd_con_cardsu() {
		return ((String) getAttrVal("Sd_con_cardsu"));
	}	
	public void setSd_con_cardsu(String Sd_con_cardsu) {
		setAttrVal("Sd_con_cardsu", Sd_con_cardsu);
	}
	public String getName_con_cardsu() {
		return ((String) getAttrVal("Name_con_cardsu"));
	}	
	public void setName_con_cardsu(String Name_con_cardsu) {
		setAttrVal("Name_con_cardsu", Name_con_cardsu);
	}
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public String getId_code() {
		return ((String) getAttrVal("Id_code"));
	}	
	public void setId_code(String Id_code) {
		setAttrVal("Id_code", Id_code);
	}
	public String getRevised_name() {
		return ((String) getAttrVal("Revised_name"));
	}	
	public void setRevised_name(String Revised_name) {
		setAttrVal("Revised_name", Revised_name);
	}
	public String getRetreat_reason() {
		return ((String) getAttrVal("Retreat_reason"));
	}	
	public void setRetreat_reason(String Retreat_reason) {
		setAttrVal("Retreat_reason", Retreat_reason);
	}
	public String getReport_unit() {
		return ((String) getAttrVal("Report_unit"));
	}	
	public void setReport_unit(String Report_unit) {
		setAttrVal("Report_unit", Report_unit);
	}
	public String getReport_unit_code() {
		return ((String) getAttrVal("Report_unit_code"));
	}	
	public void setReport_unit_code(String Report_unit_code) {
		setAttrVal("Report_unit_code", Report_unit_code);
	}
	public String getReport_unit_name() {
		return ((String) getAttrVal("Report_unit_name"));
	}	
	public void setReport_unit_name(String Report_unit_name) {
		setAttrVal("Report_unit_name", Report_unit_name);
	}
	public String getDoctor_card() {
		return ((String) getAttrVal("Doctor_card"));
	}	
	public void setDoctor_card(String Doctor_card) {
		setAttrVal("Doctor_card", Doctor_card);
	}
	public String getEu_jlcrb() {
		return ((String) getAttrVal("Eu_jlcrb"));
	}	
	public void setEu_jlcrb(String Eu_jlcrb) {
		setAttrVal("Eu_jlcrb", Eu_jlcrb);
	}
	public String getEu_jlcrb_code() {
		return ((String) getAttrVal("Eu_jlcrb_code"));
	}	
	public void setEu_jlcrb_code(String Eu_jlcrb_code) {
		setAttrVal("Eu_jlcrb_code", Eu_jlcrb_code);
	}
	public String getEu_jlcrb_name() {
		return ((String) getAttrVal("Eu_jlcrb_name"));
	}	
	public void setEu_jlcrb_name(String Eu_jlcrb_name) {
		setAttrVal("Eu_jlcrb_name", Eu_jlcrb_name);
	}
	public String getEu_ylcrb() {
		return ((String) getAttrVal("Eu_ylcrb"));
	}	
	public void setEu_ylcrb(String Eu_ylcrb) {
		setAttrVal("Eu_ylcrb", Eu_ylcrb);
	}
	public String getEu_ylcrb_code() {
		return ((String) getAttrVal("Eu_ylcrb_code"));
	}	
	public void setEu_ylcrb_code(String Eu_ylcrb_code) {
		setAttrVal("Eu_ylcrb_code", Eu_ylcrb_code);
	}
	public String getEu_ylcrb_name() {
		return ((String) getAttrVal("Eu_ylcrb_name"));
	}	
	public void setEu_ylcrb_name(String Eu_ylcrb_name) {
		setAttrVal("Eu_ylcrb_name", Eu_ylcrb_name);
	}
	public String getEu_blcrb() {
		return ((String) getAttrVal("Eu_blcrb"));
	}	
	public void setEu_blcrb(String Eu_blcrb) {
		setAttrVal("Eu_blcrb", Eu_blcrb);
	}
	public String getEu_blcrb_code() {
		return ((String) getAttrVal("Eu_blcrb_code"));
	}	
	public void setEu_blcrb_code(String Eu_blcrb_code) {
		setAttrVal("Eu_blcrb_code", Eu_blcrb_code);
	}
	public String getEu_blcrb_name() {
		return ((String) getAttrVal("Eu_blcrb_name"));
	}	
	public void setEu_blcrb_name(String Eu_blcrb_name) {
		setAttrVal("Eu_blcrb_name", Eu_blcrb_name);
	}
	public String getId_other_diseases() {
		return ((String) getAttrVal("Id_other_diseases"));
	}	
	public void setId_other_diseases(String Id_other_diseases) {
		setAttrVal("Id_other_diseases", Id_other_diseases);
	}
	public String getSd_other_diseases() {
		return ((String) getAttrVal("Sd_other_diseases"));
	}	
	public void setSd_other_diseases(String Sd_other_diseases) {
		setAttrVal("Sd_other_diseases", Sd_other_diseases);
	}
	public String getName_other_diseases() {
		return ((String) getAttrVal("Name_other_diseases"));
	}	
	public void setName_other_diseases(String Name_other_diseases) {
		setAttrVal("Name_other_diseases", Name_other_diseases);
	}
	public FBoolean getIs_alike() {
		return ((FBoolean) getAttrVal("Is_alike"));
	}	
	public void setIs_alike(FBoolean Is_alike) {
		setAttrVal("Is_alike", Is_alike);
	}
	public String getEu_blfl() {
		return ((String) getAttrVal("Eu_blfl"));
	}	
	public void setEu_blfl(String Eu_blfl) {
		setAttrVal("Eu_blfl", Eu_blfl);
	}
	public String getEu_blfl_code() {
		return ((String) getAttrVal("Eu_blfl_code"));
	}	
	public void setEu_blfl_code(String Eu_blfl_code) {
		setAttrVal("Eu_blfl_code", Eu_blfl_code);
	}
	public String getEu_blfl_name() {
		return ((String) getAttrVal("Eu_blfl_name"));
	}	
	public void setEu_blfl_name(String Eu_blfl_name) {
		setAttrVal("Eu_blfl_name", Eu_blfl_name);
	}
	public String getEu_brsy() {
		return ((String) getAttrVal("Eu_brsy"));
	}	
	public void setEu_brsy(String Eu_brsy) {
		setAttrVal("Eu_brsy", Eu_brsy);
	}
	public String getEu_brsy_code() {
		return ((String) getAttrVal("Eu_brsy_code"));
	}	
	public void setEu_brsy_code(String Eu_brsy_code) {
		setAttrVal("Eu_brsy_code", Eu_brsy_code);
	}
	public String getEu_brsy_name() {
		return ((String) getAttrVal("Eu_brsy_name"));
	}	
	public void setEu_brsy_name(String Eu_brsy_name) {
		setAttrVal("Eu_brsy_name", Eu_brsy_name);
	}
	public String getEu_rqfl() {
		return ((String) getAttrVal("Eu_rqfl"));
	}	
	public void setEu_rqfl(String Eu_rqfl) {
		setAttrVal("Eu_rqfl", Eu_rqfl);
	}
	public String getEu_rqfl_code() {
		return ((String) getAttrVal("Eu_rqfl_code"));
	}	
	public void setEu_rqfl_code(String Eu_rqfl_code) {
		setAttrVal("Eu_rqfl_code", Eu_rqfl_code);
	}
	public String getEu_rqfl_name() {
		return ((String) getAttrVal("Eu_rqfl_name"));
	}	
	public void setEu_rqfl_name(String Eu_rqfl_name) {
		setAttrVal("Eu_rqfl_name", Eu_rqfl_name);
	}
	public String getHzjzxm() {
		return ((String) getAttrVal("Hzjzxm"));
	}	
	public void setHzjzxm(String Hzjzxm) {
		setAttrVal("Hzjzxm", Hzjzxm);
	}
	public FDate getFbrq() {
		return ((FDate) getAttrVal("Fbrq"));
	}	
	public void setFbrq(FDate Fbrq) {
		setAttrVal("Fbrq", Fbrq);
	}
	public FDateTime getZdrq() {
		return ((FDateTime) getAttrVal("Zdrq"));
	}	
	public void setZdrq(FDateTime Zdrq) {
		setAttrVal("Zdrq", Zdrq);
	}
	public FDate getSwrq() {
		return ((FDate) getAttrVal("Swrq"));
	}	
	public void setSwrq(FDate Swrq) {
		setAttrVal("Swrq", Swrq);
	}
	public String getEu_nldw() {
		return ((String) getAttrVal("Eu_nldw"));
	}	
	public void setEu_nldw(String Eu_nldw) {
		setAttrVal("Eu_nldw", Eu_nldw);
	}
	public String getEu_nldw_code() {
		return ((String) getAttrVal("Eu_nldw_code"));
	}	
	public void setEu_nldw_code(String Eu_nldw_code) {
		setAttrVal("Eu_nldw_code", Eu_nldw_code);
	}
	public String getEu_nldw_name() {
		return ((String) getAttrVal("Eu_nldw_name"));
	}	
	public void setEu_nldw_name(String Eu_nldw_name) {
		setAttrVal("Eu_nldw_name", Eu_nldw_name);
	}
	public String getId_emp_entry() {
		return ((String) getAttrVal("Id_emp_entry"));
	}	
	public void setId_emp_entry(String Id_emp_entry) {
		setAttrVal("Id_emp_entry", Id_emp_entry);
	}
	public String getSd_emp_entry() {
		return ((String) getAttrVal("Sd_emp_entry"));
	}	
	public void setSd_emp_entry(String Sd_emp_entry) {
		setAttrVal("Sd_emp_entry", Sd_emp_entry);
	}
	public String getName_emp_entry() {
		return ((String) getAttrVal("Name_emp_entry"));
	}	
	public void setName_emp_entry(String Name_emp_entry) {
		setAttrVal("Name_emp_entry", Name_emp_entry);
	}
	public Integer getExact_age() {
		return ((Integer) getAttrVal("Exact_age"));
	}	
	public void setExact_age(Integer Exact_age) {
		setAttrVal("Exact_age", Exact_age);
	}
	public String getWorkunit() {
		return ((String) getAttrVal("Workunit"));
	}	
	public void setWorkunit(String Workunit) {
		setAttrVal("Workunit", Workunit);
	}
	public String getMob() {
		return ((String) getAttrVal("Mob"));
	}	
	public void setMob(String Mob) {
		setAttrVal("Mob", Mob);
	}
	public String getAddr_now() {
		return ((String) getAttrVal("Addr_now"));
	}	
	public void setAddr_now(String Addr_now) {
		setAttrVal("Addr_now", Addr_now);
	}
	public String getId_province() {
		return ((String) getAttrVal("Id_province"));
	}	
	public void setId_province(String Id_province) {
		setAttrVal("Id_province", Id_province);
	}
	public String getSd_province() {
		return ((String) getAttrVal("Sd_province"));
	}	
	public void setSd_province(String Sd_province) {
		setAttrVal("Sd_province", Sd_province);
	}
	public String getName_province() {
		return ((String) getAttrVal("Name_province"));
	}	
	public void setName_province(String Name_province) {
		setAttrVal("Name_province", Name_province);
	}
	public String getStreet() {
		return ((String) getAttrVal("Street"));
	}	
	public void setStreet(String Street) {
		setAttrVal("Street", Street);
	}
	public String getVillage() {
		return ((String) getAttrVal("Village"));
	}	
	public void setVillage(String Village) {
		setAttrVal("Village", Village);
	}
	public String getHousenum() {
		return ((String) getAttrVal("Housenum"));
	}	
	public void setHousenum(String Housenum) {
		setAttrVal("Housenum", Housenum);
	}
	public String getResidence_addr() {
		return ((String) getAttrVal("Residence_addr"));
	}	
	public void setResidence_addr(String Residence_addr) {
		setAttrVal("Residence_addr", Residence_addr);
	}
	public String getResidence_code() {
		return ((String) getAttrVal("Residence_code"));
	}	
	public void setResidence_code(String Residence_code) {
		setAttrVal("Residence_code", Residence_code);
	}
	public String getResidence() {
		return ((String) getAttrVal("Residence"));
	}	
	public void setResidence(String Residence) {
		setAttrVal("Residence", Residence);
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
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}	
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
	}
	public FDate getDt_birth() {
		return ((FDate) getAttrVal("Dt_birth"));
	}	
	public void setDt_birth(FDate Dt_birth) {
		setAttrVal("Dt_birth", Dt_birth);
	}
	public FDate getDt_contagion() {
		return ((FDate) getAttrVal("Dt_contagion"));
	}	
	public void setDt_contagion(FDate Dt_contagion) {
		setAttrVal("Dt_contagion", Dt_contagion);
	}
	public String getTel() {
		return ((String) getAttrVal("Tel"));
	}	
	public void setTel(String Tel) {
		setAttrVal("Tel", Tel);
	}
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	public String getSd_grp() {
		return ((String) getAttrVal("Sd_grp"));
	}	
	public void setSd_grp(String Sd_grp) {
		setAttrVal("Sd_grp", Sd_grp);
	}
	public String getName_grp() {
		return ((String) getAttrVal("Name_grp"));
	}	
	public void setName_grp(String Name_grp) {
		setAttrVal("Name_grp", Name_grp);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	public String getSd_org() {
		return ((String) getAttrVal("Sd_org"));
	}	
	public void setSd_org(String Sd_org) {
		setAttrVal("Sd_org", Sd_org);
	}
	public String getName_org() {
		return ((String) getAttrVal("Name_org"));
	}	
	public void setName_org(String Name_org) {
		setAttrVal("Name_org", Name_org);
	}
	public String getRemarks() {
		return ((String) getAttrVal("Remarks"));
	}	
	public void setRemarks(String Remarks) {
		setAttrVal("Remarks", Remarks);
	}
	public String getDelete_resion() {
		return ((String) getAttrVal("Delete_resion"));
	}	
	public void setDelete_resion(String Delete_resion) {
		setAttrVal("Delete_resion", Delete_resion);
	}
	public String getRehect_reason() {
		return ((String) getAttrVal("Rehect_reason"));
	}	
	public void setRehect_reason(String Rehect_reason) {
		setAttrVal("Rehect_reason", Rehect_reason);
	}
	public String getEu_bqfl() {
		return ((String) getAttrVal("Eu_bqfl"));
	}	
	public void setEu_bqfl(String Eu_bqfl) {
		setAttrVal("Eu_bqfl", Eu_bqfl);
	}
	public String getCode_eu_bqfl() {
		return ((String) getAttrVal("Code_eu_bqfl"));
	}	
	public void setCode_eu_bqfl(String Code_eu_bqfl) {
		setAttrVal("Code_eu_bqfl", Code_eu_bqfl);
	}
	public String getName_eu_bqfl() {
		return ((String) getAttrVal("Name_eu_bqfl"));
	}	
	public void setName_eu_bqfl(String Name_eu_bqfl) {
		setAttrVal("Name_eu_bqfl", Name_eu_bqfl);
	}
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}	
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}	
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}	
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
	public String getDef4() {
		return ((String) getAttrVal("Def4"));
	}	
	public void setDef4(String Def4) {
		setAttrVal("Def4", Def4);
	}
	public String getDef5() {
		return ((String) getAttrVal("Def5"));
	}	
	public void setDef5(String Def5) {
		setAttrVal("Def5", Def5);
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
	public String getRef_bklb_code() {
		return ((String) getAttrVal("Ref_bklb_code"));
	}	
	public void setRef_bklb_code(String Ref_bklb_code) {
		setAttrVal("Ref_bklb_code", Ref_bklb_code);
	}
	public String getRef_bklb_name() {
		return ((String) getAttrVal("Ref_bklb_name"));
	}	
	public void setRef_bklb_name(String Ref_bklb_name) {
		setAttrVal("Ref_bklb_name", Ref_bklb_name);
	}
	public String getRef_cardsu_code() {
		return ((String) getAttrVal("Ref_cardsu_code"));
	}	
	public void setRef_cardsu_code(String Ref_cardsu_code) {
		setAttrVal("Ref_cardsu_code", Ref_cardsu_code);
	}
	public String getRef_cardsu_name() {
		return ((String) getAttrVal("Ref_cardsu_name"));
	}	
	public void setRef_cardsu_name(String Ref_cardsu_name) {
		setAttrVal("Ref_cardsu_name", Ref_cardsu_name);
	}
	public String getRef_code_report_unit() {
		return ((String) getAttrVal("Ref_code_report_unit"));
	}	
	public void setRef_code_report_unit(String Ref_code_report_unit) {
		setAttrVal("Ref_code_report_unit", Ref_code_report_unit);
	}
	public String getRef_name_report_unit() {
		return ((String) getAttrVal("Ref_name_report_unit"));
	}	
	public void setRef_name_report_unit(String Ref_name_report_unit) {
		setAttrVal("Ref_name_report_unit", Ref_name_report_unit);
	}
	public String getRef_code_eu_jlcrb() {
		return ((String) getAttrVal("Ref_code_eu_jlcrb"));
	}	
	public void setRef_code_eu_jlcrb(String Ref_code_eu_jlcrb) {
		setAttrVal("Ref_code_eu_jlcrb", Ref_code_eu_jlcrb);
	}
	public String getRef_name_eu_jlcrb() {
		return ((String) getAttrVal("Ref_name_eu_jlcrb"));
	}	
	public void setRef_name_eu_jlcrb(String Ref_name_eu_jlcrb) {
		setAttrVal("Ref_name_eu_jlcrb", Ref_name_eu_jlcrb);
	}
	public String getRef_code_eu_ylcrb() {
		return ((String) getAttrVal("Ref_code_eu_ylcrb"));
	}	
	public void setRef_code_eu_ylcrb(String Ref_code_eu_ylcrb) {
		setAttrVal("Ref_code_eu_ylcrb", Ref_code_eu_ylcrb);
	}
	public String getRef_name_eu_ylcrb() {
		return ((String) getAttrVal("Ref_name_eu_ylcrb"));
	}	
	public void setRef_name_eu_ylcrb(String Ref_name_eu_ylcrb) {
		setAttrVal("Ref_name_eu_ylcrb", Ref_name_eu_ylcrb);
	}
	public String getCode_eu_blcrb() {
		return ((String) getAttrVal("Code_eu_blcrb"));
	}	
	public void setCode_eu_blcrb(String Code_eu_blcrb) {
		setAttrVal("Code_eu_blcrb", Code_eu_blcrb);
	}
	public String getName_eu_blcrb() {
		return ((String) getAttrVal("Name_eu_blcrb"));
	}	
	public void setName_eu_blcrb(String Name_eu_blcrb) {
		setAttrVal("Name_eu_blcrb", Name_eu_blcrb);
	}
	public String getOther_diseases_code() {
		return ((String) getAttrVal("Other_diseases_code"));
	}	
	public void setOther_diseases_code(String Other_diseases_code) {
		setAttrVal("Other_diseases_code", Other_diseases_code);
	}
	public String getOther_diseases_name() {
		return ((String) getAttrVal("Other_diseases_name"));
	}	
	public void setOther_diseases_name(String Other_diseases_name) {
		setAttrVal("Other_diseases_name", Other_diseases_name);
	}
	public String getCode_eu_rqfl() {
		return ((String) getAttrVal("Code_eu_rqfl"));
	}	
	public void setCode_eu_rqfl(String Code_eu_rqfl) {
		setAttrVal("Code_eu_rqfl", Code_eu_rqfl);
	}
	public String getName_eu_rqfl() {
		return ((String) getAttrVal("Name_eu_rqfl"));
	}	
	public void setName_eu_rqfl(String Name_eu_rqfl) {
		setAttrVal("Name_eu_rqfl", Name_eu_rqfl);
	}
	public String getCode_eu_brsy() {
		return ((String) getAttrVal("Code_eu_brsy"));
	}	
	public void setCode_eu_brsy(String Code_eu_brsy) {
		setAttrVal("Code_eu_brsy", Code_eu_brsy);
	}
	public String getName_eu_brsy() {
		return ((String) getAttrVal("Name_eu_brsy"));
	}	
	public void setName_eu_brsy(String Name_eu_brsy) {
		setAttrVal("Name_eu_brsy", Name_eu_brsy);
	}
	public String getRef_code_eu_rqfl() {
		return ((String) getAttrVal("Ref_code_eu_rqfl"));
	}	
	public void setRef_code_eu_rqfl(String Ref_code_eu_rqfl) {
		setAttrVal("Ref_code_eu_rqfl", Ref_code_eu_rqfl);
	}
	public String getRef_name_eu_rqfl() {
		return ((String) getAttrVal("Ref_name_eu_rqfl"));
	}	
	public void setRef_name_eu_rqfl(String Ref_name_eu_rqfl) {
		setAttrVal("Ref_name_eu_rqfl", Ref_name_eu_rqfl);
	}
	public String getCode_eu_nldw() {
		return ((String) getAttrVal("Code_eu_nldw"));
	}	
	public void setCode_eu_nldw(String Code_eu_nldw) {
		setAttrVal("Code_eu_nldw", Code_eu_nldw);
	}
	public String getName_eu_nldw() {
		return ((String) getAttrVal("Name_eu_nldw"));
	}	
	public void setName_eu_nldw(String Name_eu_nldw) {
		setAttrVal("Name_eu_nldw", Name_eu_nldw);
	}
	public String getDoctorcode() {
		return ((String) getAttrVal("Doctorcode"));
	}	
	public void setDoctorcode(String Doctorcode) {
		setAttrVal("Doctorcode", Doctorcode);
	}
	public String getDoctorname() {
		return ((String) getAttrVal("Doctorname"));
	}	
	public void setDoctorname(String Doctorname) {
		setAttrVal("Doctorname", Doctorname);
	}
	public String getProvince_code() {
		return ((String) getAttrVal("Province_code"));
	}	
	public void setProvince_code(String Province_code) {
		setAttrVal("Province_code", Province_code);
	}
	public String getProvince_name() {
		return ((String) getAttrVal("Province_name"));
	}	
	public void setProvince_name(String Province_name) {
		setAttrVal("Province_name", Province_name);
	}
	public String getAreacode() {
		return ((String) getAttrVal("Areacode"));
	}	
	public void setAreacode(String Areacode) {
		setAttrVal("Areacode", Areacode);
	}
	public String getAreafullname() {
		return ((String) getAttrVal("Areafullname"));
	}	
	public void setAreafullname(String Areafullname) {
		setAttrVal("Areafullname", Areafullname);
	}
	public String getSex_code() {
		return ((String) getAttrVal("Sex_code"));
	}	
	public void setSex_code(String Sex_code) {
		setAttrVal("Sex_code", Sex_code);
	}
	public String getSex_name() {
		return ((String) getAttrVal("Sex_name"));
	}	
	public void setSex_name(String Sex_name) {
		setAttrVal("Sex_name", Sex_name);
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
	public String getEu_bqfl_code() {
		return ((String) getAttrVal("Eu_bqfl_code"));
	}	
	public void setEu_bqfl_code(String Eu_bqfl_code) {
		setAttrVal("Eu_bqfl_code", Eu_bqfl_code);
	}
	public String getEu_bqfl_name() {
		return ((String) getAttrVal("Eu_bqfl_name"));
	}	
	public void setEu_bqfl_name(String Eu_bqfl_name) {
		setAttrVal("Eu_bqfl_name", Eu_bqfl_name);
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
		return "Id_contagion";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_contagion_card";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ContagionDODesc.class);
	}
	
}