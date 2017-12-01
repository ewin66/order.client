package iih.ci.rcm.contagion.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.rcm.contagion.d.desc.SyphilisDODesc;
import java.math.BigDecimal;

/**
 * 梅毒附卡 DO数据 
 * 
 */
public class SyphilisDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_CONTAGION_SS= "Id_contagion_ss";
	public static final String ID_CONTAGION= "Id_contagion";
	public static final String ID_FORM= "Id_form";
	public static final String SYPHILIS_RESULT= "Syphilis_result";
	public static final String CLINICAL_MANIFESTATION= "Clinical_manifestation";
	public static final String ID_DEP_PHYADM= "Id_dep_phyadm";
	public static final String CODE_DEP_PHYADM= "Code_dep_phyadm";
	public static final String NAME_DEP_PHYADM= "Name_dep_phyadm";
	public static final String DEP_PHYADM_CODE= "Dep_phyadm_code";
	public static final String DEP_PHYADM_NAME= "Dep_phyadm_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_contagion_ss() {
		return ((String) getAttrVal("Id_contagion_ss"));
	}	
	public void setId_contagion_ss(String Id_contagion_ss) {
		setAttrVal("Id_contagion_ss", Id_contagion_ss);
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
	public String getSyphilis_result() {
		return ((String) getAttrVal("Syphilis_result"));
	}	
	public void setSyphilis_result(String Syphilis_result) {
		setAttrVal("Syphilis_result", Syphilis_result);
	}
	public String getClinical_manifestation() {
		return ((String) getAttrVal("Clinical_manifestation"));
	}	
	public void setClinical_manifestation(String Clinical_manifestation) {
		setAttrVal("Clinical_manifestation", Clinical_manifestation);
	}
	public String getId_dep_phyadm() {
		return ((String) getAttrVal("Id_dep_phyadm"));
	}	
	public void setId_dep_phyadm(String Id_dep_phyadm) {
		setAttrVal("Id_dep_phyadm", Id_dep_phyadm);
	}
	public String getCode_dep_phyadm() {
		return ((String) getAttrVal("Code_dep_phyadm"));
	}	
	public void setCode_dep_phyadm(String Code_dep_phyadm) {
		setAttrVal("Code_dep_phyadm", Code_dep_phyadm);
	}
	public String getName_dep_phyadm() {
		return ((String) getAttrVal("Name_dep_phyadm"));
	}	
	public void setName_dep_phyadm(String Name_dep_phyadm) {
		setAttrVal("Name_dep_phyadm", Name_dep_phyadm);
	}
	public String getDep_phyadm_code() {
		return ((String) getAttrVal("Dep_phyadm_code"));
	}	
	public void setDep_phyadm_code(String Dep_phyadm_code) {
		setAttrVal("Dep_phyadm_code", Dep_phyadm_code);
	}
	public String getDep_phyadm_name() {
		return ((String) getAttrVal("Dep_phyadm_name"));
	}	
	public void setDep_phyadm_name(String Dep_phyadm_name) {
		setAttrVal("Dep_phyadm_name", Dep_phyadm_name);
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
		return "Id_contagion_ss";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_MR_CONTAGION_CARD_SS";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SyphilisDODesc.class);
	}
	
}