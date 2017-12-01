package iih.ci.ord.ciorsrvhp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.ciorsrvhp.d.desc.CiOrSrvHpDODesc;
import java.math.BigDecimal;

/**
 * 医嘱项目医保信息 DO数据 
 * 
 */
public class CiOrSrvHpDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_ORSRV_HP= "Id_orsrv_hp";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_ORSRV= "Id_orsrv";
	public static final String ID_HP= "Id_hp";
	public static final String ID_HPSRVTP= "Id_hpsrvtp";
	public static final String SD_HPSRVTP= "Sd_hpsrvtp";
	public static final String FG_INDIC= "Fg_indic";
	public static final String DES_HPSRVTP= "Des_hpsrvtp";
	public static final String DES_HPLIMIT= "Des_hplimit";
	public static final String EU_HPINDICJUDGED_MODEL= "Eu_hpindicjudged_model";
	public static final String INDICITEMID= "Indicitemid";
	public static final String EU_HPINDICRST= "Eu_hpindicrst";
	public static final String DES_HPINDICRST= "Des_hpindicrst";
	public static final String FG_SPECILL= "Fg_specill";
	public static final String FG_SELFPAY= "Fg_selfpay";
	public static final String DEF1= "Def1";
	public static final String DEF2= "Def2";
	public static final String DEF3= "Def3";
	public static final String DEF4= "Def4";
	public static final String DEF5= "Def5";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_orsrv_hp() {
		return ((String) getAttrVal("Id_orsrv_hp"));
	}	
	public void setId_orsrv_hp(String Id_orsrv_hp) {
		setAttrVal("Id_orsrv_hp", Id_orsrv_hp);
	}
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}	
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}	
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	public String getId_hpsrvtp() {
		return ((String) getAttrVal("Id_hpsrvtp"));
	}	
	public void setId_hpsrvtp(String Id_hpsrvtp) {
		setAttrVal("Id_hpsrvtp", Id_hpsrvtp);
	}
	public String getSd_hpsrvtp() {
		return ((String) getAttrVal("Sd_hpsrvtp"));
	}	
	public void setSd_hpsrvtp(String Sd_hpsrvtp) {
		setAttrVal("Sd_hpsrvtp", Sd_hpsrvtp);
	}
	public FBoolean getFg_indic() {
		return ((FBoolean) getAttrVal("Fg_indic"));
	}	
	public void setFg_indic(FBoolean Fg_indic) {
		setAttrVal("Fg_indic", Fg_indic);
	}
	public String getDes_hpsrvtp() {
		return ((String) getAttrVal("Des_hpsrvtp"));
	}	
	public void setDes_hpsrvtp(String Des_hpsrvtp) {
		setAttrVal("Des_hpsrvtp", Des_hpsrvtp);
	}
	public String getDes_hplimit() {
		return ((String) getAttrVal("Des_hplimit"));
	}	
	public void setDes_hplimit(String Des_hplimit) {
		setAttrVal("Des_hplimit", Des_hplimit);
	}
	public String getEu_hpindicjudged_model() {
		return ((String) getAttrVal("Eu_hpindicjudged_model"));
	}	
	public void setEu_hpindicjudged_model(String Eu_hpindicjudged_model) {
		setAttrVal("Eu_hpindicjudged_model", Eu_hpindicjudged_model);
	}
	public String getIndicitemid() {
		return ((String) getAttrVal("Indicitemid"));
	}	
	public void setIndicitemid(String Indicitemid) {
		setAttrVal("Indicitemid", Indicitemid);
	}
	public String getEu_hpindicrst() {
		return ((String) getAttrVal("Eu_hpindicrst"));
	}	
	public void setEu_hpindicrst(String Eu_hpindicrst) {
		setAttrVal("Eu_hpindicrst", Eu_hpindicrst);
	}
	public String getDes_hpindicrst() {
		return ((String) getAttrVal("Des_hpindicrst"));
	}	
	public void setDes_hpindicrst(String Des_hpindicrst) {
		setAttrVal("Des_hpindicrst", Des_hpindicrst);
	}
	public FBoolean getFg_specill() {
		return ((FBoolean) getAttrVal("Fg_specill"));
	}	
	public void setFg_specill(FBoolean Fg_specill) {
		setAttrVal("Fg_specill", Fg_specill);
	}
	public FBoolean getFg_selfpay() {
		return ((FBoolean) getAttrVal("Fg_selfpay"));
	}	
	public void setFg_selfpay(FBoolean Fg_selfpay) {
		setAttrVal("Fg_selfpay", Fg_selfpay);
	}
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}	
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}	
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}	
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
	public String getDef4() {
		return ((String) getAttrVal("Def4"));
	}	
	public void setDef4(String Def4) {
		setAttrVal("Def4", Def4);
	}
	public String getDef5() {
		return ((String) getAttrVal("Def5"));
	}	
	public void setDef5(String Def5) {
		setAttrVal("Def5", Def5);
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
		return "Id_orsrv_hp";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_or_srv_hp";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiOrSrvHpDODesc.class);
	}
	
}