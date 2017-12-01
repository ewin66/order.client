package iih.ci.ord.ciordems.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;

public class OrCommonFieldsDTO extends BaseDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 总次数
	 * @return Integer
	 */
	public Integer getTimes_cur() {
		return ((Integer) getAttrVal("Times_cur"));
	}
	/**
	 * 总次数
	 * @param Times_cur
	 */
	public void setTimes_cur(Integer Times_cur) {
		setAttrVal("Times_cur", Times_cur);
	}
	
	/**
	 * 使用天数
	 * @return Integer
	 */
	public Integer getUse_days() {
		return ((Integer) getAttrVal("Use_days"));
	}
	/**
	 * 使用天数
	 * @param Use_days
	 */
	public void setUse_days(Integer Use_days) {
		setAttrVal("Use_days", Use_days);
	}
	
	/**
	 * 开始时间
	 * @return Integer
	 */
	public FDateTime getDt_begin_ui() {
		return ((FDateTime) getAttrVal("Dt_begin_ui"));
	}
	/**
	 * 开始时间
	 * @param Dt_begin_ui
	 */
	public void setDt_begin_ui(FDateTime Dt_begin_ui) {
		setAttrVal("Dt_begin_ui", Dt_begin_ui);
	}
	
	/**
	 * 结束时间
	 * @return Integer
	 */
	public FDateTime getDt_end_ui() {
		return ((FDateTime) getAttrVal("Dt_end_ui"));
	}
	/**
	 * 结束时间
	 * @param Dt_end_ui
	 */
	public void setDt_end_ui(FDateTime Dt_end_ui) {
		setAttrVal("Dt_end_ui", Dt_end_ui);
	}
	
	/**
	 * 在院执行次数
	 * @return Integer
	 */
	public Integer getTimes_mp_in() {
		return ((Integer) getAttrVal("Times_mp_in"));
	}
	/**
	 * 在院执行次数
	 * @param Times_mp_in
	 */
	public void setTimes_mp_in(Integer Times_mp_in) {
		setAttrVal("Times_mp_in", Times_mp_in);
	}
	
	/**
	 * 标准价
	 * @return FDouble
	 */
	public FDouble getPri_std() {
		return ((FDouble) getAttrVal("Pri_std"));
	}	
	/**
	 * 标准价
	 * @param Pri_std
	 */
	public void setPri_std(FDouble Pri_std) {
		setAttrVal("Pri_std", Pri_std);
	}
	/**
	 * 价格系数
	 * @return FDouble
	 */
	public FDouble getPri_ratio() {
		return ((FDouble) getAttrVal("Pri_ratio"));
	}	
	/**
	 * 价格系数
	 * @param Pri_ratio
	 */
	public void setPri_ratio(FDouble Pri_ratio) {
		setAttrVal("Pri_ratio", Pri_ratio);
	}
	/**
	 * 患者价格分类
	 * @return String
	 */
	public String getId_pripat() {
		return ((String) getAttrVal("Id_pripat"));
	}	
	/**
	 * 患者价格分类
	 * @param Id_pripat
	 */
	public void setId_pripat(String Id_pripat) {
		setAttrVal("Id_pripat", Id_pripat);
	}
	/**
	 * 申请单号
	 * @return
	 */
	public String getApplyno() {
		return ((String) getAttrVal("Applyno"));
	}	
	/**
	 * 申请单号
	 * @param Applyno
	 */
	public void setApplyno(String Applyno) {
		setAttrVal("Applyno", Applyno);
	}
	/**
	 * 医疗单URL
	 * @return
	 */
	public String getFuncclassstr() {
		return ((String) getAttrVal("Funcclassstr"));
	}	
	/**
	 * 医疗单URL
	 * @param Funcclassstr
	 */
	public void setFuncclassstr(String Funcclassstr) {
		setAttrVal("Funcclassstr", Funcclassstr);
	}
	/**
	 * 医疗单id
	 * @return
	 */
	public String getId_srvof() {
		return ((String) getAttrVal("Id_srvof"));
	}	
	/**
	 * 医疗单id
	 * @param Id_srvof
	 */
	public void setId_srvof(String Id_srvof) {
		setAttrVal("Id_srvof", Id_srvof);
	}
	/**
	 * 医嘱来源方式类型
	 * @return
	 */
	public String getEu_orsrcmdtp() {
		return ((String) getAttrVal("Eu_orsrcmdtp"));
	}	
	/**
	 * 医嘱来源方式类型
	 * @param Eu_orsrcmdtp
	 */
	public void setEu_orsrcmdtp(String Eu_orsrcmdtp) {
		setAttrVal("Eu_orsrcmdtp", Eu_orsrcmdtp);
	}
	/**
	 * 简化的流程标识
	 * @return
	 */
	public FBoolean getFg_quickwflow() {
		return ((FBoolean) getAttrVal("Fg_quickwflow"));
	}	
	/**
	 * 简化的流程标识
	 * @param Fg_quickwflow
	 */
	public void setFg_quickwflow(FBoolean Fg_quickwflow) {
		setAttrVal("Fg_quickwflow", Fg_quickwflow);
	}
}
