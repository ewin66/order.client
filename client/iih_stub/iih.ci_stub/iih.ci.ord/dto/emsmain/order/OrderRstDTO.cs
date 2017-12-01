using iih.ci.iih.ci.ord.dto.emsmain;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.dto.emsmain
{
    public class OrderRstDTO : BaseCiDTO
    {
        
        public FBoolean IsSuccess
        {
            get { return getAttrVal<FBoolean>("IsSuccess", null); }
            set { setAttrVal<FBoolean>("IsSuccess", value); }
        }
        public String MessageInfo
        {
            get { return getAttrVal<String>("MessageInfo", null); }
            set { setAttrVal<String>("MessageInfo", value); }
        }
       
    }
}
