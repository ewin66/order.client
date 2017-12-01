package iih.ci.ord.iemsg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * IE血液要求信息DTO DTO数据 
 * 
 */
public class IEBtDemandDTO extends BaseDTO {
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
	public String getXycode() {
		return ((String) getAttrVal("Xycode"));
	}	
	/**
	 * 血液特殊要求编码
	 * @param Xycode
	 */
	public void setXycode(String Xycode) {
		setAttrVal("Xycode", Xycode);
	}
	/**
	 * 血液特殊要求
	 * @return String
	 */
	public String getXyname() {
		return ((String) getAttrVal("Xyname"));
	}	
	/**
	 * 血液特殊要求
	 * @param Xyname
	 */
	public void setXyname(String Xyname) {
		setAttrVal("Xyname", Xyname);
	}
}