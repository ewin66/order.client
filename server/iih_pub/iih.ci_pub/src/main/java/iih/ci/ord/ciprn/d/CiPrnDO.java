package iih.ci.ord.ciprn.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.ciprn.d.desc.CiPrnDODesc;
import java.math.BigDecimal;

/**
 * 临床打印单 DO数据 
 * 
 */
public class CiPrnDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_CIPRN= "Id_ciprn";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_DI= "Id_di";
	public static final String ID_DIITM= "Id_diitm";
	public static final String STR_ID_DIITM= "Str_id_diitm";
	public static final String STR_CODE_DI= "Str_code_di";
	public static final String STR_NAME_DI= "Str_name_di";
	public static final String NAME_DIAG= "Name_diag";
	public static final String ID_EN= "Id_en";
	public static final String FG_BB= "Fg_bb";
	public static final String NO_BB= "No_bb";
	public static final String ID_PAT= "Id_pat";
	public static final String ID_ENTP= "Id_entp";
	public static final String CODE_ENTP= "Code_entp";
	public static final String CODE_PRN= "Code_prn";
	public static final String NAME_PRN= "Name_prn";
	public static final String ID_ORG_PRN= "Id_org_prn";
	public static final String ID_DEP_PRN= "Id_dep_prn";
	public static final String ID_EMP_PRN= "Id_emp_prn";
	public static final String DT_PRN= "Dt_prn";
	public static final String ID_DEP_MP= "Id_dep_mp";
	public static final String ID_CIPRNTP= "Id_ciprntp";
	public static final String SD_CIPRNTP= "Sd_ciprntp";
	public static final String FG_PRN= "Fg_prn";
	public static final String CNT_PRN= "Cnt_prn";
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
	public static final String FG_HP= "Fg_hp";
	public static final String FG_PREPAY= "Fg_prepay";
	public static final String FG_HECOMINSUR= "Fg_hecominsur";
	public static final String HECOMINSURINFO= "Hecominsurinfo";
	public static final String FG_VIP= "Fg_vip";
	public static final String FG_BLSETTLED= "Fg_blsettled";
	public static final String NAME_ORDI= "Name_ordi";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_ciprn() {
		return ((String) getAttrVal("Id_ciprn"));
	}	
	public void setId_ciprn(String Id_ciprn) {
		setAttrVal("Id_ciprn", Id_ciprn);
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
	public String getId_di() {
		return ((String) getAttrVal("Id_di"));
	}	
	public void setId_di(String Id_di) {
		setAttrVal("Id_di", Id_di);
	}
	public String getId_diitm() {
		return ((String) getAttrVal("Id_diitm"));
	}	
	public void setId_diitm(String Id_diitm) {
		setAttrVal("Id_diitm", Id_diitm);
	}
	public String getStr_id_diitm() {
		return ((String) getAttrVal("Str_id_diitm"));
	}	
	public void setStr_id_diitm(String Str_id_diitm) {
		setAttrVal("Str_id_diitm", Str_id_diitm);
	}
	public String getStr_code_di() {
		return ((String) getAttrVal("Str_code_di"));
	}	
	public void setStr_code_di(String Str_code_di) {
		setAttrVal("Str_code_di", Str_code_di);
	}
	public String getStr_name_di() {
		return ((String) getAttrVal("Str_name_di"));
	}	
	public void setStr_name_di(String Str_name_di) {
		setAttrVal("Str_name_di", Str_name_di);
	}
	public String getName_diag() {
		return ((String) getAttrVal("Name_diag"));
	}	
	public void setName_diag(String Name_diag) {
		setAttrVal("Name_diag", Name_diag);
	}
	public String getId_en() {
		return ((String) getAttrVal("Id_en"));
	}	
	public void setId_en(String Id_en) {
		setAttrVal("Id_en", Id_en);
	}
	public FBoolean getFg_bb() {
		return ((FBoolean) getAttrVal("Fg_bb"));
	}	
	public void setFg_bb(FBoolean Fg_bb) {
		setAttrVal("Fg_bb", Fg_bb);
	}
	public Integer getNo_bb() {
		return ((Integer) getAttrVal("No_bb"));
	}	
	public void setNo_bb(Integer No_bb) {
		setAttrVal("No_bb", No_bb);
	}
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	public String getId_entp() {
		return ((String) getAttrVal("Id_entp"));
	}	
	public void setId_entp(String Id_entp) {
		setAttrVal("Id_entp", Id_entp);
	}
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}	
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	public String getCode_prn() {
		return ((String) getAttrVal("Code_prn"));
	}	
	public void setCode_prn(String Code_prn) {
		setAttrVal("Code_prn", Code_prn);
	}
	public String getName_prn() {
		return ((String) getAttrVal("Name_prn"));
	}	
	public void setName_prn(String Name_prn) {
		setAttrVal("Name_prn", Name_prn);
	}
	public String getId_org_prn() {
		return ((String) getAttrVal("Id_org_prn"));
	}	
	public void setId_org_prn(String Id_org_prn) {
		setAttrVal("Id_org_prn", Id_org_prn);
	}
	public String getId_dep_prn() {
		return ((String) getAttrVal("Id_dep_prn"));
	}	
	public void setId_dep_prn(String Id_dep_prn) {
		setAttrVal("Id_dep_prn", Id_dep_prn);
	}
	public String getId_emp_prn() {
		return ((String) getAttrVal("Id_emp_prn"));
	}	
	public void setId_emp_prn(String Id_emp_prn) {
		setAttrVal("Id_emp_prn", Id_emp_prn);
	}
	public FDateTime getDt_prn() {
		return ((FDateTime) getAttrVal("Dt_prn"));
	}	
	public void setDt_prn(FDateTime Dt_prn) {
		setAttrVal("Dt_prn", Dt_prn);
	}
	public String getId_dep_mp() {
		return ((String) getAttrVal("Id_dep_mp"));
	}	
	public void setId_dep_mp(String Id_dep_mp) {
		setAttrVal("Id_dep_mp", Id_dep_mp);
	}
	public String getId_ciprntp() {
		return ((String) getAttrVal("Id_ciprntp"));
	}	
	public void setId_ciprntp(String Id_ciprntp) {
		setAttrVal("Id_ciprntp", Id_ciprntp);
	}
	public String getSd_ciprntp() {
		return ((String) getAttrVal("Sd_ciprntp"));
	}	
	public void setSd_ciprntp(String Sd_ciprntp) {
		setAttrVal("Sd_ciprntp", Sd_ciprntp);
	}
	public FBoolean getFg_prn() {
		return ((FBoolean) getAttrVal("Fg_prn"));
	}	
	public void setFg_prn(FBoolean Fg_prn) {
		setAttrVal("Fg_prn", Fg_prn);
	}
	public Integer getCnt_prn() {
		return ((Integer) getAttrVal("Cnt_prn"));
	}	
	public void setCnt_prn(Integer Cnt_prn) {
		setAttrVal("Cnt_prn", Cnt_prn);
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
	public FBoolean getFg_hp() {
		return ((FBoolean) getAttrVal("Fg_hp"));
	}	
	public void setFg_hp(FBoolean Fg_hp) {
		setAttrVal("Fg_hp", Fg_hp);
	}
	public FBoolean getFg_prepay() {
		return ((FBoolean) getAttrVal("Fg_prepay"));
	}	
	public void setFg_prepay(FBoolean Fg_prepay) {
		setAttrVal("Fg_prepay", Fg_prepay);
	}
	public FBoolean getFg_hecominsur() {
		return ((FBoolean) getAttrVal("Fg_hecominsur"));
	}	
	public void setFg_hecominsur(FBoolean Fg_hecominsur) {
		setAttrVal("Fg_hecominsur", Fg_hecominsur);
	}
	public String getHecominsurinfo() {
		return ((String) getAttrVal("Hecominsurinfo"));
	}	
	public void setHecominsurinfo(String Hecominsurinfo) {
		setAttrVal("Hecominsurinfo", Hecominsurinfo);
	}
	public FBoolean getFg_vip() {
		return ((FBoolean) getAttrVal("Fg_vip"));
	}	
	public void setFg_vip(FBoolean Fg_vip) {
		setAttrVal("Fg_vip", Fg_vip);
	}
	public FBoolean getFg_blsettled() {
		return ((FBoolean) getAttrVal("Fg_blsettled"));
	}	
	public void setFg_blsettled(FBoolean Fg_blsettled) {
		setAttrVal("Fg_blsettled", Fg_blsettled);
	}
	public String getName_ordi() {
		return ((String) getAttrVal("Name_ordi"));
	}	
	public void setName_ordi(String Name_ordi) {
		setAttrVal("Name_ordi", Name_ordi);
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
		return "Id_ciprn";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_prn";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiPrnDODesc.class);
	}
	
}