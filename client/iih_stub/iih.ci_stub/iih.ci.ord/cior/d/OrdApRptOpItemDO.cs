
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.cior.d
{
    /// <summary>
    /// OrdApRptOpItemDO 的摘要说明。
    /// </summary>
    public class OrdApRptOpItemDO : BaseDO {

        public OrdApRptOpItemDO() {
        }
		public string Id_rptsugitm {
            get { return getAttrVal<string>("Id_rptsugitm",null); }
            set { setAttrVal<string>("Id_rptsugitm", value); }
        }
		public string Id_rptsug {
            get { return getAttrVal<string>("Id_rptsug",null); }
            set { setAttrVal<string>("Id_rptsug", value); }
        }
		public string Id_srvsug {
            get { return getAttrVal<string>("Id_srvsug",null); }
            set { setAttrVal<string>("Id_srvsug", value); }
        }
		public string Name_srv_sug {
            get { return getAttrVal<string>("Name_srv_sug",null); }
            set { setAttrVal<string>("Name_srv_sug", value); }
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
            return "ci_rpt_sug_itm";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_rptsugitm";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.cior.d.OrdApRptOpItemDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_rptsugitm", "Id_rptsug", "Id_srvsug", "Name_srv_sug"};
        }
        
    }
}
