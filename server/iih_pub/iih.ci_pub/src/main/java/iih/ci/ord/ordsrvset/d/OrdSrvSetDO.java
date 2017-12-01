package iih.ci.ord.ordsrvset.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.ordsrvset.d.desc.OrdSrvSetDODesc;
import java.math.BigDecimal;

/**
 * 医嘱服务服务套 DO数据 
 * 
 */
public class OrdSrvSetDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_ORSRVSET= "Id_orsrvset";
	public static final String ID_ORSRV= "Id_orsrv";
	public static final String ID_OR= "Id_or";
	public static final String ID_SRVSETDEF= "Id_srvsetdef";
	public static final String ID_SRVSET= "Id_srvset";
	public static final String SORTNO= "Sortno";
	public static final String DES_SRV= "Des_srv";
	public static final String ID_SRVSETROLE= "Id_srvsetrole";
	public static final String SD_SRVSETROLE= "Sd_srvsetrole";
	public static final String ID_MEDU= "Id_medu";
	public static final String QUAN_MEDU= "Quan_medu";
	public static final String ID_FREQDEF= "Id_freqdef";
	public static final String SD_BODY= "Sd_body";
	public static final String BODY_NAME= "Body_name";
	public static final String SD_POS= "Sd_pos";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String FG_CLINICAL= "Fg_clinical";
	public static final String FG_CLINICAL_BL= "Fg_clinical_bl";
	public static final String ID_BODY= "Id_body";
	public static final String ID_POS= "Id_pos";
	public static final String ID_ROUTE= "Id_route";
	public static final String ID_ROUTEDES= "Id_routedes";
	public static final String SET_NAME= "Set_name";
	public static final String SET_ID_SRVCA= "Set_id_srvca";
	public static final String SET_SD_SRVTP= "Set_sd_srvtp";
	public static final String NAME= "Name";
	public static final String CODE= "Code";
	public static final String SRVROLE_NAME= "Srvrole_name";
	public static final String CODE_ROUTE= "Code_route";
	public static final String NAME_ROUTE= "Name_route";
	public static final String CODE_ROUTEDES= "Code_routedes";
	public static final String NAME_ROUTEDES= "Name_routedes";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_orsrvset() {
		return ((String) getAttrVal("Id_orsrvset"));
	}	
	public void setId_orsrvset(String Id_orsrvset) {
		setAttrVal("Id_orsrvset", Id_orsrvset);
	}
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}	
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	public String getId_srvsetdef() {
		return ((String) getAttrVal("Id_srvsetdef"));
	}	
	public void setId_srvsetdef(String Id_srvsetdef) {
		setAttrVal("Id_srvsetdef", Id_srvsetdef);
	}
	public String getId_srvset() {
		return ((String) getAttrVal("Id_srvset"));
	}	
	public void setId_srvset(String Id_srvset) {
		setAttrVal("Id_srvset", Id_srvset);
	}
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	public String getDes_srv() {
		return ((String) getAttrVal("Des_srv"));
	}	
	public void setDes_srv(String Des_srv) {
		setAttrVal("Des_srv", Des_srv);
	}
	public String getId_srvsetrole() {
		return ((String) getAttrVal("Id_srvsetrole"));
	}	
	public void setId_srvsetrole(String Id_srvsetrole) {
		setAttrVal("Id_srvsetrole", Id_srvsetrole);
	}
	public String getSd_srvsetrole() {
		return ((String) getAttrVal("Sd_srvsetrole"));
	}	
	public void setSd_srvsetrole(String Sd_srvsetrole) {
		setAttrVal("Sd_srvsetrole", Sd_srvsetrole);
	}
	public String getId_medu() {
		return ((String) getAttrVal("Id_medu"));
	}	
	public void setId_medu(String Id_medu) {
		setAttrVal("Id_medu", Id_medu);
	}
	public FDouble getQuan_medu() {
		return ((FDouble) getAttrVal("Quan_medu"));
	}	
	public void setQuan_medu(FDouble Quan_medu) {
		setAttrVal("Quan_medu", Quan_medu);
	}
	public String getId_freqdef() {
		return ((String) getAttrVal("Id_freqdef"));
	}	
	public void setId_freqdef(String Id_freqdef) {
		setAttrVal("Id_freqdef", Id_freqdef);
	}
	public String getSd_body() {
		return ((String) getAttrVal("Sd_body"));
	}	
	public void setSd_body(String Sd_body) {
		setAttrVal("Sd_body", Sd_body);
	}
	public String getBody_name() {
		return ((String) getAttrVal("Body_name"));
	}	
	public void setBody_name(String Body_name) {
		setAttrVal("Body_name", Body_name);
	}
	public String getSd_pos() {
		return ((String) getAttrVal("Sd_pos"));
	}	
	public void setSd_pos(String Sd_pos) {
		setAttrVal("Sd_pos", Sd_pos);
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
	public FBoolean getFg_clinical() {
		return ((FBoolean) getAttrVal("Fg_clinical"));
	}	
	public void setFg_clinical(FBoolean Fg_clinical) {
		setAttrVal("Fg_clinical", Fg_clinical);
	}
	public FBoolean getFg_clinical_bl() {
		return ((FBoolean) getAttrVal("Fg_clinical_bl"));
	}	
	public void setFg_clinical_bl(FBoolean Fg_clinical_bl) {
		setAttrVal("Fg_clinical_bl", Fg_clinical_bl);
	}
	public String getId_body() {
		return ((String) getAttrVal("Id_body"));
	}	
	public void setId_body(String Id_body) {
		setAttrVal("Id_body", Id_body);
	}
	public String getId_pos() {
		return ((String) getAttrVal("Id_pos"));
	}	
	public void setId_pos(String Id_pos) {
		setAttrVal("Id_pos", Id_pos);
	}
	public String getId_route() {
		return ((String) getAttrVal("Id_route"));
	}	
	public void setId_route(String Id_route) {
		setAttrVal("Id_route", Id_route);
	}
	public String getId_routedes() {
		return ((String) getAttrVal("Id_routedes"));
	}	
	public void setId_routedes(String Id_routedes) {
		setAttrVal("Id_routedes", Id_routedes);
	}
	public String getSet_name() {
		return ((String) getAttrVal("Set_name"));
	}	
	public void setSet_name(String Set_name) {
		setAttrVal("Set_name", Set_name);
	}
	public String getSet_id_srvca() {
		return ((String) getAttrVal("Set_id_srvca"));
	}	
	public void setSet_id_srvca(String Set_id_srvca) {
		setAttrVal("Set_id_srvca", Set_id_srvca);
	}
	public String getSet_sd_srvtp() {
		return ((String) getAttrVal("Set_sd_srvtp"));
	}	
	public void setSet_sd_srvtp(String Set_sd_srvtp) {
		setAttrVal("Set_sd_srvtp", Set_sd_srvtp);
	}
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	public String getSrvrole_name() {
		return ((String) getAttrVal("Srvrole_name"));
	}	
	public void setSrvrole_name(String Srvrole_name) {
		setAttrVal("Srvrole_name", Srvrole_name);
	}
	public String getCode_route() {
		return ((String) getAttrVal("Code_route"));
	}	
	public void setCode_route(String Code_route) {
		setAttrVal("Code_route", Code_route);
	}
	public String getName_route() {
		return ((String) getAttrVal("Name_route"));
	}	
	public void setName_route(String Name_route) {
		setAttrVal("Name_route", Name_route);
	}
	public String getCode_routedes() {
		return ((String) getAttrVal("Code_routedes"));
	}	
	public void setCode_routedes(String Code_routedes) {
		setAttrVal("Code_routedes", Code_routedes);
	}
	public String getName_routedes() {
		return ((String) getAttrVal("Name_routedes"));
	}	
	public void setName_routedes(String Name_routedes) {
		setAttrVal("Name_routedes", Name_routedes);
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
		return "Id_orsrvset";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_or_srv_set";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OrdSrvSetDODesc.class);
	}
	
}