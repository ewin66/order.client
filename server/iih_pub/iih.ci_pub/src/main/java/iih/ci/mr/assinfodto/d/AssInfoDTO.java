package iih.ci.mr.assinfodto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 助手信息DTO DTO数据 
 * 
 */
public class AssInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 助手编码
	 * @return String
	 */
	public String getCode_ass() {
		return ((String) getAttrVal("Code_ass"));
	}
	/**
	 * 助手编码
	 * @param Code_ass
	 */
	public void setCode_ass(String Code_ass) {
		setAttrVal("Code_ass", Code_ass);
	}
	/**
	 * 助手名称
	 * @return String
	 */
	public String getAss() {
		return ((String) getAttrVal("Ass"));
	}
	/**
	 * 助手名称
	 * @param Ass
	 */
	public void setAss(String Ass) {
		setAttrVal("Ass", Ass);
	}
}