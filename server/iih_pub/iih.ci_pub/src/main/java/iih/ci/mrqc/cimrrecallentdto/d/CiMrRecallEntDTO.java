package iih.ci.mrqc.cimrrecallentdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊病历召回申请列表 DTO数据 
 * 
 */
public class CiMrRecallEntDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 就诊id
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊id
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getPat_name() {
		return ((String) getAttrVal("Pat_name"));
	}
	/**
	 * 姓名
	 * @param Pat_name
	 */
	public void setPat_name(String Pat_name) {
		setAttrVal("Pat_name", Pat_name);
	}
	/**
	 * 性别
	 * @return String
	 */
	public String getPat_sex() {
		return ((String) getAttrVal("Pat_sex"));
	}
	/**
	 * 性别
	 * @param Pat_sex
	 */
	public void setPat_sex(String Pat_sex) {
		setAttrVal("Pat_sex", Pat_sex);
	}
	/**
	 * 年龄
	 * @return String
	 */
	public String getPat_age() {
		return ((String) getAttrVal("Pat_age"));
	}
	/**
	 * 年龄
	 * @param Pat_age
	 */
	public void setPat_age(String Pat_age) {
		setAttrVal("Pat_age", Pat_age);
	}
	/**
	 * 就诊时间
	 * @return FDateTime
	 */
	public FDateTime getDt_ent() {
		return ((FDateTime) getAttrVal("Dt_ent"));
	}
	/**
	 * 就诊时间
	 * @param Dt_ent
	 */
	public void setDt_ent(FDateTime Dt_ent) {
		setAttrVal("Dt_ent", Dt_ent);
	}
	/**
	 * 就诊科室
	 * @return String
	 */
	public String getName_dep_ent() {
		return ((String) getAttrVal("Name_dep_ent"));
	}
	/**
	 * 就诊科室
	 * @param Name_dep_ent
	 */
	public void setName_dep_ent(String Name_dep_ent) {
		setAttrVal("Name_dep_ent", Name_dep_ent);
	}
	/**
	 * 初诊或复诊
	 * @return String
	 */
	public String getFg_first() {
		return ((String) getAttrVal("Fg_first"));
	}
	/**
	 * 初诊或复诊
	 * @param Fg_first
	 */
	public void setFg_first(String Fg_first) {
		setAttrVal("Fg_first", Fg_first);
	}
	/**
	 * 就诊科室id
	 * @return String
	 */
	public String getId_dep_ent() {
		return ((String) getAttrVal("Id_dep_ent"));
	}
	/**
	 * 就诊科室id
	 * @param Id_dep_ent
	 */
	public void setId_dep_ent(String Id_dep_ent) {
		setAttrVal("Id_dep_ent", Id_dep_ent);
	}
	/**
	 * 就诊科室code
	 * @return String
	 */
	public String getCode_dep_ent() {
		return ((String) getAttrVal("Code_dep_ent"));
	}
	/**
	 * 就诊科室code
	 * @param Code_dep_ent
	 */
	public void setCode_dep_ent(String Code_dep_ent) {
		setAttrVal("Code_dep_ent", Code_dep_ent);
	}
	/**
	 * 条码号
	 * @return String
	 */
	public String getBarcode_chis() {
		return ((String) getAttrVal("Barcode_chis"));
	}
	/**
	 * 条码号
	 * @param Barcode_chis
	 */
	public void setBarcode_chis(String Barcode_chis) {
		setAttrVal("Barcode_chis", Barcode_chis);
	}
	/**
	 * 就诊编码
	 * @return String
	 */
	public String getEnt_code() {
		return ((String) getAttrVal("Ent_code"));
	}
	/**
	 * 就诊编码
	 * @param Ent_code
	 */
	public void setEnt_code(String Ent_code) {
		setAttrVal("Ent_code", Ent_code);
	}
}