using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.emsdi.d
{
    /// <summary>
    /// EmsDiDTO 的摘要说明。
    /// </summary>
    public class EmsDiDTO : BaseDTO {

        public EmsDiDTO() {
 
        }

        /// <summary>
        /// 医疗单数据初始化主键标识
        /// </summary>
		public string Id_emsdi {
            get { return getAttrVal<string>("Id_emsdi",null); }
            set { setAttrVal<string>("Id_emsdi", value); }
        }

        /// <summary>
        /// 所属集团
        /// </summary>
		public string Id_grp {
            get { return getAttrVal<string>("Id_grp",null); }
            set { setAttrVal<string>("Id_grp", value); }
        }

        /// <summary>
        /// 所属组织
        /// </summary>
		public string Id_org {
            get { return getAttrVal<string>("Id_org",null); }
            set { setAttrVal<string>("Id_org", value); }
        }

        /// <summary>
        /// 开立科室
        /// </summary>
		public string Id_dep_or {
            get { return getAttrVal<string>("Id_dep_or",null); }
            set { setAttrVal<string>("Id_dep_or", value); }
        }

        /// <summary>
        /// 开立医生
        /// </summary>
		public string Id_emp_or {
            get { return getAttrVal<string>("Id_emp_or",null); }
            set { setAttrVal<string>("Id_emp_or", value); }
        }

        /// <summary>
        /// 医疗单应用场景
        /// </summary>
		public int? Emsappmode {
            get { return getAttrVal<int?>("Emsappmode",null); }
            set { setAttrVal<int?>("Emsappmode", value); }
        }

        /// <summary>
        /// 患者
        /// </summary>
		public string Id_pat {
            get { return getAttrVal<string>("Id_pat",null); }
            set { setAttrVal<string>("Id_pat", value); }
        }

        /// <summary>
        /// 就诊
        /// </summary>
		public string Id_en {
            get { return getAttrVal<string>("Id_en",null); }
            set { setAttrVal<string>("Id_en", value); }
        }

        /// <summary>
        /// 就诊类型
        /// </summary>
		public string Code_entp {
            get { return getAttrVal<string>("Code_entp",null); }
            set { setAttrVal<string>("Code_entp", value); }
        }

        /// <summary>
        /// 长期医嘱标识
        /// </summary>
		public bool? Fg_long {
            get { return getAttrVal<FBoolean>("Fg_long",null); }
            set { setAttrVal<FBoolean>("Fg_long", value); }
        }

        /// <summary>
        /// 医嘱名称
        /// </summary>
		public string Name_or {
            get { return getAttrVal<string>("Name_or",null); }
            set { setAttrVal<string>("Name_or", value); }
        }

        /// <summary>
        /// 主服务
        /// </summary>
		public string Id_srv {
            get { return getAttrVal<string>("Id_srv",null); }
            set { setAttrVal<string>("Id_srv", value); }
        }

        /// <summary>
        /// 主服务类型
        /// </summary>
		public string Id_srvtp {
            get { return getAttrVal<string>("Id_srvtp",null); }
            set { setAttrVal<string>("Id_srvtp", value); }
        }

        /// <summary>
        /// 主服务类型编码
        /// </summary>
		public string Sd_srvtp {
            get { return getAttrVal<string>("Sd_srvtp",null); }
            set { setAttrVal<string>("Sd_srvtp", value); }
        }

        /// <summary>
        /// 套标识
        /// </summary>
		public bool? Fg_set {
            get { return getAttrVal<FBoolean>("Fg_set",null); }
            set { setAttrVal<FBoolean>("Fg_set", value); }
        }

        /// <summary>
        /// 主服务基本分类
        /// </summary>
		public string Id_srvca {
            get { return getAttrVal<string>("Id_srvca",null); }
            set { setAttrVal<string>("Id_srvca", value); }
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
        /// 煎法要求名称j
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
        /// 医学单位名称
        /// </summary>
		public string Name_unit_med {
            get { return getAttrVal<string>("Name_unit_med",null); }
            set { setAttrVal<string>("Name_unit_med", value); }
        }

        /// <summary>
        /// 医嘱天数
        /// </summary>
		public int? Days_or {
            get { return getAttrVal<int?>("Days_or",null); }
            set { setAttrVal<int?>("Days_or", value); }
        }

        /// <summary>
        /// 医嘱次数
        /// </summary>
		public int? Times_cur {
            get { return getAttrVal<int?>("Times_cur",null); }
            set { setAttrVal<int?>("Times_cur", value); }
        }

        /// <summary>
        /// 医嘱付数
        /// </summary>
		public int? Orders {
            get { return getAttrVal<int?>("Orders",null); }
            set { setAttrVal<int?>("Orders", value); }
        }

        /// <summary>
        /// 医疗单
        /// </summary>
		public string Id_srvof {
            get { return getAttrVal<string>("Id_srvof",null); }
            set { setAttrVal<string>("Id_srvof", value); }
        }

        /// <summary>
        /// 医疗单显示名称
        /// </summary>
		public string Name_ems {
            get { return getAttrVal<string>("Name_ems",null); }
            set { setAttrVal<string>("Name_ems", value); }
        }

        /// <summary>
        /// 医疗单URL
        /// </summary>
		public string Funcclassstr {
            get { return getAttrVal<string>("Funcclassstr",null); }
            set { setAttrVal<string>("Funcclassstr", value); }
        }

        /// <summary>
        /// 医嘱执行闭环类型
        /// </summary>
		public string Id_orpltp {
            get { return getAttrVal<string>("Id_orpltp",null); }
            set { setAttrVal<string>("Id_orpltp", value); }
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
        /// 医疗单服务项目列表
        /// </summary>
		public FArrayList Uiemssrvs {
            get { return getAttrVal<FArrayList>("Uiemssrvs",null); }
            set { setAttrVal<FArrayList>("Uiemssrvs", value); }
        }

        /// <summary>
        /// 附加信息Map键值串
        /// </summary>
		public string Mapkeys {
            get { return getAttrVal<string>("Mapkeys",null); }
            set { setAttrVal<string>("Mapkeys", value); }
        }

        /// <summary>
        /// 相关附加信息MAP
        /// </summary>
		public FMap Mapinfo {
            get { return getAttrVal<FMap>("Mapinfo",null); }
            set { setAttrVal<FMap>("Mapinfo", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_emsdi", "Id_grp", "Id_org", "Id_dep_or", "Id_emp_or", "Emsappmode", "Id_pat", "Id_en", "Code_entp", "Fg_long", "Name_or", "Id_srv", "Id_srvtp", "Sd_srvtp", "Fg_set", "Id_srvca", "Id_freq", "Name_freq", "Id_route", "Name_route", "Id_routedes", "Name_routedes", "Id_boil", "Name_boil", "Id_boildes", "Name_boildes", "Quan_medu", "Id_unit_med", "Name_unit_med", "Days_or", "Times_cur", "Orders", "Id_srvof", "Name_ems", "Funcclassstr", "Id_orpltp", "Id_dep_mp", "Name_dep_mp", "Uiemssrvs", "Mapkeys", "Mapinfo"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.emsdi.d.EmsDiDTO";
        }
    }
}
