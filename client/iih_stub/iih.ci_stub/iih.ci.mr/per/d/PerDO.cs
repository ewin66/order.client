
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.mr.per.d
{
    /// <summary>
    /// PerDO 的摘要说明。
    /// </summary>
    public class PerDO : BaseDO {

        public PerDO() {
        }
		public string Id_per {
            get { return getAttrVal<string>("Id_per",null); }
            set { setAttrVal<string>("Id_per", value); }
        }
		public string Id_mr {
            get { return getAttrVal<string>("Id_mr",null); }
            set { setAttrVal<string>("Id_mr", value); }
        }
		public string Id_ent {
            get { return getAttrVal<string>("Id_ent",null); }
            set { setAttrVal<string>("Id_ent", value); }
        }
		public string Id_pat {
            get { return getAttrVal<string>("Id_pat",null); }
            set { setAttrVal<string>("Id_pat", value); }
        }
		public string Code_amr_ip {
            get { return getAttrVal<string>("Code_amr_ip",null); }
            set { setAttrVal<string>("Code_amr_ip", value); }
        }
		public string Code_entp {
            get { return getAttrVal<string>("Code_entp",null); }
            set { setAttrVal<string>("Code_entp", value); }
        }
		public string Name {
            get { return getAttrVal<string>("Name",null); }
            set { setAttrVal<string>("Name", value); }
        }
		public DateTime? Dt_op {
            get { return getAttrVal<FDate>("Dt_op",null); }
            set { setAttrVal<FDate>("Dt_op", value); }
        }
		public string Id_dep_op {
            get { return getAttrVal<string>("Id_dep_op",null); }
            set { setAttrVal<string>("Id_dep_op", value); }
        }
		public string Bi_per {
            get { return getAttrVal<string>("Bi_per",null); }
            set { setAttrVal<string>("Bi_per", value); }
        }
		public string Dis_icd {
            get { return getAttrVal<string>("Dis_icd",null); }
            set { setAttrVal<string>("Dis_icd", value); }
        }
		public string Dia_tre_plan {
            get { return getAttrVal<string>("Dia_tre_plan",null); }
            set { setAttrVal<string>("Dia_tre_plan", value); }
        }
		public string Remark {
            get { return getAttrVal<string>("Remark",null); }
            set { setAttrVal<string>("Remark", value); }
        }
		public string Createdby {
            get { return getAttrVal<string>("Createdby",null); }
            set { setAttrVal<string>("Createdby", value); }
        }
		public string Createdtime {
            get { return getAttrVal<string>("Createdtime",null); }
            set { setAttrVal<string>("Createdtime", value); }
        }
		public string Modifiedby {
            get { return getAttrVal<string>("Modifiedby",null); }
            set { setAttrVal<string>("Modifiedby", value); }
        }
		public string Modifiedtime {
            get { return getAttrVal<string>("Modifiedtime",null); }
            set { setAttrVal<string>("Modifiedtime", value); }
        }
		public string Id_code {
            get { return getAttrVal<string>("Id_code",null); }
            set { setAttrVal<string>("Id_code", value); }
        }
		public string Id_sex {
            get { return getAttrVal<string>("Id_sex",null); }
            set { setAttrVal<string>("Id_sex", value); }
        }
		public string Sd_sex {
            get { return getAttrVal<string>("Sd_sex",null); }
            set { setAttrVal<string>("Sd_sex", value); }
        }
		public string Name_sex {
            get { return getAttrVal<string>("Name_sex",null); }
            set { setAttrVal<string>("Name_sex", value); }
        }
		public DateTime? Dt_birth {
            get { return getAttrVal<FDate>("Dt_birth",null); }
            set { setAttrVal<FDate>("Dt_birth", value); }
        }
		public string Id_emp_entry {
            get { return getAttrVal<string>("Id_emp_entry",null); }
            set { setAttrVal<string>("Id_emp_entry", value); }
        }
		public string Sd_emp_entry {
            get { return getAttrVal<string>("Sd_emp_entry",null); }
            set { setAttrVal<string>("Sd_emp_entry", value); }
        }
		public string Name_emp_entry {
            get { return getAttrVal<string>("Name_emp_entry",null); }
            set { setAttrVal<string>("Name_emp_entry", value); }
        }
		public string Id_grp {
            get { return getAttrVal<string>("Id_grp",null); }
            set { setAttrVal<string>("Id_grp", value); }
        }
		public string Sd_grp {
            get { return getAttrVal<string>("Sd_grp",null); }
            set { setAttrVal<string>("Sd_grp", value); }
        }
		public string Name_grp {
            get { return getAttrVal<string>("Name_grp",null); }
            set { setAttrVal<string>("Name_grp", value); }
        }
		public string Id_org {
            get { return getAttrVal<string>("Id_org",null); }
            set { setAttrVal<string>("Id_org", value); }
        }
		public string Sd_org {
            get { return getAttrVal<string>("Sd_org",null); }
            set { setAttrVal<string>("Sd_org", value); }
        }
		public string Name_org {
            get { return getAttrVal<string>("Name_org",null); }
            set { setAttrVal<string>("Name_org", value); }
        }
		public string Sex_code {
            get { return getAttrVal<string>("Sex_code",null); }
            set { setAttrVal<string>("Sex_code", value); }
        }
		public string Sex_name {
            get { return getAttrVal<string>("Sex_name",null); }
            set { setAttrVal<string>("Sex_name", value); }
        }
		public string Emp_entry_code {
            get { return getAttrVal<string>("Emp_entry_code",null); }
            set { setAttrVal<string>("Emp_entry_code", value); }
        }
		public string Emp_entry_name {
            get { return getAttrVal<string>("Emp_entry_name",null); }
            set { setAttrVal<string>("Emp_entry_name", value); }
        }
		public string Org_code {
            get { return getAttrVal<string>("Org_code",null); }
            set { setAttrVal<string>("Org_code", value); }
        }
		public string Org_name {
            get { return getAttrVal<string>("Org_name",null); }
            set { setAttrVal<string>("Org_name", value); }
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
            return "CI_MR_PER_QC";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_per";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.per.d.PerDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_per", "Id_mr", "Id_ent", "Id_pat", "Code_amr_ip", "Code_entp", "Name", "Dt_op", "Id_dep_op", "Bi_per", "Dis_icd", "Dia_tre_plan", "Remark", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Id_code", "Id_sex", "Sd_sex", "Name_sex", "Dt_birth", "Id_emp_entry", "Sd_emp_entry", "Name_emp_entry", "Id_grp", "Sd_grp", "Name_grp", "Id_org", "Sd_org", "Name_org", "Sex_code", "Sex_name", "Emp_entry_code", "Emp_entry_name", "Org_code", "Org_name"};
        }
        
    }
}
