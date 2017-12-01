using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.dto.orderpandectemrdto.d
{
    /// <summary>
    /// OrderPandectEmrDTO 的摘要说明。
    /// </summary>
    public class OrderPandectEmrDTO : BaseDTO {

        public OrderPandectEmrDTO() {
 
        }

        /// <summary>
        /// 主键
        /// </summary>
		public string Orderpandectemr_id {
            get { return getAttrVal<string>("Orderpandectemr_id",null); }
            set { setAttrVal<string>("Orderpandectemr_id", value); }
        }

        /// <summary>
        /// 主诉
        /// </summary>
		public string Mainsuit_name {
            get { return getAttrVal<string>("Mainsuit_name",null); }
            set { setAttrVal<string>("Mainsuit_name", value); }
        }

        /// <summary>
        /// 主诉的值
        /// </summary>
		public string Mainsuit_value {
            get { return getAttrVal<string>("Mainsuit_value",null); }
            set { setAttrVal<string>("Mainsuit_value", value); }
        }

        /// <summary>
        /// 现病史
        /// </summary>
		public string Newillnes_name {
            get { return getAttrVal<string>("Newillnes_name",null); }
            set { setAttrVal<string>("Newillnes_name", value); }
        }

        /// <summary>
        /// 现病史值
        /// </summary>
		public string Newillnes_value {
            get { return getAttrVal<string>("Newillnes_value",null); }
            set { setAttrVal<string>("Newillnes_value", value); }
        }

        /// <summary>
        /// 既往史
        /// </summary>
		public string Historyillnes_name {
            get { return getAttrVal<string>("Historyillnes_name",null); }
            set { setAttrVal<string>("Historyillnes_name", value); }
        }

        /// <summary>
        /// 既往史值
        /// </summary>
		public string Historyillnes_value {
            get { return getAttrVal<string>("Historyillnes_value",null); }
            set { setAttrVal<string>("Historyillnes_value", value); }
        }

        /// <summary>
        /// 体格检查
        /// </summary>
		public string Physical_name {
            get { return getAttrVal<string>("Physical_name",null); }
            set { setAttrVal<string>("Physical_name", value); }
        }

        /// <summary>
        /// 体格检查值
        /// </summary>
		public string Physical_value {
            get { return getAttrVal<string>("Physical_value",null); }
            set { setAttrVal<string>("Physical_value", value); }
        }

        /// <summary>
        /// 一般检查
        /// </summary>
		public string Commonly_name {
            get { return getAttrVal<string>("Commonly_name",null); }
            set { setAttrVal<string>("Commonly_name", value); }
        }

        /// <summary>
        /// 一般检查值
        /// </summary>
		public string Commonly_value {
            get { return getAttrVal<string>("Commonly_value",null); }
            set { setAttrVal<string>("Commonly_value", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Orderpandectemr_id", "Mainsuit_name", "Mainsuit_value", "Newillnes_name", "Newillnes_value", "Historyillnes_name", "Historyillnes_value", "Physical_name", "Physical_value", "Commonly_name", "Commonly_value"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.dto.orderpandectemrdto.d.OrderPandectEmrDTO";
        }
    }
}
