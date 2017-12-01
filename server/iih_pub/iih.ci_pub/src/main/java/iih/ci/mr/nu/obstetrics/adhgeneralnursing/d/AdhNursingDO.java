package iih.ci.mr.nu.obstetrics.adhgeneralnursing.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.obstetrics.adhgeneralnursing.d.desc.AdhNursingDODesc;
import java.math.BigDecimal;

/**
 * 产科护理观察记录主实体 DO数据 
 * 
 */
public class AdhNursingDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_ADHNR= "Id_adhnr";
	public static final String ID_DEP_PHY= "Id_dep_phy";
	public static final String ID_DEP_NUR= "Id_dep_nur";
	public static final String NAME_BED= "Name_bed";
	public static final String ID_PAT= "Id_pat";
	public static final String ID_ENT= "Id_ent";
	public static final String AGE= "Age";
	public static final String CODE_AMR_IP= "Code_amr_ip";
	public static final String DT_ENTRY= "Dt_entry";
	public static final String NAME_DIAGNOSIS= "Name_diagnosis";
	public static final String ID_HOSWAY= "Id_hosway";
	public static final String SD_HOSWAY= "Sd_hosway";
	public static final String NAME_ALLERGY= "Name_allergy";
	public static final String ID_HBSAG= "Id_hbsag";
	public static final String SD_HBSAG= "Sd_hbsag";
	public static final String ID_HBS= "Id_hbs";
	public static final String SD_HBS= "Sd_hbs";
	public static final String ID_HBEAG= "Id_hbeag";
	public static final String SD_HBEAG= "Sd_hbeag";
	public static final String ID_HBE= "Id_hbe";
	public static final String SD_HBE= "Sd_hbe";
	public static final String ID_HBC= "Id_hbc";
	public static final String SD_HBC= "Sd_hbc";
	public static final String ID_HCV= "Id_hcv";
	public static final String SD_HCV= "Sd_hcv";
	public static final String ID_HIV= "Id_hiv";
	public static final String SD_HIV= "Sd_hiv";
	public static final String ID_NUR_LEVEL= "Id_nur_level";
	public static final String SD_NUR_LEVEL= "Sd_nur_level";
	public static final String ACTIVITY= "Activity";
	public static final String ID_SIGN= "Id_sign";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_DEP_PHY= "Name_dep_phy";
	public static final String NAME_DEP_NUR= "Name_dep_nur";
	public static final String NAME_PAT= "Name_pat";
	public static final String NAME_HOSWAY= "Name_hosway";
	public static final String NAME_HBSAG= "Name_hbsag";
	public static final String NAME_HBS= "Name_hbs";
	public static final String NAME_HBEAG= "Name_hbeag";
	public static final String NAME_HBE= "Name_hbe";
	public static final String NAME_HBC= "Name_hbc";
	public static final String NAME_HCV= "Name_hcv";
	public static final String NAME_HIV= "Name_hiv";
	public static final String NAME_NUR_LEVEL= "Name_nur_level";
	public static final String NAME_SIGN= "Name_sign";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_adhnr() {
		return ((String) getAttrVal("Id_adhnr"));
	}	
	public void setId_adhnr(String Id_adhnr) {
		setAttrVal("Id_adhnr", Id_adhnr);
	}
	public String getId_dep_phy() {
		return ((String) getAttrVal("Id_dep_phy"));
	}	
	public void setId_dep_phy(String Id_dep_phy) {
		setAttrVal("Id_dep_phy", Id_dep_phy);
	}
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}	
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	public String getName_bed() {
		return ((String) getAttrVal("Name_bed"));
	}	
	public void setName_bed(String Name_bed) {
		setAttrVal("Name_bed", Name_bed);
	}
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	public String getAge() {
		return ((String) getAttrVal("Age"));
	}	
	public void setAge(String Age) {
		setAttrVal("Age", Age);
	}
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}	
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	public FDateTime getDt_entry() {
		return ((FDateTime) getAttrVal("Dt_entry"));
	}	
	public void setDt_entry(FDateTime Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	public String getName_diagnosis() {
		return ((String) getAttrVal("Name_diagnosis"));
	}	
	public void setName_diagnosis(String Name_diagnosis) {
		setAttrVal("Name_diagnosis", Name_diagnosis);
	}
	public String getId_hosway() {
		return ((String) getAttrVal("Id_hosway"));
	}	
	public void setId_hosway(String Id_hosway) {
		setAttrVal("Id_hosway", Id_hosway);
	}
	public String getSd_hosway() {
		return ((String) getAttrVal("Sd_hosway"));
	}	
	public void setSd_hosway(String Sd_hosway) {
		setAttrVal("Sd_hosway", Sd_hosway);
	}
	public String getName_allergy() {
		return ((String) getAttrVal("Name_allergy"));
	}	
	public void setName_allergy(String Name_allergy) {
		setAttrVal("Name_allergy", Name_allergy);
	}
	public String getId_hbsag() {
		return ((String) getAttrVal("Id_hbsag"));
	}	
	public void setId_hbsag(String Id_hbsag) {
		setAttrVal("Id_hbsag", Id_hbsag);
	}
	public String getSd_hbsag() {
		return ((String) getAttrVal("Sd_hbsag"));
	}	
	public void setSd_hbsag(String Sd_hbsag) {
		setAttrVal("Sd_hbsag", Sd_hbsag);
	}
	public String getId_hbs() {
		return ((String) getAttrVal("Id_hbs"));
	}	
	public void setId_hbs(String Id_hbs) {
		setAttrVal("Id_hbs", Id_hbs);
	}
	public String getSd_hbs() {
		return ((String) getAttrVal("Sd_hbs"));
	}	
	public void setSd_hbs(String Sd_hbs) {
		setAttrVal("Sd_hbs", Sd_hbs);
	}
	public String getId_hbeag() {
		return ((String) getAttrVal("Id_hbeag"));
	}	
	public void setId_hbeag(String Id_hbeag) {
		setAttrVal("Id_hbeag", Id_hbeag);
	}
	public String getSd_hbeag() {
		return ((String) getAttrVal("Sd_hbeag"));
	}	
	public void setSd_hbeag(String Sd_hbeag) {
		setAttrVal("Sd_hbeag", Sd_hbeag);
	}
	public String getId_hbe() {
		return ((String) getAttrVal("Id_hbe"));
	}	
	public void setId_hbe(String Id_hbe) {
		setAttrVal("Id_hbe", Id_hbe);
	}
	public String getSd_hbe() {
		return ((String) getAttrVal("Sd_hbe"));
	}	
	public void setSd_hbe(String Sd_hbe) {
		setAttrVal("Sd_hbe", Sd_hbe);
	}
	public String getId_hbc() {
		return ((String) getAttrVal("Id_hbc"));
	}	
	public void setId_hbc(String Id_hbc) {
		setAttrVal("Id_hbc", Id_hbc);
	}
	public String getSd_hbc() {
		return ((String) getAttrVal("Sd_hbc"));
	}	
	public void setSd_hbc(String Sd_hbc) {
		setAttrVal("Sd_hbc", Sd_hbc);
	}
	public String getId_hcv() {
		return ((String) getAttrVal("Id_hcv"));
	}	
	public void setId_hcv(String Id_hcv) {
		setAttrVal("Id_hcv", Id_hcv);
	}
	public String getSd_hcv() {
		return ((String) getAttrVal("Sd_hcv"));
	}	
	public void setSd_hcv(String Sd_hcv) {
		setAttrVal("Sd_hcv", Sd_hcv);
	}
	public String getId_hiv() {
		return ((String) getAttrVal("Id_hiv"));
	}	
	public void setId_hiv(String Id_hiv) {
		setAttrVal("Id_hiv", Id_hiv);
	}
	public String getSd_hiv() {
		return ((String) getAttrVal("Sd_hiv"));
	}	
	public void setSd_hiv(String Sd_hiv) {
		setAttrVal("Sd_hiv", Sd_hiv);
	}
	public String getId_nur_level() {
		return ((String) getAttrVal("Id_nur_level"));
	}	
	public void setId_nur_level(String Id_nur_level) {
		setAttrVal("Id_nur_level", Id_nur_level);
	}
	public String getSd_nur_level() {
		return ((String) getAttrVal("Sd_nur_level"));
	}	
	public void setSd_nur_level(String Sd_nur_level) {
		setAttrVal("Sd_nur_level", Sd_nur_level);
	}
	public String getActivity() {
		return ((String) getAttrVal("Activity"));
	}	
	public void setActivity(String Activity) {
		setAttrVal("Activity", Activity);
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
	public String getName_dep_phy() {
		return ((String) getAttrVal("Name_dep_phy"));
	}	
	public void setName_dep_phy(String Name_dep_phy) {
		setAttrVal("Name_dep_phy", Name_dep_phy);
	}
	public String getName_dep_nur() {
		return ((String) getAttrVal("Name_dep_nur"));
	}	
	public void setName_dep_nur(String Name_dep_nur) {
		setAttrVal("Name_dep_nur", Name_dep_nur);
	}
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	public String getName_hosway() {
		return ((String) getAttrVal("Name_hosway"));
	}	
	public void setName_hosway(String Name_hosway) {
		setAttrVal("Name_hosway", Name_hosway);
	}
	public String getName_hbsag() {
		return ((String) getAttrVal("Name_hbsag"));
	}	
	public void setName_hbsag(String Name_hbsag) {
		setAttrVal("Name_hbsag", Name_hbsag);
	}
	public String getName_hbs() {
		return ((String) getAttrVal("Name_hbs"));
	}	
	public void setName_hbs(String Name_hbs) {
		setAttrVal("Name_hbs", Name_hbs);
	}
	public String getName_hbeag() {
		return ((String) getAttrVal("Name_hbeag"));
	}	
	public void setName_hbeag(String Name_hbeag) {
		setAttrVal("Name_hbeag", Name_hbeag);
	}
	public String getName_hbe() {
		return ((String) getAttrVal("Name_hbe"));
	}	
	public void setName_hbe(String Name_hbe) {
		setAttrVal("Name_hbe", Name_hbe);
	}
	public String getName_hbc() {
		return ((String) getAttrVal("Name_hbc"));
	}	
	public void setName_hbc(String Name_hbc) {
		setAttrVal("Name_hbc", Name_hbc);
	}
	public String getName_hcv() {
		return ((String) getAttrVal("Name_hcv"));
	}	
	public void setName_hcv(String Name_hcv) {
		setAttrVal("Name_hcv", Name_hcv);
	}
	public String getName_hiv() {
		return ((String) getAttrVal("Name_hiv"));
	}	
	public void setName_hiv(String Name_hiv) {
		setAttrVal("Name_hiv", Name_hiv);
	}
	public String getName_nur_level() {
		return ((String) getAttrVal("Name_nur_level"));
	}	
	public void setName_nur_level(String Name_nur_level) {
		setAttrVal("Name_nur_level", Name_nur_level);
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
		return "Id_adhnr";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_Mr_NU_ADHNR";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(AdhNursingDODesc.class);
	}
	
}