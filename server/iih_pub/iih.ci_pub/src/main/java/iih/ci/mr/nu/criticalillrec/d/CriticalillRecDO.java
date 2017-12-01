package iih.ci.mr.nu.criticalillrec.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.criticalillrec.d.desc.CriticalillRecDODesc;
import java.math.BigDecimal;

/**
 * 危重症护理记录单 DO数据 
 * 
 */
public class CriticalillRecDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_CTRI_REC= "Id_ctri_rec";
	public static final String ID_CTRI= "Id_ctri";
	public static final String D_CRI= "D_cri";
	public static final String T_CRI= "T_cri";
	public static final String TEM= "Tem";
	public static final String PULSE= "Pulse";
	public static final String BREATH= "Breath";
	public static final String DIA_PRESSURE= "Dia_pressure";
	public static final String SYS_PRESSURE= "Sys_pressure";
	public static final String PULSE_OXYGEN_SATURATION= "Pulse_oxygen_saturation";
	public static final String ID_OXYGEN_INHALATION= "Id_oxygen_inhalation";
	public static final String SD_OXYGEN_INHALATION= "Sd_oxygen_inhalation";
	public static final String FIO2= "Fio2";
	public static final String ID_PIPE_TYPE= "Id_pipe_type";
	public static final String NAME_PIPE_TYPE= "Name_pipe_type";
	public static final String SD_PIPE_TYPE= "Sd_pipe_type";
	public static final String DT_EXTUBATION= "Dt_extubation";
	public static final String AMOUNT= "Amount";
	public static final String DOSE_IN= "Dose_in";
	public static final String SPEED= "Speed";
	public static final String ID_AMOUNT_TYPE= "Id_amount_type";
	public static final String SD_AMOUNT_TYPE= "Sd_amount_type";
	public static final String ID_VOLUME= "Id_volume";
	public static final String SD_VOLUME= "Sd_volume";
	public static final String DOSE_OUT= "Dose_out";
	public static final String ID_COLOR_CHA= "Id_color_cha";
	public static final String SD_COLOR_CHA= "Sd_color_cha";
	public static final String SKIN_CONDITION= "Skin_condition";
	public static final String YS= "Ys";
	public static final String XZ= "Xz";
	public static final String JCHL= "Jchl";
	public static final String OBSANDMEA= "Obsandmea";
	public static final String ID_SIGN= "Id_sign";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_OXYGEN_INHALATION= "Name_oxygen_inhalation";
	public static final String NAME_AMOUNT_TYPE= "Name_amount_type";
	public static final String NAME_VOLUME= "Name_volume";
	public static final String NAME_COLOR_CHA= "Name_color_cha";
	public static final String NAME_SIGN= "Name_sign";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_ctri_rec() {
		return ((String) getAttrVal("Id_ctri_rec"));
	}	
	public void setId_ctri_rec(String Id_ctri_rec) {
		setAttrVal("Id_ctri_rec", Id_ctri_rec);
	}
	public String getId_ctri() {
		return ((String) getAttrVal("Id_ctri"));
	}	
	public void setId_ctri(String Id_ctri) {
		setAttrVal("Id_ctri", Id_ctri);
	}
	public FDate getD_cri() {
		return ((FDate) getAttrVal("D_cri"));
	}	
	public void setD_cri(FDate D_cri) {
		setAttrVal("D_cri", D_cri);
	}
	public FTime getT_cri() {
		return ((FTime) getAttrVal("T_cri"));
	}	
	public void setT_cri(FTime T_cri) {
		setAttrVal("T_cri", T_cri);
	}
	public FDouble getTem() {
		return ((FDouble) getAttrVal("Tem"));
	}	
	public void setTem(FDouble Tem) {
		setAttrVal("Tem", Tem);
	}
	public FDouble getPulse() {
		return ((FDouble) getAttrVal("Pulse"));
	}	
	public void setPulse(FDouble Pulse) {
		setAttrVal("Pulse", Pulse);
	}
	public FDouble getBreath() {
		return ((FDouble) getAttrVal("Breath"));
	}	
	public void setBreath(FDouble Breath) {
		setAttrVal("Breath", Breath);
	}
	public Integer getDia_pressure() {
		return ((Integer) getAttrVal("Dia_pressure"));
	}	
	public void setDia_pressure(Integer Dia_pressure) {
		setAttrVal("Dia_pressure", Dia_pressure);
	}
	public Integer getSys_pressure() {
		return ((Integer) getAttrVal("Sys_pressure"));
	}	
	public void setSys_pressure(Integer Sys_pressure) {
		setAttrVal("Sys_pressure", Sys_pressure);
	}
	public FDouble getPulse_oxygen_saturation() {
		return ((FDouble) getAttrVal("Pulse_oxygen_saturation"));
	}	
	public void setPulse_oxygen_saturation(FDouble Pulse_oxygen_saturation) {
		setAttrVal("Pulse_oxygen_saturation", Pulse_oxygen_saturation);
	}
	public String getId_oxygen_inhalation() {
		return ((String) getAttrVal("Id_oxygen_inhalation"));
	}	
	public void setId_oxygen_inhalation(String Id_oxygen_inhalation) {
		setAttrVal("Id_oxygen_inhalation", Id_oxygen_inhalation);
	}
	public String getSd_oxygen_inhalation() {
		return ((String) getAttrVal("Sd_oxygen_inhalation"));
	}	
	public void setSd_oxygen_inhalation(String Sd_oxygen_inhalation) {
		setAttrVal("Sd_oxygen_inhalation", Sd_oxygen_inhalation);
	}
	public FDouble getFio2() {
		return ((FDouble) getAttrVal("Fio2"));
	}	
	public void setFio2(FDouble Fio2) {
		setAttrVal("Fio2", Fio2);
	}
	public String getId_pipe_type() {
		return ((String) getAttrVal("Id_pipe_type"));
	}	
	public void setId_pipe_type(String Id_pipe_type) {
		setAttrVal("Id_pipe_type", Id_pipe_type);
	}
	public String getName_pipe_type() {
		return ((String) getAttrVal("Name_pipe_type"));
	}	
	public void setName_pipe_type(String Name_pipe_type) {
		setAttrVal("Name_pipe_type", Name_pipe_type);
	}
	public String getSd_pipe_type() {
		return ((String) getAttrVal("Sd_pipe_type"));
	}	
	public void setSd_pipe_type(String Sd_pipe_type) {
		setAttrVal("Sd_pipe_type", Sd_pipe_type);
	}
	public FDateTime getDt_extubation() {
		return ((FDateTime) getAttrVal("Dt_extubation"));
	}	
	public void setDt_extubation(FDateTime Dt_extubation) {
		setAttrVal("Dt_extubation", Dt_extubation);
	}
	public String getAmount() {
		return ((String) getAttrVal("Amount"));
	}	
	public void setAmount(String Amount) {
		setAttrVal("Amount", Amount);
	}
	public Integer getDose_in() {
		return ((Integer) getAttrVal("Dose_in"));
	}	
	public void setDose_in(Integer Dose_in) {
		setAttrVal("Dose_in", Dose_in);
	}
	public Integer getSpeed() {
		return ((Integer) getAttrVal("Speed"));
	}	
	public void setSpeed(Integer Speed) {
		setAttrVal("Speed", Speed);
	}
	public String getId_amount_type() {
		return ((String) getAttrVal("Id_amount_type"));
	}	
	public void setId_amount_type(String Id_amount_type) {
		setAttrVal("Id_amount_type", Id_amount_type);
	}
	public String getSd_amount_type() {
		return ((String) getAttrVal("Sd_amount_type"));
	}	
	public void setSd_amount_type(String Sd_amount_type) {
		setAttrVal("Sd_amount_type", Sd_amount_type);
	}
	public String getId_volume() {
		return ((String) getAttrVal("Id_volume"));
	}	
	public void setId_volume(String Id_volume) {
		setAttrVal("Id_volume", Id_volume);
	}
	public String getSd_volume() {
		return ((String) getAttrVal("Sd_volume"));
	}	
	public void setSd_volume(String Sd_volume) {
		setAttrVal("Sd_volume", Sd_volume);
	}
	public Integer getDose_out() {
		return ((Integer) getAttrVal("Dose_out"));
	}	
	public void setDose_out(Integer Dose_out) {
		setAttrVal("Dose_out", Dose_out);
	}
	public String getId_color_cha() {
		return ((String) getAttrVal("Id_color_cha"));
	}	
	public void setId_color_cha(String Id_color_cha) {
		setAttrVal("Id_color_cha", Id_color_cha);
	}
	public String getSd_color_cha() {
		return ((String) getAttrVal("Sd_color_cha"));
	}	
	public void setSd_color_cha(String Sd_color_cha) {
		setAttrVal("Sd_color_cha", Sd_color_cha);
	}
	public Integer getSkin_condition() {
		return ((Integer) getAttrVal("Skin_condition"));
	}	
	public void setSkin_condition(Integer Skin_condition) {
		setAttrVal("Skin_condition", Skin_condition);
	}
	public String getYs() {
		return ((String) getAttrVal("Ys"));
	}	
	public void setYs(String Ys) {
		setAttrVal("Ys", Ys);
	}
	public String getXz() {
		return ((String) getAttrVal("Xz"));
	}	
	public void setXz(String Xz) {
		setAttrVal("Xz", Xz);
	}
	public String getJchl() {
		return ((String) getAttrVal("Jchl"));
	}	
	public void setJchl(String Jchl) {
		setAttrVal("Jchl", Jchl);
	}
	public String getObsandmea() {
		return ((String) getAttrVal("Obsandmea"));
	}	
	public void setObsandmea(String Obsandmea) {
		setAttrVal("Obsandmea", Obsandmea);
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
	public String getName_oxygen_inhalation() {
		return ((String) getAttrVal("Name_oxygen_inhalation"));
	}	
	public void setName_oxygen_inhalation(String Name_oxygen_inhalation) {
		setAttrVal("Name_oxygen_inhalation", Name_oxygen_inhalation);
	}
	public String getName_amount_type() {
		return ((String) getAttrVal("Name_amount_type"));
	}	
	public void setName_amount_type(String Name_amount_type) {
		setAttrVal("Name_amount_type", Name_amount_type);
	}
	public String getName_volume() {
		return ((String) getAttrVal("Name_volume"));
	}	
	public void setName_volume(String Name_volume) {
		setAttrVal("Name_volume", Name_volume);
	}
	public String getName_color_cha() {
		return ((String) getAttrVal("Name_color_cha"));
	}	
	public void setName_color_cha(String Name_color_cha) {
		setAttrVal("Name_color_cha", Name_color_cha);
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
		return "Id_ctri_rec";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_mr_nu_ctri_rec";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CriticalillRecDODesc.class);
	}
	
}