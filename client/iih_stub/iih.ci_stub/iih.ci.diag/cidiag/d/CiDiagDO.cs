
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.diag.cidiag.d
{
    /// <summary>
    /// CiDiagDO 的摘要说明。
    /// </summary>
    public class CiDiagDO : BaseDO {

		public const string TABLE_NAME = "ci_di";
		public const string TABLE_ALIAS_NAME = "a0";

        public CiDiagDO() {
        }
		public string Id_di {
            get { return getAttrVal<string>("Id_di",null); }
            set { setAttrVal<string>("Id_di", value); }
        }
		public string Id_grp {
            get { return getAttrVal<string>("Id_grp",null); }
            set { setAttrVal<string>("Id_grp", value); }
        }
		public string Id_org {
            get { return getAttrVal<string>("Id_org",null); }
            set { setAttrVal<string>("Id_org", value); }
        }
		public string Id_pat {
            get { return getAttrVal<string>("Id_pat",null); }
            set { setAttrVal<string>("Id_pat", value); }
        }
		public string Id_entp {
            get { return getAttrVal<string>("Id_entp",null); }
            set { setAttrVal<string>("Id_entp", value); }
        }
		public string Code_entp {
            get { return getAttrVal<string>("Code_entp",null); }
            set { setAttrVal<string>("Code_entp", value); }
        }
		public string Id_en {
            get { return getAttrVal<string>("Id_en",null); }
            set { setAttrVal<string>("Id_en", value); }
        }
		public string Id_ditp {
            get { return getAttrVal<string>("Id_ditp",null); }
            set { setAttrVal<string>("Id_ditp", value); }
        }
		public string Sd_ditp {
            get { return getAttrVal<string>("Sd_ditp",null); }
            set { setAttrVal<string>("Sd_ditp", value); }
        }
		public string Des_di {
            get { return getAttrVal<string>("Des_di",null); }
            set { setAttrVal<string>("Des_di", value); }
        }
		public DateTime? Dt_di {
            get { return getAttrVal<FDateTime>("Dt_di",null); }
            set { setAttrVal<FDateTime>("Dt_di", value); }
        }
		public string Id_dep {
            get { return getAttrVal<string>("Id_dep",null); }
            set { setAttrVal<string>("Id_dep", value); }
        }
		public bool? Fg_sign {
            get { return getAttrVal<FBoolean>("Fg_sign",null); }
            set { setAttrVal<FBoolean>("Fg_sign", value); }
        }
		public DateTime? Dt_sign {
            get { return getAttrVal<FDateTime>("Dt_sign",null); }
            set { setAttrVal<FDateTime>("Dt_sign", value); }
        }
		public string Id_dep_sign {
            get { return getAttrVal<string>("Id_dep_sign",null); }
            set { setAttrVal<string>("Id_dep_sign", value); }
        }
		public string Id_emp_sign {
            get { return getAttrVal<string>("Id_emp_sign",null); }
            set { setAttrVal<string>("Id_emp_sign", value); }
        }
		public string Id_emp_create {
            get { return getAttrVal<string>("Id_emp_create",null); }
            set { setAttrVal<string>("Id_emp_create", value); }
        }
		public string Id_dep_create {
            get { return getAttrVal<string>("Id_dep_create",null); }
            set { setAttrVal<string>("Id_dep_create", value); }
        }
		public DateTime? Dt_create {
            get { return getAttrVal<FDateTime>("Dt_create",null); }
            set { setAttrVal<FDateTime>("Dt_create", value); }
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
		public string Name {
            get { return getAttrVal<string>("Name",null); }
            set { setAttrVal<string>("Name", value); }
        }
		public string Code_ditp {
            get { return getAttrVal<string>("Code_ditp",null); }
            set { setAttrVal<string>("Code_ditp", value); }
        }
		public string Name_ditp {
            get { return getAttrVal<string>("Name_ditp",null); }
            set { setAttrVal<string>("Name_ditp", value); }
        }
		public string Name_dep_sign {
            get { return getAttrVal<string>("Name_dep_sign",null); }
            set { setAttrVal<string>("Name_dep_sign", value); }
        }
		public string Signname {
            get { return getAttrVal<string>("Signname",null); }
            set { setAttrVal<string>("Signname", value); }
        }
		public string Signcode {
            get { return getAttrVal<string>("Signcode",null); }
            set { setAttrVal<string>("Signcode", value); }
        }
		public string Empcode {
            get { return getAttrVal<string>("Empcode",null); }
            set { setAttrVal<string>("Empcode", value); }
        }
		public string Empname {
            get { return getAttrVal<string>("Empname",null); }
            set { setAttrVal<string>("Empname", value); }
        }
		public string Code_dep_create {
            get { return getAttrVal<string>("Code_dep_create",null); }
            set { setAttrVal<string>("Code_dep_create", value); }
        }
		public string Name_dep_create {
            get { return getAttrVal<string>("Name_dep_create",null); }
            set { setAttrVal<string>("Name_dep_create", value); }
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
            return "ci_di";
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
            return "Id_di";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.diag.cidiag.d.CiDiagDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_di", "Id_grp", "Id_org", "Id_pat", "Id_entp", "Code_entp", "Id_en", "Id_ditp", "Sd_ditp", "Des_di", "Dt_di", "Id_dep", "Fg_sign", "Dt_sign", "Id_dep_sign", "Id_emp_sign", "Id_emp_create", "Id_dep_create", "Dt_create", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Name", "Code_ditp", "Name_ditp", "Name_dep_sign", "Signname", "Signcode", "Empcode", "Empname", "Code_dep_create", "Name_dep_create"};
        }
        
		/// <summary>
        /// 设置IBDataInfo接口映射数据
        /// </summary>
        /// <returns></returns>
		protected override void setBdDataInfoNameMap() {
			if (base.name_path_map == null)
            {
                base.name_path_map = new Dictionary<string, string>();
				base.name_path_map.Add("id","Id_cidi");
				base.name_path_map.Add("id_org","Id_org");
				base.name_path_map.Add("code","Des_di");
				base.name_path_map.Add("name","Des_di");
				base.name_path_map.Add("id_group","Id_grp");
            }
		}
    }
}
