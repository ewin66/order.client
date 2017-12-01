using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using xap.rui.appfw;
using iih.ci.iih.ci.ord.ciordems.d;

namespace iih.ci.ord.ciordems.d
{
    /// <summary>
    /// EmsConsItemDO 的摘要说明。
    /// </summary>
    public class EmsConsItemDO : OrCommonFieldsDTO{

        public EmsConsItemDO() {
 
        }

        /// <summary>
        /// 诊断id拼接
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
        /// 诊断子项目id
        /// </summary>
		public string Id_diitm {
            get { return getAttrVal<string>("Id_diitm",null); }
            set { setAttrVal<string>("Id_diitm", value); }
        }

        /// <summary>
        /// 诊断ID
        /// </summary>
		public string Id_di {
            get { return getAttrVal<string>("Id_di",null); }
            set { setAttrVal<string>("Id_di", value); }
        }

        /// <summary>
        /// 诊断名称
        /// </summary>
		public string Name_diag {
            get { return getAttrVal<string>("Name_diag",null); }
            set { setAttrVal<string>("Name_diag", value); }
        }

        /// <summary>
        /// 主键
        /// </summary>
		public string Id_emsconsitem {
            get { return getAttrVal<string>("Id_emsconsitem",null); }
            set { setAttrVal<string>("Id_emsconsitem", value); }
        }

        /// <summary>
        /// 医嘱id
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
        /// 医嘱服务id
        /// </summary>
		public string Id_orsrv {
            get { return getAttrVal<string>("Id_orsrv",null); }
            set { setAttrVal<string>("Id_orsrv", value); }
        }

        /// <summary>
        /// 加急标识
        /// </summary>
		public bool? Fg_urgent {
            get { return getAttrVal<FBoolean>("Fg_urgent",null); }
            set { setAttrVal<FBoolean>("Fg_urgent", value); }
        }

        /// <summary>
        /// 计划会诊时间
        /// </summary>
		public DateTime? Dt_plan {
            get { return getAttrVal<FDateTime>("Dt_plan",null); }
            set { setAttrVal<FDateTime>("Dt_plan", value); }
        }

        /// <summary>
        /// 联系电话
        /// </summary>
		public string Tel {
            get { return getAttrVal<string>("Tel",null); }
            set { setAttrVal<string>("Tel", value); }
        }

        /// <summary>
        /// 申请地点id
        /// </summary>
		public string Id_place {
            get { return getAttrVal<string>("Id_place",null); }
            set { setAttrVal<string>("Id_place", value); }
        }

        /// <summary>
        /// 申请地点名称
        /// </summary>
		public string Name_place {
            get { return getAttrVal<string>("Name_place",null); }
            set { setAttrVal<string>("Name_place", value); }
        }

        /// <summary>
        /// 病理摘要
        /// </summary>
		public string Des_emr {
            get { return getAttrVal<string>("Des_emr",null); }
            set { setAttrVal<string>("Des_emr", value); }
        }

        /// <summary>
        /// 会诊目的
        /// </summary>
		public string Des_psp {
            get { return getAttrVal<string>("Des_psp",null); }
            set { setAttrVal<string>("Des_psp", value); }
        }

        /// <summary>
        /// 申请科室id
        /// </summary>
		public string Id_dep_cons {
            get { return getAttrVal<string>("Id_dep_cons",null); }
            set { setAttrVal<string>("Id_dep_cons", value); }
        }

        /// <summary>
        /// 申请科室
        /// </summary>
		public string Name_dep_cons {
            get { return getAttrVal<string>("Name_dep_cons",null); }
            set { setAttrVal<string>("Name_dep_cons", value); }
        }

        /// <summary>
        /// 申请时间
        /// </summary>
		public DateTime? Dt_creat {
            get { return getAttrVal<FDateTime>("Dt_creat",null); }
            set { setAttrVal<FDateTime>("Dt_creat", value); }
        }

        /// <summary>
        /// 申请人id
        /// </summary>
		public string Id_emp_cons {
            get { return getAttrVal<string>("Id_emp_cons",null); }
            set { setAttrVal<string>("Id_emp_cons", value); }
        }

        /// <summary>
        /// 申请人
        /// </summary>
		public string Name_emp_cons {
            get { return getAttrVal<string>("Name_emp_cons",null); }
            set { setAttrVal<string>("Name_emp_cons", value); }
        }

        /// <summary>
        /// 会诊类型id
        /// </summary>
		public string Id_constp {
            get { return getAttrVal<string>("Id_constp",null); }
            set { setAttrVal<string>("Id_constp", value); }
        }

        /// <summary>
        /// 会诊类型
        /// </summary>
		public string Name_constp {
            get { return getAttrVal<string>("Name_constp",null); }
            set { setAttrVal<string>("Name_constp", value); }
        }

        /// <summary>
        /// 会诊类型编码
        /// </summary>
		public string Sd_constp {
            get { return getAttrVal<string>("Sd_constp",null); }
            set { setAttrVal<string>("Sd_constp", value); }
        }

        /// <summary>
        /// 会诊申请状态id
        /// </summary>
		public string Id_su_cons {
            get { return getAttrVal<string>("Id_su_cons",null); }
            set { setAttrVal<string>("Id_su_cons", value); }
        }

        /// <summary>
        /// 会诊申请状态
        /// </summary>
		public string Name_su_cons {
            get { return getAttrVal<string>("Name_su_cons",null); }
            set { setAttrVal<string>("Name_su_cons", value); }
        }

        /// <summary>
        /// 会诊申请状态编码
        /// </summary>
		public string Sd_su_cons {
            get { return getAttrVal<string>("Sd_su_cons",null); }
            set { setAttrVal<string>("Sd_su_cons", value); }
        }

        /// <summary>
        /// 床号
        /// </summary>
		public string Bed_no {
            get { return getAttrVal<string>("Bed_no",null); }
            set { setAttrVal<string>("Bed_no", value); }
        }

        /// <summary>
        /// 姓名
        /// </summary>
		public string Name_pat {
            get { return getAttrVal<string>("Name_pat",null); }
            set { setAttrVal<string>("Name_pat", value); }
        }

        /// <summary>
        /// 加急状态
        /// </summary>
		public string Str_urgent {
            get { return getAttrVal<string>("Str_urgent",null); }
            set { setAttrVal<string>("Str_urgent", value); }
        }

        /// <summary>
        /// 医务部意见
        /// </summary>
		public string Des_dep {
            get { return getAttrVal<string>("Des_dep",null); }
            set { setAttrVal<string>("Des_dep", value); }
        }

        /// <summary>
        /// 会诊主持人id
        /// </summary>
		public string Id_emp_host {
            get { return getAttrVal<string>("Id_emp_host",null); }
            set { setAttrVal<string>("Id_emp_host", value); }
        }

        /// <summary>
        /// 会诊主持人
        /// </summary>
		public string Name_emp_host {
            get { return getAttrVal<string>("Name_emp_host",null); }
            set { setAttrVal<string>("Name_emp_host", value); }
        }

        /// <summary>
        /// 会诊记录
        /// </summary>
		public string Advice {
            get { return getAttrVal<string>("Advice",null); }
            set { setAttrVal<string>("Advice", value); }
        }

        /// <summary>
        /// 会诊申请单号
        /// </summary>
		public string No_applyform {
            get { return getAttrVal<string>("No_applyform",null); }
            set { setAttrVal<string>("No_applyform", value); }
        }
        /// <summary>
        /// 会诊项目
        /// </summary>
        public XapDataList<EmsItemInCons> EmsConsItem
        {
            get { return getAttrVal<XapDataList<EmsItemInCons>>("EmsConsItem", null); }
            set { setAttrVal<XapDataList<EmsItemInCons>>("EmsConsItem", value); }
        }
        /// <summary>
        /// 协诊方
        /// </summary>
        public XapDataList<EmsItemInCons> EmsConsAssistItem
        {
            get { return getAttrVal<XapDataList<EmsItemInCons>>("EmsConsAssistItem", null); }
            set { setAttrVal<XapDataList<EmsItemInCons>>("EmsConsAssistItem", value); }
        }
        /// <summary>
        /// 受邀科室
        /// </summary>
		public string Id_dep_emp {
            get { return getAttrVal<string>("Id_dep_emp",null); }
            set { setAttrVal<string>("Id_dep_emp", value); }
        }

        /// <summary>
        /// 受邀科室名称
        /// </summary>
		public string Name_dep_emp {
            get { return getAttrVal<string>("Name_dep_emp",null); }
            set { setAttrVal<string>("Name_dep_emp", value); }
        }

        /// <summary>
        /// 受邀人
        /// </summary>
		public string Id_emp_doctor {
            get { return getAttrVal<string>("Id_emp_doctor",null); }
            set { setAttrVal<string>("Id_emp_doctor", value); }
        }

        /// <summary>
        /// 受邀人名称
        /// </summary>
		public string Name_emp_doctor {
            get { return getAttrVal<string>("Name_emp_doctor",null); }
            set { setAttrVal<string>("Name_emp_doctor", value); }
        }

        /// <summary>
        /// 参考价格
        /// </summary>
		public FDouble Price {
            get { return getAttrVal<FDouble>("Price",null); }
            set { setAttrVal<FDouble>("Price", value); }
        }
        /// <summary>
        /// 受邀方
        /// </summary>
        public string Dep_doctor
        {
            get { return getAttrVal<string>("Dep_doctor", null); }
            set { setAttrVal<string>("Dep_doctor", value); }
        }

        /// <summary>
        /// 院内外标志
        /// </summary>
        public bool? Fg_inorg
        {
            get { return getAttrVal<FBoolean>("Fg_inorg", null); }
            set { setAttrVal<FBoolean>("Fg_inorg", value); }
        }

        /// <summary>
        /// 多科会诊标志
        /// </summary>
        public bool? Fg_deps
        {
            get { return getAttrVal<FBoolean>("Fg_deps", null); }
            set { setAttrVal<FBoolean>("Fg_deps", value); }
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
        /// 医嘱来源
        /// </summary>
		public int? Eu_sourcemd {
            get { return getAttrVal<int?>("Eu_sourcemd",null); }
            set { setAttrVal<int?>("Eu_sourcemd", value); }
        }

        /// <summary>
        /// 所属服务
        /// </summary>
		public string Id_srv_src {
            get { return getAttrVal<string>("Id_srv_src",null); }
            set { setAttrVal<string>("Id_srv_src", value); }
        }

        /// <summary>
        /// 加价方式
        /// </summary>
		public string Priby {
            get { return getAttrVal<string>("Priby",null); }
            set { setAttrVal<string>("Priby", value); }
        }

        public FArrayList ConsAssList
        {
            get { return getAttrVal<FArrayList>("ConsAssList", null); }
            set { setAttrVal<FArrayList>("ConsAssList", value); }
        }
        public FArrayList ConsItemList
        {
            get { return getAttrVal<FArrayList>("ConsItemList", null); }
            set { setAttrVal<FArrayList>("ConsItemList", value); }
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
            return new string[] { "Str_id_diitm", "Str_name_di", "Str_code_di", "Id_diitm", "Id_di", "Name_diag", "Id_emsconsitem", "Id_or", "Id_srv", "Name_srv", "Id_orsrv", "Fg_urgent", "Dt_plan", "Tel", "Id_place", "Name_place", "Des_emr", "Des_psp", "Id_dep_cons", "Name_dep_cons", "Dt_creat", "Id_emp_cons", "Name_emp_cons", "Id_constp", "Name_constp", "Sd_constp", "Id_su_cons", "Name_su_cons", "Sd_su_cons", "Bed_no", "Name_pat", "Str_urgent", "Des_dep", "Id_emp_host", "Name_emp_host", "Advice", "No_applyform", "Id_dep_emp", "Name_dep_emp", "Id_emp_doctor", "Name_emp_doctor", "Price", "Innercode_srvca", "Fg_syncfee", "Eu_sourcemd", "Id_srv_src", "Priby", "Sd_srvtp", "Fg_selfpay", "Eu_blmd" };
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.ciordems.d.EmsConsItemDO";
        }
    }
}
