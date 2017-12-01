package iih.ci.mr.cimrsfmsec.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.cimrsfmsec.d.desc.CimrsfmsecitmDODesc;
import java.math.BigDecimal;

/**
 * 医疗记录智能表单段落项目 DO数据 
 * 
 */
public class CimrsfmsecitmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MRTPLSFMSECDE= "Id_mrtplsfmsecde";
	public static final String ID_MRTPLSFMSEC= "Id_mrtplsfmsec";
	public static final String SORTNO= "Sortno";
	public static final String ID_DE= "Id_de";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String VALUE= "Value";
	public static final String DES= "Des";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_mrtplsfmsecde() {
		return ((String) getAttrVal("Id_mrtplsfmsecde"));
	}	
	public void setId_mrtplsfmsecde(String Id_mrtplsfmsecde) {
		setAttrVal("Id_mrtplsfmsecde", Id_mrtplsfmsecde);
	}
	public String getId_mrtplsfmsec() {
		return ((String) getAttrVal("Id_mrtplsfmsec"));
	}	
	public void setId_mrtplsfmsec(String Id_mrtplsfmsec) {
		setAttrVal("Id_mrtplsfmsec", Id_mrtplsfmsec);
	}
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	public String getId_de() {
		return ((String) getAttrVal("Id_de"));
	}	
	public void setId_de(String Id_de) {
		setAttrVal("Id_de", Id_de);
	}
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	public void setCode(String Code) {
		setAttrVal("Code", Code);
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
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
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
		return "Id_mrtplsfmsecde";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_mr_sfmsec_itm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CimrsfmsecitmDODesc.class);
	}
	
}