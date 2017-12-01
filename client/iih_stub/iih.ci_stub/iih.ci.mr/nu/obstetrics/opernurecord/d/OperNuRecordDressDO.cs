
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.mr.nu.obstetrics.opernurecord.d
{
    /// <summary>
    /// OperNuRecordDressDO 的摘要说明。
    /// </summary>
    public class OperNuRecordDressDO : BaseDO {

		public const string TABLE_NAME = "ci_mr_nu_oprcod_dress";
		public const string TABLE_ALIAS_NAME = "a2";

        public OperNuRecordDressDO() {
        }
		public string Id_oprcod_dress {
            get { return getAttrVal<string>("Id_oprcod_dress",null); }
            set { setAttrVal<string>("Id_oprcod_dress", value); }
        }
		public string Id_oprcod {
            get { return getAttrVal<string>("Id_oprcod",null); }
            set { setAttrVal<string>("Id_oprcod", value); }
        }
		public string Id_eqmtp {
            get { return getAttrVal<string>("Id_eqmtp",null); }
            set { setAttrVal<string>("Id_eqmtp", value); }
        }
		public string Sd_eqmtp {
            get { return getAttrVal<string>("Sd_eqmtp",null); }
            set { setAttrVal<string>("Sd_eqmtp", value); }
        }
		public string Id_eqm {
            get { return getAttrVal<string>("Id_eqm",null); }
            set { setAttrVal<string>("Id_eqm", value); }
        }
		public string Sd_eqm {
            get { return getAttrVal<string>("Sd_eqm",null); }
            set { setAttrVal<string>("Sd_eqm", value); }
        }
		public int? Num_oprbefor {
            get { return getAttrVal<int?>("Num_oprbefor",null); }
            set { setAttrVal<int?>("Num_oprbefor", value); }
        }
		public int? Num_befor {
            get { return getAttrVal<int?>("Num_befor",null); }
            set { setAttrVal<int?>("Num_befor", value); }
        }
		public int? Num_after {
            get { return getAttrVal<int?>("Num_after",null); }
            set { setAttrVal<int?>("Num_after", value); }
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
		public string Name_tp {
            get { return getAttrVal<string>("Name_tp",null); }
            set { setAttrVal<string>("Name_tp", value); }
        }
		public string Name {
            get { return getAttrVal<string>("Name",null); }
            set { setAttrVal<string>("Name", value); }
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
            return "ci_mr_nu_oprcod_dress";
        }
        
        /// <summary>
        /// 返回表别名
        /// </summary>
        /// <returns></returns>
        public override string getAliasTableName()
        {
            return "a2";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_oprcod_dress";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.nu.obstetrics.opernurecord.d.OperNuRecordDressDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_oprcod_dress", "Id_oprcod", "Id_eqmtp", "Sd_eqmtp", "Id_eqm", "Sd_eqm", "Num_oprbefor", "Num_befor", "Num_after", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Name_tp", "Name"};
        }
        
    }
}
