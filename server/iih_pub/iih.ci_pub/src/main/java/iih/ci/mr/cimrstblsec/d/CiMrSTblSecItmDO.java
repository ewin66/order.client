package iih.ci.mr.cimrstblsec.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.cimrstblsec.d.desc.CiMrSTblSecItmDODesc;
import java.math.BigDecimal;

/**
 * 临床医疗记录表格段落项目 DO数据 
 * 
 */
public class CiMrSTblSecItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MRSTBSECITM= "Id_mrstbsecitm";
	public static final String ID_MRSTBSEC= "Id_mrstbsec";
	public static final String ID_MRTPLSTBSECITM= "Id_mrtplstbsecitm";
	public static final String SORTNO= "Sortno";
	public static final String FG_SRV= "Fg_srv";
	public static final String ID_SRV= "Id_srv";
	public static final String ID_DE= "Id_de";
	public static final String NAME= "Name";
	public static final String VALUE= "Value";
	public static final String FG_VALUE1= "Fg_value1";
	public static final String FG_SRV1= "Fg_srv1";
	public static final String ID_SRV1= "Id_srv1";
	public static final String ID_DE1= "Id_de1";
	public static final String NAME1= "Name1";
	public static final String VALUE1= "Value1";
	public static final String DATE_MEASURE= "Date_measure";
	public static final String ID_DATESLOT= "Id_dateslot";
	public static final String DT_MEASURE= "Dt_measure";
	public static final String ID_DEP= "Id_dep";
	public static final String ID_EMP= "Id_emp";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_mrstbsecitm() {
		return ((String) getAttrVal("Id_mrstbsecitm"));
	}	
	public void setId_mrstbsecitm(String Id_mrstbsecitm) {
		setAttrVal("Id_mrstbsecitm", Id_mrstbsecitm);
	}
	public String getId_mrstbsec() {
		return ((String) getAttrVal("Id_mrstbsec"));
	}	
	public void setId_mrstbsec(String Id_mrstbsec) {
		setAttrVal("Id_mrstbsec", Id_mrstbsec);
	}
	public String getId_mrtplstbsecitm() {
		return ((String) getAttrVal("Id_mrtplstbsecitm"));
	}	
	public void setId_mrtplstbsecitm(String Id_mrtplstbsecitm) {
		setAttrVal("Id_mrtplstbsecitm", Id_mrtplstbsecitm);
	}
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	public FBoolean getFg_srv() {
		return ((FBoolean) getAttrVal("Fg_srv"));
	}	
	public void setFg_srv(FBoolean Fg_srv) {
		setAttrVal("Fg_srv", Fg_srv);
	}
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	public String getId_de() {
		return ((String) getAttrVal("Id_de"));
	}	
	public void setId_de(String Id_de) {
		setAttrVal("Id_de", Id_de);
	}
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public String getValue() {
		return ((String) getAttrVal("Value"));
	}	
	public void setValue(String Value) {
		setAttrVal("Value", Value);
	}
	public FBoolean getFg_value1() {
		return ((FBoolean) getAttrVal("Fg_value1"));
	}	
	public void setFg_value1(FBoolean Fg_value1) {
		setAttrVal("Fg_value1", Fg_value1);
	}
	public FBoolean getFg_srv1() {
		return ((FBoolean) getAttrVal("Fg_srv1"));
	}	
	public void setFg_srv1(FBoolean Fg_srv1) {
		setAttrVal("Fg_srv1", Fg_srv1);
	}
	public String getId_srv1() {
		return ((String) getAttrVal("Id_srv1"));
	}	
	public void setId_srv1(String Id_srv1) {
		setAttrVal("Id_srv1", Id_srv1);
	}
	public String getId_de1() {
		return ((String) getAttrVal("Id_de1"));
	}	
	public void setId_de1(String Id_de1) {
		setAttrVal("Id_de1", Id_de1);
	}
	public String getName1() {
		return ((String) getAttrVal("Name1"));
	}	
	public void setName1(String Name1) {
		setAttrVal("Name1", Name1);
	}
	public String getValue1() {
		return ((String) getAttrVal("Value1"));
	}	
	public void setValue1(String Value1) {
		setAttrVal("Value1", Value1);
	}
	public String getDate_measure() {
		return ((String) getAttrVal("Date_measure"));
	}	
	public void setDate_measure(String Date_measure) {
		setAttrVal("Date_measure", Date_measure);
	}
	public String getId_dateslot() {
		return ((String) getAttrVal("Id_dateslot"));
	}	
	public void setId_dateslot(String Id_dateslot) {
		setAttrVal("Id_dateslot", Id_dateslot);
	}
	public FDateTime getDt_measure() {
		return ((FDateTime) getAttrVal("Dt_measure"));
	}	
	public void setDt_measure(FDateTime Dt_measure) {
		setAttrVal("Dt_measure", Dt_measure);
	}
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}	
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
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
		return "Id_mrstbsecitm";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_mr_stbsec_itm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiMrSTblSecItmDODesc.class);
	}
	
}