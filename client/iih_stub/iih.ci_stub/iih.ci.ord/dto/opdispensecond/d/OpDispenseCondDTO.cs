using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.dto.opdispensecond.d
{
    /// <summary>
    /// OpDispenseCondDTO 的摘要说明。
    /// </summary>
    public class OpDispenseCondDTO : BaseDTO {

        public OpDispenseCondDTO() {
 
        }

        /// <summary>
        /// 患者标识
        /// </summary>
		public string Id_pat {
            get { return getAttrVal<string>("Id_pat",null); }
            set { setAttrVal<string>("Id_pat", value); }
        }

        /// <summary>
        /// 诊疗卡号
        /// </summary>
		public string Card_code {
            get { return getAttrVal<string>("Card_code",null); }
            set { setAttrVal<string>("Card_code", value); }
        }

        /// <summary>
        /// 患者姓名
        /// </summary>
		public string Pat_name {
            get { return getAttrVal<string>("Pat_name",null); }
            set { setAttrVal<string>("Pat_name", value); }
        }

        /// <summary>
        /// 拼音码
        /// </summary>
		public string Pat_pycode {
            get { return getAttrVal<string>("Pat_pycode",null); }
            set { setAttrVal<string>("Pat_pycode", value); }
        }

        /// <summary>
        /// 付款日期开始
        /// </summary>
		public DateTime? Dt_charge_start {
            get { return getAttrVal<FDateTime>("Dt_charge_start",null); }
            set { setAttrVal<FDateTime>("Dt_charge_start", value); }
        }

        /// <summary>
        /// 付款日期结束
        /// </summary>
		public DateTime? Dt_charge_end {
            get { return getAttrVal<FDateTime>("Dt_charge_end",null); }
            set { setAttrVal<FDateTime>("Dt_charge_end", value); }
        }

        /// <summary>
        /// 草药标识
        /// </summary>
		public bool? Fg_herb {
            get { return getAttrVal<FBoolean>("Fg_herb",null); }
            set { setAttrVal<FBoolean>("Fg_herb", value); }
        }

        /// <summary>
        /// 窗口号
        /// </summary>
		public int? No_window {
            get { return getAttrVal<int?>("No_window",null); }
            set { setAttrVal<int?>("No_window", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_pat", "Card_code", "Pat_name", "Pat_pycode", "Dt_charge_start", "Dt_charge_end", "Fg_herb", "No_window"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.dto.opdispensecond.d.OpDispenseCondDTO";
        }
    }
}
