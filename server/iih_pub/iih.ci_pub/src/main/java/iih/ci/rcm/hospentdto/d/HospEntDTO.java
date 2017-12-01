package iih.ci.rcm.hospentdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 院感上报患者信息dto DTO数据 
 * 
 */
public class HospEntDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 病案号
	 * @return String
	 */
	public String getHospital_code() {
		return ((String) getAttrVal("Hospital_code"));
	}
	/**
	 * 病案号
	 * @param Hospital_code
	 */
	public void setHospital_code(String Hospital_code) {
		setAttrVal("Hospital_code", Hospital_code);
	}
	/**
	 * 科室病区床位
	 * @return String
	 */
	public String getDept_ward_bed() {
		return ((String) getAttrVal("Dept_ward_bed"));
	}
	/**
	 * 科室病区床位
	 * @param Dept_ward_bed
	 */
	public void setDept_ward_bed(String Dept_ward_bed) {
		setAttrVal("Dept_ward_bed", Dept_ward_bed);
	}
	/**
	 * 病人信息
	 * @return String
	 */
	public String getPat_info() {
		return ((String) getAttrVal("Pat_info"));
	}
	/**
	 * 病人信息
	 * @param Pat_info
	 */
	public void setPat_info(String Pat_info) {
		setAttrVal("Pat_info", Pat_info);
	}
	/**
	 * 感染日期
	 * @return String
	 */
	public String getInfect_date() {
		return ((String) getAttrVal("Infect_date"));
	}
	/**
	 * 感染日期
	 * @param Infect_date
	 */
	public void setInfect_date(String Infect_date) {
		setAttrVal("Infect_date", Infect_date);
	}
	/**
	 * 院感诊断
	 * @return String
	 */
	public String getDi_hosp_name() {
		return ((String) getAttrVal("Di_hosp_name"));
	}
	/**
	 * 院感诊断
	 * @param Di_hosp_name
	 */
	public void setDi_hosp_name(String Di_hosp_name) {
		setAttrVal("Di_hosp_name", Di_hosp_name);
	}
	/**
	 * 就诊号
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊号
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
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
	 * 患者号
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者号
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 填报日期
	 * @return String
	 */
	public String getDt_report() {
		return ((String) getAttrVal("Dt_report"));
	}
	/**
	 * 填报日期
	 * @param Dt_report
	 */
	public void setDt_report(String Dt_report) {
		setAttrVal("Dt_report", Dt_report);
	}
	/**
	 * 状态
	 * @return String
	 */
	public String getStages_name() {
		return ((String) getAttrVal("Stages_name"));
	}
	/**
	 * 状态
	 * @param Stages_name
	 */
	public void setStages_name(String Stages_name) {
		setAttrVal("Stages_name", Stages_name);
	}
	/**
	 * 删除原因
	 * @return String
	 */
	public String getDelete_reason() {
		return ((String) getAttrVal("Delete_reason"));
	}
	/**
	 * 删除原因
	 * @param Delete_reason
	 */
	public void setDelete_reason(String Delete_reason) {
		setAttrVal("Delete_reason", Delete_reason);
	}
	/**
	 * 删除人
	 * @return String
	 */
	public String getDelete_person() {
		return ((String) getAttrVal("Delete_person"));
	}
	/**
	 * 删除人
	 * @param Delete_person
	 */
	public void setDelete_person(String Delete_person) {
		setAttrVal("Delete_person", Delete_person);
	}
	/**
	 * 删除时间
	 * @return String
	 */
	public String getDelete_time() {
		return ((String) getAttrVal("Delete_time"));
	}
	/**
	 * 删除时间
	 * @param Delete_time
	 */
	public void setDelete_time(String Delete_time) {
		setAttrVal("Delete_time", Delete_time);
	}
}