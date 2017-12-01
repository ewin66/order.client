using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.emsdi.d
{
    /// <summary>
    /// EmsDiSrvDTO 的摘要说明。
    /// </summary>
    public class EmsDiSrvDTO : BaseDTO {

        public EmsDiSrvDTO() {
 
        }

        /// <summary>
        /// 医疗单数据初始化服务主键标识
        /// </summary>
		public string Id_emsdisrv {
            get { return getAttrVal<string>("Id_emsdisrv",null); }
            set { setAttrVal<string>("Id_emsdisrv", value); }
        }

        /// <summary>
        /// 医疗单数据初始化主键
        /// </summary>
		public string Id_emsdi {
            get { return getAttrVal<string>("Id_emsdi",null); }
            set { setAttrVal<string>("Id_emsdi", value); }
        }

        /// <summary>
        /// 服务
        /// </summary>
		public string Id_srv {
            get { return getAttrVal<string>("Id_srv",null); }
            set { setAttrVal<string>("Id_srv", value); }
        }

        /// <summary>
        /// 服务编码
        /// </summary>
		public string Code_srv {
            get { return getAttrVal<string>("Code_srv",null); }
            set { setAttrVal<string>("Code_srv", value); }
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
        /// 服务类型编码
        /// </summary>
		public string Sd_srvtp {
            get { return getAttrVal<string>("Sd_srvtp",null); }
            set { setAttrVal<string>("Sd_srvtp", value); }
        }

        /// <summary>
        /// 服务基本分类
        /// </summary>
		public string Id_srvca {
            get { return getAttrVal<string>("Id_srvca",null); }
            set { setAttrVal<string>("Id_srvca", value); }
        }

        /// <summary>
        /// 自定义服务标识
        /// </summary>
		public bool? Fg_selfsrv {
            get { return getAttrVal<FBoolean>("Fg_selfsrv",null); }
            set { setAttrVal<FBoolean>("Fg_selfsrv", value); }
        }

        /// <summary>
        /// 频次
        /// </summary>
		public string Id_freq {
            get { return getAttrVal<string>("Id_freq",null); }
            set { setAttrVal<string>("Id_freq", value); }
        }

        /// <summary>
        /// 频次名称
        /// </summary>
		public string Name_freq {
            get { return getAttrVal<string>("Name_freq",null); }
            set { setAttrVal<string>("Name_freq", value); }
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
        /// 煎法要求
        /// </summary>
		public string Id_boildes {
            get { return getAttrVal<string>("Id_boildes",null); }
            set { setAttrVal<string>("Id_boildes", value); }
        }

        /// <summary>
        /// 煎法要求名称
        /// </summary>
		public string Name_boildes {
            get { return getAttrVal<string>("Name_boildes",null); }
            set { setAttrVal<string>("Name_boildes", value); }
        }

        /// <summary>
        /// 数值_医学单位
        /// </summary>
		public double? Quan_medu {
            get { return getAttrVal<FDouble>("Quan_medu",null); }
            set { setAttrVal<FDouble>("Quan_medu", value); }
        }

        /// <summary>
        /// 医学单位
        /// </summary>
		public string Id_unit_med {
            get { return getAttrVal<string>("Id_unit_med",null); }
            set { setAttrVal<string>("Id_unit_med", value); }
        }

        /// <summary>
        /// 项目来源方式
        /// </summary>
		public int? Eu_sourcemd {
            get { return getAttrVal<int?>("Eu_sourcemd",null); }
            set { setAttrVal<int?>("Eu_sourcemd", value); }
        }

        /// <summary>
        /// 来源服务项目
        /// </summary>
		public string Id_srv_src {
            get { return getAttrVal<string>("Id_srv_src",null); }
            set { setAttrVal<string>("Id_srv_src", value); }
        }

        /// <summary>
        /// 套标识
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
        /// 物品标识
        /// </summary>
		public bool? Fg_mm {
            get { return getAttrVal<FBoolean>("Fg_mm",null); }
            set { setAttrVal<FBoolean>("Fg_mm", value); }
        }

        /// <summary>
        /// 自备药标识
        /// </summary>
		public bool? Fg_self {
            get { return getAttrVal<FBoolean>("Fg_self",null); }
            set { setAttrVal<FBoolean>("Fg_self", value); }
        }

        /// <summary>
        /// 预防用药标识
        /// </summary>
		public bool? Fg_propc {
            get { return getAttrVal<FBoolean>("Fg_propc",null); }
            set { setAttrVal<FBoolean>("Fg_propc", value); }
        }

        /// <summary>
        /// 划价方式
        /// </summary>
		public int? Eu_blmd {
            get { return getAttrVal<int?>("Eu_blmd",null); }
            set { setAttrVal<int?>("Eu_blmd", value); }
        }

        /// <summary>
        /// 定价模式
        /// </summary>
		public string Id_primd {
            get { return getAttrVal<string>("Id_primd",null); }
            set { setAttrVal<string>("Id_primd", value); }
        }

        /// <summary>
        /// 参考价
        /// </summary>
		public double? Price {
            get { return getAttrVal<FDouble>("Price",null); }
            set { setAttrVal<FDouble>("Price", value); }
        }

        /// <summary>
        /// 总量_医学单位
        /// </summary>
		public double? Quan_total_medu {
            get { return getAttrVal<FDouble>("Quan_total_medu",null); }
            set { setAttrVal<FDouble>("Quan_total_medu", value); }
        }

        /// <summary>
        /// 总金额
        /// </summary>
		public double? Amt_total {
            get { return getAttrVal<FDouble>("Amt_total",null); }
            set { setAttrVal<FDouble>("Amt_total", value); }
        }

        /// <summary>
        /// 主医保计划
        /// </summary>
		public string Id_hp {
            get { return getAttrVal<string>("Id_hp",null); }
            set { setAttrVal<string>("Id_hp", value); }
        }

        /// <summary>
        /// 医保目录
        /// </summary>
		public string Id_hpsrvtp {
            get { return getAttrVal<string>("Id_hpsrvtp",null); }
            set { setAttrVal<string>("Id_hpsrvtp", value); }
        }

        /// <summary>
        /// 医保目录编码
        /// </summary>
		public string Sd_hpsrvtp {
            get { return getAttrVal<string>("Sd_hpsrvtp",null); }
            set { setAttrVal<string>("Sd_hpsrvtp", value); }
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
        /// 医保适应症标识
        /// </summary>
		public bool? Fg_indic {
            get { return getAttrVal<FBoolean>("Fg_indic",null); }
            set { setAttrVal<FBoolean>("Fg_indic", value); }
        }

        /// <summary>
        /// 自费标识
        /// </summary>
		public bool? Fg_selfpay {
            get { return getAttrVal<FBoolean>("Fg_selfpay",null); }
            set { setAttrVal<FBoolean>("Fg_selfpay", value); }
        }

        /// <summary>
        /// 执行科室
        /// </summary>
		public string Id_dep_mp {
            get { return getAttrVal<string>("Id_dep_mp",null); }
            set { setAttrVal<string>("Id_dep_mp", value); }
        }

        /// <summary>
        /// 执行科室名称
        /// </summary>
		public string Name_dep_mp {
            get { return getAttrVal<string>("Name_dep_mp",null); }
            set { setAttrVal<string>("Name_dep_mp", value); }
        }

        /// <summary>
        /// 库房
        /// </summary>
		public string Id_dep_wh {
            get { return getAttrVal<string>("Id_dep_wh",null); }
            set { setAttrVal<string>("Id_dep_wh", value); }
        }

        /// <summary>
        /// 库房名称
        /// </summary>
		public string Name_dep_wh {
            get { return getAttrVal<string>("Name_dep_wh",null); }
            set { setAttrVal<string>("Name_dep_wh", value); }
        }

        /// <summary>
        /// 关联信息Map键值串
        /// </summary>
		public string Mapkeys {
            get { return getAttrVal<string>("Mapkeys",null); }
            set { setAttrVal<string>("Mapkeys", value); }
        }

        /// <summary>
        /// 项目关联信息MAP
        /// </summary>
		public FMap Mapinfo {
            get { return getAttrVal<FMap>("Mapinfo",null); }
            set { setAttrVal<FMap>("Mapinfo", value); }
        }

        /// <summary>
        /// 服务对应物品信息集合
        /// </summary>
		public FArrayList Srvmms {
            get { return getAttrVal<FArrayList>("Srvmms",null); }
            set { setAttrVal<FArrayList>("Srvmms", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_emsdisrv", "Id_emsdi", "Id_srv", "Code_srv", "Name_srv", "Id_srvtp", "Sd_srvtp", "Id_srvca", "Fg_selfsrv", "Id_freq", "Name_freq", "Sd_frequnitct", "Frequnitct", "Freqct", "Id_route", "Name_route", "Id_routedes", "Name_routedes", "Id_boil", "Name_boil", "Id_boildes", "Name_boildes", "Quan_medu", "Id_unit_med", "Eu_sourcemd", "Id_srv_src", "Fg_set", "Fg_or", "Fg_bl", "Fg_mm", "Fg_self", "Fg_propc", "Eu_blmd", "Id_primd", "Price", "Quan_total_medu", "Amt_total", "Id_hp", "Id_hpsrvtp", "Sd_hpsrvtp", "Name_hpsrvtp", "Limit", "Fg_indic", "Fg_selfpay", "Id_dep_mp", "Name_dep_mp", "Id_dep_wh", "Name_dep_wh", "Mapkeys", "Mapinfo", "Srvmms"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.emsdi.d.EmsDiSrvDTO";
        }
    }
}
