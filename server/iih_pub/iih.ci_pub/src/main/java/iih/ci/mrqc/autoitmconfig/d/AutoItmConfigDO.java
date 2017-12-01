package iih.ci.mrqc.autoitmconfig.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mrqc.autoitmconfig.d.desc.AutoItmConfigDODesc;
import java.math.BigDecimal;

/**
 * 自动质控控制表 DO数据 
 * 
 */
public class AutoItmConfigDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_QA_ITM_CONFIG= "Id_qa_itm_config";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_QA_ITM= "Id_qa_itm";
	public static final String REQ= "Req";
	public static final String ID_MR_TYPES= "Id_mr_types";
	public static final String EVENT_TYPE_CODE= "Event_type_code";
	public static final String DEAD_HOURS= "Dead_hours";
	public static final String WBCODE= "Wbcode";
	public static final String PYCODE= "Pycode";
	public static final String MNECODE= "Mnecode";
	public static final String FG_ACTIVE= "Fg_active";
	public static final String ID_MR_OP_TYPE= "Id_mr_op_type";
	public static final String SD_MR_OP_TYPE= "Sd_mr_op_type";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String RULE_CLAZZES= "Rule_clazzes";
	public static final String GRP_CODE= "Grp_code";
	public static final String GRP_NAME= "Grp_name";
	public static final String ORG_CODE= "Org_code";
	public static final String ORG_NAME= "Org_name";
	public static final String MRTYPE_CODE= "Mrtype_code";
	public static final String MRTYPE_NAME= "Mrtype_name";
	public static final String CREATEBY_NAME= "Createby_name";
	public static final String CREATEBY_CODE= "Createby_code";
	public static final String MODIFIEDBY_NAME= "Modifiedby_name";
	public static final String MODIFIEDBY_CODE= "Modifiedby_code";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_qa_itm_config() {
		return ((String) getAttrVal("Id_qa_itm_config"));
	}	
	public void setId_qa_itm_config(String Id_qa_itm_config) {
		setAttrVal("Id_qa_itm_config", Id_qa_itm_config);
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
	public String getId_qa_itm() {
		return ((String) getAttrVal("Id_qa_itm"));
	}	
	public void setId_qa_itm(String Id_qa_itm) {
		setAttrVal("Id_qa_itm", Id_qa_itm);
	}
	public String getReq() {
		return ((String) getAttrVal("Req"));
	}	
	public void setReq(String Req) {
		setAttrVal("Req", Req);
	}
	public String getId_mr_types() {
		return ((String) getAttrVal("Id_mr_types"));
	}	
	public void setId_mr_types(String Id_mr_types) {
		setAttrVal("Id_mr_types", Id_mr_types);
	}
	public String getEvent_type_code() {
		return ((String) getAttrVal("Event_type_code"));
	}	
	public void setEvent_type_code(String Event_type_code) {
		setAttrVal("Event_type_code", Event_type_code);
	}
	public FDouble getDead_hours() {
		return ((FDouble) getAttrVal("Dead_hours"));
	}	
	public void setDead_hours(FDouble Dead_hours) {
		setAttrVal("Dead_hours", Dead_hours);
	}
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}	
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
	}
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}	
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	public String getMnecode() {
		return ((String) getAttrVal("Mnecode"));
	}	
	public void setMnecode(String Mnecode) {
		setAttrVal("Mnecode", Mnecode);
	}
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	public String getId_mr_op_type() {
		return ((String) getAttrVal("Id_mr_op_type"));
	}	
	public void setId_mr_op_type(String Id_mr_op_type) {
		setAttrVal("Id_mr_op_type", Id_mr_op_type);
	}
	public String getSd_mr_op_type() {
		return ((String) getAttrVal("Sd_mr_op_type"));
	}	
	public void setSd_mr_op_type(String Sd_mr_op_type) {
		setAttrVal("Sd_mr_op_type", Sd_mr_op_type);
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
	public String getRule_clazzes() {
		return ((String) getAttrVal("Rule_clazzes"));
	}	
	public void setRule_clazzes(String Rule_clazzes) {
		setAttrVal("Rule_clazzes", Rule_clazzes);
	}
	public String getGrp_code() {
		return ((String) getAttrVal("Grp_code"));
	}	
	public void setGrp_code(String Grp_code) {
		setAttrVal("Grp_code", Grp_code);
	}
	public String getGrp_name() {
		return ((String) getAttrVal("Grp_name"));
	}	
	public void setGrp_name(String Grp_name) {
		setAttrVal("Grp_name", Grp_name);
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
	public String getMrtype_code() {
		return ((String) getAttrVal("Mrtype_code"));
	}	
	public void setMrtype_code(String Mrtype_code) {
		setAttrVal("Mrtype_code", Mrtype_code);
	}
	public String getMrtype_name() {
		return ((String) getAttrVal("Mrtype_name"));
	}	
	public void setMrtype_name(String Mrtype_name) {
		setAttrVal("Mrtype_name", Mrtype_name);
	}
	public String getCreateby_name() {
		return ((String) getAttrVal("Createby_name"));
	}	
	public void setCreateby_name(String Createby_name) {
		setAttrVal("Createby_name", Createby_name);
	}
	public String getCreateby_code() {
		return ((String) getAttrVal("Createby_code"));
	}	
	public void setCreateby_code(String Createby_code) {
		setAttrVal("Createby_code", Createby_code);
	}
	public String getModifiedby_name() {
		return ((String) getAttrVal("Modifiedby_name"));
	}	
	public void setModifiedby_name(String Modifiedby_name) {
		setAttrVal("Modifiedby_name", Modifiedby_name);
	}
	public String getModifiedby_code() {
		return ((String) getAttrVal("Modifiedby_code"));
	}	
	public void setModifiedby_code(String Modifiedby_code) {
		setAttrVal("Modifiedby_code", Modifiedby_code);
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
		return "Id_qa_itm_config";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_qa_auto_itm_config";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(AutoItmConfigDODesc.class);
	}
	
}