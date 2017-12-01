
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.mr.nu.painassessment.d
{
    /// <summary>
    /// PainAssessItmDO 的摘要说明。
    /// </summary>
    public class PainAssessItmDO : BaseDO {

		public const string TABLE_NAME = "CI_MR_NU_PAI";
		public const string TABLE_ALIAS_NAME = "a1";

        public PainAssessItmDO() {
        }
		public string Id_pai {
            get { return getAttrVal<string>("Id_pai",null); }
            set { setAttrVal<string>("Id_pai", value); }
        }
		public string Id_pa {
            get { return getAttrVal<string>("Id_pa",null); }
            set { setAttrVal<string>("Id_pa", value); }
        }
		public DateTime? Dt_rec {
            get { return getAttrVal<FDateTime>("Dt_rec",null); }
            set { setAttrVal<FDateTime>("Dt_rec", value); }
        }
		public FDouble Adpi {
            get { return getAttrVal<FDouble>("Adpi",null); }
            set { setAttrVal<FDouble>("Adpi", value); }
        }
		public int? Pulse {
            get { return getAttrVal<int?>("Pulse",null); }
            set { setAttrVal<int?>("Pulse", value); }
        }
		public int? Dbp {
            get { return getAttrVal<int?>("Dbp",null); }
            set { setAttrVal<int?>("Dbp", value); }
        }
		public int? Sbp {
            get { return getAttrVal<int?>("Sbp",null); }
            set { setAttrVal<int?>("Sbp", value); }
        }
		public int? Breath {
            get { return getAttrVal<int?>("Breath",null); }
            set { setAttrVal<int?>("Breath", value); }
        }
		public int? Resting {
            get { return getAttrVal<int?>("Resting",null); }
            set { setAttrVal<int?>("Resting", value); }
        }
		public int? Active {
            get { return getAttrVal<int?>("Active",null); }
            set { setAttrVal<int?>("Active", value); }
        }
		public string Id_mainpainarea {
            get { return getAttrVal<string>("Id_mainpainarea",null); }
            set { setAttrVal<string>("Id_mainpainarea", value); }
        }
		public string Sd_mainpainarea {
            get { return getAttrVal<string>("Sd_mainpainarea",null); }
            set { setAttrVal<string>("Sd_mainpainarea", value); }
        }
		public string Id_painquality {
            get { return getAttrVal<string>("Id_painquality",null); }
            set { setAttrVal<string>("Id_painquality", value); }
        }
		public string Sd_painquality {
            get { return getAttrVal<string>("Sd_painquality",null); }
            set { setAttrVal<string>("Sd_painquality", value); }
        }
		public string Id_painaddcause {
            get { return getAttrVal<string>("Id_painaddcause",null); }
            set { setAttrVal<string>("Id_painaddcause", value); }
        }
		public string Sd_painaddcause {
            get { return getAttrVal<string>("Sd_painaddcause",null); }
            set { setAttrVal<string>("Sd_painaddcause", value); }
        }
		public string Id_sleepqua {
            get { return getAttrVal<string>("Id_sleepqua",null); }
            set { setAttrVal<string>("Id_sleepqua", value); }
        }
		public string Sd_sleepqua {
            get { return getAttrVal<string>("Sd_sleepqua",null); }
            set { setAttrVal<string>("Sd_sleepqua", value); }
        }
		public int? Cacatchange {
            get { return getAttrVal<int?>("Cacatchange",null); }
            set { setAttrVal<int?>("Cacatchange", value); }
        }
		public int? Stomtach {
            get { return getAttrVal<int?>("Stomtach",null); }
            set { setAttrVal<int?>("Stomtach", value); }
        }
		public int? Swirl {
            get { return getAttrVal<int?>("Swirl",null); }
            set { setAttrVal<int?>("Swirl", value); }
        }
		public int? Sick {
            get { return getAttrVal<int?>("Sick",null); }
            set { setAttrVal<int?>("Sick", value); }
        }
		public int? Vomit {
            get { return getAttrVal<int?>("Vomit",null); }
            set { setAttrVal<int?>("Vomit", value); }
        }
		public int? Skinitch {
            get { return getAttrVal<int?>("Skinitch",null); }
            set { setAttrVal<int?>("Skinitch", value); }
        }
		public int? Drowsiness {
            get { return getAttrVal<int?>("Drowsiness",null); }
            set { setAttrVal<int?>("Drowsiness", value); }
        }
		public int? Breathctr {
            get { return getAttrVal<int?>("Breathctr",null); }
            set { setAttrVal<int?>("Breathctr", value); }
        }
		public int? Paintime {
            get { return getAttrVal<int?>("Paintime",null); }
            set { setAttrVal<int?>("Paintime", value); }
        }
		public string Other {
            get { return getAttrVal<string>("Other",null); }
            set { setAttrVal<string>("Other", value); }
        }
		public string Id_asspsn {
            get { return getAttrVal<string>("Id_asspsn",null); }
            set { setAttrVal<string>("Id_asspsn", value); }
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
		public string Name_mainpainarea {
            get { return getAttrVal<string>("Name_mainpainarea",null); }
            set { setAttrVal<string>("Name_mainpainarea", value); }
        }
		public string Name_painquality {
            get { return getAttrVal<string>("Name_painquality",null); }
            set { setAttrVal<string>("Name_painquality", value); }
        }
		public string Name_painaddcause {
            get { return getAttrVal<string>("Name_painaddcause",null); }
            set { setAttrVal<string>("Name_painaddcause", value); }
        }
		public string Name_sleepqua {
            get { return getAttrVal<string>("Name_sleepqua",null); }
            set { setAttrVal<string>("Name_sleepqua", value); }
        }
		public string Name_asspsn {
            get { return getAttrVal<string>("Name_asspsn",null); }
            set { setAttrVal<string>("Name_asspsn", value); }
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
            return "CI_MR_NU_PAI";
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
            return "Id_pai";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.nu.painassessment.d.PainAssessItmDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_pai", "Id_pa", "Dt_rec", "Adpi", "Pulse", "Dbp", "Sbp", "Breath", "Resting", "Active", "Id_mainpainarea", "Sd_mainpainarea", "Id_painquality", "Sd_painquality", "Id_painaddcause", "Sd_painaddcause", "Id_sleepqua", "Sd_sleepqua", "Cacatchange", "Stomtach", "Swirl", "Sick", "Vomit", "Skinitch", "Drowsiness", "Breathctr", "Paintime", "Other", "Id_asspsn", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Name_mainpainarea", "Name_painquality", "Name_painaddcause", "Name_sleepqua", "Name_asspsn"};
        }
        
    }
}
