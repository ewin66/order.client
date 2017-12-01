
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.mr.nu.obstetrics.antennurbserrec.d
{
    /// <summary>
    /// AntenNurBserRecDO 的摘要说明。
    /// </summary>
    public class AntenNurBserRecDO : BaseDO {

        public AntenNurBserRecDO() {
        }
		public string Id {
            get { return getAttrVal<string>("Id",null); }
            set { setAttrVal<string>("Id", value); }
        }
		public string Id_dept {
            get { return getAttrVal<string>("Id_dept",null); }
            set { setAttrVal<string>("Id_dept", value); }
        }
		public string Id_pat {
            get { return getAttrVal<string>("Id_pat",null); }
            set { setAttrVal<string>("Id_pat", value); }
        }
		public string Id_grp {
            get { return getAttrVal<string>("Id_grp",null); }
            set { setAttrVal<string>("Id_grp", value); }
        }
		public string Id_org {
            get { return getAttrVal<string>("Id_org",null); }
            set { setAttrVal<string>("Id_org", value); }
        }
		public string Ks {
            get { return getAttrVal<string>("Ks",null); }
            set { setAttrVal<string>("Ks", value); }
        }
		public string Hz {
            get { return getAttrVal<string>("Hz",null); }
            set { setAttrVal<string>("Hz", value); }
        }
		public string Ch {
            get { return getAttrVal<string>("Ch",null); }
            set { setAttrVal<string>("Ch", value); }
        }
		public string Zyh {
            get { return getAttrVal<string>("Zyh",null); }
            set { setAttrVal<string>("Zyh", value); }
        }
		public string Hznl {
            get { return getAttrVal<string>("Hznl",null); }
            set { setAttrVal<string>("Hznl", value); }
        }
		public string Rlmc {
            get { return getAttrVal<string>("Rlmc",null); }
            set { setAttrVal<string>("Rlmc", value); }
        }
		public string Rlyf {
            get { return getAttrVal<string>("Rlyf",null); }
            set { setAttrVal<string>("Rlyf", value); }
        }
		public string Bqgc {
            get { return getAttrVal<string>("Bqgc",null); }
            set { setAttrVal<string>("Bqgc", value); }
        }
		public string Clcs {
            get { return getAttrVal<string>("Clcs",null); }
            set { setAttrVal<string>("Clcs", value); }
        }
		public string Qm {
            get { return getAttrVal<string>("Qm",null); }
            set { setAttrVal<string>("Qm", value); }
        }
		public int? Mbcf {
            get { return getAttrVal<int?>("Mbcf",null); }
            set { setAttrVal<int?>("Mbcf", value); }
        }
		public int? Hxcf {
            get { return getAttrVal<int?>("Hxcf",null); }
            set { setAttrVal<int?>("Hxcf", value); }
        }
		public int? Ssymmhg {
            get { return getAttrVal<int?>("Ssymmhg",null); }
            set { setAttrVal<int?>("Ssymmhg", value); }
        }
		public int? Szymmhg {
            get { return getAttrVal<int?>("Szymmhg",null); }
            set { setAttrVal<int?>("Szymmhg", value); }
        }
		public int? Rljlml {
            get { return getAttrVal<int?>("Rljlml",null); }
            set { setAttrVal<int?>("Rljlml", value); }
        }
		public int? Gdgd {
            get { return getAttrVal<int?>("Gdgd",null); }
            set { setAttrVal<int?>("Gdgd", value); }
        }
		public int? Ydcxml {
            get { return getAttrVal<int?>("Ydcxml",null); }
            set { setAttrVal<int?>("Ydcxml", value); }
        }
		public int? Nlml {
            get { return getAttrVal<int?>("Nlml",null); }
            set { setAttrVal<int?>("Nlml", value); }
        }
		public FDouble Tw {
            get { return getAttrVal<FDouble>("Tw",null); }
            set { setAttrVal<FDouble>("Tw", value); }
        }
		public FDouble Xybhd {
            get { return getAttrVal<FDouble>("Xybhd",null); }
            set { setAttrVal<FDouble>("Xybhd", value); }
        }
		public DateTime? Jlrqsj {
            get { return getAttrVal<FDateTime>("Jlrqsj",null); }
            set { setAttrVal<FDateTime>("Jlrqsj", value); }
        }
		public string Eu_pfqk {
            get { return getAttrVal<string>("Eu_pfqk",null); }
            set { setAttrVal<string>("Eu_pfqk", value); }
        }
		public string Eu_zgss {
            get { return getAttrVal<string>("Eu_zgss",null); }
            set { setAttrVal<string>("Eu_zgss", value); }
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
		public string Name_dept {
            get { return getAttrVal<string>("Name_dept",null); }
            set { setAttrVal<string>("Name_dept", value); }
        }
		public string Name_pat {
            get { return getAttrVal<string>("Name_pat",null); }
            set { setAttrVal<string>("Name_pat", value); }
        }
		public string Name_group {
            get { return getAttrVal<string>("Name_group",null); }
            set { setAttrVal<string>("Name_group", value); }
        }
		public string Name_org {
            get { return getAttrVal<string>("Name_org",null); }
            set { setAttrVal<string>("Name_org", value); }
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
            return "CI_Mr_NU_ANTNURBSERREC";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.nu.obstetrics.antennurbserrec.d.AntenNurBserRecDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id", "Id_dept", "Id_pat", "Id_grp", "Id_org", "Ks", "Hz", "Ch", "Zyh", "Hznl", "Rlmc", "Rlyf", "Bqgc", "Clcs", "Qm", "Mbcf", "Hxcf", "Ssymmhg", "Szymmhg", "Rljlml", "Gdgd", "Ydcxml", "Nlml", "Tw", "Xybhd", "Jlrqsj", "Eu_pfqk", "Eu_zgss", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Name_dept", "Name_pat", "Name_group", "Name_org"};
        }
        
    }
}
