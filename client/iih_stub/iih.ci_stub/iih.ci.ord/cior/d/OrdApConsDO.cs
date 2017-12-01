
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.ord.cior.d
{
    /// <summary>
    /// OrdApConsDO 的摘要说明。
    /// </summary>
    public class OrdApConsDO : BaseDO {

        public OrdApConsDO() {
            this.Fg_prn = false;
            this.Cnt_prn = 0;
        }
		public string Id_apcons {
            get { return getAttrVal<string>("Id_apcons",null); }
            set { setAttrVal<string>("Id_apcons", value); }
        }
		public string Id_or {
            get { return getAttrVal<string>("Id_or",null); }
            set { setAttrVal<string>("Id_or", value); }
        }
		public string No_applyform {
            get { return getAttrVal<string>("No_applyform",null); }
            set { setAttrVal<string>("No_applyform", value); }
        }
		public string Id_constp {
            get { return getAttrVal<string>("Id_constp",null); }
            set { setAttrVal<string>("Id_constp", value); }
        }
		public string Sd_constp {
            get { return getAttrVal<string>("Sd_constp",null); }
            set { setAttrVal<string>("Sd_constp", value); }
        }
		public DateTime? Dt_ap {
            get { return getAttrVal<FDateTime>("Dt_ap",null); }
            set { setAttrVal<FDateTime>("Dt_ap", value); }
        }
		public string Tel {
            get { return getAttrVal<string>("Tel",null); }
            set { setAttrVal<string>("Tel", value); }
        }
		public string Des_emr {
            get { return getAttrVal<string>("Des_emr",null); }
            set { setAttrVal<string>("Des_emr", value); }
        }
		public DateTime? Dt_plan {
            get { return getAttrVal<FDateTime>("Dt_plan",null); }
            set { setAttrVal<FDateTime>("Dt_plan", value); }
        }
		public string Place {
            get { return getAttrVal<string>("Place",null); }
            set { setAttrVal<string>("Place", value); }
        }
		public string Des_psp {
            get { return getAttrVal<string>("Des_psp",null); }
            set { setAttrVal<string>("Des_psp", value); }
        }
		public string Id_su_cons {
            get { return getAttrVal<string>("Id_su_cons",null); }
            set { setAttrVal<string>("Id_su_cons", value); }
        }
		public string Sd_su_cons {
            get { return getAttrVal<string>("Sd_su_cons",null); }
            set { setAttrVal<string>("Sd_su_cons", value); }
        }
		public bool? Fg_urgent {
            get { return getAttrVal<FBoolean>("Fg_urgent",null); }
            set { setAttrVal<FBoolean>("Fg_urgent", value); }
        }
		public string Des_dep {
            get { return getAttrVal<string>("Des_dep",null); }
            set { setAttrVal<string>("Des_dep", value); }
        }
		public DateTime? Dt_constimelimit {
            get { return getAttrVal<FDateTime>("Dt_constimelimit",null); }
            set { setAttrVal<FDateTime>("Dt_constimelimit", value); }
        }
		public bool? Fg_audit_clidep {
            get { return getAttrVal<FBoolean>("Fg_audit_clidep",null); }
            set { setAttrVal<FBoolean>("Fg_audit_clidep", value); }
        }
		public bool? Fg_audit_admdep {
            get { return getAttrVal<FBoolean>("Fg_audit_admdep",null); }
            set { setAttrVal<FBoolean>("Fg_audit_admdep", value); }
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
		public bool? Fg_prn {
            get { return getAttrVal<FBoolean>("Fg_prn",false); }
            set { setAttrVal<FBoolean>("Fg_prn", value); }
        }
		public int? Cnt_prn {
            get { return getAttrVal<int?>("Cnt_prn",0); }
            set { setAttrVal<int?>("Cnt_prn", value); }
        }
		public string Name_constp {
            get { return getAttrVal<string>("Name_constp",null); }
            set { setAttrVal<string>("Name_constp", value); }
        }
		public string Name_su_cons {
            get { return getAttrVal<string>("Name_su_cons",null); }
            set { setAttrVal<string>("Name_su_cons", value); }
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
            return "ci_ap_cons";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_apcons";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.cior.d.OrdApConsDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_apcons", "Id_or", "No_applyform", "Id_constp", "Sd_constp", "Dt_ap", "Tel", "Des_emr", "Dt_plan", "Place", "Des_psp", "Id_su_cons", "Sd_su_cons", "Fg_urgent", "Des_dep", "Dt_constimelimit", "Fg_audit_clidep", "Fg_audit_admdep", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Fg_prn", "Cnt_prn", "Name_constp", "Name_su_cons"};
        }
        
    }
}
