package iih.ci.ord.dto.orderverify.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医嘱审核患者 DTO数据 
 * 
 */
public class OrderVerifyPatDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者id
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者id
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 就诊id
	 * @return String
	 */
	public String getId_en() {
		return ((String) getAttrVal("Id_en"));
	}
	/**
	 * 就诊id
	 * @param Id_en
	 */
	public void setId_en(String Id_en) {
		setAttrVal("Id_en", Id_en);
	}
	/**
	 * 医嘱id
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱id
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 患者编码
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}
	/**
	 * 患者编码
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	/**
	 * 患者名称
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 患者名称
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 病区
	 * @return String
	 */
	public String getId_dep_chk() {
		return ((String) getAttrVal("Id_dep_chk"));
	}
	/**
	 * 病区
	 * @param Id_dep_chk
	 */
	public void setId_dep_chk(String Id_dep_chk) {
		setAttrVal("Id_dep_chk", Id_dep_chk);
	}
	/**
	 * 病区名称
	 * @return String
	 */
	public String getName_dep_chk() {
		return ((String) getAttrVal("Name_dep_chk"));
	}
	/**
	 * 病区名称
	 * @param Name_dep_chk
	 */
	public void setName_dep_chk(String Name_dep_chk) {
		setAttrVal("Name_dep_chk", Name_dep_chk);
	}
	/**
	 * 科室id
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}
	/**
	 * 科室id
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 科室名称
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}
	/**
	 * 科室名称
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 医嘱数
	 * @return Integer
	 */
	public Integer getOrd_num() {
		return ((Integer) getAttrVal("Ord_num"));
	}
	/**
	 * 医嘱数
	 * @param Ord_num
	 */
	public void setOrd_num(Integer Ord_num) {
		setAttrVal("Ord_num", Ord_num);
	}
	/**
	 * 审核状态
	 * @return Integer
	 */
	public Integer getEu_verify_pharm() {
		return ((Integer) getAttrVal("Eu_verify_pharm"));
	}
	/**
	 * 审核状态
	 * @param Eu_verify_pharm
	 */
	public void setEu_verify_pharm(Integer Eu_verify_pharm) {
		setAttrVal("Eu_verify_pharm", Eu_verify_pharm);
	}
	/**
	 * 最近医嘱开时间
	 * @return FDateTime
	 */
	public FDateTime getMax_dt_entry() {
		return ((FDateTime) getAttrVal("Max_dt_entry"));
	}
	/**
	 * 最近医嘱开时间
	 * @param Max_dt_entry
	 */
	public void setMax_dt_entry(FDateTime Max_dt_entry) {
		setAttrVal("Max_dt_entry", Max_dt_entry);
	}
}