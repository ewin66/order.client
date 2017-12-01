package iih.ci.ord.ciorder.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.ciorder.d.desc.OrdNurseCareDODesc;
import java.math.BigDecimal;

/**
 * 临床医嘱护理 DO数据 
 * 
 */
public class OrdNurseCareDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_ORNU= "Id_ornu";
	public static final String ID_OR= "Id_or";
	public static final String NAME3= "Name3";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_ornu() {
		return ((String) getAttrVal("Id_ornu"));
	}	
	public void setId_ornu(String Id_ornu) {
		setAttrVal("Id_ornu", Id_ornu);
	}
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	public String getName3() {
		return ((String) getAttrVal("Name3"));
	}	
	public void setName3(String Name3) {
		setAttrVal("Name3", Name3);
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
		return "Id_ornu";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_or_nu";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OrdNurseCareDODesc.class);
	}
	
}