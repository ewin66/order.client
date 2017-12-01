using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.mrqry.mrusagerate.d
{
    /// <summary>
    /// MrUsageRateDTO 的摘要说明。
    /// </summary>
    public class MrUsageRateDTO : BaseDTO {

        public MrUsageRateDTO() {
 
        }

        /// <summary>
        /// 就诊类型
        /// </summary>
		public string Entp {
            get { return getAttrVal<string>("Entp",null); }
            set { setAttrVal<string>("Entp", value); }
        }

        /// <summary>
        /// 部门
        /// </summary>
		public string Dep_en {
            get { return getAttrVal<string>("Dep_en",null); }
            set { setAttrVal<string>("Dep_en", value); }
        }

        /// <summary>
        /// 员工姓名
        /// </summary>
		public string Doctor_en {
            get { return getAttrVal<string>("Doctor_en",null); }
            set { setAttrVal<string>("Doctor_en", value); }
        }

        /// <summary>
        /// 病历人数
        /// </summary>
		public int? Mrnum {
            get { return getAttrVal<int?>("Mrnum",null); }
            set { setAttrVal<int?>("Mrnum", value); }
        }

        /// <summary>
        /// 总就诊数
        /// </summary>
		public int? Ennum {
            get { return getAttrVal<int?>("Ennum",null); }
            set { setAttrVal<int?>("Ennum", value); }
        }

        /// <summary>
        /// 使用率
        /// </summary>
		public FDouble Usagerate {
            get { return getAttrVal<FDouble>("Usagerate",null); }
            set { setAttrVal<FDouble>("Usagerate", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Entp", "Dep_en", "Doctor_en", "Mrnum", "Ennum", "Usagerate"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mrqry.mrusagerate.d.MrUsageRateDTO";
        }
    }
}
