using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.dto.ordermr.d
{
    /// <summary>
    /// OrderMrDto 的摘要说明。
    /// </summary>
    public class OrderMrDto : BaseDTO {

        public OrderMrDto() {
 
        }

        /// <summary>
        /// 医嘱
        /// </summary>
		public string Id_or {
            get { return getAttrVal<string>("Id_or",null); }
            set { setAttrVal<string>("Id_or", value); }
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
        /// 长临
        /// </summary>
		public string Fg_long {
            get { return getAttrVal<string>("Fg_long",null); }
            set { setAttrVal<string>("Fg_long", value); }
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
        /// 用法要求
        /// </summary>
		public string Id_routedes {
            get { return getAttrVal<string>("Id_routedes",null); }
            set { setAttrVal<string>("Id_routedes", value); }
        }

        /// <summary>
        /// 用法要求描述
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
        /// 医嘱天数
        /// </summary>
		public int? Days_or {
            get { return getAttrVal<int?>("Days_or",null); }
            set { setAttrVal<int?>("Days_or", value); }
        }

        /// <summary>
        /// 代煎付数
        /// </summary>
		public int? Orders_boil {
            get { return getAttrVal<int?>("Orders_boil",null); }
            set { setAttrVal<int?>("Orders_boil", value); }
        }

        /// <summary>
        /// 总数量
        /// </summary>
		public int? Orders {
            get { return getAttrVal<int?>("Orders",null); }
            set { setAttrVal<int?>("Orders", value); }
        }

        /// <summary>
        /// 医嘱名称
        /// </summary>
		public string Name {
            get { return getAttrVal<string>("Name",null); }
            set { setAttrVal<string>("Name", value); }
        }

        /// <summary>
        /// 医嘱内容
        /// </summary>
		public string Content_or {
            get { return getAttrVal<string>("Content_or",null); }
            set { setAttrVal<string>("Content_or", value); }
        }

        /// <summary>
        /// 开立医生
        /// </summary>
		public string Id_emp_phy {
            get { return getAttrVal<string>("Id_emp_phy",null); }
            set { setAttrVal<string>("Id_emp_phy", value); }
        }

        /// <summary>
        /// 开立医生姓名
        /// </summary>
		public string Name_emp_phy {
            get { return getAttrVal<string>("Name_emp_phy",null); }
            set { setAttrVal<string>("Name_emp_phy", value); }
        }

        /// <summary>
        /// 开立科室
        /// </summary>
		public string Id_dep_phy {
            get { return getAttrVal<string>("Id_dep_phy",null); }
            set { setAttrVal<string>("Id_dep_phy", value); }
        }

        /// <summary>
        /// 开立科室名称
        /// </summary>
		public string Name_dep_phy {
            get { return getAttrVal<string>("Name_dep_phy",null); }
            set { setAttrVal<string>("Name_dep_phy", value); }
        }

        /// <summary>
        /// 医疗组
        /// </summary>
		public string Id_wg_or {
            get { return getAttrVal<string>("Id_wg_or",null); }
            set { setAttrVal<string>("Id_wg_or", value); }
        }

        /// <summary>
        /// 开始日期
        /// </summary>
		public DateTime? Dt_effe {
            get { return getAttrVal<FDateTime>("Dt_effe",null); }
            set { setAttrVal<FDateTime>("Dt_effe", value); }
        }

        /// <summary>
        /// 结束日期
        /// </summary>
		public DateTime? Dt_end {
            get { return getAttrVal<FDateTime>("Dt_end",null); }
            set { setAttrVal<FDateTime>("Dt_end", value); }
        }

        /// <summary>
        /// 备注
        /// </summary>
		public string Note {
            get { return getAttrVal<string>("Note",null); }
            set { setAttrVal<string>("Note", value); }
        }

        /// <summary>
        /// 状态编码
        /// </summary>
		public double? Sd_su_or {
            get { return getAttrVal<FDouble>("Sd_su_or",null); }
            set { setAttrVal<FDouble>("Sd_su_or", value); }
        }

        /// <summary>
        /// 状态名称
        /// </summary>
		public string Name_su_or {
            get { return getAttrVal<string>("Name_su_or",null); }
            set { setAttrVal<string>("Name_su_or", value); }
        }

        /// <summary>
        /// 医托
        /// </summary>
		public string Order_support {
            get { return getAttrVal<string>("Order_support",null); }
            set { setAttrVal<string>("Order_support", value); }
        }

        /// <summary>
        /// 剂量
        /// </summary>
		public string Quan_num_base {
            get { return getAttrVal<string>("Quan_num_base",null); }
            set { setAttrVal<string>("Quan_num_base", value); }
        }

        /// <summary>
        /// 计量单位
        /// </summary>
		public string Id_medu {
            get { return getAttrVal<string>("Id_medu",null); }
            set { setAttrVal<string>("Id_medu", value); }
        }

        /// <summary>
        /// 计量单位名称
        /// </summary>
		public string Id_medu_name {
            get { return getAttrVal<string>("Id_medu_name",null); }
            set { setAttrVal<string>("Id_medu_name", value); }
        }

        /// <summary>
        /// 停止核对时间
        /// </summary>
		public DateTime? Dt_chk_stop {
            get { return getAttrVal<FDateTime>("Dt_chk_stop",null); }
            set { setAttrVal<FDateTime>("Dt_chk_stop", value); }
        }

        /// <summary>
        /// 药品类型
        /// </summary>
		public string Id_mmtp {
            get { return getAttrVal<string>("Id_mmtp",null); }
            set { setAttrVal<string>("Id_mmtp", value); }
        }

        /// <summary>
        /// 药品类型编码
        /// </summary>
		public string Sd_mmtp {
            get { return getAttrVal<string>("Sd_mmtp",null); }
            set { setAttrVal<string>("Sd_mmtp", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_or", "Id_pat", "Id_en", "Id_entp", "Code_entp", "Fg_long", "Id_srvtp", "Sd_srvtp", "Id_freq", "Name_freq", "Id_route", "Name_route", "Id_routedes", "Name_routedes", "Id_boil", "Name_boil", "Id_boildes", "Name_boildes", "Days_or", "Orders_boil", "Orders", "Name", "Content_or", "Id_emp_phy", "Name_emp_phy", "Id_dep_phy", "Name_dep_phy", "Id_wg_or", "Dt_effe", "Dt_end", "Note", "Sd_su_or", "Name_su_or", "Order_support", "Quan_num_base", "Id_medu", "Id_medu_name", "Dt_chk_stop", "Id_mmtp", "Sd_mmtp"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.dto.ordermr.d.OrderMrDto";
        }
    }
}
