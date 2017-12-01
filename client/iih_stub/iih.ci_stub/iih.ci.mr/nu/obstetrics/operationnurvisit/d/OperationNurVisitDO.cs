
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.mr.nu.obstetrics.operationnurvisit.d
{
    /// <summary>
    /// OperationNurVisitDO 的摘要说明。
    /// </summary>
    public class OperationNurVisitDO : BaseDO {

		public const string TABLE_NAME = "ci_mr_nu_opernur";
		public const string TABLE_ALIAS_NAME = "a0";

        public OperationNurVisitDO() {
        }
		public string Id_opernur {
            get { return getAttrVal<string>("Id_opernur",null); }
            set { setAttrVal<string>("Id_opernur", value); }
        }
		public string Id_group {
            get { return getAttrVal<string>("Id_group",null); }
            set { setAttrVal<string>("Id_group", value); }
        }
		public string Id_org {
            get { return getAttrVal<string>("Id_org",null); }
            set { setAttrVal<string>("Id_org", value); }
        }
		public string Id_ent {
            get { return getAttrVal<string>("Id_ent",null); }
            set { setAttrVal<string>("Id_ent", value); }
        }
		public string Id_pat {
            get { return getAttrVal<string>("Id_pat",null); }
            set { setAttrVal<string>("Id_pat", value); }
        }
		public string Id_sex {
            get { return getAttrVal<string>("Id_sex",null); }
            set { setAttrVal<string>("Id_sex", value); }
        }
		public string Sd_sex {
            get { return getAttrVal<string>("Sd_sex",null); }
            set { setAttrVal<string>("Sd_sex", value); }
        }
		public string Age {
            get { return getAttrVal<string>("Age",null); }
            set { setAttrVal<string>("Age", value); }
        }
		public string Code_amr_ip {
            get { return getAttrVal<string>("Code_amr_ip",null); }
            set { setAttrVal<string>("Code_amr_ip", value); }
        }
		public string Id_dep_phy {
            get { return getAttrVal<string>("Id_dep_phy",null); }
            set { setAttrVal<string>("Id_dep_phy", value); }
        }
		public string Name_dep_phy {
            get { return getAttrVal<string>("Name_dep_phy",null); }
            set { setAttrVal<string>("Name_dep_phy", value); }
        }
		public string Id_dep_nur {
            get { return getAttrVal<string>("Id_dep_nur",null); }
            set { setAttrVal<string>("Id_dep_nur", value); }
        }
		public string Name_dep_nur {
            get { return getAttrVal<string>("Name_dep_nur",null); }
            set { setAttrVal<string>("Name_dep_nur", value); }
        }
		public DateTime? Dt_operation {
            get { return getAttrVal<FDate>("Dt_operation",null); }
            set { setAttrVal<FDate>("Dt_operation", value); }
        }
		public string Id_anesthesia {
            get { return getAttrVal<string>("Id_anesthesia",null); }
            set { setAttrVal<string>("Id_anesthesia", value); }
        }
		public string Sd_anesthesia {
            get { return getAttrVal<string>("Sd_anesthesia",null); }
            set { setAttrVal<string>("Sd_anesthesia", value); }
        }
		public string Name_diagnosis {
            get { return getAttrVal<string>("Name_diagnosis",null); }
            set { setAttrVal<string>("Name_diagnosis", value); }
        }
		public string Name_operation {
            get { return getAttrVal<string>("Name_operation",null); }
            set { setAttrVal<string>("Name_operation", value); }
        }
		public DateTime? Dt_beginvisit {
            get { return getAttrVal<FDate>("Dt_beginvisit",null); }
            set { setAttrVal<FDate>("Dt_beginvisit", value); }
        }
		public string Id_liver_fun {
            get { return getAttrVal<string>("Id_liver_fun",null); }
            set { setAttrVal<string>("Id_liver_fun", value); }
        }
		public string Sd_liver_fun {
            get { return getAttrVal<string>("Sd_liver_fun",null); }
            set { setAttrVal<string>("Sd_liver_fun", value); }
        }
		public string Id_o {
            get { return getAttrVal<string>("Id_o",null); }
            set { setAttrVal<string>("Id_o", value); }
        }
		public string Sd_o {
            get { return getAttrVal<string>("Sd_o",null); }
            set { setAttrVal<string>("Sd_o", value); }
        }
		public string Name_diseasehis {
            get { return getAttrVal<string>("Name_diseasehis",null); }
            set { setAttrVal<string>("Name_diseasehis", value); }
        }
		public string Name_oper_his {
            get { return getAttrVal<string>("Name_oper_his",null); }
            set { setAttrVal<string>("Name_oper_his", value); }
        }
		public string Name_allergy {
            get { return getAttrVal<string>("Name_allergy",null); }
            set { setAttrVal<string>("Name_allergy", value); }
        }
		public string Id_phy_con {
            get { return getAttrVal<string>("Id_phy_con",null); }
            set { setAttrVal<string>("Id_phy_con", value); }
        }
		public string Sd_phy_con {
            get { return getAttrVal<string>("Sd_phy_con",null); }
            set { setAttrVal<string>("Sd_phy_con", value); }
        }
		public string Id_shape {
            get { return getAttrVal<string>("Id_shape",null); }
            set { setAttrVal<string>("Id_shape", value); }
        }
		public string Sd_shape {
            get { return getAttrVal<string>("Sd_shape",null); }
            set { setAttrVal<string>("Sd_shape", value); }
        }
		public string Id_mentality {
            get { return getAttrVal<string>("Id_mentality",null); }
            set { setAttrVal<string>("Id_mentality", value); }
        }
		public string Sd_mentality {
            get { return getAttrVal<string>("Sd_mentality",null); }
            set { setAttrVal<string>("Sd_mentality", value); }
        }
		public int? Eu_dyskinesia {
            get { return getAttrVal<int?>("Eu_dyskinesia",null); }
            set { setAttrVal<int?>("Eu_dyskinesia", value); }
        }
		public string Id_blood_vessel {
            get { return getAttrVal<string>("Id_blood_vessel",null); }
            set { setAttrVal<string>("Id_blood_vessel", value); }
        }
		public string Sd_blood_vessel {
            get { return getAttrVal<string>("Sd_blood_vessel",null); }
            set { setAttrVal<string>("Sd_blood_vessel", value); }
        }
		public string Des_oper {
            get { return getAttrVal<string>("Des_oper",null); }
            set { setAttrVal<string>("Des_oper", value); }
        }
		public string Id_emp_visit {
            get { return getAttrVal<string>("Id_emp_visit",null); }
            set { setAttrVal<string>("Id_emp_visit", value); }
        }
		public DateTime? Dt_afteroper {
            get { return getAttrVal<FDate>("Dt_afteroper",null); }
            set { setAttrVal<FDate>("Dt_afteroper", value); }
        }
		public int? Dayafteroper {
            get { return getAttrVal<int?>("Dayafteroper",null); }
            set { setAttrVal<int?>("Dayafteroper", value); }
        }
		public string Id_spirit {
            get { return getAttrVal<string>("Id_spirit",null); }
            set { setAttrVal<string>("Id_spirit", value); }
        }
		public string Sd_spirit {
            get { return getAttrVal<string>("Sd_spirit",null); }
            set { setAttrVal<string>("Sd_spirit", value); }
        }
		public int? Eu_pain {
            get { return getAttrVal<int?>("Eu_pain",null); }
            set { setAttrVal<int?>("Eu_pain", value); }
        }
		public string Id_tem {
            get { return getAttrVal<string>("Id_tem",null); }
            set { setAttrVal<string>("Id_tem", value); }
        }
		public string Sd_tem {
            get { return getAttrVal<string>("Sd_tem",null); }
            set { setAttrVal<string>("Sd_tem", value); }
        }
		public string Id_wound_healing {
            get { return getAttrVal<string>("Id_wound_healing",null); }
            set { setAttrVal<string>("Id_wound_healing", value); }
        }
		public string Sd_wound_healing {
            get { return getAttrVal<string>("Sd_wound_healing",null); }
            set { setAttrVal<string>("Sd_wound_healing", value); }
        }
		public int? Eu_skin_burn {
            get { return getAttrVal<int?>("Eu_skin_burn",null); }
            set { setAttrVal<int?>("Eu_skin_burn", value); }
        }
		public string Id_oper_eval {
            get { return getAttrVal<string>("Id_oper_eval",null); }
            set { setAttrVal<string>("Id_oper_eval", value); }
        }
		public string Sd_oper_eval {
            get { return getAttrVal<string>("Sd_oper_eval",null); }
            set { setAttrVal<string>("Sd_oper_eval", value); }
        }
		public int? Eu_visit_atti {
            get { return getAttrVal<int?>("Eu_visit_atti",null); }
            set { setAttrVal<int?>("Eu_visit_atti", value); }
        }
		public string Specialopinion {
            get { return getAttrVal<string>("Specialopinion",null); }
            set { setAttrVal<string>("Specialopinion", value); }
        }
		public string Id_emp_back {
            get { return getAttrVal<string>("Id_emp_back",null); }
            set { setAttrVal<string>("Id_emp_back", value); }
        }
		public string Id_mental_state {
            get { return getAttrVal<string>("Id_mental_state",null); }
            set { setAttrVal<string>("Id_mental_state", value); }
        }
		public string Sd_mental_state {
            get { return getAttrVal<string>("Sd_mental_state",null); }
            set { setAttrVal<string>("Sd_mental_state", value); }
        }
		public string Id_pat_cooper {
            get { return getAttrVal<string>("Id_pat_cooper",null); }
            set { setAttrVal<string>("Id_pat_cooper", value); }
        }
		public string Sd_pat_cooper {
            get { return getAttrVal<string>("Sd_pat_cooper",null); }
            set { setAttrVal<string>("Sd_pat_cooper", value); }
        }
		public string Id_item_pre {
            get { return getAttrVal<string>("Id_item_pre",null); }
            set { setAttrVal<string>("Id_item_pre", value); }
        }
		public string Sd_item_pre {
            get { return getAttrVal<string>("Sd_item_pre",null); }
            set { setAttrVal<string>("Sd_item_pre", value); }
        }
		public int? Eu_nurrec {
            get { return getAttrVal<int?>("Eu_nurrec",null); }
            set { setAttrVal<int?>("Eu_nurrec", value); }
        }
		public string Signature_nur {
            get { return getAttrVal<string>("Signature_nur",null); }
            set { setAttrVal<string>("Signature_nur", value); }
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
		public string Name_pat {
            get { return getAttrVal<string>("Name_pat",null); }
            set { setAttrVal<string>("Name_pat", value); }
        }
		public string Name_sex {
            get { return getAttrVal<string>("Name_sex",null); }
            set { setAttrVal<string>("Name_sex", value); }
        }
		public string Name_anesthesia {
            get { return getAttrVal<string>("Name_anesthesia",null); }
            set { setAttrVal<string>("Name_anesthesia", value); }
        }
		public string Name_liver_fun {
            get { return getAttrVal<string>("Name_liver_fun",null); }
            set { setAttrVal<string>("Name_liver_fun", value); }
        }
		public string Name_o {
            get { return getAttrVal<string>("Name_o",null); }
            set { setAttrVal<string>("Name_o", value); }
        }
		public string Name_phy_con {
            get { return getAttrVal<string>("Name_phy_con",null); }
            set { setAttrVal<string>("Name_phy_con", value); }
        }
		public string Name_shape {
            get { return getAttrVal<string>("Name_shape",null); }
            set { setAttrVal<string>("Name_shape", value); }
        }
		public string Name_mentality {
            get { return getAttrVal<string>("Name_mentality",null); }
            set { setAttrVal<string>("Name_mentality", value); }
        }
		public string Name_blood_vessel {
            get { return getAttrVal<string>("Name_blood_vessel",null); }
            set { setAttrVal<string>("Name_blood_vessel", value); }
        }
		public string Name_emp_visit {
            get { return getAttrVal<string>("Name_emp_visit",null); }
            set { setAttrVal<string>("Name_emp_visit", value); }
        }
		public string Name_spirit {
            get { return getAttrVal<string>("Name_spirit",null); }
            set { setAttrVal<string>("Name_spirit", value); }
        }
		public string Name_tem {
            get { return getAttrVal<string>("Name_tem",null); }
            set { setAttrVal<string>("Name_tem", value); }
        }
		public string Name_wound_healing {
            get { return getAttrVal<string>("Name_wound_healing",null); }
            set { setAttrVal<string>("Name_wound_healing", value); }
        }
		public string Name_oper_eval {
            get { return getAttrVal<string>("Name_oper_eval",null); }
            set { setAttrVal<string>("Name_oper_eval", value); }
        }
		public string Name_emp_back {
            get { return getAttrVal<string>("Name_emp_back",null); }
            set { setAttrVal<string>("Name_emp_back", value); }
        }
		public string Name_mental_state {
            get { return getAttrVal<string>("Name_mental_state",null); }
            set { setAttrVal<string>("Name_mental_state", value); }
        }
		public string Name_pat_cooper {
            get { return getAttrVal<string>("Name_pat_cooper",null); }
            set { setAttrVal<string>("Name_pat_cooper", value); }
        }
		public string Name_item_pre {
            get { return getAttrVal<string>("Name_item_pre",null); }
            set { setAttrVal<string>("Name_item_pre", value); }
        }
		public string Name_nur {
            get { return getAttrVal<string>("Name_nur",null); }
            set { setAttrVal<string>("Name_nur", value); }
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
            return "ci_mr_nu_opernur";
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
            return "Id_opernur";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.nu.obstetrics.operationnurvisit.d.OperationNurVisitDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_opernur", "Id_group", "Id_org", "Id_ent", "Id_pat", "Id_sex", "Sd_sex", "Age", "Code_amr_ip", "Id_dep_phy", "Name_dep_phy", "Id_dep_nur", "Name_dep_nur", "Dt_operation", "Id_anesthesia", "Sd_anesthesia", "Name_diagnosis", "Name_operation", "Dt_beginvisit", "Id_liver_fun", "Sd_liver_fun", "Id_o", "Sd_o", "Name_diseasehis", "Name_oper_his", "Name_allergy", "Id_phy_con", "Sd_phy_con", "Id_shape", "Sd_shape", "Id_mentality", "Sd_mentality", "Eu_dyskinesia", "Id_blood_vessel", "Sd_blood_vessel", "Des_oper", "Id_emp_visit", "Dt_afteroper", "Dayafteroper", "Id_spirit", "Sd_spirit", "Eu_pain", "Id_tem", "Sd_tem", "Id_wound_healing", "Sd_wound_healing", "Eu_skin_burn", "Id_oper_eval", "Sd_oper_eval", "Eu_visit_atti", "Specialopinion", "Id_emp_back", "Id_mental_state", "Sd_mental_state", "Id_pat_cooper", "Sd_pat_cooper", "Id_item_pre", "Sd_item_pre", "Eu_nurrec", "Signature_nur", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Name_pat", "Name_sex", "Name_anesthesia", "Name_liver_fun", "Name_o", "Name_phy_con", "Name_shape", "Name_mentality", "Name_blood_vessel", "Name_emp_visit", "Name_spirit", "Name_tem", "Name_wound_healing", "Name_oper_eval", "Name_emp_back", "Name_mental_state", "Name_pat_cooper", "Name_item_pre", "Name_nur"};
        }
        
    }
}
