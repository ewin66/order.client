package iih.ci.mr.cimrpatsigns.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 实体 DTO数据 
 * 
 */
public class PatDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 就诊ID
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊ID
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 *  患者ID
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 *  患者ID
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 住院类型
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}
	/**
	 * 住院类型
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	/**
	 * 住院号
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 住院号
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 床位号
	 * @return String
	 */
	public String getBebcode() {
		return ((String) getAttrVal("Bebcode"));
	}
	/**
	 * 床位号
	 * @param Bebcode
	 */
	public void setBebcode(String Bebcode) {
		setAttrVal("Bebcode", Bebcode);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 患者姓名
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 性别
	 * @return String
	 */
	public String getSex() {
		return ((String) getAttrVal("Sex"));
	}
	/**
	 * 性别
	 * @param Sex
	 */
	public void setSex(String Sex) {
		setAttrVal("Sex", Sex);
	}
	/**
	 * 年龄
	 * @return String
	 */
	public String getAge() {
		return ((String) getAttrVal("Age"));
	}
	/**
	 * 年龄
	 * @param Age
	 */
	public void setAge(String Age) {
		setAttrVal("Age", Age);
	}
	/**
	 * 出生日期
	 * @return FDate
	 */
	public FDate getDt_birth() {
		return ((FDate) getAttrVal("Dt_birth"));
	}
	/**
	 * 出生日期
	 * @param Dt_birth
	 */
	public void setDt_birth(FDate Dt_birth) {
		setAttrVal("Dt_birth", Dt_birth);
	}
	/**
	 * 是否选中
	 * @return FBoolean
	 */
	public FBoolean getChecked() {
		return ((FBoolean) getAttrVal("Checked"));
	}
	/**
	 * 是否选中
	 * @param Checked
	 */
	public void setChecked(FBoolean Checked) {
		setAttrVal("Checked", Checked);
	}
	/**
	 * 任务标识
	 * @return FBoolean
	 */
	public FBoolean getFg_task() {
		return ((FBoolean) getAttrVal("Fg_task"));
	}
	/**
	 * 任务标识
	 * @param Fg_task
	 */
	public void setFg_task(FBoolean Fg_task) {
		setAttrVal("Fg_task", Fg_task);
	}
	/**
	 * 应录总数
	 * @return Integer
	 */
	public Integer getTask_all() {
		return ((Integer) getAttrVal("Task_all"));
	}
	/**
	 * 应录总数
	 * @param Task_all
	 */
	public void setTask_all(Integer Task_all) {
		setAttrVal("Task_all", Task_all);
	}
	/**
	 * 已录次数
	 * @return Integer
	 */
	public Integer getTask_ed() {
		return ((Integer) getAttrVal("Task_ed"));
	}
	/**
	 * 已录次数
	 * @param Task_ed
	 */
	public void setTask_ed(Integer Task_ed) {
		setAttrVal("Task_ed", Task_ed);
	}
	/**
	 * 未录次数
	 * @return Integer
	 */
	public Integer getTask_ing() {
		return ((Integer) getAttrVal("Task_ing"));
	}
	/**
	 * 未录次数
	 * @param Task_ing
	 */
	public void setTask_ing(Integer Task_ing) {
		setAttrVal("Task_ing", Task_ing);
	}
	/**
	 * 说明
	 * @return String
	 */
	public String getInstraction() {
		return ((String) getAttrVal("Instraction"));
	}
	/**
	 * 说明
	 * @param Instraction
	 */
	public void setInstraction(String Instraction) {
		setAttrVal("Instraction", Instraction);
	}
	/**
	 * 入院日期
	 * @return FDate
	 */
	public FDate getDt_entry() {
		return ((FDate) getAttrVal("Dt_entry"));
	}
	/**
	 * 入院日期
	 * @param Dt_entry
	 */
	public void setDt_entry(FDate Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	/**
	 * 出院日期
	 * @return FDate
	 */
	public FDate getDt_end() {
		return ((FDate) getAttrVal("Dt_end"));
	}
	/**
	 * 出院日期
	 * @param Dt_end
	 */
	public void setDt_end(FDate Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
}