using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.diag.dto.didefdto.d
{
    /// <summary>
    /// DidefDto 的摘要说明。
    /// </summary>
    public class DidefDto : BaseDTO {

        public DidefDto() {
 
        }

        /// <summary>
        /// 主键
        /// </summary>
		public string Id_di {
            get { return getAttrVal<string>("Id_di",null); }
            set { setAttrVal<string>("Id_di", value); }
        }

        /// <summary>
        /// 名称
        /// </summary>
		public string Name {
            get { return getAttrVal<string>("Name",null); }
            set { setAttrVal<string>("Name", value); }
        }

        /// <summary>
        /// 编码
        /// </summary>
		public string Code {
            get { return getAttrVal<string>("Code",null); }
            set { setAttrVal<string>("Code", value); }
        }

        /// <summary>
        /// displaynam4
        /// </summary>
		public string Name4 {
            get { return getAttrVal<string>("Name4",null); }
            set { setAttrVal<string>("Name4", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_di", "Name", "Code", "Name4"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.diag.dto.didefdto.d.DidefDto";
        }
    }
}
