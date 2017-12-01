using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.dto.OrderPresSplitDTO.d
{
    /// <summary>
    /// OrderPresSplitDTO 的摘要说明。
    /// </summary>
    public class OrderPresSplitDTO : BaseDTO {

        public OrderPresSplitDTO() {
 
        }

        /// <summary>
        /// 医嘱
        /// </summary>
		public string Id_or {
            get { return getAttrVal<string>("Id_or",null); }
            set { setAttrVal<string>("Id_or", value); }
        }

        /// <summary>
        /// 毒麻分类
        /// </summary>
		public string Sd_pois {
            get { return getAttrVal<string>("Sd_pois",null); }
            set { setAttrVal<string>("Sd_pois", value); }
        }

        /// <summary>
        /// 精一
        /// </summary>
		public string Mental1 {
            get { return getAttrVal<string>("Mental1",null); }
            set { setAttrVal<string>("Mental1", value); }
        }

        /// <summary>
        /// 精二
        /// </summary>
		public string Mental2 {
            get { return getAttrVal<string>("Mental2",null); }
            set { setAttrVal<string>("Mental2", value); }
        }

        /// <summary>
        /// 管控
        /// </summary>
		public string Control {
            get { return getAttrVal<string>("Control",null); }
            set { setAttrVal<string>("Control", value); }
        }

        /// <summary>
        /// 一般
        /// </summary>
		public string Ordinary {
            get { return getAttrVal<string>("Ordinary",null); }
            set { setAttrVal<string>("Ordinary", value); }
        }

        /// <summary>
        /// 服务类型
        /// </summary>
		public string Sd_srvtp {
            get { return getAttrVal<string>("Sd_srvtp",null); }
            set { setAttrVal<string>("Sd_srvtp", value); }
        }

        /// <summary>
        /// 执行科室
        /// </summary>
		public string Id_dep_mp {
            get { return getAttrVal<string>("Id_dep_mp",null); }
            set { setAttrVal<string>("Id_dep_mp", value); }
        }

        /// <summary>
        /// 婴儿标志
        /// </summary>
		public bool? Fg_bb {
            get { return getAttrVal<FBoolean>("Fg_bb",null); }
            set { setAttrVal<FBoolean>("Fg_bb", value); }
        }

        /// <summary>
        /// 就诊类型
        /// </summary>
		public string Id_entp {
            get { return getAttrVal<string>("Id_entp",null); }
            set { setAttrVal<string>("Id_entp", value); }
        }

        /// <summary>
        /// 机构
        /// </summary>
		public string Id_grp {
            get { return getAttrVal<string>("Id_grp",null); }
            set { setAttrVal<string>("Id_grp", value); }
        }

        /// <summary>
        /// 组织
        /// </summary>
		public string Id_org {
            get { return getAttrVal<string>("Id_org",null); }
            set { setAttrVal<string>("Id_org", value); }
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
        /// 服务
        /// </summary>
		public string Id_srvtp {
            get { return getAttrVal<string>("Id_srvtp",null); }
            set { setAttrVal<string>("Id_srvtp", value); }
        }

        /// <summary>
        /// 婴儿序号
        /// </summary>
		public int? No_bb {
            get { return getAttrVal<int?>("No_bb",null); }
            set { setAttrVal<int?>("No_bb", value); }
        }

        /// <summary>
        /// 开立时间
        /// </summary>
		public DateTime? Dt_entry {
            get { return getAttrVal<FDateTime>("Dt_entry",null); }
            set { setAttrVal<FDateTime>("Dt_entry", value); }
        }

        /// <summary>
        /// 开立人
        /// </summary>
		public string Id_emp_or {
            get { return getAttrVal<string>("Id_emp_or",null); }
            set { setAttrVal<string>("Id_emp_or", value); }
        }

        /// <summary>
        /// 开立科室
        /// </summary>
		public string Id_dep_or {
            get { return getAttrVal<string>("Id_dep_or",null); }
            set { setAttrVal<string>("Id_dep_or", value); }
        }

        /// <summary>
        /// 服务项目id
        /// </summary>
		public string Id_orsrv {
            get { return getAttrVal<string>("Id_orsrv",null); }
            set { setAttrVal<string>("Id_orsrv", value); }
        }

        /// <summary>
        /// 医疗用法
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
        /// 签署医生
        /// </summary>
		public string Id_emp_sign {
            get { return getAttrVal<string>("Id_emp_sign",null); }
            set { setAttrVal<string>("Id_emp_sign", value); }
        }

        /// <summary>
        /// 就诊类型编码
        /// </summary>
		public string Code_entp {
            get { return getAttrVal<string>("Code_entp",null); }
            set { setAttrVal<string>("Code_entp", value); }
        }

        /// <summary>
        /// 参考价格
        /// </summary>
		public double? Pri {
            get { return getAttrVal<FDouble>("Pri",null); }
            set { setAttrVal<FDouble>("Pri", value); }
        }

        /// <summary>
        /// 服务项目名称
        /// </summary>
		public string Name_srv {
            get { return getAttrVal<string>("Name_srv",null); }
            set { setAttrVal<string>("Name_srv", value); }
        }

        /// <summary>
        /// 医保类型
        /// </summary>
		public string Health_type {
            get { return getAttrVal<string>("Health_type",null); }
            set { setAttrVal<string>("Health_type", value); }
        }

        /// <summary>
        /// 处方ID
        /// </summary>
		public string Id_pres {
            get { return getAttrVal<string>("Id_pres",null); }
            set { setAttrVal<string>("Id_pres", value); }
        }

        /// <summary>
        /// 开立科室名称
        /// </summary>
		public string Name_dep_or {
            get { return getAttrVal<string>("Name_dep_or",null); }
            set { setAttrVal<string>("Name_dep_or", value); }
        }

        /// <summary>
        /// 开立人姓名
        /// </summary>
		public string Name_emp_or {
            get { return getAttrVal<string>("Name_emp_or",null); }
            set { setAttrVal<string>("Name_emp_or", value); }
        }

        /// <summary>
        /// 医保
        /// </summary>
		public string Fg_hp_pres {
            get { return getAttrVal<string>("Fg_hp_pres",null); }
            set { setAttrVal<string>("Fg_hp_pres", value); }
        }

        /// <summary>
        /// 处方类型
        /// </summary>
		public string Sd_prestp {
            get { return getAttrVal<string>("Sd_prestp",null); }
            set { setAttrVal<string>("Sd_prestp", value); }
        }

        /// <summary>
        /// 选择标志
        /// </summary>
		public bool? Fg_chk {
            get { return getAttrVal<FBoolean>("Fg_chk",null); }
            set { setAttrVal<FBoolean>("Fg_chk", value); }
        }

        /// <summary>
        /// 处方号
        /// </summary>
		public string Code {
            get { return getAttrVal<string>("Code",null); }
            set { setAttrVal<string>("Code", value); }
        }

        /// <summary>
        /// 执行科室名称
        /// </summary>
		public string Name_dep_mp {
            get { return getAttrVal<string>("Name_dep_mp",null); }
            set { setAttrVal<string>("Name_dep_mp", value); }
        }

        /// <summary>
        /// 数量
        /// </summary>
		public double? Quan_cur {
            get { return getAttrVal<FDouble>("Quan_cur",null); }
            set { setAttrVal<FDouble>("Quan_cur", value); }
        }

        /// <summary>
        /// 医保名称
        /// </summary>
		public string Name_fg_hp {
            get { return getAttrVal<string>("Name_fg_hp",null); }
            set { setAttrVal<string>("Name_fg_hp", value); }
        }

        /// <summary>
        /// 处方类型名称
        /// </summary>
		public string Name_prestp {
            get { return getAttrVal<string>("Name_prestp",null); }
            set { setAttrVal<string>("Name_prestp", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_or", "Sd_pois", "Mental1", "Mental2", "Control", "Ordinary", "Sd_srvtp", "Id_dep_mp", "Fg_bb", "Id_entp", "Id_grp", "Id_org", "Id_pat", "Id_en", "Id_srvtp", "No_bb", "Dt_entry", "Id_emp_or", "Id_dep_or", "Id_orsrv", "Id_route", "Id_routedes", "Id_boil", "Id_boildes", "Id_emp_sign", "Code_entp", "Pri", "Name_srv", "Health_type", "Id_pres", "Name_dep_or", "Name_emp_or", "Fg_hp_pres", "Sd_prestp", "Fg_chk", "Code", "Name_dep_mp", "Quan_cur", "Name_fg_hp", "Name_prestp"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO";
        }
    }
}
