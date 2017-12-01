package iih.ci.mr.nu.obstetrics.barthelassess.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.obstetrics.barthelassess.d.desc.BarthelAssessDODesc;
import java.math.BigDecimal;

/**
 * 妇产科Barthel指数评估 DO数据 
 * 
 */
public class BarthelAssessDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_BA= "Id_ba";
	public static final String KS= "Ks";
	public static final String CH= "Ch";
	public static final String XM= "Xm";
	public static final String ZYH= "Zyh";
	public static final String EU_JS= "Eu_js";
	public static final String EU_XZ= "Eu_xz";
	public static final String EU_XS= "Eu_xs";
	public static final String EU_CY= "Eu_cy";
	public static final String EU_KZDB= "Eu_kzdb";
	public static final String EU_KZXB= "Eu_kzxb";
	public static final String EU_RC= "Eu_rc";
	public static final String EU_CYYD= "Eu_cyyd";
	public static final String EU_PDXZ= "Eu_pdxz";
	public static final String EU_SXLT= "Eu_sxlt";
	public static final String ZF= "Zf";
	public static final String PGRQSJ= "Pgrqsj";
	public static final String PGR= "Pgr";
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
	
	public String getId_ba() {
		return ((String) getAttrVal("Id_ba"));
	}	
	public void setId_ba(String Id_ba) {
		setAttrVal("Id_ba", Id_ba);
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
	public String getZyh() {
		return ((String) getAttrVal("Zyh"));
	}	
	public void setZyh(String Zyh) {
		setAttrVal("Zyh", Zyh);
	}
	public Integer getEu_js() {
		return ((Integer) getAttrVal("Eu_js"));
	}	
	public void setEu_js(Integer Eu_js) {
		setAttrVal("Eu_js", Eu_js);
	}
	public Integer getEu_xz() {
		return ((Integer) getAttrVal("Eu_xz"));
	}	
	public void setEu_xz(Integer Eu_xz) {
		setAttrVal("Eu_xz", Eu_xz);
	}
	public Integer getEu_xs() {
		return ((Integer) getAttrVal("Eu_xs"));
	}	
	public void setEu_xs(Integer Eu_xs) {
		setAttrVal("Eu_xs", Eu_xs);
	}
	public Integer getEu_cy() {
		return ((Integer) getAttrVal("Eu_cy"));
	}	
	public void setEu_cy(Integer Eu_cy) {
		setAttrVal("Eu_cy", Eu_cy);
	}
	public Integer getEu_kzdb() {
		return ((Integer) getAttrVal("Eu_kzdb"));
	}	
	public void setEu_kzdb(Integer Eu_kzdb) {
		setAttrVal("Eu_kzdb", Eu_kzdb);
	}
	public Integer getEu_kzxb() {
		return ((Integer) getAttrVal("Eu_kzxb"));
	}	
	public void setEu_kzxb(Integer Eu_kzxb) {
		setAttrVal("Eu_kzxb", Eu_kzxb);
	}
	public Integer getEu_rc() {
		return ((Integer) getAttrVal("Eu_rc"));
	}	
	public void setEu_rc(Integer Eu_rc) {
		setAttrVal("Eu_rc", Eu_rc);
	}
	public Integer getEu_cyyd() {
		return ((Integer) getAttrVal("Eu_cyyd"));
	}	
	public void setEu_cyyd(Integer Eu_cyyd) {
		setAttrVal("Eu_cyyd", Eu_cyyd);
	}
	public Integer getEu_pdxz() {
		return ((Integer) getAttrVal("Eu_pdxz"));
	}	
	public void setEu_pdxz(Integer Eu_pdxz) {
		setAttrVal("Eu_pdxz", Eu_pdxz);
	}
	public Integer getEu_sxlt() {
		return ((Integer) getAttrVal("Eu_sxlt"));
	}	
	public void setEu_sxlt(Integer Eu_sxlt) {
		setAttrVal("Eu_sxlt", Eu_sxlt);
	}
	public Integer getZf() {
		return ((Integer) getAttrVal("Zf"));
	}	
	public void setZf(Integer Zf) {
		setAttrVal("Zf", Zf);
	}
	public FDateTime getPgrqsj() {
		return ((FDateTime) getAttrVal("Pgrqsj"));
	}	
	public void setPgrqsj(FDateTime Pgrqsj) {
		setAttrVal("Pgrqsj", Pgrqsj);
	}
	public String getPgr() {
		return ((String) getAttrVal("Pgr"));
	}	
	public void setPgr(String Pgr) {
		setAttrVal("Pgr", Pgr);
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
		return "Id_ba";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_MR_NU_ADH_BA";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BarthelAssessDODesc.class);
	}
	
}