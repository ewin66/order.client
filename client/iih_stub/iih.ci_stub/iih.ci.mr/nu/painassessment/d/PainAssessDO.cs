
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.mr.nu.painassessment.d
{
    /// <summary>
    /// PainAssessDO 的摘要说明。
    /// </summary>
    public class PainAssessDO : BaseDO {

		public const string TABLE_NAME = "CI_MR_NU_PA";
		public const string TABLE_ALIAS_NAME = "a0";

        public PainAssessDO() {
        }
		public string Id_pa {
            get { return getAttrVal<string>("Id_pa",null); }
            set { setAttrVal<string>("Id_pa", value); }
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
		public string Id_pat {
            get { return getAttrVal<string>("Id_pat",null); }
            set { setAttrVal<string>("Id_pat", value); }
        }
		public string Code_entp {
            get { return getAttrVal<string>("Code_entp",null); }
            set { setAttrVal<string>("Code_entp", value); }
        }
		public string Id_sex {
            get { return getAttrVal<string>("Id_sex",null); }
            set { setAttrVal<string>("Id_sex", value); }
        }
		public string Sd_sex {
            get { return getAttrVal<string>("Sd_sex",null); }
            set { setAttrVal<string>("Sd_sex", value); }
        }
		public string Name_bed {
            get { return getAttrVal<string>("Name_bed",null); }
            set { setAttrVal<string>("Name_bed", value); }
        }
		public string Code_amr_ip {
            get { return getAttrVal<string>("Code_amr_ip",null); }
            set { setAttrVal<string>("Code_amr_ip", value); }
        }
		public string Id_dep_phy {
            get { return getAttrVal<string>("Id_dep_phy",null); }
            set { setAttrVal<string>("Id_dep_phy", value); }
        }
		public string Age {
            get { return getAttrVal<string>("Age",null); }
            set { setAttrVal<string>("Age", value); }
        }
		public DateTime? Dt_entry {
            get { return getAttrVal<FDate>("Dt_entry",null); }
            set { setAttrVal<FDate>("Dt_entry", value); }
        }
		public string Name_diagnosis {
            get { return getAttrVal<string>("Name_diagnosis",null); }
            set { setAttrVal<string>("Name_diagnosis", value); }
        }
		public DateTime? Dt_oper {
            get { return getAttrVal<FDate>("Dt_oper",null); }
            set { setAttrVal<FDate>("Dt_oper", value); }
        }
		public string Name_oper {
            get { return getAttrVal<string>("Name_oper",null); }
            set { setAttrVal<string>("Name_oper", value); }
        }
		public DateTime? Dt_backroom {
            get { return getAttrVal<FDateTime>("Dt_backroom",null); }
            set { setAttrVal<FDateTime>("Dt_backroom", value); }
        }
		public int? Fg_analgesia {
            get { return getAttrVal<int?>("Fg_analgesia",null); }
            set { setAttrVal<int?>("Fg_analgesia", value); }
        }
		public DateTime? Begin_analgesia {
            get { return getAttrVal<FDateTime>("Begin_analgesia",null); }
            set { setAttrVal<FDateTime>("Begin_analgesia", value); }
        }
		public DateTime? End_analgesia {
            get { return getAttrVal<FDateTime>("End_analgesia",null); }
            set { setAttrVal<FDateTime>("End_analgesia", value); }
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
		public string Name_sex {
            get { return getAttrVal<string>("Name_sex",null); }
            set { setAttrVal<string>("Name_sex", value); }
        }
		public string Name_dep_phy {
            get { return getAttrVal<string>("Name_dep_phy",null); }
            set { setAttrVal<string>("Name_dep_phy", value); }
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
            return "CI_MR_NU_PA";
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
            return "Id_pa";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.nu.painassessment.d.PainAssessDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_pa", "Id_grp", "Id_org", "Id_ent", "Id_pat", "Code_entp", "Id_sex", "Sd_sex", "Name_bed", "Code_amr_ip", "Id_dep_phy", "Age", "Dt_entry", "Name_diagnosis", "Dt_oper", "Name_oper", "Dt_backroom", "Fg_analgesia", "Begin_analgesia", "End_analgesia", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Name_pat", "Name_sex", "Name_dep_phy"};
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
