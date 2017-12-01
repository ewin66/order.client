
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.mr.cimrrs.d
{
    /// <summary>
    /// CiMrRsDO 的摘要说明。
    /// </summary>
    public class CiMrRsDO : BaseDO {

        public CiMrRsDO() {
        }
		public string Id_mrrs {
            get { return getAttrVal<string>("Id_mrrs",null); }
            set { setAttrVal<string>("Id_mrrs", value); }
        }
		public string Id_grp {
            get { return getAttrVal<string>("Id_grp",null); }
            set { setAttrVal<string>("Id_grp", value); }
        }
		public string Id_org {
            get { return getAttrVal<string>("Id_org",null); }
            set { setAttrVal<string>("Id_org", value); }
        }
		public string Id_ent {
            get { return getAttrVal<string>("Id_ent",null); }
            set { setAttrVal<string>("Id_ent", value); }
        }
		public bool? Fg_rs {
            get { return getAttrVal<FBoolean>("Fg_rs",null); }
            set { setAttrVal<FBoolean>("Fg_rs", value); }
        }
		public DateTime? Rs_start_time {
            get { return getAttrVal<FDateTime>("Rs_start_time",null); }
            set { setAttrVal<FDateTime>("Rs_start_time", value); }
        }
		public DateTime? Rs_end_time {
            get { return getAttrVal<FDateTime>("Rs_end_time",null); }
            set { setAttrVal<FDateTime>("Rs_end_time", value); }
        }
		public string Sc_pat {
            get { return getAttrVal<string>("Sc_pat",null); }
            set { setAttrVal<string>("Sc_pat", value); }
        }
		public string Sc_hos {
            get { return getAttrVal<string>("Sc_hos",null); }
            set { setAttrVal<string>("Sc_hos", value); }
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
            return "ci_mr_rs";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_mrrs";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.cimrrs.d.CiMrRsDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_mrrs", "Id_grp", "Id_org", "Id_ent", "Fg_rs", "Rs_start_time", "Rs_end_time", "Sc_pat", "Sc_hos", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Grp_code", "Grp_name", "Org_code", "Org_name"};
        }
        
		/// <summary>
        /// 设置IBDataInfo接口映射数据
        /// </summary>
        /// <returns></returns>
		protected override void setBdDataInfoNameMap() {
			if (base.name_path_map == null)
            {
                base.name_path_map = new Dictionary<string, string>();
				base.name_path_map.Add("createdby","Createdby");
				base.name_path_map.Add("createdtime","Createdtime");
				base.name_path_map.Add("modifiedby","Modifiedby");
				base.name_path_map.Add("modifiedtime","Modifiedtime");
            }
		}
    }
}
