package iih.ci.ord.d.ems.ems;

import iih.ci.ord.d.ems.base.BaseCiDTO;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;

/**
 * 医疗单返回结果对象
 * @author wangqingzhu
 *
 */
public class EmsRstDTO extends BaseCiDTO {

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
	 * @param Id_or
	 */
	public void setEmsDriver(String EmsDriver) {
		setAttrVal("EmsDriver", EmsDriver);
	}
	
	
	
	/**
	 * 错误医嘱
	 * @return FArrayList
	 */
	public FArrayList getErrorEmsList() {
		return ((FArrayList) getAttrVal("ErrorEmsList"));
	}
	/**
	 * 错误医嘱
	 * @param ErrorEmsList
	 */
	public void setErrorEmsList(FArrayList ErrorEmsList) {
		setAttrVal("ErrorEmsList", ErrorEmsList);
	}
}
