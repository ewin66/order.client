package iih.ci.mr.meethostdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 会议主持者DTO DTO数据 
 * 
 */
public class MeetHostDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 会议主持者编码
	 * @return String
	 */
	public String getCode_meho() {
		return ((String) getAttrVal("Code_meho"));
	}
	/**
	 * 会议主持者编码
	 * @param Code_meho
	 */
	public void setCode_meho(String Code_meho) {
		setAttrVal("Code_meho", Code_meho);
	}
	/**
	 * 会议主持者名称
	 * @return String
	 */
	public String getMeho() {
		return ((String) getAttrVal("Meho"));
	}
	/**
	 * 会议主持者名称
	 * @param Meho
	 */
	public void setMeho(String Meho) {
		setAttrVal("Meho", Meho);
	}
}