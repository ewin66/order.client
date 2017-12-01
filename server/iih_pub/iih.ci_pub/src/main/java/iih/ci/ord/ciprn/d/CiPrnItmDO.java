package iih.ci.ord.ciprn.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.ciprn.d.desc.CiPrnItmDODesc;
import java.math.BigDecimal;

/**
 * 临床打印单明细 DO数据 
 * 
 */
public class CiPrnItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_CIPRNITM= "Id_ciprnitm";
	public static final String ID_CIPRN= "Id_ciprn";
	public static final String ID_BIZ= "Id_biz";
	public static final String AMT_BIZ= "Amt_biz";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_ciprnitm() {
		return ((String) getAttrVal("Id_ciprnitm"));
	}	
	public void setId_ciprnitm(String Id_ciprnitm) {
		setAttrVal("Id_ciprnitm", Id_ciprnitm);
	}
	public String getId_ciprn() {
		return ((String) getAttrVal("Id_ciprn"));
	}	
	public void setId_ciprn(String Id_ciprn) {
		setAttrVal("Id_ciprn", Id_ciprn);
	}
	public String getId_biz() {
		return ((String) getAttrVal("Id_biz"));
	}	
	public void setId_biz(String Id_biz) {
		setAttrVal("Id_biz", Id_biz);
	}
	public FDouble getAmt_biz() {
		return ((FDouble) getAttrVal("Amt_biz"));
	}	
	public void setAmt_biz(FDouble Amt_biz) {
		setAttrVal("Amt_biz", Amt_biz);
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
		return "Id_ciprnitm";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_prn_item";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiPrnItmDODesc.class);
	}
	
}