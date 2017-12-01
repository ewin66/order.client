
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.ord.cior.d
{
    /// <summary>
    /// OrdApLabDO 的摘要说明。
    /// </summary>
    public class OrdApLabDO : BaseDO {

		public const string TABLE_NAME = "ci_ap_lab";
		public const string TABLE_ALIAS_NAME = "a0";

        public OrdApLabDO() {
            this.Fg_prn = false;
            this.Cnt_prn = 0;
        }
		public string Id_orlab {
            get { return getAttrVal<string>("Id_orlab",null); }
            set { setAttrVal<string>("Id_orlab", value); }
        }
		public string Id_or {
            get { return getAttrVal<string>("Id_or",null); }
            set { setAttrVal<string>("Id_or", value); }
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
		public string No_applyform {
            get { return getAttrVal<string>("No_applyform",null); }
            set { setAttrVal<string>("No_applyform", value); }
        }
		public string Id_srvca {
            get { return getAttrVal<string>("Id_srvca",null); }
            set { setAttrVal<string>("Id_srvca", value); }
        }
		public string Sd_pps {
            get { return getAttrVal<string>("Sd_pps",null); }
            set { setAttrVal<string>("Sd_pps", value); }
        }
		public DateTime? Dt_plan {
            get { return getAttrVal<FDateTime>("Dt_plan",null); }
            set { setAttrVal<FDateTime>("Dt_plan", value); }
        }
		public string Id_pps {
            get { return getAttrVal<string>("Id_pps",null); }
            set { setAttrVal<string>("Id_pps", value); }
        }
		public string Des_pps {
            get { return getAttrVal<string>("Des_pps",null); }
            set { setAttrVal<string>("Des_pps", value); }
        }
		public string Id_su_lab {
            get { return getAttrVal<string>("Id_su_lab",null); }
            set { setAttrVal<string>("Id_su_lab", value); }
        }
		public string Sd_su_lab {
            get { return getAttrVal<string>("Sd_su_lab",null); }
            set { setAttrVal<string>("Sd_su_lab", value); }
        }
		public string Des_sympsign {
            get { return getAttrVal<string>("Des_sympsign",null); }
            set { setAttrVal<string>("Des_sympsign", value); }
        }
		public string Clinicalzztz {
            get { return getAttrVal<string>("Clinicalzztz",null); }
            set { setAttrVal<string>("Clinicalzztz", value); }
        }
		public string Pastillness {
            get { return getAttrVal<string>("Pastillness",null); }
            set { setAttrVal<string>("Pastillness", value); }
        }
		public string Auximtexam {
            get { return getAttrVal<string>("Auximtexam",null); }
            set { setAttrVal<string>("Auximtexam", value); }
        }
		public string Announcements {
            get { return getAttrVal<string>("Announcements",null); }
            set { setAttrVal<string>("Announcements", value); }
        }
		public bool? Fg_urgent {
            get { return getAttrVal<FBoolean>("Fg_urgent",null); }
            set { setAttrVal<FBoolean>("Fg_urgent", value); }
        }
		public string Sd_samptp {
            get { return getAttrVal<string>("Sd_samptp",null); }
            set { setAttrVal<string>("Sd_samptp", value); }
        }
		public string Id_samptp {
            get { return getAttrVal<string>("Id_samptp",null); }
            set { setAttrVal<string>("Id_samptp", value); }
        }
		public FDouble Quan {
            get { return getAttrVal<FDouble>("Quan",null); }
            set { setAttrVal<FDouble>("Quan", value); }
        }
		public string Sd_colltp {
            get { return getAttrVal<string>("Sd_colltp",null); }
            set { setAttrVal<string>("Sd_colltp", value); }
        }
		public string Id_colltp {
            get { return getAttrVal<string>("Id_colltp",null); }
            set { setAttrVal<string>("Id_colltp", value); }
        }
		public string Des_labsamp {
            get { return getAttrVal<string>("Des_labsamp",null); }
            set { setAttrVal<string>("Des_labsamp", value); }
        }
		public string Createdby {
            get { return getAttrVal<string>("Createdby",null); }
            set { setAttrVal<string>("Createdby", value); }
        }
		public DateTime? Modifiedtime {
            get { return getAttrVal<FDateTime>("Modifiedtime",null); }
            set { setAttrVal<FDateTime>("Modifiedtime", value); }
        }
		public DateTime? Createdtime {
            get { return getAttrVal<FDateTime>("Createdtime",null); }
            set { setAttrVal<FDateTime>("Createdtime", value); }
        }
		public string Modifiedby {
            get { return getAttrVal<string>("Modifiedby",null); }
            set { setAttrVal<string>("Modifiedby", value); }
        }
		public string Sd_contp {
            get { return getAttrVal<string>("Sd_contp",null); }
            set { setAttrVal<string>("Sd_contp", value); }
        }
		public string Id_contp {
            get { return getAttrVal<string>("Id_contp",null); }
            set { setAttrVal<string>("Id_contp", value); }
        }
		public string Id_unit_quan {
            get { return getAttrVal<string>("Id_unit_quan",null); }
            set { setAttrVal<string>("Id_unit_quan", value); }
        }
		public string Name_diag {
            get { return getAttrVal<string>("Name_diag",null); }
            set { setAttrVal<string>("Name_diag", value); }
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
		public string Def45 {
            get { return getAttrVal<string>("Def45",null); }
            set { setAttrVal<string>("Def45", value); }
        }
		public string Def46 {
            get { return getAttrVal<string>("Def46",null); }
            set { setAttrVal<string>("Def46", value); }
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
		public string Id_sampcoltime {
            get { return getAttrVal<string>("Id_sampcoltime",null); }
            set { setAttrVal<string>("Id_sampcoltime", value); }
        }
		public string Id_sampcollecttimetp {
            get { return getAttrVal<string>("Id_sampcollecttimetp",null); }
            set { setAttrVal<string>("Id_sampcollecttimetp", value); }
        }
		public string Sd_sampcollecttimetp {
            get { return getAttrVal<string>("Sd_sampcollecttimetp",null); }
            set { setAttrVal<string>("Sd_sampcollecttimetp", value); }
        }
		public FDouble Len_sampcoltime {
            get { return getAttrVal<FDouble>("Len_sampcoltime",null); }
            set { setAttrVal<FDouble>("Len_sampcoltime", value); }
        }
		public string Id_unit_sampcoltime {
            get { return getAttrVal<string>("Id_unit_sampcoltime",null); }
            set { setAttrVal<string>("Id_unit_sampcoltime", value); }
        }
		public bool? Fg_prn {
            get { return getAttrVal<FBoolean>("Fg_prn",false); }
            set { setAttrVal<FBoolean>("Fg_prn", value); }
        }
		public int? Cnt_prn {
            get { return getAttrVal<int?>("Cnt_prn",0); }
            set { setAttrVal<int?>("Cnt_prn", value); }
        }
		public string Id_labgroup {
            get { return getAttrVal<string>("Id_labgroup",null); }
            set { setAttrVal<string>("Id_labgroup", value); }
        }
		public string Sd_labgroup {
            get { return getAttrVal<string>("Sd_labgroup",null); }
            set { setAttrVal<string>("Sd_labgroup", value); }
        }
		public string Name_ordi {
            get { return getAttrVal<string>("Name_ordi",null); }
            set { setAttrVal<string>("Name_ordi", value); }
        }
		public string Name_pps {
            get { return getAttrVal<string>("Name_pps",null); }
            set { setAttrVal<string>("Name_pps", value); }
        }
		public string Name_samptp {
            get { return getAttrVal<string>("Name_samptp",null); }
            set { setAttrVal<string>("Name_samptp", value); }
        }
		public string Code_contp {
            get { return getAttrVal<string>("Code_contp",null); }
            set { setAttrVal<string>("Code_contp", value); }
        }
		public string Name_contp {
            get { return getAttrVal<string>("Name_contp",null); }
            set { setAttrVal<string>("Name_contp", value); }
        }
		public string Qunitcode {
            get { return getAttrVal<string>("Qunitcode",null); }
            set { setAttrVal<string>("Qunitcode", value); }
        }
		public string Qunitname {
            get { return getAttrVal<string>("Qunitname",null); }
            set { setAttrVal<string>("Qunitname", value); }
        }
		public string Name_sampcoltime {
            get { return getAttrVal<string>("Name_sampcoltime",null); }
            set { setAttrVal<string>("Name_sampcoltime", value); }
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
            return "ci_ap_lab";
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
            return "Id_orlab";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.cior.d.OrdApLabDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_orlab", "Id_or", "Id_di", "Id_diitm", "Str_id_diitm", "Str_code_di", "Str_name_di", "No_applyform", "Id_srvca", "Sd_pps", "Dt_plan", "Id_pps", "Des_pps", "Id_su_lab", "Sd_su_lab", "Des_sympsign", "Clinicalzztz", "Pastillness", "Auximtexam", "Announcements", "Fg_urgent", "Sd_samptp", "Id_samptp", "Quan", "Sd_colltp", "Id_colltp", "Des_labsamp", "Createdby", "Modifiedtime", "Createdtime", "Modifiedby", "Sd_contp", "Id_contp", "Id_unit_quan", "Name_diag", "Def1", "Def2", "Def3", "Def4", "Def5", "Def6", "Def7", "Def8", "Def9", "Def10", "Def11", "Def12", "Def13", "Def14", "Def15", "Def16", "Def17", "Def18", "Def19", "Def20", "Def21", "Def22", "Def23", "Def24", "Def25", "Def26", "Def27", "Def28", "Def29", "Def30", "Def31", "Def32", "Def33", "Def34", "Def35", "Def36", "Def37", "Def38", "Def39", "Def40", "Def41", "Def42", "Def43", "Def44", "Def45", "Def46", "Def47", "Def48", "Def49", "Def50", "Id_sampcoltime", "Id_sampcollecttimetp", "Sd_sampcollecttimetp", "Len_sampcoltime", "Id_unit_sampcoltime", "Fg_prn", "Cnt_prn", "Id_labgroup", "Sd_labgroup", "Name_ordi", "Name_pps", "Name_samptp", "Code_contp", "Name_contp", "Qunitcode", "Qunitname", "Name_sampcoltime"};
        }
        
    }
}
