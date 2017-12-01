package iih.ci.mr.mrsign.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.mrsign.d.desc.CiMrSignDODesc;
import java.math.BigDecimal;

/**
 * 临床医疗记录签名 DO数据 
 * 
 */
public class CiMrSignDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MRSIGN= "Id_mrsign";
	public static final String ID_MR= "Id_mr";
	public static final String ID_SIGNLVL= "Id_signlvl";
	public static final String SD_SIGNLVL= "Sd_signlvl";
	public static final String ID_ROLE_SIGN= "Id_role_sign";
	public static final String SD_ROLE_SIGN= "Sd_role_sign";
	public static final String ID_SIGNTP= "Id_signtp";
	public static final String SD_SIGNTP= "Sd_signtp";
	public static final String DT_SIGN= "Dt_sign";
	public static final String ID_EMP_SIGN= "Id_emp_sign";
	public static final String ID_PAT_SIGN= "Id_pat_sign";
	public static final String ID_DEP= "Id_dep";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_mrsign() {
		return ((String) getAttrVal("Id_mrsign"));
	}	
	public void setId_mrsign(String Id_mrsign) {
		setAttrVal("Id_mrsign", Id_mrsign);
	}
	public String getId_mr() {
		return ((String) getAttrVal("Id_mr"));
	}	
	public void setId_mr(String Id_mr) {
		setAttrVal("Id_mr", Id_mr);
	}
	public String getId_signlvl() {
		return ((String) getAttrVal("Id_signlvl"));
	}	
	public void setId_signlvl(String Id_signlvl) {
		setAttrVal("Id_signlvl", Id_signlvl);
	}
	public String getSd_signlvl() {
		return ((String) getAttrVal("Sd_signlvl"));
	}	
	public void setSd_signlvl(String Sd_signlvl) {
		setAttrVal("Sd_signlvl", Sd_signlvl);
	}
	public String getId_role_sign() {
		return ((String) getAttrVal("Id_role_sign"));
	}	
	public void setId_role_sign(String Id_role_sign) {
		setAttrVal("Id_role_sign", Id_role_sign);
	}
	public String getSd_role_sign() {
		return ((String) getAttrVal("Sd_role_sign"));
	}	
	public void setSd_role_sign(String Sd_role_sign) {
		setAttrVal("Sd_role_sign", Sd_role_sign);
	}
	public String getId_signtp() {
		return ((String) getAttrVal("Id_signtp"));
	}	
	public void setId_signtp(String Id_signtp) {
		setAttrVal("Id_signtp", Id_signtp);
	}
	public String getSd_signtp() {
		return ((String) getAttrVal("Sd_signtp"));
	}	
	public void setSd_signtp(String Sd_signtp) {
		setAttrVal("Sd_signtp", Sd_signtp);
	}
	public FDateTime getDt_sign() {
		return ((FDateTime) getAttrVal("Dt_sign"));
	}	
	public void setDt_sign(FDateTime Dt_sign) {
		setAttrVal("Dt_sign", Dt_sign);
	}
	public String getId_emp_sign() {
		return ((String) getAttrVal("Id_emp_sign"));
	}	
	public void setId_emp_sign(String Id_emp_sign) {
		setAttrVal("Id_emp_sign", Id_emp_sign);
	}
	public String getId_pat_sign() {
		return ((String) getAttrVal("Id_pat_sign"));
	}	
	public void setId_pat_sign(String Id_pat_sign) {
		setAttrVal("Id_pat_sign", Id_pat_sign);
	}
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
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
		return "Id_mrsign";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_mr_sign";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiMrSignDODesc.class);
	}
	
}