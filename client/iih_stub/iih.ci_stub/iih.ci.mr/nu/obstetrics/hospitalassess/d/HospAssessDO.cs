
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.mr.nu.obstetrics.hospitalassess.d
{
    /// <summary>
    /// HospAssessDO 的摘要说明。
    /// </summary>
    public class HospAssessDO : BaseDO {

        public HospAssessDO() {
        }
		public string Id_ha {
            get { return getAttrVal<string>("Id_ha",null); }
            set { setAttrVal<string>("Id_ha", value); }
        }
		public string Ks {
            get { return getAttrVal<string>("Ks",null); }
            set { setAttrVal<string>("Ks", value); }
        }
		public string Ch {
            get { return getAttrVal<string>("Ch",null); }
            set { setAttrVal<string>("Ch", value); }
        }
		public string Xm {
            get { return getAttrVal<string>("Xm",null); }
            set { setAttrVal<string>("Xm", value); }
        }
		public string Nl {
            get { return getAttrVal<string>("Nl",null); }
            set { setAttrVal<string>("Nl", value); }
        }
		public string Zyh {
            get { return getAttrVal<string>("Zyh",null); }
            set { setAttrVal<string>("Zyh", value); }
        }
		public DateTime? Rysj {
            get { return getAttrVal<FDateTime>("Rysj",null); }
            set { setAttrVal<FDateTime>("Rysj", value); }
        }
		public string Ryzd {
            get { return getAttrVal<string>("Ryzd",null); }
            set { setAttrVal<string>("Ryzd", value); }
        }
		public int? Eu_ryfs {
            get { return getAttrVal<int?>("Eu_ryfs",null); }
            set { setAttrVal<int?>("Eu_ryfs", value); }
        }
		public string Gms {
            get { return getAttrVal<string>("Gms",null); }
            set { setAttrVal<string>("Gms", value); }
        }
		public string Id_ggqk {
            get { return getAttrVal<string>("Id_ggqk",null); }
            set { setAttrVal<string>("Id_ggqk", value); }
        }
		public string Sd_ggqk {
            get { return getAttrVal<string>("Sd_ggqk",null); }
            set { setAttrVal<string>("Sd_ggqk", value); }
        }
		public string Id_ggqkqt {
            get { return getAttrVal<string>("Id_ggqkqt",null); }
            set { setAttrVal<string>("Id_ggqkqt", value); }
        }
		public string Sd_ggqkqt {
            get { return getAttrVal<string>("Sd_ggqkqt",null); }
            set { setAttrVal<string>("Sd_ggqkqt", value); }
        }
		public int? Eu_hljb {
            get { return getAttrVal<int?>("Eu_hljb",null); }
            set { setAttrVal<int?>("Eu_hljb", value); }
        }
		public int? Eu_hd {
            get { return getAttrVal<int?>("Eu_hd",null); }
            set { setAttrVal<int?>("Eu_hd", value); }
        }
		public string Qm {
            get { return getAttrVal<string>("Qm",null); }
            set { setAttrVal<string>("Qm", value); }
        }
		public string Id_grp {
            get { return getAttrVal<string>("Id_grp",null); }
            set { setAttrVal<string>("Id_grp", value); }
        }
		public string Id_org {
            get { return getAttrVal<string>("Id_org",null); }
            set { setAttrVal<string>("Id_org", value); }
        }
		public string Id_dept {
            get { return getAttrVal<string>("Id_dept",null); }
            set { setAttrVal<string>("Id_dept", value); }
        }
		public string Id_pat {
            get { return getAttrVal<string>("Id_pat",null); }
            set { setAttrVal<string>("Id_pat", value); }
        }
		public string Id_assess {
            get { return getAttrVal<string>("Id_assess",null); }
            set { setAttrVal<string>("Id_assess", value); }
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
		public string Dept_name {
            get { return getAttrVal<string>("Dept_name",null); }
            set { setAttrVal<string>("Dept_name", value); }
        }
		public string Pat_name {
            get { return getAttrVal<string>("Pat_name",null); }
            set { setAttrVal<string>("Pat_name", value); }
        }
		public string Assess_name {
            get { return getAttrVal<string>("Assess_name",null); }
            set { setAttrVal<string>("Assess_name", value); }
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
            return "CI_MR_NU_ADH_HA";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_ha";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.nu.obstetrics.hospitalassess.d.HospAssessDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_ha", "Ks", "Ch", "Xm", "Nl", "Zyh", "Rysj", "Ryzd", "Eu_ryfs", "Gms", "Id_ggqk", "Sd_ggqk", "Id_ggqkqt", "Sd_ggqkqt", "Eu_hljb", "Eu_hd", "Qm", "Id_grp", "Id_org", "Id_dept", "Id_pat", "Id_assess", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Dept_name", "Pat_name", "Assess_name"};
        }
        
    }
}
