
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.ord.ciorder.d
{
    /// <summary>
    /// CiOrderDO 的摘要说明。
    /// </summary>
    public class CiOrderDO : BaseDO {

		public const string TABLE_NAME = "ci_order";
		public const string TABLE_ALIAS_NAME = "a0";

        public CiOrderDO() {
            this.Dt_end = DateTime.Parse("3000-01-01 00:00:00");
            this.Fg_or_form = true;
            this.Fg_pres_outp = false;
            this.Fg_uncancelable = false;
            this.Eu_hpindicjudge = 0;
            this.Eu_uncporjudge = 0;
            this.Fg_feertnable = true;
            this.Fg_quickwflow = false;
            this.Fg_vip = false;
            this.Fg_prepay = false;
            this.Fg_orhp = false;
        }
		public string Id_or {
            get { return getAttrVal<string>("Id_or",null); }
            set { setAttrVal<string>("Id_or", value); }
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
		public bool? Fg_set {
            get { return getAttrVal<FBoolean>("Fg_set",null); }
            set { setAttrVal<FBoolean>("Fg_set", value); }
        }
		public string Id_srv_pkg {
            get { return getAttrVal<string>("Id_srv_pkg",null); }
            set { setAttrVal<string>("Id_srv_pkg", value); }
        }
		public bool? Fg_long {
            get { return getAttrVal<FBoolean>("Fg_long",null); }
            set { setAttrVal<FBoolean>("Fg_long", value); }
        }
		public string Code_or {
            get { return getAttrVal<string>("Code_or",null); }
            set { setAttrVal<string>("Code_or", value); }
        }
		public string Content_or {
            get { return getAttrVal<string>("Content_or",null); }
            set { setAttrVal<string>("Content_or", value); }
        }
		public string Des_or {
            get { return getAttrVal<string>("Des_or",null); }
            set { setAttrVal<string>("Des_or", value); }
        }
		public string Id_freq {
            get { return getAttrVal<string>("Id_freq",null); }
            set { setAttrVal<string>("Id_freq", value); }
        }
		public int? Orders {
            get { return getAttrVal<int?>("Orders",null); }
            set { setAttrVal<int?>("Orders", value); }
        }
		public bool? Fg_boil {
            get { return getAttrVal<FBoolean>("Fg_boil",null); }
            set { setAttrVal<FBoolean>("Fg_boil", value); }
        }
		public int? Orders_boil {
            get { return getAttrVal<int?>("Orders_boil",null); }
            set { setAttrVal<int?>("Orders_boil", value); }
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
		public int? Days_or {
            get { return getAttrVal<int?>("Days_or",null); }
            set { setAttrVal<int?>("Days_or", value); }
        }
		public string Id_su_or {
            get { return getAttrVal<string>("Id_su_or",null); }
            set { setAttrVal<string>("Id_su_or", value); }
        }
		public string Sd_su_or {
            get { return getAttrVal<string>("Sd_su_or",null); }
            set { setAttrVal<string>("Sd_su_or", value); }
        }
		public string Id_su_mp {
            get { return getAttrVal<string>("Id_su_mp",null); }
            set { setAttrVal<string>("Id_su_mp", value); }
        }
		public string Sd_su_mp {
            get { return getAttrVal<string>("Sd_su_mp",null); }
            set { setAttrVal<string>("Sd_su_mp", value); }
        }
		public string Id_su_bl {
            get { return getAttrVal<string>("Id_su_bl",null); }
            set { setAttrVal<string>("Id_su_bl", value); }
        }
		public string Sd_su_bl {
            get { return getAttrVal<string>("Sd_su_bl",null); }
            set { setAttrVal<string>("Sd_su_bl", value); }
        }
		public string Id_org_or {
            get { return getAttrVal<string>("Id_org_or",null); }
            set { setAttrVal<string>("Id_org_or", value); }
        }
		public string Id_dep_or {
            get { return getAttrVal<string>("Id_dep_or",null); }
            set { setAttrVal<string>("Id_dep_or", value); }
        }
		public string Id_wg_or {
            get { return getAttrVal<string>("Id_wg_or",null); }
            set { setAttrVal<string>("Id_wg_or", value); }
        }
		public string Id_emp_or {
            get { return getAttrVal<string>("Id_emp_or",null); }
            set { setAttrVal<string>("Id_emp_or", value); }
        }
		public DateTime? Dt_entry {
            get { return getAttrVal<FDateTime>("Dt_entry",null); }
            set { setAttrVal<FDateTime>("Dt_entry", value); }
        }
		public bool? Fg_sign {
            get { return getAttrVal<FBoolean>("Fg_sign",null); }
            set { setAttrVal<FBoolean>("Fg_sign", value); }
        }
		public string Id_emp_sign {
            get { return getAttrVal<string>("Id_emp_sign",null); }
            set { setAttrVal<string>("Id_emp_sign", value); }
        }
		public string Id_dep_sign {
            get { return getAttrVal<string>("Id_dep_sign",null); }
            set { setAttrVal<string>("Id_dep_sign", value); }
        }
		public DateTime? Dt_sign {
            get { return getAttrVal<FDateTime>("Dt_sign",null); }
            set { setAttrVal<FDateTime>("Dt_sign", value); }
        }
		public DateTime? Dt_effe {
            get { return getAttrVal<FDateTime>("Dt_effe",null); }
            set { setAttrVal<FDateTime>("Dt_effe", value); }
        }
		public DateTime? Dt_end {
            get { return getAttrVal<FDateTime>("Dt_end",DateTime.Parse("3000-01-01 00:00:00")); }
            set { setAttrVal<FDateTime>("Dt_end", value); }
        }
		public DateTime? Dt_invalid {
            get { return getAttrVal<FDateTime>("Dt_invalid",null); }
            set { setAttrVal<FDateTime>("Dt_invalid", value); }
        }
		public bool? Fg_chk {
            get { return getAttrVal<FBoolean>("Fg_chk",null); }
            set { setAttrVal<FBoolean>("Fg_chk", value); }
        }
		public string Id_emp_chk {
            get { return getAttrVal<string>("Id_emp_chk",null); }
            set { setAttrVal<string>("Id_emp_chk", value); }
        }
		public string Id_dep_chk {
            get { return getAttrVal<string>("Id_dep_chk",null); }
            set { setAttrVal<string>("Id_dep_chk", value); }
        }
		public DateTime? Dt_chk {
            get { return getAttrVal<FDateTime>("Dt_chk",null); }
            set { setAttrVal<FDateTime>("Dt_chk", value); }
        }
		public bool? Fg_stop {
            get { return getAttrVal<FBoolean>("Fg_stop",null); }
            set { setAttrVal<FBoolean>("Fg_stop", value); }
        }
		public string Id_emp_stop {
            get { return getAttrVal<string>("Id_emp_stop",null); }
            set { setAttrVal<string>("Id_emp_stop", value); }
        }
		public string Id_dep_stop {
            get { return getAttrVal<string>("Id_dep_stop",null); }
            set { setAttrVal<string>("Id_dep_stop", value); }
        }
		public DateTime? Dt_stop {
            get { return getAttrVal<FDateTime>("Dt_stop",null); }
            set { setAttrVal<FDateTime>("Dt_stop", value); }
        }
		public bool? Fg_chk_stop {
            get { return getAttrVal<FBoolean>("Fg_chk_stop",null); }
            set { setAttrVal<FBoolean>("Fg_chk_stop", value); }
        }
		public string Id_emp_chk_stop {
            get { return getAttrVal<string>("Id_emp_chk_stop",null); }
            set { setAttrVal<string>("Id_emp_chk_stop", value); }
        }
		public string Id_dep_chk_stop {
            get { return getAttrVal<string>("Id_dep_chk_stop",null); }
            set { setAttrVal<string>("Id_dep_chk_stop", value); }
        }
		public DateTime? Dt_chk_stop {
            get { return getAttrVal<FDateTime>("Dt_chk_stop",null); }
            set { setAttrVal<FDateTime>("Dt_chk_stop", value); }
        }
		public bool? Fg_canc {
            get { return getAttrVal<FBoolean>("Fg_canc",null); }
            set { setAttrVal<FBoolean>("Fg_canc", value); }
        }
		public string Id_emp_canc {
            get { return getAttrVal<string>("Id_emp_canc",null); }
            set { setAttrVal<string>("Id_emp_canc", value); }
        }
		public string Id_dep_canc {
            get { return getAttrVal<string>("Id_dep_canc",null); }
            set { setAttrVal<string>("Id_dep_canc", value); }
        }
		public DateTime? Dt_canc {
            get { return getAttrVal<FDateTime>("Dt_canc",null); }
            set { setAttrVal<FDateTime>("Dt_canc", value); }
        }
		public bool? Fg_chk_canc {
            get { return getAttrVal<FBoolean>("Fg_chk_canc",null); }
            set { setAttrVal<FBoolean>("Fg_chk_canc", value); }
        }
		public string Id_emp_chk_canc {
            get { return getAttrVal<string>("Id_emp_chk_canc",null); }
            set { setAttrVal<string>("Id_emp_chk_canc", value); }
        }
		public string Id_dep_chk_canc {
            get { return getAttrVal<string>("Id_dep_chk_canc",null); }
            set { setAttrVal<string>("Id_dep_chk_canc", value); }
        }
		public DateTime? Dt_chk_canc {
            get { return getAttrVal<FDateTime>("Dt_chk_canc",null); }
            set { setAttrVal<FDateTime>("Dt_chk_canc", value); }
        }
		public bool? Fg_pmor {
            get { return getAttrVal<FBoolean>("Fg_pmor",null); }
            set { setAttrVal<FBoolean>("Fg_pmor", value); }
        }
		public string Des_pmor {
            get { return getAttrVal<string>("Des_pmor",null); }
            set { setAttrVal<string>("Des_pmor", value); }
        }
		public bool? Fg_active_pm {
            get { return getAttrVal<FBoolean>("Fg_active_pm",null); }
            set { setAttrVal<FBoolean>("Fg_active_pm", value); }
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
		public bool? Fg_bb {
            get { return getAttrVal<FBoolean>("Fg_bb",null); }
            set { setAttrVal<FBoolean>("Fg_bb", value); }
        }
		public int? No_bb {
            get { return getAttrVal<int?>("No_bb",null); }
            set { setAttrVal<int?>("No_bb", value); }
        }
		public bool? Fg_ctlcp {
            get { return getAttrVal<FBoolean>("Fg_ctlcp",null); }
            set { setAttrVal<FBoolean>("Fg_ctlcp", value); }
        }
		public bool? Fg_mr {
            get { return getAttrVal<FBoolean>("Fg_mr",null); }
            set { setAttrVal<FBoolean>("Fg_mr", value); }
        }
		public bool? Fg_skintest {
            get { return getAttrVal<FBoolean>("Fg_skintest",null); }
            set { setAttrVal<FBoolean>("Fg_skintest", value); }
        }
		public bool? Fg_mp_in {
            get { return getAttrVal<FBoolean>("Fg_mp_in",null); }
            set { setAttrVal<FBoolean>("Fg_mp_in", value); }
        }
		public int? Times_mp_in {
            get { return getAttrVal<int?>("Times_mp_in",null); }
            set { setAttrVal<int?>("Times_mp_in", value); }
        }
		public bool? Fg_mp_bed {
            get { return getAttrVal<FBoolean>("Fg_mp_bed",null); }
            set { setAttrVal<FBoolean>("Fg_mp_bed", value); }
        }
		public string Note_or {
            get { return getAttrVal<string>("Note_or",null); }
            set { setAttrVal<string>("Note_or", value); }
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
		public int? Eu_verify_pharm {
            get { return getAttrVal<int?>("Eu_verify_pharm",null); }
            set { setAttrVal<int?>("Eu_verify_pharm", value); }
        }
		public string Des_verify_pharm {
            get { return getAttrVal<string>("Des_verify_pharm",null); }
            set { setAttrVal<string>("Des_verify_pharm", value); }
        }
		public string Id_ecep_level_pharm {
            get { return getAttrVal<string>("Id_ecep_level_pharm",null); }
            set { setAttrVal<string>("Id_ecep_level_pharm", value); }
        }
		public string Sd_excep_level_pharm {
            get { return getAttrVal<string>("Sd_excep_level_pharm",null); }
            set { setAttrVal<string>("Sd_excep_level_pharm", value); }
        }
		public string Des_verify_sys {
            get { return getAttrVal<string>("Des_verify_sys",null); }
            set { setAttrVal<string>("Des_verify_sys", value); }
        }
		public string Id_ecep_level_sys {
            get { return getAttrVal<string>("Id_ecep_level_sys",null); }
            set { setAttrVal<string>("Id_ecep_level_sys", value); }
        }
		public string Sd_excep_level_sys {
            get { return getAttrVal<string>("Sd_excep_level_sys",null); }
            set { setAttrVal<string>("Sd_excep_level_sys", value); }
        }
		public string Id_emp_verify_pharm {
            get { return getAttrVal<string>("Id_emp_verify_pharm",null); }
            set { setAttrVal<string>("Id_emp_verify_pharm", value); }
        }
		public DateTime? Dt_verify_pharm {
            get { return getAttrVal<FDateTime>("Dt_verify_pharm",null); }
            set { setAttrVal<FDateTime>("Dt_verify_pharm", value); }
        }
		public string Des_bk_pharm {
            get { return getAttrVal<string>("Des_bk_pharm",null); }
            set { setAttrVal<string>("Des_bk_pharm", value); }
        }
		public DateTime? Dt_bk_pharm {
            get { return getAttrVal<FDateTime>("Dt_bk_pharm",null); }
            set { setAttrVal<FDateTime>("Dt_bk_pharm", value); }
        }
		public string Id_emp_bk_pharm {
            get { return getAttrVal<string>("Id_emp_bk_pharm",null); }
            set { setAttrVal<string>("Id_emp_bk_pharm", value); }
        }
		public bool? Fg_pkg {
            get { return getAttrVal<FBoolean>("Fg_pkg",null); }
            set { setAttrVal<FBoolean>("Fg_pkg", value); }
        }
		public string Str_long {
            get { return getAttrVal<string>("Str_long",null); }
            set { setAttrVal<string>("Str_long", value); }
        }
		public string Name_or {
            get { return getAttrVal<string>("Name_or",null); }
            set { setAttrVal<string>("Name_or", value); }
        }
		public int? Quan_firday_mp {
            get { return getAttrVal<int?>("Quan_firday_mp",null); }
            set { setAttrVal<int?>("Quan_firday_mp", value); }
        }
		public bool? Fg_or_form {
            get { return getAttrVal<FBoolean>("Fg_or_form",true); }
            set { setAttrVal<FBoolean>("Fg_or_form", value); }
        }
		public string Id_skintest_skip_reason {
            get { return getAttrVal<string>("Id_skintest_skip_reason",null); }
            set { setAttrVal<string>("Id_skintest_skip_reason", value); }
        }
		public string Sd_skintest_skip_reason {
            get { return getAttrVal<string>("Sd_skintest_skip_reason",null); }
            set { setAttrVal<string>("Sd_skintest_skip_reason", value); }
        }
		public bool? Fg_pres_outp {
            get { return getAttrVal<FBoolean>("Fg_pres_outp",false); }
            set { setAttrVal<FBoolean>("Fg_pres_outp", value); }
        }
		public string Funcclassstr {
            get { return getAttrVal<string>("Funcclassstr",null); }
            set { setAttrVal<string>("Funcclassstr", value); }
        }
		public string Id_srvof {
            get { return getAttrVal<string>("Id_srvof",null); }
            set { setAttrVal<string>("Id_srvof", value); }
        }
		public string Applyno {
            get { return getAttrVal<string>("Applyno",null); }
            set { setAttrVal<string>("Applyno", value); }
        }
		public DateTime? Dt_last_bl {
            get { return getAttrVal<FDateTime>("Dt_last_bl",null); }
            set { setAttrVal<FDateTime>("Dt_last_bl", value); }
        }
		public bool? Fg_urgent {
            get { return getAttrVal<FBoolean>("Fg_urgent",null); }
            set { setAttrVal<FBoolean>("Fg_urgent", value); }
        }
		public string Ord_colligate {
            get { return getAttrVal<string>("Ord_colligate",null); }
            set { setAttrVal<string>("Ord_colligate", value); }
        }
		public FDouble Amount {
            get { return getAttrVal<FDouble>("Amount",null); }
            set { setAttrVal<FDouble>("Amount", value); }
        }
		public string Result {
            get { return getAttrVal<string>("Result",null); }
            set { setAttrVal<string>("Result", value); }
        }
		public string Id_orpltp {
            get { return getAttrVal<string>("Id_orpltp",null); }
            set { setAttrVal<string>("Id_orpltp", value); }
        }
		public string Id_srvca {
            get { return getAttrVal<string>("Id_srvca",null); }
            set { setAttrVal<string>("Id_srvca", value); }
        }
		public int? Times_cur {
            get { return getAttrVal<int?>("Times_cur",null); }
            set { setAttrVal<int?>("Times_cur", value); }
        }
		public string Id_orrsttp {
            get { return getAttrVal<string>("Id_orrsttp",null); }
            set { setAttrVal<string>("Id_orrsttp", value); }
        }
		public string Sd_orrsttp {
            get { return getAttrVal<string>("Sd_orrsttp",null); }
            set { setAttrVal<string>("Sd_orrsttp", value); }
        }
		public string Id_dep_mp {
            get { return getAttrVal<string>("Id_dep_mp",null); }
            set { setAttrVal<string>("Id_dep_mp", value); }
        }
		public DateTime? Dt_last_mp {
            get { return getAttrVal<FDateTime>("Dt_last_mp",null); }
            set { setAttrVal<FDateTime>("Dt_last_mp", value); }
        }
		public string Id_unit_med {
            get { return getAttrVal<string>("Id_unit_med",null); }
            set { setAttrVal<string>("Id_unit_med", value); }
        }
		public FDouble Quan_medu {
            get { return getAttrVal<FDouble>("Quan_medu",null); }
            set { setAttrVal<FDouble>("Quan_medu", value); }
        }
		public string Innercode_srvca {
            get { return getAttrVal<string>("Innercode_srvca",null); }
            set { setAttrVal<string>("Innercode_srvca", value); }
        }
		public bool? Fg_uncancelable {
            get { return getAttrVal<FBoolean>("Fg_uncancelable",false); }
            set { setAttrVal<FBoolean>("Fg_uncancelable", value); }
        }
		public int? Eu_hpindicjudge {
            get { return getAttrVal<int?>("Eu_hpindicjudge",0); }
            set { setAttrVal<int?>("Eu_hpindicjudge", value); }
        }
		public int? Eu_uncpordoctorjudge {
            get { return getAttrVal<int?>("Eu_uncpordoctorjudge",null); }
            set { setAttrVal<int?>("Eu_uncpordoctorjudge", value); }
        }
		public int? Eu_uncporjudge {
            get { return getAttrVal<int?>("Eu_uncporjudge",0); }
            set { setAttrVal<int?>("Eu_uncporjudge", value); }
        }
		public string Reason_uncporuse {
            get { return getAttrVal<string>("Reason_uncporuse",null); }
            set { setAttrVal<string>("Reason_uncporuse", value); }
        }
		public string Purpose_or {
            get { return getAttrVal<string>("Purpose_or",null); }
            set { setAttrVal<string>("Purpose_or", value); }
        }
		public bool? Fg_flush2mr {
            get { return getAttrVal<FBoolean>("Fg_flush2mr",null); }
            set { setAttrVal<FBoolean>("Fg_flush2mr", value); }
        }
		public bool? Fg_feertnable {
            get { return getAttrVal<FBoolean>("Fg_feertnable",true); }
            set { setAttrVal<FBoolean>("Fg_feertnable", value); }
        }
		public bool? Fg_quickwflow {
            get { return getAttrVal<FBoolean>("Fg_quickwflow",false); }
            set { setAttrVal<FBoolean>("Fg_quickwflow", value); }
        }
		public string Eu_orsrcmdtp {
            get { return getAttrVal<string>("Eu_orsrcmdtp",null); }
            set { setAttrVal<string>("Eu_orsrcmdtp", value); }
        }
		public string Id_orsrc_main {
            get { return getAttrVal<string>("Id_orsrc_main",null); }
            set { setAttrVal<string>("Id_orsrc_main", value); }
        }
		public string Id_orsrc_sub {
            get { return getAttrVal<string>("Id_orsrc_sub",null); }
            set { setAttrVal<string>("Id_orsrc_sub", value); }
        }
		public string Id_orsrc_subsub {
            get { return getAttrVal<string>("Id_orsrc_subsub",null); }
            set { setAttrVal<string>("Id_orsrc_subsub", value); }
        }
		public string Bhpjudgerst {
            get { return getAttrVal<string>("Bhpjudgerst",null); }
            set { setAttrVal<string>("Bhpjudgerst", value); }
        }
		public string Des_bhpjudgerst {
            get { return getAttrVal<string>("Des_bhpjudgerst",null); }
            set { setAttrVal<string>("Des_bhpjudgerst", value); }
        }
		public bool? Fg_vip {
            get { return getAttrVal<FBoolean>("Fg_vip",false); }
            set { setAttrVal<FBoolean>("Fg_vip", value); }
        }
		public bool? Fg_prepay {
            get { return getAttrVal<FBoolean>("Fg_prepay",false); }
            set { setAttrVal<FBoolean>("Fg_prepay", value); }
        }
		public bool? Fg_orhp {
            get { return getAttrVal<FBoolean>("Fg_orhp",false); }
            set { setAttrVal<FBoolean>("Fg_orhp", value); }
        }
		public int? Eu_feereversetp {
            get { return getAttrVal<int?>("Eu_feereversetp",null); }
            set { setAttrVal<int?>("Eu_feereversetp", value); }
        }
		public string Mdicalinfo {
            get { return getAttrVal<string>("Mdicalinfo",null); }
            set { setAttrVal<string>("Mdicalinfo", value); }
        }
		public string Id_excessive_reason {
            get { return getAttrVal<string>("Id_excessive_reason",null); }
            set { setAttrVal<string>("Id_excessive_reason", value); }
        }
		public string Sd_excessive_reason {
            get { return getAttrVal<string>("Sd_excessive_reason",null); }
            set { setAttrVal<string>("Sd_excessive_reason", value); }
        }
		public string Pat_name {
            get { return getAttrVal<string>("Pat_name",null); }
            set { setAttrVal<string>("Pat_name", value); }
        }
		public string Pat_id_sex {
            get { return getAttrVal<string>("Pat_id_sex",null); }
            set { setAttrVal<string>("Pat_id_sex", value); }
        }
		public DateTime? Pat_dt_birth {
            get { return getAttrVal<FDate>("Pat_dt_birth",null); }
            set { setAttrVal<FDate>("Pat_dt_birth", value); }
        }
		public string Pat_sd_sex {
            get { return getAttrVal<string>("Pat_sd_sex",null); }
            set { setAttrVal<string>("Pat_sd_sex", value); }
        }
		public string Id_dep_ns {
            get { return getAttrVal<string>("Id_dep_ns",null); }
            set { setAttrVal<string>("Id_dep_ns", value); }
        }
		public string Id_wg_ns {
            get { return getAttrVal<string>("Id_wg_ns",null); }
            set { setAttrVal<string>("Id_wg_ns", value); }
        }
		public string Id_dep_nur {
            get { return getAttrVal<string>("Id_dep_nur",null); }
            set { setAttrVal<string>("Id_dep_nur", value); }
        }
		public string Entp_name {
            get { return getAttrVal<string>("Entp_name",null); }
            set { setAttrVal<string>("Entp_name", value); }
        }
		public string Srvtp_name {
            get { return getAttrVal<string>("Srvtp_name",null); }
            set { setAttrVal<string>("Srvtp_name", value); }
        }
		public string Srv_pkg_name {
            get { return getAttrVal<string>("Srv_pkg_name",null); }
            set { setAttrVal<string>("Srv_pkg_name", value); }
        }
		public string Freq_name {
            get { return getAttrVal<string>("Freq_name",null); }
            set { setAttrVal<string>("Freq_name", value); }
        }
		public int? Frequnitct {
            get { return getAttrVal<int?>("Frequnitct",null); }
            set { setAttrVal<int?>("Frequnitct", value); }
        }
		public int? Freqct {
            get { return getAttrVal<int?>("Freqct",null); }
            set { setAttrVal<int?>("Freqct", value); }
        }
		public string Sd_frequnitct {
            get { return getAttrVal<string>("Sd_frequnitct",null); }
            set { setAttrVal<string>("Sd_frequnitct", value); }
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
		public string Su_or_name {
            get { return getAttrVal<string>("Su_or_name",null); }
            set { setAttrVal<string>("Su_or_name", value); }
        }
		public string Sd_su_name {
            get { return getAttrVal<string>("Sd_su_name",null); }
            set { setAttrVal<string>("Sd_su_name", value); }
        }
		public string Org_or_name {
            get { return getAttrVal<string>("Org_or_name",null); }
            set { setAttrVal<string>("Org_or_name", value); }
        }
		public string Dept_or_name {
            get { return getAttrVal<string>("Dept_or_name",null); }
            set { setAttrVal<string>("Dept_or_name", value); }
        }
		public string Wg_or_name {
            get { return getAttrVal<string>("Wg_or_name",null); }
            set { setAttrVal<string>("Wg_or_name", value); }
        }
		public string Emp_phy_name {
            get { return getAttrVal<string>("Emp_phy_name",null); }
            set { setAttrVal<string>("Emp_phy_name", value); }
        }
		public string Emp_sign_name {
            get { return getAttrVal<string>("Emp_sign_name",null); }
            set { setAttrVal<string>("Emp_sign_name", value); }
        }
		public string Dep_sign_name {
            get { return getAttrVal<string>("Dep_sign_name",null); }
            set { setAttrVal<string>("Dep_sign_name", value); }
        }
		public string Emp_chk_name {
            get { return getAttrVal<string>("Emp_chk_name",null); }
            set { setAttrVal<string>("Emp_chk_name", value); }
        }
		public string Dep_nur_name {
            get { return getAttrVal<string>("Dep_nur_name",null); }
            set { setAttrVal<string>("Dep_nur_name", value); }
        }
		public string Emp_stop_name {
            get { return getAttrVal<string>("Emp_stop_name",null); }
            set { setAttrVal<string>("Emp_stop_name", value); }
        }
		public string Dep_stop_name {
            get { return getAttrVal<string>("Dep_stop_name",null); }
            set { setAttrVal<string>("Dep_stop_name", value); }
        }
		public string Emp_chk_stop_name {
            get { return getAttrVal<string>("Emp_chk_stop_name",null); }
            set { setAttrVal<string>("Emp_chk_stop_name", value); }
        }
		public string Emp_canc_name {
            get { return getAttrVal<string>("Emp_canc_name",null); }
            set { setAttrVal<string>("Emp_canc_name", value); }
        }
		public string Dep_canc_name {
            get { return getAttrVal<string>("Dep_canc_name",null); }
            set { setAttrVal<string>("Dep_canc_name", value); }
        }
		public string Emp_chk_canc_name {
            get { return getAttrVal<string>("Emp_chk_canc_name",null); }
            set { setAttrVal<string>("Emp_chk_canc_name", value); }
        }
		public string Dep_chk_canc_name {
            get { return getAttrVal<string>("Dep_chk_canc_name",null); }
            set { setAttrVal<string>("Dep_chk_canc_name", value); }
        }
		public string Reltp_name {
            get { return getAttrVal<string>("Reltp_name",null); }
            set { setAttrVal<string>("Reltp_name", value); }
        }
		public string Or_rel_name {
            get { return getAttrVal<string>("Or_rel_name",null); }
            set { setAttrVal<string>("Or_rel_name", value); }
        }
		public string Name_dep_mp {
            get { return getAttrVal<string>("Name_dep_mp",null); }
            set { setAttrVal<string>("Name_dep_mp", value); }
        }
		public string Name_unit_med {
            get { return getAttrVal<string>("Name_unit_med",null); }
            set { setAttrVal<string>("Name_unit_med", value); }
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
            return "ci_order";
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
            return "Id_or";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.ciorder.d.CiOrderDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_or", "Id_grp", "Id_org", "Id_pat", "Id_en", "Id_entp", "Code_entp", "Id_srvtp", "Sd_srvtp", "Id_srv", "Fg_set", "Id_srv_pkg", "Fg_long", "Code_or", "Content_or", "Des_or", "Id_freq", "Orders", "Fg_boil", "Orders_boil", "Id_route", "Id_routedes", "Id_boil", "Id_boildes", "Days_or", "Id_su_or", "Sd_su_or", "Id_su_mp", "Sd_su_mp", "Id_su_bl", "Sd_su_bl", "Id_org_or", "Id_dep_or", "Id_wg_or", "Id_emp_or", "Dt_entry", "Fg_sign", "Id_emp_sign", "Id_dep_sign", "Dt_sign", "Dt_effe", "Dt_end", "Dt_invalid", "Fg_chk", "Id_emp_chk", "Id_dep_chk", "Dt_chk", "Fg_stop", "Id_emp_stop", "Id_dep_stop", "Dt_stop", "Fg_chk_stop", "Id_emp_chk_stop", "Id_dep_chk_stop", "Dt_chk_stop", "Fg_canc", "Id_emp_canc", "Id_dep_canc", "Dt_canc", "Fg_chk_canc", "Id_emp_chk_canc", "Id_dep_chk_canc", "Dt_chk_canc", "Fg_pmor", "Des_pmor", "Fg_active_pm", "Id_reltp", "Sd_reltp", "Id_or_rel", "Fg_bb", "No_bb", "Fg_ctlcp", "Fg_mr", "Fg_skintest", "Fg_mp_in", "Times_mp_in", "Fg_mp_bed", "Note_or", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Eu_verify_pharm", "Des_verify_pharm", "Id_ecep_level_pharm", "Sd_excep_level_pharm", "Des_verify_sys", "Id_ecep_level_sys", "Sd_excep_level_sys", "Id_emp_verify_pharm", "Dt_verify_pharm", "Des_bk_pharm", "Dt_bk_pharm", "Id_emp_bk_pharm", "Fg_pkg", "Str_long", "Name_or", "Quan_firday_mp", "Fg_or_form", "Id_skintest_skip_reason", "Sd_skintest_skip_reason", "Fg_pres_outp", "Funcclassstr", "Id_srvof", "Applyno", "Dt_last_bl", "Fg_urgent", "Ord_colligate", "Amount", "Result", "Id_orpltp", "Id_srvca", "Times_cur", "Id_orrsttp", "Sd_orrsttp", "Id_dep_mp", "Dt_last_mp", "Id_unit_med", "Quan_medu", "Innercode_srvca", "Fg_uncancelable", "Eu_hpindicjudge", "Eu_uncpordoctorjudge", "Eu_uncporjudge", "Reason_uncporuse", "Purpose_or", "Fg_flush2mr", "Fg_feertnable", "Fg_quickwflow", "Eu_orsrcmdtp", "Id_orsrc_main", "Id_orsrc_sub", "Id_orsrc_subsub", "Bhpjudgerst", "Des_bhpjudgerst", "Fg_vip", "Fg_prepay", "Fg_orhp", "Eu_feereversetp", "Mdicalinfo", "Id_excessive_reason", "Sd_excessive_reason", "Pat_name", "Pat_id_sex", "Pat_dt_birth", "Pat_sd_sex", "Id_dep_ns", "Id_wg_ns", "Id_dep_nur", "Entp_name", "Srvtp_name", "Srv_pkg_name", "Freq_name", "Frequnitct", "Freqct", "Sd_frequnitct", "Route_name", "Routedes_name", "Boil_name", "Boildes_name", "Su_or_name", "Sd_su_name", "Org_or_name", "Dept_or_name", "Wg_or_name", "Emp_phy_name", "Emp_sign_name", "Dep_sign_name", "Emp_chk_name", "Dep_nur_name", "Emp_stop_name", "Dep_stop_name", "Emp_chk_stop_name", "Emp_canc_name", "Dep_canc_name", "Emp_chk_canc_name", "Dep_chk_canc_name", "Reltp_name", "Or_rel_name", "Name_dep_mp", "Name_unit_med"};
        }
        
		/// <summary>
        /// 设置IBDataInfo接口映射数据
        /// </summary>
        /// <returns></returns>
		protected override void setBdDataInfoNameMap() {
			if (base.name_path_map == null)
            {
                base.name_path_map = new Dictionary<string, string>();
				base.name_path_map.Add("id","Id_or");
				base.name_path_map.Add("id_org","Id_org");
				base.name_path_map.Add("code","Code");
				base.name_path_map.Add("name","Name");
				base.name_path_map.Add("id_group","Id_grp");
            }
		}
    }
}
