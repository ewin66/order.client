package iih.ci.mr.nu.obstetrics.gynurbefore.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.obstetrics.gynurbefore.d.desc.GyNurBeforeAssDODesc;
import java.math.BigDecimal;

/**
 * 妇科护理记录单(术前) DO数据 
 * 
 */
public class GyNurBeforeAssDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_ASS= "Id_ass";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_PAT= "Id_pat";
	public static final String CODE_ENTP= "Code_entp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_DEP_PHY= "Id_dep_phy";
	public static final String NAME_BED= "Name_bed";
	public static final String AGE= "Age";
	public static final String CODE_AMR_IP= "Code_amr_ip";
	public static final String DT_ENTRY= "Dt_entry";
	public static final String NAME_DIAGNOSIS= "Name_diagnosis";
	public static final String ID_RYFS= "Id_ryfs";
	public static final String SD_RYFS= "Sd_ryfs";
	public static final String NAME_ALLERGY= "Name_allergy";
	public static final String EU_GGQK= "Eu_ggqk";
	public static final String ID_HBEAG= "Id_hbeag";
	public static final String SD_HBEAG= "Sd_hbeag";
	public static final String ID_HBSAG= "Id_hbsag";
	public static final String SD_HBSAG= "Sd_hbsag";
	public static final String ID_KHBC= "Id_khbc";
	public static final String SD_KHBC= "Sd_khbc";
	public static final String ID_KHIV= "Id_khiv";
	public static final String SD_KHIV= "Sd_khiv";
	public static final String ID_KHCV= "Id_khcv";
	public static final String SD_KHCV= "Sd_khcv";
	public static final String ID_HLJB= "Id_hljb";
	public static final String SD_HLJB= "Sd_hljb";
	public static final String ID_HD= "Id_hd";
	public static final String SD_HD= "Sd_hd";
	public static final String JYPGQM= "Jypgqm";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_PAT= "Name_pat";
	public static final String NAME_DEP_PHY= "Name_dep_phy";
	public static final String NAME_RYFS= "Name_ryfs";
	public static final String NAME_HBCEG= "Name_hbceg";
	public static final String NAME_HBSAG= "Name_hbsag";
	public static final String NAME_KHBC= "Name_khbc";
	public static final String NAME_KHIV= "Name_khiv";
	public static final String NAME_KHCV= "Name_khcv";
	public static final String NAME_HLJB= "Name_hljb";
	public static final String NAME_HD= "Name_hd";
	public static final String NAME_PSNDOC= "Name_psndoc";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_ass() {
		return ((String) getAttrVal("Id_ass"));
	}	
	public void setId_ass(String Id_ass) {
		setAttrVal("Id_ass", Id_ass);
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
	public String getId_ryfs() {
		return ((String) getAttrVal("Id_ryfs"));
	}	
	public void setId_ryfs(String Id_ryfs) {
		setAttrVal("Id_ryfs", Id_ryfs);
	}
	public String getSd_ryfs() {
		return ((String) getAttrVal("Sd_ryfs"));
	}	
	public void setSd_ryfs(String Sd_ryfs) {
		setAttrVal("Sd_ryfs", Sd_ryfs);
	}
	public String getName_allergy() {
		return ((String) getAttrVal("Name_allergy"));
	}	
	public void setName_allergy(String Name_allergy) {
		setAttrVal("Name_allergy", Name_allergy);
	}
	public Integer getEu_ggqk() {
		return ((Integer) getAttrVal("Eu_ggqk"));
	}	
	public void setEu_ggqk(Integer Eu_ggqk) {
		setAttrVal("Eu_ggqk", Eu_ggqk);
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
	public String getId_khbc() {
		return ((String) getAttrVal("Id_khbc"));
	}	
	public void setId_khbc(String Id_khbc) {
		setAttrVal("Id_khbc", Id_khbc);
	}
	public String getSd_khbc() {
		return ((String) getAttrVal("Sd_khbc"));
	}	
	public void setSd_khbc(String Sd_khbc) {
		setAttrVal("Sd_khbc", Sd_khbc);
	}
	public String getId_khiv() {
		return ((String) getAttrVal("Id_khiv"));
	}	
	public void setId_khiv(String Id_khiv) {
		setAttrVal("Id_khiv", Id_khiv);
	}
	public String getSd_khiv() {
		return ((String) getAttrVal("Sd_khiv"));
	}	
	public void setSd_khiv(String Sd_khiv) {
		setAttrVal("Sd_khiv", Sd_khiv);
	}
	public String getId_khcv() {
		return ((String) getAttrVal("Id_khcv"));
	}	
	public void setId_khcv(String Id_khcv) {
		setAttrVal("Id_khcv", Id_khcv);
	}
	public String getSd_khcv() {
		return ((String) getAttrVal("Sd_khcv"));
	}	
	public void setSd_khcv(String Sd_khcv) {
		setAttrVal("Sd_khcv", Sd_khcv);
	}
	public String getId_hljb() {
		return ((String) getAttrVal("Id_hljb"));
	}	
	public void setId_hljb(String Id_hljb) {
		setAttrVal("Id_hljb", Id_hljb);
	}
	public String getSd_hljb() {
		return ((String) getAttrVal("Sd_hljb"));
	}	
	public void setSd_hljb(String Sd_hljb) {
		setAttrVal("Sd_hljb", Sd_hljb);
	}
	public String getId_hd() {
		return ((String) getAttrVal("Id_hd"));
	}	
	public void setId_hd(String Id_hd) {
		setAttrVal("Id_hd", Id_hd);
	}
	public String getSd_hd() {
		return ((String) getAttrVal("Sd_hd"));
	}	
	public void setSd_hd(String Sd_hd) {
		setAttrVal("Sd_hd", Sd_hd);
	}
	public String getJypgqm() {
		return ((String) getAttrVal("Jypgqm"));
	}	
	public void setJypgqm(String Jypgqm) {
		setAttrVal("Jypgqm", Jypgqm);
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
	public String getName_dep_phy() {
		return ((String) getAttrVal("Name_dep_phy"));
	}	
	public void setName_dep_phy(String Name_dep_phy) {
		setAttrVal("Name_dep_phy", Name_dep_phy);
	}
	public String getName_ryfs() {
		return ((String) getAttrVal("Name_ryfs"));
	}	
	public void setName_ryfs(String Name_ryfs) {
		setAttrVal("Name_ryfs", Name_ryfs);
	}
	public String getName_hbceg() {
		return ((String) getAttrVal("Name_hbceg"));
	}	
	public void setName_hbceg(String Name_hbceg) {
		setAttrVal("Name_hbceg", Name_hbceg);
	}
	public String getName_hbsag() {
		return ((String) getAttrVal("Name_hbsag"));
	}	
	public void setName_hbsag(String Name_hbsag) {
		setAttrVal("Name_hbsag", Name_hbsag);
	}
	public String getName_khbc() {
		return ((String) getAttrVal("Name_khbc"));
	}	
	public void setName_khbc(String Name_khbc) {
		setAttrVal("Name_khbc", Name_khbc);
	}
	public String getName_khiv() {
		return ((String) getAttrVal("Name_khiv"));
	}	
	public void setName_khiv(String Name_khiv) {
		setAttrVal("Name_khiv", Name_khiv);
	}
	public String getName_khcv() {
		return ((String) getAttrVal("Name_khcv"));
	}	
	public void setName_khcv(String Name_khcv) {
		setAttrVal("Name_khcv", Name_khcv);
	}
	public String getName_hljb() {
		return ((String) getAttrVal("Name_hljb"));
	}	
	public void setName_hljb(String Name_hljb) {
		setAttrVal("Name_hljb", Name_hljb);
	}
	public String getName_hd() {
		return ((String) getAttrVal("Name_hd"));
	}	
	public void setName_hd(String Name_hd) {
		setAttrVal("Name_hd", Name_hd);
	}
	public String getName_psndoc() {
		return ((String) getAttrVal("Name_psndoc"));
	}	
	public void setName_psndoc(String Name_psndoc) {
		setAttrVal("Name_psndoc", Name_psndoc);
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
		return "CI_MR_NU_GYBEFOREASS";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(GyNurBeforeAssDODesc.class);
	}
	
}