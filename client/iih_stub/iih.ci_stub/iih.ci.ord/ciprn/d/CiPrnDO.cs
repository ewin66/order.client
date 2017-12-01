
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.ord.ciprn.d
{
    /// <summary>
    /// CiPrnDO 的摘要说明。
    /// </summary>
    public class CiPrnDO : BaseDO {

		public const string TABLE_NAME = "ci_prn";
		public const string TABLE_ALIAS_NAME = "a0";

        public CiPrnDO() {
            this.Fg_bb = false;
            this.Fg_prn = false;
            this.Fg_hp = false;
        }
		public string Id_ciprn {
            get { return getAttrVal<string>("Id_ciprn",null); }
            set { setAttrVal<string>("Id_ciprn", value); }
        }
		public string Id_grp {
            get { return getAttrVal<string>("Id_grp",null); }
            set { setAttrVal<string>("Id_grp", value); }
        }
		public string Id_org {
            get { return getAttrVal<string>("Id_org",null); }
            set { setAttrVal<string>("Id_org", value); }
        }
		public string Id_di {
            get { return getAttrVal<string>("Id_di",null); }
            set { setAttrVal<string>("Id_di", value); }
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
		public string Name_diag {
            get { return getAttrVal<string>("Name_diag",null); }
            set { setAttrVal<string>("Name_diag", value); }
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
		public string Code_prn {
            get { return getAttrVal<string>("Code_prn",null); }
            set { setAttrVal<string>("Code_prn", value); }
        }
		public string Name_prn {
            get { return getAttrVal<string>("Name_prn",null); }
            set { setAttrVal<string>("Name_prn", value); }
        }
		public string Id_org_prn {
            get { return getAttrVal<string>("Id_org_prn",null); }
            set { setAttrVal<string>("Id_org_prn", value); }
        }
		public string Id_dep_prn {
            get { return getAttrVal<string>("Id_dep_prn",null); }
            set { setAttrVal<string>("Id_dep_prn", value); }
        }
		public string Id_emp_prn {
            get { return getAttrVal<string>("Id_emp_prn",null); }
            set { setAttrVal<string>("Id_emp_prn", value); }
        }
		public DateTime? Dt_prn {
            get { return getAttrVal<FDateTime>("Dt_prn",null); }
            set { setAttrVal<FDateTime>("Dt_prn", value); }
        }
		public string Id_dep_mp {
            get { return getAttrVal<string>("Id_dep_mp",null); }
            set { setAttrVal<string>("Id_dep_mp", value); }
        }
		public string Id_ciprntp {
            get { return getAttrVal<string>("Id_ciprntp",null); }
            set { setAttrVal<string>("Id_ciprntp", value); }
        }
		public string Sd_ciprntp {
            get { return getAttrVal<string>("Sd_ciprntp",null); }
            set { setAttrVal<string>("Sd_ciprntp", value); }
        }
		public bool? Fg_prn {
            get { return getAttrVal<FBoolean>("Fg_prn",false); }
            set { setAttrVal<FBoolean>("Fg_prn", value); }
        }
		public int? Cnt_prn {
            get { return getAttrVal<int?>("Cnt_prn",null); }
            set { setAttrVal<int?>("Cnt_prn", value); }
        }
		public string Def1 {
            get { return getAttrVal<string>("Def1",null); }
            set { setAttrVal<string>("Def1", value); }
        }
		public string Def2 {
            get { return getAttrVal<string>("Def2",null); }
            set { setAttrVal<string>("Def2", value); }
        }
		public string Def3 {
            get { return getAttrVal<string>("Def3",null); }
            set { setAttrVal<string>("Def3", value); }
        }
		public string Def4 {
            get { return getAttrVal<string>("Def4",null); }
            set { setAttrVal<string>("Def4", value); }
        }
		public string Def5 {
            get { return getAttrVal<string>("Def5",null); }
            set { setAttrVal<string>("Def5", value); }
        }
		public string Def6 {
            get { return getAttrVal<string>("Def6",null); }
            set { setAttrVal<string>("Def6", value); }
        }
		public string Def7 {
            get { return getAttrVal<string>("Def7",null); }
            set { setAttrVal<string>("Def7", value); }
        }
		public string Def8 {
            get { return getAttrVal<string>("Def8",null); }
            set { setAttrVal<string>("Def8", value); }
        }
		public string Def9 {
            get { return getAttrVal<string>("Def9",null); }
            set { setAttrVal<string>("Def9", value); }
        }
		public string Def10 {
            get { return getAttrVal<string>("Def10",null); }
            set { setAttrVal<string>("Def10", value); }
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
		public bool? Fg_hp {
            get { return getAttrVal<FBoolean>("Fg_hp",false); }
            set { setAttrVal<FBoolean>("Fg_hp", value); }
        }
		public bool? Fg_prepay {
            get { return getAttrVal<FBoolean>("Fg_prepay",null); }
            set { setAttrVal<FBoolean>("Fg_prepay", value); }
        }
		public bool? Fg_hecominsur {
            get { return getAttrVal<FBoolean>("Fg_hecominsur",null); }
            set { setAttrVal<FBoolean>("Fg_hecominsur", value); }
        }
		public string Hecominsurinfo {
            get { return getAttrVal<string>("Hecominsurinfo",null); }
            set { setAttrVal<string>("Hecominsurinfo", value); }
        }
		public bool? Fg_vip {
            get { return getAttrVal<FBoolean>("Fg_vip",null); }
            set { setAttrVal<FBoolean>("Fg_vip", value); }
        }
		public bool? Fg_blsettled {
            get { return getAttrVal<FBoolean>("Fg_blsettled",null); }
            set { setAttrVal<FBoolean>("Fg_blsettled", value); }
        }
		public string Name_ordi {
            get { return getAttrVal<string>("Name_ordi",null); }
            set { setAttrVal<string>("Name_ordi", value); }
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
            return "ci_prn";
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
            return "Id_ciprn";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.ciprn.d.CiPrnDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_ciprn", "Id_grp", "Id_org", "Id_di", "Id_diitm", "Str_id_diitm", "Str_code_di", "Str_name_di", "Name_diag", "Id_en", "Fg_bb", "No_bb", "Id_pat", "Id_entp", "Code_entp", "Code_prn", "Name_prn", "Id_org_prn", "Id_dep_prn", "Id_emp_prn", "Dt_prn", "Id_dep_mp", "Id_ciprntp", "Sd_ciprntp", "Fg_prn", "Cnt_prn", "Def1", "Def2", "Def3", "Def4", "Def5", "Def6", "Def7", "Def8", "Def9", "Def10", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Fg_hp", "Fg_prepay", "Fg_hecominsur", "Hecominsurinfo", "Fg_vip", "Fg_blsettled", "Name_ordi"};
        }
        
		/// <summary>
        /// 设置IBDataInfo接口映射数据
        /// </summary>
        /// <returns></returns>
		protected override void setBdDataInfoNameMap() {
			if (base.name_path_map == null)
            {
                base.name_path_map = new Dictionary<string, string>();
				base.name_path_map.Add("id","Id_ciprn");
				base.name_path_map.Add("id_org","Id_org");
				base.name_path_map.Add("code","Code_prn");
				base.name_path_map.Add("name","Name_prn");
				base.name_path_map.Add("id_group","Id_grp");
            }
		}
    }
}
