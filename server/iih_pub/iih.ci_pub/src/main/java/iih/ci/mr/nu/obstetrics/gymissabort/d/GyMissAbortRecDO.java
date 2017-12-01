package iih.ci.mr.nu.obstetrics.gymissabort.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.obstetrics.gymissabort.d.desc.GyMissAbortRecDODesc;
import java.math.BigDecimal;

/**
 * 护理观察记录 DO数据 
 * 
 */
public class GyMissAbortRecDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_REC= "Id_rec";
	public static final String ID_ASS= "Id_ass";
	public static final String DT_REC= "Dt_rec";
	public static final String TEMP= "Temp";
	public static final String PULSE= "Pulse";
	public static final String BREATH= "Breath";
	public static final String SBP= "Sbp";
	public static final String DBP= "Dbp";
	public static final String SPO2= "Spo2";
	public static final String ID_BLEED= "Id_bleed";
	public static final String SD_BLEED= "Sd_bleed";
	public static final String URINEVOLUME= "Urinevolume";
	public static final String DRAINAGE= "Drainage";
	public static final String OBSERILNESS= "Obserilness";
	public static final String ID_REC_PSN= "Id_rec_psn";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_BLEED= "Name_bleed";
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
	public FDouble getSpo2() {
		return ((FDouble) getAttrVal("Spo2"));
	}	
	public void setSpo2(FDouble Spo2) {
		setAttrVal("Spo2", Spo2);
	}
	public String getId_bleed() {
		return ((String) getAttrVal("Id_bleed"));
	}	
	public void setId_bleed(String Id_bleed) {
		setAttrVal("Id_bleed", Id_bleed);
	}
	public String getSd_bleed() {
		return ((String) getAttrVal("Sd_bleed"));
	}	
	public void setSd_bleed(String Sd_bleed) {
		setAttrVal("Sd_bleed", Sd_bleed);
	}
	public Integer getUrinevolume() {
		return ((Integer) getAttrVal("Urinevolume"));
	}	
	public void setUrinevolume(Integer Urinevolume) {
		setAttrVal("Urinevolume", Urinevolume);
	}
	public Integer getDrainage() {
		return ((Integer) getAttrVal("Drainage"));
	}	
	public void setDrainage(Integer Drainage) {
		setAttrVal("Drainage", Drainage);
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
	public String getName_bleed() {
		return ((String) getAttrVal("Name_bleed"));
	}	
	public void setName_bleed(String Name_bleed) {
		setAttrVal("Name_bleed", Name_bleed);
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
		return "CI_MR_NU_GYMISSABORTREC";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(GyMissAbortRecDODesc.class);
	}
	
}