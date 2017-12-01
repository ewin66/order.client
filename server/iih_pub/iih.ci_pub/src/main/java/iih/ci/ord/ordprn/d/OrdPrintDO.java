package iih.ci.ord.ordprn.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.ordprn.d.desc.OrdPrintDODesc;
import java.math.BigDecimal;

/**
 * 医嘱打印 DO数据 
 * 
 */
public class OrdPrintDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_ORPRN= "Id_orprn";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_PAT= "Id_pat";
	public static final String ID_EN= "Id_en";
	public static final String ID_ENTP= "Id_entp";
	public static final String CODE_ENTP= "Code_entp";
	public static final String CODE_AMR_IP= "Code_amr_ip";
	public static final String ID_DEP_PHY= "Id_dep_phy";
	public static final String ID_DEP_NUR= "Id_dep_nur";
	public static final String ID_OR= "Id_or";
	public static final String ID_SRVTP= "Id_srvtp";
	public static final String SD_SRVTP= "Sd_srvtp";
	public static final String FG_LONG= "Fg_long";
	public static final String CONTENT_OR_PRN= "Content_or_prn";
	public static final String DT_EFFE= "Dt_effe";
	public static final String DT_EFFE_M= "Dt_effe_m";
	public static final String DT_EFFE_D= "Dt_effe_d";
	public static final String DT_EFFE_T= "Dt_effe_t";
	public static final String ID_EMP_SIGN= "Id_emp_sign";
	public static final String ID_DEP_SIGN= "Id_dep_sign";
	public static final String FG_CHK= "Fg_chk";
	public static final String ID_EMP_CHK= "Id_emp_chk";
	public static final String ID_DEP_CHK= "Id_dep_chk";
	public static final String DT_END= "Dt_end";
	public static final String DT_END_M= "Dt_end_m";
	public static final String DT_END_D= "Dt_end_d";
	public static final String DT_END_T= "Dt_end_t";
	public static final String ID_EMP_STOP= "Id_emp_stop";
	public static final String ID_DEP_STOP= "Id_dep_stop";
	public static final String FG_STOP_PRN= "Fg_stop_prn";
	public static final String FG_CHK_STOP= "Fg_chk_stop";
	public static final String ID_EMP_CHK_STOP= "Id_emp_chk_stop";
	public static final String ID_DEP_CHK_STOP= "Id_dep_chk_stop";
	public static final String FG_CANC_PRN= "Fg_canc_prn";
	public static final String FG_CHK_CANC= "Fg_chk_canc";
	public static final String DT_MP= "Dt_mp";
	public static final String FG_REFORMED= "Fg_reformed";
	public static final String DT_REFORM= "Dt_reform";
	public static final String FG_REFORMROW= "Fg_reformrow";
	public static final String DT_PRN= "Dt_prn";
	public static final String PAGE_NUM= "Page_num";
	public static final String ROW_NUM= "Row_num";
	public static final String ROW_CNT= "Row_cnt";
	public static final String ID_DEP_PRN= "Id_dep_prn";
	public static final String ID_EMP_PRN= "Id_emp_prn";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String CODE_PAT= "Code_pat";
	public static final String NAME_PAT= "Name_pat";
	public static final String NAME_PAT_EN= "Name_pat_en";
	public static final String CODE_PAT_EN= "Code_pat_en";
	public static final String CODE_DEP_PHY= "Code_dep_phy";
	public static final String NAME_DEP_PHY= "Name_dep_phy";
	public static final String CODE_DEP_NUR= "Code_dep_nur";
	public static final String NAME_DEP_NUR= "Name_dep_nur";
	public static final String CODE_EMP_SIGN= "Code_emp_sign";
	public static final String NAME_EMP_SIGN= "Name_emp_sign";
	public static final String CODE_DEP_SIGN= "Code_dep_sign";
	public static final String NAME_DEP_SIGN= "Name_dep_sign";
	public static final String CODE_EMP_CHK= "Code_emp_chk";
	public static final String NAME_EMP_CHK= "Name_emp_chk";
	public static final String CODE_DEP_CHK= "Code_dep_chk";
	public static final String NAME_DEP_CHK= "Name_dep_chk";
	public static final String CODE_EMP_STOP= "Code_emp_stop";
	public static final String NAME_EMP_STOP= "Name_emp_stop";
	public static final String CODE_DEP_STOP= "Code_dep_stop";
	public static final String NAME_DEP_STOP= "Name_dep_stop";
	public static final String CODE_EMP_CHK_STOP= "Code_emp_chk_stop";
	public static final String NAME_EMP_CHK_STOP= "Name_emp_chk_stop";
	public static final String CODE_DEP_CHK_STOP= "Code_dep_chk_stop";
	public static final String NAME_DEP_CHK_STOP= "Name_dep_chk_stop";
	public static final String CODE_DEP_PRN= "Code_dep_prn";
	public static final String NAME_DEP_PRN= "Name_dep_prn";
	public static final String CODE_EMP_PRN= "Code_emp_prn";
	public static final String NAME_EMP_PRN= "Name_emp_prn";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_orprn() {
		return ((String) getAttrVal("Id_orprn"));
	}	
	public void setId_orprn(String Id_orprn) {
		setAttrVal("Id_orprn", Id_orprn);
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
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	public String getId_en() {
		return ((String) getAttrVal("Id_en"));
	}	
	public void setId_en(String Id_en) {
		setAttrVal("Id_en", Id_en);
	}
	public String getId_entp() {
		return ((String) getAttrVal("Id_entp"));
	}	
	public void setId_entp(String Id_entp) {
		setAttrVal("Id_entp", Id_entp);
	}
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}	
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}	
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	public String getId_dep_phy() {
		return ((String) getAttrVal("Id_dep_phy"));
	}	
	public void setId_dep_phy(String Id_dep_phy) {
		setAttrVal("Id_dep_phy", Id_dep_phy);
	}
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}	
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	public String getId_srvtp() {
		return ((String) getAttrVal("Id_srvtp"));
	}	
	public void setId_srvtp(String Id_srvtp) {
		setAttrVal("Id_srvtp", Id_srvtp);
	}
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}	
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	public FBoolean getFg_long() {
		return ((FBoolean) getAttrVal("Fg_long"));
	}	
	public void setFg_long(FBoolean Fg_long) {
		setAttrVal("Fg_long", Fg_long);
	}
	public String getContent_or_prn() {
		return ((String) getAttrVal("Content_or_prn"));
	}	
	public void setContent_or_prn(String Content_or_prn) {
		setAttrVal("Content_or_prn", Content_or_prn);
	}
	public FDateTime getDt_effe() {
		return ((FDateTime) getAttrVal("Dt_effe"));
	}	
	public void setDt_effe(FDateTime Dt_effe) {
		setAttrVal("Dt_effe", Dt_effe);
	}
	public String getDt_effe_m() {
		return ((String) getAttrVal("Dt_effe_m"));
	}	
	public void setDt_effe_m(String Dt_effe_m) {
		setAttrVal("Dt_effe_m", Dt_effe_m);
	}
	public String getDt_effe_d() {
		return ((String) getAttrVal("Dt_effe_d"));
	}	
	public void setDt_effe_d(String Dt_effe_d) {
		setAttrVal("Dt_effe_d", Dt_effe_d);
	}
	public String getDt_effe_t() {
		return ((String) getAttrVal("Dt_effe_t"));
	}	
	public void setDt_effe_t(String Dt_effe_t) {
		setAttrVal("Dt_effe_t", Dt_effe_t);
	}
	public String getId_emp_sign() {
		return ((String) getAttrVal("Id_emp_sign"));
	}	
	public void setId_emp_sign(String Id_emp_sign) {
		setAttrVal("Id_emp_sign", Id_emp_sign);
	}
	public String getId_dep_sign() {
		return ((String) getAttrVal("Id_dep_sign"));
	}	
	public void setId_dep_sign(String Id_dep_sign) {
		setAttrVal("Id_dep_sign", Id_dep_sign);
	}
	public FBoolean getFg_chk() {
		return ((FBoolean) getAttrVal("Fg_chk"));
	}	
	public void setFg_chk(FBoolean Fg_chk) {
		setAttrVal("Fg_chk", Fg_chk);
	}
	public String getId_emp_chk() {
		return ((String) getAttrVal("Id_emp_chk"));
	}	
	public void setId_emp_chk(String Id_emp_chk) {
		setAttrVal("Id_emp_chk", Id_emp_chk);
	}
	public String getId_dep_chk() {
		return ((String) getAttrVal("Id_dep_chk"));
	}	
	public void setId_dep_chk(String Id_dep_chk) {
		setAttrVal("Id_dep_chk", Id_dep_chk);
	}
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}	
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	public String getDt_end_m() {
		return ((String) getAttrVal("Dt_end_m"));
	}	
	public void setDt_end_m(String Dt_end_m) {
		setAttrVal("Dt_end_m", Dt_end_m);
	}
	public String getDt_end_d() {
		return ((String) getAttrVal("Dt_end_d"));
	}	
	public void setDt_end_d(String Dt_end_d) {
		setAttrVal("Dt_end_d", Dt_end_d);
	}
	public String getDt_end_t() {
		return ((String) getAttrVal("Dt_end_t"));
	}	
	public void setDt_end_t(String Dt_end_t) {
		setAttrVal("Dt_end_t", Dt_end_t);
	}
	public String getId_emp_stop() {
		return ((String) getAttrVal("Id_emp_stop"));
	}	
	public void setId_emp_stop(String Id_emp_stop) {
		setAttrVal("Id_emp_stop", Id_emp_stop);
	}
	public String getId_dep_stop() {
		return ((String) getAttrVal("Id_dep_stop"));
	}	
	public void setId_dep_stop(String Id_dep_stop) {
		setAttrVal("Id_dep_stop", Id_dep_stop);
	}
	public FBoolean getFg_stop_prn() {
		return ((FBoolean) getAttrVal("Fg_stop_prn"));
	}	
	public void setFg_stop_prn(FBoolean Fg_stop_prn) {
		setAttrVal("Fg_stop_prn", Fg_stop_prn);
	}
	public FBoolean getFg_chk_stop() {
		return ((FBoolean) getAttrVal("Fg_chk_stop"));
	}	
	public void setFg_chk_stop(FBoolean Fg_chk_stop) {
		setAttrVal("Fg_chk_stop", Fg_chk_stop);
	}
	public String getId_emp_chk_stop() {
		return ((String) getAttrVal("Id_emp_chk_stop"));
	}	
	public void setId_emp_chk_stop(String Id_emp_chk_stop) {
		setAttrVal("Id_emp_chk_stop", Id_emp_chk_stop);
	}
	public String getId_dep_chk_stop() {
		return ((String) getAttrVal("Id_dep_chk_stop"));
	}	
	public void setId_dep_chk_stop(String Id_dep_chk_stop) {
		setAttrVal("Id_dep_chk_stop", Id_dep_chk_stop);
	}
	public FBoolean getFg_canc_prn() {
		return ((FBoolean) getAttrVal("Fg_canc_prn"));
	}	
	public void setFg_canc_prn(FBoolean Fg_canc_prn) {
		setAttrVal("Fg_canc_prn", Fg_canc_prn);
	}
	public FBoolean getFg_chk_canc() {
		return ((FBoolean) getAttrVal("Fg_chk_canc"));
	}	
	public void setFg_chk_canc(FBoolean Fg_chk_canc) {
		setAttrVal("Fg_chk_canc", Fg_chk_canc);
	}
	public FDateTime getDt_mp() {
		return ((FDateTime) getAttrVal("Dt_mp"));
	}	
	public void setDt_mp(FDateTime Dt_mp) {
		setAttrVal("Dt_mp", Dt_mp);
	}
	public FBoolean getFg_reformed() {
		return ((FBoolean) getAttrVal("Fg_reformed"));
	}	
	public void setFg_reformed(FBoolean Fg_reformed) {
		setAttrVal("Fg_reformed", Fg_reformed);
	}
	public FDateTime getDt_reform() {
		return ((FDateTime) getAttrVal("Dt_reform"));
	}	
	public void setDt_reform(FDateTime Dt_reform) {
		setAttrVal("Dt_reform", Dt_reform);
	}
	public FBoolean getFg_reformrow() {
		return ((FBoolean) getAttrVal("Fg_reformrow"));
	}	
	public void setFg_reformrow(FBoolean Fg_reformrow) {
		setAttrVal("Fg_reformrow", Fg_reformrow);
	}
	public FDateTime getDt_prn() {
		return ((FDateTime) getAttrVal("Dt_prn"));
	}	
	public void setDt_prn(FDateTime Dt_prn) {
		setAttrVal("Dt_prn", Dt_prn);
	}
	public Integer getPage_num() {
		return ((Integer) getAttrVal("Page_num"));
	}	
	public void setPage_num(Integer Page_num) {
		setAttrVal("Page_num", Page_num);
	}
	public Integer getRow_num() {
		return ((Integer) getAttrVal("Row_num"));
	}	
	public void setRow_num(Integer Row_num) {
		setAttrVal("Row_num", Row_num);
	}
	public Integer getRow_cnt() {
		return ((Integer) getAttrVal("Row_cnt"));
	}	
	public void setRow_cnt(Integer Row_cnt) {
		setAttrVal("Row_cnt", Row_cnt);
	}
	public String getId_dep_prn() {
		return ((String) getAttrVal("Id_dep_prn"));
	}	
	public void setId_dep_prn(String Id_dep_prn) {
		setAttrVal("Id_dep_prn", Id_dep_prn);
	}
	public String getId_emp_prn() {
		return ((String) getAttrVal("Id_emp_prn"));
	}	
	public void setId_emp_prn(String Id_emp_prn) {
		setAttrVal("Id_emp_prn", Id_emp_prn);
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
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}	
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	public String getName_pat_en() {
		return ((String) getAttrVal("Name_pat_en"));
	}	
	public void setName_pat_en(String Name_pat_en) {
		setAttrVal("Name_pat_en", Name_pat_en);
	}
	public String getCode_pat_en() {
		return ((String) getAttrVal("Code_pat_en"));
	}	
	public void setCode_pat_en(String Code_pat_en) {
		setAttrVal("Code_pat_en", Code_pat_en);
	}
	public String getCode_dep_phy() {
		return ((String) getAttrVal("Code_dep_phy"));
	}	
	public void setCode_dep_phy(String Code_dep_phy) {
		setAttrVal("Code_dep_phy", Code_dep_phy);
	}
	public String getName_dep_phy() {
		return ((String) getAttrVal("Name_dep_phy"));
	}	
	public void setName_dep_phy(String Name_dep_phy) {
		setAttrVal("Name_dep_phy", Name_dep_phy);
	}
	public String getCode_dep_nur() {
		return ((String) getAttrVal("Code_dep_nur"));
	}	
	public void setCode_dep_nur(String Code_dep_nur) {
		setAttrVal("Code_dep_nur", Code_dep_nur);
	}
	public String getName_dep_nur() {
		return ((String) getAttrVal("Name_dep_nur"));
	}	
	public void setName_dep_nur(String Name_dep_nur) {
		setAttrVal("Name_dep_nur", Name_dep_nur);
	}
	public String getCode_emp_sign() {
		return ((String) getAttrVal("Code_emp_sign"));
	}	
	public void setCode_emp_sign(String Code_emp_sign) {
		setAttrVal("Code_emp_sign", Code_emp_sign);
	}
	public String getName_emp_sign() {
		return ((String) getAttrVal("Name_emp_sign"));
	}	
	public void setName_emp_sign(String Name_emp_sign) {
		setAttrVal("Name_emp_sign", Name_emp_sign);
	}
	public String getCode_dep_sign() {
		return ((String) getAttrVal("Code_dep_sign"));
	}	
	public void setCode_dep_sign(String Code_dep_sign) {
		setAttrVal("Code_dep_sign", Code_dep_sign);
	}
	public String getName_dep_sign() {
		return ((String) getAttrVal("Name_dep_sign"));
	}	
	public void setName_dep_sign(String Name_dep_sign) {
		setAttrVal("Name_dep_sign", Name_dep_sign);
	}
	public String getCode_emp_chk() {
		return ((String) getAttrVal("Code_emp_chk"));
	}	
	public void setCode_emp_chk(String Code_emp_chk) {
		setAttrVal("Code_emp_chk", Code_emp_chk);
	}
	public String getName_emp_chk() {
		return ((String) getAttrVal("Name_emp_chk"));
	}	
	public void setName_emp_chk(String Name_emp_chk) {
		setAttrVal("Name_emp_chk", Name_emp_chk);
	}
	public String getCode_dep_chk() {
		return ((String) getAttrVal("Code_dep_chk"));
	}	
	public void setCode_dep_chk(String Code_dep_chk) {
		setAttrVal("Code_dep_chk", Code_dep_chk);
	}
	public String getName_dep_chk() {
		return ((String) getAttrVal("Name_dep_chk"));
	}	
	public void setName_dep_chk(String Name_dep_chk) {
		setAttrVal("Name_dep_chk", Name_dep_chk);
	}
	public String getCode_emp_stop() {
		return ((String) getAttrVal("Code_emp_stop"));
	}	
	public void setCode_emp_stop(String Code_emp_stop) {
		setAttrVal("Code_emp_stop", Code_emp_stop);
	}
	public String getName_emp_stop() {
		return ((String) getAttrVal("Name_emp_stop"));
	}	
	public void setName_emp_stop(String Name_emp_stop) {
		setAttrVal("Name_emp_stop", Name_emp_stop);
	}
	public String getCode_dep_stop() {
		return ((String) getAttrVal("Code_dep_stop"));
	}	
	public void setCode_dep_stop(String Code_dep_stop) {
		setAttrVal("Code_dep_stop", Code_dep_stop);
	}
	public String getName_dep_stop() {
		return ((String) getAttrVal("Name_dep_stop"));
	}	
	public void setName_dep_stop(String Name_dep_stop) {
		setAttrVal("Name_dep_stop", Name_dep_stop);
	}
	public String getCode_emp_chk_stop() {
		return ((String) getAttrVal("Code_emp_chk_stop"));
	}	
	public void setCode_emp_chk_stop(String Code_emp_chk_stop) {
		setAttrVal("Code_emp_chk_stop", Code_emp_chk_stop);
	}
	public String getName_emp_chk_stop() {
		return ((String) getAttrVal("Name_emp_chk_stop"));
	}	
	public void setName_emp_chk_stop(String Name_emp_chk_stop) {
		setAttrVal("Name_emp_chk_stop", Name_emp_chk_stop);
	}
	public String getCode_dep_chk_stop() {
		return ((String) getAttrVal("Code_dep_chk_stop"));
	}	
	public void setCode_dep_chk_stop(String Code_dep_chk_stop) {
		setAttrVal("Code_dep_chk_stop", Code_dep_chk_stop);
	}
	public String getName_dep_chk_stop() {
		return ((String) getAttrVal("Name_dep_chk_stop"));
	}	
	public void setName_dep_chk_stop(String Name_dep_chk_stop) {
		setAttrVal("Name_dep_chk_stop", Name_dep_chk_stop);
	}
	public String getCode_dep_prn() {
		return ((String) getAttrVal("Code_dep_prn"));
	}	
	public void setCode_dep_prn(String Code_dep_prn) {
		setAttrVal("Code_dep_prn", Code_dep_prn);
	}
	public String getName_dep_prn() {
		return ((String) getAttrVal("Name_dep_prn"));
	}	
	public void setName_dep_prn(String Name_dep_prn) {
		setAttrVal("Name_dep_prn", Name_dep_prn);
	}
	public String getCode_emp_prn() {
		return ((String) getAttrVal("Code_emp_prn"));
	}	
	public void setCode_emp_prn(String Code_emp_prn) {
		setAttrVal("Code_emp_prn", Code_emp_prn);
	}
	public String getName_emp_prn() {
		return ((String) getAttrVal("Name_emp_prn"));
	}	
	public void setName_emp_prn(String Name_emp_prn) {
		setAttrVal("Name_emp_prn", Name_emp_prn);
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
		return "Id_orprn";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_or_prn";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OrdPrintDODesc.class);
	}
	
}