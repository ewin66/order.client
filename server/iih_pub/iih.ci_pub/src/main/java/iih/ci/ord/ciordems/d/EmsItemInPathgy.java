package iih.ci.ord.ciordems.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 病理标本项目 DTO数据 
 * 
 */
public class EmsItemInPathgy extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 * @return String
	 */
	public String getId_oriteminpathgy() {
		return ((String) getAttrVal("Id_oriteminpathgy"));
	}
	/**
	 * 主键
	 * @param Id_oriteminpathgy
	 */
	public void setId_oriteminpathgy(String Id_oriteminpathgy) {
		setAttrVal("Id_oriteminpathgy", Id_oriteminpathgy);
	}
	/**
	 * 医嘱主键
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱主键
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
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
	 * 标本采集部位id
	 * @return String
	 */
	public String getId_body_coll() {
		return ((String) getAttrVal("Id_body_coll"));
	}
	/**
	 * 标本采集部位id
	 * @param Id_body_coll
	 */
	public void setId_body_coll(String Id_body_coll) {
		setAttrVal("Id_body_coll", Id_body_coll);
	}
	/**
	 * 标本采集部位sd
	 * @return String
	 */
	public String getSd_body_coll() {
		return ((String) getAttrVal("Sd_body_coll"));
	}
	/**
	 * 标本采集部位sd
	 * @param Sd_body_coll
	 */
	public void setSd_body_coll(String Sd_body_coll) {
		setAttrVal("Sd_body_coll", Sd_body_coll);
	}
	/**
	 * 采集部位
	 * @return String
	 */
	public String getBody_coll() {
		return ((String) getAttrVal("Body_coll"));
	}
	/**
	 * 采集部位
	 * @param Body_coll
	 */
	public void setBody_coll(String Body_coll) {
		setAttrVal("Body_coll", Body_coll);
	}
	/**
	 * 标本数量
	 * @return Integer
	 */
	public Integer getQuan_coll() {
		return ((Integer) getAttrVal("Quan_coll"));
	}
	/**
	 * 标本数量
	 * @param Quan_coll
	 */
	public void setQuan_coll(Integer Quan_coll) {
		setAttrVal("Quan_coll", Quan_coll);
	}
	/**
	 * 标本固定液id
	 * @return String
	 */
	public String getId_fixative() {
		return ((String) getAttrVal("Id_fixative"));
	}
	/**
	 * 标本固定液id
	 * @param Id_fixative
	 */
	public void setId_fixative(String Id_fixative) {
		setAttrVal("Id_fixative", Id_fixative);
	}
	/**
	 * 标本固定液sd
	 * @return String
	 */
	public String getSd_fixative() {
		return ((String) getAttrVal("Sd_fixative"));
	}
	/**
	 * 标本固定液sd
	 * @param Sd_fixative
	 */
	public void setSd_fixative(String Sd_fixative) {
		setAttrVal("Sd_fixative", Sd_fixative);
	}
	/**
	 * 固定液
	 * @return String
	 */
	public String getFixative() {
		return ((String) getAttrVal("Fixative"));
	}
	/**
	 * 固定液
	 * @param Fixative
	 */
	public void setFixative(String Fixative) {
		setAttrVal("Fixative", Fixative);
	}
	/**
	 * 采集所见
	 * @return String
	 */
	public String getCollectdes() {
		return ((String) getAttrVal("Collectdes"));
	}
	/**
	 * 采集所见
	 * @param Collectdes
	 */
	public void setCollectdes(String Collectdes) {
		setAttrVal("Collectdes", Collectdes);
	}
	/**
	 * 采集时间
	 * @return FDateTime
	 */
	public FDateTime getDt_coll() {
		return ((FDateTime) getAttrVal("Dt_coll"));
	}
	/**
	 * 采集时间
	 * @param Dt_coll
	 */
	public void setDt_coll(FDateTime Dt_coll) {
		setAttrVal("Dt_coll", Dt_coll);
	}
	/**
	 * 采集者编码
	 * @return String
	 */
	public String getId_emp_coll() {
		return ((String) getAttrVal("Id_emp_coll"));
	}
	/**
	 * 采集者编码
	 * @param Id_emp_coll
	 */
	public void setId_emp_coll(String Id_emp_coll) {
		setAttrVal("Id_emp_coll", Id_emp_coll);
	}
	/**
	 * 采集者名称
	 * @return String
	 */
	public String getName_emp_coll() {
		return ((String) getAttrVal("Name_emp_coll"));
	}
	/**
	 * 采集者名称
	 * @param Name_emp_coll
	 */
	public void setName_emp_coll(String Name_emp_coll) {
		setAttrVal("Name_emp_coll", Name_emp_coll);
	}
	/**
	 * 序号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 标本状态id
	 * @return String
	 */
	public String getId_su_labsamp() {
		return ((String) getAttrVal("Id_su_labsamp"));
	}
	/**
	 * 标本状态id
	 * @param Id_su_labsamp
	 */
	public void setId_su_labsamp(String Id_su_labsamp) {
		setAttrVal("Id_su_labsamp", Id_su_labsamp);
	}
	/**
	 * 标本状态编码
	 * @return String
	 */
	public String getSd_su_labsamp() {
		return ((String) getAttrVal("Sd_su_labsamp"));
	}
	/**
	 * 标本状态编码
	 * @param Sd_su_labsamp
	 */
	public void setSd_su_labsamp(String Sd_su_labsamp) {
		setAttrVal("Sd_su_labsamp", Sd_su_labsamp);
	}
	/**
	 * 标本签收科室
	 * @return String
	 */
	public String getId_dep_sign() {
		return ((String) getAttrVal("Id_dep_sign"));
	}
	/**
	 * 标本签收科室
	 * @param Id_dep_sign
	 */
	public void setId_dep_sign(String Id_dep_sign) {
		setAttrVal("Id_dep_sign", Id_dep_sign);
	}
	/**
	 * 标本签收人
	 * @return String
	 */
	public String getId_emp_sign() {
		return ((String) getAttrVal("Id_emp_sign"));
	}
	/**
	 * 标本签收人
	 * @param Id_emp_sign
	 */
	public void setId_emp_sign(String Id_emp_sign) {
		setAttrVal("Id_emp_sign", Id_emp_sign);
	}
}