package iih.ci.ord.iemsg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * IE输血CD检验项目信息DTO DTO数据 
 * 
 */
public class IEBtCdLisItmDTO extends BaseDTO {
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
	public String getJy_sxsqjycdr() {
		return ((String) getAttrVal("Jy_sxsqjycdr"));
	}	
	/**
	 * 输血申请检验项目编码
	 * @param Jy_sxsqjycdr
	 */
	public void setJy_sxsqjycdr(String Jy_sxsqjycdr) {
		setAttrVal("Jy_sxsqjycdr", Jy_sxsqjycdr);
	}
	/**
	 * 检验结果编码 
	 * @return String
	 */
	public String getJy_jyjgcode() {
		return ((String) getAttrVal("Jy_jyjgcode"));
	}	
	/**
	 * 检验结果编码 
	 * @param Jy_jyjgcode
	 */
	public void setJy_jyjgcode(String Jy_jyjgcode) {
		setAttrVal("Jy_jyjgcode", Jy_jyjgcode);
	}
	/**
	 * 检验结果
	 * @return String
	 */
	public String getJy_jyjgname() {
		return ((String) getAttrVal("Jy_jyjgname"));
	}	
	/**
	 * 检验结果
	 * @param Jy_jyjgname
	 */
	public void setJy_jyjgname(String Jy_jyjgname) {
		setAttrVal("Jy_jyjgname", Jy_jyjgname);
	}
}