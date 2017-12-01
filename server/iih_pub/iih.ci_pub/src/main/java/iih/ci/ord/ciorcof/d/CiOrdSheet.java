package iih.ci.ord.ciorcof.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.ciorcof.d.desc.CiOrdSheetDesc;
import java.math.BigDecimal;

/**
 * 实体 DO数据 
 * 
 */
public class CiOrdSheet extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_SHEET= "Id_sheet";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String PYCODE= "Pycode";
	public static final String WBCODE= "Wbcode";
	public static final String DLL_MODEL= "Dll_model";
	public static final String DLL_ASSEMBLY= "Dll_assembly";
	public static final String SORTNO= "Sortno";
	public static final String DES= "Des";
	public static final String SV= "Sv";
	public static final String DS = "Ds";
	
	public String getId_sheet() {
		return ((String) getAttrVal("Id_sheet"));
	}	
	public void setId_sheet(String Id_sheet) {
		setAttrVal("Id_sheet", Id_sheet);
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
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}	
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}	
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
	}
	public String getDll_model() {
		return ((String) getAttrVal("Dll_model"));
	}	
	public void setDll_model(String Dll_model) {
		setAttrVal("Dll_model", Dll_model);
	}
	public String getDll_assembly() {
		return ((String) getAttrVal("Dll_assembly"));
	}	
	public void setDll_assembly(String Dll_assembly) {
		setAttrVal("Dll_assembly", Dll_assembly);
	}
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
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
		return "Id_sheet";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_or_sheet";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiOrdSheetDesc.class);
	}
	
}