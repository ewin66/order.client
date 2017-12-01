package iih.ci.ord.iemsg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * IE门诊输血CD检验项目信息DTO DTO数据 
 * 
 */
public class IEOpBtCdLisItmDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * IE输血CD检验项目主键标识
	 * @return String
	 */
	public String getId_iebtcdlisitm() {
		return ((String) getAttrVal("Id_iebtcdlisitm"));
	}	
	/**
	 * IE输血CD检验项目主键标识
	 * @param Id_iebtcdlisitm
	 */
	public void setId_iebtcdlisitm(String Id_iebtcdlisitm) {
		setAttrVal("Id_iebtcdlisitm", Id_iebtcdlisitm);
	}
	/**
	 * IE输血申请
	 * @return String
	 */
	public String getId_iebtoren() {
		return ((String) getAttrVal("Id_iebtoren"));
	}	
	/**
	 * IE输血申请
	 * @param Id_iebtoren
	 */
	public void setId_iebtoren(String Id_iebtoren) {
		setAttrVal("Id_iebtoren", Id_iebtoren);
	}
	/**
	 * 输血申请检验项目编码
	 * @return String
	 */
	public String getJyapplycode() {
		return ((String) getAttrVal("Jyapplycode"));
	}	
	/**
	 * 输血申请检验项目编码
	 * @param Jyapplycode
	 */
	public void setJyapplycode(String Jyapplycode) {
		setAttrVal("Jyapplycode", Jyapplycode);
	}
	/**
	 * 检验结果编码 
	 * @return String
	 */
	public String getJyresultcode() {
		return ((String) getAttrVal("Jyresultcode"));
	}	
	/**
	 * 检验结果编码 
	 * @param Jyresultcode
	 */
	public void setJyresultcode(String Jyresultcode) {
		setAttrVal("Jyresultcode", Jyresultcode);
	}
	/**
	 * 检验结果
	 * @return String
	 */
	public String getJyresult() {
		return ((String) getAttrVal("Jyresult"));
	}	
	/**
	 * 检验结果
	 * @param Jyresult
	 */
	public void setJyresult(String Jyresult) {
		setAttrVal("Jyresult", Jyresult);
	}
}