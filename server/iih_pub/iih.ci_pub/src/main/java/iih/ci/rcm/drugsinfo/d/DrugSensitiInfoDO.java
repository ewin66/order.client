package iih.ci.rcm.drugsinfo.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.rcm.drugsinfo.d.desc.DrugSensitiInfoDODesc;
import java.math.BigDecimal;

/**
 * 药敏信息 DO数据 
 * 
 */
public class DrugSensitiInfoDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_DRUGSEINFO= "Id_drugseinfo";
	public static final String ID_HOSPITALREPORT= "Id_hospitalreport";
	public static final String ID_SAMPLENAME= "Id_samplename";
	public static final String SD_SAMPLENAME= "Sd_samplename";
	public static final String NAME_SAMPLENAME= "Name_samplename";
	public static final String SUBMISSION_DATE= "Submission_date";
	public static final String ID_TEST_METHOD= "Id_test_method";
	public static final String SD_TEST_METHOD= "Sd_test_method";
	public static final String NAME_TEST_METHOD= "Name_test_method";
	public static final String ID_PATHOGEN_SPECIES= "Id_pathogen_species";
	public static final String SD_PATHOGEN_SPECIES= "Sd_pathogen_species";
	public static final String NAME_PATHOGEN_SPECIES= "Name_pathogen_species";
	public static final String ID_SPE_TEST_RESULT= "Id_spe_test_result";
	public static final String SD_SPE_TEST_RESULT= "Sd_spe_test_result";
	public static final String NAME_SPE_TEST_RESULT= "Name_spe_test_result";
	public static final String DRUG_SEN_TEST= "Drug_sen_test";
	public static final String DRUG_SEN_RESULT= "Drug_sen_result";
	public static final String ID_INFE_SITE= "Id_infe_site";
	public static final String SD_INFE_SITE= "Sd_infe_site";
	public static final String NAME_INFE_SITE= "Name_infe_site";
	public static final String SAMPLENAME_CODE= "Samplename_code";
	public static final String SAMPLENAME_NAME= "Samplename_name";
	public static final String TEST_METHOD_CODE= "Test_method_code";
	public static final String TEST_METHOD_NAME= "Test_method_name";
	public static final String PATHOGEN_SPECIES_CODE= "Pathogen_species_code";
	public static final String PATHOGEN_SPECIES_NAME= "Pathogen_species_name";
	public static final String SPE_TEST_RESULT_CODE= "Spe_test_result_code";
	public static final String SPE_TEST_RESULT_NAME= "Spe_test_result_name";
	public static final String INFE_SITE_CODE= "Infe_site_code";
	public static final String INFE_SITE_NAME= "Infe_site_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_drugseinfo() {
		return ((String) getAttrVal("Id_drugseinfo"));
	}	
	public void setId_drugseinfo(String Id_drugseinfo) {
		setAttrVal("Id_drugseinfo", Id_drugseinfo);
	}
	public String getId_hospitalreport() {
		return ((String) getAttrVal("Id_hospitalreport"));
	}	
	public void setId_hospitalreport(String Id_hospitalreport) {
		setAttrVal("Id_hospitalreport", Id_hospitalreport);
	}
	public String getId_samplename() {
		return ((String) getAttrVal("Id_samplename"));
	}	
	public void setId_samplename(String Id_samplename) {
		setAttrVal("Id_samplename", Id_samplename);
	}
	public String getSd_samplename() {
		return ((String) getAttrVal("Sd_samplename"));
	}	
	public void setSd_samplename(String Sd_samplename) {
		setAttrVal("Sd_samplename", Sd_samplename);
	}
	public String getName_samplename() {
		return ((String) getAttrVal("Name_samplename"));
	}	
	public void setName_samplename(String Name_samplename) {
		setAttrVal("Name_samplename", Name_samplename);
	}
	public FDate getSubmission_date() {
		return ((FDate) getAttrVal("Submission_date"));
	}	
	public void setSubmission_date(FDate Submission_date) {
		setAttrVal("Submission_date", Submission_date);
	}
	public String getId_test_method() {
		return ((String) getAttrVal("Id_test_method"));
	}	
	public void setId_test_method(String Id_test_method) {
		setAttrVal("Id_test_method", Id_test_method);
	}
	public String getSd_test_method() {
		return ((String) getAttrVal("Sd_test_method"));
	}	
	public void setSd_test_method(String Sd_test_method) {
		setAttrVal("Sd_test_method", Sd_test_method);
	}
	public String getName_test_method() {
		return ((String) getAttrVal("Name_test_method"));
	}	
	public void setName_test_method(String Name_test_method) {
		setAttrVal("Name_test_method", Name_test_method);
	}
	public String getId_pathogen_species() {
		return ((String) getAttrVal("Id_pathogen_species"));
	}	
	public void setId_pathogen_species(String Id_pathogen_species) {
		setAttrVal("Id_pathogen_species", Id_pathogen_species);
	}
	public String getSd_pathogen_species() {
		return ((String) getAttrVal("Sd_pathogen_species"));
	}	
	public void setSd_pathogen_species(String Sd_pathogen_species) {
		setAttrVal("Sd_pathogen_species", Sd_pathogen_species);
	}
	public String getName_pathogen_species() {
		return ((String) getAttrVal("Name_pathogen_species"));
	}	
	public void setName_pathogen_species(String Name_pathogen_species) {
		setAttrVal("Name_pathogen_species", Name_pathogen_species);
	}
	public String getId_spe_test_result() {
		return ((String) getAttrVal("Id_spe_test_result"));
	}	
	public void setId_spe_test_result(String Id_spe_test_result) {
		setAttrVal("Id_spe_test_result", Id_spe_test_result);
	}
	public String getSd_spe_test_result() {
		return ((String) getAttrVal("Sd_spe_test_result"));
	}	
	public void setSd_spe_test_result(String Sd_spe_test_result) {
		setAttrVal("Sd_spe_test_result", Sd_spe_test_result);
	}
	public String getName_spe_test_result() {
		return ((String) getAttrVal("Name_spe_test_result"));
	}	
	public void setName_spe_test_result(String Name_spe_test_result) {
		setAttrVal("Name_spe_test_result", Name_spe_test_result);
	}
	public FBoolean getDrug_sen_test() {
		return ((FBoolean) getAttrVal("Drug_sen_test"));
	}	
	public void setDrug_sen_test(FBoolean Drug_sen_test) {
		setAttrVal("Drug_sen_test", Drug_sen_test);
	}
	public FBoolean getDrug_sen_result() {
		return ((FBoolean) getAttrVal("Drug_sen_result"));
	}	
	public void setDrug_sen_result(FBoolean Drug_sen_result) {
		setAttrVal("Drug_sen_result", Drug_sen_result);
	}
	public String getId_infe_site() {
		return ((String) getAttrVal("Id_infe_site"));
	}	
	public void setId_infe_site(String Id_infe_site) {
		setAttrVal("Id_infe_site", Id_infe_site);
	}
	public String getSd_infe_site() {
		return ((String) getAttrVal("Sd_infe_site"));
	}	
	public void setSd_infe_site(String Sd_infe_site) {
		setAttrVal("Sd_infe_site", Sd_infe_site);
	}
	public String getName_infe_site() {
		return ((String) getAttrVal("Name_infe_site"));
	}	
	public void setName_infe_site(String Name_infe_site) {
		setAttrVal("Name_infe_site", Name_infe_site);
	}
	public String getSamplename_code() {
		return ((String) getAttrVal("Samplename_code"));
	}	
	public void setSamplename_code(String Samplename_code) {
		setAttrVal("Samplename_code", Samplename_code);
	}
	public String getSamplename_name() {
		return ((String) getAttrVal("Samplename_name"));
	}	
	public void setSamplename_name(String Samplename_name) {
		setAttrVal("Samplename_name", Samplename_name);
	}
	public String getTest_method_code() {
		return ((String) getAttrVal("Test_method_code"));
	}	
	public void setTest_method_code(String Test_method_code) {
		setAttrVal("Test_method_code", Test_method_code);
	}
	public String getTest_method_name() {
		return ((String) getAttrVal("Test_method_name"));
	}	
	public void setTest_method_name(String Test_method_name) {
		setAttrVal("Test_method_name", Test_method_name);
	}
	public String getPathogen_species_code() {
		return ((String) getAttrVal("Pathogen_species_code"));
	}	
	public void setPathogen_species_code(String Pathogen_species_code) {
		setAttrVal("Pathogen_species_code", Pathogen_species_code);
	}
	public String getPathogen_species_name() {
		return ((String) getAttrVal("Pathogen_species_name"));
	}	
	public void setPathogen_species_name(String Pathogen_species_name) {
		setAttrVal("Pathogen_species_name", Pathogen_species_name);
	}
	public String getSpe_test_result_code() {
		return ((String) getAttrVal("Spe_test_result_code"));
	}	
	public void setSpe_test_result_code(String Spe_test_result_code) {
		setAttrVal("Spe_test_result_code", Spe_test_result_code);
	}
	public String getSpe_test_result_name() {
		return ((String) getAttrVal("Spe_test_result_name"));
	}	
	public void setSpe_test_result_name(String Spe_test_result_name) {
		setAttrVal("Spe_test_result_name", Spe_test_result_name);
	}
	public String getInfe_site_code() {
		return ((String) getAttrVal("Infe_site_code"));
	}	
	public void setInfe_site_code(String Infe_site_code) {
		setAttrVal("Infe_site_code", Infe_site_code);
	}
	public String getInfe_site_name() {
		return ((String) getAttrVal("Infe_site_name"));
	}	
	public void setInfe_site_name(String Infe_site_name) {
		setAttrVal("Infe_site_name", Infe_site_name);
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
		return "Id_drugseinfo";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_MR_CONTAGION_CARD_DSI";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(DrugSensitiInfoDODesc.class);
	}
	
}