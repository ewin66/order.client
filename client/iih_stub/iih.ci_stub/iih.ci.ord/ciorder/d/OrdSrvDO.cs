
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.ord.ciorder.d
{
    /// <summary>
    /// OrdSrvDO 的摘要说明。
    /// </summary>
    public class OrdSrvDO : BaseDO {

		public const string TABLE_NAME = "ci_or_srv";
		public const string TABLE_ALIAS_NAME = "a1";

        public OrdSrvDO() {
            this.Fg_skintest = false;
            this.Id_skintest_skip_reason = "~";
            this.Fg_skintest_rst = false;
            this.Id_primd = "~";
            this.Fg_hpindicjudged = 0;
            this.Eu_hpindicjudge = 0;
            this.Fg_feertnable = true;
            this.Fg_specill = false;
            this.Fg_extdispense = false;
            this.Id_pripat = "~";
        }
		public string Id_orsrv {
            get { return getAttrVal<string>("Id_orsrv",null); }
            set { setAttrVal<string>("Id_orsrv", value); }
        }
		public string Id_or {
            get { return getAttrVal<string>("Id_or",null); }
            set { setAttrVal<string>("Id_or", value); }
        }
		public string Id_org {
            get { return getAttrVal<string>("Id_org",null); }
            set { setAttrVal<string>("Id_org", value); }
        }
		public string Id_grp {
            get { return getAttrVal<string>("Id_grp",null); }
            set { setAttrVal<string>("Id_grp", value); }
        }
		public string Id_pres {
            get { return getAttrVal<string>("Id_pres",null); }
            set { setAttrVal<string>("Id_pres", value); }
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
		public int? Sortno {
            get { return getAttrVal<int?>("Sortno",null); }
            set { setAttrVal<int?>("Sortno", value); }
        }
		public string Id_srvtp {
            get { return getAttrVal<string>("Id_srvtp",null); }
            set { setAttrVal<string>("Id_srvtp", value); }
        }
		public string Sd_srvtp {
            get { return getAttrVal<string>("Sd_srvtp",null); }
            set { setAttrVal<string>("Sd_srvtp", value); }
        }
		public string Id_srv {
            get { return getAttrVal<string>("Id_srv",null); }
            set { setAttrVal<string>("Id_srv", value); }
        }
		public string Name {
            get { return getAttrVal<string>("Name",null); }
            set { setAttrVal<string>("Name", value); }
        }
		public bool? Fg_dose_anoma {
            get { return getAttrVal<FBoolean>("Fg_dose_anoma",null); }
            set { setAttrVal<FBoolean>("Fg_dose_anoma", value); }
        }
		public FDouble Quan_medu {
            get { return getAttrVal<FDouble>("Quan_medu",null); }
            set { setAttrVal<FDouble>("Quan_medu", value); }
        }
		public string Id_medu {
            get { return getAttrVal<string>("Id_medu",null); }
            set { setAttrVal<string>("Id_medu", value); }
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
		public string Id_freq {
            get { return getAttrVal<string>("Id_freq",null); }
            set { setAttrVal<string>("Id_freq", value); }
        }
		public DateTime? Dt_last_bl {
            get { return getAttrVal<FDateTime>("Dt_last_bl",null); }
            set { setAttrVal<FDateTime>("Dt_last_bl", value); }
        }
		public string Id_org_srv {
            get { return getAttrVal<string>("Id_org_srv",null); }
            set { setAttrVal<string>("Id_org_srv", value); }
        }
		public string Id_dep_srv {
            get { return getAttrVal<string>("Id_dep_srv",null); }
            set { setAttrVal<string>("Id_dep_srv", value); }
        }
		public string Id_wg_or {
            get { return getAttrVal<string>("Id_wg_or",null); }
            set { setAttrVal<string>("Id_wg_or", value); }
        }
		public string Id_emp_srv {
            get { return getAttrVal<string>("Id_emp_srv",null); }
            set { setAttrVal<string>("Id_emp_srv", value); }
        }
		public string Id_org_mp {
            get { return getAttrVal<string>("Id_org_mp",null); }
            set { setAttrVal<string>("Id_org_mp", value); }
        }
		public string Id_dep_mp {
            get { return getAttrVal<string>("Id_dep_mp",null); }
            set { setAttrVal<string>("Id_dep_mp", value); }
        }
		public string Sd_su_mp {
            get { return getAttrVal<string>("Sd_su_mp",null); }
            set { setAttrVal<string>("Sd_su_mp", value); }
        }
		public string Sd_su_bl {
            get { return getAttrVal<string>("Sd_su_bl",null); }
            set { setAttrVal<string>("Sd_su_bl", value); }
        }
		public DateTime? Dt_last_mp {
            get { return getAttrVal<FDateTime>("Dt_last_mp",null); }
            set { setAttrVal<FDateTime>("Dt_last_mp", value); }
        }
		public string Id_su_bl {
            get { return getAttrVal<string>("Id_su_bl",null); }
            set { setAttrVal<string>("Id_su_bl", value); }
        }
		public string Id_su_mp {
            get { return getAttrVal<string>("Id_su_mp",null); }
            set { setAttrVal<string>("Id_su_mp", value); }
        }
		public bool? Fg_or {
            get { return getAttrVal<FBoolean>("Fg_or",null); }
            set { setAttrVal<FBoolean>("Fg_or", value); }
        }
		public int? Eu_blmd {
            get { return getAttrVal<int?>("Eu_blmd",null); }
            set { setAttrVal<int?>("Eu_blmd", value); }
        }
		public bool? Fg_mm {
            get { return getAttrVal<FBoolean>("Fg_mm",null); }
            set { setAttrVal<FBoolean>("Fg_mm", value); }
        }
		public FDouble Pri {
            get { return getAttrVal<FDouble>("Pri",null); }
            set { setAttrVal<FDouble>("Pri", value); }
        }
		public bool? Fg_set {
            get { return getAttrVal<FBoolean>("Fg_set",null); }
            set { setAttrVal<FBoolean>("Fg_set", value); }
        }
		public string Note_srv {
            get { return getAttrVal<string>("Note_srv",null); }
            set { setAttrVal<string>("Note_srv", value); }
        }
		public bool? Fg_pres_outp {
            get { return getAttrVal<FBoolean>("Fg_pres_outp",null); }
            set { setAttrVal<FBoolean>("Fg_pres_outp", value); }
        }
		public bool? Fg_indic {
            get { return getAttrVal<FBoolean>("Fg_indic",null); }
            set { setAttrVal<FBoolean>("Fg_indic", value); }
        }
		public bool? Fg_propc {
            get { return getAttrVal<FBoolean>("Fg_propc",null); }
            set { setAttrVal<FBoolean>("Fg_propc", value); }
        }
		public bool? Fg_self {
            get { return getAttrVal<FBoolean>("Fg_self",null); }
            set { setAttrVal<FBoolean>("Fg_self", value); }
        }
		public DateTime? Dt_create {
            get { return getAttrVal<FDateTime>("Dt_create",null); }
            set { setAttrVal<FDateTime>("Dt_create", value); }
        }
		public string Id_srvca {
            get { return getAttrVal<string>("Id_srvca",null); }
            set { setAttrVal<string>("Id_srvca", value); }
        }
		public bool? Fg_bl {
            get { return getAttrVal<FBoolean>("Fg_bl",null); }
            set { setAttrVal<FBoolean>("Fg_bl", value); }
        }
		public string Code_srv {
            get { return getAttrVal<string>("Code_srv",null); }
            set { setAttrVal<string>("Code_srv", value); }
        }
		public string Id_dep_nur_srv {
            get { return getAttrVal<string>("Id_dep_nur_srv",null); }
            set { setAttrVal<string>("Id_dep_nur_srv", value); }
        }
		public int? Eu_sourcemd {
            get { return getAttrVal<int?>("Eu_sourcemd",null); }
            set { setAttrVal<int?>("Eu_sourcemd", value); }
        }
		public string Id_hp {
            get { return getAttrVal<string>("Id_hp",null); }
            set { setAttrVal<string>("Id_hp", value); }
        }
		public string Id_hpsrvtp {
            get { return getAttrVal<string>("Id_hpsrvtp",null); }
            set { setAttrVal<string>("Id_hpsrvtp", value); }
        }
		public string Sd_hpsrvtp {
            get { return getAttrVal<string>("Sd_hpsrvtp",null); }
            set { setAttrVal<string>("Sd_hpsrvtp", value); }
        }
		public bool? Fg_skintest {
            get { return getAttrVal<FBoolean>("Fg_skintest",false); }
            set { setAttrVal<FBoolean>("Fg_skintest", value); }
        }
		public string Sd_skintest_skip_reason {
            get { return getAttrVal<string>("Sd_skintest_skip_reason",null); }
            set { setAttrVal<string>("Sd_skintest_skip_reason", value); }
        }
		public string Id_skintest_skip_reason {
            get { return getAttrVal<string>("Id_skintest_skip_reason","~"); }
            set { setAttrVal<string>("Id_skintest_skip_reason", value); }
        }
		public string Id_reltp {
            get { return getAttrVal<string>("Id_reltp",null); }
            set { setAttrVal<string>("Id_reltp", value); }
        }
		public string Sd_reltp {
            get { return getAttrVal<string>("Sd_reltp",null); }
            set { setAttrVal<string>("Sd_reltp", value); }
        }
		public string Id_or_rel {
            get { return getAttrVal<string>("Id_or_rel",null); }
            set { setAttrVal<string>("Id_or_rel", value); }
        }
		public DateTime? Dt_last_cg {
            get { return getAttrVal<FDateTime>("Dt_last_cg",null); }
            set { setAttrVal<FDateTime>("Dt_last_cg", value); }
        }
		public bool? Fg_skintest_rst {
            get { return getAttrVal<FBoolean>("Fg_skintest_rst",false); }
            set { setAttrVal<FBoolean>("Fg_skintest_rst", value); }
        }
		public bool? Fg_selfsrv {
            get { return getAttrVal<FBoolean>("Fg_selfsrv",null); }
            set { setAttrVal<FBoolean>("Fg_selfsrv", value); }
        }
		public string Id_srv_src {
            get { return getAttrVal<string>("Id_srv_src",null); }
            set { setAttrVal<string>("Id_srv_src", value); }
        }
		public FDouble Quan_total_medu {
            get { return getAttrVal<FDouble>("Quan_total_medu",null); }
            set { setAttrVal<FDouble>("Quan_total_medu", value); }
        }
		public string Id_primd {
            get { return getAttrVal<string>("Id_primd","~"); }
            set { setAttrVal<string>("Id_primd", value); }
        }
		public bool? Fg_selfpay {
            get { return getAttrVal<FBoolean>("Fg_selfpay",null); }
            set { setAttrVal<FBoolean>("Fg_selfpay", value); }
        }
		public string Id_dep_wh {
            get { return getAttrVal<string>("Id_dep_wh",null); }
            set { setAttrVal<string>("Id_dep_wh", value); }
        }
		public string Innercode_srvca {
            get { return getAttrVal<string>("Innercode_srvca",null); }
            set { setAttrVal<string>("Innercode_srvca", value); }
        }
		public bool? Fg_base {
            get { return getAttrVal<FBoolean>("Fg_base",null); }
            set { setAttrVal<FBoolean>("Fg_base", value); }
        }
		public string Priby {
            get { return getAttrVal<string>("Priby",null); }
            set { setAttrVal<string>("Priby", value); }
        }
		public string Des_hplimit {
            get { return getAttrVal<string>("Des_hplimit",null); }
            set { setAttrVal<string>("Des_hplimit", value); }
        }
		public int? Fg_hpindicjudged {
            get { return getAttrVal<int?>("Fg_hpindicjudged",0); }
            set { setAttrVal<int?>("Fg_hpindicjudged", value); }
        }
		public int? Eu_hpindicjudge {
            get { return getAttrVal<int?>("Eu_hpindicjudge",0); }
            set { setAttrVal<int?>("Eu_hpindicjudge", value); }
        }
		public string Eu_hpsrvctrtp {
            get { return getAttrVal<string>("Eu_hpsrvctrtp",null); }
            set { setAttrVal<string>("Eu_hpsrvctrtp", value); }
        }
		public bool? Fg_feertnable {
            get { return getAttrVal<FBoolean>("Fg_feertnable",true); }
            set { setAttrVal<FBoolean>("Fg_feertnable", value); }
        }
		public int? Eu_hpdoctorjudge {
            get { return getAttrVal<int?>("Eu_hpdoctorjudge",null); }
            set { setAttrVal<int?>("Eu_hpdoctorjudge", value); }
        }
		public bool? Fg_specill {
            get { return getAttrVal<FBoolean>("Fg_specill",false); }
            set { setAttrVal<FBoolean>("Fg_specill", value); }
        }
		public bool? Fg_extdispense {
            get { return getAttrVal<FBoolean>("Fg_extdispense",false); }
            set { setAttrVal<FBoolean>("Fg_extdispense", value); }
        }
		public FDouble Pri_std {
            get { return getAttrVal<FDouble>("Pri_std",null); }
            set { setAttrVal<FDouble>("Pri_std", value); }
        }
		public FDouble Pri_ratio {
            get { return getAttrVal<FDouble>("Pri_ratio",null); }
            set { setAttrVal<FDouble>("Pri_ratio", value); }
        }
		public string Id_pripat {
            get { return getAttrVal<string>("Id_pripat","~"); }
            set { setAttrVal<string>("Id_pripat", value); }
        }
		public int? Eu_feereversetp {
            get { return getAttrVal<int?>("Eu_feereversetp",null); }
            set { setAttrVal<int?>("Eu_feereversetp", value); }
        }
		public string Id_mm {
            get { return getAttrVal<string>("Id_mm",null); }
            set { setAttrVal<string>("Id_mm", value); }
        }
		public string Or_name {
            get { return getAttrVal<string>("Or_name",null); }
            set { setAttrVal<string>("Or_name", value); }
        }
		public string Pres_name {
            get { return getAttrVal<string>("Pres_name",null); }
            set { setAttrVal<string>("Pres_name", value); }
        }
		public string Pat_name {
            get { return getAttrVal<string>("Pat_name",null); }
            set { setAttrVal<string>("Pat_name", value); }
        }
		public string Entp_name {
            get { return getAttrVal<string>("Entp_name",null); }
            set { setAttrVal<string>("Entp_name", value); }
        }
		public string Srvtp_name {
            get { return getAttrVal<string>("Srvtp_name",null); }
            set { setAttrVal<string>("Srvtp_name", value); }
        }
		public string Name_srv {
            get { return getAttrVal<string>("Name_srv",null); }
            set { setAttrVal<string>("Name_srv", value); }
        }
		public string Medu_name {
            get { return getAttrVal<string>("Medu_name",null); }
            set { setAttrVal<string>("Medu_name", value); }
        }
		public string Route_name {
            get { return getAttrVal<string>("Route_name",null); }
            set { setAttrVal<string>("Route_name", value); }
        }
		public string Routedes_name {
            get { return getAttrVal<string>("Routedes_name",null); }
            set { setAttrVal<string>("Routedes_name", value); }
        }
		public string Boil_name {
            get { return getAttrVal<string>("Boil_name",null); }
            set { setAttrVal<string>("Boil_name", value); }
        }
		public string Boildes_name {
            get { return getAttrVal<string>("Boildes_name",null); }
            set { setAttrVal<string>("Boildes_name", value); }
        }
		public string Freq_name {
            get { return getAttrVal<string>("Freq_name",null); }
            set { setAttrVal<string>("Freq_name", value); }
        }
		public string Sd_frequnitct {
            get { return getAttrVal<string>("Sd_frequnitct",null); }
            set { setAttrVal<string>("Sd_frequnitct", value); }
        }
		public int? Freqct {
            get { return getAttrVal<int?>("Freqct",null); }
            set { setAttrVal<int?>("Freqct", value); }
        }
		public string Org_name {
            get { return getAttrVal<string>("Org_name",null); }
            set { setAttrVal<string>("Org_name", value); }
        }
		public string Dep_name {
            get { return getAttrVal<string>("Dep_name",null); }
            set { setAttrVal<string>("Dep_name", value); }
        }
		public string Emp_name {
            get { return getAttrVal<string>("Emp_name",null); }
            set { setAttrVal<string>("Emp_name", value); }
        }
		public string Org_mp_name {
            get { return getAttrVal<string>("Org_mp_name",null); }
            set { setAttrVal<string>("Org_mp_name", value); }
        }
		public string Dep_mp_name {
            get { return getAttrVal<string>("Dep_mp_name",null); }
            set { setAttrVal<string>("Dep_mp_name", value); }
        }
		public string Su_bl_name {
            get { return getAttrVal<string>("Su_bl_name",null); }
            set { setAttrVal<string>("Su_bl_name", value); }
        }
		public string Su_name {
            get { return getAttrVal<string>("Su_name",null); }
            set { setAttrVal<string>("Su_name", value); }
        }
		public string Name_hpsrvtp {
            get { return getAttrVal<string>("Name_hpsrvtp",null); }
            set { setAttrVal<string>("Name_hpsrvtp", value); }
        }
		public string Reltp_name {
            get { return getAttrVal<string>("Reltp_name",null); }
            set { setAttrVal<string>("Reltp_name", value); }
        }
		public string Or_rel_name {
            get { return getAttrVal<string>("Or_rel_name",null); }
            set { setAttrVal<string>("Or_rel_name", value); }
        }
        public string Indicitemid {
            get { return getAttrVal<string>("Indicitemid", null); }
            set { setAttrVal<string>("Indicitemid", value); }
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
            return "ci_or_srv";
        }
        
        /// <summary>
        /// 返回表别名
        /// </summary>
        /// <returns></returns>
        public override string getAliasTableName()
        {
            return "a1";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_orsrv";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.ciorder.d.OrdSrvDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_orsrv", "Id_or", "Id_org", "Id_grp", "Id_pres", "Id_pat", "Id_entp", "Code_entp", "Id_en", "Sortno", "Id_srvtp", "Sd_srvtp", "Id_srv", "Name", "Fg_dose_anoma", "Quan_medu", "Id_medu", "Id_route", "Id_routedes", "Id_boil", "Id_boildes", "Id_freq", "Dt_last_bl", "Id_org_srv", "Id_dep_srv", "Id_wg_or", "Id_emp_srv", "Id_org_mp", "Id_dep_mp", "Sd_su_mp", "Sd_su_bl", "Dt_last_mp", "Id_su_bl", "Id_su_mp", "Fg_or", "Eu_blmd", "Fg_mm", "Pri", "Fg_set", "Note_srv", "Fg_pres_outp", "Fg_indic", "Fg_propc", "Fg_self", "Dt_create", "Id_srvca", "Fg_bl", "Code_srv", "Id_dep_nur_srv", "Eu_sourcemd", "Id_hp", "Id_hpsrvtp", "Sd_hpsrvtp", "Fg_skintest", "Sd_skintest_skip_reason", "Id_skintest_skip_reason", "Id_reltp", "Sd_reltp", "Id_or_rel", "Dt_last_cg", "Fg_skintest_rst", "Fg_selfsrv", "Id_srv_src", "Quan_total_medu", "Id_primd", "Fg_selfpay", "Id_dep_wh", "Innercode_srvca", "Fg_base", "Priby", "Des_hplimit", "Fg_hpindicjudged", "Eu_hpindicjudge", "Eu_hpsrvctrtp", "Fg_feertnable", "Eu_hpdoctorjudge", "Fg_specill", "Fg_extdispense", "Pri_std", "Pri_ratio", "Id_pripat", "Eu_feereversetp", "Id_mm", "Or_name", "Pres_name", "Pat_name", "Entp_name", "Srvtp_name", "Name_srv", "Medu_name", "Route_name", "Routedes_name", "Boil_name", "Boildes_name", "Freq_name", "Sd_frequnitct", "Freqct", "Org_name", "Dep_name", "Emp_name", "Org_mp_name", "Dep_mp_name", "Su_bl_name", "Su_name", "Name_hpsrvtp", "Reltp_name", "Or_rel_name", "Indicitemid" };
        }
        
		/// <summary>
        /// 设置IBDataInfo接口映射数据
        /// </summary>
        /// <returns></returns>
		protected override void setBdDataInfoNameMap() {
			if (base.name_path_map == null)
            {
                base.name_path_map = new Dictionary<string, string>();
				base.name_path_map.Add("id_org","Id_org");
				base.name_path_map.Add("id_group","Id_grp");
            }
		}
    }
}
