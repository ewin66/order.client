package iih.ci.mr.cimrpatsigns.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 参数DTO DTO数据 
 * 
 */
public class Patparam extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}
	/**
	 * 就诊类型
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	/**
	 * 就诊状态
	 * @return String
	 */
	public String getSd_status() {
		return ((String) getAttrVal("Sd_status"));
	}
	/**
	 * 就诊状态
	 * @param Sd_status
	 */
	public void setSd_status(String Sd_status) {
		setAttrVal("Sd_status", Sd_status);
	}
	/**
	 * 当前科室
	 * @return String
	 */
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}
	/**
	 * 当前科室
	 * @param Id_dep_nur
	 */
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	/**
	 * 过滤类型
	 * @return String
	 */
	public String getWheretype() {
		return ((String) getAttrVal("Wheretype"));
	}
	/**
	 * 过滤类型
	 * @param Wheretype
	 */
	public void setWheretype(String Wheretype) {
		setAttrVal("Wheretype", Wheretype);
	}
	/**
	 * 过滤值
	 * @return String
	 */
	public String getValue() {
		return ((String) getAttrVal("Value"));
	}
	/**
	 * 过滤值
	 * @param Value
	 */
	public void setValue(String Value) {
		setAttrVal("Value", Value);
	}
	/**
	 * 测量日期
	 * @return FDate
	 */
	public FDate getMeasuredate() {
		return ((FDate) getAttrVal("Measuredate"));
	}
	/**
	 * 测量日期
	 * @param Measuredate
	 */
	public void setMeasuredate(FDate Measuredate) {
		setAttrVal("Measuredate", Measuredate);
	}
	/**
	 * 模板ID
	 * @return String
	 */
	public String getId_mrtplvt() {
		return ((String) getAttrVal("Id_mrtplvt"));
	}
	/**
	 * 模板ID
	 * @param Id_mrtplvt
	 */
	public void setId_mrtplvt(String Id_mrtplvt) {
		setAttrVal("Id_mrtplvt", Id_mrtplvt);
	}
}