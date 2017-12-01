
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.rcm.contagion.d
{
    /// <summary>
    /// HepatitisBDO 的摘要说明。
    /// </summary>
    public class HepatitisBDO : BaseDO {

		public const string TABLE_NAME = "CI_MR_CONTAGION_CARD_HB";
		public const string TABLE_ALIAS_NAME = "a2";

        public HepatitisBDO() {
        }
		public string Id_contagion_hb {
            get { return getAttrVal<string>("Id_contagion_hb",null); }
            set { setAttrVal<string>("Id_contagion_hb", value); }
        }
		public string Id_contagion {
            get { return getAttrVal<string>("Id_contagion",null); }
            set { setAttrVal<string>("Id_contagion", value); }
        }
		public string Id_form {
            get { return getAttrVal<string>("Id_form",null); }
            set { setAttrVal<string>("Id_form", value); }
        }
		public string Id_hbsag_dt {
            get { return getAttrVal<string>("Id_hbsag_dt",null); }
            set { setAttrVal<string>("Id_hbsag_dt", value); }
        }
		public string Code_hbsag_dt {
            get { return getAttrVal<string>("Code_hbsag_dt",null); }
            set { setAttrVal<string>("Code_hbsag_dt", value); }
        }
		public string Name_hbsag_dt {
            get { return getAttrVal<string>("Name_hbsag_dt",null); }
            set { setAttrVal<string>("Name_hbsag_dt", value); }
        }
		public DateTime? Dt_first {
            get { return getAttrVal<FDate>("Dt_first",null); }
            set { setAttrVal<FDate>("Dt_first", value); }
        }
		public string Alt {
            get { return getAttrVal<string>("Alt",null); }
            set { setAttrVal<string>("Alt", value); }
        }
		public string Id_hbc_igm1 {
            get { return getAttrVal<string>("Id_hbc_igm1",null); }
            set { setAttrVal<string>("Id_hbc_igm1", value); }
        }
		public string Code_hbc_igm1 {
            get { return getAttrVal<string>("Code_hbc_igm1",null); }
            set { setAttrVal<string>("Code_hbc_igm1", value); }
        }
		public string Name_hbc_igm1 {
            get { return getAttrVal<string>("Name_hbc_igm1",null); }
            set { setAttrVal<string>("Name_hbc_igm1", value); }
        }
		public string Id_liver_puncture_results {
            get { return getAttrVal<string>("Id_liver_puncture_results",null); }
            set { setAttrVal<string>("Id_liver_puncture_results", value); }
        }
		public string Code_liver_puncture_results {
            get { return getAttrVal<string>("Code_liver_puncture_results",null); }
            set { setAttrVal<string>("Code_liver_puncture_results", value); }
        }
		public string Name_liver_puncture_results {
            get { return getAttrVal<string>("Name_liver_puncture_results",null); }
            set { setAttrVal<string>("Name_liver_puncture_results", value); }
        }
		public string Id_hbsag_huifu {
            get { return getAttrVal<string>("Id_hbsag_huifu",null); }
            set { setAttrVal<string>("Id_hbsag_huifu", value); }
        }
		public string Code_hbsag_huifu {
            get { return getAttrVal<string>("Code_hbsag_huifu",null); }
            set { setAttrVal<string>("Code_hbsag_huifu", value); }
        }
		public string Name_hbsag_huifu {
            get { return getAttrVal<string>("Name_hbsag_huifu",null); }
            set { setAttrVal<string>("Name_hbsag_huifu", value); }
        }
		public bool? Is_know {
            get { return getAttrVal<FBoolean>("Is_know",null); }
            set { setAttrVal<FBoolean>("Is_know", value); }
        }
		public string Card_no {
            get { return getAttrVal<string>("Card_no",null); }
            set { setAttrVal<string>("Card_no", value); }
        }
		public string Pat_name {
            get { return getAttrVal<string>("Pat_name",null); }
            set { setAttrVal<string>("Pat_name", value); }
        }
		public string Parent_name {
            get { return getAttrVal<string>("Parent_name",null); }
            set { setAttrVal<string>("Parent_name", value); }
        }
		public string Hjdz {
            get { return getAttrVal<string>("Hjdz",null); }
            set { setAttrVal<string>("Hjdz", value); }
        }
		public string Code_hjdz {
            get { return getAttrVal<string>("Code_hjdz",null); }
            set { setAttrVal<string>("Code_hjdz", value); }
        }
		public string Name_hjdz {
            get { return getAttrVal<string>("Name_hjdz",null); }
            set { setAttrVal<string>("Name_hjdz", value); }
        }
		public string Town {
            get { return getAttrVal<string>("Town",null); }
            set { setAttrVal<string>("Town", value); }
        }
		public string Vallege {
            get { return getAttrVal<string>("Vallege",null); }
            set { setAttrVal<string>("Vallege", value); }
        }
		public string House_no {
            get { return getAttrVal<string>("House_no",null); }
            set { setAttrVal<string>("House_no", value); }
        }
		public string Rept_doctor {
            get { return getAttrVal<string>("Rept_doctor",null); }
            set { setAttrVal<string>("Rept_doctor", value); }
        }
		public string Relation_way {
            get { return getAttrVal<string>("Relation_way",null); }
            set { setAttrVal<string>("Relation_way", value); }
        }
		public string Code_rept_doctor {
            get { return getAttrVal<string>("Code_rept_doctor",null); }
            set { setAttrVal<string>("Code_rept_doctor", value); }
        }
		public string Name_rept_doctor {
            get { return getAttrVal<string>("Name_rept_doctor",null); }
            set { setAttrVal<string>("Name_rept_doctor", value); }
        }
		public string Hbsag_dt_code {
            get { return getAttrVal<string>("Hbsag_dt_code",null); }
            set { setAttrVal<string>("Hbsag_dt_code", value); }
        }
		public string Hbsag_dt_name {
            get { return getAttrVal<string>("Hbsag_dt_name",null); }
            set { setAttrVal<string>("Hbsag_dt_name", value); }
        }
		public string Hbc_igm_code {
            get { return getAttrVal<string>("Hbc_igm_code",null); }
            set { setAttrVal<string>("Hbc_igm_code", value); }
        }
		public string Hbc_igm_name {
            get { return getAttrVal<string>("Hbc_igm_name",null); }
            set { setAttrVal<string>("Hbc_igm_name", value); }
        }
		public string Liver_puncture_results_code {
            get { return getAttrVal<string>("Liver_puncture_results_code",null); }
            set { setAttrVal<string>("Liver_puncture_results_code", value); }
        }
		public string Liver_puncture_results_name {
            get { return getAttrVal<string>("Liver_puncture_results_name",null); }
            set { setAttrVal<string>("Liver_puncture_results_name", value); }
        }
		public string Hbsag_huifu_code {
            get { return getAttrVal<string>("Hbsag_huifu_code",null); }
            set { setAttrVal<string>("Hbsag_huifu_code", value); }
        }
		public string Hbsag_huifu_name {
            get { return getAttrVal<string>("Hbsag_huifu_name",null); }
            set { setAttrVal<string>("Hbsag_huifu_name", value); }
        }
		public string Areacode {
            get { return getAttrVal<string>("Areacode",null); }
            set { setAttrVal<string>("Areacode", value); }
        }
		public string Areaname {
            get { return getAttrVal<string>("Areaname",null); }
            set { setAttrVal<string>("Areaname", value); }
        }
		public string Doctorcode {
            get { return getAttrVal<string>("Doctorcode",null); }
            set { setAttrVal<string>("Doctorcode", value); }
        }
		public string Doctorname {
            get { return getAttrVal<string>("Doctorname",null); }
            set { setAttrVal<string>("Doctorname", value); }
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
            return "CI_MR_CONTAGION_CARD_HB";
        }
        
        /// <summary>
        /// 返回表别名
        /// </summary>
        /// <returns></returns>
        public override string getAliasTableName()
        {
            return "a2";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_contagion_hb";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.rcm.contagion.d.HepatitisBDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_contagion_hb", "Id_contagion", "Id_form", "Id_hbsag_dt", "Code_hbsag_dt", "Name_hbsag_dt", "Dt_first", "Alt", "Id_hbc_igm1", "Code_hbc_igm1", "Name_hbc_igm1", "Id_liver_puncture_results", "Code_liver_puncture_results", "Name_liver_puncture_results", "Id_hbsag_huifu", "Code_hbsag_huifu", "Name_hbsag_huifu", "Is_know", "Card_no", "Pat_name", "Parent_name", "Hjdz", "Code_hjdz", "Name_hjdz", "Town", "Vallege", "House_no", "Rept_doctor", "Relation_way", "Code_rept_doctor", "Name_rept_doctor", "Hbsag_dt_code", "Hbsag_dt_name", "Hbc_igm_code", "Hbc_igm_name", "Liver_puncture_results_code", "Liver_puncture_results_name", "Hbsag_huifu_code", "Hbsag_huifu_name", "Areacode", "Areaname", "Doctorcode", "Doctorname"};
        }
        
    }
}
