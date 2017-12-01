
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.mr.nu.newbornveinnur.d
{
    /// <summary>
    /// NewBornVeinNurDO 的摘要说明。
    /// </summary>
    public class NewBornVeinNurDO : BaseDO {

		public const string TABLE_NAME = "ci_mr_nu_nbvn";
		public const string TABLE_ALIAS_NAME = "a0";

        public NewBornVeinNurDO() {
        }
		public string Id_nbvn {
            get { return getAttrVal<string>("Id_nbvn",null); }
            set { setAttrVal<string>("Id_nbvn", value); }
        }
		public string Id_ent {
            get { return getAttrVal<string>("Id_ent",null); }
            set { setAttrVal<string>("Id_ent", value); }
        }
		public string Id_pat {
            get { return getAttrVal<string>("Id_pat",null); }
            set { setAttrVal<string>("Id_pat", value); }
        }
		public string Name_bed {
            get { return getAttrVal<string>("Name_bed",null); }
            set { setAttrVal<string>("Name_bed", value); }
        }
		public string Code_entp {
            get { return getAttrVal<string>("Code_entp",null); }
            set { setAttrVal<string>("Code_entp", value); }
        }
		public string Code_amr_ip {
            get { return getAttrVal<string>("Code_amr_ip",null); }
            set { setAttrVal<string>("Code_amr_ip", value); }
        }
		public string Id_operator {
            get { return getAttrVal<string>("Id_operator",null); }
            set { setAttrVal<string>("Id_operator", value); }
        }
		public string Cathetertype {
            get { return getAttrVal<string>("Cathetertype",null); }
            set { setAttrVal<string>("Cathetertype", value); }
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
		public DateTime? Dt_puncture {
            get { return getAttrVal<FDate>("Dt_puncture",null); }
            set { setAttrVal<FDate>("Dt_puncture", value); }
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
            return "ci_mr_nu_nbvn";
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
            return "Id_nbvn";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.nu.newbornveinnur.d.NewBornVeinNurDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_nbvn", "Id_ent", "Id_pat", "Name_bed", "Code_entp", "Code_amr_ip", "Id_operator", "Cathetertype", "Catheterlength", "Chestradiograph", "Dt_extubation", "Id_result_culture", "Sd_result_culture", "Dt_puncture", "Createdtime", "Modifiedtime", "Modifiedby", "Createdby", "Id_grp", "Id_org", "Name_pat", "Name_operator", "Name_result_culture"};
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
