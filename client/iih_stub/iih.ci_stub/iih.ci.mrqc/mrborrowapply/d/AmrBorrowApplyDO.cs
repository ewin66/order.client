
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.mrqc.mrborrowapply.d
{
    /// <summary>
    /// AmrBorrowApplyDO 的摘要说明。
    /// </summary>
    public class AmrBorrowApplyDO : BaseDO {

        public AmrBorrowApplyDO() {
        }
		public string Id_amr_borrow_apply {
            get { return getAttrVal<string>("Id_amr_borrow_apply",null); }
            set { setAttrVal<string>("Id_amr_borrow_apply", value); }
        }
		public string Id_grp {
            get { return getAttrVal<string>("Id_grp",null); }
            set { setAttrVal<string>("Id_grp", value); }
        }
		public string Id_org {
            get { return getAttrVal<string>("Id_org",null); }
            set { setAttrVal<string>("Id_org", value); }
        }
		public string Id_borrow_apply_status {
            get { return getAttrVal<string>("Id_borrow_apply_status",null); }
            set { setAttrVal<string>("Id_borrow_apply_status", value); }
        }
		public string Sd_borrow_apply_status {
            get { return getAttrVal<string>("Sd_borrow_apply_status",null); }
            set { setAttrVal<string>("Sd_borrow_apply_status", value); }
        }
		public string Id_amr {
            get { return getAttrVal<string>("Id_amr",null); }
            set { setAttrVal<string>("Id_amr", value); }
        }
		public string Code_amr_ip {
            get { return getAttrVal<string>("Code_amr_ip",null); }
            set { setAttrVal<string>("Code_amr_ip", value); }
        }
		public int? Time_over {
            get { return getAttrVal<int?>("Time_over",null); }
            set { setAttrVal<int?>("Time_over", value); }
        }
		public string Id_type_approve {
            get { return getAttrVal<string>("Id_type_approve",null); }
            set { setAttrVal<string>("Id_type_approve", value); }
        }
		public string Sd_type_approve {
            get { return getAttrVal<string>("Sd_type_approve",null); }
            set { setAttrVal<string>("Sd_type_approve", value); }
        }
		public string Remark_apply {
            get { return getAttrVal<string>("Remark_apply",null); }
            set { setAttrVal<string>("Remark_apply", value); }
        }
		public string Id_borrow_apply_reason {
            get { return getAttrVal<string>("Id_borrow_apply_reason",null); }
            set { setAttrVal<string>("Id_borrow_apply_reason", value); }
        }
		public string Sd_borrow_apply_reason {
            get { return getAttrVal<string>("Sd_borrow_apply_reason",null); }
            set { setAttrVal<string>("Sd_borrow_apply_reason", value); }
        }
		public string Id_borrow_apply_user {
            get { return getAttrVal<string>("Id_borrow_apply_user",null); }
            set { setAttrVal<string>("Id_borrow_apply_user", value); }
        }
		public string Id_borrow_apply_dep {
            get { return getAttrVal<string>("Id_borrow_apply_dep",null); }
            set { setAttrVal<string>("Id_borrow_apply_dep", value); }
        }
		public DateTime? Dt_borrow_apply {
            get { return getAttrVal<FDateTime>("Dt_borrow_apply",null); }
            set { setAttrVal<FDateTime>("Dt_borrow_apply", value); }
        }
		public string Id_ent {
            get { return getAttrVal<string>("Id_ent",null); }
            set { setAttrVal<string>("Id_ent", value); }
        }
		public string Id_agree_borrow_user {
            get { return getAttrVal<string>("Id_agree_borrow_user",null); }
            set { setAttrVal<string>("Id_agree_borrow_user", value); }
        }
		public DateTime? Dt_borrow_agree {
            get { return getAttrVal<FDateTime>("Dt_borrow_agree",null); }
            set { setAttrVal<FDateTime>("Dt_borrow_agree", value); }
        }
		public DateTime? Dt_end_borrow {
            get { return getAttrVal<FDateTime>("Dt_end_borrow",null); }
            set { setAttrVal<FDateTime>("Dt_end_borrow", value); }
        }
		public string Id_pat {
            get { return getAttrVal<string>("Id_pat",null); }
            set { setAttrVal<string>("Id_pat", value); }
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
		public string Ent_code {
            get { return getAttrVal<string>("Ent_code",null); }
            set { setAttrVal<string>("Ent_code", value); }
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
		public string Borrow_apply_code {
            get { return getAttrVal<string>("Borrow_apply_code",null); }
            set { setAttrVal<string>("Borrow_apply_code", value); }
        }
		public string Borrow_apply_name {
            get { return getAttrVal<string>("Borrow_apply_name",null); }
            set { setAttrVal<string>("Borrow_apply_name", value); }
        }
		public string Type_approve_code {
            get { return getAttrVal<string>("Type_approve_code",null); }
            set { setAttrVal<string>("Type_approve_code", value); }
        }
		public string Type_approve_name {
            get { return getAttrVal<string>("Type_approve_name",null); }
            set { setAttrVal<string>("Type_approve_name", value); }
        }
		public string Borrow_apply_reason_code {
            get { return getAttrVal<string>("Borrow_apply_reason_code",null); }
            set { setAttrVal<string>("Borrow_apply_reason_code", value); }
        }
		public string Borrow_apply_reason_name {
            get { return getAttrVal<string>("Borrow_apply_reason_name",null); }
            set { setAttrVal<string>("Borrow_apply_reason_name", value); }
        }
		public string Userr_borrowapply_code {
            get { return getAttrVal<string>("Userr_borrowapply_code",null); }
            set { setAttrVal<string>("Userr_borrowapply_code", value); }
        }
		public string User_borrowapply_name {
            get { return getAttrVal<string>("User_borrowapply_name",null); }
            set { setAttrVal<string>("User_borrowapply_name", value); }
        }
		public string Depr_borrowapply_code {
            get { return getAttrVal<string>("Depr_borrowapply_code",null); }
            set { setAttrVal<string>("Depr_borrowapply_code", value); }
        }
		public string Depr_borrowapply_name {
            get { return getAttrVal<string>("Depr_borrowapply_name",null); }
            set { setAttrVal<string>("Depr_borrowapply_name", value); }
        }
		public string Userr_borrowagree_name {
            get { return getAttrVal<string>("Userr_borrowagree_name",null); }
            set { setAttrVal<string>("Userr_borrowagree_name", value); }
        }
		public string User_borrowagree_code {
            get { return getAttrVal<string>("User_borrowagree_code",null); }
            set { setAttrVal<string>("User_borrowagree_code", value); }
        }
		public string Pat_name {
            get { return getAttrVal<string>("Pat_name",null); }
            set { setAttrVal<string>("Pat_name", value); }
        }
		public string Pat_code {
            get { return getAttrVal<string>("Pat_code",null); }
            set { setAttrVal<string>("Pat_code", value); }
        }
		public string Sex_code {
            get { return getAttrVal<string>("Sex_code",null); }
            set { setAttrVal<string>("Sex_code", value); }
        }
		public string Sex_name {
            get { return getAttrVal<string>("Sex_name",null); }
            set { setAttrVal<string>("Sex_name", value); }
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
            return "ci_amr_borrow_apply";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_amr_borrow_apply";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mrqc.mrborrowapply.d.AmrBorrowApplyDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_amr_borrow_apply", "Id_grp", "Id_org", "Id_borrow_apply_status", "Sd_borrow_apply_status", "Id_amr", "Code_amr_ip", "Time_over", "Id_type_approve", "Sd_type_approve", "Remark_apply", "Id_borrow_apply_reason", "Sd_borrow_apply_reason", "Id_borrow_apply_user", "Id_borrow_apply_dep", "Dt_borrow_apply", "Id_ent", "Id_agree_borrow_user", "Dt_borrow_agree", "Dt_end_borrow", "Id_pat", "Id_sex", "Sd_sex", "Pat_age", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Ent_code", "Grp_code", "Grp_name", "Org_code", "Org_name", "Borrow_apply_code", "Borrow_apply_name", "Type_approve_code", "Type_approve_name", "Borrow_apply_reason_code", "Borrow_apply_reason_name", "Userr_borrowapply_code", "User_borrowapply_name", "Depr_borrowapply_code", "Depr_borrowapply_name", "Userr_borrowagree_name", "User_borrowagree_code", "Pat_name", "Pat_code", "Sex_code", "Sex_name", "Createby_name", "Createby_code", "Modifiedby_name", "Modifiedby_code"};
        }
        
    }
}
