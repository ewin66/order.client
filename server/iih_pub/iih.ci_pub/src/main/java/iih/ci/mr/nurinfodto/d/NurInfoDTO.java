package iih.ci.mr.nurinfodto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 护士信息DTO DTO数据 
 * 
 */
public class NurInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 护士编码
	 * @return String
	 */
	public String getCode_nur() {
		return ((String) getAttrVal("Code_nur"));
	}
	/**
	 * 护士编码
	 * @param Code_nur
	 */
	public void setCode_nur(String Code_nur) {
		setAttrVal("Code_nur", Code_nur);
	}
	/**
	 * 护士名称
	 * @return String
	 */
	public String getNur() {
		return ((String) getAttrVal("Nur"));
	}
	/**
	 * 护士名称
	 * @param Nur
	 */
	public void setNur(String Nur) {
		setAttrVal("Nur", Nur);
	}
}