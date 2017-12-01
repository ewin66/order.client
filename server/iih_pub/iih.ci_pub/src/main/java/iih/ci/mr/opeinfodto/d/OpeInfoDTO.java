package iih.ci.mr.opeinfodto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 术者信息DTO DTO数据 
 * 
 */
public class OpeInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 术者编码
	 * @return String
	 */
	public String getCode_ope() {
		return ((String) getAttrVal("Code_ope"));
	}
	/**
	 * 术者编码
	 * @param Code_ope
	 */
	public void setCode_ope(String Code_ope) {
		setAttrVal("Code_ope", Code_ope);
	}
	/**
	 * 术者名称
	 * @return String
	 */
	public String getOpe() {
		return ((String) getAttrVal("Ope"));
	}
	/**
	 * 术者名称
	 * @param Ope
	 */
	public void setOpe(String Ope) {
		setAttrVal("Ope", Ope);
	}
}