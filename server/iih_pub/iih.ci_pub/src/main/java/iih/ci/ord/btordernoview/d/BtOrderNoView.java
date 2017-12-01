package iih.ci.ord.btordernoview.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.btordernoview.d.desc.BtOrderNoViewDesc;
import java.math.BigDecimal;

/**
 * 交叉备血申请单号 DO数据 
 * 
 */
public class BtOrderNoView extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_APBT= "Id_apbt";
	public static final String NO_APPLYFORM= "No_applyform";
	public static final String EN_CODE= "En_code";
	public static final String NAME_PAT= "Name_pat";
	public static final String BLOOD_COMP= "Blood_comp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_apbt() {
		return ((String) getAttrVal("Id_apbt"));
	}	
	public void setId_apbt(String Id_apbt) {
		setAttrVal("Id_apbt", Id_apbt);
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
	public String getBlood_comp() {
		return ((String) getAttrVal("Blood_comp"));
	}	
	public void setBlood_comp(String Blood_comp) {
		setAttrVal("Blood_comp", Blood_comp);
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
		return "Id_apbt";
	}
	
	@Override
	public String getTableName() {	  
		return "BT_ORDERNO_VIEW";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BtOrderNoViewDesc.class);
	}
	
}