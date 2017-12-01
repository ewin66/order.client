using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.iih.ci.ord.ciordems.d.d
{
    /// <summary>
    /// QuantumParamDTO 的摘要说明。
    /// </summary>
    public class QuantumParamDTO : BaseDTO {

        public QuantumParamDTO() {
 
        }

        /// <summary>
        /// 就诊类型
        /// </summary>
		public string Code_entp {
            get { return getAttrVal<string>("Code_entp",null); }
            set { setAttrVal<string>("Code_entp", value); }
        }

        /// <summary>
        /// 服务类型
        /// </summary>
		public string Sd_srvtp {
            get { return getAttrVal<string>("Sd_srvtp",null); }
            set { setAttrVal<string>("Sd_srvtp", value); }
        }

        /// <summary>
        /// 出院带药标志
        /// </summary>
		public bool? Fg_pres_outp {
            get { return getAttrVal<FBoolean>("Fg_pres_outp",null); }
            set { setAttrVal<FBoolean>("Fg_pres_outp", value); }
        }

        /// <summary>
        /// 医学计量
        /// </summary>
		public FDouble Quan_medu {
            get { return getAttrVal<FDouble>("Quan_medu",null); }
            set { setAttrVal<FDouble>("Quan_medu", value); }
        }

        /// <summary>
        /// 频次id
        /// </summary>
		public string Id_freq {
            get { return getAttrVal<string>("Id_freq",null); }
            set { setAttrVal<string>("Id_freq", value); }
        }

        /// <summary>
        /// 物品标识
        /// </summary>
		public bool? Fg_mm {
            get { return getAttrVal<FBoolean>("Fg_mm",null); }
            set { setAttrVal<FBoolean>("Fg_mm", value); }
        }

        /// <summary>
        /// 总量单位
        /// </summary>
		public string Id_unit_sale {
            get { return getAttrVal<string>("Id_unit_sale",null); }
            set { setAttrVal<string>("Id_unit_sale", value); }
        }

        /// <summary>
        /// 使用天数
        /// </summary>
		public int? Use_day {
            get { return getAttrVal<int?>("Use_days",null); }
            set { setAttrVal<int?>("Use_days", value); }
        }

        /// <summary>
        /// 草药付数
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
        /// 在院执行次数
        /// </summary>
		public int? Times_mp_in {
            get { return getAttrVal<int?>("Times_mp_in",null); }
            set { setAttrVal<int?>("Times_mp_in", value); }
        }

        /// <summary>
        /// 物品id
        /// </summary>
		public string Id_mm {
            get { return getAttrVal<string>("Id_mm",null); }
            set { setAttrVal<string>("Id_mm", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Code_entp", "Sd_srvtp", "Fg_pres_outp", "Quan_medu", "Id_freq", "Fg_mm", "Id_unit_sale", "Use_days", "Orders", "Orders_boil", "Times_mp_in", "Id_mm"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.ciordems.d";
        }
    }
}
