package iih.ci.mr.nu.obstetrics.gymissabort.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.obstetrics.gymissabort.d.desc.GyMissAbortAssDODesc;
import java.math.BigDecimal;

/**
 * 评估单 DO数据 
 * 
 */
public class GyMissAbortAssDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_ASS= "Id_ass";
	public static final String ID_PAT= "Id_pat";
	public static final String ID_ENT= "Id_ent";
	public static final String CODE_ENTP= "Code_entp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String AGE= "Age";
	public static final String CODE_AMR_IP= "Code_amr_ip";
	public static final String NAME_BED= "Name_bed";
	public static final String DT_ENTRY= "Dt_entry";
	public static final String ID_ENTRY_WAY= "Id_entry_way";
	public static final String SD_ENTRY_WAY= "Sd_entry_way";
	public static final String NAME_DIAGNOSIS= "Name_diagnosis";
	public static final String EU_PASTMEDIC= "Eu_pastmedic";
	public static final String ID_HBSAG= "Id_hbsag";
	public static final String SD_HBSAG= "Sd_hbsag";
	public static final String BLOODWBC= "Bloodwbc";
	public static final String HB= "Hb";
	public static final String BLOODTYPE= "Bloodtype";
	public static final String BLOODHCG= "Bloodhcg";
	public static final String ID_SECRETA= "Id_secreta";
	public static final String SD_SECRETA= "Sd_secreta";
	public static final String ID_LEUKORRHEA= "Id_leukorrhea";
	public static final String SD_LEUKORRHEA= "Sd_leukorrhea";
	public static final String EU_VAGINA_BLOOD= "Eu_vagina_blood";
	public static final String ID_VAGINA_BLOOD= "Id_vagina_blood";
	public static final String SD_VAGINA_BLOOD= "Sd_vagina_blood";
	public static final String EU_BELLYACHE= "Eu_bellyache";
	public static final String ID_NUR_LEVEL= "Id_nur_level";
	public static final String SD_NUR_LEVEL= "Sd_nur_level";
	public static final String ID_ASSENTRY_PSN= "Id_assentry_psn";
	public static final String ID_LABOURWAY= "Id_labourway";
	public static final String SD_LABOURWAY= "Sd_labourway";
	public static final String DT_LABOUR= "Dt_labour";
	public static final String DT_DELIVER= "Dt_deliver";
	public static final String DT_BACKROOM= "Dt_backroom";
	public static final String ID_DELIVERWAY= "Id_deliverway";
	public static final String SD_DELIVERWAY= "Sd_deliverway";
	public static final String ID_URINATECOND= "Id_urinatecond";
	public static final String SD_URINATECOND= "Sd_urinatecond";
	public static final String ID_ASSDELIVER_PSN= "Id_assdeliver_psn";
	public static final String DT_OPERAT= "Dt_operat";
	public static final String EU_HOCUSWAY= "Eu_hocusway";
	public static final String ID_HOCUSWAY= "Id_hocusway";
	public static final String SD_HOCUSWAY= "Sd_hocusway";
	public static final String HOCUSWAYOTHER= "Hocuswayother";
	public static final String EU_SPECASE= "Eu_specase";
	public static final String OPERATBLOOD= "Operatblood";
	public static final String EU_KEEPCATH= "Eu_keepcath";
	public static final String ID_SPECASE_PSN= "Id_specase_psn";
	public static final String ID_URINATECOND_OPER= "Id_urinatecond_oper";
	public static final String SD_URINATECOND_OPER= "Sd_urinatecond_oper";
	public static final String ID_OPER_PSN= "Id_oper_psn";
	public static final String DT_OUTHOS= "Dt_outhos";
	public static final String ID_ASSOPER_PSN= "Id_assoper_psn";
	public static final String NAME_PAT= "Name_pat";
	public static final String NAME_ENTRY_WAY= "Name_entry_way";
	public static final String NAME_HBSAG= "Name_hbsag";
	public static final String NAME_SECRETA= "Name_secreta";
	public static final String NAME_LEUKORRHEA= "Name_leukorrhea";
	public static final String NAME_VAGINA_BLOOD= "Name_vagina_blood";
	public static final String NAME_NUR_LEVEL= "Name_nur_level";
	public static final String NAME_ASSENTRY_PSN= "Name_assentry_psn";
	public static final String NAME_LABOURWAY= "Name_labourway";
	public static final String NAME_DELIVERWAY= "Name_deliverway";
	public static final String NAME_URINATECOND= "Name_urinatecond";
	public static final String NAME_ASSDELIVER_PSN= "Name_assdeliver_psn";
	public static final String NAME_HOCUSWAY= "Name_hocusway";
	public static final String NAME_SPECASE_PSN= "Name_specase_psn";
	public static final String NAME_URINATECOND_OPER= "Name_urinatecond_oper";
	public static final String NAME_SSHSCPNQ= "Name_sshscpnq";
	public static final String NAME_ASSOPER_PSN= "Name_assoper_psn";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_ass() {
		return ((String) getAttrVal("Id_ass"));
	}	
	public void setId_ass(String Id_ass) {
		setAttrVal("Id_ass", Id_ass);
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
	public String getName_bed() {
		return ((String) getAttrVal("Name_bed"));
	}	
	public void setName_bed(String Name_bed) {
		setAttrVal("Name_bed", Name_bed);
	}
	public FDateTime getDt_entry() {
		return ((FDateTime) getAttrVal("Dt_entry"));
	}	
	public void setDt_entry(FDateTime Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	public String getId_entry_way() {
		return ((String) getAttrVal("Id_entry_way"));
	}	
	public void setId_entry_way(String Id_entry_way) {
		setAttrVal("Id_entry_way", Id_entry_way);
	}
	public String getSd_entry_way() {
		return ((String) getAttrVal("Sd_entry_way"));
	}	
	public void setSd_entry_way(String Sd_entry_way) {
		setAttrVal("Sd_entry_way", Sd_entry_way);
	}
	public String getName_diagnosis() {
		return ((String) getAttrVal("Name_diagnosis"));
	}	
	public void setName_diagnosis(String Name_diagnosis) {
		setAttrVal("Name_diagnosis", Name_diagnosis);
	}
	public Integer getEu_pastmedic() {
		return ((Integer) getAttrVal("Eu_pastmedic"));
	}	
	public void setEu_pastmedic(Integer Eu_pastmedic) {
		setAttrVal("Eu_pastmedic", Eu_pastmedic);
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
	public FDouble getBloodwbc() {
		return ((FDouble) getAttrVal("Bloodwbc"));
	}	
	public void setBloodwbc(FDouble Bloodwbc) {
		setAttrVal("Bloodwbc", Bloodwbc);
	}
	public FDouble getHb() {
		return ((FDouble) getAttrVal("Hb"));
	}	
	public void setHb(FDouble Hb) {
		setAttrVal("Hb", Hb);
	}
	public String getBloodtype() {
		return ((String) getAttrVal("Bloodtype"));
	}	
	public void setBloodtype(String Bloodtype) {
		setAttrVal("Bloodtype", Bloodtype);
	}
	public FDouble getBloodhcg() {
		return ((FDouble) getAttrVal("Bloodhcg"));
	}	
	public void setBloodhcg(FDouble Bloodhcg) {
		setAttrVal("Bloodhcg", Bloodhcg);
	}
	public String getId_secreta() {
		return ((String) getAttrVal("Id_secreta"));
	}	
	public void setId_secreta(String Id_secreta) {
		setAttrVal("Id_secreta", Id_secreta);
	}
	public String getSd_secreta() {
		return ((String) getAttrVal("Sd_secreta"));
	}	
	public void setSd_secreta(String Sd_secreta) {
		setAttrVal("Sd_secreta", Sd_secreta);
	}
	public String getId_leukorrhea() {
		return ((String) getAttrVal("Id_leukorrhea"));
	}	
	public void setId_leukorrhea(String Id_leukorrhea) {
		setAttrVal("Id_leukorrhea", Id_leukorrhea);
	}
	public String getSd_leukorrhea() {
		return ((String) getAttrVal("Sd_leukorrhea"));
	}	
	public void setSd_leukorrhea(String Sd_leukorrhea) {
		setAttrVal("Sd_leukorrhea", Sd_leukorrhea);
	}
	public Integer getEu_vagina_blood() {
		return ((Integer) getAttrVal("Eu_vagina_blood"));
	}	
	public void setEu_vagina_blood(Integer Eu_vagina_blood) {
		setAttrVal("Eu_vagina_blood", Eu_vagina_blood);
	}
	public String getId_vagina_blood() {
		return ((String) getAttrVal("Id_vagina_blood"));
	}	
	public void setId_vagina_blood(String Id_vagina_blood) {
		setAttrVal("Id_vagina_blood", Id_vagina_blood);
	}
	public String getSd_vagina_blood() {
		return ((String) getAttrVal("Sd_vagina_blood"));
	}	
	public void setSd_vagina_blood(String Sd_vagina_blood) {
		setAttrVal("Sd_vagina_blood", Sd_vagina_blood);
	}
	public Integer getEu_bellyache() {
		return ((Integer) getAttrVal("Eu_bellyache"));
	}	
	public void setEu_bellyache(Integer Eu_bellyache) {
		setAttrVal("Eu_bellyache", Eu_bellyache);
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
	public String getId_assentry_psn() {
		return ((String) getAttrVal("Id_assentry_psn"));
	}	
	public void setId_assentry_psn(String Id_assentry_psn) {
		setAttrVal("Id_assentry_psn", Id_assentry_psn);
	}
	public String getId_labourway() {
		return ((String) getAttrVal("Id_labourway"));
	}	
	public void setId_labourway(String Id_labourway) {
		setAttrVal("Id_labourway", Id_labourway);
	}
	public String getSd_labourway() {
		return ((String) getAttrVal("Sd_labourway"));
	}	
	public void setSd_labourway(String Sd_labourway) {
		setAttrVal("Sd_labourway", Sd_labourway);
	}
	public FDateTime getDt_labour() {
		return ((FDateTime) getAttrVal("Dt_labour"));
	}	
	public void setDt_labour(FDateTime Dt_labour) {
		setAttrVal("Dt_labour", Dt_labour);
	}
	public FDateTime getDt_deliver() {
		return ((FDateTime) getAttrVal("Dt_deliver"));
	}	
	public void setDt_deliver(FDateTime Dt_deliver) {
		setAttrVal("Dt_deliver", Dt_deliver);
	}
	public FDateTime getDt_backroom() {
		return ((FDateTime) getAttrVal("Dt_backroom"));
	}	
	public void setDt_backroom(FDateTime Dt_backroom) {
		setAttrVal("Dt_backroom", Dt_backroom);
	}
	public String getId_deliverway() {
		return ((String) getAttrVal("Id_deliverway"));
	}	
	public void setId_deliverway(String Id_deliverway) {
		setAttrVal("Id_deliverway", Id_deliverway);
	}
	public String getSd_deliverway() {
		return ((String) getAttrVal("Sd_deliverway"));
	}	
	public void setSd_deliverway(String Sd_deliverway) {
		setAttrVal("Sd_deliverway", Sd_deliverway);
	}
	public String getId_urinatecond() {
		return ((String) getAttrVal("Id_urinatecond"));
	}	
	public void setId_urinatecond(String Id_urinatecond) {
		setAttrVal("Id_urinatecond", Id_urinatecond);
	}
	public String getSd_urinatecond() {
		return ((String) getAttrVal("Sd_urinatecond"));
	}	
	public void setSd_urinatecond(String Sd_urinatecond) {
		setAttrVal("Sd_urinatecond", Sd_urinatecond);
	}
	public String getId_assdeliver_psn() {
		return ((String) getAttrVal("Id_assdeliver_psn"));
	}	
	public void setId_assdeliver_psn(String Id_assdeliver_psn) {
		setAttrVal("Id_assdeliver_psn", Id_assdeliver_psn);
	}
	public FDateTime getDt_operat() {
		return ((FDateTime) getAttrVal("Dt_operat"));
	}	
	public void setDt_operat(FDateTime Dt_operat) {
		setAttrVal("Dt_operat", Dt_operat);
	}
	public Integer getEu_hocusway() {
		return ((Integer) getAttrVal("Eu_hocusway"));
	}	
	public void setEu_hocusway(Integer Eu_hocusway) {
		setAttrVal("Eu_hocusway", Eu_hocusway);
	}
	public String getId_hocusway() {
		return ((String) getAttrVal("Id_hocusway"));
	}	
	public void setId_hocusway(String Id_hocusway) {
		setAttrVal("Id_hocusway", Id_hocusway);
	}
	public String getSd_hocusway() {
		return ((String) getAttrVal("Sd_hocusway"));
	}	
	public void setSd_hocusway(String Sd_hocusway) {
		setAttrVal("Sd_hocusway", Sd_hocusway);
	}
	public String getHocuswayother() {
		return ((String) getAttrVal("Hocuswayother"));
	}	
	public void setHocuswayother(String Hocuswayother) {
		setAttrVal("Hocuswayother", Hocuswayother);
	}
	public Integer getEu_specase() {
		return ((Integer) getAttrVal("Eu_specase"));
	}	
	public void setEu_specase(Integer Eu_specase) {
		setAttrVal("Eu_specase", Eu_specase);
	}
	public Integer getOperatblood() {
		return ((Integer) getAttrVal("Operatblood"));
	}	
	public void setOperatblood(Integer Operatblood) {
		setAttrVal("Operatblood", Operatblood);
	}
	public Integer getEu_keepcath() {
		return ((Integer) getAttrVal("Eu_keepcath"));
	}	
	public void setEu_keepcath(Integer Eu_keepcath) {
		setAttrVal("Eu_keepcath", Eu_keepcath);
	}
	public String getId_specase_psn() {
		return ((String) getAttrVal("Id_specase_psn"));
	}	
	public void setId_specase_psn(String Id_specase_psn) {
		setAttrVal("Id_specase_psn", Id_specase_psn);
	}
	public String getId_urinatecond_oper() {
		return ((String) getAttrVal("Id_urinatecond_oper"));
	}	
	public void setId_urinatecond_oper(String Id_urinatecond_oper) {
		setAttrVal("Id_urinatecond_oper", Id_urinatecond_oper);
	}
	public String getSd_urinatecond_oper() {
		return ((String) getAttrVal("Sd_urinatecond_oper"));
	}	
	public void setSd_urinatecond_oper(String Sd_urinatecond_oper) {
		setAttrVal("Sd_urinatecond_oper", Sd_urinatecond_oper);
	}
	public String getId_oper_psn() {
		return ((String) getAttrVal("Id_oper_psn"));
	}	
	public void setId_oper_psn(String Id_oper_psn) {
		setAttrVal("Id_oper_psn", Id_oper_psn);
	}
	public FDate getDt_outhos() {
		return ((FDate) getAttrVal("Dt_outhos"));
	}	
	public void setDt_outhos(FDate Dt_outhos) {
		setAttrVal("Dt_outhos", Dt_outhos);
	}
	public String getId_assoper_psn() {
		return ((String) getAttrVal("Id_assoper_psn"));
	}	
	public void setId_assoper_psn(String Id_assoper_psn) {
		setAttrVal("Id_assoper_psn", Id_assoper_psn);
	}
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	public String getName_entry_way() {
		return ((String) getAttrVal("Name_entry_way"));
	}	
	public void setName_entry_way(String Name_entry_way) {
		setAttrVal("Name_entry_way", Name_entry_way);
	}
	public String getName_hbsag() {
		return ((String) getAttrVal("Name_hbsag"));
	}	
	public void setName_hbsag(String Name_hbsag) {
		setAttrVal("Name_hbsag", Name_hbsag);
	}
	public String getName_secreta() {
		return ((String) getAttrVal("Name_secreta"));
	}	
	public void setName_secreta(String Name_secreta) {
		setAttrVal("Name_secreta", Name_secreta);
	}
	public String getName_leukorrhea() {
		return ((String) getAttrVal("Name_leukorrhea"));
	}	
	public void setName_leukorrhea(String Name_leukorrhea) {
		setAttrVal("Name_leukorrhea", Name_leukorrhea);
	}
	public String getName_vagina_blood() {
		return ((String) getAttrVal("Name_vagina_blood"));
	}	
	public void setName_vagina_blood(String Name_vagina_blood) {
		setAttrVal("Name_vagina_blood", Name_vagina_blood);
	}
	public String getName_nur_level() {
		return ((String) getAttrVal("Name_nur_level"));
	}	
	public void setName_nur_level(String Name_nur_level) {
		setAttrVal("Name_nur_level", Name_nur_level);
	}
	public String getName_assentry_psn() {
		return ((String) getAttrVal("Name_assentry_psn"));
	}	
	public void setName_assentry_psn(String Name_assentry_psn) {
		setAttrVal("Name_assentry_psn", Name_assentry_psn);
	}
	public String getName_labourway() {
		return ((String) getAttrVal("Name_labourway"));
	}	
	public void setName_labourway(String Name_labourway) {
		setAttrVal("Name_labourway", Name_labourway);
	}
	public String getName_deliverway() {
		return ((String) getAttrVal("Name_deliverway"));
	}	
	public void setName_deliverway(String Name_deliverway) {
		setAttrVal("Name_deliverway", Name_deliverway);
	}
	public String getName_urinatecond() {
		return ((String) getAttrVal("Name_urinatecond"));
	}	
	public void setName_urinatecond(String Name_urinatecond) {
		setAttrVal("Name_urinatecond", Name_urinatecond);
	}
	public String getName_assdeliver_psn() {
		return ((String) getAttrVal("Name_assdeliver_psn"));
	}	
	public void setName_assdeliver_psn(String Name_assdeliver_psn) {
		setAttrVal("Name_assdeliver_psn", Name_assdeliver_psn);
	}
	public String getName_hocusway() {
		return ((String) getAttrVal("Name_hocusway"));
	}	
	public void setName_hocusway(String Name_hocusway) {
		setAttrVal("Name_hocusway", Name_hocusway);
	}
	public String getName_specase_psn() {
		return ((String) getAttrVal("Name_specase_psn"));
	}	
	public void setName_specase_psn(String Name_specase_psn) {
		setAttrVal("Name_specase_psn", Name_specase_psn);
	}
	public String getName_urinatecond_oper() {
		return ((String) getAttrVal("Name_urinatecond_oper"));
	}	
	public void setName_urinatecond_oper(String Name_urinatecond_oper) {
		setAttrVal("Name_urinatecond_oper", Name_urinatecond_oper);
	}
	public String getName_sshscpnq() {
		return ((String) getAttrVal("Name_sshscpnq"));
	}	
	public void setName_sshscpnq(String Name_sshscpnq) {
		setAttrVal("Name_sshscpnq", Name_sshscpnq);
	}
	public String getName_assoper_psn() {
		return ((String) getAttrVal("Name_assoper_psn"));
	}	
	public void setName_assoper_psn(String Name_assoper_psn) {
		setAttrVal("Name_assoper_psn", Name_assoper_psn);
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
		return "Id_ass";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_MR_NU_GYMISSABORTASS";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(GyMissAbortAssDODesc.class);
	}
	
}