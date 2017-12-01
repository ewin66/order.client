
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.ord.cfg.cirulecfg.d
{
    /// <summary>
    /// CiRuleEntity 的摘要说明。
    /// </summary>
    public class CiRuleEntity : BaseDO {

		public const string TABLE_NAME = "ci_rule_entity";
		public const string TABLE_ALIAS_NAME = "a0";

        public CiRuleEntity() {
        }
		public string Id_rule {
            get { return getAttrVal<string>("Id_rule",null); }
            set { setAttrVal<string>("Id_rule", value); }
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
		public int? Eu_rule_category {
            get { return getAttrVal<int?>("Eu_rule_category",null); }
            set { setAttrVal<int?>("Eu_rule_category", value); }
        }
		public string Rule_type {
            get { return getAttrVal<string>("Rule_type",null); }
            set { setAttrVal<string>("Rule_type", value); }
        }
		public string Class_path {
            get { return getAttrVal<string>("Class_path",null); }
            set { setAttrVal<string>("Class_path", value); }
        }
		public string Class_name {
            get { return getAttrVal<string>("Class_name",null); }
            set { setAttrVal<string>("Class_name", value); }
        }
		public string Required_props {
            get { return getAttrVal<string>("Required_props",null); }
            set { setAttrVal<string>("Required_props", value); }
        }
		public bool? Fg_check_all_required {
            get { return getAttrVal<FBoolean>("Fg_check_all_required",null); }
            set { setAttrVal<FBoolean>("Fg_check_all_required", value); }
        }
		public bool? Fg_use_op {
            get { return getAttrVal<FBoolean>("Fg_use_op",null); }
            set { setAttrVal<FBoolean>("Fg_use_op", value); }
        }
		public bool? Fg_use_ip {
            get { return getAttrVal<FBoolean>("Fg_use_ip",null); }
            set { setAttrVal<FBoolean>("Fg_use_ip", value); }
        }
		public bool? Fg_use_er {
            get { return getAttrVal<FBoolean>("Fg_use_er",null); }
            set { setAttrVal<FBoolean>("Fg_use_er", value); }
        }
		public bool? Fg_use_pe {
            get { return getAttrVal<FBoolean>("Fg_use_pe",null); }
            set { setAttrVal<FBoolean>("Fg_use_pe", value); }
        }
		public bool? Fg_use_fm {
            get { return getAttrVal<FBoolean>("Fg_use_fm",null); }
            set { setAttrVal<FBoolean>("Fg_use_fm", value); }
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
            return "ci_rule_entity";
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
            return "Id_rule";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.cfg.cirulecfg.d.CiRuleEntity";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_rule", "Id_grp", "Id_org", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Eu_rule_category", "Rule_type", "Class_path", "Class_name", "Required_props", "Fg_check_all_required", "Fg_use_op", "Fg_use_ip", "Fg_use_er", "Fg_use_pe", "Fg_use_fm", "Des", "Sortno", "Code_grp", "Name_grp", "Code_org", "Name_org"};
        }
        
    }
}
