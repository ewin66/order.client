package iih.ci.mr.nu.obstetrics.antennurbaby.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.obstetrics.antennurbaby.d.desc.AntNurBabyDODesc;
import java.math.BigDecimal;

/**
 * 产科婴儿入室评估单 DO数据 
 * 
 */
public class AntNurBabyDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_ASS= "Id_ass";
	public static final String ID_DEP_PHY= "Id_dep_phy";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_PAT= "Id_pat";
	public static final String CODE_ENTP= "Code_entp";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_DEP_NUR= "Id_dep_nur";
	public static final String NAME_BED= "Name_bed";
	public static final String ID_CHILDBIRTH_TYPE= "Id_childbirth_type";
	public static final String SD_CHILDBIRTH_TYPE= "Sd_childbirth_type";
	public static final String NAME_PASTMEDIC= "Name_pastmedic";
	public static final String PFYCMS= "Pfycms";
	public static final String FSYCMS= "Fsycms";
	public static final String ID_SIGN= "Id_sign";
	public static final String CSTC= "Cstc";
	public static final String ASPF1FZ= "Aspf1fz";
	public static final String ASPF5FZ= "Aspf5fz";
	public static final String CSRQ= "Csrq";
	public static final String EU_XB= "Eu_xb";
	public static final String EU_PFQK= "Eu_pfqk";
	public static final String EU_FS= "Eu_fs";
	public static final String ID_MOTHERNIPPLE= "Id_mothernipple";
	public static final String SD_MOTHERNIPPLE= "Sd_mothernipple";
	public static final String NIPPLE_OTHER= "Nipple_other";
	public static final String POORSUCKING_DES= "Poorsucking_des";
	public static final String EU_YERSXSQK= "Eu_yersxsqk";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_DEP_PHY= "Name_dep_phy";
	public static final String NAME_PAT= "Name_pat";
	public static final String CODE_AMR_IP= "Code_amr_ip";
	public static final String NAME_GRP= "Name_grp";
	public static final String NAME_ORG= "Name_org";
	public static final String NAME_DEP_NUR= "Name_dep_nur";
	public static final String NAME_CHILDBIRTH_TYPE= "Name_childbirth_type";
	public static final String NAME_SIGN= "Name_sign";
	public static final String NAME_MOTHERNIPPLE= "Name_mothernipple";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_ass() {
		return ((String) getAttrVal("Id_ass"));
	}	
	public void setId_ass(String Id_ass) {
		setAttrVal("Id_ass", Id_ass);
	}
	public String getId_dep_phy() {
		return ((String) getAttrVal("Id_dep_phy"));
	}	
	public void setId_dep_phy(String Id_dep_phy) {
		setAttrVal("Id_dep_phy", Id_dep_phy);
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
	public String getName_bed() {
		return ((String) getAttrVal("Name_bed"));
	}	
	public void setName_bed(String Name_bed) {
		setAttrVal("Name_bed", Name_bed);
	}
	public String getId_childbirth_type() {
		return ((String) getAttrVal("Id_childbirth_type"));
	}	
	public void setId_childbirth_type(String Id_childbirth_type) {
		setAttrVal("Id_childbirth_type", Id_childbirth_type);
	}
	public String getSd_childbirth_type() {
		return ((String) getAttrVal("Sd_childbirth_type"));
	}	
	public void setSd_childbirth_type(String Sd_childbirth_type) {
		setAttrVal("Sd_childbirth_type", Sd_childbirth_type);
	}
	public String getName_pastmedic() {
		return ((String) getAttrVal("Name_pastmedic"));
	}	
	public void setName_pastmedic(String Name_pastmedic) {
		setAttrVal("Name_pastmedic", Name_pastmedic);
	}
	public String getPfycms() {
		return ((String) getAttrVal("Pfycms"));
	}	
	public void setPfycms(String Pfycms) {
		setAttrVal("Pfycms", Pfycms);
	}
	public String getFsycms() {
		return ((String) getAttrVal("Fsycms"));
	}	
	public void setFsycms(String Fsycms) {
		setAttrVal("Fsycms", Fsycms);
	}
	public String getId_sign() {
		return ((String) getAttrVal("Id_sign"));
	}	
	public void setId_sign(String Id_sign) {
		setAttrVal("Id_sign", Id_sign);
	}
	public Integer getCstc() {
		return ((Integer) getAttrVal("Cstc"));
	}	
	public void setCstc(Integer Cstc) {
		setAttrVal("Cstc", Cstc);
	}
	public Integer getAspf1fz() {
		return ((Integer) getAttrVal("Aspf1fz"));
	}	
	public void setAspf1fz(Integer Aspf1fz) {
		setAttrVal("Aspf1fz", Aspf1fz);
	}
	public Integer getAspf5fz() {
		return ((Integer) getAttrVal("Aspf5fz"));
	}	
	public void setAspf5fz(Integer Aspf5fz) {
		setAttrVal("Aspf5fz", Aspf5fz);
	}
	public FDateTime getCsrq() {
		return ((FDateTime) getAttrVal("Csrq"));
	}	
	public void setCsrq(FDateTime Csrq) {
		setAttrVal("Csrq", Csrq);
	}
	public Integer getEu_xb() {
		return ((Integer) getAttrVal("Eu_xb"));
	}	
	public void setEu_xb(Integer Eu_xb) {
		setAttrVal("Eu_xb", Eu_xb);
	}
	public Integer getEu_pfqk() {
		return ((Integer) getAttrVal("Eu_pfqk"));
	}	
	public void setEu_pfqk(Integer Eu_pfqk) {
		setAttrVal("Eu_pfqk", Eu_pfqk);
	}
	public Integer getEu_fs() {
		return ((Integer) getAttrVal("Eu_fs"));
	}	
	public void setEu_fs(Integer Eu_fs) {
		setAttrVal("Eu_fs", Eu_fs);
	}
	public String getId_mothernipple() {
		return ((String) getAttrVal("Id_mothernipple"));
	}	
	public void setId_mothernipple(String Id_mothernipple) {
		setAttrVal("Id_mothernipple", Id_mothernipple);
	}
	public String getSd_mothernipple() {
		return ((String) getAttrVal("Sd_mothernipple"));
	}	
	public void setSd_mothernipple(String Sd_mothernipple) {
		setAttrVal("Sd_mothernipple", Sd_mothernipple);
	}
	public String getNipple_other() {
		return ((String) getAttrVal("Nipple_other"));
	}	
	public void setNipple_other(String Nipple_other) {
		setAttrVal("Nipple_other", Nipple_other);
	}
	public String getPoorsucking_des() {
		return ((String) getAttrVal("Poorsucking_des"));
	}	
	public void setPoorsucking_des(String Poorsucking_des) {
		setAttrVal("Poorsucking_des", Poorsucking_des);
	}
	public Integer getEu_yersxsqk() {
		return ((Integer) getAttrVal("Eu_yersxsqk"));
	}	
	public void setEu_yersxsqk(Integer Eu_yersxsqk) {
		setAttrVal("Eu_yersxsqk", Eu_yersxsqk);
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
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}	
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
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
	public String getName_dep_nur() {
		return ((String) getAttrVal("Name_dep_nur"));
	}	
	public void setName_dep_nur(String Name_dep_nur) {
		setAttrVal("Name_dep_nur", Name_dep_nur);
	}
	public String getName_childbirth_type() {
		return ((String) getAttrVal("Name_childbirth_type"));
	}	
	public void setName_childbirth_type(String Name_childbirth_type) {
		setAttrVal("Name_childbirth_type", Name_childbirth_type);
	}
	public String getName_sign() {
		return ((String) getAttrVal("Name_sign"));
	}	
	public void setName_sign(String Name_sign) {
		setAttrVal("Name_sign", Name_sign);
	}
	public String getName_mothernipple() {
		return ((String) getAttrVal("Name_mothernipple"));
	}	
	public void setName_mothernipple(String Name_mothernipple) {
		setAttrVal("Name_mothernipple", Name_mothernipple);
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
		return "CI_Mr_NU_ANTNURBABY";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(AntNurBabyDODesc.class);
	}
	
}