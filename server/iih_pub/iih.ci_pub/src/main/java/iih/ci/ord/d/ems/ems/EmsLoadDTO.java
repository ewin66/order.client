package iih.ci.ord.d.ems.ems;

import iih.ci.ord.d.ems.base.BaseCiDTO;

public class EmsLoadDTO extends BaseCiDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 医疗单主服务id
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医疗单主服务id
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 医疗单驱动
	 * @return String
	 */
	public String getEmsDriver() {
		return ((String) getAttrVal("EmsDriver"));
	}
	/**
	 * 医疗单驱动
	 * @param mainSrv
	 */
	public void setEmsDriver(String EmsDriver) {
		setAttrVal("EmsDriver", EmsDriver);
	}
	
	

	
}
