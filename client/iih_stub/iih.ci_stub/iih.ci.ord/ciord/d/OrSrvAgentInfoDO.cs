
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.ord.ciord.d
{
    /// <summary>
    /// OrSrvAgentInfoDO 的摘要说明。
    /// </summary>
    public class OrSrvAgentInfoDO : BaseDO {

        public OrSrvAgentInfoDO() {
        }
		public string Id_orsrvagent {
            get { return getAttrVal<string>("Id_orsrvagent",null); }
            set { setAttrVal<string>("Id_orsrvagent", value); }
        }
		public string Id_or {
            get { return getAttrVal<string>("Id_or",null); }
            set { setAttrVal<string>("Id_or", value); }
        }
		public string Id_orsrv {
            get { return getAttrVal<string>("Id_orsrv",null); }
            set { setAttrVal<string>("Id_orsrv", value); }
        }
		public string Id_en {
            get { return getAttrVal<string>("Id_en",null); }
            set { setAttrVal<string>("Id_en", value); }
        }
		public string Id_pat {
            get { return getAttrVal<string>("Id_pat",null); }
            set { setAttrVal<string>("Id_pat", value); }
        }
		public string Name_pat {
            get { return getAttrVal<string>("Name_pat",null); }
            set { setAttrVal<string>("Name_pat", value); }
        }
		public string Id_sextp_pat {
            get { return getAttrVal<string>("Id_sextp_pat",null); }
            set { setAttrVal<string>("Id_sextp_pat", value); }
        }
		public string Sd_sextp_pat {
            get { return getAttrVal<string>("Sd_sextp_pat",null); }
            set { setAttrVal<string>("Sd_sextp_pat", value); }
        }
		public string Id_idtp_pat {
            get { return getAttrVal<string>("Id_idtp_pat",null); }
            set { setAttrVal<string>("Id_idtp_pat", value); }
        }
		public string Sd_idtp_pat {
            get { return getAttrVal<string>("Sd_idtp_pat",null); }
            set { setAttrVal<string>("Sd_idtp_pat", value); }
        }
		public string Idno_pat {
            get { return getAttrVal<string>("Idno_pat",null); }
            set { setAttrVal<string>("Idno_pat", value); }
        }
		public int? Age_pat {
            get { return getAttrVal<int?>("Age_pat",null); }
            set { setAttrVal<int?>("Age_pat", value); }
        }
		public string Id_conttp {
            get { return getAttrVal<string>("Id_conttp",null); }
            set { setAttrVal<string>("Id_conttp", value); }
        }
		public string Sd_conttp {
            get { return getAttrVal<string>("Sd_conttp",null); }
            set { setAttrVal<string>("Sd_conttp", value); }
        }
		public string Id_agent {
            get { return getAttrVal<string>("Id_agent",null); }
            set { setAttrVal<string>("Id_agent", value); }
        }
		public string Name_agent {
            get { return getAttrVal<string>("Name_agent",null); }
            set { setAttrVal<string>("Name_agent", value); }
        }
		public string Id_sextp_agent {
            get { return getAttrVal<string>("Id_sextp_agent",null); }
            set { setAttrVal<string>("Id_sextp_agent", value); }
        }
		public string Sd_sextp_agent {
            get { return getAttrVal<string>("Sd_sextp_agent",null); }
            set { setAttrVal<string>("Sd_sextp_agent", value); }
        }
		public string Id_idtp_agent {
            get { return getAttrVal<string>("Id_idtp_agent",null); }
            set { setAttrVal<string>("Id_idtp_agent", value); }
        }
		public string Sd_idtp_agent {
            get { return getAttrVal<string>("Sd_idtp_agent",null); }
            set { setAttrVal<string>("Sd_idtp_agent", value); }
        }
		public string Idno_agent {
            get { return getAttrVal<string>("Idno_agent",null); }
            set { setAttrVal<string>("Idno_agent", value); }
        }
		public int? Age_agent {
            get { return getAttrVal<int?>("Age_agent",null); }
            set { setAttrVal<int?>("Age_agent", value); }
        }
		public string Addr_agent {
            get { return getAttrVal<string>("Addr_agent",null); }
            set { setAttrVal<string>("Addr_agent", value); }
        }
		public string Phone_agent {
            get { return getAttrVal<string>("Phone_agent",null); }
            set { setAttrVal<string>("Phone_agent", value); }
        }
		public string Zip_agent {
            get { return getAttrVal<string>("Zip_agent",null); }
            set { setAttrVal<string>("Zip_agent", value); }
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
		public string Def6 {
            get { return getAttrVal<string>("Def6",null); }
            set { setAttrVal<string>("Def6", value); }
        }
		public string Def7 {
            get { return getAttrVal<string>("Def7",null); }
            set { setAttrVal<string>("Def7", value); }
        }
		public string Def8 {
            get { return getAttrVal<string>("Def8",null); }
            set { setAttrVal<string>("Def8", value); }
        }
		public string Def9 {
            get { return getAttrVal<string>("Def9",null); }
            set { setAttrVal<string>("Def9", value); }
        }
		public string Def10 {
            get { return getAttrVal<string>("Def10",null); }
            set { setAttrVal<string>("Def10", value); }
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
		public string Name_sextp_pat {
            get { return getAttrVal<string>("Name_sextp_pat",null); }
            set { setAttrVal<string>("Name_sextp_pat", value); }
        }
		public string Name_idtp_pat {
            get { return getAttrVal<string>("Name_idtp_pat",null); }
            set { setAttrVal<string>("Name_idtp_pat", value); }
        }
		public string Ent_name_agent {
            get { return getAttrVal<string>("Ent_name_agent",null); }
            set { setAttrVal<string>("Ent_name_agent", value); }
        }
		public string Name_sextp_agent {
            get { return getAttrVal<string>("Name_sextp_agent",null); }
            set { setAttrVal<string>("Name_sextp_agent", value); }
        }
		public string Name_idtp_agent {
            get { return getAttrVal<string>("Name_idtp_agent",null); }
            set { setAttrVal<string>("Name_idtp_agent", value); }
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
            return "ci_orsrv_agent";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_orsrvagent";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.ciord.d.OrSrvAgentInfoDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_orsrvagent", "Id_or", "Id_orsrv", "Id_en", "Id_pat", "Name_pat", "Id_sextp_pat", "Sd_sextp_pat", "Id_idtp_pat", "Sd_idtp_pat", "Idno_pat", "Age_pat", "Id_conttp", "Sd_conttp", "Id_agent", "Name_agent", "Id_sextp_agent", "Sd_sextp_agent", "Id_idtp_agent", "Sd_idtp_agent", "Idno_agent", "Age_agent", "Addr_agent", "Phone_agent", "Zip_agent", "Def1", "Def2", "Def3", "Def4", "Def5", "Def6", "Def7", "Def8", "Def9", "Def10", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Name_sextp_pat", "Name_idtp_pat", "Ent_name_agent", "Name_sextp_agent", "Name_idtp_agent"};
        }
        
    }
}
