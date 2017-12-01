package iih.ci.mr.nu.obstetrics.hospitalassess.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.obstetrics.hospitalassess.d.desc.HospAssessDODesc;
import java.math.BigDecimal;

/**
 * 妇产科入院评估 DO数据 
 * 
 */
public class HospAssessDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_HA= "Id_ha";
	public static final String KS= "Ks";
	public static final String CH= "Ch";
	public static final String XM= "Xm";
	public static final String NL= "Nl";
	public static final String ZYH= "Zyh";
	public static final String RYSJ= "Rysj";
	public static final String RYZD= "Ryzd";
	public static final String EU_RYFS= "Eu_ryfs";
	public static final String GMS= "Gms";
	public static final String ID_GGQK= "Id_ggqk";
	public static final String SD_GGQK= "Sd_ggqk";
	public static final String ID_GGQKQT= "Id_ggqkqt";
	public static final String SD_GGQKQT= "Sd_ggqkqt";
	public static final String EU_HLJB= "Eu_hljb";
	public static final String EU_HD= "Eu_hd";
	public static final String QM= "Qm";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_DEPT= "Id_dept";
	public static final String ID_PAT= "Id_pat";
	public static final String ID_ASSESS= "Id_assess";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DEPT_NAME= "Dept_name";
	public static final String PAT_NAME= "Pat_name";
	public static final String ASSESS_NAME= "Assess_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_ha() {
		return ((String) getAttrVal("Id_ha"));
	}	
	public void setId_ha(String Id_ha) {
		setAttrVal("Id_ha", Id_ha);
	}
	public String getKs() {
		return ((String) getAttrVal("Ks"));
	}	
	public void setKs(String Ks) {
		setAttrVal("Ks", Ks);
	}
	public String getCh() {
		return ((String) getAttrVal("Ch"));
	}	
	public void setCh(String Ch) {
		setAttrVal("Ch", Ch);
	}
	public String getXm() {
		return ((String) getAttrVal("Xm"));
	}	
	public void setXm(String Xm) {
		setAttrVal("Xm", Xm);
	}
	public String getNl() {
		return ((String) getAttrVal("Nl"));
	}	
	public void setNl(String Nl) {
		setAttrVal("Nl", Nl);
	}
	public String getZyh() {
		return ((String) getAttrVal("Zyh"));
	}	
	public void setZyh(String Zyh) {
		setAttrVal("Zyh", Zyh);
	}
	public FDateTime getRysj() {
		return ((FDateTime) getAttrVal("Rysj"));
	}	
	public void setRysj(FDateTime Rysj) {
		setAttrVal("Rysj", Rysj);
	}
	public String getRyzd() {
		return ((String) getAttrVal("Ryzd"));
	}	
	public void setRyzd(String Ryzd) {
		setAttrVal("Ryzd", Ryzd);
	}
	public Integer getEu_ryfs() {
		return ((Integer) getAttrVal("Eu_ryfs"));
	}	
	public void setEu_ryfs(Integer Eu_ryfs) {
		setAttrVal("Eu_ryfs", Eu_ryfs);
	}
	public String getGms() {
		return ((String) getAttrVal("Gms"));
	}	
	public void setGms(String Gms) {
		setAttrVal("Gms", Gms);
	}
	public String getId_ggqk() {
		return ((String) getAttrVal("Id_ggqk"));
	}	
	public void setId_ggqk(String Id_ggqk) {
		setAttrVal("Id_ggqk", Id_ggqk);
	}
	public String getSd_ggqk() {
		return ((String) getAttrVal("Sd_ggqk"));
	}	
	public void setSd_ggqk(String Sd_ggqk) {
		setAttrVal("Sd_ggqk", Sd_ggqk);
	}
	public String getId_ggqkqt() {
		return ((String) getAttrVal("Id_ggqkqt"));
	}	
	public void setId_ggqkqt(String Id_ggqkqt) {
		setAttrVal("Id_ggqkqt", Id_ggqkqt);
	}
	public String getSd_ggqkqt() {
		return ((String) getAttrVal("Sd_ggqkqt"));
	}	
	public void setSd_ggqkqt(String Sd_ggqkqt) {
		setAttrVal("Sd_ggqkqt", Sd_ggqkqt);
	}
	public Integer getEu_hljb() {
		return ((Integer) getAttrVal("Eu_hljb"));
	}	
	public void setEu_hljb(Integer Eu_hljb) {
		setAttrVal("Eu_hljb", Eu_hljb);
	}
	public Integer getEu_hd() {
		return ((Integer) getAttrVal("Eu_hd"));
	}	
	public void setEu_hd(Integer Eu_hd) {
		setAttrVal("Eu_hd", Eu_hd);
	}
	public String getQm() {
		return ((String) getAttrVal("Qm"));
	}	
	public void setQm(String Qm) {
		setAttrVal("Qm", Qm);
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
	public String getId_dept() {
		return ((String) getAttrVal("Id_dept"));
	}	
	public void setId_dept(String Id_dept) {
		setAttrVal("Id_dept", Id_dept);
	}
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	public String getId_assess() {
		return ((String) getAttrVal("Id_assess"));
	}	
	public void setId_assess(String Id_assess) {
		setAttrVal("Id_assess", Id_assess);
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
	public String getDept_name() {
		return ((String) getAttrVal("Dept_name"));
	}	
	public void setDept_name(String Dept_name) {
		setAttrVal("Dept_name", Dept_name);
	}
	public String getPat_name() {
		return ((String) getAttrVal("Pat_name"));
	}	
	public void setPat_name(String Pat_name) {
		setAttrVal("Pat_name", Pat_name);
	}
	public String getAssess_name() {
		return ((String) getAttrVal("Assess_name"));
	}	
	public void setAssess_name(String Assess_name) {
		setAttrVal("Assess_name", Assess_name);
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
		return "Id_ha";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_MR_NU_ADH_HA";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HospAssessDODesc.class);
	}
	
}