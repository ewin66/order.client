package iih.ci.ord.cior.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.cior.d.desc.OrdApSugViewItemDODesc;
import java.math.BigDecimal;

/**
 * 动态指标项 DO数据 
 * 
 */
public class OrdApSugViewItemDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_APOPOBSINDEX= "Id_apopobsindex";
	public static final String ID_APOP= "Id_apop";
	public static final String ID_SRV= "Id_srv";
	public static final String NAME_SRV= "Name_srv";
	public static final String ID_UNIT= "Id_unit";
	public static final String VAL_RSTRPTLA= "Val_rstrptla";
	public static final String VAL_RESTRPTLAB= "Val_restrptlab";
	public static final String NAME_UNIT= "Name_unit";
	public static final String SD_RESTRPTLABTP= "Sd_restrptlabtp";
	public static final String ID_RESTRPTLABTP= "Id_restrptlabtp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_apopobsindex() {
		return ((String) getAttrVal("Id_apopobsindex"));
	}	
	public void setId_apopobsindex(String Id_apopobsindex) {
		setAttrVal("Id_apopobsindex", Id_apopobsindex);
	}
	public String getId_apop() {
		return ((String) getAttrVal("Id_apop"));
	}	
	public void setId_apop(String Id_apop) {
		setAttrVal("Id_apop", Id_apop);
	}
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}	
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	public String getId_unit() {
		return ((String) getAttrVal("Id_unit"));
	}	
	public void setId_unit(String Id_unit) {
		setAttrVal("Id_unit", Id_unit);
	}
	public String getVal_rstrptla() {
		return ((String) getAttrVal("Val_rstrptla"));
	}	
	public void setVal_rstrptla(String Val_rstrptla) {
		setAttrVal("Val_rstrptla", Val_rstrptla);
	}
	public String getVal_restrptlab() {
		return ((String) getAttrVal("Val_restrptlab"));
	}	
	public void setVal_restrptlab(String Val_restrptlab) {
		setAttrVal("Val_restrptlab", Val_restrptlab);
	}
	public String getName_unit() {
		return ((String) getAttrVal("Name_unit"));
	}	
	public void setName_unit(String Name_unit) {
		setAttrVal("Name_unit", Name_unit);
	}
	public String getSd_restrptlabtp() {
		return ((String) getAttrVal("Sd_restrptlabtp"));
	}	
	public void setSd_restrptlabtp(String Sd_restrptlabtp) {
		setAttrVal("Sd_restrptlabtp", Sd_restrptlabtp);
	}
	public String getId_restrptlabtp() {
		return ((String) getAttrVal("Id_restrptlabtp"));
	}	
	public void setId_restrptlabtp(String Id_restrptlabtp) {
		setAttrVal("Id_restrptlabtp", Id_restrptlabtp);
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
		return "Id_apopobsindex";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_ap_sug_viewitm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OrdApSugViewItemDODesc.class);
	}
	
}