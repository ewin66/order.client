package iih.ci.diag.dto.judgedideletedto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 判断医嘱是否可以删除 DTO数据 
 * 
 */
public class Judgedideletedto extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * 医嘱名称
	 * @return String
	 */
	public String getName_or() {
		return ((String) getAttrVal("Name_or"));
	}
	/**
	 * 医嘱名称
	 * @param Name_or
	 */
	public void setName_or(String Name_or) {
		setAttrVal("Name_or", Name_or);
	}
	/**
	 * 医嘱编码
	 * @return String
	 */
	public String getCode_or() {
		return ((String) getAttrVal("Code_or"));
	}
	/**
	 * 医嘱编码
	 * @param Code_or
	 */
	public void setCode_or(String Code_or) {
		setAttrVal("Code_or", Code_or);
	}
	/**
	 * 医嘱项目主键
	 * @return String
	 */
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}
	/**
	 * 医嘱项目主键
	 * @param Id_orsrv
	 */
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}
	/**
	 * 服务名称
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	/**
	 * 结果编码
	 * @return String
	 */
	public String getEu_dpndrsn() {
		return ((String) getAttrVal("Eu_dpndrsn"));
	}
	/**
	 * 结果编码
	 * @param Eu_dpndrsn
	 */
	public void setEu_dpndrsn(String Eu_dpndrsn) {
		setAttrVal("Eu_dpndrsn", Eu_dpndrsn);
	}
	/**
	 * 结果原因
	 * @return String
	 */
	public String getDesc_dpndrsn() {
		return ((String) getAttrVal("Desc_dpndrsn"));
	}
	/**
	 * 结果原因
	 * @param Desc_dpndrsn
	 */
	public void setDesc_dpndrsn(String Desc_dpndrsn) {
		setAttrVal("Desc_dpndrsn", Desc_dpndrsn);
	}
	/**
	 * 服务id
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 服务id
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 是否删除
	 * @return String
	 */
	public FBoolean getFg_delete() {
		return ((FBoolean) getAttrVal("Fg_delete"));
	}
	/**
	 * 是否删除
	 * @param Fg_delete
	 */
	public void setFg_delete(FBoolean Fg_delete) {
		setAttrVal("Fg_delete", Fg_delete);
	}
	/**
	 * displaynam10
	 * @return String
	 */
	public String getName10() {
		return ((String) getAttrVal("Name10"));
	}
	/**
	 * displaynam10
	 * @param Name10
	 */
	public void setName10(String Name10) {
		setAttrVal("Name10", Name10);
	}
	/**
	 * displaynam11
	 * @return String
	 */
	public String getName11() {
		return ((String) getAttrVal("Name11"));
	}
	/**
	 * displaynam11
	 * @param Name11
	 */
	public void setName11(String Name11) {
		setAttrVal("Name11", Name11);
	}
	/**
	 * displaynam12
	 * @return String
	 */
	public String getName12() {
		return ((String) getAttrVal("Name12"));
	}
	/**
	 * displaynam12
	 * @param Name12
	 */
	public void setName12(String Name12) {
		setAttrVal("Name12", Name12);
	}
	/**
	 * displaynam13
	 * @return String
	 */
	public String getName13() {
		return ((String) getAttrVal("Name13"));
	}
	/**
	 * displaynam13
	 * @param Name13
	 */
	public void setName13(String Name13) {
		setAttrVal("Name13", Name13);
	}
	/**
	 * displaynam14
	 * @return String
	 */
	public String getName14() {
		return ((String) getAttrVal("Name14"));
	}
	/**
	 * displaynam14
	 * @param Name14
	 */
	public void setName14(String Name14) {
		setAttrVal("Name14", Name14);
	}
	/**
	 * displaynam15
	 * @return String
	 */
	public String getName15() {
		return ((String) getAttrVal("Name15"));
	}
	/**
	 * displaynam15
	 * @param Name15
	 */
	public void setName15(String Name15) {
		setAttrVal("Name15", Name15);
	}
	/**
	 * displaynam16
	 * @return String
	 */
	public String getName16() {
		return ((String) getAttrVal("Name16"));
	}
	/**
	 * displaynam16
	 * @param Name16
	 */
	public void setName16(String Name16) {
		setAttrVal("Name16", Name16);
	}
	/**
	 * displaynam17
	 * @return String
	 */
	public String getName17() {
		return ((String) getAttrVal("Name17"));
	}
	/**
	 * displaynam17
	 * @param Name17
	 */
	public void setName17(String Name17) {
		setAttrVal("Name17", Name17);
	}
}