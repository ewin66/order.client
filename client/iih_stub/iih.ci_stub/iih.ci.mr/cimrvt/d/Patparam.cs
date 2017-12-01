using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.mr.cimrpatsigns.d
{
    /// <summary>
    /// Patparam 的摘要说明。
    /// </summary>
    public class Patparam : BaseDTO {

        public Patparam() {
 
        }

        /// <summary>
        /// 就诊类型
        /// </summary>
		public string Code_entp {
            get { return getAttrVal<string>("Code_entp",null); }
            set { setAttrVal<string>("Code_entp", value); }
        }

        /// <summary>
        /// 就诊状态
        /// </summary>
		public string Sd_status {
            get { return getAttrVal<string>("Sd_status",null); }
            set { setAttrVal<string>("Sd_status", value); }
        }

        /// <summary>
        /// 当前科室
        /// </summary>
		public string Id_dep_nur {
            get { return getAttrVal<string>("Id_dep_nur",null); }
            set { setAttrVal<string>("Id_dep_nur", value); }
        }

        /// <summary>
        /// 过滤类型
        /// </summary>
		public string Wheretype {
            get { return getAttrVal<string>("Wheretype",null); }
            set { setAttrVal<string>("Wheretype", value); }
        }

        /// <summary>
        /// 过滤值
        /// </summary>
		public string Value {
            get { return getAttrVal<string>("Value",null); }
            set { setAttrVal<string>("Value", value); }
        }

        /// <summary>
        /// 测量日期
        /// </summary>
		public DateTime? Measuredate {
            get { return getAttrVal<FDate>("Measuredate",null); }
            set { setAttrVal<FDate>("Measuredate", value); }
        }

        /// <summary>
        /// 模板ID
        /// </summary>
		public string Id_mrtplvt {
            get { return getAttrVal<string>("Id_mrtplvt",null); }
            set { setAttrVal<string>("Id_mrtplvt", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Code_entp", "Sd_status", "Id_dep_nur", "Wheretype", "Value", "Measuredate", "Id_mrtplvt"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.cimrpatsigns.d.Patparam";
        }
    }
}
