package iih.ci.mr.nu.chidrenass.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.chidrenass.d.desc.ChildrenInAsseDODesc;
import java.math.BigDecimal;

/**
 * 高危儿入室评估 DO数据 
 * 
 */
public class ChildrenInAsseDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_CHASS= "Id_chass";
	public static final String NAME_BED= "Name_bed";
	public static final String CODE_AMR_IP= "Code_amr_ip";
	public static final String ID_ENT= "Id_ent";
	public static final String CODE_ENTP= "Code_entp";
	public static final String PARENT_SIGN= "Parent_sign";
	public static final String RSZDJYY= "Rszdjyy";
	public static final String MS= "Ms";
	public static final String AGE= "Age";
	public static final String WEIGHT= "Weight";
	public static final String YZW= "Yzw";
	public static final String ASPF1FZF= "Aspf1fzf";
	public static final String ASPF5FZF= "Aspf5fzf";
	public static final String ID_DELIVERY_MODE= "Id_delivery_mode";
	public static final String SD_DELIVERY_MODE= "Sd_delivery_mode";
	public static final String EU_PFQK= "Eu_pfqk";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String NAME_PAT= "Name_pat";
	public static final String ID_PAT= "Id_pat";
	public static final String DT_BIRTH= "Dt_birth";
	public static final String NAME_DELIVERY_MODE= "Name_delivery_mode";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_chass() {
		return ((String) getAttrVal("Id_chass"));
	}	
	public void setId_chass(String Id_chass) {
		setAttrVal("Id_chass", Id_chass);
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
	public String getParent_sign() {
		return ((String) getAttrVal("Parent_sign"));
	}	
	public void setParent_sign(String Parent_sign) {
		setAttrVal("Parent_sign", Parent_sign);
	}
	public String getRszdjyy() {
		return ((String) getAttrVal("Rszdjyy"));
	}	
	public void setRszdjyy(String Rszdjyy) {
		setAttrVal("Rszdjyy", Rszdjyy);
	}
	public String getMs() {
		return ((String) getAttrVal("Ms"));
	}	
	public void setMs(String Ms) {
		setAttrVal("Ms", Ms);
	}
	public String getAge() {
		return ((String) getAttrVal("Age"));
	}	
	public void setAge(String Age) {
		setAttrVal("Age", Age);
	}
	public Integer getWeight() {
		return ((Integer) getAttrVal("Weight"));
	}	
	public void setWeight(Integer Weight) {
		setAttrVal("Weight", Weight);
	}
	public Integer getYzw() {
		return ((Integer) getAttrVal("Yzw"));
	}	
	public void setYzw(Integer Yzw) {
		setAttrVal("Yzw", Yzw);
	}
	public Integer getAspf1fzf() {
		return ((Integer) getAttrVal("Aspf1fzf"));
	}	
	public void setAspf1fzf(Integer Aspf1fzf) {
		setAttrVal("Aspf1fzf", Aspf1fzf);
	}
	public Integer getAspf5fzf() {
		return ((Integer) getAttrVal("Aspf5fzf"));
	}	
	public void setAspf5fzf(Integer Aspf5fzf) {
		setAttrVal("Aspf5fzf", Aspf5fzf);
	}
	public String getId_delivery_mode() {
		return ((String) getAttrVal("Id_delivery_mode"));
	}	
	public void setId_delivery_mode(String Id_delivery_mode) {
		setAttrVal("Id_delivery_mode", Id_delivery_mode);
	}
	public String getSd_delivery_mode() {
		return ((String) getAttrVal("Sd_delivery_mode"));
	}	
	public void setSd_delivery_mode(String Sd_delivery_mode) {
		setAttrVal("Sd_delivery_mode", Sd_delivery_mode);
	}
	public Integer getEu_pfqk() {
		return ((Integer) getAttrVal("Eu_pfqk"));
	}	
	public void setEu_pfqk(Integer Eu_pfqk) {
		setAttrVal("Eu_pfqk", Eu_pfqk);
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
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	public FDate getDt_birth() {
		return ((FDate) getAttrVal("Dt_birth"));
	}	
	public void setDt_birth(FDate Dt_birth) {
		setAttrVal("Dt_birth", Dt_birth);
	}
	public String getName_delivery_mode() {
		return ((String) getAttrVal("Name_delivery_mode"));
	}	
	public void setName_delivery_mode(String Name_delivery_mode) {
		setAttrVal("Name_delivery_mode", Name_delivery_mode);
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
		return "Id_chass";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_MR_NU_CHASS";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ChildrenInAsseDODesc.class);
	}
	
}