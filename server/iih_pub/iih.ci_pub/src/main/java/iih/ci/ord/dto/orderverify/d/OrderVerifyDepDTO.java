package iih.ci.ord.dto.orderverify.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医嘱审核病区 DTO数据 
 * 
 */
public class OrderVerifyDepDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 病区id
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}
	/**
	 * 病区id
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 病区名称
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}
	/**
	 * 病区名称
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 医嘱数量
	 * @return Integer
	 */
	public Integer getOrder_num() {
		return ((Integer) getAttrVal("Order_num"));
	}
	/**
	 * 医嘱数量
	 * @param Order_num
	 */
	public void setOrder_num(Integer Order_num) {
		setAttrVal("Order_num", Order_num);
	}
}