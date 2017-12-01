using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.ciordems.d
{
    /// <summary>
    /// EmsFeesDTO 的摘要说明。
    /// </summary>
    public class EmsFeesDTO : BaseDTO {

        public EmsFeesDTO() {
 
        }

        /// <summary>
        /// 服务类别名称
        /// </summary>
		public string Name {
            get { return getAttrVal<string>("Name",null); }
            set { setAttrVal<string>("Name", value); }
        }

        /// <summary>
        /// 金额合计
        /// </summary>
		public FDouble Allfees {
            get { return getAttrVal<FDouble>("Allfees",null); }
            set { setAttrVal<FDouble>("Allfees", value); }
        }

        /// <summary>
        /// 已缴费金额
        /// </summary>
		public FDouble Haspay {
            get { return getAttrVal<FDouble>("Haspay",null); }
            set { setAttrVal<FDouble>("Haspay", value); }
        }

        /// <summary>
        /// 未缴费
        /// </summary>
		public FDouble Nopay {
            get { return getAttrVal<FDouble>("Nopay",null); }
            set { setAttrVal<FDouble>("Nopay", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Name", "Allfees", "Haspay", "Nopay"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.ciordems.d.d.EmsFeesDTO";
        }
    }
}
