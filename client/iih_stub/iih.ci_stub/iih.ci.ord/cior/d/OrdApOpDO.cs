
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.ord.cior.d
{
    /// <summary>
    /// OrdApOpDO 的摘要说明。
    /// </summary>
    public class OrdApOpDO : BaseDO {

		public const string TABLE_NAME = "ci_ap_sug";
		public const string TABLE_ALIAS_NAME = "a0";

        public OrdApOpDO() {
            this.Fg_prn = false;
            this.Cnt_prn = 0;
            this.Id_didef_relstd = "~";
        }
		public string Id_apop {
            get { return getAttrVal<string>("Id_apop",null); }
            set { setAttrVal<string>("Id_apop", value); }
        }
		public string Id_or {
            get { return getAttrVal<string>("Id_or",null); }
            set { setAttrVal<string>("Id_or", value); }
        }
		public string Id_di {
            get { return getAttrVal<string>("Id_di",null); }
            set { setAttrVal<string>("Id_di", value); }
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
		public DateTime? Dt_plan {
            get { return getAttrVal<FDateTime>("Dt_plan",null); }
            set { setAttrVal<FDateTime>("Dt_plan", value); }
        }
		public int? Sugplantime {
            get { return getAttrVal<int?>("Sugplantime",null); }
            set { setAttrVal<int?>("Sugplantime", value); }
        }
		public string Id_lvlsug {
            get { return getAttrVal<string>("Id_lvlsug",null); }
            set { setAttrVal<string>("Id_lvlsug", value); }
        }
		public string Sd_lvlsug {
            get { return getAttrVal<string>("Sd_lvlsug",null); }
            set { setAttrVal<string>("Sd_lvlsug", value); }
        }
		public string Id_anestp {
            get { return getAttrVal<string>("Id_anestp",null); }
            set { setAttrVal<string>("Id_anestp", value); }
        }
		public string Sd_anestp {
            get { return getAttrVal<string>("Sd_anestp",null); }
            set { setAttrVal<string>("Sd_anestp", value); }
        }
		public string Id_incitp {
            get { return getAttrVal<string>("Id_incitp",null); }
            set { setAttrVal<string>("Id_incitp", value); }
        }
		public string Sd_incitp {
            get { return getAttrVal<string>("Sd_incitp",null); }
            set { setAttrVal<string>("Sd_incitp", value); }
        }
		public bool? Fg_allergy {
            get { return getAttrVal<FBoolean>("Fg_allergy",null); }
            set { setAttrVal<FBoolean>("Fg_allergy", value); }
        }
		public bool? Fg_patho {
            get { return getAttrVal<FBoolean>("Fg_patho",null); }
            set { setAttrVal<FBoolean>("Fg_patho", value); }
        }
		public string Id_su_op {
            get { return getAttrVal<string>("Id_su_op",null); }
            set { setAttrVal<string>("Id_su_op", value); }
        }
		public string Sd_su_op {
            get { return getAttrVal<string>("Sd_su_op",null); }
            set { setAttrVal<string>("Sd_su_op", value); }
        }
		public string Announcements {
            get { return getAttrVal<string>("Announcements",null); }
            set { setAttrVal<string>("Announcements", value); }
        }
		public string Id_srv {
            get { return getAttrVal<string>("Id_srv",null); }
            set { setAttrVal<string>("Id_srv", value); }
        }
		public string Id_srv_code {
            get { return getAttrVal<string>("Id_srv_code",null); }
            set { setAttrVal<string>("Id_srv_code", value); }
        }
		public FDouble Quan_bt_paln {
            get { return getAttrVal<FDouble>("Quan_bt_paln",null); }
            set { setAttrVal<FDouble>("Quan_bt_paln", value); }
        }
		public string Id_emp_operate {
            get { return getAttrVal<string>("Id_emp_operate",null); }
            set { setAttrVal<string>("Id_emp_operate", value); }
        }
		public string Id_emp_helper {
            get { return getAttrVal<string>("Id_emp_helper",null); }
            set { setAttrVal<string>("Id_emp_helper", value); }
        }
		public string Id_sugbody {
            get { return getAttrVal<string>("Id_sugbody",null); }
            set { setAttrVal<string>("Id_sugbody", value); }
        }
		public string Sd_sugbody {
            get { return getAttrVal<string>("Sd_sugbody",null); }
            set { setAttrVal<string>("Sd_sugbody", value); }
        }
		public string Specialreq {
            get { return getAttrVal<string>("Specialreq",null); }
            set { setAttrVal<string>("Specialreq", value); }
        }
		public string Specialinstrument {
            get { return getAttrVal<string>("Specialinstrument",null); }
            set { setAttrVal<string>("Specialinstrument", value); }
        }
		public string Specialdes {
            get { return getAttrVal<string>("Specialdes",null); }
            set { setAttrVal<string>("Specialdes", value); }
        }
		public bool? Fg_er_sug {
            get { return getAttrVal<FBoolean>("Fg_er_sug",null); }
            set { setAttrVal<FBoolean>("Fg_er_sug", value); }
        }
		public bool? Fg_xq_sug {
            get { return getAttrVal<FBoolean>("Fg_xq_sug",null); }
            set { setAttrVal<FBoolean>("Fg_xq_sug", value); }
        }
		public bool? Fg_zq_sug {
            get { return getAttrVal<FBoolean>("Fg_zq_sug",null); }
            set { setAttrVal<FBoolean>("Fg_zq_sug", value); }
        }
		public bool? Fg_new_sug {
            get { return getAttrVal<FBoolean>("Fg_new_sug",null); }
            set { setAttrVal<FBoolean>("Fg_new_sug", value); }
        }
		public string Name_diag {
            get { return getAttrVal<string>("Name_diag",null); }
            set { setAttrVal<string>("Name_diag", value); }
        }
		public string Id_diitm {
            get { return getAttrVal<string>("Id_diitm",null); }
            set { setAttrVal<string>("Id_diitm", value); }
        }
		public bool? Fg_prn {
            get { return getAttrVal<FBoolean>("Fg_prn",false); }
            set { setAttrVal<FBoolean>("Fg_prn", value); }
        }
		public int? Cnt_prn {
            get { return getAttrVal<int?>("Cnt_prn",0); }
            set { setAttrVal<int?>("Cnt_prn", value); }
        }
		public string Id_didef_relstd {
            get { return getAttrVal<string>("Id_didef_relstd","~"); }
            set { setAttrVal<string>("Id_didef_relstd", value); }
        }
		public bool? Fg_daysug {
            get { return getAttrVal<FBoolean>("Fg_daysug",null); }
            set { setAttrVal<FBoolean>("Fg_daysug", value); }
        }
		public string Id_didef_dis {
            get { return getAttrVal<string>("Id_didef_dis",null); }
            set { setAttrVal<string>("Id_didef_dis", value); }
        }
		public string Name_didef_dis {
            get { return getAttrVal<string>("Name_didef_dis",null); }
            set { setAttrVal<string>("Name_didef_dis", value); }
        }
		public string Name_lvlsug {
            get { return getAttrVal<string>("Name_lvlsug",null); }
            set { setAttrVal<string>("Name_lvlsug", value); }
        }
		public string Name_anestp {
            get { return getAttrVal<string>("Name_anestp",null); }
            set { setAttrVal<string>("Name_anestp", value); }
        }
		public string Eu_anesca {
            get { return getAttrVal<string>("Eu_anesca",null); }
            set { setAttrVal<string>("Eu_anesca", value); }
        }
		public string Name_incitp {
            get { return getAttrVal<string>("Name_incitp",null); }
            set { setAttrVal<string>("Name_incitp", value); }
        }
		public string Name_op {
            get { return getAttrVal<string>("Name_op",null); }
            set { setAttrVal<string>("Name_op", value); }
        }
		public string Code_op {
            get { return getAttrVal<string>("Code_op",null); }
            set { setAttrVal<string>("Code_op", value); }
        }
		public string Name_operate {
            get { return getAttrVal<string>("Name_operate",null); }
            set { setAttrVal<string>("Name_operate", value); }
        }
		public string Name_helper {
            get { return getAttrVal<string>("Name_helper",null); }
            set { setAttrVal<string>("Name_helper", value); }
        }
		public string Name_sugbody {
            get { return getAttrVal<string>("Name_sugbody",null); }
            set { setAttrVal<string>("Name_sugbody", value); }
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
            return "ci_ap_sug";
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
            return "Id_apop";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.cior.d.OrdApOpDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_apop", "Id_or", "Id_di", "Str_id_diitm", "Str_code_di", "Str_name_di", "No_applyform", "Dt_plan", "Sugplantime", "Id_lvlsug", "Sd_lvlsug", "Id_anestp", "Sd_anestp", "Id_incitp", "Sd_incitp", "Fg_allergy", "Fg_patho", "Id_su_op", "Sd_su_op", "Announcements", "Id_srv", "Id_srv_code", "Quan_bt_paln", "Id_emp_operate", "Id_emp_helper", "Id_sugbody", "Sd_sugbody", "Specialreq", "Specialinstrument", "Specialdes", "Fg_er_sug", "Fg_xq_sug", "Fg_zq_sug", "Fg_new_sug", "Name_diag", "Id_diitm", "Fg_prn", "Cnt_prn", "Id_didef_relstd", "Fg_daysug", "Id_didef_dis", "Name_didef_dis", "Name_lvlsug", "Name_anestp", "Eu_anesca", "Name_incitp", "Name_op", "Code_op", "Name_operate", "Name_helper", "Name_sugbody"};
        }
        
    }
}
