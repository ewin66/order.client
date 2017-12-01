package iih.ci.mr.cimrpatsigns.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医疗记录历史记录信息 DTO数据 
 * 
 */
public class CiMrHisDataDTO extends BaseDTO {
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
	 * 体征测量主表ID
	 * @return String
	 */
	public String getId_mrvt() {
		return ((String) getAttrVal("Id_mrvt"));
	}
	/**
	 * 体征测量主表ID
	 * @param Id_mrvt
	 */
	public void setId_mrvt(String Id_mrvt) {
		setAttrVal("Id_mrvt", Id_mrvt);
	}
	/**
	 * 体征测量项目ID
	 * @return String
	 */
	public String getId_mrvtitm() {
		return ((String) getAttrVal("Id_mrvtitm"));
	}
	/**
	 * 体征测量项目ID
	 * @param Id_mrvtitm
	 */
	public void setId_mrvtitm(String Id_mrvtitm) {
		setAttrVal("Id_mrvtitm", Id_mrvtitm);
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
	 * 测量单ID
	 * @return String
	 */
	public String getId_mrtplvt() {
		return ((String) getAttrVal("Id_mrtplvt"));
	}
	/**
	 * 测量单ID
	 * @param Id_mrtplvt
	 */
	public void setId_mrtplvt(String Id_mrtplvt) {
		setAttrVal("Id_mrtplvt", Id_mrtplvt);
	}
	/**
	 * 测量时间
	 * @return FDateTime
	 */
	public FDateTime getDt_vt() {
		return ((FDateTime) getAttrVal("Dt_vt"));
	}
	/**
	 * 测量时间
	 * @param Dt_vt
	 */
	public void setDt_vt(FDateTime Dt_vt) {
		setAttrVal("Dt_vt", Dt_vt);
	}
	/**
	 * 测量项目ID
	 * @return String
	 */
	public String getId_mrtplvtitm() {
		return ((String) getAttrVal("Id_mrtplvtitm"));
	}
	/**
	 * 测量项目ID
	 * @param Id_mrtplvtitm
	 */
	public void setId_mrtplvtitm(String Id_mrtplvtitm) {
		setAttrVal("Id_mrtplvtitm", Id_mrtplvtitm);
	}
	/**
	 * 测量部位
	 * @return String
	 */
	public String getId_vt_pos() {
		return ((String) getAttrVal("Id_vt_pos"));
	}
	/**
	 * 测量部位
	 * @param Id_vt_pos
	 */
	public void setId_vt_pos(String Id_vt_pos) {
		setAttrVal("Id_vt_pos", Id_vt_pos);
	}
	/**
	 * 辅助措施
	 * @return String
	 */
	public String getId_vt_aux() {
		return ((String) getAttrVal("Id_vt_aux"));
	}
	/**
	 * 辅助措施
	 * @param Id_vt_aux
	 */
	public void setId_vt_aux(String Id_vt_aux) {
		setAttrVal("Id_vt_aux", Id_vt_aux);
	}
	/**
	 * 值
	 * @return String
	 */
	public String getValue() {
		return ((String) getAttrVal("Value"));
	}
	/**
	 * 值
	 * @param Value
	 */
	public void setValue(String Value) {
		setAttrVal("Value", Value);
	}
	/**
	 * 值1
	 * @return String
	 */
	public String getValue1() {
		return ((String) getAttrVal("Value1"));
	}
	/**
	 * 值1
	 * @param Value1
	 */
	public void setValue1(String Value1) {
		setAttrVal("Value1", Value1);
	}
	/**
	 * 值2
	 * @return String
	 */
	public String getValue2() {
		return ((String) getAttrVal("Value2"));
	}
	/**
	 * 值2
	 * @param Value2
	 */
	public void setValue2(String Value2) {
		setAttrVal("Value2", Value2);
	}
	/**
	 * 值3
	 * @return String
	 */
	public String getValue3() {
		return ((String) getAttrVal("Value3"));
	}
	/**
	 * 值3
	 * @param Value3
	 */
	public void setValue3(String Value3) {
		setAttrVal("Value3", Value3);
	}
	/**
	 * 体征/事件编码
	 * @return String
	 */
	public String getTypecode() {
		return ((String) getAttrVal("Typecode"));
	}
	/**
	 * 体征/事件编码
	 * @param Typecode
	 */
	public void setTypecode(String Typecode) {
		setAttrVal("Typecode", Typecode);
	}
	/**
	 * 生命体征属性主键
	 * @return String
	 */
	public String getId_srvvt() {
		return ((String) getAttrVal("Id_srvvt"));
	}
	/**
	 * 生命体征属性主键
	 * @param Id_srvvt
	 */
	public void setId_srvvt(String Id_srvvt) {
		setAttrVal("Id_srvvt", Id_srvvt);
	}
}