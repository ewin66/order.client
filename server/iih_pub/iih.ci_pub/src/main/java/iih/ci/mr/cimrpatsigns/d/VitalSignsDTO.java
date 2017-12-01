package iih.ci.mr.cimrpatsigns.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 实体 DTO数据 
 * 
 */
public class VitalSignsDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 就诊id
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊id
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
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
	 * 呼吸
	 * @return String
	 */
	public String getBreathing() {
		return ((String) getAttrVal("Breathing"));
	}
	/**
	 * 呼吸
	 * @param Breathing
	 */
	public void setBreathing(String Breathing) {
		setAttrVal("Breathing", Breathing);
	}
	/**
	 * 收缩压
	 * @return String
	 */
	public String getSystolicbloodpressure() {
		return ((String) getAttrVal("Systolicbloodpressure"));
	}
	/**
	 * 收缩压
	 * @param Systolicbloodpressure
	 */
	public void setSystolicbloodpressure(String Systolicbloodpressure) {
		setAttrVal("Systolicbloodpressure", Systolicbloodpressure);
	}
	/**
	 * 舒张压
	 * @return String
	 */
	public String getDiastolicbloodpressure() {
		return ((String) getAttrVal("Diastolicbloodpressure"));
	}
	/**
	 * 舒张压
	 * @param Diastolicbloodpressure
	 */
	public void setDiastolicbloodpressure(String Diastolicbloodpressure) {
		setAttrVal("Diastolicbloodpressure", Diastolicbloodpressure);
	}
}