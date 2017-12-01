
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.mr.nu.obstetrics.gynurafter.d
{
    /// <summary>
    /// GyNurAfterAssDO 的摘要说明。
    /// </summary>
    public class GyNurAfterAssDO : BaseDO {

		public const string TABLE_NAME = "CI_MR_NU_GYAFTERASS";
		public const string TABLE_ALIAS_NAME = "a0";

        public GyNurAfterAssDO() {
        }
		public string Id_ass {
            get { return getAttrVal<string>("Id_ass",null); }
            set { setAttrVal<string>("Id_ass", value); }
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
		public string Id_org {
            get { return getAttrVal<string>("Id_org",null); }
            set { setAttrVal<string>("Id_org", value); }
        }
		public string Id_grp {
            get { return getAttrVal<string>("Id_grp",null); }
            set { setAttrVal<string>("Id_grp", value); }
        }
		public string Code_amr_ip {
            get { return getAttrVal<string>("Code_amr_ip",null); }
            set { setAttrVal<string>("Code_amr_ip", value); }
        }
		public string Name_bed {
            get { return getAttrVal<string>("Name_bed",null); }
            set { setAttrVal<string>("Name_bed", value); }
        }
		public string Age {
            get { return getAttrVal<string>("Age",null); }
            set { setAttrVal<string>("Age", value); }
        }
		public string Id_dep_phy {
            get { return getAttrVal<string>("Id_dep_phy",null); }
            set { setAttrVal<string>("Id_dep_phy", value); }
        }
		public DateTime? Dt_oper {
            get { return getAttrVal<FDateTime>("Dt_oper",null); }
            set { setAttrVal<FDateTime>("Dt_oper", value); }
        }
		public string Id_anesway {
            get { return getAttrVal<string>("Id_anesway",null); }
            set { setAttrVal<string>("Id_anesway", value); }
        }
		public string Sd_anesway {
            get { return getAttrVal<string>("Sd_anesway",null); }
            set { setAttrVal<string>("Sd_anesway", value); }
        }
		public string Oper_diagnose {
            get { return getAttrVal<string>("Oper_diagnose",null); }
            set { setAttrVal<string>("Oper_diagnose", value); }
        }
		public string Name_diagnose {
            get { return getAttrVal<string>("Name_diagnose",null); }
            set { setAttrVal<string>("Name_diagnose", value); }
        }
		public string Specase {
            get { return getAttrVal<string>("Specase",null); }
            set { setAttrVal<string>("Specase", value); }
        }
		public int? Bleed {
            get { return getAttrVal<int?>("Bleed",null); }
            set { setAttrVal<int?>("Bleed", value); }
        }
		public DateTime? Dt_back_room {
            get { return getAttrVal<FDateTime>("Dt_back_room",null); }
            set { setAttrVal<FDateTime>("Dt_back_room", value); }
        }
		public int? Eu_draft_tube {
            get { return getAttrVal<int?>("Eu_draft_tube",null); }
            set { setAttrVal<int?>("Eu_draft_tube", value); }
        }
		public string Id_part {
            get { return getAttrVal<string>("Id_part",null); }
            set { setAttrVal<string>("Id_part", value); }
        }
		public string Sd_part {
            get { return getAttrVal<string>("Sd_part",null); }
            set { setAttrVal<string>("Sd_part", value); }
        }
		public int? Drainage {
            get { return getAttrVal<int?>("Drainage",null); }
            set { setAttrVal<int?>("Drainage", value); }
        }
		public string Id_drainage_proper {
            get { return getAttrVal<string>("Id_drainage_proper",null); }
            set { setAttrVal<string>("Id_drainage_proper", value); }
        }
		public string Sd_drainage_proper {
            get { return getAttrVal<string>("Sd_drainage_proper",null); }
            set { setAttrVal<string>("Sd_drainage_proper", value); }
        }
		public string Id_diet {
            get { return getAttrVal<string>("Id_diet",null); }
            set { setAttrVal<string>("Id_diet", value); }
        }
		public string Sd_diet {
            get { return getAttrVal<string>("Sd_diet",null); }
            set { setAttrVal<string>("Sd_diet", value); }
        }
		public string Dietother {
            get { return getAttrVal<string>("Dietother",null); }
            set { setAttrVal<string>("Dietother", value); }
        }
		public string Id_oxygen {
            get { return getAttrVal<string>("Id_oxygen",null); }
            set { setAttrVal<string>("Id_oxygen", value); }
        }
		public string Sd_oxygen {
            get { return getAttrVal<string>("Sd_oxygen",null); }
            set { setAttrVal<string>("Sd_oxygen", value); }
        }
		public FDouble Oxygen_time {
            get { return getAttrVal<FDouble>("Oxygen_time",null); }
            set { setAttrVal<FDouble>("Oxygen_time", value); }
        }
		public DateTime? Dt_oxygen_begin {
            get { return getAttrVal<FDateTime>("Dt_oxygen_begin",null); }
            set { setAttrVal<FDateTime>("Dt_oxygen_begin", value); }
        }
		public DateTime? Dt_oxygen_end {
            get { return getAttrVal<FDateTime>("Dt_oxygen_end",null); }
            set { setAttrVal<FDateTime>("Dt_oxygen_end", value); }
        }
		public FDouble Oxygen_flow {
            get { return getAttrVal<FDouble>("Oxygen_flow",null); }
            set { setAttrVal<FDouble>("Oxygen_flow", value); }
        }
		public FDouble Ecg_tutelage {
            get { return getAttrVal<FDouble>("Ecg_tutelage",null); }
            set { setAttrVal<FDouble>("Ecg_tutelage", value); }
        }
		public DateTime? Dt_ecg_begin {
            get { return getAttrVal<FDateTime>("Dt_ecg_begin",null); }
            set { setAttrVal<FDateTime>("Dt_ecg_begin", value); }
        }
		public DateTime? Dt_ecg_end {
            get { return getAttrVal<FDateTime>("Dt_ecg_end",null); }
            set { setAttrVal<FDateTime>("Dt_ecg_end", value); }
        }
		public string Id_keepureter {
            get { return getAttrVal<string>("Id_keepureter",null); }
            set { setAttrVal<string>("Id_keepureter", value); }
        }
		public string Sd_keepureter {
            get { return getAttrVal<string>("Sd_keepureter",null); }
            set { setAttrVal<string>("Sd_keepureter", value); }
        }
		public string Longopen {
            get { return getAttrVal<string>("Longopen",null); }
            set { setAttrVal<string>("Longopen", value); }
        }
		public string Id_ass_psn {
            get { return getAttrVal<string>("Id_ass_psn",null); }
            set { setAttrVal<string>("Id_ass_psn", value); }
        }
		public DateTime? Dt_moveureter {
            get { return getAttrVal<FDateTime>("Dt_moveureter",null); }
            set { setAttrVal<FDateTime>("Dt_moveureter", value); }
        }
		public string Id_move_psn {
            get { return getAttrVal<string>("Id_move_psn",null); }
            set { setAttrVal<string>("Id_move_psn", value); }
        }
		public DateTime? Dt_firselfpee {
            get { return getAttrVal<FDateTime>("Dt_firselfpee",null); }
            set { setAttrVal<FDateTime>("Dt_firselfpee", value); }
        }
		public string Id_urinatecond {
            get { return getAttrVal<string>("Id_urinatecond",null); }
            set { setAttrVal<string>("Id_urinatecond", value); }
        }
		public string Sd_urinatecond {
            get { return getAttrVal<string>("Sd_urinatecond",null); }
            set { setAttrVal<string>("Sd_urinatecond", value); }
        }
		public string Id_peesign_psn {
            get { return getAttrVal<string>("Id_peesign_psn",null); }
            set { setAttrVal<string>("Id_peesign_psn", value); }
        }
		public DateTime? Dt_leavehos {
            get { return getAttrVal<FDateTime>("Dt_leavehos",null); }
            set { setAttrVal<FDateTime>("Dt_leavehos", value); }
        }
		public string Id_leavehos_psn {
            get { return getAttrVal<string>("Id_leavehos_psn",null); }
            set { setAttrVal<string>("Id_leavehos_psn", value); }
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
		public string Name_anesway {
            get { return getAttrVal<string>("Name_anesway",null); }
            set { setAttrVal<string>("Name_anesway", value); }
        }
		public string Name_part {
            get { return getAttrVal<string>("Name_part",null); }
            set { setAttrVal<string>("Name_part", value); }
        }
		public string Name_drainage_proper {
            get { return getAttrVal<string>("Name_drainage_proper",null); }
            set { setAttrVal<string>("Name_drainage_proper", value); }
        }
		public string Name_diet {
            get { return getAttrVal<string>("Name_diet",null); }
            set { setAttrVal<string>("Name_diet", value); }
        }
		public string Name_oxygen {
            get { return getAttrVal<string>("Name_oxygen",null); }
            set { setAttrVal<string>("Name_oxygen", value); }
        }
		public string Name_keepureter {
            get { return getAttrVal<string>("Name_keepureter",null); }
            set { setAttrVal<string>("Name_keepureter", value); }
        }
		public string Name_ass_psn {
            get { return getAttrVal<string>("Name_ass_psn",null); }
            set { setAttrVal<string>("Name_ass_psn", value); }
        }
		public string Name_move_psn {
            get { return getAttrVal<string>("Name_move_psn",null); }
            set { setAttrVal<string>("Name_move_psn", value); }
        }
		public string Name_urinatecond {
            get { return getAttrVal<string>("Name_urinatecond",null); }
            set { setAttrVal<string>("Name_urinatecond", value); }
        }
		public string Name_peesign_psn {
            get { return getAttrVal<string>("Name_peesign_psn",null); }
            set { setAttrVal<string>("Name_peesign_psn", value); }
        }
		public string Name_leavehos_psn {
            get { return getAttrVal<string>("Name_leavehos_psn",null); }
            set { setAttrVal<string>("Name_leavehos_psn", value); }
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
            return "CI_MR_NU_GYAFTERASS";
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
            return "iih.ci.mr.nu.obstetrics.gynurafter.d.GyNurAfterAssDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_ass", "Id_pat", "Id_ent", "Code_entp", "Id_org", "Id_grp", "Code_amr_ip", "Name_bed", "Age", "Id_dep_phy", "Dt_oper", "Id_anesway", "Sd_anesway", "Oper_diagnose", "Name_diagnose", "Specase", "Bleed", "Dt_back_room", "Eu_draft_tube", "Id_part", "Sd_part", "Drainage", "Id_drainage_proper", "Sd_drainage_proper", "Id_diet", "Sd_diet", "Dietother", "Id_oxygen", "Sd_oxygen", "Oxygen_time", "Dt_oxygen_begin", "Dt_oxygen_end", "Oxygen_flow", "Ecg_tutelage", "Dt_ecg_begin", "Dt_ecg_end", "Id_keepureter", "Sd_keepureter", "Longopen", "Id_ass_psn", "Dt_moveureter", "Id_move_psn", "Dt_firselfpee", "Id_urinatecond", "Sd_urinatecond", "Id_peesign_psn", "Dt_leavehos", "Id_leavehos_psn", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Name_pat", "Name_dep_phy", "Name_anesway", "Name_part", "Name_drainage_proper", "Name_diet", "Name_oxygen", "Name_keepureter", "Name_ass_psn", "Name_move_psn", "Name_urinatecond", "Name_peesign_psn", "Name_leavehos_psn"};
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
