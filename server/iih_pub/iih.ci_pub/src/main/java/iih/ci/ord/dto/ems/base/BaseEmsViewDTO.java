package iih.ci.ord.dto.ems.base;

import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FDouble;

/**
 * 医疗单UI模型基类
 * @author wangqingzhu
 *
 */
public class BaseEmsViewDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1370663428572001843L;
	
	public BaseEmsViewDTO(){
		this.setStatus(DOStatus.NEW);
	}

	/**
	 * 医疗单ID
	 * @return String
	 */
	public String getId_ems() {
		return ((String) getAttrVal("Id_ems"));
	}
	/**
	 * 医疗单ID
	 * @param Id_ems
	 */
	public void setId_ems(String Id_ems) {
		setAttrVal("Id_ems", Id_ems);
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
	 * @param EmsDriver
	 */
	public void setEmsDriver(String EmsDriver) {
		setAttrVal("EmsDriver", EmsDriver);
	}
	
	/**
	 * 单价 - 标准价
	 * @return FDouble
	 */
	public FDouble getPrice_std() {
		return ((FDouble) getAttrVal("Price_std"));
	}
	/**
	 * 单价- 标准价
	 * @param Price
	 */
	public void setPrice_std(FDouble Price_std) {
		setAttrVal("Price_std", Price_std);
	}
	
	/**
	 * 单价 - 折扣系数
	 * @return FDouble
	 */
	public FDouble getPrice_ratio() {
		return ((FDouble) getAttrVal("Price_ratio"));
	}
	/**
	 * 单价- 折扣系数
	 * @param Price
	 */
	public void setPrice_ratio(FDouble Price_ratio) {
		setAttrVal("Price_ratio", Price_ratio);
	}
}
