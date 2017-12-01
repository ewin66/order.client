package iih.ci.mrqc.qrydto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊患者列表查询 DTO数据 
 * 
 */
public class OutQaPatQryDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 就诊编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 就诊编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 患者姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 当前主管医生
	 * @return String
	 */
	public String getId_emp_phy() {
		return ((String) getAttrVal("Id_emp_phy"));
	}
	/**
	 * 当前主管医生
	 * @param Id_emp_phy
	 */
	public void setId_emp_phy(String Id_emp_phy) {
		setAttrVal("Id_emp_phy", Id_emp_phy);
	}
	/**
	 * 当前就诊科室
	 * @return String
	 */
	public String getId_dep_phy() {
		return ((String) getAttrVal("Id_dep_phy"));
	}
	/**
	 * 当前就诊科室
	 * @param Id_dep_phy
	 */
	public void setId_dep_phy(String Id_dep_phy) {
		setAttrVal("Id_dep_phy", Id_dep_phy);
	}
	/**
	 * 就诊登记日期时间
	 * @return FDateTime
	 */
	public FDateTime getDt_entry_start() {
		return ((FDateTime) getAttrVal("Dt_entry_start"));
	}
	/**
	 * 就诊登记日期时间
	 * @param Dt_entry_start
	 */
	public void setDt_entry_start(FDateTime Dt_entry_start) {
		setAttrVal("Dt_entry_start", Dt_entry_start);
	}
	/**
	 * 就诊结束时间
	 * @return FDateTime
	 */
	public FDateTime getDt_entry_end() {
		return ((FDateTime) getAttrVal("Dt_entry_end"));
	}
	/**
	 * 就诊结束时间
	 * @param Dt_entry_end
	 */
	public void setDt_entry_end(FDateTime Dt_entry_end) {
		setAttrVal("Dt_entry_end", Dt_entry_end);
	}
	/**
	 * 去无门诊病历
	 * @return FBoolean
	 */
	public FBoolean getFg_mr() {
		return ((FBoolean) getAttrVal("Fg_mr"));
	}
	/**
	 * 去无门诊病历
	 * @param Fg_mr
	 */
	public void setFg_mr(FBoolean Fg_mr) {
		setAttrVal("Fg_mr", Fg_mr);
	}
	/**
	 * 去抽查
	 * @return FBoolean
	 */
	public FBoolean getFg_random() {
		return ((FBoolean) getAttrVal("Fg_random"));
	}
	/**
	 * 去抽查
	 * @param Fg_random
	 */
	public void setFg_random(FBoolean Fg_random) {
		setAttrVal("Fg_random", Fg_random);
	}
	/**
	 * 抽查份数
	 * @return Integer
	 */
	public Integer getTimes_random() {
		return ((Integer) getAttrVal("Times_random"));
	}
	/**
	 * 抽查份数
	 * @param Times_random
	 */
	public void setTimes_random(Integer Times_random) {
		setAttrVal("Times_random", Times_random);
	}
	/**
	 * 科室编码
	 * @return String
	 */
	public String getSd_dep_phy() {
		return ((String) getAttrVal("Sd_dep_phy"));
	}
	/**
	 * 科室编码
	 * @param Sd_dep_phy
	 */
	public void setSd_dep_phy(String Sd_dep_phy) {
		setAttrVal("Sd_dep_phy", Sd_dep_phy);
	}
	/**
	 * 科室名称
	 * @return String
	 */
	public String getName_dep_phy() {
		return ((String) getAttrVal("Name_dep_phy"));
	}
	/**
	 * 科室名称
	 * @param Name_dep_phy
	 */
	public void setName_dep_phy(String Name_dep_phy) {
		setAttrVal("Name_dep_phy", Name_dep_phy);
	}
	/**
	 * 医生编码
	 * @return String
	 */
	public String getSd_emp_phy() {
		return ((String) getAttrVal("Sd_emp_phy"));
	}
	/**
	 * 医生编码
	 * @param Sd_emp_phy
	 */
	public void setSd_emp_phy(String Sd_emp_phy) {
		setAttrVal("Sd_emp_phy", Sd_emp_phy);
	}
	/**
	 * 医生名称
	 * @return String
	 */
	public String getName_emp_phy() {
		return ((String) getAttrVal("Name_emp_phy"));
	}
	/**
	 * 医生名称
	 * @param Name_emp_phy
	 */
	public void setName_emp_phy(String Name_emp_phy) {
		setAttrVal("Name_emp_phy", Name_emp_phy);
	}
}