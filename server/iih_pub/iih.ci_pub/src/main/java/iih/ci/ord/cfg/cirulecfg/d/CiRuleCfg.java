package iih.ci.ord.cfg.cirulecfg.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.cfg.cirulecfg.d.desc.CiRuleCfgDesc;
import java.math.BigDecimal;

/**
 * 医嘱规则配置 DO数据 
 * 
 */
public class CiRuleCfg extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_RULECFG= "Id_rulecfg";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String ID_ENTP= "Id_entp";
	public static final String CODE_ENTP= "Code_entp";
	public static final String RULE_NAME= "Rule_name";
	public static final String EU_CHECK_POINT= "Eu_check_point";
	public static final String ID_RULES= "Id_rules";
	public static final String CFG_RESULT= "Cfg_result";
	public static final String DES= "Des";
	public static final String SORTNO= "Sortno";
	public static final String CODE_GRP= "Code_grp";
	public static final String NAME_GRP= "Name_grp";
	public static final String CODE_ORG= "Code_org";
	public static final String NAME_ORG= "Name_org";
	public static final String ENTP_NAME= "Entp_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_rulecfg() {
		return ((String) getAttrVal("Id_rulecfg"));
	}	
	public void setId_rulecfg(String Id_rulecfg) {
		setAttrVal("Id_rulecfg", Id_rulecfg);
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
	public String getId_entp() {
		return ((String) getAttrVal("Id_entp"));
	}	
	public void setId_entp(String Id_entp) {
		setAttrVal("Id_entp", Id_entp);
	}
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}	
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	public String getRule_name() {
		return ((String) getAttrVal("Rule_name"));
	}	
	public void setRule_name(String Rule_name) {
		setAttrVal("Rule_name", Rule_name);
	}
	public String getEu_check_point() {
		return ((String) getAttrVal("Eu_check_point"));
	}	
	public void setEu_check_point(String Eu_check_point) {
		setAttrVal("Eu_check_point", Eu_check_point);
	}
	public String getId_rules() {
		return ((String) getAttrVal("Id_rules"));
	}	
	public void setId_rules(String Id_rules) {
		setAttrVal("Id_rules", Id_rules);
	}
	public String getCfg_result() {
		return ((String) getAttrVal("Cfg_result"));
	}	
	public void setCfg_result(String Cfg_result) {
		setAttrVal("Cfg_result", Cfg_result);
	}
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	public String getCode_grp() {
		return ((String) getAttrVal("Code_grp"));
	}	
	public void setCode_grp(String Code_grp) {
		setAttrVal("Code_grp", Code_grp);
	}
	public String getName_grp() {
		return ((String) getAttrVal("Name_grp"));
	}	
	public void setName_grp(String Name_grp) {
		setAttrVal("Name_grp", Name_grp);
	}
	public String getCode_org() {
		return ((String) getAttrVal("Code_org"));
	}	
	public void setCode_org(String Code_org) {
		setAttrVal("Code_org", Code_org);
	}
	public String getName_org() {
		return ((String) getAttrVal("Name_org"));
	}	
	public void setName_org(String Name_org) {
		setAttrVal("Name_org", Name_org);
	}
	public String getEntp_name() {
		return ((String) getAttrVal("Entp_name"));
	}	
	public void setEntp_name(String Entp_name) {
		setAttrVal("Entp_name", Entp_name);
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
		return "Id_rulecfg";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_rule_cfg";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiRuleCfgDesc.class);
	}
	
}