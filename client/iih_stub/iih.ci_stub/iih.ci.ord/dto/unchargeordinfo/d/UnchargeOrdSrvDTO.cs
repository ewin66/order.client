using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.dto.unchargeordinfo.d
{
    /// <summary>
    /// UnchargeOrdSrvDTO 的摘要说明。
    /// </summary>
    public class UnchargeOrdSrvDTO : BaseDTO {

        public UnchargeOrdSrvDTO() {
 
        }

        /// <summary>
        /// 医嘱项目
        /// </summary>
		public string Id_orsrv {
            get { return getAttrVal<string>("Id_orsrv",null); }
            set { setAttrVal<string>("Id_orsrv", value); }
        }

        /// <summary>
        /// 医嘱
        /// </summary>
		public string Id_or {
            get { return getAttrVal<string>("Id_or",null); }
            set { setAttrVal<string>("Id_or", value); }
        }

        /// <summary>
        /// 处方
        /// </summary>
		public string Id_pres {
            get { return getAttrVal<string>("Id_pres",null); }
            set { setAttrVal<string>("Id_pres", value); }
        }

        /// <summary>
        /// 患者
        /// </summary>
		public string Id_pat {
            get { return getAttrVal<string>("Id_pat",null); }
            set { setAttrVal<string>("Id_pat", value); }
        }

        /// <summary>
        /// 就诊类型
        /// </summary>
		public string Id_entp {
            get { return getAttrVal<string>("Id_entp",null); }
            set { setAttrVal<string>("Id_entp", value); }
        }

        /// <summary>
        /// 就诊类型编码
        /// </summary>
		public string Code_entp {
            get { return getAttrVal<string>("Code_entp",null); }
            set { setAttrVal<string>("Code_entp", value); }
        }

        /// <summary>
        /// 就诊
        /// </summary>
		public string Id_en {
            get { return getAttrVal<string>("Id_en",null); }
            set { setAttrVal<string>("Id_en", value); }
        }

        /// <summary>
        /// 序号
        /// </summary>
		public int? Sortno {
            get { return getAttrVal<int?>("Sortno",null); }
            set { setAttrVal<int?>("Sortno", value); }
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
        /// 服务
        /// </summary>
		public string Id_srv {
            get { return getAttrVal<string>("Id_srv",null); }
            set { setAttrVal<string>("Id_srv", value); }
        }

        /// <summary>
        /// 服务项目名称
        /// </summary>
		public string Name_srv {
            get { return getAttrVal<string>("Name_srv",null); }
            set { setAttrVal<string>("Name_srv", value); }
        }

        /// <summary>
        /// 医学单位数量
        /// </summary>
		public string Quan_med {
            get { return getAttrVal<string>("Quan_med",null); }
            set { setAttrVal<string>("Quan_med", value); }
        }

        /// <summary>
        /// 医学单位
        /// </summary>
		public string Id_unit_med {
            get { return getAttrVal<string>("Id_unit_med",null); }
            set { setAttrVal<string>("Id_unit_med", value); }
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
        /// 中药煎法
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
        /// 频次
        /// </summary>
		public string Id_freq {
            get { return getAttrVal<string>("Id_freq",null); }
            set { setAttrVal<string>("Id_freq", value); }
        }

        /// <summary>
        /// 服务项目开立机构
        /// </summary>
		public string Id_org_srv {
            get { return getAttrVal<string>("Id_org_srv",null); }
            set { setAttrVal<string>("Id_org_srv", value); }
        }

        /// <summary>
        /// 服务项目开立部门
        /// </summary>
		public string Id_dep_srv {
            get { return getAttrVal<string>("Id_dep_srv",null); }
            set { setAttrVal<string>("Id_dep_srv", value); }
        }

        /// <summary>
        /// 服务项目开立医疗组
        /// </summary>
		public string Id_wg_srv {
            get { return getAttrVal<string>("Id_wg_srv",null); }
            set { setAttrVal<string>("Id_wg_srv", value); }
        }

        /// <summary>
        /// 服务项目开立医生
        /// </summary>
		public string Id_emp_srv {
            get { return getAttrVal<string>("Id_emp_srv",null); }
            set { setAttrVal<string>("Id_emp_srv", value); }
        }

        /// <summary>
        /// 执行机构
        /// </summary>
		public string Id_org_mp {
            get { return getAttrVal<string>("Id_org_mp",null); }
            set { setAttrVal<string>("Id_org_mp", value); }
        }

        /// <summary>
        /// 执行科室
        /// </summary>
		public string Id_dep_mp {
            get { return getAttrVal<string>("Id_dep_mp",null); }
            set { setAttrVal<string>("Id_dep_mp", value); }
        }

        /// <summary>
        /// 执行状态
        /// </summary>
		public string Id_su_mp {
            get { return getAttrVal<string>("Id_su_mp",null); }
            set { setAttrVal<string>("Id_su_mp", value); }
        }

        /// <summary>
        /// 执行状态编码
        /// </summary>
		public string Sd_su_mp {
            get { return getAttrVal<string>("Sd_su_mp",null); }
            set { setAttrVal<string>("Sd_su_mp", value); }
        }

        /// <summary>
        /// 记账状态
        /// </summary>
		public string Id_su_bl {
            get { return getAttrVal<string>("Id_su_bl",null); }
            set { setAttrVal<string>("Id_su_bl", value); }
        }

        /// <summary>
        /// 记账状态编码
        /// </summary>
		public string Sd_su_bl {
            get { return getAttrVal<string>("Sd_su_bl",null); }
            set { setAttrVal<string>("Sd_su_bl", value); }
        }

        /// <summary>
        /// 最近记账日期
        /// </summary>
		public DateTime? Dt_bl_last {
            get { return getAttrVal<FDateTime>("Dt_bl_last",null); }
            set { setAttrVal<FDateTime>("Dt_bl_last", value); }
        }

        /// <summary>
        /// 物品标识
        /// </summary>
		public bool? Fg_mm {
            get { return getAttrVal<FBoolean>("Fg_mm",null); }
            set { setAttrVal<FBoolean>("Fg_mm", value); }
        }

        /// <summary>
        /// 医保适应症
        /// </summary>
		public bool? Fg_indic {
            get { return getAttrVal<FBoolean>("Fg_indic",null); }
            set { setAttrVal<FBoolean>("Fg_indic", value); }
        }

        /// <summary>
        /// 预防用药标识
        /// </summary>
		public bool? Fg_propc {
            get { return getAttrVal<FBoolean>("Fg_propc",null); }
            set { setAttrVal<FBoolean>("Fg_propc", value); }
        }

        /// <summary>
        /// 自备药标识
        /// </summary>
		public bool? Fg_self {
            get { return getAttrVal<FBoolean>("Fg_self",null); }
            set { setAttrVal<FBoolean>("Fg_self", value); }
        }

        /// <summary>
        /// 医嘱服务物品
        /// </summary>
		public string Id_orsrvmm {
            get { return getAttrVal<string>("Id_orsrvmm",null); }
            set { setAttrVal<string>("Id_orsrvmm", value); }
        }

        /// <summary>
        /// 医疗物品
        /// </summary>
		public string Id_mm {
            get { return getAttrVal<string>("Id_mm",null); }
            set { setAttrVal<string>("Id_mm", value); }
        }

        /// <summary>
        /// 数量_当前
        /// </summary>
		public double? Quan_cur {
            get { return getAttrVal<FDouble>("Quan_cur",null); }
            set { setAttrVal<FDouble>("Quan_cur", value); }
        }

        /// <summary>
        /// 数量_基本
        /// </summary>
		public double? Quan_base {
            get { return getAttrVal<FDouble>("Quan_base",null); }
            set { setAttrVal<FDouble>("Quan_base", value); }
        }

        /// <summary>
        /// 单位_当前
        /// </summary>
		public string Id_unit_cur {
            get { return getAttrVal<string>("Id_unit_cur",null); }
            set { setAttrVal<string>("Id_unit_cur", value); }
        }

        /// <summary>
        /// 单位_基本
        /// </summary>
		public string Id_unit_base {
            get { return getAttrVal<string>("Id_unit_base",null); }
            set { setAttrVal<string>("Id_unit_base", value); }
        }

        /// <summary>
        /// 当前基本换算系数
        /// </summary>
		public double? Factor_cb {
            get { return getAttrVal<FDouble>("Factor_cb",null); }
            set { setAttrVal<FDouble>("Factor_cb", value); }
        }

        /// <summary>
        /// 物品编码
        /// </summary>
		public string Code_mm {
            get { return getAttrVal<string>("Code_mm",null); }
            set { setAttrVal<string>("Code_mm", value); }
        }

        /// <summary>
        /// 物品类型编码
        /// </summary>
		public string Sd_mmtp {
            get { return getAttrVal<string>("Sd_mmtp",null); }
            set { setAttrVal<string>("Sd_mmtp", value); }
        }

        /// <summary>
        /// 物品类型
        /// </summary>
		public string Id_mmtp {
            get { return getAttrVal<string>("Id_mmtp",null); }
            set { setAttrVal<string>("Id_mmtp", value); }
        }

        /// <summary>
        /// 服务编码
        /// </summary>
		public string Code_srv {
            get { return getAttrVal<string>("Code_srv",null); }
            set { setAttrVal<string>("Code_srv", value); }
        }

        /// <summary>
        /// 患者价格类型
        /// </summary>
		public string Id_pripat {
            get { return getAttrVal<string>("Id_pripat",null); }
            set { setAttrVal<string>("Id_pripat", value); }
        }

        /// <summary>
        /// 库房
        /// </summary>
		public string Id_dep_wh {
            get { return getAttrVal<string>("Id_dep_wh",null); }
            set { setAttrVal<string>("Id_dep_wh", value); }
        }

        /// <summary>
        /// 签署时间
        /// </summary>
		public DateTime? Dt_sign {
            get { return getAttrVal<FDateTime>("Dt_sign",null); }
            set { setAttrVal<FDateTime>("Dt_sign", value); }
        }

        /// <summary>
        /// 物品名称
        /// </summary>
		public string Name_mm {
            get { return getAttrVal<string>("Name_mm",null); }
            set { setAttrVal<string>("Name_mm", value); }
        }

        /// <summary>
        /// 医保信息
        /// </summary>
		public string Id_hp {
            get { return getAttrVal<string>("Id_hp",null); }
            set { setAttrVal<string>("Id_hp", value); }
        }

        /// <summary>
        /// 医保服务类型
        /// </summary>
		public string Id_hpsrvtp {
            get { return getAttrVal<string>("Id_hpsrvtp",null); }
            set { setAttrVal<string>("Id_hpsrvtp", value); }
        }

        /// <summary>
        /// 医保服务类型编码
        /// </summary>
		public string Sd_hpsrvtp {
            get { return getAttrVal<string>("Sd_hpsrvtp",null); }
            set { setAttrVal<string>("Sd_hpsrvtp", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_orsrv", "Id_or", "Id_pres", "Id_pat", "Id_entp", "Code_entp", "Id_en", "Sortno", "Id_srvtp", "Sd_srvtp", "Id_srv", "Name_srv", "Quan_med", "Id_unit_med", "Id_route", "Id_routedes", "Id_boil", "Id_boildes", "Id_freq", "Id_org_srv", "Id_dep_srv", "Id_wg_srv", "Id_emp_srv", "Id_org_mp", "Id_dep_mp", "Id_su_mp", "Sd_su_mp", "Id_su_bl", "Sd_su_bl", "Dt_bl_last", "Fg_mm", "Fg_indic", "Fg_propc", "Fg_self", "Id_orsrvmm", "Id_mm", "Quan_cur", "Quan_base", "Id_unit_cur", "Id_unit_base", "Factor_cb", "Code_mm", "Sd_mmtp", "Id_mmtp", "Code_srv", "Id_pripat", "Id_dep_wh", "Dt_sign", "Name_mm", "Id_hp", "Id_hpsrvtp", "Sd_hpsrvtp"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.dto.unchargeordinfo.d.UnchargeOrdSrvDTO";
        }
    }
}
