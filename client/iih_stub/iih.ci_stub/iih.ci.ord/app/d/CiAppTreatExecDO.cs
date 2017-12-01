
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.ord.app.d
{
    /// <summary>
    /// CiAppTreatExecDO 的摘要说明。
    /// </summary>
    public class CiAppTreatExecDO : BaseDO {

		public const string TABLE_NAME = "ci_app_treatexec";
		public const string TABLE_ALIAS_NAME = "a0";

        public CiAppTreatExecDO() {
            this.Fg_bb = false;
            this.Fg_prn = false;
            this.Hecominsurinfo = "N";
            this.Fg_prepay = false;
            this.Fg_vip = false;
            this.Fg_hpbirth = false;
            this.Fg_opspecial = false;
            this.Fg_blsettled = false;
        }
		public string Id_ciapptreatexec {
            get { return getAttrVal<string>("Id_ciapptreatexec",null); }
            set { setAttrVal<string>("Id_ciapptreatexec", value); }
        }
		public string Id_group {
            get { return getAttrVal<string>("Id_group",null); }
            set { setAttrVal<string>("Id_group", value); }
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
		public bool? Fg_bb {
            get { return getAttrVal<FBoolean>("Fg_bb",false); }
            set { setAttrVal<FBoolean>("Fg_bb", value); }
        }
		public int? No_bb {
            get { return getAttrVal<int?>("No_bb",null); }
            set { setAttrVal<int?>("No_bb", value); }
        }
		public string Code_app {
            get { return getAttrVal<string>("Code_app",null); }
            set { setAttrVal<string>("Code_app", value); }
        }
		public string Name_app {
            get { return getAttrVal<string>("Name_app",null); }
            set { setAttrVal<string>("Name_app", value); }
        }
		public string Id_apptreatexectp {
            get { return getAttrVal<string>("Id_apptreatexectp",null); }
            set { setAttrVal<string>("Id_apptreatexectp", value); }
        }
		public string Sd_apptreatexectp {
            get { return getAttrVal<string>("Sd_apptreatexectp",null); }
            set { setAttrVal<string>("Sd_apptreatexectp", value); }
        }
		public string Id_dep_mp {
            get { return getAttrVal<string>("Id_dep_mp",null); }
            set { setAttrVal<string>("Id_dep_mp", value); }
        }
		public string Id_emp_app {
            get { return getAttrVal<string>("Id_emp_app",null); }
            set { setAttrVal<string>("Id_emp_app", value); }
        }
		public string Id_org_app {
            get { return getAttrVal<string>("Id_org_app",null); }
            set { setAttrVal<string>("Id_org_app", value); }
        }
		public string Id_dep_app {
            get { return getAttrVal<string>("Id_dep_app",null); }
            set { setAttrVal<string>("Id_dep_app", value); }
        }
		public DateTime? Dt_app {
            get { return getAttrVal<FDateTime>("Dt_app",null); }
            set { setAttrVal<FDateTime>("Dt_app", value); }
        }
		public string Id_di {
            get { return getAttrVal<string>("Id_di",null); }
            set { setAttrVal<string>("Id_di", value); }
        }
		public string Name_diag {
            get { return getAttrVal<string>("Name_diag",null); }
            set { setAttrVal<string>("Name_diag", value); }
        }
		public string Id_diitm {
            get { return getAttrVal<string>("Id_diitm",null); }
            set { setAttrVal<string>("Id_diitm", value); }
        }
		public string Str_id_diitm {
            get { return getAttrVal<string>("Str_id_diitm",null); }
            set { setAttrVal<string>("Str_id_diitm", value); }
        }
		public string Str_code_di {
            get { return getAttrVal<string>("Str_code_di",null); }
            set { setAttrVal<string>("Str_code_di", value); }
        }
		public string Str_name_di {
            get { return getAttrVal<string>("Str_name_di",null); }
            set { setAttrVal<string>("Str_name_di", value); }
        }
		public bool? Fg_prn {
            get { return getAttrVal<FBoolean>("Fg_prn",false); }
            set { setAttrVal<FBoolean>("Fg_prn", value); }
        }
		public int? Cnt_prn {
            get { return getAttrVal<int?>("Cnt_prn",null); }
            set { setAttrVal<int?>("Cnt_prn", value); }
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
		public bool? Fg_hecominsur {
            get { return getAttrVal<FBoolean>("Fg_hecominsur",null); }
            set { setAttrVal<FBoolean>("Fg_hecominsur", value); }
        }
		public string Hecominsurinfo {
            get { return getAttrVal<string>("Hecominsurinfo","N"); }
            set { setAttrVal<string>("Hecominsurinfo", value); }
        }
		public bool? Fg_hp {
            get { return getAttrVal<FBoolean>("Fg_hp",null); }
            set { setAttrVal<FBoolean>("Fg_hp", value); }
        }
		public bool? Fg_prepay {
            get { return getAttrVal<FBoolean>("Fg_prepay",false); }
            set { setAttrVal<FBoolean>("Fg_prepay", value); }
        }
		public bool? Fg_vip {
            get { return getAttrVal<FBoolean>("Fg_vip",false); }
            set { setAttrVal<FBoolean>("Fg_vip", value); }
        }
		public bool? Fg_hpbirth {
            get { return getAttrVal<FBoolean>("Fg_hpbirth",false); }
            set { setAttrVal<FBoolean>("Fg_hpbirth", value); }
        }
		public string Researchinfo {
            get { return getAttrVal<string>("Researchinfo",null); }
            set { setAttrVal<string>("Researchinfo", value); }
        }
		public bool? Fg_opspecial {
            get { return getAttrVal<FBoolean>("Fg_opspecial",false); }
            set { setAttrVal<FBoolean>("Fg_opspecial", value); }
        }
		public bool? Fg_blsettled {
            get { return getAttrVal<FBoolean>("Fg_blsettled",false); }
            set { setAttrVal<FBoolean>("Fg_blsettled", value); }
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
            return "ci_app_treatexec";
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
            return "Id_ciapptreatexec";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.app.d.CiAppTreatExecDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_ciapptreatexec", "Id_group", "Id_org", "Id_pat", "Id_entp", "Code_entp", "Id_en", "Fg_bb", "No_bb", "Code_app", "Name_app", "Id_apptreatexectp", "Sd_apptreatexectp", "Id_dep_mp", "Id_emp_app", "Id_org_app", "Id_dep_app", "Dt_app", "Id_di", "Name_diag", "Id_diitm", "Str_id_diitm", "Str_code_di", "Str_name_di", "Fg_prn", "Cnt_prn", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Fg_hecominsur", "Hecominsurinfo", "Fg_hp", "Fg_prepay", "Fg_vip", "Fg_hpbirth", "Researchinfo", "Fg_opspecial", "Fg_blsettled"};
        }
        
		/// <summary>
        /// 设置IBDataInfo接口映射数据
        /// </summary>
        /// <returns></returns>
		protected override void setBdDataInfoNameMap() {
			if (base.name_path_map == null)
            {
                base.name_path_map = new Dictionary<string, string>();
				base.name_path_map.Add("id","Id_ciapptreatexec");
				base.name_path_map.Add("id_org","Id_org");
				base.name_path_map.Add("code","Code_app");
				base.name_path_map.Add("name","Name_app");
				base.name_path_map.Add("id_group","Id_group");
            }
		}
    }
}
