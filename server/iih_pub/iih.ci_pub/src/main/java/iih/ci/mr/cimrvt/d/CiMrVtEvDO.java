package iih.ci.mr.cimrvt.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.cimrvt.d.desc.CiMrVtEvDODesc;
import java.math.BigDecimal;

/**
 * 临床生命体征测量事件 DO数据 
 * 
 */
public class CiMrVtEvDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MRVTEV= "Id_mrvtev";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_MRVT= "Id_mrvt";
	public static final String SORTNO= "Sortno";
	public static final String ID_VT_EV= "Id_vt_ev";
	public static final String SD_VT_EV= "Sd_vt_ev";
	public static final String NAME_VT_EV= "Name_vt_ev";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_mrvtev() {
		return ((String) getAttrVal("Id_mrvtev"));
	}	
	public void setId_mrvtev(String Id_mrvtev) {
		setAttrVal("Id_mrvtev", Id_mrvtev);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	public String getId_mrvt() {
		return ((String) getAttrVal("Id_mrvt"));
	}	
	public void setId_mrvt(String Id_mrvt) {
		setAttrVal("Id_mrvt", Id_mrvt);
	}
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	public String getId_vt_ev() {
		return ((String) getAttrVal("Id_vt_ev"));
	}	
	public void setId_vt_ev(String Id_vt_ev) {
		setAttrVal("Id_vt_ev", Id_vt_ev);
	}
	public String getSd_vt_ev() {
		return ((String) getAttrVal("Sd_vt_ev"));
	}	
	public void setSd_vt_ev(String Sd_vt_ev) {
		setAttrVal("Sd_vt_ev", Sd_vt_ev);
	}
	public String getName_vt_ev() {
		return ((String) getAttrVal("Name_vt_ev"));
	}	
	public void setName_vt_ev(String Name_vt_ev) {
		setAttrVal("Name_vt_ev", Name_vt_ev);
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
		return "Id_mrvtev";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_mr_vt_ev";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiMrVtEvDODesc.class);
	}
	
}