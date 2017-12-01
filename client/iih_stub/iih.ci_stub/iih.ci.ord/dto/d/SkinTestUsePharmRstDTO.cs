using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.dto.d
{
    /// <summary>
    /// SkinTestUsePharmRstDTO 的摘要说明。
    /// </summary>
    public class SkinTestUsePharmRstDTO : BaseDTO {

        public SkinTestUsePharmRstDTO() {
 
        }

        /// <summary>
        /// N天有效返回结果枚举值
        /// </summary>
		public int? Ndaysvalidrst {
            get { return getAttrVal<int?>("Ndaysvalidrst",null); }
            set { setAttrVal<int?>("Ndaysvalidrst", value); }
        }

        /// <summary>
        /// 皮试医嘱主键标识
        /// </summary>
		public string Id_orskin {
            get { return getAttrVal<string>("Id_orskin",null); }
            set { setAttrVal<string>("Id_orskin", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Ndaysvalidrst", "Id_orskin"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.dto.d.SkinTestUsePharmRstDTO";
        }
    }
}
