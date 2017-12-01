
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.cior.d
{
    /// <summary>
    /// OrdApSugViewItemDO 的摘要说明。
    /// </summary>
    public class OrdApSugViewItemDO : BaseDO {

        public OrdApSugViewItemDO() {
        }
		public string Id_apopobsindex {
            get { return getAttrVal<string>("Id_apopobsindex",null); }
            set { setAttrVal<string>("Id_apopobsindex", value); }
        }
		public string Id_apop {
            get { return getAttrVal<string>("Id_apop",null); }
            set { setAttrVal<string>("Id_apop", value); }
        }
		public string Id_srv {
            get { return getAttrVal<string>("Id_srv",null); }
            set { setAttrVal<string>("Id_srv", value); }
        }
		public string Name_srv {
            get { return getAttrVal<string>("Name_srv",null); }
            set { setAttrVal<string>("Name_srv", value); }
        }
		public string Id_unit {
            get { return getAttrVal<string>("Id_unit",null); }
            set { setAttrVal<string>("Id_unit", value); }
        }
		public string Val_rstrptla {
            get { return getAttrVal<string>("Val_rstrptla",null); }
            set { setAttrVal<string>("Val_rstrptla", value); }
        }
		public string Val_restrptlab {
            get { return getAttrVal<string>("Val_restrptlab",null); }
            set { setAttrVal<string>("Val_restrptlab", value); }
        }
		public string Name_unit {
            get { return getAttrVal<string>("Name_unit",null); }
            set { setAttrVal<string>("Name_unit", value); }
        }
		public string Sd_restrptlabtp {
            get { return getAttrVal<string>("Sd_restrptlabtp",null); }
            set { setAttrVal<string>("Sd_restrptlabtp", value); }
        }
		public string Id_restrptlabtp {
            get { return getAttrVal<string>("Id_restrptlabtp",null); }
            set { setAttrVal<string>("Id_restrptlabtp", value); }
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
            return "ci_ap_sug_viewitm";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_apopobsindex";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.cior.d.OrdApSugViewItemDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_apopobsindex", "Id_apop", "Id_srv", "Name_srv", "Id_unit", "Val_rstrptla", "Val_restrptlab", "Name_unit", "Sd_restrptlabtp", "Id_restrptlabtp"};
        }
        
    }
}
