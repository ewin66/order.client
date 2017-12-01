
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.ord.skintest.d
{
    /// <summary>
    /// CiSkinTestRstDO 的摘要说明。
    /// </summary>
    public class CiSkinTestRstDO : BaseDO {

        public CiSkinTestRstDO() {
        }
		public string Id_skintest {
            get { return getAttrVal<string>("Id_skintest",null); }
            set { setAttrVal<string>("Id_skintest", value); }
        }
		public string Id_or {
            get { return getAttrVal<string>("Id_or",null); }
            set { setAttrVal<string>("Id_or", value); }
        }
		public string Id_rst_skintest {
            get { return getAttrVal<string>("Id_rst_skintest",null); }
            set { setAttrVal<string>("Id_rst_skintest", value); }
        }
		public string Sd_rst_skintest {
            get { return getAttrVal<string>("Sd_rst_skintest",null); }
            set { setAttrVal<string>("Sd_rst_skintest", value); }
        }
		public string Id_emp_create {
            get { return getAttrVal<string>("Id_emp_create",null); }
            set { setAttrVal<string>("Id_emp_create", value); }
        }
		public DateTime? Dt_create {
            get { return getAttrVal<FDateTime>("Dt_create",null); }
            set { setAttrVal<FDateTime>("Dt_create", value); }
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
		public string Skinres_name {
            get { return getAttrVal<string>("Skinres_name",null); }
            set { setAttrVal<string>("Skinres_name", value); }
        }
		public string Skinres_code {
            get { return getAttrVal<string>("Skinres_code",null); }
            set { setAttrVal<string>("Skinres_code", value); }
        }
		public string Id_udidoclist {
            get { return getAttrVal<string>("Id_udidoclist",null); }
            set { setAttrVal<string>("Id_udidoclist", value); }
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
            return "ci_skin_test";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_skintest";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.skintest.d.CiSkinTestRstDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_skintest", "Id_or", "Id_rst_skintest", "Sd_rst_skintest", "Id_emp_create", "Dt_create", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Skinres_name", "Skinres_code", "Id_udidoclist"};
        }
        
    }
}
