using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.ciordems.d
{
    /// <summary>
    /// EmsItemInOp 的摘要说明。
    /// </summary>
    public class EmsItemInOp : BaseDTO {

        public EmsItemInOp() {
 
        }

        /// <summary>
        /// 主键
        /// </summary>
		public string Id_oropitem {
            get { return getAttrVal<string>("Id_oropitem",null); }
            set { setAttrVal<string>("Id_oropitem", value); }
        }

        /// <summary>
        /// 人员id
        /// </summary>
		public string Id_emp_op {
            get { return getAttrVal<string>("Id_emp_op",null); }
            set { setAttrVal<string>("Id_emp_op", value); }
        }

        /// <summary>
        /// 人员
        /// </summary>
		public string Name_emp_op {
            get { return getAttrVal<string>("Name_emp_op",null); }
            set { setAttrVal<string>("Name_emp_op", value); }
        }

        /// <summary>
        /// 角色id
        /// </summary>
		public string Id_role {
            get { return getAttrVal<string>("Id_role",null); }
            set { setAttrVal<string>("Id_role", value); }
        }

        /// <summary>
        /// 角色编码
        /// </summary>
		public string Sd_role {
            get { return getAttrVal<string>("Sd_role",null); }
            set { setAttrVal<string>("Sd_role", value); }
        }

        /// <summary>
        /// 角色
        /// </summary>
		public string Name_role {
            get { return getAttrVal<string>("Name_role",null); }
            set { setAttrVal<string>("Name_role", value); }
        }

        /// <summary>
        /// 物品id
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
        /// 物品类型id
        /// </summary>
		public string Id_mmtp {
            get { return getAttrVal<string>("Id_mmtp",null); }
            set { setAttrVal<string>("Id_mmtp", value); }
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
		public string Name_mmtp {
            get { return getAttrVal<string>("Name_mmtp",null); }
            set { setAttrVal<string>("Name_mmtp", value); }
        }

        /// <summary>
        /// 规格
        /// </summary>
		public string Spec {
            get { return getAttrVal<string>("Spec",null); }
            set { setAttrVal<string>("Spec", value); }
        }

        /// <summary>
        /// 厂商id
        /// </summary>
		public string Id_sup {
            get { return getAttrVal<string>("Id_sup",null); }
            set { setAttrVal<string>("Id_sup", value); }
        }

        /// <summary>
        /// 厂商
        /// </summary>
		public string Name_sup {
            get { return getAttrVal<string>("Name_sup",null); }
            set { setAttrVal<string>("Name_sup", value); }
        }

        /// <summary>
        /// 单价
        /// </summary>
		public double? Price {
            get { return getAttrVal<FDouble>("Price",null); }
            set { setAttrVal<FDouble>("Price", value); }
        }

        /// <summary>
        /// 数量
        /// </summary>
		public int? Quan_cur {
            get { return getAttrVal<int?>("Quan_cur",null); }
            set { setAttrVal<int?>("Quan_cur", value); }
        }

        /// <summary>
        /// 零售包装单位id
        /// </summary>
		public string Id_unit_pkgsp {
            get { return getAttrVal<string>("Id_unit_pkgsp",null); }
            set { setAttrVal<string>("Id_unit_pkgsp", value); }
        }

        /// <summary>
        /// 零售包装单位
        /// </summary>
		public string Name_unit_pkgsp {
            get { return getAttrVal<string>("Name_unit_pkgsp",null); }
            set { setAttrVal<string>("Name_unit_pkgsp", value); }
        }

        /// <summary>
        /// 排序
        /// </summary>
		public int? Sortno {
            get { return getAttrVal<int?>("Sortno",null); }
            set { setAttrVal<int?>("Sortno", value); }
        }

        /// <summary>
        /// 手术 编码(code_srv)
        /// </summary>
		public string Code_srv {
            get { return getAttrVal<string>("Code_srv",null); }
            set { setAttrVal<string>("Code_srv", value); }
        }

        /// <summary>
        /// 手术id（id_srv）
        /// </summary>
		public string Id_srv {
            get { return getAttrVal<string>("Id_srv",null); }
            set { setAttrVal<string>("Id_srv", value); }
        }

        /// <summary>
        /// 手术名称
        /// </summary>
		public string Name_srv {
            get { return getAttrVal<string>("Name_srv",null); }
            set { setAttrVal<string>("Name_srv", value); }
        }

        /// <summary>
        /// 手术描述
        /// </summary>
		public string Des_op {
            get { return getAttrVal<string>("Des_op",null); }
            set { setAttrVal<string>("Des_op", value); }
        }
/// <summary>
        /// id_orsrv
        /// </summary>
        public string Id_orsrv
        {
            get { return getAttrVal<string>("Id_orsrv", null); }
            set { setAttrVal<string>("Id_orsrv", value); }
        }
        /// <summary>
        /// 医保
        /// </summary>
		public string Id_hp {
            get { return getAttrVal<string>("Id_hp",null); }
            set { setAttrVal<string>("Id_hp", value); }
        }

        /// <summary>
        /// 医保名称
        /// </summary>
		public string Name_hp {
            get { return getAttrVal<string>("Name_hp",null); }
            set { setAttrVal<string>("Name_hp", value); }
        }

        /// <summary>
        /// 医保类型
        /// </summary>
		public string Id_hpsrvtp {
            get { return getAttrVal<string>("Id_hpsrvtp",null); }
            set { setAttrVal<string>("Id_hpsrvtp", value); }
        }

        /// <summary>
        /// 医保类型编码
        /// </summary>
		public string Sd_hpsrvtp {
            get { return getAttrVal<string>("Sd_hpsrvtp",null); }
            set { setAttrVal<string>("Sd_hpsrvtp", value); }
        }

        /// <summary>
        /// 服务所属来源
        /// </summary>
		public string Id_srv_src {
            get { return getAttrVal<string>("Id_srv_src",null); }
            set { setAttrVal<string>("Id_srv_src", value); }
        }

        /// <summary>
        /// 医疗单来源
        /// </summary>
		public int? Eu_sourcemd {
            get { return getAttrVal<int?>("Eu_sourcemd",null); }
            set { setAttrVal<int?>("Eu_sourcemd", value); }
        }

        /// <summary>
        /// 计价状态
        /// </summary>
		public string Priby {
            get { return getAttrVal<string>("Priby",null); }
            set { setAttrVal<string>("Priby", value); }
        }

        /// <summary>
        /// 时间戳
        /// </summary>
		public DateTime? Sv {
            get { return getAttrVal<FDateTime>("Sv",null); }
            set { setAttrVal<FDateTime>("Sv", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_oropitem", "Id_emp_op", "Name_emp_op", "Id_role", "Sd_role", "Name_role", "Id_mm", "Name_mm", "Id_mmtp", "Sd_mmtp", "Name_mmtp", "Spec", "Id_sup", "Name_sup", "Price", "Quan_cur", "Id_unit_pkgsp", "Name_unit_pkgsp", "Sortno", "Code_srv", "Id_srv", "Name_srv", "Des_op", "Id_hp", "Name_hp", "Id_hpsrvtp", "Sd_hpsrvtp","Id_orsrv", "Id_srv_src", "Eu_sourcemd", "Priby", "Sv"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.ciordems.d.EmsItemInOp";
        }
    }
}
