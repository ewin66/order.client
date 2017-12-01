package iih.ci.ord.idvproperty.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 主键值对象 DTO数据 
 * 
 */
public class IdVProperty extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 系统主键
	 * @return String
	 */
	public String getId() {
		return ((String) getAttrVal("Id"));
	}
	/**
	 * 系统主键
	 * @param Id
	 */
	public void setId(String Id) {
		setAttrVal("Id", Id);
	}
	/**
	 * 系统版本
	 * @return FDateTime
	 */
	public FDateTime getVer() {
		return ((FDateTime) getAttrVal("Ver"));
	}
	/**
	 * 系统版本
	 * @param Ver
	 */
	public void setVer(FDateTime Ver) {
		setAttrVal("Ver", Ver);
	}
}