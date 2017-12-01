package iih.ci.ord.splitlis.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 检验申请单对应的医嘱 DTO数据 
 * 
 */
public class LisOrderItemDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 检验医嘱主键
	 * @return String
	 */
	public String getId_lisorderitem() {
		return ((String) getAttrVal("Id_lisorderitem"));
	}
	/**
	 * 检验医嘱主键
	 * @param Id_lisorderitem
	 */
	public void setId_lisorderitem(String Id_lisorderitem) {
		setAttrVal("Id_lisorderitem", Id_lisorderitem);
	}
	/**
	 * 检验申请单对应的医嘱申请主键标识
	 * @return String
	 */
	public String getId_ciapplissheetor() {
		return ((String) getAttrVal("Id_ciapplissheetor"));
	}
	/**
	 * 检验申请单对应的医嘱申请主键标识
	 * @param Id_ciapplissheetor
	 */
	public void setId_ciapplissheetor(String Id_ciapplissheetor) {
		setAttrVal("Id_ciapplissheetor", Id_ciapplissheetor);
	}
	/**
	 * 检验申请单
	 * @return String
	 */
	public String getId_ciapplissheet() {
		return ((String) getAttrVal("Id_ciapplissheet"));
	}
	/**
	 * 检验申请单
	 * @param Id_ciapplissheet
	 */
	public void setId_ciapplissheet(String Id_ciapplissheet) {
		setAttrVal("Id_ciapplissheet", Id_ciapplissheet);
	}
	/**
	 * 对应医嘱检验申请
	 * @return String
	 */
	public String getId_orlab() {
		return ((String) getAttrVal("Id_orlab"));
	}
	/**
	 * 对应医嘱检验申请
	 * @param Id_orlab
	 */
	public void setId_orlab(String Id_orlab) {
		setAttrVal("Id_orlab", Id_orlab);
	}
	/**
	 * 对应医嘱
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 对应医嘱
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 对应申请金额
	 * @return FDouble
	 */
	public FDouble getAmt_app() {
		return ((FDouble) getAttrVal("Amt_app"));
	}
	/**
	 * 对应申请金额
	 * @param Amt_app
	 */
	public void setAmt_app(FDouble Amt_app) {
		setAttrVal("Amt_app", Amt_app);
	}
	/**
	 * 检验合单
	 * @return String
	 */
	public String getId_lisordsplit() {
		return ((String) getAttrVal("Id_lisordsplit"));
	}
	/**
	 * 检验合单
	 * @param Id_lisordsplit
	 */
	public void setId_lisordsplit(String Id_lisordsplit) {
		setAttrVal("Id_lisordsplit", Id_lisordsplit);
	}
}