package iih.ci.ord.iemsg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * IE输血字串检验项目信息DTO DTO数据 
 * 
 */
public class IEBtStrLisItmDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * IE输血字串检验项目主键标识
	 * @return String
	 */
	public String getId_iebtstrlisitm() {
		return ((String) getAttrVal("Id_iebtstrlisitm"));
	}	
	/**
	 * IE输血字串检验项目主键标识
	 * @param Id_iebtstrlisitm
	 */
	public void setId_iebtstrlisitm(String Id_iebtstrlisitm) {
		setAttrVal("Id_iebtstrlisitm", Id_iebtstrlisitm);
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
	public String getJy_sxsqjyzfc() {
		return ((String) getAttrVal("Jy_sxsqjyzfc"));
	}	
	/**
	 * 输血申请检验项目编码
	 * @param Jy_sxsqjyzfc
	 */
	public void setJy_sxsqjyzfc(String Jy_sxsqjyzfc) {
		setAttrVal("Jy_sxsqjyzfc", Jy_sxsqjyzfc);
	}
	/**
	 * 检验结果
	 * @return String
	 */
	public String getJy_result() {
		return ((String) getAttrVal("Jy_result"));
	}	
	/**
	 * 检验结果
	 * @param Jy_result
	 */
	public void setJy_result(String Jy_result) {
		setAttrVal("Jy_result", Jy_result);
	}
}