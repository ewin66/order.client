package iih.ci.ord.dto.ems.uiemsdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 西药医疗单主 DTO数据 
 * 
 */
public class EmsDrugsViewDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱ID
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱ID
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 服务ID
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 服务ID
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 处置项目
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}
	/**
	 * 处置项目
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	/**
	 * 服务类型
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}
	/**
	 * 服务类型
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 频次ID
	 * @return String
	 */
	public String getId_freq() {
		return ((String) getAttrVal("Id_freq"));
	}
	/**
	 * 频次ID
	 * @param Id_freq
	 */
	public void setId_freq(String Id_freq) {
		setAttrVal("Id_freq", Id_freq);
	}
	/**
	 * 频次
	 * @return String
	 */
	public String getName_freq() {
		return ((String) getAttrVal("Name_freq"));
	}
	/**
	 * 频次
	 * @param Name_freq
	 */
	public void setName_freq(String Name_freq) {
		setAttrVal("Name_freq", Name_freq);
	}
	/**
	 * 频次数量
	 * @return String
	 */
	public String getFreqct() {
		return ((String) getAttrVal("Freqct"));
	}
	/**
	 * 频次数量
	 * @param Freqct
	 */
	public void setFreqct(String Freqct) {
		setAttrVal("Freqct", Freqct);
	}
	/**
	 * 用法要求ID
	 * @return String
	 */
	public String getId_routedes() {
		return ((String) getAttrVal("Id_routedes"));
	}
	/**
	 * 用法要求ID
	 * @param Id_routedes
	 */
	public void setId_routedes(String Id_routedes) {
		setAttrVal("Id_routedes", Id_routedes);
	}
	/**
	 * 用法要求
	 * @return String
	 */
	public String getName_routedes() {
		return ((String) getAttrVal("Name_routedes"));
	}
	/**
	 * 用法要求
	 * @param Name_routedes
	 */
	public void setName_routedes(String Name_routedes) {
		setAttrVal("Name_routedes", Name_routedes);
	}
	/**
	 * 处置周期
	 * @return String
	 */
	public String getUsedays() {
		return ((String) getAttrVal("Usedays"));
	}
	/**
	 * 处置周期
	 * @param Usedays
	 */
	public void setUsedays(String Usedays) {
		setAttrVal("Usedays", Usedays);
	}
	/**
	 * 在院执行标识
	 * @return FBoolean
	 */
	public FBoolean getFg_times_in() {
		return ((FBoolean) getAttrVal("Fg_times_in"));
	}
	/**
	 * 在院执行标识
	 * @param Fg_times_in
	 */
	public void setFg_times_in(FBoolean Fg_times_in) {
		setAttrVal("Fg_times_in", Fg_times_in);
	}
	/**
	 * 在院执行次数
	 * @return String
	 */
	public String getTimes_in() {
		return ((String) getAttrVal("Times_in"));
	}
	/**
	 * 在院执行次数
	 * @param Times_in
	 */
	public void setTimes_in(String Times_in) {
		setAttrVal("Times_in", Times_in);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getDes_or() {
		return ((String) getAttrVal("Des_or"));
	}
	/**
	 * 备注
	 * @param Des_or
	 */
	public void setDes_or(String Des_or) {
		setAttrVal("Des_or", Des_or);
	}
	/**
	 * sv
	 * @return String
	 */
	public String getSv() {
		return ((String) getAttrVal("Sv"));
	}
	/**
	 * sv
	 * @param Sv
	 */
	public void setSv(String Sv) {
		setAttrVal("Sv", Sv);
	}
	/**
	 * 次数
	 * @return Integer
	 */
	public Integer getTimes_cur() {
		return ((Integer) getAttrVal("Times_cur"));
	}
	/**
	 * 次数
	 * @param Times_cur
	 */
	public void setTimes_cur(Integer Times_cur) {
		setAttrVal("Times_cur", Times_cur);
	}
	/**
	 * 领量
	 * @return Integer
	 */
	public Integer getAvailabledays() {
		return ((Integer) getAttrVal("Availabledays"));
	}
	/**
	 * 领量
	 * @param Availabledays
	 */
	public void setAvailabledays(Integer Availabledays) {
		setAttrVal("Availabledays", Availabledays);
	}
	/**
	 * 西药药品
	 * @return FArrayList
	 */
	public FArrayList getEmsdrugsviewitems() {
		return ((FArrayList) getAttrVal("Emsdrugsviewitems"));
	}
	/**
	 * 西药药品
	 * @param Emsdrugsviewitems
	 */
	public void setEmsdrugsviewitems(FArrayList Emsdrugsviewitems) {
		setAttrVal("Emsdrugsviewitems", Emsdrugsviewitems);
	}
}