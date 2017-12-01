package iih.ci.ord.cior.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.cior.d.desc.CiOrdBtTestItmDODesc;
import java.math.BigDecimal;

/**
 * 交叉备血结果单明细 DO数据 
 * 
 */
public class CiOrdBtTestItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_RPTBTTESTITM= "Id_rptbttestitm";
	public static final String ID_RPTBTTEST= "Id_rptbttest";
	public static final String ID_TB= "Id_tb";
	public static final String SORTNO= "Sortno";
	public static final String ID_SRV_BT= "Id_srv_bt";
	public static final String BARCODE_BB= "Barcode_bb";
	public static final String NUM_BB= "Num_bb";
	public static final String ID_UNIT_BB= "Id_unit_bb";
	public static final String ID_ABO_BT= "Id_abo_bt";
	public static final String SD_ABO_BT= "Sd_abo_bt";
	public static final String ID_RH_BT= "Id_rh_bt";
	public static final String SD_RH_BT= "Sd_rh_bt";
	public static final String ID_TESTITMMETH= "Id_testitmmeth";
	public static final String SD_TESTITMMETH= "Sd_testitmmeth";
	public static final String ID_TESTITMRES_M= "Id_testitmres_m";
	public static final String SD_TESTITMRES_M= "Sd_testitmres_m";
	public static final String ID_TESTITMRES_S= "Id_testitmres_s";
	public static final String SD_TESTITMRES_S= "Sd_testitmres_s";
	public static final String DES= "Des";
	public static final String ID_EMP_TESTITM= "Id_emp_testitm";
	public static final String ID_EMP_RETESTITM= "Id_emp_retestitm";
	public static final String DT_RESTITM= "Dt_restitm";
	public static final String FG_ST= "Fg_st";
	public static final String ID_MM= "Id_mm";
	public static final String ID_UNIT_PKGSP= "Id_unit_pkgsp";
	public static final String CODE_BT= "Code_bt";
	public static final String NAME_BT= "Name_bt";
	public static final String DT_ST= "Dt_st";
	public static final String ID_EMP_ST= "Id_emp_st";
	public static final String NAME_BT_SRV= "Name_bt_srv";
	public static final String CODE_BT_SRV= "Code_bt_srv";
	public static final String UNIT_BB_NAME= "Unit_bb_name";
	public static final String ABO_NAME= "Abo_name";
	public static final String RH_NAME= "Rh_name";
	public static final String BT_METHOD_NAME= "Bt_method_name";
	public static final String BT_RSM_NAME= "Bt_rsm_name";
	public static final String BT_RSS_NAME= "Bt_rss_name";
	public static final String TEST_NAME= "Test_name";
	public static final String RETEST_NAME= "Retest_name";
	public static final String MM_NAME= "Mm_name";
	public static final String PKGSP_UNIT_NAME= "Pkgsp_unit_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_rptbttestitm() {
		return ((String) getAttrVal("Id_rptbttestitm"));
	}	
	public void setId_rptbttestitm(String Id_rptbttestitm) {
		setAttrVal("Id_rptbttestitm", Id_rptbttestitm);
	}
	public String getId_rptbttest() {
		return ((String) getAttrVal("Id_rptbttest"));
	}	
	public void setId_rptbttest(String Id_rptbttest) {
		setAttrVal("Id_rptbttest", Id_rptbttest);
	}
	public String getId_tb() {
		return ((String) getAttrVal("Id_tb"));
	}	
	public void setId_tb(String Id_tb) {
		setAttrVal("Id_tb", Id_tb);
	}
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	public String getId_srv_bt() {
		return ((String) getAttrVal("Id_srv_bt"));
	}	
	public void setId_srv_bt(String Id_srv_bt) {
		setAttrVal("Id_srv_bt", Id_srv_bt);
	}
	public String getBarcode_bb() {
		return ((String) getAttrVal("Barcode_bb"));
	}	
	public void setBarcode_bb(String Barcode_bb) {
		setAttrVal("Barcode_bb", Barcode_bb);
	}
	public Integer getNum_bb() {
		return ((Integer) getAttrVal("Num_bb"));
	}	
	public void setNum_bb(Integer Num_bb) {
		setAttrVal("Num_bb", Num_bb);
	}
	public String getId_unit_bb() {
		return ((String) getAttrVal("Id_unit_bb"));
	}	
	public void setId_unit_bb(String Id_unit_bb) {
		setAttrVal("Id_unit_bb", Id_unit_bb);
	}
	public String getId_abo_bt() {
		return ((String) getAttrVal("Id_abo_bt"));
	}	
	public void setId_abo_bt(String Id_abo_bt) {
		setAttrVal("Id_abo_bt", Id_abo_bt);
	}
	public String getSd_abo_bt() {
		return ((String) getAttrVal("Sd_abo_bt"));
	}	
	public void setSd_abo_bt(String Sd_abo_bt) {
		setAttrVal("Sd_abo_bt", Sd_abo_bt);
	}
	public String getId_rh_bt() {
		return ((String) getAttrVal("Id_rh_bt"));
	}	
	public void setId_rh_bt(String Id_rh_bt) {
		setAttrVal("Id_rh_bt", Id_rh_bt);
	}
	public String getSd_rh_bt() {
		return ((String) getAttrVal("Sd_rh_bt"));
	}	
	public void setSd_rh_bt(String Sd_rh_bt) {
		setAttrVal("Sd_rh_bt", Sd_rh_bt);
	}
	public String getId_testitmmeth() {
		return ((String) getAttrVal("Id_testitmmeth"));
	}	
	public void setId_testitmmeth(String Id_testitmmeth) {
		setAttrVal("Id_testitmmeth", Id_testitmmeth);
	}
	public String getSd_testitmmeth() {
		return ((String) getAttrVal("Sd_testitmmeth"));
	}	
	public void setSd_testitmmeth(String Sd_testitmmeth) {
		setAttrVal("Sd_testitmmeth", Sd_testitmmeth);
	}
	public String getId_testitmres_m() {
		return ((String) getAttrVal("Id_testitmres_m"));
	}	
	public void setId_testitmres_m(String Id_testitmres_m) {
		setAttrVal("Id_testitmres_m", Id_testitmres_m);
	}
	public String getSd_testitmres_m() {
		return ((String) getAttrVal("Sd_testitmres_m"));
	}	
	public void setSd_testitmres_m(String Sd_testitmres_m) {
		setAttrVal("Sd_testitmres_m", Sd_testitmres_m);
	}
	public String getId_testitmres_s() {
		return ((String) getAttrVal("Id_testitmres_s"));
	}	
	public void setId_testitmres_s(String Id_testitmres_s) {
		setAttrVal("Id_testitmres_s", Id_testitmres_s);
	}
	public String getSd_testitmres_s() {
		return ((String) getAttrVal("Sd_testitmres_s"));
	}	
	public void setSd_testitmres_s(String Sd_testitmres_s) {
		setAttrVal("Sd_testitmres_s", Sd_testitmres_s);
	}
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	public String getId_emp_testitm() {
		return ((String) getAttrVal("Id_emp_testitm"));
	}	
	public void setId_emp_testitm(String Id_emp_testitm) {
		setAttrVal("Id_emp_testitm", Id_emp_testitm);
	}
	public String getId_emp_retestitm() {
		return ((String) getAttrVal("Id_emp_retestitm"));
	}	
	public void setId_emp_retestitm(String Id_emp_retestitm) {
		setAttrVal("Id_emp_retestitm", Id_emp_retestitm);
	}
	public FDateTime getDt_restitm() {
		return ((FDateTime) getAttrVal("Dt_restitm"));
	}	
	public void setDt_restitm(FDateTime Dt_restitm) {
		setAttrVal("Dt_restitm", Dt_restitm);
	}
	public FBoolean getFg_st() {
		return ((FBoolean) getAttrVal("Fg_st"));
	}	
	public void setFg_st(FBoolean Fg_st) {
		setAttrVal("Fg_st", Fg_st);
	}
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}	
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	public String getId_unit_pkgsp() {
		return ((String) getAttrVal("Id_unit_pkgsp"));
	}	
	public void setId_unit_pkgsp(String Id_unit_pkgsp) {
		setAttrVal("Id_unit_pkgsp", Id_unit_pkgsp);
	}
	public String getCode_bt() {
		return ((String) getAttrVal("Code_bt"));
	}	
	public void setCode_bt(String Code_bt) {
		setAttrVal("Code_bt", Code_bt);
	}
	public String getName_bt() {
		return ((String) getAttrVal("Name_bt"));
	}	
	public void setName_bt(String Name_bt) {
		setAttrVal("Name_bt", Name_bt);
	}
	public FDateTime getDt_st() {
		return ((FDateTime) getAttrVal("Dt_st"));
	}	
	public void setDt_st(FDateTime Dt_st) {
		setAttrVal("Dt_st", Dt_st);
	}
	public String getId_emp_st() {
		return ((String) getAttrVal("Id_emp_st"));
	}	
	public void setId_emp_st(String Id_emp_st) {
		setAttrVal("Id_emp_st", Id_emp_st);
	}
	public String getName_bt_srv() {
		return ((String) getAttrVal("Name_bt_srv"));
	}	
	public void setName_bt_srv(String Name_bt_srv) {
		setAttrVal("Name_bt_srv", Name_bt_srv);
	}
	public String getCode_bt_srv() {
		return ((String) getAttrVal("Code_bt_srv"));
	}	
	public void setCode_bt_srv(String Code_bt_srv) {
		setAttrVal("Code_bt_srv", Code_bt_srv);
	}
	public String getUnit_bb_name() {
		return ((String) getAttrVal("Unit_bb_name"));
	}	
	public void setUnit_bb_name(String Unit_bb_name) {
		setAttrVal("Unit_bb_name", Unit_bb_name);
	}
	public String getAbo_name() {
		return ((String) getAttrVal("Abo_name"));
	}	
	public void setAbo_name(String Abo_name) {
		setAttrVal("Abo_name", Abo_name);
	}
	public String getRh_name() {
		return ((String) getAttrVal("Rh_name"));
	}	
	public void setRh_name(String Rh_name) {
		setAttrVal("Rh_name", Rh_name);
	}
	public String getBt_method_name() {
		return ((String) getAttrVal("Bt_method_name"));
	}	
	public void setBt_method_name(String Bt_method_name) {
		setAttrVal("Bt_method_name", Bt_method_name);
	}
	public String getBt_rsm_name() {
		return ((String) getAttrVal("Bt_rsm_name"));
	}	
	public void setBt_rsm_name(String Bt_rsm_name) {
		setAttrVal("Bt_rsm_name", Bt_rsm_name);
	}
	public String getBt_rss_name() {
		return ((String) getAttrVal("Bt_rss_name"));
	}	
	public void setBt_rss_name(String Bt_rss_name) {
		setAttrVal("Bt_rss_name", Bt_rss_name);
	}
	public String getTest_name() {
		return ((String) getAttrVal("Test_name"));
	}	
	public void setTest_name(String Test_name) {
		setAttrVal("Test_name", Test_name);
	}
	public String getRetest_name() {
		return ((String) getAttrVal("Retest_name"));
	}	
	public void setRetest_name(String Retest_name) {
		setAttrVal("Retest_name", Retest_name);
	}
	public String getMm_name() {
		return ((String) getAttrVal("Mm_name"));
	}	
	public void setMm_name(String Mm_name) {
		setAttrVal("Mm_name", Mm_name);
	}
	public String getPkgsp_unit_name() {
		return ((String) getAttrVal("Pkgsp_unit_name"));
	}	
	public void setPkgsp_unit_name(String Pkgsp_unit_name) {
		setAttrVal("Pkgsp_unit_name", Pkgsp_unit_name);
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
		return "Id_rptbttestitm";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_RPT_BTTESTITM";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiOrdBtTestItmDODesc.class);
	}
	
}