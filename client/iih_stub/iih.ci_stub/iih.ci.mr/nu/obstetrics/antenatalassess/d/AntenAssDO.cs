
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.mr.nu.obstetrics.antenatalassess.d
{
    /// <summary>
    /// AntenAssDO 的摘要说明。
    /// </summary>
    public class AntenAssDO : BaseDO {

		public const string TABLE_NAME = "CI_Mr_NU_ANT_ASS";
		public const string TABLE_ALIAS_NAME = "a0";

        public AntenAssDO() {
        }
		public string Id_antenass {
            get { return getAttrVal<string>("Id_antenass",null); }
            set { setAttrVal<string>("Id_antenass", value); }
        }
		public string Id_ent {
            get { return getAttrVal<string>("Id_ent",null); }
            set { setAttrVal<string>("Id_ent", value); }
        }
		public string Code_entp {
            get { return getAttrVal<string>("Code_entp",null); }
            set { setAttrVal<string>("Code_entp", value); }
        }
		public string Id_grp {
            get { return getAttrVal<string>("Id_grp",null); }
            set { setAttrVal<string>("Id_grp", value); }
        }
		public string Id_org {
            get { return getAttrVal<string>("Id_org",null); }
            set { setAttrVal<string>("Id_org", value); }
        }
		public string Id_dep_phy {
            get { return getAttrVal<string>("Id_dep_phy",null); }
            set { setAttrVal<string>("Id_dep_phy", value); }
        }
		public string Name_bed {
            get { return getAttrVal<string>("Name_bed",null); }
            set { setAttrVal<string>("Name_bed", value); }
        }
		public string Id_pat {
            get { return getAttrVal<string>("Id_pat",null); }
            set { setAttrVal<string>("Id_pat", value); }
        }
		public string Age {
            get { return getAttrVal<string>("Age",null); }
            set { setAttrVal<string>("Age", value); }
        }
		public string Code_amr_ip {
            get { return getAttrVal<string>("Code_amr_ip",null); }
            set { setAttrVal<string>("Code_amr_ip", value); }
        }
		public DateTime? Dt_delive {
            get { return getAttrVal<FDateTime>("Dt_delive",null); }
            set { setAttrVal<FDateTime>("Dt_delive", value); }
        }
		public DateTime? Dt_backroom {
            get { return getAttrVal<FDateTime>("Dt_backroom",null); }
            set { setAttrVal<FDateTime>("Dt_backroom", value); }
        }
		public string Id_deliveway {
            get { return getAttrVal<string>("Id_deliveway",null); }
            set { setAttrVal<string>("Id_deliveway", value); }
        }
		public string Sd_deliveway {
            get { return getAttrVal<string>("Sd_deliveway",null); }
            set { setAttrVal<string>("Sd_deliveway", value); }
        }
		public int? Bleed {
            get { return getAttrVal<int?>("Bleed",null); }
            set { setAttrVal<int?>("Bleed", value); }
        }
		public string Id_anesway {
            get { return getAttrVal<string>("Id_anesway",null); }
            set { setAttrVal<string>("Id_anesway", value); }
        }
		public string Sd_anesway {
            get { return getAttrVal<string>("Sd_anesway",null); }
            set { setAttrVal<string>("Sd_anesway", value); }
        }
		public string Id_asssign_psn {
            get { return getAttrVal<string>("Id_asssign_psn",null); }
            set { setAttrVal<string>("Id_asssign_psn", value); }
        }
		public DateTime? Dt_moveureter {
            get { return getAttrVal<FDateTime>("Dt_moveureter",null); }
            set { setAttrVal<FDateTime>("Dt_moveureter", value); }
        }
		public string Id_moveureter_psn {
            get { return getAttrVal<string>("Id_moveureter_psn",null); }
            set { setAttrVal<string>("Id_moveureter_psn", value); }
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
		public string Name_grp {
            get { return getAttrVal<string>("Name_grp",null); }
            set { setAttrVal<string>("Name_grp", value); }
        }
		public string Name_org {
            get { return getAttrVal<string>("Name_org",null); }
            set { setAttrVal<string>("Name_org", value); }
        }
		public string Name_dep_phy {
            get { return getAttrVal<string>("Name_dep_phy",null); }
            set { setAttrVal<string>("Name_dep_phy", value); }
        }
		public string Name_pat {
            get { return getAttrVal<string>("Name_pat",null); }
            set { setAttrVal<string>("Name_pat", value); }
        }
		public string Name_deliveway {
            get { return getAttrVal<string>("Name_deliveway",null); }
            set { setAttrVal<string>("Name_deliveway", value); }
        }
		public string Name_anesway {
            get { return getAttrVal<string>("Name_anesway",null); }
            set { setAttrVal<string>("Name_anesway", value); }
        }
		public string Name_asssign_psn {
            get { return getAttrVal<string>("Name_asssign_psn",null); }
            set { setAttrVal<string>("Name_asssign_psn", value); }
        }
		public string Name_moveureter_psn {
            get { return getAttrVal<string>("Name_moveureter_psn",null); }
            set { setAttrVal<string>("Name_moveureter_psn", value); }
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
            return "CI_Mr_NU_ANT_ASS";
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
            return "Id_antenass";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.nu.obstetrics.antenatalassess.d.AntenAssDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_antenass", "Id_ent", "Code_entp", "Id_grp", "Id_org", "Id_dep_phy", "Name_bed", "Id_pat", "Age", "Code_amr_ip", "Dt_delive", "Dt_backroom", "Id_deliveway", "Sd_deliveway", "Bleed", "Id_anesway", "Sd_anesway", "Id_asssign_psn", "Dt_moveureter", "Id_moveureter_psn", "Dt_firselfpee", "Id_urinatecond", "Sd_urinatecond", "Id_peesign_psn", "Dt_leavehos", "Id_leavehos_psn", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Name_grp", "Name_org", "Name_dep_phy", "Name_pat", "Name_deliveway", "Name_anesway", "Name_asssign_psn", "Name_moveureter_psn", "Name_urinatecond", "Name_peesign_psn", "Name_leavehos_psn"};
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
