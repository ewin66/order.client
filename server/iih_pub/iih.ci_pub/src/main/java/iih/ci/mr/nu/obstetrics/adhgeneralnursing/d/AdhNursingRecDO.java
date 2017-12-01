package iih.ci.mr.nu.obstetrics.adhgeneralnursing.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.obstetrics.adhgeneralnursing.d.desc.AdhNursingRecDODesc;
import java.math.BigDecimal;

/**
 * 产科护理观察记录（产前） DO数据 
 * 
 */
public class AdhNursingRecDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_ADHNR_REC= "Id_adhnr_rec";
	public static final String ID_ADHNR= "Id_adhnr";
	public static final String D_REC= "D_rec";
	public static final String T_REC= "T_rec";
	public static final String TEM= "Tem";
	public static final String PULSE= "Pulse";
	public static final String BREATH= "Breath";
	public static final String SYS_PRESSURE= "Sys_pressure";
	public static final String DIA_PRESSURE= "Dia_pressure";
	public static final String FETAL_HEART= "Fetal_heart";
	public static final String FETAL_MO= "Fetal_mo";
	public static final String UT_CONTRACTION= "Ut_contraction";
	public static final String EU_TM= "Eu_tm";
	public static final String DA_UT= "Da_ut";
	public static final String NAME_AMOUNT= "Name_amount";
	public static final String DOSE_AMOUNT= "Dose_amount";
	public static final String ID_AMOUNT_TYPE= "Id_amount_type";
	public static final String SD_AMOUNT_TYPE= "Sd_amount_type";
	public static final String ID_VOLUME= "Id_volume";
	public static final String SD_VOLUME= "Sd_volume";
	public static final String DOSE_VOLUME= "Dose_volume";
	public static final String SKIN_CONDITION= "Skin_condition";
	public static final String OBSANDMEA= "Obsandmea";
	public static final String ID_SIGN= "Id_sign";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_AMOUNT_TYPE= "Name_amount_type";
	public static final String NAME_VOLUME= "Name_volume";
	public static final String NAME_SIGN= "Name_sign";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_adhnr_rec() {
		return ((String) getAttrVal("Id_adhnr_rec"));
	}	
	public void setId_adhnr_rec(String Id_adhnr_rec) {
		setAttrVal("Id_adhnr_rec", Id_adhnr_rec);
	}
	public String getId_adhnr() {
		return ((String) getAttrVal("Id_adhnr"));
	}	
	public void setId_adhnr(String Id_adhnr) {
		setAttrVal("Id_adhnr", Id_adhnr);
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
	public Integer getFetal_heart() {
		return ((Integer) getAttrVal("Fetal_heart"));
	}	
	public void setFetal_heart(Integer Fetal_heart) {
		setAttrVal("Fetal_heart", Fetal_heart);
	}
	public Integer getFetal_mo() {
		return ((Integer) getAttrVal("Fetal_mo"));
	}	
	public void setFetal_mo(Integer Fetal_mo) {
		setAttrVal("Fetal_mo", Fetal_mo);
	}
	public Integer getUt_contraction() {
		return ((Integer) getAttrVal("Ut_contraction"));
	}	
	public void setUt_contraction(Integer Ut_contraction) {
		setAttrVal("Ut_contraction", Ut_contraction);
	}
	public Integer getEu_tm() {
		return ((Integer) getAttrVal("Eu_tm"));
	}	
	public void setEu_tm(Integer Eu_tm) {
		setAttrVal("Eu_tm", Eu_tm);
	}
	public Integer getDa_ut() {
		return ((Integer) getAttrVal("Da_ut"));
	}	
	public void setDa_ut(Integer Da_ut) {
		setAttrVal("Da_ut", Da_ut);
	}
	public String getName_amount() {
		return ((String) getAttrVal("Name_amount"));
	}	
	public void setName_amount(String Name_amount) {
		setAttrVal("Name_amount", Name_amount);
	}
	public Integer getDose_amount() {
		return ((Integer) getAttrVal("Dose_amount"));
	}	
	public void setDose_amount(Integer Dose_amount) {
		setAttrVal("Dose_amount", Dose_amount);
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
	public Integer getDose_volume() {
		return ((Integer) getAttrVal("Dose_volume"));
	}	
	public void setDose_volume(Integer Dose_volume) {
		setAttrVal("Dose_volume", Dose_volume);
	}
	public Integer getSkin_condition() {
		return ((Integer) getAttrVal("Skin_condition"));
	}	
	public void setSkin_condition(Integer Skin_condition) {
		setAttrVal("Skin_condition", Skin_condition);
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
		return "Id_adhnr_rec";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_Mr_NU_ADHNR_REC";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(AdhNursingRecDODesc.class);
	}
	
}