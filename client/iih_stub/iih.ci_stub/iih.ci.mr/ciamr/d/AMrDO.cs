
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.mr.ciamr.d
{
    /// <summary>
    /// AMrDO 的摘要说明。
    /// </summary>
    public class AMrDO : BaseDO {

		public const string TABLE_NAME = "ci_amr";
		public const string TABLE_ALIAS_NAME = "a0";

        public AMrDO() {
        }
		public string Id_enhr {
            get { return getAttrVal<string>("Id_enhr",null); }
            set { setAttrVal<string>("Id_enhr", value); }
        }
		public string Id_org {
            get { return getAttrVal<string>("Id_org",null); }
            set { setAttrVal<string>("Id_org", value); }
        }
		public string Id_grp {
            get { return getAttrVal<string>("Id_grp",null); }
            set { setAttrVal<string>("Id_grp", value); }
        }
		public string Code_amr_ip {
            get { return getAttrVal<string>("Code_amr_ip",null); }
            set { setAttrVal<string>("Code_amr_ip", value); }
        }
		public string Id_ent {
            get { return getAttrVal<string>("Id_ent",null); }
            set { setAttrVal<string>("Id_ent", value); }
        }
		public string Id_qa_doctor_part_sta {
            get { return getAttrVal<string>("Id_qa_doctor_part_sta",null); }
            set { setAttrVal<string>("Id_qa_doctor_part_sta", value); }
        }
		public string Sd_qa_doctor_part_sta {
            get { return getAttrVal<string>("Sd_qa_doctor_part_sta",null); }
            set { setAttrVal<string>("Sd_qa_doctor_part_sta", value); }
        }
		public string Id_qa_nurse_part_sta {
            get { return getAttrVal<string>("Id_qa_nurse_part_sta",null); }
            set { setAttrVal<string>("Id_qa_nurse_part_sta", value); }
        }
		public string Sd_qa_nurse_part_sta {
            get { return getAttrVal<string>("Sd_qa_nurse_part_sta",null); }
            set { setAttrVal<string>("Sd_qa_nurse_part_sta", value); }
        }
		public string Id_divide_level {
            get { return getAttrVal<string>("Id_divide_level",null); }
            set { setAttrVal<string>("Id_divide_level", value); }
        }
		public FDouble Score_terminal_qa {
            get { return getAttrVal<FDouble>("Score_terminal_qa",null); }
            set { setAttrVal<FDouble>("Score_terminal_qa", value); }
        }
		public string Id_emp_terminal_qa {
            get { return getAttrVal<string>("Id_emp_terminal_qa",null); }
            set { setAttrVal<string>("Id_emp_terminal_qa", value); }
        }
		public DateTime? Dt_terminal_qa {
            get { return getAttrVal<FDateTime>("Dt_terminal_qa",null); }
            set { setAttrVal<FDateTime>("Dt_terminal_qa", value); }
        }
		public string Dept_terminal_qa {
            get { return getAttrVal<string>("Dept_terminal_qa",null); }
            set { setAttrVal<string>("Dept_terminal_qa", value); }
        }
		public bool? Fg_terminal_qa {
            get { return getAttrVal<FBoolean>("Fg_terminal_qa",null); }
            set { setAttrVal<FBoolean>("Fg_terminal_qa", value); }
        }
		public FDouble Score_dept_qa {
            get { return getAttrVal<FDouble>("Score_dept_qa",null); }
            set { setAttrVal<FDouble>("Score_dept_qa", value); }
        }
		public string Id_emp_dept_qa {
            get { return getAttrVal<string>("Id_emp_dept_qa",null); }
            set { setAttrVal<string>("Id_emp_dept_qa", value); }
        }
		public DateTime? Dt_dept_qa {
            get { return getAttrVal<FDateTime>("Dt_dept_qa",null); }
            set { setAttrVal<FDateTime>("Dt_dept_qa", value); }
        }
		public string Dept_dept_qa {
            get { return getAttrVal<string>("Dept_dept_qa",null); }
            set { setAttrVal<string>("Dept_dept_qa", value); }
        }
		public bool? Fg_dept_qa {
            get { return getAttrVal<FBoolean>("Fg_dept_qa",null); }
            set { setAttrVal<FBoolean>("Fg_dept_qa", value); }
        }
		public string Id_emp_process_qa {
            get { return getAttrVal<string>("Id_emp_process_qa",null); }
            set { setAttrVal<string>("Id_emp_process_qa", value); }
        }
		public DateTime? Dt_process_qa {
            get { return getAttrVal<FDateTime>("Dt_process_qa",null); }
            set { setAttrVal<FDateTime>("Dt_process_qa", value); }
        }
		public string Dept_process_qa {
            get { return getAttrVal<string>("Dept_process_qa",null); }
            set { setAttrVal<string>("Dept_process_qa", value); }
        }
		public bool? Fg_process_qa {
            get { return getAttrVal<FBoolean>("Fg_process_qa",null); }
            set { setAttrVal<FBoolean>("Fg_process_qa", value); }
        }
		public bool? Fg_complete {
            get { return getAttrVal<FBoolean>("Fg_complete",null); }
            set { setAttrVal<FBoolean>("Fg_complete", value); }
        }
		public bool? Fg_seal {
            get { return getAttrVal<FBoolean>("Fg_seal",null); }
            set { setAttrVal<FBoolean>("Fg_seal", value); }
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
		public string Id_pat {
            get { return getAttrVal<string>("Id_pat",null); }
            set { setAttrVal<string>("Id_pat", value); }
        }
		public string Pat_name {
            get { return getAttrVal<string>("Pat_name",null); }
            set { setAttrVal<string>("Pat_name", value); }
        }
		public string Inhos_times {
            get { return getAttrVal<string>("Inhos_times",null); }
            set { setAttrVal<string>("Inhos_times", value); }
        }
		public string Id_bed {
            get { return getAttrVal<string>("Id_bed",null); }
            set { setAttrVal<string>("Id_bed", value); }
        }
		public string Id_sex {
            get { return getAttrVal<string>("Id_sex",null); }
            set { setAttrVal<string>("Id_sex", value); }
        }
		public string Sd_sex {
            get { return getAttrVal<string>("Sd_sex",null); }
            set { setAttrVal<string>("Sd_sex", value); }
        }
		public string Pat_age {
            get { return getAttrVal<string>("Pat_age",null); }
            set { setAttrVal<string>("Pat_age", value); }
        }
		public string Code_entp {
            get { return getAttrVal<string>("Code_entp",null); }
            set { setAttrVal<string>("Code_entp", value); }
        }
		public string Id_status {
            get { return getAttrVal<string>("Id_status",null); }
            set { setAttrVal<string>("Id_status", value); }
        }
		public string Id_emp_reg {
            get { return getAttrVal<string>("Id_emp_reg",null); }
            set { setAttrVal<string>("Id_emp_reg", value); }
        }
		public DateTime? Dt_entry {
            get { return getAttrVal<FDateTime>("Dt_entry",null); }
            set { setAttrVal<FDateTime>("Dt_entry", value); }
        }
		public string Id_dep_reg {
            get { return getAttrVal<string>("Id_dep_reg",null); }
            set { setAttrVal<string>("Id_dep_reg", value); }
        }
		public string Id_user_acpt {
            get { return getAttrVal<string>("Id_user_acpt",null); }
            set { setAttrVal<string>("Id_user_acpt", value); }
        }
		public DateTime? Dt_acpt {
            get { return getAttrVal<FDateTime>("Dt_acpt",null); }
            set { setAttrVal<FDateTime>("Dt_acpt", value); }
        }
		public string Id_dep_acpt {
            get { return getAttrVal<string>("Id_dep_acpt",null); }
            set { setAttrVal<string>("Id_dep_acpt", value); }
        }
		public string Id_level_dise {
            get { return getAttrVal<string>("Id_level_dise",null); }
            set { setAttrVal<string>("Id_level_dise", value); }
        }
		public string Id_level_nur {
            get { return getAttrVal<string>("Id_level_nur",null); }
            set { setAttrVal<string>("Id_level_nur", value); }
        }
		public string Id_major_di {
            get { return getAttrVal<string>("Id_major_di",null); }
            set { setAttrVal<string>("Id_major_di", value); }
        }
		public string Id_dep_cur {
            get { return getAttrVal<string>("Id_dep_cur",null); }
            set { setAttrVal<string>("Id_dep_cur", value); }
        }
		public DateTime? Dt_dep_cur {
            get { return getAttrVal<FDateTime>("Dt_dep_cur",null); }
            set { setAttrVal<FDateTime>("Dt_dep_cur", value); }
        }
		public string Id_dep_nuradm {
            get { return getAttrVal<string>("Id_dep_nuradm",null); }
            set { setAttrVal<string>("Id_dep_nuradm", value); }
        }
		public DateTime? Dt_en_dep_nuradm {
            get { return getAttrVal<FDateTime>("Dt_en_dep_nuradm",null); }
            set { setAttrVal<FDateTime>("Dt_en_dep_nuradm", value); }
        }
		public string Id_wkg_phy {
            get { return getAttrVal<string>("Id_wkg_phy",null); }
            set { setAttrVal<string>("Id_wkg_phy", value); }
        }
		public string Id_treat_doctor {
            get { return getAttrVal<string>("Id_treat_doctor",null); }
            set { setAttrVal<string>("Id_treat_doctor", value); }
        }
		public string Id_mast_doctor {
            get { return getAttrVal<string>("Id_mast_doctor",null); }
            set { setAttrVal<string>("Id_mast_doctor", value); }
        }
		public string Id_dir_doctor {
            get { return getAttrVal<string>("Id_dir_doctor",null); }
            set { setAttrVal<string>("Id_dir_doctor", value); }
        }
		public string Id_emp_nur {
            get { return getAttrVal<string>("Id_emp_nur",null); }
            set { setAttrVal<string>("Id_emp_nur", value); }
        }
		public bool? Fg_surg {
            get { return getAttrVal<FBoolean>("Fg_surg",null); }
            set { setAttrVal<FBoolean>("Fg_surg", value); }
        }
		public bool? Fg_death {
            get { return getAttrVal<FBoolean>("Fg_death",null); }
            set { setAttrVal<FBoolean>("Fg_death", value); }
        }
		public bool? Fg_reentry {
            get { return getAttrVal<FBoolean>("Fg_reentry",null); }
            set { setAttrVal<FBoolean>("Fg_reentry", value); }
        }
		public bool? Fg_reclall {
            get { return getAttrVal<FBoolean>("Fg_reclall",null); }
            set { setAttrVal<FBoolean>("Fg_reclall", value); }
        }
		public bool? Fg_flup {
            get { return getAttrVal<FBoolean>("Fg_flup",null); }
            set { setAttrVal<FBoolean>("Fg_flup", value); }
        }
		public string Id_user_end {
            get { return getAttrVal<string>("Id_user_end",null); }
            set { setAttrVal<string>("Id_user_end", value); }
        }
		public DateTime? Dt_end {
            get { return getAttrVal<FDateTime>("Dt_end",null); }
            set { setAttrVal<FDateTime>("Dt_end", value); }
        }
		public string Id_dep_end {
            get { return getAttrVal<string>("Id_dep_end",null); }
            set { setAttrVal<string>("Id_dep_end", value); }
        }
		public string Reason_deptqc_back {
            get { return getAttrVal<string>("Reason_deptqc_back",null); }
            set { setAttrVal<string>("Reason_deptqc_back", value); }
        }
		public string Reason_terminaltqc_back {
            get { return getAttrVal<string>("Reason_terminaltqc_back",null); }
            set { setAttrVal<string>("Reason_terminaltqc_back", value); }
        }
		public bool? Fg_amr_callback {
            get { return getAttrVal<FBoolean>("Fg_amr_callback",null); }
            set { setAttrVal<FBoolean>("Fg_amr_callback", value); }
        }
		public string Reason_amr_back {
            get { return getAttrVal<string>("Reason_amr_back",null); }
            set { setAttrVal<string>("Reason_amr_back", value); }
        }
		public string Id_user_signoff {
            get { return getAttrVal<string>("Id_user_signoff",null); }
            set { setAttrVal<string>("Id_user_signoff", value); }
        }
		public string Id_dep_signoff {
            get { return getAttrVal<string>("Id_dep_signoff",null); }
            set { setAttrVal<string>("Id_dep_signoff", value); }
        }
		public DateTime? Dt_signoff {
            get { return getAttrVal<FDateTime>("Dt_signoff",null); }
            set { setAttrVal<FDateTime>("Dt_signoff", value); }
        }
		public string Id_user_catalogue {
            get { return getAttrVal<string>("Id_user_catalogue",null); }
            set { setAttrVal<string>("Id_user_catalogue", value); }
        }
		public string Id_dep_catalogue {
            get { return getAttrVal<string>("Id_dep_catalogue",null); }
            set { setAttrVal<string>("Id_dep_catalogue", value); }
        }
		public DateTime? Dt_catalogue {
            get { return getAttrVal<FDateTime>("Dt_catalogue",null); }
            set { setAttrVal<FDateTime>("Dt_catalogue", value); }
        }
		public string Id_user_pigeonhole {
            get { return getAttrVal<string>("Id_user_pigeonhole",null); }
            set { setAttrVal<string>("Id_user_pigeonhole", value); }
        }
		public string Id_dep_pigeonhole {
            get { return getAttrVal<string>("Id_dep_pigeonhole",null); }
            set { setAttrVal<string>("Id_dep_pigeonhole", value); }
        }
		public DateTime? Dt_pigeonhole {
            get { return getAttrVal<FDateTime>("Dt_pigeonhole",null); }
            set { setAttrVal<FDateTime>("Dt_pigeonhole", value); }
        }
		public string Org_code {
            get { return getAttrVal<string>("Org_code",null); }
            set { setAttrVal<string>("Org_code", value); }
        }
		public string Org_name {
            get { return getAttrVal<string>("Org_name",null); }
            set { setAttrVal<string>("Org_name", value); }
        }
		public string Grp_code {
            get { return getAttrVal<string>("Grp_code",null); }
            set { setAttrVal<string>("Grp_code", value); }
        }
		public string Grp_name {
            get { return getAttrVal<string>("Grp_name",null); }
            set { setAttrVal<string>("Grp_name", value); }
        }
		public string Doctor_qa_code {
            get { return getAttrVal<string>("Doctor_qa_code",null); }
            set { setAttrVal<string>("Doctor_qa_code", value); }
        }
		public string Doctor_qa_name {
            get { return getAttrVal<string>("Doctor_qa_name",null); }
            set { setAttrVal<string>("Doctor_qa_name", value); }
        }
		public string Qa_nurse_code {
            get { return getAttrVal<string>("Qa_nurse_code",null); }
            set { setAttrVal<string>("Qa_nurse_code", value); }
        }
		public string Qa_nurse_name {
            get { return getAttrVal<string>("Qa_nurse_name",null); }
            set { setAttrVal<string>("Qa_nurse_name", value); }
        }
		public string Emp_term_name {
            get { return getAttrVal<string>("Emp_term_name",null); }
            set { setAttrVal<string>("Emp_term_name", value); }
        }
		public string Emp_term_code {
            get { return getAttrVal<string>("Emp_term_code",null); }
            set { setAttrVal<string>("Emp_term_code", value); }
        }
		public string Dept_term_name {
            get { return getAttrVal<string>("Dept_term_name",null); }
            set { setAttrVal<string>("Dept_term_name", value); }
        }
		public string Dept_term_code {
            get { return getAttrVal<string>("Dept_term_code",null); }
            set { setAttrVal<string>("Dept_term_code", value); }
        }
		public string Emp_dept_qa_code {
            get { return getAttrVal<string>("Emp_dept_qa_code",null); }
            set { setAttrVal<string>("Emp_dept_qa_code", value); }
        }
		public string Emp_dept_qa_name {
            get { return getAttrVal<string>("Emp_dept_qa_name",null); }
            set { setAttrVal<string>("Emp_dept_qa_name", value); }
        }
		public string Dept_dept_qa_code {
            get { return getAttrVal<string>("Dept_dept_qa_code",null); }
            set { setAttrVal<string>("Dept_dept_qa_code", value); }
        }
		public string Dept_dept_qa_name {
            get { return getAttrVal<string>("Dept_dept_qa_name",null); }
            set { setAttrVal<string>("Dept_dept_qa_name", value); }
        }
		public string Process_qa_name {
            get { return getAttrVal<string>("Process_qa_name",null); }
            set { setAttrVal<string>("Process_qa_name", value); }
        }
		public string Process_qa_code {
            get { return getAttrVal<string>("Process_qa_code",null); }
            set { setAttrVal<string>("Process_qa_code", value); }
        }
		public string Dept_process_qa_code {
            get { return getAttrVal<string>("Dept_process_qa_code",null); }
            set { setAttrVal<string>("Dept_process_qa_code", value); }
        }
		public string Dept_process_qa_name {
            get { return getAttrVal<string>("Dept_process_qa_name",null); }
            set { setAttrVal<string>("Dept_process_qa_name", value); }
        }
		public string Createdby_name {
            get { return getAttrVal<string>("Createdby_name",null); }
            set { setAttrVal<string>("Createdby_name", value); }
        }
		public string Createdby_code {
            get { return getAttrVal<string>("Createdby_code",null); }
            set { setAttrVal<string>("Createdby_code", value); }
        }
		public string Modifiedby_name {
            get { return getAttrVal<string>("Modifiedby_name",null); }
            set { setAttrVal<string>("Modifiedby_name", value); }
        }
		public string Modifiedby_code {
            get { return getAttrVal<string>("Modifiedby_code",null); }
            set { setAttrVal<string>("Modifiedby_code", value); }
        }
		public string Bed_code {
            get { return getAttrVal<string>("Bed_code",null); }
            set { setAttrVal<string>("Bed_code", value); }
        }
		public string Bed_name {
            get { return getAttrVal<string>("Bed_name",null); }
            set { setAttrVal<string>("Bed_name", value); }
        }
		public string Status_code {
            get { return getAttrVal<string>("Status_code",null); }
            set { setAttrVal<string>("Status_code", value); }
        }
		public string Status_name {
            get { return getAttrVal<string>("Status_name",null); }
            set { setAttrVal<string>("Status_name", value); }
        }
		public string Emp_reg_name {
            get { return getAttrVal<string>("Emp_reg_name",null); }
            set { setAttrVal<string>("Emp_reg_name", value); }
        }
		public string Emp_reg_code {
            get { return getAttrVal<string>("Emp_reg_code",null); }
            set { setAttrVal<string>("Emp_reg_code", value); }
        }
		public string Dept_reg_code {
            get { return getAttrVal<string>("Dept_reg_code",null); }
            set { setAttrVal<string>("Dept_reg_code", value); }
        }
		public string Dept_reg_name {
            get { return getAttrVal<string>("Dept_reg_name",null); }
            set { setAttrVal<string>("Dept_reg_name", value); }
        }
		public string User_acpt_name {
            get { return getAttrVal<string>("User_acpt_name",null); }
            set { setAttrVal<string>("User_acpt_name", value); }
        }
		public string User_acpt_code {
            get { return getAttrVal<string>("User_acpt_code",null); }
            set { setAttrVal<string>("User_acpt_code", value); }
        }
		public string Dept_acpt_code {
            get { return getAttrVal<string>("Dept_acpt_code",null); }
            set { setAttrVal<string>("Dept_acpt_code", value); }
        }
		public string Dept_acpt_name {
            get { return getAttrVal<string>("Dept_acpt_name",null); }
            set { setAttrVal<string>("Dept_acpt_name", value); }
        }
		public string Level_dise_code {
            get { return getAttrVal<string>("Level_dise_code",null); }
            set { setAttrVal<string>("Level_dise_code", value); }
        }
		public string Level_dise_name {
            get { return getAttrVal<string>("Level_dise_name",null); }
            set { setAttrVal<string>("Level_dise_name", value); }
        }
		public string Level_nur_code {
            get { return getAttrVal<string>("Level_nur_code",null); }
            set { setAttrVal<string>("Level_nur_code", value); }
        }
		public string Level_nur_name {
            get { return getAttrVal<string>("Level_nur_name",null); }
            set { setAttrVal<string>("Level_nur_name", value); }
        }
		public string Dep_nuram_code {
            get { return getAttrVal<string>("Dep_nuram_code",null); }
            set { setAttrVal<string>("Dep_nuram_code", value); }
        }
		public string Dep_nuram_name {
            get { return getAttrVal<string>("Dep_nuram_name",null); }
            set { setAttrVal<string>("Dep_nuram_name", value); }
        }
		public string Wkg_phy_code {
            get { return getAttrVal<string>("Wkg_phy_code",null); }
            set { setAttrVal<string>("Wkg_phy_code", value); }
        }
		public string Wkg_phy_name {
            get { return getAttrVal<string>("Wkg_phy_name",null); }
            set { setAttrVal<string>("Wkg_phy_name", value); }
        }
		public string Treat_doctor_name {
            get { return getAttrVal<string>("Treat_doctor_name",null); }
            set { setAttrVal<string>("Treat_doctor_name", value); }
        }
		public string Treat_doctor_code {
            get { return getAttrVal<string>("Treat_doctor_code",null); }
            set { setAttrVal<string>("Treat_doctor_code", value); }
        }
		public string Mast_doctor_name {
            get { return getAttrVal<string>("Mast_doctor_name",null); }
            set { setAttrVal<string>("Mast_doctor_name", value); }
        }
		public string Mast_doctor_code {
            get { return getAttrVal<string>("Mast_doctor_code",null); }
            set { setAttrVal<string>("Mast_doctor_code", value); }
        }
		public string Dir_doctor_name {
            get { return getAttrVal<string>("Dir_doctor_name",null); }
            set { setAttrVal<string>("Dir_doctor_name", value); }
        }
		public string Dir_doctor_code {
            get { return getAttrVal<string>("Dir_doctor_code",null); }
            set { setAttrVal<string>("Dir_doctor_code", value); }
        }
		public string Emp_nur_name {
            get { return getAttrVal<string>("Emp_nur_name",null); }
            set { setAttrVal<string>("Emp_nur_name", value); }
        }
		public string Emp_nur_code {
            get { return getAttrVal<string>("Emp_nur_code",null); }
            set { setAttrVal<string>("Emp_nur_code", value); }
        }
		public string User_end_name {
            get { return getAttrVal<string>("User_end_name",null); }
            set { setAttrVal<string>("User_end_name", value); }
        }
		public string User_end_code {
            get { return getAttrVal<string>("User_end_code",null); }
            set { setAttrVal<string>("User_end_code", value); }
        }
		public string Dep_end_name {
            get { return getAttrVal<string>("Dep_end_name",null); }
            set { setAttrVal<string>("Dep_end_name", value); }
        }
		public string Dep_end_code {
            get { return getAttrVal<string>("Dep_end_code",null); }
            set { setAttrVal<string>("Dep_end_code", value); }
        }
		public string User_signoff_name {
            get { return getAttrVal<string>("User_signoff_name",null); }
            set { setAttrVal<string>("User_signoff_name", value); }
        }
		public string User_signoff_code {
            get { return getAttrVal<string>("User_signoff_code",null); }
            set { setAttrVal<string>("User_signoff_code", value); }
        }
		public string Dep_signoff_code {
            get { return getAttrVal<string>("Dep_signoff_code",null); }
            set { setAttrVal<string>("Dep_signoff_code", value); }
        }
		public string Dep_signoff_name {
            get { return getAttrVal<string>("Dep_signoff_name",null); }
            set { setAttrVal<string>("Dep_signoff_name", value); }
        }
		public string User_catalogue_name {
            get { return getAttrVal<string>("User_catalogue_name",null); }
            set { setAttrVal<string>("User_catalogue_name", value); }
        }
		public string User_catalogue_code {
            get { return getAttrVal<string>("User_catalogue_code",null); }
            set { setAttrVal<string>("User_catalogue_code", value); }
        }
		public string Dep_catalogue_code {
            get { return getAttrVal<string>("Dep_catalogue_code",null); }
            set { setAttrVal<string>("Dep_catalogue_code", value); }
        }
		public string Dep_catalogue_name {
            get { return getAttrVal<string>("Dep_catalogue_name",null); }
            set { setAttrVal<string>("Dep_catalogue_name", value); }
        }
		public string User_pigeonhole_name {
            get { return getAttrVal<string>("User_pigeonhole_name",null); }
            set { setAttrVal<string>("User_pigeonhole_name", value); }
        }
		public string User_pigeonhole_code {
            get { return getAttrVal<string>("User_pigeonhole_code",null); }
            set { setAttrVal<string>("User_pigeonhole_code", value); }
        }
		public string Dep_pigeonhole_code {
            get { return getAttrVal<string>("Dep_pigeonhole_code",null); }
            set { setAttrVal<string>("Dep_pigeonhole_code", value); }
        }
		public string Dep_pigeonhole_name {
            get { return getAttrVal<string>("Dep_pigeonhole_name",null); }
            set { setAttrVal<string>("Dep_pigeonhole_name", value); }
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
            return "ci_amr";
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
            return "Id_enhr";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.ciamr.d.AMrDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_enhr", "Id_org", "Id_grp", "Code_amr_ip", "Id_ent", "Id_qa_doctor_part_sta", "Sd_qa_doctor_part_sta", "Id_qa_nurse_part_sta", "Sd_qa_nurse_part_sta", "Id_divide_level", "Score_terminal_qa", "Id_emp_terminal_qa", "Dt_terminal_qa", "Dept_terminal_qa", "Fg_terminal_qa", "Score_dept_qa", "Id_emp_dept_qa", "Dt_dept_qa", "Dept_dept_qa", "Fg_dept_qa", "Id_emp_process_qa", "Dt_process_qa", "Dept_process_qa", "Fg_process_qa", "Fg_complete", "Fg_seal", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Id_pat", "Pat_name", "Inhos_times", "Id_bed", "Id_sex", "Sd_sex", "Pat_age", "Code_entp", "Id_status", "Id_emp_reg", "Dt_entry", "Id_dep_reg", "Id_user_acpt", "Dt_acpt", "Id_dep_acpt", "Id_level_dise", "Id_level_nur", "Id_major_di", "Id_dep_cur", "Dt_dep_cur", "Id_dep_nuradm", "Dt_en_dep_nuradm", "Id_wkg_phy", "Id_treat_doctor", "Id_mast_doctor", "Id_dir_doctor", "Id_emp_nur", "Fg_surg", "Fg_death", "Fg_reentry", "Fg_reclall", "Fg_flup", "Id_user_end", "Dt_end", "Id_dep_end", "Reason_deptqc_back", "Reason_terminaltqc_back", "Fg_amr_callback", "Reason_amr_back", "Id_user_signoff", "Id_dep_signoff", "Dt_signoff", "Id_user_catalogue", "Id_dep_catalogue", "Dt_catalogue", "Id_user_pigeonhole", "Id_dep_pigeonhole", "Dt_pigeonhole", "Org_code", "Org_name", "Grp_code", "Grp_name", "Doctor_qa_code", "Doctor_qa_name", "Qa_nurse_code", "Qa_nurse_name", "Emp_term_name", "Emp_term_code", "Dept_term_name", "Dept_term_code", "Emp_dept_qa_code", "Emp_dept_qa_name", "Dept_dept_qa_code", "Dept_dept_qa_name", "Process_qa_name", "Process_qa_code", "Dept_process_qa_code", "Dept_process_qa_name", "Createdby_name", "Createdby_code", "Modifiedby_name", "Modifiedby_code", "Bed_code", "Bed_name", "Status_code", "Status_name", "Emp_reg_name", "Emp_reg_code", "Dept_reg_code", "Dept_reg_name", "User_acpt_name", "User_acpt_code", "Dept_acpt_code", "Dept_acpt_name", "Level_dise_code", "Level_dise_name", "Level_nur_code", "Level_nur_name", "Dep_nuram_code", "Dep_nuram_name", "Wkg_phy_code", "Wkg_phy_name", "Treat_doctor_name", "Treat_doctor_code", "Mast_doctor_name", "Mast_doctor_code", "Dir_doctor_name", "Dir_doctor_code", "Emp_nur_name", "Emp_nur_code", "User_end_name", "User_end_code", "Dep_end_name", "Dep_end_code", "User_signoff_name", "User_signoff_code", "Dep_signoff_code", "Dep_signoff_name", "User_catalogue_name", "User_catalogue_code", "Dep_catalogue_code", "Dep_catalogue_name", "User_pigeonhole_name", "User_pigeonhole_code", "Dep_pigeonhole_code", "Dep_pigeonhole_name"};
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
