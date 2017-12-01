package iih.ci.mr.secinfodto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 章节信息DTO DTO数据 
 * 
 */
public class SecInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 章节编码
	 * @return String
	 */
	public String getCode_sec() {
		return ((String) getAttrVal("Code_sec"));
	}
	/**
	 * 章节编码
	 * @param Code_sec
	 */
	public void setCode_sec(String Code_sec) {
		setAttrVal("Code_sec", Code_sec);
	}
	/**
	 * 章节名称
	 * @return String
	 */
	public String getTitle() {
		return ((String) getAttrVal("Title"));
	}
	/**
	 * 章节名称
	 * @param Title
	 */
	public void setTitle(String Title) {
		setAttrVal("Title", Title);
	}
	/**
	 * 章节信息
	 * @return String
	 */
	public String getSec() {
		return ((String) getAttrVal("Sec"));
	}
	/**
	 * 章节信息
	 * @param Sec
	 */
	public void setSec(String Sec) {
		setAttrVal("Sec", Sec);
	}
}