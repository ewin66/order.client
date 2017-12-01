
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.mr.nu.healthyedunsrec.d
{
    /// <summary>
    /// HealthyEduNsRecDO 的摘要说明。
    /// </summary>
    public class HealthyEduNsRecDO : BaseDO {

		public const string TABLE_NAME = "CI_MR_NU_HNER_Rec";
		public const string TABLE_ALIAS_NAME = "a1";

        public HealthyEduNsRecDO() {
        }
		public string Id_henr_rec {
            get { return getAttrVal<string>("Id_henr_rec",null); }
            set { setAttrVal<string>("Id_henr_rec", value); }
        }
		public string Id_henr {
            get { return getAttrVal<string>("Id_henr",null); }
            set { setAttrVal<string>("Id_henr", value); }
        }
		public string Id_eduobj {
            get { return getAttrVal<string>("Id_eduobj",null); }
            set { setAttrVal<string>("Id_eduobj", value); }
        }
		public string Sd_eduobj {
            get { return getAttrVal<string>("Sd_eduobj",null); }
            set { setAttrVal<string>("Sd_eduobj", value); }
        }
		public string Id_edumethod {
            get { return getAttrVal<string>("Id_edumethod",null); }
            set { setAttrVal<string>("Id_edumethod", value); }
        }
		public string Sd_edumethod {
            get { return getAttrVal<string>("Sd_edumethod",null); }
            set { setAttrVal<string>("Sd_edumethod", value); }
        }
		public DateTime? Dt_edu {
            get { return getAttrVal<FDateTime>("Dt_edu",null); }
            set { setAttrVal<FDateTime>("Dt_edu", value); }
        }
		public int? Eu_xgpj {
            get { return getAttrVal<int?>("Eu_xgpj",null); }
            set { setAttrVal<int?>("Eu_xgpj", value); }
        }
		public string Id_jyxm {
            get { return getAttrVal<string>("Id_jyxm",null); }
            set { setAttrVal<string>("Id_jyxm", value); }
        }
		public string Sd_jyxm {
            get { return getAttrVal<string>("Sd_jyxm",null); }
            set { setAttrVal<string>("Sd_jyxm", value); }
        }
		public string Id_jtnr {
            get { return getAttrVal<string>("Id_jtnr",null); }
            set { setAttrVal<string>("Id_jtnr", value); }
        }
		public string Sd_jtnr {
            get { return getAttrVal<string>("Sd_jtnr",null); }
            set { setAttrVal<string>("Sd_jtnr", value); }
        }
		public string Des {
            get { return getAttrVal<string>("Des",null); }
            set { setAttrVal<string>("Des", value); }
        }
		public string Id_educator {
            get { return getAttrVal<string>("Id_educator",null); }
            set { setAttrVal<string>("Id_educator", value); }
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
		public string Name_eduobj {
            get { return getAttrVal<string>("Name_eduobj",null); }
            set { setAttrVal<string>("Name_eduobj", value); }
        }
		public string Name_edumethod {
            get { return getAttrVal<string>("Name_edumethod",null); }
            set { setAttrVal<string>("Name_edumethod", value); }
        }
		public string Jyxm_name {
            get { return getAttrVal<string>("Jyxm_name",null); }
            set { setAttrVal<string>("Jyxm_name", value); }
        }
		public string Jtnr_name {
            get { return getAttrVal<string>("Jtnr_name",null); }
            set { setAttrVal<string>("Jtnr_name", value); }
        }
		public string Name_educator {
            get { return getAttrVal<string>("Name_educator",null); }
            set { setAttrVal<string>("Name_educator", value); }
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
            return "CI_MR_NU_HNER_Rec";
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
            return "Id_henr_rec";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.nu.healthyedunsrec.d.HealthyEduNsRecDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_henr_rec", "Id_henr", "Id_eduobj", "Sd_eduobj", "Id_edumethod", "Sd_edumethod", "Dt_edu", "Eu_xgpj", "Id_jyxm", "Sd_jyxm", "Id_jtnr", "Sd_jtnr", "Des", "Id_educator", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Name_eduobj", "Name_edumethod", "Jyxm_name", "Jtnr_name", "Name_educator"};
        }
        
    }
}
