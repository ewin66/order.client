using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.dto.ordpres.d
{
    /// <summary>
    /// PresDrugDTO 的摘要说明。
    /// </summary>
    public class PresDrugDTO : BaseDTO {

        public PresDrugDTO() {
 
        }

        /// <summary>
        /// 医嘱服务
        /// </summary>
		public string Id_ordsrv {
            get { return getAttrVal<string>("Id_ordsrv",null); }
            set { setAttrVal<string>("Id_ordsrv", value); }
        }

        /// <summary>
        /// 处方
        /// </summary>
		public string Id_pres {
            get { return getAttrVal<string>("Id_pres",null); }
            set { setAttrVal<string>("Id_pres", value); }
        }

        /// <summary>
        /// 医嘱
        /// </summary>
		public string Id_or {
            get { return getAttrVal<string>("Id_or",null); }
            set { setAttrVal<string>("Id_or", value); }
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
        /// 医疗服务
        /// </summary>
		public string Id_srv {
            get { return getAttrVal<string>("Id_srv",null); }
            set { setAttrVal<string>("Id_srv", value); }
        }

        /// <summary>
        /// 医疗服务编码
        /// </summary>
		public string Code_srv {
            get { return getAttrVal<string>("Code_srv",null); }
            set { setAttrVal<string>("Code_srv", value); }
        }

        /// <summary>
        /// 医疗服务名称
        /// </summary>
		public string Name_srv {
            get { return getAttrVal<string>("Name_srv",null); }
            set { setAttrVal<string>("Name_srv", value); }
        }

        /// <summary>
        /// 医疗单位
        /// </summary>
		public string Id_unit_med {
            get { return getAttrVal<string>("Id_unit_med",null); }
            set { setAttrVal<string>("Id_unit_med", value); }
        }

        /// <summary>
        /// 医疗单位编码
        /// </summary>
		public string Name_unit_med {
            get { return getAttrVal<string>("Name_unit_med",null); }
            set { setAttrVal<string>("Name_unit_med", value); }
        }

        /// <summary>
        /// 数量_医疗单位
        /// </summary>
		public double? Quan_med {
            get { return getAttrVal<FDouble>("Quan_med",null); }
            set { setAttrVal<FDouble>("Quan_med", value); }
        }

        /// <summary>
        /// 医嘱频次
        /// </summary>
		public string Id_freq {
            get { return getAttrVal<string>("Id_freq",null); }
            set { setAttrVal<string>("Id_freq", value); }
        }

        /// <summary>
        /// 医嘱频次名称
        /// </summary>
		public string Name_freq {
            get { return getAttrVal<string>("Name_freq",null); }
            set { setAttrVal<string>("Name_freq", value); }
        }

        /// <summary>
        /// 用法标识
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
        /// 用法要求标识
        /// </summary>
		public string Id_routedes {
            get { return getAttrVal<string>("Id_routedes",null); }
            set { setAttrVal<string>("Id_routedes", value); }
        }

        /// <summary>
        /// 用法要求
        /// </summary>
		public string Name_routedes {
            get { return getAttrVal<string>("Name_routedes",null); }
            set { setAttrVal<string>("Name_routedes", value); }
        }

        /// <summary>
        /// 煎法标识
        /// </summary>
		public string Id_boil {
            get { return getAttrVal<string>("Id_boil",null); }
            set { setAttrVal<string>("Id_boil", value); }
        }

        /// <summary>
        /// 煎法
        /// </summary>
		public string Name_boil {
            get { return getAttrVal<string>("Name_boil",null); }
            set { setAttrVal<string>("Name_boil", value); }
        }

        /// <summary>
        /// 煎法要求标识
        /// </summary>
		public string Id_boildes {
            get { return getAttrVal<string>("Id_boildes",null); }
            set { setAttrVal<string>("Id_boildes", value); }
        }

        /// <summary>
        /// 煎法要求
        /// </summary>
		public string Name_boildes {
            get { return getAttrVal<string>("Name_boildes",null); }
            set { setAttrVal<string>("Name_boildes", value); }
        }

        /// <summary>
        /// 费用标识
        /// </summary>
		public bool? Fg_bl {
            get { return getAttrVal<FBoolean>("Fg_bl",null); }
            set { setAttrVal<FBoolean>("Fg_bl", value); }
        }

        /// <summary>
        /// 参考价格
        /// </summary>
		public double? Price {
            get { return getAttrVal<FDouble>("Price",null); }
            set { setAttrVal<FDouble>("Price", value); }
        }

        /// <summary>
        /// 服务项目物品
        /// </summary>
		public string Id_orsrvmm {
            get { return getAttrVal<string>("Id_orsrvmm",null); }
            set { setAttrVal<string>("Id_orsrvmm", value); }
        }

        /// <summary>
        /// 物品
        /// </summary>
		public string Id_mm {
            get { return getAttrVal<string>("Id_mm",null); }
            set { setAttrVal<string>("Id_mm", value); }
        }

        /// <summary>
        /// 物品名称
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
        /// 生产厂商
        /// </summary>
		public string Id_manufacture {
            get { return getAttrVal<string>("Id_manufacture",null); }
            set { setAttrVal<string>("Id_manufacture", value); }
        }

        /// <summary>
        /// 生产厂商名称
        /// </summary>
		public string Name_manufacture {
            get { return getAttrVal<string>("Name_manufacture",null); }
            set { setAttrVal<string>("Name_manufacture", value); }
        }

        /// <summary>
        /// 零售单位
        /// </summary>
		public string Id_unit_sale {
            get { return getAttrVal<string>("Id_unit_sale",null); }
            set { setAttrVal<string>("Id_unit_sale", value); }
        }

        /// <summary>
        /// 零售单位名称
        /// </summary>
		public string Name_unit_sale {
            get { return getAttrVal<string>("Name_unit_sale",null); }
            set { setAttrVal<string>("Name_unit_sale", value); }
        }

        /// <summary>
        /// 基本单位
        /// </summary>
		public string Id_unit_base {
            get { return getAttrVal<string>("Id_unit_base",null); }
            set { setAttrVal<string>("Id_unit_base", value); }
        }

        /// <summary>
        /// 基本单位名称
        /// </summary>
		public string Name_unit_base {
            get { return getAttrVal<string>("Name_unit_base",null); }
            set { setAttrVal<string>("Name_unit_base", value); }
        }

        /// <summary>
        /// 数量_当前
        /// </summary>
		public double? Quan_cur {
            get { return getAttrVal<FDouble>("Quan_cur",null); }
            set { setAttrVal<FDouble>("Quan_cur", value); }
        }

        /// <summary>
        /// 数量_退药
        /// </summary>
		public double? Quan_cur_rtn {
            get { return getAttrVal<FDouble>("Quan_cur_rtn",null); }
            set { setAttrVal<FDouble>("Quan_cur_rtn", value); }
        }

        /// <summary>
        /// 数量_基本
        /// </summary>
		public double? Quan_base {
            get { return getAttrVal<FDouble>("Quan_base",null); }
            set { setAttrVal<FDouble>("Quan_base", value); }
        }

        /// <summary>
        /// 当前基本换算系数
        /// </summary>
		public double? Factor_cb {
            get { return getAttrVal<FDouble>("Factor_cb",null); }
            set { setAttrVal<FDouble>("Factor_cb", value); }
        }

        /// <summary>
        /// 医疗基本换算系数
        /// </summary>
		public double? Factor_mb {
            get { return getAttrVal<FDouble>("Factor_mb",null); }
            set { setAttrVal<FDouble>("Factor_mb", value); }
        }

        /// <summary>
        /// 应收金额
        /// </summary>
		public double? Amt_should {
            get { return getAttrVal<FDouble>("Amt_should",null); }
            set { setAttrVal<FDouble>("Amt_should", value); }
        }

        /// <summary>
        /// 实收金额
        /// </summary>
		public double? Amt_real {
            get { return getAttrVal<FDouble>("Amt_real",null); }
            set { setAttrVal<FDouble>("Amt_real", value); }
        }

        /// <summary>
        /// 退费金额
        /// </summary>
		public string Amt_rtn {
            get { return getAttrVal<string>("Amt_rtn",null); }
            set { setAttrVal<string>("Amt_rtn", value); }
        }

        /// <summary>
        /// 序号
        /// </summary>
		public int? Sortno {
            get { return getAttrVal<int?>("Sortno",null); }
            set { setAttrVal<int?>("Sortno", value); }
        }

        /// <summary>
        /// 使用周期
        /// </summary>
		public int? Use_day {
            get { return getAttrVal<int?>("Use_days",null); }
            set { setAttrVal<int?>("Use_days", value); }
        }

        /// <summary>
        /// 单次用量分子
        /// </summary>
		public int? Quan_num_base {
            get { return getAttrVal<int?>("Quan_num_base",null); }
            set { setAttrVal<int?>("Quan_num_base", value); }
        }

        /// <summary>
        /// 单次用量分母
        /// </summary>
		public int? Quan_den_base {
            get { return getAttrVal<int?>("Quan_den_base",null); }
            set { setAttrVal<int?>("Quan_den_base", value); }
        }

        /// <summary>
        /// 用量
        /// </summary>
		public string Des_uselevel {
            get { return getAttrVal<string>("Des_uselevel",null); }
            set { setAttrVal<string>("Des_uselevel", value); }
        }

        /// <summary>
        /// 医保目录_药品
        /// </summary>
		public string Name_hpsrvtp {
            get { return getAttrVal<string>("Name_hpsrvtp",null); }
            set { setAttrVal<string>("Name_hpsrvtp", value); }
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
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_ordsrv", "Id_pres", "Id_or", "Id_srvtp", "Sd_srvtp", "Id_srv", "Code_srv", "Name_srv", "Id_unit_med", "Name_unit_med", "Quan_med", "Id_freq", "Name_freq", "Id_route", "Name_route", "Id_routedes", "Name_routedes", "Id_boil", "Name_boil", "Id_boildes", "Name_boildes", "Fg_bl", "Price", "Id_orsrvmm", "Id_mm", "Name_mm", "Spec_mm", "Id_manufacture", "Name_manufacture", "Id_unit_sale", "Name_unit_sale", "Id_unit_base", "Name_unit_base", "Quan_cur", "Quan_cur_rtn", "Quan_base", "Factor_cb", "Factor_mb", "Amt_should", "Amt_real", "Amt_rtn", "Sortno", "Use_days", "Quan_num_base", "Quan_den_base", "Des_uselevel", "Name_hpsrvtp", "Id_dep_mp", "Name_dep_mp"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.dto.ordpres.d.PresDrugDTO";
        }
    }
}
