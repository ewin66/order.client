package iih.ci.mr.cimreledg.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.cimreledg.d.desc.CiMrEleDgDODesc;
import java.math.BigDecimal;

/**
 * 临床医疗记录元素_数据组 DO数据 
 * 
 */
public class CiMrEleDgDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MRDG= "Id_mrdg";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_MRTPLDG= "Id_mrtpldg";
	public static final String NAME_MRDG= "Name_mrdg";
	public static final String ID_DG= "Id_dg";
	public static final String ID_MRDG_PAT= "Id_mrdg_pat";
	public static final String ID_MR= "Id_mr";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_mrdg() {
		return ((String) getAttrVal("Id_mrdg"));
	}	
	public void setId_mrdg(String Id_mrdg) {
		setAttrVal("Id_mrdg", Id_mrdg);
	}
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	public String getId_mrtpldg() {
		return ((String) getAttrVal("Id_mrtpldg"));
	}	
	public void setId_mrtpldg(String Id_mrtpldg) {
		setAttrVal("Id_mrtpldg", Id_mrtpldg);
	}
	public String getName_mrdg() {
		return ((String) getAttrVal("Name_mrdg"));
	}	
	public void setName_mrdg(String Name_mrdg) {
		setAttrVal("Name_mrdg", Name_mrdg);
	}
	public String getId_dg() {
		return ((String) getAttrVal("Id_dg"));
	}	
	public void setId_dg(String Id_dg) {
		setAttrVal("Id_dg", Id_dg);
	}
	public String getId_mrdg_pat() {
		return ((String) getAttrVal("Id_mrdg_pat"));
	}	
	public void setId_mrdg_pat(String Id_mrdg_pat) {
		setAttrVal("Id_mrdg_pat", Id_mrdg_pat);
	}
	public String getId_mr() {
		return ((String) getAttrVal("Id_mr"));
	}	
	public void setId_mr(String Id_mr) {
		setAttrVal("Id_mr", Id_mr);
	}
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}	
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}	
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}	
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}	
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
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
		return "Id_mrdg";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_MR_ELE_DG";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiMrEleDgDODesc.class);
	}
	
}