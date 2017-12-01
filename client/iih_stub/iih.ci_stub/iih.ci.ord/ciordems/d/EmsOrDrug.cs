using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.ciordems.d
{
    /// <summary>
    /// EmsOrDrug 的摘要说明。
    /// </summary>
    public class EmsOrDrug : BaseDTO {

        public EmsOrDrug() {
 
        }
        
        /// <summary>
        /// 多价格比例主键
        /// </summary>
        public string Indicitemid
        {
            get { return getAttrVal<string>("Indicitemid", null); }
            set { setAttrVal<string>("Indicitemid", value); }
        }
        /// <summary>
        /// 多价格比例主键名称
        /// </summary>
        public string Indicitemid_name
        {
            get { return getAttrVal<string>("Indicitemid_name", null); }
            set { setAttrVal<string>("Indicitemid_name", value); }
        }
        /// <summary>
        /// 主键
        /// </summary>
		public string Id_emsordrug {
            get { return getAttrVal<string>("Id_emsordrug",null); }
            set { setAttrVal<string>("Id_emsordrug", value); }
        }

        /// <summary>
        /// 服务id
        /// </summary>
		public string Id_srv {
            get { return getAttrVal<string>("Id_srv",null); }
            set { setAttrVal<string>("Id_srv", value); }
        }

        /// <summary>
        /// 医嘱服务id
        /// </summary>
		public string Id_orsrv {
            get { return getAttrVal<string>("Id_orsrv",null); }
            set { setAttrVal<string>("Id_orsrv", value); }
        }

        /// <summary>
        /// 通用品名称
        /// </summary>
		public string Name_srv {
            get { return getAttrVal<string>("Name_srv",null); }
            set { setAttrVal<string>("Name_srv", value); }
        }

        /// <summary>
        /// 物品
        /// </summary>
		public string Id_mm {
            get { return getAttrVal<string>("Id_mm",null); }
            set { setAttrVal<string>("Id_mm", value); }
        }

        /// <summary>
        /// 物品名称
        /// </summary>
		public string Name_mm {
            get { return getAttrVal<string>("Name_mm",null); }
            set { setAttrVal<string>("Name_mm", value); }
        }

        /// <summary>
        /// 规格
        /// </summary>
		public string Spec_mm {
            get { return getAttrVal<string>("Spec_mm",null); }
            set { setAttrVal<string>("Spec_mm", value); }
        }

        /// <summary>
        /// 剂量
        /// </summary>
		public FDouble Quan_med {
            get { return getAttrVal<FDouble>("Quan_med",null); }
            set { setAttrVal<FDouble>("Quan_med", value); }
        }
        /// <summary>
        /// 剂量_虚拟（用于界面显示）
        /// </summary>
        public FDouble Quan_medu_virtual
        {
            get { return getAttrVal<FDouble>("Quan_medu_virtual", null); }
            set { setAttrVal<FDouble>("Quan_medu_virtual", value); }
        }
        /// <summary>
        /// 剂量单位
        /// </summary>
		public string Id_unit_med {
            get { return getAttrVal<string>("Id_unit_med",null); }
            set { setAttrVal<string>("Id_unit_med", value); }
        }

        /// <summary>
        /// 剂量单位名称
        /// </summary>
		public string Name_unit_med {
            get { return getAttrVal<string>("Name_unit_med",null); }
            set { setAttrVal<string>("Name_unit_med", value); }
        }
        /// <summary>
        /// 剂量单位名称_虚拟用于界面显示
        /// </summary>
        public string Name_unit_medu_virtual
        {
            get { return getAttrVal<string>("Name_unit_medu_virtual", null); }
            set { setAttrVal<string>("Name_unit_medu_virtual", value); }
        }
        /// <summary>
        /// 单次数量
        /// </summary>
		public FDouble Quan_base {
            get { return getAttrVal<FDouble>("Quan_base",null); }
            set { setAttrVal<FDouble>("Quan_base", value); }
        }

        /// <summary>
        /// 总量
        /// </summary>
		public FDouble Quan_cur {
            get { return getAttrVal<FDouble>("Quan_cur",null); }
            set { setAttrVal<FDouble>("Quan_cur", value); }
        }

        /// <summary>
        /// 零售单位
        /// </summary>
		public string Id_unit_sale {
            get { return getAttrVal<string>("Id_unit_sale",null); }
            set { setAttrVal<string>("Id_unit_sale", value); }
        }

        /// <summary>
        /// 零售单位名称
        /// </summary>
		public string Name_unit_sale {
            get { return getAttrVal<string>("Name_unit_sale",null); }
            set { setAttrVal<string>("Name_unit_sale", value); }
        }

        /// <summary>
        /// 数量单位
        /// </summary>
		public string Id_unit_base {
            get { return getAttrVal<string>("Id_unit_base",null); }
            set { setAttrVal<string>("Id_unit_base", value); }
        }

        /// <summary>
        /// 数量单位名称
        /// </summary>
		public string Name_unit_base {
            get { return getAttrVal<string>("Name_unit_base",null); }
            set { setAttrVal<string>("Name_unit_base", value); }
        }

        /// <summary>
        /// 医保
        /// </summary>
		public string Id_hp {
            get { return getAttrVal<string>("Id_hp",null); }
            set { setAttrVal<string>("Id_hp", value); }
        }

        /// <summary>
        /// 医保类型名称
        /// </summary>
		public string Name_hp {
            get { return getAttrVal<string>("Name_hp",null); }
            set { setAttrVal<string>("Name_hp", value); }
        }

        /// <summary>
        /// 参考价格
        /// </summary>
		public FDouble Price {
            get { return getAttrVal<FDouble>("Price",null); }
            set { setAttrVal<FDouble>("Price", value); }
        }

        /// <summary>
        /// 厂家
        /// </summary>
		public string Vender {
            get { return getAttrVal<string>("Vender",null); }
            set { setAttrVal<string>("Vender", value); }
        }

        /// <summary>
        /// 限制报销条件
        /// </summary>
		public string Limit {
            get { return getAttrVal<string>("Limit",null); }
            set { setAttrVal<string>("Limit", value); }
        }

        /// <summary>
        /// 可用库存
        /// </summary>
		public FDouble Fact_count {
            get { return getAttrVal<FDouble>("Fact_count",null); }
            set { setAttrVal<FDouble>("Fact_count", value); }
        }

        /// <summary>
        /// 描述
        /// </summary>
		public string Des {
            get { return getAttrVal<string>("Des",null); }
            set { setAttrVal<string>("Des", value); }
        }

        /// <summary>
        /// 频次时刻id
        /// </summary>
		public string Id_freqtime {
            get { return getAttrVal<string>("Id_freqtime",null); }
            set { setAttrVal<string>("Id_freqtime", value); }
        }
        /// <summary>
        /// 频次时刻id
        /// </summary>
        public string Sd_frequnitct
        {
            get { return getAttrVal<string>("Sd_frequnitct", null); }
            set { setAttrVal<string>("Sd_frequnitct", value); }
        }
        /// <summary>
        /// 频次时刻
        /// </summary>
		public string Name_freqtime {
            get { return getAttrVal<string>("Name_freqtime",null); }
            set { setAttrVal<string>("Name_freqtime", value); }
        }

        /// <summary>
        /// 排序号
        /// </summary>
		public int? Sortno {
            get { return getAttrVal<int?>("Sortno",null); }
            set { setAttrVal<int?>("Sortno", value); }
        }

        /// <summary>
        /// 版本号
        /// </summary>
		public DateTime? Sv {
            get { return getAttrVal<FDateTime>("Sv",null); }
            set { setAttrVal<FDateTime>("Sv", value); }
        }

        /// <summary>
        /// 当前基本换算系数
        /// </summary>
		public FDouble Factor_cb {
            get { return getAttrVal<FDouble>("Factor_cb",null); }
            set { setAttrVal<FDouble>("Factor_cb", value); }
        }

        /// <summary>
        /// 医学基本换算系数
        /// </summary>
		public FDouble Factor_mb {
            get { return getAttrVal<FDouble>("Factor_mb",null); }
            set { setAttrVal<FDouble>("Factor_mb", value); }
        }

        /// <summary>
        /// 煎法要求id
        /// </summary>
		public string Id_boildes {
            get { return getAttrVal<string>("Id_boildes",null); }
            set { setAttrVal<string>("Id_boildes", value); }
        }

        /// <summary>
        /// 煎法要求
        /// </summary>
		public string Name_boildes {
            get { return getAttrVal<string>("Name_boildes",null); }
            set { setAttrVal<string>("Name_boildes", value); }
        }

        /// <summary>
        /// 药品剂型
        /// </summary>
		public string Id_dosage {
            get { return getAttrVal<string>("Id_dosage",null); }
            set { setAttrVal<string>("Id_dosage", value); }
        }

        /// <summary>
        /// 药品剂型编码
        /// </summary>
		public string Sd_dosage {
            get { return getAttrVal<string>("Sd_dosage",null); }
            set { setAttrVal<string>("Sd_dosage", value); }
        }

        /// <summary>
        /// 药理分类
        /// </summary>
		public string Id_pharm {
            get { return getAttrVal<string>("Id_pharm",null); }
            set { setAttrVal<string>("Id_pharm", value); }
        }

        /// <summary>
        /// 药理分类编码
        /// </summary>
		public string Sd_pharm {
            get { return getAttrVal<string>("Sd_pharm",null); }
            set { setAttrVal<string>("Sd_pharm", value); }
        }

        /// <summary>
        /// 毒麻分类
        /// </summary>
		public string Id_pois {
            get { return getAttrVal<string>("Id_pois",null); }
            set { setAttrVal<string>("Id_pois", value); }
        }

        /// <summary>
        /// 毒麻分类编码
        /// </summary>
		public string Sd_pois {
            get { return getAttrVal<string>("Sd_pois",null); }
            set { setAttrVal<string>("Sd_pois", value); }
        }

        /// <summary>
        /// 抗菌药分类
        /// </summary>
		public string Id_anti {
            get { return getAttrVal<string>("Id_anti",null); }
            set { setAttrVal<string>("Id_anti", value); }
        }

        /// <summary>
        /// 抗菌药分类编码
        /// </summary>
		public string Sd_anti {
            get { return getAttrVal<string>("Sd_anti",null); }
            set { setAttrVal<string>("Sd_anti", value); }
        }

        /// <summary>
        /// 物品类型
        /// </summary>
		public string Id_mmtp {
            get { return getAttrVal<string>("Id_mmtp",null); }
            set { setAttrVal<string>("Id_mmtp", value); }
        }

        /// <summary>
        /// 物品类型编码
        /// </summary>
		public string Sd_mmtp {
            get { return getAttrVal<string>("Sd_mmtp",null); }
            set { setAttrVal<string>("Sd_mmtp", value); }
        }

        /// <summary>
        /// 物品类型名称
        /// </summary>
		public string Name_mmtp {
            get { return getAttrVal<string>("Name_mmtp",null); }
            set { setAttrVal<string>("Name_mmtp", value); }
        }

        /// <summary>
        /// 拼音码
        /// </summary>
		public string Pycode {
            get { return getAttrVal<string>("Pycode",null); }
            set { setAttrVal<string>("Pycode", value); }
        }

        /// <summary>
        /// 选择
        /// </summary>
		public bool? Fg_chk {
            get { return getAttrVal<FBoolean>("Fg_chk",null); }
            set { setAttrVal<FBoolean>("Fg_chk", value); }
        }

        /// <summary>
        /// 频次id
        /// </summary>
		public string Id_freq {
            get { return getAttrVal<string>("Id_freq",null); }
            set { setAttrVal<string>("Id_freq", value); }
        }

        /// <summary>
        /// 频次
        /// </summary>
		public string Name_freq {
            get { return getAttrVal<string>("Name_freq",null); }
            set { setAttrVal<string>("Name_freq", value); }
        }

        /// <summary>
        /// 金额
        /// </summary>
		public FDouble Totalprice {
            get { return getAttrVal<FDouble>("Totalprice",null); }
            set { setAttrVal<FDouble>("Totalprice", value); }
        }

        /// <summary>
        /// 执行科室id
        /// </summary>
		public string Id_mp_dep {
            get { return getAttrVal<string>("Id_mp_dep",null); }
            set { setAttrVal<string>("Id_mp_dep", value); }
        }

        /// <summary>
        /// 执行科室
        /// </summary>
		public string Name_mp_dep {
            get { return getAttrVal<string>("Name_mp_dep",null); }
            set { setAttrVal<string>("Name_mp_dep", value); }
        }

        /// <summary>
        /// 总量单位id
        /// </summary>
		public string Id_pgku_cur {
            get { return getAttrVal<string>("Id_pgku_cur",null); }
            set { setAttrVal<string>("Id_pgku_cur", value); }
        }

        /// <summary>
        /// 总量单位
        /// </summary>
		public string Name_pgku_cur {
            get { return getAttrVal<string>("Name_pgku_cur",null); }
            set { setAttrVal<string>("Name_pgku_cur", value); }
        }

        /// <summary>
        /// 药品编码
        /// </summary>
		public string Code_mm {
            get { return getAttrVal<string>("Code_mm",null); }
            set { setAttrVal<string>("Code_mm", value); }
        }

        /// <summary>
        /// 价值分类id
        /// </summary>
		public string Id_val {
            get { return getAttrVal<string>("Id_val",null); }
            set { setAttrVal<string>("Id_val", value); }
        }

        /// <summary>
        /// 价值分类
        /// </summary>
		public string Sd_val {
            get { return getAttrVal<string>("Sd_val",null); }
            set { setAttrVal<string>("Sd_val", value); }
        }

        /// <summary>
        /// 抗精神分类id
        /// </summary>
		public string Id_antipsy {
            get { return getAttrVal<string>("Id_antipsy",null); }
            set { setAttrVal<string>("Id_antipsy", value); }
        }

        /// <summary>
        /// 抗精神分类
        /// </summary>
		public string Sd_antipsy {
            get { return getAttrVal<string>("Sd_antipsy",null); }
            set { setAttrVal<string>("Sd_antipsy", value); }
        }

        /// <summary>
        /// otc标识
        /// </summary>
		public bool? Fg_otc {
            get { return getAttrVal<FBoolean>("Fg_otc",null); }
            set { setAttrVal<FBoolean>("Fg_otc", value); }
        }



        /// <summary>
        /// 住院取整方式
        /// </summary>
        public string Id_mupkgutp
        {
            get { return getAttrVal<string>("Id_mupkgutp", null); }
            set { setAttrVal<string>("Id_mupkgutp", value); }
        }
        public string Sd_mupkgutp {
            get { return getAttrVal<string>("Sd_mupkgutp",null); }
            set { setAttrVal<string>("Sd_mupkgutp", value); }
        }

        /// <summary>
        /// 门诊取整方式
        /// </summary>
        public string Id_opmutp
        {
            get { return getAttrVal<string>("Id_opmutp", null); }
            set { setAttrVal<string>("Id_opmutp", value); }
        }
        public string Sd_opmutp
        {
            get { return getAttrVal<string>("Sd_opmutp", null); }
            set { setAttrVal<string>("Sd_opmutp", value); }
        }

        /// <summary>
        /// 计量单位id集合
        /// </summary>
		public string Str_unit_pkg_ids {
            get { return getAttrVal<string>("Str_unit_pkg_ids",null); }
            set { setAttrVal<string>("Str_unit_pkg_ids", value); }
        }

        /// <summary>
        /// 物品标志
        /// </summary>
		public bool? Fg_mm {
            get { return getAttrVal<FBoolean>("Fg_mm",null); }
            set { setAttrVal<FBoolean>("Fg_mm", value); }
        }

        /// <summary>
        /// 服务类型
        /// </summary>
		public string Sd_srvtp {
            get { return getAttrVal<string>("Sd_srvtp",null); }
            set { setAttrVal<string>("Sd_srvtp", value); }
        }

        /// <summary>
        /// 服务编码
        /// </summary>
		public string Code_srv {
            get { return getAttrVal<string>("Code_srv",null); }
            set { setAttrVal<string>("Code_srv", value); }
        }

        /// <summary>
        /// 服务类型id
        /// </summary>
		public string Id_srvtp {
            get { return getAttrVal<string>("Id_srvtp",null); }
            set { setAttrVal<string>("Id_srvtp", value); }
        }

        /// <summary>
        /// 服务项目分类
        /// </summary>
		public string Id_srvca {
            get { return getAttrVal<string>("Id_srvca",null); }
            set { setAttrVal<string>("Id_srvca", value); }
        }

        /// <summary>
        /// 物品绑定_住院
        /// </summary>
		public string Sd_mmbind_ip {
            get { return getAttrVal<string>("Sd_mmbind_ip",null); }
            set { setAttrVal<string>("Sd_mmbind_ip", value); }
        }
        /// <summary>
        /// 物品绑定_门诊
        /// </summary>
        public string Sd_mmbind_op
        {
            get { return getAttrVal<string>("Sd_mmbind_op", null); }
            set { setAttrVal<string>("Sd_mmbind_op", value); }
        }

        /// <summary>
        /// 物品绑定_急诊
        /// </summary>
        public string Sd_mmbind_er
        {
            get { return getAttrVal<string>("Sd_mmbind_er", null); }
            set { setAttrVal<string>("Sd_mmbind_er", value); }
        }

        /// <summary>
        /// 定价模式
        /// </summary>
		public string Id_pri {
            get { return getAttrVal<string>("Id_pri",null); }
            set { setAttrVal<string>("Id_pri", value); }
        }

        /// <summary>
        /// 限制
        /// </summary>
		public string Hpdes {
            get { return getAttrVal<string>("Hpdes",null); }
            set { setAttrVal<string>("Hpdes", value); }
        }

        /// <summary>
        /// 医嘱物品
        /// </summary>
		public string Id_srvmm {
            get { return getAttrVal<string>("Id_srvmm",null); }
            set { setAttrVal<string>("Id_srvmm", value); }
        }

        /// <summary>
        /// 是否自备药
        /// </summary>
		public bool? Fg_self {
            get { return getAttrVal<FBoolean>("Fg_self",null); }
            set { setAttrVal<FBoolean>("Fg_self", value); }
        }

        /// <summary>
        /// 预防和治疗
        /// </summary>
		public bool? Fg_propc {
            get { return getAttrVal<FBoolean>("Fg_propc",null); }
            set { setAttrVal<FBoolean>("Fg_propc", value); }
        }

        /// <summary>
        /// 适应和非适应
        /// </summary>
		public bool? Fg_treat {
            get { return getAttrVal<FBoolean>("Fg_treat",null); }
            set { setAttrVal<FBoolean>("Fg_treat", value); }
        }

        /// <summary>
        /// 备注
        /// </summary>
		public string Note_or {
            get { return getAttrVal<string>("Note_or",null); }
            set { setAttrVal<string>("Note_or", value); }
        }

        /// <summary>
        /// 扩展说明
        /// </summary>
		public string Note_ext {
            get { return getAttrVal<string>("Note_ext",null); }
            set { setAttrVal<string>("Note_ext", value); }
        }

        /// <summary>
        /// 用法
        /// </summary>
		public string Id_route {
            get { return getAttrVal<string>("Id_route",null); }
            set { setAttrVal<string>("Id_route", value); }
        }

        /// <summary>
        /// 用法名称
        /// </summary>
		public string Name_route {
            get { return getAttrVal<string>("Name_route",null); }
            set { setAttrVal<string>("Name_route", value); }
        }

        /// <summary>
        /// 处置周期
        /// </summary>
        public int? Use_days
        {
            get { return getAttrVal<int?>("Use_days",null); }
            set { setAttrVal<int?>("Use_days", value); }
        }

        /// <summary>
        /// 加急
        /// </summary>
		public bool? Fg_urgent {
            get { return getAttrVal<FBoolean>("Fg_urgent",null); }
            set { setAttrVal<FBoolean>("Fg_urgent", value); }
        }

        /// <summary>
        /// 变动用药标识
        /// </summary>
		public bool? Fg_dose_anoma {
            get { return getAttrVal<FBoolean>("Fg_dose_anoma",null); }
            set { setAttrVal<FBoolean>("Fg_dose_anoma", value); }
        }

        /// <summary>
        /// 费用标识
        /// </summary>
		public bool? Fg_bl {
            get { return getAttrVal<FBoolean>("Fg_bl",null); }
            set { setAttrVal<FBoolean>("Fg_bl", value); }
        }

        /// <summary>
        /// 皮试标识
        /// </summary>
		public bool? Fg_skintest {
            get { return getAttrVal<FBoolean>("Fg_skintest",null); }
            set { setAttrVal<FBoolean>("Fg_skintest", value); }
        }

        /// <summary>
        /// 不皮试原因
        /// </summary>
		public string Id_skintest_skip_reason {
            get { return getAttrVal<string>("Id_skintest_skip_reason",null); }
            set { setAttrVal<string>("Id_skintest_skip_reason", value); }
        }

        /// <summary>
        /// 不皮试原因编码
        /// </summary>
		public string Sd_skintest_skip_reason {
            get { return getAttrVal<string>("Sd_skintest_skip_reason",null); }
            set { setAttrVal<string>("Sd_skintest_skip_reason", value); }
        }

        /// <summary>
        /// 关联类型
        /// </summary>
		public string Id_reltp {
            get { return getAttrVal<string>("Id_reltp",null); }
            set { setAttrVal<string>("Id_reltp", value); }
        }

        /// <summary>
        /// 关联类型编码
        /// </summary>
		public string Sd_reltp {
            get { return getAttrVal<string>("Sd_reltp",null); }
            set { setAttrVal<string>("Sd_reltp", value); }
        }

        /// <summary>
        /// 对应关联医嘱id_or
        /// </summary>
		public string Id_or_rel {
            get { return getAttrVal<string>("Id_or_rel",null); }
            set { setAttrVal<string>("Id_or_rel", value); }
        }

        /// <summary>
        /// 皮试服务id
        /// </summary>
		public string Id_srvskin {
            get { return getAttrVal<string>("Id_srvskin",null); }
            set { setAttrVal<string>("Id_srvskin", value); }
        }


        /// <summary>
        /// 频次数量
        /// </summary>
		public int? Freqct {
            get { return getAttrVal<int?>("Freqct",null); }
            set { setAttrVal<int?>("Freqct", value); }
        }

        /// <summary>
        /// 自定义服务名称标志
        /// </summary>
		public bool? Fg_ctm {
            get { return getAttrVal<FBoolean>("Fg_ctm",null); }
            set { setAttrVal<FBoolean>("Fg_ctm", value); }
        }

        /// <summary>
        /// 自费
        /// </summary>
		public bool? Fg_selfpay {
            get { return getAttrVal<FBoolean>("Fg_selfpay",null); }
            set { setAttrVal<FBoolean>("Fg_selfpay", value); }
        }

        /// <summary>
        /// 自定义服务
        /// </summary>
		public bool? Fg_selfsrv
        {
            get { return getAttrVal<FBoolean>("Fg_selfsrv", null); }
            set { setAttrVal<FBoolean>("Fg_selfsrv", value); }
        }

        /// <summary>
        /// 医保类型
        /// </summary>
		public string Id_hpsrvtp {
            get { return getAttrVal<string>("Id_hpsrvtp",null); }
            set { setAttrVal<string>("Id_hpsrvtp", value); }
        }

        /// <summary>
        /// 医保类型编码
        /// </summary>
		public string Sd_hpsrvtp {
            get { return getAttrVal<string>("Sd_hpsrvtp",null); }
            set { setAttrVal<string>("Sd_hpsrvtp", value); }
        }

        /// <summary>
        /// 通用医保计划目录类型
        /// </summary>
		public string Name_hpsrvtp {
            get { return getAttrVal<string>("Name_hpsrvtp",null); }
            set { setAttrVal<string>("Name_hpsrvtp", value); }
        }

        /// <summary>
        /// 医保名称
        /// </summary>
		public string Name_heath {
            get { return getAttrVal<string>("Name_heath",null); }
            set { setAttrVal<string>("Name_heath", value); }
        }

        /// <summary>
        /// 库房
        /// </summary>
		public string Id_dep_wh {
            get { return getAttrVal<string>("Id_dep_wh",null); }
            set { setAttrVal<string>("Id_dep_wh", value); }
        }

        /// <summary>
        /// 代办人信息
        /// </summary>
		public FArrayList Agentinfolist {
            get { return getAttrVal<FArrayList>("Agentinfolist",null); }
            set { setAttrVal<FArrayList>("Agentinfolist", value); }
        }

        /// <summary>
        /// 医疗单来源
        /// </summary>
		public int? Eu_sourcemd {
            get { return getAttrVal<int?>("Eu_sourcemd",null); }
            set { setAttrVal<int?>("Eu_sourcemd", value); }
        }

        /// <summary>
        /// 临床标识
        /// </summary>
		public bool? Fg_or {
            get { return getAttrVal<FBoolean>("Fg_or",null); }
            set { setAttrVal<FBoolean>("Fg_or", value); }
        }

        /// <summary>
        /// 要求
        /// </summary>
		public string Id_routedes {
            get { return getAttrVal<string>("Id_routedes",null); }
            set { setAttrVal<string>("Id_routedes", value); }
        }

        /// <summary>
        /// 要求名称
        /// </summary>
		public string Name_routedes {
            get { return getAttrVal<string>("Name_routedes",null); }
            set { setAttrVal<string>("Name_routedes", value); }
        }

        /// <summary>
        /// 煎法
        /// </summary>
		public string Id_boil {
            get { return getAttrVal<string>("Id_boil",null); }
            set { setAttrVal<string>("Id_boil", value); }
        }

        /// <summary>
        /// 煎法名称
        /// </summary>
		public string Name_boil {
            get { return getAttrVal<string>("Name_boil",null); }
            set { setAttrVal<string>("Name_boil", value); }
        }

        /// <summary>
        /// 服务分类内码
        /// </summary>
		public string Innercode_srvca {
            get { return getAttrVal<string>("Innercode_srvca",null); }
            set { setAttrVal<string>("Innercode_srvca", value); }
        }

        /// <summary>
        /// 划价方式
        /// </summary>
		public int? Eu_blmd {
            get { return getAttrVal<int?>("Eu_blmd",null); }
            set { setAttrVal<int?>("Eu_blmd", value); }
        }

        /// <summary>
        /// 所属服务来源
        /// </summary>
		public string Id_srv_src {
            get { return getAttrVal<string>("Id_srv_src",null); }
            set { setAttrVal<string>("Id_srv_src", value); }
        }

        /// <summary>
        /// 计价状态
        /// </summary>
		public string Priby {
            get { return getAttrVal<string>("Priby",null); }
            set { setAttrVal<string>("Priby", value); }
        }

        /// <summary>
        /// 所有关联字段集合
        /// </summary>
		public FMap Relativefieldmap {
            get { return getAttrVal<FMap>("Relativefieldmap",null); }
            set { setAttrVal<FMap>("Relativefieldmap", value); }
        }

        /// <summary>
        /// 毒麻标志
        /// </summary>
		public bool? Fg_pois {
            get { return getAttrVal<FBoolean>("Fg_pois",null); }
            set { setAttrVal<FBoolean>("Fg_pois", value); }
        }

        /// <summary>
        /// 抗菌药标志
        /// </summary>
		public bool? Fg_anti {
            get { return getAttrVal<FBoolean>("Fg_anti",null); }
            set { setAttrVal<FBoolean>("Fg_anti", value); }
        }

        /// <summary>
        /// 
        /// 医保信息
        /// </summary>
        public FArrayList BdHpIndicationDTO
        {
            get { return getAttrVal<FArrayList>("BdHpIndicationDTO", null); }
            set { setAttrVal<FArrayList>("BdHpIndicationDTO", value); }
        }
        /// <summary>
        /// 执行科室id集合
        /// </summary>
        public string Str_mp_dep_ids
        {
            get { return getAttrVal<string>("Str_mp_dep_ids", null); }
            set { setAttrVal<string>("Str_mp_dep_ids", value); }
        }
        /// <summary>
        /// 库房科室id集合
        /// </summary>
        public string Str_wh_dep_ids
        {
            get { return getAttrVal<string>("Str_wh_dep_ids", null); }
            set { setAttrVal<string>("Str_wh_dep_ids", value); }
        }
        /// <summary>
        /// 药房名称集合
        /// </summary>
        public string Name_dep_wh
        {
            get { return getAttrVal<string>("Name_dep_wh", null); }
            set { setAttrVal<string>("Name_dep_wh", value); }
        }

        /// <summary>
        /// 药品库存状态
        /// </summary>
        public int? Mmstatus
        {
            get { return getAttrVal<int?>("Mmstatus", null); }
            set { setAttrVal<int?>("Mmstatus", value); }
        }
        /// <summary>
        /// 诊断id
        /// </summary>
        public string Id_di
        {
            get { return getAttrVal<string>("Id_di", null); }
            set { setAttrVal<string>("Id_di", value); }
        }

        /// <summary>
        /// 诊断子id
        /// </summary>
        public string Id_diitm
        {
            get { return getAttrVal<string>("Id_diitm", null); }
            set { setAttrVal<string>("Id_diitm", value); }
        }

        /// <summary>
        /// 诊断名称
        /// </summary>
        public string Name_diag
        {
            get { return getAttrVal<string>("Name_diag", null); }
            set { setAttrVal<string>("Name_diag", value); }
        }

        /// <summary>
        /// 计划检查日期
        /// </summary>
        public DateTime? Dt_plan
        {
            get { return getAttrVal<FDateTime>("Dt_plan", null); }
            set { setAttrVal<FDateTime>("Dt_plan", value); }
        }
        /// <summary>
        /// 申请单号
        /// </summary>
        public string No_applyform
        {
            get { return getAttrVal<string>("No_applyform", null); }
            set { setAttrVal<string>("No_applyform", value); }
        }

       /// <summary>
       /// 变动用药信息
       /// </summary>
        public FArrayList OrDoseDrugList
        {
            get { return getAttrVal<FArrayList>("OrDoseDrugList", null); }
            set { setAttrVal<FArrayList>("OrDoseDrugList", value); }
        }

        /// <summary>
        /// 外配药标识
        /// </summary>
        public bool? Fg_extdispense
        {
            get { return getAttrVal<FBoolean>("Fg_extdispense", null); }
            set { setAttrVal<FBoolean>("Fg_extdispense", value); }
        }
        /// <summary>
        /// 医保服务计划编码
        /// </summary>
        public string Code_hpsrvorca
        {
            get { return getAttrVal<string>("Code_hpsrvorca", null); }
            set { setAttrVal<string>("Code_hpsrvorca", value); }
        }
        /// <summary>
        /// 医保适应症医生界面判断
        /// </summary>
        public int? Fg_hpindicjudged
        {
            get { return getAttrVal<int?>("Fg_hpindicjudged", 0); }
            set { setAttrVal<int?>("Fg_hpindicjudged", value); }
        }
        /// <summary>
        /// 标本类型id
        /// </summary>
        public string Id_samptp
        {
            get { return getAttrVal<string>("Id_samptp", null); }
            set { setAttrVal<string>("Id_samptp", value); }
        }

        /// <summary>
        /// 标本类型名称
        /// </summary>
        public string Name_samptp
        {
            get { return getAttrVal<string>("Name_samptp", null); }
            set { setAttrVal<string>("Name_samptp", value); }
        }

        /// <summary>
        /// 标本类型编码
        /// </summary>
        public string Sd_samptp
        {
            get { return getAttrVal<string>("Sd_samptp", null); }
            set { setAttrVal<string>("Sd_samptp", value); }
        }

        /// <summary>
        /// 标本采集时间
        /// </summary>
        public string Id_sampcoltime
        {
            get { return getAttrVal<string>("Id_sampcoltime", null); }
            set { setAttrVal<string>("Id_sampcoltime", value); }
        }

        /// <summary>
        /// 标本采集时间名称
        /// </summary>
        public string Name_sampcoltime
        {
            get { return getAttrVal<string>("Name_sampcoltime", null); }
            set { setAttrVal<string>("Name_sampcoltime", value); }
        }

        /// <summary>
        /// 标本采集时间类型采集时间类型
        /// </summary>
        public string Id_sampcollecttimetp
        {
            get { return getAttrVal<string>("Id_sampcollecttimetp", null); }
            set { setAttrVal<string>("Id_sampcollecttimetp", value); }
        }

        /// <summary>
        /// 采集时间编码
        /// </summary>
        public string Sd_sampcollecttimetp
        {
            get { return getAttrVal<string>("Sd_sampcollecttimetp", null); }
            set { setAttrVal<string>("Sd_sampcollecttimetp", value); }
        }

        /// <summary>
        /// 标本采集时长
        /// </summary>
        public FDouble Len_sampcoltime
        {
            get { return getAttrVal<FDouble>("Len_sampcoltime", null); }
            set { setAttrVal<FDouble>("Len_sampcoltime", value); }
        }

        /// <summary>
        /// 时长单位
        /// </summary>
        public string Id_unit_sampcoltime
        {
            get { return getAttrVal<string>("Id_unit_sampcoltime", null); }
            set { setAttrVal<string>("Id_unit_sampcoltime", value); }
        }

        /// <summary>
        /// 检查目的
        /// </summary>
        public string Id_pps
        {
            get { return getAttrVal<string>("Id_pps", null); }
            set { setAttrVal<string>("Id_pps", value); }
        }

        /// <summary>
        /// 检查目的编码
        /// </summary>
        public string Sd_pps
        {
            get { return getAttrVal<string>("Sd_pps", null); }
            set { setAttrVal<string>("Sd_pps", value); }
        }
        /// <summary>
        /// 检查目的名称
        /// </summary>
        public string Name_pps
        {
            get { return getAttrVal<string>("Name_pps", null); }
            set { setAttrVal<string>("Name_pps", value); }
        }
        /// <summary>
        /// 服务套单选限制标识
        /// </summary>
        public bool? Fg_setradio
        {
            get { return getAttrVal<FBoolean>("Fg_setradio", null); }
            set { setAttrVal<FBoolean>("Fg_setradio", value); }
        }
        /// <summary>
        /// 长临标识
        /// </summary>
        public bool? Fg_long
        {
            get { return getAttrVal<FBoolean>("Fg_long", null); }
            set { setAttrVal<FBoolean>("Fg_long", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[] { "Id_emsordrug", "Id_srv", "Id_orsrv", "Name_srv", "Id_mm", "Name_mm", "Spec_mm", "Quan_med", "Id_unit_med", "Name_unit_med", "Quan_base", "Quan_cur", "Id_unit_sale", "Name_unit_sale", "Id_unit_base", "Name_unit_base", "Id_hp", "Name_hp", "Price", "Vender", "Limit", "Fact_count", "Des", "Id_freqtime", "Name_freqtime", "Sortno", "Sv", "Factor_cb", "Factor_mb", "Id_boildes", "Name_boildes", "Id_dosage", "Sd_dosage", "Id_pharm", "Sd_pharm", "Id_pois", "Sd_pois", "Id_anti", "Sd_anti", "Id_mmtp", "Sd_mmtp", "Name_mmtp", "Pycode", "Fg_chk", "Id_freq", "Name_freq", "Totalprice", "Id_mp_dep", "Name_mp_dep", "Id_pgku_cur", "Name_pgku_cur", "Code_mm", "Id_val", "Sd_val", "Id_antipsy", "Sd_antipsy", "Fg_otc", "Sd_mupkgutp", "Str_unit_pkg_ids", "Fg_mm", "Sd_srvtp", "Code_srv", "Id_srvtp", "Id_srvca", "Sd_mmbind_ip", "Id_pri", "Hpdes", "Id_srvmm", "Fg_self", "Fg_propc", "Fg_treat", "Note_or", "Note_ext", "Id_route", "Name_route", "Use_days", "Fg_urgent", "Fg_dose_anoma", "Fg_bl", "Fg_skintest", "Id_skintest_skip_reason", "Sd_skintest_skip_reason", "Id_reltp", "Sd_reltp", "Id_or_rel", "Id_srvskin", "Freqct", "Fg_ctm", "Fg_selfpay", "Id_hpsrvtp", "Sd_hpsrvtp", "Name_hpsrvtp", "Name_heath", "Id_dep_wh", "Agentinfolist", "Eu_sourcemd", "Fg_or", "Id_routedes", "Name_routedes", "Id_boil", "Name_boil", "Innercode_srvca", "Eu_blmd", "Id_srv_src", "Priby", "Relativefieldmap", "Fg_pois", "Fg_anti", "Str_mp_dep_ids", "Str_wh_dep_ids", "Mmstatus", "Id_di", "Id_diitm", "Name_diag", "Dt_plan", "No_applyform", "Sd_mmbind_op", "Sd_mmbind_er", "Fg_extdispense", "Quan_medu_virtual", "Name_unit_medu_virtual", "Sd_frequnitct", "Code_hpsrvorca", "Fg_hpindicjudged", "Id_samptp", "Name_samptp", "Sd_samptp", "Id_sampcoltime", "Name_sampcoltime", "Id_sampcollecttimetp", "Sd_sampcollecttimetp", "Len_sampcoltime", "Id_unit_sampcoltime", "Id_pps", "Sd_pps", "Name_pps", "Fg_setradio","Fg_long" };
        }
        //0 未处理，1已经处理
        public int? Eu_hpdoctorjudge11
        {
            get { return getAttrVal<int?>("Eu_hpdoctorjudge", null); }
            set { setAttrVal<int?>("Eu_hpdoctorjudge", value); }
        }
        //医保校验信息
        public FArrayList BdHpIndication
        {
            get { return getAttrVal<FArrayList>("BdHpIndication", null); }
            set { setAttrVal<FArrayList>("BdHpIndication", value); }
        }
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.ciordems.d.EmsOrDrug";
        }
    }
}
