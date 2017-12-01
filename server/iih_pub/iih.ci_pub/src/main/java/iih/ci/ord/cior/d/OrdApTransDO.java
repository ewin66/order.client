package iih.ci.ord.cior.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.cior.d.desc.OrdApTransDODesc;
import java.math.BigDecimal;

/**
 * 医嘱转科申请 DO数据 
 * 
 */
public class OrdApTransDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_ORTRANS= "Id_ortrans";
	public static final String ID_OR= "Id_or";
	public static final String ID_DEP_TO= "Id_dep_to";
	public static final String ID_DEP_NUR_TO= "Id_dep_nur_to";
	public static final String ID_DEP_FROM= "Id_dep_from";
	public static final String ID_DEP_NUR_FROM= "Id_dep_nur_from";
	public static final String ID_SU_TRANS= "Id_su_trans";
	public static final String SD_SU_TRANS= "Sd_su_trans";
	public static final String DT_TRANS_APPLY= "Dt_trans_apply";
	public static final String DES_REA_CANC= "Des_rea_canc";
	public static final String FG_TECH_TRANS= "Fg_tech_trans";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String FG_CROSSDEPT= "Fg_crossdept";
	public static final String DT_EFFE= "Dt_effe";
	public static final String DT_END= "Dt_end";
	public static final String NAME_DEP_TO= "Name_dep_to";
	public static final String NAME_DEP_NUR_TO= "Name_dep_nur_to";
	public static final String NAME_DEP_FROM= "Name_dep_from";
	public static final String NAME_DEP_NUR_FROM= "Name_dep_nur_from";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_ortrans() {
		return ((String) getAttrVal("Id_ortrans"));
	}	
	public void setId_ortrans(String Id_ortrans) {
		setAttrVal("Id_ortrans", Id_ortrans);
	}
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	public String getId_dep_to() {
		return ((String) getAttrVal("Id_dep_to"));
	}	
	public void setId_dep_to(String Id_dep_to) {
		setAttrVal("Id_dep_to", Id_dep_to);
	}
	public String getId_dep_nur_to() {
		return ((String) getAttrVal("Id_dep_nur_to"));
	}	
	public void setId_dep_nur_to(String Id_dep_nur_to) {
		setAttrVal("Id_dep_nur_to", Id_dep_nur_to);
	}
	public String getId_dep_from() {
		return ((String) getAttrVal("Id_dep_from"));
	}	
	public void setId_dep_from(String Id_dep_from) {
		setAttrVal("Id_dep_from", Id_dep_from);
	}
	public String getId_dep_nur_from() {
		return ((String) getAttrVal("Id_dep_nur_from"));
	}	
	public void setId_dep_nur_from(String Id_dep_nur_from) {
		setAttrVal("Id_dep_nur_from", Id_dep_nur_from);
	}
	public String getId_su_trans() {
		return ((String) getAttrVal("Id_su_trans"));
	}	
	public void setId_su_trans(String Id_su_trans) {
		setAttrVal("Id_su_trans", Id_su_trans);
	}
	public String getSd_su_trans() {
		return ((String) getAttrVal("Sd_su_trans"));
	}	
	public void setSd_su_trans(String Sd_su_trans) {
		setAttrVal("Sd_su_trans", Sd_su_trans);
	}
	public FDateTime getDt_trans_apply() {
		return ((FDateTime) getAttrVal("Dt_trans_apply"));
	}	
	public void setDt_trans_apply(FDateTime Dt_trans_apply) {
		setAttrVal("Dt_trans_apply", Dt_trans_apply);
	}
	public String getDes_rea_canc() {
		return ((String) getAttrVal("Des_rea_canc"));
	}	
	public void setDes_rea_canc(String Des_rea_canc) {
		setAttrVal("Des_rea_canc", Des_rea_canc);
	}
	public FBoolean getFg_tech_trans() {
		return ((FBoolean) getAttrVal("Fg_tech_trans"));
	}	
	public void setFg_tech_trans(FBoolean Fg_tech_trans) {
		setAttrVal("Fg_tech_trans", Fg_tech_trans);
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
	public FBoolean getFg_crossdept() {
		return ((FBoolean) getAttrVal("Fg_crossdept"));
	}	
	public void setFg_crossdept(FBoolean Fg_crossdept) {
		setAttrVal("Fg_crossdept", Fg_crossdept);
	}
	public FDateTime getDt_effe() {
		return ((FDateTime) getAttrVal("Dt_effe"));
	}	
	public void setDt_effe(FDateTime Dt_effe) {
		setAttrVal("Dt_effe", Dt_effe);
	}
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}	
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	public String getName_dep_to() {
		return ((String) getAttrVal("Name_dep_to"));
	}	
	public void setName_dep_to(String Name_dep_to) {
		setAttrVal("Name_dep_to", Name_dep_to);
	}
	public String getName_dep_nur_to() {
		return ((String) getAttrVal("Name_dep_nur_to"));
	}	
	public void setName_dep_nur_to(String Name_dep_nur_to) {
		setAttrVal("Name_dep_nur_to", Name_dep_nur_to);
	}
	public String getName_dep_from() {
		return ((String) getAttrVal("Name_dep_from"));
	}	
	public void setName_dep_from(String Name_dep_from) {
		setAttrVal("Name_dep_from", Name_dep_from);
	}
	public String getName_dep_nur_from() {
		return ((String) getAttrVal("Name_dep_nur_from"));
	}	
	public void setName_dep_nur_from(String Name_dep_nur_from) {
		setAttrVal("Name_dep_nur_from", Name_dep_nur_from);
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
		return "Id_ortrans";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_ap_trans";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OrdApTransDODesc.class);
	}
	
}