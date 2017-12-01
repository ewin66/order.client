package iih.ci.ord.dto.BlFeeCiOrderSrvDto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 费用专用实体类 DTO数据 
 * 
 */
public class BlFeeCiOrderSrvDto extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱主键标识
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱主键标识
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 所属集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}
	/**
	 * 所属集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 所属组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}
	/**
	 * 所属组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 患者
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 就诊
	 * @return String
	 */
	public String getId_en() {
		return ((String) getAttrVal("Id_en"));
	}
	/**
	 * 就诊
	 * @param Id_en
	 */
	public void setId_en(String Id_en) {
		setAttrVal("Id_en", Id_en);
	}
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getId_entp() {
		return ((String) getAttrVal("Id_entp"));
	}
	/**
	 * 就诊类型
	 * @param Id_entp
	 */
	public void setId_entp(String Id_entp) {
		setAttrVal("Id_entp", Id_entp);
	}
	/**
	 * 就诊类型编码
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}
	/**
	 * 就诊类型编码
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	/**
	 * 医嘱类型
	 * @return String
	 */
	public String getId_srvtp() {
		return ((String) getAttrVal("Id_srvtp"));
	}
	/**
	 * 医嘱类型
	 * @param Id_srvtp
	 */
	public void setId_srvtp(String Id_srvtp) {
		setAttrVal("Id_srvtp", Id_srvtp);
	}
	/**
	 * 医嘱类型编码
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}
	/**
	 * 医嘱类型编码
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 服务
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 服务
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 服务套标识
	 * @return FBoolean
	 */
	public FBoolean getFg_set() {
		return ((FBoolean) getAttrVal("Fg_set"));
	}
	/**
	 * 服务套标识
	 * @param Fg_set
	 */
	public void setFg_set(FBoolean Fg_set) {
		setAttrVal("Fg_set", Fg_set);
	}
	/**
	 * 医疗服务包
	 * @return String
	 */
	public String getId_srv_pkg() {
		return ((String) getAttrVal("Id_srv_pkg"));
	}
	/**
	 * 医疗服务包
	 * @param Id_srv_pkg
	 */
	public void setId_srv_pkg(String Id_srv_pkg) {
		setAttrVal("Id_srv_pkg", Id_srv_pkg);
	}
	/**
	 * 长临标识
	 * @return FBoolean
	 */
	public FBoolean getFg_long() {
		return ((FBoolean) getAttrVal("Fg_long"));
	}
	/**
	 * 长临标识
	 * @param Fg_long
	 */
	public void setFg_long(FBoolean Fg_long) {
		setAttrVal("Fg_long", Fg_long);
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
	 * 医嘱内容
	 * @return String
	 */
	public String getContent_or() {
		return ((String) getAttrVal("Content_or"));
	}
	/**
	 * 医嘱内容
	 * @param Content_or
	 */
	public void setContent_or(String Content_or) {
		setAttrVal("Content_or", Content_or);
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
	 * 医嘱频次
	 * @return String
	 */
	public String getId_freq() {
		return ((String) getAttrVal("Id_freq"));
	}
	/**
	 * 医嘱频次
	 * @param Id_freq
	 */
	public void setId_freq(String Id_freq) {
		setAttrVal("Id_freq", Id_freq);
	}
	/**
	 * 医嘱付数
	 * @return Integer
	 */
	public Integer getOrders() {
		return ((Integer) getAttrVal("Orders"));
	}
	/**
	 * 医嘱付数
	 * @param Orders
	 */
	public void setOrders(Integer Orders) {
		setAttrVal("Orders", Orders);
	}
	/**
	 * 代煎标识
	 * @return FBoolean
	 */
	public FBoolean getFg_boil() {
		return ((FBoolean) getAttrVal("Fg_boil"));
	}
	/**
	 * 代煎标识
	 * @param Fg_boil
	 */
	public void setFg_boil(FBoolean Fg_boil) {
		setAttrVal("Fg_boil", Fg_boil);
	}
	/**
	 * 代煎付数
	 * @return Integer
	 */
	public Integer getOrders_boil() {
		return ((Integer) getAttrVal("Orders_boil"));
	}
	/**
	 * 代煎付数
	 * @param Orders_boil
	 */
	public void setOrders_boil(Integer Orders_boil) {
		setAttrVal("Orders_boil", Orders_boil);
	}
	/**
	 * 医嘱用法
	 * @return String
	 */
	public String getId_route() {
		return ((String) getAttrVal("Id_route"));
	}
	/**
	 * 医嘱用法
	 * @param Id_route
	 */
	public void setId_route(String Id_route) {
		setAttrVal("Id_route", Id_route);
	}
	/**
	 * 医嘱用法要求
	 * @return String
	 */
	public String getId_routedes() {
		return ((String) getAttrVal("Id_routedes"));
	}
	/**
	 * 医嘱用法要求
	 * @param Id_routedes
	 */
	public void setId_routedes(String Id_routedes) {
		setAttrVal("Id_routedes", Id_routedes);
	}
	/**
	 * 煎法
	 * @return String
	 */
	public String getId_boil() {
		return ((String) getAttrVal("Id_boil"));
	}
	/**
	 * 煎法
	 * @param Id_boil
	 */
	public void setId_boil(String Id_boil) {
		setAttrVal("Id_boil", Id_boil);
	}
	/**
	 * 煎法要求
	 * @return String
	 */
	public String getId_boildes() {
		return ((String) getAttrVal("Id_boildes"));
	}
	/**
	 * 煎法要求
	 * @param Id_boildes
	 */
	public void setId_boildes(String Id_boildes) {
		setAttrVal("Id_boildes", Id_boildes);
	}
	/**
	 * 医嘱状态
	 * @return String
	 */
	public String getId_su_or() {
		return ((String) getAttrVal("Id_su_or"));
	}
	/**
	 * 医嘱状态
	 * @param Id_su_or
	 */
	public void setId_su_or(String Id_su_or) {
		setAttrVal("Id_su_or", Id_su_or);
	}
	/**
	 * 医嘱天数
	 * @return Integer
	 */
	public Integer getDays_or() {
		return ((Integer) getAttrVal("Days_or"));
	}
	/**
	 * 医嘱天数
	 * @param Days_or
	 */
	public void setDays_or(Integer Days_or) {
		setAttrVal("Days_or", Days_or);
	}
	/**
	 * 医嘱状态编码
	 * @return String
	 */
	public String getSd_su_or() {
		return ((String) getAttrVal("Sd_su_or"));
	}
	/**
	 * 医嘱状态编码
	 * @param Sd_su_or
	 */
	public void setSd_su_or(String Sd_su_or) {
		setAttrVal("Sd_su_or", Sd_su_or);
	}
	/**
	 * 执行状态
	 * @return String
	 */
	public String getId_su_mp() {
		return ((String) getAttrVal("Id_su_mp"));
	}
	/**
	 * 执行状态
	 * @param Id_su_mp
	 */
	public void setId_su_mp(String Id_su_mp) {
		setAttrVal("Id_su_mp", Id_su_mp);
	}
	/**
	 * 执行状态编码
	 * @return String
	 */
	public String getSd_su_mp() {
		return ((String) getAttrVal("Sd_su_mp"));
	}
	/**
	 * 执行状态编码
	 * @param Sd_su_mp
	 */
	public void setSd_su_mp(String Sd_su_mp) {
		setAttrVal("Sd_su_mp", Sd_su_mp);
	}
	/**
	 * 记账状态
	 * @return String
	 */
	public String getId_su_bl() {
		return ((String) getAttrVal("Id_su_bl"));
	}
	/**
	 * 记账状态
	 * @param Id_su_bl
	 */
	public void setId_su_bl(String Id_su_bl) {
		setAttrVal("Id_su_bl", Id_su_bl);
	}
	/**
	 * 记账状态编码
	 * @return String
	 */
	public String getSd_su_bl() {
		return ((String) getAttrVal("Sd_su_bl"));
	}
	/**
	 * 记账状态编码
	 * @param Sd_su_bl
	 */
	public void setSd_su_bl(String Sd_su_bl) {
		setAttrVal("Sd_su_bl", Sd_su_bl);
	}
	/**
	 * 开立机构
	 * @return String
	 */
	public String getId_org_or() {
		return ((String) getAttrVal("Id_org_or"));
	}
	/**
	 * 开立机构
	 * @param Id_org_or
	 */
	public void setId_org_or(String Id_org_or) {
		setAttrVal("Id_org_or", Id_org_or);
	}
	/**
	 * 开立部门
	 * @return String
	 */
	public String getId_dep_or() {
		return ((String) getAttrVal("Id_dep_or"));
	}
	/**
	 * 开立部门
	 * @param Id_dep_or
	 */
	public void setId_dep_or(String Id_dep_or) {
		setAttrVal("Id_dep_or", Id_dep_or);
	}
	/**
	 * 开立医疗组
	 * @return String
	 */
	public String getId_wg_or() {
		return ((String) getAttrVal("Id_wg_or"));
	}
	/**
	 * 开立医疗组
	 * @param Id_wg_or
	 */
	public void setId_wg_or(String Id_wg_or) {
		setAttrVal("Id_wg_or", Id_wg_or);
	}
	/**
	 * 开立医生
	 * @return String
	 */
	public String getId_emp_or() {
		return ((String) getAttrVal("Id_emp_or"));
	}
	/**
	 * 开立医生
	 * @param Id_emp_or
	 */
	public void setId_emp_or(String Id_emp_or) {
		setAttrVal("Id_emp_or", Id_emp_or);
	}
	/**
	 * 开立日期
	 * @return FDateTime
	 */
	public FDateTime getDt_entry() {
		return ((FDateTime) getAttrVal("Dt_entry"));
	}
	/**
	 * 开立日期
	 * @param Dt_entry
	 */
	public void setDt_entry(FDateTime Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	/**
	 * 签署标识
	 * @return FBoolean
	 */
	public FBoolean getFg_sign() {
		return ((FBoolean) getAttrVal("Fg_sign"));
	}
	/**
	 * 签署标识
	 * @param Fg_sign
	 */
	public void setFg_sign(FBoolean Fg_sign) {
		setAttrVal("Fg_sign", Fg_sign);
	}
	/**
	 * 签署医生
	 * @return String
	 */
	public String getId_emp_sign() {
		return ((String) getAttrVal("Id_emp_sign"));
	}
	/**
	 * 签署医生
	 * @param Id_emp_sign
	 */
	public void setId_emp_sign(String Id_emp_sign) {
		setAttrVal("Id_emp_sign", Id_emp_sign);
	}
	/**
	 * 签署部门
	 * @return String
	 */
	public String getId_dep_sign() {
		return ((String) getAttrVal("Id_dep_sign"));
	}
	/**
	 * 签署部门
	 * @param Id_dep_sign
	 */
	public void setId_dep_sign(String Id_dep_sign) {
		setAttrVal("Id_dep_sign", Id_dep_sign);
	}
	/**
	 * 签署日期
	 * @return FDateTime
	 */
	public FDateTime getDt_sign() {
		return ((FDateTime) getAttrVal("Dt_sign"));
	}
	/**
	 * 签署日期
	 * @param Dt_sign
	 */
	public void setDt_sign(FDateTime Dt_sign) {
		setAttrVal("Dt_sign", Dt_sign);
	}
	/**
	 * 医嘱生效日期
	 * @return FDateTime
	 */
	public FDateTime getDt_effe() {
		return ((FDateTime) getAttrVal("Dt_effe"));
	}
	/**
	 * 医嘱生效日期
	 * @param Dt_effe
	 */
	public void setDt_effe(FDateTime Dt_effe) {
		setAttrVal("Dt_effe", Dt_effe);
	}
	/**
	 * 医嘱结束时间
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}
	/**
	 * 医嘱结束时间
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 医嘱过期时间
	 * @return FDateTime
	 */
	public FDateTime getDt_invalid() {
		return ((FDateTime) getAttrVal("Dt_invalid"));
	}
	/**
	 * 医嘱过期时间
	 * @param Dt_invalid
	 */
	public void setDt_invalid(FDateTime Dt_invalid) {
		setAttrVal("Dt_invalid", Dt_invalid);
	}
	/**
	 * 核对标识
	 * @return FBoolean
	 */
	public FBoolean getFg_chk() {
		return ((FBoolean) getAttrVal("Fg_chk"));
	}
	/**
	 * 核对标识
	 * @param Fg_chk
	 */
	public void setFg_chk(FBoolean Fg_chk) {
		setAttrVal("Fg_chk", Fg_chk);
	}
	/**
	 * 核对护士
	 * @return String
	 */
	public String getId_emp_chk() {
		return ((String) getAttrVal("Id_emp_chk"));
	}
	/**
	 * 核对护士
	 * @param Id_emp_chk
	 */
	public void setId_emp_chk(String Id_emp_chk) {
		setAttrVal("Id_emp_chk", Id_emp_chk);
	}
	/**
	 * 核对病区
	 * @return String
	 */
	public String getId_dep_chk() {
		return ((String) getAttrVal("Id_dep_chk"));
	}
	/**
	 * 核对病区
	 * @param Id_dep_chk
	 */
	public void setId_dep_chk(String Id_dep_chk) {
		setAttrVal("Id_dep_chk", Id_dep_chk);
	}
	/**
	 * 核对日期
	 * @return FDateTime
	 */
	public FDateTime getDt_chk() {
		return ((FDateTime) getAttrVal("Dt_chk"));
	}
	/**
	 * 核对日期
	 * @param Dt_chk
	 */
	public void setDt_chk(FDateTime Dt_chk) {
		setAttrVal("Dt_chk", Dt_chk);
	}
	/**
	 * 停止标识
	 * @return FBoolean
	 */
	public FBoolean getFg_stop() {
		return ((FBoolean) getAttrVal("Fg_stop"));
	}
	/**
	 * 停止标识
	 * @param Fg_stop
	 */
	public void setFg_stop(FBoolean Fg_stop) {
		setAttrVal("Fg_stop", Fg_stop);
	}
	/**
	 * 停止医生
	 * @return String
	 */
	public String getId_emp_stop() {
		return ((String) getAttrVal("Id_emp_stop"));
	}
	/**
	 * 停止医生
	 * @param Id_emp_stop
	 */
	public void setId_emp_stop(String Id_emp_stop) {
		setAttrVal("Id_emp_stop", Id_emp_stop);
	}
	/**
	 * 停止科室
	 * @return String
	 */
	public String getId_dep_stop() {
		return ((String) getAttrVal("Id_dep_stop"));
	}
	/**
	 * 停止科室
	 * @param Id_dep_stop
	 */
	public void setId_dep_stop(String Id_dep_stop) {
		setAttrVal("Id_dep_stop", Id_dep_stop);
	}
	/**
	 * 停止日期
	 * @return FDateTime
	 */
	public FDateTime getDt_stop() {
		return ((FDateTime) getAttrVal("Dt_stop"));
	}
	/**
	 * 停止日期
	 * @param Dt_stop
	 */
	public void setDt_stop(FDateTime Dt_stop) {
		setAttrVal("Dt_stop", Dt_stop);
	}
	/**
	 * 停止核对标识
	 * @return FBoolean
	 */
	public FBoolean getFg_chk_stop() {
		return ((FBoolean) getAttrVal("Fg_chk_stop"));
	}
	/**
	 * 停止核对标识
	 * @param Fg_chk_stop
	 */
	public void setFg_chk_stop(FBoolean Fg_chk_stop) {
		setAttrVal("Fg_chk_stop", Fg_chk_stop);
	}
	/**
	 * 停止核对护士
	 * @return String
	 */
	public String getId_emp_chk_stop() {
		return ((String) getAttrVal("Id_emp_chk_stop"));
	}
	/**
	 * 停止核对护士
	 * @param Id_emp_chk_stop
	 */
	public void setId_emp_chk_stop(String Id_emp_chk_stop) {
		setAttrVal("Id_emp_chk_stop", Id_emp_chk_stop);
	}
	/**
	 * 停止核对病区
	 * @return String
	 */
	public String getId_dep_chk_stop() {
		return ((String) getAttrVal("Id_dep_chk_stop"));
	}
	/**
	 * 停止核对病区
	 * @param Id_dep_chk_stop
	 */
	public void setId_dep_chk_stop(String Id_dep_chk_stop) {
		setAttrVal("Id_dep_chk_stop", Id_dep_chk_stop);
	}
	/**
	 * 停止核对日期
	 * @return FDateTime
	 */
	public FDateTime getDt_chk_stop() {
		return ((FDateTime) getAttrVal("Dt_chk_stop"));
	}
	/**
	 * 停止核对日期
	 * @param Dt_chk_stop
	 */
	public void setDt_chk_stop(FDateTime Dt_chk_stop) {
		setAttrVal("Dt_chk_stop", Dt_chk_stop);
	}
	/**
	 * 作废标识
	 * @return FBoolean
	 */
	public FBoolean getFg_canc() {
		return ((FBoolean) getAttrVal("Fg_canc"));
	}
	/**
	 * 作废标识
	 * @param Fg_canc
	 */
	public void setFg_canc(FBoolean Fg_canc) {
		setAttrVal("Fg_canc", Fg_canc);
	}
	/**
	 * 作废医生
	 * @return String
	 */
	public String getId_emp_canc() {
		return ((String) getAttrVal("Id_emp_canc"));
	}
	/**
	 * 作废医生
	 * @param Id_emp_canc
	 */
	public void setId_emp_canc(String Id_emp_canc) {
		setAttrVal("Id_emp_canc", Id_emp_canc);
	}
	/**
	 * 作废科室
	 * @return String
	 */
	public String getId_dep_canc() {
		return ((String) getAttrVal("Id_dep_canc"));
	}
	/**
	 * 作废科室
	 * @param Id_dep_canc
	 */
	public void setId_dep_canc(String Id_dep_canc) {
		setAttrVal("Id_dep_canc", Id_dep_canc);
	}
	/**
	 * 作废日期
	 * @return FDateTime
	 */
	public FDateTime getDt_canc() {
		return ((FDateTime) getAttrVal("Dt_canc"));
	}
	/**
	 * 作废日期
	 * @param Dt_canc
	 */
	public void setDt_canc(FDateTime Dt_canc) {
		setAttrVal("Dt_canc", Dt_canc);
	}
	/**
	 * 作废核对标识
	 * @return FBoolean
	 */
	public FBoolean getFg_chk_canc() {
		return ((FBoolean) getAttrVal("Fg_chk_canc"));
	}
	/**
	 * 作废核对标识
	 * @param Fg_chk_canc
	 */
	public void setFg_chk_canc(FBoolean Fg_chk_canc) {
		setAttrVal("Fg_chk_canc", Fg_chk_canc);
	}
	/**
	 * 作废核对护士
	 * @return String
	 */
	public String getId_emp_chk_canc() {
		return ((String) getAttrVal("Id_emp_chk_canc"));
	}
	/**
	 * 作废核对护士
	 * @param Id_emp_chk_canc
	 */
	public void setId_emp_chk_canc(String Id_emp_chk_canc) {
		setAttrVal("Id_emp_chk_canc", Id_emp_chk_canc);
	}
	/**
	 * 作废核对病区
	 * @return String
	 */
	public String getId_dep_chk_canc() {
		return ((String) getAttrVal("Id_dep_chk_canc"));
	}
	/**
	 * 作废核对病区
	 * @param Id_dep_chk_canc
	 */
	public void setId_dep_chk_canc(String Id_dep_chk_canc) {
		setAttrVal("Id_dep_chk_canc", Id_dep_chk_canc);
	}
	/**
	 * 作废核对日期
	 * @return FDateTime
	 */
	public FDateTime getDt_chk_canc() {
		return ((FDateTime) getAttrVal("Dt_chk_canc"));
	}
	/**
	 * 作废核对日期
	 * @param Dt_chk_canc
	 */
	public void setDt_chk_canc(FDateTime Dt_chk_canc) {
		setAttrVal("Dt_chk_canc", Dt_chk_canc);
	}
	/**
	 * 备用医嘱标识
	 * @return FBoolean
	 */
	public FBoolean getFg_pmor() {
		return ((FBoolean) getAttrVal("Fg_pmor"));
	}
	/**
	 * 备用医嘱标识
	 * @param Fg_pmor
	 */
	public void setFg_pmor(FBoolean Fg_pmor) {
		setAttrVal("Fg_pmor", Fg_pmor);
	}
	/**
	 * 备用医嘱使用条件描述
	 * @return String
	 */
	public String getDes_pmor() {
		return ((String) getAttrVal("Des_pmor"));
	}
	/**
	 * 备用医嘱使用条件描述
	 * @param Des_pmor
	 */
	public void setDes_pmor(String Des_pmor) {
		setAttrVal("Des_pmor", Des_pmor);
	}
	/**
	 * 备用医嘱启用标识
	 * @return FBoolean
	 */
	public FBoolean getFg_active_pm() {
		return ((FBoolean) getAttrVal("Fg_active_pm"));
	}
	/**
	 * 备用医嘱启用标识
	 * @param Fg_active_pm
	 */
	public void setFg_active_pm(FBoolean Fg_active_pm) {
		setAttrVal("Fg_active_pm", Fg_active_pm);
	}
	/**
	 * 关联类型
	 * @return String
	 */
	public String getId_reltp() {
		return ((String) getAttrVal("Id_reltp"));
	}
	/**
	 * 关联类型
	 * @param Id_reltp
	 */
	public void setId_reltp(String Id_reltp) {
		setAttrVal("Id_reltp", Id_reltp);
	}
	/**
	 * 关联类型编码
	 * @return String
	 */
	public String getSd_reltp() {
		return ((String) getAttrVal("Sd_reltp"));
	}
	/**
	 * 关联类型编码
	 * @param Sd_reltp
	 */
	public void setSd_reltp(String Sd_reltp) {
		setAttrVal("Sd_reltp", Sd_reltp);
	}
	/**
	 * 对应关联医嘱id
	 * @return String
	 */
	public String getId_or_rel() {
		return ((String) getAttrVal("Id_or_rel"));
	}
	/**
	 * 对应关联医嘱id
	 * @param Id_or_rel
	 */
	public void setId_or_rel(String Id_or_rel) {
		setAttrVal("Id_or_rel", Id_or_rel);
	}
	/**
	 * 婴儿标识
	 * @return FBoolean
	 */
	public FBoolean getFg_bb() {
		return ((FBoolean) getAttrVal("Fg_bb"));
	}
	/**
	 * 婴儿标识
	 * @param Fg_bb
	 */
	public void setFg_bb(FBoolean Fg_bb) {
		setAttrVal("Fg_bb", Fg_bb);
	}
	/**
	 * 婴儿序号
	 * @return Integer
	 */
	public Integer getNo_bb() {
		return ((Integer) getAttrVal("No_bb"));
	}
	/**
	 * 婴儿序号
	 * @param No_bb
	 */
	public void setNo_bb(Integer No_bb) {
		setAttrVal("No_bb", No_bb);
	}
	/**
	 * 临床路径控制标识
	 * @return FBoolean
	 */
	public FBoolean getFg_ctlcp() {
		return ((FBoolean) getAttrVal("Fg_ctlcp"));
	}
	/**
	 * 临床路径控制标识
	 * @param Fg_ctlcp
	 */
	public void setFg_ctlcp(FBoolean Fg_ctlcp) {
		setAttrVal("Fg_ctlcp", Fg_ctlcp);
	}
	/**
	 * 医疗记录联动标识
	 * @return FBoolean
	 */
	public FBoolean getFg_mr() {
		return ((FBoolean) getAttrVal("Fg_mr"));
	}
	/**
	 * 医疗记录联动标识
	 * @param Fg_mr
	 */
	public void setFg_mr(FBoolean Fg_mr) {
		setAttrVal("Fg_mr", Fg_mr);
	}
	/**
	 * 皮试标识
	 * @return FBoolean
	 */
	public FBoolean getFg_skintest() {
		return ((FBoolean) getAttrVal("Fg_skintest"));
	}
	/**
	 * 皮试标识
	 * @param Fg_skintest
	 */
	public void setFg_skintest(FBoolean Fg_skintest) {
		setAttrVal("Fg_skintest", Fg_skintest);
	}
	/**
	 * 在院执行标识
	 * @return FBoolean
	 */
	public FBoolean getFg_mp_in() {
		return ((FBoolean) getAttrVal("Fg_mp_in"));
	}
	/**
	 * 在院执行标识
	 * @param Fg_mp_in
	 */
	public void setFg_mp_in(FBoolean Fg_mp_in) {
		setAttrVal("Fg_mp_in", Fg_mp_in);
	}
	/**
	 * 在院执行次数
	 * @return Integer
	 */
	public Integer getTimes_mp_in() {
		return ((Integer) getAttrVal("Times_mp_in"));
	}
	/**
	 * 在院执行次数
	 * @param Times_mp_in
	 */
	public void setTimes_mp_in(Integer Times_mp_in) {
		setAttrVal("Times_mp_in", Times_mp_in);
	}
	/**
	 * 床边执行标识
	 * @return FBoolean
	 */
	public FBoolean getFg_mp_bed() {
		return ((FBoolean) getAttrVal("Fg_mp_bed"));
	}
	/**
	 * 床边执行标识
	 * @param Fg_mp_bed
	 */
	public void setFg_mp_bed(FBoolean Fg_mp_bed) {
		setAttrVal("Fg_mp_bed", Fg_mp_bed);
	}
	/**
	 * 医嘱备注
	 * @return String
	 */
	public String getNote_or() {
		return ((String) getAttrVal("Note_or"));
	}
	/**
	 * 医嘱备注
	 * @param Note_or
	 */
	public void setNote_or(String Note_or) {
		setAttrVal("Note_or", Note_or);
	}
	/**
	 * 创建人
	 * @return String
	 */
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}
	/**
	 * 创建人
	 * @param Createdby
	 */
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	/**
	 * 创建时间
	 * @return FDateTime
	 */
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}
	/**
	 * 创建时间
	 * @param Createdtime
	 */
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	/**
	 * 最后修改人
	 * @return String
	 */
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}
	/**
	 * 最后修改人
	 * @param Modifiedby
	 */
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	/**
	 * 最后修改时间
	 * @return FDateTime
	 */
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}
	/**
	 * 最后修改时间
	 * @param Modifiedtime
	 */
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
	}
	/**
	 * 药师审核状态
	 * @return Integer
	 */
	public Integer getEu_verify_pharm() {
		return ((Integer) getAttrVal("Eu_verify_pharm"));
	}
	/**
	 * 药师审核状态
	 * @param Eu_verify_pharm
	 */
	public void setEu_verify_pharm(Integer Eu_verify_pharm) {
		setAttrVal("Eu_verify_pharm", Eu_verify_pharm);
	}
	/**
	 * 药师审核建议
	 * @return String
	 */
	public String getDes_verify_pharm() {
		return ((String) getAttrVal("Des_verify_pharm"));
	}
	/**
	 * 药师审核建议
	 * @param Des_verify_pharm
	 */
	public void setDes_verify_pharm(String Des_verify_pharm) {
		setAttrVal("Des_verify_pharm", Des_verify_pharm);
	}
	/**
	 * 药师审核异常级别
	 * @return String
	 */
	public String getId_ecep_level_pharm() {
		return ((String) getAttrVal("Id_ecep_level_pharm"));
	}
	/**
	 * 药师审核异常级别
	 * @param Id_ecep_level_pharm
	 */
	public void setId_ecep_level_pharm(String Id_ecep_level_pharm) {
		setAttrVal("Id_ecep_level_pharm", Id_ecep_level_pharm);
	}
	/**
	 * 药师审核异常级别编码
	 * @return String
	 */
	public String getSd_excep_level_pharm() {
		return ((String) getAttrVal("Sd_excep_level_pharm"));
	}
	/**
	 * 药师审核异常级别编码
	 * @param Sd_excep_level_pharm
	 */
	public void setSd_excep_level_pharm(String Sd_excep_level_pharm) {
		setAttrVal("Sd_excep_level_pharm", Sd_excep_level_pharm);
	}
	/**
	 * 合理用药审核结果
	 * @return String
	 */
	public String getDes_verify_sys() {
		return ((String) getAttrVal("Des_verify_sys"));
	}
	/**
	 * 合理用药审核结果
	 * @param Des_verify_sys
	 */
	public void setDes_verify_sys(String Des_verify_sys) {
		setAttrVal("Des_verify_sys", Des_verify_sys);
	}
	/**
	 * 合理用药审核异常级别
	 * @return String
	 */
	public String getId_ecep_level_sys() {
		return ((String) getAttrVal("Id_ecep_level_sys"));
	}
	/**
	 * 合理用药审核异常级别
	 * @param Id_ecep_level_sys
	 */
	public void setId_ecep_level_sys(String Id_ecep_level_sys) {
		setAttrVal("Id_ecep_level_sys", Id_ecep_level_sys);
	}
	/**
	 * 合理用药审核异常级别编码
	 * @return String
	 */
	public String getSd_excep_level_sys() {
		return ((String) getAttrVal("Sd_excep_level_sys"));
	}
	/**
	 * 合理用药审核异常级别编码
	 * @param Sd_excep_level_sys
	 */
	public void setSd_excep_level_sys(String Sd_excep_level_sys) {
		setAttrVal("Sd_excep_level_sys", Sd_excep_level_sys);
	}
	/**
	 * 审核药师
	 * @return String
	 */
	public String getId_emp_verify_pharm() {
		return ((String) getAttrVal("Id_emp_verify_pharm"));
	}
	/**
	 * 审核药师
	 * @param Id_emp_verify_pharm
	 */
	public void setId_emp_verify_pharm(String Id_emp_verify_pharm) {
		setAttrVal("Id_emp_verify_pharm", Id_emp_verify_pharm);
	}
	/**
	 * 药师审核时间
	 * @return FDateTime
	 */
	public FDateTime getDt_verify_pharm() {
		return ((FDateTime) getAttrVal("Dt_verify_pharm"));
	}
	/**
	 * 药师审核时间
	 * @param Dt_verify_pharm
	 */
	public void setDt_verify_pharm(FDateTime Dt_verify_pharm) {
		setAttrVal("Dt_verify_pharm", Dt_verify_pharm);
	}
	/**
	 * 医师反馈意见
	 * @return String
	 */
	public String getDes_bk_pharm() {
		return ((String) getAttrVal("Des_bk_pharm"));
	}
	/**
	 * 医师反馈意见
	 * @param Des_bk_pharm
	 */
	public void setDes_bk_pharm(String Des_bk_pharm) {
		setAttrVal("Des_bk_pharm", Des_bk_pharm);
	}
	/**
	 * 医师反馈时间
	 * @return FDateTime
	 */
	public FDateTime getDt_bk_pharm() {
		return ((FDateTime) getAttrVal("Dt_bk_pharm"));
	}
	/**
	 * 医师反馈时间
	 * @param Dt_bk_pharm
	 */
	public void setDt_bk_pharm(FDateTime Dt_bk_pharm) {
		setAttrVal("Dt_bk_pharm", Dt_bk_pharm);
	}
	/**
	 * 反馈医师
	 * @return String
	 */
	public String getId_emp_bk_pharm() {
		return ((String) getAttrVal("Id_emp_bk_pharm"));
	}
	/**
	 * 反馈医师
	 * @param Id_emp_bk_pharm
	 */
	public void setId_emp_bk_pharm(String Id_emp_bk_pharm) {
		setAttrVal("Id_emp_bk_pharm", Id_emp_bk_pharm);
	}
	/**
	 * 服务包标识
	 * @return FBoolean
	 */
	public FBoolean getFg_pkg() {
		return ((FBoolean) getAttrVal("Fg_pkg"));
	}
	/**
	 * 服务包标识
	 * @param Fg_pkg
	 */
	public void setFg_pkg(FBoolean Fg_pkg) {
		setAttrVal("Fg_pkg", Fg_pkg);
	}
	/**
	 * 长临
	 * @return String
	 */
	public String getStr_long() {
		return ((String) getAttrVal("Str_long"));
	}
	/**
	 * 长临
	 * @param Str_long
	 */
	public void setStr_long(String Str_long) {
		setAttrVal("Str_long", Str_long);
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
	 * 首日执行次数
	 * @return Integer
	 */
	public Integer getQuan_firday_mp() {
		return ((Integer) getAttrVal("Quan_firday_mp"));
	}
	/**
	 * 首日执行次数
	 * @param Quan_firday_mp
	 */
	public void setQuan_firday_mp(Integer Quan_firday_mp) {
		setAttrVal("Quan_firday_mp", Quan_firday_mp);
	}
	/**
	 * 医嘱单标识
	 * @return FBoolean
	 */
	public FBoolean getFg_or_form() {
		return ((FBoolean) getAttrVal("Fg_or_form"));
	}
	/**
	 * 医嘱单标识
	 * @param Fg_or_form
	 */
	public void setFg_or_form(FBoolean Fg_or_form) {
		setAttrVal("Fg_or_form", Fg_or_form);
	}
	/**
	 * 不皮试原因（废弃不用了）
	 * @return String
	 */
	public String getId_skintest_skip_reason() {
		return ((String) getAttrVal("Id_skintest_skip_reason"));
	}
	/**
	 * 不皮试原因（废弃不用了）
	 * @param Id_skintest_skip_reason
	 */
	public void setId_skintest_skip_reason(String Id_skintest_skip_reason) {
		setAttrVal("Id_skintest_skip_reason", Id_skintest_skip_reason);
	}
	/**
	 * 不皮试原因编码（废弃不用了）
	 * @return String
	 */
	public String getSd_skintest_skip_reason() {
		return ((String) getAttrVal("Sd_skintest_skip_reason"));
	}
	/**
	 * 不皮试原因编码（废弃不用了）
	 * @param Sd_skintest_skip_reason
	 */
	public void setSd_skintest_skip_reason(String Sd_skintest_skip_reason) {
		setAttrVal("Sd_skintest_skip_reason", Sd_skintest_skip_reason);
	}
	/**
	 * 出院带药标识
	 * @return FBoolean
	 */
	public FBoolean getFg_pres_outp() {
		return ((FBoolean) getAttrVal("Fg_pres_outp"));
	}
	/**
	 * 出院带药标识
	 * @param Fg_pres_outp
	 */
	public void setFg_pres_outp(FBoolean Fg_pres_outp) {
		setAttrVal("Fg_pres_outp", Fg_pres_outp);
	}
	/**
	 * 医疗单URL
	 * @return String
	 */
	public String getFuncclassstr() {
		return ((String) getAttrVal("Funcclassstr"));
	}
	/**
	 * 医疗单URL
	 * @param Funcclassstr
	 */
	public void setFuncclassstr(String Funcclassstr) {
		setAttrVal("Funcclassstr", Funcclassstr);
	}
	/**
	 * 医疗单
	 * @return String
	 */
	public String getId_srvof() {
		return ((String) getAttrVal("Id_srvof"));
	}
	/**
	 * 医疗单
	 * @param Id_srvof
	 */
	public void setId_srvof(String Id_srvof) {
		setAttrVal("Id_srvof", Id_srvof);
	}
	/**
	 * 申请单号
	 * @return String
	 */
	public String getApplyno() {
		return ((String) getAttrVal("Applyno"));
	}
	/**
	 * 申请单号
	 * @param Applyno
	 */
	public void setApplyno(String Applyno) {
		setAttrVal("Applyno", Applyno);
	}
	/**
	 * 服务项目主键标识
	 * @return String
	 */
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}
	/**
	 * 服务项目主键标识
	 * @param Id_orsrv
	 */
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
	/**
	 * 药品处方
	 * @return String
	 */
	public String getId_pres() {
		return ((String) getAttrVal("Id_pres"));
	}
	/**
	 * 药品处方
	 * @param Id_pres
	 */
	public void setId_pres(String Id_pres) {
		setAttrVal("Id_pres", Id_pres);
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
	 * 服务项目名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 服务项目名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 不规则剂量标识
	 * @return FBoolean
	 */
	public FBoolean getFg_dose_anoma() {
		return ((FBoolean) getAttrVal("Fg_dose_anoma"));
	}
	/**
	 * 不规则剂量标识
	 * @param Fg_dose_anoma
	 */
	public void setFg_dose_anoma(FBoolean Fg_dose_anoma) {
		setAttrVal("Fg_dose_anoma", Fg_dose_anoma);
	}
	/**
	 * 数值_医疗单位
	 * @return FDouble
	 */
	public FDouble getQuan_medu() {
		return ((FDouble) getAttrVal("Quan_medu"));
	}
	/**
	 * 数值_医疗单位
	 * @param Quan_medu
	 */
	public void setQuan_medu(FDouble Quan_medu) {
		setAttrVal("Quan_medu", Quan_medu);
	}
	
	/**
	 * 数值总量_医疗单位
	 * @return FDouble
	 */
	public FDouble getQuan_total_medu() {
		return ((FDouble) getAttrVal("Quan_total_medu"));
	}
	/**
	 * 数值总量_医疗单位
	 * @param Quan_total_medu
	 */
	public void setQuan_total_medu(FDouble Quan_total_medu) {
		setAttrVal("Quan_total_medu", Quan_total_medu);
	}
	
	/**
	 * 医疗单位
	 * @return String
	 */
	public String getId_medu() {
		return ((String) getAttrVal("Id_medu"));
	}
	/**
	 * 医疗单位
	 * @param Id_medu
	 */
	public void setId_medu(String Id_medu) {
		setAttrVal("Id_medu", Id_medu);
	}
	/**
	 * 服务项目开立机构
	 * @return String
	 */
	public String getId_org_srv() {
		return ((String) getAttrVal("Id_org_srv"));
	}
	/**
	 * 服务项目开立机构
	 * @param Id_org_srv
	 */
	public void setId_org_srv(String Id_org_srv) {
		setAttrVal("Id_org_srv", Id_org_srv);
	}
	/**
	 * 服务项目开立科室
	 * @return String
	 */
	public String getId_dep_srv() {
		return ((String) getAttrVal("Id_dep_srv"));
	}
	/**
	 * 服务项目开立科室
	 * @param Id_dep_srv
	 */
	public void setId_dep_srv(String Id_dep_srv) {
		setAttrVal("Id_dep_srv", Id_dep_srv);
	}
	/**
	 * 服务项目开立医生
	 * @return String
	 */
	public String getId_emp_srv() {
		return ((String) getAttrVal("Id_emp_srv"));
	}
	/**
	 * 服务项目开立医生
	 * @param Id_emp_srv
	 */
	public void setId_emp_srv(String Id_emp_srv) {
		setAttrVal("Id_emp_srv", Id_emp_srv);
	}
	/**
	 * 服务项目立时间
	 * @return FDateTime
	 */
	public FDateTime getDt_create() {
		return ((FDateTime) getAttrVal("Dt_create"));
	}
	/**
	 * 服务项目立时间
	 * @param Dt_create
	 */
	public void setDt_create(FDateTime Dt_create) {
		setAttrVal("Dt_create", Dt_create);
	}
	/**
	 * 执行机构
	 * @return String
	 */
	public String getId_org_mp() {
		return ((String) getAttrVal("Id_org_mp"));
	}
	/**
	 * 执行机构
	 * @param Id_org_mp
	 */
	public void setId_org_mp(String Id_org_mp) {
		setAttrVal("Id_org_mp", Id_org_mp);
	}
	/**
	 * 执行科室
	 * @return String
	 */
	public String getId_dep_mp() {
		return ((String) getAttrVal("Id_dep_mp"));
	}
	/**
	 * 执行科室
	 * @param Id_dep_mp
	 */
	public void setId_dep_mp(String Id_dep_mp) {
		setAttrVal("Id_dep_mp", Id_dep_mp);
	}
	/**
	 * 最近执行日期
	 * @return FDateTime
	 */
	public FDateTime getDt_last_mp() {
		return ((FDateTime) getAttrVal("Dt_last_mp"));
	}
	/**
	 * 最近执行日期
	 * @param Dt_last_mp
	 */
	public void setDt_last_mp(FDateTime Dt_last_mp) {
		setAttrVal("Dt_last_mp", Dt_last_mp);
	}
	/**
	 * 最近生成日期
	 * @return FDateTime
	 */
	public FDateTime getDt_last_bl() {
		return ((FDateTime) getAttrVal("Dt_last_bl"));
	}
	/**
	 * 最近生成日期
	 * @param Dt_last_bl
	 */
	public void setDt_last_bl(FDateTime Dt_last_bl) {
		setAttrVal("Dt_last_bl", Dt_last_bl);
	}
	/**
	 * 医嘱标识
	 * @return FBoolean
	 */
	public FBoolean getFg_or() {
		return ((FBoolean) getAttrVal("Fg_or"));
	}
	/**
	 * 医嘱标识
	 * @param Fg_or
	 */
	public void setFg_or(FBoolean Fg_or) {
		setAttrVal("Fg_or", Fg_or);
	}
	/**
	 * 记费模式
	 * @return Integer
	 */
	public Integer getEu_blmd() {
		return ((Integer) getAttrVal("Eu_blmd"));
	}
	/**
	 * 记费模式
	 * @param Eu_blmd
	 */
	public void setEu_blmd(Integer Eu_blmd) {
		setAttrVal("Eu_blmd", Eu_blmd);
	}
	/**
	 * 物品标识
	 * @return FBoolean
	 */
	public FBoolean getFg_mm() {
		return ((FBoolean) getAttrVal("Fg_mm"));
	}
	/**
	 * 物品标识
	 * @param Fg_mm
	 */
	public void setFg_mm(FBoolean Fg_mm) {
		setAttrVal("Fg_mm", Fg_mm);
	}
	/**
	 * 参考价格
	 * @return FDouble
	 */
	public FDouble getPri() {
		return ((FDouble) getAttrVal("Pri"));
	}
	/**
	 * 参考价格
	 * @param Pri
	 */
	public void setPri(FDouble Pri) {
		setAttrVal("Pri", Pri);
	}
	/**
	 * 医保适应症标识
	 * @return FBoolean
	 */
	public FBoolean getFg_indic() {
		return ((FBoolean) getAttrVal("Fg_indic"));
	}
	/**
	 * 医保适应症标识
	 * @param Fg_indic
	 */
	public void setFg_indic(FBoolean Fg_indic) {
		setAttrVal("Fg_indic", Fg_indic);
	}
	/**
	 * 是否预防用药
	 * @return FBoolean
	 */
	public FBoolean getFg_propc() {
		return ((FBoolean) getAttrVal("Fg_propc"));
	}
	/**
	 * 是否预防用药
	 * @param Fg_propc
	 */
	public void setFg_propc(FBoolean Fg_propc) {
		setAttrVal("Fg_propc", Fg_propc);
	}
	/**
	 * 是否自备药
	 * @return FBoolean
	 */
	public FBoolean getFg_self() {
		return ((FBoolean) getAttrVal("Fg_self"));
	}
	/**
	 * 是否自备药
	 * @param Fg_self
	 */
	public void setFg_self(FBoolean Fg_self) {
		setAttrVal("Fg_self", Fg_self);
	}
	/**
	 * 服务备注
	 * @return String
	 */
	public String getNote_srv() {
		return ((String) getAttrVal("Note_srv"));
	}
	/**
	 * 服务备注
	 * @param Note_srv
	 */
	public void setNote_srv(String Note_srv) {
		setAttrVal("Note_srv", Note_srv);
	}
	/**
	 * 服务项目分类
	 * @return String
	 */
	public String getId_srvca() {
		return ((String) getAttrVal("Id_srvca"));
	}
	/**
	 * 服务项目分类
	 * @param Id_srvca
	 */
	public void setId_srvca(String Id_srvca) {
		setAttrVal("Id_srvca", Id_srvca);
	}
	/**
	 * 费用标识
	 * @return FBoolean
	 */
	public FBoolean getFg_bl() {
		return ((FBoolean) getAttrVal("Fg_bl"));
	}
	/**
	 * 费用标识
	 * @param Fg_bl
	 */
	public void setFg_bl(FBoolean Fg_bl) {
		setAttrVal("Fg_bl", Fg_bl);
	}
	/**
	 * 服务项目编码
	 * @return String
	 */
	public String getCode_srv() {
		return ((String) getAttrVal("Code_srv"));
	}
	/**
	 * 服务项目编码
	 * @param Code_srv
	 */
	public void setCode_srv(String Code_srv) {
		setAttrVal("Code_srv", Code_srv);
	}
	/**
	 * 开立病区
	 * @return String
	 */
	public String getId_dep_nur_srv() {
		return ((String) getAttrVal("Id_dep_nur_srv"));
	}
	/**
	 * 开立病区
	 * @param Id_dep_nur_srv
	 */
	public void setId_dep_nur_srv(String Id_dep_nur_srv) {
		setAttrVal("Id_dep_nur_srv", Id_dep_nur_srv);
	}
	/**
	 * 医嘱项目来源方式
	 * @return Integer
	 */
	public Integer getEu_sourcemd() {
		return ((Integer) getAttrVal("Eu_sourcemd"));
	}
	/**
	 * 医嘱项目来源方式
	 * @param Eu_sourcemd
	 */
	public void setEu_sourcemd(Integer Eu_sourcemd) {
		setAttrVal("Eu_sourcemd", Eu_sourcemd);
	}
	/**
	 * 主医保计划
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}
	/**
	 * 主医保计划
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	/**
	 * 医保目录类型
	 * @return String
	 */
	public String getId_hpsrvtp() {
		return ((String) getAttrVal("Id_hpsrvtp"));
	}
	/**
	 * 医保目录类型
	 * @param Id_hpsrvtp
	 */
	public void setId_hpsrvtp(String Id_hpsrvtp) {
		setAttrVal("Id_hpsrvtp", Id_hpsrvtp);
	}
	/**
	 * 医保目录类型编码
	 * @return String
	 */
	public String getSd_hpsrvtp() {
		return ((String) getAttrVal("Sd_hpsrvtp"));
	}
	/**
	 * 医保目录类型编码
	 * @param Sd_hpsrvtp
	 */
	public void setSd_hpsrvtp(String Sd_hpsrvtp) {
		setAttrVal("Sd_hpsrvtp", Sd_hpsrvtp);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getPat_name() {
		return ((String) getAttrVal("Pat_name"));
	}
	/**
	 * 患者姓名
	 * @param Pat_name
	 */
	public void setPat_name(String Pat_name) {
		setAttrVal("Pat_name", Pat_name);
	}
	/**
	 * 性别
	 * @return String
	 */
	public String getPat_id_sex() {
		return ((String) getAttrVal("Pat_id_sex"));
	}
	/**
	 * 性别
	 * @param Pat_id_sex
	 */
	public void setPat_id_sex(String Pat_id_sex) {
		setAttrVal("Pat_id_sex", Pat_id_sex);
	}
	/**
	 * 出生日期
	 * @return FDate
	 */
	public FDate getPat_dt_birth() {
		return ((FDate) getAttrVal("Pat_dt_birth"));
	}
	/**
	 * 出生日期
	 * @param Pat_dt_birth
	 */
	public void setPat_dt_birth(FDate Pat_dt_birth) {
		setAttrVal("Pat_dt_birth", Pat_dt_birth);
	}
	/**
	 * 性别编码
	 * @return String
	 */
	public String getPat_sd_sex() {
		return ((String) getAttrVal("Pat_sd_sex"));
	}
	/**
	 * 性别编码
	 * @param Pat_sd_sex
	 */
	public void setPat_sd_sex(String Pat_sd_sex) {
		setAttrVal("Pat_sd_sex", Pat_sd_sex);
	}
	/**
	 * 就诊类型名称
	 * @return String
	 */
	public String getEntp_name() {
		return ((String) getAttrVal("Entp_name"));
	}
	/**
	 * 就诊类型名称
	 * @param Entp_name
	 */
	public void setEntp_name(String Entp_name) {
		setAttrVal("Entp_name", Entp_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getSrvtp_name() {
		return ((String) getAttrVal("Srvtp_name"));
	}
	/**
	 * 名称
	 * @param Srvtp_name
	 */
	public void setSrvtp_name(String Srvtp_name) {
		setAttrVal("Srvtp_name", Srvtp_name);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getSrv_pkg_name() {
		return ((String) getAttrVal("Srv_pkg_name"));
	}
	/**
	 * 服务名称
	 * @param Srv_pkg_name
	 */
	public void setSrv_pkg_name(String Srv_pkg_name) {
		setAttrVal("Srv_pkg_name", Srv_pkg_name);
	}
	/**
	 * 频次名称
	 * @return String
	 */
	public String getFreq_name() {
		return ((String) getAttrVal("Freq_name"));
	}
	/**
	 * 频次名称
	 * @param Freq_name
	 */
	public void setFreq_name(String Freq_name) {
		setAttrVal("Freq_name", Freq_name);
	}
	/**
	 * 显示编码
	 * @return String
	 */
	public String getFreq_code_disp() {
		return ((String) getAttrVal("Freq_code_disp"));
	}
	/**
	 * 显示编码
	 * @param Freq_code_disp
	 */
	public void setFreq_code_disp(String Freq_code_disp) {
		setAttrVal("Freq_code_disp", Freq_code_disp);
	}
	/**
	 * 用法名称
	 * @return String
	 */
	public String getRoute_name() {
		return ((String) getAttrVal("Route_name"));
	}
	/**
	 * 用法名称
	 * @param Route_name
	 */
	public void setRoute_name(String Route_name) {
		setAttrVal("Route_name", Route_name);
	}
	/**
	 * 用法要求
	 * @return String
	 */
	public String getRoutedes_name() {
		return ((String) getAttrVal("Routedes_name"));
	}
	/**
	 * 用法要求
	 * @param Routedes_name
	 */
	public void setRoutedes_name(String Routedes_name) {
		setAttrVal("Routedes_name", Routedes_name);
	}
	/**
	 * 煎法名称
	 * @return String
	 */
	public String getBoil_name() {
		return ((String) getAttrVal("Boil_name"));
	}
	/**
	 * 煎法名称
	 * @param Boil_name
	 */
	public void setBoil_name(String Boil_name) {
		setAttrVal("Boil_name", Boil_name);
	}
	/**
	 * 煎法要求
	 * @return String
	 */
	public String getBoildes_name() {
		return ((String) getAttrVal("Boildes_name"));
	}
	/**
	 * 煎法要求
	 * @param Boildes_name
	 */
	public void setBoildes_name(String Boildes_name) {
		setAttrVal("Boildes_name", Boildes_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getSu_or_name() {
		return ((String) getAttrVal("Su_or_name"));
	}
	/**
	 * 名称
	 * @param Su_or_name
	 */
	public void setSu_or_name(String Su_or_name) {
		setAttrVal("Su_or_name", Su_or_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getSd_su_name() {
		return ((String) getAttrVal("Sd_su_name"));
	}
	/**
	 * 名称
	 * @param Sd_su_name
	 */
	public void setSd_su_name(String Sd_su_name) {
		setAttrVal("Sd_su_name", Sd_su_name);
	}
	/**
	 * 组织名称
	 * @return String
	 */
	public String getOrg_or_name() {
		return ((String) getAttrVal("Org_or_name"));
	}
	/**
	 * 组织名称
	 * @param Org_or_name
	 */
	public void setOrg_or_name(String Org_or_name) {
		setAttrVal("Org_or_name", Org_or_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getDept_or_name() {
		return ((String) getAttrVal("Dept_or_name"));
	}
	/**
	 * 名称
	 * @param Dept_or_name
	 */
	public void setDept_or_name(String Dept_or_name) {
		setAttrVal("Dept_or_name", Dept_or_name);
	}
	/**
	 * 业务组名称
	 * @return String
	 */
	public String getWg_or_name() {
		return ((String) getAttrVal("Wg_or_name"));
	}
	/**
	 * 业务组名称
	 * @param Wg_or_name
	 */
	public void setWg_or_name(String Wg_or_name) {
		setAttrVal("Wg_or_name", Wg_or_name);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getEmp_phy_name() {
		return ((String) getAttrVal("Emp_phy_name"));
	}
	/**
	 * 姓名
	 * @param Emp_phy_name
	 */
	public void setEmp_phy_name(String Emp_phy_name) {
		setAttrVal("Emp_phy_name", Emp_phy_name);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getEmp_sign_name() {
		return ((String) getAttrVal("Emp_sign_name"));
	}
	/**
	 * 姓名
	 * @param Emp_sign_name
	 */
	public void setEmp_sign_name(String Emp_sign_name) {
		setAttrVal("Emp_sign_name", Emp_sign_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getDep_sign_name() {
		return ((String) getAttrVal("Dep_sign_name"));
	}
	/**
	 * 名称
	 * @param Dep_sign_name
	 */
	public void setDep_sign_name(String Dep_sign_name) {
		setAttrVal("Dep_sign_name", Dep_sign_name);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getEmp_chk_name() {
		return ((String) getAttrVal("Emp_chk_name"));
	}
	/**
	 * 姓名
	 * @param Emp_chk_name
	 */
	public void setEmp_chk_name(String Emp_chk_name) {
		setAttrVal("Emp_chk_name", Emp_chk_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getDep_nur_name() {
		return ((String) getAttrVal("Dep_nur_name"));
	}
	/**
	 * 名称
	 * @param Dep_nur_name
	 */
	public void setDep_nur_name(String Dep_nur_name) {
		setAttrVal("Dep_nur_name", Dep_nur_name);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getEmp_stop_name() {
		return ((String) getAttrVal("Emp_stop_name"));
	}
	/**
	 * 姓名
	 * @param Emp_stop_name
	 */
	public void setEmp_stop_name(String Emp_stop_name) {
		setAttrVal("Emp_stop_name", Emp_stop_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getDep_stop_name() {
		return ((String) getAttrVal("Dep_stop_name"));
	}
	/**
	 * 名称
	 * @param Dep_stop_name
	 */
	public void setDep_stop_name(String Dep_stop_name) {
		setAttrVal("Dep_stop_name", Dep_stop_name);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getEmp_chk_stop_name() {
		return ((String) getAttrVal("Emp_chk_stop_name"));
	}
	/**
	 * 姓名
	 * @param Emp_chk_stop_name
	 */
	public void setEmp_chk_stop_name(String Emp_chk_stop_name) {
		setAttrVal("Emp_chk_stop_name", Emp_chk_stop_name);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getEmp_canc_name() {
		return ((String) getAttrVal("Emp_canc_name"));
	}
	/**
	 * 姓名
	 * @param Emp_canc_name
	 */
	public void setEmp_canc_name(String Emp_canc_name) {
		setAttrVal("Emp_canc_name", Emp_canc_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getDep_canc_name() {
		return ((String) getAttrVal("Dep_canc_name"));
	}
	/**
	 * 名称
	 * @param Dep_canc_name
	 */
	public void setDep_canc_name(String Dep_canc_name) {
		setAttrVal("Dep_canc_name", Dep_canc_name);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getEmp_chk_canc_name() {
		return ((String) getAttrVal("Emp_chk_canc_name"));
	}
	/**
	 * 姓名
	 * @param Emp_chk_canc_name
	 */
	public void setEmp_chk_canc_name(String Emp_chk_canc_name) {
		setAttrVal("Emp_chk_canc_name", Emp_chk_canc_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getDep_chk_canc_name() {
		return ((String) getAttrVal("Dep_chk_canc_name"));
	}
	/**
	 * 名称
	 * @param Dep_chk_canc_name
	 */
	public void setDep_chk_canc_name(String Dep_chk_canc_name) {
		setAttrVal("Dep_chk_canc_name", Dep_chk_canc_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getReltp_name() {
		return ((String) getAttrVal("Reltp_name"));
	}
	/**
	 * 名称
	 * @param Reltp_name
	 */
	public void setReltp_name(String Reltp_name) {
		setAttrVal("Reltp_name", Reltp_name);
	}
	/**
	 * 医嘱名称
	 * @return String
	 */
	public String getOr_rel_name() {
		return ((String) getAttrVal("Or_rel_name"));
	}
	/**
	 * 医嘱名称
	 * @param Or_rel_name
	 */
	public void setOr_rel_name(String Or_rel_name) {
		setAttrVal("Or_rel_name", Or_rel_name);
	}
	/**
	 * 处方名称
	 * @return String
	 */
	public String getPres_name() {
		return ((String) getAttrVal("Pres_name"));
	}
	/**
	 * 处方名称
	 * @param Pres_name
	 */
	public void setPres_name(String Pres_name) {
		setAttrVal("Pres_name", Pres_name);
	}
	/**
	 * 计量单位名称
	 * @return String
	 */
	public String getMedu_name() {
		return ((String) getAttrVal("Medu_name"));
	}
	/**
	 * 计量单位名称
	 * @param Medu_name
	 */
	public void setMedu_name(String Medu_name) {
		setAttrVal("Medu_name", Medu_name);
	}
	/**
	 * 组织名称
	 * @return String
	 */
	public String getOrg_name() {
		return ((String) getAttrVal("Org_name"));
	}
	/**
	 * 组织名称
	 * @param Org_name
	 */
	public void setOrg_name(String Org_name) {
		setAttrVal("Org_name", Org_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getDep_name() {
		return ((String) getAttrVal("Dep_name"));
	}
	/**
	 * 名称
	 * @param Dep_name
	 */
	public void setDep_name(String Dep_name) {
		setAttrVal("Dep_name", Dep_name);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getEmp_name() {
		return ((String) getAttrVal("Emp_name"));
	}
	/**
	 * 姓名
	 * @param Emp_name
	 */
	public void setEmp_name(String Emp_name) {
		setAttrVal("Emp_name", Emp_name);
	}
	/**
	 * 组织名称
	 * @return String
	 */
	public String getOrg_mp_name() {
		return ((String) getAttrVal("Org_mp_name"));
	}
	/**
	 * 组织名称
	 * @param Org_mp_name
	 */
	public void setOrg_mp_name(String Org_mp_name) {
		setAttrVal("Org_mp_name", Org_mp_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getDep_mp_name() {
		return ((String) getAttrVal("Dep_mp_name"));
	}
	/**
	 * 名称
	 * @param Dep_mp_name
	 */
	public void setDep_mp_name(String Dep_mp_name) {
		setAttrVal("Dep_mp_name", Dep_mp_name);
	}
	/**
	 * 最近费用日期
	 * @return
	 */
	public FDateTime getDt_last_cg() {
		return ((FDateTime) getAttrVal("Dt_last_cg"));
	}	
	/**
	 * 最近费用日期
	 * @param Dt_last_cg
	 */
	public void setDt_last_cg(FDateTime Dt_last_cg) {
		setAttrVal("Dt_last_cg", Dt_last_cg);
	}
}