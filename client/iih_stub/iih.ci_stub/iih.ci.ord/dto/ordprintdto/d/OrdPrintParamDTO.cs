using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.dto.ordprintdto.d
{
    /// <summary>
    /// OrdPrintParamDTO 的摘要说明。
    /// </summary>
    public class OrdPrintParamDTO : BaseDTO {

        public OrdPrintParamDTO() {
 
        }

        /// <summary>
        /// 长临标识
        /// </summary>
		public bool? Fg_long {
            get { return getAttrVal<FBoolean>("Fg_long",null); }
            set { setAttrVal<FBoolean>("Fg_long", value); }
        }

        /// <summary>
        /// 患者Id
        /// </summary>
		public string Id_pat {
            get { return getAttrVal<string>("Id_pat",null); }
            set { setAttrVal<string>("Id_pat", value); }
        }

        /// <summary>
        /// 就诊Id
        /// </summary>
		public string Id_en {
            get { return getAttrVal<string>("Id_en",null); }
            set { setAttrVal<string>("Id_en", value); }
        }

        /// <summary>
        /// 打印模式
        /// </summary>
		public string Print_mode {
            get { return getAttrVal<string>("Print_mode",null); }
            set { setAttrVal<string>("Print_mode", value); }
        }

        /// <summary>
        /// 页号
        /// </summary>
		public int? Page_num {
            get { return getAttrVal<int?>("Page_num",null); }
            set { setAttrVal<int?>("Page_num", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Fg_long", "Id_pat", "Id_en", "Print_mode", "Page_num"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.dto.ordprintdto.d.OrdPrintParamDTO";
        }
    }
}
