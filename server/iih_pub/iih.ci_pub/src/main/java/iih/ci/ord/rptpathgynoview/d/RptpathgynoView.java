package iih.ci.ord.rptpathgynoview.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.rptpathgynoview.d.desc.RptpathgynoViewDesc;
import java.math.BigDecimal;

/**
 * 病理申请单号 DO数据 
 * 
 */
public class RptpathgynoView extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_RPTPATHGY= "Id_rptpathgy";
	public static final String NO_APPLYFORM= "No_applyform";
	public static final String EN_CODE= "En_code";
	public static final String NAME_PAT= "Name_pat";
	public static final String NAME_OR= "Name_or";
	public static final String SEX_NAME= "Sex_name";
	public static final String PSN_NAME= "Psn_name";
	public static final String DT_EFFE= "Dt_effe";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_rptpathgy() {
		return ((String) getAttrVal("Id_rptpathgy"));
	}	
	public void setId_rptpathgy(String Id_rptpathgy) {
		setAttrVal("Id_rptpathgy", Id_rptpathgy);
	}
	public String getNo_applyform() {
		return ((String) getAttrVal("No_applyform"));
	}	
	public void setNo_applyform(String No_applyform) {
		setAttrVal("No_applyform", No_applyform);
	}
	public String getEn_code() {
		return ((String) getAttrVal("En_code"));
	}	
	public void setEn_code(String En_code) {
		setAttrVal("En_code", En_code);
	}
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	public String getName_or() {
		return ((String) getAttrVal("Name_or"));
	}	
	public void setName_or(String Name_or) {
		setAttrVal("Name_or", Name_or);
	}
	public String getSex_name() {
		return ((String) getAttrVal("Sex_name"));
	}	
	public void setSex_name(String Sex_name) {
		setAttrVal("Sex_name", Sex_name);
	}
	public String getPsn_name() {
		return ((String) getAttrVal("Psn_name"));
	}	
	public void setPsn_name(String Psn_name) {
		setAttrVal("Psn_name", Psn_name);
	}
	public String getDt_effe() {
		return ((String) getAttrVal("Dt_effe"));
	}	
	public void setDt_effe(String Dt_effe) {
		setAttrVal("Dt_effe", Dt_effe);
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
		return "Id_rptpathgy";
	}
	
	@Override
	public String getTableName() {	  
		return "RPT_PATHGY_VIEW";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(RptpathgynoViewDesc.class);
	}
	
}