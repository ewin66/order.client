package iih.ci.ord.ciordems.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 实体 DTO数据 
 * 
 */
public class EmsFeesDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 服务类别名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 服务类别名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 金额合计
	 * @return FDouble
	 */
	public FDouble getAllfees() {
		return ((FDouble) getAttrVal("Allfees"));
	}
	/**
	 * 金额合计
	 * @param Allfees
	 */
	public void setAllfees(FDouble Allfees) {
		setAttrVal("Allfees", Allfees);
	}
	/**
	 * 已缴费金额
	 * @return FDouble
	 */
	public FDouble getHaspay() {
		return ((FDouble) getAttrVal("Haspay"));
	}
	/**
	 * 已缴费金额
	 * @param Haspay
	 */
	public void setHaspay(FDouble Haspay) {
		setAttrVal("Haspay", Haspay);
	}
	/**
	 * 未缴费
	 * @return FDouble
	 */
	public FDouble getNopay() {
		return ((FDouble) getAttrVal("Nopay"));
	}
	/**
	 * 未缴费
	 * @param Nopay
	 */
	public void setNopay(FDouble Nopay) {
		setAttrVal("Nopay", Nopay);
	}
}