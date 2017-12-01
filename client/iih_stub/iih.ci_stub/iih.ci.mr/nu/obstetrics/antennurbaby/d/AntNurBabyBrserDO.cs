
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.mr.nu.obstetrics.antennurbaby.d
{
    /// <summary>
    /// AntNurBabyBrserDO 的摘要说明。
    /// </summary>
    public class AntNurBabyBrserDO : BaseDO {

		public const string TABLE_NAME = "CI_Mr_NU_ANTNURBaBrser";
		public const string TABLE_ALIAS_NAME = "a0b8";

        public AntNurBabyBrserDO() {
        }
		public string Id_brser {
            get { return getAttrVal<string>("Id_brser",null); }
            set { setAttrVal<string>("Id_brser", value); }
        }
		public string Id_ass {
            get { return getAttrVal<string>("Id_ass",null); }
            set { setAttrVal<string>("Id_ass", value); }
        }
		public string Id_skincolor {
            get { return getAttrVal<string>("Id_skincolor",null); }
            set { setAttrVal<string>("Id_skincolor", value); }
        }
		public string Sd_skincolor {
            get { return getAttrVal<string>("Sd_skincolor",null); }
            set { setAttrVal<string>("Sd_skincolor", value); }
        }
		public string Id_umbilical {
            get { return getAttrVal<string>("Id_umbilical",null); }
            set { setAttrVal<string>("Id_umbilical", value); }
        }
		public string Sd_umbilical {
            get { return getAttrVal<string>("Sd_umbilical",null); }
            set { setAttrVal<string>("Sd_umbilical", value); }
        }
		public string Tsqkjcz {
            get { return getAttrVal<string>("Tsqkjcz",null); }
            set { setAttrVal<string>("Tsqkjcz", value); }
        }
		public string Id_signrec {
            get { return getAttrVal<string>("Id_signrec",null); }
            set { setAttrVal<string>("Id_signrec", value); }
        }
		public int? Jnsrlml {
            get { return getAttrVal<int?>("Jnsrlml",null); }
            set { setAttrVal<int?>("Jnsrlml", value); }
        }
		public int? Dbc8h {
            get { return getAttrVal<int?>("Dbc8h",null); }
            set { setAttrVal<int?>("Dbc8h", value); }
        }
		public int? Xbc8h {
            get { return getAttrVal<int?>("Xbc8h",null); }
            set { setAttrVal<int?>("Xbc8h", value); }
        }
		public FDouble Tw {
            get { return getAttrVal<FDouble>("Tw",null); }
            set { setAttrVal<FDouble>("Tw", value); }
        }
		public DateTime? D_rec {
            get { return getAttrVal<FDate>("D_rec",null); }
            set { setAttrVal<FDate>("D_rec", value); }
        }
		public DateTime? T_rec {
            get { return getAttrVal<FTime>("T_rec",null); }
            set { setAttrVal<FTime>("T_rec", value); }
        }
		public string Id_feeding {
            get { return getAttrVal<string>("Id_feeding",null); }
            set { setAttrVal<string>("Id_feeding", value); }
        }
		public string Sd_feeding {
            get { return getAttrVal<string>("Sd_feeding",null); }
            set { setAttrVal<string>("Sd_feeding", value); }
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
		public string Name_skincolor {
            get { return getAttrVal<string>("Name_skincolor",null); }
            set { setAttrVal<string>("Name_skincolor", value); }
        }
		public string Name_umbilical {
            get { return getAttrVal<string>("Name_umbilical",null); }
            set { setAttrVal<string>("Name_umbilical", value); }
        }
		public string Name_signrec {
            get { return getAttrVal<string>("Name_signrec",null); }
            set { setAttrVal<string>("Name_signrec", value); }
        }
		public string Name_feeding {
            get { return getAttrVal<string>("Name_feeding",null); }
            set { setAttrVal<string>("Name_feeding", value); }
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
            return "CI_Mr_NU_ANTNURBaBrser";
        }
        
        /// <summary>
        /// 返回表别名
        /// </summary>
        /// <returns></returns>
        public override string getAliasTableName()
        {
            return "a0b8";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_brser";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.nu.obstetrics.antennurbaby.d.AntNurBabyBrserDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_brser", "Id_ass", "Id_skincolor", "Sd_skincolor", "Id_umbilical", "Sd_umbilical", "Tsqkjcz", "Id_signrec", "Jnsrlml", "Dbc8h", "Xbc8h", "Tw", "D_rec", "T_rec", "Id_feeding", "Sd_feeding", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Name_skincolor", "Name_umbilical", "Name_signrec", "Name_feeding"};
        }
        
    }
}
