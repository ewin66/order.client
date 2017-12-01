package iih.ci.ord.dto.recipedto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 处方信息 DTO数据 
 * 
 */
public class RecipeDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 药品处方主键
	 * @return String
	 */
	public String getId_pres() {
		return ((String) getAttrVal("Id_pres"));
	}
	/**
	 * 药品处方主键
	 * @param Id_pres
	 */
	public void setId_pres(String Id_pres) {
		setAttrVal("Id_pres", Id_pres);
	}
	/**
	 * 诊断序号
	 * @return String
	 */
	public String getSortno() {
		return ((String) getAttrVal("Sortno"));
	}
	/**
	 * 诊断序号
	 * @param Sortno
	 */
	public void setSortno(String Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 诊断编码
	 * @return String
	 */
	public String getDidef_code() {
		return ((String) getAttrVal("Didef_code"));
	}
	/**
	 * 诊断编码
	 * @param Didef_code
	 */
	public void setDidef_code(String Didef_code) {
		setAttrVal("Didef_code", Didef_code);
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	public String getDidef_name() {
		return ((String) getAttrVal("Didef_name"));
	}
	/**
	 * 诊断名称
	 * @param Didef_name
	 */
	public void setDidef_name(String Didef_name) {
		setAttrVal("Didef_name", Didef_name);
	}
	/**
	 * 病历信息
	 * @return String
	 */
	public String getMr_content() {
		return ((String) getAttrVal("Mr_content"));
	}
	/**
	 * 病历信息
	 * @param Mr_content
	 */
	public void setMr_content(String Mr_content) {
		setAttrVal("Mr_content", Mr_content);
	}
	/**
	 * 开立科室
	 * @return String
	 */
	public String getId_dep_or() {
		return ((String) getAttrVal("Id_dep_or"));
	}
	/**
	 * 开立科室
	 * @param Id_dep_or
	 */
	public void setId_dep_or(String Id_dep_or) {
		setAttrVal("Id_dep_or", Id_dep_or);
	}
	/**
	 * his科室编码
	 * @return String
	 */
	public String getCode_dep() {
		return ((String) getAttrVal("Code_dep"));
	}
	/**
	 * his科室编码
	 * @param Code_dep
	 */
	public void setCode_dep(String Code_dep) {
		setAttrVal("Code_dep", Code_dep);
	}
	/**
	 * 医保计划下科别编码
	 * @return String
	 */
	public String getDepcode_hp() {
		return ((String) getAttrVal("Depcode_hp"));
	}
	/**
	 * 医保计划下科别编码
	 * @param Depcode_hp
	 */
	public void setDepcode_hp(String Depcode_hp) {
		setAttrVal("Depcode_hp", Depcode_hp);
	}
	/**
	 * 医保计划下科别名称
	 * @return String
	 */
	public String getDepname_hp() {
		return ((String) getAttrVal("Depname_hp"));
	}
	/**
	 * 医保计划下科别名称
	 * @param Depname_hp
	 */
	public void setDepname_hp(String Depname_hp) {
		setAttrVal("Depname_hp", Depname_hp);
	}
	/**
	 * 开立医生
	 * @return String
	 */
	public String getId_emp_or() {
		return ((String) getAttrVal("Id_emp_or"));
	}
	/**
	 * 开立医生
	 * @param Id_emp_or
	 */
	public void setId_emp_or(String Id_emp_or) {
		setAttrVal("Id_emp_or", Id_emp_or);
	}
	/**
	 * 开立科室名称
	 * @return String
	 */
	public String getId_dep_name() {
		return ((String) getAttrVal("Id_dep_name"));
	}
	/**
	 * 开立科室名称
	 * @param Id_dep_name
	 */
	public void setId_dep_name(String Id_dep_name) {
		setAttrVal("Id_dep_name", Id_dep_name);
	}
	/**
	 * 开立医生名称
	 * @return String
	 */
	public String getId_emp_name() {
		return ((String) getAttrVal("Id_emp_name"));
	}
	/**
	 * 开立医生名称
	 * @param Id_emp_name
	 */
	public void setId_emp_name(String Id_emp_name) {
		setAttrVal("Id_emp_name", Id_emp_name);
	}
	/**
	 * 处方类型
	 * @return String
	 */
	public String getId_prestp() {
		return ((String) getAttrVal("Id_prestp"));
	}
	/**
	 * 处方类型
	 * @param Id_prestp
	 */
	public void setId_prestp(String Id_prestp) {
		setAttrVal("Id_prestp", Id_prestp);
	}
	/**
	 * 处方编码
	 * @return String
	 */
	public String getSd_prestp() {
		return ((String) getAttrVal("Sd_prestp"));
	}
	/**
	 * 处方编码
	 * @param Sd_prestp
	 */
	public void setSd_prestp(String Sd_prestp) {
		setAttrVal("Sd_prestp", Sd_prestp);
	}
	/**
	 * 代开药标志
	 * @return FBoolean
	 */
	public FBoolean getHelpmedicineflag() {
		return ((FBoolean) getAttrVal("Helpmedicineflag"));
	}
	/**
	 * 代开药标志
	 * @param Helpmedicineflag
	 */
	public void setHelpmedicineflag(FBoolean Helpmedicineflag) {
		setAttrVal("Helpmedicineflag", Helpmedicineflag);
	}
	/**
	 * 处方时间
	 * @return FDateTime
	 */
	public FDateTime getDt_entry() {
		return ((FDateTime) getAttrVal("Dt_entry"));
	}
	/**
	 * 处方时间
	 * @param Dt_entry
	 */
	public void setDt_entry(FDateTime Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}
	/**
	 * 备注
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 挂号交易流水号
	 * @return String
	 */
	public String getRegistertradeno() {
		return ((String) getAttrVal("Registertradeno"));
	}
	/**
	 * 挂号交易流水号
	 * @param Registertradeno
	 */
	public void setRegistertradeno(String Registertradeno) {
		setAttrVal("Registertradeno", Registertradeno);
	}
	/**
	 * 单据类型
	 * @return String
	 */
	public String getBillstype() {
		return ((String) getAttrVal("Billstype"));
	}
	/**
	 * 单据类型
	 * @param Billstype
	 */
	public void setBillstype(String Billstype) {
		setAttrVal("Billstype", Billstype);
	}
	/**
	 * 本院科别名称
	 * @return String
	 */
	public String getHospital_dept_name() {
		return ((String) getAttrVal("Hospital_dept_name"));
	}
	/**
	 * 本院科别名称
	 * @param Hospital_dept_name
	 */
	public void setHospital_dept_name(String Hospital_dept_name) {
		setAttrVal("Hospital_dept_name", Hospital_dept_name);
	}
	/**
	 * 患者主键
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者主键
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 就诊号
	 * @return String
	 */
	public String getId_en() {
		return ((String) getAttrVal("Id_en"));
	}
	/**
	 * 就诊号
	 * @param Id_en
	 */
	public void setId_en(String Id_en) {
		setAttrVal("Id_en", Id_en);
	}
	/**
	 * 处方类型名称
	 * @return String
	 */
	public String getPrestp_name() {
		return ((String) getAttrVal("Prestp_name"));
	}
	/**
	 * 处方类型名称
	 * @param Prestp_name
	 */
	public void setPrestp_name(String Prestp_name) {
		setAttrVal("Prestp_name", Prestp_name);
	}
	/**
	 * 处方类型（1医保内，2 医保外）
	 * @return FBoolean
	 */
	public FBoolean getRecipetype() {
		return ((FBoolean) getAttrVal("Recipetype"));
	}
	/**
	 * 处方类型（1医保内，2 医保外）
	 * @param Recipetype
	 */
	public void setRecipetype(FBoolean Recipetype) {
		setAttrVal("Recipetype", Recipetype);
	}
	/**
	 * （费用使用）备注
	 * @return String
	 */
	public String getRemark() {
		return ((String) getAttrVal("Remark"));
	}
	/**
	 * （费用使用）备注
	 * @param Remark
	 */
	public void setRemark(String Remark) {
		setAttrVal("Remark", Remark);
	}
}