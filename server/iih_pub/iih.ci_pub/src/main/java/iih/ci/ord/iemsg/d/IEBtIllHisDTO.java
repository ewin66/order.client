package iih.ci.ord.iemsg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * IE输血病史信息DTO DTO数据 
 * 
 */
public class IEBtIllHisDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * IE输血病史主键标识
	 * @return String
	 */
	public String getId_iebtillhis() {
		return ((String) getAttrVal("Id_iebtillhis"));
	}	
	/**
	 * IE输血病史主键标识
	 * @param Id_iebtillhis
	 */
	public void setId_iebtillhis(String Id_iebtillhis) {
		setAttrVal("Id_iebtillhis", Id_iebtillhis);
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
	 * 布尔项目编码
	 * @return String
	 */
	public String getBs_bexmbm() {
		return ((String) getAttrVal("Bs_bexmbm"));
	}	
	/**
	 * 布尔项目编码
	 * @param Bs_bexmbm
	 */
	public void setBs_bexmbm(String Bs_bexmbm) {
		setAttrVal("Bs_bexmbm", Bs_bexmbm);
	}
	/**
	 * 描述
	 * @return String
	 */
	public String getBs_ms() {
		return ((String) getAttrVal("Bs_ms"));
	}	
	/**
	 * 描述
	 * @param Bs_ms
	 */
	public void setBs_ms(String Bs_ms) {
		setAttrVal("Bs_ms", Bs_ms);
	}
	/**
	 * 布尔项目值
	 * @return String
	 */
	public String getBs_bexmz() {
		return ((String) getAttrVal("Bs_bexmz"));
	}	
	/**
	 * 布尔项目值
	 * @param Bs_bexmz
	 */
	public void setBs_bexmz(String Bs_bexmz) {
		setAttrVal("Bs_bexmz", Bs_bexmz);
	}
}