package iih.ci.mr.per.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.per.d.desc.PerDODesc;
import java.math.BigDecimal;

/**
 * 牙周检查主表 DO数据 
 * 
 */
public class PerDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PER= "Id_per";
	public static final String ID_MR= "Id_mr";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_PAT= "Id_pat";
	public static final String CODE_AMR_IP= "Code_amr_ip";
	public static final String CODE_ENTP= "Code_entp";
	public static final String NAME= "Name";
	public static final String DT_OP= "Dt_op";
	public static final String ID_DEP_OP= "Id_dep_op";
	public static final String BI_PER= "Bi_per";
	public static final String DIS_ICD= "Dis_icd";
	public static final String DIA_TRE_PLAN= "Dia_tre_plan";
	public static final String REMARK= "Remark";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String ID_CODE= "Id_code";
	public static final String ID_SEX= "Id_sex";
	public static final String SD_SEX= "Sd_sex";
	public static final String NAME_SEX= "Name_sex";
	public static final String DT_BIRTH= "Dt_birth";
	public static final String ID_EMP_ENTRY= "Id_emp_entry";
	public static final String SD_EMP_ENTRY= "Sd_emp_entry";
	public static final String NAME_EMP_ENTRY= "Name_emp_entry";
	public static final String ID_GRP= "Id_grp";
	public static final String SD_GRP= "Sd_grp";
	public static final String NAME_GRP= "Name_grp";
	public static final String ID_ORG= "Id_org";
	public static final String SD_ORG= "Sd_org";
	public static final String NAME_ORG= "Name_org";
	public static final String SEX_CODE= "Sex_code";
	public static final String SEX_NAME= "Sex_name";
	public static final String EMP_ENTRY_CODE= "Emp_entry_code";
	public static final String EMP_ENTRY_NAME= "Emp_entry_name";
	public static final String ORG_CODE= "Org_code";
	public static final String ORG_NAME= "Org_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_per() {
		return ((String) getAttrVal("Id_per"));
	}	
	public void setId_per(String Id_per) {
		setAttrVal("Id_per", Id_per);
	}
	public String getId_mr() {
		return ((String) getAttrVal("Id_mr"));
	}	
	public void setId_mr(String Id_mr) {
		setAttrVal("Id_mr", Id_mr);
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
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}	
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}	
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public FDate getDt_op() {
		return ((FDate) getAttrVal("Dt_op"));
	}	
	public void setDt_op(FDate Dt_op) {
		setAttrVal("Dt_op", Dt_op);
	}
	public String getId_dep_op() {
		return ((String) getAttrVal("Id_dep_op"));
	}	
	public void setId_dep_op(String Id_dep_op) {
		setAttrVal("Id_dep_op", Id_dep_op);
	}
	public String getBi_per() {
		return ((String) getAttrVal("Bi_per"));
	}	
	public void setBi_per(String Bi_per) {
		setAttrVal("Bi_per", Bi_per);
	}
	public String getDis_icd() {
		return ((String) getAttrVal("Dis_icd"));
	}	
	public void setDis_icd(String Dis_icd) {
		setAttrVal("Dis_icd", Dis_icd);
	}
	public String getDia_tre_plan() {
		return ((String) getAttrVal("Dia_tre_plan"));
	}	
	public void setDia_tre_plan(String Dia_tre_plan) {
		setAttrVal("Dia_tre_plan", Dia_tre_plan);
	}
	public String getRemark() {
		return ((String) getAttrVal("Remark"));
	}	
	public void setRemark(String Remark) {
		setAttrVal("Remark", Remark);
	}
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}	
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	public String getCreatedtime() {
		return ((String) getAttrVal("Createdtime"));
	}	
	public void setCreatedtime(String Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}	
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	public String getModifiedtime() {
		return ((String) getAttrVal("Modifiedtime"));
	}	
	public void setModifiedtime(String Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
	}
	public String getId_code() {
		return ((String) getAttrVal("Id_code"));
	}	
	public void setId_code(String Id_code) {
		setAttrVal("Id_code", Id_code);
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
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}	
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
	}
	public FDate getDt_birth() {
		return ((FDate) getAttrVal("Dt_birth"));
	}	
	public void setDt_birth(FDate Dt_birth) {
		setAttrVal("Dt_birth", Dt_birth);
	}
	public String getId_emp_entry() {
		return ((String) getAttrVal("Id_emp_entry"));
	}	
	public void setId_emp_entry(String Id_emp_entry) {
		setAttrVal("Id_emp_entry", Id_emp_entry);
	}
	public String getSd_emp_entry() {
		return ((String) getAttrVal("Sd_emp_entry"));
	}	
	public void setSd_emp_entry(String Sd_emp_entry) {
		setAttrVal("Sd_emp_entry", Sd_emp_entry);
	}
	public String getName_emp_entry() {
		return ((String) getAttrVal("Name_emp_entry"));
	}	
	public void setName_emp_entry(String Name_emp_entry) {
		setAttrVal("Name_emp_entry", Name_emp_entry);
	}
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	public String getSd_grp() {
		return ((String) getAttrVal("Sd_grp"));
	}	
	public void setSd_grp(String Sd_grp) {
		setAttrVal("Sd_grp", Sd_grp);
	}
	public String getName_grp() {
		return ((String) getAttrVal("Name_grp"));
	}	
	public void setName_grp(String Name_grp) {
		setAttrVal("Name_grp", Name_grp);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	public String getSd_org() {
		return ((String) getAttrVal("Sd_org"));
	}	
	public void setSd_org(String Sd_org) {
		setAttrVal("Sd_org", Sd_org);
	}
	public String getName_org() {
		return ((String) getAttrVal("Name_org"));
	}	
	public void setName_org(String Name_org) {
		setAttrVal("Name_org", Name_org);
	}
	public String getSex_code() {
		return ((String) getAttrVal("Sex_code"));
	}	
	public void setSex_code(String Sex_code) {
		setAttrVal("Sex_code", Sex_code);
	}
	public String getSex_name() {
		return ((String) getAttrVal("Sex_name"));
	}	
	public void setSex_name(String Sex_name) {
		setAttrVal("Sex_name", Sex_name);
	}
	public String getEmp_entry_code() {
		return ((String) getAttrVal("Emp_entry_code"));
	}	
	public void setEmp_entry_code(String Emp_entry_code) {
		setAttrVal("Emp_entry_code", Emp_entry_code);
	}
	public String getEmp_entry_name() {
		return ((String) getAttrVal("Emp_entry_name"));
	}	
	public void setEmp_entry_name(String Emp_entry_name) {
		setAttrVal("Emp_entry_name", Emp_entry_name);
	}
	public String getOrg_code() {
		return ((String) getAttrVal("Org_code"));
	}	
	public void setOrg_code(String Org_code) {
		setAttrVal("Org_code", Org_code);
	}
	public String getOrg_name() {
		return ((String) getAttrVal("Org_name"));
	}	
	public void setOrg_name(String Org_name) {
		setAttrVal("Org_name", Org_name);
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
		return "Id_per";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_MR_PER_QC";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PerDODesc.class);
	}
	
}