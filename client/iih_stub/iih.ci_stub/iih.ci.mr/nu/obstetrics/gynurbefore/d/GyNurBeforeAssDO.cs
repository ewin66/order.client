
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.mr.nu.obstetrics.gynurbefore.d
{
    /// <summary>
    /// GyNurBeforeAssDO 的摘要说明。
    /// </summary>
    public class GyNurBeforeAssDO : BaseDO {

		public const string TABLE_NAME = "CI_MR_NU_GYBEFOREASS";
		public const string TABLE_ALIAS_NAME = "a0";

        public GyNurBeforeAssDO() {
        }
		public string Id_ass {
            get { return getAttrVal<string>("Id_ass",null); }
            set { setAttrVal<string>("Id_ass", value); }
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
		public string Id_dep_phy {
            get { return getAttrVal<string>("Id_dep_phy",null); }
            set { setAttrVal<string>("Id_dep_phy", value); }
        }
		public string Name_bed {
            get { return getAttrVal<string>("Name_bed",null); }
            set { setAttrVal<string>("Name_bed", value); }
        }
		public string Age {
            get { return getAttrVal<string>("Age",null); }
            set { setAttrVal<string>("Age", value); }
        }
		public string Code_amr_ip {
            get { return getAttrVal<string>("Code_amr_ip",null); }
            set { setAttrVal<string>("Code_amr_ip", value); }
        }
		public DateTime? Dt_entry {
            get { return getAttrVal<FDateTime>("Dt_entry",null); }
            set { setAttrVal<FDateTime>("Dt_entry", value); }
        }
		public string Name_diagnosis {
            get { return getAttrVal<string>("Name_diagnosis",null); }
            set { setAttrVal<string>("Name_diagnosis", value); }
        }
		public string Id_ryfs {
            get { return getAttrVal<string>("Id_ryfs",null); }
            set { setAttrVal<string>("Id_ryfs", value); }
        }
		public string Sd_ryfs {
            get { return getAttrVal<string>("Sd_ryfs",null); }
            set { setAttrVal<string>("Sd_ryfs", value); }
        }
		public string Name_allergy {
            get { return getAttrVal<string>("Name_allergy",null); }
            set { setAttrVal<string>("Name_allergy", value); }
        }
		public int? Eu_ggqk {
            get { return getAttrVal<int?>("Eu_ggqk",null); }
            set { setAttrVal<int?>("Eu_ggqk", value); }
        }
		public string Id_hbeag {
            get { return getAttrVal<string>("Id_hbeag",null); }
            set { setAttrVal<string>("Id_hbeag", value); }
        }
		public string Sd_hbeag {
            get { return getAttrVal<string>("Sd_hbeag",null); }
            set { setAttrVal<string>("Sd_hbeag", value); }
        }
		public string Id_hbsag {
            get { return getAttrVal<string>("Id_hbsag",null); }
            set { setAttrVal<string>("Id_hbsag", value); }
        }
		public string Sd_hbsag {
            get { return getAttrVal<string>("Sd_hbsag",null); }
            set { setAttrVal<string>("Sd_hbsag", value); }
        }
		public string Id_khbc {
            get { return getAttrVal<string>("Id_khbc",null); }
            set { setAttrVal<string>("Id_khbc", value); }
        }
		public string Sd_khbc {
            get { return getAttrVal<string>("Sd_khbc",null); }
            set { setAttrVal<string>("Sd_khbc", value); }
        }
		public string Id_khiv {
            get { return getAttrVal<string>("Id_khiv",null); }
            set { setAttrVal<string>("Id_khiv", value); }
        }
		public string Sd_khiv {
            get { return getAttrVal<string>("Sd_khiv",null); }
            set { setAttrVal<string>("Sd_khiv", value); }
        }
		public string Id_khcv {
            get { return getAttrVal<string>("Id_khcv",null); }
            set { setAttrVal<string>("Id_khcv", value); }
        }
		public string Sd_khcv {
            get { return getAttrVal<string>("Sd_khcv",null); }
            set { setAttrVal<string>("Sd_khcv", value); }
        }
		public string Id_hljb {
            get { return getAttrVal<string>("Id_hljb",null); }
            set { setAttrVal<string>("Id_hljb", value); }
        }
		public string Sd_hljb {
            get { return getAttrVal<string>("Sd_hljb",null); }
            set { setAttrVal<string>("Sd_hljb", value); }
        }
		public string Id_hd {
            get { return getAttrVal<string>("Id_hd",null); }
            set { setAttrVal<string>("Id_hd", value); }
        }
		public string Sd_hd {
            get { return getAttrVal<string>("Sd_hd",null); }
            set { setAttrVal<string>("Sd_hd", value); }
        }
		public string Jypgqm {
            get { return getAttrVal<string>("Jypgqm",null); }
            set { setAttrVal<string>("Jypgqm", value); }
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
		public string Name_pat {
            get { return getAttrVal<string>("Name_pat",null); }
            set { setAttrVal<string>("Name_pat", value); }
        }
		public string Name_dep_phy {
            get { return getAttrVal<string>("Name_dep_phy",null); }
            set { setAttrVal<string>("Name_dep_phy", value); }
        }
		public string Name_ryfs {
            get { return getAttrVal<string>("Name_ryfs",null); }
            set { setAttrVal<string>("Name_ryfs", value); }
        }
		public string Name_hbceg {
            get { return getAttrVal<string>("Name_hbceg",null); }
            set { setAttrVal<string>("Name_hbceg", value); }
        }
		public string Name_hbsag {
            get { return getAttrVal<string>("Name_hbsag",null); }
            set { setAttrVal<string>("Name_hbsag", value); }
        }
		public string Name_khbc {
            get { return getAttrVal<string>("Name_khbc",null); }
            set { setAttrVal<string>("Name_khbc", value); }
        }
		public string Name_khiv {
            get { return getAttrVal<string>("Name_khiv",null); }
            set { setAttrVal<string>("Name_khiv", value); }
        }
		public string Name_khcv {
            get { return getAttrVal<string>("Name_khcv",null); }
            set { setAttrVal<string>("Name_khcv", value); }
        }
		public string Name_hljb {
            get { return getAttrVal<string>("Name_hljb",null); }
            set { setAttrVal<string>("Name_hljb", value); }
        }
		public string Name_hd {
            get { return getAttrVal<string>("Name_hd",null); }
            set { setAttrVal<string>("Name_hd", value); }
        }
		public string Name_psndoc {
            get { return getAttrVal<string>("Name_psndoc",null); }
            set { setAttrVal<string>("Name_psndoc", value); }
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
            return "CI_MR_NU_GYBEFOREASS";
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
            return "Id_ass";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.nu.obstetrics.gynurbefore.d.GyNurBeforeAssDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_ass", "Id_ent", "Id_pat", "Code_entp", "Id_org", "Id_grp", "Id_dep_phy", "Name_bed", "Age", "Code_amr_ip", "Dt_entry", "Name_diagnosis", "Id_ryfs", "Sd_ryfs", "Name_allergy", "Eu_ggqk", "Id_hbeag", "Sd_hbeag", "Id_hbsag", "Sd_hbsag", "Id_khbc", "Sd_khbc", "Id_khiv", "Sd_khiv", "Id_khcv", "Sd_khcv", "Id_hljb", "Sd_hljb", "Id_hd", "Sd_hd", "Jypgqm", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Name_pat", "Name_dep_phy", "Name_ryfs", "Name_hbceg", "Name_hbsag", "Name_khbc", "Name_khiv", "Name_khcv", "Name_hljb", "Name_hd", "Name_psndoc"};
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
