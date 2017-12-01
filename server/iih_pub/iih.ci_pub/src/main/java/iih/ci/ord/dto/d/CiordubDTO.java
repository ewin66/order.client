package iih.ci.ord.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

import iih.ci.ord.ciordems.d.OrCommonFieldsDTO;
import iih.ci.ord.refs.CiordConfirmRefModel;

/**
 * 用血申请单 DTO数据 
 * 
 */
public class CiordubDTO extends OrCommonFieldsDTO {
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
	 * 备血申请单号
	 * @return String
	 */
	public String getApplyform() {
		return ((String) getAttrVal("Applyform"));
	}
	/**
	 * 备血申请单号
	 * @param Applyform
	 */
	public void setApplyform(String Applyform) {
		setAttrVal("Applyform", Applyform);
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
	 * 输血成分
	 * @return String
	 */
	public String getOrsrvname() {
		return ((String) getAttrVal("Orsrvname"));
	}
	/**
	 * 输血成分
	 * @param Orsrvname
	 */
	public void setOrsrvname(String Orsrvname) {
		setAttrVal("Orsrvname", Orsrvname);
	}
	/**
	 * 备血申请量
	 * @return FDouble
	 */
	public FDouble getQuan_medu() {
		return ((FDouble) getAttrVal("Quan_medu"));
	}
	/**
	 * 备血申请量
	 * @param Quan_medu
	 */
	public void setQuan_medu(FDouble Quan_medu) {
		setAttrVal("Quan_medu", Quan_medu);
	}
	/**
	 * 界面中使用的用血单位
	 * @return String
	 */
	public String getId_unit() {
		return ((String) getAttrVal("Id_unit"));
	}
	/**
	 * 界面中使用的用血单位
	 * @param Id_unit
	 */
	public void setId_unit(String Id_unit) {
		setAttrVal("Id_unit", Id_unit);
	}
	/**
	 * 实际备血量
	 * @return FDouble
	 */
	public FDouble getNum_bt() {
		return ((FDouble) getAttrVal("Num_bt"));
	}
	/**
	 * 实际备血量
	 * @param Num_bt
	 */
	public void setNum_bt(FDouble Num_bt) {
		setAttrVal("Num_bt", Num_bt);
	}
	/**
	 * 计划输血日期
	 * @return FDate
	 */
	public FDate getDt_bt_pl() {
		return ((FDate) getAttrVal("Dt_bt_pl"));
	}
	/**
	 * 计划输血日期
	 * @param Dt_bt_pl
	 */
	public void setDt_bt_pl(FDate Dt_bt_pl) {
		setAttrVal("Dt_bt_pl", Dt_bt_pl);
	}
	/**
	 * 备血申请医师
	 * @return String
	 */
	public String getId_emp_sign() {
		return ((String) getAttrVal("Id_emp_sign"));
	}
	/**
	 * 备血申请医师
	 * @param Id_emp_sign
	 */
	public void setId_emp_sign(String Id_emp_sign) {
		setAttrVal("Id_emp_sign", Id_emp_sign);
	}
	/**
	 * 可用血余量
	 * @return FDouble
	 */
	public FDouble getNum_margin_bu() {
		return ((FDouble) getAttrVal("Num_margin_bu"));
	}
	/**
	 * 可用血余量
	 * @param Num_margin_bu
	 */
	public void setNum_margin_bu(FDouble Num_margin_bu) {
		setAttrVal("Num_margin_bu", Num_margin_bu);
	}
	/**
	 * 单位名称
	 * @return String
	 */
	public String getName_unit() {
		return ((String) getAttrVal("Name_unit"));
	}
	/**
	 * 单位名称
	 * @param Name_unit
	 */
	public void setName_unit(String Name_unit) {
		setAttrVal("Name_unit", Name_unit);
	}
	/**
	 * 本次用血量
	 * @return FDouble
	 */
	public FDouble getQuan_medu_ub() {
		return ((FDouble) getAttrVal("Quan_medu_ub"));
	}
	/**
	 * 本次用血量
	 * @param Quan_medu_ub
	 */
	public void setQuan_medu_ub(FDouble Quan_medu_ub) {
		setAttrVal("Quan_medu_ub", Quan_medu_ub);
	}
	/**
	 * 用法
	 * @return String
	 */
	public String getId_route() {
		return ((String) getAttrVal("Id_route"));
	}
	/**
	 * 用法
	 * @param Id_route
	 */
	public void setId_route(String Id_route) {
		setAttrVal("Id_route", Id_route);
	}
	/**
	 * 申请医师
	 * @return String
	 */
	public String getId_emp_create() {
		return ((String) getAttrVal("Id_emp_create"));
	}
	/**
	 * 申请医师
	 * @param Id_emp_create
	 */
	public void setId_emp_create(String Id_emp_create) {
		setAttrVal("Id_emp_create", Id_emp_create);
	}
	/**
	 * 嘱托
	 * @return String
	 */
	public String getDes_or() {
		return ((String) getAttrVal("Des_or"));
	}
	/**
	 * 嘱托
	 * @param Des_or
	 */
	public void setDes_or(String Des_or) {
		setAttrVal("Des_or", Des_or);
	}
	/**
	 * 申请时间
	 * @return FDateTime
	 */
	public FDateTime getDt_create() {
		return ((FDateTime) getAttrVal("Dt_create"));
	}
	/**
	 * 申请时间
	 * @param Dt_create
	 */
	public void setDt_create(FDateTime Dt_create) {
		setAttrVal("Dt_create", Dt_create);
	}
	/**
	 * 用血医嘱对应的备血医嘱id号
	 * @return String
	 */
	public String getId_or_rel() {
		return ((String) getAttrVal("Id_or_rel"));
	}
	/**
	 * 用血医嘱对应的备血医嘱id号
	 * @param Id_or_rel
	 */
	public void setId_or_rel(String Id_or_rel) {
		setAttrVal("Id_or_rel", Id_or_rel);
	}
	/**
	 * 备血申请医师名称
	 * @return String
	 */
	public String getName_emp_sign() {
		return ((String) getAttrVal("Name_emp_sign"));
	}
	/**
	 * 备血申请医师名称
	 * @param Name_emp_sign
	 */
	public void setName_emp_sign(String Name_emp_sign) {
		setAttrVal("Name_emp_sign", Name_emp_sign);
	}
	/**
	 * 申请医师名称
	 * @return String
	 */
	public String getName_emp_create() {
		return ((String) getAttrVal("Name_emp_create"));
	}
	/**
	 * 申请医师名称
	 * @param Name_emp_create
	 */
	public void setName_emp_create(String Name_emp_create) {
		setAttrVal("Name_emp_create", Name_emp_create);
	}
	/**
	 * 用法名称
	 * @return String
	 */
	public String getName_route() {
		return ((String) getAttrVal("Name_route"));
	}
	/**
	 * 用法名称
	 * @param Name_route
	 */
	public void setName_route(String Name_route) {
		setAttrVal("Name_route", Name_route);
	}
	/**
	 * 计划用血时间
	 * @return FDate
	 */
	public FDateTime getDt_bu_pl_ub() {
		return ((FDateTime) getAttrVal("Dt_bu_pl_ub"));
	}
	/**
	 * 计划用血时间
	 * @param Dt_bu_pl_ub
	 */
	public void setDt_bu_pl_ub(FDateTime Dt_bu_pl_ub) {
		setAttrVal("Dt_bu_pl_ub", Dt_bu_pl_ub);
	}
	/**
	 * 用血申请单号
	 * @return String
	 */
	public String getNo_applyform_ub() {
		return ((String) getAttrVal("No_applyform_ub"));
	}
	/**
	 * 用血申请单号
	 * @param No_applyform_ub
	 */
	public void setNo_applyform_ub(String No_applyform_ub) {
		setAttrVal("No_applyform_ub", No_applyform_ub);
	}
	/**
	 * 备血申请单
	 * @return String
	 */
	public String getPrebt() {
		return ((String) getAttrVal("Prebt"));
	}
	/**
	 * 备血申请单
	 * @param Prebt
	 */
	public void setPrebt(String Prebt) {
		setAttrVal("Prebt", Prebt);
	}
	/**
	 * 用血主键
	 * @return String
	 */
	public String getId_apbu() {
		return ((String) getAttrVal("Id_apbu"));
	}
	/**
	 * 用血主键
	 * @param Id_apbu
	 */
	public void setId_apbu(String Id_apbu) {
		setAttrVal("Id_apbu", Id_apbu);
	}
	/**
	 * 执行科室
	 * @return String
	 */
	public String getId_mp_dep() {
		return ((String) getAttrVal("Id_mp_dep"));
	}
	/**
	 * 执行科室
	 * @param Id_mp_dep
	 */
	public void setId_mp_dep(String Id_mp_dep) {
		setAttrVal("Id_mp_dep", Id_mp_dep);
	}
	/**
	 * 执行科室名称
	 * @return String
	 */
	public String getName_mp_dep() {
		return ((String) getAttrVal("Name_mp_dep"));
	}
	/**
	 * 执行科室名称
	 * @param Name_mp_dep
	 */
	public void setName_mp_dep(String Name_mp_dep) {
		setAttrVal("Name_mp_dep", Name_mp_dep);
	}
}