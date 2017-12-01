
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.mr.nu.chidrenass.d
{
    /// <summary>
    /// ChildrenInAsseDO 的摘要说明。
    /// </summary>
    public class ChildrenInAsseDO : BaseDO {

		public const string TABLE_NAME = "CI_MR_NU_CHASS";
		public const string TABLE_ALIAS_NAME = "a0";

        public ChildrenInAsseDO() {
        }
		public string Id_chass {
            get { return getAttrVal<string>("Id_chass",null); }
            set { setAttrVal<string>("Id_chass", value); }
        }
		public string Name_bed {
            get { return getAttrVal<string>("Name_bed",null); }
            set { setAttrVal<string>("Name_bed", value); }
        }
		public string Code_amr_ip {
            get { return getAttrVal<string>("Code_amr_ip",null); }
            set { setAttrVal<string>("Code_amr_ip", value); }
        }
		public string Id_ent {
            get { return getAttrVal<string>("Id_ent",null); }
            set { setAttrVal<string>("Id_ent", value); }
        }
		public string Code_entp {
            get { return getAttrVal<string>("Code_entp",null); }
            set { setAttrVal<string>("Code_entp", value); }
        }
		public string Parent_sign {
            get { return getAttrVal<string>("Parent_sign",null); }
            set { setAttrVal<string>("Parent_sign", value); }
        }
		public string Rszdjyy {
            get { return getAttrVal<string>("Rszdjyy",null); }
            set { setAttrVal<string>("Rszdjyy", value); }
        }
		public string Ms {
            get { return getAttrVal<string>("Ms",null); }
            set { setAttrVal<string>("Ms", value); }
        }
		public string Age {
            get { return getAttrVal<string>("Age",null); }
            set { setAttrVal<string>("Age", value); }
        }
		public int? Weight {
            get { return getAttrVal<int?>("Weight",null); }
            set { setAttrVal<int?>("Weight", value); }
        }
		public int? Yzw {
            get { return getAttrVal<int?>("Yzw",null); }
            set { setAttrVal<int?>("Yzw", value); }
        }
		public int? Aspf1fzf {
            get { return getAttrVal<int?>("Aspf1fzf",null); }
            set { setAttrVal<int?>("Aspf1fzf", value); }
        }
		public int? Aspf5fzf {
            get { return getAttrVal<int?>("Aspf5fzf",null); }
            set { setAttrVal<int?>("Aspf5fzf", value); }
        }
		public string Id_delivery_mode {
            get { return getAttrVal<string>("Id_delivery_mode",null); }
            set { setAttrVal<string>("Id_delivery_mode", value); }
        }
		public string Sd_delivery_mode {
            get { return getAttrVal<string>("Sd_delivery_mode",null); }
            set { setAttrVal<string>("Sd_delivery_mode", value); }
        }
		public int? Eu_pfqk {
            get { return getAttrVal<int?>("Eu_pfqk",null); }
            set { setAttrVal<int?>("Eu_pfqk", value); }
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
		public string Id_grp {
            get { return getAttrVal<string>("Id_grp",null); }
            set { setAttrVal<string>("Id_grp", value); }
        }
		public string Id_org {
            get { return getAttrVal<string>("Id_org",null); }
            set { setAttrVal<string>("Id_org", value); }
        }
		public string Name_pat {
            get { return getAttrVal<string>("Name_pat",null); }
            set { setAttrVal<string>("Name_pat", value); }
        }
		public string Id_pat {
            get { return getAttrVal<string>("Id_pat",null); }
            set { setAttrVal<string>("Id_pat", value); }
        }
		public DateTime? Dt_birth {
            get { return getAttrVal<FDate>("Dt_birth",null); }
            set { setAttrVal<FDate>("Dt_birth", value); }
        }
		public string Name_delivery_mode {
            get { return getAttrVal<string>("Name_delivery_mode",null); }
            set { setAttrVal<string>("Name_delivery_mode", value); }
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
            return "CI_MR_NU_CHASS";
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
            return "Id_chass";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.nu.chidrenass.d.ChildrenInAsseDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_chass", "Name_bed", "Code_amr_ip", "Id_ent", "Code_entp", "Parent_sign", "Rszdjyy", "Ms", "Age", "Weight", "Yzw", "Aspf1fzf", "Aspf5fzf", "Id_delivery_mode", "Sd_delivery_mode", "Eu_pfqk", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Id_grp", "Id_org", "Name_pat", "Id_pat", "Dt_birth", "Name_delivery_mode"};
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
