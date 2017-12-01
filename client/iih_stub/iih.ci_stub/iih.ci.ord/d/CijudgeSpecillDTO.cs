using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.d
{
    /// <summary>
    /// CijudgeSpecillDTO 的摘要说明。
    /// </summary>
    public class CijudgeSpecillDTO : BaseDTO {

        public CijudgeSpecillDTO() {
 
        }

        /// <summary>
        /// 药品
        /// </summary>
		public string Id_mm {
            get { return getAttrVal<string>("Id_mm",null); }
            set { setAttrVal<string>("Id_mm", value); }
        }

        /// <summary>
        /// 特殊病药
        /// </summary>
		public bool? Fg_mmspecill {
            get { return getAttrVal<FBoolean>("Fg_mmspecill",null); }
            set { setAttrVal<FBoolean>("Fg_mmspecill", value); }
        }

        /// <summary>
        /// 诊断集合
        /// </summary>
		public FMap2 Diagmap {
            get { return getAttrVal<FMap2>("Diagmap",null); }
            set { setAttrVal<FMap2>("Diagmap", value); }
        }

        /// <summary>
        /// 扩展字段
        /// </summary>
		public string Str {
            get { return getAttrVal<string>("Str",null); }
            set { setAttrVal<string>("Str", value); }
        }

        /// <summary>
        /// 扩展字段2
        /// </summary>
		public string Str2 {
            get { return getAttrVal<string>("Str2",null); }
            set { setAttrVal<string>("Str2", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_mm", "Fg_mmspecill", "Diagmap", "Str", "Str2"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.d.CijudgeSpecillDTO";
        }
    }
}
