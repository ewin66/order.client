
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.mrqc.qared.d
{
    /// <summary>
    /// QaRecordDO 的摘要说明。
    /// </summary>
    public class QaRecordDO : BaseDO {

		public const string TABLE_NAME = "ci_qa_record";
		public const string TABLE_ALIAS_NAME = "a0";

        public QaRecordDO() {
        }
		public string Id_qa {
            get { return getAttrVal<string>("Id_qa",null); }
            set { setAttrVal<string>("Id_qa", value); }
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
		public string Id_qa_ty {
            get { return getAttrVal<string>("Id_qa_ty",null); }
            set { setAttrVal<string>("Id_qa_ty", value); }
        }
		public string Sd_qa_ty {
            get { return getAttrVal<string>("Sd_qa_ty",null); }
            set { setAttrVal<string>("Sd_qa_ty", value); }
        }
		public DateTime? Dt_plan {
            get { return getAttrVal<FDateTime>("Dt_plan",null); }
            set { setAttrVal<FDateTime>("Dt_plan", value); }
        }
		public DateTime? Dt_exec_begin {
            get { return getAttrVal<FDateTime>("Dt_exec_begin",null); }
            set { setAttrVal<FDateTime>("Dt_exec_begin", value); }
        }
		public DateTime? Dt_exec_end {
            get { return getAttrVal<FDateTime>("Dt_exec_end",null); }
            set { setAttrVal<FDateTime>("Dt_exec_end", value); }
        }
		public string Id_exec_user {
            get { return getAttrVal<string>("Id_exec_user",null); }
            set { setAttrVal<string>("Id_exec_user", value); }
        }
		public string Id_exec_dept {
            get { return getAttrVal<string>("Id_exec_dept",null); }
            set { setAttrVal<string>("Id_exec_dept", value); }
        }
		public bool? Fg_cmpl {
            get { return getAttrVal<FBoolean>("Fg_cmpl",null); }
            set { setAttrVal<FBoolean>("Fg_cmpl", value); }
        }
		public bool? Fg_have_flt {
            get { return getAttrVal<FBoolean>("Fg_have_flt",null); }
            set { setAttrVal<FBoolean>("Fg_have_flt", value); }
        }
		public bool? Fg_need_rfm_flt {
            get { return getAttrVal<FBoolean>("Fg_need_rfm_flt",null); }
            set { setAttrVal<FBoolean>("Fg_need_rfm_flt", value); }
        }
		public int? Rfm_deadline {
            get { return getAttrVal<int?>("Rfm_deadline",null); }
            set { setAttrVal<int?>("Rfm_deadline", value); }
        }
		public DateTime? Deadline {
            get { return getAttrVal<FDateTime>("Deadline",null); }
            set { setAttrVal<FDateTime>("Deadline", value); }
        }
		public string Id_revision {
            get { return getAttrVal<string>("Id_revision",null); }
            set { setAttrVal<string>("Id_revision", value); }
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
            return "ci_qa_record";
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
            return "Id_qa";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mrqc.qared.d.QaRecordDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_qa", "Id_grp", "Id_org", "Id_ent", "Id_qa_ty", "Sd_qa_ty", "Dt_plan", "Dt_exec_begin", "Dt_exec_end", "Id_exec_user", "Id_exec_dept", "Fg_cmpl", "Fg_have_flt", "Fg_need_rfm_flt", "Rfm_deadline", "Deadline", "Id_revision", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Grp_code", "Grp_name", "Org_code", "Org_name", "Createby_name", "Createby_code", "Modifiedby_name", "Modifiedby_code"};
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
