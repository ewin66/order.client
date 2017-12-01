
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.mrqc.qaflt.d
{
    /// <summary>
    /// QaFltDO 的摘要说明。
    /// </summary>
    public class QaFltDO : BaseDO {

        public QaFltDO() {
        }
		public string Id_qa_flt {
            get { return getAttrVal<string>("Id_qa_flt",null); }
            set { setAttrVal<string>("Id_qa_flt", value); }
        }
		public string Id_grp {
            get { return getAttrVal<string>("Id_grp",null); }
            set { setAttrVal<string>("Id_grp", value); }
        }
		public string Id_org {
            get { return getAttrVal<string>("Id_org",null); }
            set { setAttrVal<string>("Id_org", value); }
        }
		public string Id_revision {
            get { return getAttrVal<string>("Id_revision",null); }
            set { setAttrVal<string>("Id_revision", value); }
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
		public string Id_flt_sta {
            get { return getAttrVal<string>("Id_flt_sta",null); }
            set { setAttrVal<string>("Id_flt_sta", value); }
        }
		public string Sd_flt_sta {
            get { return getAttrVal<string>("Sd_flt_sta",null); }
            set { setAttrVal<string>("Sd_flt_sta", value); }
        }
		public DateTime? Dt_sbmt {
            get { return getAttrVal<FDateTime>("Dt_sbmt",null); }
            set { setAttrVal<FDateTime>("Dt_sbmt", value); }
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
		public DateTime? Dt_rfm {
            get { return getAttrVal<FDateTime>("Dt_rfm",null); }
            set { setAttrVal<FDateTime>("Dt_rfm", value); }
        }
		public string Id_rfm_user {
            get { return getAttrVal<string>("Id_rfm_user",null); }
            set { setAttrVal<string>("Id_rfm_user", value); }
        }
		public string Id_rfm_dept {
            get { return getAttrVal<string>("Id_rfm_dept",null); }
            set { setAttrVal<string>("Id_rfm_dept", value); }
        }
		public string Rfm_des {
            get { return getAttrVal<string>("Rfm_des",null); }
            set { setAttrVal<string>("Rfm_des", value); }
        }
		public DateTime? Dt_vrf {
            get { return getAttrVal<FDateTime>("Dt_vrf",null); }
            set { setAttrVal<FDateTime>("Dt_vrf", value); }
        }
		public string Id_vrf_user {
            get { return getAttrVal<string>("Id_vrf_user",null); }
            set { setAttrVal<string>("Id_vrf_user", value); }
        }
		public string Id_vrf_dept {
            get { return getAttrVal<string>("Id_vrf_dept",null); }
            set { setAttrVal<string>("Id_vrf_dept", value); }
        }
		public string Drp_des {
            get { return getAttrVal<string>("Drp_des",null); }
            set { setAttrVal<string>("Drp_des", value); }
        }
		public string Id_ent {
            get { return getAttrVal<string>("Id_ent",null); }
            set { setAttrVal<string>("Id_ent", value); }
        }
		public string Id_mr {
            get { return getAttrVal<string>("Id_mr",null); }
            set { setAttrVal<string>("Id_mr", value); }
        }
		public int? Deduct_scr_times {
            get { return getAttrVal<int?>("Deduct_scr_times",null); }
            set { setAttrVal<int?>("Deduct_scr_times", value); }
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
		public string Qa_ty_code {
            get { return getAttrVal<string>("Qa_ty_code",null); }
            set { setAttrVal<string>("Qa_ty_code", value); }
        }
		public string Qa_ty_name {
            get { return getAttrVal<string>("Qa_ty_name",null); }
            set { setAttrVal<string>("Qa_ty_name", value); }
        }
		public string Flt_sta_code {
            get { return getAttrVal<string>("Flt_sta_code",null); }
            set { setAttrVal<string>("Flt_sta_code", value); }
        }
		public string Flt_sta_name {
            get { return getAttrVal<string>("Flt_sta_name",null); }
            set { setAttrVal<string>("Flt_sta_name", value); }
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
            return "ci_qa_flt";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_qa_flt";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mrqc.qaflt.d.QaFltDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_qa_flt", "Id_grp", "Id_org", "Id_revision", "Id_qa_itm", "Id_qa_ty", "Sd_qa_ty", "Id_flt_sta", "Sd_flt_sta", "Dt_sbmt", "Id_sbmt_user", "Id_sbmt_dept", "Rfm_req", "Dt_rfm", "Id_rfm_user", "Id_rfm_dept", "Rfm_des", "Dt_vrf", "Id_vrf_user", "Id_vrf_dept", "Drp_des", "Id_ent", "Id_mr", "Deduct_scr_times", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Grp_code", "Grp_name", "Org_code", "Org_name", "Qa_ty_code", "Qa_ty_name", "Flt_sta_code", "Flt_sta_name", "Createby_name", "Createby_code", "Modifiedby_name", "Modifiedby_code"};
        }
        
    }
}
