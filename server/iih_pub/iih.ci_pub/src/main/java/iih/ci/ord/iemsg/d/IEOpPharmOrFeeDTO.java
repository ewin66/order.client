package iih.ci.ord.iemsg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * IE门诊已收费处方信息 DTO数据 
 * 
 */
public class IEOpPharmOrFeeDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * IE药品医嘱就诊主键标识
	 * @return String
	 */
	public String getId_iepharmoren() {
		return ((String) getAttrVal("Id_iepharmoren"));
	}	
	/**
	 * IE药品医嘱就诊主键标识
	 * @param Id_iepharmoren
	 */
	public void setId_iepharmoren(String Id_iepharmoren) {
		setAttrVal("Id_iepharmoren", Id_iepharmoren);
	}
	/**
	 * IE药品已收费主键标识
	 * @return String
	 */
	public String getId_iepharmfee() {
		return ((String) getAttrVal("Id_iepharmfee"));
	}	
	/**
	 * IE药品已收费主键标识
	 * @param Id_iepharmfee
	 */
	public void setId_iepharmfee(String Id_iepharmfee) {
		setAttrVal("Id_iepharmfee", Id_iepharmfee);
	}
	/**
	 * 已收费处方号
	 * @return String
	 */
	public String getOrderno() {
		return ((String) getAttrVal("Orderno"));
	}	
	/**
	 * 已收费处方号
	 * @param Orderno
	 */
	public void setOrderno(String Orderno) {
		setAttrVal("Orderno", Orderno);
	}
	/**
	 * 处方类别编码
	 * @return String
	 */
	public String getOrdertypecode() {
		return ((String) getAttrVal("Ordertypecode"));
	}	
	/**
	 * 处方类别编码
	 * @param Ordertypecode
	 */
	public void setOrdertypecode(String Ordertypecode) {
		setAttrVal("Ordertypecode", Ordertypecode);
	}
	/**
	 * 处方类别名称
	 * @return String
	 */
	public String getOrdertypename() {
		return ((String) getAttrVal("Ordertypename"));
	}	
	/**
	 * 处方类别名称
	 * @param Ordertypename
	 */
	public void setOrdertypename(String Ordertypename) {
		setAttrVal("Ordertypename", Ordertypename);
	}
}