package iih.ci.ord.pres.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.pres.d.desc.CiPresDODesc;
import java.math.BigDecimal;

/**
 * 药品处方 DO数据 
 * 
 */
public class CiPresDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PRES= "Id_pres";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_PATI= "Id_pati";
	public static final String ID_ENTP= "Id_entp";
	public static final String CODE_ENTP= "Code_entp";
	public static final String ID_EN= "Id_en";
	public static final String ID_DI= "Id_di";
	public static final String ID_DIITM= "Id_diitm";
	public static final String STR_ID_DI= "Str_id_di";
	public static final String STR_NAME_DI= "Str_name_di";
	public static final String ID_SRVTP= "Id_srvtp";
	public static final String SD_SRVTP= "Sd_srvtp";
	public static final String ID_PRESTP= "Id_prestp";
	public static final String SD_PRESTP= "Sd_prestp";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String ID_DEP_OR= "Id_dep_or";
	public static final String ID_EMP_OR= "Id_emp_or";
	public static final String DT_ENTRY= "Dt_entry";
	public static final String FG_BB= "Fg_bb";
	public static final String NO_BB= "No_bb";
	public static final String ID_BB= "Id_bb";
	public static final String ID_ROUTE= "Id_route";
	public static final String ID_ROUTEDES= "Id_routedes";
	public static final String ID_BOIL= "Id_boil";
	public static final String ID_BOILDES= "Id_boildes";
	public static final String FG_CHARGE= "Fg_charge";
	public static final String FG_DISPENSE= "Fg_dispense";
	public static final String ID_BACKTP= "Id_backtp";
	public static final String SD_BACKTP= "Sd_backtp";
	public static final String FG_BACK= "Fg_back";
	public static final String ID_EMP= "Id_emp";
	public static final String FG_PRN= "Fg_prn";
	public static final String CNT_PRN= "Cnt_prn";
	public static final String FG_PRN_ADD= "Fg_prn_add";
	public static final String ID_PRES_REL_ADD= "Id_pres_rel_add";
	public static final String ID_SU_BL= "Id_su_bl";
	public static final String SD_SU_BL= "Sd_su_bl";
	public static final String FG_MAKEUP= "Fg_makeup";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String FG_HP_PRES= "Fg_hp_pres";
	public static final String ID_SESSION= "Id_session";
	public static final String ID_DEP_MP= "Id_dep_mp";
	public static final String ID_ORG_CREATE= "Id_org_create";
	public static final String FG_BASE= "Fg_base";
	public static final String ID_PRESTPWORD= "Id_prestpword";
	public static final String SD_PRESTPWORD= "Sd_prestpword";
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
	public static final String NO_DRUGWIN= "No_drugwin";
	public static final String FG_PREPAY= "Fg_prepay";
	public static final String FG_BLSETTLED= "Fg_blsettled";
	public static final String CODE_POIS= "Code_pois";
	public static final String FG_HECOMINSUR= "Fg_hecominsur";
	public static final String HECOMINSURINFO= "Hecominsurinfo";
	public static final String FG_VIP= "Fg_vip";
	public static final String PRESTP_NAME= "Prestp_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_pres() {
		return ((String) getAttrVal("Id_pres"));
	}	
	public void setId_pres(String Id_pres) {
		setAttrVal("Id_pres", Id_pres);
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
	public String getId_pati() {
		return ((String) getAttrVal("Id_pati"));
	}	
	public void setId_pati(String Id_pati) {
		setAttrVal("Id_pati", Id_pati);
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
	public String getId_en() {
		return ((String) getAttrVal("Id_en"));
	}	
	public void setId_en(String Id_en) {
		setAttrVal("Id_en", Id_en);
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
	public String getStr_id_di() {
		return ((String) getAttrVal("Str_id_di"));
	}	
	public void setStr_id_di(String Str_id_di) {
		setAttrVal("Str_id_di", Str_id_di);
	}
	public String getStr_name_di() {
		return ((String) getAttrVal("Str_name_di"));
	}	
	public void setStr_name_di(String Str_name_di) {
		setAttrVal("Str_name_di", Str_name_di);
	}
	public String getId_srvtp() {
		return ((String) getAttrVal("Id_srvtp"));
	}	
	public void setId_srvtp(String Id_srvtp) {
		setAttrVal("Id_srvtp", Id_srvtp);
	}
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}	
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	public String getId_prestp() {
		return ((String) getAttrVal("Id_prestp"));
	}	
	public void setId_prestp(String Id_prestp) {
		setAttrVal("Id_prestp", Id_prestp);
	}
	public String getSd_prestp() {
		return ((String) getAttrVal("Sd_prestp"));
	}	
	public void setSd_prestp(String Sd_prestp) {
		setAttrVal("Sd_prestp", Sd_prestp);
	}
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public String getId_dep_or() {
		return ((String) getAttrVal("Id_dep_or"));
	}	
	public void setId_dep_or(String Id_dep_or) {
		setAttrVal("Id_dep_or", Id_dep_or);
	}
	public String getId_emp_or() {
		return ((String) getAttrVal("Id_emp_or"));
	}	
	public void setId_emp_or(String Id_emp_or) {
		setAttrVal("Id_emp_or", Id_emp_or);
	}
	public FDateTime getDt_entry() {
		return ((FDateTime) getAttrVal("Dt_entry"));
	}	
	public void setDt_entry(FDateTime Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
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
	public String getId_bb() {
		return ((String) getAttrVal("Id_bb"));
	}	
	public void setId_bb(String Id_bb) {
		setAttrVal("Id_bb", Id_bb);
	}
	public String getId_route() {
		return ((String) getAttrVal("Id_route"));
	}	
	public void setId_route(String Id_route) {
		setAttrVal("Id_route", Id_route);
	}
	public String getId_routedes() {
		return ((String) getAttrVal("Id_routedes"));
	}	
	public void setId_routedes(String Id_routedes) {
		setAttrVal("Id_routedes", Id_routedes);
	}
	public String getId_boil() {
		return ((String) getAttrVal("Id_boil"));
	}	
	public void setId_boil(String Id_boil) {
		setAttrVal("Id_boil", Id_boil);
	}
	public String getId_boildes() {
		return ((String) getAttrVal("Id_boildes"));
	}	
	public void setId_boildes(String Id_boildes) {
		setAttrVal("Id_boildes", Id_boildes);
	}
	public FBoolean getFg_charge() {
		return ((FBoolean) getAttrVal("Fg_charge"));
	}	
	public void setFg_charge(FBoolean Fg_charge) {
		setAttrVal("Fg_charge", Fg_charge);
	}
	public FBoolean getFg_dispense() {
		return ((FBoolean) getAttrVal("Fg_dispense"));
	}	
	public void setFg_dispense(FBoolean Fg_dispense) {
		setAttrVal("Fg_dispense", Fg_dispense);
	}
	public String getId_backtp() {
		return ((String) getAttrVal("Id_backtp"));
	}	
	public void setId_backtp(String Id_backtp) {
		setAttrVal("Id_backtp", Id_backtp);
	}
	public String getSd_backtp() {
		return ((String) getAttrVal("Sd_backtp"));
	}	
	public void setSd_backtp(String Sd_backtp) {
		setAttrVal("Sd_backtp", Sd_backtp);
	}
	public FBoolean getFg_back() {
		return ((FBoolean) getAttrVal("Fg_back"));
	}	
	public void setFg_back(FBoolean Fg_back) {
		setAttrVal("Fg_back", Fg_back);
	}
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}	
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
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
	public FBoolean getFg_prn_add() {
		return ((FBoolean) getAttrVal("Fg_prn_add"));
	}	
	public void setFg_prn_add(FBoolean Fg_prn_add) {
		setAttrVal("Fg_prn_add", Fg_prn_add);
	}
	public String getId_pres_rel_add() {
		return ((String) getAttrVal("Id_pres_rel_add"));
	}	
	public void setId_pres_rel_add(String Id_pres_rel_add) {
		setAttrVal("Id_pres_rel_add", Id_pres_rel_add);
	}
	public String getId_su_bl() {
		return ((String) getAttrVal("Id_su_bl"));
	}	
	public void setId_su_bl(String Id_su_bl) {
		setAttrVal("Id_su_bl", Id_su_bl);
	}
	public String getSd_su_bl() {
		return ((String) getAttrVal("Sd_su_bl"));
	}	
	public void setSd_su_bl(String Sd_su_bl) {
		setAttrVal("Sd_su_bl", Sd_su_bl);
	}
	public FBoolean getFg_makeup() {
		return ((FBoolean) getAttrVal("Fg_makeup"));
	}	
	public void setFg_makeup(FBoolean Fg_makeup) {
		setAttrVal("Fg_makeup", Fg_makeup);
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
	public FBoolean getFg_hp_pres() {
		return ((FBoolean) getAttrVal("Fg_hp_pres"));
	}	
	public void setFg_hp_pres(FBoolean Fg_hp_pres) {
		setAttrVal("Fg_hp_pres", Fg_hp_pres);
	}
	public String getId_session() {
		return ((String) getAttrVal("Id_session"));
	}	
	public void setId_session(String Id_session) {
		setAttrVal("Id_session", Id_session);
	}
	public String getId_dep_mp() {
		return ((String) getAttrVal("Id_dep_mp"));
	}	
	public void setId_dep_mp(String Id_dep_mp) {
		setAttrVal("Id_dep_mp", Id_dep_mp);
	}
	public String getId_org_create() {
		return ((String) getAttrVal("Id_org_create"));
	}	
	public void setId_org_create(String Id_org_create) {
		setAttrVal("Id_org_create", Id_org_create);
	}
	public FBoolean getFg_base() {
		return ((FBoolean) getAttrVal("Fg_base"));
	}	
	public void setFg_base(FBoolean Fg_base) {
		setAttrVal("Fg_base", Fg_base);
	}
	public String getId_prestpword() {
		return ((String) getAttrVal("Id_prestpword"));
	}	
	public void setId_prestpword(String Id_prestpword) {
		setAttrVal("Id_prestpword", Id_prestpword);
	}
	public String getSd_prestpword() {
		return ((String) getAttrVal("Sd_prestpword"));
	}	
	public void setSd_prestpword(String Sd_prestpword) {
		setAttrVal("Sd_prestpword", Sd_prestpword);
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
	public String getNo_drugwin() {
		return ((String) getAttrVal("No_drugwin"));
	}	
	public void setNo_drugwin(String No_drugwin) {
		setAttrVal("No_drugwin", No_drugwin);
	}
	public FBoolean getFg_prepay() {
		return ((FBoolean) getAttrVal("Fg_prepay"));
	}	
	public void setFg_prepay(FBoolean Fg_prepay) {
		setAttrVal("Fg_prepay", Fg_prepay);
	}
	public FBoolean getFg_blsettled() {
		return ((FBoolean) getAttrVal("Fg_blsettled"));
	}	
	public void setFg_blsettled(FBoolean Fg_blsettled) {
		setAttrVal("Fg_blsettled", Fg_blsettled);
	}
	public String getCode_pois() {
		return ((String) getAttrVal("Code_pois"));
	}	
	public void setCode_pois(String Code_pois) {
		setAttrVal("Code_pois", Code_pois);
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
	public String getPrestp_name() {
		return ((String) getAttrVal("Prestp_name"));
	}	
	public void setPrestp_name(String Prestp_name) {
		setAttrVal("Prestp_name", Prestp_name);
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
		return "Id_pres";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_pres";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiPresDODesc.class);
	}
	
}