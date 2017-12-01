package iih.ci.mrfp.cimrfp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mrfp.cimrfp.d.desc.CiMrFpDODesc;
import java.math.BigDecimal;

/**
 * 住院病案首页 DO数据 
 * 
 */
public class CiMrFpDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MRFP= "Id_mrfp";
	public static final String SD_MRFPTP= "Sd_mrfptp";
	public static final String ID_PAT= "Id_pat";
	public static final String ID_ORG= "Id_org";
	public static final String ID_ENT= "Id_ent";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_mrfp() {
		return ((String) getAttrVal("Id_mrfp"));
	}	
	public void setId_mrfp(String Id_mrfp) {
		setAttrVal("Id_mrfp", Id_mrfp);
	}
	public String getSd_mrfptp() {
		return ((String) getAttrVal("Sd_mrfptp"));
	}	
	public void setSd_mrfptp(String Sd_mrfptp) {
		setAttrVal("Sd_mrfptp", Sd_mrfptp);
	}
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
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
		return "Id_mrfp";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_MR_FP";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiMrFpDODesc.class);
	}
	
}