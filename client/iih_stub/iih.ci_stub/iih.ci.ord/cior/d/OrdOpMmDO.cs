
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.cior.d
{
    /// <summary>
    /// OrdOpMmDO 的摘要说明。
    /// </summary>
    public class OrdOpMmDO : BaseDO {

		public const string TABLE_NAME = "ci_ap_sug_mm";
		public const string TABLE_ALIAS_NAME = "a2";

        public OrdOpMmDO() {
        }
		public string Id_apopmm {
            get { return getAttrVal<string>("Id_apopmm",null); }
            set { setAttrVal<string>("Id_apopmm", value); }
        }
		public string Id_apop {
            get { return getAttrVal<string>("Id_apop",null); }
            set { setAttrVal<string>("Id_apop", value); }
        }
		public string Id_mm {
            get { return getAttrVal<string>("Id_mm",null); }
            set { setAttrVal<string>("Id_mm", value); }
        }
		public string Sd_mmtp {
            get { return getAttrVal<string>("Sd_mmtp",null); }
            set { setAttrVal<string>("Sd_mmtp", value); }
        }
		public string Id_mmtp {
            get { return getAttrVal<string>("Id_mmtp",null); }
            set { setAttrVal<string>("Id_mmtp", value); }
        }
		public string Spec {
            get { return getAttrVal<string>("Spec",null); }
            set { setAttrVal<string>("Spec", value); }
        }
		public string Id_sup {
            get { return getAttrVal<string>("Id_sup",null); }
            set { setAttrVal<string>("Id_sup", value); }
        }
		public FDouble Price {
            get { return getAttrVal<FDouble>("Price",null); }
            set { setAttrVal<FDouble>("Price", value); }
        }
		public int? Quan_cur {
            get { return getAttrVal<int?>("Quan_cur",null); }
            set { setAttrVal<int?>("Quan_cur", value); }
        }
		public string Id_unit_pkgsp {
            get { return getAttrVal<string>("Id_unit_pkgsp",null); }
            set { setAttrVal<string>("Id_unit_pkgsp", value); }
        }
		public string Name_mm {
            get { return getAttrVal<string>("Name_mm",null); }
            set { setAttrVal<string>("Name_mm", value); }
        }
		public string Name_mmtp {
            get { return getAttrVal<string>("Name_mmtp",null); }
            set { setAttrVal<string>("Name_mmtp", value); }
        }
		public string Name_sug {
            get { return getAttrVal<string>("Name_sug",null); }
            set { setAttrVal<string>("Name_sug", value); }
        }
		public string Name_unit_pkgsp {
            get { return getAttrVal<string>("Name_unit_pkgsp",null); }
            set { setAttrVal<string>("Name_unit_pkgsp", value); }
        }
        public int Ds {
            get { return getAttrVal<int>("Ds",0);}
            set { setAttrVal<int>("Ds", value); }
        }

        public DateTime? Sv        {
            get { return getAttrVal<FDateTime>("Sv",null); }
            set { setAttrVal<FDateTime>("Sv", value); }
        }
        
        /// <summary>
        /// 返回表名
        /// </summary>
        /// <returns></returns>
        public override string getTableName()
        {
            return "ci_ap_sug_mm";
        }
        
        /// <summary>
        /// 返回表别名
        /// </summary>
        /// <returns></returns>
        public override string getAliasTableName()
        {
            return "a2";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_apopmm";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.cior.d.OrdOpMmDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_apopmm", "Id_apop", "Id_mm", "Sd_mmtp", "Id_mmtp", "Spec", "Id_sup", "Price", "Quan_cur", "Id_unit_pkgsp", "Name_mm", "Name_mmtp", "Name_sug", "Name_unit_pkgsp"};
        }
        
    }
}
