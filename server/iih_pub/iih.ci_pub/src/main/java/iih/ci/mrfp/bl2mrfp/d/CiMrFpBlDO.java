package iih.ci.mrfp.bl2mrfp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mrfp.bl2mrfp.d.desc.CiMrFpBlDODesc;
import java.math.BigDecimal;

/**
 * 医疗记录_住院病历首页_费用 DO数据 
 * 
 */
public class CiMrFpBlDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MRFPBL= "Id_mrfpbl";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_PAT= "Id_pat";
	public static final String ID_MRFP= "Id_mrfp";
	public static final String SORTNO= "Sortno";
	public static final String ID_SRV_BL= "Id_srv_bl";
	public static final String NAME_SRV_BL= "Name_srv_bl";
	public static final String AMOUNT= "Amount";
	public static final String CMS_GMSFEE= "Cms_gmsfee";
	public static final String CMS_GTOFEE= "Cms_gtofee";
	public static final String CMS_NURFEE= "Cms_nurfee";
	public static final String CMS_OTHERFEE= "Cms_otherfee";
	public static final String CMS_SPAMOUNT= "Cms_spamount";
	public static final String DI_PDIFEE= "Di_pdifee";
	public static final String DI_LDIFEE= "Di_ldifee";
	public static final String DI_IDIFEE= "Di_idifee";
	public static final String DI_CDIFEE= "Di_cdifee";
	public static final String TC_NSTPFEE= "Tc_nstpfee";
	public static final String TC_CPTFEE= "Tc_cptfee";
	public static final String TC_STFEE= "Tc_stfee";
	public static final String TC_ANFEE= "Tc_anfee";
	public static final String TC_OPFEE= "Tc_opfee";
	public static final String RC_RCFEE= "Rc_rcfee";
	public static final String TCM_CMTFEE= "Tcm_cmtfee";
	public static final String WM_WMFEE= "Wm_wmfee";
	public static final String WM_AGFEE= "Wm_agfee";
	public static final String TCMT_CPMFEE= "Tcmt_cpmfee";
	public static final String TCMT_CHMFEE= "Tcmt_chmfee";
	public static final String BABP_BFEE= "Babp_bfee";
	public static final String BABP_APFEE= "Babp_apfee";
	public static final String BABP_GPFEE= "Babp_gpfee";
	public static final String BABP_BCFFEE= "Babp_bcffee";
	public static final String BABP_CFLFEE= "Babp_cflfee";
	public static final String SC_DMMFIFEE= "Sc_dmmfifee";
	public static final String SC_DMMFTFEE= "Sc_dmmftfee";
	public static final String SC_DMMFSFEE= "Sc_dmmfsfee";
	public static final String OC_OCFEE= "Oc_ocfee";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_mrfpbl() {
		return ((String) getAttrVal("Id_mrfpbl"));
	}	
	public void setId_mrfpbl(String Id_mrfpbl) {
		setAttrVal("Id_mrfpbl", Id_mrfpbl);
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
	public String getId_mrfp() {
		return ((String) getAttrVal("Id_mrfp"));
	}	
	public void setId_mrfp(String Id_mrfp) {
		setAttrVal("Id_mrfp", Id_mrfp);
	}
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	public String getId_srv_bl() {
		return ((String) getAttrVal("Id_srv_bl"));
	}	
	public void setId_srv_bl(String Id_srv_bl) {
		setAttrVal("Id_srv_bl", Id_srv_bl);
	}
	public String getName_srv_bl() {
		return ((String) getAttrVal("Name_srv_bl"));
	}	
	public void setName_srv_bl(String Name_srv_bl) {
		setAttrVal("Name_srv_bl", Name_srv_bl);
	}
	public FDouble getAmount() {
		return ((FDouble) getAttrVal("Amount"));
	}	
	public void setAmount(FDouble Amount) {
		setAttrVal("Amount", Amount);
	}
	public FDouble getCms_gmsfee() {
		return ((FDouble) getAttrVal("Cms_gmsfee"));
	}	
	public void setCms_gmsfee(FDouble Cms_gmsfee) {
		setAttrVal("Cms_gmsfee", Cms_gmsfee);
	}
	public FDouble getCms_gtofee() {
		return ((FDouble) getAttrVal("Cms_gtofee"));
	}	
	public void setCms_gtofee(FDouble Cms_gtofee) {
		setAttrVal("Cms_gtofee", Cms_gtofee);
	}
	public FDouble getCms_nurfee() {
		return ((FDouble) getAttrVal("Cms_nurfee"));
	}	
	public void setCms_nurfee(FDouble Cms_nurfee) {
		setAttrVal("Cms_nurfee", Cms_nurfee);
	}
	public FDouble getCms_otherfee() {
		return ((FDouble) getAttrVal("Cms_otherfee"));
	}	
	public void setCms_otherfee(FDouble Cms_otherfee) {
		setAttrVal("Cms_otherfee", Cms_otherfee);
	}
	public FDouble getCms_spamount() {
		return ((FDouble) getAttrVal("Cms_spamount"));
	}	
	public void setCms_spamount(FDouble Cms_spamount) {
		setAttrVal("Cms_spamount", Cms_spamount);
	}
	public FDouble getDi_pdifee() {
		return ((FDouble) getAttrVal("Di_pdifee"));
	}	
	public void setDi_pdifee(FDouble Di_pdifee) {
		setAttrVal("Di_pdifee", Di_pdifee);
	}
	public FDouble getDi_ldifee() {
		return ((FDouble) getAttrVal("Di_ldifee"));
	}	
	public void setDi_ldifee(FDouble Di_ldifee) {
		setAttrVal("Di_ldifee", Di_ldifee);
	}
	public FDouble getDi_idifee() {
		return ((FDouble) getAttrVal("Di_idifee"));
	}	
	public void setDi_idifee(FDouble Di_idifee) {
		setAttrVal("Di_idifee", Di_idifee);
	}
	public FDouble getDi_cdifee() {
		return ((FDouble) getAttrVal("Di_cdifee"));
	}	
	public void setDi_cdifee(FDouble Di_cdifee) {
		setAttrVal("Di_cdifee", Di_cdifee);
	}
	public FDouble getTc_nstpfee() {
		return ((FDouble) getAttrVal("Tc_nstpfee"));
	}	
	public void setTc_nstpfee(FDouble Tc_nstpfee) {
		setAttrVal("Tc_nstpfee", Tc_nstpfee);
	}
	public FDouble getTc_cptfee() {
		return ((FDouble) getAttrVal("Tc_cptfee"));
	}	
	public void setTc_cptfee(FDouble Tc_cptfee) {
		setAttrVal("Tc_cptfee", Tc_cptfee);
	}
	public FDouble getTc_stfee() {
		return ((FDouble) getAttrVal("Tc_stfee"));
	}	
	public void setTc_stfee(FDouble Tc_stfee) {
		setAttrVal("Tc_stfee", Tc_stfee);
	}
	public FDouble getTc_anfee() {
		return ((FDouble) getAttrVal("Tc_anfee"));
	}	
	public void setTc_anfee(FDouble Tc_anfee) {
		setAttrVal("Tc_anfee", Tc_anfee);
	}
	public FDouble getTc_opfee() {
		return ((FDouble) getAttrVal("Tc_opfee"));
	}	
	public void setTc_opfee(FDouble Tc_opfee) {
		setAttrVal("Tc_opfee", Tc_opfee);
	}
	public FDouble getRc_rcfee() {
		return ((FDouble) getAttrVal("Rc_rcfee"));
	}	
	public void setRc_rcfee(FDouble Rc_rcfee) {
		setAttrVal("Rc_rcfee", Rc_rcfee);
	}
	public FDouble getTcm_cmtfee() {
		return ((FDouble) getAttrVal("Tcm_cmtfee"));
	}	
	public void setTcm_cmtfee(FDouble Tcm_cmtfee) {
		setAttrVal("Tcm_cmtfee", Tcm_cmtfee);
	}
	public FDouble getWm_wmfee() {
		return ((FDouble) getAttrVal("Wm_wmfee"));
	}	
	public void setWm_wmfee(FDouble Wm_wmfee) {
		setAttrVal("Wm_wmfee", Wm_wmfee);
	}
	public FDouble getWm_agfee() {
		return ((FDouble) getAttrVal("Wm_agfee"));
	}	
	public void setWm_agfee(FDouble Wm_agfee) {
		setAttrVal("Wm_agfee", Wm_agfee);
	}
	public FDouble getTcmt_cpmfee() {
		return ((FDouble) getAttrVal("Tcmt_cpmfee"));
	}	
	public void setTcmt_cpmfee(FDouble Tcmt_cpmfee) {
		setAttrVal("Tcmt_cpmfee", Tcmt_cpmfee);
	}
	public FDouble getTcmt_chmfee() {
		return ((FDouble) getAttrVal("Tcmt_chmfee"));
	}	
	public void setTcmt_chmfee(FDouble Tcmt_chmfee) {
		setAttrVal("Tcmt_chmfee", Tcmt_chmfee);
	}
	public FDouble getBabp_bfee() {
		return ((FDouble) getAttrVal("Babp_bfee"));
	}	
	public void setBabp_bfee(FDouble Babp_bfee) {
		setAttrVal("Babp_bfee", Babp_bfee);
	}
	public FDouble getBabp_apfee() {
		return ((FDouble) getAttrVal("Babp_apfee"));
	}	
	public void setBabp_apfee(FDouble Babp_apfee) {
		setAttrVal("Babp_apfee", Babp_apfee);
	}
	public FDouble getBabp_gpfee() {
		return ((FDouble) getAttrVal("Babp_gpfee"));
	}	
	public void setBabp_gpfee(FDouble Babp_gpfee) {
		setAttrVal("Babp_gpfee", Babp_gpfee);
	}
	public FDouble getBabp_bcffee() {
		return ((FDouble) getAttrVal("Babp_bcffee"));
	}	
	public void setBabp_bcffee(FDouble Babp_bcffee) {
		setAttrVal("Babp_bcffee", Babp_bcffee);
	}
	public FDouble getBabp_cflfee() {
		return ((FDouble) getAttrVal("Babp_cflfee"));
	}	
	public void setBabp_cflfee(FDouble Babp_cflfee) {
		setAttrVal("Babp_cflfee", Babp_cflfee);
	}
	public FDouble getSc_dmmfifee() {
		return ((FDouble) getAttrVal("Sc_dmmfifee"));
	}	
	public void setSc_dmmfifee(FDouble Sc_dmmfifee) {
		setAttrVal("Sc_dmmfifee", Sc_dmmfifee);
	}
	public FDouble getSc_dmmftfee() {
		return ((FDouble) getAttrVal("Sc_dmmftfee"));
	}	
	public void setSc_dmmftfee(FDouble Sc_dmmftfee) {
		setAttrVal("Sc_dmmftfee", Sc_dmmftfee);
	}
	public FDouble getSc_dmmfsfee() {
		return ((FDouble) getAttrVal("Sc_dmmfsfee"));
	}	
	public void setSc_dmmfsfee(FDouble Sc_dmmfsfee) {
		setAttrVal("Sc_dmmfsfee", Sc_dmmfsfee);
	}
	public FDouble getOc_ocfee() {
		return ((FDouble) getAttrVal("Oc_ocfee"));
	}	
	public void setOc_ocfee(FDouble Oc_ocfee) {
		setAttrVal("Oc_ocfee", Oc_ocfee);
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
		return "Id_mrfpbl";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_MR_FP_BL";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiMrFpBlDODesc.class);
	}
	
}