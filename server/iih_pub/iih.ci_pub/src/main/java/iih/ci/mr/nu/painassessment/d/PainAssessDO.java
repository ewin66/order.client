package iih.ci.mr.nu.painassessment.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.painassessment.d.desc.PainAssessDODesc;
import java.math.BigDecimal;

/**
 * 疼痛护理评估表 DO数据 
 * 
 */
public class PainAssessDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PA= "Id_pa";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_PAT= "Id_pat";
	public static final String CODE_ENTP= "Code_entp";
	public static final String ID_SEX= "Id_sex";
	public static final String SD_SEX= "Sd_sex";
	public static final String NAME_BED= "Name_bed";
	public static final String CODE_AMR_IP= "Code_amr_ip";
	public static final String ID_DEP_PHY= "Id_dep_phy";
	public static final String AGE= "Age";
	public static final String DT_ENTRY= "Dt_entry";
	public static final String NAME_DIAGNOSIS= "Name_diagnosis";
	public static final String DT_OPER= "Dt_oper";
	public static final String NAME_OPER= "Name_oper";
	public static final String DT_BACKROOM= "Dt_backroom";
	public static final String FG_ANALGESIA= "Fg_analgesia";
	public static final String BEGIN_ANALGESIA= "Begin_analgesia";
	public static final String END_ANALGESIA= "End_analgesia";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_PAT= "Name_pat";
	public static final String NAME_SEX= "Name_sex";
	public static final String NAME_DEP_PHY= "Name_dep_phy";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_pa() {
		return ((String) getAttrVal("Id_pa"));
	}	
	public void setId_pa(String Id_pa) {
		setAttrVal("Id_pa", Id_pa);
	}
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
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
	public String getName_bed() {
		return ((String) getAttrVal("Name_bed"));
	}	
	public void setName_bed(String Name_bed) {
		setAttrVal("Name_bed", Name_bed);
	}
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}	
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	public String getId_dep_phy() {
		return ((String) getAttrVal("Id_dep_phy"));
	}	
	public void setId_dep_phy(String Id_dep_phy) {
		setAttrVal("Id_dep_phy", Id_dep_phy);
	}
	public String getAge() {
		return ((String) getAttrVal("Age"));
	}	
	public void setAge(String Age) {
		setAttrVal("Age", Age);
	}
	public FDate getDt_entry() {
		return ((FDate) getAttrVal("Dt_entry"));
	}	
	public void setDt_entry(FDate Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	public String getName_diagnosis() {
		return ((String) getAttrVal("Name_diagnosis"));
	}	
	public void setName_diagnosis(String Name_diagnosis) {
		setAttrVal("Name_diagnosis", Name_diagnosis);
	}
	public FDate getDt_oper() {
		return ((FDate) getAttrVal("Dt_oper"));
	}	
	public void setDt_oper(FDate Dt_oper) {
		setAttrVal("Dt_oper", Dt_oper);
	}
	public String getName_oper() {
		return ((String) getAttrVal("Name_oper"));
	}	
	public void setName_oper(String Name_oper) {
		setAttrVal("Name_oper", Name_oper);
	}
	public FDateTime getDt_backroom() {
		return ((FDateTime) getAttrVal("Dt_backroom"));
	}	
	public void setDt_backroom(FDateTime Dt_backroom) {
		setAttrVal("Dt_backroom", Dt_backroom);
	}
	public Integer getFg_analgesia() {
		return ((Integer) getAttrVal("Fg_analgesia"));
	}	
	public void setFg_analgesia(Integer Fg_analgesia) {
		setAttrVal("Fg_analgesia", Fg_analgesia);
	}
	public FDateTime getBegin_analgesia() {
		return ((FDateTime) getAttrVal("Begin_analgesia"));
	}	
	public void setBegin_analgesia(FDateTime Begin_analgesia) {
		setAttrVal("Begin_analgesia", Begin_analgesia);
	}
	public FDateTime getEnd_analgesia() {
		return ((FDateTime) getAttrVal("End_analgesia"));
	}	
	public void setEnd_analgesia(FDateTime End_analgesia) {
		setAttrVal("End_analgesia", End_analgesia);
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
	public String getName_dep_phy() {
		return ((String) getAttrVal("Name_dep_phy"));
	}	
	public void setName_dep_phy(String Name_dep_phy) {
		setAttrVal("Name_dep_phy", Name_dep_phy);
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
		return "Id_pa";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_MR_NU_PA";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PainAssessDODesc.class);
	}
	
}