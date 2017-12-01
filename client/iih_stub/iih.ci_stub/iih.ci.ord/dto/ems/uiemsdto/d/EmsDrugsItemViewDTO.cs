using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.dto.ems.uiemsdto.d
{
    /// <summary>
    /// EmsDrugsItemViewDTO 的摘要说明。
    /// </summary>
    public class EmsDrugsItemViewDTO : BaseDTO {

        public EmsDrugsItemViewDTO() {
 
        }

        /// <summary>
        /// 服务ID
        /// </summary>
		public string Id_srv {
            get { return getAttrVal<string>("Id_srv",null); }
            set { setAttrVal<string>("Id_srv", value); }
        }

        /// <summary>
        /// 处置项目
        /// </summary>
		public string Name_srv {
            get { return getAttrVal<string>("Name_srv",null); }
            set { setAttrVal<string>("Name_srv", value); }
        }

        /// <summary>
        /// 服务类型
        /// </summary>
		public string Sd_srvtp {
            get { return getAttrVal<string>("Sd_srvtp",null); }
            set { setAttrVal<string>("Sd_srvtp", value); }
        }

        /// <summary>
        /// 商品名
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
        /// 计量
        /// </summary>
		public string Quan_med {
            get { return getAttrVal<string>("Quan_med",null); }
            set { setAttrVal<string>("Quan_med", value); }
        }

        /// <summary>
        /// 计量单位ID
        /// </summary>
		public string Id_unit_med {
            get { return getAttrVal<string>("Id_unit_med",null); }
            set { setAttrVal<string>("Id_unit_med", value); }
        }

        /// <summary>
        /// 计量单位
        /// </summary>
		public string Name_unit_med {
            get { return getAttrVal<string>("Name_unit_med",null); }
            set { setAttrVal<string>("Name_unit_med", value); }
        }

        /// <summary>
        /// 用法ID
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
        /// 用法过滤条件
        /// </summary>
		public string Filter_route {
            get { return getAttrVal<string>("Filter_route",null); }
            set { setAttrVal<string>("Filter_route", value); }
        }

        /// <summary>
        /// 频次ID
        /// </summary>
		public string Id_freq {
            get { return getAttrVal<string>("Id_freq",null); }
            set { setAttrVal<string>("Id_freq", value); }
        }

        /// <summary>
        /// 频次
        /// </summary>
		public string Name_freq {
            get { return getAttrVal<string>("Name_freq",null); }
            set { setAttrVal<string>("Name_freq", value); }
        }

        /// <summary>
        /// 频次周期类型SD
        /// </summary>
		public string Sd_frequnitct {
            get { return getAttrVal<string>("Sd_frequnitct",null); }
            set { setAttrVal<string>("Sd_frequnitct", value); }
        }

        /// <summary>
        /// 频次数量
        /// </summary>
		public string Freqct {
            get { return getAttrVal<string>("Freqct",null); }
            set { setAttrVal<string>("Freqct", value); }
        }

        /// <summary>
        /// 天数
        /// </summary>
		public string Usedays {
            get { return getAttrVal<string>("Usedays",null); }
            set { setAttrVal<string>("Usedays", value); }
        }

        /// <summary>
        /// 总量
        /// </summary>
		public FDouble Quan_cur {
            get { return getAttrVal<FDouble>("Quan_cur",null); }
            set { setAttrVal<FDouble>("Quan_cur", value); }
        }

        /// <summary>
        /// 药房ID
        /// </summary>
		public string Id_dep_wh {
            get { return getAttrVal<string>("Id_dep_wh",null); }
            set { setAttrVal<string>("Id_dep_wh", value); }
        }

        /// <summary>
        /// 药房
        /// </summary>
		public string Name_dep_wh {
            get { return getAttrVal<string>("Name_dep_wh",null); }
            set { setAttrVal<string>("Name_dep_wh", value); }
        }

        /// <summary>
        /// 药房过滤条件
        /// </summary>
		public string Filter_dep_wh {
            get { return getAttrVal<string>("Filter_dep_wh",null); }
            set { setAttrVal<string>("Filter_dep_wh", value); }
        }

        /// <summary>
        /// 参考价
        /// </summary>
		public FDouble Price {
            get { return getAttrVal<FDouble>("Price",null); }
            set { setAttrVal<FDouble>("Price", value); }
        }

        /// <summary>
        /// 总价
        /// </summary>
		public FDouble Amount {
            get { return getAttrVal<FDouble>("Amount",null); }
            set { setAttrVal<FDouble>("Amount", value); }
        }

        /// <summary>
        /// 外配药标识
        /// </summary>
		public bool? Fg_extdispense {
            get { return getAttrVal<FBoolean>("Fg_extdispense",null); }
            set { setAttrVal<FBoolean>("Fg_extdispense", value); }
        }

        /// <summary>
        /// 零售单位ID
        /// </summary>
		public string Id_unit_sale {
            get { return getAttrVal<string>("Id_unit_sale",null); }
            set { setAttrVal<string>("Id_unit_sale", value); }
        }

        /// <summary>
        /// 零售单位
        /// </summary>
		public string Name_unit_sale {
            get { return getAttrVal<string>("Name_unit_sale",null); }
            set { setAttrVal<string>("Name_unit_sale", value); }
        }

        /// <summary>
        /// 折扣价系数
        /// </summary>
		public string Price_ratio {
            get { return getAttrVal<string>("Price_ratio",null); }
            set { setAttrVal<string>("Price_ratio", value); }
        }

        /// <summary>
        /// 标准价
        /// </summary>
		public FDouble Price_standard {
            get { return getAttrVal<FDouble>("Price_standard",null); }
            set { setAttrVal<FDouble>("Price_standard", value); }
        }

        /// <summary>
        /// 自定义标识
        /// </summary>
		public bool? Fg_selfsrv {
            get { return getAttrVal<FBoolean>("Fg_selfsrv",null); }
            set { setAttrVal<FBoolean>("Fg_selfsrv", value); }
        }

        /// <summary>
        /// 自付费标识
        /// </summary>
		public bool? Fg_selfpay {
            get { return getAttrVal<FBoolean>("Fg_selfpay",null); }
            set { setAttrVal<FBoolean>("Fg_selfpay", value); }
        }

        /// <summary>
        /// 医保适应症标识
        /// </summary>
		public bool? Fg_indic {
            get { return getAttrVal<FBoolean>("Fg_indic",null); }
            set { setAttrVal<FBoolean>("Fg_indic", value); }
        }

        /// <summary>
        /// 治疗用药标识
        /// </summary>
		public bool? Fg_treat {
            get { return getAttrVal<FBoolean>("Fg_treat",null); }
            set { setAttrVal<FBoolean>("Fg_treat", value); }
        }

        /// <summary>
        /// 执行科室ID
        /// </summary>
		public string Id_dep_mp {
            get { return getAttrVal<string>("Id_dep_mp",null); }
            set { setAttrVal<string>("Id_dep_mp", value); }
        }

        /// <summary>
        /// 执行科室
        /// </summary>
		public string Name_dep_mp {
            get { return getAttrVal<string>("Name_dep_mp",null); }
            set { setAttrVal<string>("Name_dep_mp", value); }
        }

        /// <summary>
        /// 执行科室过滤条件
        /// </summary>
		public string Filter_dep_mp {
            get { return getAttrVal<string>("Filter_dep_mp",null); }
            set { setAttrVal<string>("Filter_dep_mp", value); }
        }

        /// <summary>
        /// 换算系数_医基
        /// </summary>
		public FDouble Factor_mb {
            get { return getAttrVal<FDouble>("Factor_mb",null); }
            set { setAttrVal<FDouble>("Factor_mb", value); }
        }

        /// <summary>
        /// 换算系数_当前
        /// </summary>
		public FDouble Factor_cb {
            get { return getAttrVal<FDouble>("Factor_cb",null); }
            set { setAttrVal<FDouble>("Factor_cb", value); }
        }

        /// <summary>
        /// 包装单位门诊取整模式
        /// </summary>
		public string Sd_opmutp {
            get { return getAttrVal<string>("Sd_opmutp",null); }
            set { setAttrVal<string>("Sd_opmutp", value); }
        }

        /// <summary>
        /// 物品ID
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
            return new string[]{ "Id_srv", "Name_srv", "Sd_srvtp", "Name_mm", "Spec_mm", "Quan_med", "Id_unit_med", "Name_unit_med", "Id_route", "Name_route", "Filter_route", "Id_freq", "Name_freq", "Sd_frequnitct", "Freqct", "Usedays", "Quan_cur", "Id_dep_wh", "Name_dep_wh", "Filter_dep_wh", "Price", "Amount", "Fg_extdispense", "Id_unit_sale", "Name_unit_sale", "Price_ratio", "Price_standard", "Fg_selfsrv", "Fg_selfpay", "Fg_indic", "Fg_treat", "Id_dep_mp", "Name_dep_mp", "Filter_dep_mp", "Factor_mb", "Factor_cb", "Sd_opmutp", "Id_mm"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.dto.ems.uiemsdto.d.EmsDrugsItemViewDTO";
        }
    }
}
