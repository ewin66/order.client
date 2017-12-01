using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.moreemsdto.d
{
    /// <summary>
    /// MoreEmsParamDTO 的摘要说明。
    /// </summary>
    public class MoreEmsParamDTO : BaseDTO {

        public MoreEmsParamDTO() {
 
        }

        /// <summary>
        /// 主键
        /// </summary>
		public string Id_moreems {
            get { return getAttrVal<string>("Id_moreems",null); }
            set { setAttrVal<string>("Id_moreems", value); }
        }

        /// <summary>
        /// 医嘱列表
        /// </summary>
		public FMap2 Ordermap2 {
            get { return getAttrVal<FMap2>("Ordermap2",null); }
            set { setAttrVal<FMap2>("Ordermap2", value); }
        }

        /// <summary>
        /// 错误信息字符串
        /// </summary>
		public string Errorinfo {
            get { return getAttrVal<string>("Errorinfo",null); }
            set { setAttrVal<string>("Errorinfo", value); }
        }

        /// <summary>
        /// 多医疗单的错误数据
        /// </summary>
		public FMap2 Errormap2 {
            get { return getAttrVal<FMap2>("Errormap2",null); }
            set { setAttrVal<FMap2>("Errormap2", value); }
        }

        /// <summary>
        /// displaynam5
        /// </summary>
		public string Name5 {
            get { return getAttrVal<string>("Name5",null); }
            set { setAttrVal<string>("Name5", value); }
        }

        /// <summary>
        /// displaynam6
        /// </summary>
		public string Name6 {
            get { return getAttrVal<string>("Name6",null); }
            set { setAttrVal<string>("Name6", value); }
        }

        /// <summary>
        /// 提示信息
        /// </summary>
		public string Prompt_msg {
            get { return getAttrVal<string>("Prompt_msg",null); }
            set { setAttrVal<string>("Prompt_msg", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_moreems", "Ordermap2", "Errorinfo", "Errormap2", "Name5", "Name6", "Prompt_msg"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.moreemsdto.d.MoreEmsParamDTO";
        }
    }
}
