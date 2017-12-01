
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.mr.cimreledg.d
{
    /// <summary>
    /// CiMrEleDgDO 的摘要说明。
    /// </summary>
    public class CiMrEleDgDO : BaseDO {

		public const string TABLE_NAME = "CI_MR_ELE_DG";
		public const string TABLE_ALIAS_NAME = "a0";

        public CiMrEleDgDO() {
        }
		public string Id_mrdg {
            get { return getAttrVal<string>("Id_mrdg",null); }
            set { setAttrVal<string>("Id_mrdg", value); }
        }
		public string Id_grp {
            get { return getAttrVal<string>("Id_grp",null); }
            set { setAttrVal<string>("Id_grp", value); }
        }
		public string Id_org {
            get { return getAttrVal<string>("Id_org",null); }
            set { setAttrVal<string>("Id_org", value); }
        }
		public string Id_mrtpldg {
            get { return getAttrVal<string>("Id_mrtpldg",null); }
            set { setAttrVal<string>("Id_mrtpldg", value); }
        }
		public string Name_mrdg {
            get { return getAttrVal<string>("Name_mrdg",null); }
            set { setAttrVal<string>("Name_mrdg", value); }
        }
		public string Id_dg {
            get { return getAttrVal<string>("Id_dg",null); }
            set { setAttrVal<string>("Id_dg", value); }
        }
		public string Id_mrdg_pat {
            get { return getAttrVal<string>("Id_mrdg_pat",null); }
            set { setAttrVal<string>("Id_mrdg_pat", value); }
        }
		public string Id_mr {
            get { return getAttrVal<string>("Id_mr",null); }
            set { setAttrVal<string>("Id_mr", value); }
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
            return "CI_MR_ELE_DG";
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
            return "Id_mrdg";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.cimreledg.d.CiMrEleDgDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_mrdg", "Id_grp", "Id_org", "Id_mrtpldg", "Name_mrdg", "Id_dg", "Id_mrdg_pat", "Id_mr", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime"};
        }
        
		/// <summary>
        /// 设置IBDataInfo接口映射数据
        /// </summary>
        /// <returns></returns>
		protected override void setBdDataInfoNameMap() {
			if (base.name_path_map == null)
            {
                base.name_path_map = new Dictionary<string, string>();
				base.name_path_map.Add("id","Id_mrdg");
				base.name_path_map.Add("pid","Id_mrdg_pat");
				base.name_path_map.Add("id_org","Id_org");
				base.name_path_map.Add("id_group","Id_grp");
            }
		}
    }
}
