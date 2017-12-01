
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.mrqc.concerndep.d
{
    /// <summary>
    /// ConcernDepDO 的摘要说明。
    /// </summary>
    public class ConcernDepDO : BaseDO {

        public ConcernDepDO() {
        }
		public string Id_con_dept {
            get { return getAttrVal<string>("Id_con_dept",null); }
            set { setAttrVal<string>("Id_con_dept", value); }
        }
		public string Id_ent {
            get { return getAttrVal<string>("Id_ent",null); }
            set { setAttrVal<string>("Id_ent", value); }
        }
		public string Id_coned_dept {
            get { return getAttrVal<string>("Id_coned_dept",null); }
            set { setAttrVal<string>("Id_coned_dept", value); }
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
		public string Coned_dept_code {
            get { return getAttrVal<string>("Coned_dept_code",null); }
            set { setAttrVal<string>("Coned_dept_code", value); }
        }
		public string Coned_dept_name {
            get { return getAttrVal<string>("Coned_dept_name",null); }
            set { setAttrVal<string>("Coned_dept_name", value); }
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
            return "CI_ARM_CON_DEPT";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_con_dept";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mrqc.concerndep.d.ConcernDepDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_con_dept", "Id_ent", "Id_coned_dept", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Coned_dept_code", "Coned_dept_name", "Createby_name", "Createby_code", "Modifiedby_name", "Modifiedby_code"};
        }
        
    }
}
