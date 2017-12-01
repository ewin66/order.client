
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.mr.nu.adl.d
{
    /// <summary>
    /// ADLDO 的摘要说明。
    /// </summary>
    public class ADLDO : BaseDO {

		public const string TABLE_NAME = "CI_MR_NU_ADL";
		public const string TABLE_ALIAS_NAME = "a0";

        public ADLDO() {
        }
		public string Id_adl {
            get { return getAttrVal<string>("Id_adl",null); }
            set { setAttrVal<string>("Id_adl", value); }
        }
		public string Id_grp {
            get { return getAttrVal<string>("Id_grp",null); }
            set { setAttrVal<string>("Id_grp", value); }
        }
		public string Id_org {
            get { return getAttrVal<string>("Id_org",null); }
            set { setAttrVal<string>("Id_org", value); }
        }
		public string Id_dep_nur {
            get { return getAttrVal<string>("Id_dep_nur",null); }
            set { setAttrVal<string>("Id_dep_nur", value); }
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
		public string Age {
            get { return getAttrVal<string>("Age",null); }
            set { setAttrVal<string>("Age", value); }
        }
		public DateTime? Dt_entry {
            get { return getAttrVal<FDateTime>("Dt_entry",null); }
            set { setAttrVal<FDateTime>("Dt_entry", value); }
        }
		public string Id_takefood {
            get { return getAttrVal<string>("Id_takefood",null); }
            set { setAttrVal<string>("Id_takefood", value); }
        }
		public string Sd_takefood {
            get { return getAttrVal<string>("Sd_takefood",null); }
            set { setAttrVal<string>("Sd_takefood", value); }
        }
		public FDouble Sco_takefood {
            get { return getAttrVal<FDouble>("Sco_takefood",null); }
            set { setAttrVal<FDouble>("Sco_takefood", value); }
        }
		public string Id_bath {
            get { return getAttrVal<string>("Id_bath",null); }
            set { setAttrVal<string>("Id_bath", value); }
        }
		public string Sd_bath {
            get { return getAttrVal<string>("Sd_bath",null); }
            set { setAttrVal<string>("Sd_bath", value); }
        }
		public FDouble Sco_bath {
            get { return getAttrVal<FDouble>("Sco_bath",null); }
            set { setAttrVal<FDouble>("Sco_bath", value); }
        }
		public string Id_bedeck {
            get { return getAttrVal<string>("Id_bedeck",null); }
            set { setAttrVal<string>("Id_bedeck", value); }
        }
		public string Sd_bedeck {
            get { return getAttrVal<string>("Sd_bedeck",null); }
            set { setAttrVal<string>("Sd_bedeck", value); }
        }
		public FDouble Sco_bedeck {
            get { return getAttrVal<FDouble>("Sco_bedeck",null); }
            set { setAttrVal<FDouble>("Sco_bedeck", value); }
        }
		public string Id_dress {
            get { return getAttrVal<string>("Id_dress",null); }
            set { setAttrVal<string>("Id_dress", value); }
        }
		public string Sd_dress {
            get { return getAttrVal<string>("Sd_dress",null); }
            set { setAttrVal<string>("Sd_dress", value); }
        }
		public FDouble Sco_dress {
            get { return getAttrVal<FDouble>("Sco_dress",null); }
            set { setAttrVal<FDouble>("Sco_dress", value); }
        }
		public string Id_ctrfeces {
            get { return getAttrVal<string>("Id_ctrfeces",null); }
            set { setAttrVal<string>("Id_ctrfeces", value); }
        }
		public string Sd_ctrfeces {
            get { return getAttrVal<string>("Sd_ctrfeces",null); }
            set { setAttrVal<string>("Sd_ctrfeces", value); }
        }
		public FDouble Sco_ctrfeces {
            get { return getAttrVal<FDouble>("Sco_ctrfeces",null); }
            set { setAttrVal<FDouble>("Sco_ctrfeces", value); }
        }
		public string Id_ctrpee {
            get { return getAttrVal<string>("Id_ctrpee",null); }
            set { setAttrVal<string>("Id_ctrpee", value); }
        }
		public string Sd_ctrpee {
            get { return getAttrVal<string>("Sd_ctrpee",null); }
            set { setAttrVal<string>("Sd_ctrpee", value); }
        }
		public FDouble Sco_ctrpee {
            get { return getAttrVal<FDouble>("Sco_ctrpee",null); }
            set { setAttrVal<FDouble>("Sco_ctrpee", value); }
        }
		public string Id_defcation {
            get { return getAttrVal<string>("Id_defcation",null); }
            set { setAttrVal<string>("Id_defcation", value); }
        }
		public string Sd_defcation {
            get { return getAttrVal<string>("Sd_defcation",null); }
            set { setAttrVal<string>("Sd_defcation", value); }
        }
		public FDouble Sco_defcation {
            get { return getAttrVal<FDouble>("Sco_defcation",null); }
            set { setAttrVal<FDouble>("Sco_defcation", value); }
        }
		public string Id_bedbentran {
            get { return getAttrVal<string>("Id_bedbentran",null); }
            set { setAttrVal<string>("Id_bedbentran", value); }
        }
		public string Sd_bedbentran {
            get { return getAttrVal<string>("Sd_bedbentran",null); }
            set { setAttrVal<string>("Sd_bedbentran", value); }
        }
		public FDouble Sco_bedbentran {
            get { return getAttrVal<FDouble>("Sco_bedbentran",null); }
            set { setAttrVal<FDouble>("Sco_bedbentran", value); }
        }
		public string Id_levtalk {
            get { return getAttrVal<string>("Id_levtalk",null); }
            set { setAttrVal<string>("Id_levtalk", value); }
        }
		public string Sd_levtalk {
            get { return getAttrVal<string>("Sd_levtalk",null); }
            set { setAttrVal<string>("Sd_levtalk", value); }
        }
		public FDouble Sco_levtalk {
            get { return getAttrVal<FDouble>("Sco_levtalk",null); }
            set { setAttrVal<FDouble>("Sco_levtalk", value); }
        }
		public string Id_updownstair {
            get { return getAttrVal<string>("Id_updownstair",null); }
            set { setAttrVal<string>("Id_updownstair", value); }
        }
		public string Sd_updownstair {
            get { return getAttrVal<string>("Sd_updownstair",null); }
            set { setAttrVal<string>("Sd_updownstair", value); }
        }
		public FDouble Sco_updownstair {
            get { return getAttrVal<FDouble>("Sco_updownstair",null); }
            set { setAttrVal<FDouble>("Sco_updownstair", value); }
        }
		public string Ass_result {
            get { return getAttrVal<string>("Ass_result",null); }
            set { setAttrVal<string>("Ass_result", value); }
        }
		public DateTime? Dt_ass {
            get { return getAttrVal<FDateTime>("Dt_ass",null); }
            set { setAttrVal<FDateTime>("Dt_ass", value); }
        }
		public string Id_ass_psn {
            get { return getAttrVal<string>("Id_ass_psn",null); }
            set { setAttrVal<string>("Id_ass_psn", value); }
        }
		public FDouble Totalscore {
            get { return getAttrVal<FDouble>("Totalscore",null); }
            set { setAttrVal<FDouble>("Totalscore", value); }
        }
		public string Id_level {
            get { return getAttrVal<string>("Id_level",null); }
            set { setAttrVal<string>("Id_level", value); }
        }
		public string Sd_level {
            get { return getAttrVal<string>("Sd_level",null); }
            set { setAttrVal<string>("Sd_level", value); }
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
		public string Name_dep_nur {
            get { return getAttrVal<string>("Name_dep_nur",null); }
            set { setAttrVal<string>("Name_dep_nur", value); }
        }
		public string Name_pat {
            get { return getAttrVal<string>("Name_pat",null); }
            set { setAttrVal<string>("Name_pat", value); }
        }
		public string Name_sex {
            get { return getAttrVal<string>("Name_sex",null); }
            set { setAttrVal<string>("Name_sex", value); }
        }
		public string Name_takefood {
            get { return getAttrVal<string>("Name_takefood",null); }
            set { setAttrVal<string>("Name_takefood", value); }
        }
		public string Name_bath {
            get { return getAttrVal<string>("Name_bath",null); }
            set { setAttrVal<string>("Name_bath", value); }
        }
		public string Name_bedeck {
            get { return getAttrVal<string>("Name_bedeck",null); }
            set { setAttrVal<string>("Name_bedeck", value); }
        }
		public string Name_dress {
            get { return getAttrVal<string>("Name_dress",null); }
            set { setAttrVal<string>("Name_dress", value); }
        }
		public string Name_ctrfeces {
            get { return getAttrVal<string>("Name_ctrfeces",null); }
            set { setAttrVal<string>("Name_ctrfeces", value); }
        }
		public string Name_ctrpee {
            get { return getAttrVal<string>("Name_ctrpee",null); }
            set { setAttrVal<string>("Name_ctrpee", value); }
        }
		public string Name_defcation {
            get { return getAttrVal<string>("Name_defcation",null); }
            set { setAttrVal<string>("Name_defcation", value); }
        }
		public string Name_bedbentran {
            get { return getAttrVal<string>("Name_bedbentran",null); }
            set { setAttrVal<string>("Name_bedbentran", value); }
        }
		public string Name_levtalk {
            get { return getAttrVal<string>("Name_levtalk",null); }
            set { setAttrVal<string>("Name_levtalk", value); }
        }
		public string Name_updownstair {
            get { return getAttrVal<string>("Name_updownstair",null); }
            set { setAttrVal<string>("Name_updownstair", value); }
        }
		public string Name_ass_psn {
            get { return getAttrVal<string>("Name_ass_psn",null); }
            set { setAttrVal<string>("Name_ass_psn", value); }
        }
		public string Name_level {
            get { return getAttrVal<string>("Name_level",null); }
            set { setAttrVal<string>("Name_level", value); }
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
            return "CI_MR_NU_ADL";
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
            return "Id_adl";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.nu.adl.d.ADLDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_adl", "Id_grp", "Id_org", "Id_dep_nur", "Id_ent", "Id_pat", "Code_entp", "Id_sex", "Sd_sex", "Name_bed", "Code_amr_ip", "Age", "Dt_entry", "Id_takefood", "Sd_takefood", "Sco_takefood", "Id_bath", "Sd_bath", "Sco_bath", "Id_bedeck", "Sd_bedeck", "Sco_bedeck", "Id_dress", "Sd_dress", "Sco_dress", "Id_ctrfeces", "Sd_ctrfeces", "Sco_ctrfeces", "Id_ctrpee", "Sd_ctrpee", "Sco_ctrpee", "Id_defcation", "Sd_defcation", "Sco_defcation", "Id_bedbentran", "Sd_bedbentran", "Sco_bedbentran", "Id_levtalk", "Sd_levtalk", "Sco_levtalk", "Id_updownstair", "Sd_updownstair", "Sco_updownstair", "Ass_result", "Dt_ass", "Id_ass_psn", "Totalscore", "Id_level", "Sd_level", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Name_dep_nur", "Name_pat", "Name_sex", "Name_takefood", "Name_bath", "Name_bedeck", "Name_dress", "Name_ctrfeces", "Name_ctrpee", "Name_defcation", "Name_bedbentran", "Name_levtalk", "Name_updownstair", "Name_ass_psn", "Name_level"};
        }
        
    }
}
