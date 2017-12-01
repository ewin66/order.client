package iih.ci.mr.nu.obstetrics.opernurecord.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.obstetrics.opernurecord.d.desc.OperNuRecordEqmDODesc;
import java.math.BigDecimal;

/**
 * 手术室器材 DO数据 
 * 
 */
public class OperNuRecordEqmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_OPRCOD_EQM= "Id_oprcod_eqm";
	public static final String ID_OPRCOD= "Id_oprcod";
	public static final String ID_EQMTP= "Id_eqmtp";
	public static final String SD_EQMTP= "Sd_eqmtp";
	public static final String ID_EQM= "Id_eqm";
	public static final String SD_EQM= "Sd_eqm";
	public static final String NUM_OPRBEFOR= "Num_oprbefor";
	public static final String NUM_BEFOR= "Num_befor";
	public static final String NUM_AFTER= "Num_after";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_TP= "Name_tp";
	public static final String NAME= "Name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_oprcod_eqm() {
		return ((String) getAttrVal("Id_oprcod_eqm"));
	}	
	public void setId_oprcod_eqm(String Id_oprcod_eqm) {
		setAttrVal("Id_oprcod_eqm", Id_oprcod_eqm);
	}
	public String getId_oprcod() {
		return ((String) getAttrVal("Id_oprcod"));
	}	
	public void setId_oprcod(String Id_oprcod) {
		setAttrVal("Id_oprcod", Id_oprcod);
	}
	public String getId_eqmtp() {
		return ((String) getAttrVal("Id_eqmtp"));
	}	
	public void setId_eqmtp(String Id_eqmtp) {
		setAttrVal("Id_eqmtp", Id_eqmtp);
	}
	public String getSd_eqmtp() {
		return ((String) getAttrVal("Sd_eqmtp"));
	}	
	public void setSd_eqmtp(String Sd_eqmtp) {
		setAttrVal("Sd_eqmtp", Sd_eqmtp);
	}
	public String getId_eqm() {
		return ((String) getAttrVal("Id_eqm"));
	}	
	public void setId_eqm(String Id_eqm) {
		setAttrVal("Id_eqm", Id_eqm);
	}
	public String getSd_eqm() {
		return ((String) getAttrVal("Sd_eqm"));
	}	
	public void setSd_eqm(String Sd_eqm) {
		setAttrVal("Sd_eqm", Sd_eqm);
	}
	public Integer getNum_oprbefor() {
		return ((Integer) getAttrVal("Num_oprbefor"));
	}	
	public void setNum_oprbefor(Integer Num_oprbefor) {
		setAttrVal("Num_oprbefor", Num_oprbefor);
	}
	public Integer getNum_befor() {
		return ((Integer) getAttrVal("Num_befor"));
	}	
	public void setNum_befor(Integer Num_befor) {
		setAttrVal("Num_befor", Num_befor);
	}
	public Integer getNum_after() {
		return ((Integer) getAttrVal("Num_after"));
	}	
	public void setNum_after(Integer Num_after) {
		setAttrVal("Num_after", Num_after);
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
	public String getName_tp() {
		return ((String) getAttrVal("Name_tp"));
	}	
	public void setName_tp(String Name_tp) {
		setAttrVal("Name_tp", Name_tp);
	}
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
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
		return "Id_oprcod_eqm";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_mr_nu_oprcod_eqm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OperNuRecordEqmDODesc.class);
	}
	
}