package iih.ci.ord.d.ems.ems;

/**
 * 医疗单保存信息
 * @author wangqingzhu
 *
 */
public class EmsSaveDTO extends EmsRstDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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
