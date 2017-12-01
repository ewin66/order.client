package iih.ci.mr.nu.obstetrics.birthrec.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.obstetrics.birthrec.d.desc.BirthrecProDODesc;
import java.math.BigDecimal;

/**
 * 产程经过记录 DO数据 
 * 
 */
public class BirthrecProDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_BIRTHRECPRO= "Id_birthrecpro";
	public static final String ID_BIRTHINFO= "Id_birthinfo";
	public static final String TM= "Tm";
	public static final String QM= "Qm";
	public static final String TFW= "Tfw";
	public static final String GD= "Gd";
	public static final String YS= "Ys";
	public static final String MB= "Mb";
	public static final String GSCX= "Gscx";
	public static final String SZY= "Szy";
	public static final String GSJG= "Gsjg";
	public static final String SSY= "Ssy";
	public static final String TX= "Tx";
	public static final String TW= "Tw";
	public static final String RQ= "Rq";
	public static final String EU_GSQR= "Eu_gsqr";
	public static final String BZ= "Bz";
	public static final String GK= "Gk";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_birthrecpro() {
		return ((String) getAttrVal("Id_birthrecpro"));
	}	
	public void setId_birthrecpro(String Id_birthrecpro) {
		setAttrVal("Id_birthrecpro", Id_birthrecpro);
	}
	public String getId_birthinfo() {
		return ((String) getAttrVal("Id_birthinfo"));
	}	
	public void setId_birthinfo(String Id_birthinfo) {
		setAttrVal("Id_birthinfo", Id_birthinfo);
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
	public String getTfw() {
		return ((String) getAttrVal("Tfw"));
	}	
	public void setTfw(String Tfw) {
		setAttrVal("Tfw", Tfw);
	}
	public String getGd() {
		return ((String) getAttrVal("Gd"));
	}	
	public void setGd(String Gd) {
		setAttrVal("Gd", Gd);
	}
	public String getYs() {
		return ((String) getAttrVal("Ys"));
	}	
	public void setYs(String Ys) {
		setAttrVal("Ys", Ys);
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
	public FDouble getTw() {
		return ((FDouble) getAttrVal("Tw"));
	}	
	public void setTw(FDouble Tw) {
		setAttrVal("Tw", Tw);
	}
	public FDateTime getRq() {
		return ((FDateTime) getAttrVal("Rq"));
	}	
	public void setRq(FDateTime Rq) {
		setAttrVal("Rq", Rq);
	}
	public Integer getEu_gsqr() {
		return ((Integer) getAttrVal("Eu_gsqr"));
	}	
	public void setEu_gsqr(Integer Eu_gsqr) {
		setAttrVal("Eu_gsqr", Eu_gsqr);
	}
	public String getBz() {
		return ((String) getAttrVal("Bz"));
	}	
	public void setBz(String Bz) {
		setAttrVal("Bz", Bz);
	}
	public String getGk() {
		return ((String) getAttrVal("Gk"));
	}	
	public void setGk(String Gk) {
		setAttrVal("Gk", Gk);
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
		return "Id_birthrecpro";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_MR_NU_BIRTHRECPRO";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BirthrecProDODesc.class);
	}
	
}