
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.app.d
{
    /// <summary>
    /// CiAppPathgySheetDO 的摘要说明。
    /// </summary>
    public class CiAppPathgySheetDO : BaseDO {

		public const string TABLE_NAME = "ci_app_pathgy";
		public const string TABLE_ALIAS_NAME = "a0";

        public CiAppPathgySheetDO() {
            this.Fg_hp = false;
            this.Fg_bb = false;
            this.Hecominsurinfo = "N";
            this.Fg_prepay = false;
            this.Fg_vip = false;
            this.Fg_hpbirth = false;
            this.Fg_blsettled = false;
        }
		public string Id_ciapppathgysheet {
            get { return getAttrVal<string>("Id_ciapppathgysheet",null); }
            set { setAttrVal<string>("Id_ciapppathgysheet", value); }
        }
		public string Id_pat {
            get { return getAttrVal<string>("Id_pat",null); }
            set { setAttrVal<string>("Id_pat", value); }
        }
		public string Id_en {
            get { return getAttrVal<string>("Id_en",null); }
            set { setAttrVal<string>("Id_en", value); }
        }
		public string Id_entp {
            get { return getAttrVal<string>("Id_entp",null); }
            set { setAttrVal<string>("Id_entp", value); }
        }
		public string Code_entp {
            get { return getAttrVal<string>("Code_entp",null); }
            set { setAttrVal<string>("Code_entp", value); }
        }
		public bool? Fg_hp {
            get { return getAttrVal<FBoolean>("Fg_hp",false); }
            set { setAttrVal<FBoolean>("Fg_hp", value); }
        }
		public bool? Fg_bb {
            get { return getAttrVal<FBoolean>("Fg_bb",false); }
            set { setAttrVal<FBoolean>("Fg_bb", value); }
        }
		public int? No_bb {
            get { return getAttrVal<int?>("No_bb",null); }
            set { setAttrVal<int?>("No_bb", value); }
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
		public string Code_app {
            get { return getAttrVal<string>("Code_app",null); }
            set { setAttrVal<string>("Code_app", value); }
        }
		public string Name_app {
            get { return getAttrVal<string>("Name_app",null); }
            set { setAttrVal<string>("Name_app", value); }
        }
		public string Id_or {
            get { return getAttrVal<string>("Id_or",null); }
            set { setAttrVal<string>("Id_or", value); }
        }
		public string Id_srv {
            get { return getAttrVal<string>("Id_srv",null); }
            set { setAttrVal<string>("Id_srv", value); }
        }
		public string Id_appathgy {
            get { return getAttrVal<string>("Id_appathgy",null); }
            set { setAttrVal<string>("Id_appathgy", value); }
        }
		public string No_applyform {
            get { return getAttrVal<string>("No_applyform",null); }
            set { setAttrVal<string>("No_applyform", value); }
        }
		public string Id_samptp {
            get { return getAttrVal<string>("Id_samptp",null); }
            set { setAttrVal<string>("Id_samptp", value); }
        }
		public string Sd_samptp {
            get { return getAttrVal<string>("Sd_samptp",null); }
            set { setAttrVal<string>("Sd_samptp", value); }
        }
		public int? Quan {
            get { return getAttrVal<int?>("Quan",null); }
            set { setAttrVal<int?>("Quan", value); }
        }
		public string Id_colltp {
            get { return getAttrVal<string>("Id_colltp",null); }
            set { setAttrVal<string>("Id_colltp", value); }
        }
		public string Sd_colltp {
            get { return getAttrVal<string>("Sd_colltp",null); }
            set { setAttrVal<string>("Sd_colltp", value); }
        }
		public string Des_labsamp {
            get { return getAttrVal<string>("Des_labsamp",null); }
            set { setAttrVal<string>("Des_labsamp", value); }
        }
		public bool? Fg_urgent {
            get { return getAttrVal<FBoolean>("Fg_urgent",null); }
            set { setAttrVal<FBoolean>("Fg_urgent", value); }
        }
		public string Announcements {
            get { return getAttrVal<string>("Announcements",null); }
            set { setAttrVal<string>("Announcements", value); }
        }
		public string Des_sympsign {
            get { return getAttrVal<string>("Des_sympsign",null); }
            set { setAttrVal<string>("Des_sympsign", value); }
        }
		public bool? Fg_outer {
            get { return getAttrVal<FBoolean>("Fg_outer",null); }
            set { setAttrVal<FBoolean>("Fg_outer", value); }
        }
		public string No_pathgy_old {
            get { return getAttrVal<string>("No_pathgy_old",null); }
            set { setAttrVal<string>("No_pathgy_old", value); }
        }
		public DateTime? Dt_pathgy_old {
            get { return getAttrVal<FDateTime>("Dt_pathgy_old",null); }
            set { setAttrVal<FDateTime>("Dt_pathgy_old", value); }
        }
		public string Di_pathgy_old {
            get { return getAttrVal<string>("Di_pathgy_old",null); }
            set { setAttrVal<string>("Di_pathgy_old", value); }
        }
		public string Org_pathgy_old {
            get { return getAttrVal<string>("Org_pathgy_old",null); }
            set { setAttrVal<string>("Org_pathgy_old", value); }
        }
		public string Collectdes {
            get { return getAttrVal<string>("Collectdes",null); }
            set { setAttrVal<string>("Collectdes", value); }
        }
		public string Id_emp {
            get { return getAttrVal<string>("Id_emp",null); }
            set { setAttrVal<string>("Id_emp", value); }
        }
		public string Id_dep {
            get { return getAttrVal<string>("Id_dep",null); }
            set { setAttrVal<string>("Id_dep", value); }
        }
		public DateTime? Dt_coll {
            get { return getAttrVal<FDateTime>("Dt_coll",null); }
            set { setAttrVal<FDateTime>("Dt_coll", value); }
        }
		public string Id_su_pathgy {
            get { return getAttrVal<string>("Id_su_pathgy",null); }
            set { setAttrVal<string>("Id_su_pathgy", value); }
        }
		public string Sd_su_pathgy {
            get { return getAttrVal<string>("Sd_su_pathgy",null); }
            set { setAttrVal<string>("Sd_su_pathgy", value); }
        }
		public string No_pathgy {
            get { return getAttrVal<string>("No_pathgy",null); }
            set { setAttrVal<string>("No_pathgy", value); }
        }
		public bool? Fg_set {
            get { return getAttrVal<FBoolean>("Fg_set",null); }
            set { setAttrVal<FBoolean>("Fg_set", value); }
        }
		public DateTime? Dt_rptpathgy {
            get { return getAttrVal<FDateTime>("Dt_rptpathgy",null); }
            set { setAttrVal<FDateTime>("Dt_rptpathgy", value); }
        }
		public string Id_grp {
            get { return getAttrVal<string>("Id_grp",null); }
            set { setAttrVal<string>("Id_grp", value); }
        }
		public string Id_org {
            get { return getAttrVal<string>("Id_org",null); }
            set { setAttrVal<string>("Id_org", value); }
        }
		public string Id_org_app {
            get { return getAttrVal<string>("Id_org_app",null); }
            set { setAttrVal<string>("Id_org_app", value); }
        }
		public string Id_dep_app {
            get { return getAttrVal<string>("Id_dep_app",null); }
            set { setAttrVal<string>("Id_dep_app", value); }
        }
		public string Id_emp_app {
            get { return getAttrVal<string>("Id_emp_app",null); }
            set { setAttrVal<string>("Id_emp_app", value); }
        }
		public DateTime? Dt_app {
            get { return getAttrVal<FDateTime>("Dt_app",null); }
            set { setAttrVal<FDateTime>("Dt_app", value); }
        }
		public string Id_dep_mp {
            get { return getAttrVal<string>("Id_dep_mp",null); }
            set { setAttrVal<string>("Id_dep_mp", value); }
        }
		public bool? Fg_opspecial {
            get { return getAttrVal<FBoolean>("Fg_opspecial",null); }
            set { setAttrVal<FBoolean>("Fg_opspecial", value); }
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
		public bool? Fg_hpbirth {
            get { return getAttrVal<FBoolean>("Fg_hpbirth",false); }
            set { setAttrVal<FBoolean>("Fg_hpbirth", value); }
        }
		public string Researchinfo {
            get { return getAttrVal<string>("Researchinfo",null); }
            set { setAttrVal<string>("Researchinfo", value); }
        }
		public FDouble Amt_app {
            get { return getAttrVal<FDouble>("Amt_app",null); }
            set { setAttrVal<FDouble>("Amt_app", value); }
        }
		public bool? Fg_blsettled {
            get { return getAttrVal<FBoolean>("Fg_blsettled",false); }
            set { setAttrVal<FBoolean>("Fg_blsettled", value); }
        }
		public bool? Fg_prn {
            get { return getAttrVal<FBoolean>("Fg_prn",null); }
            set { setAttrVal<FBoolean>("Fg_prn", value); }
        }
		public int? Cnt_prn {
            get { return getAttrVal<int?>("Cnt_prn",null); }
            set { setAttrVal<int?>("Cnt_prn", value); }
        }
		public string Id_session {
            get { return getAttrVal<string>("Id_session",null); }
            set { setAttrVal<string>("Id_session", value); }
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
		public string Def15 {
            get { return getAttrVal<string>("Def15",null); }
            set { setAttrVal<string>("Def15", value); }
        }
		public string Def14 {
            get { return getAttrVal<string>("Def14",null); }
            set { setAttrVal<string>("Def14", value); }
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
		public string Def21 {
            get { return getAttrVal<string>("Def21",null); }
            set { setAttrVal<string>("Def21", value); }
        }
		public string Def22 {
            get { return getAttrVal<string>("Def22",null); }
            set { setAttrVal<string>("Def22", value); }
        }
		public string Def23 {
            get { return getAttrVal<string>("Def23",null); }
            set { setAttrVal<string>("Def23", value); }
        }
		public string Def24 {
            get { return getAttrVal<string>("Def24",null); }
            set { setAttrVal<string>("Def24", value); }
        }
		public string Def25 {
            get { return getAttrVal<string>("Def25",null); }
            set { setAttrVal<string>("Def25", value); }
        }
		public string Def26 {
            get { return getAttrVal<string>("Def26",null); }
            set { setAttrVal<string>("Def26", value); }
        }
		public string Def27 {
            get { return getAttrVal<string>("Def27",null); }
            set { setAttrVal<string>("Def27", value); }
        }
		public string Def28 {
            get { return getAttrVal<string>("Def28",null); }
            set { setAttrVal<string>("Def28", value); }
        }
		public string Def29 {
            get { return getAttrVal<string>("Def29",null); }
            set { setAttrVal<string>("Def29", value); }
        }
		public string Def30 {
            get { return getAttrVal<string>("Def30",null); }
            set { setAttrVal<string>("Def30", value); }
        }
		public string Def31 {
            get { return getAttrVal<string>("Def31",null); }
            set { setAttrVal<string>("Def31", value); }
        }
		public string Def32 {
            get { return getAttrVal<string>("Def32",null); }
            set { setAttrVal<string>("Def32", value); }
        }
		public string Def33 {
            get { return getAttrVal<string>("Def33",null); }
            set { setAttrVal<string>("Def33", value); }
        }
		public string Def34 {
            get { return getAttrVal<string>("Def34",null); }
            set { setAttrVal<string>("Def34", value); }
        }
		public string Def35 {
            get { return getAttrVal<string>("Def35",null); }
            set { setAttrVal<string>("Def35", value); }
        }
		public string Def36 {
            get { return getAttrVal<string>("Def36",null); }
            set { setAttrVal<string>("Def36", value); }
        }
		public string Def37 {
            get { return getAttrVal<string>("Def37",null); }
            set { setAttrVal<string>("Def37", value); }
        }
		public string Def38 {
            get { return getAttrVal<string>("Def38",null); }
            set { setAttrVal<string>("Def38", value); }
        }
		public string Def39 {
            get { return getAttrVal<string>("Def39",null); }
            set { setAttrVal<string>("Def39", value); }
        }
		public string Def40 {
            get { return getAttrVal<string>("Def40",null); }
            set { setAttrVal<string>("Def40", value); }
        }
		public string Def41 {
            get { return getAttrVal<string>("Def41",null); }
            set { setAttrVal<string>("Def41", value); }
        }
		public string Def42 {
            get { return getAttrVal<string>("Def42",null); }
            set { setAttrVal<string>("Def42", value); }
        }
		public string Def43 {
            get { return getAttrVal<string>("Def43",null); }
            set { setAttrVal<string>("Def43", value); }
        }
		public string Def44 {
            get { return getAttrVal<string>("Def44",null); }
            set { setAttrVal<string>("Def44", value); }
        }
		public string Def46 {
            get { return getAttrVal<string>("Def46",null); }
            set { setAttrVal<string>("Def46", value); }
        }
		public string Def45 {
            get { return getAttrVal<string>("Def45",null); }
            set { setAttrVal<string>("Def45", value); }
        }
		public string Def47 {
            get { return getAttrVal<string>("Def47",null); }
            set { setAttrVal<string>("Def47", value); }
        }
		public string Def48 {
            get { return getAttrVal<string>("Def48",null); }
            set { setAttrVal<string>("Def48", value); }
        }
		public string Def49 {
            get { return getAttrVal<string>("Def49",null); }
            set { setAttrVal<string>("Def49", value); }
        }
		public string Def50 {
            get { return getAttrVal<string>("Def50",null); }
            set { setAttrVal<string>("Def50", value); }
        }
		public string Name_ordi {
            get { return getAttrVal<string>("Name_ordi",null); }
            set { setAttrVal<string>("Name_ordi", value); }
        }
		public string Name_samptp {
            get { return getAttrVal<string>("Name_samptp",null); }
            set { setAttrVal<string>("Name_samptp", value); }
        }
		public string Name_cooltp {
            get { return getAttrVal<string>("Name_cooltp",null); }
            set { setAttrVal<string>("Name_cooltp", value); }
        }
		public string Name_coll_emp {
            get { return getAttrVal<string>("Name_coll_emp",null); }
            set { setAttrVal<string>("Name_coll_emp", value); }
        }
		public string Name_dep {
            get { return getAttrVal<string>("Name_dep",null); }
            set { setAttrVal<string>("Name_dep", value); }
        }
		public string Name_su {
            get { return getAttrVal<string>("Name_su",null); }
            set { setAttrVal<string>("Name_su", value); }
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
            return "ci_app_pathgy";
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
            return "Id_ciapppathgysheet";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.app.d.CiAppPathgySheetDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_ciapppathgysheet", "Id_pat", "Id_en", "Id_entp", "Code_entp", "Fg_hp", "Fg_bb", "No_bb", "Id_di", "Id_diitm", "Str_id_diitm", "Str_code_di", "Str_name_di", "Name_diag", "Code_app", "Name_app", "Id_or", "Id_srv", "Id_appathgy", "No_applyform", "Id_samptp", "Sd_samptp", "Quan", "Id_colltp", "Sd_colltp", "Des_labsamp", "Fg_urgent", "Announcements", "Des_sympsign", "Fg_outer", "No_pathgy_old", "Dt_pathgy_old", "Di_pathgy_old", "Org_pathgy_old", "Collectdes", "Id_emp", "Id_dep", "Dt_coll", "Id_su_pathgy", "Sd_su_pathgy", "No_pathgy", "Fg_set", "Dt_rptpathgy", "Id_grp", "Id_org", "Id_org_app", "Id_dep_app", "Id_emp_app", "Dt_app", "Id_dep_mp", "Fg_opspecial", "Fg_hecominsur", "Hecominsurinfo", "Fg_prepay", "Fg_vip", "Fg_hpbirth", "Researchinfo", "Amt_app", "Fg_blsettled", "Fg_prn", "Cnt_prn", "Id_session", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Def1", "Def2", "Def3", "Def4", "Def5", "Def6", "Def7", "Def8", "Def9", "Def10", "Def11", "Def12", "Def13", "Def15", "Def14", "Def16", "Def17", "Def18", "Def19", "Def20", "Def21", "Def22", "Def23", "Def24", "Def25", "Def26", "Def27", "Def28", "Def29", "Def30", "Def31", "Def32", "Def33", "Def34", "Def35", "Def36", "Def37", "Def38", "Def39", "Def40", "Def41", "Def42", "Def43", "Def44", "Def46", "Def45", "Def47", "Def48", "Def49", "Def50", "Name_ordi", "Name_samptp", "Name_cooltp", "Name_coll_emp", "Name_dep", "Name_su"};
        }
        
    }
}
