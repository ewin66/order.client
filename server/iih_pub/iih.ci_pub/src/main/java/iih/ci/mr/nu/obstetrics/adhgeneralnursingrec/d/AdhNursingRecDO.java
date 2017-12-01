package iih.ci.mr.nu.obstetrics.adhgeneralnursingrec.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.obstetrics.adhgeneralnursingrec.d.desc.AdhNursingRecDODesc;
import java.math.BigDecimal;

/**
 * 妇产科护理观察记录单 DO数据 
 * 
 */
public class AdhNursingRecDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NR= "Id_nr";
	public static final String KS= "Ks";
	public static final String CH= "Ch";
	public static final String HZ= "Hz";
	public static final String HZNL= "Hznl";
	public static final String ZYH= "Zyh";
	public static final String JLRQSJ= "Jlrqsj";
	public static final String TW= "Tw";
	public static final String MBCF= "Mbcf";
	public static final String HXCF= "Hxcf";
	public static final String SSYMMHG= "Ssymmhg";
	public static final String SZYMMHG= "Szymmhg";
	public static final String TXCF= "Txcf";
	public static final String TDC12H= "Tdc12h";
	public static final String EU_GS= "Eu_gs";
	public static final String EU_TM= "Eu_tm";
	public static final String GKKDCM= "Gkkdcm";
	public static final String RLMC= "Rlmc";
	public static final String RLJLML= "Rljlml";
	public static final String RLYF= "Rlyf";
	public static final String CLMC= "Clmc";
	public static final String CLJLML= "Cljlml";
	public static final String EU_PFQK= "Eu_pfqk";
	public static final String BQGC= "Bqgc";
	public static final String CLCS= "Clcs";
	public static final String QM= "Qm";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_DEPT= "Id_dept";
	public static final String ID_PAT= "Id_pat";
	public static final String DEPT_NAME= "Dept_name";
	public static final String PAT_NAME= "Pat_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_nr() {
		return ((String) getAttrVal("Id_nr"));
	}	
	public void setId_nr(String Id_nr) {
		setAttrVal("Id_nr", Id_nr);
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
	public String getHz() {
		return ((String) getAttrVal("Hz"));
	}	
	public void setHz(String Hz) {
		setAttrVal("Hz", Hz);
	}
	public String getHznl() {
		return ((String) getAttrVal("Hznl"));
	}	
	public void setHznl(String Hznl) {
		setAttrVal("Hznl", Hznl);
	}
	public String getZyh() {
		return ((String) getAttrVal("Zyh"));
	}	
	public void setZyh(String Zyh) {
		setAttrVal("Zyh", Zyh);
	}
	public FDateTime getJlrqsj() {
		return ((FDateTime) getAttrVal("Jlrqsj"));
	}	
	public void setJlrqsj(FDateTime Jlrqsj) {
		setAttrVal("Jlrqsj", Jlrqsj);
	}
	public FDouble getTw() {
		return ((FDouble) getAttrVal("Tw"));
	}	
	public void setTw(FDouble Tw) {
		setAttrVal("Tw", Tw);
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
	public String getTxcf() {
		return ((String) getAttrVal("Txcf"));
	}	
	public void setTxcf(String Txcf) {
		setAttrVal("Txcf", Txcf);
	}
	public String getTdc12h() {
		return ((String) getAttrVal("Tdc12h"));
	}	
	public void setTdc12h(String Tdc12h) {
		setAttrVal("Tdc12h", Tdc12h);
	}
	public Integer getEu_gs() {
		return ((Integer) getAttrVal("Eu_gs"));
	}	
	public void setEu_gs(Integer Eu_gs) {
		setAttrVal("Eu_gs", Eu_gs);
	}
	public Integer getEu_tm() {
		return ((Integer) getAttrVal("Eu_tm"));
	}	
	public void setEu_tm(Integer Eu_tm) {
		setAttrVal("Eu_tm", Eu_tm);
	}
	public Integer getGkkdcm() {
		return ((Integer) getAttrVal("Gkkdcm"));
	}	
	public void setGkkdcm(Integer Gkkdcm) {
		setAttrVal("Gkkdcm", Gkkdcm);
	}
	public String getRlmc() {
		return ((String) getAttrVal("Rlmc"));
	}	
	public void setRlmc(String Rlmc) {
		setAttrVal("Rlmc", Rlmc);
	}
	public Integer getRljlml() {
		return ((Integer) getAttrVal("Rljlml"));
	}	
	public void setRljlml(Integer Rljlml) {
		setAttrVal("Rljlml", Rljlml);
	}
	public String getRlyf() {
		return ((String) getAttrVal("Rlyf"));
	}	
	public void setRlyf(String Rlyf) {
		setAttrVal("Rlyf", Rlyf);
	}
	public String getClmc() {
		return ((String) getAttrVal("Clmc"));
	}	
	public void setClmc(String Clmc) {
		setAttrVal("Clmc", Clmc);
	}
	public Integer getCljlml() {
		return ((Integer) getAttrVal("Cljlml"));
	}	
	public void setCljlml(Integer Cljlml) {
		setAttrVal("Cljlml", Cljlml);
	}
	public Integer getEu_pfqk() {
		return ((Integer) getAttrVal("Eu_pfqk"));
	}	
	public void setEu_pfqk(Integer Eu_pfqk) {
		setAttrVal("Eu_pfqk", Eu_pfqk);
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
		return "Id_nr";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_Mr_NU_ADH_NR";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(AdhNursingRecDODesc.class);
	}
	
}