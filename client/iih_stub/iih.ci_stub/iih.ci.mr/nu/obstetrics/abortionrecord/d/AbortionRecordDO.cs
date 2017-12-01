
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.mr.nu.obstetrics.abortionrecord.d
{
    /// <summary>
    /// AbortionRecordDO 的摘要说明。
    /// </summary>
    public class AbortionRecordDO : BaseDO {

		public const string TABLE_NAME = "ci_mr_nu_abortionrecord";
		public const string TABLE_ALIAS_NAME = "a0";

        public AbortionRecordDO() {
        }
		public string Id_abortion {
            get { return getAttrVal<string>("Id_abortion",null); }
            set { setAttrVal<string>("Id_abortion", value); }
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
		public string Name_pat {
            get { return getAttrVal<string>("Name_pat",null); }
            set { setAttrVal<string>("Name_pat", value); }
        }
		public string Code_entp {
            get { return getAttrVal<string>("Code_entp",null); }
            set { setAttrVal<string>("Code_entp", value); }
        }
		public string Age {
            get { return getAttrVal<string>("Age",null); }
            set { setAttrVal<string>("Age", value); }
        }
		public string Id_sex {
            get { return getAttrVal<string>("Id_sex",null); }
            set { setAttrVal<string>("Id_sex", value); }
        }
		public string Sd_sex {
            get { return getAttrVal<string>("Sd_sex",null); }
            set { setAttrVal<string>("Sd_sex", value); }
        }
		public string Id_dep_nur {
            get { return getAttrVal<string>("Id_dep_nur",null); }
            set { setAttrVal<string>("Id_dep_nur", value); }
        }
		public string Name_bed {
            get { return getAttrVal<string>("Name_bed",null); }
            set { setAttrVal<string>("Name_bed", value); }
        }
		public string Code_amr_ip {
            get { return getAttrVal<string>("Code_amr_ip",null); }
            set { setAttrVal<string>("Code_amr_ip", value); }
        }
		public string Name_diagnosis {
            get { return getAttrVal<string>("Name_diagnosis",null); }
            set { setAttrVal<string>("Name_diagnosis", value); }
        }
		public DateTime? Dt_in {
            get { return getAttrVal<FDateTime>("Dt_in",null); }
            set { setAttrVal<FDateTime>("Dt_in", value); }
        }
		public DateTime? Dt_contractions {
            get { return getAttrVal<FDateTime>("Dt_contractions",null); }
            set { setAttrVal<FDateTime>("Dt_contractions", value); }
        }
		public DateTime? Dt_amnioticfluid_rupture {
            get { return getAttrVal<FDateTime>("Dt_amnioticfluid_rupture",null); }
            set { setAttrVal<FDateTime>("Dt_amnioticfluid_rupture", value); }
        }
		public string Id_rupturetp {
            get { return getAttrVal<string>("Id_rupturetp",null); }
            set { setAttrVal<string>("Id_rupturetp", value); }
        }
		public string Sd_rupturetp {
            get { return getAttrVal<string>("Sd_rupturetp",null); }
            set { setAttrVal<string>("Sd_rupturetp", value); }
        }
		public string Id_amnioticfluid_color {
            get { return getAttrVal<string>("Id_amnioticfluid_color",null); }
            set { setAttrVal<string>("Id_amnioticfluid_color", value); }
        }
		public string Sd_amnioticfluid_color {
            get { return getAttrVal<string>("Sd_amnioticfluid_color",null); }
            set { setAttrVal<string>("Sd_amnioticfluid_color", value); }
        }
		public DateTime? Dt_abortion {
            get { return getAttrVal<FDateTime>("Dt_abortion",null); }
            set { setAttrVal<FDateTime>("Dt_abortion", value); }
        }
		public string Id_childbirth_abortiontp {
            get { return getAttrVal<string>("Id_childbirth_abortiontp",null); }
            set { setAttrVal<string>("Id_childbirth_abortiontp", value); }
        }
		public string Sd_childbirth_abortiontp {
            get { return getAttrVal<string>("Sd_childbirth_abortiontp",null); }
            set { setAttrVal<string>("Sd_childbirth_abortiontp", value); }
        }
		public string Id_child_situation {
            get { return getAttrVal<string>("Id_child_situation",null); }
            set { setAttrVal<string>("Id_child_situation", value); }
        }
		public string Sd_child_situation {
            get { return getAttrVal<string>("Sd_child_situation",null); }
            set { setAttrVal<string>("Sd_child_situation", value); }
        }
		public int? Length_child {
            get { return getAttrVal<int?>("Length_child",null); }
            set { setAttrVal<int?>("Length_child", value); }
        }
		public int? Weight_child {
            get { return getAttrVal<int?>("Weight_child",null); }
            set { setAttrVal<int?>("Weight_child", value); }
        }
		public string Id_child_appearances {
            get { return getAttrVal<string>("Id_child_appearances",null); }
            set { setAttrVal<string>("Id_child_appearances", value); }
        }
		public string Sd_child_appearances {
            get { return getAttrVal<string>("Sd_child_appearances",null); }
            set { setAttrVal<string>("Sd_child_appearances", value); }
        }
		public bool? Fg_malformation {
            get { return getAttrVal<FBoolean>("Fg_malformation",null); }
            set { setAttrVal<FBoolean>("Fg_malformation", value); }
        }
		public string Id_deliverytp {
            get { return getAttrVal<string>("Id_deliverytp",null); }
            set { setAttrVal<string>("Id_deliverytp", value); }
        }
		public string Sd_deliverytp {
            get { return getAttrVal<string>("Sd_deliverytp",null); }
            set { setAttrVal<string>("Sd_deliverytp", value); }
        }
		public DateTime? Dt_delivery {
            get { return getAttrVal<FDateTime>("Dt_delivery",null); }
            set { setAttrVal<FDateTime>("Dt_delivery", value); }
        }
		public string Id_placenta_birthtp {
            get { return getAttrVal<string>("Id_placenta_birthtp",null); }
            set { setAttrVal<string>("Id_placenta_birthtp", value); }
        }
		public string Sd_placenta_birthtp {
            get { return getAttrVal<string>("Sd_placenta_birthtp",null); }
            set { setAttrVal<string>("Sd_placenta_birthtp", value); }
        }
		public string Id_placenta_situation {
            get { return getAttrVal<string>("Id_placenta_situation",null); }
            set { setAttrVal<string>("Id_placenta_situation", value); }
        }
		public string Sd_placenta_situation {
            get { return getAttrVal<string>("Sd_placenta_situation",null); }
            set { setAttrVal<string>("Sd_placenta_situation", value); }
        }
		public string Id_caul_situation {
            get { return getAttrVal<string>("Id_caul_situation",null); }
            set { setAttrVal<string>("Id_caul_situation", value); }
        }
		public string Sd_caul_situation {
            get { return getAttrVal<string>("Sd_caul_situation",null); }
            set { setAttrVal<string>("Sd_caul_situation", value); }
        }
		public int? Num_bleeding {
            get { return getAttrVal<int?>("Num_bleeding",null); }
            set { setAttrVal<int?>("Num_bleeding", value); }
        }
		public string Id_contractions_agent {
            get { return getAttrVal<string>("Id_contractions_agent",null); }
            set { setAttrVal<string>("Id_contractions_agent", value); }
        }
		public string Sd_contractions_agent {
            get { return getAttrVal<string>("Sd_contractions_agent",null); }
            set { setAttrVal<string>("Sd_contractions_agent", value); }
        }
		public string Id_route {
            get { return getAttrVal<string>("Id_route",null); }
            set { setAttrVal<string>("Id_route", value); }
        }
		public int? Num_bleedinged {
            get { return getAttrVal<int?>("Num_bleedinged",null); }
            set { setAttrVal<int?>("Num_bleedinged", value); }
        }
		public int? Heightpressure {
            get { return getAttrVal<int?>("Heightpressure",null); }
            set { setAttrVal<int?>("Heightpressure", value); }
        }
		public int? Lowpressure {
            get { return getAttrVal<int?>("Lowpressure",null); }
            set { setAttrVal<int?>("Lowpressure", value); }
        }
		public int? Pulse {
            get { return getAttrVal<int?>("Pulse",null); }
            set { setAttrVal<int?>("Pulse", value); }
        }
		public bool? Fg_full_bladder {
            get { return getAttrVal<FBoolean>("Fg_full_bladder",null); }
            set { setAttrVal<FBoolean>("Fg_full_bladder", value); }
        }
		public string Id_birth_canal_chk {
            get { return getAttrVal<string>("Id_birth_canal_chk",null); }
            set { setAttrVal<string>("Id_birth_canal_chk", value); }
        }
		public string Sd_birth_canal_chk {
            get { return getAttrVal<string>("Sd_birth_canal_chk",null); }
            set { setAttrVal<string>("Sd_birth_canal_chk", value); }
        }
		public string Note {
            get { return getAttrVal<string>("Note",null); }
            set { setAttrVal<string>("Note", value); }
        }
		public int? Num_bleeding_vagina {
            get { return getAttrVal<int?>("Num_bleeding_vagina",null); }
            set { setAttrVal<int?>("Num_bleeding_vagina", value); }
        }
		public string Id_order_drug {
            get { return getAttrVal<string>("Id_order_drug",null); }
            set { setAttrVal<string>("Id_order_drug", value); }
        }
		public string Sd_order_drug {
            get { return getAttrVal<string>("Sd_order_drug",null); }
            set { setAttrVal<string>("Sd_order_drug", value); }
        }
		public int? Dosage {
            get { return getAttrVal<int?>("Dosage",null); }
            set { setAttrVal<int?>("Dosage", value); }
        }
		public string Id_complication {
            get { return getAttrVal<string>("Id_complication",null); }
            set { setAttrVal<string>("Id_complication", value); }
        }
		public string Sd_complication {
            get { return getAttrVal<string>("Sd_complication",null); }
            set { setAttrVal<string>("Sd_complication", value); }
        }
		public string Id_emp_dely {
            get { return getAttrVal<string>("Id_emp_dely",null); }
            set { setAttrVal<string>("Id_emp_dely", value); }
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
		public string Name_sex {
            get { return getAttrVal<string>("Name_sex",null); }
            set { setAttrVal<string>("Name_sex", value); }
        }
		public string Name_dep_nur {
            get { return getAttrVal<string>("Name_dep_nur",null); }
            set { setAttrVal<string>("Name_dep_nur", value); }
        }
		public string Name_rupturetp {
            get { return getAttrVal<string>("Name_rupturetp",null); }
            set { setAttrVal<string>("Name_rupturetp", value); }
        }
		public string Name_amnioticfluid_color {
            get { return getAttrVal<string>("Name_amnioticfluid_color",null); }
            set { setAttrVal<string>("Name_amnioticfluid_color", value); }
        }
		public string Name_childbirth_abortiontp {
            get { return getAttrVal<string>("Name_childbirth_abortiontp",null); }
            set { setAttrVal<string>("Name_childbirth_abortiontp", value); }
        }
		public string Name_child_situation {
            get { return getAttrVal<string>("Name_child_situation",null); }
            set { setAttrVal<string>("Name_child_situation", value); }
        }
		public string Name_child_appearances {
            get { return getAttrVal<string>("Name_child_appearances",null); }
            set { setAttrVal<string>("Name_child_appearances", value); }
        }
		public string Name_deliverytp {
            get { return getAttrVal<string>("Name_deliverytp",null); }
            set { setAttrVal<string>("Name_deliverytp", value); }
        }
		public string Name_placenta_birthtp {
            get { return getAttrVal<string>("Name_placenta_birthtp",null); }
            set { setAttrVal<string>("Name_placenta_birthtp", value); }
        }
		public string Name_placenta_situation {
            get { return getAttrVal<string>("Name_placenta_situation",null); }
            set { setAttrVal<string>("Name_placenta_situation", value); }
        }
		public string Name_caul_situation {
            get { return getAttrVal<string>("Name_caul_situation",null); }
            set { setAttrVal<string>("Name_caul_situation", value); }
        }
		public string Name_contractions_agent {
            get { return getAttrVal<string>("Name_contractions_agent",null); }
            set { setAttrVal<string>("Name_contractions_agent", value); }
        }
		public string Name_route {
            get { return getAttrVal<string>("Name_route",null); }
            set { setAttrVal<string>("Name_route", value); }
        }
		public string Name_birth_canal_chk {
            get { return getAttrVal<string>("Name_birth_canal_chk",null); }
            set { setAttrVal<string>("Name_birth_canal_chk", value); }
        }
		public string Name_order_drug {
            get { return getAttrVal<string>("Name_order_drug",null); }
            set { setAttrVal<string>("Name_order_drug", value); }
        }
		public string Name_complication {
            get { return getAttrVal<string>("Name_complication",null); }
            set { setAttrVal<string>("Name_complication", value); }
        }
		public string Name_emp_dely {
            get { return getAttrVal<string>("Name_emp_dely",null); }
            set { setAttrVal<string>("Name_emp_dely", value); }
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
            return "ci_mr_nu_abortionrecord";
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
            return "Id_abortion";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.nu.obstetrics.abortionrecord.d.AbortionRecordDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_abortion", "Id_grp", "Id_org", "Id_pat", "Id_ent", "Name_pat", "Code_entp", "Age", "Id_sex", "Sd_sex", "Id_dep_nur", "Name_bed", "Code_amr_ip", "Name_diagnosis", "Dt_in", "Dt_contractions", "Dt_amnioticfluid_rupture", "Id_rupturetp", "Sd_rupturetp", "Id_amnioticfluid_color", "Sd_amnioticfluid_color", "Dt_abortion", "Id_childbirth_abortiontp", "Sd_childbirth_abortiontp", "Id_child_situation", "Sd_child_situation", "Length_child", "Weight_child", "Id_child_appearances", "Sd_child_appearances", "Fg_malformation", "Id_deliverytp", "Sd_deliverytp", "Dt_delivery", "Id_placenta_birthtp", "Sd_placenta_birthtp", "Id_placenta_situation", "Sd_placenta_situation", "Id_caul_situation", "Sd_caul_situation", "Num_bleeding", "Id_contractions_agent", "Sd_contractions_agent", "Id_route", "Num_bleedinged", "Heightpressure", "Lowpressure", "Pulse", "Fg_full_bladder", "Id_birth_canal_chk", "Sd_birth_canal_chk", "Note", "Num_bleeding_vagina", "Id_order_drug", "Sd_order_drug", "Dosage", "Id_complication", "Sd_complication", "Id_emp_dely", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Name_sex", "Name_dep_nur", "Name_rupturetp", "Name_amnioticfluid_color", "Name_childbirth_abortiontp", "Name_child_situation", "Name_child_appearances", "Name_deliverytp", "Name_placenta_birthtp", "Name_placenta_situation", "Name_caul_situation", "Name_contractions_agent", "Name_route", "Name_birth_canal_chk", "Name_order_drug", "Name_complication", "Name_emp_dely"};
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
