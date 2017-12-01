package iih.ci.ord.ciordems.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;

import java.math.BigDecimal;

/**
 * 药品医疗单项目 DTO数据
 * 
 */
public class EmsDrugItemDO extends OrCommonFieldsDTO {
	private static final long serialVersionUID = 1L;

	/**
	 * 医嘱服务项目
	 * 
	 * @return String
	 */
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}

	/**
	 * 医嘱服务项目
	 * 
	 * @param Id_orsrv
	 */
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}

	/**
	 * 医嘱
	 * 
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}

	/**
	 * 医嘱
	 * 
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}

	/**
	 * 服务类型
	 * 
	 * @return String
	 */
	public String getId_srvtp() {
		return ((String) getAttrVal("Id_srvtp"));
	}

	/**
	 * 服务类型
	 * 
	 * @param Id_srvtp
	 */
	public void setId_srvtp(String Id_srvtp) {
		setAttrVal("Id_srvtp", Id_srvtp);
	}

	/**
	 * 服务类型编码
	 * 
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}

	/**
	 * 服务类型编码
	 * 
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}

	/**
	 * 医疗服务
	 * 
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}

	/**
	 * 医疗服务
	 * 
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}

	/**
	 * 医疗服务编码
	 * 
	 * @return String
	 */
	public String getCode_srv() {
		return ((String) getAttrVal("Code_srv"));
	}

	/**
	 * 医疗服务编码
	 * 
	 * @param Code_srv
	 */
	public void setCode_srv(String Code_srv) {
		setAttrVal("Code_srv", Code_srv);
	}

	/**
	 * 医疗服务名称
	 * 
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}

	/**
	 * 医疗服务名称
	 * 
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}

	/**
	 * 医疗单位
	 * 
	 * @return String
	 */
	public String getId_unit_med() {
		return ((String) getAttrVal("Id_unit_med"));
	}

	/**
	 * 医疗单位
	 * 
	 * @param Id_unit_med
	 */
	public void setId_unit_med(String Id_unit_med) {
		setAttrVal("Id_unit_med", Id_unit_med);
	}

	/**
	 * 医疗单位编码
	 * 
	 * @return String
	 */
	public String getName_unit_med() {
		return ((String) getAttrVal("Name_unit_med"));
	}

	/**
	 * 医疗单位编码
	 * 
	 * @param Name_unit_med
	 */
	public void setName_unit_med(String Name_unit_med) {
		setAttrVal("Name_unit_med", Name_unit_med);
	}

	/**
	 * 剂量
	 * 
	 * @return FDouble
	 */
	public FDouble getQuan_med() {
		return ((FDouble) getAttrVal("Quan_med"));
	}

	/**
	 * 剂量
	 * 
	 * @param Quan_med
	 */
	public void setQuan_med(FDouble Quan_med) {
		setAttrVal("Quan_med", Quan_med);
	}

	/**
	 * 医嘱频次
	 * 
	 * @return String
	 */
	public String getId_freq() {
		return ((String) getAttrVal("Id_freq"));
	}

	/**
	 * 医嘱频次
	 * 
	 * @param Id_freq
	 */
	public void setId_freq(String Id_freq) {
		setAttrVal("Id_freq", Id_freq);
	}

	/**
	 * 医嘱频次名称
	 * 
	 * @return String
	 */
	public String getName_freq() {
		return ((String) getAttrVal("Name_freq"));
	}

	/**
	 * 医嘱频次名称
	 * 
	 * @param Name_freq
	 */
	public void setName_freq(String Name_freq) {
		setAttrVal("Name_freq", Name_freq);
	}

	/**
	 * 用法标识
	 * 
	 * @return String
	 */
	public String getId_route() {
		return ((String) getAttrVal("Id_route"));
	}

	/**
	 * 用法标识
	 * 
	 * @param Id_route
	 */
	public void setId_route(String Id_route) {
		setAttrVal("Id_route", Id_route);
	}

	/**
	 * 用法
	 * 
	 * @return String
	 */
	public String getName_route() {
		return ((String) getAttrVal("Name_route"));
	}

	/**
	 * 用法
	 * 
	 * @param Name_route
	 */
	public void setName_route(String Name_route) {
		setAttrVal("Name_route", Name_route);
	}

	/**
	 * 用法要求标识
	 * 
	 * @return String
	 */
	public String getId_routedes() {
		return ((String) getAttrVal("Id_routedes"));
	}

	/**
	 * 用法要求标识
	 * 
	 * @param Id_routedes
	 */
	public void setId_routedes(String Id_routedes) {
		setAttrVal("Id_routedes", Id_routedes);
	}

	/**
	 * 用法要求
	 * 
	 * @return String
	 */
	public String getName_routedes() {
		return ((String) getAttrVal("Name_routedes"));
	}

	/**
	 * 用法要求
	 * 
	 * @param Name_routedes
	 */
	public void setName_routedes(String Name_routedes) {
		setAttrVal("Name_routedes", Name_routedes);
	}

	/**
	 * 煎法标识
	 * 
	 * @return String
	 */
	public String getId_boil() {
		return ((String) getAttrVal("Id_boil"));
	}

	/**
	 * 煎法标识
	 * 
	 * @param Id_boil
	 */
	public void setId_boil(String Id_boil) {
		setAttrVal("Id_boil", Id_boil);
	}

	/**
	 * 煎法
	 * 
	 * @return String
	 */
	public String getName_boil() {
		return ((String) getAttrVal("Name_boil"));
	}

	/**
	 * 煎法
	 * 
	 * @param Name_boil
	 */
	public void setName_boil(String Name_boil) {
		setAttrVal("Name_boil", Name_boil);
	}

	/**
	 * 煎法要求标识
	 * 
	 * @return String
	 */
	public String getId_boildes() {
		return ((String) getAttrVal("Id_boildes"));
	}

	/**
	 * 煎法要求标识
	 * 
	 * @param Id_boildes
	 */
	public void setId_boildes(String Id_boildes) {
		setAttrVal("Id_boildes", Id_boildes);
	}

	/**
	 * 煎法要求
	 * 
	 * @return String
	 */
	public String getName_boildes() {
		return ((String) getAttrVal("Name_boildes"));
	}

	/**
	 * 煎法要求
	 * 
	 * @param Name_boildes
	 */
	public void setName_boildes(String Name_boildes) {
		setAttrVal("Name_boildes", Name_boildes);
	}

	/**
	 * 变动用药标识
	 * 
	 * @return FBoolean
	 */
	public FBoolean getFg_dose_anoma() {
		return ((FBoolean) getAttrVal("Fg_dose_anoma"));
	}

	/**
	 * 变动用药标识
	 * 
	 * @param Fg_dose_anoma
	 */
	public void setFg_dose_anoma(FBoolean Fg_dose_anoma) {
		setAttrVal("Fg_dose_anoma", Fg_dose_anoma);
	}
	/**
	 * 加急
	 * @return
	 */
	public FBoolean getFg_urgent() {
		return ((FBoolean) getAttrVal("Fg_urgent"));
	}	
	public void setFg_urgent(FBoolean Fg_urgent) {
		setAttrVal("Fg_urgent", Fg_urgent);
	}

	/**
	 * 变动用药安排
	 * 
	 * @return FArrayList
	 */
	public FArrayList getEmsfreqdose() {
		return ((FArrayList) getAttrVal("Emsfreqdose"));
	}

	/**
	 * 变动用药安排
	 * 
	 * @param Emsfreqdose
	 */
	public void setEmsfreqdose(FArrayList Emsfreqdose) {
		setAttrVal("Emsfreqdose", Emsfreqdose);
	}

	/**
	 * 物品标识
	 * 
	 * @return FBoolean
	 */
	public FBoolean getFg_mm() {
		return ((FBoolean) getAttrVal("Fg_mm"));
	}

	/**
	 * 物品标识
	 * 
	 * @param Fg_mm
	 */
	public void setFg_mm(FBoolean Fg_mm) {
		setAttrVal("Fg_mm", Fg_mm);
	}

	/**
	 * 服务套标识
	 * 
	 * @return FBoolean
	 */
	public FBoolean getFg_set() {
		return ((FBoolean) getAttrVal("Fg_set"));
	}

	/**
	 * 服务套标识
	 * 
	 * @param Fg_set
	 */
	public void setFg_set(FBoolean Fg_set) {
		setAttrVal("Fg_set", Fg_set);
	}

	/**
	 * 医嘱标识
	 * 
	 * @return FBoolean
	 */
	public FBoolean getFg_or() {
		return ((FBoolean) getAttrVal("Fg_or"));
	}

	/**
	 * 医嘱标识
	 * 
	 * @param Fg_or
	 */
	public void setFg_or(FBoolean Fg_or) {
		setAttrVal("Fg_or", Fg_or);
	}

	/**
	 * 费用标识
	 * 
	 * @return FBoolean
	 */
	public FBoolean getFg_bl() {
		return ((FBoolean) getAttrVal("Fg_bl"));
	}

	/**
	 * 费用标识
	 * 
	 * @param Fg_bl
	 */
	public void setFg_bl(FBoolean Fg_bl) {
		setAttrVal("Fg_bl", Fg_bl);
	}

	/**
	 * 自备药标识
	 * 
	 * @return FBoolean
	 */
	public FBoolean getFg_self() {
		return ((FBoolean) getAttrVal("Fg_self"));
	}

	/**
	 * 自备药标识
	 * 
	 * @param Fg_self
	 */
	public void setFg_self(FBoolean Fg_self) {
		setAttrVal("Fg_self", Fg_self);
	}

	/**
	 * 出院带药标识
	 * 
	 * @return FBoolean
	 */
	public FBoolean getFg_outp() {
		return ((FBoolean) getAttrVal("Fg_outp"));
	}

	/**
	 * 出院带药标识
	 * 
	 * @param Fg_outp
	 */
	public void setFg_outp(FBoolean Fg_outp) {
		setAttrVal("Fg_outp", Fg_outp);
	}

	/**
	 * 预防用药标识
	 * 
	 * @return FBoolean
	 */
	public FBoolean getFg_propc() {
		return ((FBoolean) getAttrVal("Fg_propc"));
	}

	/**
	 * 预防用药标识
	 * 
	 * @param Fg_propc
	 */
	public void setFg_propc(FBoolean Fg_propc) {
		setAttrVal("Fg_propc", Fg_propc);
	}

	/**
	 * 治疗用药标识
	 * 
	 * @return FBoolean
	 */
	public FBoolean getFg_treat() {
		return ((FBoolean) getAttrVal("Fg_treat"));
	}

	/**
	 * 治疗用药标识
	 * 
	 * @param Fg_treat
	 */
	public void setFg_treat(FBoolean Fg_treat) {
		setAttrVal("Fg_treat", Fg_treat);
	}

	/**
	 * 代煎标识
	 * 
	 * @return FBoolean
	 */
	public FBoolean getFg_boil() {
		return ((FBoolean) getAttrVal("Fg_boil"));
	}

	/**
	 * 代煎标识
	 * 
	 * @param Fg_boil
	 */
	public void setFg_boil(FBoolean Fg_boil) {
		setAttrVal("Fg_boil", Fg_boil);
	}
	
	/**
	 * 参考价格
	 * 
	 * @return FDouble
	 */
	public FDouble getPrice() {
		return ((FDouble) getAttrVal("Price"));
	}

	/**
	 * 参考价格
	 * 
	 * @param Price
	 */
	public void setPrice(FDouble Price) {
		setAttrVal("Price", Price);
	}

	/**
	 * 金额
	 * 
	 * @return String
	 */
	public String getTotalprice() {
		return ((String) getAttrVal("Totalprice"));
	}

	/**
	 * 金额
	 * 
	 * @param Totalprice
	 */
	public void setTotalprice(String Totalprice) {
		setAttrVal("Totalprice", Totalprice);
	}

	/**
	 * 服务项目物品
	 * 
	 * @return String
	 */
	public String getId_orsrvmm() {
		return ((String) getAttrVal("Id_orsrvmm"));
	}

	/**
	 * 服务项目物品
	 * 
	 * @param Id_orsrvmm
	 */
	public void setId_orsrvmm(String Id_orsrvmm) {
		setAttrVal("Id_orsrvmm", Id_orsrvmm);
	}

	/**
	 * 物品
	 * 
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}

	/**
	 * 物品
	 * 
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}

	/**
	 * 物品名称
	 * 
	 * @return String
	 */
	public String getName_mm() {
		return ((String) getAttrVal("Name_mm"));
	}

	/**
	 * 物品名称
	 * 
	 * @param Name_mm
	 */
	public void setName_mm(String Name_mm) {
		setAttrVal("Name_mm", Name_mm);
	}

	/**
	 * 规格
	 * 
	 * @return String
	 */
	public String getSpec_mm() {
		return ((String) getAttrVal("Spec_mm"));
	}

	/**
	 * 规格
	 * 
	 * @param Spec_mm
	 */
	public void setSpec_mm(String Spec_mm) {
		setAttrVal("Spec_mm", Spec_mm);
	}

	/**
	 * 适应症
	 * 
	 * @return String
	 */
	public String getIndica() {
		return ((String) getAttrVal("Indica"));
	}

	/**
	 * 适应症
	 * 
	 * @param Indica
	 */
	public void setIndica(String Indica) {
		setAttrVal("Indica", Indica);
	}

	/**
	 * 禁忌症
	 * 
	 * @return String
	 */
	public String getConstr() {
		return ((String) getAttrVal("Constr"));
	}

	/**
	 * 禁忌症
	 * 
	 * @param Constr
	 */
	public void setConstr(String Constr) {
		setAttrVal("Constr", Constr);
	}

	/**
	 * 不良反应
	 * 
	 * @return String
	 */
	public String getReact() {
		return ((String) getAttrVal("React"));
	}

	/**
	 * 不良反应
	 * 
	 * @param React
	 */
	public void setReact(String React) {
		setAttrVal("React", React);
	}

	/**
	 * 主要作用
	 * 
	 * @return String
	 */
	public String getGuide() {
		return ((String) getAttrVal("Guide"));
	}

	/**
	 * 主要作用
	 * 
	 * @param Guide
	 */
	public void setGuide(String Guide) {
		setAttrVal("Guide", Guide);
	}

	/**
	 * 物品默认标识
	 * 
	 * @return FBoolean
	 */
	public FBoolean getIsdefault() {
		return ((FBoolean) getAttrVal("Isdefault"));
	}

	/**
	 * 物品默认标识
	 * 
	 * @param Isdefault
	 */
	public void setIsdefault(FBoolean Isdefault) {
		setAttrVal("Isdefault", Isdefault);
	}

	/**
	 * 零售单位
	 * 
	 * @return String
	 */
	public String getId_unit_sale() {
		return ((String) getAttrVal("Id_unit_sale"));
	}

	/**
	 * 零售单位
	 * 
	 * @param Id_unit_sale
	 */
	public void setId_unit_sale(String Id_unit_sale) {
		setAttrVal("Id_unit_sale", Id_unit_sale);
	}

	/**
	 * 零售单位名称
	 * 
	 * @return String
	 */
	public String getName_unit_sale() {
		return ((String) getAttrVal("Name_unit_sale"));
	}

	/**
	 * 零售单位名称
	 * 
	 * @param Name_unit_sale
	 */
	public void setName_unit_sale(String Name_unit_sale) {
		setAttrVal("Name_unit_sale", Name_unit_sale);
	}

	/**
	 * 基本单位
	 * 
	 * @return String
	 */
	public String getId_unit_base() {
		return ((String) getAttrVal("Id_unit_base"));
	}

	/**
	 * 基本单位
	 * 
	 * @param Id_unit_base
	 */
	public void setId_unit_base(String Id_unit_base) {
		setAttrVal("Id_unit_base", Id_unit_base);
	}

	/**
	 * 基本单位名称
	 * 
	 * @return String
	 */
	public String getName_unit_base() {
		return ((String) getAttrVal("Name_unit_base"));
	}

	/**
	 * 基本单位名称
	 * 
	 * @param Name_unit_base
	 */
	public void setName_unit_base(String Name_unit_base) {
		setAttrVal("Name_unit_base", Name_unit_base);
	}

	/**
	 * 数量_当前
	 * 
	 * @return FDouble
	 */
	public FDouble getQuan_cur() {
		return ((FDouble) getAttrVal("Quan_cur"));
	}

	/**
	 * 数量_当前
	 * 
	 * @param Quan_cur
	 */
	public void setQuan_cur(FDouble Quan_cur) {
		setAttrVal("Quan_cur", Quan_cur);
	}

	/**
	 * 数量_基本
	 * 
	 * @return FDouble
	 */
	public FDouble getQuan_base() {
		return ((FDouble) getAttrVal("Quan_base"));
	}

	/**
	 * 数量_基本
	 * 
	 * @param Quan_base
	 */
	public void setQuan_base(FDouble Quan_base) {
		setAttrVal("Quan_base", Quan_base);
	}

	/**
	 * 当前基本换算系数
	 * 
	 * @return String
	 */
	public String getFactor_cb() {
		return ((String) getAttrVal("Factor_cb"));
	}

	/**
	 * 当前基本换算系数
	 * 
	 * @param Factor_cb
	 */
	public void setFactor_cb(String Factor_cb) {
		setAttrVal("Factor_cb", Factor_cb);
	}

	/**
	 * 医疗基本换算系数
	 * 
	 * @return String
	 */
	public String getFactor_mb() {
		return ((String) getAttrVal("Factor_mb"));
	}

	/**
	 * 医疗基本换算系数
	 * 
	 * @param Factor_mb
	 */
	public void setFactor_mb(String Factor_mb) {
		setAttrVal("Factor_mb", Factor_mb);
	}

	/**
	 * 开始时间
	 * 
	 * @return FDateTime
	 */
	public FDateTime getDt_begin_ui() {
		return ((FDateTime) getAttrVal("Dt_begin_ui"));
	}

	/**
	 * 开始时间
	 * 
	 * @param Dt_begin_ui
	 */
	public void setDt_begin_ui(FDateTime Dt_begin_ui) {
		setAttrVal("Dt_begin_ui", Dt_begin_ui);
	}

	/**
	 * 结束时间
	 * 
	 * @return FDateTime
	 */
	public FDateTime getDt_end_ui() {
		return ((FDateTime) getAttrVal("Dt_end_ui"));
	}

	/**
	 * 结束时间
	 * 
	 * @param Dt_end_ui
	 */
	public void setDt_end_ui(FDateTime Dt_end_ui) {
		setAttrVal("Dt_end_ui", Dt_end_ui);
	}

//	/**
//	 * 使用天数
//	 * 
//	 * @return Integer
//	 */
//	public Integer getUse_day() {
//		return ((Integer) getAttrVal("Use_day"));
//	}
//
//	/**
//	 * 使用天数
//	 * 
//	 * @param Use_day
//	 */
//	public void setUse_day(Integer Use_day) {
//		setAttrVal("Use_day", Use_day);
//	}

	/**
	 * 长临标识
	 * 
	 * @return FBoolean
	 */
	public FBoolean getFg_long() {
		return ((FBoolean) getAttrVal("Fg_long"));
	}

	/**
	 * 长临标识
	 * 
	 * @param Fg_long
	 */
	public void setFg_long(FBoolean Fg_long) {
		setAttrVal("Fg_long", Fg_long);
	}

	/**
	 * 备用医嘱标识
	 * 
	 * @return FBoolean
	 */
	public FBoolean getFg_pmor() {
		return ((FBoolean) getAttrVal("Fg_pmor"));
	}

	/**
	 * 备用医嘱标识
	 * 
	 * @param Fg_pmor
	 */
	public void setFg_pmor(FBoolean Fg_pmor) {
		setAttrVal("Fg_pmor", Fg_pmor);
	}

	/**
	 * 备用医嘱使用条件描述
	 * 
	 * @return String
	 */
	public String getBak_des() {
		return ((String) getAttrVal("Bak_des"));
	}

	/**
	 * 备用医嘱使用条件描述
	 * 
	 * @param Bak_des
	 */
	public void setBak_des(String Bak_des) {
		setAttrVal("Bak_des", Bak_des);
	}

	/**
	 * 备用医嘱失效日期
	 * 
	 * @return FDateTime
	 */
	public FDateTime getDt_fail() {
		return ((FDateTime) getAttrVal("Dt_fail"));
	}

	/**
	 * 备用医嘱失效日期
	 * 
	 * @param Dt_fail
	 */
	public void setDt_fail(FDateTime Dt_fail) {
		setAttrVal("Dt_fail", Dt_fail);
	}

	/**
	 * 单次数量
	 * 
	 * @return Integer
	 */
	public Integer getSingle_count() {
		return ((Integer) getAttrVal("Single_count"));
	}

	/**
	 * 单次数量
	 * 
	 * @param Single_count
	 */
	public void setSingle_count(Integer Single_count) {
		setAttrVal("Single_count", Single_count);
	}

	/**
	 * 执行时间
	 * 
	 * @return String
	 */
	public String getWork_time() {
		return ((String) getAttrVal("Work_time"));
	}

	/**
	 * 执行时间
	 * 
	 * @param Work_time
	 */
	public void setWork_time(String Work_time) {
		setAttrVal("Work_time", Work_time);
	}

	/**
	 * 首日执行
	 * 
	 * @return String
	 */
	public String getFirst_freq() {
		return ((String) getAttrVal("First_freq"));
	}

	/**
	 * 首日执行
	 * 
	 * @param First_freq
	 */
	public void setFirst_freq(String First_freq) {
		setAttrVal("First_freq", First_freq);
	}

	/**
	 * 首日执行时间
	 * 
	 * @return String
	 */
	public String getFirst_time() {
		return ((String) getAttrVal("First_time"));
	}

	/**
	 * 首日执行时间
	 * 
	 * @param First_time
	 */
	public void setFirst_time(String First_time) {
		setAttrVal("First_time", First_time);
	}

	/**
	 * 执行科室
	 * 
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}

	/**
	 * 执行科室
	 * 
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}

	/**
	 * 执行科室名称
	 * 
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}

	/**
	 * 执行科室名称
	 * 
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}

	/**
	 * 总量
	 * 
	 * @return FDouble
	 */
	public FDouble getTotal_count() {
		return ((FDouble) getAttrVal("Total_count"));
	}

	/**
	 * 总量
	 * 
	 * @param Total_count
	 */
	public void setTotal_count(FDouble Total_count) {
		setAttrVal("Total_count", Total_count);
	}

	/**
	 * 总量单位id
	 * 
	 * @return String
	 */
	public String getId_total_count_unit() {
		return ((String) getAttrVal("Id_total_count_unit"));
	}

	/**
	 * 总量单位id
	 * 
	 * @param Id_total_count_unit
	 */
	public void setId_total_count_unit(String Id_total_count_unit) {
		setAttrVal("Id_total_count_unit", Id_total_count_unit);
	}

	/**
	 * 总量单位
	 * 
	 * @return String
	 */
	public String getTotal_count_unit() {
		return ((String) getAttrVal("Total_count_unit"));
	}

	/**
	 * 总量单位
	 * 
	 * @param Total_count_unit
	 */
	public void setTotal_count_unit(String Total_count_unit) {
		setAttrVal("Total_count_unit", Total_count_unit);
	}
	/**
	 * 首日执行次数
	 * @return Integer
	 */
	public Integer getQuan_firday_mp() {
		return ((Integer) getAttrVal("Times_firday_mp"));
	}	
	/**
	 * 首日执行次数
	 * @param Times_firday_mp
	 */
	public void setQuan_firday_mp(Integer Times_firday_mp) {
		setAttrVal("Times_firday_mp", Times_firday_mp);
	}

	/**
	 * 皮试标识
	 * 
	 * @return FBoolean
	 */
	public FBoolean getFg_skintest() {
		return ((FBoolean) getAttrVal("Fg_skintest"));
	}

	/**
	 * 皮试标识
	 * 
	 * @param Fg_skintest
	 */
	public void setFg_skintest(FBoolean Fg_skintest) {
		setAttrVal("Fg_skintest", Fg_skintest);
	}

	/**
	 * 组织编码
	 * 
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}

	/**
	 * 组织编码
	 * 
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}

	/**
	 * 医嘱付数
	 * 
	 * @return Integer
	 */
	public Integer getOrders() {
		return ((Integer) getAttrVal("Orders"));
	}

	/**
	 * 医嘱付数
	 * 
	 * @param Orders
	 */
	public void setOrders(Integer Orders) {
		setAttrVal("Orders", Orders);
	}

	/**
	 * 代煎付数
	 * 
	 * @return Integer
	 */
	public Integer getOrders_boil() {
		return ((Integer) getAttrVal("Orders_boil"));
	}

	/**
	 * 代煎付数
	 * 
	 * @param Orders_boil
	 */
	public void setOrders_boil(Integer Orders_boil) {
		setAttrVal("Orders_boil", Orders_boil);
	}

	/**
	 * 频次单位
	 * 
	 * @return String
	 */
	public String getSd_frequnitct() {
		return ((String) getAttrVal("Sd_frequnitct"));
	}

	/**
	 * 频次单位
	 * 
	 * @param Sd_frequnitct
	 */
	public void setSd_frequnitct(String Sd_frequnitct) {
		setAttrVal("Sd_frequnitct", Sd_frequnitct);
	}

	/**
	 * 频次下频次数
	 * 
	 * @return Integer
	 */
	public Integer getFreqct() {
		return ((Integer) getAttrVal("Freqct"));
	}

	/**
	 * 频次下频次数
	 * 
	 * @param Freqct
	 */
	public void setFreqct(Integer Freqct) {
		setAttrVal("Freqct", Freqct);
	}

	/**
	 * 在院执行标志
	 * 
	 * @return FBoolean
	 */
	public FBoolean getFg_mp_in() {
		return ((FBoolean) getAttrVal("Fg_mp_in"));
	}

	/**
	 * 在院执行标志
	 * 
	 * @param Fg_mp_in
	 */
	public void setFg_mp_in(FBoolean Fg_mp_in) {
		setAttrVal("Fg_mp_in", Fg_mp_in);
	}

	/**
	 * 在院执行次数
	 * 
	 * @return Integer
	 */
	public Integer getTimes_mp_in() {
		return ((Integer) getAttrVal("Times_mp_in"));
	}

	/**
	 * 在院执行次数
	 * 
	 * @param Times_mp_in
	 */
	public void setTimes_mp_in(Integer Times_mp_in) {
		setAttrVal("Times_mp_in", Times_mp_in);
	}

	/**
	 * 最近生成日期
	 * 
	 * @return FDateTime
	 */
	public FDateTime getDt_last_bl() {
		return ((FDateTime) getAttrVal("Dt_last_bl"));
	}

	/**
	 * 最近生成日期
	 * 
	 * @param Dt_last_bl
	 */
	public void setDt_last_bl(FDateTime Dt_last_bl) {
		setAttrVal("Dt_last_bl", Dt_last_bl);
	}
	
	/**
	 * 备注
	 * 
	 * @return String
	 */
	public String getNote_or() {
		return ((String) getAttrVal("Note_or"));
	}

	/**
	 * 备注
	 * 
	 * @param Name_heath
	 */
	public void setNote_or(String Note_or) {
		setAttrVal("Note_or", Note_or);
	}

	/**
	 * 医保类型
	 * 
	 * @return String
	 */
	public String getName_heath() {
		return ((String) getAttrVal("Name_heath"));
	}

	/**
	 * 医保类型
	 * 
	 * @param Name_heath
	 */
	public void setName_heath(String Name_heath) {
		setAttrVal("Name_heath", Name_heath);
	}

	/**
	 * 医保限制条件
	 * 
	 * @return String
	 */
	public String getLimit() {
		return ((String) getAttrVal("Limit"));
	}

	/**
	 * 医保限制条件
	 * 
	 * @param Limit
	 */
	public void setLimit(String Limit) {
		setAttrVal("Limit", Limit);
	}

	public String getName_sup() {
		return ((String) getAttrVal("Name_sup"));
	}

	public void setName_sup(String Name_sup) {
		setAttrVal("Name_sup", Name_sup);
	}

	public String getDes_mm() {
		return ((String) getAttrVal("Des_mm"));
	}

	public void setDes_mm(String Name_sup) {
		setAttrVal("Name_sup", Name_sup);
	}

	// 执行科室id集合
	public String getStr_mp_dep_ids() {
		return ((String) getAttrVal("Str_mp_dep_ids"));
	}

	public void setStr_mp_dep_ids(String Str_mp_dep_ids) {
		setAttrVal("Str_mp_dep_ids", Str_mp_dep_ids);
	}
	
	/**
	 * 自费标示
	 * 
	 * @return FBoolean
	 */
	public FBoolean getFg_selfpay() {
		return ((FBoolean) getAttrVal("Fg_selfpay"));
	}

	/**
	 * 自费标示
	 * 
	 * @param Fg_selfpay
	 */
	public void setFg_selfpay(FBoolean Fg_selfpay) {
		setAttrVal("Fg_selfpay", Fg_selfpay);
	}

	// 库房id集合
		public String getStr_wh_dep_ids() {
			return ((String) getAttrVal("Str_wh_dep_ids"));
		}

		public void setStr_wh_dep_ids(String Str_wh_dep_ids) {
			setAttrVal("Str_wh_dep_ids", Str_wh_dep_ids);
		}
	// 计量单位id集合
	public String getStr_unit_pkg_ids() {
		return ((String) getAttrVal("Str_unit_pkg_ids"));
	}

	public void setStr_unit_pkg_ids(String Str_unit_pkg_ids) {
		setAttrVal("Str_unit_pkg_ids", Str_unit_pkg_ids);
	}

	/// ===============================================

	/**
	 * 获取变动用药的映射集合
	 * 
	 * @return
	 */
	public FMap2 getEmsDoseDrugMap() {
		return (FMap2) getAttrVal("EmsDoseDrugMap");
	}

	/**
	 * 设置变动用药的映射集合
	 * 
	 * @param emsDoseDrugMap
	 */
	public void setEmsDoseDrugMap(FMap2 emsDoseDrugMap) {
		setAttrVal("EmsDoseDrugMap", emsDoseDrugMap);
	}

//	/**
//	 * 获取药品表单上的药品列表
//	 * @return
//	 */
//	public FArrayList getEmsOrDrugList() {
//		return (FArrayList) getAttrVal("EmsOrDrugList");
//
//	}
//
//	/**
//	 * 设置药品表单上的药品列表
//	 * @param emsOrDrugList
//	 */
//	public void setEmsOrDrugList(FArrayList emsOrDrugList) {
//
//		setAttrVal("EmsOrDrugList", emsOrDrugList);
//	}
	
	/**
	 * 获取药品表单上的药品列表
	 * @return
	 */
	public FArrayList getEmsOrDrugListEx() {
		return (FArrayList) getAttrVal("EmsOrDrugListEx");

	}

	/**
	 * 设置药品表单上的药品列表
	 * @param emsOrDrugList
	 */
	public void setEmsOrDrugListEx(FArrayList EmsOrDrugListEx) {

		setAttrVal("EmsOrDrugListEx", EmsOrDrugListEx);
	}

	/**
	 * 医嘱药品参照数据集
	 * 
	 * @return
	 */
	public FArrayList getEmsOrDrug() {
		return (FArrayList) getAttrVal("EmsOrDrug");

	}

	public void setEmsOrDrug(FArrayList EmsOrDrug) {

		setAttrVal("EmsOrDrug", EmsOrDrug);
	}
	
	/**
	 * 医嘱药品参照数据集
	 * 
	 * @return
	 */
	public FArrayList getEmsOrDrugEx() {
		return (FArrayList) getAttrVal("EmsOrDrugEx");

	}

	/**
	 * 医嘱药品参照数据集
	 * 
	 * @param EmsOrDrug_ex
	 */
	public void setEmsOrDrugEx(FArrayList EmsOrDrugEx) {

		setAttrVal("EmsOrDrugEx", EmsOrDrugEx);
	}
	/**
	 * 删除的药品集合
	 * 
	 * @return
	 */
	public FArrayList getEmsOrDeleteDrugList() {
		return (FArrayList) getAttrVal("EmsOrDeleteDrugList");

	}

	public void getEmsOrDeleteDrugList(FArrayList EmsOrDeleteDrugList) {
		setAttrVal("EmsOrDeleteDrugList", EmsOrDeleteDrugList);
	}

	/// <summary>
	/// 变动用药数据集合
	/// </summary>
	/// <value>
	/// The ems or dose drug list.
	/// </value>
	/// Author:admin
	/// Date:2015-09-12
	public FArrayList getEmsOrDoseDrug() {
		return (FArrayList) getAttrVal("EmsOrDoseDrug");

	}

	public void setEmsOrDoseDrug(FArrayList EmsOrDoseDrug) {
		setAttrVal("EmsOrDoseDrug", EmsOrDoseDrug);
	}
	
	/**
	 * 外配药标识（草药医疗单使用）
	 * @return FBoolean
	 */
	public FBoolean getFg_extdispense() {
		return ((FBoolean) getAttrVal("Fg_extdispense"));
	}
	/**
	 * 外配药标识（草药医疗单使用）
	 * @param Fg_extdispense
	 */
	public void setFg_extdispense(FBoolean Fg_extdispense) {
		setAttrVal("Fg_extdispense", Fg_extdispense);
	}
	/**
	 * 超量开单原因id
	 * @return String
	 */
	public String getId_excessive_reason() {
		return ((String) getAttrVal("Id_excessive_reason"));
	}
	/**
	 * 超量开单原因id
	 * @param Id_excessive_reason
	 */
	public void setId_excessive_reason(String Id_excessive_reason) {
		setAttrVal("Id_excessive_reason", Id_excessive_reason);
	}
	/**
	 * 超量开单原因sd
	 * @return String
	 */
	public String getSd_excessive_reason() {
		return ((String) getAttrVal("Sd_excessive_reason"));
	}
	/**
	 * 超量开单原因sd
	 * @param Sd_excessive_reason
	 */
	public void setSd_excessive_reason(String Sd_excessive_reason) {
		setAttrVal("Sd_excessive_reason", Sd_excessive_reason);
	}
   
	/////////添加检验、检查、诊疗多剂量多次执行，杨敬本20171111
	/**
	 * 是否多次执行
	 * @return
	 */
	public FBoolean getIsmulexec() {
		return ((FBoolean) getAttrVal("Ismulexec"));
	}
	/**
	 * 是否多次执行
	 * @param Ismulexec
	 */
	public void setIsmulexec(FBoolean Ismulexec) {
		setAttrVal("Ismulexec", Ismulexec);
	}
	
	/**
	 * 是否多剂量
	 * @return
	 */
	public FBoolean getIsmuldose() {
		return ((FBoolean) getAttrVal("Ismuldose"));
	}
	/**
	 * 是否多剂量
	 * @param Ismulexec
	 */
	public void setIsmuldose(FBoolean Ismuldose) {
		setAttrVal("Ismuldose", Ismuldose);
	}
	/////////添加检验、检查、诊疗多剂量多次执行，杨敬本20171111
}