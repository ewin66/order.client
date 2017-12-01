package iih.ci.mr.cimrfs.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.cimrfs.d.desc.CiMrFsDODesc;
import java.math.BigDecimal;

/**
 * 临床医疗记录流数据 DO数据 
 * 
 */
public class CiMrFsDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MRFS= "Id_mrfs";
	public static final String ID_MR= "Id_mr";
	public static final String EMRFS= "Emrfs";
	public static final String EMRXML= "Emrxml";
	public static final String EMRFS_PRN= "Emrfs_prn";
	public static final String FG_COMPRESS= "Fg_compress";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_mrfs() {
		return ((String) getAttrVal("Id_mrfs"));
	}	
	public void setId_mrfs(String Id_mrfs) {
		setAttrVal("Id_mrfs", Id_mrfs);
	}
	public String getId_mr() {
		return ((String) getAttrVal("Id_mr"));
	}	
	public void setId_mr(String Id_mr) {
		setAttrVal("Id_mr", Id_mr);
	}
	public byte[] getEmrfs() {
		return ((byte[]) getAttrVal("Emrfs"));
	}	
	public void setEmrfs(byte[] Emrfs) {
		setAttrVal("Emrfs", Emrfs);
	}
	public byte[] getEmrxml() {
		return ((byte[]) getAttrVal("Emrxml"));
	}	
	public void setEmrxml(byte[] Emrxml) {
		setAttrVal("Emrxml", Emrxml);
	}
	public byte[] getEmrfs_prn() {
		return ((byte[]) getAttrVal("Emrfs_prn"));
	}	
	public void setEmrfs_prn(byte[] Emrfs_prn) {
		setAttrVal("Emrfs_prn", Emrfs_prn);
	}
	public FBoolean getFg_compress() {
		return ((FBoolean) getAttrVal("Fg_compress"));
	}	
	public void setFg_compress(FBoolean Fg_compress) {
		setAttrVal("Fg_compress", Fg_compress);
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
		return "Id_mrfs";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_mr_fs";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiMrFsDODesc.class);
	}
	
}