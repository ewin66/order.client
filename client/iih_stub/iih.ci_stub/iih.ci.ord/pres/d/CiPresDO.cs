
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.ord.pres.d
{
    /// <summary>
    /// CiPresDO 的摘要说明。
    /// </summary>
    public class CiPresDO : BaseDO {

		public const string TABLE_NAME = "ci_pres";
		public const string TABLE_ALIAS_NAME = "a0";

        public CiPresDO() {
            this.Fg_prepay = false;
            this.Fg_blsettled = false;
            this.Hecominsurinfo = "N";
            this.Fg_vip = false;
        }
		public string Id_pres {
            get { return getAttrVal<string>("Id_pres",null); }
            set { setAttrVal<string>("Id_pres", value); }
        }
		public string Id_grp {
            get { return getAttrVal<string>("Id_grp",null); }
            set { setAttrVal<string>("Id_grp", value); }
        }
		public string Id_org {
            get { return getAttrVal<string>("Id_org",null); }
            set { setAttrVal<string>("Id_org", value); }
        }
		public string Id_pati {
            get { return getAttrVal<string>("Id_pati",null); }
            set { setAttrVal<string>("Id_pati", value); }
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
		public string Id_di {
            get { return getAttrVal<string>("Id_di",null); }
            set { setAttrVal<string>("Id_di", value); }
        }
		public string Id_diitm {
            get { return getAttrVal<string>("Id_diitm",null); }
            set { setAttrVal<string>("Id_diitm", value); }
        }
		public string Str_id_di {
            get { return getAttrVal<string>("Str_id_di",null); }
            set { setAttrVal<string>("Str_id_di", value); }
        }
		public string Str_name_di {
            get { return getAttrVal<string>("Str_name_di",null); }
            set { setAttrVal<string>("Str_name_di", value); }
        }
		public string Id_srvtp {
            get { return getAttrVal<string>("Id_srvtp",null); }
            set { setAttrVal<string>("Id_srvtp", value); }
        }
		public string Sd_srvtp {
            get { return getAttrVal<string>("Sd_srvtp",null); }
            set { setAttrVal<string>("Sd_srvtp", value); }
        }
		public string Id_prestp {
            get { return getAttrVal<string>("Id_prestp",null); }
            set { setAttrVal<string>("Id_prestp", value); }
        }
		public string Sd_prestp {
            get { return getAttrVal<string>("Sd_prestp",null); }
            set { setAttrVal<string>("Sd_prestp", value); }
        }
		public string Code {
            get { return getAttrVal<string>("Code",null); }
            set { setAttrVal<string>("Code", value); }
        }
		public string Name {
            get { return getAttrVal<string>("Name",null); }
            set { setAttrVal<string>("Name", value); }
        }
		public string Id_dep_or {
            get { return getAttrVal<string>("Id_dep_or",null); }
            set { setAttrVal<string>("Id_dep_or", value); }
        }
		public string Id_emp_or {
            get { return getAttrVal<string>("Id_emp_or",null); }
            set { setAttrVal<string>("Id_emp_or", value); }
        }
		public DateTime? Dt_entry {
            get { return getAttrVal<FDateTime>("Dt_entry",null); }
            set { setAttrVal<FDateTime>("Dt_entry", value); }
        }
		public bool? Fg_bb {
            get { return getAttrVal<FBoolean>("Fg_bb",null); }
            set { setAttrVal<FBoolean>("Fg_bb", value); }
        }
		public int? No_bb {
            get { return getAttrVal<int?>("No_bb",null); }
            set { setAttrVal<int?>("No_bb", value); }
        }
		public string Id_bb {
            get { return getAttrVal<string>("Id_bb",null); }
            set { setAttrVal<string>("Id_bb", value); }
        }
		public string Id_route {
            get { return getAttrVal<string>("Id_route",null); }
            set { setAttrVal<string>("Id_route", value); }
        }
		public string Id_routedes {
            get { return getAttrVal<string>("Id_routedes",null); }
            set { setAttrVal<string>("Id_routedes", value); }
        }
		public string Id_boil {
            get { return getAttrVal<string>("Id_boil",null); }
            set { setAttrVal<string>("Id_boil", value); }
        }
		public string Id_boildes {
            get { return getAttrVal<string>("Id_boildes",null); }
            set { setAttrVal<string>("Id_boildes", value); }
        }
		public bool? Fg_charge {
            get { return getAttrVal<FBoolean>("Fg_charge",null); }
            set { setAttrVal<FBoolean>("Fg_charge", value); }
        }
		public bool? Fg_dispense {
            get { return getAttrVal<FBoolean>("Fg_dispense",null); }
            set { setAttrVal<FBoolean>("Fg_dispense", value); }
        }
		public string Id_backtp {
            get { return getAttrVal<string>("Id_backtp",null); }
            set { setAttrVal<string>("Id_backtp", value); }
        }
		public string Sd_backtp {
            get { return getAttrVal<string>("Sd_backtp",null); }
            set { setAttrVal<string>("Sd_backtp", value); }
        }
		public bool? Fg_back {
            get { return getAttrVal<FBoolean>("Fg_back",null); }
            set { setAttrVal<FBoolean>("Fg_back", value); }
        }
		public string Id_emp {
            get { return getAttrVal<string>("Id_emp",null); }
            set { setAttrVal<string>("Id_emp", value); }
        }
		public bool? Fg_prn {
            get { return getAttrVal<FBoolean>("Fg_prn",null); }
            set { setAttrVal<FBoolean>("Fg_prn", value); }
        }
		public int? Cnt_prn {
            get { return getAttrVal<int?>("Cnt_prn",null); }
            set { setAttrVal<int?>("Cnt_prn", value); }
        }
		public bool? Fg_prn_add {
            get { return getAttrVal<FBoolean>("Fg_prn_add",null); }
            set { setAttrVal<FBoolean>("Fg_prn_add", value); }
        }
		public string Id_pres_rel_add {
            get { return getAttrVal<string>("Id_pres_rel_add",null); }
            set { setAttrVal<string>("Id_pres_rel_add", value); }
        }
		public string Id_su_bl {
            get { return getAttrVal<string>("Id_su_bl",null); }
            set { setAttrVal<string>("Id_su_bl", value); }
        }
		public string Sd_su_bl {
            get { return getAttrVal<string>("Sd_su_bl",null); }
            set { setAttrVal<string>("Sd_su_bl", value); }
        }
		public bool? Fg_makeup {
            get { return getAttrVal<FBoolean>("Fg_makeup",null); }
            set { setAttrVal<FBoolean>("Fg_makeup", value); }
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
		public bool? Fg_hp_pres {
            get { return getAttrVal<FBoolean>("Fg_hp_pres",null); }
            set { setAttrVal<FBoolean>("Fg_hp_pres", value); }
        }
		public string Id_session {
            get { return getAttrVal<string>("Id_session",null); }
            set { setAttrVal<string>("Id_session", value); }
        }
		public string Id_dep_mp {
            get { return getAttrVal<string>("Id_dep_mp",null); }
            set { setAttrVal<string>("Id_dep_mp", value); }
        }
		public string Id_org_create {
            get { return getAttrVal<string>("Id_org_create",null); }
            set { setAttrVal<string>("Id_org_create", value); }
        }
		public bool? Fg_base {
            get { return getAttrVal<FBoolean>("Fg_base",null); }
            set { setAttrVal<FBoolean>("Fg_base", value); }
        }
		public string Id_prestpword {
            get { return getAttrVal<string>("Id_prestpword",null); }
            set { setAttrVal<string>("Id_prestpword", value); }
        }
		public string Sd_prestpword {
            get { return getAttrVal<string>("Sd_prestpword",null); }
            set { setAttrVal<string>("Sd_prestpword", value); }
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
		public string No_drugwin {
            get { return getAttrVal<string>("No_drugwin",null); }
            set { setAttrVal<string>("No_drugwin", value); }
        }
		public bool? Fg_prepay {
            get { return getAttrVal<FBoolean>("Fg_prepay",false); }
            set { setAttrVal<FBoolean>("Fg_prepay", value); }
        }
		public bool? Fg_blsettled {
            get { return getAttrVal<FBoolean>("Fg_blsettled",false); }
            set { setAttrVal<FBoolean>("Fg_blsettled", value); }
        }
		public string Code_pois {
            get { return getAttrVal<string>("Code_pois",null); }
            set { setAttrVal<string>("Code_pois", value); }
        }
		public bool? Fg_hecominsur {
            get { return getAttrVal<FBoolean>("Fg_hecominsur",null); }
            set { setAttrVal<FBoolean>("Fg_hecominsur", value); }
        }
		public string Hecominsurinfo {
            get { return getAttrVal<string>("Hecominsurinfo","N"); }
            set { setAttrVal<string>("Hecominsurinfo", value); }
        }
		public bool? Fg_vip {
            get { return getAttrVal<FBoolean>("Fg_vip",false); }
            set { setAttrVal<FBoolean>("Fg_vip", value); }
        }
		public string Prestp_name {
            get { return getAttrVal<string>("Prestp_name",null); }
            set { setAttrVal<string>("Prestp_name", value); }
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
            return "ci_pres";
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
            return "Id_pres";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.pres.d.CiPresDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_pres", "Id_grp", "Id_org", "Id_pati", "Id_entp", "Code_entp", "Id_en", "Id_di", "Id_diitm", "Str_id_di", "Str_name_di", "Id_srvtp", "Sd_srvtp", "Id_prestp", "Sd_prestp", "Code", "Name", "Id_dep_or", "Id_emp_or", "Dt_entry", "Fg_bb", "No_bb", "Id_bb", "Id_route", "Id_routedes", "Id_boil", "Id_boildes", "Fg_charge", "Fg_dispense", "Id_backtp", "Sd_backtp", "Fg_back", "Id_emp", "Fg_prn", "Cnt_prn", "Fg_prn_add", "Id_pres_rel_add", "Id_su_bl", "Sd_su_bl", "Fg_makeup", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Fg_hp_pres", "Id_session", "Id_dep_mp", "Id_org_create", "Fg_base", "Id_prestpword", "Sd_prestpword", "Def1", "Def2", "Def3", "Def4", "Def5", "Def6", "Def7", "Def8", "Def9", "Def10", "No_drugwin", "Fg_prepay", "Fg_blsettled", "Code_pois", "Fg_hecominsur", "Hecominsurinfo", "Fg_vip", "Prestp_name"};
        }
        
		/// <summary>
        /// 设置IBDataInfo接口映射数据
        /// </summary>
        /// <returns></returns>
		protected override void setBdDataInfoNameMap() {
			if (base.name_path_map == null)
            {
                base.name_path_map = new Dictionary<string, string>();
				base.name_path_map.Add("id","Id_pres");
				base.name_path_map.Add("id_org","Id_org");
				base.name_path_map.Add("code","Code");
				base.name_path_map.Add("name","Name");
				base.name_path_map.Add("id_group","Id_grp");
            }
		}
    }
}
