package iih.ci.mrfp.di2mrfp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mrfp.di2mrfp.d.desc.CiMrfpDiDODesc;
import java.math.BigDecimal;

/**
 * 住院病案首页 诊断信息 DO数据 
 * 
 */
public class CiMrfpDiDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MRFPDI= "Id_mrfpdi";
	public static final String ID_MRFP= "Id_mrfp";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_PAT= "Id_pat";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_mrfpdi() {
		return ((String) getAttrVal("Id_mrfpdi"));
	}	
	public void setId_mrfpdi(String Id_mrfpdi) {
		setAttrVal("Id_mrfpdi", Id_mrfpdi);
	}
	public String getId_mrfp() {
		return ((String) getAttrVal("Id_mrfp"));
	}	
	public void setId_mrfp(String Id_mrfp) {
		setAttrVal("Id_mrfp", Id_mrfp);
	}
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
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
		return "Id_mrfpdi";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_mr_fp_di";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiMrfpDiDODesc.class);
	}
	
}