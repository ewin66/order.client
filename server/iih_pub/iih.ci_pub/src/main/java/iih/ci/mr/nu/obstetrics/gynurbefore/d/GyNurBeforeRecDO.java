package iih.ci.mr.nu.obstetrics.gynurbefore.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.obstetrics.gynurbefore.d.desc.GyNurBeforeRecDODesc;
import java.math.BigDecimal;

/**
 * 护理记录 DO数据 
 * 
 */
public class GyNurBeforeRecDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_REC= "Id_rec";
	public static final String ID_ASS= "Id_ass";
	public static final String RQ= "Rq";
	public static final String TWT= "Twt";
	public static final String MBP= "Mbp";
	public static final String HXR= "Hxr";
	public static final String SSYSBP= "Ssysbp";
	public static final String SZYDBP= "Szydbp";
	public static final String XYBHDSAO= "Xybhdsao";
	public static final String TX= "Tx";
	public static final String FT= "Ft";
	public static final String ID_YDCX= "Id_ydcx";
	public static final String SD_YDCX= "Sd_ydcx";
	public static final String RLMC= "Rlmc";
	public static final String RLJL= "Rljl";
	public static final String ID_RLYF= "Id_rlyf";
	public static final String SD_RLYF= "Sd_rlyf";
	public static final String CLNL= "Clnl";
	public static final String CLOTL= "Clotl";
	public static final String BQGCJCS= "Bqgcjcs";
	public static final String GCJLQM= "Gcjlqm";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_YDCX= "Name_ydcx";
	public static final String NAME_RLYF= "Name_rlyf";
	public static final String NAME_PSNDOC= "Name_psndoc";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_rec() {
		return ((String) getAttrVal("Id_rec"));
	}	
	public void setId_rec(String Id_rec) {
		setAttrVal("Id_rec", Id_rec);
	}
	public String getId_ass() {
		return ((String) getAttrVal("Id_ass"));
	}	
	public void setId_ass(String Id_ass) {
		setAttrVal("Id_ass", Id_ass);
	}
	public FDateTime getRq() {
		return ((FDateTime) getAttrVal("Rq"));
	}	
	public void setRq(FDateTime Rq) {
		setAttrVal("Rq", Rq);
	}
	public FDouble getTwt() {
		return ((FDouble) getAttrVal("Twt"));
	}	
	public void setTwt(FDouble Twt) {
		setAttrVal("Twt", Twt);
	}
	public Integer getMbp() {
		return ((Integer) getAttrVal("Mbp"));
	}	
	public void setMbp(Integer Mbp) {
		setAttrVal("Mbp", Mbp);
	}
	public Integer getHxr() {
		return ((Integer) getAttrVal("Hxr"));
	}	
	public void setHxr(Integer Hxr) {
		setAttrVal("Hxr", Hxr);
	}
	public Integer getSsysbp() {
		return ((Integer) getAttrVal("Ssysbp"));
	}	
	public void setSsysbp(Integer Ssysbp) {
		setAttrVal("Ssysbp", Ssysbp);
	}
	public Integer getSzydbp() {
		return ((Integer) getAttrVal("Szydbp"));
	}	
	public void setSzydbp(Integer Szydbp) {
		setAttrVal("Szydbp", Szydbp);
	}
	public FDouble getXybhdsao() {
		return ((FDouble) getAttrVal("Xybhdsao"));
	}	
	public void setXybhdsao(FDouble Xybhdsao) {
		setAttrVal("Xybhdsao", Xybhdsao);
	}
	public Integer getTx() {
		return ((Integer) getAttrVal("Tx"));
	}	
	public void setTx(Integer Tx) {
		setAttrVal("Tx", Tx);
	}
	public Integer getFt() {
		return ((Integer) getAttrVal("Ft"));
	}	
	public void setFt(Integer Ft) {
		setAttrVal("Ft", Ft);
	}
	public String getId_ydcx() {
		return ((String) getAttrVal("Id_ydcx"));
	}	
	public void setId_ydcx(String Id_ydcx) {
		setAttrVal("Id_ydcx", Id_ydcx);
	}
	public String getSd_ydcx() {
		return ((String) getAttrVal("Sd_ydcx"));
	}	
	public void setSd_ydcx(String Sd_ydcx) {
		setAttrVal("Sd_ydcx", Sd_ydcx);
	}
	public String getRlmc() {
		return ((String) getAttrVal("Rlmc"));
	}	
	public void setRlmc(String Rlmc) {
		setAttrVal("Rlmc", Rlmc);
	}
	public Integer getRljl() {
		return ((Integer) getAttrVal("Rljl"));
	}	
	public void setRljl(Integer Rljl) {
		setAttrVal("Rljl", Rljl);
	}
	public String getId_rlyf() {
		return ((String) getAttrVal("Id_rlyf"));
	}	
	public void setId_rlyf(String Id_rlyf) {
		setAttrVal("Id_rlyf", Id_rlyf);
	}
	public String getSd_rlyf() {
		return ((String) getAttrVal("Sd_rlyf"));
	}	
	public void setSd_rlyf(String Sd_rlyf) {
		setAttrVal("Sd_rlyf", Sd_rlyf);
	}
	public Integer getClnl() {
		return ((Integer) getAttrVal("Clnl"));
	}	
	public void setClnl(Integer Clnl) {
		setAttrVal("Clnl", Clnl);
	}
	public Integer getClotl() {
		return ((Integer) getAttrVal("Clotl"));
	}	
	public void setClotl(Integer Clotl) {
		setAttrVal("Clotl", Clotl);
	}
	public String getBqgcjcs() {
		return ((String) getAttrVal("Bqgcjcs"));
	}	
	public void setBqgcjcs(String Bqgcjcs) {
		setAttrVal("Bqgcjcs", Bqgcjcs);
	}
	public String getGcjlqm() {
		return ((String) getAttrVal("Gcjlqm"));
	}	
	public void setGcjlqm(String Gcjlqm) {
		setAttrVal("Gcjlqm", Gcjlqm);
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
	public String getName_ydcx() {
		return ((String) getAttrVal("Name_ydcx"));
	}	
	public void setName_ydcx(String Name_ydcx) {
		setAttrVal("Name_ydcx", Name_ydcx);
	}
	public String getName_rlyf() {
		return ((String) getAttrVal("Name_rlyf"));
	}	
	public void setName_rlyf(String Name_rlyf) {
		setAttrVal("Name_rlyf", Name_rlyf);
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
		return "Id_rec";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_MR_NU_GYBEFOREREC";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(GyNurBeforeRecDODesc.class);
	}
	
}