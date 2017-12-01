
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.mr.nu.newbabypicc.d
{
    /// <summary>
    /// NewBabyPiccDO 的摘要说明。
    /// </summary>
    public class NewBabyPiccDO : BaseDO {

		public const string TABLE_NAME = "ci_mr_nu_picc";
		public const string TABLE_ALIAS_NAME = "a0";

        public NewBabyPiccDO() {
        }
		public string Id_picc {
            get { return getAttrVal<string>("Id_picc",null); }
            set { setAttrVal<string>("Id_picc", value); }
        }
		public string Id_pat {
            get { return getAttrVal<string>("Id_pat",null); }
            set { setAttrVal<string>("Id_pat", value); }
        }
		public string Code_entp {
            get { return getAttrVal<string>("Code_entp",null); }
            set { setAttrVal<string>("Code_entp", value); }
        }
		public string Id_ent {
            get { return getAttrVal<string>("Id_ent",null); }
            set { setAttrVal<string>("Id_ent", value); }
        }
		public string Name_bed {
            get { return getAttrVal<string>("Name_bed",null); }
            set { setAttrVal<string>("Name_bed", value); }
        }
		public string Code_amr_ip {
            get { return getAttrVal<string>("Code_amr_ip",null); }
            set { setAttrVal<string>("Code_amr_ip", value); }
        }
		public string Operator {
            get { return getAttrVal<string>("Operator",null); }
            set { setAttrVal<string>("Operator", value); }
        }
		public DateTime? Dt_puncture {
            get { return getAttrVal<FDate>("Dt_puncture",null); }
            set { setAttrVal<FDate>("Dt_puncture", value); }
        }
		public string Cathetertype {
            get { return getAttrVal<string>("Cathetertype",null); }
            set { setAttrVal<string>("Cathetertype", value); }
        }
		public string Id_puncture_site {
            get { return getAttrVal<string>("Id_puncture_site",null); }
            set { setAttrVal<string>("Id_puncture_site", value); }
        }
		public string Sd_puncture_site {
            get { return getAttrVal<string>("Sd_puncture_site",null); }
            set { setAttrVal<string>("Sd_puncture_site", value); }
        }
		public int? Catheterlength {
            get { return getAttrVal<int?>("Catheterlength",null); }
            set { setAttrVal<int?>("Catheterlength", value); }
        }
		public string Chestradiograph {
            get { return getAttrVal<string>("Chestradiograph",null); }
            set { setAttrVal<string>("Chestradiograph", value); }
        }
		public DateTime? Dt_extubation {
            get { return getAttrVal<FDate>("Dt_extubation",null); }
            set { setAttrVal<FDate>("Dt_extubation", value); }
        }
		public string Id_result_culture {
            get { return getAttrVal<string>("Id_result_culture",null); }
            set { setAttrVal<string>("Id_result_culture", value); }
        }
		public string Sd_result_culture {
            get { return getAttrVal<string>("Sd_result_culture",null); }
            set { setAttrVal<string>("Sd_result_culture", value); }
        }
		public DateTime? Createdtime {
            get { return getAttrVal<FDateTime>("Createdtime",null); }
            set { setAttrVal<FDateTime>("Createdtime", value); }
        }
		public DateTime? Modifiedtime {
            get { return getAttrVal<FDateTime>("Modifiedtime",null); }
            set { setAttrVal<FDateTime>("Modifiedtime", value); }
        }
		public string Modifiedby {
            get { return getAttrVal<string>("Modifiedby",null); }
            set { setAttrVal<string>("Modifiedby", value); }
        }
		public string Createdby {
            get { return getAttrVal<string>("Createdby",null); }
            set { setAttrVal<string>("Createdby", value); }
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
		public string Name_operator {
            get { return getAttrVal<string>("Name_operator",null); }
            set { setAttrVal<string>("Name_operator", value); }
        }
		public string Name_puncture_site {
            get { return getAttrVal<string>("Name_puncture_site",null); }
            set { setAttrVal<string>("Name_puncture_site", value); }
        }
		public string Name_result_culture {
            get { return getAttrVal<string>("Name_result_culture",null); }
            set { setAttrVal<string>("Name_result_culture", value); }
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
            return "ci_mr_nu_picc";
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
            return "Id_picc";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.nu.newbabypicc.d.NewBabyPiccDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_picc", "Id_pat", "Code_entp", "Id_ent", "Name_bed", "Code_amr_ip", "Operator", "Dt_puncture", "Cathetertype", "Id_puncture_site", "Sd_puncture_site", "Catheterlength", "Chestradiograph", "Dt_extubation", "Id_result_culture", "Sd_result_culture", "Createdtime", "Modifiedtime", "Modifiedby", "Createdby", "Id_grp", "Id_org", "Name_pat", "Name_operator", "Name_puncture_site", "Name_result_culture"};
        }
        
		/// <summary>
        /// 设置IBDataInfo接口映射数据
        /// </summary>
        /// <returns></returns>
		protected override void setBdDataInfoNameMap() {
			if (base.name_path_map == null)
            {
                base.name_path_map = new Dictionary<string, string>();
				base.name_path_map.Add("id","Id_picc");
				base.name_path_map.Add("id_org","Id_org");
				base.name_path_map.Add("id_group","Id_grp");
            }
		}
    }
}
