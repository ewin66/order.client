package iih.ci.ord.dto.ems.uiemsdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 手术医疗单 DTO数据 
 * 
 */
public class EmsOpsViewDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱ID
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱ID
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 服务ID
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 服务ID
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 处置项目
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}
	/**
	 * 处置项目
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
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
	 * 单价
	 * @return FDouble
	 */
	public FDouble getPrice() {
		return ((FDouble) getAttrVal("Price"));
	}
	/**
	 * 单价
	 * @param Price
	 */
	public void setPrice(FDouble Price) {
		setAttrVal("Price", Price);
	}
	/**
	 * 服务类型
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}
	/**
	 * 服务类型
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 执行科室ID
	 * @return String
	 */
	public String getId_dep_mp() {
		return ((String) getAttrVal("Id_dep_mp"));
	}
	/**
	 * 执行科室ID
	 * @param Id_dep_mp
	 */
	public void setId_dep_mp(String Id_dep_mp) {
		setAttrVal("Id_dep_mp", Id_dep_mp);
	}
	/**
	 * 执行科室
	 * @return String
	 */
	public String getName_dep_mp() {
		return ((String) getAttrVal("Name_dep_mp"));
	}
	/**
	 * 执行科室
	 * @param Name_dep_mp
	 */
	public void setName_dep_mp(String Name_dep_mp) {
		setAttrVal("Name_dep_mp", Name_dep_mp);
	}
	/**
	 * 执行科室过滤条件
	 * @return String
	 */
	public String getFilter_dep_mp() {
		return ((String) getAttrVal("Filter_dep_mp"));
	}
	/**
	 * 执行科室过滤条件
	 * @param Filter_dep_mp
	 */
	public void setFilter_dep_mp(String Filter_dep_mp) {
		setAttrVal("Filter_dep_mp", Filter_dep_mp);
	}
	/**
	 * 计划手术时间
	 * @return FDateTime
	 */
	public FDateTime getDt_plan() {
		return ((FDateTime) getAttrVal("Dt_plan"));
	}
	/**
	 * 计划手术时间
	 * @param Dt_plan
	 */
	public void setDt_plan(FDateTime Dt_plan) {
		setAttrVal("Dt_plan", Dt_plan);
	}
	/**
	 * 手术时限
	 * @return String
	 */
	public String getOptime_limit() {
		return ((String) getAttrVal("Optime_limit"));
	}
	/**
	 * 手术时限
	 * @param Optime_limit
	 */
	public void setOptime_limit(String Optime_limit) {
		setAttrVal("Optime_limit", Optime_limit);
	}
	/**
	 * 诊断ID
	 * @return String
	 */
	public String getId_di() {
		return ((String) getAttrVal("Id_di"));
	}
	/**
	 * 诊断ID
	 * @param Id_di
	 */
	public void setId_di(String Id_di) {
		setAttrVal("Id_di", Id_di);
	}
	/**
	 * 诊断
	 * @return String
	 */
	public String getName_di() {
		return ((String) getAttrVal("Name_di"));
	}
	/**
	 * 诊断
	 * @param Name_di
	 */
	public void setName_di(String Name_di) {
		setAttrVal("Name_di", Name_di);
	}
	/**
	 * 诊断过滤条件
	 * @return String
	 */
	public String getFilter_di() {
		return ((String) getAttrVal("Filter_di"));
	}
	/**
	 * 诊断过滤条件
	 * @param Filter_di
	 */
	public void setFilter_di(String Filter_di) {
		setAttrVal("Filter_di", Filter_di);
	}
	/**
	 * 麻醉方式
	 * @return String
	 */
	public String getName_anestp() {
		return ((String) getAttrVal("Name_anestp"));
	}
	/**
	 * 麻醉方式
	 * @param Name_anestp
	 */
	public void setName_anestp(String Name_anestp) {
		setAttrVal("Name_anestp", Name_anestp);
	}
	/**
	 * 麻醉方式ID
	 * @return String
	 */
	public String getId_anestp() {
		return ((String) getAttrVal("Id_anestp"));
	}
	/**
	 * 麻醉方式ID
	 * @param Id_anestp
	 */
	public void setId_anestp(String Id_anestp) {
		setAttrVal("Id_anestp", Id_anestp);
	}
	/**
	 * 麻醉方式SD
	 * @return String
	 */
	public String getSd_anestp() {
		return ((String) getAttrVal("Sd_anestp"));
	}
	/**
	 * 麻醉方式SD
	 * @param Sd_anestp
	 */
	public void setSd_anestp(String Sd_anestp) {
		setAttrVal("Sd_anestp", Sd_anestp);
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
	 * 附加术ID
	 * @return String
	 */
	public String getId_opex_srvs() {
		return ((String) getAttrVal("Id_opex_srvs"));
	}
	/**
	 * 附加术ID
	 * @param Id_opex_srvs
	 */
	public void setId_opex_srvs(String Id_opex_srvs) {
		setAttrVal("Id_opex_srvs", Id_opex_srvs);
	}
	/**
	 * 附加术编码
	 * @return String
	 */
	public String getCode_opex_srvs() {
		return ((String) getAttrVal("Code_opex_srvs"));
	}
	/**
	 * 附加术编码
	 * @param Code_opex_srvs
	 */
	public void setCode_opex_srvs(String Code_opex_srvs) {
		setAttrVal("Code_opex_srvs", Code_opex_srvs);
	}
	/**
	 * 附加术
	 * @return String
	 */
	public String getName_opex_srvs() {
		return ((String) getAttrVal("Name_opex_srvs"));
	}
	/**
	 * 附加术
	 * @param Name_opex_srvs
	 */
	public void setName_opex_srvs(String Name_opex_srvs) {
		setAttrVal("Name_opex_srvs", Name_opex_srvs);
	}
	/**
	 * 主刀医生ID
	 * @return String
	 */
	public String getId_emp_operator() {
		return ((String) getAttrVal("Id_emp_operator"));
	}
	/**
	 * 主刀医生ID
	 * @param Id_emp_operator
	 */
	public void setId_emp_operator(String Id_emp_operator) {
		setAttrVal("Id_emp_operator", Id_emp_operator);
	}
	/**
	 * 主刀医生
	 * @return String
	 */
	public String getName_emp_operator() {
		return ((String) getAttrVal("Name_emp_operator"));
	}
	/**
	 * 主刀医生
	 * @param Name_emp_operator
	 */
	public void setName_emp_operator(String Name_emp_operator) {
		setAttrVal("Name_emp_operator", Name_emp_operator);
	}
	/**
	 * 第一助手ID
	 * @return String
	 */
	public String getId_emp_help1() {
		return ((String) getAttrVal("Id_emp_help1"));
	}
	/**
	 * 第一助手ID
	 * @param Id_emp_help1
	 */
	public void setId_emp_help1(String Id_emp_help1) {
		setAttrVal("Id_emp_help1", Id_emp_help1);
	}
	/**
	 * 第一助手
	 * @return String
	 */
	public String getName_emp_help1() {
		return ((String) getAttrVal("Name_emp_help1"));
	}
	/**
	 * 第一助手
	 * @param Name_emp_help1
	 */
	public void setName_emp_help1(String Name_emp_help1) {
		setAttrVal("Name_emp_help1", Name_emp_help1);
	}
	/**
	 * 手术级别
	 * @return String
	 */
	public String getName_lvlsug() {
		return ((String) getAttrVal("Name_lvlsug"));
	}
	/**
	 * 手术级别
	 * @param Name_lvlsug
	 */
	public void setName_lvlsug(String Name_lvlsug) {
		setAttrVal("Name_lvlsug", Name_lvlsug);
	}
	/**
	 * 手术级别SD
	 * @return String
	 */
	public String getSd_lvlsug() {
		return ((String) getAttrVal("Sd_lvlsug"));
	}
	/**
	 * 手术级别SD
	 * @param Sd_lvlsug
	 */
	public void setSd_lvlsug(String Sd_lvlsug) {
		setAttrVal("Sd_lvlsug", Sd_lvlsug);
	}
	/**
	 * 手术级别ID
	 * @return String
	 */
	public String getId_lvlsug() {
		return ((String) getAttrVal("Id_lvlsug"));
	}
	/**
	 * 手术级别ID
	 * @param Id_lvlsug
	 */
	public void setId_lvlsug(String Id_lvlsug) {
		setAttrVal("Id_lvlsug", Id_lvlsug);
	}
	/**
	 * sv
	 * @return String
	 */
	public String getSv() {
		return ((String) getAttrVal("Sv"));
	}
	/**
	 * sv
	 * @param Sv
	 */
	public void setSv(String Sv) {
		setAttrVal("Sv", Sv);
	}
}