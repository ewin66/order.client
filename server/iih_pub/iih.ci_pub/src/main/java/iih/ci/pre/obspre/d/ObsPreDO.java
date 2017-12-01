package iih.ci.pre.obspre.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.pre.obspre.d.desc.ObsPreDODesc;
import java.math.BigDecimal;

/**
 * 预检 DO数据 
 * 
 */
public class ObsPreDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_OBSPRE= "Id_obspre";
	public static final String ID_PAT= "Id_pat";
	public static final String NAME= "Name";
	public static final String ID_ENT= "Id_ent";
	public static final String CODE_ENTP= "Code_entp";
	public static final String ID_DI= "Id_di";
	public static final String ID_DIITM= "Id_diitm";
	public static final String STR_ID_DI= "Str_id_di";
	public static final String STR_NAME_DI= "Str_name_di";
	public static final String ID_SEX= "Id_sex";
	public static final String SD_SEX= "Sd_sex";
	public static final String DT_BIRTH= "Dt_birth";
	public static final String ID_IDTP= "Id_idtp";
	public static final String SD_IDTP= "Sd_idtp";
	public static final String NO_IDTP= "No_idtp";
	public static final String TEL= "Tel";
	public static final String MOB= "Mob";
	public static final String ID_ADMDIV= "Id_admdiv";
	public static final String SD_ADMDIV= "Sd_admdiv";
	public static final String NAME_STREET= "Name_street";
	public static final String NO_ZIPCD= "No_zipcd";
	public static final String ID_COME_WAY= "Id_come_way";
	public static final String SD_COME_WAY= "Sd_come_way";
	public static final String DT_ENTRY= "Dt_entry";
	public static final String DT_RESCUE_B= "Dt_rescue_b";
	public static final String DT_RESCUE_E= "Dt_rescue_e";
	public static final String NO_PREOBS= "No_preobs";
	public static final String SD_PREOBSLVL= "Sd_preobslvl";
	public static final String DESC_PREOBSLVL= "Desc_preobslvl";
	public static final String ID_DEP= "Id_dep";
	public static final String DES_HIS= "Des_his";
	public static final String ID_EMP= "Id_emp";
	public static final String DT_SIGN= "Dt_sign";
	public static final String IDS_COMPANION= "Ids_companion";
	public static final String SDS_COMPANION= "Sds_companion";
	public static final String FG_CHK_EQIDEMIC= "Fg_chk_eqidemic";
	public static final String FG_HAS_HOT= "Fg_has_hot";
	public static final String FG_HAS_HOT2= "Fg_has_hot2";
	public static final String FG_HAS_EQIDAREA= "Fg_has_eqidarea";
	public static final String FG_HAS_TOUCHANIM= "Fg_has_touchanim";
	public static final String CHK_NOTE= "Chk_note";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_obspre() {
		return ((String) getAttrVal("Id_obspre"));
	}	
	public void setId_obspre(String Id_obspre) {
		setAttrVal("Id_obspre", Id_obspre);
	}
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}	
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
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
	public String getId_sex() {
		return ((String) getAttrVal("Id_sex"));
	}	
	public void setId_sex(String Id_sex) {
		setAttrVal("Id_sex", Id_sex);
	}
	public String getSd_sex() {
		return ((String) getAttrVal("Sd_sex"));
	}	
	public void setSd_sex(String Sd_sex) {
		setAttrVal("Sd_sex", Sd_sex);
	}
	public FDate getDt_birth() {
		return ((FDate) getAttrVal("Dt_birth"));
	}	
	public void setDt_birth(FDate Dt_birth) {
		setAttrVal("Dt_birth", Dt_birth);
	}
	public String getId_idtp() {
		return ((String) getAttrVal("Id_idtp"));
	}	
	public void setId_idtp(String Id_idtp) {
		setAttrVal("Id_idtp", Id_idtp);
	}
	public String getSd_idtp() {
		return ((String) getAttrVal("Sd_idtp"));
	}	
	public void setSd_idtp(String Sd_idtp) {
		setAttrVal("Sd_idtp", Sd_idtp);
	}
	public String getNo_idtp() {
		return ((String) getAttrVal("No_idtp"));
	}	
	public void setNo_idtp(String No_idtp) {
		setAttrVal("No_idtp", No_idtp);
	}
	public String getTel() {
		return ((String) getAttrVal("Tel"));
	}	
	public void setTel(String Tel) {
		setAttrVal("Tel", Tel);
	}
	public String getMob() {
		return ((String) getAttrVal("Mob"));
	}	
	public void setMob(String Mob) {
		setAttrVal("Mob", Mob);
	}
	public String getId_admdiv() {
		return ((String) getAttrVal("Id_admdiv"));
	}	
	public void setId_admdiv(String Id_admdiv) {
		setAttrVal("Id_admdiv", Id_admdiv);
	}
	public String getSd_admdiv() {
		return ((String) getAttrVal("Sd_admdiv"));
	}	
	public void setSd_admdiv(String Sd_admdiv) {
		setAttrVal("Sd_admdiv", Sd_admdiv);
	}
	public String getName_street() {
		return ((String) getAttrVal("Name_street"));
	}	
	public void setName_street(String Name_street) {
		setAttrVal("Name_street", Name_street);
	}
	public String getNo_zipcd() {
		return ((String) getAttrVal("No_zipcd"));
	}	
	public void setNo_zipcd(String No_zipcd) {
		setAttrVal("No_zipcd", No_zipcd);
	}
	public String getId_come_way() {
		return ((String) getAttrVal("Id_come_way"));
	}	
	public void setId_come_way(String Id_come_way) {
		setAttrVal("Id_come_way", Id_come_way);
	}
	public String getSd_come_way() {
		return ((String) getAttrVal("Sd_come_way"));
	}	
	public void setSd_come_way(String Sd_come_way) {
		setAttrVal("Sd_come_way", Sd_come_way);
	}
	public FDateTime getDt_entry() {
		return ((FDateTime) getAttrVal("Dt_entry"));
	}	
	public void setDt_entry(FDateTime Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	public FDateTime getDt_rescue_b() {
		return ((FDateTime) getAttrVal("Dt_rescue_b"));
	}	
	public void setDt_rescue_b(FDateTime Dt_rescue_b) {
		setAttrVal("Dt_rescue_b", Dt_rescue_b);
	}
	public FDateTime getDt_rescue_e() {
		return ((FDateTime) getAttrVal("Dt_rescue_e"));
	}	
	public void setDt_rescue_e(FDateTime Dt_rescue_e) {
		setAttrVal("Dt_rescue_e", Dt_rescue_e);
	}
	public String getNo_preobs() {
		return ((String) getAttrVal("No_preobs"));
	}	
	public void setNo_preobs(String No_preobs) {
		setAttrVal("No_preobs", No_preobs);
	}
	public String getSd_preobslvl() {
		return ((String) getAttrVal("Sd_preobslvl"));
	}	
	public void setSd_preobslvl(String Sd_preobslvl) {
		setAttrVal("Sd_preobslvl", Sd_preobslvl);
	}
	public String getDesc_preobslvl() {
		return ((String) getAttrVal("Desc_preobslvl"));
	}	
	public void setDesc_preobslvl(String Desc_preobslvl) {
		setAttrVal("Desc_preobslvl", Desc_preobslvl);
	}
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	public String getDes_his() {
		return ((String) getAttrVal("Des_his"));
	}	
	public void setDes_his(String Des_his) {
		setAttrVal("Des_his", Des_his);
	}
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}	
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	public FDateTime getDt_sign() {
		return ((FDateTime) getAttrVal("Dt_sign"));
	}	
	public void setDt_sign(FDateTime Dt_sign) {
		setAttrVal("Dt_sign", Dt_sign);
	}
	public String getIds_companion() {
		return ((String) getAttrVal("Ids_companion"));
	}	
	public void setIds_companion(String Ids_companion) {
		setAttrVal("Ids_companion", Ids_companion);
	}
	public String getSds_companion() {
		return ((String) getAttrVal("Sds_companion"));
	}	
	public void setSds_companion(String Sds_companion) {
		setAttrVal("Sds_companion", Sds_companion);
	}
	public FBoolean getFg_chk_eqidemic() {
		return ((FBoolean) getAttrVal("Fg_chk_eqidemic"));
	}	
	public void setFg_chk_eqidemic(FBoolean Fg_chk_eqidemic) {
		setAttrVal("Fg_chk_eqidemic", Fg_chk_eqidemic);
	}
	public FBoolean getFg_has_hot() {
		return ((FBoolean) getAttrVal("Fg_has_hot"));
	}	
	public void setFg_has_hot(FBoolean Fg_has_hot) {
		setAttrVal("Fg_has_hot", Fg_has_hot);
	}
	public FBoolean getFg_has_hot2() {
		return ((FBoolean) getAttrVal("Fg_has_hot2"));
	}	
	public void setFg_has_hot2(FBoolean Fg_has_hot2) {
		setAttrVal("Fg_has_hot2", Fg_has_hot2);
	}
	public FBoolean getFg_has_eqidarea() {
		return ((FBoolean) getAttrVal("Fg_has_eqidarea"));
	}	
	public void setFg_has_eqidarea(FBoolean Fg_has_eqidarea) {
		setAttrVal("Fg_has_eqidarea", Fg_has_eqidarea);
	}
	public FBoolean getFg_has_touchanim() {
		return ((FBoolean) getAttrVal("Fg_has_touchanim"));
	}	
	public void setFg_has_touchanim(FBoolean Fg_has_touchanim) {
		setAttrVal("Fg_has_touchanim", Fg_has_touchanim);
	}
	public String getChk_note() {
		return ((String) getAttrVal("Chk_note"));
	}	
	public void setChk_note(String Chk_note) {
		setAttrVal("Chk_note", Chk_note);
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
		return "Id_obspre";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_obs_pre";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ObsPreDODesc.class);
	}
	
}