package iih.ci.ord.dto.ems.uiemsdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 会诊医疗单子 DTO数据 
 * 
 */
public class EmsConsViewDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 受邀科室ID
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}
	/**
	 * 受邀科室ID
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 受邀科室
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}
	/**
	 * 受邀科室
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 受邀人ID
	 * @return String
	 */
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}
	/**
	 * 受邀人ID
	 * @param Id_emp
	 */
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	/**
	 * 受邀人
	 * @return String
	 */
	public String getName_emp() {
		return ((String) getAttrVal("Name_emp"));
	}
	/**
	 * 受邀人
	 * @param Name_emp
	 */
	public void setName_emp(String Name_emp) {
		setAttrVal("Name_emp", Name_emp);
	}
	/**
	 * 受邀人职称ID
	 * @return String
	 */
	public String getId_emp_title() {
		return ((String) getAttrVal("Id_emp_title"));
	}
	/**
	 * 受邀人职称ID
	 * @param Id_emp_title
	 */
	public void setId_emp_title(String Id_emp_title) {
		setAttrVal("Id_emp_title", Id_emp_title);
	}
	/**
	 * 受邀人职称
	 * @return String
	 */
	public String getSd_emp_title() {
		return ((String) getAttrVal("Sd_emp_title"));
	}
	/**
	 * 受邀人职称
	 * @param Sd_emp_title
	 */
	public void setSd_emp_title(String Sd_emp_title) {
		setAttrVal("Sd_emp_title", Sd_emp_title);
	}
	/**
	 * 会诊受邀对象ID
	 * @return String
	 */
	public String getId_invitecons() {
		return ((String) getAttrVal("Id_invitecons"));
	}
	/**
	 * 会诊受邀对象ID
	 * @param Id_invitecons
	 */
	public void setId_invitecons(String Id_invitecons) {
		setAttrVal("Id_invitecons", Id_invitecons);
	}
}