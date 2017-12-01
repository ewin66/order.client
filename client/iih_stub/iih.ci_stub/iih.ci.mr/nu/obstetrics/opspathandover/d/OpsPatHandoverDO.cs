
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.mr.nu.obstetrics.opspathandover.d
{
    /// <summary>
    /// OpsPatHandoverDO 的摘要说明。
    /// </summary>
    public class OpsPatHandoverDO : BaseDO {

		public const string TABLE_NAME = "ci_mr_nu_opspathandover";
		public const string TABLE_ALIAS_NAME = "a0";

        public OpsPatHandoverDO() {
        }
		public string Id_opspathandover {
            get { return getAttrVal<string>("Id_opspathandover",null); }
            set { setAttrVal<string>("Id_opspathandover", value); }
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
		public string Id_pat {
            get { return getAttrVal<string>("Id_pat",null); }
            set { setAttrVal<string>("Id_pat", value); }
        }
		public string Code_entp {
            get { return getAttrVal<string>("Code_entp",null); }
            set { setAttrVal<string>("Code_entp", value); }
        }
		public DateTime? Dt_create {
            get { return getAttrVal<FDate>("Dt_create",null); }
            set { setAttrVal<FDate>("Dt_create", value); }
        }
		public DateTime? Dt_accept {
            get { return getAttrVal<FDateTime>("Dt_accept",null); }
            set { setAttrVal<FDateTime>("Dt_accept", value); }
        }
		public string Id_dep_nur {
            get { return getAttrVal<string>("Id_dep_nur",null); }
            set { setAttrVal<string>("Id_dep_nur", value); }
        }
		public string Name_bed {
            get { return getAttrVal<string>("Name_bed",null); }
            set { setAttrVal<string>("Name_bed", value); }
        }
		public string Age {
            get { return getAttrVal<string>("Age",null); }
            set { setAttrVal<string>("Age", value); }
        }
		public DateTime? Dt_inroom {
            get { return getAttrVal<FDateTime>("Dt_inroom",null); }
            set { setAttrVal<FDateTime>("Dt_inroom", value); }
        }
		public string Name_operation {
            get { return getAttrVal<string>("Name_operation",null); }
            set { setAttrVal<string>("Name_operation", value); }
        }
		public int? Eu_sqyy {
            get { return getAttrVal<int?>("Eu_sqyy",null); }
            set { setAttrVal<int?>("Eu_sqyy", value); }
        }
		public string Id_skin_con {
            get { return getAttrVal<string>("Id_skin_con",null); }
            set { setAttrVal<string>("Id_skin_con", value); }
        }
		public string Sd_skin_con {
            get { return getAttrVal<string>("Sd_skin_con",null); }
            set { setAttrVal<string>("Sd_skin_con", value); }
        }
		public int? Eu_jzrs {
            get { return getAttrVal<int?>("Eu_jzrs",null); }
            set { setAttrVal<int?>("Eu_jzrs", value); }
        }
		public string Id_con_statein {
            get { return getAttrVal<string>("Id_con_statein",null); }
            set { setAttrVal<string>("Id_con_statein", value); }
        }
		public string Sd_con_statein {
            get { return getAttrVal<string>("Sd_con_statein",null); }
            set { setAttrVal<string>("Sd_con_statein", value); }
        }
		public int? Eu_zthdzc {
            get { return getAttrVal<int?>("Eu_zthdzc",null); }
            set { setAttrVal<int?>("Eu_zthdzc", value); }
        }
		public int? Eu_grss {
            get { return getAttrVal<int?>("Eu_grss",null); }
            set { setAttrVal<int?>("Eu_grss", value); }
        }
		public int? Eu_bl {
            get { return getAttrVal<int?>("Eu_bl",null); }
            set { setAttrVal<int?>("Eu_bl", value); }
        }
		public int? Eu_jmtl {
            get { return getAttrVal<int?>("Eu_jmtl",null); }
            set { setAttrVal<int?>("Eu_jmtl", value); }
        }
		public int? Eu_lzdn {
            get { return getAttrVal<int?>("Eu_lzdn",null); }
            set { setAttrVal<int?>("Eu_lzdn", value); }
        }
		public int? Eu_pfqk {
            get { return getAttrVal<int?>("Eu_pfqk",null); }
            set { setAttrVal<int?>("Eu_pfqk", value); }
        }
		public string Des_skin_in {
            get { return getAttrVal<string>("Des_skin_in",null); }
            set { setAttrVal<string>("Des_skin_in", value); }
        }
		public string Remarks_zr {
            get { return getAttrVal<string>("Remarks_zr",null); }
            set { setAttrVal<string>("Remarks_zr", value); }
        }
		public string Id_emp_nur_inchk {
            get { return getAttrVal<string>("Id_emp_nur_inchk",null); }
            set { setAttrVal<string>("Id_emp_nur_inchk", value); }
        }
		public string Id_emp_opr_inchk {
            get { return getAttrVal<string>("Id_emp_opr_inchk",null); }
            set { setAttrVal<string>("Id_emp_opr_inchk", value); }
        }
		public DateTime? Dt_outroom {
            get { return getAttrVal<FDateTime>("Dt_outroom",null); }
            set { setAttrVal<FDateTime>("Dt_outroom", value); }
        }
		public string Id_liquid {
            get { return getAttrVal<string>("Id_liquid",null); }
            set { setAttrVal<string>("Id_liquid", value); }
        }
		public string Sd_liquid {
            get { return getAttrVal<string>("Sd_liquid",null); }
            set { setAttrVal<string>("Sd_liquid", value); }
        }
		public string Id_con_stateout {
            get { return getAttrVal<string>("Id_con_stateout",null); }
            set { setAttrVal<string>("Id_con_stateout", value); }
        }
		public string Sd_con_stateout {
            get { return getAttrVal<string>("Sd_con_stateout",null); }
            set { setAttrVal<string>("Sd_con_stateout", value); }
        }
		public string Id_breath_type {
            get { return getAttrVal<string>("Id_breath_type",null); }
            set { setAttrVal<string>("Id_breath_type", value); }
        }
		public string Sd_breath_type {
            get { return getAttrVal<string>("Sd_breath_type",null); }
            set { setAttrVal<string>("Sd_breath_type", value); }
        }
		public int? Eu_wzjmtc {
            get { return getAttrVal<int?>("Eu_wzjmtc",null); }
            set { setAttrVal<int?>("Eu_wzjmtc", value); }
        }
		public int? Eu_lzdngct {
            get { return getAttrVal<int?>("Eu_lzdngct",null); }
            set { setAttrVal<int?>("Eu_lzdngct", value); }
        }
		public int? Eu_zxjm {
            get { return getAttrVal<int?>("Eu_zxjm",null); }
            set { setAttrVal<int?>("Eu_zxjm", value); }
        }
		public int? Eu_qkyl {
            get { return getAttrVal<int?>("Eu_qkyl",null); }
            set { setAttrVal<int?>("Eu_qkyl", value); }
        }
		public string Id_infusion_blood {
            get { return getAttrVal<string>("Id_infusion_blood",null); }
            set { setAttrVal<string>("Id_infusion_blood", value); }
        }
		public string Sd_infusion_blood {
            get { return getAttrVal<string>("Sd_infusion_blood",null); }
            set { setAttrVal<string>("Sd_infusion_blood", value); }
        }
		public string Id_blood_pro {
            get { return getAttrVal<string>("Id_blood_pro",null); }
            set { setAttrVal<string>("Id_blood_pro", value); }
        }
		public string Sd_blood_pro {
            get { return getAttrVal<string>("Sd_blood_pro",null); }
            set { setAttrVal<string>("Sd_blood_pro", value); }
        }
		public int? Eu_hxypzsqk {
            get { return getAttrVal<int?>("Eu_hxypzsqk",null); }
            set { setAttrVal<int?>("Eu_hxypzsqk", value); }
        }
		public int? Eu_pfqj {
            get { return getAttrVal<int?>("Eu_pfqj",null); }
            set { setAttrVal<int?>("Eu_pfqj", value); }
        }
		public int? Eu_shjjbl {
            get { return getAttrVal<int?>("Eu_shjjbl",null); }
            set { setAttrVal<int?>("Eu_shjjbl", value); }
        }
		public int? Eu_shjjpfqk {
            get { return getAttrVal<int?>("Eu_shjjpfqk",null); }
            set { setAttrVal<int?>("Eu_shjjpfqk", value); }
        }
		public string Des_skin_out {
            get { return getAttrVal<string>("Des_skin_out",null); }
            set { setAttrVal<string>("Des_skin_out", value); }
        }
		public string Remark_jj {
            get { return getAttrVal<string>("Remark_jj",null); }
            set { setAttrVal<string>("Remark_jj", value); }
        }
		public string Id_emp_nur_outchk {
            get { return getAttrVal<string>("Id_emp_nur_outchk",null); }
            set { setAttrVal<string>("Id_emp_nur_outchk", value); }
        }
		public string Id_emp_opr_outchk {
            get { return getAttrVal<string>("Id_emp_opr_outchk",null); }
            set { setAttrVal<string>("Id_emp_opr_outchk", value); }
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
		public DateTime? Dt_birth_pat {
            get { return getAttrVal<FDate>("Dt_birth_pat",null); }
            set { setAttrVal<FDate>("Dt_birth_pat", value); }
        }
		public string Code_amr_ip {
            get { return getAttrVal<string>("Code_amr_ip",null); }
            set { setAttrVal<string>("Code_amr_ip", value); }
        }
		public string Name_dep_nur {
            get { return getAttrVal<string>("Name_dep_nur",null); }
            set { setAttrVal<string>("Name_dep_nur", value); }
        }
		public string Name_skin_con {
            get { return getAttrVal<string>("Name_skin_con",null); }
            set { setAttrVal<string>("Name_skin_con", value); }
        }
		public string Name_con_statein {
            get { return getAttrVal<string>("Name_con_statein",null); }
            set { setAttrVal<string>("Name_con_statein", value); }
        }
		public string Name_nur_inchk {
            get { return getAttrVal<string>("Name_nur_inchk",null); }
            set { setAttrVal<string>("Name_nur_inchk", value); }
        }
		public string Name_opr_inchk {
            get { return getAttrVal<string>("Name_opr_inchk",null); }
            set { setAttrVal<string>("Name_opr_inchk", value); }
        }
		public string Name_liquid {
            get { return getAttrVal<string>("Name_liquid",null); }
            set { setAttrVal<string>("Name_liquid", value); }
        }
		public string Name_con_stateout {
            get { return getAttrVal<string>("Name_con_stateout",null); }
            set { setAttrVal<string>("Name_con_stateout", value); }
        }
		public string Name_breath_type {
            get { return getAttrVal<string>("Name_breath_type",null); }
            set { setAttrVal<string>("Name_breath_type", value); }
        }
		public string Name_infusion_blood {
            get { return getAttrVal<string>("Name_infusion_blood",null); }
            set { setAttrVal<string>("Name_infusion_blood", value); }
        }
		public string Name_blood_pro {
            get { return getAttrVal<string>("Name_blood_pro",null); }
            set { setAttrVal<string>("Name_blood_pro", value); }
        }
		public string Name_nur_outchk {
            get { return getAttrVal<string>("Name_nur_outchk",null); }
            set { setAttrVal<string>("Name_nur_outchk", value); }
        }
		public string Name_opr_outchk {
            get { return getAttrVal<string>("Name_opr_outchk",null); }
            set { setAttrVal<string>("Name_opr_outchk", value); }
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
            return "ci_mr_nu_opspathandover";
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
            return "Id_opspathandover";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.nu.obstetrics.opspathandover.d.OpsPatHandoverDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_opspathandover", "Id_org", "Id_grp", "Id_ent", "Id_pat", "Code_entp", "Dt_create", "Dt_accept", "Id_dep_nur", "Name_bed", "Age", "Dt_inroom", "Name_operation", "Eu_sqyy", "Id_skin_con", "Sd_skin_con", "Eu_jzrs", "Id_con_statein", "Sd_con_statein", "Eu_zthdzc", "Eu_grss", "Eu_bl", "Eu_jmtl", "Eu_lzdn", "Eu_pfqk", "Des_skin_in", "Remarks_zr", "Id_emp_nur_inchk", "Id_emp_opr_inchk", "Dt_outroom", "Id_liquid", "Sd_liquid", "Id_con_stateout", "Sd_con_stateout", "Id_breath_type", "Sd_breath_type", "Eu_wzjmtc", "Eu_lzdngct", "Eu_zxjm", "Eu_qkyl", "Id_infusion_blood", "Sd_infusion_blood", "Id_blood_pro", "Sd_blood_pro", "Eu_hxypzsqk", "Eu_pfqj", "Eu_shjjbl", "Eu_shjjpfqk", "Des_skin_out", "Remark_jj", "Id_emp_nur_outchk", "Id_emp_opr_outchk", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Name_pat", "Dt_birth_pat", "Code_amr_ip", "Name_dep_nur", "Name_skin_con", "Name_con_statein", "Name_nur_inchk", "Name_opr_inchk", "Name_liquid", "Name_con_stateout", "Name_breath_type", "Name_infusion_blood", "Name_blood_pro", "Name_nur_outchk", "Name_opr_outchk"};
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
