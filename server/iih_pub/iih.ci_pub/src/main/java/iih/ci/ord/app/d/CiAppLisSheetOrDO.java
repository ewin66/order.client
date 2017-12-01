package iih.ci.ord.app.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.app.d.desc.CiAppLisSheetOrDODesc;
import java.math.BigDecimal;

/**
 * 检验申请单对应医嘱 DO数据 
 * 
 */
public class CiAppLisSheetOrDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_CIAPPLISSHEETOR= "Id_ciapplissheetor";
	public static final String ID_CIAPPLISSHEET= "Id_ciapplissheet";
	public static final String ID_ORLAB= "Id_orlab";
	public static final String ID_OR= "Id_or";
	public static final String AMT_APP= "Amt_app";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_ciapplissheetor() {
		return ((String) getAttrVal("Id_ciapplissheetor"));
	}	
	public void setId_ciapplissheetor(String Id_ciapplissheetor) {
		setAttrVal("Id_ciapplissheetor", Id_ciapplissheetor);
	}
	public String getId_ciapplissheet() {
		return ((String) getAttrVal("Id_ciapplissheet"));
	}	
	public void setId_ciapplissheet(String Id_ciapplissheet) {
		setAttrVal("Id_ciapplissheet", Id_ciapplissheet);
	}
	public String getId_orlab() {
		return ((String) getAttrVal("Id_orlab"));
	}	
	public void setId_orlab(String Id_orlab) {
		setAttrVal("Id_orlab", Id_orlab);
	}
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	public FDouble getAmt_app() {
		return ((FDouble) getAttrVal("Amt_app"));
	}	
	public void setAmt_app(FDouble Amt_app) {
		setAttrVal("Amt_app", Amt_app);
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
		return "Id_ciapplissheetor";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_app_lis_or";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiAppLisSheetOrDODesc.class);
	}
	
}