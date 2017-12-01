package iih.ci.ord.cirptlab.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.cirptlab.d.desc.CiRptLabItmDODesc;
import java.math.BigDecimal;

/**
 * 检验报告单明细 DO数据 
 * 
 */
public class CiRptLabItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_RPTLISITM= "Id_rptlisitm";
	public static final String ID_RPTLAB= "Id_rptlab";
	public static final String ID_SRV= "Id_srv";
	public static final String SORTNO= "Sortno";
	public static final String VAL_REFERENCE= "Val_reference";
	public static final String VAL_MAX= "Val_max";
	public static final String VAL_MIN= "Val_min";
	public static final String VAL_RSTRPTLAB= "Val_rstrptlab";
	public static final String ID_UNIT= "Id_unit";
	public static final String ID_DEVIATE= "Id_deviate";
	public static final String SD_DEVIATE= "Sd_deviate";
	public static final String SD_RESTRPTLABTP= "Sd_restrptlabtp";
	public static final String VAL_RANGE= "Val_range";
	public static final String NAME_SRV= "Name_srv";
	public static final String SHORTNAME= "Shortname";
	public static final String UNIT_NAME= "Unit_name";
	public static final String NAME_DEVIATE= "Name_deviate";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_rptlisitm() {
		return ((String) getAttrVal("Id_rptlisitm"));
	}	
	public void setId_rptlisitm(String Id_rptlisitm) {
		setAttrVal("Id_rptlisitm", Id_rptlisitm);
	}
	public String getId_rptlab() {
		return ((String) getAttrVal("Id_rptlab"));
	}	
	public void setId_rptlab(String Id_rptlab) {
		setAttrVal("Id_rptlab", Id_rptlab);
	}
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	public String getVal_reference() {
		return ((String) getAttrVal("Val_reference"));
	}	
	public void setVal_reference(String Val_reference) {
		setAttrVal("Val_reference", Val_reference);
	}
	public String getVal_max() {
		return ((String) getAttrVal("Val_max"));
	}	
	public void setVal_max(String Val_max) {
		setAttrVal("Val_max", Val_max);
	}
	public String getVal_min() {
		return ((String) getAttrVal("Val_min"));
	}	
	public void setVal_min(String Val_min) {
		setAttrVal("Val_min", Val_min);
	}
	public String getVal_rstrptlab() {
		return ((String) getAttrVal("Val_rstrptlab"));
	}	
	public void setVal_rstrptlab(String Val_rstrptlab) {
		setAttrVal("Val_rstrptlab", Val_rstrptlab);
	}
	public String getId_unit() {
		return ((String) getAttrVal("Id_unit"));
	}	
	public void setId_unit(String Id_unit) {
		setAttrVal("Id_unit", Id_unit);
	}
	public String getId_deviate() {
		return ((String) getAttrVal("Id_deviate"));
	}	
	public void setId_deviate(String Id_deviate) {
		setAttrVal("Id_deviate", Id_deviate);
	}
	public String getSd_deviate() {
		return ((String) getAttrVal("Sd_deviate"));
	}	
	public void setSd_deviate(String Sd_deviate) {
		setAttrVal("Sd_deviate", Sd_deviate);
	}
	public String getSd_restrptlabtp() {
		return ((String) getAttrVal("Sd_restrptlabtp"));
	}	
	public void setSd_restrptlabtp(String Sd_restrptlabtp) {
		setAttrVal("Sd_restrptlabtp", Sd_restrptlabtp);
	}
	public String getVal_range() {
		return ((String) getAttrVal("Val_range"));
	}	
	public void setVal_range(String Val_range) {
		setAttrVal("Val_range", Val_range);
	}
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}	
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	public String getShortname() {
		return ((String) getAttrVal("Shortname"));
	}	
	public void setShortname(String Shortname) {
		setAttrVal("Shortname", Shortname);
	}
	public String getUnit_name() {
		return ((String) getAttrVal("Unit_name"));
	}	
	public void setUnit_name(String Unit_name) {
		setAttrVal("Unit_name", Unit_name);
	}
	public String getName_deviate() {
		return ((String) getAttrVal("Name_deviate"));
	}	
	public void setName_deviate(String Name_deviate) {
		setAttrVal("Name_deviate", Name_deviate);
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
		return "Id_rptlisitm";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_RPT_LAB_ITM";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiRptLabItmDODesc.class);
	}
	
}