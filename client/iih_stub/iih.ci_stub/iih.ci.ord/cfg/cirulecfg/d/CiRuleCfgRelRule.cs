
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.cfg.cirulecfg.d
{
    /// <summary>
    /// CiRuleCfgRelRule 的摘要说明。
    /// </summary>
    public class CiRuleCfgRelRule : BaseDO {

		public const string TABLE_NAME = "ci_rule_cfg_relsrv";
		public const string TABLE_ALIAS_NAME = "a1";

        public CiRuleCfgRelRule() {
        }
		public string Id_srvrelrule {
            get { return getAttrVal<string>("Id_srvrelrule",null); }
            set { setAttrVal<string>("Id_srvrelrule", value); }
        }
		public string Id_rulecfg {
            get { return getAttrVal<string>("Id_rulecfg",null); }
            set { setAttrVal<string>("Id_rulecfg", value); }
        }
		public string Eu_ofreftp {
            get { return getAttrVal<string>("Eu_ofreftp",null); }
            set { setAttrVal<string>("Eu_ofreftp", value); }
        }
		public string Id_srvof {
            get { return getAttrVal<string>("Id_srvof",null); }
            set { setAttrVal<string>("Id_srvof", value); }
        }
		public string Id_srvtp {
            get { return getAttrVal<string>("Id_srvtp",null); }
            set { setAttrVal<string>("Id_srvtp", value); }
        }
		public string Sd_srvtp {
            get { return getAttrVal<string>("Sd_srvtp",null); }
            set { setAttrVal<string>("Sd_srvtp", value); }
        }
		public string Id_srv {
            get { return getAttrVal<string>("Id_srv",null); }
            set { setAttrVal<string>("Id_srv", value); }
        }
		public int? Eu_direct {
            get { return getAttrVal<int?>("Eu_direct",null); }
            set { setAttrVal<int?>("Eu_direct", value); }
        }
		public bool? Fg_sys {
            get { return getAttrVal<FBoolean>("Fg_sys",null); }
            set { setAttrVal<FBoolean>("Fg_sys", value); }
        }
		public string Srvtpname {
            get { return getAttrVal<string>("Srvtpname",null); }
            set { setAttrVal<string>("Srvtpname", value); }
        }
		public string Srvname {
            get { return getAttrVal<string>("Srvname",null); }
            set { setAttrVal<string>("Srvname", value); }
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
            return "ci_rule_cfg_relsrv";
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
            return "Id_srvrelrule";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.cfg.cirulecfg.d.CiRuleCfgRelRule";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_srvrelrule", "Id_rulecfg", "Eu_ofreftp", "Id_srvof", "Id_srvtp", "Sd_srvtp", "Id_srv", "Eu_direct", "Fg_sys", "Srvtpname", "Srvname"};
        }
        
    }
}
