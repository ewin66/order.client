
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.mrfp.sug2mrfp.d
{
    /// <summary>
    /// CiMrFpSugDO 的摘要说明。
    /// </summary>
    public class CiMrFpSugDO : BaseDO {

        public CiMrFpSugDO() {
        }
		public string Id_mrfpsug {
            get { return getAttrVal<string>("Id_mrfpsug",null); }
            set { setAttrVal<string>("Id_mrfpsug", value); }
        }
		public string Id_mrfp {
            get { return getAttrVal<string>("Id_mrfp",null); }
            set { setAttrVal<string>("Id_mrfp", value); }
        }
		public int? Sortno {
            get { return getAttrVal<int?>("Sortno",null); }
            set { setAttrVal<int?>("Sortno", value); }
        }
		public string Id_ent {
            get { return getAttrVal<string>("Id_ent",null); }
            set { setAttrVal<string>("Id_ent", value); }
        }
		public string Id_pat {
            get { return getAttrVal<string>("Id_pat",null); }
            set { setAttrVal<string>("Id_pat", value); }
        }
		public string Id_sug {
            get { return getAttrVal<string>("Id_sug",null); }
            set { setAttrVal<string>("Id_sug", value); }
        }
		public string Sd_sug {
            get { return getAttrVal<string>("Sd_sug",null); }
            set { setAttrVal<string>("Sd_sug", value); }
        }
		public string Name_sug {
            get { return getAttrVal<string>("Name_sug",null); }
            set { setAttrVal<string>("Name_sug", value); }
        }
		public string Id_lvlsug {
            get { return getAttrVal<string>("Id_lvlsug",null); }
            set { setAttrVal<string>("Id_lvlsug", value); }
        }
		public string Sd_lvlsug {
            get { return getAttrVal<string>("Sd_lvlsug",null); }
            set { setAttrVal<string>("Sd_lvlsug", value); }
        }
		public string Name_lvlsug {
            get { return getAttrVal<string>("Name_lvlsug",null); }
            set { setAttrVal<string>("Name_lvlsug", value); }
        }
		public DateTime? Dt_start_sug {
            get { return getAttrVal<FDateTime>("Dt_start_sug",null); }
            set { setAttrVal<FDateTime>("Dt_start_sug", value); }
        }
		public DateTime? Dt_end_sug {
            get { return getAttrVal<FDateTime>("Dt_end_sug",null); }
            set { setAttrVal<FDateTime>("Dt_end_sug", value); }
        }
		public string Id_emp_sug {
            get { return getAttrVal<string>("Id_emp_sug",null); }
            set { setAttrVal<string>("Id_emp_sug", value); }
        }
		public string Sd_emp_sug {
            get { return getAttrVal<string>("Sd_emp_sug",null); }
            set { setAttrVal<string>("Sd_emp_sug", value); }
        }
		public string Name_emp_sug {
            get { return getAttrVal<string>("Name_emp_sug",null); }
            set { setAttrVal<string>("Name_emp_sug", value); }
        }
		public string Id_emp_asst1 {
            get { return getAttrVal<string>("Id_emp_asst1",null); }
            set { setAttrVal<string>("Id_emp_asst1", value); }
        }
		public string Sd_emp_asst1 {
            get { return getAttrVal<string>("Sd_emp_asst1",null); }
            set { setAttrVal<string>("Sd_emp_asst1", value); }
        }
		public string Name_emp_asst1 {
            get { return getAttrVal<string>("Name_emp_asst1",null); }
            set { setAttrVal<string>("Name_emp_asst1", value); }
        }
		public string Id_emp_asst2 {
            get { return getAttrVal<string>("Id_emp_asst2",null); }
            set { setAttrVal<string>("Id_emp_asst2", value); }
        }
		public string Sd_emp_asst2 {
            get { return getAttrVal<string>("Sd_emp_asst2",null); }
            set { setAttrVal<string>("Sd_emp_asst2", value); }
        }
		public string Name_emp_asst2 {
            get { return getAttrVal<string>("Name_emp_asst2",null); }
            set { setAttrVal<string>("Name_emp_asst2", value); }
        }
		public string Id_emp_anes {
            get { return getAttrVal<string>("Id_emp_anes",null); }
            set { setAttrVal<string>("Id_emp_anes", value); }
        }
		public string Sd_emp_anes {
            get { return getAttrVal<string>("Sd_emp_anes",null); }
            set { setAttrVal<string>("Sd_emp_anes", value); }
        }
		public string Name_emp_anes {
            get { return getAttrVal<string>("Name_emp_anes",null); }
            set { setAttrVal<string>("Name_emp_anes", value); }
        }
		public string Id_incitp {
            get { return getAttrVal<string>("Id_incitp",null); }
            set { setAttrVal<string>("Id_incitp", value); }
        }
		public string Sd_incitp {
            get { return getAttrVal<string>("Sd_incitp",null); }
            set { setAttrVal<string>("Sd_incitp", value); }
        }
		public string Name_incitp {
            get { return getAttrVal<string>("Name_incitp",null); }
            set { setAttrVal<string>("Name_incitp", value); }
        }
		public string Id_anestp {
            get { return getAttrVal<string>("Id_anestp",null); }
            set { setAttrVal<string>("Id_anestp", value); }
        }
		public string Sd_anestp {
            get { return getAttrVal<string>("Sd_anestp",null); }
            set { setAttrVal<string>("Sd_anestp", value); }
        }
		public string Name_anestp {
            get { return getAttrVal<string>("Name_anestp",null); }
            set { setAttrVal<string>("Name_anestp", value); }
        }
		public string Id_incicondi {
            get { return getAttrVal<string>("Id_incicondi",null); }
            set { setAttrVal<string>("Id_incicondi", value); }
        }
		public string Sd_incicondi {
            get { return getAttrVal<string>("Sd_incicondi",null); }
            set { setAttrVal<string>("Sd_incicondi", value); }
        }
		public string Name_incicondi {
            get { return getAttrVal<string>("Name_incicondi",null); }
            set { setAttrVal<string>("Name_incicondi", value); }
        }
		public string Sug_code {
            get { return getAttrVal<string>("Sug_code",null); }
            set { setAttrVal<string>("Sug_code", value); }
        }
		public string Sug_name {
            get { return getAttrVal<string>("Sug_name",null); }
            set { setAttrVal<string>("Sug_name", value); }
        }
		public string Lvlsug_code {
            get { return getAttrVal<string>("Lvlsug_code",null); }
            set { setAttrVal<string>("Lvlsug_code", value); }
        }
		public string Lvlsug_name {
            get { return getAttrVal<string>("Lvlsug_name",null); }
            set { setAttrVal<string>("Lvlsug_name", value); }
        }
		public string Emp_sug_name {
            get { return getAttrVal<string>("Emp_sug_name",null); }
            set { setAttrVal<string>("Emp_sug_name", value); }
        }
		public string Emp_sug_code {
            get { return getAttrVal<string>("Emp_sug_code",null); }
            set { setAttrVal<string>("Emp_sug_code", value); }
        }
		public string Emp_asst1_name {
            get { return getAttrVal<string>("Emp_asst1_name",null); }
            set { setAttrVal<string>("Emp_asst1_name", value); }
        }
		public string Emp_asst1_code {
            get { return getAttrVal<string>("Emp_asst1_code",null); }
            set { setAttrVal<string>("Emp_asst1_code", value); }
        }
		public string Emp_asst2_name {
            get { return getAttrVal<string>("Emp_asst2_name",null); }
            set { setAttrVal<string>("Emp_asst2_name", value); }
        }
		public string Emp_asst2_code {
            get { return getAttrVal<string>("Emp_asst2_code",null); }
            set { setAttrVal<string>("Emp_asst2_code", value); }
        }
		public string Emp_anes_name {
            get { return getAttrVal<string>("Emp_anes_name",null); }
            set { setAttrVal<string>("Emp_anes_name", value); }
        }
		public string Emp_anes_code {
            get { return getAttrVal<string>("Emp_anes_code",null); }
            set { setAttrVal<string>("Emp_anes_code", value); }
        }
		public string Incitp_code {
            get { return getAttrVal<string>("Incitp_code",null); }
            set { setAttrVal<string>("Incitp_code", value); }
        }
		public string Incitp_name {
            get { return getAttrVal<string>("Incitp_name",null); }
            set { setAttrVal<string>("Incitp_name", value); }
        }
		public string Anestp_code {
            get { return getAttrVal<string>("Anestp_code",null); }
            set { setAttrVal<string>("Anestp_code", value); }
        }
		public string Anestp_name {
            get { return getAttrVal<string>("Anestp_name",null); }
            set { setAttrVal<string>("Anestp_name", value); }
        }
		public string Incicondi_code {
            get { return getAttrVal<string>("Incicondi_code",null); }
            set { setAttrVal<string>("Incicondi_code", value); }
        }
		public string Incicondi_name {
            get { return getAttrVal<string>("Incicondi_name",null); }
            set { setAttrVal<string>("Incicondi_name", value); }
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
            return "CI_MR_FP_SUG";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_mrfpsug";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mrfp.sug2mrfp.d.CiMrFpSugDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_mrfpsug", "Id_mrfp", "Sortno", "Id_ent", "Id_pat", "Id_sug", "Sd_sug", "Name_sug", "Id_lvlsug", "Sd_lvlsug", "Name_lvlsug", "Dt_start_sug", "Dt_end_sug", "Id_emp_sug", "Sd_emp_sug", "Name_emp_sug", "Id_emp_asst1", "Sd_emp_asst1", "Name_emp_asst1", "Id_emp_asst2", "Sd_emp_asst2", "Name_emp_asst2", "Id_emp_anes", "Sd_emp_anes", "Name_emp_anes", "Id_incitp", "Sd_incitp", "Name_incitp", "Id_anestp", "Sd_anestp", "Name_anestp", "Id_incicondi", "Sd_incicondi", "Name_incicondi", "Sug_code", "Sug_name", "Lvlsug_code", "Lvlsug_name", "Emp_sug_name", "Emp_sug_code", "Emp_asst1_name", "Emp_asst1_code", "Emp_asst2_name", "Emp_asst2_code", "Emp_anes_name", "Emp_anes_code", "Incitp_code", "Incitp_name", "Anestp_code", "Anestp_name", "Incicondi_code", "Incicondi_name"};
        }
        
    }
}
