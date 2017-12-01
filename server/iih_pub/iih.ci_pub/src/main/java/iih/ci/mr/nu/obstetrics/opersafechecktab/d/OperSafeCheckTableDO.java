package iih.ci.mr.nu.obstetrics.opersafechecktab.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.obstetrics.opersafechecktab.d.desc.OperSafeCheckTableDODesc;
import java.math.BigDecimal;

/**
 * 手术安全核查表 DO数据 
 * 
 */
public class OperSafeCheckTableDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_OPERSAFE= "Id_opersafe";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_PAT= "Id_pat";
	public static final String CODE_ENTP= "Code_entp";
	public static final String ID_DEP_PHY= "Id_dep_phy";
	public static final String NAME_DEP_PHY= "Name_dep_phy";
	public static final String ID_SEX= "Id_sex";
	public static final String SD_SEX= "Sd_sex";
	public static final String AGE= "Age";
	public static final String CODE_AMR_IP= "Code_amr_ip";
	public static final String ID_ANESTHESIA= "Id_anesthesia";
	public static final String SD_ANESTHESIA= "Sd_anesthesia";
	public static final String OPER_METHOD= "Oper_method";
	public static final String ID_EMP_OPER= "Id_emp_oper";
	public static final String DT_OPER= "Dt_oper";
	public static final String ID_GROUP= "Id_group";
	public static final String ID_ORG= "Id_org";
	public static final String EU_PATINFOBEFOREANA= "Eu_patinfobeforeana";
	public static final String EU_OPERMODEBEFOREANA= "Eu_opermodebeforeana";
	public static final String EU_SSBWYBSQ= "Eu_ssbwybsq";
	public static final String EU_SSZQTY= "Eu_sszqty";
	public static final String EU_MZZQTY= "Eu_mzzqty";
	public static final String EU_MZFSQR= "Eu_mzfsqr";
	public static final String EU_MZSBAQJC= "Eu_mzsbaqjc";
	public static final String EU_PFSFWZ= "Eu_pfsfwz";
	public static final String EU_SQPFZBZQ= "Eu_sqpfzbzq";
	public static final String EU_JMTDJLWC= "Eu_jmtdjlwc";
	public static final String EU_HZSFYGMS= "Eu_hzsfygms";
	public static final String EU_KJYWPSJG= "Eu_kjywpsjg";
	public static final String EU_SQBX= "Eu_sqbx";
	public static final String ID_ITEM_PRE= "Id_item_pre";
	public static final String SD_ITEM_PRE= "Sd_item_pre";
	public static final String BF_ANA_OTHER= "Bf_ana_other";
	public static final String EU_XMXBNL= "Eu_xmxbnl";
	public static final String EU_SQSSFSQR= "Eu_sqssfsqr";
	public static final String EU_SQSSBWYB= "Eu_sqssbwyb";
	public static final String ID_SSYSCS= "Id_ssyscs";
	public static final String SD_SSYSCS= "Sd_ssyscs";
	public static final String ID_MZYSCS= "Id_mzyscs";
	public static final String SD_MZYSCS= "Sd_mzyscs";
	public static final String ID_SSHSCS= "Id_sshscs";
	public static final String SD_SSHSCS= "Sd_sshscs";
	public static final String EU_SFXYXGYX= "Eu_sfxyxgyx";
	public static final String BF_OPER_OTHER= "Bf_oper_other";
	public static final String EU_SHHZXMDXBD= "Eu_shhzxmdxbd";
	public static final String EU_SJSSFSQR= "Eu_sjssfsqr";
	public static final String EU_SSYYDSXD= "Eu_ssyydsxd";
	public static final String EU_SSYWQDZQ= "Eu_ssywqdzq";
	public static final String EU_SSBBQR= "Eu_ssbbqr";
	public static final String EU_SHPFSFWZ= "Eu_shpfsfwz";
	public static final String ID_GCGL= "Id_gcgl";
	public static final String SD_GCGL= "Sd_gcgl";
	public static final String ID_HZQX= "Id_hzqx";
	public static final String SD_HZQX= "Sd_hzqx";
	public static final String PIPE_OTHER= "Pipe_other";
	public static final String PAT_LEV_OTHER= "Pat_lev_other";
	public static final String ID_SIGN_DOC= "Id_sign_doc";
	public static final String ID_SIGN_ANAER= "Id_sign_anaer";
	public static final String ID_SIGN_NUR= "Id_sign_nur";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_PAT= "Name_pat";
	public static final String NAME_SEX= "Name_sex";
	public static final String NAME_ANESTHESIA= "Name_anesthesia";
	public static final String NAME_EMP_OPER= "Name_emp_oper";
	public static final String NAME_ITEM_PRE= "Name_item_pre";
	public static final String NAME_SSYSCS= "Name_ssyscs";
	public static final String NAME_MZYSCS= "Name_mzyscs";
	public static final String NAME_SSHSCS= "Name_sshscs";
	public static final String NAME_GCGL= "Name_gcgl";
	public static final String NAME_HZQX= "Name_hzqx";
	public static final String NAME_SIGN_DOC= "Name_sign_doc";
	public static final String NAME_SIGN_ANAER= "Name_sign_anaer";
	public static final String NAME_SIGN_NUR= "Name_sign_nur";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_opersafe() {
		return ((String) getAttrVal("Id_opersafe"));
	}	
	public void setId_opersafe(String Id_opersafe) {
		setAttrVal("Id_opersafe", Id_opersafe);
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
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}	
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	public String getId_dep_phy() {
		return ((String) getAttrVal("Id_dep_phy"));
	}	
	public void setId_dep_phy(String Id_dep_phy) {
		setAttrVal("Id_dep_phy", Id_dep_phy);
	}
	public String getName_dep_phy() {
		return ((String) getAttrVal("Name_dep_phy"));
	}	
	public void setName_dep_phy(String Name_dep_phy) {
		setAttrVal("Name_dep_phy", Name_dep_phy);
	}
	public String getId_sex() {
		return ((String) getAttrVal("Id_sex"));
	}	
	public void setId_sex(String Id_sex) {
		setAttrVal("Id_sex", Id_sex);
	}
	public String getSd_sex() {
		return ((String) getAttrVal("Sd_sex"));
	}	
	public void setSd_sex(String Sd_sex) {
		setAttrVal("Sd_sex", Sd_sex);
	}
	public String getAge() {
		return ((String) getAttrVal("Age"));
	}	
	public void setAge(String Age) {
		setAttrVal("Age", Age);
	}
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}	
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	public String getId_anesthesia() {
		return ((String) getAttrVal("Id_anesthesia"));
	}	
	public void setId_anesthesia(String Id_anesthesia) {
		setAttrVal("Id_anesthesia", Id_anesthesia);
	}
	public String getSd_anesthesia() {
		return ((String) getAttrVal("Sd_anesthesia"));
	}	
	public void setSd_anesthesia(String Sd_anesthesia) {
		setAttrVal("Sd_anesthesia", Sd_anesthesia);
	}
	public String getOper_method() {
		return ((String) getAttrVal("Oper_method"));
	}	
	public void setOper_method(String Oper_method) {
		setAttrVal("Oper_method", Oper_method);
	}
	public String getId_emp_oper() {
		return ((String) getAttrVal("Id_emp_oper"));
	}	
	public void setId_emp_oper(String Id_emp_oper) {
		setAttrVal("Id_emp_oper", Id_emp_oper);
	}
	public FDate getDt_oper() {
		return ((FDate) getAttrVal("Dt_oper"));
	}	
	public void setDt_oper(FDate Dt_oper) {
		setAttrVal("Dt_oper", Dt_oper);
	}
	public String getId_group() {
		return ((String) getAttrVal("Id_group"));
	}	
	public void setId_group(String Id_group) {
		setAttrVal("Id_group", Id_group);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	public Integer getEu_patinfobeforeana() {
		return ((Integer) getAttrVal("Eu_patinfobeforeana"));
	}	
	public void setEu_patinfobeforeana(Integer Eu_patinfobeforeana) {
		setAttrVal("Eu_patinfobeforeana", Eu_patinfobeforeana);
	}
	public Integer getEu_opermodebeforeana() {
		return ((Integer) getAttrVal("Eu_opermodebeforeana"));
	}	
	public void setEu_opermodebeforeana(Integer Eu_opermodebeforeana) {
		setAttrVal("Eu_opermodebeforeana", Eu_opermodebeforeana);
	}
	public Integer getEu_ssbwybsq() {
		return ((Integer) getAttrVal("Eu_ssbwybsq"));
	}	
	public void setEu_ssbwybsq(Integer Eu_ssbwybsq) {
		setAttrVal("Eu_ssbwybsq", Eu_ssbwybsq);
	}
	public Integer getEu_sszqty() {
		return ((Integer) getAttrVal("Eu_sszqty"));
	}	
	public void setEu_sszqty(Integer Eu_sszqty) {
		setAttrVal("Eu_sszqty", Eu_sszqty);
	}
	public Integer getEu_mzzqty() {
		return ((Integer) getAttrVal("Eu_mzzqty"));
	}	
	public void setEu_mzzqty(Integer Eu_mzzqty) {
		setAttrVal("Eu_mzzqty", Eu_mzzqty);
	}
	public Integer getEu_mzfsqr() {
		return ((Integer) getAttrVal("Eu_mzfsqr"));
	}	
	public void setEu_mzfsqr(Integer Eu_mzfsqr) {
		setAttrVal("Eu_mzfsqr", Eu_mzfsqr);
	}
	public Integer getEu_mzsbaqjc() {
		return ((Integer) getAttrVal("Eu_mzsbaqjc"));
	}	
	public void setEu_mzsbaqjc(Integer Eu_mzsbaqjc) {
		setAttrVal("Eu_mzsbaqjc", Eu_mzsbaqjc);
	}
	public Integer getEu_pfsfwz() {
		return ((Integer) getAttrVal("Eu_pfsfwz"));
	}	
	public void setEu_pfsfwz(Integer Eu_pfsfwz) {
		setAttrVal("Eu_pfsfwz", Eu_pfsfwz);
	}
	public Integer getEu_sqpfzbzq() {
		return ((Integer) getAttrVal("Eu_sqpfzbzq"));
	}	
	public void setEu_sqpfzbzq(Integer Eu_sqpfzbzq) {
		setAttrVal("Eu_sqpfzbzq", Eu_sqpfzbzq);
	}
	public Integer getEu_jmtdjlwc() {
		return ((Integer) getAttrVal("Eu_jmtdjlwc"));
	}	
	public void setEu_jmtdjlwc(Integer Eu_jmtdjlwc) {
		setAttrVal("Eu_jmtdjlwc", Eu_jmtdjlwc);
	}
	public Integer getEu_hzsfygms() {
		return ((Integer) getAttrVal("Eu_hzsfygms"));
	}	
	public void setEu_hzsfygms(Integer Eu_hzsfygms) {
		setAttrVal("Eu_hzsfygms", Eu_hzsfygms);
	}
	public Integer getEu_kjywpsjg() {
		return ((Integer) getAttrVal("Eu_kjywpsjg"));
	}	
	public void setEu_kjywpsjg(Integer Eu_kjywpsjg) {
		setAttrVal("Eu_kjywpsjg", Eu_kjywpsjg);
	}
	public Integer getEu_sqbx() {
		return ((Integer) getAttrVal("Eu_sqbx"));
	}	
	public void setEu_sqbx(Integer Eu_sqbx) {
		setAttrVal("Eu_sqbx", Eu_sqbx);
	}
	public String getId_item_pre() {
		return ((String) getAttrVal("Id_item_pre"));
	}	
	public void setId_item_pre(String Id_item_pre) {
		setAttrVal("Id_item_pre", Id_item_pre);
	}
	public String getSd_item_pre() {
		return ((String) getAttrVal("Sd_item_pre"));
	}	
	public void setSd_item_pre(String Sd_item_pre) {
		setAttrVal("Sd_item_pre", Sd_item_pre);
	}
	public String getBf_ana_other() {
		return ((String) getAttrVal("Bf_ana_other"));
	}	
	public void setBf_ana_other(String Bf_ana_other) {
		setAttrVal("Bf_ana_other", Bf_ana_other);
	}
	public Integer getEu_xmxbnl() {
		return ((Integer) getAttrVal("Eu_xmxbnl"));
	}	
	public void setEu_xmxbnl(Integer Eu_xmxbnl) {
		setAttrVal("Eu_xmxbnl", Eu_xmxbnl);
	}
	public Integer getEu_sqssfsqr() {
		return ((Integer) getAttrVal("Eu_sqssfsqr"));
	}	
	public void setEu_sqssfsqr(Integer Eu_sqssfsqr) {
		setAttrVal("Eu_sqssfsqr", Eu_sqssfsqr);
	}
	public Integer getEu_sqssbwyb() {
		return ((Integer) getAttrVal("Eu_sqssbwyb"));
	}	
	public void setEu_sqssbwyb(Integer Eu_sqssbwyb) {
		setAttrVal("Eu_sqssbwyb", Eu_sqssbwyb);
	}
	public String getId_ssyscs() {
		return ((String) getAttrVal("Id_ssyscs"));
	}	
	public void setId_ssyscs(String Id_ssyscs) {
		setAttrVal("Id_ssyscs", Id_ssyscs);
	}
	public String getSd_ssyscs() {
		return ((String) getAttrVal("Sd_ssyscs"));
	}	
	public void setSd_ssyscs(String Sd_ssyscs) {
		setAttrVal("Sd_ssyscs", Sd_ssyscs);
	}
	public String getId_mzyscs() {
		return ((String) getAttrVal("Id_mzyscs"));
	}	
	public void setId_mzyscs(String Id_mzyscs) {
		setAttrVal("Id_mzyscs", Id_mzyscs);
	}
	public String getSd_mzyscs() {
		return ((String) getAttrVal("Sd_mzyscs"));
	}	
	public void setSd_mzyscs(String Sd_mzyscs) {
		setAttrVal("Sd_mzyscs", Sd_mzyscs);
	}
	public String getId_sshscs() {
		return ((String) getAttrVal("Id_sshscs"));
	}	
	public void setId_sshscs(String Id_sshscs) {
		setAttrVal("Id_sshscs", Id_sshscs);
	}
	public String getSd_sshscs() {
		return ((String) getAttrVal("Sd_sshscs"));
	}	
	public void setSd_sshscs(String Sd_sshscs) {
		setAttrVal("Sd_sshscs", Sd_sshscs);
	}
	public Integer getEu_sfxyxgyx() {
		return ((Integer) getAttrVal("Eu_sfxyxgyx"));
	}	
	public void setEu_sfxyxgyx(Integer Eu_sfxyxgyx) {
		setAttrVal("Eu_sfxyxgyx", Eu_sfxyxgyx);
	}
	public String getBf_oper_other() {
		return ((String) getAttrVal("Bf_oper_other"));
	}	
	public void setBf_oper_other(String Bf_oper_other) {
		setAttrVal("Bf_oper_other", Bf_oper_other);
	}
	public Integer getEu_shhzxmdxbd() {
		return ((Integer) getAttrVal("Eu_shhzxmdxbd"));
	}	
	public void setEu_shhzxmdxbd(Integer Eu_shhzxmdxbd) {
		setAttrVal("Eu_shhzxmdxbd", Eu_shhzxmdxbd);
	}
	public Integer getEu_sjssfsqr() {
		return ((Integer) getAttrVal("Eu_sjssfsqr"));
	}	
	public void setEu_sjssfsqr(Integer Eu_sjssfsqr) {
		setAttrVal("Eu_sjssfsqr", Eu_sjssfsqr);
	}
	public Integer getEu_ssyydsxd() {
		return ((Integer) getAttrVal("Eu_ssyydsxd"));
	}	
	public void setEu_ssyydsxd(Integer Eu_ssyydsxd) {
		setAttrVal("Eu_ssyydsxd", Eu_ssyydsxd);
	}
	public Integer getEu_ssywqdzq() {
		return ((Integer) getAttrVal("Eu_ssywqdzq"));
	}	
	public void setEu_ssywqdzq(Integer Eu_ssywqdzq) {
		setAttrVal("Eu_ssywqdzq", Eu_ssywqdzq);
	}
	public Integer getEu_ssbbqr() {
		return ((Integer) getAttrVal("Eu_ssbbqr"));
	}	
	public void setEu_ssbbqr(Integer Eu_ssbbqr) {
		setAttrVal("Eu_ssbbqr", Eu_ssbbqr);
	}
	public Integer getEu_shpfsfwz() {
		return ((Integer) getAttrVal("Eu_shpfsfwz"));
	}	
	public void setEu_shpfsfwz(Integer Eu_shpfsfwz) {
		setAttrVal("Eu_shpfsfwz", Eu_shpfsfwz);
	}
	public String getId_gcgl() {
		return ((String) getAttrVal("Id_gcgl"));
	}	
	public void setId_gcgl(String Id_gcgl) {
		setAttrVal("Id_gcgl", Id_gcgl);
	}
	public String getSd_gcgl() {
		return ((String) getAttrVal("Sd_gcgl"));
	}	
	public void setSd_gcgl(String Sd_gcgl) {
		setAttrVal("Sd_gcgl", Sd_gcgl);
	}
	public String getId_hzqx() {
		return ((String) getAttrVal("Id_hzqx"));
	}	
	public void setId_hzqx(String Id_hzqx) {
		setAttrVal("Id_hzqx", Id_hzqx);
	}
	public String getSd_hzqx() {
		return ((String) getAttrVal("Sd_hzqx"));
	}	
	public void setSd_hzqx(String Sd_hzqx) {
		setAttrVal("Sd_hzqx", Sd_hzqx);
	}
	public String getPipe_other() {
		return ((String) getAttrVal("Pipe_other"));
	}	
	public void setPipe_other(String Pipe_other) {
		setAttrVal("Pipe_other", Pipe_other);
	}
	public String getPat_lev_other() {
		return ((String) getAttrVal("Pat_lev_other"));
	}	
	public void setPat_lev_other(String Pat_lev_other) {
		setAttrVal("Pat_lev_other", Pat_lev_other);
	}
	public String getId_sign_doc() {
		return ((String) getAttrVal("Id_sign_doc"));
	}	
	public void setId_sign_doc(String Id_sign_doc) {
		setAttrVal("Id_sign_doc", Id_sign_doc);
	}
	public String getId_sign_anaer() {
		return ((String) getAttrVal("Id_sign_anaer"));
	}	
	public void setId_sign_anaer(String Id_sign_anaer) {
		setAttrVal("Id_sign_anaer", Id_sign_anaer);
	}
	public String getId_sign_nur() {
		return ((String) getAttrVal("Id_sign_nur"));
	}	
	public void setId_sign_nur(String Id_sign_nur) {
		setAttrVal("Id_sign_nur", Id_sign_nur);
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
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}	
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
	}
	public String getName_anesthesia() {
		return ((String) getAttrVal("Name_anesthesia"));
	}	
	public void setName_anesthesia(String Name_anesthesia) {
		setAttrVal("Name_anesthesia", Name_anesthesia);
	}
	public String getName_emp_oper() {
		return ((String) getAttrVal("Name_emp_oper"));
	}	
	public void setName_emp_oper(String Name_emp_oper) {
		setAttrVal("Name_emp_oper", Name_emp_oper);
	}
	public String getName_item_pre() {
		return ((String) getAttrVal("Name_item_pre"));
	}	
	public void setName_item_pre(String Name_item_pre) {
		setAttrVal("Name_item_pre", Name_item_pre);
	}
	public String getName_ssyscs() {
		return ((String) getAttrVal("Name_ssyscs"));
	}	
	public void setName_ssyscs(String Name_ssyscs) {
		setAttrVal("Name_ssyscs", Name_ssyscs);
	}
	public String getName_mzyscs() {
		return ((String) getAttrVal("Name_mzyscs"));
	}	
	public void setName_mzyscs(String Name_mzyscs) {
		setAttrVal("Name_mzyscs", Name_mzyscs);
	}
	public String getName_sshscs() {
		return ((String) getAttrVal("Name_sshscs"));
	}	
	public void setName_sshscs(String Name_sshscs) {
		setAttrVal("Name_sshscs", Name_sshscs);
	}
	public String getName_gcgl() {
		return ((String) getAttrVal("Name_gcgl"));
	}	
	public void setName_gcgl(String Name_gcgl) {
		setAttrVal("Name_gcgl", Name_gcgl);
	}
	public String getName_hzqx() {
		return ((String) getAttrVal("Name_hzqx"));
	}	
	public void setName_hzqx(String Name_hzqx) {
		setAttrVal("Name_hzqx", Name_hzqx);
	}
	public String getName_sign_doc() {
		return ((String) getAttrVal("Name_sign_doc"));
	}	
	public void setName_sign_doc(String Name_sign_doc) {
		setAttrVal("Name_sign_doc", Name_sign_doc);
	}
	public String getName_sign_anaer() {
		return ((String) getAttrVal("Name_sign_anaer"));
	}	
	public void setName_sign_anaer(String Name_sign_anaer) {
		setAttrVal("Name_sign_anaer", Name_sign_anaer);
	}
	public String getName_sign_nur() {
		return ((String) getAttrVal("Name_sign_nur"));
	}	
	public void setName_sign_nur(String Name_sign_nur) {
		setAttrVal("Name_sign_nur", Name_sign_nur);
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
		return "Id_opersafe";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_mr_nu_opersafe";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OperSafeCheckTableDODesc.class);
	}
	
}