package iih.ci.ord.ciordems.d.ext;

import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.FArrayList;

public class CheckRstDTO extends BaseDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 医疗单类型
	 * @return String
	 */
	public String getEmsDriver() {
		return ((String) getAttrVal("EmsDriver"));
	}
	/**
	 * 医疗单类型
	 * @param EmsDriver
	 */
	public void setEmsDriver(String EmsDriver) {
		setAttrVal("EmsDriver", EmsDriver);
	}
	/**
	 * 服务类型
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}
	/**
	 *服务类型
	 * @param Id_srv
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}

	/**
	 * 返回信息集合
	 * @return FArrayList
	 */
	public FArrayList getRtnMsgList() {
		return ((FArrayList) getAttrVal("RtnMsgList"));
	}
	/**
	 * 返回信息集合
	 * @param RtnMsgList
	 */
	public void setRtnMsgList(FArrayList RtnMsgList) {
		setAttrVal("RtnMsgList", RtnMsgList);
	}
}
