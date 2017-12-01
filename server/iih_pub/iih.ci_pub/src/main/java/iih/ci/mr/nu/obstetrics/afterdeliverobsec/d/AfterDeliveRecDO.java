package iih.ci.mr.nu.obstetrics.afterdeliverobsec.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.obstetrics.afterdeliverobsec.d.desc.AfterDeliveRecDODesc;
import java.math.BigDecimal;

/**
 * 产后观察记录 DO数据 
 * 
 */
public class AfterDeliveRecDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_AFTDEREC= "Id_aftderec";
	public static final String ID_AFTDEINFO= "Id_aftdeinfo";
	public static final String ID_AFTERDEDT= "Id_afterdedt";
	public static final String SD_AFTERDEDT= "Sd_afterdedt";
	public static final String SBP= "Sbp";
	public static final String DBP= "Dbp";
	public static final String PULSE= "Pulse";
	public static final String SPO= "Spo";
	public static final String ID_FUNDUS= "Id_fundus";
	public static final String SD_FUNDUS= "Sd_fundus";
	public static final String BLEEDVOLUME= "Bleedvolume";
	public static final String ID_BLADFILL= "Id_bladfill";
	public static final String SD_BLADFILL= "Sd_bladfill";
	public static final String ID_NEWBORNCOND= "Id_newborncond";
	public static final String SD_NEWBORNCOND= "Sd_newborncond";
	public static final String ID_SIGN_PSN= "Id_sign_psn";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_AFTERDEDT= "Name_afterdedt";
	public static final String NAME_FUNDUS= "Name_fundus";
	public static final String NAME_BLADFILL= "Name_bladfill";
	public static final String NAME_NEWBORNCOND= "Name_newborncond";
	public static final String NAME_SIGN_PSN= "Name_sign_psn";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_aftderec() {
		return ((String) getAttrVal("Id_aftderec"));
	}	
	public void setId_aftderec(String Id_aftderec) {
		setAttrVal("Id_aftderec", Id_aftderec);
	}
	public String getId_aftdeinfo() {
		return ((String) getAttrVal("Id_aftdeinfo"));
	}	
	public void setId_aftdeinfo(String Id_aftdeinfo) {
		setAttrVal("Id_aftdeinfo", Id_aftdeinfo);
	}
	public String getId_afterdedt() {
		return ((String) getAttrVal("Id_afterdedt"));
	}	
	public void setId_afterdedt(String Id_afterdedt) {
		setAttrVal("Id_afterdedt", Id_afterdedt);
	}
	public String getSd_afterdedt() {
		return ((String) getAttrVal("Sd_afterdedt"));
	}	
	public void setSd_afterdedt(String Sd_afterdedt) {
		setAttrVal("Sd_afterdedt", Sd_afterdedt);
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
	public Integer getPulse() {
		return ((Integer) getAttrVal("Pulse"));
	}	
	public void setPulse(Integer Pulse) {
		setAttrVal("Pulse", Pulse);
	}
	public FDouble getSpo() {
		return ((FDouble) getAttrVal("Spo"));
	}	
	public void setSpo(FDouble Spo) {
		setAttrVal("Spo", Spo);
	}
	public String getId_fundus() {
		return ((String) getAttrVal("Id_fundus"));
	}	
	public void setId_fundus(String Id_fundus) {
		setAttrVal("Id_fundus", Id_fundus);
	}
	public String getSd_fundus() {
		return ((String) getAttrVal("Sd_fundus"));
	}	
	public void setSd_fundus(String Sd_fundus) {
		setAttrVal("Sd_fundus", Sd_fundus);
	}
	public Integer getBleedvolume() {
		return ((Integer) getAttrVal("Bleedvolume"));
	}	
	public void setBleedvolume(Integer Bleedvolume) {
		setAttrVal("Bleedvolume", Bleedvolume);
	}
	public String getId_bladfill() {
		return ((String) getAttrVal("Id_bladfill"));
	}	
	public void setId_bladfill(String Id_bladfill) {
		setAttrVal("Id_bladfill", Id_bladfill);
	}
	public String getSd_bladfill() {
		return ((String) getAttrVal("Sd_bladfill"));
	}	
	public void setSd_bladfill(String Sd_bladfill) {
		setAttrVal("Sd_bladfill", Sd_bladfill);
	}
	public String getId_newborncond() {
		return ((String) getAttrVal("Id_newborncond"));
	}	
	public void setId_newborncond(String Id_newborncond) {
		setAttrVal("Id_newborncond", Id_newborncond);
	}
	public String getSd_newborncond() {
		return ((String) getAttrVal("Sd_newborncond"));
	}	
	public void setSd_newborncond(String Sd_newborncond) {
		setAttrVal("Sd_newborncond", Sd_newborncond);
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
	public String getName_afterdedt() {
		return ((String) getAttrVal("Name_afterdedt"));
	}	
	public void setName_afterdedt(String Name_afterdedt) {
		setAttrVal("Name_afterdedt", Name_afterdedt);
	}
	public String getName_fundus() {
		return ((String) getAttrVal("Name_fundus"));
	}	
	public void setName_fundus(String Name_fundus) {
		setAttrVal("Name_fundus", Name_fundus);
	}
	public String getName_bladfill() {
		return ((String) getAttrVal("Name_bladfill"));
	}	
	public void setName_bladfill(String Name_bladfill) {
		setAttrVal("Name_bladfill", Name_bladfill);
	}
	public String getName_newborncond() {
		return ((String) getAttrVal("Name_newborncond"));
	}	
	public void setName_newborncond(String Name_newborncond) {
		setAttrVal("Name_newborncond", Name_newborncond);
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
		return "Id_aftderec";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_MR_NU_AFTDEREC";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(AfterDeliveRecDODesc.class);
	}
	
}