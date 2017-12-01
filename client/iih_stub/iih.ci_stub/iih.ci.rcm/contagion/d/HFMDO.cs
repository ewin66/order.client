
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.rcm.contagion.d
{
    /// <summary>
    /// HFMDO 的摘要说明。
    /// </summary>
    public class HFMDO : BaseDO {

		public const string TABLE_NAME = "CI_MR_CONTAGION_CARD_HFM";
		public const string TABLE_ALIAS_NAME = "a4";

        public HFMDO() {
        }
		public string Id_contagion_hfm {
            get { return getAttrVal<string>("Id_contagion_hfm",null); }
            set { setAttrVal<string>("Id_contagion_hfm", value); }
        }
		public string Id_contagion {
            get { return getAttrVal<string>("Id_contagion",null); }
            set { setAttrVal<string>("Id_contagion", value); }
        }
		public string Id_form {
            get { return getAttrVal<string>("Id_form",null); }
            set { setAttrVal<string>("Id_form", value); }
        }
		public string Id_hfm_result {
            get { return getAttrVal<string>("Id_hfm_result",null); }
            set { setAttrVal<string>("Id_hfm_result", value); }
        }
		public string Code_hfm_result {
            get { return getAttrVal<string>("Code_hfm_result",null); }
            set { setAttrVal<string>("Code_hfm_result", value); }
        }
		public string Name_hfm_result {
            get { return getAttrVal<string>("Name_hfm_result",null); }
            set { setAttrVal<string>("Name_hfm_result", value); }
        }
		public string Is_zhongzheng {
            get { return getAttrVal<string>("Is_zhongzheng",null); }
            set { setAttrVal<string>("Is_zhongzheng", value); }
        }
		public string Code_zhongzheng {
            get { return getAttrVal<string>("Code_zhongzheng",null); }
            set { setAttrVal<string>("Code_zhongzheng", value); }
        }
		public string Name_zhongzheng {
            get { return getAttrVal<string>("Name_zhongzheng",null); }
            set { setAttrVal<string>("Name_zhongzheng", value); }
        }
		public string Hfm_result_code {
            get { return getAttrVal<string>("Hfm_result_code",null); }
            set { setAttrVal<string>("Hfm_result_code", value); }
        }
		public string Hfm_result_name {
            get { return getAttrVal<string>("Hfm_result_name",null); }
            set { setAttrVal<string>("Hfm_result_name", value); }
        }
		public string Zhongzheng_code {
            get { return getAttrVal<string>("Zhongzheng_code",null); }
            set { setAttrVal<string>("Zhongzheng_code", value); }
        }
		public string Zhongzheng_name {
            get { return getAttrVal<string>("Zhongzheng_name",null); }
            set { setAttrVal<string>("Zhongzheng_name", value); }
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
            return "CI_MR_CONTAGION_CARD_HFM";
        }
        
        /// <summary>
        /// 返回表别名
        /// </summary>
        /// <returns></returns>
        public override string getAliasTableName()
        {
            return "a4";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_contagion_hfm";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.rcm.contagion.d.HFMDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_contagion_hfm", "Id_contagion", "Id_form", "Id_hfm_result", "Code_hfm_result", "Name_hfm_result", "Is_zhongzheng", "Code_zhongzheng", "Name_zhongzheng", "Hfm_result_code", "Hfm_result_name", "Zhongzheng_code", "Zhongzheng_name"};
        }
        
    }
}
