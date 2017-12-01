package iih.ci.ord.app.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.app.d.desc.CiAppTreatExecOrDODesc;
import java.math.BigDecimal;

/**
 * 门诊诊疗执行单对应医嘱 DO数据 
 * 
 */
public class CiAppTreatExecOrDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_CIAPPTREATEXECOR= "Id_ciapptreatexecor";
	public static final String ID_CIAPPTREATEXEC= "Id_ciapptreatexec";
	public static final String ID_OR= "Id_or";
	public static final String AMT_OR= "Amt_or";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_ciapptreatexecor() {
		return ((String) getAttrVal("Id_ciapptreatexecor"));
	}	
	public void setId_ciapptreatexecor(String Id_ciapptreatexecor) {
		setAttrVal("Id_ciapptreatexecor", Id_ciapptreatexecor);
	}
	public String getId_ciapptreatexec() {
		return ((String) getAttrVal("Id_ciapptreatexec"));
	}	
	public void setId_ciapptreatexec(String Id_ciapptreatexec) {
		setAttrVal("Id_ciapptreatexec", Id_ciapptreatexec);
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
		return "Id_ciapptreatexecor";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_app_treatexec_or";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiAppTreatExecOrDODesc.class);
	}
	
}