using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.cior.d
{
    /// <summary>
    /// CiOrLastMpDTO 的摘要说明。
    /// </summary>
    public class CiOrLastMpDTO : BaseDTO {

        public CiOrLastMpDTO() {
 
        }

        /// <summary>
        /// 医嘱
        /// </summary>
		public string Id_or {
            get { return getAttrVal<string>("Id_or",null); }
            set { setAttrVal<string>("Id_or", value); }
        }

        /// <summary>
        /// 计划执行时间
        /// </summary>
		public DateTime? Dt_mp_plan {
            get { return getAttrVal<FDateTime>("Dt_mp_plan",null); }
            set { setAttrVal<FDateTime>("Dt_mp_plan", value); }
        }

        /// <summary>
        /// 是否最后一顿
        /// </summary>
		public int? Eu_last {
            get { return getAttrVal<int?>("Eu_last",null); }
            set { setAttrVal<int?>("Eu_last", value); }
        }

        /// <summary>
        /// 就诊类型
        /// </summary>
		public string Code_entp {
            get { return getAttrVal<string>("Code_entp",null); }
            set { setAttrVal<string>("Code_entp", value); }
        }

        /// <summary>
        /// 长期标识
        /// </summary>
		public bool? Fg_long {
            get { return getAttrVal<FBoolean>("Fg_long",null); }
            set { setAttrVal<FBoolean>("Fg_long", value); }
        }

        /// <summary>
        /// 出院带药标识
        /// </summary>
		public bool? Fg_pres_outp {
            get { return getAttrVal<FBoolean>("Fg_pres_outp",null); }
            set { setAttrVal<FBoolean>("Fg_pres_outp", value); }
        }

        /// <summary>
        /// 医嘱类型
        /// </summary>
		public string Sd_srvtp {
            get { return getAttrVal<string>("Sd_srvtp",null); }
            set { setAttrVal<string>("Sd_srvtp", value); }
        }

        /// <summary>
        /// 频次
        /// </summary>
		public string Id_freq {
            get { return getAttrVal<string>("Id_freq",null); }
            set { setAttrVal<string>("Id_freq", value); }
        }

        /// <summary>
        /// 频次周期类型
        /// </summary>
		public string Sd_frequnit {
            get { return getAttrVal<string>("Sd_frequnit",null); }
            set { setAttrVal<string>("Sd_frequnit", value); }
        }

        /// <summary>
        /// 频次周期数
        /// </summary>
		public int? Frequnitct {
            get { return getAttrVal<int?>("Frequnitct",null); }
            set { setAttrVal<int?>("Frequnitct", value); }
        }

        /// <summary>
        /// 频次周期下次数
        /// </summary>
		public int? Freqct {
            get { return getAttrVal<int?>("Freqct",null); }
            set { setAttrVal<int?>("Freqct", value); }
        }

        /// <summary>
        /// 生效时间
        /// </summary>
		public DateTime? Dt_effe {
            get { return getAttrVal<FDateTime>("Dt_effe",null); }
            set { setAttrVal<FDateTime>("Dt_effe", value); }
        }

        /// <summary>
        /// 失效时间
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
            return new string[]{ "Id_or", "Dt_mp_plan", "Eu_last", "Code_entp", "Fg_long", "Fg_pres_outp", "Sd_srvtp", "Id_freq", "Sd_frequnit", "Frequnitct", "Freqct", "Dt_effe", "Dt_end"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.cior.d.CiOrLastMpDTO";
        }
    }
}
