
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.rcm.operinciinfect.d
{
    /// <summary>
    /// OperIncInfectDO 的摘要说明。
    /// </summary>
    public class OperIncInfectDO : BaseDO {

        public OperIncInfectDO() {
            this.Isemergency = false;
            this.Iscauseinci = false;
            this.Is_inci_infection = false;
        }
		public string Id_operinciinfect {
            get { return getAttrVal<string>("Id_operinciinfect",null); }
            set { setAttrVal<string>("Id_operinciinfect", value); }
        }
		public string Id_hospitalreport {
            get { return getAttrVal<string>("Id_hospitalreport",null); }
            set { setAttrVal<string>("Id_hospitalreport", value); }
        }
		public string Id_oper {
            get { return getAttrVal<string>("Id_oper",null); }
            set { setAttrVal<string>("Id_oper", value); }
        }
		public string Sd_oper {
            get { return getAttrVal<string>("Sd_oper",null); }
            set { setAttrVal<string>("Sd_oper", value); }
        }
		public string Name_oper {
            get { return getAttrVal<string>("Name_oper",null); }
            set { setAttrVal<string>("Name_oper", value); }
        }
		public bool? Isemergency {
            get { return getAttrVal<FBoolean>("Isemergency",false); }
            set { setAttrVal<FBoolean>("Isemergency", value); }
        }
		public string Id_oper_type {
            get { return getAttrVal<string>("Id_oper_type",null); }
            set { setAttrVal<string>("Id_oper_type", value); }
        }
		public string Sd_oper_type {
            get { return getAttrVal<string>("Sd_oper_type",null); }
            set { setAttrVal<string>("Sd_oper_type", value); }
        }
		public string Name_oper_type {
            get { return getAttrVal<string>("Name_oper_type",null); }
            set { setAttrVal<string>("Name_oper_type", value); }
        }
		public string Id_type_surinci {
            get { return getAttrVal<string>("Id_type_surinci",null); }
            set { setAttrVal<string>("Id_type_surinci", value); }
        }
		public string Sd_type_surinci {
            get { return getAttrVal<string>("Sd_type_surinci",null); }
            set { setAttrVal<string>("Sd_type_surinci", value); }
        }
		public string Name_type_surinci {
            get { return getAttrVal<string>("Name_type_surinci",null); }
            set { setAttrVal<string>("Name_type_surinci", value); }
        }
		public bool? Iscauseinci {
            get { return getAttrVal<FBoolean>("Iscauseinci",false); }
            set { setAttrVal<FBoolean>("Iscauseinci", value); }
        }
		public DateTime? Dt_start {
            get { return getAttrVal<FDateTime>("Dt_start",null); }
            set { setAttrVal<FDateTime>("Dt_start", value); }
        }
		public DateTime? Dt_end {
            get { return getAttrVal<FDateTime>("Dt_end",null); }
            set { setAttrVal<FDateTime>("Dt_end", value); }
        }
		public string Id_anes_methods {
            get { return getAttrVal<string>("Id_anes_methods",null); }
            set { setAttrVal<string>("Id_anes_methods", value); }
        }
		public string Sd_anes_methods {
            get { return getAttrVal<string>("Sd_anes_methods",null); }
            set { setAttrVal<string>("Sd_anes_methods", value); }
        }
		public string Name_anes_methods {
            get { return getAttrVal<string>("Name_anes_methods",null); }
            set { setAttrVal<string>("Name_anes_methods", value); }
        }
		public string Oper_doctor {
            get { return getAttrVal<string>("Oper_doctor",null); }
            set { setAttrVal<string>("Oper_doctor", value); }
        }
		public string Tech_title {
            get { return getAttrVal<string>("Tech_title",null); }
            set { setAttrVal<string>("Tech_title", value); }
        }
		public string Id_incision_type {
            get { return getAttrVal<string>("Id_incision_type",null); }
            set { setAttrVal<string>("Id_incision_type", value); }
        }
		public string Sd_incision_type {
            get { return getAttrVal<string>("Sd_incision_type",null); }
            set { setAttrVal<string>("Sd_incision_type", value); }
        }
		public string Name_incision_type {
            get { return getAttrVal<string>("Name_incision_type",null); }
            set { setAttrVal<string>("Name_incision_type", value); }
        }
		public string Id_heal_condition {
            get { return getAttrVal<string>("Id_heal_condition",null); }
            set { setAttrVal<string>("Id_heal_condition", value); }
        }
		public string Sd_heal_condition {
            get { return getAttrVal<string>("Sd_heal_condition",null); }
            set { setAttrVal<string>("Sd_heal_condition", value); }
        }
		public string Name_heal_condition {
            get { return getAttrVal<string>("Name_heal_condition",null); }
            set { setAttrVal<string>("Name_heal_condition", value); }
        }
		public bool? Is_inci_infection {
            get { return getAttrVal<FBoolean>("Is_inci_infection",false); }
            set { setAttrVal<FBoolean>("Is_inci_infection", value); }
        }
		public string Id_type_surg_siteinfe {
            get { return getAttrVal<string>("Id_type_surg_siteinfe",null); }
            set { setAttrVal<string>("Id_type_surg_siteinfe", value); }
        }
		public string Sd_type_surg_siteinfe {
            get { return getAttrVal<string>("Sd_type_surg_siteinfe",null); }
            set { setAttrVal<string>("Sd_type_surg_siteinfe", value); }
        }
		public string Name_type_surg_siteinfe {
            get { return getAttrVal<string>("Name_type_surg_siteinfe",null); }
            set { setAttrVal<string>("Name_type_surg_siteinfe", value); }
        }
		public int? Count_white_cell {
            get { return getAttrVal<int?>("Count_white_cell",null); }
            set { setAttrVal<int?>("Count_white_cell", value); }
        }
		public string Id_asa_score {
            get { return getAttrVal<string>("Id_asa_score",null); }
            set { setAttrVal<string>("Id_asa_score", value); }
        }
		public string Sd_asa_score {
            get { return getAttrVal<string>("Sd_asa_score",null); }
            set { setAttrVal<string>("Sd_asa_score", value); }
        }
		public string Name_asa_score {
            get { return getAttrVal<string>("Name_asa_score",null); }
            set { setAttrVal<string>("Name_asa_score", value); }
        }
		public string Id_class_phy_condition {
            get { return getAttrVal<string>("Id_class_phy_condition",null); }
            set { setAttrVal<string>("Id_class_phy_condition", value); }
        }
		public string Sd_class_phy_condition {
            get { return getAttrVal<string>("Sd_class_phy_condition",null); }
            set { setAttrVal<string>("Sd_class_phy_condition", value); }
        }
		public string Name_class_phy_condition {
            get { return getAttrVal<string>("Name_class_phy_condition",null); }
            set { setAttrVal<string>("Name_class_phy_condition", value); }
        }
		public string Id_mult_oper {
            get { return getAttrVal<string>("Id_mult_oper",null); }
            set { setAttrVal<string>("Id_mult_oper", value); }
        }
		public string Sd_mult_oper {
            get { return getAttrVal<string>("Sd_mult_oper",null); }
            set { setAttrVal<string>("Sd_mult_oper", value); }
        }
		public string Name_mult_oper {
            get { return getAttrVal<string>("Name_mult_oper",null); }
            set { setAttrVal<string>("Name_mult_oper", value); }
        }
		public string Id_endos_surg {
            get { return getAttrVal<string>("Id_endos_surg",null); }
            set { setAttrVal<string>("Id_endos_surg", value); }
        }
		public string Sd_endos_surg {
            get { return getAttrVal<string>("Sd_endos_surg",null); }
            set { setAttrVal<string>("Sd_endos_surg", value); }
        }
		public string Name_endos_surg {
            get { return getAttrVal<string>("Name_endos_surg",null); }
            set { setAttrVal<string>("Name_endos_surg", value); }
        }
		public string Id_pros_graft {
            get { return getAttrVal<string>("Id_pros_graft",null); }
            set { setAttrVal<string>("Id_pros_graft", value); }
        }
		public string Sd_pros_graft {
            get { return getAttrVal<string>("Sd_pros_graft",null); }
            set { setAttrVal<string>("Sd_pros_graft", value); }
        }
		public string Name_pros_graft {
            get { return getAttrVal<string>("Name_pros_graft",null); }
            set { setAttrVal<string>("Name_pros_graft", value); }
        }
		public string Id_surg_site_nfe {
            get { return getAttrVal<string>("Id_surg_site_nfe",null); }
            set { setAttrVal<string>("Id_surg_site_nfe", value); }
        }
		public string Sd_surg_site_nfe {
            get { return getAttrVal<string>("Sd_surg_site_nfe",null); }
            set { setAttrVal<string>("Sd_surg_site_nfe", value); }
        }
		public string Name_surg_site_nfe {
            get { return getAttrVal<string>("Name_surg_site_nfe",null); }
            set { setAttrVal<string>("Name_surg_site_nfe", value); }
        }
		public string Oper_code {
            get { return getAttrVal<string>("Oper_code",null); }
            set { setAttrVal<string>("Oper_code", value); }
        }
		public string Oper_name {
            get { return getAttrVal<string>("Oper_name",null); }
            set { setAttrVal<string>("Oper_name", value); }
        }
		public string Oper_type_code {
            get { return getAttrVal<string>("Oper_type_code",null); }
            set { setAttrVal<string>("Oper_type_code", value); }
        }
		public string Oper_type_name {
            get { return getAttrVal<string>("Oper_type_name",null); }
            set { setAttrVal<string>("Oper_type_name", value); }
        }
		public string Type_surinci_code {
            get { return getAttrVal<string>("Type_surinci_code",null); }
            set { setAttrVal<string>("Type_surinci_code", value); }
        }
		public string Type_surinci_name {
            get { return getAttrVal<string>("Type_surinci_name",null); }
            set { setAttrVal<string>("Type_surinci_name", value); }
        }
		public string Anes_methods_code {
            get { return getAttrVal<string>("Anes_methods_code",null); }
            set { setAttrVal<string>("Anes_methods_code", value); }
        }
		public string Anes_methods_name {
            get { return getAttrVal<string>("Anes_methods_name",null); }
            set { setAttrVal<string>("Anes_methods_name", value); }
        }
		public string Incision_type_code {
            get { return getAttrVal<string>("Incision_type_code",null); }
            set { setAttrVal<string>("Incision_type_code", value); }
        }
		public string Incision_type_name {
            get { return getAttrVal<string>("Incision_type_name",null); }
            set { setAttrVal<string>("Incision_type_name", value); }
        }
		public string Heal_condition_code {
            get { return getAttrVal<string>("Heal_condition_code",null); }
            set { setAttrVal<string>("Heal_condition_code", value); }
        }
		public string Heal_condition_name {
            get { return getAttrVal<string>("Heal_condition_name",null); }
            set { setAttrVal<string>("Heal_condition_name", value); }
        }
		public string Type_surg_siteinfe_code {
            get { return getAttrVal<string>("Type_surg_siteinfe_code",null); }
            set { setAttrVal<string>("Type_surg_siteinfe_code", value); }
        }
		public string Type_surg_siteinfe_name {
            get { return getAttrVal<string>("Type_surg_siteinfe_name",null); }
            set { setAttrVal<string>("Type_surg_siteinfe_name", value); }
        }
		public string Asa_score_code {
            get { return getAttrVal<string>("Asa_score_code",null); }
            set { setAttrVal<string>("Asa_score_code", value); }
        }
		public string Asa_score_name {
            get { return getAttrVal<string>("Asa_score_name",null); }
            set { setAttrVal<string>("Asa_score_name", value); }
        }
		public string Class_phy_condition_code {
            get { return getAttrVal<string>("Class_phy_condition_code",null); }
            set { setAttrVal<string>("Class_phy_condition_code", value); }
        }
		public string Class_phy_condition_name {
            get { return getAttrVal<string>("Class_phy_condition_name",null); }
            set { setAttrVal<string>("Class_phy_condition_name", value); }
        }
		public string Mult_oper_code {
            get { return getAttrVal<string>("Mult_oper_code",null); }
            set { setAttrVal<string>("Mult_oper_code", value); }
        }
		public string Mult_oper_name {
            get { return getAttrVal<string>("Mult_oper_name",null); }
            set { setAttrVal<string>("Mult_oper_name", value); }
        }
		public string Endos_surg_code {
            get { return getAttrVal<string>("Endos_surg_code",null); }
            set { setAttrVal<string>("Endos_surg_code", value); }
        }
		public string Endos_surg_name {
            get { return getAttrVal<string>("Endos_surg_name",null); }
            set { setAttrVal<string>("Endos_surg_name", value); }
        }
		public string Pros_graft_code {
            get { return getAttrVal<string>("Pros_graft_code",null); }
            set { setAttrVal<string>("Pros_graft_code", value); }
        }
		public string Pros_graft_name {
            get { return getAttrVal<string>("Pros_graft_name",null); }
            set { setAttrVal<string>("Pros_graft_name", value); }
        }
		public string Surg_site_nfe_code {
            get { return getAttrVal<string>("Surg_site_nfe_code",null); }
            set { setAttrVal<string>("Surg_site_nfe_code", value); }
        }
		public string Surg_site_nfe_name {
            get { return getAttrVal<string>("Surg_site_nfe_name",null); }
            set { setAttrVal<string>("Surg_site_nfe_name", value); }
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
            return "CI_MR_CONTAGION_CARD_INCISION";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_operinciinfect";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.rcm.operinciinfect.d.OperIncInfectDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_operinciinfect", "Id_hospitalreport", "Id_oper", "Sd_oper", "Name_oper", "Isemergency", "Id_oper_type", "Sd_oper_type", "Name_oper_type", "Id_type_surinci", "Sd_type_surinci", "Name_type_surinci", "Iscauseinci", "Dt_start", "Dt_end", "Id_anes_methods", "Sd_anes_methods", "Name_anes_methods", "Oper_doctor", "Tech_title", "Id_incision_type", "Sd_incision_type", "Name_incision_type", "Id_heal_condition", "Sd_heal_condition", "Name_heal_condition", "Is_inci_infection", "Id_type_surg_siteinfe", "Sd_type_surg_siteinfe", "Name_type_surg_siteinfe", "Count_white_cell", "Id_asa_score", "Sd_asa_score", "Name_asa_score", "Id_class_phy_condition", "Sd_class_phy_condition", "Name_class_phy_condition", "Id_mult_oper", "Sd_mult_oper", "Name_mult_oper", "Id_endos_surg", "Sd_endos_surg", "Name_endos_surg", "Id_pros_graft", "Sd_pros_graft", "Name_pros_graft", "Id_surg_site_nfe", "Sd_surg_site_nfe", "Name_surg_site_nfe", "Oper_code", "Oper_name", "Oper_type_code", "Oper_type_name", "Type_surinci_code", "Type_surinci_name", "Anes_methods_code", "Anes_methods_name", "Incision_type_code", "Incision_type_name", "Heal_condition_code", "Heal_condition_name", "Type_surg_siteinfe_code", "Type_surg_siteinfe_name", "Asa_score_code", "Asa_score_name", "Class_phy_condition_code", "Class_phy_condition_name", "Mult_oper_code", "Mult_oper_name", "Endos_surg_code", "Endos_surg_name", "Pros_graft_code", "Pros_graft_name", "Surg_site_nfe_code", "Surg_site_nfe_name"};
        }
        
    }
}
