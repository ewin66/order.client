package iih.ci.ord.dto.outdeptcheckorder.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 出科医嘱 DTO数据 
 * 
 */
public class OutDeptCheckOrderDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱状态
	 * @return String
	 */
	public String getSd_su() {
		return ((String) getAttrVal("Sd_su"));
	}
	/**
	 * 医嘱状态
	 * @param Sd_su
	 */
	public void setSd_su(String Sd_su) {
		setAttrVal("Sd_su", Sd_su);
	}
	/**
	 * 长临标志
	 * @return String
	 */
	public String getFg_long() {
		return ((String) getAttrVal("Fg_long"));
	}
	/**
	 * 长临标志
	 * @param Fg_long
	 */
	public void setFg_long(String Fg_long) {
		setAttrVal("Fg_long", Fg_long);
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
	 * 医嘱内容
	 * @return String
	 */
	public String getOr_content() {
		return ((String) getAttrVal("Or_content"));
	}
	/**
	 * 医嘱内容
	 * @param Or_content
	 */
	public void setOr_content(String Or_content) {
		setAttrVal("Or_content", Or_content);
	}
	/**
	 * 生效日期
	 * @return FDateTime
	 */
	public FDateTime getDt_effe() {
		return ((FDateTime) getAttrVal("Dt_effe"));
	}
	/**
	 * 生效日期
	 * @param Dt_effe
	 */
	public void setDt_effe(FDateTime Dt_effe) {
		setAttrVal("Dt_effe", Dt_effe);
	}
	/**
	 * 开立医生
	 * @return String
	 */
	public String getId_emp_create() {
		return ((String) getAttrVal("Id_emp_create"));
	}
	/**
	 * 开立医生
	 * @param Id_emp_create
	 */
	public void setId_emp_create(String Id_emp_create) {
		setAttrVal("Id_emp_create", Id_emp_create);
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
	 * 执行时间
	 * @return FDateTime
	 */
	public FDateTime getId_dep_date() {
		return ((FDateTime) getAttrVal("Id_dep_date"));
	}
	/**
	 * 执行时间
	 * @param Id_dep_date
	 */
	public void setId_dep_date(FDateTime Id_dep_date) {
		setAttrVal("Id_dep_date", Id_dep_date);
	}
	/**
	 * 医嘱id
	 * @return String
	 */
	public String getId_ord() {
		return ((String) getAttrVal("Id_ord"));
	}
	/**
	 * 医嘱id
	 * @param Id_ord
	 */
	public void setId_ord(String Id_ord) {
		setAttrVal("Id_ord", Id_ord);
	}
	/**
	 * 医嘱状态名称
	 * @return String
	 */
	public String getSuname() {
		return ((String) getAttrVal("Suname"));
	}
	/**
	 * 医嘱状态名称
	 * @param Suname
	 */
	public void setSuname(String Suname) {
		setAttrVal("Suname", Suname);
	}
	/**
	 * 服务类型名称
	 * @return String
	 */
	public String getSrvname() {
		return ((String) getAttrVal("Srvname"));
	}
	/**
	 * 服务类型名称
	 * @param Srvname
	 */
	public void setSrvname(String Srvname) {
		setAttrVal("Srvname", Srvname);
	}
	/**
	 * 开立医生名称
	 * @return String
	 */
	public String getEmpname() {
		return ((String) getAttrVal("Empname"));
	}
	/**
	 * 开立医生名称
	 * @param Empname
	 */
	public void setEmpname(String Empname) {
		setAttrVal("Empname", Empname);
	}
	/**
	 * 执行科室名称
	 * @return String
	 */
	public String getDeptname() {
		return ((String) getAttrVal("Deptname"));
	}
	/**
	 * 执行科室名称
	 * @param Deptname
	 */
	public void setDeptname(String Deptname) {
		setAttrVal("Deptname", Deptname);
	}
}