
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.mr.nu.generalnursingrec.d
{
    /// <summary>
    /// GeneralNursingRecDO 的摘要说明。
    /// </summary>
    public class GeneralNursingRecDO : BaseDO {

		public const string TABLE_NAME = "CI_MR_NU_GNR_REC";
		public const string TABLE_ALIAS_NAME = "a1";

        public GeneralNursingRecDO() {
        }
		public string Id_gnr_rec {
            get { return getAttrVal<string>("Id_gnr_rec",null); }
            set { setAttrVal<string>("Id_gnr_rec", value); }
        }
		public string Id_gnr {
            get { return getAttrVal<string>("Id_gnr",null); }
            set { setAttrVal<string>("Id_gnr", value); }
        }
		public string Conditiontreatment {
            get { return getAttrVal<string>("Conditiontreatment",null); }
            set { setAttrVal<string>("Conditiontreatment", value); }
        }
		public DateTime? Dt_rec {
            get { return getAttrVal<FDateTime>("Dt_rec",null); }
            set { setAttrVal<FDateTime>("Dt_rec", value); }
        }
		public string Signature {
            get { return getAttrVal<string>("Signature",null); }
            set { setAttrVal<string>("Signature", value); }
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
            return "CI_MR_NU_GNR_REC";
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
            return "Id_gnr_rec";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.nu.generalnursingrec.d.GeneralNursingRecDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_gnr_rec", "Id_gnr", "Conditiontreatment", "Dt_rec", "Signature", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Name_sign"};
        }
        
    }
}
