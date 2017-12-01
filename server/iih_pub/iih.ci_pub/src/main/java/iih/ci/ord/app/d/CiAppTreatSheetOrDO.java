package iih.ci.ord.app.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.app.d.desc.CiAppTreatSheetOrDODesc;
import java.math.BigDecimal;

/**
 * 诊疗申请单对应医嘱 DO数据 
 * 
 */
public class CiAppTreatSheetOrDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_CIAPPTREATSHEETOR= "Id_ciapptreatsheetor";
	public static final String ID_CIAPPTREATSHEET= "Id_ciapptreatsheet";
	public static final String ID_OR= "Id_or";
	public static final String AMT_OR= "Amt_or";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_ciapptreatsheetor() {
		return ((String) getAttrVal("Id_ciapptreatsheetor"));
	}	
	public void setId_ciapptreatsheetor(String Id_ciapptreatsheetor) {
		setAttrVal("Id_ciapptreatsheetor", Id_ciapptreatsheetor);
	}
	public String getId_ciapptreatsheet() {
		return ((String) getAttrVal("Id_ciapptreatsheet"));
	}	
	public void setId_ciapptreatsheet(String Id_ciapptreatsheet) {
		setAttrVal("Id_ciapptreatsheet", Id_ciapptreatsheet);
	}
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	public FDouble getAmt_or() {
		return ((FDouble) getAttrVal("Amt_or"));
	}	
	public void setAmt_or(FDouble Amt_or) {
		setAttrVal("Amt_or", Amt_or);
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
		return "Id_ciapptreatsheetor";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_app_treat_or";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiAppTreatSheetOrDODesc.class);
	}
	
}