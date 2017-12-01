package iih.ci.ord.ciord.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.ciord.d.desc.OrSrvAgentInfoDODesc;
import java.math.BigDecimal;

/**
 * 医嘱项目患者信息核对或代理人信息登录 DO数据 
 * 
 */
public class OrSrvAgentInfoDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_ORSRVAGENT= "Id_orsrvagent";
	public static final String ID_OR= "Id_or";
	public static final String ID_ORSRV= "Id_orsrv";
	public static final String ID_EN= "Id_en";
	public static final String ID_PAT= "Id_pat";
	public static final String NAME_PAT= "Name_pat";
	public static final String ID_SEXTP_PAT= "Id_sextp_pat";
	public static final String SD_SEXTP_PAT= "Sd_sextp_pat";
	public static final String ID_IDTP_PAT= "Id_idtp_pat";
	public static final String SD_IDTP_PAT= "Sd_idtp_pat";
	public static final String IDNO_PAT= "Idno_pat";
	public static final String AGE_PAT= "Age_pat";
	public static final String ID_CONTTP= "Id_conttp";
	public static final String SD_CONTTP= "Sd_conttp";
	public static final String ID_AGENT= "Id_agent";
	public static final String NAME_AGENT= "Name_agent";
	public static final String ID_SEXTP_AGENT= "Id_sextp_agent";
	public static final String SD_SEXTP_AGENT= "Sd_sextp_agent";
	public static final String ID_IDTP_AGENT= "Id_idtp_agent";
	public static final String SD_IDTP_AGENT= "Sd_idtp_agent";
	public static final String IDNO_AGENT= "Idno_agent";
	public static final String AGE_AGENT= "Age_agent";
	public static final String ADDR_AGENT= "Addr_agent";
	public static final String PHONE_AGENT= "Phone_agent";
	public static final String ZIP_AGENT= "Zip_agent";
	public static final String DEF1= "Def1";
	public static final String DEF2= "Def2";
	public static final String DEF3= "Def3";
	public static final String DEF4= "Def4";
	public static final String DEF5= "Def5";
	public static final String DEF6= "Def6";
	public static final String DEF7= "Def7";
	public static final String DEF8= "Def8";
	public static final String DEF9= "Def9";
	public static final String DEF10= "Def10";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_SEXTP_PAT= "Name_sextp_pat";
	public static final String NAME_IDTP_PAT= "Name_idtp_pat";
	public static final String ENT_NAME_AGENT= "Ent_name_agent";
	public static final String NAME_SEXTP_AGENT= "Name_sextp_agent";
	public static final String NAME_IDTP_AGENT= "Name_idtp_agent";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_orsrvagent() {
		return ((String) getAttrVal("Id_orsrvagent"));
	}	
	public void setId_orsrvagent(String Id_orsrvagent) {
		setAttrVal("Id_orsrvagent", Id_orsrvagent);
	}
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}	
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
	public String getId_en() {
		return ((String) getAttrVal("Id_en"));
	}	
	public void setId_en(String Id_en) {
		setAttrVal("Id_en", Id_en);
	}
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	public String getId_sextp_pat() {
		return ((String) getAttrVal("Id_sextp_pat"));
	}	
	public void setId_sextp_pat(String Id_sextp_pat) {
		setAttrVal("Id_sextp_pat", Id_sextp_pat);
	}
	public String getSd_sextp_pat() {
		return ((String) getAttrVal("Sd_sextp_pat"));
	}	
	public void setSd_sextp_pat(String Sd_sextp_pat) {
		setAttrVal("Sd_sextp_pat", Sd_sextp_pat);
	}
	public String getId_idtp_pat() {
		return ((String) getAttrVal("Id_idtp_pat"));
	}	
	public void setId_idtp_pat(String Id_idtp_pat) {
		setAttrVal("Id_idtp_pat", Id_idtp_pat);
	}
	public String getSd_idtp_pat() {
		return ((String) getAttrVal("Sd_idtp_pat"));
	}	
	public void setSd_idtp_pat(String Sd_idtp_pat) {
		setAttrVal("Sd_idtp_pat", Sd_idtp_pat);
	}
	public String getIdno_pat() {
		return ((String) getAttrVal("Idno_pat"));
	}	
	public void setIdno_pat(String Idno_pat) {
		setAttrVal("Idno_pat", Idno_pat);
	}
	public Integer getAge_pat() {
		return ((Integer) getAttrVal("Age_pat"));
	}	
	public void setAge_pat(Integer Age_pat) {
		setAttrVal("Age_pat", Age_pat);
	}
	public String getId_conttp() {
		return ((String) getAttrVal("Id_conttp"));
	}	
	public void setId_conttp(String Id_conttp) {
		setAttrVal("Id_conttp", Id_conttp);
	}
	public String getSd_conttp() {
		return ((String) getAttrVal("Sd_conttp"));
	}	
	public void setSd_conttp(String Sd_conttp) {
		setAttrVal("Sd_conttp", Sd_conttp);
	}
	public String getId_agent() {
		return ((String) getAttrVal("Id_agent"));
	}	
	public void setId_agent(String Id_agent) {
		setAttrVal("Id_agent", Id_agent);
	}
	public String getName_agent() {
		return ((String) getAttrVal("Name_agent"));
	}	
	public void setName_agent(String Name_agent) {
		setAttrVal("Name_agent", Name_agent);
	}
	public String getId_sextp_agent() {
		return ((String) getAttrVal("Id_sextp_agent"));
	}	
	public void setId_sextp_agent(String Id_sextp_agent) {
		setAttrVal("Id_sextp_agent", Id_sextp_agent);
	}
	public String getSd_sextp_agent() {
		return ((String) getAttrVal("Sd_sextp_agent"));
	}	
	public void setSd_sextp_agent(String Sd_sextp_agent) {
		setAttrVal("Sd_sextp_agent", Sd_sextp_agent);
	}
	public String getId_idtp_agent() {
		return ((String) getAttrVal("Id_idtp_agent"));
	}	
	public void setId_idtp_agent(String Id_idtp_agent) {
		setAttrVal("Id_idtp_agent", Id_idtp_agent);
	}
	public String getSd_idtp_agent() {
		return ((String) getAttrVal("Sd_idtp_agent"));
	}	
	public void setSd_idtp_agent(String Sd_idtp_agent) {
		setAttrVal("Sd_idtp_agent", Sd_idtp_agent);
	}
	public String getIdno_agent() {
		return ((String) getAttrVal("Idno_agent"));
	}	
	public void setIdno_agent(String Idno_agent) {
		setAttrVal("Idno_agent", Idno_agent);
	}
	public Integer getAge_agent() {
		return ((Integer) getAttrVal("Age_agent"));
	}	
	public void setAge_agent(Integer Age_agent) {
		setAttrVal("Age_agent", Age_agent);
	}
	public String getAddr_agent() {
		return ((String) getAttrVal("Addr_agent"));
	}	
	public void setAddr_agent(String Addr_agent) {
		setAttrVal("Addr_agent", Addr_agent);
	}
	public String getPhone_agent() {
		return ((String) getAttrVal("Phone_agent"));
	}	
	public void setPhone_agent(String Phone_agent) {
		setAttrVal("Phone_agent", Phone_agent);
	}
	public String getZip_agent() {
		return ((String) getAttrVal("Zip_agent"));
	}	
	public void setZip_agent(String Zip_agent) {
		setAttrVal("Zip_agent", Zip_agent);
	}
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}	
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}	
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}	
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
	public String getDef4() {
		return ((String) getAttrVal("Def4"));
	}	
	public void setDef4(String Def4) {
		setAttrVal("Def4", Def4);
	}
	public String getDef5() {
		return ((String) getAttrVal("Def5"));
	}	
	public void setDef5(String Def5) {
		setAttrVal("Def5", Def5);
	}
	public String getDef6() {
		return ((String) getAttrVal("Def6"));
	}	
	public void setDef6(String Def6) {
		setAttrVal("Def6", Def6);
	}
	public String getDef7() {
		return ((String) getAttrVal("Def7"));
	}	
	public void setDef7(String Def7) {
		setAttrVal("Def7", Def7);
	}
	public String getDef8() {
		return ((String) getAttrVal("Def8"));
	}	
	public void setDef8(String Def8) {
		setAttrVal("Def8", Def8);
	}
	public String getDef9() {
		return ((String) getAttrVal("Def9"));
	}	
	public void setDef9(String Def9) {
		setAttrVal("Def9", Def9);
	}
	public String getDef10() {
		return ((String) getAttrVal("Def10"));
	}	
	public void setDef10(String Def10) {
		setAttrVal("Def10", Def10);
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
	public String getName_sextp_pat() {
		return ((String) getAttrVal("Name_sextp_pat"));
	}	
	public void setName_sextp_pat(String Name_sextp_pat) {
		setAttrVal("Name_sextp_pat", Name_sextp_pat);
	}
	public String getName_idtp_pat() {
		return ((String) getAttrVal("Name_idtp_pat"));
	}	
	public void setName_idtp_pat(String Name_idtp_pat) {
		setAttrVal("Name_idtp_pat", Name_idtp_pat);
	}
	public String getEnt_name_agent() {
		return ((String) getAttrVal("Ent_name_agent"));
	}	
	public void setEnt_name_agent(String Ent_name_agent) {
		setAttrVal("Ent_name_agent", Ent_name_agent);
	}
	public String getName_sextp_agent() {
		return ((String) getAttrVal("Name_sextp_agent"));
	}	
	public void setName_sextp_agent(String Name_sextp_agent) {
		setAttrVal("Name_sextp_agent", Name_sextp_agent);
	}
	public String getName_idtp_agent() {
		return ((String) getAttrVal("Name_idtp_agent"));
	}	
	public void setName_idtp_agent(String Name_idtp_agent) {
		setAttrVal("Name_idtp_agent", Name_idtp_agent);
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
		return "Id_orsrvagent";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_orsrv_agent";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OrSrvAgentInfoDODesc.class);
	}
	
}