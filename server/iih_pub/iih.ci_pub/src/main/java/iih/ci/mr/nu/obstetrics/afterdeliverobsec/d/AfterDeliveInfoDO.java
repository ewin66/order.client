package iih.ci.mr.nu.obstetrics.afterdeliverobsec.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.obstetrics.afterdeliverobsec.d.desc.AfterDeliveInfoDODesc;
import java.math.BigDecimal;

/**
 * 产后观察患者信息 DO数据 
 * 
 */
public class AfterDeliveInfoDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_AFTDEINFO= "Id_aftdeinfo";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_PAT= "Id_pat";
	public static final String ID_ENT= "Id_ent";
	public static final String CODE_ENTP= "Code_entp";
	public static final String AGE= "Age";
	public static final String NAME_BED= "Name_bed";
	public static final String ID_DEP_NUR= "Id_dep_nur";
	public static final String CODE_AMR_IP= "Code_amr_ip";
	public static final String DT_BEGIN_PER= "Dt_begin_per";
	public static final String DT_END_PER= "Dt_end_per";
	public static final String ID_PAPILLACOND= "Id_papillacond";
	public static final String SD_PAPILLACOND= "Sd_papillacond";
	public static final String DT_SKINTOUCH= "Dt_skintouch";
	public static final String SKINTOUCH_TIME= "Skintouch_time";
	public static final String DT_FORAGE= "Dt_forage";
	public static final String DT_SUCK= "Dt_suck";
	public static final String TIME_SUCK= "Time_suck";
	public static final String ID_SUCK_COND= "Id_suck_cond";
	public static final String SD_SUCK_COND= "Sd_suck_cond";
	public static final String ACCIDENTDESC= "Accidentdesc";
	public static final String ID_SIGN_PSN= "Id_sign_psn";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_PAT= "Name_pat";
	public static final String NAME_DEP_NUR= "Name_dep_nur";
	public static final String NAME_PAPILLACOND= "Name_papillacond";
	public static final String NAME_SUCK_COND= "Name_suck_cond";
	public static final String NAME_SIGN_PSN= "Name_sign_psn";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_aftdeinfo() {
		return ((String) getAttrVal("Id_aftdeinfo"));
	}	
	public void setId_aftdeinfo(String Id_aftdeinfo) {
		setAttrVal("Id_aftdeinfo", Id_aftdeinfo);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
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
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}	
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	public String getAge() {
		return ((String) getAttrVal("Age"));
	}	
	public void setAge(String Age) {
		setAttrVal("Age", Age);
	}
	public String getName_bed() {
		return ((String) getAttrVal("Name_bed"));
	}	
	public void setName_bed(String Name_bed) {
		setAttrVal("Name_bed", Name_bed);
	}
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}	
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}	
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	public FDateTime getDt_begin_per() {
		return ((FDateTime) getAttrVal("Dt_begin_per"));
	}	
	public void setDt_begin_per(FDateTime Dt_begin_per) {
		setAttrVal("Dt_begin_per", Dt_begin_per);
	}
	public FDateTime getDt_end_per() {
		return ((FDateTime) getAttrVal("Dt_end_per"));
	}	
	public void setDt_end_per(FDateTime Dt_end_per) {
		setAttrVal("Dt_end_per", Dt_end_per);
	}
	public String getId_papillacond() {
		return ((String) getAttrVal("Id_papillacond"));
	}	
	public void setId_papillacond(String Id_papillacond) {
		setAttrVal("Id_papillacond", Id_papillacond);
	}
	public String getSd_papillacond() {
		return ((String) getAttrVal("Sd_papillacond"));
	}	
	public void setSd_papillacond(String Sd_papillacond) {
		setAttrVal("Sd_papillacond", Sd_papillacond);
	}
	public Integer getDt_skintouch() {
		return ((Integer) getAttrVal("Dt_skintouch"));
	}	
	public void setDt_skintouch(Integer Dt_skintouch) {
		setAttrVal("Dt_skintouch", Dt_skintouch);
	}
	public Integer getSkintouch_time() {
		return ((Integer) getAttrVal("Skintouch_time"));
	}	
	public void setSkintouch_time(Integer Skintouch_time) {
		setAttrVal("Skintouch_time", Skintouch_time);
	}
	public Integer getDt_forage() {
		return ((Integer) getAttrVal("Dt_forage"));
	}	
	public void setDt_forage(Integer Dt_forage) {
		setAttrVal("Dt_forage", Dt_forage);
	}
	public Integer getDt_suck() {
		return ((Integer) getAttrVal("Dt_suck"));
	}	
	public void setDt_suck(Integer Dt_suck) {
		setAttrVal("Dt_suck", Dt_suck);
	}
	public Integer getTime_suck() {
		return ((Integer) getAttrVal("Time_suck"));
	}	
	public void setTime_suck(Integer Time_suck) {
		setAttrVal("Time_suck", Time_suck);
	}
	public String getId_suck_cond() {
		return ((String) getAttrVal("Id_suck_cond"));
	}	
	public void setId_suck_cond(String Id_suck_cond) {
		setAttrVal("Id_suck_cond", Id_suck_cond);
	}
	public String getSd_suck_cond() {
		return ((String) getAttrVal("Sd_suck_cond"));
	}	
	public void setSd_suck_cond(String Sd_suck_cond) {
		setAttrVal("Sd_suck_cond", Sd_suck_cond);
	}
	public String getAccidentdesc() {
		return ((String) getAttrVal("Accidentdesc"));
	}	
	public void setAccidentdesc(String Accidentdesc) {
		setAttrVal("Accidentdesc", Accidentdesc);
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
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	public String getName_dep_nur() {
		return ((String) getAttrVal("Name_dep_nur"));
	}	
	public void setName_dep_nur(String Name_dep_nur) {
		setAttrVal("Name_dep_nur", Name_dep_nur);
	}
	public String getName_papillacond() {
		return ((String) getAttrVal("Name_papillacond"));
	}	
	public void setName_papillacond(String Name_papillacond) {
		setAttrVal("Name_papillacond", Name_papillacond);
	}
	public String getName_suck_cond() {
		return ((String) getAttrVal("Name_suck_cond"));
	}	
	public void setName_suck_cond(String Name_suck_cond) {
		setAttrVal("Name_suck_cond", Name_suck_cond);
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
		return "Id_aftdeinfo";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_MR_NU_AFTDEINFO";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(AfterDeliveInfoDODesc.class);
	}
	
}