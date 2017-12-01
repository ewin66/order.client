
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.mr.nu.falleval.d
{
    /// <summary>
    /// FallEvalDO 的摘要说明。
    /// </summary>
    public class FallEvalDO : BaseDO {

		public const string TABLE_NAME = "CI_MR_NU_MORSE";
		public const string TABLE_ALIAS_NAME = "a0";

        public FallEvalDO() {
        }
		public string Id_fe {
            get { return getAttrVal<string>("Id_fe",null); }
            set { setAttrVal<string>("Id_fe", value); }
        }
		public string Id_pat {
            get { return getAttrVal<string>("Id_pat",null); }
            set { setAttrVal<string>("Id_pat", value); }
        }
		public string Id_ent {
            get { return getAttrVal<string>("Id_ent",null); }
            set { setAttrVal<string>("Id_ent", value); }
        }
		public string Id_dep_phy {
            get { return getAttrVal<string>("Id_dep_phy",null); }
            set { setAttrVal<string>("Id_dep_phy", value); }
        }
		public string Id_grp {
            get { return getAttrVal<string>("Id_grp",null); }
            set { setAttrVal<string>("Id_grp", value); }
        }
		public string Id_org {
            get { return getAttrVal<string>("Id_org",null); }
            set { setAttrVal<string>("Id_org", value); }
        }
		public string Id_sex {
            get { return getAttrVal<string>("Id_sex",null); }
            set { setAttrVal<string>("Id_sex", value); }
        }
		public string Sd_sex {
            get { return getAttrVal<string>("Sd_sex",null); }
            set { setAttrVal<string>("Sd_sex", value); }
        }
		public string Age {
            get { return getAttrVal<string>("Age",null); }
            set { setAttrVal<string>("Age", value); }
        }
		public string Name_bed {
            get { return getAttrVal<string>("Name_bed",null); }
            set { setAttrVal<string>("Name_bed", value); }
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
		public string Id_hisoffall {
            get { return getAttrVal<string>("Id_hisoffall",null); }
            set { setAttrVal<string>("Id_hisoffall", value); }
        }
		public string Sd_hisoffall {
            get { return getAttrVal<string>("Sd_hisoffall",null); }
            set { setAttrVal<string>("Sd_hisoffall", value); }
        }
		public string Score_hisoffall {
            get { return getAttrVal<string>("Score_hisoffall",null); }
            set { setAttrVal<string>("Score_hisoffall", value); }
        }
		public string Id_overadiagn {
            get { return getAttrVal<string>("Id_overadiagn",null); }
            set { setAttrVal<string>("Id_overadiagn", value); }
        }
		public string Sd_overadiagn {
            get { return getAttrVal<string>("Sd_overadiagn",null); }
            set { setAttrVal<string>("Sd_overadiagn", value); }
        }
		public string Score_overadiagn {
            get { return getAttrVal<string>("Score_overadiagn",null); }
            set { setAttrVal<string>("Score_overadiagn", value); }
        }
		public string Id_walkaux {
            get { return getAttrVal<string>("Id_walkaux",null); }
            set { setAttrVal<string>("Id_walkaux", value); }
        }
		public string Sd_walkaux {
            get { return getAttrVal<string>("Sd_walkaux",null); }
            set { setAttrVal<string>("Sd_walkaux", value); }
        }
		public string Score_walkaux {
            get { return getAttrVal<string>("Score_walkaux",null); }
            set { setAttrVal<string>("Score_walkaux", value); }
        }
		public string Id_ventransfus {
            get { return getAttrVal<string>("Id_ventransfus",null); }
            set { setAttrVal<string>("Id_ventransfus", value); }
        }
		public string Sd_ventransfus {
            get { return getAttrVal<string>("Sd_ventransfus",null); }
            set { setAttrVal<string>("Sd_ventransfus", value); }
        }
		public string Score_ventransfus {
            get { return getAttrVal<string>("Score_ventransfus",null); }
            set { setAttrVal<string>("Score_ventransfus", value); }
        }
		public string Id_gait_state {
            get { return getAttrVal<string>("Id_gait_state",null); }
            set { setAttrVal<string>("Id_gait_state", value); }
        }
		public string Sd_gait_state {
            get { return getAttrVal<string>("Sd_gait_state",null); }
            set { setAttrVal<string>("Sd_gait_state", value); }
        }
		public string Score_gait_state {
            get { return getAttrVal<string>("Score_gait_state",null); }
            set { setAttrVal<string>("Score_gait_state", value); }
        }
		public string Id_cognitive_state {
            get { return getAttrVal<string>("Id_cognitive_state",null); }
            set { setAttrVal<string>("Id_cognitive_state", value); }
        }
		public string Sd_cognitive_state {
            get { return getAttrVal<string>("Sd_cognitive_state",null); }
            set { setAttrVal<string>("Sd_cognitive_state", value); }
        }
		public string Score_cognitive_state {
            get { return getAttrVal<string>("Score_cognitive_state",null); }
            set { setAttrVal<string>("Score_cognitive_state", value); }
        }
		public int? Total {
            get { return getAttrVal<int?>("Total",null); }
            set { setAttrVal<int?>("Total", value); }
        }
		public string Assresult {
            get { return getAttrVal<string>("Assresult",null); }
            set { setAttrVal<string>("Assresult", value); }
        }
		public DateTime? Dt_ass {
            get { return getAttrVal<FDateTime>("Dt_ass",null); }
            set { setAttrVal<FDateTime>("Dt_ass", value); }
        }
		public string Id_nur_psn {
            get { return getAttrVal<string>("Id_nur_psn",null); }
            set { setAttrVal<string>("Id_nur_psn", value); }
        }
		public string Id_hdnur_room {
            get { return getAttrVal<string>("Id_hdnur_room",null); }
            set { setAttrVal<string>("Id_hdnur_room", value); }
        }
		public string Ralation {
            get { return getAttrVal<string>("Ralation",null); }
            set { setAttrVal<string>("Ralation", value); }
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
		public string Name_sex {
            get { return getAttrVal<string>("Name_sex",null); }
            set { setAttrVal<string>("Name_sex", value); }
        }
		public string Name_hisoffall {
            get { return getAttrVal<string>("Name_hisoffall",null); }
            set { setAttrVal<string>("Name_hisoffall", value); }
        }
		public string Name_overadiagn {
            get { return getAttrVal<string>("Name_overadiagn",null); }
            set { setAttrVal<string>("Name_overadiagn", value); }
        }
		public string Name_walkaux {
            get { return getAttrVal<string>("Name_walkaux",null); }
            set { setAttrVal<string>("Name_walkaux", value); }
        }
		public string Name_ventransfus {
            get { return getAttrVal<string>("Name_ventransfus",null); }
            set { setAttrVal<string>("Name_ventransfus", value); }
        }
		public string Name_gait_state {
            get { return getAttrVal<string>("Name_gait_state",null); }
            set { setAttrVal<string>("Name_gait_state", value); }
        }
		public string Name_cognitive_state {
            get { return getAttrVal<string>("Name_cognitive_state",null); }
            set { setAttrVal<string>("Name_cognitive_state", value); }
        }
		public string Name_nur_psn {
            get { return getAttrVal<string>("Name_nur_psn",null); }
            set { setAttrVal<string>("Name_nur_psn", value); }
        }
		public string Name_hdnur_room {
            get { return getAttrVal<string>("Name_hdnur_room",null); }
            set { setAttrVal<string>("Name_hdnur_room", value); }
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
            return "CI_MR_NU_MORSE";
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
            return "Id_fe";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.nu.falleval.d.FallEvalDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_fe", "Id_pat", "Id_ent", "Id_dep_phy", "Id_grp", "Id_org", "Id_sex", "Sd_sex", "Age", "Name_bed", "Code_amr_ip", "Dt_entry", "Name_diagnosis", "Id_hisoffall", "Sd_hisoffall", "Score_hisoffall", "Id_overadiagn", "Sd_overadiagn", "Score_overadiagn", "Id_walkaux", "Sd_walkaux", "Score_walkaux", "Id_ventransfus", "Sd_ventransfus", "Score_ventransfus", "Id_gait_state", "Sd_gait_state", "Score_gait_state", "Id_cognitive_state", "Sd_cognitive_state", "Score_cognitive_state", "Total", "Assresult", "Dt_ass", "Id_nur_psn", "Id_hdnur_room", "Ralation", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Name_pat", "Name_dep_phy", "Name_sex", "Name_hisoffall", "Name_overadiagn", "Name_walkaux", "Name_ventransfus", "Name_gait_state", "Name_cognitive_state", "Name_nur_psn", "Name_hdnur_room"};
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
