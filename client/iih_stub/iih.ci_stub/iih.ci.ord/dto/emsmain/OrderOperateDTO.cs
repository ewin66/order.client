using iih.ci.ord.ems.d;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.mw.core.data;

namespace iih.ci.ord.dto.emsmain
{
    public class OrderOperateDTO : BaseDTO
    {
        /// <summary>
        /// 医嘱操作参数
        /// </summary>
        public FArrayList ParamList
        {
            get { return getAttrVal<FArrayList>("ParamList", null); }
            set { setAttrVal<FArrayList>("ParamList", value); }
        }
        /**
          * 就诊上下文
          * @return BaseDTO
          */
        public CiEnContextDTO EnContext
        {
            get { return getAttrVal<CiEnContextDTO>("EnContext", null); }
            set { setAttrVal<CiEnContextDTO>("EnContext", value); }
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
