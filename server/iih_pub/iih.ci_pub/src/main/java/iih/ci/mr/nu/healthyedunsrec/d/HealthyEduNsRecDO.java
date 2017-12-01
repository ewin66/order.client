package iih.ci.mr.nu.healthyedunsrec.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.healthyedunsrec.d.desc.HealthyEduNsRecDODesc;
import java.math.BigDecimal;

/**
 * 健康教育记录 DO数据 
 * 
 */
public class HealthyEduNsRecDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_HENR_REC= "Id_henr_rec";
	public static final String ID_HENR= "Id_henr";
	public static final String ID_EDUOBJ= "Id_eduobj";
	public static final String SD_EDUOBJ= "Sd_eduobj";
	public static final String ID_EDUMETHOD= "Id_edumethod";
	public static final String SD_EDUMETHOD= "Sd_edumethod";
	public static final String DT_EDU= "Dt_edu";
	public static final String EU_XGPJ= "Eu_xgpj";
	public static final String ID_JYXM= "Id_jyxm";
	public static final String SD_JYXM= "Sd_jyxm";
	public static final String ID_JTNR= "Id_jtnr";
	public static final String SD_JTNR= "Sd_jtnr";
	public static final String DES= "Des";
	public static final String ID_EDUCATOR= "Id_educator";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_EDUOBJ= "Name_eduobj";
	public static final String NAME_EDUMETHOD= "Name_edumethod";
	public static final String JYXM_NAME= "Jyxm_name";
	public static final String JTNR_NAME= "Jtnr_name";
	public static final String NAME_EDUCATOR= "Name_educator";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_henr_rec() {
		return ((String) getAttrVal("Id_henr_rec"));
	}	
	public void setId_henr_rec(String Id_henr_rec) {
		setAttrVal("Id_henr_rec", Id_henr_rec);
	}
	public String getId_henr() {
		return ((String) getAttrVal("Id_henr"));
	}	
	public void setId_henr(String Id_henr) {
		setAttrVal("Id_henr", Id_henr);
	}
	public String getId_eduobj() {
		return ((String) getAttrVal("Id_eduobj"));
	}	
	public void setId_eduobj(String Id_eduobj) {
		setAttrVal("Id_eduobj", Id_eduobj);
	}
	public String getSd_eduobj() {
		return ((String) getAttrVal("Sd_eduobj"));
	}	
	public void setSd_eduobj(String Sd_eduobj) {
		setAttrVal("Sd_eduobj", Sd_eduobj);
	}
	public String getId_edumethod() {
		return ((String) getAttrVal("Id_edumethod"));
	}	
	public void setId_edumethod(String Id_edumethod) {
		setAttrVal("Id_edumethod", Id_edumethod);
	}
	public String getSd_edumethod() {
		return ((String) getAttrVal("Sd_edumethod"));
	}	
	public void setSd_edumethod(String Sd_edumethod) {
		setAttrVal("Sd_edumethod", Sd_edumethod);
	}
	public FDateTime getDt_edu() {
		return ((FDateTime) getAttrVal("Dt_edu"));
	}	
	public void setDt_edu(FDateTime Dt_edu) {
		setAttrVal("Dt_edu", Dt_edu);
	}
	public Integer getEu_xgpj() {
		return ((Integer) getAttrVal("Eu_xgpj"));
	}	
	public void setEu_xgpj(Integer Eu_xgpj) {
		setAttrVal("Eu_xgpj", Eu_xgpj);
	}
	public String getId_jyxm() {
		return ((String) getAttrVal("Id_jyxm"));
	}	
	public void setId_jyxm(String Id_jyxm) {
		setAttrVal("Id_jyxm", Id_jyxm);
	}
	public String getSd_jyxm() {
		return ((String) getAttrVal("Sd_jyxm"));
	}	
	public void setSd_jyxm(String Sd_jyxm) {
		setAttrVal("Sd_jyxm", Sd_jyxm);
	}
	public String getId_jtnr() {
		return ((String) getAttrVal("Id_jtnr"));
	}	
	public void setId_jtnr(String Id_jtnr) {
		setAttrVal("Id_jtnr", Id_jtnr);
	}
	public String getSd_jtnr() {
		return ((String) getAttrVal("Sd_jtnr"));
	}	
	public void setSd_jtnr(String Sd_jtnr) {
		setAttrVal("Sd_jtnr", Sd_jtnr);
	}
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	public String getId_educator() {
		return ((String) getAttrVal("Id_educator"));
	}	
	public void setId_educator(String Id_educator) {
		setAttrVal("Id_educator", Id_educator);
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
	public String getName_eduobj() {
		return ((String) getAttrVal("Name_eduobj"));
	}	
	public void setName_eduobj(String Name_eduobj) {
		setAttrVal("Name_eduobj", Name_eduobj);
	}
	public String getName_edumethod() {
		return ((String) getAttrVal("Name_edumethod"));
	}	
	public void setName_edumethod(String Name_edumethod) {
		setAttrVal("Name_edumethod", Name_edumethod);
	}
	public String getJyxm_name() {
		return ((String) getAttrVal("Jyxm_name"));
	}	
	public void setJyxm_name(String Jyxm_name) {
		setAttrVal("Jyxm_name", Jyxm_name);
	}
	public String getJtnr_name() {
		return ((String) getAttrVal("Jtnr_name"));
	}	
	public void setJtnr_name(String Jtnr_name) {
		setAttrVal("Jtnr_name", Jtnr_name);
	}
	public String getName_educator() {
		return ((String) getAttrVal("Name_educator"));
	}	
	public void setName_educator(String Name_educator) {
		setAttrVal("Name_educator", Name_educator);
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
		return "Id_henr_rec";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_MR_NU_HNER_Rec";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HealthyEduNsRecDODesc.class);
	}
	
}