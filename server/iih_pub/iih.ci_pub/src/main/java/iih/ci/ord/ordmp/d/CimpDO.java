package iih.ci.ord.ordmp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.ordmp.d.desc.CimpDODesc;
import java.math.BigDecimal;

/**
 * 医嘱关键执行事件及状态 DO数据 
 * 
 */
public class CimpDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_CIMP= "Id_cimp";
	public static final String ID_OR= "Id_or";
	public static final String DT_MP= "Dt_mp";
	public static final String ID_ORG_MP= "Id_org_mp";
	public static final String ID_DEP_MP= "Id_dep_mp";
	public static final String ID_EMP_MP= "Id_emp_mp";
	public static final String DES_MP= "Des_mp";
	public static final String ID_ORPLTPSTA= "Id_orpltpsta";
	public static final String ID_ORPRSTA= "Id_orprsta";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_cimp() {
		return ((String) getAttrVal("Id_cimp"));
	}	
	public void setId_cimp(String Id_cimp) {
		setAttrVal("Id_cimp", Id_cimp);
	}
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	public FDateTime getDt_mp() {
		return ((FDateTime) getAttrVal("Dt_mp"));
	}	
	public void setDt_mp(FDateTime Dt_mp) {
		setAttrVal("Dt_mp", Dt_mp);
	}
	public String getId_org_mp() {
		return ((String) getAttrVal("Id_org_mp"));
	}	
	public void setId_org_mp(String Id_org_mp) {
		setAttrVal("Id_org_mp", Id_org_mp);
	}
	public String getId_dep_mp() {
		return ((String) getAttrVal("Id_dep_mp"));
	}	
	public void setId_dep_mp(String Id_dep_mp) {
		setAttrVal("Id_dep_mp", Id_dep_mp);
	}
	public String getId_emp_mp() {
		return ((String) getAttrVal("Id_emp_mp"));
	}	
	public void setId_emp_mp(String Id_emp_mp) {
		setAttrVal("Id_emp_mp", Id_emp_mp);
	}
	public String getDes_mp() {
		return ((String) getAttrVal("Des_mp"));
	}	
	public void setDes_mp(String Des_mp) {
		setAttrVal("Des_mp", Des_mp);
	}
	public String getId_orpltpsta() {
		return ((String) getAttrVal("Id_orpltpsta"));
	}	
	public void setId_orpltpsta(String Id_orpltpsta) {
		setAttrVal("Id_orpltpsta", Id_orpltpsta);
	}
	public String getId_orprsta() {
		return ((String) getAttrVal("Id_orprsta"));
	}	
	public void setId_orprsta(String Id_orprsta) {
		setAttrVal("Id_orprsta", Id_orprsta);
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
		return "Id_cimp";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_MP";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CimpDODesc.class);
	}
	
}