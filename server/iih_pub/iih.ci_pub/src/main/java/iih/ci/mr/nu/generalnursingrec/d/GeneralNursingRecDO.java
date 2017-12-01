package iih.ci.mr.nu.generalnursingrec.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.generalnursingrec.d.desc.GeneralNursingRecDODesc;
import java.math.BigDecimal;

/**
 * 一般护理记录 DO数据 
 * 
 */
public class GeneralNursingRecDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_GNR_REC= "Id_gnr_rec";
	public static final String ID_GNR= "Id_gnr";
	public static final String CONDITIONTREATMENT= "Conditiontreatment";
	public static final String DT_REC= "Dt_rec";
	public static final String SIGNATURE= "Signature";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_SIGN= "Name_sign";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_gnr_rec() {
		return ((String) getAttrVal("Id_gnr_rec"));
	}	
	public void setId_gnr_rec(String Id_gnr_rec) {
		setAttrVal("Id_gnr_rec", Id_gnr_rec);
	}
	public String getId_gnr() {
		return ((String) getAttrVal("Id_gnr"));
	}	
	public void setId_gnr(String Id_gnr) {
		setAttrVal("Id_gnr", Id_gnr);
	}
	public String getConditiontreatment() {
		return ((String) getAttrVal("Conditiontreatment"));
	}	
	public void setConditiontreatment(String Conditiontreatment) {
		setAttrVal("Conditiontreatment", Conditiontreatment);
	}
	public FDateTime getDt_rec() {
		return ((FDateTime) getAttrVal("Dt_rec"));
	}	
	public void setDt_rec(FDateTime Dt_rec) {
		setAttrVal("Dt_rec", Dt_rec);
	}
	public String getSignature() {
		return ((String) getAttrVal("Signature"));
	}	
	public void setSignature(String Signature) {
		setAttrVal("Signature", Signature);
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
	public String getName_sign() {
		return ((String) getAttrVal("Name_sign"));
	}	
	public void setName_sign(String Name_sign) {
		setAttrVal("Name_sign", Name_sign);
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
		return "Id_gnr_rec";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_MR_NU_GNR_REC";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(GeneralNursingRecDODesc.class);
	}
	
}