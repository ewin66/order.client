package iih.ci.mr.nu.painassessment.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.painassessment.d.desc.PainAssessItmDODesc;
import java.math.BigDecimal;

/**
 * 疼痛护理记录表 DO数据 
 * 
 */
public class PainAssessItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PAI= "Id_pai";
	public static final String ID_PA= "Id_pa";
	public static final String DT_REC= "Dt_rec";
	public static final String ADPI= "Adpi";
	public static final String PULSE= "Pulse";
	public static final String DBP= "Dbp";
	public static final String SBP= "Sbp";
	public static final String BREATH= "Breath";
	public static final String RESTING= "Resting";
	public static final String ACTIVE= "Active";
	public static final String ID_MAINPAINAREA= "Id_mainpainarea";
	public static final String SD_MAINPAINAREA= "Sd_mainpainarea";
	public static final String ID_PAINQUALITY= "Id_painquality";
	public static final String SD_PAINQUALITY= "Sd_painquality";
	public static final String ID_PAINADDCAUSE= "Id_painaddcause";
	public static final String SD_PAINADDCAUSE= "Sd_painaddcause";
	public static final String ID_SLEEPQUA= "Id_sleepqua";
	public static final String SD_SLEEPQUA= "Sd_sleepqua";
	public static final String CACATCHANGE= "Cacatchange";
	public static final String STOMTACH= "Stomtach";
	public static final String SWIRL= "Swirl";
	public static final String SICK= "Sick";
	public static final String VOMIT= "Vomit";
	public static final String SKINITCH= "Skinitch";
	public static final String DROWSINESS= "Drowsiness";
	public static final String BREATHCTR= "Breathctr";
	public static final String PAINTIME= "Paintime";
	public static final String OTHER= "Other";
	public static final String ID_ASSPSN= "Id_asspsn";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_MAINPAINAREA= "Name_mainpainarea";
	public static final String NAME_PAINQUALITY= "Name_painquality";
	public static final String NAME_PAINADDCAUSE= "Name_painaddcause";
	public static final String NAME_SLEEPQUA= "Name_sleepqua";
	public static final String NAME_ASSPSN= "Name_asspsn";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_pai() {
		return ((String) getAttrVal("Id_pai"));
	}	
	public void setId_pai(String Id_pai) {
		setAttrVal("Id_pai", Id_pai);
	}
	public String getId_pa() {
		return ((String) getAttrVal("Id_pa"));
	}	
	public void setId_pa(String Id_pa) {
		setAttrVal("Id_pa", Id_pa);
	}
	public FDateTime getDt_rec() {
		return ((FDateTime) getAttrVal("Dt_rec"));
	}	
	public void setDt_rec(FDateTime Dt_rec) {
		setAttrVal("Dt_rec", Dt_rec);
	}
	public FDouble getAdpi() {
		return ((FDouble) getAttrVal("Adpi"));
	}	
	public void setAdpi(FDouble Adpi) {
		setAttrVal("Adpi", Adpi);
	}
	public Integer getPulse() {
		return ((Integer) getAttrVal("Pulse"));
	}	
	public void setPulse(Integer Pulse) {
		setAttrVal("Pulse", Pulse);
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
	public Integer getBreath() {
		return ((Integer) getAttrVal("Breath"));
	}	
	public void setBreath(Integer Breath) {
		setAttrVal("Breath", Breath);
	}
	public Integer getResting() {
		return ((Integer) getAttrVal("Resting"));
	}	
	public void setResting(Integer Resting) {
		setAttrVal("Resting", Resting);
	}
	public Integer getActive() {
		return ((Integer) getAttrVal("Active"));
	}	
	public void setActive(Integer Active) {
		setAttrVal("Active", Active);
	}
	public String getId_mainpainarea() {
		return ((String) getAttrVal("Id_mainpainarea"));
	}	
	public void setId_mainpainarea(String Id_mainpainarea) {
		setAttrVal("Id_mainpainarea", Id_mainpainarea);
	}
	public String getSd_mainpainarea() {
		return ((String) getAttrVal("Sd_mainpainarea"));
	}	
	public void setSd_mainpainarea(String Sd_mainpainarea) {
		setAttrVal("Sd_mainpainarea", Sd_mainpainarea);
	}
	public String getId_painquality() {
		return ((String) getAttrVal("Id_painquality"));
	}	
	public void setId_painquality(String Id_painquality) {
		setAttrVal("Id_painquality", Id_painquality);
	}
	public String getSd_painquality() {
		return ((String) getAttrVal("Sd_painquality"));
	}	
	public void setSd_painquality(String Sd_painquality) {
		setAttrVal("Sd_painquality", Sd_painquality);
	}
	public String getId_painaddcause() {
		return ((String) getAttrVal("Id_painaddcause"));
	}	
	public void setId_painaddcause(String Id_painaddcause) {
		setAttrVal("Id_painaddcause", Id_painaddcause);
	}
	public String getSd_painaddcause() {
		return ((String) getAttrVal("Sd_painaddcause"));
	}	
	public void setSd_painaddcause(String Sd_painaddcause) {
		setAttrVal("Sd_painaddcause", Sd_painaddcause);
	}
	public String getId_sleepqua() {
		return ((String) getAttrVal("Id_sleepqua"));
	}	
	public void setId_sleepqua(String Id_sleepqua) {
		setAttrVal("Id_sleepqua", Id_sleepqua);
	}
	public String getSd_sleepqua() {
		return ((String) getAttrVal("Sd_sleepqua"));
	}	
	public void setSd_sleepqua(String Sd_sleepqua) {
		setAttrVal("Sd_sleepqua", Sd_sleepqua);
	}
	public Integer getCacatchange() {
		return ((Integer) getAttrVal("Cacatchange"));
	}	
	public void setCacatchange(Integer Cacatchange) {
		setAttrVal("Cacatchange", Cacatchange);
	}
	public Integer getStomtach() {
		return ((Integer) getAttrVal("Stomtach"));
	}	
	public void setStomtach(Integer Stomtach) {
		setAttrVal("Stomtach", Stomtach);
	}
	public Integer getSwirl() {
		return ((Integer) getAttrVal("Swirl"));
	}	
	public void setSwirl(Integer Swirl) {
		setAttrVal("Swirl", Swirl);
	}
	public Integer getSick() {
		return ((Integer) getAttrVal("Sick"));
	}	
	public void setSick(Integer Sick) {
		setAttrVal("Sick", Sick);
	}
	public Integer getVomit() {
		return ((Integer) getAttrVal("Vomit"));
	}	
	public void setVomit(Integer Vomit) {
		setAttrVal("Vomit", Vomit);
	}
	public Integer getSkinitch() {
		return ((Integer) getAttrVal("Skinitch"));
	}	
	public void setSkinitch(Integer Skinitch) {
		setAttrVal("Skinitch", Skinitch);
	}
	public Integer getDrowsiness() {
		return ((Integer) getAttrVal("Drowsiness"));
	}	
	public void setDrowsiness(Integer Drowsiness) {
		setAttrVal("Drowsiness", Drowsiness);
	}
	public Integer getBreathctr() {
		return ((Integer) getAttrVal("Breathctr"));
	}	
	public void setBreathctr(Integer Breathctr) {
		setAttrVal("Breathctr", Breathctr);
	}
	public Integer getPaintime() {
		return ((Integer) getAttrVal("Paintime"));
	}	
	public void setPaintime(Integer Paintime) {
		setAttrVal("Paintime", Paintime);
	}
	public String getOther() {
		return ((String) getAttrVal("Other"));
	}	
	public void setOther(String Other) {
		setAttrVal("Other", Other);
	}
	public String getId_asspsn() {
		return ((String) getAttrVal("Id_asspsn"));
	}	
	public void setId_asspsn(String Id_asspsn) {
		setAttrVal("Id_asspsn", Id_asspsn);
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
	public String getName_mainpainarea() {
		return ((String) getAttrVal("Name_mainpainarea"));
	}	
	public void setName_mainpainarea(String Name_mainpainarea) {
		setAttrVal("Name_mainpainarea", Name_mainpainarea);
	}
	public String getName_painquality() {
		return ((String) getAttrVal("Name_painquality"));
	}	
	public void setName_painquality(String Name_painquality) {
		setAttrVal("Name_painquality", Name_painquality);
	}
	public String getName_painaddcause() {
		return ((String) getAttrVal("Name_painaddcause"));
	}	
	public void setName_painaddcause(String Name_painaddcause) {
		setAttrVal("Name_painaddcause", Name_painaddcause);
	}
	public String getName_sleepqua() {
		return ((String) getAttrVal("Name_sleepqua"));
	}	
	public void setName_sleepqua(String Name_sleepqua) {
		setAttrVal("Name_sleepqua", Name_sleepqua);
	}
	public String getName_asspsn() {
		return ((String) getAttrVal("Name_asspsn"));
	}	
	public void setName_asspsn(String Name_asspsn) {
		setAttrVal("Name_asspsn", Name_asspsn);
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
		return "Id_pai";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_MR_NU_PAI";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PainAssessItmDODesc.class);
	}
	
}