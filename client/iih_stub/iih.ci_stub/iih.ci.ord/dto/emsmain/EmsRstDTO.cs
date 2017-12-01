using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.mw.core.data;

namespace iih.ci.ord.dto.emsmain
{
    public class EmsRstDTO : BaseDTO
    {
        /**
	 * 医疗单
	 * @return BaseDTO
	 */
        public String EmsDocument
        {
            get { return getAttrVal<String>("EmsDocument", null); }
            set { setAttrVal<String>("EmsDocument", value); }
        }


        /**
         * 医疗单类型
         * @return String
         */
        public int? EmsType
        {
            get { return getAttrVal<int?>("EmsType", null); }
            set { setAttrVal<int?>("EmsType", value); }
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
