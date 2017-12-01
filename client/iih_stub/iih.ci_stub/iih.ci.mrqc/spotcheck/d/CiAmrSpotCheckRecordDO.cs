
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.mrqc.spotcheck.d
{
    /// <summary>
    /// CiAmrSpotCheckRecordDO 的摘要说明。
    /// </summary>
    public class CiAmrSpotCheckRecordDO : BaseDO {

        public CiAmrSpotCheckRecordDO() {
        }
		public string Id_spot_check {
            get { return getAttrVal<string>("Id_spot_check",null); }
            set { setAttrVal<string>("Id_spot_check", value); }
        }
		public string Id_ent {
            get { return getAttrVal<string>("Id_ent",null); }
            set { setAttrVal<string>("Id_ent", value); }
        }
		public string Id_pat {
            get { return getAttrVal<string>("Id_pat",null); }
            set { setAttrVal<string>("Id_pat", value); }
        }
		public string Id_enhr {
            get { return getAttrVal<string>("Id_enhr",null); }
            set { setAttrVal<string>("Id_enhr", value); }
        }
		public string Code_amr_ip {
            get { return getAttrVal<string>("Code_amr_ip",null); }
            set { setAttrVal<string>("Code_amr_ip", value); }
        }
		public string Id_emp_check {
            get { return getAttrVal<string>("Id_emp_check",null); }
            set { setAttrVal<string>("Id_emp_check", value); }
        }
		public DateTime? Dt_check {
            get { return getAttrVal<FDateTime>("Dt_check",null); }
            set { setAttrVal<FDateTime>("Dt_check", value); }
        }
		public bool? Fg_check {
            get { return getAttrVal<FBoolean>("Fg_check",null); }
            set { setAttrVal<FBoolean>("Fg_check", value); }
        }
		public FDouble Score_emp_check {
            get { return getAttrVal<FDouble>("Score_emp_check",null); }
            set { setAttrVal<FDouble>("Score_emp_check", value); }
        }
		public string Id_check_status {
            get { return getAttrVal<string>("Id_check_status",null); }
            set { setAttrVal<string>("Id_check_status", value); }
        }
		public string Sd_check_status {
            get { return getAttrVal<string>("Sd_check_status",null); }
            set { setAttrVal<string>("Sd_check_status", value); }
        }
		public DateTime? Dt_score {
            get { return getAttrVal<FDateTime>("Dt_score",null); }
            set { setAttrVal<FDateTime>("Dt_score", value); }
        }
		public DateTime? Modifiedtime {
            get { return getAttrVal<FDateTime>("Modifiedtime",null); }
            set { setAttrVal<FDateTime>("Modifiedtime", value); }
        }
		public string Modifiedby {
            get { return getAttrVal<string>("Modifiedby",null); }
            set { setAttrVal<string>("Modifiedby", value); }
        }
		public DateTime? Createdtime {
            get { return getAttrVal<FDateTime>("Createdtime",null); }
            set { setAttrVal<FDateTime>("Createdtime", value); }
        }
		public string Createdby {
            get { return getAttrVal<string>("Createdby",null); }
            set { setAttrVal<string>("Createdby", value); }
        }
		public string Temp1 {
            get { return getAttrVal<string>("Temp1",null); }
            set { setAttrVal<string>("Temp1", value); }
        }
		public string Temp2 {
            get { return getAttrVal<string>("Temp2",null); }
            set { setAttrVal<string>("Temp2", value); }
        }
		public string Temp3 {
            get { return getAttrVal<string>("Temp3",null); }
            set { setAttrVal<string>("Temp3", value); }
        }
		public string Temp4 {
            get { return getAttrVal<string>("Temp4",null); }
            set { setAttrVal<string>("Temp4", value); }
        }
		public string Temp5 {
            get { return getAttrVal<string>("Temp5",null); }
            set { setAttrVal<string>("Temp5", value); }
        }
		public string Emp_check_name {
            get { return getAttrVal<string>("Emp_check_name",null); }
            set { setAttrVal<string>("Emp_check_name", value); }
        }
		public string Emp_check_code {
            get { return getAttrVal<string>("Emp_check_code",null); }
            set { setAttrVal<string>("Emp_check_code", value); }
        }
		public string Modifiedby_name {
            get { return getAttrVal<string>("Modifiedby_name",null); }
            set { setAttrVal<string>("Modifiedby_name", value); }
        }
		public string Modifiedby_code {
            get { return getAttrVal<string>("Modifiedby_code",null); }
            set { setAttrVal<string>("Modifiedby_code", value); }
        }
		public string Createby_name {
            get { return getAttrVal<string>("Createby_name",null); }
            set { setAttrVal<string>("Createby_name", value); }
        }
		public string Createby_code {
            get { return getAttrVal<string>("Createby_code",null); }
            set { setAttrVal<string>("Createby_code", value); }
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
            return "CI_AMR_SPOT_CHECK";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_spot_check";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mrqc.spotcheck.d.CiAmrSpotCheckRecordDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_spot_check", "Id_ent", "Id_pat", "Id_enhr", "Code_amr_ip", "Id_emp_check", "Dt_check", "Fg_check", "Score_emp_check", "Id_check_status", "Sd_check_status", "Dt_score", "Modifiedtime", "Modifiedby", "Createdtime", "Createdby", "Temp1", "Temp2", "Temp3", "Temp4", "Temp5", "Emp_check_name", "Emp_check_code", "Modifiedby_name", "Modifiedby_code", "Createby_name", "Createby_code"};
        }
        
    }
}
