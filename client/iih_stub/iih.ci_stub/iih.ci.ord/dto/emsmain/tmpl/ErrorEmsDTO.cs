using iih.ci.ord.dto.emsmain;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.mw.core.data;

namespace iih.ci.ord.d.ems.tmpl
{
    public class ErrorEmsDTO : BaseCiDTO
    {
        /**
	 * 错误信息
	 * @return FArrayList
	 */
        public FArrayList ErrorInfo
        {
            get { return getAttrVal<FArrayList>("ErrorInfo", null); }
            set { setAttrVal<FArrayList>("ErrorInfo", value); }
        }
        
    }
}
