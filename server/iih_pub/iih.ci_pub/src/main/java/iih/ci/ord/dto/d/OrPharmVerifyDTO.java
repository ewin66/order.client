package iih.ci.ord.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 药师医嘱审核信息DTO DTO数据 
 * 
 */
public class OrPharmVerifyDTO extends BaseDTO {
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
	 * 药师审核状态
	 * @return Integer
	 */
	public Integer getEu_verify_pharm() {
		return ((Integer) getAttrVal("Eu_verify_pharm"));
	}
	/**
	 * 药师审核状态
	 * @param Eu_verify_pharm
	 */
	public void setEu_verify_pharm(Integer Eu_verify_pharm) {
		setAttrVal("Eu_verify_pharm", Eu_verify_pharm);
	}
	/**
	 * 药师审核建议
	 * @return String
	 */
	public String getDes_verify_pharm() {
		return ((String) getAttrVal("Des_verify_pharm"));
	}
	/**
	 * 药师审核建议
	 * @param Des_verify_pharm
	 */
	public void setDes_verify_pharm(String Des_verify_pharm) {
		setAttrVal("Des_verify_pharm", Des_verify_pharm);
	}
	/**
	 * 药师审核异常级别
	 * @return String
	 */
	public String getId_ecep_level_pharm() {
		return ((String) getAttrVal("Id_ecep_level_pharm"));
	}
	/**
	 * 药师审核异常级别
	 * @param Id_ecep_level_pharm
	 */
	public void setId_ecep_level_pharm(String Id_ecep_level_pharm) {
		setAttrVal("Id_ecep_level_pharm", Id_ecep_level_pharm);
	}
	/**
	 * 药师审核异常级别编码
	 * @return String
	 */
	public String getSd_excep_level_pharm() {
		return ((String) getAttrVal("Sd_excep_level_pharm"));
	}
	/**
	 * 药师审核异常级别编码
	 * @param Sd_excep_level_pharm
	 */
	public void setSd_excep_level_pharm(String Sd_excep_level_pharm) {
		setAttrVal("Sd_excep_level_pharm", Sd_excep_level_pharm);
	}
	/**
	 * 合理用药审核结果
	 * @return String
	 */
	public String getDes_verify_sys() {
		return ((String) getAttrVal("Des_verify_sys"));
	}
	/**
	 * 合理用药审核结果
	 * @param Des_verify_sys
	 */
	public void setDes_verify_sys(String Des_verify_sys) {
		setAttrVal("Des_verify_sys", Des_verify_sys);
	}
	/**
	 * 合理用药审核异常级别
	 * @return String
	 */
	public String getId_ecep_level_sys() {
		return ((String) getAttrVal("Id_ecep_level_sys"));
	}
	/**
	 * 合理用药审核异常级别
	 * @param Id_ecep_level_sys
	 */
	public void setId_ecep_level_sys(String Id_ecep_level_sys) {
		setAttrVal("Id_ecep_level_sys", Id_ecep_level_sys);
	}
	/**
	 * 合理用药审核异常级别编码
	 * @return String
	 */
	public String getSd_excep_level_sys() {
		return ((String) getAttrVal("Sd_excep_level_sys"));
	}
	/**
	 * 合理用药审核异常级别编码
	 * @param Sd_excep_level_sys
	 */
	public void setSd_excep_level_sys(String Sd_excep_level_sys) {
		setAttrVal("Sd_excep_level_sys", Sd_excep_level_sys);
	}
	/**
	 * 审核药师
	 * @return String
	 */
	public String getId_emp_verify_pharm() {
		return ((String) getAttrVal("Id_emp_verify_pharm"));
	}
	/**
	 * 审核药师
	 * @param Id_emp_verify_pharm
	 */
	public void setId_emp_verify_pharm(String Id_emp_verify_pharm) {
		setAttrVal("Id_emp_verify_pharm", Id_emp_verify_pharm);
	}
	/**
	 * 药师审核时间
	 * @return FDateTime
	 */
	public FDateTime getDt_verify_pharm() {
		return ((FDateTime) getAttrVal("Dt_verify_pharm"));
	}
	/**
	 * 药师审核时间
	 * @param Dt_verify_pharm
	 */
	public void setDt_verify_pharm(FDateTime Dt_verify_pharm) {
		setAttrVal("Dt_verify_pharm", Dt_verify_pharm);
	}
	/**
	 * 医师反馈意见
	 * @return String
	 */
	public String getDes_bk_pharm() {
		return ((String) getAttrVal("Des_bk_pharm"));
	}
	/**
	 * 医师反馈意见
	 * @param Des_bk_pharm
	 */
	public void setDes_bk_pharm(String Des_bk_pharm) {
		setAttrVal("Des_bk_pharm", Des_bk_pharm);
	}
	/**
	 * 医师反馈时间
	 * @return FDateTime
	 */
	public FDateTime getDt_bk_pharm() {
		return ((FDateTime) getAttrVal("Dt_bk_pharm"));
	}
	/**
	 * 医师反馈时间
	 * @param Dt_bk_pharm
	 */
	public void setDt_bk_pharm(FDateTime Dt_bk_pharm) {
		setAttrVal("Dt_bk_pharm", Dt_bk_pharm);
	}
	/**
	 * 反馈医师
	 * @return String
	 */
	public String getId_emp_bk_pharm() {
		return ((String) getAttrVal("Id_emp_bk_pharm"));
	}
	/**
	 * 反馈医师
	 * @param Id_emp_bk_pharm
	 */
	public void setId_emp_bk_pharm(String Id_emp_bk_pharm) {
		setAttrVal("Id_emp_bk_pharm", Id_emp_bk_pharm);
	}
}