package iih.ci.rcm.hospitalinfectiondto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 实体 DTO数据 
 * 
 */
public class HospitalInfectionDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 节点id
	 * @return String
	 */
	public String getId_node() {
		return ((String) getAttrVal("Id_node"));
	}
	/**
	 * 节点id
	 * @param Id_node
	 */
	public void setId_node(String Id_node) {
		setAttrVal("Id_node", Id_node);
	}
	/**
	 * 父节点id
	 * @return String
	 */
	public String getId_parent_node() {
		return ((String) getAttrVal("Id_parent_node"));
	}
	/**
	 * 父节点id
	 * @param Id_parent_node
	 */
	public void setId_parent_node(String Id_parent_node) {
		setAttrVal("Id_parent_node", Id_parent_node);
	}
	/**
	 * 类型
	 * @return String
	 */
	public String getStyle() {
		return ((String) getAttrVal("Style"));
	}
	/**
	 * 类型
	 * @param Style
	 */
	public void setStyle(String Style) {
		setAttrVal("Style", Style);
	}
	/**
	 * 是否主卡
	 * @return FBoolean
	 */
	public FBoolean getIs_main_card() {
		return ((FBoolean) getAttrVal("Is_main_card"));
	}
	/**
	 * 是否主卡
	 * @param Is_main_card
	 */
	public void setIs_main_card(FBoolean Is_main_card) {
		setAttrVal("Is_main_card", Is_main_card);
	}
	/**
	 * 是否副卡
	 * @return FBoolean
	 */
	public FBoolean getIs_vice_card() {
		return ((FBoolean) getAttrVal("Is_vice_card"));
	}
	/**
	 * 是否副卡
	 * @param Is_vice_card
	 */
	public void setIs_vice_card(FBoolean Is_vice_card) {
		setAttrVal("Is_vice_card", Is_vice_card);
	}
	/**
	 * 报卡状态
	 * @return String
	 */
	public String getReport_status() {
		return ((String) getAttrVal("Report_status"));
	}
	/**
	 * 报卡状态
	 * @param Report_status
	 */
	public void setReport_status(String Report_status) {
		setAttrVal("Report_status", Report_status);
	}
}