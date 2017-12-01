
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.mr.nu.obstetrics.antenatalassess.d
{
    /// <summary>
    /// AntenNurBserRecDO 的摘要说明。
    /// </summary>
    public class AntenNurBserRecDO : BaseDO {

		public const string TABLE_NAME = "CI_Mr_NU_ANTNURBSERREC";
		public const string TABLE_ALIAS_NAME = "a1";

        public AntenNurBserRecDO() {
        }
		public string Id_antenrec {
            get { return getAttrVal<string>("Id_antenrec",null); }
            set { setAttrVal<string>("Id_antenrec", value); }
        }
		public string Id_antenass {
            get { return getAttrVal<string>("Id_antenass",null); }
            set { setAttrVal<string>("Id_antenass", value); }
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
		public FDouble Spo {
            get { return getAttrVal<FDouble>("Spo",null); }
            set { setAttrVal<FDouble>("Spo", value); }
        }
		public string Id_fundushgt {
            get { return getAttrVal<string>("Id_fundushgt",null); }
            set { setAttrVal<string>("Id_fundushgt", value); }
        }
		public string Sd_fundushgt {
            get { return getAttrVal<string>("Sd_fundushgt",null); }
            set { setAttrVal<string>("Sd_fundushgt", value); }
        }
		public int? Eu_uterus_pinch {
            get { return getAttrVal<int?>("Eu_uterus_pinch",null); }
            set { setAttrVal<int?>("Eu_uterus_pinch", value); }
        }
		public int? Colporrhagia {
            get { return getAttrVal<int?>("Colporrhagia",null); }
            set { setAttrVal<int?>("Colporrhagia", value); }
        }
		public int? Urinevolume {
            get { return getAttrVal<int?>("Urinevolume",null); }
            set { setAttrVal<int?>("Urinevolume", value); }
        }
		public string Driname {
            get { return getAttrVal<string>("Driname",null); }
            set { setAttrVal<string>("Driname", value); }
        }
		public int? Dridosage {
            get { return getAttrVal<int?>("Dridosage",null); }
            set { setAttrVal<int?>("Dridosage", value); }
        }
		public string Driusage {
            get { return getAttrVal<string>("Driusage",null); }
            set { setAttrVal<string>("Driusage", value); }
        }
		public int? Id_skincond {
            get { return getAttrVal<int?>("Id_skincond",null); }
            set { setAttrVal<int?>("Id_skincond", value); }
        }
		public string Obserilness {
            get { return getAttrVal<string>("Obserilness",null); }
            set { setAttrVal<string>("Obserilness", value); }
        }
		public string Id_sign_psn {
            get { return getAttrVal<string>("Id_sign_psn",null); }
            set { setAttrVal<string>("Id_sign_psn", value); }
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
		public string Name_fundushgt {
            get { return getAttrVal<string>("Name_fundushgt",null); }
            set { setAttrVal<string>("Name_fundushgt", value); }
        }
		public string Name_sign_psn {
            get { return getAttrVal<string>("Name_sign_psn",null); }
            set { setAttrVal<string>("Name_sign_psn", value); }
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
            return "CI_Mr_NU_ANTNURBSERREC";
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
            return "Id_antenrec";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.nu.obstetrics.antenatalassess.d.AntenNurBserRecDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_antenrec", "Id_antenass", "Dt_rec", "Temp", "Pulse", "Breath", "Sbp", "Dbp", "Spo", "Id_fundushgt", "Sd_fundushgt", "Eu_uterus_pinch", "Colporrhagia", "Urinevolume", "Driname", "Dridosage", "Driusage", "Id_skincond", "Obserilness", "Id_sign_psn", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Name_fundushgt", "Name_sign_psn"};
        }
        
    }
}
