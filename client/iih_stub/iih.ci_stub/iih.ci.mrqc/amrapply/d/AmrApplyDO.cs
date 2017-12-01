
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.mrqc.amrapply.d
{
    /// <summary>
    /// AmrApplyDO 的摘要说明。
    /// </summary>
    public class AmrApplyDO : BaseDO {

        public AmrApplyDO() {
        }
		public string Id_amr_apply {
            get { return getAttrVal<string>("Id_amr_apply",null); }
            set { setAttrVal<string>("Id_amr_apply", value); }
        }
		public string Id_grp {
            get { return getAttrVal<string>("Id_grp",null); }
            set { setAttrVal<string>("Id_grp", value); }
        }
		public string Id_org {
            get { return getAttrVal<string>("Id_org",null); }
            set { setAttrVal<string>("Id_org", value); }
        }
		public string Id_apply_status {
            get { return getAttrVal<string>("Id_apply_status",null); }
            set { setAttrVal<string>("Id_apply_status", value); }
        }
		public string Sd_apply_status {
            get { return getAttrVal<string>("Sd_apply_status",null); }
            set { setAttrVal<string>("Sd_apply_status", value); }
        }
		public string Apply_reason {
            get { return getAttrVal<string>("Apply_reason",null); }
            set { setAttrVal<string>("Apply_reason", value); }
        }
		public string Id_apply_user {
            get { return getAttrVal<string>("Id_apply_user",null); }
            set { setAttrVal<string>("Id_apply_user", value); }
        }
		public string Id_apply_dep {
            get { return getAttrVal<string>("Id_apply_dep",null); }
            set { setAttrVal<string>("Id_apply_dep", value); }
        }
		public string Id_ent {
            get { return getAttrVal<string>("Id_ent",null); }
            set { setAttrVal<string>("Id_ent", value); }
        }
		public string Id_agree_user {
            get { return getAttrVal<string>("Id_agree_user",null); }
            set { setAttrVal<string>("Id_agree_user", value); }
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
		public DateTime? Dt_apply {
            get { return getAttrVal<FDateTime>("Dt_apply",null); }
            set { setAttrVal<FDateTime>("Dt_apply", value); }
        }
		public DateTime? Dt_agree {
            get { return getAttrVal<FDateTime>("Dt_agree",null); }
            set { setAttrVal<FDateTime>("Dt_agree", value); }
        }
		public string Id_pat {
            get { return getAttrVal<string>("Id_pat",null); }
            set { setAttrVal<string>("Id_pat", value); }
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
		public string Apply_status_code {
            get { return getAttrVal<string>("Apply_status_code",null); }
            set { setAttrVal<string>("Apply_status_code", value); }
        }
		public string Apply_status_name {
            get { return getAttrVal<string>("Apply_status_name",null); }
            set { setAttrVal<string>("Apply_status_name", value); }
        }
		public string Userapply_code {
            get { return getAttrVal<string>("Userapply_code",null); }
            set { setAttrVal<string>("Userapply_code", value); }
        }
		public string Userapply_name {
            get { return getAttrVal<string>("Userapply_name",null); }
            set { setAttrVal<string>("Userapply_name", value); }
        }
		public string Dep_code {
            get { return getAttrVal<string>("Dep_code",null); }
            set { setAttrVal<string>("Dep_code", value); }
        }
		public string Dep_name {
            get { return getAttrVal<string>("Dep_name",null); }
            set { setAttrVal<string>("Dep_name", value); }
        }
		public string En_id_pat {
            get { return getAttrVal<string>("En_id_pat",null); }
            set { setAttrVal<string>("En_id_pat", value); }
        }
		public string Useragree_name {
            get { return getAttrVal<string>("Useragree_name",null); }
            set { setAttrVal<string>("Useragree_name", value); }
        }
		public string Useragree_code {
            get { return getAttrVal<string>("Useragree_code",null); }
            set { setAttrVal<string>("Useragree_code", value); }
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
		public string Pat_name {
            get { return getAttrVal<string>("Pat_name",null); }
            set { setAttrVal<string>("Pat_name", value); }
        }
		public string Pat_code {
            get { return getAttrVal<string>("Pat_code",null); }
            set { setAttrVal<string>("Pat_code", value); }
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
            return "ci_amr_apply";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_amr_apply";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mrqc.amrapply.d.AmrApplyDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_amr_apply", "Id_grp", "Id_org", "Id_apply_status", "Sd_apply_status", "Apply_reason", "Id_apply_user", "Id_apply_dep", "Id_ent", "Id_agree_user", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Dt_apply", "Dt_agree", "Id_pat", "Grp_code", "Grp_name", "Org_code", "Org_name", "Apply_status_code", "Apply_status_name", "Userapply_code", "Userapply_name", "Dep_code", "Dep_name", "En_id_pat", "Useragree_name", "Useragree_code", "Createby_name", "Createby_code", "Modifiedby_name", "Modifiedby_code", "Pat_name", "Pat_code"};
        }
        
    }
}
