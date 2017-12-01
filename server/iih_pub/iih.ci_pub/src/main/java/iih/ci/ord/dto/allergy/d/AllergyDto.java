package iih.ci.ord.dto.allergy.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 实体 DTO数据 
 * 
 */
public class AllergyDto extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 过敏史
	 * @return String
	 */
	public String getId_patal() {
		return ((String) getAttrVal("Id_patal"));
	}
	/**
	 * 过敏史
	 * @param Id_patal
	 */
	public void setId_patal(String Id_patal) {
		setAttrVal("Id_patal", Id_patal);
	}
	/**
	 * 患者id
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者id
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 过敏史分类名称
	 * @return String
	 */
	public String getName_altp() {
		return ((String) getAttrVal("Name_altp"));
	}
	/**
	 * 过敏史分类名称
	 * @param Name_altp
	 */
	public void setName_altp(String Name_altp) {
		setAttrVal("Name_altp", Name_altp);
	}
	/**
	 * displaynam4
	 * @return String
	 */
	public String getName_alcla() {
		return ((String) getAttrVal("Name_alcla"));
	}
	/**
	 * displaynam4
	 * @param Name_alcla
	 */
	public void setName_alcla(String Name_alcla) {
		setAttrVal("Name_alcla", Name_alcla);
	}
}