
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.ciorsrvhp.d
{
    /// <summary>
    /// CiOrSrvHpDO 的摘要说明。
    /// </summary>
    public class CiOrSrvHpDO : BaseDO {

		public const string TABLE_NAME = "ci_or_srv_hp";
		public const string TABLE_ALIAS_NAME = "a0";

        public CiOrSrvHpDO() {
        }
		public string Id_orsrv_hp {
            get { return getAttrVal<string>("Id_orsrv_hp",null); }
            set { setAttrVal<string>("Id_orsrv_hp", value); }
        }
		public string Id_ent {
            get { return getAttrVal<string>("Id_ent",null); }
            set { setAttrVal<string>("Id_ent", value); }
        }
		public string Id_orsrv {
            get { return getAttrVal<string>("Id_orsrv",null); }
            set { setAttrVal<string>("Id_orsrv", value); }
        }
		public string Id_hp {
            get { return getAttrVal<string>("Id_hp",null); }
            set { setAttrVal<string>("Id_hp", value); }
        }
		public string Id_hpsrvtp {
            get { return getAttrVal<string>("Id_hpsrvtp",null); }
            set { setAttrVal<string>("Id_hpsrvtp", value); }
        }
		public string Sd_hpsrvtp {
            get { return getAttrVal<string>("Sd_hpsrvtp",null); }
            set { setAttrVal<string>("Sd_hpsrvtp", value); }
        }
		public bool? Fg_indic {
            get { return getAttrVal<FBoolean>("Fg_indic",null); }
            set { setAttrVal<FBoolean>("Fg_indic", value); }
        }
		public string Des_hpsrvtp {
            get { return getAttrVal<string>("Des_hpsrvtp",null); }
            set { setAttrVal<string>("Des_hpsrvtp", value); }
        }
		public string Des_hplimit {
            get { return getAttrVal<string>("Des_hplimit",null); }
            set { setAttrVal<string>("Des_hplimit", value); }
        }
		public string Eu_hpindicjudged_model {
            get { return getAttrVal<string>("Eu_hpindicjudged_model",null); }
            set { setAttrVal<string>("Eu_hpindicjudged_model", value); }
        }
		public string Indicitemid {
            get { return getAttrVal<string>("Indicitemid",null); }
            set { setAttrVal<string>("Indicitemid", value); }
        }
		public string Eu_hpindicrst {
            get { return getAttrVal<string>("Eu_hpindicrst",null); }
            set { setAttrVal<string>("Eu_hpindicrst", value); }
        }
		public string Des_hpindicrst {
            get { return getAttrVal<string>("Des_hpindicrst",null); }
            set { setAttrVal<string>("Des_hpindicrst", value); }
        }
		public bool? Fg_specill {
            get { return getAttrVal<FBoolean>("Fg_specill",null); }
            set { setAttrVal<FBoolean>("Fg_specill", value); }
        }
		public bool? Fg_selfpay {
            get { return getAttrVal<FBoolean>("Fg_selfpay",null); }
            set { setAttrVal<FBoolean>("Fg_selfpay", value); }
        }
		public string Def1 {
            get { return getAttrVal<string>("Def1",null); }
            set { setAttrVal<string>("Def1", value); }
        }
		public string Def2 {
            get { return getAttrVal<string>("Def2",null); }
            set { setAttrVal<string>("Def2", value); }
        }
		public string Def3 {
            get { return getAttrVal<string>("Def3",null); }
            set { setAttrVal<string>("Def3", value); }
        }
		public string Def4 {
            get { return getAttrVal<string>("Def4",null); }
            set { setAttrVal<string>("Def4", value); }
        }
		public string Def5 {
            get { return getAttrVal<string>("Def5",null); }
            set { setAttrVal<string>("Def5", value); }
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
            return "ci_or_srv_hp";
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
            return "Id_orsrv_hp";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.ciorsrvhp.d.CiOrSrvHpDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_orsrv_hp", "Id_ent", "Id_orsrv", "Id_hp", "Id_hpsrvtp", "Sd_hpsrvtp", "Fg_indic", "Des_hpsrvtp", "Des_hplimit", "Eu_hpindicjudged_model", "Indicitemid", "Eu_hpindicrst", "Des_hpindicrst", "Fg_specill", "Fg_selfpay", "Def1", "Def2", "Def3", "Def4", "Def5"};
        }
        
    }
}
