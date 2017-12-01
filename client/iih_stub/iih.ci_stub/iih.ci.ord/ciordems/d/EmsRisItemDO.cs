using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.ciordems.d
{
    /// <summary>
    /// ${EntityMeta.fullClassName} 的摘要说明。
    /// </summary>
    public class EmsRisItemDO : BaseDTO {

        public EmsRisItemDO() {
 
        }
		public string Id_orsrv {
            get { return getAttrVal<string>("Id_orsrv",null); }
            set { setAttrVal<string>("Id_orsrv", value); }
        }
		public string Id_or {
            get { return getAttrVal<string>("Id_or",null); }
            set { setAttrVal<string>("Id_or", value); }
        }
		public string Name3 {
            get { return getAttrVal<string>("Name3",null); }
            set { setAttrVal<string>("Name3", value); }
        }
		public string Name4 {
            get { return getAttrVal<string>("Name4",null); }
            set { setAttrVal<string>("Name4", value); }
        }
		public string Name5 {
            get { return getAttrVal<string>("Name5",null); }
            set { setAttrVal<string>("Name5", value); }
        }
    }
}
