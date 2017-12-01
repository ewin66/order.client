
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.rcm.contagion.d
{
    /// <summary>
    /// SyphilisDO 的摘要说明。
    /// </summary>
    public class SyphilisDO : BaseDO {

		public const string TABLE_NAME = "CI_MR_CONTAGION_CARD_SS";
		public const string TABLE_ALIAS_NAME = "a3";

        public SyphilisDO() {
        }
		public string Id_contagion_ss {
            get { return getAttrVal<string>("Id_contagion_ss",null); }
            set { setAttrVal<string>("Id_contagion_ss", value); }
        }
		public string Id_contagion {
            get { return getAttrVal<string>("Id_contagion",null); }
            set { setAttrVal<string>("Id_contagion", value); }
        }
		public string Id_form {
            get { return getAttrVal<string>("Id_form",null); }
            set { setAttrVal<string>("Id_form", value); }
        }
		public string Syphilis_result {
            get { return getAttrVal<string>("Syphilis_result",null); }
            set { setAttrVal<string>("Syphilis_result", value); }
        }
		public string Clinical_manifestation {
            get { return getAttrVal<string>("Clinical_manifestation",null); }
            set { setAttrVal<string>("Clinical_manifestation", value); }
        }
		public string Id_dep_phyadm {
            get { return getAttrVal<string>("Id_dep_phyadm",null); }
            set { setAttrVal<string>("Id_dep_phyadm", value); }
        }
		public string Code_dep_phyadm {
            get { return getAttrVal<string>("Code_dep_phyadm",null); }
            set { setAttrVal<string>("Code_dep_phyadm", value); }
        }
		public string Name_dep_phyadm {
            get { return getAttrVal<string>("Name_dep_phyadm",null); }
            set { setAttrVal<string>("Name_dep_phyadm", value); }
        }
		public string Dep_phyadm_code {
            get { return getAttrVal<string>("Dep_phyadm_code",null); }
            set { setAttrVal<string>("Dep_phyadm_code", value); }
        }
		public string Dep_phyadm_name {
            get { return getAttrVal<string>("Dep_phyadm_name",null); }
            set { setAttrVal<string>("Dep_phyadm_name", value); }
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
            return "CI_MR_CONTAGION_CARD_SS";
        }
        
        /// <summary>
        /// 返回表别名
        /// </summary>
        /// <returns></returns>
        public override string getAliasTableName()
        {
            return "a3";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_contagion_ss";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.rcm.contagion.d.SyphilisDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_contagion_ss", "Id_contagion", "Id_form", "Syphilis_result", "Clinical_manifestation", "Id_dep_phyadm", "Code_dep_phyadm", "Name_dep_phyadm", "Dep_phyadm_code", "Dep_phyadm_name"};
        }
        
    }
}
