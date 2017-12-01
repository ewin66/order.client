
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.ciorder.d
{
    /// <summary>
    /// OrdDrugDO 的摘要说明。
    /// </summary>
    public class OrdDrugDO : BaseDO {

		public const string TABLE_NAME = "ci_or_drug";
		public const string TABLE_ALIAS_NAME = "a3";

        public OrdDrugDO() {
        }
		public string Id_ordrug {
            get { return getAttrVal<string>("Id_ordrug",null); }
            set { setAttrVal<string>("Id_ordrug", value); }
        }
		public string Id_or {
            get { return getAttrVal<string>("Id_or",null); }
            set { setAttrVal<string>("Id_or", value); }
        }
		public bool? Fg_skintest {
            get { return getAttrVal<FBoolean>("Fg_skintest",null); }
            set { setAttrVal<FBoolean>("Fg_skintest", value); }
        }
		public string Id_skintest {
            get { return getAttrVal<string>("Id_skintest",null); }
            set { setAttrVal<string>("Id_skintest", value); }
        }
		public string Sd_skintest {
            get { return getAttrVal<string>("Sd_skintest",null); }
            set { setAttrVal<string>("Sd_skintest", value); }
        }
		public bool? Fg_boil {
            get { return getAttrVal<FBoolean>("Fg_boil",null); }
            set { setAttrVal<FBoolean>("Fg_boil", value); }
        }
		public FDouble Orders_boil {
            get { return getAttrVal<FDouble>("Orders_boil",null); }
            set { setAttrVal<FDouble>("Orders_boil", value); }
        }
		public bool? Fg_self {
            get { return getAttrVal<FBoolean>("Fg_self",null); }
            set { setAttrVal<FBoolean>("Fg_self", value); }
        }
		public bool? Fg_pres_outp {
            get { return getAttrVal<FBoolean>("Fg_pres_outp",null); }
            set { setAttrVal<FBoolean>("Fg_pres_outp", value); }
        }
		public bool? Fg_propc {
            get { return getAttrVal<FBoolean>("Fg_propc",null); }
            set { setAttrVal<FBoolean>("Fg_propc", value); }
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
            return "ci_or_drug";
        }
        
        /// <summary>
        /// 返回表别名
        /// </summary>
        /// <returns></returns>
        public override string getAliasTableName()
        {
            return "a3";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_ordrug";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.ciorder.d.OrdDrugDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_ordrug", "Id_or", "Fg_skintest", "Id_skintest", "Sd_skintest", "Fg_boil", "Orders_boil", "Fg_self", "Fg_pres_outp", "Fg_propc"};
        }
        
    }
}
