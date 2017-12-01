
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.mrqc.divide.d
{
    /// <summary>
    /// DivideDO 的摘要说明。
    /// </summary>
    public class DivideDO : BaseDO {

		public const string TABLE_NAME = "ci_qa_divide";
		public const string TABLE_ALIAS_NAME = "a0";

        public DivideDO() {
        }
		public string Id_qa_divide {
            get { return getAttrVal<string>("Id_qa_divide",null); }
            set { setAttrVal<string>("Id_qa_divide", value); }
        }
		public string Id_grp {
            get { return getAttrVal<string>("Id_grp",null); }
            set { setAttrVal<string>("Id_grp", value); }
        }
		public string Id_org {
            get { return getAttrVal<string>("Id_org",null); }
            set { setAttrVal<string>("Id_org", value); }
        }
		public string Id_qa_itm {
            get { return getAttrVal<string>("Id_qa_itm",null); }
            set { setAttrVal<string>("Id_qa_itm", value); }
        }
		public string Id_qa_ty {
            get { return getAttrVal<string>("Id_qa_ty",null); }
            set { setAttrVal<string>("Id_qa_ty", value); }
        }
		public string Sd_qa_ty {
            get { return getAttrVal<string>("Sd_qa_ty",null); }
            set { setAttrVal<string>("Sd_qa_ty", value); }
        }
		public DateTime? Sbmt_time {
            get { return getAttrVal<FDateTime>("Sbmt_time",null); }
            set { setAttrVal<FDateTime>("Sbmt_time", value); }
        }
		public string Id_sbmt_user {
            get { return getAttrVal<string>("Id_sbmt_user",null); }
            set { setAttrVal<string>("Id_sbmt_user", value); }
        }
		public string Id_sbmt_dept {
            get { return getAttrVal<string>("Id_sbmt_dept",null); }
            set { setAttrVal<string>("Id_sbmt_dept", value); }
        }
		public string Rfm_req {
            get { return getAttrVal<string>("Rfm_req",null); }
            set { setAttrVal<string>("Rfm_req", value); }
        }
		public string Drp_des {
            get { return getAttrVal<string>("Drp_des",null); }
            set { setAttrVal<string>("Drp_des", value); }
        }
		public string Id_ent {
            get { return getAttrVal<string>("Id_ent",null); }
            set { setAttrVal<string>("Id_ent", value); }
        }
		public int? Deduct_scr_times {
            get { return getAttrVal<int?>("Deduct_scr_times",null); }
            set { setAttrVal<int?>("Deduct_scr_times", value); }
        }
		public int? Qa_scr {
            get { return getAttrVal<int?>("Qa_scr",null); }
            set { setAttrVal<int?>("Qa_scr", value); }
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
            return "ci_qa_divide";
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
            return "Id_qa_divide";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mrqc.divide.d.DivideDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_qa_divide", "Id_grp", "Id_org", "Id_qa_itm", "Id_qa_ty", "Sd_qa_ty", "Sbmt_time", "Id_sbmt_user", "Id_sbmt_dept", "Rfm_req", "Drp_des", "Id_ent", "Deduct_scr_times", "Qa_scr", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Grp_code", "Grp_name", "Org_code", "Org_name", "Createby_name", "Createby_code", "Modifiedby_name", "Modifiedby_code"};
        }
        
    }
}
