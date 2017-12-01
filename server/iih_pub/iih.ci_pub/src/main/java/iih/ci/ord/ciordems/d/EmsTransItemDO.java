package iih.ci.ord.ciordems.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 转科医嘱申请单 DTO数据 
 * 
 */
public class EmsTransItemDO extends OrCommonFieldsDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 * @return String
	 */
	public String getId_emsaptrans() {
		return ((String) getAttrVal("Id_emsaptrans"));
	}
	/**
	 * 主键
	 * @param Id_emsaptrans
	 */
	public void setId_emsaptrans(String Id_emsaptrans) {
		setAttrVal("Id_emsaptrans", Id_emsaptrans);
	}
	/**
	 * displaynam8
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * displaynam8
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * displaynam9
	 * @return String
	 */
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}
	/**
	 * displaynam9
	 * @param Id_orsrv
	 */
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
	/**
	 * 转科/跨科
	 * @return FBoolean
	 */
	public FBoolean getFg_tech_trans() {
		return ((FBoolean) getAttrVal("Fg_tech_trans"));
	}
	/**
	 * 转科/跨科
	 * @param Fg_tech_trans
	 */
	public void setFg_tech_trans(FBoolean Fg_tech_trans) {
		setAttrVal("Fg_tech_trans", Fg_tech_trans);
	}
	/**
	 * 目标科室id
	 * @return String
	 */
	public String getId_dep_to() {
		return ((String) getAttrVal("Id_dep_to"));
	}
	/**
	 * 目标科室id
	 * @param Id_dep_to
	 */
	public void setId_dep_to(String Id_dep_to) {
		setAttrVal("Id_dep_to", Id_dep_to);
	}
	/**
	 * 目标科室
	 * @return String
	 */
	public String getName_dep_to() {
		return ((String) getAttrVal("Name_dep_to"));
	}
	/**
	 * 目标科室
	 * @param Name_dep_to
	 */
	public void setName_dep_to(String Name_dep_to) {
		setAttrVal("Name_dep_to", Name_dep_to);
	}
	/**
	 * 目标病区
	 * @return String
	 */
	public String getName_dep_nur_to() {
		return ((String) getAttrVal("Name_dep_nur_to"));
	}
	/**
	 * 目标病区
	 * @param Name_dep_nur_to
	 */
	public void setName_dep_nur_to(String Name_dep_nur_to) {
		setAttrVal("Name_dep_nur_to", Name_dep_nur_to);
	}
	/**
	 * 目标病区id
	 * @return String
	 */
	public String getId_dep_nur_to() {
		return ((String) getAttrVal("Id_dep_nur_to"));
	}
	/**
	 * 目标病区id
	 * @param Id_dep_nur_to
	 */
	public void setId_dep_nur_to(String Id_dep_nur_to) {
		setAttrVal("Id_dep_nur_to", Id_dep_nur_to);
	}
	/**
	 * 转科原因
	 * @return String
	 */
	public String getDes_rea_canc() {
		return ((String) getAttrVal("Des_rea_canc"));
	}
	/**
	 * 转科原因
	 * @param Des_rea_canc
	 */
	public void setDes_rea_canc(String Des_rea_canc) {
		setAttrVal("Des_rea_canc", Des_rea_canc);
	}
	/**
	 * 原科室
	 * @return String
	 */
	public String getId_dep_from() {
		return ((String) getAttrVal("Id_dep_from"));
	}
	/**
	 * 原科室
	 * @param Id_dep_from
	 */
	public void setId_dep_from(String Id_dep_from) {
		setAttrVal("Id_dep_from", Id_dep_from);
	}
	/**
	 * 原病区
	 * @return String
	 */
	public String getId_dep_nur_from() {
		return ((String) getAttrVal("Id_dep_nur_from"));
	}
	/**
	 * 原病区
	 * @param Id_dep_nur_from
	 */
	public void setId_dep_nur_from(String Id_dep_nur_from) {
		setAttrVal("Id_dep_nur_from", Id_dep_nur_from);
	}
	/**
	 * 转科状态
	 * @return String
	 */
	public String getId_su_trans() {
		return ((String) getAttrVal("Id_su_trans"));
	}
	/**
	 * 转科状态
	 * @param Id_su_trans
	 */
	public void setId_su_trans(String Id_su_trans) {
		setAttrVal("Id_su_trans", Id_su_trans);
	}
	/**
	 * 转科状态编码
	 * @return String
	 */
	public String getSd_su_trans() {
		return ((String) getAttrVal("Sd_su_trans"));
	}
	/**
	 * 转科状态编码
	 * @param Sd_su_trans
	 */
	public void setSd_su_trans(String Sd_su_trans) {
		setAttrVal("Sd_su_trans", Sd_su_trans);
	}
	/**
	 * 申请时间
	 * @return FDateTime
	 */
	public FDateTime getDt_trans_apply() {
		return ((FDateTime) getAttrVal("Dt_trans_apply"));
	}
	/**
	 * 申请时间
	 * @param Dt_trans_apply
	 */
	public void setDt_trans_apply(FDateTime Dt_trans_apply) {
		setAttrVal("Dt_trans_apply", Dt_trans_apply);
	}
	/**
	 * 跨科生效时间
	 * @return FDateTime
	 */
	public FDateTime getDt_effe() {
		return ((FDateTime) getAttrVal("Dt_effe"));
	}
	/**
	 * 跨科生效时间
	 * @param Dt_trans_apply
	 */
	public void setDt_effe(FDateTime Dt_effe) {
		setAttrVal("Dt_effe", Dt_effe);
	}
	/**
	 * 跨科失效时间
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}
	/**
	 * 跨科失效时间
	 * @param Dt_trans_apply
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 版本号
	 * @return FDateTime
	 */
	public FDateTime getSv() {
		return ((FDateTime) getAttrVal("Sv"));
	}
	/**
	 * 版本号
	 * @param Sv
	 */
	public void setSv(FDateTime Sv) {
		setAttrVal("Sv", Sv);
	}
		/**
	 * 自费标识
	 * @return FBoolean
	 */
	public FBoolean getFg_selfpay() {
		return ((FBoolean) getAttrVal("Fg_selfpay"));
	}
	/**
	 * 自费标识
	 * @param Fg_selfpay
	 */
	public void setFg_selfpay(FBoolean Fg_selfpay) {
		setAttrVal("Fg_selfpay", Fg_selfpay);
	}
}