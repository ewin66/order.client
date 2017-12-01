
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.ord.cfg.cirulecfg.d
{
    /// <summary>
    /// CiRuleCfg 的摘要说明。
    /// </summary>
    public class CiRuleCfg : BaseDO {

		public const string TABLE_NAME = "ci_rule_cfg";
		public const string TABLE_ALIAS_NAME = "a0";

        public CiRuleCfg() {
        }
		public string Id_rulecfg {
            get { return getAttrVal<string>("Id_rulecfg",null); }
            set { setAttrVal<string>("Id_rulecfg", value); }
        }
		public string Id_grp {
            get { return getAttrVal<string>("Id_grp",null); }
            set { setAttrVal<string>("Id_grp", value); }
        }
		public string Id_org {
            get { return getAttrVal<string>("Id_org",null); }
            set { setAttrVal<string>("Id_org", value); }
        }
		public string Createdby {
            get { return getAttrVal<string>("Createdby",null); }
            set { setAttrVal<string>("Createdby", value); }
        }
		public DateTime? Createdtime {
            get { return getAttrVal<FDateTime>("Createdtime",null); }
            set { setAttrVal<FDateTime>("Createdtime", value); }
        }
		public string Modifiedby {
            get { return getAttrVal<string>("Modifiedby",null); }
            set { setAttrVal<string>("Modifiedby", value); }
        }
		public DateTime? Modifiedtime {
            get { return getAttrVal<FDateTime>("Modifiedtime",null); }
            set { setAttrVal<FDateTime>("Modifiedtime", value); }
        }
		public string Id_entp {
            get { return getAttrVal<string>("Id_entp",null); }
            set { setAttrVal<string>("Id_entp", value); }
        }
		public string Code_entp {
            get { return getAttrVal<string>("Code_entp",null); }
            set { setAttrVal<string>("Code_entp", value); }
        }
		public string Rule_name {
            get { return getAttrVal<string>("Rule_name",null); }
            set { setAttrVal<string>("Rule_name", value); }
        }
		public string Eu_check_point {
            get { return getAttrVal<string>("Eu_check_point",null); }
            set { setAttrVal<string>("Eu_check_point", value); }
        }
		public string Id_rules {
            get { return getAttrVal<string>("Id_rules",null); }
            set { setAttrVal<string>("Id_rules", value); }
        }
		public string Cfg_result {
            get { return getAttrVal<string>("Cfg_result",null); }
            set { setAttrVal<string>("Cfg_result", value); }
        }
		public string Des {
            get { return getAttrVal<string>("Des",null); }
            set { setAttrVal<string>("Des", value); }
        }
		public int? Sortno {
            get { return getAttrVal<int?>("Sortno",null); }
            set { setAttrVal<int?>("Sortno", value); }
        }
		public string Code_grp {
            get { return getAttrVal<string>("Code_grp",null); }
            set { setAttrVal<string>("Code_grp", value); }
        }
		public string Name_grp {
            get { return getAttrVal<string>("Name_grp",null); }
            set { setAttrVal<string>("Name_grp", value); }
        }
		public string Code_org {
            get { return getAttrVal<string>("Code_org",null); }
            set { setAttrVal<string>("Code_org", value); }
        }
		public string Name_org {
            get { return getAttrVal<string>("Name_org",null); }
            set { setAttrVal<string>("Name_org", value); }
        }
		public string Entp_name {
            get { return getAttrVal<string>("Entp_name",null); }
            set { setAttrVal<string>("Entp_name", value); }
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
            return "ci_rule_cfg";
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
            return "Id_rulecfg";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.cfg.cirulecfg.d.CiRuleCfg";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_rulecfg", "Id_grp", "Id_org", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Id_entp", "Code_entp", "Rule_name", "Eu_check_point", "Id_rules", "Cfg_result", "Des", "Sortno", "Code_grp", "Name_grp", "Code_org", "Name_org", "Entp_name"};
        }
        
    }
}
