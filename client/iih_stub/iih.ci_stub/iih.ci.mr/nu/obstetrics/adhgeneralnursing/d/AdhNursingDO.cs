
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.mr.nu.obstetrics.adhgeneralnursing.d
{
    /// <summary>
    /// AdhNursingDO 的摘要说明。
    /// </summary>
    public class AdhNursingDO : BaseDO {

		public const string TABLE_NAME = "CI_Mr_NU_ADHNR";
		public const string TABLE_ALIAS_NAME = "a0";

        public AdhNursingDO() {
        }
		public string Id_adhnr {
            get { return getAttrVal<string>("Id_adhnr",null); }
            set { setAttrVal<string>("Id_adhnr", value); }
        }
		public string Id_dep_phy {
            get { return getAttrVal<string>("Id_dep_phy",null); }
            set { setAttrVal<string>("Id_dep_phy", value); }
        }
		public string Id_dep_nur {
            get { return getAttrVal<string>("Id_dep_nur",null); }
            set { setAttrVal<string>("Id_dep_nur", value); }
        }
		public string Name_bed {
            get { return getAttrVal<string>("Name_bed",null); }
            set { setAttrVal<string>("Name_bed", value); }
        }
		public string Id_pat {
            get { return getAttrVal<string>("Id_pat",null); }
            set { setAttrVal<string>("Id_pat", value); }
        }
		public string Id_ent {
            get { return getAttrVal<string>("Id_ent",null); }
            set { setAttrVal<string>("Id_ent", value); }
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
		public string Id_hosway {
            get { return getAttrVal<string>("Id_hosway",null); }
            set { setAttrVal<string>("Id_hosway", value); }
        }
		public string Sd_hosway {
            get { return getAttrVal<string>("Sd_hosway",null); }
            set { setAttrVal<string>("Sd_hosway", value); }
        }
		public string Name_allergy {
            get { return getAttrVal<string>("Name_allergy",null); }
            set { setAttrVal<string>("Name_allergy", value); }
        }
		public string Id_hbsag {
            get { return getAttrVal<string>("Id_hbsag",null); }
            set { setAttrVal<string>("Id_hbsag", value); }
        }
		public string Sd_hbsag {
            get { return getAttrVal<string>("Sd_hbsag",null); }
            set { setAttrVal<string>("Sd_hbsag", value); }
        }
		public string Id_hbs {
            get { return getAttrVal<string>("Id_hbs",null); }
            set { setAttrVal<string>("Id_hbs", value); }
        }
		public string Sd_hbs {
            get { return getAttrVal<string>("Sd_hbs",null); }
            set { setAttrVal<string>("Sd_hbs", value); }
        }
		public string Id_hbeag {
            get { return getAttrVal<string>("Id_hbeag",null); }
            set { setAttrVal<string>("Id_hbeag", value); }
        }
		public string Sd_hbeag {
            get { return getAttrVal<string>("Sd_hbeag",null); }
            set { setAttrVal<string>("Sd_hbeag", value); }
        }
		public string Id_hbe {
            get { return getAttrVal<string>("Id_hbe",null); }
            set { setAttrVal<string>("Id_hbe", value); }
        }
		public string Sd_hbe {
            get { return getAttrVal<string>("Sd_hbe",null); }
            set { setAttrVal<string>("Sd_hbe", value); }
        }
		public string Id_hbc {
            get { return getAttrVal<string>("Id_hbc",null); }
            set { setAttrVal<string>("Id_hbc", value); }
        }
		public string Sd_hbc {
            get { return getAttrVal<string>("Sd_hbc",null); }
            set { setAttrVal<string>("Sd_hbc", value); }
        }
		public string Id_hcv {
            get { return getAttrVal<string>("Id_hcv",null); }
            set { setAttrVal<string>("Id_hcv", value); }
        }
		public string Sd_hcv {
            get { return getAttrVal<string>("Sd_hcv",null); }
            set { setAttrVal<string>("Sd_hcv", value); }
        }
		public string Id_hiv {
            get { return getAttrVal<string>("Id_hiv",null); }
            set { setAttrVal<string>("Id_hiv", value); }
        }
		public string Sd_hiv {
            get { return getAttrVal<string>("Sd_hiv",null); }
            set { setAttrVal<string>("Sd_hiv", value); }
        }
		public string Id_nur_level {
            get { return getAttrVal<string>("Id_nur_level",null); }
            set { setAttrVal<string>("Id_nur_level", value); }
        }
		public string Sd_nur_level {
            get { return getAttrVal<string>("Sd_nur_level",null); }
            set { setAttrVal<string>("Sd_nur_level", value); }
        }
		public string Activity {
            get { return getAttrVal<string>("Activity",null); }
            set { setAttrVal<string>("Activity", value); }
        }
		public string Id_sign {
            get { return getAttrVal<string>("Id_sign",null); }
            set { setAttrVal<string>("Id_sign", value); }
        }
		public string Id_grp {
            get { return getAttrVal<string>("Id_grp",null); }
            set { setAttrVal<string>("Id_grp", value); }
        }
		public string Id_org {
            get { return getAttrVal<string>("Id_org",null); }
            set { setAttrVal<string>("Id_org", value); }
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
		public string Name_dep_phy {
            get { return getAttrVal<string>("Name_dep_phy",null); }
            set { setAttrVal<string>("Name_dep_phy", value); }
        }
		public string Name_dep_nur {
            get { return getAttrVal<string>("Name_dep_nur",null); }
            set { setAttrVal<string>("Name_dep_nur", value); }
        }
		public string Name_pat {
            get { return getAttrVal<string>("Name_pat",null); }
            set { setAttrVal<string>("Name_pat", value); }
        }
		public string Name_hosway {
            get { return getAttrVal<string>("Name_hosway",null); }
            set { setAttrVal<string>("Name_hosway", value); }
        }
		public string Name_hbsag {
            get { return getAttrVal<string>("Name_hbsag",null); }
            set { setAttrVal<string>("Name_hbsag", value); }
        }
		public string Name_hbs {
            get { return getAttrVal<string>("Name_hbs",null); }
            set { setAttrVal<string>("Name_hbs", value); }
        }
		public string Name_hbeag {
            get { return getAttrVal<string>("Name_hbeag",null); }
            set { setAttrVal<string>("Name_hbeag", value); }
        }
		public string Name_hbe {
            get { return getAttrVal<string>("Name_hbe",null); }
            set { setAttrVal<string>("Name_hbe", value); }
        }
		public string Name_hbc {
            get { return getAttrVal<string>("Name_hbc",null); }
            set { setAttrVal<string>("Name_hbc", value); }
        }
		public string Name_hcv {
            get { return getAttrVal<string>("Name_hcv",null); }
            set { setAttrVal<string>("Name_hcv", value); }
        }
		public string Name_hiv {
            get { return getAttrVal<string>("Name_hiv",null); }
            set { setAttrVal<string>("Name_hiv", value); }
        }
		public string Name_nur_level {
            get { return getAttrVal<string>("Name_nur_level",null); }
            set { setAttrVal<string>("Name_nur_level", value); }
        }
		public string Name_sign {
            get { return getAttrVal<string>("Name_sign",null); }
            set { setAttrVal<string>("Name_sign", value); }
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
            return "CI_Mr_NU_ADHNR";
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
            return "Id_adhnr";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.nu.obstetrics.adhgeneralnursing.d.AdhNursingDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_adhnr", "Id_dep_phy", "Id_dep_nur", "Name_bed", "Id_pat", "Id_ent", "Age", "Code_amr_ip", "Dt_entry", "Name_diagnosis", "Id_hosway", "Sd_hosway", "Name_allergy", "Id_hbsag", "Sd_hbsag", "Id_hbs", "Sd_hbs", "Id_hbeag", "Sd_hbeag", "Id_hbe", "Sd_hbe", "Id_hbc", "Sd_hbc", "Id_hcv", "Sd_hcv", "Id_hiv", "Sd_hiv", "Id_nur_level", "Sd_nur_level", "Activity", "Id_sign", "Id_grp", "Id_org", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Name_dep_phy", "Name_dep_nur", "Name_pat", "Name_hosway", "Name_hbsag", "Name_hbs", "Name_hbeag", "Name_hbe", "Name_hbc", "Name_hcv", "Name_hiv", "Name_nur_level", "Name_sign"};
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
