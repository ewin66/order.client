package iih.ci.diag.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 共同信息 DTO数据 
 * 
 */
public class Headdto extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 类型
	 * @return String
	 */
	public String getId_ditp() {
		return ((String) getAttrVal("Id_ditp"));
	}
	/**
	 * 类型
	 * @param Id_ditp
	 */
	public void setId_ditp(String Id_ditp) {
		setAttrVal("Id_ditp", Id_ditp);
	}
	/**
	 * 类型名称
	 * @return String
	 */
	public String getId_ditp_name() {
		return ((String) getAttrVal("Id_ditp_name"));
	}
	/**
	 * 类型名称
	 * @param Id_ditp_name
	 */
	public void setId_ditp_name(String Id_ditp_name) {
		setAttrVal("Id_ditp_name", Id_ditp_name);
	}
	/**
	 * 类型编码
	 * @return String
	 */
	public String getId_ditp_code() {
		return ((String) getAttrVal("Id_ditp_code"));
	}
	/**
	 * 类型编码
	 * @param Id_ditp_code
	 */
	public void setId_ditp_code(String Id_ditp_code) {
		setAttrVal("Id_ditp_code", Id_ditp_code);
	}
	/**
	 * 诊断医生
	 * @return String
	 */
	public String getId_emp_create() {
		return ((String) getAttrVal("Id_emp_create"));
	}
	/**
	 * 诊断医生
	 * @param Id_emp_create
	 */
	public void setId_emp_create(String Id_emp_create) {
		setAttrVal("Id_emp_create", Id_emp_create);
	}
	/**
	 * 诊断医生名称
	 * @return String
	 */
	public String getId_emp_create_name() {
		return ((String) getAttrVal("Id_emp_create_name"));
	}
	/**
	 * 诊断医生名称
	 * @param Id_emp_create_name
	 */
	public void setId_emp_create_name(String Id_emp_create_name) {
		setAttrVal("Id_emp_create_name", Id_emp_create_name);
	}
	/**
	 * 诊断时间
	 * @return FDateTime
	 */
	public FDateTime getDt_di() {
		return ((FDateTime) getAttrVal("Dt_di"));
	}
	/**
	 * 诊断时间
	 * @param Dt_di
	 */
	public void setDt_di(FDateTime Dt_di) {
		setAttrVal("Dt_di", Dt_di);
	}
}