
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.ord.cior.d
{
    /// <summary>
    /// OrdApRptOpDO 的摘要说明。
    /// </summary>
    public class OrdApRptOpDO : BaseDO {

        public OrdApRptOpDO() {
        }
		public string Id_rptsug {
            get { return getAttrVal<string>("Id_rptsug",null); }
            set { setAttrVal<string>("Id_rptsug", value); }
        }
		public string Id_orop {
            get { return getAttrVal<string>("Id_orop",null); }
            set { setAttrVal<string>("Id_orop", value); }
        }
		public string Id_or {
            get { return getAttrVal<string>("Id_or",null); }
            set { setAttrVal<string>("Id_or", value); }
        }
		public DateTime? Dt_b_actual {
            get { return getAttrVal<FDateTime>("Dt_b_actual",null); }
            set { setAttrVal<FDateTime>("Dt_b_actual", value); }
        }
		public DateTime? Dt_e_actual {
            get { return getAttrVal<FDateTime>("Dt_e_actual",null); }
            set { setAttrVal<FDateTime>("Dt_e_actual", value); }
        }
		public string Id_dep_actual {
            get { return getAttrVal<string>("Id_dep_actual",null); }
            set { setAttrVal<string>("Id_dep_actual", value); }
        }
		public bool? Fg_success {
            get { return getAttrVal<FBoolean>("Fg_success",null); }
            set { setAttrVal<FBoolean>("Fg_success", value); }
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
            return "ci_rpt_sug";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_rptsug";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.cior.d.OrdApRptOpDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_rptsug", "Id_orop", "Id_or", "Dt_b_actual", "Dt_e_actual", "Id_dep_actual", "Fg_success", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime"};
        }
        
    }
}
