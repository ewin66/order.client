using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using xap.rui.appfw;
using iih.ci.ord.cior.d;
using iih.ci.iih.ci.ord.ciordems.d;

namespace iih.ci.ord.ciordems.d
{
    /// <summary>
    /// EmsBtItemDO 的摘要说明。
    /// </summary>
    public partial class EmsBtItemDO : OrCommonFieldsDTO
    {

        public EmsBtItemDO() {
 
        }

        /// <summary>
        /// 临床诊断id拼接
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
        /// 临床诊断名称
        /// </summary>
		public string Name_diag {
            get { return getAttrVal<string>("Name_diag",null); }
            set { setAttrVal<string>("Name_diag", value); }
        }

        /// <summary>
        /// 临床诊断id
        /// </summary>
		public string Id_di {
            get { return getAttrVal<string>("Id_di",null); }
            set { setAttrVal<string>("Id_di", value); }
        }

        /// <summary>
        /// 输血医疗单主键
        /// </summary>
		public string Id_emsbt {
            get { return getAttrVal<string>("Id_emsbt",null); }
            set { setAttrVal<string>("Id_emsbt", value); }
        }

        /// <summary>
        /// 服务id
        /// </summary>
		public string Id_srv {
            get { return getAttrVal<string>("Id_srv",null); }
            set { setAttrVal<string>("Id_srv", value); }
        }

        /// <summary>
        ///  输血成分(服务名称)
        /// </summary>
		public string Name_srv {
            get { return getAttrVal<string>("Name_srv",null); }
            set { setAttrVal<string>("Name_srv", value); }
        }

        public string Sd_srvtp
        {
            get { return getAttrVal<string>("Sd_srvtp", null); }
            set { setAttrVal<string>("Sd_srvtp", value); }
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
        /// 输血数量(医学单位数值)
        /// </summary>
		public FDouble Quan_med {
            get { return getAttrVal<FDouble>("Quan_med",null); }
            set { setAttrVal<FDouble>("Quan_med", value); }
        }

        /// <summary>
        /// 输血数量单位(医学单位)
        /// </summary>
		public string Id_unit_med {
            get { return getAttrVal<string>("Id_unit_med",null); }
            set { setAttrVal<string>("Id_unit_med", value); }
        }

        /// <summary>
        /// 医学单位名称
        /// </summary>
		public string Name_unit_med {
            get { return getAttrVal<string>("Name_unit_med",null); }
            set { setAttrVal<string>("Name_unit_med", value); }
        }

        /// <summary>
        /// 输血单号
        /// </summary>
		public string No_applyform {
            get { return getAttrVal<string>("No_applyform",null); }
            set { setAttrVal<string>("No_applyform", value); }
        }

        /// <summary>
        /// 产数量
        /// </summary>
		public int? Parturition_cnt {
            get { return getAttrVal<int?>("Parturition_cnt",null); }
            set { setAttrVal<int?>("Parturition_cnt", value); }
        }

        /// <summary>
        /// 输血目的编码
        /// </summary>
		public string Sd_pps {
            get { return getAttrVal<string>("Sd_pps",null); }
            set { setAttrVal<string>("Sd_pps", value); }
        }

        /// <summary>
        /// 输血目的id
        /// </summary>
		public string Id_pps {
            get { return getAttrVal<string>("Id_pps",null); }
            set { setAttrVal<string>("Id_pps", value); }
        }

        /// <summary>
        /// 输血目的
        /// </summary>
		public string Name_pps {
            get { return getAttrVal<string>("Name_pps",null); }
            set { setAttrVal<string>("Name_pps", value); }
        }

        /// <summary>
        /// 献血史标志
        /// </summary>
		public bool? Fg_db {
            get { return getAttrVal<FBoolean>("Fg_db",null); }
            set { setAttrVal<FBoolean>("Fg_db", value); }
        }

        /// <summary>
        /// 献血证号
        /// </summary>
		public string No_db {
            get { return getAttrVal<string>("No_db",null); }
            set { setAttrVal<string>("No_db", value); }
        }

        /// <summary>
        /// 预定输血方式id
        /// </summary>
		public string Id_mode {
            get { return getAttrVal<string>("Id_mode",null); }
            set { setAttrVal<string>("Id_mode", value); }
        }

        /// <summary>
        /// 预定输血方式sd
        /// </summary>
		public string Sd_mode {
            get { return getAttrVal<string>("Sd_mode",null); }
            set { setAttrVal<string>("Sd_mode", value); }
        }

        /// <summary>
        /// 预定输血方式
        /// </summary>
		public string Name_mode {
            get { return getAttrVal<string>("Name_mode",null); }
            set { setAttrVal<string>("Name_mode", value); }
        }

        /// <summary>
        /// 输血需求状态id
        /// </summary>
		public string Id_demandsu {
            get { return getAttrVal<string>("Id_demandsu",null); }
            set { setAttrVal<string>("Id_demandsu", value); }
        }

        /// <summary>
        /// 输血需求状态sd
        /// </summary>
		public string Sd_demandsu {
            get { return getAttrVal<string>("Sd_demandsu",null); }
            set { setAttrVal<string>("Sd_demandsu", value); }
        }

        /// <summary>
        /// 输血需求状态
        /// </summary>
		public string Name_demandsu {
            get { return getAttrVal<string>("Name_demandsu",null); }
            set { setAttrVal<string>("Name_demandsu", value); }
        }

        /// <summary>
        /// 孕几胎
        /// </summary>
		public int? Pregnat_num {
            get { return getAttrVal<int?>("Pregnat_num",null); }
            set { setAttrVal<int?>("Pregnat_num", value); }
        }

        /// <summary>
        /// 输血前检查说明id
        /// </summary>
		public string Id_labitmexplain {
            get { return getAttrVal<string>("Id_labitmexplain",null); }
            set { setAttrVal<string>("Id_labitmexplain", value); }
        }

        /// <summary>
        /// 输血前检查说明
        /// </summary>
		public string Name_labitmexplain {
            get { return getAttrVal<string>("Name_labitmexplain",null); }
            set { setAttrVal<string>("Name_labitmexplain", value); }
        }

        /// <summary>
        /// 输血前检测项目说明
        /// </summary>
		public string Sd_labitmexplain {
            get { return getAttrVal<string>("Sd_labitmexplain",null); }
            set { setAttrVal<string>("Sd_labitmexplain", value); }
        }

        /// <summary>
        /// 输血日期
        /// </summary>
		public DateTime? Dt_bt {
            get { return getAttrVal<FDateTime>("Dt_bt",null); }
            set { setAttrVal<FDateTime>("Dt_bt", value); }
        }

        /// <summary>
        /// 申请医生id
        /// </summary>
		public string Id_emp_create {
            get { return getAttrVal<string>("Id_emp_create",null); }
            set { setAttrVal<string>("Id_emp_create", value); }
        }

        /// <summary>
        /// 申请医生
        /// </summary>
		public string Name_emp_create {
            get { return getAttrVal<string>("Name_emp_create",null); }
            set { setAttrVal<string>("Name_emp_create", value); }
        }

        /// <summary>
        /// 开立时间
        /// </summary>
		public DateTime? Dt_create {
            get { return getAttrVal<FDateTime>("Dt_create",null); }
            set { setAttrVal<FDateTime>("Dt_create", value); }
        }

        /// <summary>
        /// 血液品种id
        /// </summary>
		public string Id_bttp {
            get { return getAttrVal<string>("Id_bttp",null); }
            set { setAttrVal<string>("Id_bttp", value); }
        }

        /// <summary>
        /// 血液品种
        /// </summary>
		public string Name_bttp {
            get { return getAttrVal<string>("Name_bttp",null); }
            set { setAttrVal<string>("Name_bttp", value); }
        }

        /// <summary>
        /// 血液品种sd
        /// </summary>
		public string Sd_bttp {
            get { return getAttrVal<string>("Sd_bttp",null); }
            set { setAttrVal<string>("Sd_bttp", value); }
        }

        /// <summary>
        /// 输血史编码
        /// </summary>
		public string Sd_his_bt {
            get { return getAttrVal<string>("Sd_his_bt",null); }
            set { setAttrVal<string>("Sd_his_bt", value); }
        }

        /// <summary>
        /// 输血史
        /// </summary>
		public string Name_his_bt {
            get { return getAttrVal<string>("Name_his_bt",null); }
            set { setAttrVal<string>("Name_his_bt", value); }
        }

        /// <summary>
        /// 输血史id
        /// </summary>
		public string Id_his_bt {
            get { return getAttrVal<string>("Id_his_bt",null); }
            set { setAttrVal<string>("Id_his_bt", value); }
        }

        /// <summary>
        /// 可用血余量
        /// </summary>
		public int? Real_num {
            get { return getAttrVal<int?>("Real_num",null); }
            set { setAttrVal<int?>("Real_num", value); }
        }

        /// <summary>
        /// 执行科室
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
        ///输血前检查指标
        /// </summary>
        public XapDataList<OrdApSugViewItemDO> BtLabItem
        {
            get { return getAttrVal<XapDataList<OrdApSugViewItemDO>>("BtLabItem", null); }
            set { setAttrVal<XapDataList<OrdApSugViewItemDO>>("BtLabItem", value); }
        }
        /// <summary>
        /// 医保
        /// </summary>
		public string Id_hp {
            get { return getAttrVal<string>("Id_hp",null); }
            set { setAttrVal<string>("Id_hp", value); }
        }

        /// <summary>
        /// 医保名称
        /// </summary>
		public string Name_hp {
            get { return getAttrVal<string>("Name_hp",null); }
            set { setAttrVal<string>("Name_hp", value); }
        }

        /// <summary>
        /// 医保类型
        /// </summary>
		public string Id_hpsrvtp {
            get { return getAttrVal<string>("Id_hpsrvtp",null); }
            set { setAttrVal<string>("Id_hpsrvtp", value); }
        }

        /// <summary>
        /// 一包类型编码
        /// </summary>
		public string Sd_hpsrvtp {
            get { return getAttrVal<string>("Sd_hpsrvtp",null); }
            set { setAttrVal<string>("Sd_hpsrvtp", value); }
        }

        /// <summary>
        /// 费用同步标识
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
        /// 计价方式
        /// </summary>
		public string Priby {
            get { return getAttrVal<string>("Priby",null); }
            set { setAttrVal<string>("Priby", value); }
        }

        /// <summary>
        /// 输血成分
        /// </summary>
		public string Components_name {
            get { return getAttrVal<string>("Components_name",null); }
            set { setAttrVal<string>("Components_name", value); }
        }

        public double? Price
        {
            get { return getAttrVal<double?>("Price", null); }
            set { setAttrVal<double?>("Price", value); }
        }

        
        public FArrayList BtLabItemEx
        {
            get { return getAttrVal<FArrayList>("BtLabItemEx", null); }
            set { setAttrVal<FArrayList>("BtLabItemEx", value); }
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
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[] { "Str_id_diitm", "Str_name_di", "Str_code_di", "Id_diitm", "Name_diag", "Id_di", "Id_emsbt", "Id_srv", "Name_srv", "Id_or", "Id_orsrv", "Quan_med", "Id_unit_med", "Name_unit_med", "No_applyform", "Parturition_cnt", "Sd_pps", "Id_pps", "Name_pps", "Fg_db", "No_db", "Id_mode", "Sd_mode", "Name_mode", "Id_demandsu", "Sd_demandsu", "Name_demandsu", "Pregnat_num", "Id_labitmexplain", "Name_labitmexplain", "Sd_labitmexplain", "Dt_bt", "Id_emp_create", "Name_emp_create", "Dt_create", "Id_bttp", "Name_bttp", "Sd_bttp", "Sd_his_bt", "Name_his_bt", "Id_his_bt", "Real_num", "Id_mp_dep", "Name_mp_dep", "Id_hp", "Name_hp", "Id_hpsrvtp", "Sd_hpsrvtp", "Fg_syncfee", "Innercode_srvca", "Eu_sourcemd", "Id_srv_src", "Priby", "Components_name", "Fg_selfpay" };
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.ciordems.d.EmsBtItemDO";
        }
    }
}
