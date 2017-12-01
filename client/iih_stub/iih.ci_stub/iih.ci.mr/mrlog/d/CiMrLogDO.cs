
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.mr.mrlog.d
{
    /// <summary>
    /// CiMrLogDO 的摘要说明。
    /// </summary>
    public class CiMrLogDO : BaseDO {

        public CiMrLogDO() {
        }
		public string Id_mr_log {
            get { return getAttrVal<string>("Id_mr_log",null); }
            set { setAttrVal<string>("Id_mr_log", value); }
        }
		public string Id_grp {
            get { return getAttrVal<string>("Id_grp",null); }
            set { setAttrVal<string>("Id_grp", value); }
        }
		public string Id_org {
            get { return getAttrVal<string>("Id_org",null); }
            set { setAttrVal<string>("Id_org", value); }
        }
		public string Id_mr {
            get { return getAttrVal<string>("Id_mr",null); }
            set { setAttrVal<string>("Id_mr", value); }
        }
		public string Id_user_operate {
            get { return getAttrVal<string>("Id_user_operate",null); }
            set { setAttrVal<string>("Id_user_operate", value); }
        }
		public string Id_type_operate {
            get { return getAttrVal<string>("Id_type_operate",null); }
            set { setAttrVal<string>("Id_type_operate", value); }
        }
		public string Sd_type_operate {
            get { return getAttrVal<string>("Sd_type_operate",null); }
            set { setAttrVal<string>("Sd_type_operate", value); }
        }
		public DateTime? Dt_operate {
            get { return getAttrVal<FDateTime>("Dt_operate",null); }
            set { setAttrVal<FDateTime>("Dt_operate", value); }
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
		public string User_operate_name {
            get { return getAttrVal<string>("User_operate_name",null); }
            set { setAttrVal<string>("User_operate_name", value); }
        }
		public string User_operate_code {
            get { return getAttrVal<string>("User_operate_code",null); }
            set { setAttrVal<string>("User_operate_code", value); }
        }
		public string Type_operate_code {
            get { return getAttrVal<string>("Type_operate_code",null); }
            set { setAttrVal<string>("Type_operate_code", value); }
        }
		public string Type_operate_name {
            get { return getAttrVal<string>("Type_operate_name",null); }
            set { setAttrVal<string>("Type_operate_name", value); }
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
            return "ci_mr_log";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_mr_log";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.mrlog.d.CiMrLogDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_mr_log", "Id_grp", "Id_org", "Id_mr", "Id_user_operate", "Id_type_operate", "Sd_type_operate", "Dt_operate", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Grp_code", "Grp_name", "Org_code", "Org_name", "User_operate_name", "User_operate_code", "Type_operate_code", "Type_operate_name", "Createby_name", "Createby_code", "Modifiedby_name", "Modifiedby_code"};
        }
        
    }
}
