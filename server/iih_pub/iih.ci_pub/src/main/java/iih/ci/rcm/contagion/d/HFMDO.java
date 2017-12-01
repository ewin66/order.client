package iih.ci.rcm.contagion.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.rcm.contagion.d.desc.HFMDODesc;
import java.math.BigDecimal;

/**
 * 手足口附卡 DO数据 
 * 
 */
public class HFMDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_CONTAGION_HFM= "Id_contagion_hfm";
	public static final String ID_CONTAGION= "Id_contagion";
	public static final String ID_FORM= "Id_form";
	public static final String ID_HFM_RESULT= "Id_hfm_result";
	public static final String CODE_HFM_RESULT= "Code_hfm_result";
	public static final String NAME_HFM_RESULT= "Name_hfm_result";
	public static final String IS_ZHONGZHENG= "Is_zhongzheng";
	public static final String CODE_ZHONGZHENG= "Code_zhongzheng";
	public static final String NAME_ZHONGZHENG= "Name_zhongzheng";
	public static final String HFM_RESULT_CODE= "Hfm_result_code";
	public static final String HFM_RESULT_NAME= "Hfm_result_name";
	public static final String ZHONGZHENG_CODE= "Zhongzheng_code";
	public static final String ZHONGZHENG_NAME= "Zhongzheng_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_contagion_hfm() {
		return ((String) getAttrVal("Id_contagion_hfm"));
	}	
	public void setId_contagion_hfm(String Id_contagion_hfm) {
		setAttrVal("Id_contagion_hfm", Id_contagion_hfm);
	}
	public String getId_contagion() {
		return ((String) getAttrVal("Id_contagion"));
	}	
	public void setId_contagion(String Id_contagion) {
		setAttrVal("Id_contagion", Id_contagion);
	}
	public String getId_form() {
		return ((String) getAttrVal("Id_form"));
	}	
	public void setId_form(String Id_form) {
		setAttrVal("Id_form", Id_form);
	}
	public String getId_hfm_result() {
		return ((String) getAttrVal("Id_hfm_result"));
	}	
	public void setId_hfm_result(String Id_hfm_result) {
		setAttrVal("Id_hfm_result", Id_hfm_result);
	}
	public String getCode_hfm_result() {
		return ((String) getAttrVal("Code_hfm_result"));
	}	
	public void setCode_hfm_result(String Code_hfm_result) {
		setAttrVal("Code_hfm_result", Code_hfm_result);
	}
	public String getName_hfm_result() {
		return ((String) getAttrVal("Name_hfm_result"));
	}	
	public void setName_hfm_result(String Name_hfm_result) {
		setAttrVal("Name_hfm_result", Name_hfm_result);
	}
	public String getIs_zhongzheng() {
		return ((String) getAttrVal("Is_zhongzheng"));
	}	
	public void setIs_zhongzheng(String Is_zhongzheng) {
		setAttrVal("Is_zhongzheng", Is_zhongzheng);
	}
	public String getCode_zhongzheng() {
		return ((String) getAttrVal("Code_zhongzheng"));
	}	
	public void setCode_zhongzheng(String Code_zhongzheng) {
		setAttrVal("Code_zhongzheng", Code_zhongzheng);
	}
	public String getName_zhongzheng() {
		return ((String) getAttrVal("Name_zhongzheng"));
	}	
	public void setName_zhongzheng(String Name_zhongzheng) {
		setAttrVal("Name_zhongzheng", Name_zhongzheng);
	}
	public String getHfm_result_code() {
		return ((String) getAttrVal("Hfm_result_code"));
	}	
	public void setHfm_result_code(String Hfm_result_code) {
		setAttrVal("Hfm_result_code", Hfm_result_code);
	}
	public String getHfm_result_name() {
		return ((String) getAttrVal("Hfm_result_name"));
	}	
	public void setHfm_result_name(String Hfm_result_name) {
		setAttrVal("Hfm_result_name", Hfm_result_name);
	}
	public String getZhongzheng_code() {
		return ((String) getAttrVal("Zhongzheng_code"));
	}	
	public void setZhongzheng_code(String Zhongzheng_code) {
		setAttrVal("Zhongzheng_code", Zhongzheng_code);
	}
	public String getZhongzheng_name() {
		return ((String) getAttrVal("Zhongzheng_name"));
	}	
	public void setZhongzheng_name(String Zhongzheng_name) {
		setAttrVal("Zhongzheng_name", Zhongzheng_name);
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
		return "Id_contagion_hfm";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_MR_CONTAGION_CARD_HFM";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HFMDODesc.class);
	}
	
}