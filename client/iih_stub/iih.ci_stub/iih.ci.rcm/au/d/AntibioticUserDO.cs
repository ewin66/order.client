
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.rcm.au.d
{
    /// <summary>
    /// AntibioticUserDO 的摘要说明。
    /// </summary>
    public class AntibioticUserDO : BaseDO {

        public AntibioticUserDO() {
        }
		public string Id_au {
            get { return getAttrVal<string>("Id_au",null); }
            set { setAttrVal<string>("Id_au", value); }
        }
		public bool? Isuseantibi {
            get { return getAttrVal<FBoolean>("Isuseantibi",null); }
            set { setAttrVal<FBoolean>("Isuseantibi", value); }
        }
		public string Drug_name {
            get { return getAttrVal<string>("Drug_name",null); }
            set { setAttrVal<string>("Drug_name", value); }
        }
		public string Id_route_adminis {
            get { return getAttrVal<string>("Id_route_adminis",null); }
            set { setAttrVal<string>("Id_route_adminis", value); }
        }
		public string Sd_route_adminis {
            get { return getAttrVal<string>("Sd_route_adminis",null); }
            set { setAttrVal<string>("Sd_route_adminis", value); }
        }
		public string Name_route_adminis {
            get { return getAttrVal<string>("Name_route_adminis",null); }
            set { setAttrVal<string>("Name_route_adminis", value); }
        }
		public string Dose {
            get { return getAttrVal<string>("Dose",null); }
            set { setAttrVal<string>("Dose", value); }
        }
		public string Id_dose_unit {
            get { return getAttrVal<string>("Id_dose_unit",null); }
            set { setAttrVal<string>("Id_dose_unit", value); }
        }
		public string Sd_dose_unit {
            get { return getAttrVal<string>("Sd_dose_unit",null); }
            set { setAttrVal<string>("Sd_dose_unit", value); }
        }
		public string Name_dose_unit {
            get { return getAttrVal<string>("Name_dose_unit",null); }
            set { setAttrVal<string>("Name_dose_unit", value); }
        }
		public int? Usage {
            get { return getAttrVal<int?>("Usage",null); }
            set { setAttrVal<int?>("Usage", value); }
        }
		public DateTime? Dt_start {
            get { return getAttrVal<FDateTime>("Dt_start",null); }
            set { setAttrVal<FDateTime>("Dt_start", value); }
        }
		public DateTime? Dt_end {
            get { return getAttrVal<FDateTime>("Dt_end",null); }
            set { setAttrVal<FDateTime>("Dt_end", value); }
        }
		public string Id_medi_methods {
            get { return getAttrVal<string>("Id_medi_methods",null); }
            set { setAttrVal<string>("Id_medi_methods", value); }
        }
		public string Sd_medi_methods {
            get { return getAttrVal<string>("Sd_medi_methods",null); }
            set { setAttrVal<string>("Sd_medi_methods", value); }
        }
		public string Name_medi_methods {
            get { return getAttrVal<string>("Name_medi_methods",null); }
            set { setAttrVal<string>("Name_medi_methods", value); }
        }
		public string Id_objective {
            get { return getAttrVal<string>("Id_objective",null); }
            set { setAttrVal<string>("Id_objective", value); }
        }
		public string Sd_objective {
            get { return getAttrVal<string>("Sd_objective",null); }
            set { setAttrVal<string>("Sd_objective", value); }
        }
		public string Name_objective {
            get { return getAttrVal<string>("Name_objective",null); }
            set { setAttrVal<string>("Name_objective", value); }
        }
		public string Id_treat_methods {
            get { return getAttrVal<string>("Id_treat_methods",null); }
            set { setAttrVal<string>("Id_treat_methods", value); }
        }
		public string Sd_treat_methods {
            get { return getAttrVal<string>("Sd_treat_methods",null); }
            set { setAttrVal<string>("Sd_treat_methods", value); }
        }
		public string Name_treat_methods {
            get { return getAttrVal<string>("Name_treat_methods",null); }
            set { setAttrVal<string>("Name_treat_methods", value); }
        }
		public string Id_pre_methods {
            get { return getAttrVal<string>("Id_pre_methods",null); }
            set { setAttrVal<string>("Id_pre_methods", value); }
        }
		public string Sd_pre_methods {
            get { return getAttrVal<string>("Sd_pre_methods",null); }
            set { setAttrVal<string>("Sd_pre_methods", value); }
        }
		public string Name_pre_methods {
            get { return getAttrVal<string>("Name_pre_methods",null); }
            set { setAttrVal<string>("Name_pre_methods", value); }
        }
		public bool? Is_pre_drug_use {
            get { return getAttrVal<FBoolean>("Is_pre_drug_use",null); }
            set { setAttrVal<FBoolean>("Is_pre_drug_use", value); }
        }
		public string Id_pre_effect {
            get { return getAttrVal<string>("Id_pre_effect",null); }
            set { setAttrVal<string>("Id_pre_effect", value); }
        }
		public string Sd_pre_effect {
            get { return getAttrVal<string>("Sd_pre_effect",null); }
            set { setAttrVal<string>("Sd_pre_effect", value); }
        }
		public string Name_pre_effect {
            get { return getAttrVal<string>("Name_pre_effect",null); }
            set { setAttrVal<string>("Name_pre_effect", value); }
        }
		public string Id_com_medi {
            get { return getAttrVal<string>("Id_com_medi",null); }
            set { setAttrVal<string>("Id_com_medi", value); }
        }
		public string Sd_com_medi {
            get { return getAttrVal<string>("Sd_com_medi",null); }
            set { setAttrVal<string>("Sd_com_medi", value); }
        }
		public string Name_com_medi {
            get { return getAttrVal<string>("Name_com_medi",null); }
            set { setAttrVal<string>("Name_com_medi", value); }
        }
		public string Pre_medi_time {
            get { return getAttrVal<string>("Pre_medi_time",null); }
            set { setAttrVal<string>("Pre_medi_time", value); }
        }
		public int? Days_after_oper {
            get { return getAttrVal<int?>("Days_after_oper",null); }
            set { setAttrVal<int?>("Days_after_oper", value); }
        }
		public bool? Adv_drug_reactions {
            get { return getAttrVal<FBoolean>("Adv_drug_reactions",null); }
            set { setAttrVal<FBoolean>("Adv_drug_reactions", value); }
        }
		public bool? Double_infection {
            get { return getAttrVal<FBoolean>("Double_infection",null); }
            set { setAttrVal<FBoolean>("Double_infection", value); }
        }
		public string Route_adminis_code {
            get { return getAttrVal<string>("Route_adminis_code",null); }
            set { setAttrVal<string>("Route_adminis_code", value); }
        }
		public string Route_adminis_name {
            get { return getAttrVal<string>("Route_adminis_name",null); }
            set { setAttrVal<string>("Route_adminis_name", value); }
        }
		public string Dose_unit_code {
            get { return getAttrVal<string>("Dose_unit_code",null); }
            set { setAttrVal<string>("Dose_unit_code", value); }
        }
		public string Dose_unit_name {
            get { return getAttrVal<string>("Dose_unit_name",null); }
            set { setAttrVal<string>("Dose_unit_name", value); }
        }
		public string Medi_methods_code {
            get { return getAttrVal<string>("Medi_methods_code",null); }
            set { setAttrVal<string>("Medi_methods_code", value); }
        }
		public string Medi_methods_name {
            get { return getAttrVal<string>("Medi_methods_name",null); }
            set { setAttrVal<string>("Medi_methods_name", value); }
        }
		public string Objective_code {
            get { return getAttrVal<string>("Objective_code",null); }
            set { setAttrVal<string>("Objective_code", value); }
        }
		public string Objective_name {
            get { return getAttrVal<string>("Objective_name",null); }
            set { setAttrVal<string>("Objective_name", value); }
        }
		public string Treat_methods_code {
            get { return getAttrVal<string>("Treat_methods_code",null); }
            set { setAttrVal<string>("Treat_methods_code", value); }
        }
		public string Treat_methods_name {
            get { return getAttrVal<string>("Treat_methods_name",null); }
            set { setAttrVal<string>("Treat_methods_name", value); }
        }
		public string Pre_methods_code {
            get { return getAttrVal<string>("Pre_methods_code",null); }
            set { setAttrVal<string>("Pre_methods_code", value); }
        }
		public string Pre_methods_name {
            get { return getAttrVal<string>("Pre_methods_name",null); }
            set { setAttrVal<string>("Pre_methods_name", value); }
        }
		public string Pre_effect_code {
            get { return getAttrVal<string>("Pre_effect_code",null); }
            set { setAttrVal<string>("Pre_effect_code", value); }
        }
		public string Pre_effect_name {
            get { return getAttrVal<string>("Pre_effect_name",null); }
            set { setAttrVal<string>("Pre_effect_name", value); }
        }
		public string Com_medi_code {
            get { return getAttrVal<string>("Com_medi_code",null); }
            set { setAttrVal<string>("Com_medi_code", value); }
        }
		public string Com_medi_name {
            get { return getAttrVal<string>("Com_medi_name",null); }
            set { setAttrVal<string>("Com_medi_name", value); }
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
            return "CI_MR_CONTAGION_CARD_AU";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_au";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.rcm.au.d.AntibioticUserDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_au", "Isuseantibi", "Drug_name", "Id_route_adminis", "Sd_route_adminis", "Name_route_adminis", "Dose", "Id_dose_unit", "Sd_dose_unit", "Name_dose_unit", "Usage", "Dt_start", "Dt_end", "Id_medi_methods", "Sd_medi_methods", "Name_medi_methods", "Id_objective", "Sd_objective", "Name_objective", "Id_treat_methods", "Sd_treat_methods", "Name_treat_methods", "Id_pre_methods", "Sd_pre_methods", "Name_pre_methods", "Is_pre_drug_use", "Id_pre_effect", "Sd_pre_effect", "Name_pre_effect", "Id_com_medi", "Sd_com_medi", "Name_com_medi", "Pre_medi_time", "Days_after_oper", "Adv_drug_reactions", "Double_infection", "Route_adminis_code", "Route_adminis_name", "Dose_unit_code", "Dose_unit_name", "Medi_methods_code", "Medi_methods_name", "Objective_code", "Objective_name", "Treat_methods_code", "Treat_methods_name", "Pre_methods_code", "Pre_methods_name", "Pre_effect_code", "Pre_effect_name", "Com_medi_code", "Com_medi_name"};
        }
        
    }
}
