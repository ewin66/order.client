
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.mrfp.other2mrfp.d
{
    /// <summary>
    /// CiMrFpOtherDO 的摘要说明。
    /// </summary>
    public class CiMrFpOtherDO : BaseDO {

        public CiMrFpOtherDO() {
        }
		public string Id_cimrfpother {
            get { return getAttrVal<string>("Id_cimrfpother",null); }
            set { setAttrVal<string>("Id_cimrfpother", value); }
        }
		public string Id_ent {
            get { return getAttrVal<string>("Id_ent",null); }
            set { setAttrVal<string>("Id_ent", value); }
        }
		public string Id_pat {
            get { return getAttrVal<string>("Id_pat",null); }
            set { setAttrVal<string>("Id_pat", value); }
        }
		public string Id_mrtp {
            get { return getAttrVal<string>("Id_mrtp",null); }
            set { setAttrVal<string>("Id_mrtp", value); }
        }
		public string Id_drug_allergy {
            get { return getAttrVal<string>("Id_drug_allergy",null); }
            set { setAttrVal<string>("Id_drug_allergy", value); }
        }
		public string Name_drug_allergy {
            get { return getAttrVal<string>("Name_drug_allergy",null); }
            set { setAttrVal<string>("Name_drug_allergy", value); }
        }
		public string Allergic_drugs {
            get { return getAttrVal<string>("Allergic_drugs",null); }
            set { setAttrVal<string>("Allergic_drugs", value); }
        }
		public string Id_blood_type {
            get { return getAttrVal<string>("Id_blood_type",null); }
            set { setAttrVal<string>("Id_blood_type", value); }
        }
		public string Name_blood_type {
            get { return getAttrVal<string>("Name_blood_type",null); }
            set { setAttrVal<string>("Name_blood_type", value); }
        }
		public string Id_rh_type {
            get { return getAttrVal<string>("Id_rh_type",null); }
            set { setAttrVal<string>("Id_rh_type", value); }
        }
		public string Name_rh_type {
            get { return getAttrVal<string>("Name_rh_type",null); }
            set { setAttrVal<string>("Name_rh_type", value); }
        }
		public string Dirofdept {
            get { return getAttrVal<string>("Dirofdept",null); }
            set { setAttrVal<string>("Dirofdept", value); }
        }
		public string Name_zr_doc {
            get { return getAttrVal<string>("Name_zr_doc",null); }
            set { setAttrVal<string>("Name_zr_doc", value); }
        }
		public string Name_zz_doc {
            get { return getAttrVal<string>("Name_zz_doc",null); }
            set { setAttrVal<string>("Name_zz_doc", value); }
        }
		public string Name_zy_doc {
            get { return getAttrVal<string>("Name_zy_doc",null); }
            set { setAttrVal<string>("Name_zy_doc", value); }
        }
		public string Name_emp_phy {
            get { return getAttrVal<string>("Name_emp_phy",null); }
            set { setAttrVal<string>("Name_emp_phy", value); }
        }
		public string Name_emp_nur {
            get { return getAttrVal<string>("Name_emp_nur",null); }
            set { setAttrVal<string>("Name_emp_nur", value); }
        }
		public string Name_learn_doc {
            get { return getAttrVal<string>("Name_learn_doc",null); }
            set { setAttrVal<string>("Name_learn_doc", value); }
        }
		public string Name_intern_doc {
            get { return getAttrVal<string>("Name_intern_doc",null); }
            set { setAttrVal<string>("Name_intern_doc", value); }
        }
		public string Name_qcp_doc {
            get { return getAttrVal<string>("Name_qcp_doc",null); }
            set { setAttrVal<string>("Name_qcp_doc", value); }
        }
		public string Name_qcp_nur {
            get { return getAttrVal<string>("Name_qcp_nur",null); }
            set { setAttrVal<string>("Name_qcp_nur", value); }
        }
		public string Name_coder {
            get { return getAttrVal<string>("Name_coder",null); }
            set { setAttrVal<string>("Name_coder", value); }
        }
		public string Id_qom_record {
            get { return getAttrVal<string>("Id_qom_record",null); }
            set { setAttrVal<string>("Id_qom_record", value); }
        }
		public string Name_qom_record {
            get { return getAttrVal<string>("Name_qom_record",null); }
            set { setAttrVal<string>("Name_qom_record", value); }
        }
		public DateTime? Qc_date {
            get { return getAttrVal<FDate>("Qc_date",null); }
            set { setAttrVal<FDate>("Qc_date", value); }
        }
		public string Num_patho {
            get { return getAttrVal<string>("Num_patho",null); }
            set { setAttrVal<string>("Num_patho", value); }
        }
		public string Out_hos_mode {
            get { return getAttrVal<string>("Out_hos_mode",null); }
            set { setAttrVal<string>("Out_hos_mode", value); }
        }
		public string Name_out_hos_mode {
            get { return getAttrVal<string>("Name_out_hos_mode",null); }
            set { setAttrVal<string>("Name_out_hos_mode", value); }
        }
		public string Name_med_in_1 {
            get { return getAttrVal<string>("Name_med_in_1",null); }
            set { setAttrVal<string>("Name_med_in_1", value); }
        }
		public string Name_med_in_2 {
            get { return getAttrVal<string>("Name_med_in_2",null); }
            set { setAttrVal<string>("Name_med_in_2", value); }
        }
		public string Id_aut_dead_pat {
            get { return getAttrVal<string>("Id_aut_dead_pat",null); }
            set { setAttrVal<string>("Id_aut_dead_pat", value); }
        }
		public string Name_aut_dead_pat {
            get { return getAttrVal<string>("Name_aut_dead_pat",null); }
            set { setAttrVal<string>("Name_aut_dead_pat", value); }
        }
		public string Id_is_have_inhos_plan {
            get { return getAttrVal<string>("Id_is_have_inhos_plan",null); }
            set { setAttrVal<string>("Id_is_have_inhos_plan", value); }
        }
		public string Name_is_have_inhos_plan {
            get { return getAttrVal<string>("Name_is_have_inhos_plan",null); }
            set { setAttrVal<string>("Name_is_have_inhos_plan", value); }
        }
		public string Goal_inhos_plan {
            get { return getAttrVal<string>("Goal_inhos_plan",null); }
            set { setAttrVal<string>("Goal_inhos_plan", value); }
        }
		public int? Coma_time_bef_inhos_days {
            get { return getAttrVal<int?>("Coma_time_bef_inhos_days",null); }
            set { setAttrVal<int?>("Coma_time_bef_inhos_days", value); }
        }
		public int? Coma_time_bef_inhos_hours {
            get { return getAttrVal<int?>("Coma_time_bef_inhos_hours",null); }
            set { setAttrVal<int?>("Coma_time_bef_inhos_hours", value); }
        }
		public int? Coma_time_bef_inhos_mins {
            get { return getAttrVal<int?>("Coma_time_bef_inhos_mins",null); }
            set { setAttrVal<int?>("Coma_time_bef_inhos_mins", value); }
        }
		public int? Coma_time_inhos_days {
            get { return getAttrVal<int?>("Coma_time_inhos_days",null); }
            set { setAttrVal<int?>("Coma_time_inhos_days", value); }
        }
		public int? Coma_time_inhos_hours {
            get { return getAttrVal<int?>("Coma_time_inhos_hours",null); }
            set { setAttrVal<int?>("Coma_time_inhos_hours", value); }
        }
		public int? Coma_time_inhos_mins {
            get { return getAttrVal<int?>("Coma_time_inhos_mins",null); }
            set { setAttrVal<int?>("Coma_time_inhos_mins", value); }
        }
		public int? Ventilator_use_time {
            get { return getAttrVal<int?>("Ventilator_use_time",null); }
            set { setAttrVal<int?>("Ventilator_use_time", value); }
        }
		public string Tumor_grade_t {
            get { return getAttrVal<string>("Tumor_grade_t",null); }
            set { setAttrVal<string>("Tumor_grade_t", value); }
        }
		public string Tumor_grade_n {
            get { return getAttrVal<string>("Tumor_grade_n",null); }
            set { setAttrVal<string>("Tumor_grade_n", value); }
        }
		public string Tumor_grade_m {
            get { return getAttrVal<string>("Tumor_grade_m",null); }
            set { setAttrVal<string>("Tumor_grade_m", value); }
        }
		public string Dlb_score_in {
            get { return getAttrVal<string>("Dlb_score_in",null); }
            set { setAttrVal<string>("Dlb_score_in", value); }
        }
		public string Dlb_score_out {
            get { return getAttrVal<string>("Dlb_score_out",null); }
            set { setAttrVal<string>("Dlb_score_out", value); }
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
            return "CI_MR_FP_OTHER";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_cimrfpother";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mrfp.other2mrfp.d.CiMrFpOtherDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_cimrfpother", "Id_ent", "Id_pat", "Id_mrtp", "Id_drug_allergy", "Name_drug_allergy", "Allergic_drugs", "Id_blood_type", "Name_blood_type", "Id_rh_type", "Name_rh_type", "Dirofdept", "Name_zr_doc", "Name_zz_doc", "Name_zy_doc", "Name_emp_phy", "Name_emp_nur", "Name_learn_doc", "Name_intern_doc", "Name_qcp_doc", "Name_qcp_nur", "Name_coder", "Id_qom_record", "Name_qom_record", "Qc_date", "Num_patho", "Out_hos_mode", "Name_out_hos_mode", "Name_med_in_1", "Name_med_in_2", "Id_aut_dead_pat", "Name_aut_dead_pat", "Id_is_have_inhos_plan", "Name_is_have_inhos_plan", "Goal_inhos_plan", "Coma_time_bef_inhos_days", "Coma_time_bef_inhos_hours", "Coma_time_bef_inhos_mins", "Coma_time_inhos_days", "Coma_time_inhos_hours", "Coma_time_inhos_mins", "Ventilator_use_time", "Tumor_grade_t", "Tumor_grade_n", "Tumor_grade_m", "Dlb_score_in", "Dlb_score_out"};
        }
        
    }
}
