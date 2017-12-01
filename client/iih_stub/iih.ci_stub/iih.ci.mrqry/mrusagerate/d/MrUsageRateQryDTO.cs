using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.mrqry.mrusagerate.d
{
    /// <summary>
    /// MrUsageRateQryDTO 的摘要说明。
    /// </summary>
    public class MrUsageRateQryDTO : BaseDTO {

        public MrUsageRateQryDTO() {
 
        }

        /// <summary>
        /// 统计范围
        /// </summary>
		public string Range_qry {
            get { return getAttrVal<string>("Range_qry",null); }
            set { setAttrVal<string>("Range_qry", value); }
        }

        /// <summary>
        /// 就诊类型
        /// </summary>
		public string Entp {
            get { return getAttrVal<string>("Entp",null); }
            set { setAttrVal<string>("Entp", value); }
        }

        /// <summary>
        /// 科室
        /// </summary>
		public string Dep_ent {
            get { return getAttrVal<string>("Dep_ent",null); }
            set { setAttrVal<string>("Dep_ent", value); }
        }

        /// <summary>
        /// 医生
        /// </summary>
		public string Doctor_ent {
            get { return getAttrVal<string>("Doctor_ent",null); }
            set { setAttrVal<string>("Doctor_ent", value); }
        }

        /// <summary>
        /// 开始时间
        /// </summary>
		public DateTime? Dt_start {
            get { return getAttrVal<FDateTime>("Dt_start",null); }
            set { setAttrVal<FDateTime>("Dt_start", value); }
        }

        /// <summary>
        /// 结束时间
        /// </summary>
		public DateTime? Dt_end {
            get { return getAttrVal<FDateTime>("Dt_end",null); }
            set { setAttrVal<FDateTime>("Dt_end", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Range_qry", "Entp", "Dep_ent", "Doctor_ent", "Dt_start", "Dt_end"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mrqry.mrusagerate.d.MrUsageRateQryDTO";
        }
    }
}
