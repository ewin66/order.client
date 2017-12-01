
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.mr.nu.newbornveinnur.d
{
    /// <summary>
    /// NewBornVeinNurRecordDO 的摘要说明。
    /// </summary>
    public class NewBornVeinNurRecordDO : BaseDO {

		public const string TABLE_NAME = "ci_mr_nu_nbvn_rec";
		public const string TABLE_ALIAS_NAME = "a1";

        public NewBornVeinNurRecordDO() {
        }
		public string Id_nbvnrec {
            get { return getAttrVal<string>("Id_nbvnrec",null); }
            set { setAttrVal<string>("Id_nbvnrec", value); }
        }
		public string Id_nbvn {
            get { return getAttrVal<string>("Id_nbvn",null); }
            set { setAttrVal<string>("Id_nbvn", value); }
        }
		public DateTime? D_rec {
            get { return getAttrVal<FDate>("D_rec",null); }
            set { setAttrVal<FDate>("D_rec", value); }
        }
		public DateTime? T_rec {
            get { return getAttrVal<FTime>("T_rec",null); }
            set { setAttrVal<FTime>("T_rec", value); }
        }
		public int? Redswollen {
            get { return getAttrVal<int?>("Redswollen",null); }
            set { setAttrVal<int?>("Redswollen", value); }
        }
		public int? Bleeding {
            get { return getAttrVal<int?>("Bleeding",null); }
            set { setAttrVal<int?>("Bleeding", value); }
        }
		public string Id_smooth_pipe {
            get { return getAttrVal<string>("Id_smooth_pipe",null); }
            set { setAttrVal<string>("Id_smooth_pipe", value); }
        }
		public string Sd_smooth_pipe {
            get { return getAttrVal<string>("Sd_smooth_pipe",null); }
            set { setAttrVal<string>("Sd_smooth_pipe", value); }
        }
		public int? Catheter_insertion {
            get { return getAttrVal<int?>("Catheter_insertion",null); }
            set { setAttrVal<int?>("Catheter_insertion", value); }
        }
		public int? Catheter_exposed {
            get { return getAttrVal<int?>("Catheter_exposed",null); }
            set { setAttrVal<int?>("Catheter_exposed", value); }
        }
		public int? Replace_dressing {
            get { return getAttrVal<int?>("Replace_dressing",null); }
            set { setAttrVal<int?>("Replace_dressing", value); }
        }
		public int? Replace_infusion_conector {
            get { return getAttrVal<int?>("Replace_infusion_conector",null); }
            set { setAttrVal<int?>("Replace_infusion_conector", value); }
        }
		public string Other {
            get { return getAttrVal<string>("Other",null); }
            set { setAttrVal<string>("Other", value); }
        }
		public string Id_sign {
            get { return getAttrVal<string>("Id_sign",null); }
            set { setAttrVal<string>("Id_sign", value); }
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
		public string Name_smooth_pipe {
            get { return getAttrVal<string>("Name_smooth_pipe",null); }
            set { setAttrVal<string>("Name_smooth_pipe", value); }
        }
		public string Name_sign {
            get { return getAttrVal<string>("Name_sign",null); }
            set { setAttrVal<string>("Name_sign", value); }
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
            return "ci_mr_nu_nbvn_rec";
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
            return "Id_nbvnrec";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.nu.newbornveinnur.d.NewBornVeinNurRecordDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_nbvnrec", "Id_nbvn", "D_rec", "T_rec", "Redswollen", "Bleeding", "Id_smooth_pipe", "Sd_smooth_pipe", "Catheter_insertion", "Catheter_exposed", "Replace_dressing", "Replace_infusion_conector", "Other", "Id_sign", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Name_smooth_pipe", "Name_sign"};
        }
        
    }
}
