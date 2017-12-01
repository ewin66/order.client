package iih.ci.ord.iemsg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * IE门诊血液要求信息DTO DTO数据 
 * 
 */
public class IEOpBtDemandDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * IE输血血液要求主键标识
	 * @return String
	 */
	public String getId_iebtdemand() {
		return ((String) getAttrVal("Id_iebtdemand"));
	}	
	/**
	 * IE输血血液要求主键标识
	 * @param Id_iebtdemand
	 */
	public void setId_iebtdemand(String Id_iebtdemand) {
		setAttrVal("Id_iebtdemand", Id_iebtdemand);
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
	 * 血液特殊要求编码
	 * @return String
	 */
	public String getBloodreqcode() {
		return ((String) getAttrVal("Bloodreqcode"));
	}	
	/**
	 * 血液特殊要求编码
	 * @param Bloodreqcode
	 */
	public void setBloodreqcode(String Bloodreqcode) {
		setAttrVal("Bloodreqcode", Bloodreqcode);
	}
	/**
	 * 血液特殊要求
	 * @return String
	 */
	public String getBloodreq() {
		return ((String) getAttrVal("Bloodreq"));
	}	
	/**
	 * 血液特殊要求
	 * @param Bloodreq
	 */
	public void setBloodreq(String Bloodreq) {
		setAttrVal("Bloodreq", Bloodreq);
	}
}