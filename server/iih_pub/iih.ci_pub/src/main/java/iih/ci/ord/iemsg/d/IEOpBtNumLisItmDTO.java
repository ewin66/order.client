package iih.ci.ord.iemsg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * IE门诊输血数值检验项目信息DTO DTO数据 
 * 
 */
public class IEOpBtNumLisItmDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * IE输血数值检验项目主键标识
	 * @return String
	 */
	public String getId_iebtnumlisitm() {
		return ((String) getAttrVal("Id_iebtnumlisitm"));
	}	
	/**
	 * IE输血数值检验项目主键标识
	 * @param Id_iebtnumlisitm
	 */
	public void setId_iebtnumlisitm(String Id_iebtnumlisitm) {
		setAttrVal("Id_iebtnumlisitm", Id_iebtnumlisitm);
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
	/**
	 * 检验结果单位
	 * @return String
	 */
	public String getJyresultunit() {
		return ((String) getAttrVal("Jyresultunit"));
	}	
	/**
	 * 检验结果单位
	 * @param Jyresultunit
	 */
	public void setJyresultunit(String Jyresultunit) {
		setAttrVal("Jyresultunit", Jyresultunit);
	}
}