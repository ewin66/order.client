package iih.ci.ord.dto.ems.uiemsdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 检验医疗单子 DTO数据 
 * 
 */
public class EmsLisViewItemDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 服务ID
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 服务ID
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 服务
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}
	/**
	 * 服务
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	/**
	 * 选中标识
	 * @return FBoolean
	 */
	public FBoolean getFg_check() {
		return ((FBoolean) getAttrVal("Fg_check"));
	}
	/**
	 * 选中标识
	 * @param Fg_check
	 */
	public void setFg_check(FBoolean Fg_check) {
		setAttrVal("Fg_check", Fg_check);
	}
	/**
	 * 编辑标识
	 * @return FBoolean
	 */
	public FBoolean getFg_edit() {
		return ((FBoolean) getAttrVal("Fg_edit"));
	}
	/**
	 * 编辑标识
	 * @param Fg_edit
	 */
	public void setFg_edit(FBoolean Fg_edit) {
		setAttrVal("Fg_edit", Fg_edit);
	}
	/**
	 * 医嘱服务ID
	 * @return String
	 */
	public String getId_or_srv() {
		return ((String) getAttrVal("Id_or_srv"));
	}
	/**
	 * 医嘱服务ID
	 * @param Id_or_srv
	 */
	public void setId_or_srv(String Id_or_srv) {
		setAttrVal("Id_or_srv", Id_or_srv);
	}
}