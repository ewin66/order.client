
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.mr.nu.newbabypicc.d
{
    /// <summary>
    /// NewBabyPiccRecDO 的摘要说明。
    /// </summary>
    public class NewBabyPiccRecDO : BaseDO {

		public const string TABLE_NAME = "ci_mr_nu_picc_rec";
		public const string TABLE_ALIAS_NAME = "a1";

        public NewBabyPiccRecDO() {
        }
		public string Id_piccrec {
            get { return getAttrVal<string>("Id_piccrec",null); }
            set { setAttrVal<string>("Id_piccrec", value); }
        }
		public string Id_picc {
            get { return getAttrVal<string>("Id_picc",null); }
            set { setAttrVal<string>("Id_picc", value); }
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
		public int? Scleroma {
            get { return getAttrVal<int?>("Scleroma",null); }
            set { setAttrVal<int?>("Scleroma", value); }
        }
		public int? Bleeding {
            get { return getAttrVal<int?>("Bleeding",null); }
            set { setAttrVal<int?>("Bleeding", value); }
        }
		public string Id_pipe_infusion {
            get { return getAttrVal<string>("Id_pipe_infusion",null); }
            set { setAttrVal<string>("Id_pipe_infusion", value); }
        }
		public string Sd_pipe_infusion {
            get { return getAttrVal<string>("Sd_pipe_infusion",null); }
            set { setAttrVal<string>("Sd_pipe_infusion", value); }
        }
		public int? Catheter_insertion {
            get { return getAttrVal<int?>("Catheter_insertion",null); }
            set { setAttrVal<int?>("Catheter_insertion", value); }
        }
		public int? Catheter_exposed {
            get { return getAttrVal<int?>("Catheter_exposed",null); }
            set { setAttrVal<int?>("Catheter_exposed", value); }
        }
		public FDouble Length_leftarm {
            get { return getAttrVal<FDouble>("Length_leftarm",null); }
            set { setAttrVal<FDouble>("Length_leftarm", value); }
        }
		public FDouble Length_rightarm {
            get { return getAttrVal<FDouble>("Length_rightarm",null); }
            set { setAttrVal<FDouble>("Length_rightarm", value); }
        }
		public int? Replace_film {
            get { return getAttrVal<int?>("Replace_film",null); }
            set { setAttrVal<int?>("Replace_film", value); }
        }
		public int? Replace_infusion_conector {
            get { return getAttrVal<int?>("Replace_infusion_conector",null); }
            set { setAttrVal<int?>("Replace_infusion_conector", value); }
        }
		public int? Wet_pack {
            get { return getAttrVal<int?>("Wet_pack",null); }
            set { setAttrVal<int?>("Wet_pack", value); }
        }
		public int? Ointmen {
            get { return getAttrVal<int?>("Ointmen",null); }
            set { setAttrVal<int?>("Ointmen", value); }
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
		public string Name_pipe_infusion {
            get { return getAttrVal<string>("Name_pipe_infusion",null); }
            set { setAttrVal<string>("Name_pipe_infusion", value); }
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
            return "ci_mr_nu_picc_rec";
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
            return "Id_piccrec";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.nu.newbabypicc.d.NewBabyPiccRecDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_piccrec", "Id_picc", "D_rec", "T_rec", "Redswollen", "Scleroma", "Bleeding", "Id_pipe_infusion", "Sd_pipe_infusion", "Catheter_insertion", "Catheter_exposed", "Length_leftarm", "Length_rightarm", "Replace_film", "Replace_infusion_conector", "Wet_pack", "Ointmen", "Other", "Id_sign", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Name_pipe_infusion", "Name_sign"};
        }
        
    }
}
