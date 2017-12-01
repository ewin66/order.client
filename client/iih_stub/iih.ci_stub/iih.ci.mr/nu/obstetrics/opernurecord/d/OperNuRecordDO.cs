
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.mr.nu.obstetrics.opernurecord.d
{
    /// <summary>
    /// OperNuRecordDO 的摘要说明。
    /// </summary>
    public class OperNuRecordDO : BaseDO {

		public const string TABLE_NAME = "ci_mr_nu_oprcod";
		public const string TABLE_ALIAS_NAME = "a0";

        public OperNuRecordDO() {
        }
		public string Id_oprcod {
            get { return getAttrVal<string>("Id_oprcod",null); }
            set { setAttrVal<string>("Id_oprcod", value); }
        }
		public string Id_org {
            get { return getAttrVal<string>("Id_org",null); }
            set { setAttrVal<string>("Id_org", value); }
        }
		public string Id_grp {
            get { return getAttrVal<string>("Id_grp",null); }
            set { setAttrVal<string>("Id_grp", value); }
        }
		public string Id_ent {
            get { return getAttrVal<string>("Id_ent",null); }
            set { setAttrVal<string>("Id_ent", value); }
        }
		public string Id_sex {
            get { return getAttrVal<string>("Id_sex",null); }
            set { setAttrVal<string>("Id_sex", value); }
        }
		public string Sd_sex {
            get { return getAttrVal<string>("Sd_sex",null); }
            set { setAttrVal<string>("Sd_sex", value); }
        }
		public string Id_pat {
            get { return getAttrVal<string>("Id_pat",null); }
            set { setAttrVal<string>("Id_pat", value); }
        }
		public string Code_entp {
            get { return getAttrVal<string>("Code_entp",null); }
            set { setAttrVal<string>("Code_entp", value); }
        }
		public string Age {
            get { return getAttrVal<string>("Age",null); }
            set { setAttrVal<string>("Age", value); }
        }
		public FDouble Weight {
            get { return getAttrVal<FDouble>("Weight",null); }
            set { setAttrVal<FDouble>("Weight", value); }
        }
		public string Name_dep_nur {
            get { return getAttrVal<string>("Name_dep_nur",null); }
            set { setAttrVal<string>("Name_dep_nur", value); }
        }
		public string Name_oper_room {
            get { return getAttrVal<string>("Name_oper_room",null); }
            set { setAttrVal<string>("Name_oper_room", value); }
        }
		public DateTime? Dt_oper {
            get { return getAttrVal<FDate>("Dt_oper",null); }
            set { setAttrVal<FDate>("Dt_oper", value); }
        }
		public DateTime? Dt_in {
            get { return getAttrVal<FDateTime>("Dt_in",null); }
            set { setAttrVal<FDateTime>("Dt_in", value); }
        }
		public DateTime? Dt_begin {
            get { return getAttrVal<FDateTime>("Dt_begin",null); }
            set { setAttrVal<FDateTime>("Dt_begin", value); }
        }
		public DateTime? Dt_end {
            get { return getAttrVal<FDateTime>("Dt_end",null); }
            set { setAttrVal<FDateTime>("Dt_end", value); }
        }
		public DateTime? Dt_out {
            get { return getAttrVal<FDateTime>("Dt_out",null); }
            set { setAttrVal<FDateTime>("Dt_out", value); }
        }
		public string Preoperative_diagnosis {
            get { return getAttrVal<string>("Preoperative_diagnosis",null); }
            set { setAttrVal<string>("Preoperative_diagnosis", value); }
        }
		public string Name_oper {
            get { return getAttrVal<string>("Name_oper",null); }
            set { setAttrVal<string>("Name_oper", value); }
        }
		public string Id_anesthesia_method {
            get { return getAttrVal<string>("Id_anesthesia_method",null); }
            set { setAttrVal<string>("Id_anesthesia_method", value); }
        }
		public string Sd_anesthesia_method {
            get { return getAttrVal<string>("Sd_anesthesia_method",null); }
            set { setAttrVal<string>("Sd_anesthesia_method", value); }
        }
		public string Position_oper {
            get { return getAttrVal<string>("Position_oper",null); }
            set { setAttrVal<string>("Position_oper", value); }
        }
		public string Skin_beforeoper {
            get { return getAttrVal<string>("Skin_beforeoper",null); }
            set { setAttrVal<string>("Skin_beforeoper", value); }
        }
		public string Name_allergy {
            get { return getAttrVal<string>("Name_allergy",null); }
            set { setAttrVal<string>("Name_allergy", value); }
        }
		public int? Eu_lzdn {
            get { return getAttrVal<int?>("Eu_lzdn",null); }
            set { setAttrVal<int?>("Eu_lzdn", value); }
        }
		public int? Eu_ngct {
            get { return getAttrVal<int?>("Eu_ngct",null); }
            set { setAttrVal<int?>("Eu_ngct", value); }
        }
		public string Id_urine_color {
            get { return getAttrVal<string>("Id_urine_color",null); }
            set { setAttrVal<string>("Id_urine_color", value); }
        }
		public string Sd_urine_color {
            get { return getAttrVal<string>("Sd_urine_color",null); }
            set { setAttrVal<string>("Sd_urine_color", value); }
        }
		public FDouble Bloodinoper {
            get { return getAttrVal<FDouble>("Bloodinoper",null); }
            set { setAttrVal<FDouble>("Bloodinoper", value); }
        }
		public FDouble Dose_urine {
            get { return getAttrVal<FDouble>("Dose_urine",null); }
            set { setAttrVal<FDouble>("Dose_urine", value); }
        }
		public FDouble Infusion {
            get { return getAttrVal<FDouble>("Infusion",null); }
            set { setAttrVal<FDouble>("Infusion", value); }
        }
		public FDouble Redbloodcell {
            get { return getAttrVal<FDouble>("Redbloodcell",null); }
            set { setAttrVal<FDouble>("Redbloodcell", value); }
        }
		public FDouble Plasma {
            get { return getAttrVal<FDouble>("Plasma",null); }
            set { setAttrVal<FDouble>("Plasma", value); }
        }
		public int? Eu_shysqk {
            get { return getAttrVal<int?>("Eu_shysqk",null); }
            set { setAttrVal<int?>("Eu_shysqk", value); }
        }
		public string Skin_afteroper {
            get { return getAttrVal<string>("Skin_afteroper",null); }
            set { setAttrVal<string>("Skin_afteroper", value); }
        }
		public int? Eu_ylg {
            get { return getAttrVal<int?>("Eu_ylg",null); }
            set { setAttrVal<int?>("Eu_ylg", value); }
        }
		public string Drainage_tube {
            get { return getAttrVal<string>("Drainage_tube",null); }
            set { setAttrVal<string>("Drainage_tube", value); }
        }
		public int? Eu_bb {
            get { return getAttrVal<int?>("Eu_bb",null); }
            set { setAttrVal<int?>("Eu_bb", value); }
        }
		public int? Sdb {
            get { return getAttrVal<int?>("Sdb",null); }
            set { setAttrVal<int?>("Sdb", value); }
        }
		public int? Dbp {
            get { return getAttrVal<int?>("Dbp",null); }
            set { setAttrVal<int?>("Dbp", value); }
        }
		public int? Pluse {
            get { return getAttrVal<int?>("Pluse",null); }
            set { setAttrVal<int?>("Pluse", value); }
        }
		public int? Breath {
            get { return getAttrVal<int?>("Breath",null); }
            set { setAttrVal<int?>("Breath", value); }
        }
		public string Specialrec {
            get { return getAttrVal<string>("Specialrec",null); }
            set { setAttrVal<string>("Specialrec", value); }
        }
		public string Id_emp_wash {
            get { return getAttrVal<string>("Id_emp_wash",null); }
            set { setAttrVal<string>("Id_emp_wash", value); }
        }
		public string Id_emp_apply {
            get { return getAttrVal<string>("Id_emp_apply",null); }
            set { setAttrVal<string>("Id_emp_apply", value); }
        }
		public string Sterile {
            get { return getAttrVal<string>("Sterile",null); }
            set { setAttrVal<string>("Sterile", value); }
        }
		public DateTime? Modifiedtime {
            get { return getAttrVal<FDateTime>("Modifiedtime",null); }
            set { setAttrVal<FDateTime>("Modifiedtime", value); }
        }
		public string Modifiedby {
            get { return getAttrVal<string>("Modifiedby",null); }
            set { setAttrVal<string>("Modifiedby", value); }
        }
		public string Createdby {
            get { return getAttrVal<string>("Createdby",null); }
            set { setAttrVal<string>("Createdby", value); }
        }
		public DateTime? Createdtime {
            get { return getAttrVal<FDateTime>("Createdtime",null); }
            set { setAttrVal<FDateTime>("Createdtime", value); }
        }
		public string Name_pat {
            get { return getAttrVal<string>("Name_pat",null); }
            set { setAttrVal<string>("Name_pat", value); }
        }
		public DateTime? Dt_birth_pat {
            get { return getAttrVal<FDate>("Dt_birth_pat",null); }
            set { setAttrVal<FDate>("Dt_birth_pat", value); }
        }
		public string Name_sex {
            get { return getAttrVal<string>("Name_sex",null); }
            set { setAttrVal<string>("Name_sex", value); }
        }
		public string Code_amr_ip {
            get { return getAttrVal<string>("Code_amr_ip",null); }
            set { setAttrVal<string>("Code_amr_ip", value); }
        }
		public string Name_anesthesia_method {
            get { return getAttrVal<string>("Name_anesthesia_method",null); }
            set { setAttrVal<string>("Name_anesthesia_method", value); }
        }
		public string Name_urine_color {
            get { return getAttrVal<string>("Name_urine_color",null); }
            set { setAttrVal<string>("Name_urine_color", value); }
        }
		public string Name_wash {
            get { return getAttrVal<string>("Name_wash",null); }
            set { setAttrVal<string>("Name_wash", value); }
        }
		public string Name_apply {
            get { return getAttrVal<string>("Name_apply",null); }
            set { setAttrVal<string>("Name_apply", value); }
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
            return "ci_mr_nu_oprcod";
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
            return "Id_oprcod";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.nu.obstetrics.opernurecord.d.OperNuRecordDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_oprcod", "Id_org", "Id_grp", "Id_ent", "Id_sex", "Sd_sex", "Id_pat", "Code_entp", "Age", "Weight", "Name_dep_nur", "Name_oper_room", "Dt_oper", "Dt_in", "Dt_begin", "Dt_end", "Dt_out", "Preoperative_diagnosis", "Name_oper", "Id_anesthesia_method", "Sd_anesthesia_method", "Position_oper", "Skin_beforeoper", "Name_allergy", "Eu_lzdn", "Eu_ngct", "Id_urine_color", "Sd_urine_color", "Bloodinoper", "Dose_urine", "Infusion", "Redbloodcell", "Plasma", "Eu_shysqk", "Skin_afteroper", "Eu_ylg", "Drainage_tube", "Eu_bb", "Sdb", "Dbp", "Pluse", "Breath", "Specialrec", "Id_emp_wash", "Id_emp_apply", "Sterile", "Modifiedtime", "Modifiedby", "Createdby", "Createdtime", "Name_pat", "Dt_birth_pat", "Name_sex", "Code_amr_ip", "Name_anesthesia_method", "Name_urine_color", "Name_wash", "Name_apply"};
        }
        
		/// <summary>
        /// 设置IBDataInfo接口映射数据
        /// </summary>
        /// <returns></returns>
		protected override void setBdDataInfoNameMap() {
			if (base.name_path_map == null)
            {
                base.name_path_map = new Dictionary<string, string>();
				base.name_path_map.Add("id_org","Id_org");
				base.name_path_map.Add("id_group","Id_grp");
            }
		}
    }
}
