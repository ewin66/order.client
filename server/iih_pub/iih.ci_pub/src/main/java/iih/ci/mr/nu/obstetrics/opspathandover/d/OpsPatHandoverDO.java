package iih.ci.mr.nu.obstetrics.opspathandover.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.obstetrics.opspathandover.d.desc.OpsPatHandoverDODesc;
import java.math.BigDecimal;

/**
 * 手术病人情况交接登记单 DO数据 
 * 
 */
public class OpsPatHandoverDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_OPSPATHANDOVER= "Id_opspathandover";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_PAT= "Id_pat";
	public static final String CODE_ENTP= "Code_entp";
	public static final String DT_CREATE= "Dt_create";
	public static final String DT_ACCEPT= "Dt_accept";
	public static final String ID_DEP_NUR= "Id_dep_nur";
	public static final String NAME_BED= "Name_bed";
	public static final String AGE= "Age";
	public static final String DT_INROOM= "Dt_inroom";
	public static final String NAME_OPERATION= "Name_operation";
	public static final String EU_SQYY= "Eu_sqyy";
	public static final String ID_SKIN_CON= "Id_skin_con";
	public static final String SD_SKIN_CON= "Sd_skin_con";
	public static final String EU_JZRS= "Eu_jzrs";
	public static final String ID_CON_STATEIN= "Id_con_statein";
	public static final String SD_CON_STATEIN= "Sd_con_statein";
	public static final String EU_ZTHDZC= "Eu_zthdzc";
	public static final String EU_GRSS= "Eu_grss";
	public static final String EU_BL= "Eu_bl";
	public static final String EU_JMTL= "Eu_jmtl";
	public static final String EU_LZDN= "Eu_lzdn";
	public static final String EU_PFQK= "Eu_pfqk";
	public static final String DES_SKIN_IN= "Des_skin_in";
	public static final String REMARKS_ZR= "Remarks_zr";
	public static final String ID_EMP_NUR_INCHK= "Id_emp_nur_inchk";
	public static final String ID_EMP_OPR_INCHK= "Id_emp_opr_inchk";
	public static final String DT_OUTROOM= "Dt_outroom";
	public static final String ID_LIQUID= "Id_liquid";
	public static final String SD_LIQUID= "Sd_liquid";
	public static final String ID_CON_STATEOUT= "Id_con_stateout";
	public static final String SD_CON_STATEOUT= "Sd_con_stateout";
	public static final String ID_BREATH_TYPE= "Id_breath_type";
	public static final String SD_BREATH_TYPE= "Sd_breath_type";
	public static final String EU_WZJMTC= "Eu_wzjmtc";
	public static final String EU_LZDNGCT= "Eu_lzdngct";
	public static final String EU_ZXJM= "Eu_zxjm";
	public static final String EU_QKYL= "Eu_qkyl";
	public static final String ID_INFUSION_BLOOD= "Id_infusion_blood";
	public static final String SD_INFUSION_BLOOD= "Sd_infusion_blood";
	public static final String ID_BLOOD_PRO= "Id_blood_pro";
	public static final String SD_BLOOD_PRO= "Sd_blood_pro";
	public static final String EU_HXYPZSQK= "Eu_hxypzsqk";
	public static final String EU_PFQJ= "Eu_pfqj";
	public static final String EU_SHJJBL= "Eu_shjjbl";
	public static final String EU_SHJJPFQK= "Eu_shjjpfqk";
	public static final String DES_SKIN_OUT= "Des_skin_out";
	public static final String REMARK_JJ= "Remark_jj";
	public static final String ID_EMP_NUR_OUTCHK= "Id_emp_nur_outchk";
	public static final String ID_EMP_OPR_OUTCHK= "Id_emp_opr_outchk";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_PAT= "Name_pat";
	public static final String DT_BIRTH_PAT= "Dt_birth_pat";
	public static final String CODE_AMR_IP= "Code_amr_ip";
	public static final String NAME_DEP_NUR= "Name_dep_nur";
	public static final String NAME_SKIN_CON= "Name_skin_con";
	public static final String NAME_CON_STATEIN= "Name_con_statein";
	public static final String NAME_NUR_INCHK= "Name_nur_inchk";
	public static final String NAME_OPR_INCHK= "Name_opr_inchk";
	public static final String NAME_LIQUID= "Name_liquid";
	public static final String NAME_CON_STATEOUT= "Name_con_stateout";
	public static final String NAME_BREATH_TYPE= "Name_breath_type";
	public static final String NAME_INFUSION_BLOOD= "Name_infusion_blood";
	public static final String NAME_BLOOD_PRO= "Name_blood_pro";
	public static final String NAME_NUR_OUTCHK= "Name_nur_outchk";
	public static final String NAME_OPR_OUTCHK= "Name_opr_outchk";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_opspathandover() {
		return ((String) getAttrVal("Id_opspathandover"));
	}	
	public void setId_opspathandover(String Id_opspathandover) {
		setAttrVal("Id_opspathandover", Id_opspathandover);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
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
	public FDate getDt_create() {
		return ((FDate) getAttrVal("Dt_create"));
	}	
	public void setDt_create(FDate Dt_create) {
		setAttrVal("Dt_create", Dt_create);
	}
	public FDateTime getDt_accept() {
		return ((FDateTime) getAttrVal("Dt_accept"));
	}	
	public void setDt_accept(FDateTime Dt_accept) {
		setAttrVal("Dt_accept", Dt_accept);
	}
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}	
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	public String getName_bed() {
		return ((String) getAttrVal("Name_bed"));
	}	
	public void setName_bed(String Name_bed) {
		setAttrVal("Name_bed", Name_bed);
	}
	public String getAge() {
		return ((String) getAttrVal("Age"));
	}	
	public void setAge(String Age) {
		setAttrVal("Age", Age);
	}
	public FDateTime getDt_inroom() {
		return ((FDateTime) getAttrVal("Dt_inroom"));
	}	
	public void setDt_inroom(FDateTime Dt_inroom) {
		setAttrVal("Dt_inroom", Dt_inroom);
	}
	public String getName_operation() {
		return ((String) getAttrVal("Name_operation"));
	}	
	public void setName_operation(String Name_operation) {
		setAttrVal("Name_operation", Name_operation);
	}
	public Integer getEu_sqyy() {
		return ((Integer) getAttrVal("Eu_sqyy"));
	}	
	public void setEu_sqyy(Integer Eu_sqyy) {
		setAttrVal("Eu_sqyy", Eu_sqyy);
	}
	public String getId_skin_con() {
		return ((String) getAttrVal("Id_skin_con"));
	}	
	public void setId_skin_con(String Id_skin_con) {
		setAttrVal("Id_skin_con", Id_skin_con);
	}
	public String getSd_skin_con() {
		return ((String) getAttrVal("Sd_skin_con"));
	}	
	public void setSd_skin_con(String Sd_skin_con) {
		setAttrVal("Sd_skin_con", Sd_skin_con);
	}
	public Integer getEu_jzrs() {
		return ((Integer) getAttrVal("Eu_jzrs"));
	}	
	public void setEu_jzrs(Integer Eu_jzrs) {
		setAttrVal("Eu_jzrs", Eu_jzrs);
	}
	public String getId_con_statein() {
		return ((String) getAttrVal("Id_con_statein"));
	}	
	public void setId_con_statein(String Id_con_statein) {
		setAttrVal("Id_con_statein", Id_con_statein);
	}
	public String getSd_con_statein() {
		return ((String) getAttrVal("Sd_con_statein"));
	}	
	public void setSd_con_statein(String Sd_con_statein) {
		setAttrVal("Sd_con_statein", Sd_con_statein);
	}
	public Integer getEu_zthdzc() {
		return ((Integer) getAttrVal("Eu_zthdzc"));
	}	
	public void setEu_zthdzc(Integer Eu_zthdzc) {
		setAttrVal("Eu_zthdzc", Eu_zthdzc);
	}
	public Integer getEu_grss() {
		return ((Integer) getAttrVal("Eu_grss"));
	}	
	public void setEu_grss(Integer Eu_grss) {
		setAttrVal("Eu_grss", Eu_grss);
	}
	public Integer getEu_bl() {
		return ((Integer) getAttrVal("Eu_bl"));
	}	
	public void setEu_bl(Integer Eu_bl) {
		setAttrVal("Eu_bl", Eu_bl);
	}
	public Integer getEu_jmtl() {
		return ((Integer) getAttrVal("Eu_jmtl"));
	}	
	public void setEu_jmtl(Integer Eu_jmtl) {
		setAttrVal("Eu_jmtl", Eu_jmtl);
	}
	public Integer getEu_lzdn() {
		return ((Integer) getAttrVal("Eu_lzdn"));
	}	
	public void setEu_lzdn(Integer Eu_lzdn) {
		setAttrVal("Eu_lzdn", Eu_lzdn);
	}
	public Integer getEu_pfqk() {
		return ((Integer) getAttrVal("Eu_pfqk"));
	}	
	public void setEu_pfqk(Integer Eu_pfqk) {
		setAttrVal("Eu_pfqk", Eu_pfqk);
	}
	public String getDes_skin_in() {
		return ((String) getAttrVal("Des_skin_in"));
	}	
	public void setDes_skin_in(String Des_skin_in) {
		setAttrVal("Des_skin_in", Des_skin_in);
	}
	public String getRemarks_zr() {
		return ((String) getAttrVal("Remarks_zr"));
	}	
	public void setRemarks_zr(String Remarks_zr) {
		setAttrVal("Remarks_zr", Remarks_zr);
	}
	public String getId_emp_nur_inchk() {
		return ((String) getAttrVal("Id_emp_nur_inchk"));
	}	
	public void setId_emp_nur_inchk(String Id_emp_nur_inchk) {
		setAttrVal("Id_emp_nur_inchk", Id_emp_nur_inchk);
	}
	public String getId_emp_opr_inchk() {
		return ((String) getAttrVal("Id_emp_opr_inchk"));
	}	
	public void setId_emp_opr_inchk(String Id_emp_opr_inchk) {
		setAttrVal("Id_emp_opr_inchk", Id_emp_opr_inchk);
	}
	public FDateTime getDt_outroom() {
		return ((FDateTime) getAttrVal("Dt_outroom"));
	}	
	public void setDt_outroom(FDateTime Dt_outroom) {
		setAttrVal("Dt_outroom", Dt_outroom);
	}
	public String getId_liquid() {
		return ((String) getAttrVal("Id_liquid"));
	}	
	public void setId_liquid(String Id_liquid) {
		setAttrVal("Id_liquid", Id_liquid);
	}
	public String getSd_liquid() {
		return ((String) getAttrVal("Sd_liquid"));
	}	
	public void setSd_liquid(String Sd_liquid) {
		setAttrVal("Sd_liquid", Sd_liquid);
	}
	public String getId_con_stateout() {
		return ((String) getAttrVal("Id_con_stateout"));
	}	
	public void setId_con_stateout(String Id_con_stateout) {
		setAttrVal("Id_con_stateout", Id_con_stateout);
	}
	public String getSd_con_stateout() {
		return ((String) getAttrVal("Sd_con_stateout"));
	}	
	public void setSd_con_stateout(String Sd_con_stateout) {
		setAttrVal("Sd_con_stateout", Sd_con_stateout);
	}
	public String getId_breath_type() {
		return ((String) getAttrVal("Id_breath_type"));
	}	
	public void setId_breath_type(String Id_breath_type) {
		setAttrVal("Id_breath_type", Id_breath_type);
	}
	public String getSd_breath_type() {
		return ((String) getAttrVal("Sd_breath_type"));
	}	
	public void setSd_breath_type(String Sd_breath_type) {
		setAttrVal("Sd_breath_type", Sd_breath_type);
	}
	public Integer getEu_wzjmtc() {
		return ((Integer) getAttrVal("Eu_wzjmtc"));
	}	
	public void setEu_wzjmtc(Integer Eu_wzjmtc) {
		setAttrVal("Eu_wzjmtc", Eu_wzjmtc);
	}
	public Integer getEu_lzdngct() {
		return ((Integer) getAttrVal("Eu_lzdngct"));
	}	
	public void setEu_lzdngct(Integer Eu_lzdngct) {
		setAttrVal("Eu_lzdngct", Eu_lzdngct);
	}
	public Integer getEu_zxjm() {
		return ((Integer) getAttrVal("Eu_zxjm"));
	}	
	public void setEu_zxjm(Integer Eu_zxjm) {
		setAttrVal("Eu_zxjm", Eu_zxjm);
	}
	public Integer getEu_qkyl() {
		return ((Integer) getAttrVal("Eu_qkyl"));
	}	
	public void setEu_qkyl(Integer Eu_qkyl) {
		setAttrVal("Eu_qkyl", Eu_qkyl);
	}
	public String getId_infusion_blood() {
		return ((String) getAttrVal("Id_infusion_blood"));
	}	
	public void setId_infusion_blood(String Id_infusion_blood) {
		setAttrVal("Id_infusion_blood", Id_infusion_blood);
	}
	public String getSd_infusion_blood() {
		return ((String) getAttrVal("Sd_infusion_blood"));
	}	
	public void setSd_infusion_blood(String Sd_infusion_blood) {
		setAttrVal("Sd_infusion_blood", Sd_infusion_blood);
	}
	public String getId_blood_pro() {
		return ((String) getAttrVal("Id_blood_pro"));
	}	
	public void setId_blood_pro(String Id_blood_pro) {
		setAttrVal("Id_blood_pro", Id_blood_pro);
	}
	public String getSd_blood_pro() {
		return ((String) getAttrVal("Sd_blood_pro"));
	}	
	public void setSd_blood_pro(String Sd_blood_pro) {
		setAttrVal("Sd_blood_pro", Sd_blood_pro);
	}
	public Integer getEu_hxypzsqk() {
		return ((Integer) getAttrVal("Eu_hxypzsqk"));
	}	
	public void setEu_hxypzsqk(Integer Eu_hxypzsqk) {
		setAttrVal("Eu_hxypzsqk", Eu_hxypzsqk);
	}
	public Integer getEu_pfqj() {
		return ((Integer) getAttrVal("Eu_pfqj"));
	}	
	public void setEu_pfqj(Integer Eu_pfqj) {
		setAttrVal("Eu_pfqj", Eu_pfqj);
	}
	public Integer getEu_shjjbl() {
		return ((Integer) getAttrVal("Eu_shjjbl"));
	}	
	public void setEu_shjjbl(Integer Eu_shjjbl) {
		setAttrVal("Eu_shjjbl", Eu_shjjbl);
	}
	public Integer getEu_shjjpfqk() {
		return ((Integer) getAttrVal("Eu_shjjpfqk"));
	}	
	public void setEu_shjjpfqk(Integer Eu_shjjpfqk) {
		setAttrVal("Eu_shjjpfqk", Eu_shjjpfqk);
	}
	public String getDes_skin_out() {
		return ((String) getAttrVal("Des_skin_out"));
	}	
	public void setDes_skin_out(String Des_skin_out) {
		setAttrVal("Des_skin_out", Des_skin_out);
	}
	public String getRemark_jj() {
		return ((String) getAttrVal("Remark_jj"));
	}	
	public void setRemark_jj(String Remark_jj) {
		setAttrVal("Remark_jj", Remark_jj);
	}
	public String getId_emp_nur_outchk() {
		return ((String) getAttrVal("Id_emp_nur_outchk"));
	}	
	public void setId_emp_nur_outchk(String Id_emp_nur_outchk) {
		setAttrVal("Id_emp_nur_outchk", Id_emp_nur_outchk);
	}
	public String getId_emp_opr_outchk() {
		return ((String) getAttrVal("Id_emp_opr_outchk"));
	}	
	public void setId_emp_opr_outchk(String Id_emp_opr_outchk) {
		setAttrVal("Id_emp_opr_outchk", Id_emp_opr_outchk);
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
	public FDate getDt_birth_pat() {
		return ((FDate) getAttrVal("Dt_birth_pat"));
	}	
	public void setDt_birth_pat(FDate Dt_birth_pat) {
		setAttrVal("Dt_birth_pat", Dt_birth_pat);
	}
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}	
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	public String getName_dep_nur() {
		return ((String) getAttrVal("Name_dep_nur"));
	}	
	public void setName_dep_nur(String Name_dep_nur) {
		setAttrVal("Name_dep_nur", Name_dep_nur);
	}
	public String getName_skin_con() {
		return ((String) getAttrVal("Name_skin_con"));
	}	
	public void setName_skin_con(String Name_skin_con) {
		setAttrVal("Name_skin_con", Name_skin_con);
	}
	public String getName_con_statein() {
		return ((String) getAttrVal("Name_con_statein"));
	}	
	public void setName_con_statein(String Name_con_statein) {
		setAttrVal("Name_con_statein", Name_con_statein);
	}
	public String getName_nur_inchk() {
		return ((String) getAttrVal("Name_nur_inchk"));
	}	
	public void setName_nur_inchk(String Name_nur_inchk) {
		setAttrVal("Name_nur_inchk", Name_nur_inchk);
	}
	public String getName_opr_inchk() {
		return ((String) getAttrVal("Name_opr_inchk"));
	}	
	public void setName_opr_inchk(String Name_opr_inchk) {
		setAttrVal("Name_opr_inchk", Name_opr_inchk);
	}
	public String getName_liquid() {
		return ((String) getAttrVal("Name_liquid"));
	}	
	public void setName_liquid(String Name_liquid) {
		setAttrVal("Name_liquid", Name_liquid);
	}
	public String getName_con_stateout() {
		return ((String) getAttrVal("Name_con_stateout"));
	}	
	public void setName_con_stateout(String Name_con_stateout) {
		setAttrVal("Name_con_stateout", Name_con_stateout);
	}
	public String getName_breath_type() {
		return ((String) getAttrVal("Name_breath_type"));
	}	
	public void setName_breath_type(String Name_breath_type) {
		setAttrVal("Name_breath_type", Name_breath_type);
	}
	public String getName_infusion_blood() {
		return ((String) getAttrVal("Name_infusion_blood"));
	}	
	public void setName_infusion_blood(String Name_infusion_blood) {
		setAttrVal("Name_infusion_blood", Name_infusion_blood);
	}
	public String getName_blood_pro() {
		return ((String) getAttrVal("Name_blood_pro"));
	}	
	public void setName_blood_pro(String Name_blood_pro) {
		setAttrVal("Name_blood_pro", Name_blood_pro);
	}
	public String getName_nur_outchk() {
		return ((String) getAttrVal("Name_nur_outchk"));
	}	
	public void setName_nur_outchk(String Name_nur_outchk) {
		setAttrVal("Name_nur_outchk", Name_nur_outchk);
	}
	public String getName_opr_outchk() {
		return ((String) getAttrVal("Name_opr_outchk"));
	}	
	public void setName_opr_outchk(String Name_opr_outchk) {
		setAttrVal("Name_opr_outchk", Name_opr_outchk);
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
		return "Id_opspathandover";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_mr_nu_opspathandover";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OpsPatHandoverDODesc.class);
	}
	
}