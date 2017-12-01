package iih.ci.mr.nu.obstetrics.antenatalassess.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.obstetrics.antenatalassess.d.desc.AntenNurBserRecDODesc;
import java.math.BigDecimal;

/**
 * 护理观察记录 DO数据 
 * 
 */
public class AntenNurBserRecDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_ANTENREC= "Id_antenrec";
	public static final String ID_ANTENASS= "Id_antenass";
	public static final String DT_REC= "Dt_rec";
	public static final String TEMP= "Temp";
	public static final String PULSE= "Pulse";
	public static final String BREATH= "Breath";
	public static final String SBP= "Sbp";
	public static final String DBP= "Dbp";
	public static final String SPO= "Spo";
	public static final String ID_FUNDUSHGT= "Id_fundushgt";
	public static final String SD_FUNDUSHGT= "Sd_fundushgt";
	public static final String EU_UTERUS_PINCH= "Eu_uterus_pinch";
	public static final String COLPORRHAGIA= "Colporrhagia";
	public static final String URINEVOLUME= "Urinevolume";
	public static final String DRINAME= "Driname";
	public static final String DRIDOSAGE= "Dridosage";
	public static final String DRIUSAGE= "Driusage";
	public static final String ID_SKINCOND= "Id_skincond";
	public static final String OBSERILNESS= "Obserilness";
	public static final String ID_SIGN_PSN= "Id_sign_psn";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_FUNDUSHGT= "Name_fundushgt";
	public static final String NAME_SIGN_PSN= "Name_sign_psn";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_antenrec() {
		return ((String) getAttrVal("Id_antenrec"));
	}	
	public void setId_antenrec(String Id_antenrec) {
		setAttrVal("Id_antenrec", Id_antenrec);
	}
	public String getId_antenass() {
		return ((String) getAttrVal("Id_antenass"));
	}	
	public void setId_antenass(String Id_antenass) {
		setAttrVal("Id_antenass", Id_antenass);
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
	public FDouble getSpo() {
		return ((FDouble) getAttrVal("Spo"));
	}	
	public void setSpo(FDouble Spo) {
		setAttrVal("Spo", Spo);
	}
	public String getId_fundushgt() {
		return ((String) getAttrVal("Id_fundushgt"));
	}	
	public void setId_fundushgt(String Id_fundushgt) {
		setAttrVal("Id_fundushgt", Id_fundushgt);
	}
	public String getSd_fundushgt() {
		return ((String) getAttrVal("Sd_fundushgt"));
	}	
	public void setSd_fundushgt(String Sd_fundushgt) {
		setAttrVal("Sd_fundushgt", Sd_fundushgt);
	}
	public Integer getEu_uterus_pinch() {
		return ((Integer) getAttrVal("Eu_uterus_pinch"));
	}	
	public void setEu_uterus_pinch(Integer Eu_uterus_pinch) {
		setAttrVal("Eu_uterus_pinch", Eu_uterus_pinch);
	}
	public Integer getColporrhagia() {
		return ((Integer) getAttrVal("Colporrhagia"));
	}	
	public void setColporrhagia(Integer Colporrhagia) {
		setAttrVal("Colporrhagia", Colporrhagia);
	}
	public Integer getUrinevolume() {
		return ((Integer) getAttrVal("Urinevolume"));
	}	
	public void setUrinevolume(Integer Urinevolume) {
		setAttrVal("Urinevolume", Urinevolume);
	}
	public String getDriname() {
		return ((String) getAttrVal("Driname"));
	}	
	public void setDriname(String Driname) {
		setAttrVal("Driname", Driname);
	}
	public Integer getDridosage() {
		return ((Integer) getAttrVal("Dridosage"));
	}	
	public void setDridosage(Integer Dridosage) {
		setAttrVal("Dridosage", Dridosage);
	}
	public String getDriusage() {
		return ((String) getAttrVal("Driusage"));
	}	
	public void setDriusage(String Driusage) {
		setAttrVal("Driusage", Driusage);
	}
	public Integer getId_skincond() {
		return ((Integer) getAttrVal("Id_skincond"));
	}	
	public void setId_skincond(Integer Id_skincond) {
		setAttrVal("Id_skincond", Id_skincond);
	}
	public String getObserilness() {
		return ((String) getAttrVal("Obserilness"));
	}	
	public void setObserilness(String Obserilness) {
		setAttrVal("Obserilness", Obserilness);
	}
	public String getId_sign_psn() {
		return ((String) getAttrVal("Id_sign_psn"));
	}	
	public void setId_sign_psn(String Id_sign_psn) {
		setAttrVal("Id_sign_psn", Id_sign_psn);
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
	public String getName_fundushgt() {
		return ((String) getAttrVal("Name_fundushgt"));
	}	
	public void setName_fundushgt(String Name_fundushgt) {
		setAttrVal("Name_fundushgt", Name_fundushgt);
	}
	public String getName_sign_psn() {
		return ((String) getAttrVal("Name_sign_psn"));
	}	
	public void setName_sign_psn(String Name_sign_psn) {
		setAttrVal("Name_sign_psn", Name_sign_psn);
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
		return "Id_antenrec";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_Mr_NU_ANTNURBSERREC";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(AntenNurBserRecDODesc.class);
	}
	
}