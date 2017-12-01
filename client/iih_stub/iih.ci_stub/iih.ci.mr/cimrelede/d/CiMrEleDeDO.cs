
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.mr.cimrelede.d
{
    /// <summary>
    /// CiMrEleDeDO 的摘要说明。
    /// </summary>
    public class CiMrEleDeDO : BaseDO {

		public const string TABLE_NAME = "CI_MR_ELE_DE";
		public const string TABLE_ALIAS_NAME = "a0";

        public CiMrEleDeDO() {
        }
		public string Id_mrde {
            get { return getAttrVal<string>("Id_mrde",null); }
            set { setAttrVal<string>("Id_mrde", value); }
        }
		public string Name_mrde {
            get { return getAttrVal<string>("Name_mrde",null); }
            set { setAttrVal<string>("Name_mrde", value); }
        }
		public string Id_grp {
            get { return getAttrVal<string>("Id_grp",null); }
            set { setAttrVal<string>("Id_grp", value); }
        }
		public string Id_org {
            get { return getAttrVal<string>("Id_org",null); }
            set { setAttrVal<string>("Id_org", value); }
        }
		public string Id_mrdg {
            get { return getAttrVal<string>("Id_mrdg",null); }
            set { setAttrVal<string>("Id_mrdg", value); }
        }
		public string Id_mrtplde {
            get { return getAttrVal<string>("Id_mrtplde",null); }
            set { setAttrVal<string>("Id_mrtplde", value); }
        }
		public string Id_de {
            get { return getAttrVal<string>("Id_de",null); }
            set { setAttrVal<string>("Id_de", value); }
        }
		public string Id_val {
            get { return getAttrVal<string>("Id_val",null); }
            set { setAttrVal<string>("Id_val", value); }
        }
		public string Val {
            get { return getAttrVal<string>("Val",null); }
            set { setAttrVal<string>("Val", value); }
        }
		public string Val_dsp {
            get { return getAttrVal<string>("Val_dsp",null); }
            set { setAttrVal<string>("Val_dsp", value); }
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
		public string Name_de {
            get { return getAttrVal<string>("Name_de",null); }
            set { setAttrVal<string>("Name_de", value); }
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
            return "CI_MR_ELE_DE";
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
            return "Id_mrde";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.cimrelede.d.CiMrEleDeDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_mrde", "Name_mrde", "Id_grp", "Id_org", "Id_mrdg", "Id_mrtplde", "Id_de", "Id_val", "Val", "Val_dsp", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Name_de"};
        }
        
		/// <summary>
        /// 设置IBDataInfo接口映射数据
        /// </summary>
        /// <returns></returns>
		protected override void setBdDataInfoNameMap() {
			if (base.name_path_map == null)
            {
                base.name_path_map = new Dictionary<string, string>();
				base.name_path_map.Add("id","Id_mrde");
				base.name_path_map.Add("id_org","Id_org");
				base.name_path_map.Add("id_group","Id_grp");
            }
		}
    }
}
