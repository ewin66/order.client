package iih.ci.mrqc.qcreport.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mrqc.qcreport.d.desc.QcReportDODesc;
import java.math.BigDecimal;

/**
 * 质控报表 DO数据 
 * 
 */
public class QcReportDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_QCREPORT= "Id_qcreport";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String NAME= "Name";
	public static final String ID_QCREPORTGRP= "Id_qcreportgrp";
	public static final String SERV_RPTFILE= "Serv_rptfile";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_qcreport() {
		return ((String) getAttrVal("Id_qcreport"));
	}	
	public void setId_qcreport(String Id_qcreport) {
		setAttrVal("Id_qcreport", Id_qcreport);
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
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public String getId_qcreportgrp() {
		return ((String) getAttrVal("Id_qcreportgrp"));
	}	
	public void setId_qcreportgrp(String Id_qcreportgrp) {
		setAttrVal("Id_qcreportgrp", Id_qcreportgrp);
	}
	public String getServ_rptfile() {
		return ((String) getAttrVal("Serv_rptfile"));
	}	
	public void setServ_rptfile(String Serv_rptfile) {
		setAttrVal("Serv_rptfile", Serv_rptfile);
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
		return "Id_qcreport";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_qc_report";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(QcReportDODesc.class);
	}
	
}