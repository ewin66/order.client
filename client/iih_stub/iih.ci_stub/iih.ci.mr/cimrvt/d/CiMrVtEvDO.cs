
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.mr.cimrvt.d
{
    /// <summary>
    /// CiMrVtEvDO 的摘要说明。
    /// </summary>
    public class CiMrVtEvDO : BaseDO {

		public const string TABLE_NAME = "ci_mr_vt_ev";
		public const string TABLE_ALIAS_NAME = "a2";

        public CiMrVtEvDO() {
        }
		public string Id_mrvtev {
            get { return getAttrVal<string>("Id_mrvtev",null); }
            set { setAttrVal<string>("Id_mrvtev", value); }
        }
		public string Id_org {
            get { return getAttrVal<string>("Id_org",null); }
            set { setAttrVal<string>("Id_org", value); }
        }
		public string Id_grp {
            get { return getAttrVal<string>("Id_grp",null); }
            set { setAttrVal<string>("Id_grp", value); }
        }
		public string Id_mrvt {
            get { return getAttrVal<string>("Id_mrvt",null); }
            set { setAttrVal<string>("Id_mrvt", value); }
        }
		public int? Sortno {
            get { return getAttrVal<int?>("Sortno",null); }
            set { setAttrVal<int?>("Sortno", value); }
        }
		public string Id_vt_ev {
            get { return getAttrVal<string>("Id_vt_ev",null); }
            set { setAttrVal<string>("Id_vt_ev", value); }
        }
		public string Sd_vt_ev {
            get { return getAttrVal<string>("Sd_vt_ev",null); }
            set { setAttrVal<string>("Sd_vt_ev", value); }
        }
		public string Name_vt_ev {
            get { return getAttrVal<string>("Name_vt_ev",null); }
            set { setAttrVal<string>("Name_vt_ev", value); }
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
            return "ci_mr_vt_ev";
        }
        
        /// <summary>
        /// 返回表别名
        /// </summary>
        /// <returns></returns>
        public override string getAliasTableName()
        {
            return "a2";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_mrvtev";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.cimrvt.d.CiMrVtEvDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_mrvtev", "Id_org", "Id_grp", "Id_mrvt", "Sortno", "Id_vt_ev", "Sd_vt_ev", "Name_vt_ev"};
        }
        
		/// <summary>
        /// 设置IBDataInfo接口映射数据
        /// </summary>
        /// <returns></returns>
		protected override void setBdDataInfoNameMap() {
			if (base.name_path_map == null)
            {
                base.name_path_map = new Dictionary<string, string>();
				base.name_path_map.Add("id_org","Id_org");
				base.name_path_map.Add("id_group","Id_grp");
            }
		}
    }
}
