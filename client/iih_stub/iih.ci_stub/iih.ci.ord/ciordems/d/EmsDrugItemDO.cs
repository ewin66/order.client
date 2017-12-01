using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using xap.rui.appfw;
using iih.ci.iih.ci.ord.ciordems.d;

namespace iih.ci.ord.ciordems.d
{
    /// <summary>
    /// 是CI_SRV_MM+BD_SRV两张表信息的组装
    /// </summary>
    public class EmsDrugItemDO : OrCommonFieldsDTO
    {

        public EmsDrugItemDO() {
 
        }

        /// <summary>
        /// 医嘱服务项目
        /// </summary>
		public string Id_orsrv {
            get { return getAttrVal<string>("Id_orsrv",null); }
            set { setAttrVal<string>("Id_orsrv", value); }
        }

        /// <summary>
        /// 医嘱
        /// </summary>
		public string Id_or {
            get { return getAttrVal<string>("Id_or",null); }
            set { setAttrVal<string>("Id_or", value); }
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
        /// 医疗服务
        /// </summary>
		public string Id_srv {
            get { return getAttrVal<string>("Id_srv",null); }
            set { setAttrVal<string>("Id_srv", value); }
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
        /// 变动用药安排
        /// </summary>
		public FArrayList Emsfreqdose {
            get { return getAttrVal<FArrayList>("Emsfreqdose",null); }
            set { setAttrVal<FArrayList>("Emsfreqdose", value); }
        }

        /// <summary>
        /// 物品标识
        /// </summary>
		public bool? Fg_urgent
        {
            get { return getAttrVal<FBoolean>("Fg_urgent", null); }
            set { setAttrVal<FBoolean>("Fg_urgent", value); }
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
        /// 出院带药标识
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

        public bool? Fg_boil
        {
            get { return getAttrVal<FBoolean>("Fg_boil", null); }
            set { setAttrVal<FBoolean>("Fg_boil", value); }
        }

        /// <summary>
        /// 参考价格
        /// </summary>
		public double? Price {
            get { return getAttrVal<FDouble>("Price",null); }
            set { setAttrVal<FDouble>("Price", value); }
        }
		
		/// <summary>
        /// 金额
        /// </summary>
		public string Totalprice {
            get { return getAttrVal<string>("Totalprice",null); }
            set { setAttrVal<string>("Totalprice", value); }
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
        /// 物品默认标识
        /// </summary>
		public bool? Isdefault {
            get { return getAttrVal<FBoolean>("Isdefault",null); }
            set { setAttrVal<FBoolean>("Isdefault", value); }
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
        /// 数量_当前
        /// </summary>
		public double? Quan_cur {
            get { return getAttrVal<FDouble>("Quan_cur",null); }
            set { setAttrVal<FDouble>("Quan_cur", value); }
        }

        /// <summary>
        /// 数量_基本
        /// </summary>
		public double? Quan_base {
            get { return getAttrVal<double?>("Quan_base", null); }
            set { setAttrVal<double?>("Quan_base", value); }
        }

        /// <summary>
        /// 当前基本换算系数
        /// </summary>
		public string Factor_cb {
            get { return getAttrVal<string>("Factor_cb",null); }
            set { setAttrVal<string>("Factor_cb", value); }
        }

        /// <summary>
        /// 医疗基本换算系数
        /// </summary>
		public string Factor_mb {
            get { return getAttrVal<string>("Factor_mb",null); }
            set { setAttrVal<string>("Factor_mb", value); }
        }

        /// <summary>
        /// 长临标识
        /// </summary>
		public bool? Fg_long {
            get { return getAttrVal<FBoolean>("Fg_long",null); }
            set { setAttrVal<FBoolean>("Fg_long", value); }
        }

        /// <summary>
        /// 备用医嘱标识
        /// </summary>
		public bool? Fg_pmor {
            get { return getAttrVal<FBoolean>("Fg_pmor",null); }
            set { setAttrVal<FBoolean>("Fg_pmor", value); }
        }

        /// <summary>
        /// 备用医嘱使用条件描述
        /// </summary>
		public string Bak_des {
            get { return getAttrVal<string>("Bak_des",null); }
            set { setAttrVal<string>("Bak_des", value); }
        }

        /// <summary>
        /// 备用医嘱失效日期
        /// </summary>
		public DateTime? Dt_fail {
            get { return getAttrVal<FDateTime>("Dt_fail",null); }
            set { setAttrVal<FDateTime>("Dt_fail", value); }
        }

        /// <summary>
        /// 单次数量
        /// </summary>
		public int? Single_count {
            get { return getAttrVal<int?>("Single_count",null); }
            set { setAttrVal<int?>("Single_count", value); }
        }

        /// <summary>
        /// 执行时间
        /// </summary>
		public string Work_time {
            get { return getAttrVal<string>("Work_time",null); }
            set { setAttrVal<string>("Work_time", value); }
        }

        /// <summary>
        /// 首日执行
        /// </summary>
        public string  First_freq
        {
            get { return getAttrVal<string>("First_freq", null); }
            set { setAttrVal<string>("First_freq", value); }
        }

        /// <summary>
        /// 首日执行时间
        /// </summary>
        public string First_time
        {
            get { return getAttrVal<string>("First_time", null); }
            set { setAttrVal<string>("First_time", value); }
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
        /// 总量
        /// </summary>
		public double? Total_count {
            get { return getAttrVal<FDouble>("Total_count",null); }
            set { setAttrVal<FDouble>("Total_count", value); }
        }

        /// <summary>
        /// 总量单位id
        /// </summary>
		public string Id_total_count_unit {
            get { return getAttrVal<string>("Id_total_count_unit",null); }
            set { setAttrVal<string>("Id_total_count_unit", value); }
        }

        /// <summary>
        /// 总量单位
        /// </summary>
		public string Total_count_unit {
            get { return getAttrVal<string>("Total_count_unit",null); }
            set { setAttrVal<string>("Total_count_unit", value); }
        }

        /// <summary>
        /// 皮试标识
        /// </summary>
        //public bool? Fg_skintest {
        //    get { return getAttrVal<FBoolean>("Fg_skintest",null); }
        //    set { setAttrVal<FBoolean>("Fg_skintest", value); }
        //}

        /// <summary>
        /// 组织编码
        /// </summary>
		public string Id_org {
            get { return getAttrVal<string>("Id_org",null); }
            set { setAttrVal<string>("Id_org", value); }
        }

        /// <summary>
        /// 医嘱付数
        /// </summary>
		public int? Orders {
            get { return getAttrVal<int?>("Orders",null); }
            set { setAttrVal<int?>("Orders", value); }
        }

        /// <summary>
        /// 代煎付数
        /// </summary>
		public int? Orders_boil {
            get { return getAttrVal<int?>("Orders_boil",null); }
            set { setAttrVal<int?>("Orders_boil", value); }
        }

        /// <summary>
        /// 频次单位
        /// </summary>
		public string Sd_frequnitct {
            get { return getAttrVal<string>("Sd_frequnitct",null); }
            set { setAttrVal<string>("Sd_frequnitct", value); }
        }

        /// <summary>
        /// 频次下频次数
        /// </summary>
		public int? Freqct {
            get { return getAttrVal<int?>("Freqct",null); }
            set { setAttrVal<int?>("Freqct", value); }
        }

        /// <summary>
        /// 在院执行标志
        /// </summary>
		public bool? Fg_mp_in {
            get { return getAttrVal<FBoolean>("Fg_mp_in",null); }
            set { setAttrVal<FBoolean>("Fg_mp_in", value); }
        }
         /// <summary>
        /// 首日执行次数
        /// </summary>
        public int? Quan_firday_mp
        {
            get { return getAttrVal<int?>("Quan_firday_mp", null); }
            set { setAttrVal<int?>("Quan_firday_mp", value); }
        }

        

        /// <summary>
        /// 最近生成日期
        /// </summary>
		public DateTime? Dt_last_bl {
            get { return getAttrVal<FDateTime>("Dt_last_bl",null); }
            set { setAttrVal<FDateTime>("Dt_last_bl", value); }
        }

        /// <summary>
        /// 备注
        /// </summary>
        public string Note_or
        {
            get { return getAttrVal<string>("Note_or", null); }
            set { setAttrVal<string>("Note_or", value); }
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
        /// 自费标示
        /// </summary>
        public bool? Fg_selfpay
        {
            get { return getAttrVal<FBoolean>("Fg_selfpay", null); }
            set { setAttrVal<FBoolean>("Fg_selfpay", value); }
        }


           /// <summary>
        /// 医学单位剂量
        /// </summary>
		public double? Quan_medu {
            get { return getAttrVal<FDouble>("Quan_medu", null); }
            set { setAttrVal<FDouble>("Quan_medu", value); }
        }

        /// <summary>
        /// 超量开单原因id
        /// </summary>
		public string Id_excessive_reason
        {
            get { return getAttrVal<string>("Id_excessive_reason", null); }
            set { setAttrVal<string>("Id_excessive_reason", value); }
        }

        /// <summary>
        /// 超量开单原因sd
        /// </summary>
		public string Sd_excessive_reason
        {
            get { return getAttrVal<string>("Sd_excessive_reason", null); }
            set { setAttrVal<string>("Sd_excessive_reason", value); }
        }

        /// <summary>
        /// 超量开单原因名称
        /// </summary>
		public string Name_excessive_reason
        {
            get { return getAttrVal<string>("Name_excessive_reason", null); }
            set { setAttrVal<string>("Name_excessive_reason", value); }
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[] { "Id_orsrv", "Id_or", "Id_srvtp", "Sd_srvtp", "Id_srv", "Code_srv", "Name_srv", "Id_unit_med", "Name_unit_med", "Quan_med", "Id_freq", "Name_freq", "Id_route", "Name_route", "Id_routedes", "Name_routedes", "Id_boil", "Name_boil", "Id_boildes", "Name_boildes", "Fg_dose_anoma", "Emsfreqdose", "Fg_mm", "Fg_set", "Fg_or", "Fg_bl", "Fg_self", "Fg_outp", "Fg_propc", "Fg_treat", "Price", "Totalprice", "Id_orsrvmm", "Id_mm", "Name_mm", "Spec_mm", "Indica", "Constr", "React", "Guide", "Isdefault", "Id_unit_sale", "Name_unit_sale", "Id_unit_base", "Name_unit_base", "Quan_cur", "Quan_base", "Factor_cb", "Factor_mb", "Dt_begin_ui", "Dt_end_ui", "Use_days", "Fg_long", "Fg_pmor", "Bak_des", "Dt_fail", "Single_count", "Work_time", "First_freq", "First_time", "Id_dep", "Name_dep", "Total_count", "Id_total_count_unit", "Total_count_unit", "Fg_skintest", "Id_org", "Orders", "Orders_boil", "Sd_frequnitct", "Freqct", "Fg_mp_in", "Times_mp_in", "Dt_last_bl", "EmsOrDrug", "EmsOrDrugList", "EmsOrDeleteDrugList", "EmsOrDoseDrug", "Fg_selfpay", "Quan_medu", "EmsDoseDrugMap", "DrugItemInfo", "Str_wh_dep_ids", "Times_cur", "Fg_extdispense", "Id_excessive_reason", "Sd_excessive_reason", "Name_excessive_reason",
                "Ismulexec",
                "Ismuldose" };/////////添加检验、检查、诊疗多剂量多次执行，杨敬本20171111
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.ciordems.d.EmsDrugItemDO";
        }

        /// <summary>
        /// 医嘱药品参照数据集
        /// </summary>
        /// <value>
        /// The ems ord SRV mm.
        /// </value>
        /// Author:admin
        /// Date:2015-09-05
        public XapDataList<EmsOrDrug> EmsOrDrug {
            get { return getAttrVal<XapDataList<EmsOrDrug>>("EmsOrDrug", null); }
            set { setAttrVal<XapDataList<EmsOrDrug>>("EmsOrDrug", value); }
        }

        /// <summary>
        /// 与EmsOrDrug数据相同，用于接口改造数据传输
        /// </summary>
        /// <value>
        /// 
        /// </value>
        public FArrayList EmsOrDrugEx {

            get { return getAttrVal<FArrayList>("EmsOrDrugEx", null); }
            set { setAttrVal<FArrayList>("EmsOrDrugEx", value); }
        }

        /// <summary>
        /// Gets or sets the 药品表单上的药品列表
        /// </summary>
        /// <value>
        /// The ems or drug list.
        /// </value>
        /// Author:admin
        /// Date:2015-09-05
        public XapDataList<EmsOrDrug> EmsOrDrugList
        {
            get { return getAttrVal<XapDataList<EmsOrDrug>>("EmsOrDrugList", null); }
            set { setAttrVal<XapDataList<EmsOrDrug>>("EmsOrDrugList", value); }
        }

        /// <summary>
        /// 
        /// </summary>
                 
        public FArrayList EmsOrDrugListEx
        {
            get { return getAttrVal<FArrayList>("EmsOrDrugListEx", null); }
            set { setAttrVal<FArrayList>("EmsOrDrugListEx", value); }
        }

        /// <summary>
        /// 删除的药品集合
        /// </summary>
        /// <value>
        /// The ems or delete drug list.
        /// </value>
        /// Author:admin
        /// Date:2015-10-14
        public XapDataList<EmsOrDrug> EmsOrDeleteDrugList
        {
            get { return getAttrVal<XapDataList<EmsOrDrug>>("EmsOrDeleteDrugList", null); }
            set { setAttrVal<XapDataList<EmsOrDrug>>("EmsOrDeleteDrugList", value); }
        }
        /// <summary>
        /// 变动用药数据集合
        /// </summary>
        /// <value>
        /// The ems or dose drug list.
        /// </value>
        /// Author:admin
        /// Date:2015-09-12
        public XapDataList<EmsOrDrug> EmsOrDoseDrug
        {
            get { return getAttrVal<XapDataList<EmsOrDrug>>("EmsOrDoseDrug", null); }
            set { setAttrVal<XapDataList<EmsOrDrug>>("EmsOrDoseDrug", value); }
        }
        public string Name_heath
        {
            get { return getAttrVal<string>("Name_heath", null); }
            set { setAttrVal<string>("Name_heath", value); }
        }

        public string Limit
        {
            get { return getAttrVal<string>("Limit", null); }
            set { setAttrVal<string>("Limit", value); }
        }
        //厂商
        public string Name_sup
        {
            get { return getAttrVal<string>("Name_sup", null); }
            set { setAttrVal<string>("Name_sup", value); }
        }

        /// <summary>
        /// m描述
        /// </summary>
        public string Des_mm
        {
            get { return getAttrVal<string>("Des_mm", null); }
            set { setAttrVal<string>("Des_mm", value); }
        }

        /// <summary>
        /// 服务内部编码
        /// </summary>
        public string Innercode_srvca
        {
            get { return getAttrVal<string>("Innercode_srvca", null); }
            set { setAttrVal<string>("Innercode_srvca", value); }
        }


        /// <summary>
        /// 费用同步标识
        /// </summary>
        public bool? Fg_syncfee
        {
            get { return getAttrVal<bool?>("Fg_syncfee", null); }
            set { setAttrVal<bool?>("Fg_syncfee", value); }
        }

        /// <summary>
        /// 外配药标识
        /// </summary>
        public bool? Fg_extdispense
        {
            get { return getAttrVal<FBoolean>("Fg_extdispense", null); }
            set { setAttrVal<FBoolean>("Fg_extdispense", value); }
        }

        /////////添加检验、检查、诊疗多剂量多次执行，杨敬本20171111
        /// <summary>
        /// 是否多次执行
        /// </summary>
        public bool? Ismulexec
        {
            get { return getAttrVal<FBoolean>("Ismulexec", null); }
            set { setAttrVal<FBoolean>("Ismulexec", value); }
        }

        /// <summary>
        /// 是否多剂量
        /// </summary>
        public bool? Ismuldose
        {
            get { return getAttrVal<FBoolean>("Ismuldose", null); }
            set { setAttrVal<FBoolean>("Ismuldose", value); }
        }
        /////////添加检验、检查、诊疗多剂量多次执行，杨敬本20171111
        ////医嘱物品
        //public List<OrdSrvMmDO> EmsOrdSrvMm
        //{
        //    get { return getAttrVal<List<OrdSrvMmDO>>("EmsOrdSrvMm", null); }
        //    set { setAttrVal<List<OrdSrvMmDO>>("EmsOrdSrvMm", value); }
        //}
    }
}
