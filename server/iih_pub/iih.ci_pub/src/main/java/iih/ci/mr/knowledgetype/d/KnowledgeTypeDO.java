package iih.ci.mr.knowledgetype.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.knowledgetype.d.desc.KnowledgeTypeDODesc;
import java.math.BigDecimal;

/**
 * 知识库类型 DO数据 
 * 
 */
public class KnowledgeTypeDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_KNOWLEDGE_TYPE= "Id_knowledge_type";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String SORTNO= "Sortno";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String PYCODE= "Pycode";
	public static final String WBCODE= "Wbcode";
	public static final String MNECODE= "Mnecode";
	public static final String ID_DEPT= "Id_dept";
	public static final String ID_USER= "Id_user";
	public static final String PERSONAL= "Personal";
	public static final String ADMINISTRATIVE= "Administrative";
	public static final String ATTRIBUTE= "Attribute";
	public static final String DES= "Des";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String ORG_CODE= "Org_code";
	public static final String ORG_NAME= "Org_name";
	public static final String DEPT_CODE= "Dept_code";
	public static final String DEPT_NAME= "Dept_name";
	public static final String USER_NAME= "User_name";
	public static final String USER_CODE= "User_code";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_knowledge_type() {
		return ((String) getAttrVal("Id_knowledge_type"));
	}	
	public void setId_knowledge_type(String Id_knowledge_type) {
		setAttrVal("Id_knowledge_type", Id_knowledge_type);
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
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}	
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}	
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
	}
	public String getMnecode() {
		return ((String) getAttrVal("Mnecode"));
	}	
	public void setMnecode(String Mnecode) {
		setAttrVal("Mnecode", Mnecode);
	}
	public String getId_dept() {
		return ((String) getAttrVal("Id_dept"));
	}	
	public void setId_dept(String Id_dept) {
		setAttrVal("Id_dept", Id_dept);
	}
	public String getId_user() {
		return ((String) getAttrVal("Id_user"));
	}	
	public void setId_user(String Id_user) {
		setAttrVal("Id_user", Id_user);
	}
	public FBoolean getPersonal() {
		return ((FBoolean) getAttrVal("Personal"));
	}	
	public void setPersonal(FBoolean Personal) {
		setAttrVal("Personal", Personal);
	}
	public FBoolean getAdministrative() {
		return ((FBoolean) getAttrVal("Administrative"));
	}	
	public void setAdministrative(FBoolean Administrative) {
		setAttrVal("Administrative", Administrative);
	}
	public Integer getAttribute() {
		return ((Integer) getAttrVal("Attribute"));
	}	
	public void setAttribute(Integer Attribute) {
		setAttrVal("Attribute", Attribute);
	}
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
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
	public String getDept_code() {
		return ((String) getAttrVal("Dept_code"));
	}	
	public void setDept_code(String Dept_code) {
		setAttrVal("Dept_code", Dept_code);
	}
	public String getDept_name() {
		return ((String) getAttrVal("Dept_name"));
	}	
	public void setDept_name(String Dept_name) {
		setAttrVal("Dept_name", Dept_name);
	}
	public String getUser_name() {
		return ((String) getAttrVal("User_name"));
	}	
	public void setUser_name(String User_name) {
		setAttrVal("User_name", User_name);
	}
	public String getUser_code() {
		return ((String) getAttrVal("User_code"));
	}	
	public void setUser_code(String User_code) {
		setAttrVal("User_code", User_code);
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
		return "Id_knowledge_type";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_mr_knowledge_type";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(KnowledgeTypeDODesc.class);
	}
	
}