
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.ord.cior.d
{
    /// <summary>
    /// OrdApTransDO 的摘要说明。
    /// </summary>
    public class OrdApTransDO : BaseDO {

        public OrdApTransDO() {
        }
		public string Id_ortrans {
            get { return getAttrVal<string>("Id_ortrans",null); }
            set { setAttrVal<string>("Id_ortrans", value); }
        }
		public string Id_or {
            get { return getAttrVal<string>("Id_or",null); }
            set { setAttrVal<string>("Id_or", value); }
        }
		public string Id_dep_to {
            get { return getAttrVal<string>("Id_dep_to",null); }
            set { setAttrVal<string>("Id_dep_to", value); }
        }
		public string Id_dep_nur_to {
            get { return getAttrVal<string>("Id_dep_nur_to",null); }
            set { setAttrVal<string>("Id_dep_nur_to", value); }
        }
		public string Id_dep_from {
            get { return getAttrVal<string>("Id_dep_from",null); }
            set { setAttrVal<string>("Id_dep_from", value); }
        }
		public string Id_dep_nur_from {
            get { return getAttrVal<string>("Id_dep_nur_from",null); }
            set { setAttrVal<string>("Id_dep_nur_from", value); }
        }
		public string Id_su_trans {
            get { return getAttrVal<string>("Id_su_trans",null); }
            set { setAttrVal<string>("Id_su_trans", value); }
        }
		public string Sd_su_trans {
            get { return getAttrVal<string>("Sd_su_trans",null); }
            set { setAttrVal<string>("Sd_su_trans", value); }
        }
		public DateTime? Dt_trans_apply {
            get { return getAttrVal<FDateTime>("Dt_trans_apply",null); }
            set { setAttrVal<FDateTime>("Dt_trans_apply", value); }
        }
		public string Des_rea_canc {
            get { return getAttrVal<string>("Des_rea_canc",null); }
            set { setAttrVal<string>("Des_rea_canc", value); }
        }
		public bool? Fg_tech_trans {
            get { return getAttrVal<FBoolean>("Fg_tech_trans",null); }
            set { setAttrVal<FBoolean>("Fg_tech_trans", value); }
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
		public bool? Fg_crossdept {
            get { return getAttrVal<FBoolean>("Fg_crossdept",null); }
            set { setAttrVal<FBoolean>("Fg_crossdept", value); }
        }
		public DateTime? Dt_effe {
            get { return getAttrVal<FDateTime>("Dt_effe",null); }
            set { setAttrVal<FDateTime>("Dt_effe", value); }
        }
		public DateTime? Dt_end {
            get { return getAttrVal<FDateTime>("Dt_end",null); }
            set { setAttrVal<FDateTime>("Dt_end", value); }
        }
		public string Name_dep_to {
            get { return getAttrVal<string>("Name_dep_to",null); }
            set { setAttrVal<string>("Name_dep_to", value); }
        }
		public string Name_dep_nur_to {
            get { return getAttrVal<string>("Name_dep_nur_to",null); }
            set { setAttrVal<string>("Name_dep_nur_to", value); }
        }
		public string Name_dep_from {
            get { return getAttrVal<string>("Name_dep_from",null); }
            set { setAttrVal<string>("Name_dep_from", value); }
        }
		public string Name_dep_nur_from {
            get { return getAttrVal<string>("Name_dep_nur_from",null); }
            set { setAttrVal<string>("Name_dep_nur_from", value); }
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
            return "ci_ap_trans";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_ortrans";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.cior.d.OrdApTransDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_ortrans", "Id_or", "Id_dep_to", "Id_dep_nur_to", "Id_dep_from", "Id_dep_nur_from", "Id_su_trans", "Sd_su_trans", "Dt_trans_apply", "Des_rea_canc", "Fg_tech_trans", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Fg_crossdept", "Dt_effe", "Dt_end", "Name_dep_to", "Name_dep_nur_to", "Name_dep_from", "Name_dep_nur_from"};
        }
        
    }
}
