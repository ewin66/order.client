using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.dto.d
{
    /// <summary>
    /// SkinTestRstDTO 的摘要说明。
    /// </summary>
    public class SkinTestRstDTO : BaseDTO {

        public SkinTestRstDTO() {
 
        }

        /// <summary>
        /// 易过敏类药物处理方式
        /// </summary>
		public int? Allergicpharmhandlemode {
            get { return getAttrVal<int?>("Allergicpharmhandlemode",null); }
            set { setAttrVal<int?>("Allergicpharmhandlemode", value); }
        }

        /// <summary>
        /// 皮试医嘱
        /// </summary>
		public string Id_skinor {
            get { return getAttrVal<string>("Id_skinor",null); }
            set { setAttrVal<string>("Id_skinor", value); }
        }
        /// <summary>
        /// 过敏日期
        /// </summary>
        public FDateTime Dt_act
        {
            get { return getAttrVal<FDateTime>("Dt_act", null); }
            set { setAttrVal<FDateTime>("Dt_act", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[] { "Allergicpharmhandlemode", "Id_skinor", "Dt_act" };
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.dto.d.SkinTestRstDTO";
        }
    }
}
