package iih.ci.ord.ordsrvdose.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.ordsrvdose.d.desc.OrdSrvDoseDODesc;
import java.math.BigDecimal;

/**
 * 医嘱服务项目剂量 DO数据 
 * 
 */
public class OrdSrvDoseDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_ORSRVDOSE= "Id_orsrvdose";
	public static final String ID_ORSRV= "Id_orsrv";
	public static final String ID_OR= "Id_or";
	public static final String ID_FREQTIME= "Id_freqtime";
	public static final String DT_FREQ= "Dt_freq";
	public static final String NO_MP= "No_mp";
	public static final String QUAN_DOSE= "Quan_dose";
	public static final String ID_UNIT_DOSE= "Id_unit_dose";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_UNIT_DOSE= "Name_unit_dose";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_orsrvdose() {
		return ((String) getAttrVal("Id_orsrvdose"));
	}	
	public void setId_orsrvdose(String Id_orsrvdose) {
		setAttrVal("Id_orsrvdose", Id_orsrvdose);
	}
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}	
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	public String getId_freqtime() {
		return ((String) getAttrVal("Id_freqtime"));
	}	
	public void setId_freqtime(String Id_freqtime) {
		setAttrVal("Id_freqtime", Id_freqtime);
	}
	public FDateTime getDt_freq() {
		return ((FDateTime) getAttrVal("Dt_freq"));
	}	
	public void setDt_freq(FDateTime Dt_freq) {
		setAttrVal("Dt_freq", Dt_freq);
	}
	public Integer getNo_mp() {
		return ((Integer) getAttrVal("No_mp"));
	}	
	public void setNo_mp(Integer No_mp) {
		setAttrVal("No_mp", No_mp);
	}
	public FDouble getQuan_dose() {
		return ((FDouble) getAttrVal("Quan_dose"));
	}	
	public void setQuan_dose(FDouble Quan_dose) {
		setAttrVal("Quan_dose", Quan_dose);
	}
	public String getId_unit_dose() {
		return ((String) getAttrVal("Id_unit_dose"));
	}	
	public void setId_unit_dose(String Id_unit_dose) {
		setAttrVal("Id_unit_dose", Id_unit_dose);
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
	public String getName_unit_dose() {
		return ((String) getAttrVal("Name_unit_dose"));
	}	
	public void setName_unit_dose(String Name_unit_dose) {
		setAttrVal("Name_unit_dose", Name_unit_dose);
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
		return "Id_orsrvdose";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_or_srv_dose";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OrdSrvDoseDODesc.class);
	}
	
}