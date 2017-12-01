package iih.ci.ord.dto.ordrationaldrugdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 合理用药数据对象 DTO数据 
 * 
 */
public class OrdRationalDrugDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * 签署标识
	 * @return FBoolean
	 */
	public FBoolean getFg_sign() {
		return ((FBoolean) getAttrVal("Fg_sign"));
	}
	/**
	 * 签署标识
	 * @param Fg_sign
	 */
	public void setFg_sign(FBoolean Fg_sign) {
		setAttrVal("Fg_sign", Fg_sign);
	}
	/**
	 * 组号
	 * @return String
	 */
	public String getGroup_number() {
		return ((String) getAttrVal("Group_number"));
	}
	/**
	 * 组号
	 * @param Group_number
	 */
	public void setGroup_number(String Group_number) {
		setAttrVal("Group_number", Group_number);
	}
	/**
	 * 服务主键
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 服务主键
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 服务名
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}
	/**
	 * 服务名
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	/**
	 * 医嘱服务物品主键标识
	 * @return String
	 */
	public String getId_orsrvmm() {
		return ((String) getAttrVal("Id_orsrvmm"));
	}
	/**
	 * 医嘱服务物品主键标识
	 * @param Id_orsrvmm
	 */
	public void setId_orsrvmm(String Id_orsrvmm) {
		setAttrVal("Id_orsrvmm", Id_orsrvmm);
	}
	/**
	 * 物品编码
	 * @return String
	 */
	public String getCode_mm() {
		return ((String) getAttrVal("Code_mm"));
	}
	/**
	 * 物品编码
	 * @param Code_mm
	 */
	public void setCode_mm(String Code_mm) {
		setAttrVal("Code_mm", Code_mm);
	}
	/**
	 * 物品名称
	 * @return String
	 */
	public String getName_mm() {
		return ((String) getAttrVal("Name_mm"));
	}
	/**
	 * 物品名称
	 * @param Name_mm
	 */
	public void setName_mm(String Name_mm) {
		setAttrVal("Name_mm", Name_mm);
	}
	/**
	 * 医疗用法主键标识
	 * @return String
	 */
	public String getId_route() {
		return ((String) getAttrVal("Id_route"));
	}
	/**
	 * 医疗用法主键标识
	 * @param Id_route
	 */
	public void setId_route(String Id_route) {
		setAttrVal("Id_route", Id_route);
	}
	/**
	 * 用法编码
	 * @return String
	 */
	public String getRoute_code() {
		return ((String) getAttrVal("Route_code"));
	}
	/**
	 * 用法编码
	 * @param Route_name
	 */
	public void setRoute_code(String Route_code) {
		setAttrVal("Route_code", Route_code);
	}
	/**
	 * 用法名称
	 * @return String
	 */
	public String getRoute_name() {
		return ((String) getAttrVal("Route_name"));
	}
	/**
	 * 用法名称
	 * @param Route_name
	 */
	public void setRoute_name(String Route_name) {
		setAttrVal("Route_name", Route_name);
	}
	/**
	 * 医嘱天数
	 * @return String
	 */
	public String getDays_or() {
		return ((String) getAttrVal("Days_or"));
	}
	/**
	 * 医嘱天数
	 * @param Days_or
	 */
	public void setDays_or(String Days_or) {
		setAttrVal("Days_or", Days_or);
	}
	/**
	 * 医嘱频次
	 * @return String
	 */
	public String getId_freq() {
		return ((String) getAttrVal("Id_freq"));
	}
	/**
	 * 医嘱频次
	 * @param Id_freq
	 */
	public void setId_freq(String Id_freq) {
		setAttrVal("Id_freq", Id_freq);
	}
	/**
	 * 频次编码
	 * @return String
	 */
	public String getFreq_code() {
		return ((String) getAttrVal("Freq_code"));
	}
	/**
	 * 频次编码
	 * @param Freq_code
	 */
	public void setFreq_code(String Freq_code) {
		setAttrVal("Freq_code", Freq_code);
	}
	/**
	 * 频次名称
	 * @return String
	 */
	public String getFreq_name() {
		return ((String) getAttrVal("Freq_name"));
	}
	/**
	 * 频次名称
	 * @param Freq_name
	 */
	public void setFreq_name(String Freq_name) {
		setAttrVal("Freq_name", Freq_name);
	}
	/**
	 * 用量
	 * @return String
	 */
	public String getQuan_medu() {
		return ((String) getAttrVal("Quan_medu"));
	}
	/**
	 * 用量
	 * @param Quan_medu
	 */
	public void setQuan_medu(String Quan_medu) {
		setAttrVal("Quan_medu", Quan_medu);
	}
	/**
	 * 医疗单位
	 * @return String
	 */
	public String getId_medu() {
		return ((String) getAttrVal("Id_medu"));
	}
	/**
	 * 医疗单位
	 * @param Id_medu
	 */
	public void setId_medu(String Id_medu) {
		setAttrVal("Id_medu", Id_medu);
	}
	/**
	 * 计量单位编码
	 * @return String
	 */
	public String getMedu_code() {
		return ((String) getAttrVal("Medu_code"));
	}
	/**
	 * 计量单位编码
	 * @param Medu_code
	 */
	public void setMedu_code(String Medu_code) {
		setAttrVal("Medu_code", Medu_code);
	}
	/**
	 * 计量单位名称
	 * @return String
	 */
	public String getMedu_name() {
		return ((String) getAttrVal("Medu_name"));
	}
	/**
	 * 计量单位名称
	 * @param Medu_name
	 */
	public void setMedu_name(String Medu_name) {
		setAttrVal("Medu_name", Medu_name);
	}
}