using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.cior.d
{
    /// <summary>
    /// ReactExtOrsAndStopOrsDO 的摘要说明。
    /// </summary>
    public class ReactExtOrsAndStopOrsDO : BaseDTO {

        public ReactExtOrsAndStopOrsDO() {
 
        }

        /// <summary>
        /// 排斥扩展医嘱聚集数据
        /// </summary>
		public FArrayList Reactextdos {
            get { return getAttrVal<FArrayList>("Reactextdos",null); }
            set { setAttrVal<FArrayList>("Reactextdos", value); }
        }

        /// <summary>
        /// 关联要停止的医嘱
        /// </summary>
		public FArrayList Stopordos {
            get { return getAttrVal<FArrayList>("Stopordos",null); }
            set { setAttrVal<FArrayList>("Stopordos", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Reactextdos", "Stopordos"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.cior.d.ReactExtOrsAndStopOrsDO";
        }
    }
}
