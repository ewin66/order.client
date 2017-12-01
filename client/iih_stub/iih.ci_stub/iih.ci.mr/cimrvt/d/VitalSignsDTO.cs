using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.mr.cimrpatsigns.d
{
    /// <summary>
    /// VitalSignsDTO 的摘要说明。
    /// </summary>
    public class VitalSignsDTO : BaseDTO {

        public VitalSignsDTO() {
 
        }

        /// <summary>
        /// 就诊id
        /// </summary>
		public string Id_ent {
            get { return getAttrVal<string>("Id_ent",null); }
            set { setAttrVal<string>("Id_ent", value); }
        }

        /// <summary>
        /// 测量时间
        /// </summary>
		public DateTime? Dt_vt {
            get { return getAttrVal<FDateTime>("Dt_vt",null); }
            set { setAttrVal<FDateTime>("Dt_vt", value); }
        }

        /// <summary>
        /// 体温
        /// </summary>
		public string Temperature {
            get { return getAttrVal<string>("Temperature",null); }
            set { setAttrVal<string>("Temperature", value); }
        }

        /// <summary>
        /// 脉搏
        /// </summary>
		public string Pulse {
            get { return getAttrVal<string>("Pulse",null); }
            set { setAttrVal<string>("Pulse", value); }
        }

        /// <summary>
        /// 呼吸
        /// </summary>
		public string Breathing {
            get { return getAttrVal<string>("Breathing",null); }
            set { setAttrVal<string>("Breathing", value); }
        }

        /// <summary>
        /// 收缩压
        /// </summary>
		public string Systolicbloodpressure {
            get { return getAttrVal<string>("Systolicbloodpressure",null); }
            set { setAttrVal<string>("Systolicbloodpressure", value); }
        }

        /// <summary>
        /// 舒张压
        /// </summary>
		public string Diastolicbloodpressure {
            get { return getAttrVal<string>("Diastolicbloodpressure",null); }
            set { setAttrVal<string>("Diastolicbloodpressure", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_ent", "Dt_vt", "Temperature", "Pulse", "Breathing", "Systolicbloodpressure", "Diastolicbloodpressure"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.cimrpatsigns.d.VitalSignsDTO";
        }
    }
}
