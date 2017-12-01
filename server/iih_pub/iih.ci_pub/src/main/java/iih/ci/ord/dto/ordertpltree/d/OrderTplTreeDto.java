package iih.ci.ord.dto.ordertpltree.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医嘱助手模板树 DTO数据 
 * 
 */
public class OrderTplTreeDto extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 * @return String
	 */
	public String getId() {
		return ((String) getAttrVal("Id"));
	}
	/**
	 * 主键
	 * @param Id
	 */
	public void setId(String Id) {
		setAttrVal("Id", Id);
	}
	/**
	 * 父编码
	 * @return String
	 */
	public String getParent() {
		return ((String) getAttrVal("Parent"));
	}
	/**
	 * 父编码
	 * @param Parent
	 */
	public void setParent(String Parent) {
		setAttrVal("Parent", Parent);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getNm() {
		return ((String) getAttrVal("Nm"));
	}
	/**
	 * 名称
	 * @param Nm
	 */
	public void setNm(String Nm) {
		setAttrVal("Nm", Nm);
	}
}