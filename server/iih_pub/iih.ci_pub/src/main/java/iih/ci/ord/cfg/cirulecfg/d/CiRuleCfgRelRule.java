package iih.ci.ord.cfg.cirulecfg.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.cfg.cirulecfg.d.desc.CiRuleCfgRelRuleDesc;
import java.math.BigDecimal;

/**
 * 校验规则关联内容 DO数据 
 * 
 */
public class CiRuleCfgRelRule extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_SRVRELRULE= "Id_srvrelrule";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String CREATEDTIME= "Createdtime";
	public static final String ID_RULECFG= "Id_rulecfg";
	public static final String EU_OFREFTP= "Eu_ofreftp";
	public static final String ID_SRVOF= "Id_srvof";
	public static final String ID_SRVTP= "Id_srvtp";
	public static final String SD_SRVTP= "Sd_srvtp";
	public static final String ID_SRV= "Id_srv";
	public static final String EU_DIRECT= "Eu_direct";
	public static final String FG_SYS= "Fg_sys";
	public static final String REL_ID= "Rel_id";
	public static final String REL_NAME= "Rel_name";
	public static final String NAME_GRP= "Name_grp";
	public static final String CODE_GRP= "Code_grp";
	public static final String NAME_ORG= "Name_org";
	public static final String CODE_ORG= "Code_org";
	public static final String SRVTPNAME= "Srvtpname";
	public static final String SRVNAME= "Srvname";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_srvrelrule() {
		return ((String) getAttrVal("Id_srvrelrule"));
	}	
	public void setId_srvrelrule(String Id_srvrelrule) {
		setAttrVal("Id_srvrelrule", Id_srvrelrule);
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
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}	
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	public String getId_rulecfg() {
		return ((String) getAttrVal("Id_rulecfg"));
	}	
	public void setId_rulecfg(String Id_rulecfg) {
		setAttrVal("Id_rulecfg", Id_rulecfg);
	}
	public String getEu_ofreftp() {
		return ((String) getAttrVal("Eu_ofreftp"));
	}	
	public void setEu_ofreftp(String Eu_ofreftp) {
		setAttrVal("Eu_ofreftp", Eu_ofreftp);
	}
	public String getId_srvof() {
		return ((String) getAttrVal("Id_srvof"));
	}	
	public void setId_srvof(String Id_srvof) {
		setAttrVal("Id_srvof", Id_srvof);
	}
	public String getId_srvtp() {
		return ((String) getAttrVal("Id_srvtp"));
	}	
	public void setId_srvtp(String Id_srvtp) {
		setAttrVal("Id_srvtp", Id_srvtp);
	}
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}	
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	public Integer getEu_direct() {
		return ((Integer) getAttrVal("Eu_direct"));
	}	
	public void setEu_direct(Integer Eu_direct) {
		setAttrVal("Eu_direct", Eu_direct);
	}
	public FBoolean getFg_sys() {
		return ((FBoolean) getAttrVal("Fg_sys"));
	}	
	public void setFg_sys(FBoolean Fg_sys) {
		setAttrVal("Fg_sys", Fg_sys);
	}
	public String getRel_id() {
		return ((String) getAttrVal("Rel_id"));
	}	
	public void setRel_id(String Rel_id) {
		setAttrVal("Rel_id", Rel_id);
	}
	public String getRel_name() {
		return ((String) getAttrVal("Rel_name"));
	}	
	public void setRel_name(String Rel_name) {
		setAttrVal("Rel_name", Rel_name);
	}
	public String getName_grp() {
		return ((String) getAttrVal("Name_grp"));
	}	
	public void setName_grp(String Name_grp) {
		setAttrVal("Name_grp", Name_grp);
	}
	public String getCode_grp() {
		return ((String) getAttrVal("Code_grp"));
	}	
	public void setCode_grp(String Code_grp) {
		setAttrVal("Code_grp", Code_grp);
	}
	public String getName_org() {
		return ((String) getAttrVal("Name_org"));
	}	
	public void setName_org(String Name_org) {
		setAttrVal("Name_org", Name_org);
	}
	public String getCode_org() {
		return ((String) getAttrVal("Code_org"));
	}	
	public void setCode_org(String Code_org) {
		setAttrVal("Code_org", Code_org);
	}
	public String getSrvtpname() {
		return ((String) getAttrVal("Srvtpname"));
	}	
	public void setSrvtpname(String Srvtpname) {
		setAttrVal("Srvtpname", Srvtpname);
	}
	public String getSrvname() {
		return ((String) getAttrVal("Srvname"));
	}	
	public void setSrvname(String Srvname) {
		setAttrVal("Srvname", Srvname);
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
		return "Id_srvrelrule";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_rule_cfg_relsrv";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiRuleCfgRelRuleDesc.class);
	}
	
}