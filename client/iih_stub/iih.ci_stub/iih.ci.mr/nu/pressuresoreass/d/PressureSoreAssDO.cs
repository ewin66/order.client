
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.mr.nu.pressuresoreass.d
{
    /// <summary>
    /// PressureSoreAssDO 的摘要说明。
    /// </summary>
    public class PressureSoreAssDO : BaseDO {

		public const string TABLE_NAME = "CI_MR_NU_PUSA";
		public const string TABLE_ALIAS_NAME = "a0";

        public PressureSoreAssDO() {
        }
		public string Id_puas {
            get { return getAttrVal<string>("Id_puas",null); }
            set { setAttrVal<string>("Id_puas", value); }
        }
		public string Id_grp {
            get { return getAttrVal<string>("Id_grp",null); }
            set { setAttrVal<string>("Id_grp", value); }
        }
		public string Id_org {
            get { return getAttrVal<string>("Id_org",null); }
            set { setAttrVal<string>("Id_org", value); }
        }
		public string Id_pat {
            get { return getAttrVal<string>("Id_pat",null); }
            set { setAttrVal<string>("Id_pat", value); }
        }
		public string Id_ent {
            get { return getAttrVal<string>("Id_ent",null); }
            set { setAttrVal<string>("Id_ent", value); }
        }
		public string Code_entp {
            get { return getAttrVal<string>("Code_entp",null); }
            set { setAttrVal<string>("Code_entp", value); }
        }
		public string Id_sex {
            get { return getAttrVal<string>("Id_sex",null); }
            set { setAttrVal<string>("Id_sex", value); }
        }
		public string Sd_sex {
            get { return getAttrVal<string>("Sd_sex",null); }
            set { setAttrVal<string>("Sd_sex", value); }
        }
		public string Id_dep_phy {
            get { return getAttrVal<string>("Id_dep_phy",null); }
            set { setAttrVal<string>("Id_dep_phy", value); }
        }
		public string Name_bed {
            get { return getAttrVal<string>("Name_bed",null); }
            set { setAttrVal<string>("Name_bed", value); }
        }
		public string Age {
            get { return getAttrVal<string>("Age",null); }
            set { setAttrVal<string>("Age", value); }
        }
		public string Code_amr_ip {
            get { return getAttrVal<string>("Code_amr_ip",null); }
            set { setAttrVal<string>("Code_amr_ip", value); }
        }
		public DateTime? Dt_entry {
            get { return getAttrVal<FDateTime>("Dt_entry",null); }
            set { setAttrVal<FDateTime>("Dt_entry", value); }
        }
		public string Name_diagnosis {
            get { return getAttrVal<string>("Name_diagnosis",null); }
            set { setAttrVal<string>("Name_diagnosis", value); }
        }
		public string Id_sores_physical {
            get { return getAttrVal<string>("Id_sores_physical",null); }
            set { setAttrVal<string>("Id_sores_physical", value); }
        }
		public string Sd_sores_physical {
            get { return getAttrVal<string>("Sd_sores_physical",null); }
            set { setAttrVal<string>("Sd_sores_physical", value); }
        }
		public int? Sores_physical {
            get { return getAttrVal<int?>("Sores_physical",null); }
            set { setAttrVal<int?>("Sores_physical", value); }
        }
		public string Id_sores_skin {
            get { return getAttrVal<string>("Id_sores_skin",null); }
            set { setAttrVal<string>("Id_sores_skin", value); }
        }
		public string Sd_sores_skin {
            get { return getAttrVal<string>("Sd_sores_skin",null); }
            set { setAttrVal<string>("Sd_sores_skin", value); }
        }
		public int? Sores_skin {
            get { return getAttrVal<int?>("Sores_skin",null); }
            set { setAttrVal<int?>("Sores_skin", value); }
        }
		public string Id_sores_sex {
            get { return getAttrVal<string>("Id_sores_sex",null); }
            set { setAttrVal<string>("Id_sores_sex", value); }
        }
		public string Sd_sores_sex {
            get { return getAttrVal<string>("Sd_sores_sex",null); }
            set { setAttrVal<string>("Sd_sores_sex", value); }
        }
		public int? Sores_sex {
            get { return getAttrVal<int?>("Sores_sex",null); }
            set { setAttrVal<int?>("Sores_sex", value); }
        }
		public string Id_sores_age {
            get { return getAttrVal<string>("Id_sores_age",null); }
            set { setAttrVal<string>("Id_sores_age", value); }
        }
		public string Sd_sores_age {
            get { return getAttrVal<string>("Sd_sores_age",null); }
            set { setAttrVal<string>("Sd_sores_age", value); }
        }
		public int? Sores_age {
            get { return getAttrVal<int?>("Sores_age",null); }
            set { setAttrVal<int?>("Sores_age", value); }
        }
		public string Id_sores_wgt_dec {
            get { return getAttrVal<string>("Id_sores_wgt_dec",null); }
            set { setAttrVal<string>("Id_sores_wgt_dec", value); }
        }
		public string Sd_sores_wgt_dec {
            get { return getAttrVal<string>("Sd_sores_wgt_dec",null); }
            set { setAttrVal<string>("Sd_sores_wgt_dec", value); }
        }
		public string Id_sores_wgt_sc {
            get { return getAttrVal<string>("Id_sores_wgt_sc",null); }
            set { setAttrVal<string>("Id_sores_wgt_sc", value); }
        }
		public string Sd_sores_wgt_sc {
            get { return getAttrVal<string>("Sd_sores_wgt_sc",null); }
            set { setAttrVal<string>("Sd_sores_wgt_sc", value); }
        }
		public int? Sores_wgt_sc {
            get { return getAttrVal<int?>("Sores_wgt_sc",null); }
            set { setAttrVal<int?>("Sores_wgt_sc", value); }
        }
		public string Id_sores_loss_appetite {
            get { return getAttrVal<string>("Id_sores_loss_appetite",null); }
            set { setAttrVal<string>("Id_sores_loss_appetite", value); }
        }
		public string Sd_sores_loss_appetite {
            get { return getAttrVal<string>("Sd_sores_loss_appetite",null); }
            set { setAttrVal<string>("Sd_sores_loss_appetite", value); }
        }
		public int? Sores_loss_appetite {
            get { return getAttrVal<int?>("Sores_loss_appetite",null); }
            set { setAttrVal<int?>("Sores_loss_appetite", value); }
        }
		public string Id_sores_incontinence {
            get { return getAttrVal<string>("Id_sores_incontinence",null); }
            set { setAttrVal<string>("Id_sores_incontinence", value); }
        }
		public string Sd_sores_incontinence {
            get { return getAttrVal<string>("Sd_sores_incontinence",null); }
            set { setAttrVal<string>("Sd_sores_incontinence", value); }
        }
		public int? Sores_incontinence {
            get { return getAttrVal<int?>("Sores_incontinence",null); }
            set { setAttrVal<int?>("Sores_incontinence", value); }
        }
		public string Id_sores_sport {
            get { return getAttrVal<string>("Id_sores_sport",null); }
            set { setAttrVal<string>("Id_sores_sport", value); }
        }
		public string Sd_sores_sport {
            get { return getAttrVal<string>("Sd_sores_sport",null); }
            set { setAttrVal<string>("Sd_sores_sport", value); }
        }
		public int? Sores_sport {
            get { return getAttrVal<int?>("Sores_sport",null); }
            set { setAttrVal<int?>("Sores_sport", value); }
        }
		public string Id_sores_nutrition {
            get { return getAttrVal<string>("Id_sores_nutrition",null); }
            set { setAttrVal<string>("Id_sores_nutrition", value); }
        }
		public string Sd_sores_nutrition {
            get { return getAttrVal<string>("Sd_sores_nutrition",null); }
            set { setAttrVal<string>("Sd_sores_nutrition", value); }
        }
		public int? Sores_nutrition {
            get { return getAttrVal<int?>("Sores_nutrition",null); }
            set { setAttrVal<int?>("Sores_nutrition", value); }
        }
		public string Id_sores_nervous {
            get { return getAttrVal<string>("Id_sores_nervous",null); }
            set { setAttrVal<string>("Id_sores_nervous", value); }
        }
		public string Sd_sores_nervous {
            get { return getAttrVal<string>("Sd_sores_nervous",null); }
            set { setAttrVal<string>("Sd_sores_nervous", value); }
        }
		public int? Sores_nervous {
            get { return getAttrVal<int?>("Sores_nervous",null); }
            set { setAttrVal<int?>("Sores_nervous", value); }
        }
		public string Id_sores_trauma {
            get { return getAttrVal<string>("Id_sores_trauma",null); }
            set { setAttrVal<string>("Id_sores_trauma", value); }
        }
		public string Sd_sores_trauma {
            get { return getAttrVal<string>("Sd_sores_trauma",null); }
            set { setAttrVal<string>("Sd_sores_trauma", value); }
        }
		public int? Sores_trauma {
            get { return getAttrVal<int?>("Sores_trauma",null); }
            set { setAttrVal<int?>("Sores_trauma", value); }
        }
		public string Id_sores_drug {
            get { return getAttrVal<string>("Id_sores_drug",null); }
            set { setAttrVal<string>("Id_sores_drug", value); }
        }
		public string Sd_sores_drug {
            get { return getAttrVal<string>("Sd_sores_drug",null); }
            set { setAttrVal<string>("Sd_sores_drug", value); }
        }
		public int? Sores_drug {
            get { return getAttrVal<int?>("Sores_drug",null); }
            set { setAttrVal<int?>("Sores_drug", value); }
        }
		public int? Total_score {
            get { return getAttrVal<int?>("Total_score",null); }
            set { setAttrVal<int?>("Total_score", value); }
        }
		public string Ass_result {
            get { return getAttrVal<string>("Ass_result",null); }
            set { setAttrVal<string>("Ass_result", value); }
        }
		public DateTime? Dt_ass {
            get { return getAttrVal<FDateTime>("Dt_ass",null); }
            set { setAttrVal<FDateTime>("Dt_ass", value); }
        }
		public string Id_nur_psn {
            get { return getAttrVal<string>("Id_nur_psn",null); }
            set { setAttrVal<string>("Id_nur_psn", value); }
        }
		public string Id_headnur_psn {
            get { return getAttrVal<string>("Id_headnur_psn",null); }
            set { setAttrVal<string>("Id_headnur_psn", value); }
        }
		public string Relation {
            get { return getAttrVal<string>("Relation",null); }
            set { setAttrVal<string>("Relation", value); }
        }
		public int? Virus_nerve {
            get { return getAttrVal<int?>("Virus_nerve",null); }
            set { setAttrVal<int?>("Virus_nerve", value); }
        }
		public int? Sport_nerve {
            get { return getAttrVal<int?>("Sport_nerve",null); }
            set { setAttrVal<int?>("Sport_nerve", value); }
        }
		public int? Hem_nerve {
            get { return getAttrVal<int?>("Hem_nerve",null); }
            set { setAttrVal<int?>("Hem_nerve", value); }
        }
		public int? Cell_med {
            get { return getAttrVal<int?>("Cell_med",null); }
            set { setAttrVal<int?>("Cell_med", value); }
        }
		public int? Long_med {
            get { return getAttrVal<int?>("Long_med",null); }
            set { setAttrVal<int?>("Long_med", value); }
        }
		public int? Biotic_med {
            get { return getAttrVal<int?>("Biotic_med",null); }
            set { setAttrVal<int?>("Biotic_med", value); }
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
		public string Name_dep_phy {
            get { return getAttrVal<string>("Name_dep_phy",null); }
            set { setAttrVal<string>("Name_dep_phy", value); }
        }
		public string Name_sores_physical {
            get { return getAttrVal<string>("Name_sores_physical",null); }
            set { setAttrVal<string>("Name_sores_physical", value); }
        }
		public string Name_sores_skin {
            get { return getAttrVal<string>("Name_sores_skin",null); }
            set { setAttrVal<string>("Name_sores_skin", value); }
        }
		public string Name_sores_sex {
            get { return getAttrVal<string>("Name_sores_sex",null); }
            set { setAttrVal<string>("Name_sores_sex", value); }
        }
		public string Name_sores_age {
            get { return getAttrVal<string>("Name_sores_age",null); }
            set { setAttrVal<string>("Name_sores_age", value); }
        }
		public string Name_sores_wgt_dec {
            get { return getAttrVal<string>("Name_sores_wgt_dec",null); }
            set { setAttrVal<string>("Name_sores_wgt_dec", value); }
        }
		public string Name_sores_wgt_sc {
            get { return getAttrVal<string>("Name_sores_wgt_sc",null); }
            set { setAttrVal<string>("Name_sores_wgt_sc", value); }
        }
		public string Name_sores_loss {
            get { return getAttrVal<string>("Name_sores_loss",null); }
            set { setAttrVal<string>("Name_sores_loss", value); }
        }
		public string Name_sores_incon {
            get { return getAttrVal<string>("Name_sores_incon",null); }
            set { setAttrVal<string>("Name_sores_incon", value); }
        }
		public string Name_sores_sport {
            get { return getAttrVal<string>("Name_sores_sport",null); }
            set { setAttrVal<string>("Name_sores_sport", value); }
        }
		public string Name_sores_nutr {
            get { return getAttrVal<string>("Name_sores_nutr",null); }
            set { setAttrVal<string>("Name_sores_nutr", value); }
        }
		public string Name_sores_ner {
            get { return getAttrVal<string>("Name_sores_ner",null); }
            set { setAttrVal<string>("Name_sores_ner", value); }
        }
		public string Name_sores_tra {
            get { return getAttrVal<string>("Name_sores_tra",null); }
            set { setAttrVal<string>("Name_sores_tra", value); }
        }
		public string Name_sores_drug {
            get { return getAttrVal<string>("Name_sores_drug",null); }
            set { setAttrVal<string>("Name_sores_drug", value); }
        }
		public string Name_nur_psn {
            get { return getAttrVal<string>("Name_nur_psn",null); }
            set { setAttrVal<string>("Name_nur_psn", value); }
        }
		public string Name_headnur_psn {
            get { return getAttrVal<string>("Name_headnur_psn",null); }
            set { setAttrVal<string>("Name_headnur_psn", value); }
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
            return "CI_MR_NU_PUSA";
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
            return "Id_puas";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.nu.pressuresoreass.d.PressureSoreAssDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_puas", "Id_grp", "Id_org", "Id_pat", "Id_ent", "Code_entp", "Id_sex", "Sd_sex", "Id_dep_phy", "Name_bed", "Age", "Code_amr_ip", "Dt_entry", "Name_diagnosis", "Id_sores_physical", "Sd_sores_physical", "Sores_physical", "Id_sores_skin", "Sd_sores_skin", "Sores_skin", "Id_sores_sex", "Sd_sores_sex", "Sores_sex", "Id_sores_age", "Sd_sores_age", "Sores_age", "Id_sores_wgt_dec", "Sd_sores_wgt_dec", "Id_sores_wgt_sc", "Sd_sores_wgt_sc", "Sores_wgt_sc", "Id_sores_loss_appetite", "Sd_sores_loss_appetite", "Sores_loss_appetite", "Id_sores_incontinence", "Sd_sores_incontinence", "Sores_incontinence", "Id_sores_sport", "Sd_sores_sport", "Sores_sport", "Id_sores_nutrition", "Sd_sores_nutrition", "Sores_nutrition", "Id_sores_nervous", "Sd_sores_nervous", "Sores_nervous", "Id_sores_trauma", "Sd_sores_trauma", "Sores_trauma", "Id_sores_drug", "Sd_sores_drug", "Sores_drug", "Total_score", "Ass_result", "Dt_ass", "Id_nur_psn", "Id_headnur_psn", "Relation", "Virus_nerve", "Sport_nerve", "Hem_nerve", "Cell_med", "Long_med", "Biotic_med", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Name_pat", "Name_sex", "Name_dep_phy", "Name_sores_physical", "Name_sores_skin", "Name_sores_sex", "Name_sores_age", "Name_sores_wgt_dec", "Name_sores_wgt_sc", "Name_sores_loss", "Name_sores_incon", "Name_sores_sport", "Name_sores_nutr", "Name_sores_ner", "Name_sores_tra", "Name_sores_drug", "Name_nur_psn", "Name_headnur_psn"};
        }
        
    }
}
