using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.tmpl.d
{
    /// <summary>
    /// CiOrTmplSetItmDTO 的摘要说明。
    /// </summary>
    public class CiOrTmplSetItmDTO : BaseDTO {

        public CiOrTmplSetItmDTO() {
 
        }

        /// <summary>
        /// 临床医嘱模板套内项目主键标识
        /// </summary>
		public string Id_ciortmplsetitm {
            get { return getAttrVal<string>("Id_ciortmplsetitm",null); }
            set { setAttrVal<string>("Id_ciortmplsetitm", value); }
        }

        /// <summary>
        /// 临床医嘱模板项目
        /// </summary>
		public string Id_ciortmplsrv {
            get { return getAttrVal<string>("Id_ciortmplsrv",null); }
            set { setAttrVal<string>("Id_ciortmplsrv", value); }
        }

        /// <summary>
        /// 套内项目
        /// </summary>
		public string Id_srv {
            get { return getAttrVal<string>("Id_srv",null); }
            set { setAttrVal<string>("Id_srv", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_ciortmplsetitm", "Id_ciortmplsrv", "Id_srv"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.tmpl.d.CiOrTmplSetItmDTO";
        }
    }
}
