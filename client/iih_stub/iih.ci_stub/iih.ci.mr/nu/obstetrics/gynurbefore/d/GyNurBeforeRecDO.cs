
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.mr.nu.obstetrics.gynurbefore.d
{
    /// <summary>
    /// GyNurBeforeRecDO 的摘要说明。
    /// </summary>
    public class GyNurBeforeRecDO : BaseDO {

		public const string TABLE_NAME = "CI_MR_NU_GYBEFOREREC";
		public const string TABLE_ALIAS_NAME = "a1";

        public GyNurBeforeRecDO() {
        }
		public string Id_rec {
            get { return getAttrVal<string>("Id_rec",null); }
            set { setAttrVal<string>("Id_rec", value); }
        }
		public string Id_ass {
            get { return getAttrVal<string>("Id_ass",null); }
            set { setAttrVal<string>("Id_ass", value); }
        }
		public DateTime? Rq {
            get { return getAttrVal<FDateTime>("Rq",null); }
            set { setAttrVal<FDateTime>("Rq", value); }
        }
		public FDouble Twt {
            get { return getAttrVal<FDouble>("Twt",null); }
            set { setAttrVal<FDouble>("Twt", value); }
        }
		public int? Mbp {
            get { return getAttrVal<int?>("Mbp",null); }
            set { setAttrVal<int?>("Mbp", value); }
        }
		public int? Hxr {
            get { return getAttrVal<int?>("Hxr",null); }
            set { setAttrVal<int?>("Hxr", value); }
        }
		public int? Ssysbp {
            get { return getAttrVal<int?>("Ssysbp",null); }
            set { setAttrVal<int?>("Ssysbp", value); }
        }
		public int? Szydbp {
            get { return getAttrVal<int?>("Szydbp",null); }
            set { setAttrVal<int?>("Szydbp", value); }
        }
		public FDouble Xybhdsao {
            get { return getAttrVal<FDouble>("Xybhdsao",null); }
            set { setAttrVal<FDouble>("Xybhdsao", value); }
        }
		public int? Tx {
            get { return getAttrVal<int?>("Tx",null); }
            set { setAttrVal<int?>("Tx", value); }
        }
		public int? Ft {
            get { return getAttrVal<int?>("Ft",null); }
            set { setAttrVal<int?>("Ft", value); }
        }
		public string Id_ydcx {
            get { return getAttrVal<string>("Id_ydcx",null); }
            set { setAttrVal<string>("Id_ydcx", value); }
        }
		public string Sd_ydcx {
            get { return getAttrVal<string>("Sd_ydcx",null); }
            set { setAttrVal<string>("Sd_ydcx", value); }
        }
		public string Rlmc {
            get { return getAttrVal<string>("Rlmc",null); }
            set { setAttrVal<string>("Rlmc", value); }
        }
		public int? Rljl {
            get { return getAttrVal<int?>("Rljl",null); }
            set { setAttrVal<int?>("Rljl", value); }
        }
		public string Id_rlyf {
            get { return getAttrVal<string>("Id_rlyf",null); }
            set { setAttrVal<string>("Id_rlyf", value); }
        }
		public string Sd_rlyf {
            get { return getAttrVal<string>("Sd_rlyf",null); }
            set { setAttrVal<string>("Sd_rlyf", value); }
        }
		public int? Clnl {
            get { return getAttrVal<int?>("Clnl",null); }
            set { setAttrVal<int?>("Clnl", value); }
        }
		public int? Clotl {
            get { return getAttrVal<int?>("Clotl",null); }
            set { setAttrVal<int?>("Clotl", value); }
        }
		public string Bqgcjcs {
            get { return getAttrVal<string>("Bqgcjcs",null); }
            set { setAttrVal<string>("Bqgcjcs", value); }
        }
		public string Gcjlqm {
            get { return getAttrVal<string>("Gcjlqm",null); }
            set { setAttrVal<string>("Gcjlqm", value); }
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
		public string Name_ydcx {
            get { return getAttrVal<string>("Name_ydcx",null); }
            set { setAttrVal<string>("Name_ydcx", value); }
        }
		public string Name_rlyf {
            get { return getAttrVal<string>("Name_rlyf",null); }
            set { setAttrVal<string>("Name_rlyf", value); }
        }
		public string Name_psndoc {
            get { return getAttrVal<string>("Name_psndoc",null); }
            set { setAttrVal<string>("Name_psndoc", value); }
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
            return "CI_MR_NU_GYBEFOREREC";
        }
        
        /// <summary>
        /// 返回表别名
        /// </summary>
        /// <returns></returns>
        public override string getAliasTableName()
        {
            return "a1";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_rec";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.nu.obstetrics.gynurbefore.d.GyNurBeforeRecDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_rec", "Id_ass", "Rq", "Twt", "Mbp", "Hxr", "Ssysbp", "Szydbp", "Xybhdsao", "Tx", "Ft", "Id_ydcx", "Sd_ydcx", "Rlmc", "Rljl", "Id_rlyf", "Sd_rlyf", "Clnl", "Clotl", "Bqgcjcs", "Gcjlqm", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Name_ydcx", "Name_rlyf", "Name_psndoc"};
        }
        
    }
}
