package iih.ci.ord.iemsg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * IE门诊输血病史信息DTO DTO数据 
 * 
 */
public class IEOpBtIllHisDTO extends BaseDTO {
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
	public String getBoolcode() {
		return ((String) getAttrVal("Boolcode"));
	}	
	/**
	 * 布尔项目编码
	 * @param Boolcode
	 */
	public void setBoolcode(String Boolcode) {
		setAttrVal("Boolcode", Boolcode);
	}
	/**
	 * 描述
	 * @return String
	 */
	public String getBdiscript() {
		return ((String) getAttrVal("Bdiscript"));
	}	
	/**
	 * 描述
	 * @param Bdiscript
	 */
	public void setBdiscript(String Bdiscript) {
		setAttrVal("Bdiscript", Bdiscript);
	}
	/**
	 * 布尔项目值
	 * @return String
	 */
	public String getBoolvalue() {
		return ((String) getAttrVal("Boolvalue"));
	}	
	/**
	 * 布尔项目值
	 * @param Boolvalue
	 */
	public void setBoolvalue(String Boolvalue) {
		setAttrVal("Boolvalue", Boolvalue);
	}
}