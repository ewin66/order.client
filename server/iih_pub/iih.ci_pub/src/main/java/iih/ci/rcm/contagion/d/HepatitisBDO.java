package iih.ci.rcm.contagion.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.rcm.contagion.d.desc.HepatitisBDODesc;
import java.math.BigDecimal;

/**
 * 乙肝附卡 DO数据 
 * 
 */
public class HepatitisBDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_CONTAGION_HB= "Id_contagion_hb";
	public static final String ID_CONTAGION= "Id_contagion";
	public static final String ID_FORM= "Id_form";
	public static final String ID_HBSAG_DT= "Id_hbsag_dt";
	public static final String CODE_HBSAG_DT= "Code_hbsag_dt";
	public static final String NAME_HBSAG_DT= "Name_hbsag_dt";
	public static final String DT_FIRST= "Dt_first";
	public static final String ALT= "Alt";
	public static final String ID_HBC_IGM1= "Id_hbc_igm1";
	public static final String CODE_HBC_IGM1= "Code_hbc_igm1";
	public static final String NAME_HBC_IGM1= "Name_hbc_igm1";
	public static final String ID_LIVER_PUNCTURE_RESULTS= "Id_liver_puncture_results";
	public static final String CODE_LIVER_PUNCTURE_RESULTS= "Code_liver_puncture_results";
	public static final String NAME_LIVER_PUNCTURE_RESULTS= "Name_liver_puncture_results";
	public static final String ID_HBSAG_HUIFU= "Id_hbsag_huifu";
	public static final String CODE_HBSAG_HUIFU= "Code_hbsag_huifu";
	public static final String NAME_HBSAG_HUIFU= "Name_hbsag_huifu";
	public static final String IS_KNOW= "Is_know";
	public static final String CARD_NO= "Card_no";
	public static final String PAT_NAME= "Pat_name";
	public static final String PARENT_NAME= "Parent_name";
	public static final String HJDZ= "Hjdz";
	public static final String CODE_HJDZ= "Code_hjdz";
	public static final String NAME_HJDZ= "Name_hjdz";
	public static final String TOWN= "Town";
	public static final String VALLEGE= "Vallege";
	public static final String HOUSE_NO= "House_no";
	public static final String REPT_DOCTOR= "Rept_doctor";
	public static final String RELATION_WAY= "Relation_way";
	public static final String CODE_REPT_DOCTOR= "Code_rept_doctor";
	public static final String NAME_REPT_DOCTOR= "Name_rept_doctor";
	public static final String HBSAG_DT_CODE= "Hbsag_dt_code";
	public static final String HBSAG_DT_NAME= "Hbsag_dt_name";
	public static final String HBC_IGM_CODE= "Hbc_igm_code";
	public static final String HBC_IGM_NAME= "Hbc_igm_name";
	public static final String LIVER_PUNCTURE_RESULTS_CODE= "Liver_puncture_results_code";
	public static final String LIVER_PUNCTURE_RESULTS_NAME= "Liver_puncture_results_name";
	public static final String HBSAG_HUIFU_CODE= "Hbsag_huifu_code";
	public static final String HBSAG_HUIFU_NAME= "Hbsag_huifu_name";
	public static final String AREACODE= "Areacode";
	public static final String AREANAME= "Areaname";
	public static final String DOCTORCODE= "Doctorcode";
	public static final String DOCTORNAME= "Doctorname";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_contagion_hb() {
		return ((String) getAttrVal("Id_contagion_hb"));
	}	
	public void setId_contagion_hb(String Id_contagion_hb) {
		setAttrVal("Id_contagion_hb", Id_contagion_hb);
	}
	public String getId_contagion() {
		return ((String) getAttrVal("Id_contagion"));
	}	
	public void setId_contagion(String Id_contagion) {
		setAttrVal("Id_contagion", Id_contagion);
	}
	public String getId_form() {
		return ((String) getAttrVal("Id_form"));
	}	
	public void setId_form(String Id_form) {
		setAttrVal("Id_form", Id_form);
	}
	public String getId_hbsag_dt() {
		return ((String) getAttrVal("Id_hbsag_dt"));
	}	
	public void setId_hbsag_dt(String Id_hbsag_dt) {
		setAttrVal("Id_hbsag_dt", Id_hbsag_dt);
	}
	public String getCode_hbsag_dt() {
		return ((String) getAttrVal("Code_hbsag_dt"));
	}	
	public void setCode_hbsag_dt(String Code_hbsag_dt) {
		setAttrVal("Code_hbsag_dt", Code_hbsag_dt);
	}
	public String getName_hbsag_dt() {
		return ((String) getAttrVal("Name_hbsag_dt"));
	}	
	public void setName_hbsag_dt(String Name_hbsag_dt) {
		setAttrVal("Name_hbsag_dt", Name_hbsag_dt);
	}
	public FDate getDt_first() {
		return ((FDate) getAttrVal("Dt_first"));
	}	
	public void setDt_first(FDate Dt_first) {
		setAttrVal("Dt_first", Dt_first);
	}
	public String getAlt() {
		return ((String) getAttrVal("Alt"));
	}	
	public void setAlt(String Alt) {
		setAttrVal("Alt", Alt);
	}
	public String getId_hbc_igm1() {
		return ((String) getAttrVal("Id_hbc_igm1"));
	}	
	public void setId_hbc_igm1(String Id_hbc_igm1) {
		setAttrVal("Id_hbc_igm1", Id_hbc_igm1);
	}
	public String getCode_hbc_igm1() {
		return ((String) getAttrVal("Code_hbc_igm1"));
	}	
	public void setCode_hbc_igm1(String Code_hbc_igm1) {
		setAttrVal("Code_hbc_igm1", Code_hbc_igm1);
	}
	public String getName_hbc_igm1() {
		return ((String) getAttrVal("Name_hbc_igm1"));
	}	
	public void setName_hbc_igm1(String Name_hbc_igm1) {
		setAttrVal("Name_hbc_igm1", Name_hbc_igm1);
	}
	public String getId_liver_puncture_results() {
		return ((String) getAttrVal("Id_liver_puncture_results"));
	}	
	public void setId_liver_puncture_results(String Id_liver_puncture_results) {
		setAttrVal("Id_liver_puncture_results", Id_liver_puncture_results);
	}
	public String getCode_liver_puncture_results() {
		return ((String) getAttrVal("Code_liver_puncture_results"));
	}	
	public void setCode_liver_puncture_results(String Code_liver_puncture_results) {
		setAttrVal("Code_liver_puncture_results", Code_liver_puncture_results);
	}
	public String getName_liver_puncture_results() {
		return ((String) getAttrVal("Name_liver_puncture_results"));
	}	
	public void setName_liver_puncture_results(String Name_liver_puncture_results) {
		setAttrVal("Name_liver_puncture_results", Name_liver_puncture_results);
	}
	public String getId_hbsag_huifu() {
		return ((String) getAttrVal("Id_hbsag_huifu"));
	}	
	public void setId_hbsag_huifu(String Id_hbsag_huifu) {
		setAttrVal("Id_hbsag_huifu", Id_hbsag_huifu);
	}
	public String getCode_hbsag_huifu() {
		return ((String) getAttrVal("Code_hbsag_huifu"));
	}	
	public void setCode_hbsag_huifu(String Code_hbsag_huifu) {
		setAttrVal("Code_hbsag_huifu", Code_hbsag_huifu);
	}
	public String getName_hbsag_huifu() {
		return ((String) getAttrVal("Name_hbsag_huifu"));
	}	
	public void setName_hbsag_huifu(String Name_hbsag_huifu) {
		setAttrVal("Name_hbsag_huifu", Name_hbsag_huifu);
	}
	public FBoolean getIs_know() {
		return ((FBoolean) getAttrVal("Is_know"));
	}	
	public void setIs_know(FBoolean Is_know) {
		setAttrVal("Is_know", Is_know);
	}
	public String getCard_no() {
		return ((String) getAttrVal("Card_no"));
	}	
	public void setCard_no(String Card_no) {
		setAttrVal("Card_no", Card_no);
	}
	public String getPat_name() {
		return ((String) getAttrVal("Pat_name"));
	}	
	public void setPat_name(String Pat_name) {
		setAttrVal("Pat_name", Pat_name);
	}
	public String getParent_name() {
		return ((String) getAttrVal("Parent_name"));
	}	
	public void setParent_name(String Parent_name) {
		setAttrVal("Parent_name", Parent_name);
	}
	public String getHjdz() {
		return ((String) getAttrVal("Hjdz"));
	}	
	public void setHjdz(String Hjdz) {
		setAttrVal("Hjdz", Hjdz);
	}
	public String getCode_hjdz() {
		return ((String) getAttrVal("Code_hjdz"));
	}	
	public void setCode_hjdz(String Code_hjdz) {
		setAttrVal("Code_hjdz", Code_hjdz);
	}
	public String getName_hjdz() {
		return ((String) getAttrVal("Name_hjdz"));
	}	
	public void setName_hjdz(String Name_hjdz) {
		setAttrVal("Name_hjdz", Name_hjdz);
	}
	public String getTown() {
		return ((String) getAttrVal("Town"));
	}	
	public void setTown(String Town) {
		setAttrVal("Town", Town);
	}
	public String getVallege() {
		return ((String) getAttrVal("Vallege"));
	}	
	public void setVallege(String Vallege) {
		setAttrVal("Vallege", Vallege);
	}
	public String getHouse_no() {
		return ((String) getAttrVal("House_no"));
	}	
	public void setHouse_no(String House_no) {
		setAttrVal("House_no", House_no);
	}
	public String getRept_doctor() {
		return ((String) getAttrVal("Rept_doctor"));
	}	
	public void setRept_doctor(String Rept_doctor) {
		setAttrVal("Rept_doctor", Rept_doctor);
	}
	public String getRelation_way() {
		return ((String) getAttrVal("Relation_way"));
	}	
	public void setRelation_way(String Relation_way) {
		setAttrVal("Relation_way", Relation_way);
	}
	public String getCode_rept_doctor() {
		return ((String) getAttrVal("Code_rept_doctor"));
	}	
	public void setCode_rept_doctor(String Code_rept_doctor) {
		setAttrVal("Code_rept_doctor", Code_rept_doctor);
	}
	public String getName_rept_doctor() {
		return ((String) getAttrVal("Name_rept_doctor"));
	}	
	public void setName_rept_doctor(String Name_rept_doctor) {
		setAttrVal("Name_rept_doctor", Name_rept_doctor);
	}
	public String getHbsag_dt_code() {
		return ((String) getAttrVal("Hbsag_dt_code"));
	}	
	public void setHbsag_dt_code(String Hbsag_dt_code) {
		setAttrVal("Hbsag_dt_code", Hbsag_dt_code);
	}
	public String getHbsag_dt_name() {
		return ((String) getAttrVal("Hbsag_dt_name"));
	}	
	public void setHbsag_dt_name(String Hbsag_dt_name) {
		setAttrVal("Hbsag_dt_name", Hbsag_dt_name);
	}
	public String getHbc_igm_code() {
		return ((String) getAttrVal("Hbc_igm_code"));
	}	
	public void setHbc_igm_code(String Hbc_igm_code) {
		setAttrVal("Hbc_igm_code", Hbc_igm_code);
	}
	public String getHbc_igm_name() {
		return ((String) getAttrVal("Hbc_igm_name"));
	}	
	public void setHbc_igm_name(String Hbc_igm_name) {
		setAttrVal("Hbc_igm_name", Hbc_igm_name);
	}
	public String getLiver_puncture_results_code() {
		return ((String) getAttrVal("Liver_puncture_results_code"));
	}	
	public void setLiver_puncture_results_code(String Liver_puncture_results_code) {
		setAttrVal("Liver_puncture_results_code", Liver_puncture_results_code);
	}
	public String getLiver_puncture_results_name() {
		return ((String) getAttrVal("Liver_puncture_results_name"));
	}	
	public void setLiver_puncture_results_name(String Liver_puncture_results_name) {
		setAttrVal("Liver_puncture_results_name", Liver_puncture_results_name);
	}
	public String getHbsag_huifu_code() {
		return ((String) getAttrVal("Hbsag_huifu_code"));
	}	
	public void setHbsag_huifu_code(String Hbsag_huifu_code) {
		setAttrVal("Hbsag_huifu_code", Hbsag_huifu_code);
	}
	public String getHbsag_huifu_name() {
		return ((String) getAttrVal("Hbsag_huifu_name"));
	}	
	public void setHbsag_huifu_name(String Hbsag_huifu_name) {
		setAttrVal("Hbsag_huifu_name", Hbsag_huifu_name);
	}
	public String getAreacode() {
		return ((String) getAttrVal("Areacode"));
	}	
	public void setAreacode(String Areacode) {
		setAttrVal("Areacode", Areacode);
	}
	public String getAreaname() {
		return ((String) getAttrVal("Areaname"));
	}	
	public void setAreaname(String Areaname) {
		setAttrVal("Areaname", Areaname);
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
		return "Id_contagion_hb";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_MR_CONTAGION_CARD_HB";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HepatitisBDODesc.class);
	}
	
}