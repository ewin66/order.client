using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.dto.d
{
    /// <summary>
    /// ExecuteLoopDTO 的摘要说明。
    /// </summary>
    public class ExecuteLoopDTO : BaseDTO {

        public ExecuteLoopDTO() {
 
        }

        /// <summary>
        /// 医嘱id
        /// </summary>
		public string Id_or {
            get { return getAttrVal<string>("Id_or",null); }
            set { setAttrVal<string>("Id_or", value); }
        }

        /// <summary>
        /// 执行步骤
        /// </summary>
		public FArrayList Loops {
            get { return getAttrVal<FArrayList>("Loops",null); }
            set { setAttrVal<FArrayList>("Loops", value); }
        }

        /// <summary>
        /// 服务项目
        /// </summary>
		public FArrayList Srvs {
            get { return getAttrVal<FArrayList>("Srvs",null); }
            set { setAttrVal<FArrayList>("Srvs", value); }
        }

        /// <summary>
        /// 计划执行时间
        /// </summary>
		public DateTime? Dt_mp_plan {
            get { return getAttrVal<FDateTime>("Dt_mp_plan",null); }
            set { setAttrVal<FDateTime>("Dt_mp_plan", value); }
        }

        /// <summary>
        /// 服务
        /// </summary>
		public string Id_srv {
            get { return getAttrVal<string>("Id_srv",null); }
            set { setAttrVal<string>("Id_srv", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_or", "Loops", "Srvs", "Dt_mp_plan", "Id_srv"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.dto.d.ExecuteLoopDTO";
        }
    }
}
