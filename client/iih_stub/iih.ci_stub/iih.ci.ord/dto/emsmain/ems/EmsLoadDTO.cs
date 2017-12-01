using iih.ci.iih.ci.ord.dto.emsmain;
using iih.ci.ord.ems.d;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.mw.core.data;

namespace iih.ci.ord.dto.emsmain
{
    public class EmsLoadDTO : BaseCiDTO
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

        /// <summary>
        /// 医疗单驱动
        /// </summary>
        public String EmsDriver
        {
            get { return getAttrVal<String>("EmsDriver", null); }
            set { setAttrVal<String>("EmsDriver", value); }
        }

    }
}
