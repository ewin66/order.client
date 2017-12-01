
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.mr.nu.obstetrics.birthrec.d
{
    /// <summary>
    /// BirthrecInfoDO 的摘要说明。
    /// </summary>
    public class BirthrecInfoDO : BaseDO {

		public const string TABLE_NAME = "CI_MR_NU_BIRTHINFO";
		public const string TABLE_ALIAS_NAME = "a0";

        public BirthrecInfoDO() {
        }
		public string Id_birthinfo {
            get { return getAttrVal<string>("Id_birthinfo",null); }
            set { setAttrVal<string>("Id_birthinfo", value); }
        }
		public string Id_ent {
            get { return getAttrVal<string>("Id_ent",null); }
            set { setAttrVal<string>("Id_ent", value); }
        }
		public string Id_pat {
            get { return getAttrVal<string>("Id_pat",null); }
            set { setAttrVal<string>("Id_pat", value); }
        }
		public string Code_entp {
            get { return getAttrVal<string>("Code_entp",null); }
            set { setAttrVal<string>("Code_entp", value); }
        }
		public string Id_org {
            get { return getAttrVal<string>("Id_org",null); }
            set { setAttrVal<string>("Id_org", value); }
        }
		public string Id_grp {
            get { return getAttrVal<string>("Id_grp",null); }
            set { setAttrVal<string>("Id_grp", value); }
        }
		public string Xm {
            get { return getAttrVal<string>("Xm",null); }
            set { setAttrVal<string>("Xm", value); }
        }
		public string Nl {
            get { return getAttrVal<string>("Nl",null); }
            set { setAttrVal<string>("Nl", value); }
        }
		public string Bq {
            get { return getAttrVal<string>("Bq",null); }
            set { setAttrVal<string>("Bq", value); }
        }
		public string Ch {
            get { return getAttrVal<string>("Ch",null); }
            set { setAttrVal<string>("Ch", value); }
        }
		public string Zyh {
            get { return getAttrVal<string>("Zyh",null); }
            set { setAttrVal<string>("Zyh", value); }
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
            return "CI_MR_NU_BIRTHINFO";
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
            return "Id_birthinfo";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.nu.obstetrics.birthrec.d.BirthrecInfoDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_birthinfo", "Id_ent", "Id_pat", "Code_entp", "Id_org", "Id_grp", "Xm", "Nl", "Bq", "Ch", "Zyh", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime"};
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
