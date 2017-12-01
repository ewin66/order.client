
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;
using xap.wf.af.vos.i;

namespace iih.ci.mr.cimr.d
{
    /// <summary>
    /// CiMrDO 的摘要说明。
    /// </summary>
    public class CiMrDO : BaseDO,WfFormInfoCtx{

        public CiMrDO() {
        }
		public string Id_mr {
            get { return getAttrVal<string>("Id_mr",null); }
            set { setAttrVal<string>("Id_mr", value); }
        }
		public string Id_grp {
            get { return getAttrVal<string>("Id_grp",null); }
            set { setAttrVal<string>("Id_grp", value); }
        }
		public string Id_org {
            get { return getAttrVal<string>("Id_org",null); }
            set { setAttrVal<string>("Id_org", value); }
        }
		public string Id_ent {
            get { return getAttrVal<string>("Id_ent",null); }
            set { setAttrVal<string>("Id_ent", value); }
        }
		public string Id_pat {
            get { return getAttrVal<string>("Id_pat",null); }
            set { setAttrVal<string>("Id_pat", value); }
        }
		public string Name {
            get { return getAttrVal<string>("Name",null); }
            set { setAttrVal<string>("Name", value); }
        }
		public string Id_mrcactm {
            get { return getAttrVal<string>("Id_mrcactm",null); }
            set { setAttrVal<string>("Id_mrcactm", value); }
        }
		public string Id_mrtp {
            get { return getAttrVal<string>("Id_mrtp",null); }
            set { setAttrVal<string>("Id_mrtp", value); }
        }
		public string Id_su_mr {
            get { return getAttrVal<string>("Id_su_mr",null); }
            set { setAttrVal<string>("Id_su_mr", value); }
        }
		public string Sd_su_mr {
            get { return getAttrVal<string>("Sd_su_mr",null); }
            set { setAttrVal<string>("Sd_su_mr", value); }
        }
		public bool? Fg_complete {
            get { return getAttrVal<FBoolean>("Fg_complete",null); }
            set { setAttrVal<FBoolean>("Fg_complete", value); }
        }
		public string Id_reviewtp {
            get { return getAttrVal<string>("Id_reviewtp",null); }
            set { setAttrVal<string>("Id_reviewtp", value); }
        }
		public string Sd_reviewtp {
            get { return getAttrVal<string>("Sd_reviewtp",null); }
            set { setAttrVal<string>("Sd_reviewtp", value); }
        }
		public string Id_mrtpl {
            get { return getAttrVal<string>("Id_mrtpl",null); }
            set { setAttrVal<string>("Id_mrtpl", value); }
        }
		public string Id_mred {
            get { return getAttrVal<string>("Id_mred",null); }
            set { setAttrVal<string>("Id_mred", value); }
        }
		public string Startparaed {
            get { return getAttrVal<string>("Startparaed",null); }
            set { setAttrVal<string>("Startparaed", value); }
        }
		public string Id_mrtplstmd {
            get { return getAttrVal<string>("Id_mrtplstmd",null); }
            set { setAttrVal<string>("Id_mrtplstmd", value); }
        }
		public string Sd_mrtplstmd {
            get { return getAttrVal<string>("Sd_mrtplstmd",null); }
            set { setAttrVal<string>("Sd_mrtplstmd", value); }
        }
		public string Url_file {
            get { return getAttrVal<string>("Url_file",null); }
            set { setAttrVal<string>("Url_file", value); }
        }
		public string Id_emp_submit {
            get { return getAttrVal<string>("Id_emp_submit",null); }
            set { setAttrVal<string>("Id_emp_submit", value); }
        }
		public DateTime? Date_submit {
            get { return getAttrVal<FDateTime>("Date_submit",null); }
            set { setAttrVal<FDateTime>("Date_submit", value); }
        }
		public string Date_time_show {
            get { return getAttrVal<string>("Date_time_show",null); }
            set { setAttrVal<string>("Date_time_show", value); }
        }
		public string Id_submit_dept {
            get { return getAttrVal<string>("Id_submit_dept",null); }
            set { setAttrVal<string>("Id_submit_dept", value); }
        }
		public string Code_dept_pat {
            get { return getAttrVal<string>("Code_dept_pat",null); }
            set { setAttrVal<string>("Code_dept_pat", value); }
        }
		public string Id_treat_doctor {
            get { return getAttrVal<string>("Id_treat_doctor",null); }
            set { setAttrVal<string>("Id_treat_doctor", value); }
        }
		public string Id_mast_doctor {
            get { return getAttrVal<string>("Id_mast_doctor",null); }
            set { setAttrVal<string>("Id_mast_doctor", value); }
        }
		public DateTime? Mast_doctor_date {
            get { return getAttrVal<FDateTime>("Mast_doctor_date",null); }
            set { setAttrVal<FDateTime>("Mast_doctor_date", value); }
        }
		public string Id_dir_doctor {
            get { return getAttrVal<string>("Id_dir_doctor",null); }
            set { setAttrVal<string>("Id_dir_doctor", value); }
        }
		public DateTime? Dir_doctor_date {
            get { return getAttrVal<FDateTime>("Dir_doctor_date",null); }
            set { setAttrVal<FDateTime>("Dir_doctor_date", value); }
        }
		public string Id_entp {
            get { return getAttrVal<string>("Id_entp",null); }
            set { setAttrVal<string>("Id_entp", value); }
        }
		public string Code_entp {
            get { return getAttrVal<string>("Code_entp",null); }
            set { setAttrVal<string>("Code_entp", value); }
        }
		public bool? Fg_duty_doctor {
            get { return getAttrVal<FBoolean>("Fg_duty_doctor",null); }
            set { setAttrVal<FBoolean>("Fg_duty_doctor", value); }
        }
		public DateTime? Dt_rd {
            get { return getAttrVal<FDateTime>("Dt_rd",null); }
            set { setAttrVal<FDateTime>("Dt_rd", value); }
        }
		public string Id_emp {
            get { return getAttrVal<string>("Id_emp",null); }
            set { setAttrVal<string>("Id_emp", value); }
        }
		public string Id_dep {
            get { return getAttrVal<string>("Id_dep",null); }
            set { setAttrVal<string>("Id_dep", value); }
        }
		public string Id_emp_higher {
            get { return getAttrVal<string>("Id_emp_higher",null); }
            set { setAttrVal<string>("Id_emp_higher", value); }
        }
		public DateTime? Dt_sign {
            get { return getAttrVal<FDateTime>("Dt_sign",null); }
            set { setAttrVal<FDateTime>("Dt_sign", value); }
        }
		public string Id_emp_lat {
            get { return getAttrVal<string>("Id_emp_lat",null); }
            set { setAttrVal<string>("Id_emp_lat", value); }
        }
		public DateTime? Dt_sign_lat {
            get { return getAttrVal<FDateTime>("Dt_sign_lat",null); }
            set { setAttrVal<FDateTime>("Dt_sign_lat", value); }
        }
		public string Id_emp_audit {
            get { return getAttrVal<string>("Id_emp_audit",null); }
            set { setAttrVal<string>("Id_emp_audit", value); }
        }
		public DateTime? Dt_audit_lat {
            get { return getAttrVal<FDateTime>("Dt_audit_lat",null); }
            set { setAttrVal<FDateTime>("Dt_audit_lat", value); }
        }
		public double? Scoreqalat {
            get { return getAttrVal<FDouble>("Scoreqalat",null); }
            set { setAttrVal<FDouble>("Scoreqalat", value); }
        }
		public bool? Fg_edit {
            get { return getAttrVal<FBoolean>("Fg_edit",null); }
            set { setAttrVal<FBoolean>("Fg_edit", value); }
        }
		public bool? Fg_submit {
            get { return getAttrVal<FBoolean>("Fg_submit",null); }
            set { setAttrVal<FBoolean>("Fg_submit", value); }
        }
		public bool? Fg_reject {
            get { return getAttrVal<FBoolean>("Fg_reject",null); }
            set { setAttrVal<FBoolean>("Fg_reject", value); }
        }
		public bool? Fg_seal {
            get { return getAttrVal<FBoolean>("Fg_seal",null); }
            set { setAttrVal<FBoolean>("Fg_seal", value); }
        }
		public bool? Fg_arc {
            get { return getAttrVal<FBoolean>("Fg_arc",null); }
            set { setAttrVal<FBoolean>("Fg_arc", value); }
        }
		public bool? Fg_prn {
            get { return getAttrVal<FBoolean>("Fg_prn",null); }
            set { setAttrVal<FBoolean>("Fg_prn", value); }
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
		public string Task_id {
            get { return getAttrVal<string>("Task_id",null); }
            set { setAttrVal<string>("Task_id", value); }
        }
		public string Id_dep_pat {
            get { return getAttrVal<string>("Id_dep_pat",null); }
            set { setAttrVal<string>("Id_dep_pat", value); }
        }
		public string Id_flowtype {
            get { return getAttrVal<string>("Id_flowtype",null); }
            set { setAttrVal<string>("Id_flowtype", value); }
        }
		public string Id_dep_nuradm {
            get { return getAttrVal<string>("Id_dep_nuradm",null); }
            set { setAttrVal<string>("Id_dep_nuradm", value); }
        }
		public string Id_bed {
            get { return getAttrVal<string>("Id_bed",null); }
            set { setAttrVal<string>("Id_bed", value); }
        }
		public int? Id_sex {
            get { return getAttrVal<int?>("Id_sex",null); }
            set { setAttrVal<int?>("Id_sex", value); }
        }
		public string Pat_age {
            get { return getAttrVal<string>("Pat_age",null); }
            set { setAttrVal<string>("Pat_age", value); }
        }
		public bool? Newtop {
            get { return getAttrVal<FBoolean>("Newtop",null); }
            set { setAttrVal<FBoolean>("Newtop", value); }
        }
		public bool? Newend {
            get { return getAttrVal<FBoolean>("Newend",null); }
            set { setAttrVal<FBoolean>("Newend", value); }
        }
		public string Sign_suggestion {
            get { return getAttrVal<string>("Sign_suggestion",null); }
            set { setAttrVal<string>("Sign_suggestion", value); }
        }
		public bool? Fg_sign {
            get { return getAttrVal<FBoolean>("Fg_sign",null); }
            set { setAttrVal<FBoolean>("Fg_sign", value); }
        }
		public string Grp_code {
            get { return getAttrVal<string>("Grp_code",null); }
            set { setAttrVal<string>("Grp_code", value); }
        }
		public string Grp_name {
            get { return getAttrVal<string>("Grp_name",null); }
            set { setAttrVal<string>("Grp_name", value); }
        }
		public string Org_code {
            get { return getAttrVal<string>("Org_code",null); }
            set { setAttrVal<string>("Org_code", value); }
        }
		public string Org_name {
            get { return getAttrVal<string>("Org_name",null); }
            set { setAttrVal<string>("Org_name", value); }
        }
		public string Pat_code {
            get { return getAttrVal<string>("Pat_code",null); }
            set { setAttrVal<string>("Pat_code", value); }
        }
		public string Pat_name {
            get { return getAttrVal<string>("Pat_name",null); }
            set { setAttrVal<string>("Pat_name", value); }
        }
		public string Mrcactm_code {
            get { return getAttrVal<string>("Mrcactm_code",null); }
            set { setAttrVal<string>("Mrcactm_code", value); }
        }
		public string Mrcactm_name {
            get { return getAttrVal<string>("Mrcactm_name",null); }
            set { setAttrVal<string>("Mrcactm_name", value); }
        }
		public string Mrtp_code {
            get { return getAttrVal<string>("Mrtp_code",null); }
            set { setAttrVal<string>("Mrtp_code", value); }
        }
		public string Mrtp_name {
            get { return getAttrVal<string>("Mrtp_name",null); }
            set { setAttrVal<string>("Mrtp_name", value); }
        }
		public string Su_mr_code {
            get { return getAttrVal<string>("Su_mr_code",null); }
            set { setAttrVal<string>("Su_mr_code", value); }
        }
		public string Su_mr_name {
            get { return getAttrVal<string>("Su_mr_name",null); }
            set { setAttrVal<string>("Su_mr_name", value); }
        }
		public string Reviewtp_code {
            get { return getAttrVal<string>("Reviewtp_code",null); }
            set { setAttrVal<string>("Reviewtp_code", value); }
        }
		public string Reviewtp_name {
            get { return getAttrVal<string>("Reviewtp_name",null); }
            set { setAttrVal<string>("Reviewtp_name", value); }
        }
		public string Id_mr_finish_status {
            get { return getAttrVal<string>("Id_mr_finish_status",null); }
            set { setAttrVal<string>("Id_mr_finish_status", value); }
        }
		public string Mrtpl_code {
            get { return getAttrVal<string>("Mrtpl_code",null); }
            set { setAttrVal<string>("Mrtpl_code", value); }
        }
		public string Mrtpl_name {
            get { return getAttrVal<string>("Mrtpl_name",null); }
            set { setAttrVal<string>("Mrtpl_name", value); }
        }
		public string Mred_code {
            get { return getAttrVal<string>("Mred_code",null); }
            set { setAttrVal<string>("Mred_code", value); }
        }
		public string Mred_name {
            get { return getAttrVal<string>("Mred_name",null); }
            set { setAttrVal<string>("Mred_name", value); }
        }
		public string Mrtplstmd_code {
            get { return getAttrVal<string>("Mrtplstmd_code",null); }
            set { setAttrVal<string>("Mrtplstmd_code", value); }
        }
		public string Mrtplstmd_name {
            get { return getAttrVal<string>("Mrtplstmd_name",null); }
            set { setAttrVal<string>("Mrtplstmd_name", value); }
        }
		public string Emp_submit_name {
            get { return getAttrVal<string>("Emp_submit_name",null); }
            set { setAttrVal<string>("Emp_submit_name", value); }
        }
		public string Emp_submit_code {
            get { return getAttrVal<string>("Emp_submit_code",null); }
            set { setAttrVal<string>("Emp_submit_code", value); }
        }
		public string Submit_dept_code {
            get { return getAttrVal<string>("Submit_dept_code",null); }
            set { setAttrVal<string>("Submit_dept_code", value); }
        }
		public string Submit_dept_name {
            get { return getAttrVal<string>("Submit_dept_name",null); }
            set { setAttrVal<string>("Submit_dept_name", value); }
        }
		public string Treat_name {
            get { return getAttrVal<string>("Treat_name",null); }
            set { setAttrVal<string>("Treat_name", value); }
        }
		public string Treat_code {
            get { return getAttrVal<string>("Treat_code",null); }
            set { setAttrVal<string>("Treat_code", value); }
        }
		public string Mast_name {
            get { return getAttrVal<string>("Mast_name",null); }
            set { setAttrVal<string>("Mast_name", value); }
        }
		public string Mast_code {
            get { return getAttrVal<string>("Mast_code",null); }
            set { setAttrVal<string>("Mast_code", value); }
        }
		public string Dir_name {
            get { return getAttrVal<string>("Dir_name",null); }
            set { setAttrVal<string>("Dir_name", value); }
        }
		public string Dir_code {
            get { return getAttrVal<string>("Dir_code",null); }
            set { setAttrVal<string>("Dir_code", value); }
        }
		public string Entp_code {
            get { return getAttrVal<string>("Entp_code",null); }
            set { setAttrVal<string>("Entp_code", value); }
        }
		public string Entp_name {
            get { return getAttrVal<string>("Entp_name",null); }
            set { setAttrVal<string>("Entp_name", value); }
        }
		public string Emp_name {
            get { return getAttrVal<string>("Emp_name",null); }
            set { setAttrVal<string>("Emp_name", value); }
        }
		public string Emp_code {
            get { return getAttrVal<string>("Emp_code",null); }
            set { setAttrVal<string>("Emp_code", value); }
        }
		public string Dep_code {
            get { return getAttrVal<string>("Dep_code",null); }
            set { setAttrVal<string>("Dep_code", value); }
        }
		public string Dep_name {
            get { return getAttrVal<string>("Dep_name",null); }
            set { setAttrVal<string>("Dep_name", value); }
        }
		public string Emp_higher_name {
            get { return getAttrVal<string>("Emp_higher_name",null); }
            set { setAttrVal<string>("Emp_higher_name", value); }
        }
		public string Emp_higher_code {
            get { return getAttrVal<string>("Emp_higher_code",null); }
            set { setAttrVal<string>("Emp_higher_code", value); }
        }
		public string Emp_lat_name {
            get { return getAttrVal<string>("Emp_lat_name",null); }
            set { setAttrVal<string>("Emp_lat_name", value); }
        }
		public string Emp_lat_code {
            get { return getAttrVal<string>("Emp_lat_code",null); }
            set { setAttrVal<string>("Emp_lat_code", value); }
        }
		public string Emp_audit_name {
            get { return getAttrVal<string>("Emp_audit_name",null); }
            set { setAttrVal<string>("Emp_audit_name", value); }
        }
		public string Emp_audit_code {
            get { return getAttrVal<string>("Emp_audit_code",null); }
            set { setAttrVal<string>("Emp_audit_code", value); }
        }
		public string Createby_name {
            get { return getAttrVal<string>("Createby_name",null); }
            set { setAttrVal<string>("Createby_name", value); }
        }
		public string Createby_code {
            get { return getAttrVal<string>("Createby_code",null); }
            set { setAttrVal<string>("Createby_code", value); }
        }
		public string Modifiedby_name {
            get { return getAttrVal<string>("Modifiedby_name",null); }
            set { setAttrVal<string>("Modifiedby_name", value); }
        }
		public string Modifiedby_code {
            get { return getAttrVal<string>("Modifiedby_code",null); }
            set { setAttrVal<string>("Modifiedby_code", value); }
        }
		public string Dep_pat_code {
            get { return getAttrVal<string>("Dep_pat_code",null); }
            set { setAttrVal<string>("Dep_pat_code", value); }
        }
		public string Dep_pat_name {
            get { return getAttrVal<string>("Dep_pat_name",null); }
            set { setAttrVal<string>("Dep_pat_name", value); }
        }
		public string Flowtype_typecode {
            get { return getAttrVal<string>("Flowtype_typecode",null); }
            set { setAttrVal<string>("Flowtype_typecode", value); }
        }
		public string Flowtype_typename {
            get { return getAttrVal<string>("Flowtype_typename",null); }
            set { setAttrVal<string>("Flowtype_typename", value); }
        }
		public string Deptline_code {
            get { return getAttrVal<string>("Deptline_code",null); }
            set { setAttrVal<string>("Deptline_code", value); }
        }
		public string Deptline_name {
            get { return getAttrVal<string>("Deptline_name",null); }
            set { setAttrVal<string>("Deptline_name", value); }
        }
		public string Bed_code {
            get { return getAttrVal<string>("Bed_code",null); }
            set { setAttrVal<string>("Bed_code", value); }
        }
		public string Bed_name {
            get { return getAttrVal<string>("Bed_name",null); }
            set { setAttrVal<string>("Bed_name", value); }
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
            return "ci_mr";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_mr";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.cimr.d.CiMrDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_mr", "Id_grp", "Id_org", "Id_ent", "Id_pat", "Name", "Id_mrcactm", "Id_mrtp", "Id_su_mr", "Sd_su_mr", "Fg_complete", "Id_reviewtp", "Sd_reviewtp", "Id_mrtpl", "Id_mred", "Startparaed", "Id_mrtplstmd", "Sd_mrtplstmd", "Url_file", "Id_emp_submit", "Date_submit", "Date_time_show", "Id_submit_dept", "Code_dept_pat", "Id_treat_doctor", "Id_mast_doctor", "Mast_doctor_date", "Id_dir_doctor", "Dir_doctor_date", "Id_entp", "Code_entp", "Fg_duty_doctor", "Dt_rd", "Id_emp", "Id_dep", "Id_emp_higher", "Dt_sign", "Id_emp_lat", "Dt_sign_lat", "Id_emp_audit", "Dt_audit_lat", "Scoreqalat", "Fg_edit", "Fg_submit", "Fg_reject", "Fg_seal", "Fg_arc", "Fg_prn", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Task_id", "Id_dep_pat", "Id_flowtype", "Id_dep_nuradm", "Id_bed", "Id_sex", "Pat_age", "Newtop", "Newend", "Sign_suggestion", "Fg_sign", "Grp_code", "Grp_name", "Org_code", "Org_name", "Pat_code", "Pat_name", "Mrcactm_code", "Mrcactm_name", "Mrtp_code", "Mrtp_name", "Su_mr_code", "Su_mr_name", "Reviewtp_code", "Reviewtp_name", "Id_mr_finish_status", "Mrtpl_code", "Mrtpl_name", "Mred_code", "Mred_name", "Mrtplstmd_code", "Mrtplstmd_name", "Emp_submit_name", "Emp_submit_code", "Submit_dept_code", "Submit_dept_name", "Treat_name", "Treat_code", "Mast_name", "Mast_code", "Dir_name", "Dir_code", "Entp_code", "Entp_name", "Emp_name", "Emp_code", "Dep_code", "Dep_name", "Emp_higher_name", "Emp_higher_code", "Emp_lat_name", "Emp_lat_code", "Emp_audit_name", "Emp_audit_code", "Createby_name", "Createby_code", "Modifiedby_name", "Modifiedby_code", "Dep_pat_code", "Dep_pat_name", "Flowtype_typecode", "Flowtype_typename", "Deptline_code", "Deptline_name", "Bed_code", "Bed_name"};
        }
        
		/// <summary>
        /// 设置IBDataInfo接口映射数据
        /// </summary>
        /// <returns></returns>
		protected override void setBdDataInfoNameMap() {
			if (base.name_path_map == null)
            {
                base.name_path_map = new Dictionary<string, string>();
				base.name_path_map.Add("createdby","Createdby");
				base.name_path_map.Add("createdtime","Createdtime");
				base.name_path_map.Add("modifiedby","Modifiedby");
				base.name_path_map.Add("modifiedtime","Modifiedtime");
            }
		}

        public string getBillMakeDateField()
        {
            throw new NotImplementedException();
        }

        public string getBillMakeUserField()
        {
            throw new NotImplementedException();
        }

        public string getBillMakeNumbField()
        {
            throw new NotImplementedException();
        }

        public string getFrmTaskPkField()
        {
            throw new NotImplementedException();
        }

        public string getBillMakeDeptField()
        {
            throw new NotImplementedException();
        }

        public string getFrmAuditUserField()
        {
            throw new NotImplementedException();
        }

        public string getFrmAuditDateField()
        {
            throw new NotImplementedException();
        }

        public string getFrmStateField()
        {
            throw new NotImplementedException();
        }

        public string getFrmTitileField()
        {
            throw new NotImplementedException();
        }

        public string getFrmInsPk()
        {
            throw new NotImplementedException();
        }

        public object getAttributeValue(string attrbute)
        {
            throw new NotImplementedException();
        }

        public object getAllLevelAttributeValue(string attrbute, string BeanID)
        {
            throw new NotImplementedException();
        }

        public void setAttributeValue(string name, object value)
        {
            throw new NotImplementedException();
        }

        public string[] getAttributeNames()
        {
            throw new NotImplementedException();
        }

        public string getTaskId()
        {
            throw new NotImplementedException();
        }
    }
}
