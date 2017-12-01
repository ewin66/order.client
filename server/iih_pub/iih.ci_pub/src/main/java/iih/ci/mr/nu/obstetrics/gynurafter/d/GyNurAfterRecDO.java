package iih.ci.mr.nu.obstetrics.gynurafter.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.obstetrics.gynurafter.d.desc.GyNurAfterRecDODesc;
import java.math.BigDecimal;

/**
 * 护理观察记录 DO数据 
 * 
 */
public class GyNurAfterRecDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_REC= "Id_rec";
	public static final String ID_ASS= "Id_ass";
	public static final String DT_REC= "Dt_rec";
	public static final String TEMP= "Temp";
	public static final String PULSE= "Pulse";
	public static final String BREATH= "Breath";
	public static final String SBP= "Sbp";
	public static final String DBP= "Dbp";
	public static final String SAO2= "Sao2";
	public static final String DRI_NAME= "Dri_name";
	public static final String DRI_DOSAGE= "Dri_dosage";
	public static final String ID_DRI_USAGE= "Id_dri_usage";
	public static final String SD_DRI_USAGE= "Sd_dri_usage";
	public static final String OUTPUT_URINE= "Output_urine";
	public static final String OUTPUT_DRAINAGE= "Output_drainage";
	public static final String EU_SKIN= "Eu_skin";
	public static final String EU_DRAINBLOOD= "Eu_drainblood";
	public static final String OBSERILNESS= "Obserilness";
	public static final String ID_REC_PSN= "Id_rec_psn";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_DRI_USAGE= "Name_dri_usage";
	public static final String NAME_REC_PSN= "Name_rec_psn";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_rec() {
		return ((String) getAttrVal("Id_rec"));
	}	
	public void setId_rec(String Id_rec) {
		setAttrVal("Id_rec", Id_rec);
	}
	public String getId_ass() {
		return ((String) getAttrVal("Id_ass"));
	}	
	public void setId_ass(String Id_ass) {
		setAttrVal("Id_ass", Id_ass);
	}
	public FDateTime getDt_rec() {
		return ((FDateTime) getAttrVal("Dt_rec"));
	}	
	public void setDt_rec(FDateTime Dt_rec) {
		setAttrVal("Dt_rec", Dt_rec);
	}
	public FDouble getTemp() {
		return ((FDouble) getAttrVal("Temp"));
	}	
	public void setTemp(FDouble Temp) {
		setAttrVal("Temp", Temp);
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
	public Integer getSbp() {
		return ((Integer) getAttrVal("Sbp"));
	}	
	public void setSbp(Integer Sbp) {
		setAttrVal("Sbp", Sbp);
	}
	public Integer getDbp() {
		return ((Integer) getAttrVal("Dbp"));
	}	
	public void setDbp(Integer Dbp) {
		setAttrVal("Dbp", Dbp);
	}
	public FDouble getSao2() {
		return ((FDouble) getAttrVal("Sao2"));
	}	
	public void setSao2(FDouble Sao2) {
		setAttrVal("Sao2", Sao2);
	}
	public String getDri_name() {
		return ((String) getAttrVal("Dri_name"));
	}	
	public void setDri_name(String Dri_name) {
		setAttrVal("Dri_name", Dri_name);
	}
	public Integer getDri_dosage() {
		return ((Integer) getAttrVal("Dri_dosage"));
	}	
	public void setDri_dosage(Integer Dri_dosage) {
		setAttrVal("Dri_dosage", Dri_dosage);
	}
	public String getId_dri_usage() {
		return ((String) getAttrVal("Id_dri_usage"));
	}	
	public void setId_dri_usage(String Id_dri_usage) {
		setAttrVal("Id_dri_usage", Id_dri_usage);
	}
	public String getSd_dri_usage() {
		return ((String) getAttrVal("Sd_dri_usage"));
	}	
	public void setSd_dri_usage(String Sd_dri_usage) {
		setAttrVal("Sd_dri_usage", Sd_dri_usage);
	}
	public Integer getOutput_urine() {
		return ((Integer) getAttrVal("Output_urine"));
	}	
	public void setOutput_urine(Integer Output_urine) {
		setAttrVal("Output_urine", Output_urine);
	}
	public Integer getOutput_drainage() {
		return ((Integer) getAttrVal("Output_drainage"));
	}	
	public void setOutput_drainage(Integer Output_drainage) {
		setAttrVal("Output_drainage", Output_drainage);
	}
	public Integer getEu_skin() {
		return ((Integer) getAttrVal("Eu_skin"));
	}	
	public void setEu_skin(Integer Eu_skin) {
		setAttrVal("Eu_skin", Eu_skin);
	}
	public Integer getEu_drainblood() {
		return ((Integer) getAttrVal("Eu_drainblood"));
	}	
	public void setEu_drainblood(Integer Eu_drainblood) {
		setAttrVal("Eu_drainblood", Eu_drainblood);
	}
	public String getObserilness() {
		return ((String) getAttrVal("Obserilness"));
	}	
	public void setObserilness(String Obserilness) {
		setAttrVal("Obserilness", Obserilness);
	}
	public String getId_rec_psn() {
		return ((String) getAttrVal("Id_rec_psn"));
	}	
	public void setId_rec_psn(String Id_rec_psn) {
		setAttrVal("Id_rec_psn", Id_rec_psn);
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
	public String getName_dri_usage() {
		return ((String) getAttrVal("Name_dri_usage"));
	}	
	public void setName_dri_usage(String Name_dri_usage) {
		setAttrVal("Name_dri_usage", Name_dri_usage);
	}
	public String getName_rec_psn() {
		return ((String) getAttrVal("Name_rec_psn"));
	}	
	public void setName_rec_psn(String Name_rec_psn) {
		setAttrVal("Name_rec_psn", Name_rec_psn);
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
		return "Id_rec";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_MR_NU_GYAFTERREC";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(GyNurAfterRecDODesc.class);
	}
	
}