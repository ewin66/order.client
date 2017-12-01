package iih.ci.pre.obspre.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.pre.obspre.d.desc.ObsPreSrvDODesc;
import java.math.BigDecimal;

/**
 * 预检服务项目 DO数据 
 * 
 */
public class ObsPreSrvDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PREOBSSRV= "Id_preobssrv";
	public static final String ID_OBSPRE= "Id_obspre";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_SRV= "Id_srv";
	public static final String VAL0= "Val0";
	public static final String VAL1= "Val1";
	public static final String VAL2= "Val2";
	public static final String VAL3= "Val3";
	public static final String VAL4= "Val4";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_preobssrv() {
		return ((String) getAttrVal("Id_preobssrv"));
	}	
	public void setId_preobssrv(String Id_preobssrv) {
		setAttrVal("Id_preobssrv", Id_preobssrv);
	}
	public String getId_obspre() {
		return ((String) getAttrVal("Id_obspre"));
	}	
	public void setId_obspre(String Id_obspre) {
		setAttrVal("Id_obspre", Id_obspre);
	}
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	public String getVal0() {
		return ((String) getAttrVal("Val0"));
	}	
	public void setVal0(String Val0) {
		setAttrVal("Val0", Val0);
	}
	public String getVal1() {
		return ((String) getAttrVal("Val1"));
	}	
	public void setVal1(String Val1) {
		setAttrVal("Val1", Val1);
	}
	public String getVal2() {
		return ((String) getAttrVal("Val2"));
	}	
	public void setVal2(String Val2) {
		setAttrVal("Val2", Val2);
	}
	public String getVal3() {
		return ((String) getAttrVal("Val3"));
	}	
	public void setVal3(String Val3) {
		setAttrVal("Val3", Val3);
	}
	public String getVal4() {
		return ((String) getAttrVal("Val4"));
	}	
	public void setVal4(String Val4) {
		setAttrVal("Val4", Val4);
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
		return "Id_preobssrv";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_obs_pre_srv";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ObsPreSrvDODesc.class);
	}
	
}