package iih.ci.ord.dto.orderverify.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医嘱审核 DTO数据 
 * 
 */
public class OrderVerifyDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 选择
	 * @return FBoolean
	 */
	public FBoolean getSelect() {
		return ((FBoolean) getAttrVal("Select"));
	}
	/**
	 * 选择
	 * @param Select
	 */
	public void setSelect(FBoolean Select) {
		setAttrVal("Select", Select);
	}
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
	 * 医嘱编码
	 * @return String
	 */
	public String getCode_or() {
		return ((String) getAttrVal("Code_or"));
	}
	/**
	 * 医嘱编码
	 * @param Code_or
	 */
	public void setCode_or(String Code_or) {
		setAttrVal("Code_or", Code_or);
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
	 * 失效日期
	 * @return FDateTime
	 */
	public FDateTime getDt_invalid() {
		return ((FDateTime) getAttrVal("Dt_invalid"));
	}
	/**
	 * 失效日期
	 * @param Dt_invalid
	 */
	public void setDt_invalid(FDateTime Dt_invalid) {
		setAttrVal("Dt_invalid", Dt_invalid);
	}
	/**
	 * 医嘱内容
	 * @return String
	 */
	public String getContent_or() {
		return ((String) getAttrVal("Content_or"));
	}
	/**
	 * 医嘱内容
	 * @param Content_or
	 */
	public void setContent_or(String Content_or) {
		setAttrVal("Content_or", Content_or);
	}
	/**
	 * 长临标识
	 * @return FBoolean
	 */
	public FBoolean getFg_long() {
		return ((FBoolean) getAttrVal("Fg_long"));
	}
	/**
	 * 长临标识
	 * @param Fg_long
	 */
	public void setFg_long(FBoolean Fg_long) {
		setAttrVal("Fg_long", Fg_long);
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
	public String getId_excep_level_pharm() {
		return ((String) getAttrVal("Id_excep_level_pharm"));
	}
	/**
	 * 药师审核异常级别
	 * @param Id_excep_level_pharm
	 */
	public void setId_excep_level_pharm(String Id_excep_level_pharm) {
		setAttrVal("Id_excep_level_pharm", Id_excep_level_pharm);
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
	 * 药师审核异常级别名称
	 * @return String
	 */
	public String getName_excep_level_pharm() {
		return ((String) getAttrVal("Name_excep_level_pharm"));
	}
	/**
	 * 药师审核异常级别名称
	 * @param Name_excep_level_pharm
	 */
	public void setName_excep_level_pharm(String Name_excep_level_pharm) {
		setAttrVal("Name_excep_level_pharm", Name_excep_level_pharm);
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
	public String getId_excep_level_sys() {
		return ((String) getAttrVal("Id_excep_level_sys"));
	}
	/**
	 * 合理用药审核异常级别
	 * @param Id_excep_level_sys
	 */
	public void setId_excep_level_sys(String Id_excep_level_sys) {
		setAttrVal("Id_excep_level_sys", Id_excep_level_sys);
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
	 * 合理用药审核异常级别名称
	 * @return String
	 */
	public String getName_excep_level_sys() {
		return ((String) getAttrVal("Name_excep_level_sys"));
	}
	/**
	 * 合理用药审核异常级别名称
	 * @param Name_excep_level_sys
	 */
	public void setName_excep_level_sys(String Name_excep_level_sys) {
		setAttrVal("Name_excep_level_sys", Name_excep_level_sys);
	}
	/**
	 * 审核人
	 * @return String
	 */
	public String getId_emp_verify_pharm() {
		return ((String) getAttrVal("Id_emp_verify_pharm"));
	}
	/**
	 * 审核人
	 * @param Id_emp_verify_pharm
	 */
	public void setId_emp_verify_pharm(String Id_emp_verify_pharm) {
		setAttrVal("Id_emp_verify_pharm", Id_emp_verify_pharm);
	}
	/**
	 * 审核人姓名
	 * @return String
	 */
	public String getName_emp_verify_pharm() {
		return ((String) getAttrVal("Name_emp_verify_pharm"));
	}
	/**
	 * 审核人姓名
	 * @param Name_emp_verify_pharm
	 */
	public void setName_emp_verify_pharm(String Name_emp_verify_pharm) {
		setAttrVal("Name_emp_verify_pharm", Name_emp_verify_pharm);
	}
	/**
	 * 审核时间
	 * @return FDateTime
	 */
	public FDateTime getDt_verify_pharm() {
		return ((FDateTime) getAttrVal("Dt_verify_pharm"));
	}
	/**
	 * 审核时间
	 * @param Dt_verify_pharm
	 */
	public void setDt_verify_pharm(FDateTime Dt_verify_pharm) {
		setAttrVal("Dt_verify_pharm", Dt_verify_pharm);
	}
}