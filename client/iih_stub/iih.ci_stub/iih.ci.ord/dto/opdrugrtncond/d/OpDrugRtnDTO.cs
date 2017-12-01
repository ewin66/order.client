using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.dto.opdrugrtncond.d
{
    /// <summary>
    /// ${EntityMeta.fullClassName} 的摘要说明。
    /// </summary>
    public class OpDrugRtnDTO : BaseDTO {

        public OpDrugRtnDTO() {
 
        }
		public string Id_pat {
            get { return getAttrVal<string>("Id_pat",null); }
            set { setAttrVal<string>("Id_pat", value); }
        }
		public string Name2 {
            get { return getAttrVal<string>("Name2",null); }
            set { setAttrVal<string>("Name2", value); }
        }
    }
}
