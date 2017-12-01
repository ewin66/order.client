using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.tmpl.d
{
    /// <summary>
    /// CiOrTmplDTO 的摘要说明。
    /// </summary>
    public class CiOrTmplDTO : BaseDTO {

        public CiOrTmplDTO() {
 
        }

        /// <summary>
        /// 临床医嘱模板主键标识
        /// </summary>
		public string Id_ciortmpl {
            get { return getAttrVal<string>("Id_ciortmpl",null); }
            set { setAttrVal<string>("Id_ciortmpl", value); }
        }

        /// <summary>
        /// 医嘱模板项目列表
        /// </summary>
		public FArrayList Ortmplsrvs {
            get { return getAttrVal<FArrayList>("Ortmplsrvs",null); }
            set { setAttrVal<FArrayList>("Ortmplsrvs", value); }
        }

        /// <summary>
        /// 医嘱来源方式类型
        /// </summary>
		public string Eu_orsrcmdtp {
            get { return getAttrVal<string>("Eu_orsrcmdtp",null); }
            set { setAttrVal<string>("Eu_orsrcmdtp", value); }
        }

        /// <summary>
        /// 医嘱来源主标识
        /// </summary>
		public string Id_orsrc_main {
            get { return getAttrVal<string>("Id_orsrc_main",null); }
            set { setAttrVal<string>("Id_orsrc_main", value); }
        }

        /// <summary>
        /// 医嘱来源子标识
        /// </summary>
		public string Id_orsrc_sub {
            get { return getAttrVal<string>("Id_orsrc_sub",null); }
            set { setAttrVal<string>("Id_orsrc_sub", value); }
        }

        /// <summary>
        /// 医嘱来源孙标识
        /// </summary>
		public string Id_orsrc_subsub {
            get { return getAttrVal<string>("Id_orsrc_subsub",null); }
            set { setAttrVal<string>("Id_orsrc_subsub", value); }
        }

        /// <summary>
        /// 编码
        /// </summary>
		public string Code {
            get { return getAttrVal<string>("Code",null); }
            set { setAttrVal<string>("Code", value); }
        }

        /// <summary>
        /// 名称
        /// </summary>
		public string Name {
            get { return getAttrVal<string>("Name",null); }
            set { setAttrVal<string>("Name", value); }
        }

        /// <summary>
        /// 医嘱类型
        /// </summary>
		public string Id_srvtp {
            get { return getAttrVal<string>("Id_srvtp",null); }
            set { setAttrVal<string>("Id_srvtp", value); }
        }

        /// <summary>
        /// 医嘱类型编码
        /// </summary>
		public string Sd_srvtp {
            get { return getAttrVal<string>("Sd_srvtp",null); }
            set { setAttrVal<string>("Sd_srvtp", value); }
        }

        /// <summary>
        /// 长期临时类型
        /// </summary>
		public int? Eu_long {
            get { return getAttrVal<int?>("Eu_long",null); }
            set { setAttrVal<int?>("Eu_long", value); }
        }

        /// <summary>
        /// 医嘱频次
        /// </summary>
		public string Id_freq {
            get { return getAttrVal<string>("Id_freq",null); }
            set { setAttrVal<string>("Id_freq", value); }
        }

        /// <summary>
        /// 用法
        /// </summary>
		public string Id_route {
            get { return getAttrVal<string>("Id_route",null); }
            set { setAttrVal<string>("Id_route", value); }
        }

        /// <summary>
        /// 用法要求
        /// </summary>
		public string Id_routedes {
            get { return getAttrVal<string>("Id_routedes",null); }
            set { setAttrVal<string>("Id_routedes", value); }
        }

        /// <summary>
        /// 煎法
        /// </summary>
		public string Id_boil {
            get { return getAttrVal<string>("Id_boil",null); }
            set { setAttrVal<string>("Id_boil", value); }
        }

        /// <summary>
        /// 煎法要求
        /// </summary>
		public string Id_boildes {
            get { return getAttrVal<string>("Id_boildes",null); }
            set { setAttrVal<string>("Id_boildes", value); }
        }

        /// <summary>
        /// 代煎标识
        /// </summary>
		public bool? Fg_boil {
            get { return getAttrVal<FBoolean>("Fg_boil",null); }
            set { setAttrVal<FBoolean>("Fg_boil", value); }
        }

        /// <summary>
        /// 医嘱天数
        /// </summary>
		public int? Days_or {
            get { return getAttrVal<int?>("Days_or",null); }
            set { setAttrVal<int?>("Days_or", value); }
        }

        /// <summary>
        /// 医嘱付数
        /// </summary>
		public int? Orders {
            get { return getAttrVal<int?>("Orders",null); }
            set { setAttrVal<int?>("Orders", value); }
        }

        /// <summary>
        /// 医嘱次数
        /// </summary>
		public int? Times {
            get { return getAttrVal<int?>("Times",null); }
            set { setAttrVal<int?>("Times", value); }
        }

        /// <summary>
        /// 医嘱描述
        /// </summary>
		public string Des_or {
            get { return getAttrVal<string>("Des_or",null); }
            set { setAttrVal<string>("Des_or", value); }
        }

        /// <summary>
        /// 医疗服务id
        /// </summary>
		public string Id_srv {
            get { return getAttrVal<string>("Id_srv",null); }
            set { setAttrVal<string>("Id_srv", value); }
        }

        /// <summary>
        /// 套标示
        /// </summary>
		public bool? Fg_set {
            get { return getAttrVal<FBoolean>("Fg_set",null); }
            set { setAttrVal<FBoolean>("Fg_set", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_ciortmpl", "Ortmplsrvs", "Eu_orsrcmdtp", "Id_orsrc_main", "Id_orsrc_sub", "Id_orsrc_subsub", "Code", "Name", "Id_srvtp", "Sd_srvtp", "Eu_long", "Id_freq", "Id_route", "Id_routedes", "Id_boil", "Id_boildes", "Fg_boil", "Days_or", "Orders", "Times", "Des_or", "Id_srv", "Fg_set"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.tmpl.d.CiOrTmplDTO";
        }
    }
}
