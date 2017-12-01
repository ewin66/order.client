package iih.ci.ord.cior.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.cior.d.desc.OrdApOpDODesc;
import java.math.BigDecimal;

/**
 * 手术申请 DO数据 
 * 
 */
public class OrdApOpDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_APOP= "Id_apop";
	public static final String ID_OR= "Id_or";
	public static final String ID_DI= "Id_di";
	public static final String STR_ID_DIITM= "Str_id_diitm";
	public static final String STR_CODE_DI= "Str_code_di";
	public static final String STR_NAME_DI= "Str_name_di";
	public static final String NO_APPLYFORM= "No_applyform";
	public static final String DT_PLAN= "Dt_plan";
	public static final String SUGPLANTIME= "Sugplantime";
	public static final String ID_LVLSUG= "Id_lvlsug";
	public static final String SD_LVLSUG= "Sd_lvlsug";
	public static final String ID_ANESTP= "Id_anestp";
	public static final String SD_ANESTP= "Sd_anestp";
	public static final String ID_INCITP= "Id_incitp";
	public static final String SD_INCITP= "Sd_incitp";
	public static final String FG_ALLERGY= "Fg_allergy";
	public static final String FG_PATHO= "Fg_patho";
	public static final String ID_SU_OP= "Id_su_op";
	public static final String SD_SU_OP= "Sd_su_op";
	public static final String ANNOUNCEMENTS= "Announcements";
	public static final String ID_SRV= "Id_srv";
	public static final String ID_SRV_CODE= "Id_srv_code";
	public static final String QUAN_BT_PALN= "Quan_bt_paln";
	public static final String ID_EMP_OPERATE= "Id_emp_operate";
	public static final String ID_EMP_HELPER= "Id_emp_helper";
	public static final String ID_SUGBODY= "Id_sugbody";
	public static final String SD_SUGBODY= "Sd_sugbody";
	public static final String SPECIALREQ= "Specialreq";
	public static final String SPECIALINSTRUMENT= "Specialinstrument";
	public static final String SPECIALDES= "Specialdes";
	public static final String FG_ER_SUG= "Fg_er_sug";
	public static final String FG_XQ_SUG= "Fg_xq_sug";
	public static final String FG_ZQ_SUG= "Fg_zq_sug";
	public static final String FG_NEW_SUG= "Fg_new_sug";
	public static final String NAME_DIAG= "Name_diag";
	public static final String ID_DIITM= "Id_diitm";
	public static final String FG_PRN= "Fg_prn";
	public static final String CNT_PRN= "Cnt_prn";
	public static final String ID_DIDEF_RELSTD= "Id_didef_relstd";
	public static final String FG_DAYSUG= "Fg_daysug";
	public static final String ID_DIDEF_DIS= "Id_didef_dis";
	public static final String NAME_DIDEF_DIS= "Name_didef_dis";
	public static final String NAME_LVLSUG= "Name_lvlsug";
	public static final String NAME_ANESTP= "Name_anestp";
	public static final String EU_ANESCA= "Eu_anesca";
	public static final String NAME_INCITP= "Name_incitp";
	public static final String NAME_OP= "Name_op";
	public static final String CODE_OP= "Code_op";
	public static final String NAME_OPERATE= "Name_operate";
	public static final String NAME_HELPER= "Name_helper";
	public static final String NAME_SUGBODY= "Name_sugbody";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public OrdApOpDO () {
		super();
		setFg_prn(new xap.mw.coreitf.d.FBoolean("N"));
		setCnt_prn(0);
		setId_didef_relstd("~");
	}
	
	public String getId_apop() {
		return ((String) getAttrVal("Id_apop"));
	}	
	public void setId_apop(String Id_apop) {
		setAttrVal("Id_apop", Id_apop);
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
	public FDateTime getDt_plan() {
		return ((FDateTime) getAttrVal("Dt_plan"));
	}	
	public void setDt_plan(FDateTime Dt_plan) {
		setAttrVal("Dt_plan", Dt_plan);
	}
	public Integer getSugplantime() {
		return ((Integer) getAttrVal("Sugplantime"));
	}	
	public void setSugplantime(Integer Sugplantime) {
		setAttrVal("Sugplantime", Sugplantime);
	}
	public String getId_lvlsug() {
		return ((String) getAttrVal("Id_lvlsug"));
	}	
	public void setId_lvlsug(String Id_lvlsug) {
		setAttrVal("Id_lvlsug", Id_lvlsug);
	}
	public String getSd_lvlsug() {
		return ((String) getAttrVal("Sd_lvlsug"));
	}	
	public void setSd_lvlsug(String Sd_lvlsug) {
		setAttrVal("Sd_lvlsug", Sd_lvlsug);
	}
	public String getId_anestp() {
		return ((String) getAttrVal("Id_anestp"));
	}	
	public void setId_anestp(String Id_anestp) {
		setAttrVal("Id_anestp", Id_anestp);
	}
	public String getSd_anestp() {
		return ((String) getAttrVal("Sd_anestp"));
	}	
	public void setSd_anestp(String Sd_anestp) {
		setAttrVal("Sd_anestp", Sd_anestp);
	}
	public String getId_incitp() {
		return ((String) getAttrVal("Id_incitp"));
	}	
	public void setId_incitp(String Id_incitp) {
		setAttrVal("Id_incitp", Id_incitp);
	}
	public String getSd_incitp() {
		return ((String) getAttrVal("Sd_incitp"));
	}	
	public void setSd_incitp(String Sd_incitp) {
		setAttrVal("Sd_incitp", Sd_incitp);
	}
	public FBoolean getFg_allergy() {
		return ((FBoolean) getAttrVal("Fg_allergy"));
	}	
	public void setFg_allergy(FBoolean Fg_allergy) {
		setAttrVal("Fg_allergy", Fg_allergy);
	}
	public FBoolean getFg_patho() {
		return ((FBoolean) getAttrVal("Fg_patho"));
	}	
	public void setFg_patho(FBoolean Fg_patho) {
		setAttrVal("Fg_patho", Fg_patho);
	}
	public String getId_su_op() {
		return ((String) getAttrVal("Id_su_op"));
	}	
	public void setId_su_op(String Id_su_op) {
		setAttrVal("Id_su_op", Id_su_op);
	}
	public String getSd_su_op() {
		return ((String) getAttrVal("Sd_su_op"));
	}	
	public void setSd_su_op(String Sd_su_op) {
		setAttrVal("Sd_su_op", Sd_su_op);
	}
	public String getAnnouncements() {
		return ((String) getAttrVal("Announcements"));
	}	
	public void setAnnouncements(String Announcements) {
		setAttrVal("Announcements", Announcements);
	}
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	public String getId_srv_code() {
		return ((String) getAttrVal("Id_srv_code"));
	}	
	public void setId_srv_code(String Id_srv_code) {
		setAttrVal("Id_srv_code", Id_srv_code);
	}
	public FDouble getQuan_bt_paln() {
		return ((FDouble) getAttrVal("Quan_bt_paln"));
	}	
	public void setQuan_bt_paln(FDouble Quan_bt_paln) {
		setAttrVal("Quan_bt_paln", Quan_bt_paln);
	}
	public String getId_emp_operate() {
		return ((String) getAttrVal("Id_emp_operate"));
	}	
	public void setId_emp_operate(String Id_emp_operate) {
		setAttrVal("Id_emp_operate", Id_emp_operate);
	}
	public String getId_emp_helper() {
		return ((String) getAttrVal("Id_emp_helper"));
	}	
	public void setId_emp_helper(String Id_emp_helper) {
		setAttrVal("Id_emp_helper", Id_emp_helper);
	}
	public String getId_sugbody() {
		return ((String) getAttrVal("Id_sugbody"));
	}	
	public void setId_sugbody(String Id_sugbody) {
		setAttrVal("Id_sugbody", Id_sugbody);
	}
	public String getSd_sugbody() {
		return ((String) getAttrVal("Sd_sugbody"));
	}	
	public void setSd_sugbody(String Sd_sugbody) {
		setAttrVal("Sd_sugbody", Sd_sugbody);
	}
	public String getSpecialreq() {
		return ((String) getAttrVal("Specialreq"));
	}	
	public void setSpecialreq(String Specialreq) {
		setAttrVal("Specialreq", Specialreq);
	}
	public String getSpecialinstrument() {
		return ((String) getAttrVal("Specialinstrument"));
	}	
	public void setSpecialinstrument(String Specialinstrument) {
		setAttrVal("Specialinstrument", Specialinstrument);
	}
	public String getSpecialdes() {
		return ((String) getAttrVal("Specialdes"));
	}	
	public void setSpecialdes(String Specialdes) {
		setAttrVal("Specialdes", Specialdes);
	}
	public FBoolean getFg_er_sug() {
		return ((FBoolean) getAttrVal("Fg_er_sug"));
	}	
	public void setFg_er_sug(FBoolean Fg_er_sug) {
		setAttrVal("Fg_er_sug", Fg_er_sug);
	}
	public FBoolean getFg_xq_sug() {
		return ((FBoolean) getAttrVal("Fg_xq_sug"));
	}	
	public void setFg_xq_sug(FBoolean Fg_xq_sug) {
		setAttrVal("Fg_xq_sug", Fg_xq_sug);
	}
	public FBoolean getFg_zq_sug() {
		return ((FBoolean) getAttrVal("Fg_zq_sug"));
	}	
	public void setFg_zq_sug(FBoolean Fg_zq_sug) {
		setAttrVal("Fg_zq_sug", Fg_zq_sug);
	}
	public FBoolean getFg_new_sug() {
		return ((FBoolean) getAttrVal("Fg_new_sug"));
	}	
	public void setFg_new_sug(FBoolean Fg_new_sug) {
		setAttrVal("Fg_new_sug", Fg_new_sug);
	}
	public String getName_diag() {
		return ((String) getAttrVal("Name_diag"));
	}	
	public void setName_diag(String Name_diag) {
		setAttrVal("Name_diag", Name_diag);
	}
	public String getId_diitm() {
		return ((String) getAttrVal("Id_diitm"));
	}	
	public void setId_diitm(String Id_diitm) {
		setAttrVal("Id_diitm", Id_diitm);
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
	public String getId_didef_relstd() {
		return ((String) getAttrVal("Id_didef_relstd"));
	}	
	public void setId_didef_relstd(String Id_didef_relstd) {
		setAttrVal("Id_didef_relstd", Id_didef_relstd);
	}
	public FBoolean getFg_daysug() {
		return ((FBoolean) getAttrVal("Fg_daysug"));
	}	
	public void setFg_daysug(FBoolean Fg_daysug) {
		setAttrVal("Fg_daysug", Fg_daysug);
	}
	public String getId_didef_dis() {
		return ((String) getAttrVal("Id_didef_dis"));
	}	
	public void setId_didef_dis(String Id_didef_dis) {
		setAttrVal("Id_didef_dis", Id_didef_dis);
	}
	public String getName_didef_dis() {
		return ((String) getAttrVal("Name_didef_dis"));
	}	
	public void setName_didef_dis(String Name_didef_dis) {
		setAttrVal("Name_didef_dis", Name_didef_dis);
	}
	public String getName_lvlsug() {
		return ((String) getAttrVal("Name_lvlsug"));
	}	
	public void setName_lvlsug(String Name_lvlsug) {
		setAttrVal("Name_lvlsug", Name_lvlsug);
	}
	public String getName_anestp() {
		return ((String) getAttrVal("Name_anestp"));
	}	
	public void setName_anestp(String Name_anestp) {
		setAttrVal("Name_anestp", Name_anestp);
	}
	public String getEu_anesca() {
		return ((String) getAttrVal("Eu_anesca"));
	}	
	public void setEu_anesca(String Eu_anesca) {
		setAttrVal("Eu_anesca", Eu_anesca);
	}
	public String getName_incitp() {
		return ((String) getAttrVal("Name_incitp"));
	}	
	public void setName_incitp(String Name_incitp) {
		setAttrVal("Name_incitp", Name_incitp);
	}
	public String getName_op() {
		return ((String) getAttrVal("Name_op"));
	}	
	public void setName_op(String Name_op) {
		setAttrVal("Name_op", Name_op);
	}
	public String getCode_op() {
		return ((String) getAttrVal("Code_op"));
	}	
	public void setCode_op(String Code_op) {
		setAttrVal("Code_op", Code_op);
	}
	public String getName_operate() {
		return ((String) getAttrVal("Name_operate"));
	}	
	public void setName_operate(String Name_operate) {
		setAttrVal("Name_operate", Name_operate);
	}
	public String getName_helper() {
		return ((String) getAttrVal("Name_helper"));
	}	
	public void setName_helper(String Name_helper) {
		setAttrVal("Name_helper", Name_helper);
	}
	public String getName_sugbody() {
		return ((String) getAttrVal("Name_sugbody"));
	}	
	public void setName_sugbody(String Name_sugbody) {
		setAttrVal("Name_sugbody", Name_sugbody);
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
		return "Id_apop";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_ap_sug";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OrdApOpDODesc.class);
	}
	
}