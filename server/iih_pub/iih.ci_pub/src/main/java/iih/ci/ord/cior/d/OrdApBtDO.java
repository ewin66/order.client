package iih.ci.ord.cior.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.cior.d.desc.OrdApBtDODesc;
import java.math.BigDecimal;

/**
 * 备血申请单 DO数据 
 * 
 */
public class OrdApBtDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_APBT= "Id_apbt";
	public static final String ID_OR= "Id_or";
	public static final String ID_DI= "Id_di";
	public static final String STR_ID_DIITM= "Str_id_diitm";
	public static final String STR_CODE_DI= "Str_code_di";
	public static final String STR_NAME_DI= "Str_name_di";
	public static final String NO_APPLYFORM= "No_applyform";
	public static final String PREGNANT_NUM= "Pregnant_num";
	public static final String PARTURITION_CNT= "Parturition_cnt";
	public static final String ID_HIS_BT= "Id_his_bt";
	public static final String SD_HIS_BT= "Sd_his_bt";
	public static final String ID_PPS_BT= "Id_pps_bt";
	public static final String SD_PPS_BT= "Sd_pps_bt";
	public static final String DES_PPS_BT= "Des_pps_bt";
	public static final String FG_DB= "Fg_db";
	public static final String NO_DB= "No_db";
	public static final String ID_LABITMEXPLAIN= "Id_labitmexplain";
	public static final String SD_LABITMEXPLAIN= "Sd_labitmexplain";
	public static final String ID_DEMANDSU_BT= "Id_demandsu_bt";
	public static final String SD_DEMANDSU_BT= "Sd_demandsu_bt";
	public static final String ID_MODE_BT= "Id_mode_bt";
	public static final String SD_MODE_BT= "Sd_mode_bt";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NUM_MARGIN_BU= "Num_margin_bu";
	public static final String DT_BT_PL= "Dt_bt_pl";
	public static final String SD_SU_BT= "Sd_su_bt";
	public static final String ID_SU_BT= "Id_su_bt";
	public static final String FG_RPT= "Fg_rpt";
	public static final String NAME_DIAG= "Name_diag";
	public static final String FG_PRN= "Fg_prn";
	public static final String CNT_PRN= "Cnt_prn";
	public static final String ID_DIITM= "Id_diitm";
	public static final String ID_DIDEF_DIS= "Id_didef_dis";
	public static final String NAME_HIS_BT= "Name_his_bt";
	public static final String NAME_PPS_BT= "Name_pps_bt";
	public static final String NAME_LABITMEXPLAIN= "Name_labitmexplain";
	public static final String NAME_DEMANDSU_BT= "Name_demandsu_bt";
	public static final String NAME_MODE_BT= "Name_mode_bt";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_apbt() {
		return ((String) getAttrVal("Id_apbt"));
	}	
	public void setId_apbt(String Id_apbt) {
		setAttrVal("Id_apbt", Id_apbt);
	}
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	public String getId_di() {
		return ((String) getAttrVal("Id_di"));
	}	
	public void setId_di(String Id_di) {
		setAttrVal("Id_di", Id_di);
	}
	public String getStr_id_diitm() {
		return ((String) getAttrVal("Str_id_diitm"));
	}	
	public void setStr_id_diitm(String Str_id_diitm) {
		setAttrVal("Str_id_diitm", Str_id_diitm);
	}
	public String getStr_code_di() {
		return ((String) getAttrVal("Str_code_di"));
	}	
	public void setStr_code_di(String Str_code_di) {
		setAttrVal("Str_code_di", Str_code_di);
	}
	public String getStr_name_di() {
		return ((String) getAttrVal("Str_name_di"));
	}	
	public void setStr_name_di(String Str_name_di) {
		setAttrVal("Str_name_di", Str_name_di);
	}
	public String getNo_applyform() {
		return ((String) getAttrVal("No_applyform"));
	}	
	public void setNo_applyform(String No_applyform) {
		setAttrVal("No_applyform", No_applyform);
	}
	public Integer getPregnant_num() {
		return ((Integer) getAttrVal("Pregnant_num"));
	}	
	public void setPregnant_num(Integer Pregnant_num) {
		setAttrVal("Pregnant_num", Pregnant_num);
	}
	public Integer getParturition_cnt() {
		return ((Integer) getAttrVal("Parturition_cnt"));
	}	
	public void setParturition_cnt(Integer Parturition_cnt) {
		setAttrVal("Parturition_cnt", Parturition_cnt);
	}
	public String getId_his_bt() {
		return ((String) getAttrVal("Id_his_bt"));
	}	
	public void setId_his_bt(String Id_his_bt) {
		setAttrVal("Id_his_bt", Id_his_bt);
	}
	public String getSd_his_bt() {
		return ((String) getAttrVal("Sd_his_bt"));
	}	
	public void setSd_his_bt(String Sd_his_bt) {
		setAttrVal("Sd_his_bt", Sd_his_bt);
	}
	public String getId_pps_bt() {
		return ((String) getAttrVal("Id_pps_bt"));
	}	
	public void setId_pps_bt(String Id_pps_bt) {
		setAttrVal("Id_pps_bt", Id_pps_bt);
	}
	public String getSd_pps_bt() {
		return ((String) getAttrVal("Sd_pps_bt"));
	}	
	public void setSd_pps_bt(String Sd_pps_bt) {
		setAttrVal("Sd_pps_bt", Sd_pps_bt);
	}
	public String getDes_pps_bt() {
		return ((String) getAttrVal("Des_pps_bt"));
	}	
	public void setDes_pps_bt(String Des_pps_bt) {
		setAttrVal("Des_pps_bt", Des_pps_bt);
	}
	public FBoolean getFg_db() {
		return ((FBoolean) getAttrVal("Fg_db"));
	}	
	public void setFg_db(FBoolean Fg_db) {
		setAttrVal("Fg_db", Fg_db);
	}
	public String getNo_db() {
		return ((String) getAttrVal("No_db"));
	}	
	public void setNo_db(String No_db) {
		setAttrVal("No_db", No_db);
	}
	public String getId_labitmexplain() {
		return ((String) getAttrVal("Id_labitmexplain"));
	}	
	public void setId_labitmexplain(String Id_labitmexplain) {
		setAttrVal("Id_labitmexplain", Id_labitmexplain);
	}
	public String getSd_labitmexplain() {
		return ((String) getAttrVal("Sd_labitmexplain"));
	}	
	public void setSd_labitmexplain(String Sd_labitmexplain) {
		setAttrVal("Sd_labitmexplain", Sd_labitmexplain);
	}
	public String getId_demandsu_bt() {
		return ((String) getAttrVal("Id_demandsu_bt"));
	}	
	public void setId_demandsu_bt(String Id_demandsu_bt) {
		setAttrVal("Id_demandsu_bt", Id_demandsu_bt);
	}
	public String getSd_demandsu_bt() {
		return ((String) getAttrVal("Sd_demandsu_bt"));
	}	
	public void setSd_demandsu_bt(String Sd_demandsu_bt) {
		setAttrVal("Sd_demandsu_bt", Sd_demandsu_bt);
	}
	public String getId_mode_bt() {
		return ((String) getAttrVal("Id_mode_bt"));
	}	
	public void setId_mode_bt(String Id_mode_bt) {
		setAttrVal("Id_mode_bt", Id_mode_bt);
	}
	public String getSd_mode_bt() {
		return ((String) getAttrVal("Sd_mode_bt"));
	}	
	public void setSd_mode_bt(String Sd_mode_bt) {
		setAttrVal("Sd_mode_bt", Sd_mode_bt);
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
	public FDouble getNum_margin_bu() {
		return ((FDouble) getAttrVal("Num_margin_bu"));
	}	
	public void setNum_margin_bu(FDouble Num_margin_bu) {
		setAttrVal("Num_margin_bu", Num_margin_bu);
	}
	public String getDt_bt_pl() {
		return ((String) getAttrVal("Dt_bt_pl"));
	}	
	public void setDt_bt_pl(String Dt_bt_pl) {
		setAttrVal("Dt_bt_pl", Dt_bt_pl);
	}
	public String getSd_su_bt() {
		return ((String) getAttrVal("Sd_su_bt"));
	}	
	public void setSd_su_bt(String Sd_su_bt) {
		setAttrVal("Sd_su_bt", Sd_su_bt);
	}
	public String getId_su_bt() {
		return ((String) getAttrVal("Id_su_bt"));
	}	
	public void setId_su_bt(String Id_su_bt) {
		setAttrVal("Id_su_bt", Id_su_bt);
	}
	public String getFg_rpt() {
		return ((String) getAttrVal("Fg_rpt"));
	}	
	public void setFg_rpt(String Fg_rpt) {
		setAttrVal("Fg_rpt", Fg_rpt);
	}
	public String getName_diag() {
		return ((String) getAttrVal("Name_diag"));
	}	
	public void setName_diag(String Name_diag) {
		setAttrVal("Name_diag", Name_diag);
	}
	public FBoolean getFg_prn() {
		return ((FBoolean) getAttrVal("Fg_prn"));
	}	
	public void setFg_prn(FBoolean Fg_prn) {
		setAttrVal("Fg_prn", Fg_prn);
	}
	public Integer getCnt_prn() {
		return ((Integer) getAttrVal("Cnt_prn"));
	}	
	public void setCnt_prn(Integer Cnt_prn) {
		setAttrVal("Cnt_prn", Cnt_prn);
	}
	public String getId_diitm() {
		return ((String) getAttrVal("Id_diitm"));
	}	
	public void setId_diitm(String Id_diitm) {
		setAttrVal("Id_diitm", Id_diitm);
	}
	public String getId_didef_dis() {
		return ((String) getAttrVal("Id_didef_dis"));
	}	
	public void setId_didef_dis(String Id_didef_dis) {
		setAttrVal("Id_didef_dis", Id_didef_dis);
	}
	public String getName_his_bt() {
		return ((String) getAttrVal("Name_his_bt"));
	}	
	public void setName_his_bt(String Name_his_bt) {
		setAttrVal("Name_his_bt", Name_his_bt);
	}
	public String getName_pps_bt() {
		return ((String) getAttrVal("Name_pps_bt"));
	}	
	public void setName_pps_bt(String Name_pps_bt) {
		setAttrVal("Name_pps_bt", Name_pps_bt);
	}
	public String getName_labitmexplain() {
		return ((String) getAttrVal("Name_labitmexplain"));
	}	
	public void setName_labitmexplain(String Name_labitmexplain) {
		setAttrVal("Name_labitmexplain", Name_labitmexplain);
	}
	public String getName_demandsu_bt() {
		return ((String) getAttrVal("Name_demandsu_bt"));
	}	
	public void setName_demandsu_bt(String Name_demandsu_bt) {
		setAttrVal("Name_demandsu_bt", Name_demandsu_bt);
	}
	public String getName_mode_bt() {
		return ((String) getAttrVal("Name_mode_bt"));
	}	
	public void setName_mode_bt(String Name_mode_bt) {
		setAttrVal("Name_mode_bt", Name_mode_bt);
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
		return "Id_apbt";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_ap_bt";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OrdApBtDODesc.class);
	}
	
}