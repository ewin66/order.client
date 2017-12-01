
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.mrqc.revisionnotice.d
{
    /// <summary>
    /// RevisionNoticeDO 的摘要说明。
    /// </summary>
    public class RevisionNoticeDO : BaseDO {

        public RevisionNoticeDO() {
        }
		public string Id_revision {
            get { return getAttrVal<string>("Id_revision",null); }
            set { setAttrVal<string>("Id_revision", value); }
        }
		public string Id_grp {
            get { return getAttrVal<string>("Id_grp",null); }
            set { setAttrVal<string>("Id_grp", value); }
        }
		public string Id_org {
            get { return getAttrVal<string>("Id_org",null); }
            set { setAttrVal<string>("Id_org", value); }
        }
		public string Id_status {
            get { return getAttrVal<string>("Id_status",null); }
            set { setAttrVal<string>("Id_status", value); }
        }
		public string Sd_status {
            get { return getAttrVal<string>("Sd_status",null); }
            set { setAttrVal<string>("Sd_status", value); }
        }
		public DateTime? Dt_send {
            get { return getAttrVal<FDateTime>("Dt_send",null); }
            set { setAttrVal<FDateTime>("Dt_send", value); }
        }
		public string Id_exec_doctor {
            get { return getAttrVal<string>("Id_exec_doctor",null); }
            set { setAttrVal<string>("Id_exec_doctor", value); }
        }
		public int? Rfm_deadline {
            get { return getAttrVal<int?>("Rfm_deadline",null); }
            set { setAttrVal<int?>("Rfm_deadline", value); }
        }
		public DateTime? Dt_deadline {
            get { return getAttrVal<FDateTime>("Dt_deadline",null); }
            set { setAttrVal<FDateTime>("Dt_deadline", value); }
        }
		public string Id_exec_dept {
            get { return getAttrVal<string>("Id_exec_dept",null); }
            set { setAttrVal<string>("Id_exec_dept", value); }
        }
		public string Id_ent {
            get { return getAttrVal<string>("Id_ent",null); }
            set { setAttrVal<string>("Id_ent", value); }
        }
		public string Id_rfm_doctor {
            get { return getAttrVal<string>("Id_rfm_doctor",null); }
            set { setAttrVal<string>("Id_rfm_doctor", value); }
        }
		public string Id_rfm_dept {
            get { return getAttrVal<string>("Id_rfm_dept",null); }
            set { setAttrVal<string>("Id_rfm_dept", value); }
        }
		public string Id_qa_ty {
            get { return getAttrVal<string>("Id_qa_ty",null); }
            set { setAttrVal<string>("Id_qa_ty", value); }
        }
		public string Sd_qa_ty {
            get { return getAttrVal<string>("Sd_qa_ty",null); }
            set { setAttrVal<string>("Sd_qa_ty", value); }
        }
		public bool? Fg_cmpl {
            get { return getAttrVal<FBoolean>("Fg_cmpl",null); }
            set { setAttrVal<FBoolean>("Fg_cmpl", value); }
        }
		public DateTime? Rfm_time {
            get { return getAttrVal<FDateTime>("Rfm_time",null); }
            set { setAttrVal<FDateTime>("Rfm_time", value); }
        }
		public DateTime? Vrf_time {
            get { return getAttrVal<FDateTime>("Vrf_time",null); }
            set { setAttrVal<FDateTime>("Vrf_time", value); }
        }
		public string Des {
            get { return getAttrVal<string>("Des",null); }
            set { setAttrVal<string>("Des", value); }
        }
		public string Id_vrf_user {
            get { return getAttrVal<string>("Id_vrf_user",null); }
            set { setAttrVal<string>("Id_vrf_user", value); }
        }
		public string Id_vrf_dept {
            get { return getAttrVal<string>("Id_vrf_dept",null); }
            set { setAttrVal<string>("Id_vrf_dept", value); }
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
		public string Id_dead_apply_status {
            get { return getAttrVal<string>("Id_dead_apply_status",null); }
            set { setAttrVal<string>("Id_dead_apply_status", value); }
        }
		public string Sd_dead_apply_status {
            get { return getAttrVal<string>("Sd_dead_apply_status",null); }
            set { setAttrVal<string>("Sd_dead_apply_status", value); }
        }
		public string Dead_apply_reason {
            get { return getAttrVal<string>("Dead_apply_reason",null); }
            set { setAttrVal<string>("Dead_apply_reason", value); }
        }
		public string Dead_callback_reason {
            get { return getAttrVal<string>("Dead_callback_reason",null); }
            set { setAttrVal<string>("Dead_callback_reason", value); }
        }
		public DateTime? Dt_dead_apply {
            get { return getAttrVal<FDateTime>("Dt_dead_apply",null); }
            set { setAttrVal<FDateTime>("Dt_dead_apply", value); }
        }
		public DateTime? Dt_dead_agree {
            get { return getAttrVal<FDateTime>("Dt_dead_agree",null); }
            set { setAttrVal<FDateTime>("Dt_dead_agree", value); }
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
		public string Rfm_doctor_code {
            get { return getAttrVal<string>("Rfm_doctor_code",null); }
            set { setAttrVal<string>("Rfm_doctor_code", value); }
        }
		public string Rfm_doctor_name {
            get { return getAttrVal<string>("Rfm_doctor_name",null); }
            set { setAttrVal<string>("Rfm_doctor_name", value); }
        }
		public string Rfm_dept_code {
            get { return getAttrVal<string>("Rfm_dept_code",null); }
            set { setAttrVal<string>("Rfm_dept_code", value); }
        }
		public string Rfm_dept_name {
            get { return getAttrVal<string>("Rfm_dept_name",null); }
            set { setAttrVal<string>("Rfm_dept_name", value); }
        }
		public string Vrf_user_name {
            get { return getAttrVal<string>("Vrf_user_name",null); }
            set { setAttrVal<string>("Vrf_user_name", value); }
        }
		public string Vrf_user_code {
            get { return getAttrVal<string>("Vrf_user_code",null); }
            set { setAttrVal<string>("Vrf_user_code", value); }
        }
		public string Vrf_dept_code {
            get { return getAttrVal<string>("Vrf_dept_code",null); }
            set { setAttrVal<string>("Vrf_dept_code", value); }
        }
		public string Vrf_dept_name {
            get { return getAttrVal<string>("Vrf_dept_name",null); }
            set { setAttrVal<string>("Vrf_dept_name", value); }
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
		public string Dead_apply_status_code {
            get { return getAttrVal<string>("Dead_apply_status_code",null); }
            set { setAttrVal<string>("Dead_apply_status_code", value); }
        }
		public string Dead_apply_status_name {
            get { return getAttrVal<string>("Dead_apply_status_name",null); }
            set { setAttrVal<string>("Dead_apply_status_name", value); }
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
            return "ci_qa_revision_notice";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_revision";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mrqc.revisionnotice.d.RevisionNoticeDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_revision", "Id_grp", "Id_org", "Id_status", "Sd_status", "Dt_send", "Id_exec_doctor", "Rfm_deadline", "Dt_deadline", "Id_exec_dept", "Id_ent", "Id_rfm_doctor", "Id_rfm_dept", "Id_qa_ty", "Sd_qa_ty", "Fg_cmpl", "Rfm_time", "Vrf_time", "Des", "Id_vrf_user", "Id_vrf_dept", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Id_dead_apply_status", "Sd_dead_apply_status", "Dead_apply_reason", "Dead_callback_reason", "Dt_dead_apply", "Dt_dead_agree", "Grp_code", "Grp_name", "Org_code", "Org_name", "Rfm_doctor_code", "Rfm_doctor_name", "Rfm_dept_code", "Rfm_dept_name", "Vrf_user_name", "Vrf_user_code", "Vrf_dept_code", "Vrf_dept_name", "Createby_name", "Createby_code", "Modifiedby_name", "Modifiedby_code", "Dead_apply_status_code", "Dead_apply_status_name"};
        }
        
    }
}
