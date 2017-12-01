
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.mr.nu.obstetrics.gymissabort.d
{
    /// <summary>
    /// GyMissAbortAssDO 的摘要说明。
    /// </summary>
    public class GyMissAbortAssDO : BaseDO {

		public const string TABLE_NAME = "CI_MR_NU_GYMISSABORTASS";
		public const string TABLE_ALIAS_NAME = "a0";

        public GyMissAbortAssDO() {
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
		public string Age {
            get { return getAttrVal<string>("Age",null); }
            set { setAttrVal<string>("Age", value); }
        }
		public string Code_amr_ip {
            get { return getAttrVal<string>("Code_amr_ip",null); }
            set { setAttrVal<string>("Code_amr_ip", value); }
        }
		public string Name_bed {
            get { return getAttrVal<string>("Name_bed",null); }
            set { setAttrVal<string>("Name_bed", value); }
        }
		public DateTime? Dt_entry {
            get { return getAttrVal<FDateTime>("Dt_entry",null); }
            set { setAttrVal<FDateTime>("Dt_entry", value); }
        }
		public string Id_entry_way {
            get { return getAttrVal<string>("Id_entry_way",null); }
            set { setAttrVal<string>("Id_entry_way", value); }
        }
		public string Sd_entry_way {
            get { return getAttrVal<string>("Sd_entry_way",null); }
            set { setAttrVal<string>("Sd_entry_way", value); }
        }
		public string Name_diagnosis {
            get { return getAttrVal<string>("Name_diagnosis",null); }
            set { setAttrVal<string>("Name_diagnosis", value); }
        }
		public int? Eu_pastmedic {
            get { return getAttrVal<int?>("Eu_pastmedic",null); }
            set { setAttrVal<int?>("Eu_pastmedic", value); }
        }
		public string Id_hbsag {
            get { return getAttrVal<string>("Id_hbsag",null); }
            set { setAttrVal<string>("Id_hbsag", value); }
        }
		public string Sd_hbsag {
            get { return getAttrVal<string>("Sd_hbsag",null); }
            set { setAttrVal<string>("Sd_hbsag", value); }
        }
		public FDouble Bloodwbc {
            get { return getAttrVal<FDouble>("Bloodwbc",null); }
            set { setAttrVal<FDouble>("Bloodwbc", value); }
        }
		public FDouble Hb {
            get { return getAttrVal<FDouble>("Hb",null); }
            set { setAttrVal<FDouble>("Hb", value); }
        }
		public string Bloodtype {
            get { return getAttrVal<string>("Bloodtype",null); }
            set { setAttrVal<string>("Bloodtype", value); }
        }
		public FDouble Bloodhcg {
            get { return getAttrVal<FDouble>("Bloodhcg",null); }
            set { setAttrVal<FDouble>("Bloodhcg", value); }
        }
		public string Id_secreta {
            get { return getAttrVal<string>("Id_secreta",null); }
            set { setAttrVal<string>("Id_secreta", value); }
        }
		public string Sd_secreta {
            get { return getAttrVal<string>("Sd_secreta",null); }
            set { setAttrVal<string>("Sd_secreta", value); }
        }
		public string Id_leukorrhea {
            get { return getAttrVal<string>("Id_leukorrhea",null); }
            set { setAttrVal<string>("Id_leukorrhea", value); }
        }
		public string Sd_leukorrhea {
            get { return getAttrVal<string>("Sd_leukorrhea",null); }
            set { setAttrVal<string>("Sd_leukorrhea", value); }
        }
		public int? Eu_vagina_blood {
            get { return getAttrVal<int?>("Eu_vagina_blood",null); }
            set { setAttrVal<int?>("Eu_vagina_blood", value); }
        }
		public string Id_vagina_blood {
            get { return getAttrVal<string>("Id_vagina_blood",null); }
            set { setAttrVal<string>("Id_vagina_blood", value); }
        }
		public string Sd_vagina_blood {
            get { return getAttrVal<string>("Sd_vagina_blood",null); }
            set { setAttrVal<string>("Sd_vagina_blood", value); }
        }
		public int? Eu_bellyache {
            get { return getAttrVal<int?>("Eu_bellyache",null); }
            set { setAttrVal<int?>("Eu_bellyache", value); }
        }
		public string Id_nur_level {
            get { return getAttrVal<string>("Id_nur_level",null); }
            set { setAttrVal<string>("Id_nur_level", value); }
        }
		public string Sd_nur_level {
            get { return getAttrVal<string>("Sd_nur_level",null); }
            set { setAttrVal<string>("Sd_nur_level", value); }
        }
		public string Id_assentry_psn {
            get { return getAttrVal<string>("Id_assentry_psn",null); }
            set { setAttrVal<string>("Id_assentry_psn", value); }
        }
		public string Id_labourway {
            get { return getAttrVal<string>("Id_labourway",null); }
            set { setAttrVal<string>("Id_labourway", value); }
        }
		public string Sd_labourway {
            get { return getAttrVal<string>("Sd_labourway",null); }
            set { setAttrVal<string>("Sd_labourway", value); }
        }
		public DateTime? Dt_labour {
            get { return getAttrVal<FDateTime>("Dt_labour",null); }
            set { setAttrVal<FDateTime>("Dt_labour", value); }
        }
		public DateTime? Dt_deliver {
            get { return getAttrVal<FDateTime>("Dt_deliver",null); }
            set { setAttrVal<FDateTime>("Dt_deliver", value); }
        }
		public DateTime? Dt_backroom {
            get { return getAttrVal<FDateTime>("Dt_backroom",null); }
            set { setAttrVal<FDateTime>("Dt_backroom", value); }
        }
		public string Id_deliverway {
            get { return getAttrVal<string>("Id_deliverway",null); }
            set { setAttrVal<string>("Id_deliverway", value); }
        }
		public string Sd_deliverway {
            get { return getAttrVal<string>("Sd_deliverway",null); }
            set { setAttrVal<string>("Sd_deliverway", value); }
        }
		public string Id_urinatecond {
            get { return getAttrVal<string>("Id_urinatecond",null); }
            set { setAttrVal<string>("Id_urinatecond", value); }
        }
		public string Sd_urinatecond {
            get { return getAttrVal<string>("Sd_urinatecond",null); }
            set { setAttrVal<string>("Sd_urinatecond", value); }
        }
		public string Id_assdeliver_psn {
            get { return getAttrVal<string>("Id_assdeliver_psn",null); }
            set { setAttrVal<string>("Id_assdeliver_psn", value); }
        }
		public DateTime? Dt_operat {
            get { return getAttrVal<FDateTime>("Dt_operat",null); }
            set { setAttrVal<FDateTime>("Dt_operat", value); }
        }
		public int? Eu_hocusway {
            get { return getAttrVal<int?>("Eu_hocusway",null); }
            set { setAttrVal<int?>("Eu_hocusway", value); }
        }
		public string Id_hocusway {
            get { return getAttrVal<string>("Id_hocusway",null); }
            set { setAttrVal<string>("Id_hocusway", value); }
        }
		public string Sd_hocusway {
            get { return getAttrVal<string>("Sd_hocusway",null); }
            set { setAttrVal<string>("Sd_hocusway", value); }
        }
		public string Hocuswayother {
            get { return getAttrVal<string>("Hocuswayother",null); }
            set { setAttrVal<string>("Hocuswayother", value); }
        }
		public int? Eu_specase {
            get { return getAttrVal<int?>("Eu_specase",null); }
            set { setAttrVal<int?>("Eu_specase", value); }
        }
		public int? Operatblood {
            get { return getAttrVal<int?>("Operatblood",null); }
            set { setAttrVal<int?>("Operatblood", value); }
        }
		public int? Eu_keepcath {
            get { return getAttrVal<int?>("Eu_keepcath",null); }
            set { setAttrVal<int?>("Eu_keepcath", value); }
        }
		public string Id_specase_psn {
            get { return getAttrVal<string>("Id_specase_psn",null); }
            set { setAttrVal<string>("Id_specase_psn", value); }
        }
		public string Id_urinatecond_oper {
            get { return getAttrVal<string>("Id_urinatecond_oper",null); }
            set { setAttrVal<string>("Id_urinatecond_oper", value); }
        }
		public string Sd_urinatecond_oper {
            get { return getAttrVal<string>("Sd_urinatecond_oper",null); }
            set { setAttrVal<string>("Sd_urinatecond_oper", value); }
        }
		public string Id_oper_psn {
            get { return getAttrVal<string>("Id_oper_psn",null); }
            set { setAttrVal<string>("Id_oper_psn", value); }
        }
		public DateTime? Dt_outhos {
            get { return getAttrVal<FDate>("Dt_outhos",null); }
            set { setAttrVal<FDate>("Dt_outhos", value); }
        }
		public string Id_assoper_psn {
            get { return getAttrVal<string>("Id_assoper_psn",null); }
            set { setAttrVal<string>("Id_assoper_psn", value); }
        }
		public string Name_pat {
            get { return getAttrVal<string>("Name_pat",null); }
            set { setAttrVal<string>("Name_pat", value); }
        }
		public string Name_entry_way {
            get { return getAttrVal<string>("Name_entry_way",null); }
            set { setAttrVal<string>("Name_entry_way", value); }
        }
		public string Name_hbsag {
            get { return getAttrVal<string>("Name_hbsag",null); }
            set { setAttrVal<string>("Name_hbsag", value); }
        }
		public string Name_secreta {
            get { return getAttrVal<string>("Name_secreta",null); }
            set { setAttrVal<string>("Name_secreta", value); }
        }
		public string Name_leukorrhea {
            get { return getAttrVal<string>("Name_leukorrhea",null); }
            set { setAttrVal<string>("Name_leukorrhea", value); }
        }
		public string Name_vagina_blood {
            get { return getAttrVal<string>("Name_vagina_blood",null); }
            set { setAttrVal<string>("Name_vagina_blood", value); }
        }
		public string Name_nur_level {
            get { return getAttrVal<string>("Name_nur_level",null); }
            set { setAttrVal<string>("Name_nur_level", value); }
        }
		public string Name_assentry_psn {
            get { return getAttrVal<string>("Name_assentry_psn",null); }
            set { setAttrVal<string>("Name_assentry_psn", value); }
        }
		public string Name_labourway {
            get { return getAttrVal<string>("Name_labourway",null); }
            set { setAttrVal<string>("Name_labourway", value); }
        }
		public string Name_deliverway {
            get { return getAttrVal<string>("Name_deliverway",null); }
            set { setAttrVal<string>("Name_deliverway", value); }
        }
		public string Name_urinatecond {
            get { return getAttrVal<string>("Name_urinatecond",null); }
            set { setAttrVal<string>("Name_urinatecond", value); }
        }
		public string Name_assdeliver_psn {
            get { return getAttrVal<string>("Name_assdeliver_psn",null); }
            set { setAttrVal<string>("Name_assdeliver_psn", value); }
        }
		public string Name_hocusway {
            get { return getAttrVal<string>("Name_hocusway",null); }
            set { setAttrVal<string>("Name_hocusway", value); }
        }
		public string Name_specase_psn {
            get { return getAttrVal<string>("Name_specase_psn",null); }
            set { setAttrVal<string>("Name_specase_psn", value); }
        }
		public string Name_urinatecond_oper {
            get { return getAttrVal<string>("Name_urinatecond_oper",null); }
            set { setAttrVal<string>("Name_urinatecond_oper", value); }
        }
		public string Name_sshscpnq {
            get { return getAttrVal<string>("Name_sshscpnq",null); }
            set { setAttrVal<string>("Name_sshscpnq", value); }
        }
		public string Name_assoper_psn {
            get { return getAttrVal<string>("Name_assoper_psn",null); }
            set { setAttrVal<string>("Name_assoper_psn", value); }
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
            return "CI_MR_NU_GYMISSABORTASS";
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
            return "iih.ci.mr.nu.obstetrics.gymissabort.d.GyMissAbortAssDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_ass", "Id_pat", "Id_ent", "Code_entp", "Id_org", "Id_grp", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Age", "Code_amr_ip", "Name_bed", "Dt_entry", "Id_entry_way", "Sd_entry_way", "Name_diagnosis", "Eu_pastmedic", "Id_hbsag", "Sd_hbsag", "Bloodwbc", "Hb", "Bloodtype", "Bloodhcg", "Id_secreta", "Sd_secreta", "Id_leukorrhea", "Sd_leukorrhea", "Eu_vagina_blood", "Id_vagina_blood", "Sd_vagina_blood", "Eu_bellyache", "Id_nur_level", "Sd_nur_level", "Id_assentry_psn", "Id_labourway", "Sd_labourway", "Dt_labour", "Dt_deliver", "Dt_backroom", "Id_deliverway", "Sd_deliverway", "Id_urinatecond", "Sd_urinatecond", "Id_assdeliver_psn", "Dt_operat", "Eu_hocusway", "Id_hocusway", "Sd_hocusway", "Hocuswayother", "Eu_specase", "Operatblood", "Eu_keepcath", "Id_specase_psn", "Id_urinatecond_oper", "Sd_urinatecond_oper", "Id_oper_psn", "Dt_outhos", "Id_assoper_psn", "Name_pat", "Name_entry_way", "Name_hbsag", "Name_secreta", "Name_leukorrhea", "Name_vagina_blood", "Name_nur_level", "Name_assentry_psn", "Name_labourway", "Name_deliverway", "Name_urinatecond", "Name_assdeliver_psn", "Name_hocusway", "Name_specase_psn", "Name_urinatecond_oper", "Name_sshscpnq", "Name_assoper_psn"};
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
