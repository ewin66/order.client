
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.mr.mrsign.d
{
    /// <summary>
    /// CiMrSignDO 的摘要说明。
    /// </summary>
    public class CiMrSignDO : BaseDO {

        public CiMrSignDO() {
        }
		public string Id_mrsign {
            get { return getAttrVal<string>("Id_mrsign",null); }
            set { setAttrVal<string>("Id_mrsign", value); }
        }
		public string Id_mr {
            get { return getAttrVal<string>("Id_mr",null); }
            set { setAttrVal<string>("Id_mr", value); }
        }
		public string Id_signlvl {
            get { return getAttrVal<string>("Id_signlvl",null); }
            set { setAttrVal<string>("Id_signlvl", value); }
        }
		public string Sd_signlvl {
            get { return getAttrVal<string>("Sd_signlvl",null); }
            set { setAttrVal<string>("Sd_signlvl", value); }
        }
		public string Id_role_sign {
            get { return getAttrVal<string>("Id_role_sign",null); }
            set { setAttrVal<string>("Id_role_sign", value); }
        }
		public string Sd_role_sign {
            get { return getAttrVal<string>("Sd_role_sign",null); }
            set { setAttrVal<string>("Sd_role_sign", value); }
        }
		public string Id_signtp {
            get { return getAttrVal<string>("Id_signtp",null); }
            set { setAttrVal<string>("Id_signtp", value); }
        }
		public string Sd_signtp {
            get { return getAttrVal<string>("Sd_signtp",null); }
            set { setAttrVal<string>("Sd_signtp", value); }
        }
		public DateTime? Dt_sign {
            get { return getAttrVal<FDateTime>("Dt_sign",null); }
            set { setAttrVal<FDateTime>("Dt_sign", value); }
        }
		public string Id_emp_sign {
            get { return getAttrVal<string>("Id_emp_sign",null); }
            set { setAttrVal<string>("Id_emp_sign", value); }
        }
		public string Id_pat_sign {
            get { return getAttrVal<string>("Id_pat_sign",null); }
            set { setAttrVal<string>("Id_pat_sign", value); }
        }
		public string Id_dep {
            get { return getAttrVal<string>("Id_dep",null); }
            set { setAttrVal<string>("Id_dep", value); }
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
            return "ci_mr_sign";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_mrsign";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.mrsign.d.CiMrSignDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_mrsign", "Id_mr", "Id_signlvl", "Sd_signlvl", "Id_role_sign", "Sd_role_sign", "Id_signtp", "Sd_signtp", "Dt_sign", "Id_emp_sign", "Id_pat_sign", "Id_dep", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime"};
        }
        
    }
}
