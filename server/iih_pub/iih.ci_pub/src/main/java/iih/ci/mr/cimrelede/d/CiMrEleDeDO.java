package iih.ci.mr.cimrelede.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.cimrelede.d.desc.CiMrEleDeDODesc;
import java.math.BigDecimal;

/**
 * 临床医疗记录元素_数据元 DO数据 
 * 
 */
public class CiMrEleDeDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MRDE= "Id_mrde";
	public static final String NAME_MRDE= "Name_mrde";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_MRDG= "Id_mrdg";
	public static final String ID_MRTPLDE= "Id_mrtplde";
	public static final String ID_DE= "Id_de";
	public static final String ID_VAL= "Id_val";
	public static final String VAL= "Val";
	public static final String VAL_DSP= "Val_dsp";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_DE= "Name_de";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_mrde() {
		return ((String) getAttrVal("Id_mrde"));
	}	
	public void setId_mrde(String Id_mrde) {
		setAttrVal("Id_mrde", Id_mrde);
	}
	public String getName_mrde() {
		return ((String) getAttrVal("Name_mrde"));
	}	
	public void setName_mrde(String Name_mrde) {
		setAttrVal("Name_mrde", Name_mrde);
	}
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	public String getId_mrdg() {
		return ((String) getAttrVal("Id_mrdg"));
	}	
	public void setId_mrdg(String Id_mrdg) {
		setAttrVal("Id_mrdg", Id_mrdg);
	}
	public String getId_mrtplde() {
		return ((String) getAttrVal("Id_mrtplde"));
	}	
	public void setId_mrtplde(String Id_mrtplde) {
		setAttrVal("Id_mrtplde", Id_mrtplde);
	}
	public String getId_de() {
		return ((String) getAttrVal("Id_de"));
	}	
	public void setId_de(String Id_de) {
		setAttrVal("Id_de", Id_de);
	}
	public String getId_val() {
		return ((String) getAttrVal("Id_val"));
	}	
	public void setId_val(String Id_val) {
		setAttrVal("Id_val", Id_val);
	}
	public String getVal() {
		return ((String) getAttrVal("Val"));
	}	
	public void setVal(String Val) {
		setAttrVal("Val", Val);
	}
	public String getVal_dsp() {
		return ((String) getAttrVal("Val_dsp"));
	}	
	public void setVal_dsp(String Val_dsp) {
		setAttrVal("Val_dsp", Val_dsp);
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
	public String getName_de() {
		return ((String) getAttrVal("Name_de"));
	}	
	public void setName_de(String Name_de) {
		setAttrVal("Name_de", Name_de);
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
		return "Id_mrde";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_MR_ELE_DE";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiMrEleDeDODesc.class);
	}
	
}