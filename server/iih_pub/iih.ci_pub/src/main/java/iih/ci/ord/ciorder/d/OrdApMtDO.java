package iih.ci.ord.ciorder.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.ciorder.d.desc.OrdApMtDODesc;
import java.math.BigDecimal;

/**
 * 医嘱医技辅申请 DO数据 
 * 
 */
public class OrdApMtDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_ORMT= "Id_ormt";
	public static final String ID_OR= "Id_or";
	public static final String ID_ORDI= "Id_ordi";
	public static final String ID_ORDIITM= "Id_ordiitm";
	public static final String STR_ID_DI= "Str_id_di";
	public static final String STR_NAME_DI= "Str_name_di";
	public static final String NO_APPLYFORM= "No_applyform";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_ormt() {
		return ((String) getAttrVal("Id_ormt"));
	}	
	public void setId_ormt(String Id_ormt) {
		setAttrVal("Id_ormt", Id_ormt);
	}
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	public String getId_ordi() {
		return ((String) getAttrVal("Id_ordi"));
	}	
	public void setId_ordi(String Id_ordi) {
		setAttrVal("Id_ordi", Id_ordi);
	}
	public String getId_ordiitm() {
		return ((String) getAttrVal("Id_ordiitm"));
	}	
	public void setId_ordiitm(String Id_ordiitm) {
		setAttrVal("Id_ordiitm", Id_ordiitm);
	}
	public String getStr_id_di() {
		return ((String) getAttrVal("Str_id_di"));
	}	
	public void setStr_id_di(String Str_id_di) {
		setAttrVal("Str_id_di", Str_id_di);
	}
	public String getStr_name_di() {
		return ((String) getAttrVal("Str_name_di"));
	}	
	public void setStr_name_di(String Str_name_di) {
		setAttrVal("Str_name_di", Str_name_di);
	}
	public String getNo_applyform() {
		return ((String) getAttrVal("No_applyform"));
	}	
	public void setNo_applyform(String No_applyform) {
		setAttrVal("No_applyform", No_applyform);
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
		return "Id_ormt";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_ap_mt";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OrdApMtDODesc.class);
	}
	
}