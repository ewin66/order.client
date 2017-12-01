
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.mr.nu.chidrenass.d
{
    /// <summary>
    /// ChildrenInAsseNurRecordDO 的摘要说明。
    /// </summary>
    public class ChildrenInAsseNurRecordDO : BaseDO {

		public const string TABLE_NAME = "CI_MR_NU_CHASS_REC";
		public const string TABLE_ALIAS_NAME = "a1";

        public ChildrenInAsseNurRecordDO() {
        }
		public string Id_chass_rec {
            get { return getAttrVal<string>("Id_chass_rec",null); }
            set { setAttrVal<string>("Id_chass_rec", value); }
        }
		public string Id_chass {
            get { return getAttrVal<string>("Id_chass",null); }
            set { setAttrVal<string>("Id_chass", value); }
        }
		public DateTime? D_rec {
            get { return getAttrVal<FDate>("D_rec",null); }
            set { setAttrVal<FDate>("D_rec", value); }
        }
		public DateTime? T_rec {
            get { return getAttrVal<FTime>("T_rec",null); }
            set { setAttrVal<FTime>("T_rec", value); }
        }
		public FDouble Tem {
            get { return getAttrVal<FDouble>("Tem",null); }
            set { setAttrVal<FDouble>("Tem", value); }
        }
		public int? Pulse {
            get { return getAttrVal<int?>("Pulse",null); }
            set { setAttrVal<int?>("Pulse", value); }
        }
		public int? Breath {
            get { return getAttrVal<int?>("Breath",null); }
            set { setAttrVal<int?>("Breath", value); }
        }
		public int? Sys_pressure {
            get { return getAttrVal<int?>("Sys_pressure",null); }
            set { setAttrVal<int?>("Sys_pressure", value); }
        }
		public int? Dia_pressure {
            get { return getAttrVal<int?>("Dia_pressure",null); }
            set { setAttrVal<int?>("Dia_pressure", value); }
        }
		public int? Spo2 {
            get { return getAttrVal<int?>("Spo2",null); }
            set { setAttrVal<int?>("Spo2", value); }
        }
		public string Id_oxy_type {
            get { return getAttrVal<string>("Id_oxy_type",null); }
            set { setAttrVal<string>("Id_oxy_type", value); }
        }
		public string Sd_oxy_type {
            get { return getAttrVal<string>("Sd_oxy_type",null); }
            set { setAttrVal<string>("Sd_oxy_type", value); }
        }
		public int? Oxy {
            get { return getAttrVal<int?>("Oxy",null); }
            set { setAttrVal<int?>("Oxy", value); }
        }
		public string Id_skincolor {
            get { return getAttrVal<string>("Id_skincolor",null); }
            set { setAttrVal<string>("Id_skincolor", value); }
        }
		public string Sd_skincolor {
            get { return getAttrVal<string>("Sd_skincolor",null); }
            set { setAttrVal<string>("Sd_skincolor", value); }
        }
		public string Id_autoactivity {
            get { return getAttrVal<string>("Id_autoactivity",null); }
            set { setAttrVal<string>("Id_autoactivity", value); }
        }
		public string Sd_autoactivity {
            get { return getAttrVal<string>("Sd_autoactivity",null); }
            set { setAttrVal<string>("Sd_autoactivity", value); }
        }
		public string Id_muscle_tension {
            get { return getAttrVal<string>("Id_muscle_tension",null); }
            set { setAttrVal<string>("Id_muscle_tension", value); }
        }
		public string Sd_muscle_tension {
            get { return getAttrVal<string>("Sd_muscle_tension",null); }
            set { setAttrVal<string>("Sd_muscle_tension", value); }
        }
		public string Id_cry_voice {
            get { return getAttrVal<string>("Id_cry_voice",null); }
            set { setAttrVal<string>("Id_cry_voice", value); }
        }
		public string Sd_cry_voice {
            get { return getAttrVal<string>("Sd_cry_voice",null); }
            set { setAttrVal<string>("Sd_cry_voice", value); }
        }
		public string Id_abd_dis {
            get { return getAttrVal<string>("Id_abd_dis",null); }
            set { setAttrVal<string>("Id_abd_dis", value); }
        }
		public string Sd_abd_dis {
            get { return getAttrVal<string>("Sd_abd_dis",null); }
            set { setAttrVal<string>("Sd_abd_dis", value); }
        }
		public string Id_umbilical {
            get { return getAttrVal<string>("Id_umbilical",null); }
            set { setAttrVal<string>("Id_umbilical", value); }
        }
		public string Sd_umbilical {
            get { return getAttrVal<string>("Sd_umbilical",null); }
            set { setAttrVal<string>("Sd_umbilical", value); }
        }
		public string Name_medicine {
            get { return getAttrVal<string>("Name_medicine",null); }
            set { setAttrVal<string>("Name_medicine", value); }
        }
		public int? Metering {
            get { return getAttrVal<int?>("Metering",null); }
            set { setAttrVal<int?>("Metering", value); }
        }
		public string Id_route {
            get { return getAttrVal<string>("Id_route",null); }
            set { setAttrVal<string>("Id_route", value); }
        }
		public string Sd_route {
            get { return getAttrVal<string>("Sd_route",null); }
            set { setAttrVal<string>("Sd_route", value); }
        }
		public int? Speed_drug {
            get { return getAttrVal<int?>("Speed_drug",null); }
            set { setAttrVal<int?>("Speed_drug", value); }
        }
		public string Id_unit_speed {
            get { return getAttrVal<string>("Id_unit_speed",null); }
            set { setAttrVal<string>("Id_unit_speed", value); }
        }
		public string Sd_unit_speed {
            get { return getAttrVal<string>("Sd_unit_speed",null); }
            set { setAttrVal<string>("Sd_unit_speed", value); }
        }
		public string Id_diet {
            get { return getAttrVal<string>("Id_diet",null); }
            set { setAttrVal<string>("Id_diet", value); }
        }
		public string Sd_diet {
            get { return getAttrVal<string>("Sd_diet",null); }
            set { setAttrVal<string>("Sd_diet", value); }
        }
		public string Id_bringinto_way {
            get { return getAttrVal<string>("Id_bringinto_way",null); }
            set { setAttrVal<string>("Id_bringinto_way", value); }
        }
		public string Sd_bringinto_way {
            get { return getAttrVal<string>("Sd_bringinto_way",null); }
            set { setAttrVal<string>("Sd_bringinto_way", value); }
        }
		public int? Drink {
            get { return getAttrVal<int?>("Drink",null); }
            set { setAttrVal<int?>("Drink", value); }
        }
		public string Id_suckpower {
            get { return getAttrVal<string>("Id_suckpower",null); }
            set { setAttrVal<string>("Id_suckpower", value); }
        }
		public string Sd_suckpower {
            get { return getAttrVal<string>("Sd_suckpower",null); }
            set { setAttrVal<string>("Sd_suckpower", value); }
        }
		public string Id_swallow_active {
            get { return getAttrVal<string>("Id_swallow_active",null); }
            set { setAttrVal<string>("Id_swallow_active", value); }
        }
		public string Sd_swallow_active {
            get { return getAttrVal<string>("Sd_swallow_active",null); }
            set { setAttrVal<string>("Sd_swallow_active", value); }
        }
		public int? Vomit {
            get { return getAttrVal<int?>("Vomit",null); }
            set { setAttrVal<int?>("Vomit", value); }
        }
		public int? Drainage {
            get { return getAttrVal<int?>("Drainage",null); }
            set { setAttrVal<int?>("Drainage", value); }
        }
		public int? Shit {
            get { return getAttrVal<int?>("Shit",null); }
            set { setAttrVal<int?>("Shit", value); }
        }
		public int? A_shit {
            get { return getAttrVal<int?>("A_shit",null); }
            set { setAttrVal<int?>("A_shit", value); }
        }
		public int? Urine {
            get { return getAttrVal<int?>("Urine",null); }
            set { setAttrVal<int?>("Urine", value); }
        }
		public int? A_urine {
            get { return getAttrVal<int?>("A_urine",null); }
            set { setAttrVal<int?>("A_urine", value); }
        }
		public string Id_skin {
            get { return getAttrVal<string>("Id_skin",null); }
            set { setAttrVal<string>("Id_skin", value); }
        }
		public string Sd_skin {
            get { return getAttrVal<string>("Sd_skin",null); }
            set { setAttrVal<string>("Sd_skin", value); }
        }
		public FDouble Boxtem {
            get { return getAttrVal<FDouble>("Boxtem",null); }
            set { setAttrVal<FDouble>("Boxtem", value); }
        }
		public FDouble Hum {
            get { return getAttrVal<FDouble>("Hum",null); }
            set { setAttrVal<FDouble>("Hum", value); }
        }
		public string Management {
            get { return getAttrVal<string>("Management",null); }
            set { setAttrVal<string>("Management", value); }
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
		public string Name_oxy_type {
            get { return getAttrVal<string>("Name_oxy_type",null); }
            set { setAttrVal<string>("Name_oxy_type", value); }
        }
		public string Name_skincolor {
            get { return getAttrVal<string>("Name_skincolor",null); }
            set { setAttrVal<string>("Name_skincolor", value); }
        }
		public string Name_autoactivity {
            get { return getAttrVal<string>("Name_autoactivity",null); }
            set { setAttrVal<string>("Name_autoactivity", value); }
        }
		public string Name_muscle_tension {
            get { return getAttrVal<string>("Name_muscle_tension",null); }
            set { setAttrVal<string>("Name_muscle_tension", value); }
        }
		public string Name_cry_voice {
            get { return getAttrVal<string>("Name_cry_voice",null); }
            set { setAttrVal<string>("Name_cry_voice", value); }
        }
		public string Name_abd_dis {
            get { return getAttrVal<string>("Name_abd_dis",null); }
            set { setAttrVal<string>("Name_abd_dis", value); }
        }
		public string Name_umbilical {
            get { return getAttrVal<string>("Name_umbilical",null); }
            set { setAttrVal<string>("Name_umbilical", value); }
        }
		public string Name_route {
            get { return getAttrVal<string>("Name_route",null); }
            set { setAttrVal<string>("Name_route", value); }
        }
		public string Name_unit_speed {
            get { return getAttrVal<string>("Name_unit_speed",null); }
            set { setAttrVal<string>("Name_unit_speed", value); }
        }
		public string Name_diet {
            get { return getAttrVal<string>("Name_diet",null); }
            set { setAttrVal<string>("Name_diet", value); }
        }
		public string Name_bringinto_way {
            get { return getAttrVal<string>("Name_bringinto_way",null); }
            set { setAttrVal<string>("Name_bringinto_way", value); }
        }
		public string Name_suckpower {
            get { return getAttrVal<string>("Name_suckpower",null); }
            set { setAttrVal<string>("Name_suckpower", value); }
        }
		public string Name_swallow_active {
            get { return getAttrVal<string>("Name_swallow_active",null); }
            set { setAttrVal<string>("Name_swallow_active", value); }
        }
		public string Name_skin {
            get { return getAttrVal<string>("Name_skin",null); }
            set { setAttrVal<string>("Name_skin", value); }
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
            return "CI_MR_NU_CHASS_REC";
        }
        
        /// <summary>
        /// 返回表别名
        /// </summary>
        /// <returns></returns>
        public override string getAliasTableName()
        {
            return "a1";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_chass_rec";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.nu.chidrenass.d.ChildrenInAsseNurRecordDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_chass_rec", "Id_chass", "D_rec", "T_rec", "Tem", "Pulse", "Breath", "Sys_pressure", "Dia_pressure", "Spo2", "Id_oxy_type", "Sd_oxy_type", "Oxy", "Id_skincolor", "Sd_skincolor", "Id_autoactivity", "Sd_autoactivity", "Id_muscle_tension", "Sd_muscle_tension", "Id_cry_voice", "Sd_cry_voice", "Id_abd_dis", "Sd_abd_dis", "Id_umbilical", "Sd_umbilical", "Name_medicine", "Metering", "Id_route", "Sd_route", "Speed_drug", "Id_unit_speed", "Sd_unit_speed", "Id_diet", "Sd_diet", "Id_bringinto_way", "Sd_bringinto_way", "Drink", "Id_suckpower", "Sd_suckpower", "Id_swallow_active", "Sd_swallow_active", "Vomit", "Drainage", "Shit", "A_shit", "Urine", "A_urine", "Id_skin", "Sd_skin", "Boxtem", "Hum", "Management", "Id_sign", "Id_grp", "Id_org", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Name_oxy_type", "Name_skincolor", "Name_autoactivity", "Name_muscle_tension", "Name_cry_voice", "Name_abd_dis", "Name_umbilical", "Name_route", "Name_unit_speed", "Name_diet", "Name_bringinto_way", "Name_suckpower", "Name_swallow_active", "Name_skin", "Name_sign"};
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
