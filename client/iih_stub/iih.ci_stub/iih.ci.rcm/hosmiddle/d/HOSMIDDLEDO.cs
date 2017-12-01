
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.rcm.hosmiddle.d
{
    /// <summary>
    /// HOSMIDDLEDO 的摘要说明。
    /// </summary>
    public class HOSMIDDLEDO : BaseDO {

		public const string TABLE_NAME = "CI_MR_HOS_MIDDLE";
		public const string TABLE_ALIAS_NAME = "a0";

        public HOSMIDDLEDO() {
            this.State = true;
        }
		public string Id_middle {
            get { return getAttrVal<string>("Id_middle",null); }
            set { setAttrVal<string>("Id_middle", value); }
        }
		public string Id_ent {
            get { return getAttrVal<string>("Id_ent",null); }
            set { setAttrVal<string>("Id_ent", value); }
        }
		public string Id_hospitalreport {
            get { return getAttrVal<string>("Id_hospitalreport",null); }
            set { setAttrVal<string>("Id_hospitalreport", value); }
        }
		public string Id_subcard {
            get { return getAttrVal<string>("Id_subcard",null); }
            set { setAttrVal<string>("Id_subcard", value); }
        }
		public string Title {
            get { return getAttrVal<string>("Title",null); }
            set { setAttrVal<string>("Title", value); }
        }
		public bool State {
            get { return getAttrVal<FBoolean>("State",true); }
            set { setAttrVal<FBoolean>("State", value); }
        }
		public string Style {
            get { return getAttrVal<string>("Style",null); }
            set { setAttrVal<string>("Style", value); }
        }
		public string Serailno {
            get { return getAttrVal<string>("Serailno",null); }
            set { setAttrVal<string>("Serailno", value); }
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
            return "CI_MR_HOS_MIDDLE";
        }
        
        /// <summary>
        /// 返回表别名
        /// </summary>
        /// <returns></returns>
        public override string getAliasTableName()
        {
            return "a0";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_middle";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.rcm.hosmiddle.d.HOSMIDDLEDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_middle", "Id_ent", "Id_hospitalreport", "Id_subcard", "Title", "State", "Style", "Serailno"};
        }
        
    }
}
