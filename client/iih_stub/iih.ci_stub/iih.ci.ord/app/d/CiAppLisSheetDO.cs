
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.ord.app.d
{
    /// <summary>
    /// CiAppLisSheetDO 的摘要说明。
    /// </summary>
    public class CiAppLisSheetDO : BaseDO {

		public const string TABLE_NAME = "ci_app_lis";
		public const string TABLE_ALIAS_NAME = "a0";

        public CiAppLisSheetDO() {
            this.Fg_urgent = false;
            this.Fg_prn = false;
            this.Fg_hp_pres = false;
            this.Fg_bb = false;
            this.Hecominsurinfo = "N";
            this.Fg_prepay = false;
            this.Fg_vip = false;
            this.Fg_lishp = false;
            this.Fg_hpbirth = false;
            this.Fg_blsettled = false;
        }
		public string Id_ciapplissheet {
            get { return getAttrVal<string>("Id_ciapplissheet",null); }
            set { setAttrVal<string>("Id_ciapplissheet", value); }
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
		public string Id_group {
            get { return getAttrVal<string>("Id_group",null); }
            set { setAttrVal<string>("Id_group", value); }
        }
		public string Id_org {
            get { return getAttrVal<string>("Id_org",null); }
            set { setAttrVal<string>("Id_org", value); }
        }
		public string Code_app {
            get { return getAttrVal<string>("Code_app",null); }
            set { setAttrVal<string>("Code_app", value); }
        }
		public string Name_app {
            get { return getAttrVal<string>("Name_app",null); }
            set { setAttrVal<string>("Name_app", value); }
        }
		public DateTime? Dt_plan {
            get { return getAttrVal<FDateTime>("Dt_plan",null); }
            set { setAttrVal<FDateTime>("Dt_plan", value); }
        }
		public bool? Fg_urgent {
            get { return getAttrVal<FBoolean>("Fg_urgent",false); }
            set { setAttrVal<FBoolean>("Fg_urgent", value); }
        }
		public string Id_org_app {
            get { return getAttrVal<string>("Id_org_app",null); }
            set { setAttrVal<string>("Id_org_app", value); }
        }
		public string Id_dep_app {
            get { return getAttrVal<string>("Id_dep_app",null); }
            set { setAttrVal<string>("Id_dep_app", value); }
        }
		public bool? Fg_prn {
            get { return getAttrVal<FBoolean>("Fg_prn",false); }
            set { setAttrVal<FBoolean>("Fg_prn", value); }
        }
		public int? Cnt_prn {
            get { return getAttrVal<int?>("Cnt_prn",null); }
            set { setAttrVal<int?>("Cnt_prn", value); }
        }
		public bool? Fg_hp_pres {
            get { return getAttrVal<FBoolean>("Fg_hp_pres",false); }
            set { setAttrVal<FBoolean>("Fg_hp_pres", value); }
        }
		public string Id_emp_app {
            get { return getAttrVal<string>("Id_emp_app",null); }
            set { setAttrVal<string>("Id_emp_app", value); }
        }
		public DateTime? Dt_app {
            get { return getAttrVal<FDateTime>("Dt_app",null); }
            set { setAttrVal<FDateTime>("Dt_app", value); }
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
		public bool? Fg_opspecial {
            get { return getAttrVal<FBoolean>("Fg_opspecial",null); }
            set { setAttrVal<FBoolean>("Fg_opspecial", value); }
        }
		public string Announcements {
            get { return getAttrVal<string>("Announcements",null); }
            set { setAttrVal<string>("Announcements", value); }
        }
		public string Sampcolplace {
            get { return getAttrVal<string>("Sampcolplace",null); }
            set { setAttrVal<string>("Sampcolplace", value); }
        }
		public string Id_dep_mp {
            get { return getAttrVal<string>("Id_dep_mp",null); }
            set { setAttrVal<string>("Id_dep_mp", value); }
        }
		public FDouble Amt_app_total {
            get { return getAttrVal<FDouble>("Amt_app_total",null); }
            set { setAttrVal<FDouble>("Amt_app_total", value); }
        }
		public string Id_sampcoltime {
            get { return getAttrVal<string>("Id_sampcoltime",null); }
            set { setAttrVal<string>("Id_sampcoltime", value); }
        }
		public FDouble Len_sampcoltime {
            get { return getAttrVal<FDouble>("Len_sampcoltime",null); }
            set { setAttrVal<FDouble>("Len_sampcoltime", value); }
        }
		public string Id_sampcollecttimetp {
            get { return getAttrVal<string>("Id_sampcollecttimetp",null); }
            set { setAttrVal<string>("Id_sampcollecttimetp", value); }
        }
		public string Sd_sampcollecttimetp {
            get { return getAttrVal<string>("Sd_sampcollecttimetp",null); }
            set { setAttrVal<string>("Sd_sampcollecttimetp", value); }
        }
		public string Id_unit_sampcoltime {
            get { return getAttrVal<string>("Id_unit_sampcoltime",null); }
            set { setAttrVal<string>("Id_unit_sampcoltime", value); }
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
		public string Id_session {
            get { return getAttrVal<string>("Id_session",null); }
            set { setAttrVal<string>("Id_session", value); }
        }
		public string Id_samptp {
            get { return getAttrVal<string>("Id_samptp",null); }
            set { setAttrVal<string>("Id_samptp", value); }
        }
		public string Sd_samptp {
            get { return getAttrVal<string>("Sd_samptp",null); }
            set { setAttrVal<string>("Sd_samptp", value); }
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
		public string Def11 {
            get { return getAttrVal<string>("Def11",null); }
            set { setAttrVal<string>("Def11", value); }
        }
		public string Def12 {
            get { return getAttrVal<string>("Def12",null); }
            set { setAttrVal<string>("Def12", value); }
        }
		public string Def13 {
            get { return getAttrVal<string>("Def13",null); }
            set { setAttrVal<string>("Def13", value); }
        }
		public string Def14 {
            get { return getAttrVal<string>("Def14",null); }
            set { setAttrVal<string>("Def14", value); }
        }
		public string Def15 {
            get { return getAttrVal<string>("Def15",null); }
            set { setAttrVal<string>("Def15", value); }
        }
		public string Def16 {
            get { return getAttrVal<string>("Def16",null); }
            set { setAttrVal<string>("Def16", value); }
        }
		public string Def17 {
            get { return getAttrVal<string>("Def17",null); }
            set { setAttrVal<string>("Def17", value); }
        }
		public string Def18 {
            get { return getAttrVal<string>("Def18",null); }
            set { setAttrVal<string>("Def18", value); }
        }
		public string Def19 {
            get { return getAttrVal<string>("Def19",null); }
            set { setAttrVal<string>("Def19", value); }
        }
		public string Def20 {
            get { return getAttrVal<string>("Def20",null); }
            set { setAttrVal<string>("Def20", value); }
        }
		public bool? Fg_hecominsur {
            get { return getAttrVal<FBoolean>("Fg_hecominsur",null); }
            set { setAttrVal<FBoolean>("Fg_hecominsur", value); }
        }
		public string Hecominsurinfo {
            get { return getAttrVal<string>("Hecominsurinfo","N"); }
            set { setAttrVal<string>("Hecominsurinfo", value); }
        }
		public bool? Fg_prepay {
            get { return getAttrVal<FBoolean>("Fg_prepay",false); }
            set { setAttrVal<FBoolean>("Fg_prepay", value); }
        }
		public bool? Fg_vip {
            get { return getAttrVal<FBoolean>("Fg_vip",false); }
            set { setAttrVal<FBoolean>("Fg_vip", value); }
        }
		public bool? Fg_lishp {
            get { return getAttrVal<FBoolean>("Fg_lishp",false); }
            set { setAttrVal<FBoolean>("Fg_lishp", value); }
        }
		public bool? Fg_hpbirth {
            get { return getAttrVal<FBoolean>("Fg_hpbirth",false); }
            set { setAttrVal<FBoolean>("Fg_hpbirth", value); }
        }
		public string Researchinfo {
            get { return getAttrVal<string>("Researchinfo",null); }
            set { setAttrVal<string>("Researchinfo", value); }
        }
		public bool? Fg_blsettled {
            get { return getAttrVal<FBoolean>("Fg_blsettled",false); }
            set { setAttrVal<FBoolean>("Fg_blsettled", value); }
        }
		public string Name_ordi {
            get { return getAttrVal<string>("Name_ordi",null); }
            set { setAttrVal<string>("Name_ordi", value); }
        }
		public string Name_sampcoltime {
            get { return getAttrVal<string>("Name_sampcoltime",null); }
            set { setAttrVal<string>("Name_sampcoltime", value); }
        }
		public string Name_sampcollecttimetp {
            get { return getAttrVal<string>("Name_sampcollecttimetp",null); }
            set { setAttrVal<string>("Name_sampcollecttimetp", value); }
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
            return "ci_app_lis";
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
            return "Id_ciapplissheet";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.app.d.CiAppLisSheetDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_ciapplissheet", "Id_di", "Id_diitm", "Str_id_diitm", "Str_code_di", "Str_name_di", "Name_diag", "Id_group", "Id_org", "Code_app", "Name_app", "Dt_plan", "Fg_urgent", "Id_org_app", "Id_dep_app", "Fg_prn", "Cnt_prn", "Fg_hp_pres", "Id_emp_app", "Dt_app", "Id_pat", "Id_entp", "Code_entp", "Id_en", "Fg_bb", "No_bb", "Fg_opspecial", "Announcements", "Sampcolplace", "Id_dep_mp", "Amt_app_total", "Id_sampcoltime", "Len_sampcoltime", "Id_sampcollecttimetp", "Sd_sampcollecttimetp", "Id_unit_sampcoltime", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Id_session", "Id_samptp", "Sd_samptp", "Def1", "Def2", "Def3", "Def4", "Def5", "Def6", "Def7", "Def8", "Def9", "Def10", "Def11", "Def12", "Def13", "Def14", "Def15", "Def16", "Def17", "Def18", "Def19", "Def20", "Fg_hecominsur", "Hecominsurinfo", "Fg_prepay", "Fg_vip", "Fg_lishp", "Fg_hpbirth", "Researchinfo", "Fg_blsettled", "Name_ordi", "Name_sampcoltime", "Name_sampcollecttimetp"};
        }
        
		/// <summary>
        /// 设置IBDataInfo接口映射数据
        /// </summary>
        /// <returns></returns>
		protected override void setBdDataInfoNameMap() {
			if (base.name_path_map == null)
            {
                base.name_path_map = new Dictionary<string, string>();
				base.name_path_map.Add("id","Id_ciapplissheet");
				base.name_path_map.Add("id_org","Id_org");
				base.name_path_map.Add("code","Code_app");
				base.name_path_map.Add("name","Name_app");
				base.name_path_map.Add("id_group","Id_group");
            }
		}
    }
}
