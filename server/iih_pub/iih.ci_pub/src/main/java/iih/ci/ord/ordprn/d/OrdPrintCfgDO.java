package iih.ci.ord.ordprn.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.ordprn.d.desc.OrdPrintCfgDODesc;
import java.math.BigDecimal;

/**
 * 医嘱打印配置 DO数据 
 * 
 */
public class OrdPrintCfgDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_ORPRN_CFG= "Id_orprn_cfg";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String FG_LONG= "Fg_long";
	public static final String ID_SRVTP= "Id_srvtp";
	public static final String SD_SRVTP= "Sd_srvtp";
	public static final String CFG_GRP= "Cfg_grp";
	public static final String CFG_PROPERTY= "Cfg_property";
	public static final String CFG_CONTENT= "Cfg_content";
	public static final String DEFAULT_CFG= "Default_cfg";
	public static final String TYPE= "Type";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String SOTRNO= "Sotrno";
	public static final String SRVTP_NAME= "Srvtp_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_orprn_cfg() {
		return ((String) getAttrVal("Id_orprn_cfg"));
	}	
	public void setId_orprn_cfg(String Id_orprn_cfg) {
		setAttrVal("Id_orprn_cfg", Id_orprn_cfg);
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
	public FBoolean getFg_long() {
		return ((FBoolean) getAttrVal("Fg_long"));
	}	
	public void setFg_long(FBoolean Fg_long) {
		setAttrVal("Fg_long", Fg_long);
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
	public String getCfg_grp() {
		return ((String) getAttrVal("Cfg_grp"));
	}	
	public void setCfg_grp(String Cfg_grp) {
		setAttrVal("Cfg_grp", Cfg_grp);
	}
	public String getCfg_property() {
		return ((String) getAttrVal("Cfg_property"));
	}	
	public void setCfg_property(String Cfg_property) {
		setAttrVal("Cfg_property", Cfg_property);
	}
	public String getCfg_content() {
		return ((String) getAttrVal("Cfg_content"));
	}	
	public void setCfg_content(String Cfg_content) {
		setAttrVal("Cfg_content", Cfg_content);
	}
	public FBoolean getDefault_cfg() {
		return ((FBoolean) getAttrVal("Default_cfg"));
	}	
	public void setDefault_cfg(FBoolean Default_cfg) {
		setAttrVal("Default_cfg", Default_cfg);
	}
	public String getType() {
		return ((String) getAttrVal("Type"));
	}	
	public void setType(String Type) {
		setAttrVal("Type", Type);
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
	public Integer getSotrno() {
		return ((Integer) getAttrVal("Sotrno"));
	}	
	public void setSotrno(Integer Sotrno) {
		setAttrVal("Sotrno", Sotrno);
	}
	public String getSrvtp_name() {
		return ((String) getAttrVal("Srvtp_name"));
	}	
	public void setSrvtp_name(String Srvtp_name) {
		setAttrVal("Srvtp_name", Srvtp_name);
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
		return "Id_orprn_cfg";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_or_prn_cfg";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OrdPrintCfgDODesc.class);
	}
	
}