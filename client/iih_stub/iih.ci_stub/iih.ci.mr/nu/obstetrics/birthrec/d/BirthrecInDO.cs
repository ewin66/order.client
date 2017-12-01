
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.mr.nu.obstetrics.birthrec.d
{
    /// <summary>
    /// BirthrecInDO 的摘要说明。
    /// </summary>
    public class BirthrecInDO : BaseDO {

		public const string TABLE_NAME = "CI_MR_NU_BIRTHRECIN";
		public const string TABLE_ALIAS_NAME = "a0b4";

        public BirthrecInDO() {
        }
		public string Id_birthrecin {
            get { return getAttrVal<string>("Id_birthrecin",null); }
            set { setAttrVal<string>("Id_birthrecin", value); }
        }
		public string Id_birthinfo {
            get { return getAttrVal<string>("Id_birthinfo",null); }
            set { setAttrVal<string>("Id_birthinfo", value); }
        }
		public string Tw {
            get { return getAttrVal<string>("Tw",null); }
            set { setAttrVal<string>("Tw", value); }
        }
		public string Xl {
            get { return getAttrVal<string>("Xl",null); }
            set { setAttrVal<string>("Xl", value); }
        }
		public string Jc {
            get { return getAttrVal<string>("Jc",null); }
            set { setAttrVal<string>("Jc", value); }
        }
		public string Gk {
            get { return getAttrVal<string>("Gk",null); }
            set { setAttrVal<string>("Gk", value); }
        }
		public string Tm {
            get { return getAttrVal<string>("Tm",null); }
            set { setAttrVal<string>("Tm", value); }
        }
		public string Qm {
            get { return getAttrVal<string>("Qm",null); }
            set { setAttrVal<string>("Qm", value); }
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
		public int? Tedx {
            get { return getAttrVal<int?>("Tedx",null); }
            set { setAttrVal<int?>("Tedx", value); }
        }
		public FDouble Temp {
            get { return getAttrVal<FDouble>("Temp",null); }
            set { setAttrVal<FDouble>("Temp", value); }
        }
		public DateTime? Rq {
            get { return getAttrVal<FDateTime>("Rq",null); }
            set { setAttrVal<FDateTime>("Rq", value); }
        }
		public int? Gsqr {
            get { return getAttrVal<int?>("Gsqr",null); }
            set { setAttrVal<int?>("Gsqr", value); }
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
            return "CI_MR_NU_BIRTHRECIN";
        }
        
        /// <summary>
        /// 返回表别名
        /// </summary>
        /// <returns></returns>
        public override string getAliasTableName()
        {
            return "a0b4";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_birthrecin";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.nu.obstetrics.birthrec.d.BirthrecInDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_birthrecin", "Id_birthinfo", "Tw", "Xl", "Jc", "Gk", "Tm", "Qm", "Mb", "Gscx", "Szy", "Gsjg", "Ssy", "Tx", "Tedx", "Temp", "Rq", "Gsqr"};
        }
        
    }
}
