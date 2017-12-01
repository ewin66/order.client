using iih.ci.ord.ems.d;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.mw.core.data;

namespace iih.ci.ord.dto.emsmain
{
    public class EmsLoadDTO : BaseDTO
    {
        /**
	 * 医疗单主服务id
	 * @return String
	 */
        public string Id_or
        {
            get { return getAttrVal<string>("Id_or", null); }
            set { setAttrVal<string>("Id_or", value); }
        }

        /**
         * 医疗单驱动
         * @return String
         */
        public string EmsDriver
        {
            get { return getAttrVal<string>("EmsDriver", null); }
            set { setAttrVal<string>("EmsDriver", value); }
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
