using iih.ci.ord.ems.d;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace iih.ci.ord.dto.emsmain
{
    public class EmsSaveDTO : EmsRstDTO
    {
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
        
    }
}
