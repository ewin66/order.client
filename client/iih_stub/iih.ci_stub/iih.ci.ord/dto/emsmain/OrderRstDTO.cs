using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.dto.emsmain
{
    public class OrderRstDTO : BaseDTO
    {
        /// <summary>
        /// 医嘱操作参数
        /// </summary>
        public FArrayList RstInfo
        {
            get { return getAttrVal<FArrayList>("RstInfo", null); }
            set { setAttrVal<FArrayList>("RstInfo", value); }
        }
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
        /** 
         * 医疗单扩展信息
         * @return String
         */
        public FMap2 EmsExtension
        {
            get { return getAttrVal<FMap2>("EmsExtension", null); }
            set { setAttrVal<FMap2>("EmsExtension", value); }
        }
    }
}
