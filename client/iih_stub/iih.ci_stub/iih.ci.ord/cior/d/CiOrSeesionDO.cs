
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.cior.d
{
    /// <summary>
    /// CiOrSeesionDO 的摘要说明。
    /// </summary>
    public class CiOrSeesionDO : BaseDO {

        public CiOrSeesionDO() {
        }
		public string Id_ciorsession {
            get { return getAttrVal<string>("Id_ciorsession",null); }
            set { setAttrVal<string>("Id_ciorsession", value); }
        }
		public string Id_pat {
            get { return getAttrVal<string>("Id_pat",null); }
            set { setAttrVal<string>("Id_pat", value); }
        }
		public string Id_en {
            get { return getAttrVal<string>("Id_en",null); }
            set { setAttrVal<string>("Id_en", value); }
        }
		public string Id_org_create {
            get { return getAttrVal<string>("Id_org_create",null); }
            set { setAttrVal<string>("Id_org_create", value); }
        }
		public string Id_emp_create {
            get { return getAttrVal<string>("Id_emp_create",null); }
            set { setAttrVal<string>("Id_emp_create", value); }
        }
		public string Id_dep_create {
            get { return getAttrVal<string>("Id_dep_create",null); }
            set { setAttrVal<string>("Id_dep_create", value); }
        }
		public string Id_wg_create {
            get { return getAttrVal<string>("Id_wg_create",null); }
            set { setAttrVal<string>("Id_wg_create", value); }
        }
		public DateTime? Dt_create {
            get { return getAttrVal<FDateTime>("Dt_create",null); }
            set { setAttrVal<FDateTime>("Dt_create", value); }
        }
		public bool? Fg_canc {
            get { return getAttrVal<FBoolean>("Fg_canc",null); }
            set { setAttrVal<FBoolean>("Fg_canc", value); }
        }
		public DateTime? Dt_canc {
            get { return getAttrVal<FDateTime>("Dt_canc",null); }
            set { setAttrVal<FDateTime>("Dt_canc", value); }
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
            return "CI_OR_SESSION";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_ciorsession";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.cior.d.CiOrSeesionDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_ciorsession", "Id_pat", "Id_en", "Id_org_create", "Id_emp_create", "Id_dep_create", "Id_wg_create", "Dt_create", "Fg_canc", "Dt_canc"};
        }
        
    }
}
