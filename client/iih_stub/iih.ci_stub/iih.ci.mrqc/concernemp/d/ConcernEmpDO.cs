
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.mrqc.concernemp.d
{
    /// <summary>
    /// ConcernEmpDO 的摘要说明。
    /// </summary>
    public class ConcernEmpDO : BaseDO {

        public ConcernEmpDO() {
        }
		public string Id_con_emp {
            get { return getAttrVal<string>("Id_con_emp",null); }
            set { setAttrVal<string>("Id_con_emp", value); }
        }
		public string Id_ent {
            get { return getAttrVal<string>("Id_ent",null); }
            set { setAttrVal<string>("Id_ent", value); }
        }
		public string Id_coned_emp {
            get { return getAttrVal<string>("Id_coned_emp",null); }
            set { setAttrVal<string>("Id_coned_emp", value); }
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
		public string Coned_emp_name {
            get { return getAttrVal<string>("Coned_emp_name",null); }
            set { setAttrVal<string>("Coned_emp_name", value); }
        }
		public string Coned_emp_code {
            get { return getAttrVal<string>("Coned_emp_code",null); }
            set { setAttrVal<string>("Coned_emp_code", value); }
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
            return "CI_AMR_CON_EMP";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_con_emp";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mrqc.concernemp.d.ConcernEmpDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_con_emp", "Id_ent", "Id_coned_emp", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Coned_emp_name", "Coned_emp_code", "Createby_name", "Createby_code", "Modifiedby_name", "Modifiedby_code"};
        }
        
    }
}
