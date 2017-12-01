package iih.ci.mr.nu.obstetrics.birthrec.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.obstetrics.birthrec.d.desc.BirthrecInDODesc;
import java.math.BigDecimal;

/**
 * 入产房时护理记录 DO数据 
 * 
 */
public class BirthrecInDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_BIRTHRECIN= "Id_birthrecin";
	public static final String ID_BIRTHINFO= "Id_birthinfo";
	public static final String TW= "Tw";
	public static final String XL= "Xl";
	public static final String JC= "Jc";
	public static final String GK= "Gk";
	public static final String TM= "Tm";
	public static final String QM= "Qm";
	public static final String MB= "Mb";
	public static final String GSCX= "Gscx";
	public static final String SZY= "Szy";
	public static final String GSJG= "Gsjg";
	public static final String SSY= "Ssy";
	public static final String TX= "Tx";
	public static final String TEDX= "Tedx";
	public static final String TEMP= "Temp";
	public static final String RQ= "Rq";
	public static final String GSQR= "Gsqr";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_birthrecin() {
		return ((String) getAttrVal("Id_birthrecin"));
	}	
	public void setId_birthrecin(String Id_birthrecin) {
		setAttrVal("Id_birthrecin", Id_birthrecin);
	}
	public String getId_birthinfo() {
		return ((String) getAttrVal("Id_birthinfo"));
	}	
	public void setId_birthinfo(String Id_birthinfo) {
		setAttrVal("Id_birthinfo", Id_birthinfo);
	}
	public String getTw() {
		return ((String) getAttrVal("Tw"));
	}	
	public void setTw(String Tw) {
		setAttrVal("Tw", Tw);
	}
	public String getXl() {
		return ((String) getAttrVal("Xl"));
	}	
	public void setXl(String Xl) {
		setAttrVal("Xl", Xl);
	}
	public String getJc() {
		return ((String) getAttrVal("Jc"));
	}	
	public void setJc(String Jc) {
		setAttrVal("Jc", Jc);
	}
	public String getGk() {
		return ((String) getAttrVal("Gk"));
	}	
	public void setGk(String Gk) {
		setAttrVal("Gk", Gk);
	}
	public String getTm() {
		return ((String) getAttrVal("Tm"));
	}	
	public void setTm(String Tm) {
		setAttrVal("Tm", Tm);
	}
	public String getQm() {
		return ((String) getAttrVal("Qm"));
	}	
	public void setQm(String Qm) {
		setAttrVal("Qm", Qm);
	}
	public Integer getMb() {
		return ((Integer) getAttrVal("Mb"));
	}	
	public void setMb(Integer Mb) {
		setAttrVal("Mb", Mb);
	}
	public Integer getGscx() {
		return ((Integer) getAttrVal("Gscx"));
	}	
	public void setGscx(Integer Gscx) {
		setAttrVal("Gscx", Gscx);
	}
	public Integer getSzy() {
		return ((Integer) getAttrVal("Szy"));
	}	
	public void setSzy(Integer Szy) {
		setAttrVal("Szy", Szy);
	}
	public Integer getGsjg() {
		return ((Integer) getAttrVal("Gsjg"));
	}	
	public void setGsjg(Integer Gsjg) {
		setAttrVal("Gsjg", Gsjg);
	}
	public Integer getSsy() {
		return ((Integer) getAttrVal("Ssy"));
	}	
	public void setSsy(Integer Ssy) {
		setAttrVal("Ssy", Ssy);
	}
	public Integer getTx() {
		return ((Integer) getAttrVal("Tx"));
	}	
	public void setTx(Integer Tx) {
		setAttrVal("Tx", Tx);
	}
	public Integer getTedx() {
		return ((Integer) getAttrVal("Tedx"));
	}	
	public void setTedx(Integer Tedx) {
		setAttrVal("Tedx", Tedx);
	}
	public FDouble getTemp() {
		return ((FDouble) getAttrVal("Temp"));
	}	
	public void setTemp(FDouble Temp) {
		setAttrVal("Temp", Temp);
	}
	public FDateTime getRq() {
		return ((FDateTime) getAttrVal("Rq"));
	}	
	public void setRq(FDateTime Rq) {
		setAttrVal("Rq", Rq);
	}
	public Integer getGsqr() {
		return ((Integer) getAttrVal("Gsqr"));
	}	
	public void setGsqr(Integer Gsqr) {
		setAttrVal("Gsqr", Gsqr);
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
		return "Id_birthrecin";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_MR_NU_BIRTHRECIN";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BirthrecInDODesc.class);
	}
	
}