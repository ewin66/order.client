package iih.ci.ord.dto.ems.uiemsdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 备血医疗单 DTO数据 
 * 
 */
public class EmsApbtViewDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱ID
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱ID
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 服务ID
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 服务ID
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 处置项目
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}
	/**
	 * 处置项目
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	/**
	 * 输血成分ID
	 * @return String
	 */
	public String getId_srv_set() {
		return ((String) getAttrVal("Id_srv_set"));
	}
	/**
	 * 输血成分ID
	 * @param Id_srv_set
	 */
	public void setId_srv_set(String Id_srv_set) {
		setAttrVal("Id_srv_set", Id_srv_set);
	}
	/**
	 * 输血成分
	 * @return String
	 */
	public String getName_srv_set() {
		return ((String) getAttrVal("Name_srv_set"));
	}
	/**
	 * 输血成分
	 * @param Name_srv_set
	 */
	public void setName_srv_set(String Name_srv_set) {
		setAttrVal("Name_srv_set", Name_srv_set);
	}
	/**
	 * 加急标识
	 * @return FBoolean
	 */
	public FBoolean getFg_urgent() {
		return ((FBoolean) getAttrVal("Fg_urgent"));
	}
	/**
	 * 加急标识
	 * @param Fg_urgent
	 */
	public void setFg_urgent(FBoolean Fg_urgent) {
		setAttrVal("Fg_urgent", Fg_urgent);
	}
	/**
	 * 单价
	 * @return FDouble
	 */
	public FDouble getPrice() {
		return ((FDouble) getAttrVal("Price"));
	}
	/**
	 * 单价
	 * @param Price
	 */
	public void setPrice(FDouble Price) {
		setAttrVal("Price", Price);
	}
	/**
	 * 服务类型
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}
	/**
	 * 服务类型
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 执行科室ID
	 * @return String
	 */
	public String getId_dep_mp() {
		return ((String) getAttrVal("Id_dep_mp"));
	}
	/**
	 * 执行科室ID
	 * @param Id_dep_mp
	 */
	public void setId_dep_mp(String Id_dep_mp) {
		setAttrVal("Id_dep_mp", Id_dep_mp);
	}
	/**
	 * 执行科室
	 * @return String
	 */
	public String getName_dep_mp() {
		return ((String) getAttrVal("Name_dep_mp"));
	}
	/**
	 * 执行科室
	 * @param Name_dep_mp
	 */
	public void setName_dep_mp(String Name_dep_mp) {
		setAttrVal("Name_dep_mp", Name_dep_mp);
	}
	/**
	 * 执行科室过滤条件
	 * @return String
	 */
	public String getFilter_dep_mp() {
		return ((String) getAttrVal("Filter_dep_mp"));
	}
	/**
	 * 执行科室过滤条件
	 * @param Filter_dep_mp
	 */
	public void setFilter_dep_mp(String Filter_dep_mp) {
		setAttrVal("Filter_dep_mp", Filter_dep_mp);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getDes_or() {
		return ((String) getAttrVal("Des_or"));
	}
	/**
	 * 备注
	 * @param Des_or
	 */
	public void setDes_or(String Des_or) {
		setAttrVal("Des_or", Des_or);
	}
	/**
	 * 备血用量
	 * @return String
	 */
	public String getQuan_med() {
		return ((String) getAttrVal("Quan_med"));
	}
	/**
	 * 备血用量
	 * @param Quan_med
	 */
	public void setQuan_med(String Quan_med) {
		setAttrVal("Quan_med", Quan_med);
	}
	/**
	 * 计划用血时间
	 * @return FDateTime
	 */
	public FDateTime getDt_bt_pl() {
		return ((FDateTime) getAttrVal("Dt_bt_pl"));
	}
	/**
	 * 计划用血时间
	 * @param Dt_bt_pl
	 */
	public void setDt_bt_pl(FDateTime Dt_bt_pl) {
		setAttrVal("Dt_bt_pl", Dt_bt_pl);
	}
	/**
	 * 输血需求状态ID
	 * @return String
	 */
	public String getId_demandsu_bt() {
		return ((String) getAttrVal("Id_demandsu_bt"));
	}
	/**
	 * 输血需求状态ID
	 * @param Id_demandsu_bt
	 */
	public void setId_demandsu_bt(String Id_demandsu_bt) {
		setAttrVal("Id_demandsu_bt", Id_demandsu_bt);
	}
	/**
	 * 输血需求状态SD
	 * @return String
	 */
	public String getSd_demandsu_bt() {
		return ((String) getAttrVal("Sd_demandsu_bt"));
	}
	/**
	 * 输血需求状态SD
	 * @param Sd_demandsu_bt
	 */
	public void setSd_demandsu_bt(String Sd_demandsu_bt) {
		setAttrVal("Sd_demandsu_bt", Sd_demandsu_bt);
	}
	/**
	 * 输血需求状态
	 * @return String
	 */
	public String getName_demandsu_bt() {
		return ((String) getAttrVal("Name_demandsu_bt"));
	}
	/**
	 * 输血需求状态
	 * @param Name_demandsu_bt
	 */
	public void setName_demandsu_bt(String Name_demandsu_bt) {
		setAttrVal("Name_demandsu_bt", Name_demandsu_bt);
	}
	/**
	 * 诊断ID
	 * @return String
	 */
	public String getId_di() {
		return ((String) getAttrVal("Id_di"));
	}
	/**
	 * 诊断ID
	 * @param Id_di
	 */
	public void setId_di(String Id_di) {
		setAttrVal("Id_di", Id_di);
	}
	/**
	 * 诊断
	 * @return String
	 */
	public String getName_di() {
		return ((String) getAttrVal("Name_di"));
	}
	/**
	 * 诊断
	 * @param Name_di
	 */
	public void setName_di(String Name_di) {
		setAttrVal("Name_di", Name_di);
	}
	/**
	 * 用血目的ID
	 * @return String
	 */
	public String getId_pps_bt() {
		return ((String) getAttrVal("Id_pps_bt"));
	}
	/**
	 * 用血目的ID
	 * @param Id_pps_bt
	 */
	public void setId_pps_bt(String Id_pps_bt) {
		setAttrVal("Id_pps_bt", Id_pps_bt);
	}
	/**
	 * 用血目的SD
	 * @return String
	 */
	public String getSd_pps_bt() {
		return ((String) getAttrVal("Sd_pps_bt"));
	}
	/**
	 * 用血目的SD
	 * @param Sd_pps_bt
	 */
	public void setSd_pps_bt(String Sd_pps_bt) {
		setAttrVal("Sd_pps_bt", Sd_pps_bt);
	}
	/**
	 * 用血目的
	 * @return String
	 */
	public String getName_pps_bt() {
		return ((String) getAttrVal("Name_pps_bt"));
	}
	/**
	 * 用血目的
	 * @param Name_pps_bt
	 */
	public void setName_pps_bt(String Name_pps_bt) {
		setAttrVal("Name_pps_bt", Name_pps_bt);
	}
	/**
	 * 预定输血方式ID
	 * @return String
	 */
	public String getId_mode_bt() {
		return ((String) getAttrVal("Id_mode_bt"));
	}
	/**
	 * 预定输血方式ID
	 * @param Id_mode_bt
	 */
	public void setId_mode_bt(String Id_mode_bt) {
		setAttrVal("Id_mode_bt", Id_mode_bt);
	}
	/**
	 * 预定输血方式SD
	 * @return String
	 */
	public String getSd_mode_bt() {
		return ((String) getAttrVal("Sd_mode_bt"));
	}
	/**
	 * 预定输血方式SD
	 * @param Sd_mode_bt
	 */
	public void setSd_mode_bt(String Sd_mode_bt) {
		setAttrVal("Sd_mode_bt", Sd_mode_bt);
	}
	/**
	 * 预定输血方式
	 * @return String
	 */
	public String getName_mode_bt() {
		return ((String) getAttrVal("Name_mode_bt"));
	}
	/**
	 * 预定输血方式
	 * @param Name_mode_bt
	 */
	public void setName_mode_bt(String Name_mode_bt) {
		setAttrVal("Name_mode_bt", Name_mode_bt);
	}
	/**
	 * 输血史ID
	 * @return String
	 */
	public String getId_his_bt() {
		return ((String) getAttrVal("Id_his_bt"));
	}
	/**
	 * 输血史ID
	 * @param Id_his_bt
	 */
	public void setId_his_bt(String Id_his_bt) {
		setAttrVal("Id_his_bt", Id_his_bt);
	}
	/**
	 * 输血史SD
	 * @return String
	 */
	public String getSd_his_bt() {
		return ((String) getAttrVal("Sd_his_bt"));
	}
	/**
	 * 输血史SD
	 * @param Sd_his_bt
	 */
	public void setSd_his_bt(String Sd_his_bt) {
		setAttrVal("Sd_his_bt", Sd_his_bt);
	}
	/**
	 * 输血史
	 * @return String
	 */
	public String getName_his_bt() {
		return ((String) getAttrVal("Name_his_bt"));
	}
	/**
	 * 输血史
	 * @param Name_his_bt
	 */
	public void setName_his_bt(String Name_his_bt) {
		setAttrVal("Name_his_bt", Name_his_bt);
	}
	/**
	 * 孕
	 * @return Integer
	 */
	public Integer getPregnant_num() {
		return ((Integer) getAttrVal("Pregnant_num"));
	}
	/**
	 * 孕
	 * @param Pregnant_num
	 */
	public void setPregnant_num(Integer Pregnant_num) {
		setAttrVal("Pregnant_num", Pregnant_num);
	}
	/**
	 * 产
	 * @return Integer
	 */
	public Integer getParturition_cnt() {
		return ((Integer) getAttrVal("Parturition_cnt"));
	}
	/**
	 * 产
	 * @param Parturition_cnt
	 */
	public void setParturition_cnt(Integer Parturition_cnt) {
		setAttrVal("Parturition_cnt", Parturition_cnt);
	}
	/**
	 * 献血史
	 * @return FBoolean
	 */
	public FBoolean getFg_db() {
		return ((FBoolean) getAttrVal("Fg_db"));
	}
	/**
	 * 献血史
	 * @param Fg_db
	 */
	public void setFg_db(FBoolean Fg_db) {
		setAttrVal("Fg_db", Fg_db);
	}
	/**
	 * 献血证号
	 * @return String
	 */
	public String getNo_db() {
		return ((String) getAttrVal("No_db"));
	}
	/**
	 * 献血证号
	 * @param No_db
	 */
	public void setNo_db(String No_db) {
		setAttrVal("No_db", No_db);
	}
	/**
	 * sv
	 * @return String
	 */
	public String getSv() {
		return ((String) getAttrVal("Sv"));
	}
	/**
	 * sv
	 * @param Sv
	 */
	public void setSv(String Sv) {
		setAttrVal("Sv", Sv);
	}
}