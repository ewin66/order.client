
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.mr.knowledge.d
{
    /// <summary>
    /// KnowledgeDO 的摘要说明。
    /// </summary>
    public class KnowledgeDO : BaseDO {

		public const string TABLE_NAME = "ci_mr_knowledge";
		public const string TABLE_ALIAS_NAME = "a0";

        public KnowledgeDO() {
        }
		public string Id_knowledge {
            get { return getAttrVal<string>("Id_knowledge",null); }
            set { setAttrVal<string>("Id_knowledge", value); }
        }
		public string Id_grp {
            get { return getAttrVal<string>("Id_grp",null); }
            set { setAttrVal<string>("Id_grp", value); }
        }
		public string Id_org {
            get { return getAttrVal<string>("Id_org",null); }
            set { setAttrVal<string>("Id_org", value); }
        }
		public int? Sortno {
            get { return getAttrVal<int?>("Sortno",null); }
            set { setAttrVal<int?>("Sortno", value); }
        }
		public string Code {
            get { return getAttrVal<string>("Code",null); }
            set { setAttrVal<string>("Code", value); }
        }
		public string Name {
            get { return getAttrVal<string>("Name",null); }
            set { setAttrVal<string>("Name", value); }
        }
		public string Pycode {
            get { return getAttrVal<string>("Pycode",null); }
            set { setAttrVal<string>("Pycode", value); }
        }
		public string Wbcode {
            get { return getAttrVal<string>("Wbcode",null); }
            set { setAttrVal<string>("Wbcode", value); }
        }
		public string Mnecode {
            get { return getAttrVal<string>("Mnecode",null); }
            set { setAttrVal<string>("Mnecode", value); }
        }
		public string Knowledge_content {
            get { return getAttrVal<string>("Knowledge_content",null); }
            set { setAttrVal<string>("Knowledge_content", value); }
        }
		public string Id_knowledge_type {
            get { return getAttrVal<string>("Id_knowledge_type",null); }
            set { setAttrVal<string>("Id_knowledge_type", value); }
        }
		public string Id_dept {
            get { return getAttrVal<string>("Id_dept",null); }
            set { setAttrVal<string>("Id_dept", value); }
        }
		public string Id_user {
            get { return getAttrVal<string>("Id_user",null); }
            set { setAttrVal<string>("Id_user", value); }
        }
		public bool? Fg_active {
            get { return getAttrVal<FBoolean>("Fg_active",null); }
            set { setAttrVal<FBoolean>("Fg_active", value); }
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
		public string Org_code {
            get { return getAttrVal<string>("Org_code",null); }
            set { setAttrVal<string>("Org_code", value); }
        }
		public string Org_name {
            get { return getAttrVal<string>("Org_name",null); }
            set { setAttrVal<string>("Org_name", value); }
        }
		public string Knowledge_type_name {
            get { return getAttrVal<string>("Knowledge_type_name",null); }
            set { setAttrVal<string>("Knowledge_type_name", value); }
        }
		public string Dept_code {
            get { return getAttrVal<string>("Dept_code",null); }
            set { setAttrVal<string>("Dept_code", value); }
        }
		public string Dept_name {
            get { return getAttrVal<string>("Dept_name",null); }
            set { setAttrVal<string>("Dept_name", value); }
        }
		public string User_name {
            get { return getAttrVal<string>("User_name",null); }
            set { setAttrVal<string>("User_name", value); }
        }
		public string User_code {
            get { return getAttrVal<string>("User_code",null); }
            set { setAttrVal<string>("User_code", value); }
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
            return "ci_mr_knowledge";
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
            return "Id_knowledge";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.knowledge.d.KnowledgeDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_knowledge", "Id_grp", "Id_org", "Sortno", "Code", "Name", "Pycode", "Wbcode", "Mnecode", "Knowledge_content", "Id_knowledge_type", "Id_dept", "Id_user", "Fg_active", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Org_code", "Org_name", "Knowledge_type_name", "Dept_code", "Dept_name", "User_name", "User_code"};
        }
        
		/// <summary>
        /// 设置IBDataInfo接口映射数据
        /// </summary>
        /// <returns></returns>
		protected override void setBdDataInfoNameMap() {
			if (base.name_path_map == null)
            {
                base.name_path_map = new Dictionary<string, string>();
				base.name_path_map.Add("id","Id_knowledge");
				base.name_path_map.Add("id_org","Id_org");
				base.name_path_map.Add("code","Code");
				base.name_path_map.Add("name","Name");
				base.name_path_map.Add("id_group","Id_grp");
				base.name_path_map.Add("pycode","Pycode");
				base.name_path_map.Add("wbcode","Wbcode");
				base.name_path_map.Add("mnecode","Mnecode");
            }
		}
    }
}
