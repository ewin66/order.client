using iih.bd.srv.ems.d;
using iih.ci.ord.ems.d;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.mw.core.data;

namespace iih.ci.ord.dto.emsmain
{
    public class EmsCrtDTO : BaseDTO
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

        public String CustomInfo
        {
            get { return getAttrVal<String>("CustomInfo", null); }
            set { setAttrVal<String>("CustomInfo", value); }
        }

        /**
	 * 医疗单 --- 后续优化掉该属性
	 * @return EmsMatchRstDTO
	 */
        public EmsMatchRstDTO EmsMgrInfo
        {
            get { return getAttrVal<EmsMatchRstDTO>("EmsMgrInfo", null); }
            set { setAttrVal<EmsMatchRstDTO>("EmsMgrInfo", value); }
        }


        /**
         * 医疗单驱动
         * @return String
         */
        public String EmsDriver
        {
            get { return getAttrVal<String>("EmsDriver", null); }
            set { setAttrVal<String>("EmsDriver", value); }
        }

        /// <summary>
        /// 就诊上下文
        /// </summary>
        public CiEnContextDTO EnContext
        {
            get { return getAttrVal<CiEnContextDTO>("EnContext", null); }
            set { setAttrVal<CiEnContextDTO>("EnContext", value); }
        }
        
    }
}
