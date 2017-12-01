
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.mr.nu.obstetrics.afterdeliverobsec.d
{
    /// <summary>
    /// AfterDeliveRecDO 的摘要说明。
    /// </summary>
    public class AfterDeliveRecDO : BaseDO {

		public const string TABLE_NAME = "CI_MR_NU_AFTDEREC";
		public const string TABLE_ALIAS_NAME = "a1";

        public AfterDeliveRecDO() {
        }
		public string Id_aftderec {
            get { return getAttrVal<string>("Id_aftderec",null); }
            set { setAttrVal<string>("Id_aftderec", value); }
        }
		public string Id_aftdeinfo {
            get { return getAttrVal<string>("Id_aftdeinfo",null); }
            set { setAttrVal<string>("Id_aftdeinfo", value); }
        }
		public string Id_afterdedt {
            get { return getAttrVal<string>("Id_afterdedt",null); }
            set { setAttrVal<string>("Id_afterdedt", value); }
        }
		public string Sd_afterdedt {
            get { return getAttrVal<string>("Sd_afterdedt",null); }
            set { setAttrVal<string>("Sd_afterdedt", value); }
        }
		public int? Sbp {
            get { return getAttrVal<int?>("Sbp",null); }
            set { setAttrVal<int?>("Sbp", value); }
        }
		public int? Dbp {
            get { return getAttrVal<int?>("Dbp",null); }
            set { setAttrVal<int?>("Dbp", value); }
        }
		public int? Pulse {
            get { return getAttrVal<int?>("Pulse",null); }
            set { setAttrVal<int?>("Pulse", value); }
        }
		public FDouble Spo {
            get { return getAttrVal<FDouble>("Spo",null); }
            set { setAttrVal<FDouble>("Spo", value); }
        }
		public string Id_fundus {
            get { return getAttrVal<string>("Id_fundus",null); }
            set { setAttrVal<string>("Id_fundus", value); }
        }
		public string Sd_fundus {
            get { return getAttrVal<string>("Sd_fundus",null); }
            set { setAttrVal<string>("Sd_fundus", value); }
        }
		public int? Bleedvolume {
            get { return getAttrVal<int?>("Bleedvolume",null); }
            set { setAttrVal<int?>("Bleedvolume", value); }
        }
		public string Id_bladfill {
            get { return getAttrVal<string>("Id_bladfill",null); }
            set { setAttrVal<string>("Id_bladfill", value); }
        }
		public string Sd_bladfill {
            get { return getAttrVal<string>("Sd_bladfill",null); }
            set { setAttrVal<string>("Sd_bladfill", value); }
        }
		public string Id_newborncond {
            get { return getAttrVal<string>("Id_newborncond",null); }
            set { setAttrVal<string>("Id_newborncond", value); }
        }
		public string Sd_newborncond {
            get { return getAttrVal<string>("Sd_newborncond",null); }
            set { setAttrVal<string>("Sd_newborncond", value); }
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
		public string Name_afterdedt {
            get { return getAttrVal<string>("Name_afterdedt",null); }
            set { setAttrVal<string>("Name_afterdedt", value); }
        }
		public string Name_fundus {
            get { return getAttrVal<string>("Name_fundus",null); }
            set { setAttrVal<string>("Name_fundus", value); }
        }
		public string Name_bladfill {
            get { return getAttrVal<string>("Name_bladfill",null); }
            set { setAttrVal<string>("Name_bladfill", value); }
        }
		public string Name_newborncond {
            get { return getAttrVal<string>("Name_newborncond",null); }
            set { setAttrVal<string>("Name_newborncond", value); }
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
            return "CI_MR_NU_AFTDEREC";
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
            return "Id_aftderec";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.nu.obstetrics.afterdeliverobsec.d.AfterDeliveRecDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_aftderec", "Id_aftdeinfo", "Id_afterdedt", "Sd_afterdedt", "Sbp", "Dbp", "Pulse", "Spo", "Id_fundus", "Sd_fundus", "Bleedvolume", "Id_bladfill", "Sd_bladfill", "Id_newborncond", "Sd_newborncond", "Id_sign_psn", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Name_afterdedt", "Name_fundus", "Name_bladfill", "Name_newborncond", "Name_sign_psn"};
        }
        
    }
}
