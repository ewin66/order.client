package iih.ci.ord.ciordems.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 出院医嘱申请单 DTO数据 
 * 
 */
public class EmsOutItemDO extends OrCommonFieldsDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 * @return String
	 */
	public String getId_emsapout() {
		return ((String) getAttrVal("Id_emsapout"));
	}
	/**
	 * 主键
	 * @param Id_emsapout
	 */
	public void setId_emsapout(String Id_emsapout) {
		setAttrVal("Id_emsapout", Id_emsapout);
	}
	/**
	 * 医嘱id
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱id
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 医嘱服务id
	 * @return String
	 */
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}
	/**
	 * 医嘱服务id
	 * @param Id_orsrv
	 */
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
	/**
	 * 出院科室id
	 * @return String
	 */
	public String getId_dep_out() {
		return ((String) getAttrVal("Id_dep_out"));
	}
	/**
	 * 出院科室id
	 * @param Id_dep_out
	 */
	public void setId_dep_out(String Id_dep_out) {
		setAttrVal("Id_dep_out", Id_dep_out);
	}
	/**
	 * 出院科室
	 * @return String
	 */
	public String getName_dep_out() {
		return ((String) getAttrVal("Name_dep_out"));
	}
	/**
	 * 出院科室
	 * @param Name_dep_out
	 */
	public void setName_dep_out(String Name_dep_out) {
		setAttrVal("Name_dep_out", Name_dep_out);
	}
	/**
	 * 出院病区id
	 * @return String
	 */
	public String getId_dep_nur_out() {
		return ((String) getAttrVal("Id_dep_nur_out"));
	}
	/**
	 * 出院病区id
	 * @param Id_dep_nur_out
	 */
	public void setId_dep_nur_out(String Id_dep_nur_out) {
		setAttrVal("Id_dep_nur_out", Id_dep_nur_out);
	}
	/**
	 * 出院病区
	 * @return String
	 */
	public String getName_dep_nur_out() {
		return ((String) getAttrVal("Name_dep_nur_out"));
	}
	/**
	 * 出院病区
	 * @param Name_dep_nur_out
	 */
	public void setName_dep_nur_out(String Name_dep_nur_out) {
		setAttrVal("Name_dep_nur_out", Name_dep_nur_out);
	}
	/**
	 * 出院床位id
	 * @return String
	 */
	public String getId_bed_out() {
		return ((String) getAttrVal("Id_bed_out"));
	}
	/**
	 * 出院床位id
	 * @param Id_bed_out
	 */
	public void setId_bed_out(String Id_bed_out) {
		setAttrVal("Id_bed_out", Id_bed_out);
	}
	/**
	 * 出院床位
	 * @return String
	 */
	public String getName_bde_out() {
		return ((String) getAttrVal("Name_bde_out"));
	}
	/**
	 * 出院床位
	 * @param Name_bde_out
	 */
	public void setName_bde_out(String Name_bde_out) {
		setAttrVal("Name_bde_out", Name_bde_out);
	}
	/**
	 * 31日再入院计划
	 * @return FBoolean
	 */
	public FBoolean getFg_again31() {
		return ((FBoolean) getAttrVal("Fg_again31"));
	}
	/**
	 * 31日再入院计划
	 * @param Fg_again31
	 */
	public void setFg_again31(FBoolean Fg_again31) {
		setAttrVal("Fg_again31", Fg_again31);
	}
	/**
	 * 31日再入院目的
	 * @return String
	 */
	public String getDes_again31() {
		return ((String) getAttrVal("Des_again31"));
	}
	/**
	 * 31日再入院目的
	 * @param Des_again31
	 */
	public void setDes_again31(String Des_again31) {
		setAttrVal("Des_again31", Des_again31);
	}
	/**
	 * 离院方式id
	 * @return String
	 */
	public String getId_outtp() {
		return ((String) getAttrVal("Id_outtp"));
	}
	/**
	 * 离院方式id
	 * @param Id_outtp
	 */
	public void setId_outtp(String Id_outtp) {
		setAttrVal("Id_outtp", Id_outtp);
	}
	/**
	 * 离院方式编码
	 * @return String
	 */
	public String getSd_outtp() {
		return ((String) getAttrVal("Sd_outtp"));
	}
	/**
	 * 离院方式编码
	 * @param Sd_outtp
	 */
	public void setSd_outtp(String Sd_outtp) {
		setAttrVal("Sd_outtp", Sd_outtp);
	}
	/**
	 * 离院方式
	 * @return String
	 */
	public String getName_outtp() {
		return ((String) getAttrVal("Name_outtp"));
	}
	/**
	 * 离院方式
	 * @param Name_outtp
	 */
	public void setName_outtp(String Name_outtp) {
		setAttrVal("Name_outtp", Name_outtp);
	}
	/**
	 * 离院描述
	 * @return String
	 */
	public String getDes_outtp() {
		return ((String) getAttrVal("Des_outtp"));
	}
	/**
	 * 离院描述
	 * @param Des_outtp
	 */
	public void setDes_outtp(String Des_outtp) {
		setAttrVal("Des_outtp", Des_outtp);
	}
	/**
	 * sv
	 * @return FDateTime
	 */
	public FDateTime getSv() {
		return ((FDateTime) getAttrVal("Sv"));
	}
	/**
	 * sv
	 * @param Sv
	 */
	public void setSv(FDateTime Sv) {
		setAttrVal("Sv", Sv);
	}
	/**
	 * 出院时间
	 * @return FDateTime
	 */
	public FDateTime getDt_out() {
		return ((FDateTime) getAttrVal("Dt_out"));
	}
	/**
	 * 出院时间
	 * @param Dt_out
	 */
	public void setDt_out(FDateTime Dt_out) {
		setAttrVal("Dt_out", Dt_out);
	}
	/**
	 * 是否死亡标识
	 * @return FBoolean
	 */
	public FBoolean getFg_death() {
		return ((FBoolean) getAttrVal("Fg_death"));
	}
	/**
	 *  是否死亡标识
	 * @param Fg_death
	 */
	public void setFg_death(FBoolean Fg_death) {
		setAttrVal("Fg_death", Fg_death);
	}
	/**
	 * 是否尸检标识
	 * @return FBoolean
	 */
	public FBoolean getFg_autopsy() {
		return ((FBoolean) getAttrVal("Fg_autopsy"));
	}
	/**
	 *  是否尸检标识
	 * @param Fg_autopsy
	 */
	public void setFg_autopsy(FBoolean Fg_autopsy) {
		setAttrVal("Fg_autopsy", Fg_autopsy);
	}
}