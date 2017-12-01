package iih.ci.rcm.consite.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.rcm.consite.d.desc.ConSiteDODesc;
import java.math.BigDecimal;

/**
 * 院感感染部位 DO数据 
 * 
 */
public class ConSiteDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_SITE= "Id_site";
	public static final String ID_HOSPITALREPORT= "Id_hospitalreport";
	public static final String INFECTEDATE= "Infectedate";
	public static final String ID_INFECTE_SITE= "Id_infecte_site";
	public static final String SD_INFECTE_SITE= "Sd_infecte_site";
	public static final String NAME_INFECTE_SITE= "Name_infecte_site";
	public static final String INFECTE_SITE_OTHER= "Infecte_site_other";
	public static final String ID_DI_INFECTION= "Id_di_infection";
	public static final String SD_DI_INFECTION= "Sd_di_infection";
	public static final String NAME_DI_INFECTION= "Name_di_infection";
	public static final String ID_INVA_OPER= "Id_inva_oper";
	public static final String SD_INVA_OPER= "Sd_inva_oper";
	public static final String NAME_INVA_OPER= "Name_inva_oper";
	public static final String ID_REPORT_DEPT= "Id_report_dept";
	public static final String NAME_REPORT_DEPT= "Name_report_dept";
	public static final String SD_REPORT_DEPT= "Sd_report_dept";
	public static final String ID_REPORT_PERSON= "Id_report_person";
	public static final String NAME_REPORT_PERSON= "Name_report_person";
	public static final String SD_REPORT_PERSON= "Sd_report_person";
	public static final String DT_REPORT= "Dt_report";
	public static final String OPERATION= "Operation";
	public static final String INFECTE_SITE_NAME= "Infecte_site_name";
	public static final String INFECTE_SITE_CODE= "Infecte_site_code";
	public static final String DI_INFECTION_CODE= "Di_infection_code";
	public static final String DI_INFECTION_NAME= "Di_infection_name";
	public static final String INVA_OPER_CODE= "Inva_oper_code";
	public static final String INVA_OPER_NAME= "Inva_oper_name";
	public static final String REPORT_DEPT_CODE= "Report_dept_code";
	public static final String REPORT_DEPT_NAME= "Report_dept_name";
	public static final String REPORT_PERSON_CODE= "Report_person_code";
	public static final String REPORT_PERSON_NAME= "Report_person_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_site() {
		return ((String) getAttrVal("Id_site"));
	}	
	public void setId_site(String Id_site) {
		setAttrVal("Id_site", Id_site);
	}
	public String getId_hospitalreport() {
		return ((String) getAttrVal("Id_hospitalreport"));
	}	
	public void setId_hospitalreport(String Id_hospitalreport) {
		setAttrVal("Id_hospitalreport", Id_hospitalreport);
	}
	public FDate getInfectedate() {
		return ((FDate) getAttrVal("Infectedate"));
	}	
	public void setInfectedate(FDate Infectedate) {
		setAttrVal("Infectedate", Infectedate);
	}
	public String getId_infecte_site() {
		return ((String) getAttrVal("Id_infecte_site"));
	}	
	public void setId_infecte_site(String Id_infecte_site) {
		setAttrVal("Id_infecte_site", Id_infecte_site);
	}
	public String getSd_infecte_site() {
		return ((String) getAttrVal("Sd_infecte_site"));
	}	
	public void setSd_infecte_site(String Sd_infecte_site) {
		setAttrVal("Sd_infecte_site", Sd_infecte_site);
	}
	public String getName_infecte_site() {
		return ((String) getAttrVal("Name_infecte_site"));
	}	
	public void setName_infecte_site(String Name_infecte_site) {
		setAttrVal("Name_infecte_site", Name_infecte_site);
	}
	public String getInfecte_site_other() {
		return ((String) getAttrVal("Infecte_site_other"));
	}	
	public void setInfecte_site_other(String Infecte_site_other) {
		setAttrVal("Infecte_site_other", Infecte_site_other);
	}
	public String getId_di_infection() {
		return ((String) getAttrVal("Id_di_infection"));
	}	
	public void setId_di_infection(String Id_di_infection) {
		setAttrVal("Id_di_infection", Id_di_infection);
	}
	public String getSd_di_infection() {
		return ((String) getAttrVal("Sd_di_infection"));
	}	
	public void setSd_di_infection(String Sd_di_infection) {
		setAttrVal("Sd_di_infection", Sd_di_infection);
	}
	public String getName_di_infection() {
		return ((String) getAttrVal("Name_di_infection"));
	}	
	public void setName_di_infection(String Name_di_infection) {
		setAttrVal("Name_di_infection", Name_di_infection);
	}
	public String getId_inva_oper() {
		return ((String) getAttrVal("Id_inva_oper"));
	}	
	public void setId_inva_oper(String Id_inva_oper) {
		setAttrVal("Id_inva_oper", Id_inva_oper);
	}
	public String getSd_inva_oper() {
		return ((String) getAttrVal("Sd_inva_oper"));
	}	
	public void setSd_inva_oper(String Sd_inva_oper) {
		setAttrVal("Sd_inva_oper", Sd_inva_oper);
	}
	public String getName_inva_oper() {
		return ((String) getAttrVal("Name_inva_oper"));
	}	
	public void setName_inva_oper(String Name_inva_oper) {
		setAttrVal("Name_inva_oper", Name_inva_oper);
	}
	public String getId_report_dept() {
		return ((String) getAttrVal("Id_report_dept"));
	}	
	public void setId_report_dept(String Id_report_dept) {
		setAttrVal("Id_report_dept", Id_report_dept);
	}
	public String getName_report_dept() {
		return ((String) getAttrVal("Name_report_dept"));
	}	
	public void setName_report_dept(String Name_report_dept) {
		setAttrVal("Name_report_dept", Name_report_dept);
	}
	public String getSd_report_dept() {
		return ((String) getAttrVal("Sd_report_dept"));
	}	
	public void setSd_report_dept(String Sd_report_dept) {
		setAttrVal("Sd_report_dept", Sd_report_dept);
	}
	public String getId_report_person() {
		return ((String) getAttrVal("Id_report_person"));
	}	
	public void setId_report_person(String Id_report_person) {
		setAttrVal("Id_report_person", Id_report_person);
	}
	public String getName_report_person() {
		return ((String) getAttrVal("Name_report_person"));
	}	
	public void setName_report_person(String Name_report_person) {
		setAttrVal("Name_report_person", Name_report_person);
	}
	public String getSd_report_person() {
		return ((String) getAttrVal("Sd_report_person"));
	}	
	public void setSd_report_person(String Sd_report_person) {
		setAttrVal("Sd_report_person", Sd_report_person);
	}
	public String getDt_report() {
		return ((String) getAttrVal("Dt_report"));
	}	
	public void setDt_report(String Dt_report) {
		setAttrVal("Dt_report", Dt_report);
	}
	public String getOperation() {
		return ((String) getAttrVal("Operation"));
	}	
	public void setOperation(String Operation) {
		setAttrVal("Operation", Operation);
	}
	public String getInfecte_site_name() {
		return ((String) getAttrVal("Infecte_site_name"));
	}	
	public void setInfecte_site_name(String Infecte_site_name) {
		setAttrVal("Infecte_site_name", Infecte_site_name);
	}
	public String getInfecte_site_code() {
		return ((String) getAttrVal("Infecte_site_code"));
	}	
	public void setInfecte_site_code(String Infecte_site_code) {
		setAttrVal("Infecte_site_code", Infecte_site_code);
	}
	public String getDi_infection_code() {
		return ((String) getAttrVal("Di_infection_code"));
	}	
	public void setDi_infection_code(String Di_infection_code) {
		setAttrVal("Di_infection_code", Di_infection_code);
	}
	public String getDi_infection_name() {
		return ((String) getAttrVal("Di_infection_name"));
	}	
	public void setDi_infection_name(String Di_infection_name) {
		setAttrVal("Di_infection_name", Di_infection_name);
	}
	public String getInva_oper_code() {
		return ((String) getAttrVal("Inva_oper_code"));
	}	
	public void setInva_oper_code(String Inva_oper_code) {
		setAttrVal("Inva_oper_code", Inva_oper_code);
	}
	public String getInva_oper_name() {
		return ((String) getAttrVal("Inva_oper_name"));
	}	
	public void setInva_oper_name(String Inva_oper_name) {
		setAttrVal("Inva_oper_name", Inva_oper_name);
	}
	public String getReport_dept_code() {
		return ((String) getAttrVal("Report_dept_code"));
	}	
	public void setReport_dept_code(String Report_dept_code) {
		setAttrVal("Report_dept_code", Report_dept_code);
	}
	public String getReport_dept_name() {
		return ((String) getAttrVal("Report_dept_name"));
	}	
	public void setReport_dept_name(String Report_dept_name) {
		setAttrVal("Report_dept_name", Report_dept_name);
	}
	public String getReport_person_code() {
		return ((String) getAttrVal("Report_person_code"));
	}	
	public void setReport_person_code(String Report_person_code) {
		setAttrVal("Report_person_code", Report_person_code);
	}
	public String getReport_person_name() {
		return ((String) getAttrVal("Report_person_name"));
	}	
	public void setReport_person_name(String Report_person_name) {
		setAttrVal("Report_person_name", Report_person_name);
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
		return "Id_site";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_MR_CONTAGION_SITE";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ConSiteDODesc.class);
	}
	
}