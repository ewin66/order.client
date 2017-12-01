package iih.ci.ord.ciordems.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 会诊受邀科室项目 DTO数据 
 * 
 */
public class EmsItemInCons extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 * @return String
	 */
	public String getId_emsitemincons() {
		return ((String) getAttrVal("Id_emsitemincons"));
	}
	/**
	 * 主键
	 * @param Id_emsitemincons
	 */
	public void setId_emsitemincons(String Id_emsitemincons) {
		setAttrVal("Id_emsitemincons", Id_emsitemincons);
	}
	/**
	 * 排序号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}
	/**
	 * 排序号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 受邀机构id
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}
	/**
	 * 受邀机构id
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 受邀机构
	 * @return String
	 */
	public String getName_org() {
		return ((String) getAttrVal("Name_org"));
	}
	/**
	 * 受邀机构
	 * @param Name_org
	 */
	public void setName_org(String Name_org) {
		setAttrVal("Name_org", Name_org);
	}
	/**
	 * 受邀科室id
	 * @return String
	 */
	public String getId_dep_emp() {
		return ((String) getAttrVal("Id_dep_emp"));
	}
	/**
	 * 受邀科室id
	 * @param Id_dep_emp
	 */
	public void setId_dep_emp(String Id_dep_emp) {
		setAttrVal("Id_dep_emp", Id_dep_emp);
	}
	/**
	 * 受邀科室
	 * @return String
	 */
	public String getName_dep_emp() {
		return ((String) getAttrVal("Name_dep_emp"));
	}
	/**
	 * 受邀科室
	 * @param Name_dep_emp
	 */
	public void setName_dep_emp(String Name_dep_emp) {
		setAttrVal("Name_dep_emp", Name_dep_emp);
	}
	/**
	 * 受邀职称编码
	 * @return String
	 */
	public String getSd_emp_title() {
		return ((String) getAttrVal("Sd_emp_title"));
	}
	/**
	 * 受邀职称编码
	 * @param Sd_emp_title
	 */
	public void setSd_emp_title(String Sd_emp_title) {
		setAttrVal("Sd_emp_title", Sd_emp_title);
	}
	/**
	 * 受邀职称id
	 * @return String
	 */
	public String getId_emp_title() {
		return ((String) getAttrVal("Id_emp_title"));
	}
	/**
	 * 受邀职称id
	 * @param Id_emp_title
	 */
	public void setId_emp_title(String Id_emp_title) {
		setAttrVal("Id_emp_title", Id_emp_title);
	}
	/**
	 * 受邀职称
	 * @return String
	 */
	public String getName_emp_title() {
		return ((String) getAttrVal("Name_emp_title"));
	}
	/**
	 * 受邀职称
	 * @param Name_emp_title
	 */
	public void setName_emp_title(String Name_emp_title) {
		setAttrVal("Name_emp_title", Name_emp_title);
	}
	/**
	 * 受邀人id
	 * @return String
	 */
	public String getId_emp_doctor() {
		return ((String) getAttrVal("Id_emp_doctor"));
	}
	/**
	 * 受邀人id
	 * @param Id_emp_doctor
	 */
	public void setId_emp_doctor(String Id_emp_doctor) {
		setAttrVal("Id_emp_doctor", Id_emp_doctor);
	}
	/**
	 * 受邀人
	 * @return String
	 */
	public String getName_emp_doctor() {
		return ((String) getAttrVal("Name_emp_doctor"));
	}
	/**
	 * 受邀人
	 * @param Name_emp_doctor
	 */
	public void setName_emp_doctor(String Name_emp_doctor) {
		setAttrVal("Name_emp_doctor", Name_emp_doctor);
	}
	/**
	 * 应答时间
	 * @return FDateTime
	 */
	public FDateTime getDt_response() {
		return ((FDateTime) getAttrVal("Dt_response"));
	}
	/**
	 * 应答时间
	 * @param Dt_response
	 */
	public void setDt_response(FDateTime Dt_response) {
		setAttrVal("Dt_response", Dt_response);
	}
	/**
	 * 应答标志
	 * @return FBoolean
	 */
	public FBoolean getFg_response() {
		return ((FBoolean) getAttrVal("Fg_response"));
	}
	/**
	 * 应答标志
	 * @param Fg_response
	 */
	public void setFg_response(FBoolean Fg_response) {
		setAttrVal("Fg_response", Fg_response);
	}
	/**
	 * 应答人id
	 * @return String
	 */
	public String getId_emp_response() {
		return ((String) getAttrVal("Id_emp_response"));
	}
	/**
	 * 应答人id
	 * @param Id_emp_response
	 */
	public void setId_emp_response(String Id_emp_response) {
		setAttrVal("Id_emp_response", Id_emp_response);
	}
	/**
	 * 应答人
	 * @return String
	 */
	public String getName_emp_response() {
		return ((String) getAttrVal("Name_emp_response"));
	}
	/**
	 * 应答人
	 * @param Name_emp_response
	 */
	public void setName_emp_response(String Name_emp_response) {
		setAttrVal("Name_emp_response", Name_emp_response);
	}
	/**
	 * 会诊项目id
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 会诊项目id
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 会诊项目
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}
	/**
	 * 会诊项目
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	/**
	 * 会诊类型编码
	 * @return String
	 */
	public String getSd_constp() {
		return ((String) getAttrVal("Sd_constp"));
	}
	/**
	 * 会诊类型编码
	 * @param Sd_constp
	 */
	public void setSd_constp(String Sd_constp) {
		setAttrVal("Sd_constp", Sd_constp);
	}
	/**
	 * 会诊类型id
	 * @return String
	 */
	public String getId_constp() {
		return ((String) getAttrVal("Id_constp"));
	}
	/**
	 * 会诊类型id
	 * @param Id_constp
	 */
	public void setId_constp(String Id_constp) {
		setAttrVal("Id_constp", Id_constp);
	}
	/**
	 * 会诊类型
	 * @return String
	 */
	public String getName_constp() {
		return ((String) getAttrVal("Name_constp"));
	}
	/**
	 * 会诊类型
	 * @param Name_constp
	 */
	public void setName_constp(String Name_constp) {
		setAttrVal("Name_constp", Name_constp);
	}
	/**
	 * 版本号
	 * @return FDateTime
	 */
	public FDateTime getSv() {
		return ((FDateTime) getAttrVal("Sv"));
	}
	/**
	 * 版本号
	 * @param Sv
	 */
	public void setSv(FDateTime Sv) {
		setAttrVal("Sv", Sv);
	}
	/**
	 * 医疗单来源
	 * @return Integer
	 */
	public Integer getEu_sourcemd() {
		return ((Integer) getAttrVal("Eu_sourcemd"));
	}
	/**
	 * 医疗单来源
	 * @param Eu_sourcemd
	 */
	public void setEu_sourcemd(Integer Eu_sourcemd) {
		setAttrVal("Eu_sourcemd", Eu_sourcemd);
	}
	/**
	 * 费用标识
	 * @return FBoolean
	 */
	public FBoolean getFg_bl() {
		return ((FBoolean) getAttrVal("Fg_bl"));
	}
	/**
	 * 费用标识
	 * @param Fg_bl
	 */
	public void setFg_bl(FBoolean Fg_bl) {
		setAttrVal("Fg_bl", Fg_bl);
	}
	/**
	 * 临床标识
	 * @return FBoolean
	 */
	public FBoolean getFg_or() {
		return ((FBoolean) getAttrVal("Fg_or"));
	}
	/**
	 * 临床标识
	 * @param Fg_or
	 */
	public void setFg_or(FBoolean Fg_or) {
		setAttrVal("Fg_or", Fg_or);
	}
	/**
	 * 服务来源ID
	 * @return String
	 */
	public String getId_srv_src() {
		return ((String) getAttrVal("Id_srv_src"));
	}
	/**
	 * 服务来源ID
	 * @param Id_srv_src
	 */
	public void setId_srv_src(String Id_srv_src) {
		setAttrVal("Id_srv_src", Id_srv_src);
	}
	/**
	 * 计价方式
	 * @return String
	 */
	public String getPriby() {
		return ((String) getAttrVal("Priby"));
	}
	/**
	 * 计价方式
	 * @param Priby
	 */
	public void setPriby(String Priby) {
		setAttrVal("Priby", Priby);
	}
}