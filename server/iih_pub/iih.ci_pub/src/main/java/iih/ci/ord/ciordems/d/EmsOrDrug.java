package iih.ci.ord.ciordems.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;

import java.math.BigDecimal;

/**
 * 药品项目 DTO数据 
 * 
 */
public class EmsOrDrug extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 * @return String
	 */
	public String getId_emsordrug() {
		return ((String) getAttrVal("Id_emsordrug"));
	}
	/**
	 * 主键
	 * @param Id_emsordrug
	 */
	public void setId_emsordrug(String Id_emsordrug) {
		setAttrVal("Id_emsordrug", Id_emsordrug);
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
	 * 通用品名称
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}
	/**
	 * 通用品名称
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	/**
	 * 物品
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}
	/**
	 * 物品
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 物品名称
	 * @return String
	 */
	public String getName_mm() {
		return ((String) getAttrVal("Name_mm"));
	}
	/**
	 * 物品名称
	 * @param Name_mm
	 */
	public void setName_mm(String Name_mm) {
		setAttrVal("Name_mm", Name_mm);
	}
	/**
	 * 规格
	 * @return String
	 */
	public String getSpec_mm() {
		return ((String) getAttrVal("Spec_mm"));
	}
	/**
	 * 规格
	 * @param Spec_mm
	 */
	public void setSpec_mm(String Spec_mm) {
		setAttrVal("Spec_mm", Spec_mm);
	}
	/**
	 * 剂量
	 * @return FDouble
	 */
	public FDouble getQuan_med() {
		return ((FDouble) getAttrVal("Quan_med"));
	}
	/**
	 * 剂量
	 * @param Quan_med
	 */
	public void setQuan_med(FDouble Quan_med) {
		setAttrVal("Quan_med", Quan_med);
	}
	
    
	/**
	 * 剂量单位
	 * @return String
	 */
	public String getId_unit_med() {
		return ((String) getAttrVal("Id_unit_med"));
	}
	/**
	 * 剂量单位
	 * @param Id_unit_med
	 */
	public void setId_unit_med(String Id_unit_med) {
		setAttrVal("Id_unit_med", Id_unit_med);
	}
	/**
	 * 剂量单位名称
	 * @return String
	 */
	public String getName_unit_med() {
		return ((String) getAttrVal("Name_unit_med"));
	}
	/**
	 * 剂量单位名称
	 * @param Name_unit_med
	 */
	public void setName_unit_med(String Name_unit_med) {
		setAttrVal("Name_unit_med", Name_unit_med);
	}
	/**
	 * 单次数量
	 * @return FDouble
	 */
	public FDouble getQuan_base() {
		return ((FDouble) getAttrVal("Quan_base"));
	}
	/**
	 * 单次数量
	 * @param Quan_base
	 */
	public void setQuan_base(FDouble Quan_base) {
		setAttrVal("Quan_base", Quan_base);
	}
	/**
	 * 总量
	 * @return FDouble
	 */
	public FDouble getQuan_cur() {
		return ((FDouble) getAttrVal("Quan_cur"));
	}
	/**
	 * 总量
	 * @param Quan_cur
	 */
	public void setQuan_cur(FDouble Quan_cur) {
		setAttrVal("Quan_cur", Quan_cur);
	}
	/**
	 * 零售单位
	 * @return String
	 */
	public String getId_unit_sale() {
		return ((String) getAttrVal("Id_unit_sale"));
	}
	/**
	 * 零售单位
	 * @param Id_unit_sale
	 */
	public void setId_unit_sale(String Id_unit_sale) {
		setAttrVal("Id_unit_sale", Id_unit_sale);
	}
	/**
	 * 零售单位名称
	 * @return String
	 */
	public String getName_unit_sale() {
		return ((String) getAttrVal("Name_unit_sale"));
	}
	/**
	 * 零售单位名称
	 * @param Name_unit_sale
	 */
	public void setName_unit_sale(String Name_unit_sale) {
		setAttrVal("Name_unit_sale", Name_unit_sale);
	}
	/**
	 * 数量单位
	 * @return String
	 */
	public String getId_unit_base() {
		return ((String) getAttrVal("Id_unit_base"));
	}
	/**
	 * 数量单位
	 * @param Id_unit_base
	 */
	public void setId_unit_base(String Id_unit_base) {
		setAttrVal("Id_unit_base", Id_unit_base);
	}
	/**
	 * 数量单位名称
	 * @return String
	 */
	public String getName_unit_base() {
		return ((String) getAttrVal("Name_unit_base"));
	}
	/**
	 * 数量单位名称
	 * @param Name_unit_base
	 */
	public void setName_unit_base(String Name_unit_base) {
		setAttrVal("Name_unit_base", Name_unit_base);
	}
	/**
	 * 医保
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}
	/**
	 * 医保
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	/**
	 * 医保类型名称
	 * @return String
	 */
	public String getName_hp() {
		return ((String) getAttrVal("Name_hp"));
	}
	/**
	 * 医保类型名称
	 * @param Name_hp
	 */
	public void setName_hp(String Name_hp) {
		setAttrVal("Name_hp", Name_hp);
	}
	/**
	 * 参考价格
	 * @return FDouble
	 */
	public FDouble getPrice() {
		return ((FDouble) getAttrVal("Price"));
	}
	/**
	 * 参考价格
	 * @param Price
	 */
	public void setPrice(FDouble Price) {
		setAttrVal("Price", Price);
	}
	/**
	 * 厂家
	 * @return String
	 */
	public String getVender() {
		return ((String) getAttrVal("Vender"));
	}
	/**
	 * 厂家
	 * @param Vender
	 */
	public void setVender(String Vender) {
		setAttrVal("Vender", Vender);
	}
	/**
	 * 限制报销条件
	 * @return String
	 */
	public String getLimit() {
		return ((String) getAttrVal("Limit"));
	}
	/**
	 * 限制报销条件
	 * @param Limit
	 */
	public void setLimit(String Limit) {
		setAttrVal("Limit", Limit);
	}
	/**
	 * 可用库存
	 * @return FDouble
	 */
	public FDouble getFact_count() {
		return ((FDouble) getAttrVal("Fact_count"));
	}
	/**
	 * 可用库存
	 * @param Fact_count
	 */
	public void setFact_count(FDouble Fact_count) {
		setAttrVal("Fact_count", Fact_count);
	}
	/**
	 * 描述
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}
	/**
	 * 描述
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 频次时刻id
	 * @return String
	 */
	public String getId_freqtime() {
		return ((String) getAttrVal("Id_freqtime"));
	}
	/**
	 * 频次时刻id
	 * @param Id_freqtime
	 */
	public void setId_freqtime(String Id_freqtime) {
		setAttrVal("Id_freqtime", Id_freqtime);
	}
	/**
	 * 频次的SD
	 * @return String
	 */
	public String getSd_frequnitct() {
		return ((String) getAttrVal("Sd_frequnitct"));
	}
	/**
	 * 频次的SD
	 * @param Sd_frequnitct
	 */
	public void setSd_frequnitct(String Sd_frequnitct) {
		setAttrVal("Sd_frequnitct", Sd_frequnitct);
	}
	/**
	 * 频次时刻
	 * @return String
	 */
	public String getName_freqtime() {
		return ((String) getAttrVal("Name_freqtime"));
	}
	/**
	 * 频次时刻
	 * @param Name_freqtime
	 */
	public void setName_freqtime(String Name_freqtime) {
		setAttrVal("Name_freqtime", Name_freqtime);
	}
	/**
	 * 排序号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}
	/**
	 * 排序号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
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
	 * 当前基本换算系数
	 * @return FDouble
	 */
	public FDouble getFactor_cb() {
		return ((FDouble) getAttrVal("Factor_cb"));
	}
	/**
	 * 当前基本换算系数
	 * @param Factor_cb
	 */
	public void setFactor_cb(FDouble Factor_cb) {
		setAttrVal("Factor_cb", Factor_cb);
	}
	/**
	 * 医学基本换算系数
	 * @return FDouble
	 */
	public FDouble getFactor_mb() {
		return ((FDouble) getAttrVal("Factor_mb"));
	}
	/**
	 * 医学基本换算系数
	 * @param Factor_mb
	 */
	public void setFactor_mb(FDouble Factor_mb) {
		setAttrVal("Factor_mb", Factor_mb);
	}
	/**
	 * 煎法要求id
	 * @return String
	 */
	public String getId_boildes() {
		return ((String) getAttrVal("Id_boildes"));
	}
	/**
	 * 煎法要求id
	 * @param Id_boildes
	 */
	public void setId_boildes(String Id_boildes) {
		setAttrVal("Id_boildes", Id_boildes);
	}
	/**
	 * 煎法要求
	 * @return String
	 */
	public String getName_boildes() {
		return ((String) getAttrVal("Name_boildes"));
	}
	/**
	 * 煎法要求
	 * @param Name_boildes
	 */
	public void setName_boildes(String Name_boildes) {
		setAttrVal("Name_boildes", Name_boildes);
	}
	/**
	 * 药品剂型
	 * @return String
	 */
	public String getId_dosage() {
		return ((String) getAttrVal("Id_dosage"));
	}
	/**
	 * 药品剂型
	 * @param Id_dosage
	 */
	public void setId_dosage(String Id_dosage) {
		setAttrVal("Id_dosage", Id_dosage);
	}
	/**
	 * 药品剂型编码
	 * @return String
	 */
	public String getSd_dosage() {
		return ((String) getAttrVal("Sd_dosage"));
	}
	/**
	 * 药品剂型编码
	 * @param Sd_dosage
	 */
	public void setSd_dosage(String Sd_dosage) {
		setAttrVal("Sd_dosage", Sd_dosage);
	}
	/**
	 * 药理分类
	 * @return String
	 */
	public String getId_pharm() {
		return ((String) getAttrVal("Id_pharm"));
	}
	/**
	 * 药理分类
	 * @param Id_pharm
	 */
	public void setId_pharm(String Id_pharm) {
		setAttrVal("Id_pharm", Id_pharm);
	}
	/**
	 * 药理分类编码
	 * @return String
	 */
	public String getSd_pharm() {
		return ((String) getAttrVal("Sd_pharm"));
	}
	/**
	 * 药理分类编码
	 * @param Sd_pharm
	 */
	public void setSd_pharm(String Sd_pharm) {
		setAttrVal("Sd_pharm", Sd_pharm);
	}
	/**
	 * 毒麻分类
	 * @return String
	 */
	public String getId_pois() {
		return ((String) getAttrVal("Id_pois"));
	}
	/**
	 * 毒麻分类
	 * @param Id_pois
	 */
	public void setId_pois(String Id_pois) {
		setAttrVal("Id_pois", Id_pois);
	}
	/**
	 * 毒麻分类编码
	 * @return String
	 */
	public String getSd_pois() {
		return ((String) getAttrVal("Sd_pois"));
	}
	/**
	 * 毒麻分类编码
	 * @param Sd_pois
	 */
	public void setSd_pois(String Sd_pois) {
		setAttrVal("Sd_pois", Sd_pois);
	}
	/**
	 * 抗菌药分类
	 * @return String
	 */
	public String getId_anti() {
		return ((String) getAttrVal("Id_anti"));
	}
	/**
	 * 抗菌药分类
	 * @param Id_anti
	 */
	public void setId_anti(String Id_anti) {
		setAttrVal("Id_anti", Id_anti);
	}
	/**
	 * 抗菌药分类编码
	 * @return String
	 */
	public String getSd_anti() {
		return ((String) getAttrVal("Sd_anti"));
	}
	/**
	 * 抗菌药分类编码
	 * @param Sd_anti
	 */
	public void setSd_anti(String Sd_anti) {
		setAttrVal("Sd_anti", Sd_anti);
	}
	/**
	 * 物品类型
	 * @return String
	 */
	public String getId_mmtp() {
		return ((String) getAttrVal("Id_mmtp"));
	}
	/**
	 * 物品类型
	 * @param Id_mmtp
	 */
	public void setId_mmtp(String Id_mmtp) {
		setAttrVal("Id_mmtp", Id_mmtp);
	}
	/**
	 * 物品类型编码
	 * @return String
	 */
	public String getSd_mmtp() {
		return ((String) getAttrVal("Sd_mmtp"));
	}
	/**
	 * 物品类型编码
	 * @param Sd_mmtp
	 */
	public void setSd_mmtp(String Sd_mmtp) {
		setAttrVal("Sd_mmtp", Sd_mmtp);
	}
	/**
	 * 物品类型名称
	 * @return String
	 */
	public String getName_mmtp() {
		return ((String) getAttrVal("Name_mmtp"));
	}
	/**
	 * 物品类型名称
	 * @param Name_mmtp
	 */
	public void setName_mmtp(String Name_mmtp) {
		setAttrVal("Name_mmtp", Name_mmtp);
	}
	/**
	 * 拼音码
	 * @return String
	 */
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}
	/**
	 * 拼音码
	 * @param Pycode
	 */
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	/**
	 * 选择
	 * @return FBoolean
	 */
	public FBoolean getFg_chk() {
		return ((FBoolean) getAttrVal("Fg_chk"));
	}
	/**
	 * 选择
	 * @param Fg_chk
	 */
	public void setFg_chk(FBoolean Fg_chk) {
		setAttrVal("Fg_chk", Fg_chk);
	}
	/**
	 * 频次id
	 * @return String
	 */
	public String getId_freq() {
		return ((String) getAttrVal("Id_freq"));
	}
	/**
	 * 频次id
	 * @param Id_freq
	 */
	public void setId_freq(String Id_freq) {
		setAttrVal("Id_freq", Id_freq);
	}
	/**
	 * 频次
	 * @return String
	 */
	public String getName_freq() {
		return ((String) getAttrVal("Name_freq"));
	}
	/**
	 * 频次
	 * @param Name_freq
	 */
	public void setName_freq(String Name_freq) {
		setAttrVal("Name_freq", Name_freq);
	}
	/**
	 * 金额
	 * @return FDouble
	 */
	public FDouble getTotalprice() {
		return ((FDouble) getAttrVal("Totalprice"));
	}
	/**
	 * 金额
	 * @param Totalprice
	 */
	public void setTotalprice(FDouble Totalprice) {
		setAttrVal("Totalprice", Totalprice);
	}
	/**
	 * 执行科室id
	 * @return String
	 */
	public String getId_mp_dep() {
		return ((String) getAttrVal("Id_mp_dep"));
	}
	/**
	 * 执行科室id
	 * @param Id_mp_dep
	 */
	public void setId_mp_dep(String Id_mp_dep) {
		setAttrVal("Id_mp_dep", Id_mp_dep);
	}
	/**
	 * 执行科室
	 * @return String
	 */
	public String getName_mp_dep() {
		return ((String) getAttrVal("Name_mp_dep"));
	}
	/**
	 * 执行科室
	 * @param Name_mp_dep
	 */
	public void setName_mp_dep(String Name_mp_dep) {
		setAttrVal("Name_mp_dep", Name_mp_dep);
	}
	/**
	 * 总量单位id
	 * @return String
	 */
	public String getId_pgku_cur() {
		return ((String) getAttrVal("Id_pgku_cur"));
	}
	/**
	 * 总量单位id
	 * @param Id_pgku_cur
	 */
	public void setId_pgku_cur(String Id_pgku_cur) {
		setAttrVal("Id_pgku_cur", Id_pgku_cur);
	}
	/**
	 * 总量单位
	 * @return String
	 */
	public String getName_pgku_cur() {
		return ((String) getAttrVal("Name_pgku_cur"));
	}
	/**
	 * 总量单位
	 * @param Name_pgku_cur
	 */
	public void setName_pgku_cur(String Name_pgku_cur) {
		setAttrVal("Name_pgku_cur", Name_pgku_cur);
	}
	/**
	 * 药品编码
	 * @return String
	 */
	public String getCode_mm() {
		return ((String) getAttrVal("Code_mm"));
	}
	/**
	 * 药品编码
	 * @param Code_mm
	 */
	public void setCode_mm(String Code_mm) {
		setAttrVal("Code_mm", Code_mm);
	}
	/**
	 * 价值分类id
	 * @return String
	 */
	public String getId_val() {
		return ((String) getAttrVal("Id_val"));
	}
	/**
	 * 价值分类id
	 * @param Id_val
	 */
	public void setId_val(String Id_val) {
		setAttrVal("Id_val", Id_val);
	}
	/**
	 * 价值分类
	 * @return String
	 */
	public String getSd_val() {
		return ((String) getAttrVal("Sd_val"));
	}
	/**
	 * 价值分类
	 * @param Sd_val
	 */
	public void setSd_val(String Sd_val) {
		setAttrVal("Sd_val", Sd_val);
	}
	/**
	 * 抗精神分类id
	 * @return String
	 */
	public String getId_antipsy() {
		return ((String) getAttrVal("Id_antipsy"));
	}
	/**
	 * 抗精神分类id
	 * @param Id_antipsy
	 */
	public void setId_antipsy(String Id_antipsy) {
		setAttrVal("Id_antipsy", Id_antipsy);
	}
	/**
	 * 抗精神分类
	 * @return String
	 */
	public String getSd_antipsy() {
		return ((String) getAttrVal("Sd_antipsy"));
	}
	/**
	 * 抗精神分类
	 * @param Sd_antipsy
	 */
	public void setSd_antipsy(String Sd_antipsy) {
		setAttrVal("Sd_antipsy", Sd_antipsy);
	}
	/**
	 * otc标识
	 * @return FBoolean
	 */
	public FBoolean getFg_otc() {
		return ((FBoolean) getAttrVal("Fg_otc"));
	}
	/**
	 * otc标识
	 * @param Fg_otc
	 */
	public void setFg_otc(FBoolean Fg_otc) {
		setAttrVal("Fg_otc", Fg_otc);
	}
	/**
	 * 住院取整方式
	 * @return String
	 */
	public String getId_mupkgutp() {
		return ((String) getAttrVal("Id_mupkgutp"));
	}
	/**
	 * 住院取整方式
	 * @param Sd_mupkgutp
	 */
	public void setId_mupkgutp(String Id_mupkgutp) {
		setAttrVal("Id_mupkgutp", Id_mupkgutp);
	}
	/**
	 * 住院取整方式
	 * @return String
	 */
	public String getSd_mupkgutp() {
		return ((String) getAttrVal("Sd_mupkgutp"));
	}
	/**
	 * 住院取整方式
	 * @param Sd_mupkgutp
	 */
	public void setSd_mupkgutp(String Sd_mupkgutp) {
		setAttrVal("Sd_mupkgutp", Sd_mupkgutp);
	}
	/**
	 * 门诊包装单位取整方式
	 * @return String
	 */
	public String getId_opmutp() {
		return ((String) getAttrVal("Id_opmutp"));
	}
	/**
	 * 门诊包装单位取整方式
	 * @param Sd_opmutp
	 */
	public void setId_opmutp(String Id_opmutp) {
		setAttrVal("Id_opmutp", Id_opmutp);
	}
	/**
	 * 门诊包装单位取整方式
	 * @return String
	 */
	public String getSd_opmutp() {
		return ((String) getAttrVal("Sd_opmutp"));
	}
	/**
	 * 门诊包装单位取整方式
	 * @param Sd_opmutp
	 */
	public void setSd_opmutp(String Sd_opmutp) {
		setAttrVal("Sd_opmutp", Sd_opmutp);
	}
	/**
	 * 计量单位id集合
	 * @return String
	 */
	public String getStr_unit_pkg_ids() {
		return ((String) getAttrVal("Str_unit_pkg_ids"));
	}
	/**
	 * 计量单位id集合
	 * @param Str_unit_pkg_ids
	 */
	public void setStr_unit_pkg_ids(String Str_unit_pkg_ids) {
		setAttrVal("Str_unit_pkg_ids", Str_unit_pkg_ids);
	}
	/**
	 * 物品标志
	 * @return FBoolean
	 */
	public FBoolean getFg_mm() {
		return ((FBoolean) getAttrVal("Fg_mm"));
	}
	/**
	 * 物品标志
	 * @param Fg_mm
	 */
	public void setFg_mm(FBoolean Fg_mm) {
		setAttrVal("Fg_mm", Fg_mm);
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
	 * 服务编码
	 * @return String
	 */
	public String getCode_srv() {
		return ((String) getAttrVal("Code_srv"));
	}
	/**
	 * 服务编码
	 * @param Code_srv
	 */
	public void setCode_srv(String Code_srv) {
		setAttrVal("Code_srv", Code_srv);
	}
	/**
	 * 服务类型id
	 * @return String
	 */
	public String getId_srvtp() {
		return ((String) getAttrVal("Id_srvtp"));
	}
	/**
	 * 服务类型id
	 * @param Id_srvtp
	 */
	public void setId_srvtp(String Id_srvtp) {
		setAttrVal("Id_srvtp", Id_srvtp);
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
	 * 物品绑定_住院
	 * @return String
	 */
	public String getSd_mmbind_ip() {
		return ((String) getAttrVal("Sd_mmbind_ip"));
	}
	/**
	 * 物品绑定_住院
	 * @param Sd_mmbind_ip
	 */
	public void setSd_mmbind_ip(String Sd_mmbind_ip) {
		setAttrVal("Sd_mmbind_ip", Sd_mmbind_ip);
	}
	/**
	 * 物品绑定_门诊
	 * @return String
	 */
	public String getSd_mmbind_op() {
		return ((String) getAttrVal("Sd_mmbind_op"));
	}
	/**
	 * 物品绑定_门诊
	 * @param Sd_mmbind_ip
	 */
	public void setSd_mmbind_op(String Sd_mmbind_op) {
		setAttrVal("Sd_mmbind_op", Sd_mmbind_op);
	}
	/**
	 * 物品绑定_急诊
	 * @return String
	 */
	public String getSd_mmbind_er() {
		return ((String) getAttrVal("Sd_mmbind_er"));
	}
	/**
	 * 物品绑定_急诊
	 * @param Sd_mmbind_ip
	 */
	public void setSd_mmbind_er(String Sd_mmbind_er) {
		setAttrVal("Sd_mmbind_er", Sd_mmbind_er);
	}
	/**
	 * 定价模式
	 * @return String
	 */
	public String getId_pri() {
		return ((String) getAttrVal("Id_pri"));
	}
	/**
	 * 定价模式
	 * @param Id_pri
	 */
	public void setId_pri(String Id_pri) {
		setAttrVal("Id_pri", Id_pri);
	}
	/**
	 * 限制
	 * @return String
	 */
	public String getHpdes() {
		return ((String) getAttrVal("Hpdes"));
	}
	/**
	 * 限制
	 * @param Hpdes
	 */
	public void setHpdes(String Hpdes) {
		setAttrVal("Hpdes", Hpdes);
	}
	/**
	 * 医嘱物品
	 * @return String
	 */
	public String getId_srvmm() {
		return ((String) getAttrVal("Id_srvmm"));
	}
	/**
	 * 医嘱物品
	 * @param Id_srvmm
	 */
	public void setId_srvmm(String Id_srvmm) {
		setAttrVal("Id_srvmm", Id_srvmm);
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
	 * 自定义服务标识
	 * @return FBoolean
	 */
	public FBoolean getFg_selfsrv() {
		return ((FBoolean) getAttrVal("Fg_selfsrv"));
	}	
	/**
	 * 自定义服务标识
	 * @param Fg_selfsrv
	 */
	public void setFg_selfsrv(FBoolean Fg_selfsrv) {
		setAttrVal("Fg_selfsrv", Fg_selfsrv);
	}
	/**
	 * 预防和治疗
	 * @return FBoolean
	 */
	public FBoolean getFg_propc() {
		return ((FBoolean) getAttrVal("Fg_propc"));
	}
	/**
	 * 预防和治疗
	 * @param Fg_propc
	 */
	public void setFg_propc(FBoolean Fg_propc) {
		setAttrVal("Fg_propc", Fg_propc);
	}
	/**
	 * 适应和非适应
	 * @return FBoolean
	 */
	public FBoolean getFg_treat() {
		return ((FBoolean) getAttrVal("Fg_treat"));
	}
	/**
	 * 适应和非适应
	 * @param Fg_treat
	 */
	public void setFg_treat(FBoolean Fg_treat) {
		setAttrVal("Fg_treat", Fg_treat);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getNote_or() {
		return ((String) getAttrVal("Note_or"));
	}
	/**
	 * 备注
	 * @param Note_or
	 */
	public void setNote_or(String Note_or) {
		setAttrVal("Note_or", Note_or);
	}
	/**
	 * 扩展说明
	 * @return String
	 */
	public String getNote_ext() {
		return ((String) getAttrVal("Note_ext"));
	}
	/**
	 * 扩展说明
	 * @param Note_ext
	 */
	public void setNote_ext(String Note_ext) {
		setAttrVal("Note_ext", Note_ext);
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
	 * 处置周期
	 * @return Integer
	 */
	public Integer getUse_days() {
		return ((Integer) getAttrVal("Use_days"));
	}
	/**
	 * 处置周期
	 * @param Use_days
	 */
	public void setUse_days(Integer Use_days) {
		setAttrVal("Use_days", Use_days);
	}
	/**
	 * 加急
	 * @return FBoolean
	 */
	public FBoolean getFg_urgent() {
		return ((FBoolean) getAttrVal("Fg_urgent"));
	}
	/**
	 * 加急
	 * @param Fg_urgent
	 */
	public void setFg_urgent(FBoolean Fg_urgent) {
		setAttrVal("Fg_urgent", Fg_urgent);
	}
	/**
	 * 变动用药标识
	 * @return FBoolean
	 */
	public FBoolean getFg_dose_anoma() {
		return ((FBoolean) getAttrVal("Fg_dose_anoma"));
	}
	/**
	 * 变动用药标识
	 * @param Fg_dose_anoma
	 */
	public void setFg_dose_anoma(FBoolean Fg_dose_anoma) {
		setAttrVal("Fg_dose_anoma", Fg_dose_anoma);
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
	 * 不皮试原因
	 * @return String
	 */
	public String getId_skintest_skip_reason() {
		return ((String) getAttrVal("Id_skintest_skip_reason"));
	}
	/**
	 * 不皮试原因
	 * @param Id_skintest_skip_reason
	 */
	public void setId_skintest_skip_reason(String Id_skintest_skip_reason) {
		setAttrVal("Id_skintest_skip_reason", Id_skintest_skip_reason);
	}
	/**
	 * 不皮试原因编码
	 * @return String
	 */
	public String getSd_skintest_skip_reason() {
		return ((String) getAttrVal("Sd_skintest_skip_reason"));
	}
	/**
	 * 不皮试原因编码
	 * @param Sd_skintest_skip_reason
	 */
	public void setSd_skintest_skip_reason(String Sd_skintest_skip_reason) {
		setAttrVal("Sd_skintest_skip_reason", Sd_skintest_skip_reason);
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
	 * 对应关联医嘱id_or
	 * @return String
	 */
	public String getId_or_rel() {
		return ((String) getAttrVal("Id_or_rel"));
	}
	/**
	 * 对应关联医嘱id_or
	 * @param Id_or_rel
	 */
	public void setId_or_rel(String Id_or_rel) {
		setAttrVal("Id_or_rel", Id_or_rel);
	}
	/**
	 * 皮试服务id
	 * @return String
	 */
	public String getId_srvskin() {
		return ((String) getAttrVal("Id_srvskin"));
	}
	/**
	 * 皮试服务id
	 * @param Id_srvskin
	 */
	public void setId_srvskin(String Id_srvskin) {
		setAttrVal("Id_srvskin", Id_srvskin);
	}
//	/**
//	 * 频次SD
//	 * @return String
//	 */
//	public String getSd_freq() {
//		return ((String) getAttrVal("Sd_freq"));
//	}
//	/**
//	 * 频次SD
//	 * @param Sd_freq
//	 */
//	public void setSd_freq(String Sd_freq) {
//		setAttrVal("Sd_freq", Sd_freq);
//	}
	/**
	 * 频次数量
	 * @return Integer
	 */
	public Integer getFreqct() {
		return ((Integer) getAttrVal("Freqct"));
	}
	/**
	 * 频次数量
	 * @param Freqct
	 */
	public void setFreqct(Integer Freqct) {
		setAttrVal("Freqct", Freqct);
	}
	/**
	 * 自定义服务名称标志
	 * @return FBoolean
	 */
	public FBoolean getFg_ctm() {
		return ((FBoolean) getAttrVal("Fg_ctm"));
	}
	/**
	 * 自定义服务名称标志
	 * @param Fg_ctm
	 */
	public void setFg_ctm(FBoolean Fg_ctm) {
		setAttrVal("Fg_ctm", Fg_ctm);
	}
	/**
	 * 自费
	 * @return FBoolean
	 */
	public FBoolean getFg_selfpay() {
		return ((FBoolean) getAttrVal("Fg_selfpay"));
	}
	/**
	 * 自费
	 * @param Fg_selfpay
	 */
	public void setFg_selfpay(FBoolean Fg_selfpay) {
		setAttrVal("Fg_selfpay", Fg_selfpay);
	}
	/**
	 * 医保类型
	 * @return String
	 */
	public String getId_hpsrvtp() {
		return ((String) getAttrVal("Id_hpsrvtp"));
	}
	/**
	 * 医保类型
	 * @param Id_hpsrvtp
	 */
	public void setId_hpsrvtp(String Id_hpsrvtp) {
		setAttrVal("Id_hpsrvtp", Id_hpsrvtp);
	}
	/**
	 * 医保类型编码
	 * @return String
	 */
	public String getSd_hpsrvtp() {
		return ((String) getAttrVal("Sd_hpsrvtp"));
	}
	/**
	 * 医保类型编码
	 * @param Sd_hpsrvtp
	 */
	public void setSd_hpsrvtp(String Sd_hpsrvtp) {
		setAttrVal("Sd_hpsrvtp", Sd_hpsrvtp);
	}
	/**
	 * 通用医保计划目录类型
	 * @return String
	 */
	public String getName_hpsrvtp() {
		return ((String) getAttrVal("Name_hpsrvtp"));
	}
	/**
	 * 通用医保计划目录类型
	 * @param Name_hpsrvtp
	 */
	public void setName_hpsrvtp(String Name_hpsrvtp) {
		setAttrVal("Name_hpsrvtp", Name_hpsrvtp);
	}
	/**
	 * 医保名称
	 * @return String
	 */
	public String getName_heath() {
		return ((String) getAttrVal("Name_heath"));
	}
	/**
	 * 医保名称
	 * @param Name_heath
	 */
	public void setName_heath(String Name_heath) {
		setAttrVal("Name_heath", Name_heath);
	}
	/**
	 * 库房
	 * @return String
	 */
	public String getId_dep_wh() {
		return ((String) getAttrVal("Id_dep_wh"));
	}
	/**
	 * 库房
	 * @param Id_dep_wh
	 */
	public void setId_dep_wh(String Id_dep_wh) {
		setAttrVal("Id_dep_wh", Id_dep_wh);
	}
	/**
	 * 代办人信息
	 * @return FArrayList
	 */
	public FArrayList getAgentinfolist() {
		return ((FArrayList) getAttrVal("Agentinfolist"));
	}
	/**
	 * 代办人信息
	 * @param Agentinfolist
	 */
	public void setAgentinfolist(FArrayList Agentinfolist) {
		setAttrVal("Agentinfolist", Agentinfolist);
	}
	/**
	 * 医疗单来源
	 * @return Integer
	 */
	public Integer getEu_sourcemd() {
		return ((Integer) getAttrVal("Eu_sourcemd"));
	}
	/**
	 * 医疗单来源
	 * @param Eu_sourcemd
	 */
	public void setEu_sourcemd(Integer Eu_sourcemd) {
		setAttrVal("Eu_sourcemd", Eu_sourcemd);
	}
	/**
	 * 临床标识
	 * @return FBoolean
	 */
	public FBoolean getFg_or() {
		return ((FBoolean) getAttrVal("Fg_or"));
	}
	/**
	 * 临床标识
	 * @param Fg_or
	 */
	public void setFg_or(FBoolean Fg_or) {
		setAttrVal("Fg_or", Fg_or);
	}
	/**
	 * 要求
	 * @return String
	 */
	public String getId_routedes() {
		return ((String) getAttrVal("Id_routedes"));
	}
	/**
	 * 要求
	 * @param Id_routedes
	 */
	public void setId_routedes(String Id_routedes) {
		setAttrVal("Id_routedes", Id_routedes);
	}
	/**
	 * 要求名称
	 * @return String
	 */
	public String getName_routedes() {
		return ((String) getAttrVal("Name_routedes"));
	}
	/**
	 * 要求名称
	 * @param Name_routedes
	 */
	public void setName_routedes(String Name_routedes) {
		setAttrVal("Name_routedes", Name_routedes);
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
	 * 煎法名称
	 * @return String
	 */
	public String getName_boil() {
		return ((String) getAttrVal("Name_boil"));
	}
	/**
	 * 煎法名称
	 * @param Name_boil
	 */
	public void setName_boil(String Name_boil) {
		setAttrVal("Name_boil", Name_boil);
	}
	/**
	 * 服务分类内码
	 * @return String
	 */
	public String getInnercode_srvca() {
		return ((String) getAttrVal("Innercode_srvca"));
	}
	/**
	 * 服务分类内码
	 * @param Innercode_srvca
	 */
	public void setInnercode_srvca(String Innercode_srvca) {
		setAttrVal("Innercode_srvca", Innercode_srvca);
	}
	/**
	 * 划价方式
	 * @return Integer
	 */
	public Integer getEu_blmd() {
		return ((Integer) getAttrVal("Eu_blmd"));
	}
	/**
	 * 划价方式
	 * @param Eu_blmd
	 */
	public void setEu_blmd(Integer Eu_blmd) {
		setAttrVal("Eu_blmd", Eu_blmd);
	}
	/**
	 * 所属服务来源
	 * @return String
	 */
	public String getId_srv_src() {
		return ((String) getAttrVal("Id_srv_src"));
	}
	/**
	 * 所属服务来源
	 * @param Id_srv_src
	 */
	public void setId_srv_src(String Id_srv_src) {
		setAttrVal("Id_srv_src", Id_srv_src);
	}
	/**
	 * 计价状态
	 * @return String
	 */
	public String getPriby() {
		return ((String) getAttrVal("Priby"));
	}
	/**
	 * 计价状态
	 * @param Priby
	 */
	public void setPriby(String Priby) {
		setAttrVal("Priby", Priby);
	}
	/**
	 * 所有关联字段集合
	 * @return FMap
	 */
	public FMap getRelativefieldmap() {
		return ((FMap) getAttrVal("Relativefieldmap"));
	}
	/**
	 * 所有关联字段集合
	 * @param Relativefieldmap
	 */
	public void setRelativefieldmap(FMap Relativefieldmap) {
		setAttrVal("Relativefieldmap", Relativefieldmap);
	}
	/**
	 * 毒麻标志
	 * @return FBoolean
	 */
	public FBoolean getFg_pois() {
		return ((FBoolean) getAttrVal("Fg_pois"));
	}
	/**
	 * 毒麻标志
	 * @param Fg_pois
	 */
	public void setFg_pois(FBoolean Fg_pois) {
		setAttrVal("Fg_pois", Fg_pois);
	}
	/**
	 * 抗菌药标志
	 * @return FBoolean
	 */
	public FBoolean getFg_anti() {
		return ((FBoolean) getAttrVal("Fg_anti"));
	}
	/**
	 * 抗菌药标志
	 * @param Fg_anti
	 */
	public void setFg_anti(FBoolean Fg_anti) {
		setAttrVal("Fg_anti", Fg_anti);
	}
	// 执行科室id集合
		public String getStr_mp_dep_ids() {
			return ((String) getAttrVal("Str_mp_dep_ids"));
		}

		public void setStr_mp_dep_ids(String Str_mp_dep_ids) {
			setAttrVal("Str_mp_dep_ids", Str_mp_dep_ids);
		}
		// 库房科室id集合
		public String getStr_wh_dep_ids() {
			return ((String) getAttrVal("Str_wh_dep_ids"));
		}

		public void setStr_wh_dep_ids(String Str_wh_dep_ids) {
			setAttrVal("Str_wh_dep_ids", Str_wh_dep_ids);
		}
		// 药房名称集合
		public String getName_dep_wh() {
			return ((String) getAttrVal("Name_dep_wh"));
		}

		public void setName_dep_wh(String Name_dep_wh) {
			setAttrVal("Name_dep_wh", Name_dep_wh);
		}
		
	  //医保信息
    public FArrayList getBdHpIndicationDTO()
    {
          return (FArrayList)getAttrVal("BdHpIndicationDTO"); 
        
    }
	 //医保信息
	 public void setBdHpIndicationDTO(FArrayList BdHpIndicationDTO )
    {
        
         setAttrVal("BdHpIndicationDTO", BdHpIndicationDTO);  
    }
	 /**
		 * 药品库存状态
		 * @return Integer
		 */
		public Integer getMmstatus() {
			return ((Integer) getAttrVal("Mmstatus"));
		}
		/**
		 * 药品库存状态
		 * @param Mmstatus
		 */
		public void setMmstatus(Integer Mmstatus) {
			setAttrVal("Mmstatus", Mmstatus);
		}
		/**
		 * 诊断id
		 * @return String
		 */
		public String getId_di() {
			return ((String) getAttrVal("Id_di"));
		}
		/**
		 * 诊断id
		 * @param Id_di
		 */
		public void setId_di(String Id_di) {
			setAttrVal("Id_di", Id_di);
		}
		/**
		 * 诊断子id
		 * @return String
		 */
		public String getId_diitm() {
			return ((String) getAttrVal("Id_diitm"));
		}
		/**
		 * 诊断子id
		 * @param Id_diitm
		 */
		public void setId_diitm(String Id_diitm) {
			setAttrVal("Id_diitm", Id_diitm);
		}
		/**
		 * 诊断名称
		 * @return String
		 */
		public String getName_diag() {
			return ((String) getAttrVal("Name_diag"));
		}
		/**
		 * 诊断名称
		 * @param Name_diag
		 */
		public void setName_diag(String Name_diag) {
			setAttrVal("Name_diag", Name_diag);
		}
		/**
		 * 计划检查日期
		 * @return FDateTime
		 */
		public FDateTime getDt_plan() {
			return ((FDateTime) getAttrVal("Dt_plan"));
		}
		/**
		 * 计划检查日期
		 * @param Dt_plan
		 */
		public void setDt_plan(FDateTime Dt_plan) {
			setAttrVal("Dt_plan", Dt_plan);
		}
		/**
		 * 申请单号
		 * @return String
		 */
		public String getNo_applyform() {
			return ((String) getAttrVal("No_applyform"));
		}
		/**
		 * 申请单号
		 * @param No_applyform
		 */
		public void setNo_applyform(String No_applyform) {
			setAttrVal("No_applyform", No_applyform);
		}
		/**
		 * 医生是已进行医保确认  0 未处理，1已经处理
		 * @return Integer
		 */
		public Integer getEu_hpdoctorjudge11() {
			return ((Integer) getAttrVal("Eu_hpdoctorjudge"));
		}
		/**
		 * 医生是已进行医保确认  0 未处理，1已经处理
		 * @param Sortno
		 */
		public void setEu_hpdoctorjudge11(Integer Eu_hpdoctorjudge) {
			setAttrVal("Eu_hpdoctorjudge", Eu_hpdoctorjudge);
		}
		/**
		 * 变动用药列表
		 * @return FArrayList
		 */
		public FArrayList getOrDoseDrugList() {
			return ((FArrayList) getAttrVal("OrDoseDrugList"));
		}
		/**
		 * 变动用药列表
		 * @param OrDoseDrugList
		 */
		public void setOrDoseDrugList(FArrayList OrDoseDrugList) {
			setAttrVal("OrDoseDrugList", OrDoseDrugList);
		}
		/**
		 * 剂量_虚拟
		 * @return FDouble
		 */
		public FDouble getQuan_medu_virtual() {
			return ((FDouble) getAttrVal("Quan_medu_virtual"));
		}
		/**
		 * 剂量_虚拟
		 * @param Quan_medu_virtual
		 */
		public void setQuan_medu_virtual(FDouble Quan_medu_virtual) {
			setAttrVal("Quan_medu_virtual", Quan_medu_virtual);
		}
		/**
		 * 剂量单位虚拟
		 * @return String
		 */
		public String getName_unit_medu_virtual() {
			return ((String) getAttrVal("Name_unit_medu_virtual"));
		}
		/**
		 * 剂量单位虚拟
		 * @param Name_unit_medu_virtual
		 */
		public void setName_unit_medu_virtual(String Name_unit_medu_virtual) {
			setAttrVal("Name_unit_medu_virtual", Name_unit_medu_virtual);
		}
		/**
		 * 外配药标识
		 * @return FBoolean
		 */
		public FBoolean getFg_extdispense() {
			return ((FBoolean) getAttrVal("Fg_extdispense"));
		}
		/**
		 * 外配药标识
		 * @param Fg_extdispense
		 */
		public void setFg_extdispense(FBoolean Fg_extdispense) {
			setAttrVal("Fg_extdispense", Fg_extdispense);
		}
		/**
		 * 医保服务计划编码
		 * @return String
		 */
		public String getCode_hpsrvorca() {
			return ((String) getAttrVal("Code_hpsrvorca"));
		}
		/**
		 * 医保服务计划编码
		 * @param Code_hpsrvorca
		 */
		public void setCode_hpsrvorca(String Code_hpsrvorca) {
			setAttrVal("Code_hpsrvorca", Code_hpsrvorca);
		}
		/**
		 * 医保适应症医生界面判断
		 * @return
		 */
		public Integer getFg_hpindicjudged() {
			return ((Integer) getAttrVal("Fg_hpindicjudged"));
		}	
		/**
		 * 医保适应症医生界面判断
		 * @param Fg_hpindicjudged
		 */
		public void setFg_hpindicjudged(Integer Fg_hpindicjudged) {
			setAttrVal("Fg_hpindicjudged", Fg_hpindicjudged);
		}
		/**
		 * 标本类型id
		 * @param Id_samptp
		 */
		public void setId_samptp(String Id_samptp) {
			setAttrVal("Id_samptp", Id_samptp);
		}
		/**
		 * 标本类型id
		 * @param Id_samptp
		 */
		public String getId_samptp() {
			return ((String) getAttrVal("Id_samptp"));
		}
		/**
		 * 标本类型名称
		 * @return String
		 */
		public String getName_samptp() {
			return ((String) getAttrVal("Name_samptp"));
		}
		/**
		 * 标本类型名称
		 * @param Name_samptp
		 */
		public void setName_samptp(String Name_samptp) {
			setAttrVal("Name_samptp", Name_samptp);
		}
		/**
		 * 标本类型编码
		 * @return String
		 */
		public String getSd_samptp() {
			return ((String) getAttrVal("Sd_samptp"));
		}
		/**
		 * 标本类型编码
		 * @param Sd_samptp
		 */
		public void setSd_samptp(String Sd_samptp) {
			setAttrVal("Sd_samptp", Sd_samptp);
		}
		/**
		 * 标本采集时间
		 * @return FDateTime
		 */
		public String getId_sampcoltime() {
			return ((String) getAttrVal("Id_sampcoltime"));
		}
		/**
		 * 标本采集时间
		 * @param Id_sampcoltime
		 */
		public void setId_sampcoltime(String Id_sampcoltime) {
			setAttrVal("Id_sampcoltime", Id_sampcoltime);
		}
		/**
		 * 标本采集时间名称
		 * @return String
		 */
		public String getName_sampcoltime() {
			return ((String) getAttrVal("Name_sampcoltime"));
		}
		/**
		 * 标本采集时间名称
		 * @param Name_sampcoltime
		 */
		public void setName_sampcoltime(String Name_sampcoltime) {
			setAttrVal("Name_sampcoltime", Name_sampcoltime);
		}
		/**
		 * 标本采集时间类型采集时间类型
		 * @return String
		 */
		public String getId_sampcollecttimetp() {
			return ((String) getAttrVal("Id_sampcollecttimetp"));
		}
		/**
		 * 标本采集时间类型采集时间类型
		 * @param Id_sampcollecttimetp
		 */
		public void setId_sampcollecttimetp(String Id_sampcollecttimetp) {
			setAttrVal("Id_sampcollecttimetp", Id_sampcollecttimetp);
		}
		/**
		 * 采集时间编码
		 * @return String
		 */
		public String getSd_sampcollecttimetp() {
			return ((String) getAttrVal("Sd_sampcollecttimetp"));
		}
		/**
		 * 采集时间编码
		 * @param Sd_sampcollecttimetp
		 */
		public void setSd_sampcollecttimetp(String Sd_sampcollecttimetp) {
			setAttrVal("Sd_sampcollecttimetp", Sd_sampcollecttimetp);
		}
		/**
		 * 标本采集时长
		 * @return FDouble
		 */
		public FDouble getLen_sampcoltime() {
			return ((FDouble) getAttrVal("Len_sampcoltime"));
		}
		/**
		 * 标本采集时长
		 * @param Len_sampcoltime
		 */
		public void setLen_sampcoltime(FDouble Len_sampcoltime) {
			setAttrVal("Len_sampcoltime", Len_sampcoltime);
		}
		/**
		 * 时长单位
		 * @return String
		 */
		public String getId_unit_sampcoltime() {
			return ((String) getAttrVal("Id_unit_sampcoltime"));
		}
		/**
		 * 时长单位
		 * @param Id_unit_sampcoltime
		 */
		public void setId_unit_sampcoltime(String Id_unit_sampcoltime) {
			setAttrVal("Id_unit_sampcoltime", Id_unit_sampcoltime);
		}
		/**
		 * 检查目的
		 * @return String
		 */
		public String getId_pps() {
			return ((String) getAttrVal("Id_pps"));
		}
		/**
		 * 检查目的
		 * @param Id_pps
		 */
		public void setId_pps(String Id_pps) {
			setAttrVal("Id_pps", Id_pps);
		}
		/**
		 * 检查目的编码
		 * @return String
		 */
		public String getSd_pps() {
			return ((String) getAttrVal("Sd_pps"));
		}
		/**
		 * 检查目的编码
		 * @param Sd_pps
		 */
		public void setSd_pps(String Sd_pps) {
			setAttrVal("Sd_pps", Sd_pps);
		}
		/**
		 * 检查目的名称
		 * @return String
		 */
		public String getName_pps() {
			return ((String) getAttrVal("Name_pps"));
		}
		/**
		 * 检查目的名称
		 * @param Name_pps
		 */
		public void setName_pps(String Name_pps) {
			setAttrVal("Name_pps", Name_pps);
		}
		
		/**
		 * 服务套单选限制标识
		 * @return FBoolean
		 */
		public FBoolean getFg_setradio() {
			return ((FBoolean) getAttrVal("Fg_setradio"));
		}
		/**
		 * 服务套单选限制标识
		 * @param Fg_setradio
		 */
		public void setFg_setradio(FBoolean Fg_setradio) {
			setAttrVal("Fg_setradio", Fg_setradio);
		}
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
}