using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.idvproperty.d
{
    /// <summary>
    /// IdVProperty 的摘要说明。
    /// </summary>
    public class IdVProperty : BaseDTO {

        public IdVProperty() {
 
        }

        /// <summary>
        /// 系统主键
        /// </summary>
		public string Id {
            get { return getAttrVal<string>("Id",null); }
            set { setAttrVal<string>("Id", value); }
        }

        /// <summary>
        /// 系统版本
        /// </summary>
		public DateTime? Ver {
            get { return getAttrVal<FDateTime>("Ver",null); }
            set { setAttrVal<FDateTime>("Ver", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id", "Ver"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.idvproperty.d.IdVProperty";
        }
    }
}
