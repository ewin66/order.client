package iih.ci.rcm.contagion.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 实体 DTO数据 
 * 
 */
public class EntDto extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * 患者ID
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者ID
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 病案主键
	 * @return String
	 */
	public String getId_amr() {
		return ((String) getAttrVal("Id_amr"));
	}
	/**
	 * 病案主键
	 * @param Id_amr
	 */
	public void setId_amr(String Id_amr) {
		setAttrVal("Id_amr", Id_amr);
	}
	/**
	 * 床号
	 * @return String
	 */
	public String getBed_code() {
		return ((String) getAttrVal("Bed_code"));
	}
	/**
	 * 床号
	 * @param Bed_code
	 */
	public void setBed_code(String Bed_code) {
		setAttrVal("Bed_code", Bed_code);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 性别ID
	 * @return String
	 */
	public String getId_sex_pat() {
		return ((String) getAttrVal("Id_sex_pat"));
	}
	/**
	 * 性别ID
	 * @param Id_sex_pat
	 */
	public void setId_sex_pat(String Id_sex_pat) {
		setAttrVal("Id_sex_pat", Id_sex_pat);
	}
	/**
	 * 性别code
	 * @return String
	 */
	public String getSd_sex_pat() {
		return ((String) getAttrVal("Sd_sex_pat"));
	}
	/**
	 * 性别code
	 * @param Sd_sex_pat
	 */
	public void setSd_sex_pat(String Sd_sex_pat) {
		setAttrVal("Sd_sex_pat", Sd_sex_pat);
	}
	/**
	 * 性别
	 * @return String
	 */
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}
	/**
	 * 性别
	 * @param Name_sex
	 */
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
	}
	/**
	 * 年龄
	 * @return String
	 */
	public String getPat_age() {
		return ((String) getAttrVal("Pat_age"));
	}
	/**
	 * 年龄
	 * @param Pat_age
	 */
	public void setPat_age(String Pat_age) {
		setAttrVal("Pat_age", Pat_age);
	}
	/**
	 * 就诊科室
	 * @return String
	 */
	public String getId_dep_phy() {
		return ((String) getAttrVal("Id_dep_phy"));
	}
	/**
	 * 就诊科室
	 * @param Id_dep_phy
	 */
	public void setId_dep_phy(String Id_dep_phy) {
		setAttrVal("Id_dep_phy", Id_dep_phy);
	}
	/**
	 * 就诊科室名称
	 * @return String
	 */
	public String getDep_phy_name() {
		return ((String) getAttrVal("Dep_phy_name"));
	}
	/**
	 * 就诊科室名称
	 * @param Dep_phy_name
	 */
	public void setDep_phy_name(String Dep_phy_name) {
		setAttrVal("Dep_phy_name", Dep_phy_name);
	}
	/**
	 * 入院时间
	 * @return String
	 */
	public String getDt_acpt() {
		return ((String) getAttrVal("Dt_acpt"));
	}
	/**
	 * 入院时间
	 * @param Dt_acpt
	 */
	public void setDt_acpt(String Dt_acpt) {
		setAttrVal("Dt_acpt", Dt_acpt);
	}
	/**
	 * 出院时间
	 * @return String
	 */
	public String getDt_end() {
		return ((String) getAttrVal("Dt_end"));
	}
	/**
	 * 出院时间
	 * @param Dt_end
	 */
	public void setDt_end(String Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 确诊时间
	 * @return String
	 */
	public String getDt_diag() {
		return ((String) getAttrVal("Dt_diag"));
	}
	/**
	 * 确诊时间
	 * @param Dt_diag
	 */
	public void setDt_diag(String Dt_diag) {
		setAttrVal("Dt_diag", Dt_diag);
	}
	/**
	 * 主管医生
	 * @return String
	 */
	public String getName_emp_phy() {
		return ((String) getAttrVal("Name_emp_phy"));
	}
	/**
	 * 主管医生
	 * @param Name_emp_phy
	 */
	public void setName_emp_phy(String Name_emp_phy) {
		setAttrVal("Name_emp_phy", Name_emp_phy);
	}
	/**
	 * 诊断
	 * @return String
	 */
	public String getId_didef_dis() {
		return ((String) getAttrVal("Id_didef_dis"));
	}
	/**
	 * 诊断
	 * @param Id_didef_dis
	 */
	public void setId_didef_dis(String Id_didef_dis) {
		setAttrVal("Id_didef_dis", Id_didef_dis);
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	public String getName_didef_dis() {
		return ((String) getAttrVal("Name_didef_dis"));
	}
	/**
	 * 诊断名称
	 * @param Name_didef_dis
	 */
	public void setName_didef_dis(String Name_didef_dis) {
		setAttrVal("Name_didef_dis", Name_didef_dis);
	}
	/**
	 * 是否有上报卡
	 * @return FBoolean
	 */
	public FBoolean getIscard() {
		return ((FBoolean) getAttrVal("Iscard"));
	}
	/**
	 * 是否有上报卡
	 * @param Iscard
	 */
	public void setIscard(FBoolean Iscard) {
		setAttrVal("Iscard", Iscard);
	}
	/**
	 * 传染病发病日期
	 * @return String
	 */
	public String getFbrq() {
		return ((String) getAttrVal("Fbrq"));
	}
	/**
	 * 传染病发病日期
	 * @param Fbrq
	 */
	public void setFbrq(String Fbrq) {
		setAttrVal("Fbrq", Fbrq);
	}
	/**
	 * 填报日期
	 * @return String
	 */
	public String getDt_contagion() {
		return ((String) getAttrVal("Dt_contagion"));
	}
	/**
	 * 填报日期
	 * @param Dt_contagion
	 */
	public void setDt_contagion(String Dt_contagion) {
		setAttrVal("Dt_contagion", Dt_contagion);
	}
	/**
	 * 状态
	 * @return String
	 */
	public String getId_con_cardsu() {
		return ((String) getAttrVal("Id_con_cardsu"));
	}
	/**
	 * 状态
	 * @param Id_con_cardsu
	 */
	public void setId_con_cardsu(String Id_con_cardsu) {
		setAttrVal("Id_con_cardsu", Id_con_cardsu);
	}
	/**
	 * 状态编码
	 * @return String
	 */
	public String getSd_con_cardsn() {
		return ((String) getAttrVal("Sd_con_cardsn"));
	}
	/**
	 * 状态编码
	 * @param Sd_con_cardsn
	 */
	public void setSd_con_cardsn(String Sd_con_cardsn) {
		setAttrVal("Sd_con_cardsn", Sd_con_cardsn);
	}
	/**
	 * 状态名称
	 * @return String
	 */
	public String getName_con_cardsn() {
		return ((String) getAttrVal("Name_con_cardsn"));
	}
	/**
	 * 状态名称
	 * @param Name_con_cardsn
	 */
	public void setName_con_cardsn(String Name_con_cardsn) {
		setAttrVal("Name_con_cardsn", Name_con_cardsn);
	}
	/**
	 * 出生日期
	 * @return FDate
	 */
	public FDate getPat_birth() {
		return ((FDate) getAttrVal("Pat_birth"));
	}
	/**
	 * 出生日期
	 * @param Pat_birth
	 */
	public void setPat_birth(FDate Pat_birth) {
		setAttrVal("Pat_birth", Pat_birth);
	}
}