package iih.ci.mr.nu.adl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.adl.d.desc.ADLDODesc;
import java.math.BigDecimal;

/**
 * ADL指数评估单 DO数据 
 * 
 */
public class ADLDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_ADL= "Id_adl";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_DEP_NUR= "Id_dep_nur";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_PAT= "Id_pat";
	public static final String CODE_ENTP= "Code_entp";
	public static final String ID_SEX= "Id_sex";
	public static final String SD_SEX= "Sd_sex";
	public static final String NAME_BED= "Name_bed";
	public static final String CODE_AMR_IP= "Code_amr_ip";
	public static final String AGE= "Age";
	public static final String DT_ENTRY= "Dt_entry";
	public static final String ID_TAKEFOOD= "Id_takefood";
	public static final String SD_TAKEFOOD= "Sd_takefood";
	public static final String SCO_TAKEFOOD= "Sco_takefood";
	public static final String ID_BATH= "Id_bath";
	public static final String SD_BATH= "Sd_bath";
	public static final String SCO_BATH= "Sco_bath";
	public static final String ID_BEDECK= "Id_bedeck";
	public static final String SD_BEDECK= "Sd_bedeck";
	public static final String SCO_BEDECK= "Sco_bedeck";
	public static final String ID_DRESS= "Id_dress";
	public static final String SD_DRESS= "Sd_dress";
	public static final String SCO_DRESS= "Sco_dress";
	public static final String ID_CTRFECES= "Id_ctrfeces";
	public static final String SD_CTRFECES= "Sd_ctrfeces";
	public static final String SCO_CTRFECES= "Sco_ctrfeces";
	public static final String ID_CTRPEE= "Id_ctrpee";
	public static final String SD_CTRPEE= "Sd_ctrpee";
	public static final String SCO_CTRPEE= "Sco_ctrpee";
	public static final String ID_DEFCATION= "Id_defcation";
	public static final String SD_DEFCATION= "Sd_defcation";
	public static final String SCO_DEFCATION= "Sco_defcation";
	public static final String ID_BEDBENTRAN= "Id_bedbentran";
	public static final String SD_BEDBENTRAN= "Sd_bedbentran";
	public static final String SCO_BEDBENTRAN= "Sco_bedbentran";
	public static final String ID_LEVTALK= "Id_levtalk";
	public static final String SD_LEVTALK= "Sd_levtalk";
	public static final String SCO_LEVTALK= "Sco_levtalk";
	public static final String ID_UPDOWNSTAIR= "Id_updownstair";
	public static final String SD_UPDOWNSTAIR= "Sd_updownstair";
	public static final String SCO_UPDOWNSTAIR= "Sco_updownstair";
	public static final String ASS_RESULT= "Ass_result";
	public static final String DT_ASS= "Dt_ass";
	public static final String ID_ASS_PSN= "Id_ass_psn";
	public static final String TOTALSCORE= "Totalscore";
	public static final String ID_LEVEL= "Id_level";
	public static final String SD_LEVEL= "Sd_level";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_DEP_NUR= "Name_dep_nur";
	public static final String NAME_PAT= "Name_pat";
	public static final String NAME_SEX= "Name_sex";
	public static final String NAME_TAKEFOOD= "Name_takefood";
	public static final String NAME_BATH= "Name_bath";
	public static final String NAME_BEDECK= "Name_bedeck";
	public static final String NAME_DRESS= "Name_dress";
	public static final String NAME_CTRFECES= "Name_ctrfeces";
	public static final String NAME_CTRPEE= "Name_ctrpee";
	public static final String NAME_DEFCATION= "Name_defcation";
	public static final String NAME_BEDBENTRAN= "Name_bedbentran";
	public static final String NAME_LEVTALK= "Name_levtalk";
	public static final String NAME_UPDOWNSTAIR= "Name_updownstair";
	public static final String NAME_ASS_PSN= "Name_ass_psn";
	public static final String NAME_LEVEL= "Name_level";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_adl() {
		return ((String) getAttrVal("Id_adl"));
	}	
	public void setId_adl(String Id_adl) {
		setAttrVal("Id_adl", Id_adl);
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
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}	
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}	
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	public String getId_sex() {
		return ((String) getAttrVal("Id_sex"));
	}	
	public void setId_sex(String Id_sex) {
		setAttrVal("Id_sex", Id_sex);
	}
	public String getSd_sex() {
		return ((String) getAttrVal("Sd_sex"));
	}	
	public void setSd_sex(String Sd_sex) {
		setAttrVal("Sd_sex", Sd_sex);
	}
	public String getName_bed() {
		return ((String) getAttrVal("Name_bed"));
	}	
	public void setName_bed(String Name_bed) {
		setAttrVal("Name_bed", Name_bed);
	}
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}	
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	public String getAge() {
		return ((String) getAttrVal("Age"));
	}	
	public void setAge(String Age) {
		setAttrVal("Age", Age);
	}
	public FDateTime getDt_entry() {
		return ((FDateTime) getAttrVal("Dt_entry"));
	}	
	public void setDt_entry(FDateTime Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	public String getId_takefood() {
		return ((String) getAttrVal("Id_takefood"));
	}	
	public void setId_takefood(String Id_takefood) {
		setAttrVal("Id_takefood", Id_takefood);
	}
	public String getSd_takefood() {
		return ((String) getAttrVal("Sd_takefood"));
	}	
	public void setSd_takefood(String Sd_takefood) {
		setAttrVal("Sd_takefood", Sd_takefood);
	}
	public FDouble getSco_takefood() {
		return ((FDouble) getAttrVal("Sco_takefood"));
	}	
	public void setSco_takefood(FDouble Sco_takefood) {
		setAttrVal("Sco_takefood", Sco_takefood);
	}
	public String getId_bath() {
		return ((String) getAttrVal("Id_bath"));
	}	
	public void setId_bath(String Id_bath) {
		setAttrVal("Id_bath", Id_bath);
	}
	public String getSd_bath() {
		return ((String) getAttrVal("Sd_bath"));
	}	
	public void setSd_bath(String Sd_bath) {
		setAttrVal("Sd_bath", Sd_bath);
	}
	public FDouble getSco_bath() {
		return ((FDouble) getAttrVal("Sco_bath"));
	}	
	public void setSco_bath(FDouble Sco_bath) {
		setAttrVal("Sco_bath", Sco_bath);
	}
	public String getId_bedeck() {
		return ((String) getAttrVal("Id_bedeck"));
	}	
	public void setId_bedeck(String Id_bedeck) {
		setAttrVal("Id_bedeck", Id_bedeck);
	}
	public String getSd_bedeck() {
		return ((String) getAttrVal("Sd_bedeck"));
	}	
	public void setSd_bedeck(String Sd_bedeck) {
		setAttrVal("Sd_bedeck", Sd_bedeck);
	}
	public FDouble getSco_bedeck() {
		return ((FDouble) getAttrVal("Sco_bedeck"));
	}	
	public void setSco_bedeck(FDouble Sco_bedeck) {
		setAttrVal("Sco_bedeck", Sco_bedeck);
	}
	public String getId_dress() {
		return ((String) getAttrVal("Id_dress"));
	}	
	public void setId_dress(String Id_dress) {
		setAttrVal("Id_dress", Id_dress);
	}
	public String getSd_dress() {
		return ((String) getAttrVal("Sd_dress"));
	}	
	public void setSd_dress(String Sd_dress) {
		setAttrVal("Sd_dress", Sd_dress);
	}
	public FDouble getSco_dress() {
		return ((FDouble) getAttrVal("Sco_dress"));
	}	
	public void setSco_dress(FDouble Sco_dress) {
		setAttrVal("Sco_dress", Sco_dress);
	}
	public String getId_ctrfeces() {
		return ((String) getAttrVal("Id_ctrfeces"));
	}	
	public void setId_ctrfeces(String Id_ctrfeces) {
		setAttrVal("Id_ctrfeces", Id_ctrfeces);
	}
	public String getSd_ctrfeces() {
		return ((String) getAttrVal("Sd_ctrfeces"));
	}	
	public void setSd_ctrfeces(String Sd_ctrfeces) {
		setAttrVal("Sd_ctrfeces", Sd_ctrfeces);
	}
	public FDouble getSco_ctrfeces() {
		return ((FDouble) getAttrVal("Sco_ctrfeces"));
	}	
	public void setSco_ctrfeces(FDouble Sco_ctrfeces) {
		setAttrVal("Sco_ctrfeces", Sco_ctrfeces);
	}
	public String getId_ctrpee() {
		return ((String) getAttrVal("Id_ctrpee"));
	}	
	public void setId_ctrpee(String Id_ctrpee) {
		setAttrVal("Id_ctrpee", Id_ctrpee);
	}
	public String getSd_ctrpee() {
		return ((String) getAttrVal("Sd_ctrpee"));
	}	
	public void setSd_ctrpee(String Sd_ctrpee) {
		setAttrVal("Sd_ctrpee", Sd_ctrpee);
	}
	public FDouble getSco_ctrpee() {
		return ((FDouble) getAttrVal("Sco_ctrpee"));
	}	
	public void setSco_ctrpee(FDouble Sco_ctrpee) {
		setAttrVal("Sco_ctrpee", Sco_ctrpee);
	}
	public String getId_defcation() {
		return ((String) getAttrVal("Id_defcation"));
	}	
	public void setId_defcation(String Id_defcation) {
		setAttrVal("Id_defcation", Id_defcation);
	}
	public String getSd_defcation() {
		return ((String) getAttrVal("Sd_defcation"));
	}	
	public void setSd_defcation(String Sd_defcation) {
		setAttrVal("Sd_defcation", Sd_defcation);
	}
	public FDouble getSco_defcation() {
		return ((FDouble) getAttrVal("Sco_defcation"));
	}	
	public void setSco_defcation(FDouble Sco_defcation) {
		setAttrVal("Sco_defcation", Sco_defcation);
	}
	public String getId_bedbentran() {
		return ((String) getAttrVal("Id_bedbentran"));
	}	
	public void setId_bedbentran(String Id_bedbentran) {
		setAttrVal("Id_bedbentran", Id_bedbentran);
	}
	public String getSd_bedbentran() {
		return ((String) getAttrVal("Sd_bedbentran"));
	}	
	public void setSd_bedbentran(String Sd_bedbentran) {
		setAttrVal("Sd_bedbentran", Sd_bedbentran);
	}
	public FDouble getSco_bedbentran() {
		return ((FDouble) getAttrVal("Sco_bedbentran"));
	}	
	public void setSco_bedbentran(FDouble Sco_bedbentran) {
		setAttrVal("Sco_bedbentran", Sco_bedbentran);
	}
	public String getId_levtalk() {
		return ((String) getAttrVal("Id_levtalk"));
	}	
	public void setId_levtalk(String Id_levtalk) {
		setAttrVal("Id_levtalk", Id_levtalk);
	}
	public String getSd_levtalk() {
		return ((String) getAttrVal("Sd_levtalk"));
	}	
	public void setSd_levtalk(String Sd_levtalk) {
		setAttrVal("Sd_levtalk", Sd_levtalk);
	}
	public FDouble getSco_levtalk() {
		return ((FDouble) getAttrVal("Sco_levtalk"));
	}	
	public void setSco_levtalk(FDouble Sco_levtalk) {
		setAttrVal("Sco_levtalk", Sco_levtalk);
	}
	public String getId_updownstair() {
		return ((String) getAttrVal("Id_updownstair"));
	}	
	public void setId_updownstair(String Id_updownstair) {
		setAttrVal("Id_updownstair", Id_updownstair);
	}
	public String getSd_updownstair() {
		return ((String) getAttrVal("Sd_updownstair"));
	}	
	public void setSd_updownstair(String Sd_updownstair) {
		setAttrVal("Sd_updownstair", Sd_updownstair);
	}
	public FDouble getSco_updownstair() {
		return ((FDouble) getAttrVal("Sco_updownstair"));
	}	
	public void setSco_updownstair(FDouble Sco_updownstair) {
		setAttrVal("Sco_updownstair", Sco_updownstair);
	}
	public String getAss_result() {
		return ((String) getAttrVal("Ass_result"));
	}	
	public void setAss_result(String Ass_result) {
		setAttrVal("Ass_result", Ass_result);
	}
	public FDateTime getDt_ass() {
		return ((FDateTime) getAttrVal("Dt_ass"));
	}	
	public void setDt_ass(FDateTime Dt_ass) {
		setAttrVal("Dt_ass", Dt_ass);
	}
	public String getId_ass_psn() {
		return ((String) getAttrVal("Id_ass_psn"));
	}	
	public void setId_ass_psn(String Id_ass_psn) {
		setAttrVal("Id_ass_psn", Id_ass_psn);
	}
	public FDouble getTotalscore() {
		return ((FDouble) getAttrVal("Totalscore"));
	}	
	public void setTotalscore(FDouble Totalscore) {
		setAttrVal("Totalscore", Totalscore);
	}
	public String getId_level() {
		return ((String) getAttrVal("Id_level"));
	}	
	public void setId_level(String Id_level) {
		setAttrVal("Id_level", Id_level);
	}
	public String getSd_level() {
		return ((String) getAttrVal("Sd_level"));
	}	
	public void setSd_level(String Sd_level) {
		setAttrVal("Sd_level", Sd_level);
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
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}	
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
	}
	public String getName_takefood() {
		return ((String) getAttrVal("Name_takefood"));
	}	
	public void setName_takefood(String Name_takefood) {
		setAttrVal("Name_takefood", Name_takefood);
	}
	public String getName_bath() {
		return ((String) getAttrVal("Name_bath"));
	}	
	public void setName_bath(String Name_bath) {
		setAttrVal("Name_bath", Name_bath);
	}
	public String getName_bedeck() {
		return ((String) getAttrVal("Name_bedeck"));
	}	
	public void setName_bedeck(String Name_bedeck) {
		setAttrVal("Name_bedeck", Name_bedeck);
	}
	public String getName_dress() {
		return ((String) getAttrVal("Name_dress"));
	}	
	public void setName_dress(String Name_dress) {
		setAttrVal("Name_dress", Name_dress);
	}
	public String getName_ctrfeces() {
		return ((String) getAttrVal("Name_ctrfeces"));
	}	
	public void setName_ctrfeces(String Name_ctrfeces) {
		setAttrVal("Name_ctrfeces", Name_ctrfeces);
	}
	public String getName_ctrpee() {
		return ((String) getAttrVal("Name_ctrpee"));
	}	
	public void setName_ctrpee(String Name_ctrpee) {
		setAttrVal("Name_ctrpee", Name_ctrpee);
	}
	public String getName_defcation() {
		return ((String) getAttrVal("Name_defcation"));
	}	
	public void setName_defcation(String Name_defcation) {
		setAttrVal("Name_defcation", Name_defcation);
	}
	public String getName_bedbentran() {
		return ((String) getAttrVal("Name_bedbentran"));
	}	
	public void setName_bedbentran(String Name_bedbentran) {
		setAttrVal("Name_bedbentran", Name_bedbentran);
	}
	public String getName_levtalk() {
		return ((String) getAttrVal("Name_levtalk"));
	}	
	public void setName_levtalk(String Name_levtalk) {
		setAttrVal("Name_levtalk", Name_levtalk);
	}
	public String getName_updownstair() {
		return ((String) getAttrVal("Name_updownstair"));
	}	
	public void setName_updownstair(String Name_updownstair) {
		setAttrVal("Name_updownstair", Name_updownstair);
	}
	public String getName_ass_psn() {
		return ((String) getAttrVal("Name_ass_psn"));
	}	
	public void setName_ass_psn(String Name_ass_psn) {
		setAttrVal("Name_ass_psn", Name_ass_psn);
	}
	public String getName_level() {
		return ((String) getAttrVal("Name_level"));
	}	
	public void setName_level(String Name_level) {
		setAttrVal("Name_level", Name_level);
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
		return "Id_adl";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_MR_NU_ADL";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ADLDODesc.class);
	}
	
}