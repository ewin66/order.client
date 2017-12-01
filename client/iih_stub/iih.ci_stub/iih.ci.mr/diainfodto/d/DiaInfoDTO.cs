using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.mr.diainfodto.d
{
    /// <summary>
    /// DiaInfoDTO 的摘要说明。
    /// </summary>
    public class DiaInfoDTO : BaseDTO {

        public DiaInfoDTO() {
 
        }

        /// <summary>
        /// 诊断类别编码
        /// </summary>
		public string Code_dia_tp {
            get { return getAttrVal<string>("Code_dia_tp",null); }
            set { setAttrVal<string>("Code_dia_tp", value); }
        }

        /// <summary>
        /// 诊断类别名称
        /// </summary>
		public string Dia_tp {
            get { return getAttrVal<string>("Dia_tp",null); }
            set { setAttrVal<string>("Dia_tp", value); }
        }

        /// <summary>
        /// 诊断编码
        /// </summary>
		public string Code_dia {
            get { return getAttrVal<string>("Code_dia",null); }
            set { setAttrVal<string>("Code_dia", value); }
        }

        /// <summary>
        /// 诊断名称
        /// </summary>
		public string Dia {
            get { return getAttrVal<string>("Dia",null); }
            set { setAttrVal<string>("Dia", value); }
        }

        /// <summary>
        /// 诊断日期
        /// </summary>
		public DateTime? Dt_dia {
            get { return getAttrVal<FDate>("Dt_dia",null); }
            set { setAttrVal<FDate>("Dt_dia", value); }
        }

        /// <summary>
        /// 诊断描述
        /// </summary>
		public string Des {
            get { return getAttrVal<string>("Des",null); }
            set { setAttrVal<string>("Des", value); }
        }

        /// <summary>
        /// 治疗结果编码
        /// </summary>
		public string Code_trre {
            get { return getAttrVal<string>("Code_trre",null); }
            set { setAttrVal<string>("Code_trre", value); }
        }

        /// <summary>
        /// 治疗结果名称
        /// </summary>
		public string Trre {
            get { return getAttrVal<string>("Trre",null); }
            set { setAttrVal<string>("Trre", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Code_dia_tp", "Dia_tp", "Code_dia", "Dia", "Dt_dia", "Des", "Code_trre", "Trre"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.diainfodto.d.DiaInfoDTO";
        }
    }
}
