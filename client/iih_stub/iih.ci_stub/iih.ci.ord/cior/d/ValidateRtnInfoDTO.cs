using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.cior.d
{
    /// <summary>
    /// ValidateRtnInfoDTO 的摘要说明。
    /// </summary>
    public class ValidateRtnInfoDTO : BaseDTO {

        public ValidateRtnInfoDTO() {
 
        }

        /// <summary>
        /// 所在阶段序号
        /// </summary>
		public int? Phaseno {
            get { return getAttrVal<int?>("Phaseno",null); }
            set { setAttrVal<int?>("Phaseno", value); }
        }

        /// <summary>
        /// 场景数据
        /// </summary>
		public FMap2 Scenedatum {
            get { return getAttrVal<FMap2>("Scenedatum",null); }
            set { setAttrVal<FMap2>("Scenedatum", value); }
        }

        /// <summary>
        /// 返回值
        /// </summary>
		public FMap2 Rtnvalue {
            get { return getAttrVal<FMap2>("Rtnvalue",null); }
            set { setAttrVal<FMap2>("Rtnvalue", value); }
        }

        /// <summary>
        /// 返回值为场景值标识
        /// </summary>
		public bool? Fg_rtnscene {
            get { return getAttrVal<FBoolean>("Fg_rtnscene",null); }
            set { setAttrVal<FBoolean>("Fg_rtnscene", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Phaseno", "Scenedatum", "Rtnvalue", "Fg_rtnscene"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.cior.d.ValidateRtnInfoDTO";
        }
    }
}
