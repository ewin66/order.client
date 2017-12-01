
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.mr.nu.obstetrics.gymissabort.d
{
    /// <summary>
    /// GyMissAbortRecDO 的摘要说明。
    /// </summary>
    public class GyMissAbortRecDO : BaseDO {

		public const string TABLE_NAME = "CI_MR_NU_GYMISSABORTREC";
		public const string TABLE_ALIAS_NAME = "a1";

        public GyMissAbortRecDO() {
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
		public FDouble Spo2 {
            get { return getAttrVal<FDouble>("Spo2",null); }
            set { setAttrVal<FDouble>("Spo2", value); }
        }
		public string Id_bleed {
            get { return getAttrVal<string>("Id_bleed",null); }
            set { setAttrVal<string>("Id_bleed", value); }
        }
		public string Sd_bleed {
            get { return getAttrVal<string>("Sd_bleed",null); }
            set { setAttrVal<string>("Sd_bleed", value); }
        }
		public int? Urinevolume {
            get { return getAttrVal<int?>("Urinevolume",null); }
            set { setAttrVal<int?>("Urinevolume", value); }
        }
		public int? Drainage {
            get { return getAttrVal<int?>("Drainage",null); }
            set { setAttrVal<int?>("Drainage", value); }
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
		public string Name_bleed {
            get { return getAttrVal<string>("Name_bleed",null); }
            set { setAttrVal<string>("Name_bleed", value); }
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
            return "CI_MR_NU_GYMISSABORTREC";
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
            return "iih.ci.mr.nu.obstetrics.gymissabort.d.GyMissAbortRecDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_rec", "Id_ass", "Dt_rec", "Temp", "Pulse", "Breath", "Sbp", "Dbp", "Spo2", "Id_bleed", "Sd_bleed", "Urinevolume", "Drainage", "Obserilness", "Id_rec_psn", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Name_bleed", "Name_rec_psn"};
        }
        
    }
}
