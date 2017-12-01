package iih.ci.ord.dto.vitalsignsdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 生命体征显示 DTO数据 
 * 
 */
public class VitalSignsDto extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 * @return String
	 */
	public String getId() {
		return ((String) getAttrVal("Id"));
	}
	/**
	 * 主键
	 * @param Id
	 */
	public void setId(String Id) {
		setAttrVal("Id", Id);
	}
	/**
	 * 体温
	 * @return String
	 */
	public String getTemperature() {
		return ((String) getAttrVal("Temperature"));
	}
	/**
	 * 体温
	 * @param Temperature
	 */
	public void setTemperature(String Temperature) {
		setAttrVal("Temperature", Temperature);
	}
	/**
	 * 呼吸
	 * @return String
	 */
	public String getBreath() {
		return ((String) getAttrVal("Breath"));
	}
	/**
	 * 呼吸
	 * @param Breath
	 */
	public void setBreath(String Breath) {
		setAttrVal("Breath", Breath);
	}
	/**
	 * 脉搏
	 * @return String
	 */
	public String getPulse() {
		return ((String) getAttrVal("Pulse"));
	}
	/**
	 * 脉搏
	 * @param Pulse
	 */
	public void setPulse(String Pulse) {
		setAttrVal("Pulse", Pulse);
	}
	/**
	 * 血压低
	 * @return String
	 */
	public String getBpmin() {
		return ((String) getAttrVal("Bpmin"));
	}
	/**
	 * 血压低
	 * @param Bpmin
	 */
	public void setBpmin(String Bpmin) {
		setAttrVal("Bpmin", Bpmin);
	}
	/**
	 * 血压高
	 * @return String
	 */
	public String getBpmax() {
		return ((String) getAttrVal("Bpmax"));
	}
	/**
	 * 血压高
	 * @param Bpmax
	 */
	public void setBpmax(String Bpmax) {
		setAttrVal("Bpmax", Bpmax);
	}
	/**
	 * 心率
	 * @return String
	 */
	public String getHeart_rate() {
		return ((String) getAttrVal("Heart_rate"));
	}
	/**
	 * 心率
	 * @param Heart_rate
	 */
	public void setHeart_rate(String Heart_rate) {
		setAttrVal("Heart_rate", Heart_rate);
	}
	/**
	 * 体重
	 * @return String
	 */
	public String getWeight() {
		return ((String) getAttrVal("Weight"));
	}
	/**
	 * 体重
	 * @param Weight
	 */
	public void setWeight(String Weight) {
		setAttrVal("Weight", Weight);
	}
	/**
	 * 补充信息
	 * @return FMap2
	 */
	public FMap2 getInfomap() {
		return ((FMap2) getAttrVal("Infomap"));
	}
	/**
	 * 补充信息
	 * @param Infomap
	 */
	public void setInfomap(FMap2 Infomap) {
		setAttrVal("Infomap", Infomap);
	}
}