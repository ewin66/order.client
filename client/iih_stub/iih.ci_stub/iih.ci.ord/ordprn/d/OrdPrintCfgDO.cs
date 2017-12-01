
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.ord.ordprn.d
{
    /// <summary>
    /// OrdPrintCfgDO 的摘要说明。
    /// </summary>
    public class OrdPrintCfgDO : BaseDO {

        public OrdPrintCfgDO() {
        }
		public string Id_orprn_cfg {
            get { return getAttrVal<string>("Id_orprn_cfg",null); }
            set { setAttrVal<string>("Id_orprn_cfg", value); }
        }
		public string Id_grp {
            get { return getAttrVal<string>("Id_grp",null); }
            set { setAttrVal<string>("Id_grp", value); }
        }
		public string Id_org {
            get { return getAttrVal<string>("Id_org",null); }
            set { setAttrVal<string>("Id_org", value); }
        }
		public bool? Fg_long {
            get { return getAttrVal<FBoolean>("Fg_long",null); }
            set { setAttrVal<FBoolean>("Fg_long", value); }
        }
		public string Id_srvtp {
            get { return getAttrVal<string>("Id_srvtp",null); }
            set { setAttrVal<string>("Id_srvtp", value); }
        }
		public string Sd_srvtp {
            get { return getAttrVal<string>("Sd_srvtp",null); }
            set { setAttrVal<string>("Sd_srvtp", value); }
        }
		public string Cfg_grp {
            get { return getAttrVal<string>("Cfg_grp",null); }
            set { setAttrVal<string>("Cfg_grp", value); }
        }
		public string Cfg_property {
            get { return getAttrVal<string>("Cfg_property",null); }
            set { setAttrVal<string>("Cfg_property", value); }
        }
		public string Cfg_content {
            get { return getAttrVal<string>("Cfg_content",null); }
            set { setAttrVal<string>("Cfg_content", value); }
        }
		public bool? Default_cfg {
            get { return getAttrVal<FBoolean>("Default_cfg",null); }
            set { setAttrVal<FBoolean>("Default_cfg", value); }
        }
		public string Type {
            get { return getAttrVal<string>("Type",null); }
            set { setAttrVal<string>("Type", value); }
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
		public int? Sotrno {
            get { return getAttrVal<int?>("Sotrno",null); }
            set { setAttrVal<int?>("Sotrno", value); }
        }
		public string Srvtp_name {
            get { return getAttrVal<string>("Srvtp_name",null); }
            set { setAttrVal<string>("Srvtp_name", value); }
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
            return "ci_or_prn_cfg";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_orprn_cfg";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.ordprn.d.OrdPrintCfgDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_orprn_cfg", "Id_grp", "Id_org", "Fg_long", "Id_srvtp", "Sd_srvtp", "Cfg_grp", "Cfg_property", "Cfg_content", "Default_cfg", "Type", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Sotrno", "Srvtp_name"};
        }
        
    }
}
