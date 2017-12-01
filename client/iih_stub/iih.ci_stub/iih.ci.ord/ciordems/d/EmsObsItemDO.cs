using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using xap.rui.appfw;
using iih.ci.iih.ci.ord.ciordems.d;

namespace iih.ci.ord.ciordems.d
{
    /// <summary>
    /// EmsObsItemDO 的摘要说明。
    /// </summary>
    public class EmsObsItemDO : OrCommonFieldsDTO {

        public EmsObsItemDO() {
 
        }

        /// <summary>
        /// 诊断子项id
        /// </summary>
		public string Id_diitm {
            get { return getAttrVal<string>("Id_diitm",null); }
            set { setAttrVal<string>("Id_diitm", value); }
        }

        /// <summary>
        /// 诊断子项id拼接
        /// </summary>
		public string Str_id_diitm {
            get { return getAttrVal<string>("Str_id_diitm",null); }
            set { setAttrVal<string>("Str_id_diitm", value); }
        }

        /// <summary>
        /// 诊断名称拼接
        /// </summary>
		public string Str_name_di {
            get { return getAttrVal<string>("Str_name_di",null); }
            set { setAttrVal<string>("Str_name_di", value); }
        }

        /// <summary>
        /// 诊断编码拼接
        /// </summary>
		public string Str_code_di {
            get { return getAttrVal<string>("Str_code_di",null); }
            set { setAttrVal<string>("Str_code_di", value); }
        }

        /// <summary>
        /// 诊断名称
        /// </summary>
		public string Name_diag {
            get { return getAttrVal<string>("Name_diag",null); }
            set { setAttrVal<string>("Name_diag", value); }
        }

        /// <summary>
        /// 诊断id
        /// </summary>
		public string Id_di {
            get { return getAttrVal<string>("Id_di",null); }
            set { setAttrVal<string>("Id_di", value); }
        }

        /// <summary>
        /// 检查申请单主键
        /// </summary>
		public string Id_emsobs {
            get { return getAttrVal<string>("Id_emsobs",null); }
            set { setAttrVal<string>("Id_emsobs", value); }
        }

        /// <summary>
        /// 医嘱服务id
        /// </summary>
		public string Id_orsrv {
            get { return getAttrVal<string>("Id_orsrv",null); }
            set { setAttrVal<string>("Id_orsrv", value); }
        }

        /// <summary>
        /// 医嘱医疗单
        /// </summary>
		public string Id_or {
            get { return getAttrVal<string>("Id_or",null); }
            set { setAttrVal<string>("Id_or", value); }
        }

        /// <summary>
        /// 服务id
        /// </summary>
		public string Id_srv {
            get { return getAttrVal<string>("Id_srv",null); }
            set { setAttrVal<string>("Id_srv", value); }
        }

        /// <summary>
        /// 服务名称
        /// </summary>
		public string Name_srv {
            get { return getAttrVal<string>("Name_srv",null); }
            set { setAttrVal<string>("Name_srv", value); }
        }

        /// <summary>
        /// 服务类型
        /// </summary>
		public string Id_srvtp {
            get { return getAttrVal<string>("Id_srvtp",null); }
            set { setAttrVal<string>("Id_srvtp", value); }
        }

        /// <summary>
        /// 服务类型名称
        /// </summary>
		public string Name_srvtp {
            get { return getAttrVal<string>("Name_srvtp",null); }
            set { setAttrVal<string>("Name_srvtp", value); }
        }

        /// <summary>
        /// 检查类型id
        /// </summary>
		public string Id_obstp {
            get { return getAttrVal<string>("Id_obstp",null); }
            set { setAttrVal<string>("Id_obstp", value); }
        }

        /// <summary>
        /// 检查类型名称
        /// </summary>
		public string Name_obstp {
            get { return getAttrVal<string>("Name_obstp",null); }
            set { setAttrVal<string>("Name_obstp", value); }
        }

        /// <summary>
        /// 检查申请单号
        /// </summary>
		public string No_applyobs {
            get { return getAttrVal<string>("No_applyobs",null); }
            set { setAttrVal<string>("No_applyobs", value); }
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
        /// Gets or sets the 检查体位集合
        /// </summary>
        /// <value>
        /// The ems or drug list.
        /// </value>
        /// Author:admin
        /// Date:2015-09-05
        //public FArrayList EmsOrObsArrayList
        //{
        //    get { return getAttrVal<FArrayList>("EmsOrObsArrayList", null); }
        //    set { setAttrVal<FArrayList>("EmsOrObsArrayList", value); }
        //}

        public XapDataList<EmsObsLap> EmsOrObsList
        {
            get { return getAttrVal<XapDataList<EmsObsLap>>("EmsOrObsList", null); }
            set { setAttrVal<XapDataList<EmsObsLap>>("EmsOrObsList", value); }
        }
        /// <summary>
        /// 编辑时删除是检查部位
        /// </summary>
        public XapDataList<EmsObsLap> EmsOrObsListDel
        {
            get { return getAttrVal<XapDataList<EmsObsLap>>("EmsOrObsListDel", null); }
            set { setAttrVal<XapDataList<EmsObsLap>>("EmsOrObsListDel", value); }
        }
        /// <summary>
        /// 加急标识
        /// </summary>
		public bool? Fg_urgent {
            get { return getAttrVal<FBoolean>("Fg_urgent",null); }
            set { setAttrVal<FBoolean>("Fg_urgent", value); }
        }

        /// <summary>
        /// 床旁执行标志
        /// </summary>
		public bool? Fg_mp_bed {
            get { return getAttrVal<FBoolean>("Fg_mp_bed",null); }
            set { setAttrVal<FBoolean>("Fg_mp_bed", value); }
        }

        /// <summary>
        /// 计划检查时间
        /// </summary>
		public DateTime? Dt_plan {
            get { return getAttrVal<FDateTime>("Dt_plan",null); }
            set { setAttrVal<FDateTime>("Dt_plan", value); }
        }

        /// <summary>
        /// 检查目的编码
        /// </summary>
		public string Sd_pps {
            get { return getAttrVal<string>("Sd_pps",null); }
            set { setAttrVal<string>("Sd_pps", value); }
        }

        /// <summary>
        /// 检查目的
        /// </summary>
		public string Id_pps {
            get { return getAttrVal<string>("Id_pps",null); }
            set { setAttrVal<string>("Id_pps", value); }
        }

        /// <summary>
        /// 检查目的名称
        /// </summary>
		public string Name_pps {
            get { return getAttrVal<string>("Name_pps",null); }
            set { setAttrVal<string>("Name_pps", value); }
        }

        /// <summary>
        /// 检查目的描述
        /// </summary>
		public string Des_pps {
            get { return getAttrVal<string>("Des_pps",null); }
            set { setAttrVal<string>("Des_pps", value); }
        }

        /// <summary>
        /// 症状体征描述
        /// </summary>
		public string Des_sympsign {
            get { return getAttrVal<string>("Des_sympsign",null); }
            set { setAttrVal<string>("Des_sympsign", value); }
        }

        /// <summary>
        /// 身体部位id
        /// </summary>
		public string Id_body {
            get { return getAttrVal<string>("Id_body",null); }
            set { setAttrVal<string>("Id_body", value); }
        }

        /// <summary>
        /// 身体部位编码
        /// </summary>
		public string Sd_body {
            get { return getAttrVal<string>("Sd_body",null); }
            set { setAttrVal<string>("Sd_body", value); }
        }

        /// <summary>
        /// 身体部位名称
        /// </summary>
		public string Name_body {
            get { return getAttrVal<string>("Name_body",null); }
            set { setAttrVal<string>("Name_body", value); }
        }

        /// <summary>
        /// 检查申请单状态
        /// </summary>
		public string Id_su_obs {
            get { return getAttrVal<string>("Id_su_obs",null); }
            set { setAttrVal<string>("Id_su_obs", value); }
        }

        /// <summary>
        /// 检查申请单编码
        /// </summary>
		public string Sd_su_obs {
            get { return getAttrVal<string>("Sd_su_obs",null); }
            set { setAttrVal<string>("Sd_su_obs", value); }
        }

        /// <summary>
        /// 身体体位id
        /// </summary>
		public string Id_pos {
            get { return getAttrVal<string>("Id_pos",null); }
            set { setAttrVal<string>("Id_pos", value); }
        }

        /// <summary>
        /// 身体体位编码
        /// </summary>
		public string Sd_pos {
            get { return getAttrVal<string>("Sd_pos",null); }
            set { setAttrVal<string>("Sd_pos", value); }
        }

        /// <summary>
        /// 身体体位名称
        /// </summary>
		public string Name_pos {
            get { return getAttrVal<string>("Name_pos",null); }
            set { setAttrVal<string>("Name_pos", value); }
        }

        /// <summary>
        /// 标本类型id
        /// </summary>
		public string Id_samptp {
            get { return getAttrVal<string>("Id_samptp",null); }
            set { setAttrVal<string>("Id_samptp", value); }
        }

        /// <summary>
        /// 标本类型名称
        /// </summary>
		public string Name_samptp {
            get { return getAttrVal<string>("Name_samptp",null); }
            set { setAttrVal<string>("Name_samptp", value); }
        }

        /// <summary>
        /// 标本类型编码
        /// </summary>
		public string Sd_samptp {
            get { return getAttrVal<string>("Sd_samptp",null); }
            set { setAttrVal<string>("Sd_samptp", value); }
        }

        /// <summary>
        /// 序号
        /// </summary>
		public int? Sortno {
            get { return getAttrVal<int?>("Sortno",null); }
            set { setAttrVal<int?>("Sortno", value); }
        }

        /// <summary>
        /// 选择
        /// </summary>
		public bool? Fg_chk {
            get { return getAttrVal<FBoolean>("Fg_chk",null); }
            set { setAttrVal<FBoolean>("Fg_chk", value); }
        }

        /// <summary>
        /// 注意事项
        /// </summary>
		public string Announcements {
            get { return getAttrVal<string>("Announcements",null); }
            set { setAttrVal<string>("Announcements", value); }
        }

        /// <summary>
        /// 版本号
        /// </summary>
		public DateTime? Sv {
            get { return getAttrVal<FDateTime>("Sv",null); }
            set { setAttrVal<FDateTime>("Sv", value); }
        }

        /// <summary>
        /// 检验分类
        /// </summary>
		public string Id_srvca {
            get { return getAttrVal<string>("Id_srvca",null); }
            set { setAttrVal<string>("Id_srvca", value); }
        }

        /// <summary>
        /// 采集方法编码
        /// </summary>
		public string Sd_colltp {
            get { return getAttrVal<string>("Sd_colltp",null); }
            set { setAttrVal<string>("Sd_colltp", value); }
        }

        /// <summary>
        /// 采集方法id
        /// </summary>
		public string Id_colltp {
            get { return getAttrVal<string>("Id_colltp",null); }
            set { setAttrVal<string>("Id_colltp", value); }
        }

        /// <summary>
        /// 标本说明
        /// </summary>
		public string Des_labsamp {
            get { return getAttrVal<string>("Des_labsamp",null); }
            set { setAttrVal<string>("Des_labsamp", value); }
        }
        /////////添加检验、检查、诊疗多剂量多次执行，杨敬本20171111
        /// <summary>
        /// 使用天数
        /// </summary>
		public int? Use_days {
            get { return getAttrVal<int?>("Use_days",null); }
            set { setAttrVal<int?>("Use_days", value); }
        }
        /////////添加检验、检查、诊疗多剂量多次执行，杨敬本20171111
        /// <summary>
        /// 执行科室ID
        /// </summary>
		public string Id_mp_dep {
            get { return getAttrVal<string>("Id_mp_dep",null); }
            set { setAttrVal<string>("Id_mp_dep", value); }
        }

        /// <summary>
        /// 执行科室名称
        /// </summary>
		public string Name_mp_dep {
            get { return getAttrVal<string>("Name_mp_dep",null); }
            set { setAttrVal<string>("Name_mp_dep", value); }
        }

        /// <summary>
        /// 价格
        /// </summary>
		public FDouble Price {
            get { return getAttrVal<FDouble>("Price",null); }
            set { setAttrVal<FDouble>("Price", value); }
        }

        /// <summary>
        /// 总量
        /// </summary>
		public FDouble Quan_cur {
            get { return getAttrVal<FDouble>("Quan_cur",null); }
            set { setAttrVal<FDouble>("Quan_cur", value); }
        }

        /// <summary>
        /// 总量单位
        /// </summary>
		public string Id_unit_sale {
            get { return getAttrVal<string>("Id_unit_sale",null); }
            set { setAttrVal<string>("Id_unit_sale", value); }
        }

        /// <summary>
        /// 总量单位名称
        /// </summary>
		public string Name_unit_sale {
            get { return getAttrVal<string>("Name_unit_sale",null); }
            set { setAttrVal<string>("Name_unit_sale", value); }
        }

        /// <summary>
        /// 适应症
        /// </summary>
		public bool? Fg_indic {
            get { return getAttrVal<FBoolean>("Fg_indic",null); }
            set { setAttrVal<FBoolean>("Fg_indic", value); }
        }

        /// <summary>
        /// 计数单位ID
        /// </summary>
		public string Id_unit_base {
            get { return getAttrVal<string>("Id_unit_base",null); }
            set { setAttrVal<string>("Id_unit_base", value); }
        }

        /// <summary>
        /// 计数单位名称
        /// </summary>
		public string Name_unit_base {
            get { return getAttrVal<string>("Name_unit_base",null); }
            set { setAttrVal<string>("Name_unit_base", value); }
        }

        /// <summary>
        /// 计数单位
        /// </summary>
		public FDouble Quan_base {
            get { return getAttrVal<FDouble>("Quan_base",null); }
            set { setAttrVal<FDouble>("Quan_base", value); }
        }

        /// <summary>
        /// 服务分类内部编码
        /// </summary>
		public string Innercode_srvca {
            get { return getAttrVal<string>("Innercode_srvca",null); }
            set { setAttrVal<string>("Innercode_srvca", value); }
        }

        /// <summary>
        /// 费用同步标识
        /// </summary>
		public bool? Fg_syncfee {
            get { return getAttrVal<FBoolean>("Fg_syncfee",null); }
            set { setAttrVal<FBoolean>("Fg_syncfee", value); }
        }

        /// <summary>
        /// 客户拓展字段1
        /// </summary>
		public string Def1 {
            get { return getAttrVal<string>("Def1",null); }
            set { setAttrVal<string>("Def1", value); }
        }

        /// <summary>
        /// 客户拓展字段2
        /// </summary>
		public string Def2 {
            get { return getAttrVal<string>("Def2",null); }
            set { setAttrVal<string>("Def2", value); }
        }

        /// <summary>
        /// 客户拓展字段3
        /// </summary>
		public string Def3 {
            get { return getAttrVal<string>("Def3",null); }
            set { setAttrVal<string>("Def3", value); }
        }

        /// <summary>
        /// 客户拓展字段4
        /// </summary>
		public string Def4 {
            get { return getAttrVal<string>("Def4",null); }
            set { setAttrVal<string>("Def4", value); }
        }

        /// <summary>
        /// 客户拓展字段5
        /// </summary>
		public string Def5 {
            get { return getAttrVal<string>("Def5",null); }
            set { setAttrVal<string>("Def5", value); }
        }

        /// <summary>
        /// 客户拓展字段6
        /// </summary>
		public string Def6 {
            get { return getAttrVal<string>("Def6",null); }
            set { setAttrVal<string>("Def6", value); }
        }

        /// <summary>
        /// 客户拓展字段7
        /// </summary>
		public string Def7 {
            get { return getAttrVal<string>("Def7",null); }
            set { setAttrVal<string>("Def7", value); }
        }

        /// <summary>
        /// 客户拓展字段8
        /// </summary>
		public string Def8 {
            get { return getAttrVal<string>("Def8",null); }
            set { setAttrVal<string>("Def8", value); }
        }

        /// <summary>
        /// 客户拓展字段9
        /// </summary>
		public string Def9 {
            get { return getAttrVal<string>("Def9",null); }
            set { setAttrVal<string>("Def9", value); }
        }

        /// <summary>
        /// 客户拓展字段10
        /// </summary>
		public string Def10 {
            get { return getAttrVal<string>("Def10",null); }
            set { setAttrVal<string>("Def10", value); }
        }

        /// <summary>
        /// 客户拓展字段11
        /// </summary>
		public string Def11 {
            get { return getAttrVal<string>("Def11",null); }
            set { setAttrVal<string>("Def11", value); }
        }

        /// <summary>
        /// 客户拓展字段12
        /// </summary>
		public string Def12 {
            get { return getAttrVal<string>("Def12",null); }
            set { setAttrVal<string>("Def12", value); }
        }

        /// <summary>
        /// 客户拓展字段13
        /// </summary>
		public string Def13 {
            get { return getAttrVal<string>("Def13",null); }
            set { setAttrVal<string>("Def13", value); }
        }

        /// <summary>
        /// 客户拓展字段14
        /// </summary>
		public string Def14 {
            get { return getAttrVal<string>("Def14",null); }
            set { setAttrVal<string>("Def14", value); }
        }

        /// <summary>
        /// 客户拓展字段15
        /// </summary>
		public string Def15 {
            get { return getAttrVal<string>("Def15",null); }
            set { setAttrVal<string>("Def15", value); }
        }

        /// <summary>
        /// 客户拓展字段16
        /// </summary>
		public string Def16 {
            get { return getAttrVal<string>("Def16",null); }
            set { setAttrVal<string>("Def16", value); }
        }

        /// <summary>
        /// 客户拓展字段17
        /// </summary>
		public string Def17 {
            get { return getAttrVal<string>("Def17",null); }
            set { setAttrVal<string>("Def17", value); }
        }

        /// <summary>
        /// 客户拓展字段18
        /// </summary>
		public string Def18 {
            get { return getAttrVal<string>("Def18",null); }
            set { setAttrVal<string>("Def18", value); }
        }

        /// <summary>
        /// 客户拓展字段19
        /// </summary>
		public string Def19 {
            get { return getAttrVal<string>("Def19",null); }
            set { setAttrVal<string>("Def19", value); }
        }

        /// <summary>
        /// 客户拓展字段20
        /// </summary>
		public string Def20 {
            get { return getAttrVal<string>("Def20",null); }
            set { setAttrVal<string>("Def20", value); }
        }

        /// <summary>
        /// 客户拓展字段21
        /// </summary>
		public string Def21 {
            get { return getAttrVal<string>("Def21",null); }
            set { setAttrVal<string>("Def21", value); }
        }

        /// <summary>
        /// 客户拓展字段22
        /// </summary>
		public string Def22 {
            get { return getAttrVal<string>("Def22",null); }
            set { setAttrVal<string>("Def22", value); }
        }

        /// <summary>
        /// 客户拓展字段23
        /// </summary>
		public string Def23 {
            get { return getAttrVal<string>("Def23",null); }
            set { setAttrVal<string>("Def23", value); }
        }

        /// <summary>
        /// 客户拓展字段24
        /// </summary>
		public string Def24 {
            get { return getAttrVal<string>("Def24",null); }
            set { setAttrVal<string>("Def24", value); }
        }

        /// <summary>
        /// 客户拓展字段25
        /// </summary>
		public string Def25 {
            get { return getAttrVal<string>("Def25",null); }
            set { setAttrVal<string>("Def25", value); }
        }

        /// <summary>
        /// 客户拓展字段26
        /// </summary>
		public string Def26 {
            get { return getAttrVal<string>("Def26",null); }
            set { setAttrVal<string>("Def26", value); }
        }

        /// <summary>
        /// 客户拓展字段27
        /// </summary>
		public string Def27 {
            get { return getAttrVal<string>("Def27",null); }
            set { setAttrVal<string>("Def27", value); }
        }

        /// <summary>
        /// 客户拓展字段28
        /// </summary>
		public string Def28 {
            get { return getAttrVal<string>("Def28",null); }
            set { setAttrVal<string>("Def28", value); }
        }

        /// <summary>
        /// 客户拓展字段29
        /// </summary>
		public string Def29 {
            get { return getAttrVal<string>("Def29",null); }
            set { setAttrVal<string>("Def29", value); }
        }

        /// <summary>
        /// 客户拓展字段304
        /// </summary>
		public string Def30 {
            get { return getAttrVal<string>("Def30",null); }
            set { setAttrVal<string>("Def30", value); }
        }

        /// <summary>
        /// 客户拓展字段31
        /// </summary>
		public string Def31 {
            get { return getAttrVal<string>("Def31",null); }
            set { setAttrVal<string>("Def31", value); }
        }

        /// <summary>
        /// 客户拓展字段32
        /// </summary>
		public string Def32 {
            get { return getAttrVal<string>("Def32",null); }
            set { setAttrVal<string>("Def32", value); }
        }

        /// <summary>
        /// 客户拓展字段33
        /// </summary>
		public string Def33 {
            get { return getAttrVal<string>("Def33",null); }
            set { setAttrVal<string>("Def33", value); }
        }

        /// <summary>
        /// 客户拓展字段34
        /// </summary>
		public string Def34 {
            get { return getAttrVal<string>("Def34",null); }
            set { setAttrVal<string>("Def34", value); }
        }

        /// <summary>
        /// 客户拓展字段35
        /// </summary>
		public string Def35 {
            get { return getAttrVal<string>("Def35",null); }
            set { setAttrVal<string>("Def35", value); }
        }

        /// <summary>
        /// 客户拓展字段36
        /// </summary>
		public string Def36 {
            get { return getAttrVal<string>("Def36",null); }
            set { setAttrVal<string>("Def36", value); }
        }

        /// <summary>
        /// 客户拓展字段37
        /// </summary>
		public string Def37 {
            get { return getAttrVal<string>("Def37",null); }
            set { setAttrVal<string>("Def37", value); }
        }

        /// <summary>
        /// 客户拓展字段38
        /// </summary>
		public string Def38 {
            get { return getAttrVal<string>("Def38",null); }
            set { setAttrVal<string>("Def38", value); }
        }

        /// <summary>
        /// 客户拓展字段39
        /// </summary>
		public string Def39 {
            get { return getAttrVal<string>("Def39",null); }
            set { setAttrVal<string>("Def39", value); }
        }

        /// <summary>
        /// 客户拓展字段40
        /// </summary>
		public string Def40 {
            get { return getAttrVal<string>("Def40",null); }
            set { setAttrVal<string>("Def40", value); }
        }

        /// <summary>
        /// 客户拓展字段41
        /// </summary>
		public string Def41 {
            get { return getAttrVal<string>("Def41",null); }
            set { setAttrVal<string>("Def41", value); }
        }

        /// <summary>
        /// 客户拓展字段42
        /// </summary>
		public string Def42 {
            get { return getAttrVal<string>("Def42",null); }
            set { setAttrVal<string>("Def42", value); }
        }

        /// <summary>
        /// 客户拓展字段43
        /// </summary>
		public string Def43 {
            get { return getAttrVal<string>("Def43",null); }
            set { setAttrVal<string>("Def43", value); }
        }

        /// <summary>
        /// 客户拓展字段44
        /// </summary>
		public string Def44 {
            get { return getAttrVal<string>("Def44",null); }
            set { setAttrVal<string>("Def44", value); }
        }

        /// <summary>
        /// 客户拓展字段45
        /// </summary>
		public string Def45 {
            get { return getAttrVal<string>("Def45",null); }
            set { setAttrVal<string>("Def45", value); }
        }

        /// <summary>
        /// 客户拓展字段46
        /// </summary>
		public string Def46 {
            get { return getAttrVal<string>("Def46",null); }
            set { setAttrVal<string>("Def46", value); }
        }

        /// <summary>
        /// 客户拓展字段47
        /// </summary>
		public string Def47 {
            get { return getAttrVal<string>("Def47",null); }
            set { setAttrVal<string>("Def47", value); }
        }

        /// <summary>
        /// 客户拓展字段48
        /// </summary>
		public string Def48 {
            get { return getAttrVal<string>("Def48",null); }
            set { setAttrVal<string>("Def48", value); }
        }

        /// <summary>
        /// 客户拓展字段49
        /// </summary>
		public string Def49 {
            get { return getAttrVal<string>("Def49",null); }
            set { setAttrVal<string>("Def49", value); }
        }

        /// <summary>
        /// 客户拓展字段50
        /// </summary>
		public string Def50 {
            get { return getAttrVal<string>("Def50",null); }
            set { setAttrVal<string>("Def50", value); }
        }

        /// <summary>
        /// 临床症状及体征
        /// </summary>
		public string Clinicalzztz {
            get { return getAttrVal<string>("Clinicalzztz",null); }
            set { setAttrVal<string>("Clinicalzztz", value); }
        }

        /// <summary>
        /// 既往病史
        /// </summary>
		public string Pastillness {
            get { return getAttrVal<string>("Pastillness",null); }
            set { setAttrVal<string>("Pastillness", value); }
        }

        /// <summary>
        /// 其他检查所见
        /// </summary>
		public string Auximtexam {
            get { return getAttrVal<string>("Auximtexam",null); }
            set { setAttrVal<string>("Auximtexam", value); }
        }

        /// <summary>
        /// 标本采集
        /// </summary>
		public string Id_sampcoltime {
            get { return getAttrVal<string>("Id_sampcoltime",null); }
            set { setAttrVal<string>("Id_sampcoltime", value); }
        }

        /// <summary>
        /// 标本采集时长
        /// </summary>
		public FDouble Len_sampcoltime {
            get { return getAttrVal<FDouble>("Len_sampcoltime",null); }
            set { setAttrVal<FDouble>("Len_sampcoltime", value); }
        }

        /// <summary>
        /// 时长单位
        /// </summary>
		public string Id_unit_sampcoltime {
            get { return getAttrVal<string>("Id_unit_sampcoltime",null); }
            set { setAttrVal<string>("Id_unit_sampcoltime", value); }
        }

        /// <summary>
        /// 标本采集时间类型采集时间类型
        /// </summary>
		public string Id_sampcollecttimetp {
            get { return getAttrVal<string>("Id_sampcollecttimetp",null); }
            set { setAttrVal<string>("Id_sampcollecttimetp", value); }
        }

        /// <summary>
        /// 采集时间编码
        /// </summary>
		public string Sd_sampcollecttimetp {
            get { return getAttrVal<string>("Sd_sampcollecttimetp",null); }
            set { setAttrVal<string>("Sd_sampcollecttimetp", value); }
        }

        /// <summary>
        /// 标本采集时间名称
        /// </summary>
		public string Name_sampcoltime {
            get { return getAttrVal<string>("Name_sampcoltime",null); }
            set { setAttrVal<string>("Name_sampcoltime", value); }
        }

        /// <summary>
        /// 采集时长名称
        /// </summary>
		public string Name_len_sampcoltime {
            get { return getAttrVal<string>("Name_len_sampcoltime",null); }
            set { setAttrVal<string>("Name_len_sampcoltime", value); }
        }

        /// <summary>
        /// 采集时间类型名称
        /// </summary>
		public string Name_sampcollecttimetp {
            get { return getAttrVal<string>("Name_sampcollecttimetp",null); }
            set { setAttrVal<string>("Name_sampcollecttimetp", value); }
        }

        /// <summary>
        /// 时长单位名称
        /// </summary>
		public string Name_unit_sampcoltime {
            get { return getAttrVal<string>("Name_unit_sampcoltime",null); }
            set { setAttrVal<string>("Name_unit_sampcoltime", value); }
        }

        /// <summary>
        /// 药品列表
        /// </summary>
        public FArrayList EmsOrDrugListEx
        {
            get { return getAttrVal<FArrayList>("EmsOrDrugListEx", null); }
            set { setAttrVal<FArrayList>("EmsOrDrugListEx", value); }
        }

        /// <summary>
        /// 检验检查子项列表
        /// </summary>
        public FArrayList EmsOrObsListEx
        {
            get { return getAttrVal<FArrayList>("EmsOrObsListEx", null); }
            set { setAttrVal<FArrayList>("EmsOrObsListEx", value); }
        }

        /// <summary>
        /// 
        /// </summary>
        public string Id_primd
        {
            get { return getAttrVal<string>("Id_primd", null); }
            set { setAttrVal<string>("Id_primd", value); }
        }

        /// <summary>
        /// 
        /// </summary>
        public bool? Fg_set
        {
            get { return getAttrVal<FBoolean>("Fg_set", null); }
            set { setAttrVal<FBoolean>("Fg_set", value); }
        }
        /////////添加检验、检查、诊疗多剂量多次执行，杨敬本20171111
        /// <summary>
        /// 剂量单位id
        /// </summary>
		public string Id_unit_med 
        {
            get { return getAttrVal<string>("Id_unit_med",null); }
            set { setAttrVal<string>("Id_unit_med", value); }
        }

        /// <summary>
        /// 剂量单位名称
        /// </summary>
		public string Name_unit_med 
        {
            get { return getAttrVal<string>("Name_unit_med",null); }
            set { setAttrVal<string>("Name_unit_med", value); }
        }

        /// <summary>
        /// 剂量
        /// </summary>
		public FDouble Quan_med 
        {
            get { return getAttrVal<FDouble>("Quan_med",null); }
            set { setAttrVal<FDouble>("Quan_med", value); }
        }
        /////////添加检验、检查、诊疗多剂量多次执行，杨敬本20171111
        /// <summary>
        /// 服务类型编码
        /// </summary>
		public string Sd_srvtp 
        {
            get { return getAttrVal<string>("Sd_srvtp",null); }
            set { setAttrVal<string>("Sd_srvtp", value); }
        }

        /// <summary>
        /// 自费标识
        /// </summary>
		public bool? Fg_selfpay 
        {
            get { return getAttrVal<FBoolean>("Fg_selfpay",null); }
            set { setAttrVal<FBoolean>("Fg_selfpay", value); }
        }
        /////////添加检验、检查、诊疗多剂量多次执行，杨敬本20171111
        /// <summary>
        /// 医嘱频次ID
        /// </summary>
		public string Id_freq 
        {
            get { return getAttrVal<string>("Id_freq",null); }
            set { setAttrVal<string>("Id_freq", value); }
        }

        /// <summary>
        /// 医嘱频次名称
        /// </summary>
		public string Name_freq 
        {
            get { return getAttrVal<string>("Name_freq",null); }
            set { setAttrVal<string>("Name_freq", value); }
        }

        /// <summary>
        /// 频次下频次数
        /// </summary>
		public int? Freqct 
        {
            get { return getAttrVal<int?>("Freqct",null); }
            set { setAttrVal<int?>("Freqct", value); }
        }

        /// <summary>
        /// 频次周期类型
        /// </summary>
        public string Sd_frequnitct
        {
            get { return getAttrVal<string>("Sd_frequnitct", null); }
            set { setAttrVal<string>("Sd_frequnitct", value); }
        }

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
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[] { "Id_diitm", "Str_id_diitm", "Str_name_di", "Str_code_di", "Name_diag", "Id_di", "Id_emsobs", "Id_orsrv", "Id_or", "Id_srv", "Name_srv", "Id_srvtp", "Name_srvtp", "Id_obstp", "Name_obstp", "No_applyobs", "Fg_urgent", "Fg_mp_bed", "Dt_plan", "Sd_pps", "Id_pps", "Name_pps", "Des_pps", "Des_sympsign", "Id_body", "Sd_body", "Name_body", "Id_su_obs", "Sd_su_obs", "Id_pos", "Sd_pos", "Name_pos", "Id_samptp", "Name_samptp", "Sd_samptp", "Sortno", "Fg_chk", "Announcements", "Sv", "Id_srvca", "Sd_colltp", "Id_colltp", "Des_labsamp", "Use_days", "Id_mp_dep", "Name_mp_dep", "Price", "Quan_cur", "Id_unit_sale", "Name_unit_sale", "Fg_indic", "Id_unit_base", "Name_unit_base", "Quan_base", "Innercode_srvca", "Fg_syncfee", "Def1", "Def2", "Def3", "Def4", "Def5", "Def6", "Def7", "Def8", "Def9", "Def10", "Def11", "Def12", "Def13", "Def14", "Def15", "Def16", "Def17", "Def18", "Def19", "Def20", "Def21", "Def22", "Def23", "Def24", "Def25", "Def26", "Def27", "Def28", "Def29", "Def30", "Def31", "Def32", "Def33", "Def34", "Def35", "Def36", "Def37", "Def38", "Def39", "Def40", "Def41", "Def42", "Def43", "Def44", "Def45", "Def46", "Def47", "Def48", "Def49", "Def50", "Clinicalzztz", "Pastillness", "Auximtexam", "Id_sampcoltime", "Len_sampcoltime", "Id_unit_sampcoltime", "Id_sampcollecttimetp", "Sd_sampcollecttimetp", "Name_sampcoltime", "Name_len_sampcoltime", "Name_sampcollecttimetp", "Name_unit_sampcoltime", "Id_unit_med", "Name_unit_med", "Quan_med", "Sd_srvtp", "Fg_selfpay", "Id_freq", "Name_freq", "Freqct", "Sd_frequnitct", 
                "Ismulexec",
                "Ismuldose" 
            };/////////添加检验、检查、诊疗多剂量多次执行，杨敬本20171111
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.ciordems.d.EmsObsItemDO";
        }
    }
}
