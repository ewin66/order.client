package iih.ci.mr.nu.obstetrics.breathmachnur.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.obstetrics.breathmachnur.d.desc.BreathMachRecDODesc;
import java.math.BigDecimal;

/**
 * 呼吸治疗观察护理记录单 DO数据 
 * 
 */
public class BreathMachRecDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_BTHMACHREC= "Id_bthmachrec";
	public static final String ID_BTHMACH= "Id_bthmach";
	public static final String DT_REC= "Dt_rec";
	public static final String ID_MECHANICAL_VENTILATION= "Id_mechanical_ventilation";
	public static final String SD_MECHANICAL_VENTILATION= "Sd_mechanical_ventilation";
	public static final String FR= "Fr";
	public static final String PIP= "Pip";
	public static final String P= "P";
	public static final String PEEP= "Peep";
	public static final String MAP= "Map";
	public static final String RR_MACHINE= "Rr_machine";
	public static final String F= "F";
	public static final String IT= "It";
	public static final String IE= "Ie";
	public static final String FIO2= "Fio2";
	public static final String TEM= "Tem";
	public static final String HEART_RATE= "Heart_rate";
	public static final String RESPIRATORY_FREQUENCY= "Respiratory_frequency";
	public static final String DBP= "Dbp";
	public static final String SBP= "Sbp";
	public static final String SPO2= "Spo2";
	public static final String NAME_DRUG= "Name_drug";
	public static final String DOSE_DRUGS= "Dose_drugs";
	public static final String ID_ROUTE_DRUG= "Id_route_drug";
	public static final String SD_ROUTE_DRUG= "Sd_route_drug";
	public static final String SPPED_DRUG= "Spped_drug";
	public static final String ID_UNIT_SPEED= "Id_unit_speed";
	public static final String SD_UNIT_SPEED= "Sd_unit_speed";
	public static final String ID_DIET= "Id_diet";
	public static final String SD_DIET= "Sd_diet";
	public static final String ID_DOSEIN_WAY= "Id_dosein_way";
	public static final String SD_DOSEIN_WAY= "Sd_dosein_way";
	public static final String DOSE_DRINK= "Dose_drink";
	public static final String SHIT= "Shit";
	public static final String A_SKIT= "A_skit";
	public static final String URINE= "Urine";
	public static final String A_URINE= "A_urine";
	public static final String ID_SUCTION_WAY= "Id_suction_way";
	public static final String SD_SUCTION_WAY= "Sd_suction_way";
	public static final String NATURE= "Nature";
	public static final String ID_SKIN_COLOR= "Id_skin_color";
	public static final String SD_SKIN_COLOR= "Sd_skin_color";
	public static final String ID_SKIN= "Id_skin";
	public static final String SD_SKIN= "Sd_skin";
	public static final String ID_PIPE= "Id_pipe";
	public static final String SD_PIPE= "Sd_pipe";
	public static final String BQBHJCL= "Bqbhjcl";
	public static final String ID_SIGN= "Id_sign";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_MECHANICAL_VENTILATION= "Name_mechanical_ventilation";
	public static final String NAME_ROUTE_DRUG= "Name_route_drug";
	public static final String NAME_UNIT_SPEED= "Name_unit_speed";
	public static final String NAME_DIET= "Name_diet";
	public static final String NAME_DOSEIN_WAY= "Name_dosein_way";
	public static final String NAME_SUCTION_WAY= "Name_suction_way";
	public static final String NAME_SKIN_COLOR= "Name_skin_color";
	public static final String NAME_SKIN= "Name_skin";
	public static final String NAME_PIPE= "Name_pipe";
	public static final String NAME_SIGN= "Name_sign";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_bthmachrec() {
		return ((String) getAttrVal("Id_bthmachrec"));
	}	
	public void setId_bthmachrec(String Id_bthmachrec) {
		setAttrVal("Id_bthmachrec", Id_bthmachrec);
	}
	public String getId_bthmach() {
		return ((String) getAttrVal("Id_bthmach"));
	}	
	public void setId_bthmach(String Id_bthmach) {
		setAttrVal("Id_bthmach", Id_bthmach);
	}
	public FDateTime getDt_rec() {
		return ((FDateTime) getAttrVal("Dt_rec"));
	}	
	public void setDt_rec(FDateTime Dt_rec) {
		setAttrVal("Dt_rec", Dt_rec);
	}
	public String getId_mechanical_ventilation() {
		return ((String) getAttrVal("Id_mechanical_ventilation"));
	}	
	public void setId_mechanical_ventilation(String Id_mechanical_ventilation) {
		setAttrVal("Id_mechanical_ventilation", Id_mechanical_ventilation);
	}
	public String getSd_mechanical_ventilation() {
		return ((String) getAttrVal("Sd_mechanical_ventilation"));
	}	
	public void setSd_mechanical_ventilation(String Sd_mechanical_ventilation) {
		setAttrVal("Sd_mechanical_ventilation", Sd_mechanical_ventilation);
	}
	public FDouble getFr() {
		return ((FDouble) getAttrVal("Fr"));
	}	
	public void setFr(FDouble Fr) {
		setAttrVal("Fr", Fr);
	}
	public FDouble getPip() {
		return ((FDouble) getAttrVal("Pip"));
	}	
	public void setPip(FDouble Pip) {
		setAttrVal("Pip", Pip);
	}
	public FDouble getP() {
		return ((FDouble) getAttrVal("P"));
	}	
	public void setP(FDouble P) {
		setAttrVal("P", P);
	}
	public FDouble getPeep() {
		return ((FDouble) getAttrVal("Peep"));
	}	
	public void setPeep(FDouble Peep) {
		setAttrVal("Peep", Peep);
	}
	public FDouble getMap() {
		return ((FDouble) getAttrVal("Map"));
	}	
	public void setMap(FDouble Map) {
		setAttrVal("Map", Map);
	}
	public FDouble getRr_machine() {
		return ((FDouble) getAttrVal("Rr_machine"));
	}	
	public void setRr_machine(FDouble Rr_machine) {
		setAttrVal("Rr_machine", Rr_machine);
	}
	public FDouble getF() {
		return ((FDouble) getAttrVal("F"));
	}	
	public void setF(FDouble F) {
		setAttrVal("F", F);
	}
	public FDouble getIt() {
		return ((FDouble) getAttrVal("It"));
	}	
	public void setIt(FDouble It) {
		setAttrVal("It", It);
	}
	public FDouble getIe() {
		return ((FDouble) getAttrVal("Ie"));
	}	
	public void setIe(FDouble Ie) {
		setAttrVal("Ie", Ie);
	}
	public FDouble getFio2() {
		return ((FDouble) getAttrVal("Fio2"));
	}	
	public void setFio2(FDouble Fio2) {
		setAttrVal("Fio2", Fio2);
	}
	public FDouble getTem() {
		return ((FDouble) getAttrVal("Tem"));
	}	
	public void setTem(FDouble Tem) {
		setAttrVal("Tem", Tem);
	}
	public Integer getHeart_rate() {
		return ((Integer) getAttrVal("Heart_rate"));
	}	
	public void setHeart_rate(Integer Heart_rate) {
		setAttrVal("Heart_rate", Heart_rate);
	}
	public Integer getRespiratory_frequency() {
		return ((Integer) getAttrVal("Respiratory_frequency"));
	}	
	public void setRespiratory_frequency(Integer Respiratory_frequency) {
		setAttrVal("Respiratory_frequency", Respiratory_frequency);
	}
	public Integer getDbp() {
		return ((Integer) getAttrVal("Dbp"));
	}	
	public void setDbp(Integer Dbp) {
		setAttrVal("Dbp", Dbp);
	}
	public Integer getSbp() {
		return ((Integer) getAttrVal("Sbp"));
	}	
	public void setSbp(Integer Sbp) {
		setAttrVal("Sbp", Sbp);
	}
	public FDouble getSpo2() {
		return ((FDouble) getAttrVal("Spo2"));
	}	
	public void setSpo2(FDouble Spo2) {
		setAttrVal("Spo2", Spo2);
	}
	public String getName_drug() {
		return ((String) getAttrVal("Name_drug"));
	}	
	public void setName_drug(String Name_drug) {
		setAttrVal("Name_drug", Name_drug);
	}
	public Integer getDose_drugs() {
		return ((Integer) getAttrVal("Dose_drugs"));
	}	
	public void setDose_drugs(Integer Dose_drugs) {
		setAttrVal("Dose_drugs", Dose_drugs);
	}
	public String getId_route_drug() {
		return ((String) getAttrVal("Id_route_drug"));
	}	
	public void setId_route_drug(String Id_route_drug) {
		setAttrVal("Id_route_drug", Id_route_drug);
	}
	public String getSd_route_drug() {
		return ((String) getAttrVal("Sd_route_drug"));
	}	
	public void setSd_route_drug(String Sd_route_drug) {
		setAttrVal("Sd_route_drug", Sd_route_drug);
	}
	public Integer getSpped_drug() {
		return ((Integer) getAttrVal("Spped_drug"));
	}	
	public void setSpped_drug(Integer Spped_drug) {
		setAttrVal("Spped_drug", Spped_drug);
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
	public String getId_dosein_way() {
		return ((String) getAttrVal("Id_dosein_way"));
	}	
	public void setId_dosein_way(String Id_dosein_way) {
		setAttrVal("Id_dosein_way", Id_dosein_way);
	}
	public String getSd_dosein_way() {
		return ((String) getAttrVal("Sd_dosein_way"));
	}	
	public void setSd_dosein_way(String Sd_dosein_way) {
		setAttrVal("Sd_dosein_way", Sd_dosein_way);
	}
	public Integer getDose_drink() {
		return ((Integer) getAttrVal("Dose_drink"));
	}	
	public void setDose_drink(Integer Dose_drink) {
		setAttrVal("Dose_drink", Dose_drink);
	}
	public Integer getShit() {
		return ((Integer) getAttrVal("Shit"));
	}	
	public void setShit(Integer Shit) {
		setAttrVal("Shit", Shit);
	}
	public Integer getA_skit() {
		return ((Integer) getAttrVal("A_skit"));
	}	
	public void setA_skit(Integer A_skit) {
		setAttrVal("A_skit", A_skit);
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
	public String getId_suction_way() {
		return ((String) getAttrVal("Id_suction_way"));
	}	
	public void setId_suction_way(String Id_suction_way) {
		setAttrVal("Id_suction_way", Id_suction_way);
	}
	public String getSd_suction_way() {
		return ((String) getAttrVal("Sd_suction_way"));
	}	
	public void setSd_suction_way(String Sd_suction_way) {
		setAttrVal("Sd_suction_way", Sd_suction_way);
	}
	public String getNature() {
		return ((String) getAttrVal("Nature"));
	}	
	public void setNature(String Nature) {
		setAttrVal("Nature", Nature);
	}
	public String getId_skin_color() {
		return ((String) getAttrVal("Id_skin_color"));
	}	
	public void setId_skin_color(String Id_skin_color) {
		setAttrVal("Id_skin_color", Id_skin_color);
	}
	public String getSd_skin_color() {
		return ((String) getAttrVal("Sd_skin_color"));
	}	
	public void setSd_skin_color(String Sd_skin_color) {
		setAttrVal("Sd_skin_color", Sd_skin_color);
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
	public String getId_pipe() {
		return ((String) getAttrVal("Id_pipe"));
	}	
	public void setId_pipe(String Id_pipe) {
		setAttrVal("Id_pipe", Id_pipe);
	}
	public String getSd_pipe() {
		return ((String) getAttrVal("Sd_pipe"));
	}	
	public void setSd_pipe(String Sd_pipe) {
		setAttrVal("Sd_pipe", Sd_pipe);
	}
	public String getBqbhjcl() {
		return ((String) getAttrVal("Bqbhjcl"));
	}	
	public void setBqbhjcl(String Bqbhjcl) {
		setAttrVal("Bqbhjcl", Bqbhjcl);
	}
	public String getId_sign() {
		return ((String) getAttrVal("Id_sign"));
	}	
	public void setId_sign(String Id_sign) {
		setAttrVal("Id_sign", Id_sign);
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
	public String getName_mechanical_ventilation() {
		return ((String) getAttrVal("Name_mechanical_ventilation"));
	}	
	public void setName_mechanical_ventilation(String Name_mechanical_ventilation) {
		setAttrVal("Name_mechanical_ventilation", Name_mechanical_ventilation);
	}
	public String getName_route_drug() {
		return ((String) getAttrVal("Name_route_drug"));
	}	
	public void setName_route_drug(String Name_route_drug) {
		setAttrVal("Name_route_drug", Name_route_drug);
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
	public String getName_dosein_way() {
		return ((String) getAttrVal("Name_dosein_way"));
	}	
	public void setName_dosein_way(String Name_dosein_way) {
		setAttrVal("Name_dosein_way", Name_dosein_way);
	}
	public String getName_suction_way() {
		return ((String) getAttrVal("Name_suction_way"));
	}	
	public void setName_suction_way(String Name_suction_way) {
		setAttrVal("Name_suction_way", Name_suction_way);
	}
	public String getName_skin_color() {
		return ((String) getAttrVal("Name_skin_color"));
	}	
	public void setName_skin_color(String Name_skin_color) {
		setAttrVal("Name_skin_color", Name_skin_color);
	}
	public String getName_skin() {
		return ((String) getAttrVal("Name_skin"));
	}	
	public void setName_skin(String Name_skin) {
		setAttrVal("Name_skin", Name_skin);
	}
	public String getName_pipe() {
		return ((String) getAttrVal("Name_pipe"));
	}	
	public void setName_pipe(String Name_pipe) {
		setAttrVal("Name_pipe", Name_pipe);
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
		return "Id_bthmachrec";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_MR_NU_BTHMACH_REC";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BreathMachRecDODesc.class);
	}
	
}