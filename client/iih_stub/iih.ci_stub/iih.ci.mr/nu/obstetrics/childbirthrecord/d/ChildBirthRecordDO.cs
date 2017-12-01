
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.mr.nu.obstetrics.childbirthrecord.d
{
    /// <summary>
    /// ChildBirthRecordDO 的摘要说明。
    /// </summary>
    public class ChildBirthRecordDO : BaseDO {

		public const string TABLE_NAME = "ci_mr_nu_childbirth";
		public const string TABLE_ALIAS_NAME = "a0";

        public ChildBirthRecordDO() {
        }
		public string Id_childbirth {
            get { return getAttrVal<string>("Id_childbirth",null); }
            set { setAttrVal<string>("Id_childbirth", value); }
        }
		public string Id_pat {
            get { return getAttrVal<string>("Id_pat",null); }
            set { setAttrVal<string>("Id_pat", value); }
        }
		public string Id_ent {
            get { return getAttrVal<string>("Id_ent",null); }
            set { setAttrVal<string>("Id_ent", value); }
        }
		public string Code_entp {
            get { return getAttrVal<string>("Code_entp",null); }
            set { setAttrVal<string>("Code_entp", value); }
        }
		public string Age {
            get { return getAttrVal<string>("Age",null); }
            set { setAttrVal<string>("Age", value); }
        }
		public string Id_dep_nur {
            get { return getAttrVal<string>("Id_dep_nur",null); }
            set { setAttrVal<string>("Id_dep_nur", value); }
        }
		public string Name_bed {
            get { return getAttrVal<string>("Name_bed",null); }
            set { setAttrVal<string>("Name_bed", value); }
        }
		public DateTime? Dt_zsks {
            get { return getAttrVal<FDateTime>("Dt_zsks",null); }
            set { setAttrVal<FDateTime>("Dt_zsks", value); }
        }
		public DateTime? Dt_tmpl {
            get { return getAttrVal<FDateTime>("Dt_tmpl",null); }
            set { setAttrVal<FDateTime>("Dt_tmpl", value); }
        }
		public DateTime? Dt_gkqk {
            get { return getAttrVal<FDateTime>("Dt_gkqk",null); }
            set { setAttrVal<FDateTime>("Dt_gkqk", value); }
        }
		public DateTime? Dt_first {
            get { return getAttrVal<FDateTime>("Dt_first",null); }
            set { setAttrVal<FDateTime>("Dt_first", value); }
        }
		public string Id_first_cbtp {
            get { return getAttrVal<string>("Id_first_cbtp",null); }
            set { setAttrVal<string>("Id_first_cbtp", value); }
        }
		public string Sd_first_cbtp {
            get { return getAttrVal<string>("Sd_first_cbtp",null); }
            set { setAttrVal<string>("Sd_first_cbtp", value); }
        }
		public string Id_first_protp {
            get { return getAttrVal<string>("Id_first_protp",null); }
            set { setAttrVal<string>("Id_first_protp", value); }
        }
		public string Sd_first_protp {
            get { return getAttrVal<string>("Sd_first_protp",null); }
            set { setAttrVal<string>("Sd_first_protp", value); }
        }
		public DateTime? Dt_second {
            get { return getAttrVal<FDateTime>("Dt_second",null); }
            set { setAttrVal<FDateTime>("Dt_second", value); }
        }
		public string Id_second_cbtp {
            get { return getAttrVal<string>("Id_second_cbtp",null); }
            set { setAttrVal<string>("Id_second_cbtp", value); }
        }
		public string Sd_second_cbtp {
            get { return getAttrVal<string>("Sd_second_cbtp",null); }
            set { setAttrVal<string>("Sd_second_cbtp", value); }
        }
		public string Id_second_protp {
            get { return getAttrVal<string>("Id_second_protp",null); }
            set { setAttrVal<string>("Id_second_protp", value); }
        }
		public string Sd_second_protp {
            get { return getAttrVal<string>("Sd_second_protp",null); }
            set { setAttrVal<string>("Sd_second_protp", value); }
        }
		public DateTime? Dt_placenta_birth {
            get { return getAttrVal<FDateTime>("Dt_placenta_birth",null); }
            set { setAttrVal<FDateTime>("Dt_placenta_birth", value); }
        }
		public string Id_placenta_birthtp {
            get { return getAttrVal<string>("Id_placenta_birthtp",null); }
            set { setAttrVal<string>("Id_placenta_birthtp", value); }
        }
		public string Sd_placenta_birthtp {
            get { return getAttrVal<string>("Sd_placenta_birthtp",null); }
            set { setAttrVal<string>("Sd_placenta_birthtp", value); }
        }
		public string Id_placenta_stripping {
            get { return getAttrVal<string>("Id_placenta_stripping",null); }
            set { setAttrVal<string>("Id_placenta_stripping", value); }
        }
		public string Sd_placenta_stripping {
            get { return getAttrVal<string>("Sd_placenta_stripping",null); }
            set { setAttrVal<string>("Sd_placenta_stripping", value); }
        }
		public FDouble Num_amniotic_fluid {
            get { return getAttrVal<FDouble>("Num_amniotic_fluid",null); }
            set { setAttrVal<FDouble>("Num_amniotic_fluid", value); }
        }
		public string Id_amniotic_fluid_char {
            get { return getAttrVal<string>("Id_amniotic_fluid_char",null); }
            set { setAttrVal<string>("Id_amniotic_fluid_char", value); }
        }
		public string Sd_amniotic_fluid_char {
            get { return getAttrVal<string>("Sd_amniotic_fluid_char",null); }
            set { setAttrVal<string>("Sd_amniotic_fluid_char", value); }
        }
		public int? Num_uterus_height {
            get { return getAttrVal<int?>("Num_uterus_height",null); }
            set { setAttrVal<int?>("Num_uterus_height", value); }
        }
		public string Id_perineum_status {
            get { return getAttrVal<string>("Id_perineum_status",null); }
            set { setAttrVal<string>("Id_perineum_status", value); }
        }
		public string Sd_perineum_status {
            get { return getAttrVal<string>("Sd_perineum_status",null); }
            set { setAttrVal<string>("Sd_perineum_status", value); }
        }
		public string Id_perineum_serious {
            get { return getAttrVal<string>("Id_perineum_serious",null); }
            set { setAttrVal<string>("Id_perineum_serious", value); }
        }
		public string Sd_perineum_serious {
            get { return getAttrVal<string>("Sd_perineum_serious",null); }
            set { setAttrVal<string>("Sd_perineum_serious", value); }
        }
		public int? Eu_vaginal_injury {
            get { return getAttrVal<int?>("Eu_vaginal_injury",null); }
            set { setAttrVal<int?>("Eu_vaginal_injury", value); }
        }
		public int? Eu_cervical_injury {
            get { return getAttrVal<int?>("Eu_cervical_injury",null); }
            set { setAttrVal<int?>("Eu_cervical_injury", value); }
        }
		public string Id_bloodmeasure {
            get { return getAttrVal<string>("Id_bloodmeasure",null); }
            set { setAttrVal<string>("Id_bloodmeasure", value); }
        }
		public string Sd_bloodmeasure {
            get { return getAttrVal<string>("Sd_bloodmeasure",null); }
            set { setAttrVal<string>("Sd_bloodmeasure", value); }
        }
		public int? Num_blood_afterbirth {
            get { return getAttrVal<int?>("Num_blood_afterbirth",null); }
            set { setAttrVal<int?>("Num_blood_afterbirth", value); }
        }
		public int? Num_forthlabor_blood {
            get { return getAttrVal<int?>("Num_forthlabor_blood",null); }
            set { setAttrVal<int?>("Num_forthlabor_blood", value); }
        }
		public string Id_drug_afterbirth {
            get { return getAttrVal<string>("Id_drug_afterbirth",null); }
            set { setAttrVal<string>("Id_drug_afterbirth", value); }
        }
		public string Sd_drug_afterbirth {
            get { return getAttrVal<string>("Sd_drug_afterbirth",null); }
            set { setAttrVal<string>("Sd_drug_afterbirth", value); }
        }
		public string Labor_first {
            get { return getAttrVal<string>("Labor_first",null); }
            set { setAttrVal<string>("Labor_first", value); }
        }
		public string Labor_second {
            get { return getAttrVal<string>("Labor_second",null); }
            set { setAttrVal<string>("Labor_second", value); }
        }
		public string Labor_third {
            get { return getAttrVal<string>("Labor_third",null); }
            set { setAttrVal<string>("Labor_third", value); }
        }
		public string Labor_total {
            get { return getAttrVal<string>("Labor_total",null); }
            set { setAttrVal<string>("Labor_total", value); }
        }
		public string Id_sex_a {
            get { return getAttrVal<string>("Id_sex_a",null); }
            set { setAttrVal<string>("Id_sex_a", value); }
        }
		public string Sd_sex_a {
            get { return getAttrVal<string>("Sd_sex_a",null); }
            set { setAttrVal<string>("Sd_sex_a", value); }
        }
		public int? Weigth_a {
            get { return getAttrVal<int?>("Weigth_a",null); }
            set { setAttrVal<int?>("Weigth_a", value); }
        }
		public int? Height_a {
            get { return getAttrVal<int?>("Height_a",null); }
            set { setAttrVal<int?>("Height_a", value); }
        }
		public string Id_child_birth_a {
            get { return getAttrVal<string>("Id_child_birth_a",null); }
            set { setAttrVal<string>("Id_child_birth_a", value); }
        }
		public string Sd_child_birth_a {
            get { return getAttrVal<string>("Sd_child_birth_a",null); }
            set { setAttrVal<string>("Sd_child_birth_a", value); }
        }
		public string Id_asphyxia_a {
            get { return getAttrVal<string>("Id_asphyxia_a",null); }
            set { setAttrVal<string>("Id_asphyxia_a", value); }
        }
		public string Sd_asphyxia_a {
            get { return getAttrVal<string>("Sd_asphyxia_a",null); }
            set { setAttrVal<string>("Sd_asphyxia_a", value); }
        }
		public int? Num_apgar_one_a {
            get { return getAttrVal<int?>("Num_apgar_one_a",null); }
            set { setAttrVal<int?>("Num_apgar_one_a", value); }
        }
		public int? Num_apgar_five_a {
            get { return getAttrVal<int?>("Num_apgar_five_a",null); }
            set { setAttrVal<int?>("Num_apgar_five_a", value); }
        }
		public int? Num_apgar_ten_a {
            get { return getAttrVal<int?>("Num_apgar_ten_a",null); }
            set { setAttrVal<int?>("Num_apgar_ten_a", value); }
        }
		public int? Eu_skin_a {
            get { return getAttrVal<int?>("Eu_skin_a",null); }
            set { setAttrVal<int?>("Eu_skin_a", value); }
        }
		public int? Eu_breath_a {
            get { return getAttrVal<int?>("Eu_breath_a",null); }
            set { setAttrVal<int?>("Eu_breath_a", value); }
        }
		public int? Eu_heartbeat_a {
            get { return getAttrVal<int?>("Eu_heartbeat_a",null); }
            set { setAttrVal<int?>("Eu_heartbeat_a", value); }
        }
		public int? Eu_muscle_a {
            get { return getAttrVal<int?>("Eu_muscle_a",null); }
            set { setAttrVal<int?>("Eu_muscle_a", value); }
        }
		public int? Eu_reflection_a {
            get { return getAttrVal<int?>("Eu_reflection_a",null); }
            set { setAttrVal<int?>("Eu_reflection_a", value); }
        }
		public string Id_umbilicalcord_part_a {
            get { return getAttrVal<string>("Id_umbilicalcord_part_a",null); }
            set { setAttrVal<string>("Id_umbilicalcord_part_a", value); }
        }
		public string Sd_umbilicalcord_part_a {
            get { return getAttrVal<string>("Sd_umbilicalcord_part_a",null); }
            set { setAttrVal<string>("Sd_umbilicalcord_part_a", value); }
        }
		public int? Num_umbilicalcord_part_a {
            get { return getAttrVal<int?>("Num_umbilicalcord_part_a",null); }
            set { setAttrVal<int?>("Num_umbilicalcord_part_a", value); }
        }
		public string Id_umbilicalcord_ligation_a {
            get { return getAttrVal<string>("Id_umbilicalcord_ligation_a",null); }
            set { setAttrVal<string>("Id_umbilicalcord_ligation_a", value); }
        }
		public string Sd_umbilicalcord_ligation_a {
            get { return getAttrVal<string>("Sd_umbilicalcord_ligation_a",null); }
            set { setAttrVal<string>("Sd_umbilicalcord_ligation_a", value); }
        }
		public string Id_eyes_handle_a {
            get { return getAttrVal<string>("Id_eyes_handle_a",null); }
            set { setAttrVal<string>("Id_eyes_handle_a", value); }
        }
		public string Sd_eyes_handle_a {
            get { return getAttrVal<string>("Sd_eyes_handle_a",null); }
            set { setAttrVal<string>("Sd_eyes_handle_a", value); }
        }
		public int? Length_umbilicalcord_a {
            get { return getAttrVal<int?>("Length_umbilicalcord_a",null); }
            set { setAttrVal<int?>("Length_umbilicalcord_a", value); }
        }
		public string Des_unusual_a {
            get { return getAttrVal<string>("Des_unusual_a",null); }
            set { setAttrVal<string>("Des_unusual_a", value); }
        }
		public string Id_sex_b {
            get { return getAttrVal<string>("Id_sex_b",null); }
            set { setAttrVal<string>("Id_sex_b", value); }
        }
		public string Sd_sex_b {
            get { return getAttrVal<string>("Sd_sex_b",null); }
            set { setAttrVal<string>("Sd_sex_b", value); }
        }
		public FDouble Weigth_b {
            get { return getAttrVal<FDouble>("Weigth_b",null); }
            set { setAttrVal<FDouble>("Weigth_b", value); }
        }
		public FDouble Height_b {
            get { return getAttrVal<FDouble>("Height_b",null); }
            set { setAttrVal<FDouble>("Height_b", value); }
        }
		public string Id_child_birth_b {
            get { return getAttrVal<string>("Id_child_birth_b",null); }
            set { setAttrVal<string>("Id_child_birth_b", value); }
        }
		public string Sd_child_birth_b {
            get { return getAttrVal<string>("Sd_child_birth_b",null); }
            set { setAttrVal<string>("Sd_child_birth_b", value); }
        }
		public string Id_asphyxia_b {
            get { return getAttrVal<string>("Id_asphyxia_b",null); }
            set { setAttrVal<string>("Id_asphyxia_b", value); }
        }
		public string Sd_asphyxia_b {
            get { return getAttrVal<string>("Sd_asphyxia_b",null); }
            set { setAttrVal<string>("Sd_asphyxia_b", value); }
        }
		public int? Num_apgar_one_b {
            get { return getAttrVal<int?>("Num_apgar_one_b",null); }
            set { setAttrVal<int?>("Num_apgar_one_b", value); }
        }
		public int? Num_apgar_five_b {
            get { return getAttrVal<int?>("Num_apgar_five_b",null); }
            set { setAttrVal<int?>("Num_apgar_five_b", value); }
        }
		public int? Num_apgar_ten_b {
            get { return getAttrVal<int?>("Num_apgar_ten_b",null); }
            set { setAttrVal<int?>("Num_apgar_ten_b", value); }
        }
		public int? Eu_skin_b {
            get { return getAttrVal<int?>("Eu_skin_b",null); }
            set { setAttrVal<int?>("Eu_skin_b", value); }
        }
		public int? Eu_breath_b {
            get { return getAttrVal<int?>("Eu_breath_b",null); }
            set { setAttrVal<int?>("Eu_breath_b", value); }
        }
		public int? Eu_heartbeat_b {
            get { return getAttrVal<int?>("Eu_heartbeat_b",null); }
            set { setAttrVal<int?>("Eu_heartbeat_b", value); }
        }
		public int? Eu_muscle_b {
            get { return getAttrVal<int?>("Eu_muscle_b",null); }
            set { setAttrVal<int?>("Eu_muscle_b", value); }
        }
		public int? Eu_reflection_b {
            get { return getAttrVal<int?>("Eu_reflection_b",null); }
            set { setAttrVal<int?>("Eu_reflection_b", value); }
        }
		public string Id_umbilicalcord_part_b {
            get { return getAttrVal<string>("Id_umbilicalcord_part_b",null); }
            set { setAttrVal<string>("Id_umbilicalcord_part_b", value); }
        }
		public string Sd_umbilicalcord_part_b {
            get { return getAttrVal<string>("Sd_umbilicalcord_part_b",null); }
            set { setAttrVal<string>("Sd_umbilicalcord_part_b", value); }
        }
		public int? Num_umbilicalcord_part_b {
            get { return getAttrVal<int?>("Num_umbilicalcord_part_b",null); }
            set { setAttrVal<int?>("Num_umbilicalcord_part_b", value); }
        }
		public string Id_umbilicalcord_ligation_b {
            get { return getAttrVal<string>("Id_umbilicalcord_ligation_b",null); }
            set { setAttrVal<string>("Id_umbilicalcord_ligation_b", value); }
        }
		public string Sd_umbilicalcord_ligation_b {
            get { return getAttrVal<string>("Sd_umbilicalcord_ligation_b",null); }
            set { setAttrVal<string>("Sd_umbilicalcord_ligation_b", value); }
        }
		public string Id_eyes_handle_b {
            get { return getAttrVal<string>("Id_eyes_handle_b",null); }
            set { setAttrVal<string>("Id_eyes_handle_b", value); }
        }
		public string Sd_eyes_handle_b {
            get { return getAttrVal<string>("Sd_eyes_handle_b",null); }
            set { setAttrVal<string>("Sd_eyes_handle_b", value); }
        }
		public int? Length_umbilicalcord_b {
            get { return getAttrVal<int?>("Length_umbilicalcord_b",null); }
            set { setAttrVal<int?>("Length_umbilicalcord_b", value); }
        }
		public string Des_unusual_b {
            get { return getAttrVal<string>("Des_unusual_b",null); }
            set { setAttrVal<string>("Des_unusual_b", value); }
        }
		public string Id_placenta_status {
            get { return getAttrVal<string>("Id_placenta_status",null); }
            set { setAttrVal<string>("Id_placenta_status", value); }
        }
		public string Sd_placenta_status {
            get { return getAttrVal<string>("Sd_placenta_status",null); }
            set { setAttrVal<string>("Sd_placenta_status", value); }
        }
		public string Id_membranes_status {
            get { return getAttrVal<string>("Id_membranes_status",null); }
            set { setAttrVal<string>("Id_membranes_status", value); }
        }
		public string Sd_membranes_status {
            get { return getAttrVal<string>("Sd_membranes_status",null); }
            set { setAttrVal<string>("Sd_membranes_status", value); }
        }
		public string Membranes_rupture {
            get { return getAttrVal<string>("Membranes_rupture",null); }
            set { setAttrVal<string>("Membranes_rupture", value); }
        }
		public int? Length_pla {
            get { return getAttrVal<int?>("Length_pla",null); }
            set { setAttrVal<int?>("Length_pla", value); }
        }
		public int? Width_pla {
            get { return getAttrVal<int?>("Width_pla",null); }
            set { setAttrVal<int?>("Width_pla", value); }
        }
		public int? Height_pla {
            get { return getAttrVal<int?>("Height_pla",null); }
            set { setAttrVal<int?>("Height_pla", value); }
        }
		public string Id_perineum_cut {
            get { return getAttrVal<string>("Id_perineum_cut",null); }
            set { setAttrVal<string>("Id_perineum_cut", value); }
        }
		public string Sd_perineum_cut {
            get { return getAttrVal<string>("Sd_perineum_cut",null); }
            set { setAttrVal<string>("Sd_perineum_cut", value); }
        }
		public string Id_childbirth_narcosis_type {
            get { return getAttrVal<string>("Id_childbirth_narcosis_type",null); }
            set { setAttrVal<string>("Id_childbirth_narcosis_type", value); }
        }
		public string Sd_childbirth_narcosis_type {
            get { return getAttrVal<string>("Sd_childbirth_narcosis_type",null); }
            set { setAttrVal<string>("Sd_childbirth_narcosis_type", value); }
        }
		public string Id_childbirth_narcosis_drug {
            get { return getAttrVal<string>("Id_childbirth_narcosis_drug",null); }
            set { setAttrVal<string>("Id_childbirth_narcosis_drug", value); }
        }
		public string Sd_childbirth_narcosis_drug {
            get { return getAttrVal<string>("Sd_childbirth_narcosis_drug",null); }
            set { setAttrVal<string>("Sd_childbirth_narcosis_drug", value); }
        }
		public int? Num_drug_left {
            get { return getAttrVal<int?>("Num_drug_left",null); }
            set { setAttrVal<int?>("Num_drug_left", value); }
        }
		public int? Num_drug_right {
            get { return getAttrVal<int?>("Num_drug_right",null); }
            set { setAttrVal<int?>("Num_drug_right", value); }
        }
		public string Indications {
            get { return getAttrVal<string>("Indications",null); }
            set { setAttrVal<string>("Indications", value); }
        }
		public string Id_suture_type {
            get { return getAttrVal<string>("Id_suture_type",null); }
            set { setAttrVal<string>("Id_suture_type", value); }
        }
		public string Sd_suture_type {
            get { return getAttrVal<string>("Sd_suture_type",null); }
            set { setAttrVal<string>("Sd_suture_type", value); }
        }
		public string Id_childbirth_operation {
            get { return getAttrVal<string>("Id_childbirth_operation",null); }
            set { setAttrVal<string>("Id_childbirth_operation", value); }
        }
		public string Sd_childbirth_operation {
            get { return getAttrVal<string>("Sd_childbirth_operation",null); }
            set { setAttrVal<string>("Sd_childbirth_operation", value); }
        }
		public string Indications_oper {
            get { return getAttrVal<string>("Indications_oper",null); }
            set { setAttrVal<string>("Indications_oper", value); }
        }
		public string Special_case {
            get { return getAttrVal<string>("Special_case",null); }
            set { setAttrVal<string>("Special_case", value); }
        }
		public string Diagnosis {
            get { return getAttrVal<string>("Diagnosis",null); }
            set { setAttrVal<string>("Diagnosis", value); }
        }
		public string Id_emp_delivering {
            get { return getAttrVal<string>("Id_emp_delivering",null); }
            set { setAttrVal<string>("Id_emp_delivering", value); }
        }
		public string Id_dep_suture {
            get { return getAttrVal<string>("Id_dep_suture",null); }
            set { setAttrVal<string>("Id_dep_suture", value); }
        }
		public string Id_dep_assist {
            get { return getAttrVal<string>("Id_dep_assist",null); }
            set { setAttrVal<string>("Id_dep_assist", value); }
        }
		public string Id_dep_counting {
            get { return getAttrVal<string>("Id_dep_counting",null); }
            set { setAttrVal<string>("Id_dep_counting", value); }
        }
		public string Id_dep_record {
            get { return getAttrVal<string>("Id_dep_record",null); }
            set { setAttrVal<string>("Id_dep_record", value); }
        }
		public string Id_group {
            get { return getAttrVal<string>("Id_group",null); }
            set { setAttrVal<string>("Id_group", value); }
        }
		public string Id_org {
            get { return getAttrVal<string>("Id_org",null); }
            set { setAttrVal<string>("Id_org", value); }
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
		public string Code_amr_ip {
            get { return getAttrVal<string>("Code_amr_ip",null); }
            set { setAttrVal<string>("Code_amr_ip", value); }
        }
		public DateTime? Dt_birth_pat {
            get { return getAttrVal<FDate>("Dt_birth_pat",null); }
            set { setAttrVal<FDate>("Dt_birth_pat", value); }
        }
		public string Name_pat {
            get { return getAttrVal<string>("Name_pat",null); }
            set { setAttrVal<string>("Name_pat", value); }
        }
		public string Name_dep {
            get { return getAttrVal<string>("Name_dep",null); }
            set { setAttrVal<string>("Name_dep", value); }
        }
		public string Name_bithtp_a {
            get { return getAttrVal<string>("Name_bithtp_a",null); }
            set { setAttrVal<string>("Name_bithtp_a", value); }
        }
		public string Name_protp_a {
            get { return getAttrVal<string>("Name_protp_a",null); }
            set { setAttrVal<string>("Name_protp_a", value); }
        }
		public string Name_birthtp_b {
            get { return getAttrVal<string>("Name_birthtp_b",null); }
            set { setAttrVal<string>("Name_birthtp_b", value); }
        }
		public string Name_proptp_b {
            get { return getAttrVal<string>("Name_proptp_b",null); }
            set { setAttrVal<string>("Name_proptp_b", value); }
        }
		public string Name_placenta_birthtp {
            get { return getAttrVal<string>("Name_placenta_birthtp",null); }
            set { setAttrVal<string>("Name_placenta_birthtp", value); }
        }
		public string Name_placenta_stripping {
            get { return getAttrVal<string>("Name_placenta_stripping",null); }
            set { setAttrVal<string>("Name_placenta_stripping", value); }
        }
		public string Name_amniotic_fluid_char {
            get { return getAttrVal<string>("Name_amniotic_fluid_char",null); }
            set { setAttrVal<string>("Name_amniotic_fluid_char", value); }
        }
		public string Name_perineum_status {
            get { return getAttrVal<string>("Name_perineum_status",null); }
            set { setAttrVal<string>("Name_perineum_status", value); }
        }
		public string Name_perineum_serious {
            get { return getAttrVal<string>("Name_perineum_serious",null); }
            set { setAttrVal<string>("Name_perineum_serious", value); }
        }
		public string Name_bloodmeasure {
            get { return getAttrVal<string>("Name_bloodmeasure",null); }
            set { setAttrVal<string>("Name_bloodmeasure", value); }
        }
		public string Name_drug_afterbirth {
            get { return getAttrVal<string>("Name_drug_afterbirth",null); }
            set { setAttrVal<string>("Name_drug_afterbirth", value); }
        }
		public string Name_sex_a {
            get { return getAttrVal<string>("Name_sex_a",null); }
            set { setAttrVal<string>("Name_sex_a", value); }
        }
		public string Name_child_birth_a {
            get { return getAttrVal<string>("Name_child_birth_a",null); }
            set { setAttrVal<string>("Name_child_birth_a", value); }
        }
		public string Name_asphyxia_a {
            get { return getAttrVal<string>("Name_asphyxia_a",null); }
            set { setAttrVal<string>("Name_asphyxia_a", value); }
        }
		public string Name_umbilicalcord_part_a {
            get { return getAttrVal<string>("Name_umbilicalcord_part_a",null); }
            set { setAttrVal<string>("Name_umbilicalcord_part_a", value); }
        }
		public string Name_umbilicalcord_ligation_a {
            get { return getAttrVal<string>("Name_umbilicalcord_ligation_a",null); }
            set { setAttrVal<string>("Name_umbilicalcord_ligation_a", value); }
        }
		public string Name_eyes_handle_a {
            get { return getAttrVal<string>("Name_eyes_handle_a",null); }
            set { setAttrVal<string>("Name_eyes_handle_a", value); }
        }
		public string Name_sex_b {
            get { return getAttrVal<string>("Name_sex_b",null); }
            set { setAttrVal<string>("Name_sex_b", value); }
        }
		public string Name_child_birth_b {
            get { return getAttrVal<string>("Name_child_birth_b",null); }
            set { setAttrVal<string>("Name_child_birth_b", value); }
        }
		public string Name_asphyxia_b {
            get { return getAttrVal<string>("Name_asphyxia_b",null); }
            set { setAttrVal<string>("Name_asphyxia_b", value); }
        }
		public string Name_umbilicalcord_part_b {
            get { return getAttrVal<string>("Name_umbilicalcord_part_b",null); }
            set { setAttrVal<string>("Name_umbilicalcord_part_b", value); }
        }
		public string Name_umbilicalcord_ligation_b {
            get { return getAttrVal<string>("Name_umbilicalcord_ligation_b",null); }
            set { setAttrVal<string>("Name_umbilicalcord_ligation_b", value); }
        }
		public string Nam_eyes_handle_b {
            get { return getAttrVal<string>("Nam_eyes_handle_b",null); }
            set { setAttrVal<string>("Nam_eyes_handle_b", value); }
        }
		public string Name_placenta_status {
            get { return getAttrVal<string>("Name_placenta_status",null); }
            set { setAttrVal<string>("Name_placenta_status", value); }
        }
		public string Name_membranes_status {
            get { return getAttrVal<string>("Name_membranes_status",null); }
            set { setAttrVal<string>("Name_membranes_status", value); }
        }
		public string Name_perineum_cut {
            get { return getAttrVal<string>("Name_perineum_cut",null); }
            set { setAttrVal<string>("Name_perineum_cut", value); }
        }
		public string Name_childbirth_narcosis_type {
            get { return getAttrVal<string>("Name_childbirth_narcosis_type",null); }
            set { setAttrVal<string>("Name_childbirth_narcosis_type", value); }
        }
		public string Name_narcosis_drug {
            get { return getAttrVal<string>("Name_narcosis_drug",null); }
            set { setAttrVal<string>("Name_narcosis_drug", value); }
        }
		public string Name_suture_type {
            get { return getAttrVal<string>("Name_suture_type",null); }
            set { setAttrVal<string>("Name_suture_type", value); }
        }
		public string Name_childbirth_operation {
            get { return getAttrVal<string>("Name_childbirth_operation",null); }
            set { setAttrVal<string>("Name_childbirth_operation", value); }
        }
		public string Name_delivering {
            get { return getAttrVal<string>("Name_delivering",null); }
            set { setAttrVal<string>("Name_delivering", value); }
        }
		public string Name_suture {
            get { return getAttrVal<string>("Name_suture",null); }
            set { setAttrVal<string>("Name_suture", value); }
        }
		public string Name_assist {
            get { return getAttrVal<string>("Name_assist",null); }
            set { setAttrVal<string>("Name_assist", value); }
        }
		public string Name_counting {
            get { return getAttrVal<string>("Name_counting",null); }
            set { setAttrVal<string>("Name_counting", value); }
        }
		public string Name_mrrecord {
            get { return getAttrVal<string>("Name_mrrecord",null); }
            set { setAttrVal<string>("Name_mrrecord", value); }
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
            return "ci_mr_nu_childbirth";
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
            return "Id_childbirth";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.nu.obstetrics.childbirthrecord.d.ChildBirthRecordDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_childbirth", "Id_pat", "Id_ent", "Code_entp", "Age", "Id_dep_nur", "Name_bed", "Dt_zsks", "Dt_tmpl", "Dt_gkqk", "Dt_first", "Id_first_cbtp", "Sd_first_cbtp", "Id_first_protp", "Sd_first_protp", "Dt_second", "Id_second_cbtp", "Sd_second_cbtp", "Id_second_protp", "Sd_second_protp", "Dt_placenta_birth", "Id_placenta_birthtp", "Sd_placenta_birthtp", "Id_placenta_stripping", "Sd_placenta_stripping", "Num_amniotic_fluid", "Id_amniotic_fluid_char", "Sd_amniotic_fluid_char", "Num_uterus_height", "Id_perineum_status", "Sd_perineum_status", "Id_perineum_serious", "Sd_perineum_serious", "Eu_vaginal_injury", "Eu_cervical_injury", "Id_bloodmeasure", "Sd_bloodmeasure", "Num_blood_afterbirth", "Num_forthlabor_blood", "Id_drug_afterbirth", "Sd_drug_afterbirth", "Labor_first", "Labor_second", "Labor_third", "Labor_total", "Id_sex_a", "Sd_sex_a", "Weigth_a", "Height_a", "Id_child_birth_a", "Sd_child_birth_a", "Id_asphyxia_a", "Sd_asphyxia_a", "Num_apgar_one_a", "Num_apgar_five_a", "Num_apgar_ten_a", "Eu_skin_a", "Eu_breath_a", "Eu_heartbeat_a", "Eu_muscle_a", "Eu_reflection_a", "Id_umbilicalcord_part_a", "Sd_umbilicalcord_part_a", "Num_umbilicalcord_part_a", "Id_umbilicalcord_ligation_a", "Sd_umbilicalcord_ligation_a", "Id_eyes_handle_a", "Sd_eyes_handle_a", "Length_umbilicalcord_a", "Des_unusual_a", "Id_sex_b", "Sd_sex_b", "Weigth_b", "Height_b", "Id_child_birth_b", "Sd_child_birth_b", "Id_asphyxia_b", "Sd_asphyxia_b", "Num_apgar_one_b", "Num_apgar_five_b", "Num_apgar_ten_b", "Eu_skin_b", "Eu_breath_b", "Eu_heartbeat_b", "Eu_muscle_b", "Eu_reflection_b", "Id_umbilicalcord_part_b", "Sd_umbilicalcord_part_b", "Num_umbilicalcord_part_b", "Id_umbilicalcord_ligation_b", "Sd_umbilicalcord_ligation_b", "Id_eyes_handle_b", "Sd_eyes_handle_b", "Length_umbilicalcord_b", "Des_unusual_b", "Id_placenta_status", "Sd_placenta_status", "Id_membranes_status", "Sd_membranes_status", "Membranes_rupture", "Length_pla", "Width_pla", "Height_pla", "Id_perineum_cut", "Sd_perineum_cut", "Id_childbirth_narcosis_type", "Sd_childbirth_narcosis_type", "Id_childbirth_narcosis_drug", "Sd_childbirth_narcosis_drug", "Num_drug_left", "Num_drug_right", "Indications", "Id_suture_type", "Sd_suture_type", "Id_childbirth_operation", "Sd_childbirth_operation", "Indications_oper", "Special_case", "Diagnosis", "Id_emp_delivering", "Id_dep_suture", "Id_dep_assist", "Id_dep_counting", "Id_dep_record", "Id_group", "Id_org", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Code_amr_ip", "Dt_birth_pat", "Name_pat", "Name_dep", "Name_bithtp_a", "Name_protp_a", "Name_birthtp_b", "Name_proptp_b", "Name_placenta_birthtp", "Name_placenta_stripping", "Name_amniotic_fluid_char", "Name_perineum_status", "Name_perineum_serious", "Name_bloodmeasure", "Name_drug_afterbirth", "Name_sex_a", "Name_child_birth_a", "Name_asphyxia_a", "Name_umbilicalcord_part_a", "Name_umbilicalcord_ligation_a", "Name_eyes_handle_a", "Name_sex_b", "Name_child_birth_b", "Name_asphyxia_b", "Name_umbilicalcord_part_b", "Name_umbilicalcord_ligation_b", "Nam_eyes_handle_b", "Name_placenta_status", "Name_membranes_status", "Name_perineum_cut", "Name_childbirth_narcosis_type", "Name_narcosis_drug", "Name_suture_type", "Name_childbirth_operation", "Name_delivering", "Name_suture", "Name_assist", "Name_counting", "Name_mrrecord"};
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
				base.name_path_map.Add("id_group","Id_group");
            }
		}
    }
}
