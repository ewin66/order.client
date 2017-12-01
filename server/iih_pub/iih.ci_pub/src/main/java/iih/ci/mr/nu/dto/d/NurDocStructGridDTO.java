package iih.ci.mr.nu.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 护理文书结构化浏览医疗文书清单 DTO数据 
 * 
 */
public class NurDocStructGridDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医疗记录ID
	 * @return String
	 */
	public String getId_mr() {
		return ((String) getAttrVal("Id_mr"));
	}
	/**
	 * 医疗记录ID
	 * @param Id_mr
	 */
	public void setId_mr(String Id_mr) {
		setAttrVal("Id_mr", Id_mr);
	}
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
	 * 病区id
	 * @return String
	 */
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}
	/**
	 * 病区id
	 * @param Id_dep_nur
	 */
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	/**
	 * 病区
	 * @return String
	 */
	public String getName_dep_nur() {
		return ((String) getAttrVal("Name_dep_nur"));
	}
	/**
	 * 病区
	 * @param Name_dep_nur
	 */
	public void setName_dep_nur(String Name_dep_nur) {
		setAttrVal("Name_dep_nur", Name_dep_nur);
	}
	/**
	 * 床号id
	 * @return String
	 */
	public String getId_bed() {
		return ((String) getAttrVal("Id_bed"));
	}
	/**
	 * 床号id
	 * @param Id_bed
	 */
	public void setId_bed(String Id_bed) {
		setAttrVal("Id_bed", Id_bed);
	}
	/**
	 * 床号
	 * @return String
	 */
	public String getName_bed() {
		return ((String) getAttrVal("Name_bed"));
	}
	/**
	 * 床号
	 * @param Name_bed
	 */
	public void setName_bed(String Name_bed) {
		setAttrVal("Name_bed", Name_bed);
	}
	/**
	 * 医疗记录类型ID
	 * @return String
	 */
	public String getId_mrtp() {
		return ((String) getAttrVal("Id_mrtp"));
	}
	/**
	 * 医疗记录类型ID
	 * @param Id_mrtp
	 */
	public void setId_mrtp(String Id_mrtp) {
		setAttrVal("Id_mrtp", Id_mrtp);
	}
	/**
	 * 医疗记录类型自定义分类ID
	 * @return String
	 */
	public String getId_mrcactm() {
		return ((String) getAttrVal("Id_mrcactm"));
	}
	/**
	 * 医疗记录类型自定义分类ID
	 * @param Id_mrcactm
	 */
	public void setId_mrcactm(String Id_mrcactm) {
		setAttrVal("Id_mrcactm", Id_mrcactm);
	}
	/**
	 * 医疗记录类型
	 * @return String
	 */
	public String getName_mrtp() {
		return ((String) getAttrVal("Name_mrtp"));
	}
	/**
	 * 医疗记录类型
	 * @param Name_mrtp
	 */
	public void setName_mrtp(String Name_mrtp) {
		setAttrVal("Name_mrtp", Name_mrtp);
	}
	/**
	 * 医疗记录类型自定义分类
	 * @return String
	 */
	public String getName_mrcactm() {
		return ((String) getAttrVal("Name_mrcactm"));
	}
	/**
	 * 医疗记录类型自定义分类
	 * @param Name_mrcactm
	 */
	public void setName_mrcactm(String Name_mrcactm) {
		setAttrVal("Name_mrcactm", Name_mrcactm);
	}
	/**
	 * 医疗记录
	 * @return String
	 */
	public String getName_mr() {
		return ((String) getAttrVal("Name_mr"));
	}
	/**
	 * 医疗记录
	 * @param Name_mr
	 */
	public void setName_mr(String Name_mr) {
		setAttrVal("Name_mr", Name_mr);
	}
	/**
	 * 最后签署人ID
	 * @return String
	 */
	public String getId_emp_lat() {
		return ((String) getAttrVal("Id_emp_lat"));
	}
	/**
	 * 最后签署人ID
	 * @param Id_emp_lat
	 */
	public void setId_emp_lat(String Id_emp_lat) {
		setAttrVal("Id_emp_lat", Id_emp_lat);
	}
	/**
	 * 最后签署人
	 * @return String
	 */
	public String getName_emp_lat() {
		return ((String) getAttrVal("Name_emp_lat"));
	}
	/**
	 * 最后签署人
	 * @param Name_emp_lat
	 */
	public void setName_emp_lat(String Name_emp_lat) {
		setAttrVal("Name_emp_lat", Name_emp_lat);
	}
	/**
	 * 最后签署时间
	 * @return FDateTime
	 */
	public FDateTime getDt_sign_lat() {
		return ((FDateTime) getAttrVal("Dt_sign_lat"));
	}
	/**
	 * 最后签署时间
	 * @param Dt_sign_lat
	 */
	public void setDt_sign_lat(FDateTime Dt_sign_lat) {
		setAttrVal("Dt_sign_lat", Dt_sign_lat);
	}
}