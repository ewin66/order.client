package iih.ci.mr.nu.obstetrics.antenatalassess.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.obstetrics.antenatalassess.d.desc.AntenAssDODesc;
import java.math.BigDecimal;

/**
 * 简要评估（产后、术后） DO数据 
 * 
 */
public class AntenAssDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_ANTENASS= "Id_antenass";
	public static final String ID_ENT= "Id_ent";
	public static final String CODE_ENTP= "Code_entp";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_DEP_PHY= "Id_dep_phy";
	public static final String NAME_BED= "Name_bed";
	public static final String ID_PAT= "Id_pat";
	public static final String AGE= "Age";
	public static final String CODE_AMR_IP= "Code_amr_ip";
	public static final String DT_DELIVE= "Dt_delive";
	public static final String DT_BACKROOM= "Dt_backroom";
	public static final String ID_DELIVEWAY= "Id_deliveway";
	public static final String SD_DELIVEWAY= "Sd_deliveway";
	public static final String BLEED= "Bleed";
	public static final String ID_ANESWAY= "Id_anesway";
	public static final String SD_ANESWAY= "Sd_anesway";
	public static final String ID_ASSSIGN_PSN= "Id_asssign_psn";
	public static final String DT_MOVEURETER= "Dt_moveureter";
	public static final String ID_MOVEURETER_PSN= "Id_moveureter_psn";
	public static final String DT_FIRSELFPEE= "Dt_firselfpee";
	public static final String ID_URINATECOND= "Id_urinatecond";
	public static final String SD_URINATECOND= "Sd_urinatecond";
	public static final String ID_PEESIGN_PSN= "Id_peesign_psn";
	public static final String DT_LEAVEHOS= "Dt_leavehos";
	public static final String ID_LEAVEHOS_PSN= "Id_leavehos_psn";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_GRP= "Name_grp";
	public static final String NAME_ORG= "Name_org";
	public static final String NAME_DEP_PHY= "Name_dep_phy";
	public static final String NAME_PAT= "Name_pat";
	public static final String NAME_DELIVEWAY= "Name_deliveway";
	public static final String NAME_ANESWAY= "Name_anesway";
	public static final String NAME_ASSSIGN_PSN= "Name_asssign_psn";
	public static final String NAME_MOVEURETER_PSN= "Name_moveureter_psn";
	public static final String NAME_URINATECOND= "Name_urinatecond";
	public static final String NAME_PEESIGN_PSN= "Name_peesign_psn";
	public static final String NAME_LEAVEHOS_PSN= "Name_leavehos_psn";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_antenass() {
		return ((String) getAttrVal("Id_antenass"));
	}	
	public void setId_antenass(String Id_antenass) {
		setAttrVal("Id_antenass", Id_antenass);
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
	public String getId_dep_phy() {
		return ((String) getAttrVal("Id_dep_phy"));
	}	
	public void setId_dep_phy(String Id_dep_phy) {
		setAttrVal("Id_dep_phy", Id_dep_phy);
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
	public FDateTime getDt_delive() {
		return ((FDateTime) getAttrVal("Dt_delive"));
	}	
	public void setDt_delive(FDateTime Dt_delive) {
		setAttrVal("Dt_delive", Dt_delive);
	}
	public FDateTime getDt_backroom() {
		return ((FDateTime) getAttrVal("Dt_backroom"));
	}	
	public void setDt_backroom(FDateTime Dt_backroom) {
		setAttrVal("Dt_backroom", Dt_backroom);
	}
	public String getId_deliveway() {
		return ((String) getAttrVal("Id_deliveway"));
	}	
	public void setId_deliveway(String Id_deliveway) {
		setAttrVal("Id_deliveway", Id_deliveway);
	}
	public String getSd_deliveway() {
		return ((String) getAttrVal("Sd_deliveway"));
	}	
	public void setSd_deliveway(String Sd_deliveway) {
		setAttrVal("Sd_deliveway", Sd_deliveway);
	}
	public Integer getBleed() {
		return ((Integer) getAttrVal("Bleed"));
	}	
	public void setBleed(Integer Bleed) {
		setAttrVal("Bleed", Bleed);
	}
	public String getId_anesway() {
		return ((String) getAttrVal("Id_anesway"));
	}	
	public void setId_anesway(String Id_anesway) {
		setAttrVal("Id_anesway", Id_anesway);
	}
	public String getSd_anesway() {
		return ((String) getAttrVal("Sd_anesway"));
	}	
	public void setSd_anesway(String Sd_anesway) {
		setAttrVal("Sd_anesway", Sd_anesway);
	}
	public String getId_asssign_psn() {
		return ((String) getAttrVal("Id_asssign_psn"));
	}	
	public void setId_asssign_psn(String Id_asssign_psn) {
		setAttrVal("Id_asssign_psn", Id_asssign_psn);
	}
	public FDateTime getDt_moveureter() {
		return ((FDateTime) getAttrVal("Dt_moveureter"));
	}	
	public void setDt_moveureter(FDateTime Dt_moveureter) {
		setAttrVal("Dt_moveureter", Dt_moveureter);
	}
	public String getId_moveureter_psn() {
		return ((String) getAttrVal("Id_moveureter_psn"));
	}	
	public void setId_moveureter_psn(String Id_moveureter_psn) {
		setAttrVal("Id_moveureter_psn", Id_moveureter_psn);
	}
	public FDateTime getDt_firselfpee() {
		return ((FDateTime) getAttrVal("Dt_firselfpee"));
	}	
	public void setDt_firselfpee(FDateTime Dt_firselfpee) {
		setAttrVal("Dt_firselfpee", Dt_firselfpee);
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
	public String getId_peesign_psn() {
		return ((String) getAttrVal("Id_peesign_psn"));
	}	
	public void setId_peesign_psn(String Id_peesign_psn) {
		setAttrVal("Id_peesign_psn", Id_peesign_psn);
	}
	public FDateTime getDt_leavehos() {
		return ((FDateTime) getAttrVal("Dt_leavehos"));
	}	
	public void setDt_leavehos(FDateTime Dt_leavehos) {
		setAttrVal("Dt_leavehos", Dt_leavehos);
	}
	public String getId_leavehos_psn() {
		return ((String) getAttrVal("Id_leavehos_psn"));
	}	
	public void setId_leavehos_psn(String Id_leavehos_psn) {
		setAttrVal("Id_leavehos_psn", Id_leavehos_psn);
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
	public String getName_grp() {
		return ((String) getAttrVal("Name_grp"));
	}	
	public void setName_grp(String Name_grp) {
		setAttrVal("Name_grp", Name_grp);
	}
	public String getName_org() {
		return ((String) getAttrVal("Name_org"));
	}	
	public void setName_org(String Name_org) {
		setAttrVal("Name_org", Name_org);
	}
	public String getName_dep_phy() {
		return ((String) getAttrVal("Name_dep_phy"));
	}	
	public void setName_dep_phy(String Name_dep_phy) {
		setAttrVal("Name_dep_phy", Name_dep_phy);
	}
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	public String getName_deliveway() {
		return ((String) getAttrVal("Name_deliveway"));
	}	
	public void setName_deliveway(String Name_deliveway) {
		setAttrVal("Name_deliveway", Name_deliveway);
	}
	public String getName_anesway() {
		return ((String) getAttrVal("Name_anesway"));
	}	
	public void setName_anesway(String Name_anesway) {
		setAttrVal("Name_anesway", Name_anesway);
	}
	public String getName_asssign_psn() {
		return ((String) getAttrVal("Name_asssign_psn"));
	}	
	public void setName_asssign_psn(String Name_asssign_psn) {
		setAttrVal("Name_asssign_psn", Name_asssign_psn);
	}
	public String getName_moveureter_psn() {
		return ((String) getAttrVal("Name_moveureter_psn"));
	}	
	public void setName_moveureter_psn(String Name_moveureter_psn) {
		setAttrVal("Name_moveureter_psn", Name_moveureter_psn);
	}
	public String getName_urinatecond() {
		return ((String) getAttrVal("Name_urinatecond"));
	}	
	public void setName_urinatecond(String Name_urinatecond) {
		setAttrVal("Name_urinatecond", Name_urinatecond);
	}
	public String getName_peesign_psn() {
		return ((String) getAttrVal("Name_peesign_psn"));
	}	
	public void setName_peesign_psn(String Name_peesign_psn) {
		setAttrVal("Name_peesign_psn", Name_peesign_psn);
	}
	public String getName_leavehos_psn() {
		return ((String) getAttrVal("Name_leavehos_psn"));
	}	
	public void setName_leavehos_psn(String Name_leavehos_psn) {
		setAttrVal("Name_leavehos_psn", Name_leavehos_psn);
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
		return "Id_antenass";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_Mr_NU_ANT_ASS";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(AntenAssDODesc.class);
	}
	
}