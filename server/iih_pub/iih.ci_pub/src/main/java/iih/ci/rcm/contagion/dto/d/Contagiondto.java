package iih.ci.rcm.contagion.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 实体 DTO数据 
 * 
 */
public class Contagiondto extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * id_contagion
	 * @return String
	 */
	public String getId_contagion() {
		return ((String) getAttrVal("Id_contagion"));
	}
	/**
	 * id_contagion
	 * @param Id_contagion
	 */
	public void setId_contagion(String Id_contagion) {
		setAttrVal("Id_contagion", Id_contagion);
	}
	/**
	 * title
	 * @return String
	 */
	public String getTitle() {
		return ((String) getAttrVal("Title"));
	}
	/**
	 * title
	 * @param Title
	 */
	public void setTitle(String Title) {
		setAttrVal("Title", Title);
	}
	/**
	 * id_form
	 * @return String
	 */
	public String getId_form() {
		return ((String) getAttrVal("Id_form"));
	}
	/**
	 * id_form
	 * @param Id_form
	 */
	public void setId_form(String Id_form) {
		setAttrVal("Id_form", Id_form);
	}
	/**
	 * id_ent
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * id_ent
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * p_id_contagion
	 * @return String
	 */
	public String getP_id_contagion() {
		return ((String) getAttrVal("P_id_contagion"));
	}
	/**
	 * p_id_contagion
	 * @param P_id_contagion
	 */
	public void setP_id_contagion(String P_id_contagion) {
		setAttrVal("P_id_contagion", P_id_contagion);
	}
	/**
	 * 状态
	 * @return String
	 */
	public String getId_state() {
		return ((String) getAttrVal("Id_state"));
	}
	/**
	 * 状态
	 * @param Id_state
	 */
	public void setId_state(String Id_state) {
		setAttrVal("Id_state", Id_state);
	}
	/**
	 * 驳回原因
	 * @return String
	 */
	public String getReject_reason() {
		return ((String) getAttrVal("Reject_reason"));
	}
	/**
	 * 驳回原因
	 * @param Reject_reason
	 */
	public void setReject_reason(String Reject_reason) {
		setAttrVal("Reject_reason", Reject_reason);
	}
}