package iih.ci.ord.d.ems.error;

import iih.ci.ord.d.ems.base.BaseXapJsonSerialization;
import xap.mw.core.data.FMap2;
/**
 * 错误信息
 * @author wangqingzhu
 *
 */
public class CiErrorDTO extends BaseXapJsonSerialization {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4816942061528425908L;
	
	/**
	 * 错误信息ID
	 * @return String
	 */
	public String getId_error() {
		return ((String) getAttrVal("Id_error"));
	}
	/**
	 * 错误信息ID
	 * @param Id_error
	 */
	public void setId_error(String Id_error) {
		setAttrVal("Id_error", Id_error);
	}
	
	/**
	 * 错误信息描述
	 * @return String
	 */
	public String getDescription() {
		return ((String) getAttrVal("Description"));
	}
	/**
	 * 错误信息描述
	 * @param Description
	 */
	public void setDescription(String Description) {
		setAttrVal("Description", Description);
	}
	
	/**
	 * 错误信息级别
	 * @return String
	 */
	public String getLevel() {
		return ((String) getAttrVal("Level"));
	}
	/**
	 * 错误信息级别
	 * @param Level
	 */
	public void setLevel(String Level) {
		setAttrVal("Level", Level);
	}
	/**
	 * 错误信息扩展
	 * @return FMap2
	 */
	public FMap2 getExtInfo() {
		return ((FMap2) getAttrVal("Extension"));
	}
	/**
	 * 错误信息扩展
	 * @param Level
	 */
	public void setExtInfo(FMap2 ExtInfo) {
		setAttrVal("Extension", ExtInfo);
	}
}
