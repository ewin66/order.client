
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.cipres.d
{
    /// <summary>
    /// ${EntityMeta.fullClassName} 的摘要说明。
    /// </summary>
    public class CiPresDO : BaseDO {

        public CiPresDO() {
        }
		public string Id_pres {
            get { return getAttrVal<string>("Id_pres",null); }
            set { setAttrVal<string>("Id_pres", value); }
        }
		public string Id_org {
            get { return getAttrVal<string>("Id_org",null); }
            set { setAttrVal<string>("Id_org", value); }
        }
		public string Id_grp {
            get { return getAttrVal<string>("Id_grp",null); }
            set { setAttrVal<string>("Id_grp", value); }
        }
		public string Sd_entp {
            get { return getAttrVal<string>("Sd_entp",null); }
            set { setAttrVal<string>("Sd_entp", value); }
        }
		public string Id_entp {
            get { return getAttrVal<string>("Id_entp",null); }
            set { setAttrVal<string>("Id_entp", value); }
        }
		public string Id_en {
            get { return getAttrVal<string>("Id_en",null); }
            set { setAttrVal<string>("Id_en", value); }
        }
		public string Id_di {
            get { return getAttrVal<string>("Id_di",null); }
            set { setAttrVal<string>("Id_di", value); }
        }
		public string Id_diitm {
            get { return getAttrVal<string>("Id_diitm",null); }
            set { setAttrVal<string>("Id_diitm", value); }
        }
		public string Str_id_di {
            get { return getAttrVal<string>("Str_id_di",null); }
            set { setAttrVal<string>("Str_id_di", value); }
        }
		public string Str_name_di {
            get { return getAttrVal<string>("Str_name_di",null); }
            set { setAttrVal<string>("Str_name_di", value); }
        }
		public string Sd_srvtp {
            get { return getAttrVal<string>("Sd_srvtp",null); }
            set { setAttrVal<string>("Sd_srvtp", value); }
        }
		public string Id_srvtp {
            get { return getAttrVal<string>("Id_srvtp",null); }
            set { setAttrVal<string>("Id_srvtp", value); }
        }
		public string Sd_prestp {
            get { return getAttrVal<string>("Sd_prestp",null); }
            set { setAttrVal<string>("Sd_prestp", value); }
        }
		public string Id_prestp {
            get { return getAttrVal<string>("Id_prestp",null); }
            set { setAttrVal<string>("Id_prestp", value); }
        }
		public string Code {
            get { return getAttrVal<string>("Code",null); }
            set { setAttrVal<string>("Code", value); }
        }
		public string Name {
            get { return getAttrVal<string>("Name",null); }
            set { setAttrVal<string>("Name", value); }
        }
		public string Id_dep_or {
            get { return getAttrVal<string>("Id_dep_or",null); }
            set { setAttrVal<string>("Id_dep_or", value); }
        }
		public string Id_emp_or {
            get { return getAttrVal<string>("Id_emp_or",null); }
            set { setAttrVal<string>("Id_emp_or", value); }
        }
		public DateTime? Dt_entry {
            get { return getAttrVal<FDateTime>("Dt_entry",null); }
            set { setAttrVal<FDateTime>("Dt_entry", value); }
        }
		public bool? Fg_bb {
            get { return getAttrVal<FBoolean>("Fg_bb",null); }
            set { setAttrVal<FBoolean>("Fg_bb", value); }
        }
		public int? No_bb {
            get { return getAttrVal<int?>("No_bb",null); }
            set { setAttrVal<int?>("No_bb", value); }
        }
		public string Id_bb {
            get { return getAttrVal<string>("Id_bb",null); }
            set { setAttrVal<string>("Id_bb", value); }
        }
		public string Id_usg {
            get { return getAttrVal<string>("Id_usg",null); }
            set { setAttrVal<string>("Id_usg", value); }
        }
		public string Des_usg {
            get { return getAttrVal<string>("Des_usg",null); }
            set { setAttrVal<string>("Des_usg", value); }
        }
		public bool? Fg_dispense {
            get { return getAttrVal<FBoolean>("Fg_dispense",null); }
            set { setAttrVal<FBoolean>("Fg_dispense", value); }
        }
		public string Sd_backtp {
            get { return getAttrVal<string>("Sd_backtp",null); }
            set { setAttrVal<string>("Sd_backtp", value); }
        }
		public string Id_backtp {
            get { return getAttrVal<string>("Id_backtp",null); }
            set { setAttrVal<string>("Id_backtp", value); }
        }
		public bool? Fg_back {
            get { return getAttrVal<FBoolean>("Fg_back",null); }
            set { setAttrVal<FBoolean>("Fg_back", value); }
        }
		public string Id_pres_rel {
            get { return getAttrVal<string>("Id_pres_rel",null); }
            set { setAttrVal<string>("Id_pres_rel", value); }
        }
		public string Id_emp {
            get { return getAttrVal<string>("Id_emp",null); }
            set { setAttrVal<string>("Id_emp", value); }
        }
		public bool? Fg_prn {
            get { return getAttrVal<FBoolean>("Fg_prn",null); }
            set { setAttrVal<FBoolean>("Fg_prn", value); }
        }
		public bool? Fg_prn_add {
            get { return getAttrVal<FBoolean>("Fg_prn_add",null); }
            set { setAttrVal<FBoolean>("Fg_prn_add", value); }
        }
		public string Id_pres_rel_add {
            get { return getAttrVal<string>("Id_pres_rel_add",null); }
            set { setAttrVal<string>("Id_pres_rel_add", value); }
        }
		public string Sd_su_bl {
            get { return getAttrVal<string>("Sd_su_bl",null); }
            set { setAttrVal<string>("Sd_su_bl", value); }
        }
		public string Id_su_bl {
            get { return getAttrVal<string>("Id_su_bl",null); }
            set { setAttrVal<string>("Id_su_bl", value); }
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
            return "CI_PRES";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_pres";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.cipres.d.CiPresDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_pres", "Id_org", "Id_grp", "Sd_entp", "Id_entp", "Id_en", "Id_di", "Id_diitm", "Str_id_di", "Str_name_di", "Sd_srvtp", "Id_srvtp", "Sd_prestp", "Id_prestp", "Code", "Name", "Id_dep_or", "Id_emp_or", "Dt_entry", "Fg_bb", "No_bb", "Id_bb", "Id_usg", "Des_usg", "Fg_dispense", "Sd_backtp", "Id_backtp", "Fg_back", "Id_pres_rel", "Id_emp", "Fg_prn", "Fg_prn_add", "Id_pres_rel_add", "Sd_su_bl", "Id_su_bl", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime"};
        }
        
    }
}
