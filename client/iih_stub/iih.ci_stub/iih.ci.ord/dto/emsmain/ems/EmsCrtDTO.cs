using iih.bd.srv.ems.d;
using iih.ci.iih.ci.ord.dto.emsmain;
using iih.ci.ord.ems.d;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.mw.core.data;

namespace iih.ci.ord.dto.emsmain
{
    public class EmsCrtDTO : BaseCiDTO
    {
        /**
	 * 医疗单主服务id
	 * @return String
	 */
        public String Id_srv
        {
            get { return getAttrVal<String>("Id_srv", null); }
            set { setAttrVal<String>("Id_srv", value); }
        }


        /**
         * 医疗单物品id
         * @return String
         */
        public String Id_mm
        {
            get { return getAttrVal<String>("Id_mm", null); }
            set { setAttrVal<String>("Id_mm", value); }
        }


        /**
	 * 医疗单 --- 后续优化掉该属性
	 * @return EmsMatchRstDTO
	 */
        public SrvMatchEmsRstDTO EmsMgrInfo
        {
            get { return getAttrVal<SrvMatchEmsRstDTO>("EmsMgrInfo", null); }
            set { setAttrVal<SrvMatchEmsRstDTO>("EmsMgrInfo", value); }
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
