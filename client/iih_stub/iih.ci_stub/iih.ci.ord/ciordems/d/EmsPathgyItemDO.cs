using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using xap.rui.appfw;
using iih.ci.iih.ci.ord.ciordems.d;

namespace iih.ci.ord.ciordems.d
{
    /// <summary>
    /// EmsPathgyItemDO 的摘要说明。
    /// </summary>
    public class EmsPathgyItemDO : OrCommonFieldsDTO {

        public EmsPathgyItemDO() {
 
        }

        /// <summary>
        /// 诊断子项id
        /// </summary>
		public string Id_diitm {
            get { return getAttrVal<string>("Id_diitm",null); }
            set { setAttrVal<string>("Id_diitm", value); }
        }

        /// <summary>
        /// 诊断编码拼接
        /// </summary>
		public string Str_code_di {
            get { return getAttrVal<string>("Str_code_di",null); }
            set { setAttrVal<string>("Str_code_di", value); }
        }

        /// <summary>
        /// 诊断idi拼接字符串
        /// </summary>
		public string Str_id_diitm {
            get { return getAttrVal<string>("Str_id_diitm",null); }
            set { setAttrVal<string>("Str_id_diitm", value); }
        }

        /// <summary>
        /// 诊断名字拼接字符串
        /// </summary>
		public string Str_name_di {
            get { return getAttrVal<string>("Str_name_di",null); }
            set { setAttrVal<string>("Str_name_di", value); }
        }

        /// <summary>
        /// 诊断
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
        /// 主键
        /// </summary>
		public string Id_ordpathgyitem {
            get { return getAttrVal<string>("Id_ordpathgyitem",null); }
            set { setAttrVal<string>("Id_ordpathgyitem", value); }
        }

        /// <summary>
        /// 医嘱id
        /// </summary>
		public string Id_or {
            get { return getAttrVal<string>("Id_or",null); }
            set { setAttrVal<string>("Id_or", value); }
        }

        /// <summary>
        /// 医嘱服务id
        /// </summary>
		public string Id_orsrv {
            get { return getAttrVal<string>("Id_orsrv",null); }
            set { setAttrVal<string>("Id_orsrv", value); }
        }

        /// <summary>
        /// 服务id
        /// </summary>
		public string Id_srv {
            get { return getAttrVal<string>("Id_srv",null); }
            set { setAttrVal<string>("Id_srv", value); }
        }

        /// <summary>
        /// 病理项目
        /// </summary>
		public string Name_srv {
            get { return getAttrVal<string>("Name_srv",null); }
            set { setAttrVal<string>("Name_srv", value); }
        }

        /// <summary>
        /// 标本类型id
        /// </summary>
		public string Id_samptp {
            get { return getAttrVal<string>("Id_samptp",null); }
            set { setAttrVal<string>("Id_samptp", value); }
        }

        /// <summary>
        /// 标本类型编码
        /// </summary>
		public string Sd_samptp {
            get { return getAttrVal<string>("Sd_samptp",null); }
            set { setAttrVal<string>("Sd_samptp", value); }
        }

        /// <summary>
        /// 标本类型
        /// </summary>
		public string Name_samptp {
            get { return getAttrVal<string>("Name_samptp",null); }
            set { setAttrVal<string>("Name_samptp", value); }
        }

        /// <summary>
        /// 加急标识
        /// </summary>
		public bool? Fg_urgent {
            get { return getAttrVal<FBoolean>("Fg_urgent",null); }
            set { setAttrVal<FBoolean>("Fg_urgent", value); }
        }

        /// <summary>
        /// 检查要求
        /// </summary>
		public string Announcements {
            get { return getAttrVal<string>("Announcements",null); }
            set { setAttrVal<string>("Announcements", value); }
        }

        /// <summary>
        /// 病情描述
        /// </summary>
		public string Des_sympsign {
            get { return getAttrVal<string>("Des_sympsign",null); }
            set { setAttrVal<string>("Des_sympsign", value); }
        }

        /// <summary>
        /// 申请单号
        /// </summary>
		public string No_applyform {
            get { return getAttrVal<string>("No_applyform",null); }
            set { setAttrVal<string>("No_applyform", value); }
        }

        /// <summary>
        /// 申请时间
        /// </summary>
		public DateTime? Dt_create {
            get { return getAttrVal<FDateTime>("Dt_create",null); }
            set { setAttrVal<FDateTime>("Dt_create", value); }
        }

        /// <summary>
        /// 申请医生id
        /// </summary>
		public string Id_emp_create {
            get { return getAttrVal<string>("Id_emp_create",null); }
            set { setAttrVal<string>("Id_emp_create", value); }
        }

        /// <summary>
        /// 申请医师
        /// </summary>
		public string Name_emp_create {
            get { return getAttrVal<string>("Name_emp_create",null); }
            set { setAttrVal<string>("Name_emp_create", value); }
        }

        /// <summary>
        /// 采集所见
        /// </summary>
		public string Collectdes {
            get { return getAttrVal<string>("Collectdes",null); }
            set { setAttrVal<string>("Collectdes", value); }
        }

        /// <summary>
        /// 采集者id
        /// </summary>
		public string Id_emp_coll {
            get { return getAttrVal<string>("Id_emp_coll",null); }
            set { setAttrVal<string>("Id_emp_coll", value); }
        }

        /// <summary>
        /// 采集者
        /// </summary>
		public string Name_emp_coll {
            get { return getAttrVal<string>("Name_emp_coll",null); }
            set { setAttrVal<string>("Name_emp_coll", value); }
        }

        /// <summary>
        /// 采集时间
        /// </summary>
		public DateTime? Dt_coll {
            get { return getAttrVal<FDateTime>("Dt_coll",null); }
            set { setAttrVal<FDateTime>("Dt_coll", value); }
        }

        /// <summary>
        /// 外院标志
        /// </summary>
		public bool? Fg_outer {
            get { return getAttrVal<FBoolean>("Fg_outer",null); }
            set { setAttrVal<FBoolean>("Fg_outer", value); }
        }

        /// <summary>
        /// 既往病理医院
        /// </summary>
		public string Org_pathgy_old {
            get { return getAttrVal<string>("Org_pathgy_old",null); }
            set { setAttrVal<string>("Org_pathgy_old", value); }
        }

        /// <summary>
        /// 既往病理日期
        /// </summary>
		public DateTime? Dt_pathgy_old {
            get { return getAttrVal<FDateTime>("Dt_pathgy_old",null); }
            set { setAttrVal<FDateTime>("Dt_pathgy_old", value); }
        }

        /// <summary>
        /// 既往病理号
        /// </summary>
		public string No_pathgy_old {
            get { return getAttrVal<string>("No_pathgy_old",null); }
            set { setAttrVal<string>("No_pathgy_old", value); }
        }

        /// <summary>
        /// 既往病理诊断id
        /// </summary>
		public string Id_di_pathgy_old {
            get { return getAttrVal<string>("Id_di_pathgy_old",null); }
            set { setAttrVal<string>("Id_di_pathgy_old", value); }
        }

        /// <summary>
        /// 既往病理诊断
        /// </summary>
		public string Name_di_pathgy_old {
            get { return getAttrVal<string>("Name_di_pathgy_old",null); }
            set { setAttrVal<string>("Name_di_pathgy_old", value); }
        }

        /// <summary>
        /// 标本采集科室id
        /// </summary>
		public string Id_dep_coll {
            get { return getAttrVal<string>("Id_dep_coll",null); }
            set { setAttrVal<string>("Id_dep_coll", value); }
        }

        /// <summary>
        /// 标本采集科室
        /// </summary>
		public string Name_dep_coll {
            get { return getAttrVal<string>("Name_dep_coll",null); }
            set { setAttrVal<string>("Name_dep_coll", value); }
        }

        /// <summary>
        /// 病理号
        /// </summary>
		public string No_pathgy {
            get { return getAttrVal<string>("No_pathgy",null); }
            set { setAttrVal<string>("No_pathgy", value); }
        }

        /// <summary>
        /// 报告发布时间
        /// </summary>
		public DateTime? Dt_rptpathgy {
            get { return getAttrVal<FDateTime>("Dt_rptpathgy",null); }
            set { setAttrVal<FDateTime>("Dt_rptpathgy", value); }
        }

        /// <summary>
        /// 版本号
        /// </summary>
		public DateTime? Sv {
            get { return getAttrVal<FDateTime>("Sv",null); }
            set { setAttrVal<FDateTime>("Sv", value); }
        }

        /// 标本
        /// </summary>
        public XapDataList<EmsItemInPathgy> EmsItemInpathgy
        {
            get { return getAttrVal<XapDataList<EmsItemInPathgy>>("EmsItemInpathgy", null); }
            set { setAttrVal<XapDataList<EmsItemInPathgy>>("EmsItemInpathgy", value); }
        }

        /// <summary>
        /// 标本数量
        /// </summary>
		public int? Quan {
            get { return getAttrVal<int?>("Quan",null); }
            set { setAttrVal<int?>("Quan", value); }
        }

        /// <summary>
        /// 采集方法
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
        /// 采集方法名称
        /// </summary>
		public string Name_colltp {
            get { return getAttrVal<string>("Name_colltp",null); }
            set { setAttrVal<string>("Name_colltp", value); }
        }

        /// <summary>
        /// 标本说明
        /// </summary>
		public string Des_labsamp {
            get { return getAttrVal<string>("Des_labsamp",null); }
            set { setAttrVal<string>("Des_labsamp", value); }
        }

        /// <summary>
        /// 参考价格
        /// </summary>
		public FDouble Price {
            get { return getAttrVal<FDouble>("Price",null); }
            set { setAttrVal<FDouble>("Price", value); }
        }

        /// <summary>
        /// 费用同步编码
        /// </summary>
		public bool? Fg_syncfee {
            get { return getAttrVal<FBoolean>("Fg_syncfee",null); }
            set { setAttrVal<FBoolean>("Fg_syncfee", value); }
        }

        /// <summary>
        /// 服务分类内部编码
        /// </summary>
		public string Innercode_srvca {
            get { return getAttrVal<string>("Innercode_srvca",null); }
            set { setAttrVal<string>("Innercode_srvca", value); }
        }

        /// <summary>
        /// 执行科室id
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
        /// 标本集合
        /// </summary>
		public FArrayList EmsItemInpathgyList
        {
            get { return getAttrVal<FArrayList>("EmsItemInpathgyList", null); }
            set { setAttrVal<FArrayList>("EmsItemInpathgyList", value); }
        }

        /// <summary>
        /// 服务类型编码
        /// </summary>
		public string Sd_srvtp
        {
            get { return getAttrVal<string>("Sd_srvtp", null); }
            set { setAttrVal<string>("Sd_srvtp", value); }
        }
        /// <summary>
        /// 自费标识
        /// </summary>
        public bool? Fg_selfpay
        {
            get { return getAttrVal<FBoolean>("Fg_selfpay", null); }
            set { setAttrVal<FBoolean>("Fg_selfpay", value); }
        }
        /// <summary>
        /// 记费模式
        /// </summary>
		public int? Eu_blmd
        {
            get { return getAttrVal<int?>("Eu_blmd", null); }
            set { setAttrVal<int?>("Eu_blmd", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[] { "Id_diitm", "Str_code_di", "Str_id_diitm", "Str_name_di", "Name_diag", "Id_di", "Id_ordpathgyitem", "Id_or", "Id_orsrv", "Id_srv", "Name_srv", "Id_samptp", "Sd_samptp", "Name_samptp", "Fg_urgent", "Announcements", "Des_sympsign", "No_applyform", "Dt_create", "Id_emp_create", "Name_emp_create", "Collectdes", "Id_emp_coll", "Name_emp_coll", "Dt_coll", "Fg_outer", "Org_pathgy_old", "Dt_pathgy_old", "No_pathgy_old", "Id_di_pathgy_old", "Name_di_pathgy_old", "Id_dep_coll", "Name_dep_coll", "No_pathgy", "Dt_rptpathgy", "Sv", "Quan", "Sd_colltp", "Id_colltp", "Name_colltp", "Des_labsamp", "Price", "Fg_syncfee", "Innercode_srvca", "Id_mp_dep", "Name_mp_dep", "Def1", "Def2", "Def3", "Def4", "Def5", "Def6", "Def7", "Def8", "Def9", "Def10", "Def11", "Def12", "Def13", "Def14", "Def15", "Def16", "Def17", "Def18", "Def19", "Def20", "Def21", "Def22", "Def23", "Def24", "Def25", "Def26", "Def27", "Def28", "Def29", "Def30", "Def31", "Def32", "Def33", "Def34", "Def35", "Def36", "Def37", "Def38", "Def39", "Def40", "Def41", "Def42", "Def43", "Def44", "Def45", "Def46", "Def47", "Def48", "Def49", "Def50", "Sd_srvtp", "Fg_selfpay", "Eu_blmd" };
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.ciordems.d.EmsPathgyItemDO";
        }
    }
}
