package iih.ci.mr.meetpartdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 会议参加者DTO DTO数据 
 * 
 */
public class MeetPartDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 会议参加者编码
	 * @return String
	 */
	public String getCode_mepa() {
		return ((String) getAttrVal("Code_mepa"));
	}
	/**
	 * 会议参加者编码
	 * @param Code_mepa
	 */
	public void setCode_mepa(String Code_mepa) {
		setAttrVal("Code_mepa", Code_mepa);
	}
	/**
	 * 会议参加者名称
	 * @return String
	 */
	public String getMepa() {
		return ((String) getAttrVal("Mepa"));
	}
	/**
	 * 会议参加者名称
	 * @param Mepa
	 */
	public void setMepa(String Mepa) {
		setAttrVal("Mepa", Mepa);
	}
}