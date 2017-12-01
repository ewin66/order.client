package iih.ci.ord.emsdi.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 构建医疗单数据时医嘱参数DTO DTO数据 
 * 
 */
public class CiOr4EmsDiDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 临床医嘱
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 临床医嘱
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
}