using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.dto.vitalsignsdto.d
{
    /// <summary>
    /// VitalSignsDto 的摘要说明。
    /// </summary>
    public class VitalSignsDto : BaseDTO {

        public VitalSignsDto() {
 
        }

        /// <summary>
        /// 主键
        /// </summary>
		public string Id {
            get { return getAttrVal<string>("Id",null); }
            set { setAttrVal<string>("Id", value); }
        }

        /// <summary>
        /// 体温
        /// </summary>
		public string Temperature {
            get { return getAttrVal<string>("Temperature",null); }
            set { setAttrVal<string>("Temperature", value); }
        }

        /// <summary>
        /// 呼吸
        /// </summary>
		public string Breath {
            get { return getAttrVal<string>("Breath",null); }
            set { setAttrVal<string>("Breath", value); }
        }

        /// <summary>
        /// 脉搏
        /// </summary>
		public string Pulse {
            get { return getAttrVal<string>("Pulse",null); }
            set { setAttrVal<string>("Pulse", value); }
        }

        /// <summary>
        /// 血压低
        /// </summary>
		public string Bpmin {
            get { return getAttrVal<string>("Bpmin",null); }
            set { setAttrVal<string>("Bpmin", value); }
        }

        /// <summary>
        /// 血压高
        /// </summary>
		public string Bpmax {
            get { return getAttrVal<string>("Bpmax",null); }
            set { setAttrVal<string>("Bpmax", value); }
        }

        /// <summary>
        /// 心率
        /// </summary>
		public string Heart_rate {
            get { return getAttrVal<string>("Heart_rate",null); }
            set { setAttrVal<string>("Heart_rate", value); }
        }

        /// <summary>
        /// 体重
        /// </summary>
		public string Weight {
            get { return getAttrVal<string>("Weight",null); }
            set { setAttrVal<string>("Weight", value); }
        }

        /// <summary>
        /// 补充信息
        /// </summary>
		public FMap2 Infomap {
            get { return getAttrVal<FMap2>("Infomap",null); }
            set { setAttrVal<FMap2>("Infomap", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id", "Temperature", "Breath", "Pulse", "Bpmin", "Bpmax", "Heart_rate", "Weight", "Infomap"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.dto.vitalsignsdto.d.VitalSignsDto";
        }
    }
}
