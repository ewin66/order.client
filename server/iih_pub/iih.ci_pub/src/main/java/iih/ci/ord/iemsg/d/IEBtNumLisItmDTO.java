package iih.ci.ord.iemsg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * IE输血数值检验项目信息DTO DTO数据 
 * 
 */
public class IEBtNumLisItmDTO extends BaseDTO {
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
	public String getJy_sxsqjldw() {
		return ((String) getAttrVal("Jy_sxsqjldw"));
	}	
	/**
	 * 输血申请检验项目编码
	 * @param Jy_sxsqjldw
	 */
	public void setJy_sxsqjldw(String Jy_sxsqjldw) {
		setAttrVal("Jy_sxsqjldw", Jy_sxsqjldw);
	}
	/**
	 * 检验结果
	 * @return String
	 */
	public String getJy_jyresult() {
		return ((String) getAttrVal("Jy_jyresult"));
	}	
	/**
	 * 检验结果
	 * @param Jy_jyresult
	 */
	public void setJy_jyresult(String Jy_jyresult) {
		setAttrVal("Jy_jyresult", Jy_jyresult);
	}
	/**
	 * 检验结果单位
	 * @return String
	 */
	public String getJy_jydw() {
		return ((String) getAttrVal("Jy_jydw"));
	}	
	/**
	 * 检验结果单位
	 * @param Jy_jydw
	 */
	public void setJy_jydw(String Jy_jydw) {
		setAttrVal("Jy_jydw", Jy_jydw);
	}
}