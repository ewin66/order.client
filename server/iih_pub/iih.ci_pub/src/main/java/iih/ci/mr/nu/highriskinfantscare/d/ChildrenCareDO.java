package iih.ci.mr.nu.highriskinfantscare.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.highriskinfantscare.d.desc.ChildrenCareDODesc;
import java.math.BigDecimal;

/**
 * 高危儿童护理记录 DO数据 
 * 
 */
public class ChildrenCareDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_CHCARE= "Id_chcare";
	public static final String CH= "Ch";
	public static final String ZYH= "Zyh";
	public static final String XM= "Xm";
	public static final String RL= "Rl";
	public static final String BS= "Bs";
	public static final String QM= "Qm";
	public static final String QD= "Qd";
	public static final String PF= "Pf";
	public static final String GYMC= "Gymc";
	public static final String TYDZ= "Tydz";
	public static final String XYFS= "Xyfs";
	public static final String FS= "Fs";
	public static final String ZZHD= "Zzhd";
	public static final String GYYF= "Gyyf";
	public static final String GYSD= "Gysd";
	public static final String GYJL= "Gyjl";
	public static final String NR= "Nr";
	public static final String JZL= "Jzl";
	public static final String YS= "Ys";
	public static final String KS= "Ks";
	public static final String FZ= "Fz";
	public static final String SXL= "Sxl";
	public static final String BQBHJCZ= "Bqbhjcz";
	public static final String YLML= "Ylml";
	public static final String DBGC= "Dbgc";
	public static final String PCF= "Pcf";
	public static final String RCF= "Rcf";
	public static final String SPO2= "Spo2";
	public static final String OTML= "Otml";
	public static final String XYND= "Xynd";
	public static final String BPMMHG= "Bpmmhg";
	public static final String XBMLC= "Xbmlc";
	public static final String YL= "Yl";
	public static final String XW= "Xw";
	public static final String SD= "Sd";
	public static final String T= "T";
	public static final String RQ= "Rq";
	public static final String SJ= "Sj";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_PAT= "Name_pat";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_chcare() {
		return ((String) getAttrVal("Id_chcare"));
	}	
	public void setId_chcare(String Id_chcare) {
		setAttrVal("Id_chcare", Id_chcare);
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
	public String getXm() {
		return ((String) getAttrVal("Xm"));
	}	
	public void setXm(String Xm) {
		setAttrVal("Xm", Xm);
	}
	public Integer getRl() {
		return ((Integer) getAttrVal("Rl"));
	}	
	public void setRl(Integer Rl) {
		setAttrVal("Rl", Rl);
	}
	public String getBs() {
		return ((String) getAttrVal("Bs"));
	}	
	public void setBs(String Bs) {
		setAttrVal("Bs", Bs);
	}
	public String getQm() {
		return ((String) getAttrVal("Qm"));
	}	
	public void setQm(String Qm) {
		setAttrVal("Qm", Qm);
	}
	public String getQd() {
		return ((String) getAttrVal("Qd"));
	}	
	public void setQd(String Qd) {
		setAttrVal("Qd", Qd);
	}
	public String getPf() {
		return ((String) getAttrVal("Pf"));
	}	
	public void setPf(String Pf) {
		setAttrVal("Pf", Pf);
	}
	public String getGymc() {
		return ((String) getAttrVal("Gymc"));
	}	
	public void setGymc(String Gymc) {
		setAttrVal("Gymc", Gymc);
	}
	public String getTydz() {
		return ((String) getAttrVal("Tydz"));
	}	
	public void setTydz(String Tydz) {
		setAttrVal("Tydz", Tydz);
	}
	public String getXyfs() {
		return ((String) getAttrVal("Xyfs"));
	}	
	public void setXyfs(String Xyfs) {
		setAttrVal("Xyfs", Xyfs);
	}
	public String getFs() {
		return ((String) getAttrVal("Fs"));
	}	
	public void setFs(String Fs) {
		setAttrVal("Fs", Fs);
	}
	public String getZzhd() {
		return ((String) getAttrVal("Zzhd"));
	}	
	public void setZzhd(String Zzhd) {
		setAttrVal("Zzhd", Zzhd);
	}
	public String getGyyf() {
		return ((String) getAttrVal("Gyyf"));
	}	
	public void setGyyf(String Gyyf) {
		setAttrVal("Gyyf", Gyyf);
	}
	public String getGysd() {
		return ((String) getAttrVal("Gysd"));
	}	
	public void setGysd(String Gysd) {
		setAttrVal("Gysd", Gysd);
	}
	public String getGyjl() {
		return ((String) getAttrVal("Gyjl"));
	}	
	public void setGyjl(String Gyjl) {
		setAttrVal("Gyjl", Gyjl);
	}
	public String getNr() {
		return ((String) getAttrVal("Nr"));
	}	
	public void setNr(String Nr) {
		setAttrVal("Nr", Nr);
	}
	public String getJzl() {
		return ((String) getAttrVal("Jzl"));
	}	
	public void setJzl(String Jzl) {
		setAttrVal("Jzl", Jzl);
	}
	public String getYs() {
		return ((String) getAttrVal("Ys"));
	}	
	public void setYs(String Ys) {
		setAttrVal("Ys", Ys);
	}
	public String getKs() {
		return ((String) getAttrVal("Ks"));
	}	
	public void setKs(String Ks) {
		setAttrVal("Ks", Ks);
	}
	public String getFz() {
		return ((String) getAttrVal("Fz"));
	}	
	public void setFz(String Fz) {
		setAttrVal("Fz", Fz);
	}
	public String getSxl() {
		return ((String) getAttrVal("Sxl"));
	}	
	public void setSxl(String Sxl) {
		setAttrVal("Sxl", Sxl);
	}
	public String getBqbhjcz() {
		return ((String) getAttrVal("Bqbhjcz"));
	}	
	public void setBqbhjcz(String Bqbhjcz) {
		setAttrVal("Bqbhjcz", Bqbhjcz);
	}
	public Integer getYlml() {
		return ((Integer) getAttrVal("Ylml"));
	}	
	public void setYlml(Integer Ylml) {
		setAttrVal("Ylml", Ylml);
	}
	public Integer getDbgc() {
		return ((Integer) getAttrVal("Dbgc"));
	}	
	public void setDbgc(Integer Dbgc) {
		setAttrVal("Dbgc", Dbgc);
	}
	public Integer getPcf() {
		return ((Integer) getAttrVal("Pcf"));
	}	
	public void setPcf(Integer Pcf) {
		setAttrVal("Pcf", Pcf);
	}
	public Integer getRcf() {
		return ((Integer) getAttrVal("Rcf"));
	}	
	public void setRcf(Integer Rcf) {
		setAttrVal("Rcf", Rcf);
	}
	public Integer getSpo2() {
		return ((Integer) getAttrVal("Spo2"));
	}	
	public void setSpo2(Integer Spo2) {
		setAttrVal("Spo2", Spo2);
	}
	public Integer getOtml() {
		return ((Integer) getAttrVal("Otml"));
	}	
	public void setOtml(Integer Otml) {
		setAttrVal("Otml", Otml);
	}
	public Integer getXynd() {
		return ((Integer) getAttrVal("Xynd"));
	}	
	public void setXynd(Integer Xynd) {
		setAttrVal("Xynd", Xynd);
	}
	public Integer getBpmmhg() {
		return ((Integer) getAttrVal("Bpmmhg"));
	}	
	public void setBpmmhg(Integer Bpmmhg) {
		setAttrVal("Bpmmhg", Bpmmhg);
	}
	public Integer getXbmlc() {
		return ((Integer) getAttrVal("Xbmlc"));
	}	
	public void setXbmlc(Integer Xbmlc) {
		setAttrVal("Xbmlc", Xbmlc);
	}
	public Integer getYl() {
		return ((Integer) getAttrVal("Yl"));
	}	
	public void setYl(Integer Yl) {
		setAttrVal("Yl", Yl);
	}
	public FDouble getXw() {
		return ((FDouble) getAttrVal("Xw"));
	}	
	public void setXw(FDouble Xw) {
		setAttrVal("Xw", Xw);
	}
	public FDouble getSd() {
		return ((FDouble) getAttrVal("Sd"));
	}	
	public void setSd(FDouble Sd) {
		setAttrVal("Sd", Sd);
	}
	public FDouble getT() {
		return ((FDouble) getAttrVal("T"));
	}	
	public void setT(FDouble T) {
		setAttrVal("T", T);
	}
	public FDate getRq() {
		return ((FDate) getAttrVal("Rq"));
	}	
	public void setRq(FDate Rq) {
		setAttrVal("Rq", Rq);
	}
	public FTime getSj() {
		return ((FTime) getAttrVal("Sj"));
	}	
	public void setSj(FTime Sj) {
		setAttrVal("Sj", Sj);
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
		return "Id_chcare";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_MR_NU_CHCARE";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ChildrenCareDODesc.class);
	}
	
}