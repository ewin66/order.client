using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.mrqc.itmdto.d
{
    /// <summary>
    /// ItmFstDTO 的摘要说明。
    /// </summary>
    public class ItmFstDTO : BaseDTO {

        public ItmFstDTO() {
 
        }

        /// <summary>
        /// 一级分类
        /// </summary>
		public string Id_fst {
            get { return getAttrVal<string>("Id_fst",null); }
            set { setAttrVal<string>("Id_fst", value); }
        }

        /// <summary>
        /// 一级分类名称
        /// </summary>
		public string Fst_name {
            get { return getAttrVal<string>("Fst_name",null); }
            set { setAttrVal<string>("Fst_name", value); }
        }

        /// <summary>
        /// 缺陷表主键
        /// </summary>
		public string Id_qa_flt {
            get { return getAttrVal<string>("Id_qa_flt",null); }
            set { setAttrVal<string>("Id_qa_flt", value); }
        }

        /// <summary>
        /// 整改说明
        /// </summary>
		public string Rfm_des {
            get { return getAttrVal<string>("Rfm_des",null); }
            set { setAttrVal<string>("Rfm_des", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_fst", "Fst_name", "Id_qa_flt", "Rfm_des"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mrqc.itmdto.d.ItmFstDTO";
        }
    }
}
