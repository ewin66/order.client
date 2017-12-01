package iih.ci.ord.d.ems.base;

import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.FMap2;

/**
 * 前后台数据传输Json序列化与反序列化类型
 * @author wangqingzhu
 *
 */
public class BaseXapJsonSerialization extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	/**
	 * 扩展信息
	 * @return String
	 */
	public FMap2 getExtension() {
		return ((FMap2) getAttrVal("Extension"));
	}
	/**
	 * 扩展信息
	 * @param Extension
	 */
	public void setExtension(FMap2 Extension) {
		setAttrVal("Extension", Extension);
	}
}
