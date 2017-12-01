
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.mr.nu.obstetrics.afterdeliverobsec.d
{
    /// <summary>
    /// AfterDeliveInfoDO 的摘要说明。
    /// </summary>
    public class AfterDeliveInfoDO : BaseDO {

		public const string TABLE_NAME = "CI_MR_NU_AFTDEINFO";
		public const string TABLE_ALIAS_NAME = "a0";

        public AfterDeliveInfoDO() {
        }
		public string Id_aftdeinfo {
            get { return getAttrVal<string>("Id_aftdeinfo",null); }
            set { setAttrVal<string>("Id_aftdeinfo", value); }
        }
		public string Id_org {
            get { return getAttrVal<string>("Id_org",null); }
            set { setAttrVal<string>("Id_org", value); }
        }
		public string Id_grp {
            get { return getAttrVal<string>("Id_grp",null); }
            set { setAttrVal<string>("Id_grp", value); }
        }
		public string Id_pat {
            get { return getAttrVal<string>("Id_pat",null); }
            set { setAttrVal<string>("Id_pat", value); }
        }
		public string Id_ent {
            get { return getAttrVal<string>("Id_ent",null); }
            set { setAttrVal<string>("Id_ent", value); }
        }
		public string Code_entp {
            get { return getAttrVal<string>("Code_entp",null); }
            set { setAttrVal<string>("Code_entp", value); }
        }
		public string Age {
            get { return getAttrVal<string>("Age",null); }
            set { setAttrVal<string>("Age", value); }
        }
		public string Name_bed {
            get { return getAttrVal<string>("Name_bed",null); }
            set { setAttrVal<string>("Name_bed", value); }
        }
		public string Id_dep_nur {
            get { return getAttrVal<string>("Id_dep_nur",null); }
            set { setAttrVal<string>("Id_dep_nur", value); }
        }
		public string Code_amr_ip {
            get { return getAttrVal<string>("Code_amr_ip",null); }
            set { setAttrVal<string>("Code_amr_ip", value); }
        }
		public DateTime? Dt_begin_per {
            get { return getAttrVal<FDateTime>("Dt_begin_per",null); }
            set { setAttrVal<FDateTime>("Dt_begin_per", value); }
        }
		public DateTime? Dt_end_per {
            get { return getAttrVal<FDateTime>("Dt_end_per",null); }
            set { setAttrVal<FDateTime>("Dt_end_per", value); }
        }
		public string Id_papillacond {
            get { return getAttrVal<string>("Id_papillacond",null); }
            set { setAttrVal<string>("Id_papillacond", value); }
        }
		public string Sd_papillacond {
            get { return getAttrVal<string>("Sd_papillacond",null); }
            set { setAttrVal<string>("Sd_papillacond", value); }
        }
		public int? Dt_skintouch {
            get { return getAttrVal<int?>("Dt_skintouch",null); }
            set { setAttrVal<int?>("Dt_skintouch", value); }
        }
		public int? Skintouch_time {
            get { return getAttrVal<int?>("Skintouch_time",null); }
            set { setAttrVal<int?>("Skintouch_time", value); }
        }
		public int? Dt_forage {
            get { return getAttrVal<int?>("Dt_forage",null); }
            set { setAttrVal<int?>("Dt_forage", value); }
        }
		public int? Dt_suck {
            get { return getAttrVal<int?>("Dt_suck",null); }
            set { setAttrVal<int?>("Dt_suck", value); }
        }
		public int? Time_suck {
            get { return getAttrVal<int?>("Time_suck",null); }
            set { setAttrVal<int?>("Time_suck", value); }
        }
		public string Id_suck_cond {
            get { return getAttrVal<string>("Id_suck_cond",null); }
            set { setAttrVal<string>("Id_suck_cond", value); }
        }
		public string Sd_suck_cond {
            get { return getAttrVal<string>("Sd_suck_cond",null); }
            set { setAttrVal<string>("Sd_suck_cond", value); }
        }
		public string Accidentdesc {
            get { return getAttrVal<string>("Accidentdesc",null); }
            set { setAttrVal<string>("Accidentdesc", value); }
        }
		public string Id_sign_psn {
            get { return getAttrVal<string>("Id_sign_psn",null); }
            set { setAttrVal<string>("Id_sign_psn", value); }
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
		public string Name_dep_nur {
            get { return getAttrVal<string>("Name_dep_nur",null); }
            set { setAttrVal<string>("Name_dep_nur", value); }
        }
		public string Name_papillacond {
            get { return getAttrVal<string>("Name_papillacond",null); }
            set { setAttrVal<string>("Name_papillacond", value); }
        }
		public string Name_suck_cond {
            get { return getAttrVal<string>("Name_suck_cond",null); }
            set { setAttrVal<string>("Name_suck_cond", value); }
        }
		public string Name_sign_psn {
            get { return getAttrVal<string>("Name_sign_psn",null); }
            set { setAttrVal<string>("Name_sign_psn", value); }
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
            return "CI_MR_NU_AFTDEINFO";
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
            return "Id_aftdeinfo";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.nu.obstetrics.afterdeliverobsec.d.AfterDeliveInfoDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_aftdeinfo", "Id_org", "Id_grp", "Id_pat", "Id_ent", "Code_entp", "Age", "Name_bed", "Id_dep_nur", "Code_amr_ip", "Dt_begin_per", "Dt_end_per", "Id_papillacond", "Sd_papillacond", "Dt_skintouch", "Skintouch_time", "Dt_forage", "Dt_suck", "Time_suck", "Id_suck_cond", "Sd_suck_cond", "Accidentdesc", "Id_sign_psn", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Name_pat", "Name_dep_nur", "Name_papillacond", "Name_suck_cond", "Name_sign_psn"};
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
