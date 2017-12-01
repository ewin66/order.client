package iih.ci.ord.cior.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.cior.d.desc.OrdApOutDODesc;
import java.math.BigDecimal;

/**
 * 医嘱出院申请 DO数据 
 * 
 */
public class OrdApOutDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_OROUT= "Id_orout";
	public static final String ID_OR= "Id_or";
	public static final String ID_OUTTP= "Id_outtp";
	public static final String SD_OUTTP= "Sd_outtp";
	public static final String DT_TIMEOUT= "Dt_timeout";
	public static final String ID_DEP_OUT= "Id_dep_out";
	public static final String ID_DEP_NUR_OUT= "Id_dep_nur_out";
	public static final String ID_BED_OUT= "Id_bed_out";
	public static final String FG_DEATH= "Fg_death";
	public static final String FG_AUTOPSY= "Fg_autopsy";
	public static final String DES_OUTTP= "Des_outtp";
	public static final String FG_AGAIN31= "Fg_again31";
	public static final String DES_AGAIN31= "Des_again31";
	public static final String DEF1= "Def1";
	public static final String DEF2= "Def2";
	public static final String DEF3= "Def3";
	public static final String DEF4= "Def4";
	public static final String DEF5= "Def5";
	public static final String DEF6= "Def6";
	public static final String DEF7= "Def7";
	public static final String DEF8= "Def8";
	public static final String DEF9= "Def9";
	public static final String DEF10= "Def10";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_OUTTP= "Name_outtp";
	public static final String NAME_DEP_OUT= "Name_dep_out";
	public static final String NAME_DEP_NUR_OUT= "Name_dep_nur_out";
	public static final String NAME_BED_OUT= "Name_bed_out";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_orout() {
		return ((String) getAttrVal("Id_orout"));
	}	
	public void setId_orout(String Id_orout) {
		setAttrVal("Id_orout", Id_orout);
	}
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	public String getId_outtp() {
		return ((String) getAttrVal("Id_outtp"));
	}	
	public void setId_outtp(String Id_outtp) {
		setAttrVal("Id_outtp", Id_outtp);
	}
	public String getSd_outtp() {
		return ((String) getAttrVal("Sd_outtp"));
	}	
	public void setSd_outtp(String Sd_outtp) {
		setAttrVal("Sd_outtp", Sd_outtp);
	}
	public FDateTime getDt_timeout() {
		return ((FDateTime) getAttrVal("Dt_timeout"));
	}	
	public void setDt_timeout(FDateTime Dt_timeout) {
		setAttrVal("Dt_timeout", Dt_timeout);
	}
	public String getId_dep_out() {
		return ((String) getAttrVal("Id_dep_out"));
	}	
	public void setId_dep_out(String Id_dep_out) {
		setAttrVal("Id_dep_out", Id_dep_out);
	}
	public String getId_dep_nur_out() {
		return ((String) getAttrVal("Id_dep_nur_out"));
	}	
	public void setId_dep_nur_out(String Id_dep_nur_out) {
		setAttrVal("Id_dep_nur_out", Id_dep_nur_out);
	}
	public String getId_bed_out() {
		return ((String) getAttrVal("Id_bed_out"));
	}	
	public void setId_bed_out(String Id_bed_out) {
		setAttrVal("Id_bed_out", Id_bed_out);
	}
	public FBoolean getFg_death() {
		return ((FBoolean) getAttrVal("Fg_death"));
	}	
	public void setFg_death(FBoolean Fg_death) {
		setAttrVal("Fg_death", Fg_death);
	}
	public FBoolean getFg_autopsy() {
		return ((FBoolean) getAttrVal("Fg_autopsy"));
	}	
	public void setFg_autopsy(FBoolean Fg_autopsy) {
		setAttrVal("Fg_autopsy", Fg_autopsy);
	}
	public String getDes_outtp() {
		return ((String) getAttrVal("Des_outtp"));
	}	
	public void setDes_outtp(String Des_outtp) {
		setAttrVal("Des_outtp", Des_outtp);
	}
	public FBoolean getFg_again31() {
		return ((FBoolean) getAttrVal("Fg_again31"));
	}	
	public void setFg_again31(FBoolean Fg_again31) {
		setAttrVal("Fg_again31", Fg_again31);
	}
	public String getDes_again31() {
		return ((String) getAttrVal("Des_again31"));
	}	
	public void setDes_again31(String Des_again31) {
		setAttrVal("Des_again31", Des_again31);
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
	public String getDef6() {
		return ((String) getAttrVal("Def6"));
	}	
	public void setDef6(String Def6) {
		setAttrVal("Def6", Def6);
	}
	public String getDef7() {
		return ((String) getAttrVal("Def7"));
	}	
	public void setDef7(String Def7) {
		setAttrVal("Def7", Def7);
	}
	public String getDef8() {
		return ((String) getAttrVal("Def8"));
	}	
	public void setDef8(String Def8) {
		setAttrVal("Def8", Def8);
	}
	public String getDef9() {
		return ((String) getAttrVal("Def9"));
	}	
	public void setDef9(String Def9) {
		setAttrVal("Def9", Def9);
	}
	public String getDef10() {
		return ((String) getAttrVal("Def10"));
	}	
	public void setDef10(String Def10) {
		setAttrVal("Def10", Def10);
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
	public String getName_outtp() {
		return ((String) getAttrVal("Name_outtp"));
	}	
	public void setName_outtp(String Name_outtp) {
		setAttrVal("Name_outtp", Name_outtp);
	}
	public String getName_dep_out() {
		return ((String) getAttrVal("Name_dep_out"));
	}	
	public void setName_dep_out(String Name_dep_out) {
		setAttrVal("Name_dep_out", Name_dep_out);
	}
	public String getName_dep_nur_out() {
		return ((String) getAttrVal("Name_dep_nur_out"));
	}	
	public void setName_dep_nur_out(String Name_dep_nur_out) {
		setAttrVal("Name_dep_nur_out", Name_dep_nur_out);
	}
	public String getName_bed_out() {
		return ((String) getAttrVal("Name_bed_out"));
	}	
	public void setName_bed_out(String Name_bed_out) {
		setAttrVal("Name_bed_out", Name_bed_out);
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
		return "Id_orout";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_ap_out";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OrdApOutDODesc.class);
	}
	
}