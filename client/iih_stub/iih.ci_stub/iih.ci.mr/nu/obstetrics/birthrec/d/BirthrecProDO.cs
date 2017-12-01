
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.mr.nu.obstetrics.birthrec.d
{
    /// <summary>
    /// BirthrecProDO 的摘要说明。
    /// </summary>
    public class BirthrecProDO : BaseDO {

		public const string TABLE_NAME = "CI_MR_NU_BIRTHRECPRO";
		public const string TABLE_ALIAS_NAME = "a0b5";

        public BirthrecProDO() {
        }
		public string Id_birthrecpro {
            get { return getAttrVal<string>("Id_birthrecpro",null); }
            set { setAttrVal<string>("Id_birthrecpro", value); }
        }
		public string Id_birthinfo {
            get { return getAttrVal<string>("Id_birthinfo",null); }
            set { setAttrVal<string>("Id_birthinfo", value); }
        }
		public string Tm {
            get { return getAttrVal<string>("Tm",null); }
            set { setAttrVal<string>("Tm", value); }
        }
		public string Qm {
            get { return getAttrVal<string>("Qm",null); }
            set { setAttrVal<string>("Qm", value); }
        }
		public string Tfw {
            get { return getAttrVal<string>("Tfw",null); }
            set { setAttrVal<string>("Tfw", value); }
        }
		public string Gd {
            get { return getAttrVal<string>("Gd",null); }
            set { setAttrVal<string>("Gd", value); }
        }
		public string Ys {
            get { return getAttrVal<string>("Ys",null); }
            set { setAttrVal<string>("Ys", value); }
        }
		public int? Mb {
            get { return getAttrVal<int?>("Mb",null); }
            set { setAttrVal<int?>("Mb", value); }
        }
		public int? Gscx {
            get { return getAttrVal<int?>("Gscx",null); }
            set { setAttrVal<int?>("Gscx", value); }
        }
		public int? Szy {
            get { return getAttrVal<int?>("Szy",null); }
            set { setAttrVal<int?>("Szy", value); }
        }
		public int? Gsjg {
            get { return getAttrVal<int?>("Gsjg",null); }
            set { setAttrVal<int?>("Gsjg", value); }
        }
		public int? Ssy {
            get { return getAttrVal<int?>("Ssy",null); }
            set { setAttrVal<int?>("Ssy", value); }
        }
		public int? Tx {
            get { return getAttrVal<int?>("Tx",null); }
            set { setAttrVal<int?>("Tx", value); }
        }
		public FDouble Tw {
            get { return getAttrVal<FDouble>("Tw",null); }
            set { setAttrVal<FDouble>("Tw", value); }
        }
		public DateTime? Rq {
            get { return getAttrVal<FDateTime>("Rq",null); }
            set { setAttrVal<FDateTime>("Rq", value); }
        }
		public int? Eu_gsqr {
            get { return getAttrVal<int?>("Eu_gsqr",null); }
            set { setAttrVal<int?>("Eu_gsqr", value); }
        }
		public string Bz {
            get { return getAttrVal<string>("Bz",null); }
            set { setAttrVal<string>("Bz", value); }
        }
		public string Gk {
            get { return getAttrVal<string>("Gk",null); }
            set { setAttrVal<string>("Gk", value); }
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
            return "CI_MR_NU_BIRTHRECPRO";
        }
        
        /// <summary>
        /// 返回表别名
        /// </summary>
        /// <returns></returns>
        public override string getAliasTableName()
        {
            return "a0b5";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_birthrecpro";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.nu.obstetrics.birthrec.d.BirthrecProDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_birthrecpro", "Id_birthinfo", "Tm", "Qm", "Tfw", "Gd", "Ys", "Mb", "Gscx", "Szy", "Gsjg", "Ssy", "Tx", "Tw", "Rq", "Eu_gsqr", "Bz", "Gk"};
        }
        
    }
}
