using iih.ci.ord.ems.d;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.mw.core.data;

namespace iih.ci.ord.dto.emsmain
{
    public class BaseCiDTO : BaseXapJsonSerialization
    {
        /// <summary>
        /// 就诊上下文
        /// </summary>
        public CiEnContextDTO EnContext
        {
            get { return getAttrVal<CiEnContextDTO>("EnContext", null); }
            set { setAttrVal<CiEnContextDTO>("EnContext", value); }
        }


        /**
         * 数据档案
         * @return String
         */
        public FArrayList Document
        {
            get { return getAttrVal<FArrayList>("Document", null); }
            set { setAttrVal<FArrayList>("Document", value); }
        }
        //public String DocumentString
        //{
        //    get { return getAttrVal<String>("DocumentString", null); }
        //    set { setAttrVal<String>("DocumentString", value); }
        //}


        

        /**
	 * 数据操作来源
	 * @return String
	 */
        public String OperateSourceFrom
        {
            get { return getAttrVal<String>("OperateSourceFrom", null); }
            set { setAttrVal<String>("OperateSourceFrom", value); }
        }
        
        
    }
}
