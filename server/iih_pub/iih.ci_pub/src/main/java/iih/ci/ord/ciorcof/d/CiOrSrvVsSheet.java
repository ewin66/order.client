package iih.ci.ord.ciorcof.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.ciorcof.d.desc.CiOrSrvVsSheetDesc;
import java.math.BigDecimal;

/**
 * 实体 DO数据 
 * 
 */
public class CiOrSrvVsSheet extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_SRVVSSHEET= "Id_srvvssheet";
	public static final String SD_SRVTP= "Sd_srvtp";
	public static final String ID_SRVTP= "Id_srvtp";
	public static final String ID_SHEET= "Id_sheet";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_srvvssheet() {
		return ((String) getAttrVal("Id_srvvssheet"));
	}	
	public void setId_srvvssheet(String Id_srvvssheet) {
		setAttrVal("Id_srvvssheet", Id_srvvssheet);
	}
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}	
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	public String getId_srvtp() {
		return ((String) getAttrVal("Id_srvtp"));
	}	
	public void setId_srvtp(String Id_srvtp) {
		setAttrVal("Id_srvtp", Id_srvtp);
	}
	public String getId_sheet() {
		return ((String) getAttrVal("Id_sheet"));
	}	
	public void setId_sheet(String Id_sheet) {
		setAttrVal("Id_sheet", Id_sheet);
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
		return "Id_srvvssheet";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_srv_vs_sheet";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiOrSrvVsSheetDesc.class);
	}
	
}