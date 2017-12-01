using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.tmpl.d
{
    /// <summary>
    /// CiOrTmplSrvDTO 的摘要说明。
    /// </summary>
    public class CiOrTmplSrvDTO : BaseDTO {

        public CiOrTmplSrvDTO() {
 
        }

        /// <summary>
        /// 临床医嘱模板项目主键标识
        /// </summary>
		public string Id_ciortmplsrv {
            get { return getAttrVal<string>("Id_ciortmplsrv",null); }
            set { setAttrVal<string>("Id_ciortmplsrv", value); }
        }

        /// <summary>
        /// 临床医嘱模板
        /// </summary>
		public string Id_ciortmpl {
            get { return getAttrVal<string>("Id_ciortmpl",null); }
            set { setAttrVal<string>("Id_ciortmpl", value); }
        }

        /// <summary>
        /// 序号
        /// </summary>
		public int? Sortno {
            get { return getAttrVal<int?>("Sortno",null); }
            set { setAttrVal<int?>("Sortno", value); }
        }

        /// <summary>
        /// 服务
        /// </summary>
		public string Id_srv {
            get { return getAttrVal<string>("Id_srv",null); }
            set { setAttrVal<string>("Id_srv", value); }
        }

        /// <summary>
        /// 自定义服务标识
        /// </summary>
		public bool? Fg_selfsrv {
            get { return getAttrVal<FBoolean>("Fg_selfsrv",null); }
            set { setAttrVal<FBoolean>("Fg_selfsrv", value); }
        }

        /// <summary>
        /// 自定义服务名
        /// </summary>
		public string Name_selfsrv {
            get { return getAttrVal<string>("Name_selfsrv",null); }
            set { setAttrVal<string>("Name_selfsrv", value); }
        }

        /// <summary>
        /// 套标识
        /// </summary>
		public bool? Fg_set {
            get { return getAttrVal<FBoolean>("Fg_set",null); }
            set { setAttrVal<FBoolean>("Fg_set", value); }
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
        /// 频次
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
        /// 要求
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
        /// 中医要求
        /// </summary>
		public string Id_boildes {
            get { return getAttrVal<string>("Id_boildes",null); }
            set { setAttrVal<string>("Id_boildes", value); }
        }

        /// <summary>
        /// 医学单位
        /// </summary>
		public string Id_unit_med {
            get { return getAttrVal<string>("Id_unit_med",null); }
            set { setAttrVal<string>("Id_unit_med", value); }
        }

        /// <summary>
        /// 医学单位数值
        /// </summary>
		public double? Quan_med {
            get { return getAttrVal<FDouble>("Quan_med",null); }
            set { setAttrVal<FDouble>("Quan_med", value); }
        }

        /// <summary>
        /// 服务总量
        /// </summary>
		public double? Quan_total_medu {
            get { return getAttrVal<FDouble>("Quan_total_medu",null); }
            set { setAttrVal<FDouble>("Quan_total_medu", value); }
        }

        /// <summary>
        /// 零售单位
        /// </summary>
		public string Id_unit_sale {
            get { return getAttrVal<string>("Id_unit_sale",null); }
            set { setAttrVal<string>("Id_unit_sale", value); }
        }

        /// <summary>
        /// 执行科室
        /// </summary>
		public string Id_dep_mp {
            get { return getAttrVal<string>("Id_dep_mp",null); }
            set { setAttrVal<string>("Id_dep_mp", value); }
        }

        /// <summary>
        /// 关联物品
        /// </summary>
		public string Id_mm {
            get { return getAttrVal<string>("Id_mm",null); }
            set { setAttrVal<string>("Id_mm", value); }
        }

        /// <summary>
        /// 套内项目集合
        /// </summary>
		public FArrayList Srvsetitms {
            get { return getAttrVal<FArrayList>("Srvsetitms",null); }
            set { setAttrVal<FArrayList>("Srvsetitms", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_ciortmplsrv", "Id_ciortmpl", "Sortno", "Id_srv", "Fg_selfsrv", "Name_selfsrv", "Fg_set", "Id_srvtp", "Sd_srvtp", "Id_freq", "Id_route", "Id_routedes", "Id_boil", "Id_boildes", "Id_unit_med", "Quan_med", "Quan_total_medu", "Id_unit_sale", "Id_dep_mp", "Id_mm", "Srvsetitms"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.tmpl.d.CiOrTmplSrvDTO";
        }
    }
}
