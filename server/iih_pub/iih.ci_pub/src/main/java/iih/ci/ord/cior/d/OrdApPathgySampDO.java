package iih.ci.ord.cior.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.cior.d.desc.OrdApPathgySampDODesc;
import java.math.BigDecimal;

/**
 * 病理标本 DO数据 
 * 
 */
public class OrdApPathgySampDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_APPATHGYSAMP= "Id_appathgysamp";
	public static final String ID_APPATHGY= "Id_appathgy";
	public static final String NAME_LABSAMP= "Name_labsamp";
	public static final String ID_BODY_COLL= "Id_body_coll";
	public static final String SD_BODY_COLL= "Sd_body_coll";
	public static final String BODY_COLL= "Body_coll";
	public static final String QUAN_COLL= "Quan_coll";
	public static final String ID_FIXATIVE= "Id_fixative";
	public static final String SD_FIXATIVE= "Sd_fixative";
	public static final String FIXATIVE= "Fixative";
	public static final String ID_SU_LABSAMP= "Id_su_labsamp";
	public static final String SD_SU_LABSAMP= "Sd_su_labsamp";
	public static final String ID_DEP_SIGN= "Id_dep_sign";
	public static final String ID_EMP_SIGN= "Id_emp_sign";
	public static final String DT_SIGN= "Dt_sign";
	public static final String SORTNO= "Sortno";
	public static final String NAME_BODY_COLL= "Name_body_coll";
	public static final String NAME_FIXATIVE= "Name_fixative";
	public static final String NAME_SU_LABSAMP= "Name_su_labsamp";
	public static final String NAME_DEP_SIGN= "Name_dep_sign";
	public static final String CODE_DEP_SIGN= "Code_dep_sign";
	public static final String NAME_EMP_SIGN= "Name_emp_sign";
	public static final String CODE_EMP_SIGN= "Code_emp_sign";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_appathgysamp() {
		return ((String) getAttrVal("Id_appathgysamp"));
	}	
	public void setId_appathgysamp(String Id_appathgysamp) {
		setAttrVal("Id_appathgysamp", Id_appathgysamp);
	}
	public String getId_appathgy() {
		return ((String) getAttrVal("Id_appathgy"));
	}	
	public void setId_appathgy(String Id_appathgy) {
		setAttrVal("Id_appathgy", Id_appathgy);
	}
	public String getName_labsamp() {
		return ((String) getAttrVal("Name_labsamp"));
	}	
	public void setName_labsamp(String Name_labsamp) {
		setAttrVal("Name_labsamp", Name_labsamp);
	}
	public String getId_body_coll() {
		return ((String) getAttrVal("Id_body_coll"));
	}	
	public void setId_body_coll(String Id_body_coll) {
		setAttrVal("Id_body_coll", Id_body_coll);
	}
	public String getSd_body_coll() {
		return ((String) getAttrVal("Sd_body_coll"));
	}	
	public void setSd_body_coll(String Sd_body_coll) {
		setAttrVal("Sd_body_coll", Sd_body_coll);
	}
	public String getBody_coll() {
		return ((String) getAttrVal("Body_coll"));
	}	
	public void setBody_coll(String Body_coll) {
		setAttrVal("Body_coll", Body_coll);
	}
	public Integer getQuan_coll() {
		return ((Integer) getAttrVal("Quan_coll"));
	}	
	public void setQuan_coll(Integer Quan_coll) {
		setAttrVal("Quan_coll", Quan_coll);
	}
	public String getId_fixative() {
		return ((String) getAttrVal("Id_fixative"));
	}	
	public void setId_fixative(String Id_fixative) {
		setAttrVal("Id_fixative", Id_fixative);
	}
	public String getSd_fixative() {
		return ((String) getAttrVal("Sd_fixative"));
	}	
	public void setSd_fixative(String Sd_fixative) {
		setAttrVal("Sd_fixative", Sd_fixative);
	}
	public String getFixative() {
		return ((String) getAttrVal("Fixative"));
	}	
	public void setFixative(String Fixative) {
		setAttrVal("Fixative", Fixative);
	}
	public String getId_su_labsamp() {
		return ((String) getAttrVal("Id_su_labsamp"));
	}	
	public void setId_su_labsamp(String Id_su_labsamp) {
		setAttrVal("Id_su_labsamp", Id_su_labsamp);
	}
	public String getSd_su_labsamp() {
		return ((String) getAttrVal("Sd_su_labsamp"));
	}	
	public void setSd_su_labsamp(String Sd_su_labsamp) {
		setAttrVal("Sd_su_labsamp", Sd_su_labsamp);
	}
	public String getId_dep_sign() {
		return ((String) getAttrVal("Id_dep_sign"));
	}	
	public void setId_dep_sign(String Id_dep_sign) {
		setAttrVal("Id_dep_sign", Id_dep_sign);
	}
	public String getId_emp_sign() {
		return ((String) getAttrVal("Id_emp_sign"));
	}	
	public void setId_emp_sign(String Id_emp_sign) {
		setAttrVal("Id_emp_sign", Id_emp_sign);
	}
	public FDateTime getDt_sign() {
		return ((FDateTime) getAttrVal("Dt_sign"));
	}	
	public void setDt_sign(FDateTime Dt_sign) {
		setAttrVal("Dt_sign", Dt_sign);
	}
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	public String getName_body_coll() {
		return ((String) getAttrVal("Name_body_coll"));
	}	
	public void setName_body_coll(String Name_body_coll) {
		setAttrVal("Name_body_coll", Name_body_coll);
	}
	public String getName_fixative() {
		return ((String) getAttrVal("Name_fixative"));
	}	
	public void setName_fixative(String Name_fixative) {
		setAttrVal("Name_fixative", Name_fixative);
	}
	public String getName_su_labsamp() {
		return ((String) getAttrVal("Name_su_labsamp"));
	}	
	public void setName_su_labsamp(String Name_su_labsamp) {
		setAttrVal("Name_su_labsamp", Name_su_labsamp);
	}
	public String getName_dep_sign() {
		return ((String) getAttrVal("Name_dep_sign"));
	}	
	public void setName_dep_sign(String Name_dep_sign) {
		setAttrVal("Name_dep_sign", Name_dep_sign);
	}
	public String getCode_dep_sign() {
		return ((String) getAttrVal("Code_dep_sign"));
	}	
	public void setCode_dep_sign(String Code_dep_sign) {
		setAttrVal("Code_dep_sign", Code_dep_sign);
	}
	public String getName_emp_sign() {
		return ((String) getAttrVal("Name_emp_sign"));
	}	
	public void setName_emp_sign(String Name_emp_sign) {
		setAttrVal("Name_emp_sign", Name_emp_sign);
	}
	public String getCode_emp_sign() {
		return ((String) getAttrVal("Code_emp_sign"));
	}	
	public void setCode_emp_sign(String Code_emp_sign) {
		setAttrVal("Code_emp_sign", Code_emp_sign);
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
		return "Id_appathgysamp";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_pathgy_samp";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OrdApPathgySampDODesc.class);
	}
	
}