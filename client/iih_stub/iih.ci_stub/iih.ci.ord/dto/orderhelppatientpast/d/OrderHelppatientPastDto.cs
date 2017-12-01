using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.dto.orderhelppatientpast.d
{
    /// <summary>
    /// OrderHelppatientPastDto 的摘要说明。
    /// </summary>
    public class OrderHelppatientPastDto : BaseDTO {

        public OrderHelppatientPastDto() {
 
        }

        /// <summary>
        /// 主键
        /// </summary>
		public string Id {
            get { return getAttrVal<string>("Id",null); }
            set { setAttrVal<string>("Id", value); }
        }

        /// <summary>
        /// 患者id
        /// </summary>
		public string Id_pat {
            get { return getAttrVal<string>("Id_pat",null); }
            set { setAttrVal<string>("Id_pat", value); }
        }

        /// <summary>
        /// 门急诊开始时间
        /// </summary>
		public string Op_start_dt {
            get { return getAttrVal<string>("Op_start_dt",null); }
            set { setAttrVal<string>("Op_start_dt", value); }
        }

        /// <summary>
        /// 门急诊结束时间
        /// </summary>
		public string Op_end_dt {
            get { return getAttrVal<string>("Op_end_dt",null); }
            set { setAttrVal<string>("Op_end_dt", value); }
        }

        /// <summary>
        /// 住院开始时间
        /// </summary>
		public string Ip_start_dt {
            get { return getAttrVal<string>("Ip_start_dt",null); }
            set { setAttrVal<string>("Ip_start_dt", value); }
        }

        /// <summary>
        /// 住院结束时间
        /// </summary>
		public string Ip_end_dt {
            get { return getAttrVal<string>("Ip_end_dt",null); }
            set { setAttrVal<string>("Ip_end_dt", value); }
        }

        /// <summary>
        /// 显示的患者参数
        /// </summary>
		public string Display_parameters {
            get { return getAttrVal<string>("Display_parameters",null); }
            set { setAttrVal<string>("Display_parameters", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id", "Id_pat", "Op_start_dt", "Op_end_dt", "Ip_start_dt", "Ip_end_dt", "Display_parameters"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.dto.orderhelppatientpast.d.OrderHelppatientPastDto";
        }
    }
}
