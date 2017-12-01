
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.mr.nu.obstetrics.gynurafter.d
{
    /// <summary>
    /// GyNurAfterRecDO 的摘要说明。
    /// </summary>
    public class GyNurAfterRecDO : BaseDO {

		public const string TABLE_NAME = "CI_MR_NU_GYAFTERREC";
		public const string TABLE_ALIAS_NAME = "a1";

        public GyNurAfterRecDO() {
        }
		public string Id_rec {
            get { return getAttrVal<string>("Id_rec",null); }
            set { setAttrVal<string>("Id_rec", value); }
        }
		public string Id_ass {
            get { return getAttrVal<string>("Id_ass",null); }
            set { setAttrVal<string>("Id_ass", value); }
        }
		public DateTime? Dt_rec {
            get { return getAttrVal<FDateTime>("Dt_rec",null); }
            set { setAttrVal<FDateTime>("Dt_rec", value); }
        }
		public FDouble Temp {
            get { return getAttrVal<FDouble>("Temp",null); }
            set { setAttrVal<FDouble>("Temp", value); }
        }
		public int? Pulse {
            get { return getAttrVal<int?>("Pulse",null); }
            set { setAttrVal<int?>("Pulse", value); }
        }
		public int? Breath {
            get { return getAttrVal<int?>("Breath",null); }
            set { setAttrVal<int?>("Breath", value); }
        }
		public int? Sbp {
            get { return getAttrVal<int?>("Sbp",null); }
            set { setAttrVal<int?>("Sbp", value); }
        }
		public int? Dbp {
            get { return getAttrVal<int?>("Dbp",null); }
            set { setAttrVal<int?>("Dbp", value); }
        }
		public FDouble Sao2 {
            get { return getAttrVal<FDouble>("Sao2",null); }
            set { setAttrVal<FDouble>("Sao2", value); }
        }
		public string Dri_name {
            get { return getAttrVal<string>("Dri_name",null); }
            set { setAttrVal<string>("Dri_name", value); }
        }
		public int? Dri_dosage {
            get { return getAttrVal<int?>("Dri_dosage",null); }
            set { setAttrVal<int?>("Dri_dosage", value); }
        }
		public string Id_dri_usage {
            get { return getAttrVal<string>("Id_dri_usage",null); }
            set { setAttrVal<string>("Id_dri_usage", value); }
        }
		public string Sd_dri_usage {
            get { return getAttrVal<string>("Sd_dri_usage",null); }
            set { setAttrVal<string>("Sd_dri_usage", value); }
        }
		public int? Output_urine {
            get { return getAttrVal<int?>("Output_urine",null); }
            set { setAttrVal<int?>("Output_urine", value); }
        }
		public int? Output_drainage {
            get { return getAttrVal<int?>("Output_drainage",null); }
            set { setAttrVal<int?>("Output_drainage", value); }
        }
		public int? Eu_skin {
            get { return getAttrVal<int?>("Eu_skin",null); }
            set { setAttrVal<int?>("Eu_skin", value); }
        }
		public int? Eu_drainblood {
            get { return getAttrVal<int?>("Eu_drainblood",null); }
            set { setAttrVal<int?>("Eu_drainblood", value); }
        }
		public string Obserilness {
            get { return getAttrVal<string>("Obserilness",null); }
            set { setAttrVal<string>("Obserilness", value); }
        }
		public string Id_rec_psn {
            get { return getAttrVal<string>("Id_rec_psn",null); }
            set { setAttrVal<string>("Id_rec_psn", value); }
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
		public string Name_dri_usage {
            get { return getAttrVal<string>("Name_dri_usage",null); }
            set { setAttrVal<string>("Name_dri_usage", value); }
        }
		public string Name_rec_psn {
            get { return getAttrVal<string>("Name_rec_psn",null); }
            set { setAttrVal<string>("Name_rec_psn", value); }
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
            return "CI_MR_NU_GYAFTERREC";
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
            return "Id_rec";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.nu.obstetrics.gynurafter.d.GyNurAfterRecDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_rec", "Id_ass", "Dt_rec", "Temp", "Pulse", "Breath", "Sbp", "Dbp", "Sao2", "Dri_name", "Dri_dosage", "Id_dri_usage", "Sd_dri_usage", "Output_urine", "Output_drainage", "Eu_skin", "Eu_drainblood", "Obserilness", "Id_rec_psn", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Name_dri_usage", "Name_rec_psn"};
        }
        
    }
}
