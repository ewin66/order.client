package iih.ci.mr.nu.chidrenass.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.chidrenass.d.desc.ChildrenInAsseNurRecordDODesc;
import java.math.BigDecimal;

/**
 * 高危儿护理观察记录 DO数据 
 * 
 */
public class ChildrenInAsseNurRecordDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_CHASS_REC= "Id_chass_rec";
	public static final String ID_CHASS= "Id_chass";
	public static final String D_REC= "D_rec";
	public static final String T_REC= "T_rec";
	public static final String TEM= "Tem";
	public static final String PULSE= "Pulse";
	public static final String BREATH= "Breath";
	public static final String SYS_PRESSURE= "Sys_pressure";
	public static final String DIA_PRESSURE= "Dia_pressure";
	public static final String SPO2= "Spo2";
	public static final String ID_OXY_TYPE= "Id_oxy_type";
	public static final String SD_OXY_TYPE= "Sd_oxy_type";
	public static final String OXY= "Oxy";
	public static final String ID_SKINCOLOR= "Id_skincolor";
	public static final String SD_SKINCOLOR= "Sd_skincolor";
	public static final String ID_AUTOACTIVITY= "Id_autoactivity";
	public static final String SD_AUTOACTIVITY= "Sd_autoactivity";
	public static final String ID_MUSCLE_TENSION= "Id_muscle_tension";
	public static final String SD_MUSCLE_TENSION= "Sd_muscle_tension";
	public static final String ID_CRY_VOICE= "Id_cry_voice";
	public static final String SD_CRY_VOICE= "Sd_cry_voice";
	public static final String ID_ABD_DIS= "Id_abd_dis";
	public static final String SD_ABD_DIS= "Sd_abd_dis";
	public static final String ID_UMBILICAL= "Id_umbilical";
	public static final String SD_UMBILICAL= "Sd_umbilical";
	public static final String NAME_MEDICINE= "Name_medicine";
	public static final String METERING= "Metering";
	public static final String ID_ROUTE= "Id_route";
	public static final String SD_ROUTE= "Sd_route";
	public static final String SPEED_DRUG= "Speed_drug";
	public static final String ID_UNIT_SPEED= "Id_unit_speed";
	public static final String SD_UNIT_SPEED= "Sd_unit_speed";
	public static final String ID_DIET= "Id_diet";
	public static final String SD_DIET= "Sd_diet";
	public static final String ID_BRINGINTO_WAY= "Id_bringinto_way";
	public static final String SD_BRINGINTO_WAY= "Sd_bringinto_way";
	public static final String DRINK= "Drink";
	public static final String ID_SUCKPOWER= "Id_suckpower";
	public static final String SD_SUCKPOWER= "Sd_suckpower";
	public static final String ID_SWALLOW_ACTIVE= "Id_swallow_active";
	public static final String SD_SWALLOW_ACTIVE= "Sd_swallow_active";
	public static final String VOMIT= "Vomit";
	public static final String DRAINAGE= "Drainage";
	public static final String SHIT= "Shit";
	public static final String A_SHIT= "A_shit";
	public static final String URINE= "Urine";
	public static final String A_URINE= "A_urine";
	public static final String ID_SKIN= "Id_skin";
	public static final String SD_SKIN= "Sd_skin";
	public static final String BOXTEM= "Boxtem";
	public static final String HUM= "Hum";
	public static final String MANAGEMENT= "Management";
	public static final String ID_SIGN= "Id_sign";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_OXY_TYPE= "Name_oxy_type";
	public static final String NAME_SKINCOLOR= "Name_skincolor";
	public static final String NAME_AUTOACTIVITY= "Name_autoactivity";
	public static final String NAME_MUSCLE_TENSION= "Name_muscle_tension";
	public static final String NAME_CRY_VOICE= "Name_cry_voice";
	public static final String NAME_ABD_DIS= "Name_abd_dis";
	public static final String NAME_UMBILICAL= "Name_umbilical";
	public static final String NAME_ROUTE= "Name_route";
	public static final String NAME_UNIT_SPEED= "Name_unit_speed";
	public static final String NAME_DIET= "Name_diet";
	public static final String NAME_BRINGINTO_WAY= "Name_bringinto_way";
	public static final String NAME_SUCKPOWER= "Name_suckpower";
	public static final String NAME_SWALLOW_ACTIVE= "Name_swallow_active";
	public static final String NAME_SKIN= "Name_skin";
	public static final String NAME_SIGN= "Name_sign";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_chass_rec() {
		return ((String) getAttrVal("Id_chass_rec"));
	}	
	public void setId_chass_rec(String Id_chass_rec) {
		setAttrVal("Id_chass_rec", Id_chass_rec);
	}
	public String getId_chass() {
		return ((String) getAttrVal("Id_chass"));
	}	
	public void setId_chass(String Id_chass) {
		setAttrVal("Id_chass", Id_chass);
	}
	public FDate getD_rec() {
		return ((FDate) getAttrVal("D_rec"));
	}	
	public void setD_rec(FDate D_rec) {
		setAttrVal("D_rec", D_rec);
	}
	public FTime getT_rec() {
		return ((FTime) getAttrVal("T_rec"));
	}	
	public void setT_rec(FTime T_rec) {
		setAttrVal("T_rec", T_rec);
	}
	public FDouble getTem() {
		return ((FDouble) getAttrVal("Tem"));
	}	
	public void setTem(FDouble Tem) {
		setAttrVal("Tem", Tem);
	}
	public Integer getPulse() {
		return ((Integer) getAttrVal("Pulse"));
	}	
	public void setPulse(Integer Pulse) {
		setAttrVal("Pulse", Pulse);
	}
	public Integer getBreath() {
		return ((Integer) getAttrVal("Breath"));
	}	
	public void setBreath(Integer Breath) {
		setAttrVal("Breath", Breath);
	}
	public Integer getSys_pressure() {
		return ((Integer) getAttrVal("Sys_pressure"));
	}	
	public void setSys_pressure(Integer Sys_pressure) {
		setAttrVal("Sys_pressure", Sys_pressure);
	}
	public Integer getDia_pressure() {
		return ((Integer) getAttrVal("Dia_pressure"));
	}	
	public void setDia_pressure(Integer Dia_pressure) {
		setAttrVal("Dia_pressure", Dia_pressure);
	}
	public Integer getSpo2() {
		return ((Integer) getAttrVal("Spo2"));
	}	
	public void setSpo2(Integer Spo2) {
		setAttrVal("Spo2", Spo2);
	}
	public String getId_oxy_type() {
		return ((String) getAttrVal("Id_oxy_type"));
	}	
	public void setId_oxy_type(String Id_oxy_type) {
		setAttrVal("Id_oxy_type", Id_oxy_type);
	}
	public String getSd_oxy_type() {
		return ((String) getAttrVal("Sd_oxy_type"));
	}	
	public void setSd_oxy_type(String Sd_oxy_type) {
		setAttrVal("Sd_oxy_type", Sd_oxy_type);
	}
	public Integer getOxy() {
		return ((Integer) getAttrVal("Oxy"));
	}	
	public void setOxy(Integer Oxy) {
		setAttrVal("Oxy", Oxy);
	}
	public String getId_skincolor() {
		return ((String) getAttrVal("Id_skincolor"));
	}	
	public void setId_skincolor(String Id_skincolor) {
		setAttrVal("Id_skincolor", Id_skincolor);
	}
	public String getSd_skincolor() {
		return ((String) getAttrVal("Sd_skincolor"));
	}	
	public void setSd_skincolor(String Sd_skincolor) {
		setAttrVal("Sd_skincolor", Sd_skincolor);
	}
	public String getId_autoactivity() {
		return ((String) getAttrVal("Id_autoactivity"));
	}	
	public void setId_autoactivity(String Id_autoactivity) {
		setAttrVal("Id_autoactivity", Id_autoactivity);
	}
	public String getSd_autoactivity() {
		return ((String) getAttrVal("Sd_autoactivity"));
	}	
	public void setSd_autoactivity(String Sd_autoactivity) {
		setAttrVal("Sd_autoactivity", Sd_autoactivity);
	}
	public String getId_muscle_tension() {
		return ((String) getAttrVal("Id_muscle_tension"));
	}	
	public void setId_muscle_tension(String Id_muscle_tension) {
		setAttrVal("Id_muscle_tension", Id_muscle_tension);
	}
	public String getSd_muscle_tension() {
		return ((String) getAttrVal("Sd_muscle_tension"));
	}	
	public void setSd_muscle_tension(String Sd_muscle_tension) {
		setAttrVal("Sd_muscle_tension", Sd_muscle_tension);
	}
	public String getId_cry_voice() {
		return ((String) getAttrVal("Id_cry_voice"));
	}	
	public void setId_cry_voice(String Id_cry_voice) {
		setAttrVal("Id_cry_voice", Id_cry_voice);
	}
	public String getSd_cry_voice() {
		return ((String) getAttrVal("Sd_cry_voice"));
	}	
	public void setSd_cry_voice(String Sd_cry_voice) {
		setAttrVal("Sd_cry_voice", Sd_cry_voice);
	}
	public String getId_abd_dis() {
		return ((String) getAttrVal("Id_abd_dis"));
	}	
	public void setId_abd_dis(String Id_abd_dis) {
		setAttrVal("Id_abd_dis", Id_abd_dis);
	}
	public String getSd_abd_dis() {
		return ((String) getAttrVal("Sd_abd_dis"));
	}	
	public void setSd_abd_dis(String Sd_abd_dis) {
		setAttrVal("Sd_abd_dis", Sd_abd_dis);
	}
	public String getId_umbilical() {
		return ((String) getAttrVal("Id_umbilical"));
	}	
	public void setId_umbilical(String Id_umbilical) {
		setAttrVal("Id_umbilical", Id_umbilical);
	}
	public String getSd_umbilical() {
		return ((String) getAttrVal("Sd_umbilical"));
	}	
	public void setSd_umbilical(String Sd_umbilical) {
		setAttrVal("Sd_umbilical", Sd_umbilical);
	}
	public String getName_medicine() {
		return ((String) getAttrVal("Name_medicine"));
	}	
	public void setName_medicine(String Name_medicine) {
		setAttrVal("Name_medicine", Name_medicine);
	}
	public Integer getMetering() {
		return ((Integer) getAttrVal("Metering"));
	}	
	public void setMetering(Integer Metering) {
		setAttrVal("Metering", Metering);
	}
	public String getId_route() {
		return ((String) getAttrVal("Id_route"));
	}	
	public void setId_route(String Id_route) {
		setAttrVal("Id_route", Id_route);
	}
	public String getSd_route() {
		return ((String) getAttrVal("Sd_route"));
	}	
	public void setSd_route(String Sd_route) {
		setAttrVal("Sd_route", Sd_route);
	}
	public Integer getSpeed_drug() {
		return ((Integer) getAttrVal("Speed_drug"));
	}	
	public void setSpeed_drug(Integer Speed_drug) {
		setAttrVal("Speed_drug", Speed_drug);
	}
	public String getId_unit_speed() {
		return ((String) getAttrVal("Id_unit_speed"));
	}	
	public void setId_unit_speed(String Id_unit_speed) {
		setAttrVal("Id_unit_speed", Id_unit_speed);
	}
	public String getSd_unit_speed() {
		return ((String) getAttrVal("Sd_unit_speed"));
	}	
	public void setSd_unit_speed(String Sd_unit_speed) {
		setAttrVal("Sd_unit_speed", Sd_unit_speed);
	}
	public String getId_diet() {
		return ((String) getAttrVal("Id_diet"));
	}	
	public void setId_diet(String Id_diet) {
		setAttrVal("Id_diet", Id_diet);
	}
	public String getSd_diet() {
		return ((String) getAttrVal("Sd_diet"));
	}	
	public void setSd_diet(String Sd_diet) {
		setAttrVal("Sd_diet", Sd_diet);
	}
	public String getId_bringinto_way() {
		return ((String) getAttrVal("Id_bringinto_way"));
	}	
	public void setId_bringinto_way(String Id_bringinto_way) {
		setAttrVal("Id_bringinto_way", Id_bringinto_way);
	}
	public String getSd_bringinto_way() {
		return ((String) getAttrVal("Sd_bringinto_way"));
	}	
	public void setSd_bringinto_way(String Sd_bringinto_way) {
		setAttrVal("Sd_bringinto_way", Sd_bringinto_way);
	}
	public Integer getDrink() {
		return ((Integer) getAttrVal("Drink"));
	}	
	public void setDrink(Integer Drink) {
		setAttrVal("Drink", Drink);
	}
	public String getId_suckpower() {
		return ((String) getAttrVal("Id_suckpower"));
	}	
	public void setId_suckpower(String Id_suckpower) {
		setAttrVal("Id_suckpower", Id_suckpower);
	}
	public String getSd_suckpower() {
		return ((String) getAttrVal("Sd_suckpower"));
	}	
	public void setSd_suckpower(String Sd_suckpower) {
		setAttrVal("Sd_suckpower", Sd_suckpower);
	}
	public String getId_swallow_active() {
		return ((String) getAttrVal("Id_swallow_active"));
	}	
	public void setId_swallow_active(String Id_swallow_active) {
		setAttrVal("Id_swallow_active", Id_swallow_active);
	}
	public String getSd_swallow_active() {
		return ((String) getAttrVal("Sd_swallow_active"));
	}	
	public void setSd_swallow_active(String Sd_swallow_active) {
		setAttrVal("Sd_swallow_active", Sd_swallow_active);
	}
	public Integer getVomit() {
		return ((Integer) getAttrVal("Vomit"));
	}	
	public void setVomit(Integer Vomit) {
		setAttrVal("Vomit", Vomit);
	}
	public Integer getDrainage() {
		return ((Integer) getAttrVal("Drainage"));
	}	
	public void setDrainage(Integer Drainage) {
		setAttrVal("Drainage", Drainage);
	}
	public Integer getShit() {
		return ((Integer) getAttrVal("Shit"));
	}	
	public void setShit(Integer Shit) {
		setAttrVal("Shit", Shit);
	}
	public Integer getA_shit() {
		return ((Integer) getAttrVal("A_shit"));
	}	
	public void setA_shit(Integer A_shit) {
		setAttrVal("A_shit", A_shit);
	}
	public Integer getUrine() {
		return ((Integer) getAttrVal("Urine"));
	}	
	public void setUrine(Integer Urine) {
		setAttrVal("Urine", Urine);
	}
	public Integer getA_urine() {
		return ((Integer) getAttrVal("A_urine"));
	}	
	public void setA_urine(Integer A_urine) {
		setAttrVal("A_urine", A_urine);
	}
	public String getId_skin() {
		return ((String) getAttrVal("Id_skin"));
	}	
	public void setId_skin(String Id_skin) {
		setAttrVal("Id_skin", Id_skin);
	}
	public String getSd_skin() {
		return ((String) getAttrVal("Sd_skin"));
	}	
	public void setSd_skin(String Sd_skin) {
		setAttrVal("Sd_skin", Sd_skin);
	}
	public FDouble getBoxtem() {
		return ((FDouble) getAttrVal("Boxtem"));
	}	
	public void setBoxtem(FDouble Boxtem) {
		setAttrVal("Boxtem", Boxtem);
	}
	public FDouble getHum() {
		return ((FDouble) getAttrVal("Hum"));
	}	
	public void setHum(FDouble Hum) {
		setAttrVal("Hum", Hum);
	}
	public String getManagement() {
		return ((String) getAttrVal("Management"));
	}	
	public void setManagement(String Management) {
		setAttrVal("Management", Management);
	}
	public String getId_sign() {
		return ((String) getAttrVal("Id_sign"));
	}	
	public void setId_sign(String Id_sign) {
		setAttrVal("Id_sign", Id_sign);
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
	public String getName_oxy_type() {
		return ((String) getAttrVal("Name_oxy_type"));
	}	
	public void setName_oxy_type(String Name_oxy_type) {
		setAttrVal("Name_oxy_type", Name_oxy_type);
	}
	public String getName_skincolor() {
		return ((String) getAttrVal("Name_skincolor"));
	}	
	public void setName_skincolor(String Name_skincolor) {
		setAttrVal("Name_skincolor", Name_skincolor);
	}
	public String getName_autoactivity() {
		return ((String) getAttrVal("Name_autoactivity"));
	}	
	public void setName_autoactivity(String Name_autoactivity) {
		setAttrVal("Name_autoactivity", Name_autoactivity);
	}
	public String getName_muscle_tension() {
		return ((String) getAttrVal("Name_muscle_tension"));
	}	
	public void setName_muscle_tension(String Name_muscle_tension) {
		setAttrVal("Name_muscle_tension", Name_muscle_tension);
	}
	public String getName_cry_voice() {
		return ((String) getAttrVal("Name_cry_voice"));
	}	
	public void setName_cry_voice(String Name_cry_voice) {
		setAttrVal("Name_cry_voice", Name_cry_voice);
	}
	public String getName_abd_dis() {
		return ((String) getAttrVal("Name_abd_dis"));
	}	
	public void setName_abd_dis(String Name_abd_dis) {
		setAttrVal("Name_abd_dis", Name_abd_dis);
	}
	public String getName_umbilical() {
		return ((String) getAttrVal("Name_umbilical"));
	}	
	public void setName_umbilical(String Name_umbilical) {
		setAttrVal("Name_umbilical", Name_umbilical);
	}
	public String getName_route() {
		return ((String) getAttrVal("Name_route"));
	}	
	public void setName_route(String Name_route) {
		setAttrVal("Name_route", Name_route);
	}
	public String getName_unit_speed() {
		return ((String) getAttrVal("Name_unit_speed"));
	}	
	public void setName_unit_speed(String Name_unit_speed) {
		setAttrVal("Name_unit_speed", Name_unit_speed);
	}
	public String getName_diet() {
		return ((String) getAttrVal("Name_diet"));
	}	
	public void setName_diet(String Name_diet) {
		setAttrVal("Name_diet", Name_diet);
	}
	public String getName_bringinto_way() {
		return ((String) getAttrVal("Name_bringinto_way"));
	}	
	public void setName_bringinto_way(String Name_bringinto_way) {
		setAttrVal("Name_bringinto_way", Name_bringinto_way);
	}
	public String getName_suckpower() {
		return ((String) getAttrVal("Name_suckpower"));
	}	
	public void setName_suckpower(String Name_suckpower) {
		setAttrVal("Name_suckpower", Name_suckpower);
	}
	public String getName_swallow_active() {
		return ((String) getAttrVal("Name_swallow_active"));
	}	
	public void setName_swallow_active(String Name_swallow_active) {
		setAttrVal("Name_swallow_active", Name_swallow_active);
	}
	public String getName_skin() {
		return ((String) getAttrVal("Name_skin"));
	}	
	public void setName_skin(String Name_skin) {
		setAttrVal("Name_skin", Name_skin);
	}
	public String getName_sign() {
		return ((String) getAttrVal("Name_sign"));
	}	
	public void setName_sign(String Name_sign) {
		setAttrVal("Name_sign", Name_sign);
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
		return "Id_chass_rec";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_MR_NU_CHASS_REC";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ChildrenInAsseNurRecordDODesc.class);
	}
	
}