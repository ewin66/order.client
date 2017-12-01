
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.cior.d
{
    /// <summary>
    /// OrdApBtViewItemDO 的摘要说明。
    /// </summary>
    public class OrdApBtViewItemDO : BaseDO {

        public OrdApBtViewItemDO() {
        }
		public string Id_apbtobsindex {
            get { return getAttrVal<string>("Id_apbtobsindex",null); }
            set { setAttrVal<string>("Id_apbtobsindex", value); }
        }
		public string Id_apbt {
            get { return getAttrVal<string>("Id_apbt",null); }
            set { setAttrVal<string>("Id_apbt", value); }
        }
		public string Id_srv {
            get { return getAttrVal<string>("Id_srv",null); }
            set { setAttrVal<string>("Id_srv", value); }
        }
		public string Name_srv {
            get { return getAttrVal<string>("Name_srv",null); }
            set { setAttrVal<string>("Name_srv", value); }
        }
		public string Val_rstrptla {
            get { return getAttrVal<string>("Val_rstrptla",null); }
            set { setAttrVal<string>("Val_rstrptla", value); }
        }
		public string Id_unit {
            get { return getAttrVal<string>("Id_unit",null); }
            set { setAttrVal<string>("Id_unit", value); }
        }
		public string Name_unit {
            get { return getAttrVal<string>("Name_unit",null); }
            set { setAttrVal<string>("Name_unit", value); }
        }
		public string Val_restrptlab {
            get { return getAttrVal<string>("Val_restrptlab",null); }
            set { setAttrVal<string>("Val_restrptlab", value); }
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
            return "ci_ap_bt_viewitm";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_apbtobsindex";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.cior.d.OrdApBtViewItemDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_apbtobsindex", "Id_apbt", "Id_srv", "Name_srv", "Val_rstrptla", "Id_unit", "Name_unit", "Val_restrptlab", "Sd_restrptlabtp", "Id_restrptlabtp"};
        }
        
    }
}
