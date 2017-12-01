
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.pre.obspre.d
{
    /// <summary>
    /// ObsPreDO 的摘要说明。
    /// </summary>
    public class ObsPreDO : BaseDO {

        public ObsPreDO() {
        }
		public string Id_obspre {
            get { return getAttrVal<string>("Id_obspre",null); }
            set { setAttrVal<string>("Id_obspre", value); }
        }
		public string Id_pat {
            get { return getAttrVal<string>("Id_pat",null); }
            set { setAttrVal<string>("Id_pat", value); }
        }
		public string Name {
            get { return getAttrVal<string>("Name",null); }
            set { setAttrVal<string>("Name", value); }
        }
		public string Id_ent {
            get { return getAttrVal<string>("Id_ent",null); }
            set { setAttrVal<string>("Id_ent", value); }
        }
		public string Code_entp {
            get { return getAttrVal<string>("Code_entp",null); }
            set { setAttrVal<string>("Code_entp", value); }
        }
		public string Id_di {
            get { return getAttrVal<string>("Id_di",null); }
            set { setAttrVal<string>("Id_di", value); }
        }
		public string Id_diitm {
            get { return getAttrVal<string>("Id_diitm",null); }
            set { setAttrVal<string>("Id_diitm", value); }
        }
		public string Str_id_di {
            get { return getAttrVal<string>("Str_id_di",null); }
            set { setAttrVal<string>("Str_id_di", value); }
        }
		public string Str_name_di {
            get { return getAttrVal<string>("Str_name_di",null); }
            set { setAttrVal<string>("Str_name_di", value); }
        }
		public string Id_sex {
            get { return getAttrVal<string>("Id_sex",null); }
            set { setAttrVal<string>("Id_sex", value); }
        }
		public string Sd_sex {
            get { return getAttrVal<string>("Sd_sex",null); }
            set { setAttrVal<string>("Sd_sex", value); }
        }
		public DateTime? Dt_birth {
            get { return getAttrVal<FDate>("Dt_birth",null); }
            set { setAttrVal<FDate>("Dt_birth", value); }
        }
		public string Id_idtp {
            get { return getAttrVal<string>("Id_idtp",null); }
            set { setAttrVal<string>("Id_idtp", value); }
        }
		public string Sd_idtp {
            get { return getAttrVal<string>("Sd_idtp",null); }
            set { setAttrVal<string>("Sd_idtp", value); }
        }
		public string No_idtp {
            get { return getAttrVal<string>("No_idtp",null); }
            set { setAttrVal<string>("No_idtp", value); }
        }
		public string Tel {
            get { return getAttrVal<string>("Tel",null); }
            set { setAttrVal<string>("Tel", value); }
        }
		public string Mob {
            get { return getAttrVal<string>("Mob",null); }
            set { setAttrVal<string>("Mob", value); }
        }
		public string Id_admdiv {
            get { return getAttrVal<string>("Id_admdiv",null); }
            set { setAttrVal<string>("Id_admdiv", value); }
        }
		public string Sd_admdiv {
            get { return getAttrVal<string>("Sd_admdiv",null); }
            set { setAttrVal<string>("Sd_admdiv", value); }
        }
		public string Name_street {
            get { return getAttrVal<string>("Name_street",null); }
            set { setAttrVal<string>("Name_street", value); }
        }
		public string No_zipcd {
            get { return getAttrVal<string>("No_zipcd",null); }
            set { setAttrVal<string>("No_zipcd", value); }
        }
		public string Id_come_way {
            get { return getAttrVal<string>("Id_come_way",null); }
            set { setAttrVal<string>("Id_come_way", value); }
        }
		public string Sd_come_way {
            get { return getAttrVal<string>("Sd_come_way",null); }
            set { setAttrVal<string>("Sd_come_way", value); }
        }
		public DateTime? Dt_entry {
            get { return getAttrVal<FDateTime>("Dt_entry",null); }
            set { setAttrVal<FDateTime>("Dt_entry", value); }
        }
		public DateTime? Dt_rescue_b {
            get { return getAttrVal<FDateTime>("Dt_rescue_b",null); }
            set { setAttrVal<FDateTime>("Dt_rescue_b", value); }
        }
		public DateTime? Dt_rescue_e {
            get { return getAttrVal<FDateTime>("Dt_rescue_e",null); }
            set { setAttrVal<FDateTime>("Dt_rescue_e", value); }
        }
		public string No_preobs {
            get { return getAttrVal<string>("No_preobs",null); }
            set { setAttrVal<string>("No_preobs", value); }
        }
		public string Sd_preobslvl {
            get { return getAttrVal<string>("Sd_preobslvl",null); }
            set { setAttrVal<string>("Sd_preobslvl", value); }
        }
		public string Desc_preobslvl {
            get { return getAttrVal<string>("Desc_preobslvl",null); }
            set { setAttrVal<string>("Desc_preobslvl", value); }
        }
		public string Id_dep {
            get { return getAttrVal<string>("Id_dep",null); }
            set { setAttrVal<string>("Id_dep", value); }
        }
		public string Des_his {
            get { return getAttrVal<string>("Des_his",null); }
            set { setAttrVal<string>("Des_his", value); }
        }
		public string Id_emp {
            get { return getAttrVal<string>("Id_emp",null); }
            set { setAttrVal<string>("Id_emp", value); }
        }
		public DateTime? Dt_sign {
            get { return getAttrVal<FDateTime>("Dt_sign",null); }
            set { setAttrVal<FDateTime>("Dt_sign", value); }
        }
		public string Ids_companion {
            get { return getAttrVal<string>("Ids_companion",null); }
            set { setAttrVal<string>("Ids_companion", value); }
        }
		public string Sds_companion {
            get { return getAttrVal<string>("Sds_companion",null); }
            set { setAttrVal<string>("Sds_companion", value); }
        }
		public bool? Fg_chk_eqidemic {
            get { return getAttrVal<FBoolean>("Fg_chk_eqidemic",null); }
            set { setAttrVal<FBoolean>("Fg_chk_eqidemic", value); }
        }
		public bool? Fg_has_hot {
            get { return getAttrVal<FBoolean>("Fg_has_hot",null); }
            set { setAttrVal<FBoolean>("Fg_has_hot", value); }
        }
		public bool? Fg_has_hot2 {
            get { return getAttrVal<FBoolean>("Fg_has_hot2",null); }
            set { setAttrVal<FBoolean>("Fg_has_hot2", value); }
        }
		public bool? Fg_has_eqidarea {
            get { return getAttrVal<FBoolean>("Fg_has_eqidarea",null); }
            set { setAttrVal<FBoolean>("Fg_has_eqidarea", value); }
        }
		public bool? Fg_has_touchanim {
            get { return getAttrVal<FBoolean>("Fg_has_touchanim",null); }
            set { setAttrVal<FBoolean>("Fg_has_touchanim", value); }
        }
		public string Chk_note {
            get { return getAttrVal<string>("Chk_note",null); }
            set { setAttrVal<string>("Chk_note", value); }
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
            return "ci_obs_pre";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_obspre";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.pre.obspre.d.ObsPreDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_obspre", "Id_pat", "Name", "Id_ent", "Code_entp", "Id_di", "Id_diitm", "Str_id_di", "Str_name_di", "Id_sex", "Sd_sex", "Dt_birth", "Id_idtp", "Sd_idtp", "No_idtp", "Tel", "Mob", "Id_admdiv", "Sd_admdiv", "Name_street", "No_zipcd", "Id_come_way", "Sd_come_way", "Dt_entry", "Dt_rescue_b", "Dt_rescue_e", "No_preobs", "Sd_preobslvl", "Desc_preobslvl", "Id_dep", "Des_his", "Id_emp", "Dt_sign", "Ids_companion", "Sds_companion", "Fg_chk_eqidemic", "Fg_has_hot", "Fg_has_hot2", "Fg_has_eqidarea", "Fg_has_touchanim", "Chk_note", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime"};
        }
        
    }
}
