package iih.ci.ord.dto.ordsrvchangeddto.d;

import xap.mw.core.data.BaseDTO;

/**
 * 服务是否可开立判断dto DTO数据
 * 
 */
public class OrdSrvChangedInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;

	/**
	 * 服务主键
	 * 
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}

	/**
	 * 服务主键
	 * 
	 * @param id_srv
	 */
	public void setId_srv(String id_srv) {
		setAttrVal("Id_srv", id_srv);
	}

	/**
	 * 物品主键
	 * 
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}

	/**
	 * 物品主键
	 * 
	 * @param id_mm
	 */
	public void setId_mm(String id_mm) {
		setAttrVal("Id_mm", id_mm);
	}

	/**
	 * 不可开立原因提示
	 * 
	 * @return String
	 */
	public String getInfo_reason() {
		return ((String) getAttrVal("Info_reason"));
	}

	/**
	 * 不可开立原因提示
	 * 
	 * @param info_reason
	 */
	public void setInfo_reason(String info_reason) {
		setAttrVal("Info_reason", info_reason);
	}
}
