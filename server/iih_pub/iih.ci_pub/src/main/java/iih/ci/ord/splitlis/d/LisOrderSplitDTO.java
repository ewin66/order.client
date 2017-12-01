package iih.ci.ord.splitlis.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 检验合单 DTO数据 
 * 
 */
public class LisOrderSplitDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 检验分类
	 * @return String
	 */
	public String getId_srvca() {
		return ((String) getAttrVal("Id_srvca"));
	}
	/**
	 * 检验分类
	 * @param Id_srvca
	 */
	public void setId_srvca(String Id_srvca) {
		setAttrVal("Id_srvca", Id_srvca);
	}
	/**
	 * 标本类型编码
	 * @return String
	 */
	public String getSd_samptp() {
		return ((String) getAttrVal("Sd_samptp"));
	}
	/**
	 * 标本类型编码
	 * @param Sd_samptp
	 */
	public void setSd_samptp(String Sd_samptp) {
		setAttrVal("Sd_samptp", Sd_samptp);
	}
	/**
	 * 标本类型（检验物）
	 * @return String
	 */
	public String getId_samptp() {
		return ((String) getAttrVal("Id_samptp"));
	}
	/**
	 * 标本类型（检验物）
	 * @param Id_samptp
	 */
	public void setId_samptp(String Id_samptp) {
		setAttrVal("Id_samptp", Id_samptp);
	}
	/**
	 * 执行科室
	 * @return String
	 */
	public String getId_dep_mp() {
		return ((String) getAttrVal("Id_dep_mp"));
	}
	/**
	 * 执行科室
	 * @param Id_dep_mp
	 */
	public void setId_dep_mp(String Id_dep_mp) {
		setAttrVal("Id_dep_mp", Id_dep_mp);
	}
	/**
	 * 门诊医嘱开立区间
	 * @return String
	 */
	public String getId_session() {
		return ((String) getAttrVal("Id_session"));
	}
	/**
	 * 门诊医嘱开立区间
	 * @param Id_session
	 */
	public void setId_session(String Id_session) {
		setAttrVal("Id_session", Id_session);
	}
	/**
	 * 门诊特需标识
	 * @return FBoolean
	 */
	public FBoolean getFg_opspecial() {
		return ((FBoolean) getAttrVal("Fg_opspecial"));
	}
	/**
	 * 门诊特需标识
	 * @param Fg_opspecial
	 */
	public void setFg_opspecial(FBoolean Fg_opspecial) {
		setAttrVal("Fg_opspecial", Fg_opspecial);
	}
	/**
	 * 患者就诊医保标识
	 * @return FBoolean
	 */
	public FBoolean getFg_hp_pres() {
		return ((FBoolean) getAttrVal("Fg_hp_pres"));
	}
	/**
	 * 患者就诊医保标识
	 * @param Fg_hp_pres
	 */
	public void setFg_hp_pres(FBoolean Fg_hp_pres) {
		setAttrVal("Fg_hp_pres", Fg_hp_pres);
	}
	/**
	 * 打印次数
	 * @return Integer
	 */
	public Integer getCnt_prn() {
		return ((Integer) getAttrVal("Cnt_prn"));
	}
	/**
	 * 打印次数
	 * @param Cnt_prn
	 */
	public void setCnt_prn(Integer Cnt_prn) {
		setAttrVal("Cnt_prn", Cnt_prn);
	}
	/**
	 * 打印标识
	 * @return FBoolean
	 */
	public FBoolean getFg_prn() {
		return ((FBoolean) getAttrVal("Fg_prn"));
	}
	/**
	 * 打印标识
	 * @param Fg_prn
	 */
	public void setFg_prn(FBoolean Fg_prn) {
		setAttrVal("Fg_prn", Fg_prn);
	}
	/**
	 * 诊断名称拼接
	 * @return String
	 */
	public String getStr_name_di() {
		return ((String) getAttrVal("Str_name_di"));
	}
	/**
	 * 诊断名称拼接
	 * @param Str_name_di
	 */
	public void setStr_name_di(String Str_name_di) {
		setAttrVal("Str_name_di", Str_name_di);
	}
	/**
	 * 临床诊断明细id拼接
	 * @return String
	 */
	public String getStr_id_diitm() {
		return ((String) getAttrVal("Str_id_diitm"));
	}
	/**
	 * 临床诊断明细id拼接
	 * @param Str_id_diitm
	 */
	public void setStr_id_diitm(String Str_id_diitm) {
		setAttrVal("Str_id_diitm", Str_id_diitm);
	}
	/**
	 * 诊断编码拼接
	 * @return String
	 */
	public String getStr_code_di() {
		return ((String) getAttrVal("Str_code_di"));
	}
	/**
	 * 诊断编码拼接
	 * @param Str_code_di
	 */
	public void setStr_code_di(String Str_code_di) {
		setAttrVal("Str_code_di", Str_code_di);
	}
	/**
	 * 临床诊断子项
	 * @return String
	 */
	public String getId_diitm() {
		return ((String) getAttrVal("Id_diitm"));
	}
	/**
	 * 临床诊断子项
	 * @param Id_diitm
	 */
	public void setId_diitm(String Id_diitm) {
		setAttrVal("Id_diitm", Id_diitm);
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	public String getName_diag() {
		return ((String) getAttrVal("Name_diag"));
	}
	/**
	 * 诊断名称
	 * @param Name_diag
	 */
	public void setName_diag(String Name_diag) {
		setAttrVal("Name_diag", Name_diag);
	}
	/**
	 * 临床诊断
	 * @return String
	 */
	public String getId_di() {
		return ((String) getAttrVal("Id_di"));
	}
	/**
	 * 临床诊断
	 * @param Id_di
	 */
	public void setId_di(String Id_di) {
		setAttrVal("Id_di", Id_di);
	}
	/**
	 * 申请时间
	 * @return FDateTime
	 */
	public FDateTime getDt_app() {
		return ((FDateTime) getAttrVal("Dt_app"));
	}
	/**
	 * 申请时间
	 * @param Dt_app
	 */
	public void setDt_app(FDateTime Dt_app) {
		setAttrVal("Dt_app", Dt_app);
	}
	/**
	 * 申请科室
	 * @return String
	 */
	public String getId_dep_app() {
		return ((String) getAttrVal("Id_dep_app"));
	}
	/**
	 * 申请科室
	 * @param Id_dep_app
	 */
	public void setId_dep_app(String Id_dep_app) {
		setAttrVal("Id_dep_app", Id_dep_app);
	}
	/**
	 * 申请机构
	 * @return String
	 */
	public String getId_org_app() {
		return ((String) getAttrVal("Id_org_app"));
	}
	/**
	 * 申请机构
	 * @param Id_org_app
	 */
	public void setId_org_app(String Id_org_app) {
		setAttrVal("Id_org_app", Id_org_app);
	}
	/**
	 * 申请医生
	 * @return String
	 */
	public String getId_emp_app() {
		return ((String) getAttrVal("Id_emp_app"));
	}
	/**
	 * 申请医生
	 * @param Id_emp_app
	 */
	public void setId_emp_app(String Id_emp_app) {
		setAttrVal("Id_emp_app", Id_emp_app);
	}
	/**
	 * 加急标识
	 * @return FBoolean
	 */
	public FBoolean getFg_urgent() {
		return ((FBoolean) getAttrVal("Fg_urgent"));
	}
	/**
	 * 加急标识
	 * @param Fg_urgent
	 */
	public void setFg_urgent(FBoolean Fg_urgent) {
		setAttrVal("Fg_urgent", Fg_urgent);
	}
	/**
	 * 注意事项
	 * @return String
	 */
	public String getAnnouncements() {
		return ((String) getAttrVal("Announcements"));
	}
	/**
	 * 注意事项
	 * @param Announcements
	 */
	public void setAnnouncements(String Announcements) {
		setAttrVal("Announcements", Announcements);
	}
	/**
	 * 申请单总金额（参考）
	 * @return FDouble
	 */
	public FDouble getAmt_app_total() {
		return ((FDouble) getAttrVal("Amt_app_total"));
	}
	/**
	 * 申请单总金额（参考）
	 * @param Amt_app_total
	 */
	public void setAmt_app_total(FDouble Amt_app_total) {
		setAttrVal("Amt_app_total", Amt_app_total);
	}
	/**
	 * 标本采集地点
	 * @return String
	 */
	public String getSampcolplace() {
		return ((String) getAttrVal("Sampcolplace"));
	}
	/**
	 * 标本采集地点
	 * @param Sampcolplace
	 */
	public void setSampcolplace(String Sampcolplace) {
		setAttrVal("Sampcolplace", Sampcolplace);
	}
	/**
	 * 标本采集时长单位
	 * @return String
	 */
	public String getId_unit_sampcoltime() {
		return ((String) getAttrVal("Id_unit_sampcoltime"));
	}
	/**
	 * 标本采集时长单位
	 * @param Id_unit_sampcoltime
	 */
	public void setId_unit_sampcoltime(String Id_unit_sampcoltime) {
		setAttrVal("Id_unit_sampcoltime", Id_unit_sampcoltime);
	}
	/**
	 * 标本采集时长
	 * @return FDouble
	 */
	public FDouble getLen_sampcoltime() {
		return ((FDouble) getAttrVal("Len_sampcoltime"));
	}
	/**
	 * 标本采集时长
	 * @param Len_sampcoltime
	 */
	public void setLen_sampcoltime(FDouble Len_sampcoltime) {
		setAttrVal("Len_sampcoltime", Len_sampcoltime);
	}
	/**
	 * 标本采集时间
	 * @return String
	 */
	public String getId_sampcoltime() {
		return ((String) getAttrVal("Id_sampcoltime"));
	}
	/**
	 * 标本采集时间
	 * @param Id_sampcoltime
	 */
	public void setId_sampcoltime(String Id_sampcoltime) {
		setAttrVal("Id_sampcoltime", Id_sampcoltime);
	}
	/**
	 * 计划检验日期
	 * @return FDateTime
	 */
	public FDateTime getDt_plan() {
		return ((FDateTime) getAttrVal("Dt_plan"));
	}
	/**
	 * 计划检验日期
	 * @param Dt_plan
	 */
	public void setDt_plan(FDateTime Dt_plan) {
		setAttrVal("Dt_plan", Dt_plan);
	}
	/**
	 * 申请单名称
	 * @return String
	 */
	public String getName_app() {
		return ((String) getAttrVal("Name_app"));
	}
	/**
	 * 申请单名称
	 * @param Name_app
	 */
	public void setName_app(String Name_app) {
		setAttrVal("Name_app", Name_app);
	}
	/**
	 * 申请单号
	 * @return String
	 */
	public String getCode_app() {
		return ((String) getAttrVal("Code_app"));
	}
	/**
	 * 申请单号
	 * @param Code_app
	 */
	public void setCode_app(String Code_app) {
		setAttrVal("Code_app", Code_app);
	}
	/**
	 * 婴儿序号
	 * @return Integer
	 */
	public Integer getNo_bb() {
		return ((Integer) getAttrVal("No_bb"));
	}
	/**
	 * 婴儿序号
	 * @param No_bb
	 */
	public void setNo_bb(Integer No_bb) {
		setAttrVal("No_bb", No_bb);
	}
	/**
	 * 婴儿标识
	 * @return FBoolean
	 */
	public FBoolean getFg_bb() {
		return ((FBoolean) getAttrVal("Fg_bb"));
	}
	/**
	 * 婴儿标识
	 * @param Fg_bb
	 */
	public void setFg_bb(FBoolean Fg_bb) {
		setAttrVal("Fg_bb", Fg_bb);
	}
	/**
	 * 就诊
	 * @return String
	 */
	public String getId_en() {
		return ((String) getAttrVal("Id_en"));
	}
	/**
	 * 就诊
	 * @param Id_en
	 */
	public void setId_en(String Id_en) {
		setAttrVal("Id_en", Id_en);
	}
	/**
	 * 就诊类型编码
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}
	/**
	 * 就诊类型编码
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getId_entp() {
		return ((String) getAttrVal("Id_entp"));
	}
	/**
	 * 就诊类型
	 * @param Id_entp
	 */
	public void setId_entp(String Id_entp) {
		setAttrVal("Id_entp", Id_entp);
	}
	/**
	 * 患者
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 所属组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}
	/**
	 * 所属组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 所属集团
	 * @return String
	 */
	public String getId_group() {
		return ((String) getAttrVal("Id_group"));
	}
	/**
	 * 所属集团
	 * @param Id_group
	 */
	public void setId_group(String Id_group) {
		setAttrVal("Id_group", Id_group);
	}
	/**
	 * 检验申请单主键标识
	 * @return String
	 */
	public String getId_ciapplissheet() {
		return ((String) getAttrVal("Id_ciapplissheet"));
	}
	/**
	 * 检验申请单主键标识
	 * @param Id_ciapplissheet
	 */
	public void setId_ciapplissheet(String Id_ciapplissheet) {
		setAttrVal("Id_ciapplissheet", Id_ciapplissheet);
	}
}