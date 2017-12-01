package iih.ci.mr.nu.obstetrics.antennurbserrec.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.obstetrics.antennurbserrec.d.desc.AntenNurBserRecDODesc;

/**
 * 产科护理观察记录（产后、术后） DO数据 
 * 
 */
public class AntenNurBserRecDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID= "Id";
	public static final String ID_DEPT= "Id_dept";
	public static final String ID_PAT= "Id_pat";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String KS= "Ks";
	public static final String HZ= "Hz";
	public static final String CH= "Ch";
	public static final String ZYH= "Zyh";
	public static final String HZNL= "Hznl";
	public static final String RLMC= "Rlmc";
	public static final String RLYF= "Rlyf";
	public static final String BQGC= "Bqgc";
	public static final String CLCS= "Clcs";
	public static final String QM= "Qm";
	public static final String MBCF= "Mbcf";
	public static final String HXCF= "Hxcf";
	public static final String SSYMMHG= "Ssymmhg";
	public static final String SZYMMHG= "Szymmhg";
	public static final String RLJLML= "Rljlml";
	public static final String GDGD= "Gdgd";
	public static final String YDCXML= "Ydcxml";
	public static final String NLML= "Nlml";
	public static final String TW= "Tw";
	public static final String XYBHD= "Xybhd";
	public static final String JLRQSJ= "Jlrqsj";
	public static final String EU_PFQK= "Eu_pfqk";
	public static final String EU_ZGSS= "Eu_zgss";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_DEPT= "Name_dept";
	public static final String NAME_PAT= "Name_pat";
	public static final String NAME_GROUP= "Name_group";
	public static final String NAME_ORG= "Name_org";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId() {
		return ((String) getAttrVal("Id"));
	}	
	public void setId(String Id) {
		setAttrVal("Id", Id);
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
	public String getKs() {
		return ((String) getAttrVal("Ks"));
	}	
	public void setKs(String Ks) {
		setAttrVal("Ks", Ks);
	}
	public String getHz() {
		return ((String) getAttrVal("Hz"));
	}	
	public void setHz(String Hz) {
		setAttrVal("Hz", Hz);
	}
	public String getCh() {
		return ((String) getAttrVal("Ch"));
	}	
	public void setCh(String Ch) {
		setAttrVal("Ch", Ch);
	}
	public String getZyh() {
		return ((String) getAttrVal("Zyh"));
	}	
	public void setZyh(String Zyh) {
		setAttrVal("Zyh", Zyh);
	}
	public String getHznl() {
		return ((String) getAttrVal("Hznl"));
	}	
	public void setHznl(String Hznl) {
		setAttrVal("Hznl", Hznl);
	}
	public String getRlmc() {
		return ((String) getAttrVal("Rlmc"));
	}	
	public void setRlmc(String Rlmc) {
		setAttrVal("Rlmc", Rlmc);
	}
	public String getRlyf() {
		return ((String) getAttrVal("Rlyf"));
	}	
	public void setRlyf(String Rlyf) {
		setAttrVal("Rlyf", Rlyf);
	}
	public String getBqgc() {
		return ((String) getAttrVal("Bqgc"));
	}	
	public void setBqgc(String Bqgc) {
		setAttrVal("Bqgc", Bqgc);
	}
	public String getClcs() {
		return ((String) getAttrVal("Clcs"));
	}	
	public void setClcs(String Clcs) {
		setAttrVal("Clcs", Clcs);
	}
	public String getQm() {
		return ((String) getAttrVal("Qm"));
	}	
	public void setQm(String Qm) {
		setAttrVal("Qm", Qm);
	}
	public Integer getMbcf() {
		return ((Integer) getAttrVal("Mbcf"));
	}	
	public void setMbcf(Integer Mbcf) {
		setAttrVal("Mbcf", Mbcf);
	}
	public Integer getHxcf() {
		return ((Integer) getAttrVal("Hxcf"));
	}	
	public void setHxcf(Integer Hxcf) {
		setAttrVal("Hxcf", Hxcf);
	}
	public Integer getSsymmhg() {
		return ((Integer) getAttrVal("Ssymmhg"));
	}	
	public void setSsymmhg(Integer Ssymmhg) {
		setAttrVal("Ssymmhg", Ssymmhg);
	}
	public Integer getSzymmhg() {
		return ((Integer) getAttrVal("Szymmhg"));
	}	
	public void setSzymmhg(Integer Szymmhg) {
		setAttrVal("Szymmhg", Szymmhg);
	}
	public Integer getRljlml() {
		return ((Integer) getAttrVal("Rljlml"));
	}	
	public void setRljlml(Integer Rljlml) {
		setAttrVal("Rljlml", Rljlml);
	}
	public Integer getGdgd() {
		return ((Integer) getAttrVal("Gdgd"));
	}	
	public void setGdgd(Integer Gdgd) {
		setAttrVal("Gdgd", Gdgd);
	}
	public Integer getYdcxml() {
		return ((Integer) getAttrVal("Ydcxml"));
	}	
	public void setYdcxml(Integer Ydcxml) {
		setAttrVal("Ydcxml", Ydcxml);
	}
	public Integer getNlml() {
		return ((Integer) getAttrVal("Nlml"));
	}	
	public void setNlml(Integer Nlml) {
		setAttrVal("Nlml", Nlml);
	}
	public FDouble getTw() {
		return ((FDouble) getAttrVal("Tw"));
	}	
	public void setTw(FDouble Tw) {
		setAttrVal("Tw", Tw);
	}
	public FDouble getXybhd() {
		return ((FDouble) getAttrVal("Xybhd"));
	}	
	public void setXybhd(FDouble Xybhd) {
		setAttrVal("Xybhd", Xybhd);
	}
	public FDateTime getJlrqsj() {
		return ((FDateTime) getAttrVal("Jlrqsj"));
	}	
	public void setJlrqsj(FDateTime Jlrqsj) {
		setAttrVal("Jlrqsj", Jlrqsj);
	}
	public String getEu_pfqk() {
		return ((String) getAttrVal("Eu_pfqk"));
	}	
	public void setEu_pfqk(String Eu_pfqk) {
		setAttrVal("Eu_pfqk", Eu_pfqk);
	}
	public String getEu_zgss() {
		return ((String) getAttrVal("Eu_zgss"));
	}	
	public void setEu_zgss(String Eu_zgss) {
		setAttrVal("Eu_zgss", Eu_zgss);
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
	public String getName_dept() {
		return ((String) getAttrVal("Name_dept"));
	}	
	public void setName_dept(String Name_dept) {
		setAttrVal("Name_dept", Name_dept);
	}
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	public String getName_group() {
		return ((String) getAttrVal("Name_group"));
	}	
	public void setName_group(String Name_group) {
		setAttrVal("Name_group", Name_group);
	}
	public String getName_org() {
		return ((String) getAttrVal("Name_org"));
	}	
	public void setName_org(String Name_org) {
		setAttrVal("Name_org", Name_org);
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
		return "Id";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_Mr_NU_ANTNURBSERREC";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(AntenNurBserRecDODesc.class);
	}
	
}