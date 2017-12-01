using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.ems.d
{
    /// <summary>
    /// CiEmsSrvDTO 的摘要说明。
    /// </summary>
    public class CiEmsSrvDTO : BaseDTO {

        public CiEmsSrvDTO() {
 
        }
        //医保校验信息
        public FArrayList BdHpIndication
        {
            get { return getAttrVal<FArrayList>("BdHpIndication", null); }
            set { setAttrVal<FArrayList>("BdHpIndication", value); }
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
        /// 医疗单项目主键标识
        /// </summary>
		public string Id_orsrv {
            get { return getAttrVal<string>("Id_orsrv",null); }
            set { setAttrVal<string>("Id_orsrv", value); }
        }

        /// <summary>
        /// 医疗单
        /// </summary>
		public string Id_or {
            get { return getAttrVal<string>("Id_or",null); }
            set { setAttrVal<string>("Id_or", value); }
        }

        /// <summary>
        /// 序号
        /// </summary>
		public int? Sortno {
            get { return getAttrVal<int?>("Sortno",null); }
            set { setAttrVal<int?>("Sortno", value); }
        }

        /// <summary>
        /// 医疗服务
        /// </summary>
		public string Id_srv {
            get { return getAttrVal<string>("Id_srv",null); }
            set { setAttrVal<string>("Id_srv", value); }
        }

        /// <summary>
        /// 所属服务套
        /// </summary>
		public string Id_srv_set {
            get { return getAttrVal<string>("Id_srv_set",null); }
            set { setAttrVal<string>("Id_srv_set", value); }
        }

        /// <summary>
        /// 服务类型
        /// </summary>
		public string Id_srvtp {
            get { return getAttrVal<string>("Id_srvtp",null); }
            set { setAttrVal<string>("Id_srvtp", value); }
        }

        /// <summary>
        /// 服务类型编码
        /// </summary>
		public string Sd_srvtp {
            get { return getAttrVal<string>("Sd_srvtp",null); }
            set { setAttrVal<string>("Sd_srvtp", value); }
        }

        /// <summary>
        /// 医疗服务编码
        /// </summary>
		public string Code_srv {
            get { return getAttrVal<string>("Code_srv",null); }
            set { setAttrVal<string>("Code_srv", value); }
        }

        /// <summary>
        /// 医疗服务名称
        /// </summary>
		public string Name_srv {
            get { return getAttrVal<string>("Name_srv",null); }
            set { setAttrVal<string>("Name_srv", value); }
        }

        /// <summary>
        /// 服务项目基本分类
        /// </summary>
		public string Id_srvca {
            get { return getAttrVal<string>("Id_srvca",null); }
            set { setAttrVal<string>("Id_srvca", value); }
        }

        /// <summary>
        /// 医疗单位
        /// </summary>
		public string Id_unit_med {
            get { return getAttrVal<string>("Id_unit_med",null); }
            set { setAttrVal<string>("Id_unit_med", value); }
        }

        /// <summary>
        /// 医疗单位编码
        /// </summary>
		public string Name_unit_med {
            get { return getAttrVal<string>("Name_unit_med",null); }
            set { setAttrVal<string>("Name_unit_med", value); }
        }

        /// <summary>
        /// 剂量
        /// </summary>
		public double? Quan_med {
            get { return getAttrVal<FDouble>("Quan_med",null); }
            set { setAttrVal<FDouble>("Quan_med", value); }
        }

        /// <summary>
        /// 参考价格
        /// </summary>
		public double? Price {
            get { return getAttrVal<FDouble>("Price",null); }
            set { setAttrVal<FDouble>("Price", value); }
        }

        /// <summary>
        /// 医嘱频次
        /// </summary>
		public string Id_freq {
            get { return getAttrVal<string>("Id_freq",null); }
            set { setAttrVal<string>("Id_freq", value); }
        }

        /// <summary>
        /// 医嘱频次名称
        /// </summary>
		public string Name_freq {
            get { return getAttrVal<string>("Name_freq",null); }
            set { setAttrVal<string>("Name_freq", value); }
        }

        /// <summary>
        /// 用法标识
        /// </summary>
		public string Id_route {
            get { return getAttrVal<string>("Id_route",null); }
            set { setAttrVal<string>("Id_route", value); }
        }

        /// <summary>
        /// 用法
        /// </summary>
		public string Name_route {
            get { return getAttrVal<string>("Name_route",null); }
            set { setAttrVal<string>("Name_route", value); }
        }

        /// <summary>
        /// 用法要求标识
        /// </summary>
		public string Id_routedes {
            get { return getAttrVal<string>("Id_routedes",null); }
            set { setAttrVal<string>("Id_routedes", value); }
        }

        /// <summary>
        /// 用法要求
        /// </summary>
		public string Name_routedes {
            get { return getAttrVal<string>("Name_routedes",null); }
            set { setAttrVal<string>("Name_routedes", value); }
        }

        /// <summary>
        /// 煎法标识
        /// </summary>
		public string Id_boil {
            get { return getAttrVal<string>("Id_boil",null); }
            set { setAttrVal<string>("Id_boil", value); }
        }

        /// <summary>
        /// 煎法
        /// </summary>
		public string Name_boil {
            get { return getAttrVal<string>("Name_boil",null); }
            set { setAttrVal<string>("Name_boil", value); }
        }

        /// <summary>
        /// 煎法要求标识
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
        /// 变动用药标识
        /// </summary>
		public bool? Fg_dose_anoma {
            get { return getAttrVal<FBoolean>("Fg_dose_anoma",null); }
            set { setAttrVal<FBoolean>("Fg_dose_anoma", value); }
        }

        /// <summary>
        /// 备注
        /// </summary>
		public string Des_srv {
            get { return getAttrVal<string>("Des_srv",null); }
            set { setAttrVal<string>("Des_srv", value); }
        }

        /// <summary>
        /// 物品标识
        /// </summary>
		public bool? Fg_mm {
            get { return getAttrVal<FBoolean>("Fg_mm",null); }
            set { setAttrVal<FBoolean>("Fg_mm", value); }
        }

        /// <summary>
        /// 服务套标识
        /// </summary>
		public bool? Fg_set {
            get { return getAttrVal<FBoolean>("Fg_set",null); }
            set { setAttrVal<FBoolean>("Fg_set", value); }
        }

        /// <summary>
        /// 医嘱标识
        /// </summary>
		public bool? Fg_or {
            get { return getAttrVal<FBoolean>("Fg_or",null); }
            set { setAttrVal<FBoolean>("Fg_or", value); }
        }

        /// <summary>
        /// 费用标识
        /// </summary>
		public bool? Fg_bl {
            get { return getAttrVal<FBoolean>("Fg_bl",null); }
            set { setAttrVal<FBoolean>("Fg_bl", value); }
        }

        /// <summary>
        /// 自备药标识
        /// </summary>
		public bool? Fg_self {
            get { return getAttrVal<FBoolean>("Fg_self",null); }
            set { setAttrVal<FBoolean>("Fg_self", value); }
        }

        /// <summary>
        /// 出院带药标识（废弃不用了）
        /// </summary>
		public bool? Fg_outp {
            get { return getAttrVal<FBoolean>("Fg_outp",null); }
            set { setAttrVal<FBoolean>("Fg_outp", value); }
        }

        /// <summary>
        /// 预防用药标识
        /// </summary>
		public bool? Fg_propc {
            get { return getAttrVal<FBoolean>("Fg_propc",null); }
            set { setAttrVal<FBoolean>("Fg_propc", value); }
        }

        /// <summary>
        /// 治疗用药标识
        /// </summary>
		public bool? Fg_treat {
            get { return getAttrVal<FBoolean>("Fg_treat",null); }
            set { setAttrVal<FBoolean>("Fg_treat", value); }
        }

        /// <summary>
        /// 开立机构
        /// </summary>
		public string Id_org_srv {
            get { return getAttrVal<string>("Id_org_srv",null); }
            set { setAttrVal<string>("Id_org_srv", value); }
        }

        /// <summary>
        /// 开立科室
        /// </summary>
		public string Id_dep_srv {
            get { return getAttrVal<string>("Id_dep_srv",null); }
            set { setAttrVal<string>("Id_dep_srv", value); }
        }

        /// <summary>
        /// 开立病区
        /// </summary>
		public string Id_ward_srv {
            get { return getAttrVal<string>("Id_ward_srv",null); }
            set { setAttrVal<string>("Id_ward_srv", value); }
        }

        /// <summary>
        /// 开立人员
        /// </summary>
		public string Id_emp_srv {
            get { return getAttrVal<string>("Id_emp_srv",null); }
            set { setAttrVal<string>("Id_emp_srv", value); }
        }

        /// <summary>
        /// 开立时间
        /// </summary>
		public DateTime? Dt_create_srv {
            get { return getAttrVal<FDateTime>("Dt_create_srv",null); }
            set { setAttrVal<FDateTime>("Dt_create_srv", value); }
        }

        /// <summary>
        /// 执行科室
        /// </summary>
		public string Id_dep {
            get { return getAttrVal<string>("Id_dep",null); }
            set { setAttrVal<string>("Id_dep", value); }
        }

        /// <summary>
        /// 执行科室名称
        /// </summary>
		public string Name_dep {
            get { return getAttrVal<string>("Name_dep",null); }
            set { setAttrVal<string>("Name_dep", value); }
        }

        /// <summary>
        /// 最近生成日期
        /// </summary>
		public DateTime? Dt_last_bl {
            get { return getAttrVal<FDateTime>("Dt_last_bl",null); }
            set { setAttrVal<FDateTime>("Dt_last_bl", value); }
        }

        /// <summary>
        /// 划价方式
        /// </summary>
		public int? Eu_blmd {
            get { return getAttrVal<int?>("Eu_blmd",null); }
            set { setAttrVal<int?>("Eu_blmd", value); }
        }

        /// <summary>
        /// 服务项目物品
        /// </summary>
		public string Id_orsrvmm {
            get { return getAttrVal<string>("Id_orsrvmm",null); }
            set { setAttrVal<string>("Id_orsrvmm", value); }
        }

        /// <summary>
        /// 物品
        /// </summary>
		public string Id_mm {
            get { return getAttrVal<string>("Id_mm",null); }
            set { setAttrVal<string>("Id_mm", value); }
        }

        /// <summary>
        /// 物品编码
        /// </summary>
		public string Code_mm {
            get { return getAttrVal<string>("Code_mm",null); }
            set { setAttrVal<string>("Code_mm", value); }
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
        /// 基本单位
        /// </summary>
		public string Id_unit_base {
            get { return getAttrVal<string>("Id_unit_base",null); }
            set { setAttrVal<string>("Id_unit_base", value); }
        }

        /// <summary>
        /// 基本单位名称
        /// </summary>
		public string Name_unit_base {
            get { return getAttrVal<string>("Name_unit_base",null); }
            set { setAttrVal<string>("Name_unit_base", value); }
        }

        /// <summary>
        /// 单次数量_分子
        /// </summary>
		public int? Quan_num_base {
            get { return getAttrVal<int?>("Quan_num_base",null); }
            set { setAttrVal<int?>("Quan_num_base", value); }
        }

        /// <summary>
        /// 单次数量_分母
        /// </summary>
		public int? Quan_den_base {
            get { return getAttrVal<int?>("Quan_den_base",null); }
            set { setAttrVal<int?>("Quan_den_base", value); }
        }

        /// <summary>
        /// 参考价当前
        /// </summary>
		public double? Price_cur {
            get { return getAttrVal<FDouble>("Price_cur",null); }
            set { setAttrVal<FDouble>("Price_cur", value); }
        }

        /// <summary>
        /// 总量_当前
        /// </summary>
		public double? Quan_cur {
            get { return getAttrVal<FDouble>("Quan_cur",null); }
            set { setAttrVal<FDouble>("Quan_cur", value); }
        }

        /// <summary>
        /// 总量_基本
        /// </summary>
		public double? Quan_base {
            get { return getAttrVal<FDouble>("Quan_base",null); }
            set { setAttrVal<FDouble>("Quan_base", value); }
        }

        /// <summary>
        /// 床边量_医学
        /// </summary>
		public double? Quan_bed_medu {
            get { return getAttrVal<FDouble>("Quan_bed_medu",null); }
            set { setAttrVal<FDouble>("Quan_bed_medu", value); }
        }

        /// <summary>
        /// 当前基本换算系数
        /// </summary>
		public double? Factor_cb {
            get { return getAttrVal<FDouble>("Factor_cb",null); }
            set { setAttrVal<FDouble>("Factor_cb", value); }
        }

        /// <summary>
        /// 医疗基本换算系数
        /// </summary>
		public double? Factor_mb {
            get { return getAttrVal<FDouble>("Factor_mb",null); }
            set { setAttrVal<FDouble>("Factor_mb", value); }
        }
        public string Id_mupkgutp
        {
            get { return getAttrVal<string>("Id_mupkgutp", null); }
            set { setAttrVal<string>("Id_mupkgutp", value); }
        }
        public string Sd_mupkgutp
        {
            get { return getAttrVal<string>("Sd_mupkgutp", null); }
            set { setAttrVal<string>("Sd_mupkgutp", value); }
        }
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
        /// 价值分类
        /// </summary>
		public string Id_val {
            get { return getAttrVal<string>("Id_val",null); }
            set { setAttrVal<string>("Id_val", value); }
        }

        /// <summary>
        /// 价值分类编码
        /// </summary>
		public string Sd_val {
            get { return getAttrVal<string>("Sd_val",null); }
            set { setAttrVal<string>("Sd_val", value); }
        }

        /// <summary>
        /// 适应症
        /// </summary>
		public string Indica {
            get { return getAttrVal<string>("Indica",null); }
            set { setAttrVal<string>("Indica", value); }
        }

        /// <summary>
        /// 禁忌症
        /// </summary>
		public string Constr {
            get { return getAttrVal<string>("Constr",null); }
            set { setAttrVal<string>("Constr", value); }
        }

        /// <summary>
        /// 不良反应
        /// </summary>
		public string React {
            get { return getAttrVal<string>("React",null); }
            set { setAttrVal<string>("React", value); }
        }

        /// <summary>
        /// 主要作用
        /// </summary>
		public string Guide {
            get { return getAttrVal<string>("Guide",null); }
            set { setAttrVal<string>("Guide", value); }
        }

        /// <summary>
        /// OTC标识
        /// </summary>
		public bool? Fg_otc {
            get { return getAttrVal<FBoolean>("Fg_otc",null); }
            set { setAttrVal<FBoolean>("Fg_otc", value); }
        }

        /// <summary>
        /// 变动用药安排
        /// </summary>
		public FArrayList Emsfreqdose {
            get { return getAttrVal<FArrayList>("Emsfreqdose",null); }
            set { setAttrVal<FArrayList>("Emsfreqdose", value); }
        }

        /// <summary>
        /// 部位
        /// </summary>
		public string Id_body {
            get { return getAttrVal<string>("Id_body",null); }
            set { setAttrVal<string>("Id_body", value); }
        }

        /// <summary>
        /// 部位编码
        /// </summary>
		public string Sd_body {
            get { return getAttrVal<string>("Sd_body",null); }
            set { setAttrVal<string>("Sd_body", value); }
        }

        /// <summary>
        /// 部位名称
        /// </summary>
		public string Body_name {
            get { return getAttrVal<string>("Body_name",null); }
            set { setAttrVal<string>("Body_name", value); }
        }

        /// <summary>
        /// 体位
        /// </summary>
		public string Id_pos {
            get { return getAttrVal<string>("Id_pos",null); }
            set { setAttrVal<string>("Id_pos", value); }
        }

        /// <summary>
        /// 体位编码
        /// </summary>
		public string Sd_pos {
            get { return getAttrVal<string>("Sd_pos",null); }
            set { setAttrVal<string>("Sd_pos", value); }
        }

        /// <summary>
        /// 体位名称
        /// </summary>
		public string Pos_name {
            get { return getAttrVal<string>("Pos_name",null); }
            set { setAttrVal<string>("Pos_name", value); }
        }

        /// <summary>
        /// 医保适应症标识
        /// </summary>
		public bool? Fg_indic {
            get { return getAttrVal<FBoolean>("Fg_indic",null); }
            set { setAttrVal<FBoolean>("Fg_indic", value); }
        }

        /// <summary>
        /// 医疗单项目数据来源方式
        /// </summary>
		public int? Eu_sourcemd {
            get { return getAttrVal<int?>("Eu_sourcemd",null); }
            set { setAttrVal<int?>("Eu_sourcemd", value); }
        }

        /// <summary>
        /// 服务版本号
        /// </summary>
		public DateTime? Srv_sv {
            get { return getAttrVal<FDateTime>("Srv_sv",null); }
            set { setAttrVal<FDateTime>("Srv_sv", value); }
        }

        /// <summary>
        /// 物品版本号
        /// </summary>
		public DateTime? Mm_sv {
            get { return getAttrVal<FDateTime>("Mm_sv",null); }
            set { setAttrVal<FDateTime>("Mm_sv", value); }
        }

        /// <summary>
        /// 需皮试标识
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
        /// 关联医嘱
        /// </summary>
		public string Id_or_rel {
            get { return getAttrVal<string>("Id_or_rel",null); }
            set { setAttrVal<string>("Id_or_rel", value); }
        }

        /// <summary>
        /// 皮试是否有结果
        /// </summary>
		public bool? Fg_skintest_rst {
            get { return getAttrVal<FBoolean>("Fg_skintest_rst",null); }
            set { setAttrVal<FBoolean>("Fg_skintest_rst", value); }
        }

        /// <summary>
        /// 自定义服务标识
        /// </summary>
		public bool? Fg_selfsrv {
            get { return getAttrVal<FBoolean>("Fg_selfsrv",null); }
            set { setAttrVal<FBoolean>("Fg_selfsrv", value); }
        }

        /// <summary>
        /// 所属来源服务
        /// </summary>
		public string Id_srv_src {
            get { return getAttrVal<string>("Id_srv_src",null); }
            set { setAttrVal<string>("Id_srv_src", value); }
        }

        /// <summary>
        /// 服务总量
        /// </summary>
		public double? Quan_total_medu {
            get { return getAttrVal<FDouble>("Quan_total_medu",null); }
            set { setAttrVal<FDouble>("Quan_total_medu", value); }
        }

        /// <summary>
        /// 定价模式
        /// </summary>
		public string Id_primd {
            get { return getAttrVal<string>("Id_primd",null); }
            set { setAttrVal<string>("Id_primd", value); }
        }

        /// <summary>
        /// 自费标识
        /// </summary>
		public bool? Fg_selfpay {
            get { return getAttrVal<FBoolean>("Fg_selfpay",null); }
            set { setAttrVal<FBoolean>("Fg_selfpay", value); }
        }

        /// <summary>
        /// 主医保计划
        /// </summary>
		public string Id_hp {
            get { return getAttrVal<string>("Id_hp",null); }
            set { setAttrVal<string>("Id_hp", value); }
        }

        /// <summary>
        /// 医保目录类型
        /// </summary>
		public string Id_hpsrvtp {
            get { return getAttrVal<string>("Id_hpsrvtp",null); }
            set { setAttrVal<string>("Id_hpsrvtp", value); }
        }

        /// <summary>
        /// 医保目录类型编码
        /// </summary>
		public string Sd_hpsrvtp {
            get { return getAttrVal<string>("Sd_hpsrvtp",null); }
            set { setAttrVal<string>("Sd_hpsrvtp", value); }
        }

        /// <summary>
        /// 仓库
        /// </summary>
		public string Id_dep_wh {
            get { return getAttrVal<string>("Id_dep_wh",null); }
            set { setAttrVal<string>("Id_dep_wh", value); }
        }

        /// <summary>
        /// 毒麻药品服务代办人信息
        /// </summary>
		public FArrayList Emsagentinfo {
            get { return getAttrVal<FArrayList>("Emsagentinfo",null); }
            set { setAttrVal<FArrayList>("Emsagentinfo", value); }
        }

        /// <summary>
        /// 服务分类内码
        /// </summary>
		public string Innercode_srvca {
            get { return getAttrVal<string>("Innercode_srvca",null); }
            set { setAttrVal<string>("Innercode_srvca", value); }
        }

        /// <summary>
        /// 频次周期类型
        /// </summary>
		public string Sd_frequnitct {
            get { return getAttrVal<string>("Sd_frequnitct",null); }
            set { setAttrVal<string>("Sd_frequnitct", value); }
        }

        /// <summary>
        /// 频次周期数
        /// </summary>
		public int? Frequnitct {
            get { return getAttrVal<int?>("Frequnitct",null); }
            set { setAttrVal<int?>("Frequnitct", value); }
        }

        /// <summary>
        /// 频次周期下次数
        /// </summary>
		public int? Freqct {
            get { return getAttrVal<int?>("Freqct",null); }
            set { setAttrVal<int?>("Freqct", value); }
        }

        /// <summary>
        /// 医保目录名称
        /// </summary>
		public string Name_hpsrvtp {
            get { return getAttrVal<string>("Name_hpsrvtp",null); }
            set { setAttrVal<string>("Name_hpsrvtp", value); }
        }

        /// <summary>
        /// 限制报销条件
        /// </summary>
		public string Limit {
            get { return getAttrVal<string>("Limit",null); }
            set { setAttrVal<string>("Limit", value); }
        }

        /// <summary>
        /// 总金额
        /// </summary>
		public double? Amt_total {
            get { return getAttrVal<FDouble>("Amt_total",null); }
            set { setAttrVal<FDouble>("Amt_total", value); }
        }

        /// <summary>
        /// 库房名称
        /// </summary>
		public string Name_dep_wh {
            get { return getAttrVal<string>("Name_dep_wh",null); }
            set { setAttrVal<string>("Name_dep_wh", value); }
        }

        /// <summary>
        /// 计费单位
        /// </summary>
		public string Id_unit_cg {
            get { return getAttrVal<string>("Id_unit_cg",null); }
            set { setAttrVal<string>("Id_unit_cg", value); }
        }

        /// <summary>
        /// 计费单位名称
        /// </summary>
		public string Name_unit_cg {
            get { return getAttrVal<string>("Name_unit_cg",null); }
            set { setAttrVal<string>("Name_unit_cg", value); }
        }

        /// <summary>
        /// 计费基数
        /// </summary>
		public double? Quan_cgbase {
            get { return getAttrVal<FDouble>("Quan_cgbase",null); }
            set { setAttrVal<FDouble>("Quan_cgbase", value); }
        }

        /// <summary>
        /// 系数_费医
        /// </summary>
		public double? Factor_cm {
            get { return getAttrVal<FDouble>("Factor_cm",null); }
            set { setAttrVal<FDouble>("Factor_cm", value); }
        }

        /// <summary>
        /// 计费取整模式
        /// </summary>
		public string Sd_roundmd_cg {
            get { return getAttrVal<string>("Sd_roundmd_cg",null); }
            set { setAttrVal<string>("Sd_roundmd_cg", value); }
        }

        /// <summary>
        /// 物品类型名称
        /// </summary>
		public string Name_mmtp {
            get { return getAttrVal<string>("Name_mmtp",null); }
            set { setAttrVal<string>("Name_mmtp", value); }
        }

        /// <summary>
        /// 厂家
        /// </summary>
		public string Id_sup {
            get { return getAttrVal<string>("Id_sup",null); }
            set { setAttrVal<string>("Id_sup", value); }
        }

        /// <summary>
        /// 厂家名称
        /// </summary>
		public string Name_sup {
            get { return getAttrVal<string>("Name_sup",null); }
            set { setAttrVal<string>("Name_sup", value); }
        }

        /// <summary>
        /// 取整方式
        /// </summary>
		public string Sd_roundmd {
            get { return getAttrVal<string>("Sd_roundmd",null); }
            set { setAttrVal<string>("Sd_roundmd", value); }
        }

        /// <summary>
        /// 金额
        /// </summary>
		public double? Amt_cur {
            get { return getAttrVal<FDouble>("Amt_cur",null); }
            set { setAttrVal<FDouble>("Amt_cur", value); }
        }

        /// <summary>
        /// 可用库存
        /// </summary>
		public double? Quan_stock {
            get { return getAttrVal<FDouble>("Quan_stock",null); }
            set { setAttrVal<FDouble>("Quan_stock", value); }
        }

        /// <summary>
        /// 对应皮试服务
        /// </summary>
		public string Id_srvskin {
            get { return getAttrVal<string>("Id_srvskin",null); }
            set { setAttrVal<string>("Id_srvskin", value); }
        }

        /// <summary>
        /// 关联信息Map键值串
        /// </summary>
		public string Mapkeys {
            get { return getAttrVal<string>("Mapkeys",null); }
            set { setAttrVal<string>("Mapkeys", value); }
        }

        /// <summary>
        /// 服务与物品关联信息MAP
        /// </summary>
		public FMap Mapinfo {
            get { return getAttrVal<FMap>("Mapinfo",null); }
            set { setAttrVal<FMap>("Mapinfo", value); }
        }

        /// <summary>
        /// 计价依据
        /// </summary>
		public string Priby {
            get { return getAttrVal<string>("Priby",null); }
            set { setAttrVal<string>("Priby", value); }
        }

        /// <summary>
        /// 基数药标识
        /// </summary>
		public bool? Fg_base {
            get { return getAttrVal<FBoolean>("Fg_base",null); }
            set { setAttrVal<FBoolean>("Fg_base", value); }
        }


        /// <summary>
        /// 领可用天数（门诊用）
        /// </summary>
        public int? Days_available
        {
            get { return getAttrVal<int?>("Days_available", null); }
            set { setAttrVal<int?>("Days_available", value); }
        }
        /// <summary>
        /// 可退费标识
        /// </summary>
        public bool? Fg_feertnable
        {
            get { return getAttrVal<FBoolean>("Fg_feertnable", null); }
            set { setAttrVal<FBoolean>("Fg_feertnable", value); }
        }

      
        //0 未处理，1已经处理
        public int? Eu_hpdoctorjudge11
        {
            get { return getAttrVal<int?>("Eu_hpdoctorjudge", null); }
            set { setAttrVal<int?>("Eu_hpdoctorjudge", value); }
        }
        /// <summary>
        /// 费用说明
        /// </summary>
        public string Des_bl
        {
            get { return getAttrVal<string>("Des_bl", null); }
            set { setAttrVal<string>("Des_bl", value); }
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
        /// 标准价
        /// </summary>
        public FDouble Pri_std
        {
            get { return getAttrVal<FDouble>("Pri_std", null); }
            set { setAttrVal<FDouble>("Pri_std", value); }
        }

        /// <summary>
        /// 价格系数
        /// </summary>
        public FDouble Pri_ratio
        {
            get { return getAttrVal<FDouble>("Pri_ratio", null); }
            set { setAttrVal<FDouble>("Pri_ratio", value); }
        }

        /// <summary>
        /// 患者价格分类
        /// </summary>
        public string Id_pripat
        {
            get { return getAttrVal<string>("Id_pripat", null); }
            set { setAttrVal<string>("Id_pripat", value); }
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
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[] { "Id_orsrv", "Id_or", "Sortno", "Id_srv", "Id_srv_set", "Id_srvtp", "Sd_srvtp", "Code_srv", "Name_srv", "Id_srvca", "Id_unit_med", "Name_unit_med", "Quan_med", "Price", "Id_freq", "Name_freq", "Id_route", "Name_route", "Id_routedes", "Name_routedes", "Id_boil", "Name_boil", "Id_boildes", "Name_boildes", "Fg_dose_anoma", "Des_srv", "Fg_mm", "Fg_set", "Fg_or", "Fg_bl", "Fg_self", "Fg_outp", "Fg_propc", "Fg_treat", "Id_org_srv", "Id_dep_srv", "Id_ward_srv", "Id_emp_srv", "Dt_create_srv", "Id_dep", "Name_dep", "Dt_last_bl", "Eu_blmd", "Id_orsrvmm", "Id_mm", "Code_mm", "Name_mm", "Spec_mm", "Id_unit_sale", "Name_unit_sale", "Id_unit_base", "Name_unit_base", "Quan_num_base", "Quan_den_base", "Price_cur", "Quan_cur", "Quan_base", "Quan_bed_medu", "Factor_cb", "Factor_mb", "Id_dosage", "Sd_dosage", "Id_pharm", "Sd_pharm", "Id_pois", "Sd_pois", "Id_anti", "Sd_anti", "Id_mmtp", "Sd_mmtp", "Id_val", "Sd_val", "Indica", "Constr", "React", "Guide", "Fg_otc", "Emsfreqdose", "Id_body", "Sd_body", "Body_name", "Id_pos", "Sd_pos", "Pos_name", "Fg_indic", "Eu_sourcemd", "Srv_sv", "Mm_sv", "Fg_skintest", "Id_skintest_skip_reason", "Sd_skintest_skip_reason", "Id_reltp", "Sd_reltp", "Id_or_rel", "Fg_skintest_rst", "Fg_selfsrv", "Id_srv_src", "Quan_total_medu", "Id_primd", "Fg_selfpay", "Id_hp", "Id_hpsrvtp", "Sd_hpsrvtp", "Id_dep_wh", "Emsagentinfo", "Innercode_srvca", "Sd_frequnitct", "Frequnitct", "Freqct", "Name_hpsrvtp", "Limit", "Amt_total", "Name_dep_wh", "Id_unit_cg", "Name_unit_cg", "Quan_cgbase", "Factor_cm", "Sd_roundmd_cg", "Name_mmtp", "Id_sup", "Name_sup", "Sd_roundmd", "Amt_cur", "Quan_stock", "Id_srvskin", "Mapkeys", "Mapinfo", "Priby", "Fg_base", "Days_available", "Eu_hpdoctorjudge", "Des_bl", "Fg_extdispense", "Pri_std", "Pri_ratio", "Id_pripat", "Fg_hpindicjudged" };
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.ems.d.CiEmsSrvDTO";
        }
    }
}
