package iih.ci.ord.dto.ems.uiemsdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 病理医疗单子 DTO数据 
 * 
 */
public class EmsPathgyItemViewDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 标本id
	 * @return String
	 */
	public String getId_lagsamp() {
		return ((String) getAttrVal("Id_lagsamp"));
	}
	/**
	 * 标本id
	 * @param Id_lagsamp
	 */
	public void setId_lagsamp(String Id_lagsamp) {
		setAttrVal("Id_lagsamp", Id_lagsamp);
	}
	/**
	 * 标本名称
	 * @return String
	 */
	public String getName_labsamp() {
		return ((String) getAttrVal("Name_labsamp"));
	}
	/**
	 * 标本名称
	 * @param Name_labsamp
	 */
	public void setName_labsamp(String Name_labsamp) {
		setAttrVal("Name_labsamp", Name_labsamp);
	}
	/**
	 * 采集部位ID
	 * @return String
	 */
	public String getId_body_coll() {
		return ((String) getAttrVal("Id_body_coll"));
	}
	/**
	 * 采集部位ID
	 * @param Id_body_coll
	 */
	public void setId_body_coll(String Id_body_coll) {
		setAttrVal("Id_body_coll", Id_body_coll);
	}
	/**
	 * 采集部位SD
	 * @return String
	 */
	public String getSd_body_coll() {
		return ((String) getAttrVal("Sd_body_coll"));
	}
	/**
	 * 采集部位SD
	 * @param Sd_body_coll
	 */
	public void setSd_body_coll(String Sd_body_coll) {
		setAttrVal("Sd_body_coll", Sd_body_coll);
	}
	/**
	 * 采集部位
	 * @return String
	 */
	public String getName_body_coll() {
		return ((String) getAttrVal("Name_body_coll"));
	}
	/**
	 * 采集部位
	 * @param Name_body_coll
	 */
	public void setName_body_coll(String Name_body_coll) {
		setAttrVal("Name_body_coll", Name_body_coll);
	}
	/**
	 * 标本数量
	 * @return String
	 */
	public String getQuan_coll() {
		return ((String) getAttrVal("Quan_coll"));
	}
	/**
	 * 标本数量
	 * @param Quan_coll
	 */
	public void setQuan_coll(String Quan_coll) {
		setAttrVal("Quan_coll", Quan_coll);
	}
	/**
	 * 固定液ID
	 * @return String
	 */
	public String getId_fixative() {
		return ((String) getAttrVal("Id_fixative"));
	}
	/**
	 * 固定液ID
	 * @param Id_fixative
	 */
	public void setId_fixative(String Id_fixative) {
		setAttrVal("Id_fixative", Id_fixative);
	}
	/**
	 * 固定液SD
	 * @return String
	 */
	public String getSd_fixative() {
		return ((String) getAttrVal("Sd_fixative"));
	}
	/**
	 * 固定液SD
	 * @param Sd_fixative
	 */
	public void setSd_fixative(String Sd_fixative) {
		setAttrVal("Sd_fixative", Sd_fixative);
	}
	/**
	 * 固定液
	 * @return String
	 */
	public String getName_fixative() {
		return ((String) getAttrVal("Name_fixative"));
	}
	/**
	 * 固定液
	 * @param Name_fixative
	 */
	public void setName_fixative(String Name_fixative) {
		setAttrVal("Name_fixative", Name_fixative);
	}
	/**
	 * 序号
	 * @return String
	 */
	public String getSortno() {
		return ((String) getAttrVal("Sortno"));
	}
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(String Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 病理标本ID
	 * @return String
	 */
	public String getId_appathgysamp() {
		return ((String) getAttrVal("Id_appathgysamp"));
	}
	/**
	 * 病理标本ID
	 * @param Id_appathgysamp
	 */
	public void setId_appathgysamp(String Id_appathgysamp) {
		setAttrVal("Id_appathgysamp", Id_appathgysamp);
	}
}