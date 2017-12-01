
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.ord.ordsrvset.d
{
    /// <summary>
    /// OrdSrvSetDO 的摘要说明。
    /// </summary>
    public class OrdSrvSetDO : BaseDO {

        public OrdSrvSetDO() {
        }
		public string Id_orsrvset {
            get { return getAttrVal<string>("Id_orsrvset",null); }
            set { setAttrVal<string>("Id_orsrvset", value); }
        }
		public string Id_orsrv {
            get { return getAttrVal<string>("Id_orsrv",null); }
            set { setAttrVal<string>("Id_orsrv", value); }
        }
		public string Id_or {
            get { return getAttrVal<string>("Id_or",null); }
            set { setAttrVal<string>("Id_or", value); }
        }
		public string Id_srvsetdef {
            get { return getAttrVal<string>("Id_srvsetdef",null); }
            set { setAttrVal<string>("Id_srvsetdef", value); }
        }
		public string Id_srvset {
            get { return getAttrVal<string>("Id_srvset",null); }
            set { setAttrVal<string>("Id_srvset", value); }
        }
		public int? Sortno {
            get { return getAttrVal<int?>("Sortno",null); }
            set { setAttrVal<int?>("Sortno", value); }
        }
		public string Des_srv {
            get { return getAttrVal<string>("Des_srv",null); }
            set { setAttrVal<string>("Des_srv", value); }
        }
		public string Id_srvsetrole {
            get { return getAttrVal<string>("Id_srvsetrole",null); }
            set { setAttrVal<string>("Id_srvsetrole", value); }
        }
		public string Sd_srvsetrole {
            get { return getAttrVal<string>("Sd_srvsetrole",null); }
            set { setAttrVal<string>("Sd_srvsetrole", value); }
        }
		public string Id_medu {
            get { return getAttrVal<string>("Id_medu",null); }
            set { setAttrVal<string>("Id_medu", value); }
        }
		public double? Quan_medu {
            get { return getAttrVal<FDouble>("Quan_medu",null); }
            set { setAttrVal<FDouble>("Quan_medu", value); }
        }
		public string Id_freqdef {
            get { return getAttrVal<string>("Id_freqdef",null); }
            set { setAttrVal<string>("Id_freqdef", value); }
        }
		public string Sd_body {
            get { return getAttrVal<string>("Sd_body",null); }
            set { setAttrVal<string>("Sd_body", value); }
        }
		public string Body_name {
            get { return getAttrVal<string>("Body_name",null); }
            set { setAttrVal<string>("Body_name", value); }
        }
		public string Sd_pos {
            get { return getAttrVal<string>("Sd_pos",null); }
            set { setAttrVal<string>("Sd_pos", value); }
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
		public bool? Fg_clinical {
            get { return getAttrVal<FBoolean>("Fg_clinical",null); }
            set { setAttrVal<FBoolean>("Fg_clinical", value); }
        }
		public bool? Fg_clinical_bl {
            get { return getAttrVal<FBoolean>("Fg_clinical_bl",null); }
            set { setAttrVal<FBoolean>("Fg_clinical_bl", value); }
        }
		public string Id_body {
            get { return getAttrVal<string>("Id_body",null); }
            set { setAttrVal<string>("Id_body", value); }
        }
		public string Id_pos {
            get { return getAttrVal<string>("Id_pos",null); }
            set { setAttrVal<string>("Id_pos", value); }
        }
		public string Id_route {
            get { return getAttrVal<string>("Id_route",null); }
            set { setAttrVal<string>("Id_route", value); }
        }
		public string Id_routedes {
            get { return getAttrVal<string>("Id_routedes",null); }
            set { setAttrVal<string>("Id_routedes", value); }
        }
		public string Set_name {
            get { return getAttrVal<string>("Set_name",null); }
            set { setAttrVal<string>("Set_name", value); }
        }
		public string Set_id_srvca {
            get { return getAttrVal<string>("Set_id_srvca",null); }
            set { setAttrVal<string>("Set_id_srvca", value); }
        }
		public string Set_sd_srvtp {
            get { return getAttrVal<string>("Set_sd_srvtp",null); }
            set { setAttrVal<string>("Set_sd_srvtp", value); }
        }
		public string Name {
            get { return getAttrVal<string>("Name",null); }
            set { setAttrVal<string>("Name", value); }
        }
		public string Code {
            get { return getAttrVal<string>("Code",null); }
            set { setAttrVal<string>("Code", value); }
        }
		public string Srvrole_name {
            get { return getAttrVal<string>("Srvrole_name",null); }
            set { setAttrVal<string>("Srvrole_name", value); }
        }
		public string Code_route {
            get { return getAttrVal<string>("Code_route",null); }
            set { setAttrVal<string>("Code_route", value); }
        }
		public string Name_route {
            get { return getAttrVal<string>("Name_route",null); }
            set { setAttrVal<string>("Name_route", value); }
        }
		public string Code_routedes {
            get { return getAttrVal<string>("Code_routedes",null); }
            set { setAttrVal<string>("Code_routedes", value); }
        }
		public string Name_routedes {
            get { return getAttrVal<string>("Name_routedes",null); }
            set { setAttrVal<string>("Name_routedes", value); }
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
            return "ci_or_srv_set";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_orsrvset";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.ordsrvset.d.OrdSrvSetDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_orsrvset", "Id_orsrv", "Id_or", "Id_srvsetdef", "Id_srvset", "Sortno", "Des_srv", "Id_srvsetrole", "Sd_srvsetrole", "Id_medu", "Quan_medu", "Id_freqdef", "Sd_body", "Body_name", "Sd_pos", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Fg_clinical", "Fg_clinical_bl", "Id_body", "Id_pos", "Id_route", "Id_routedes", "Set_name", "Set_id_srvca", "Set_sd_srvtp", "Name", "Code", "Srvrole_name", "Code_route", "Name_route", "Code_routedes", "Name_routedes"};
        }
        
    }
}
