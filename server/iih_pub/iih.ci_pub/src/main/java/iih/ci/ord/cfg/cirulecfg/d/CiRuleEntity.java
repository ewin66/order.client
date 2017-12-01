package iih.ci.ord.cfg.cirulecfg.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.cfg.cirulecfg.d.desc.CiRuleEntityDesc;
import java.math.BigDecimal;

/**
 * 医嘱规则实体 DO数据 
 * 
 */
public class CiRuleEntity extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_RULE= "Id_rule";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String EU_RULE_CATEGORY= "Eu_rule_category";
	public static final String RULE_TYPE= "Rule_type";
	public static final String CLASS_PATH= "Class_path";
	public static final String CLASS_NAME= "Class_name";
	public static final String REQUIRED_PROPS= "Required_props";
	public static final String FG_CHECK_ALL_REQUIRED= "Fg_check_all_required";
	public static final String FG_USE_OP= "Fg_use_op";
	public static final String FG_USE_IP= "Fg_use_ip";
	public static final String FG_USE_ER= "Fg_use_er";
	public static final String FG_USE_PE= "Fg_use_pe";
	public static final String FG_USE_FM= "Fg_use_fm";
	public static final String DES= "Des";
	public static final String SORTNO= "Sortno";
	public static final String CODE_GRP= "Code_grp";
	public static final String NAME_GRP= "Name_grp";
	public static final String CODE_ORG= "Code_org";
	public static final String NAME_ORG= "Name_org";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_rule() {
		return ((String) getAttrVal("Id_rule"));
	}	
	public void setId_rule(String Id_rule) {
		setAttrVal("Id_rule", Id_rule);
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
	public Integer getEu_rule_category() {
		return ((Integer) getAttrVal("Eu_rule_category"));
	}	
	public void setEu_rule_category(Integer Eu_rule_category) {
		setAttrVal("Eu_rule_category", Eu_rule_category);
	}
	public String getRule_type() {
		return ((String) getAttrVal("Rule_type"));
	}	
	public void setRule_type(String Rule_type) {
		setAttrVal("Rule_type", Rule_type);
	}
	public String getClass_path() {
		return ((String) getAttrVal("Class_path"));
	}	
	public void setClass_path(String Class_path) {
		setAttrVal("Class_path", Class_path);
	}
	public String getClass_name() {
		return ((String) getAttrVal("Class_name"));
	}	
	public void setClass_name(String Class_name) {
		setAttrVal("Class_name", Class_name);
	}
	public String getRequired_props() {
		return ((String) getAttrVal("Required_props"));
	}	
	public void setRequired_props(String Required_props) {
		setAttrVal("Required_props", Required_props);
	}
	public FBoolean getFg_check_all_required() {
		return ((FBoolean) getAttrVal("Fg_check_all_required"));
	}	
	public void setFg_check_all_required(FBoolean Fg_check_all_required) {
		setAttrVal("Fg_check_all_required", Fg_check_all_required);
	}
	public FBoolean getFg_use_op() {
		return ((FBoolean) getAttrVal("Fg_use_op"));
	}	
	public void setFg_use_op(FBoolean Fg_use_op) {
		setAttrVal("Fg_use_op", Fg_use_op);
	}
	public FBoolean getFg_use_ip() {
		return ((FBoolean) getAttrVal("Fg_use_ip"));
	}	
	public void setFg_use_ip(FBoolean Fg_use_ip) {
		setAttrVal("Fg_use_ip", Fg_use_ip);
	}
	public FBoolean getFg_use_er() {
		return ((FBoolean) getAttrVal("Fg_use_er"));
	}	
	public void setFg_use_er(FBoolean Fg_use_er) {
		setAttrVal("Fg_use_er", Fg_use_er);
	}
	public FBoolean getFg_use_pe() {
		return ((FBoolean) getAttrVal("Fg_use_pe"));
	}	
	public void setFg_use_pe(FBoolean Fg_use_pe) {
		setAttrVal("Fg_use_pe", Fg_use_pe);
	}
	public FBoolean getFg_use_fm() {
		return ((FBoolean) getAttrVal("Fg_use_fm"));
	}	
	public void setFg_use_fm(FBoolean Fg_use_fm) {
		setAttrVal("Fg_use_fm", Fg_use_fm);
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
		return "Id_rule";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_rule_entity";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiRuleEntityDesc.class);
	}
	
}