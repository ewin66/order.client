using iih.ci.iih.ci.ord.dto.emsmain;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.dto.emsmain
{
    public class EmsRstDTO : BaseCiDTO
    {
       

        /// <summary>
        /// 医疗单驱动
        /// </summary>
        public String EmsDriver
        {
            get { return getAttrVal<String>("EmsDriver", null); }
            set { setAttrVal<String>("EmsDriver", value); }
        }

        public FArrayList ErrorEmsList
        {
            get { return getAttrVal<FArrayList>("ErrorEmsList", null); }
            set { setAttrVal<FArrayList>("ErrorEmsList", value); }
        }

    }
}
