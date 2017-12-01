using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.mw.core.data;

namespace iih.ci.iih.ci.ord.dto.emsmain.error
{
    /// <summary>
    /// 错误信息
    /// </summary>
    class CiErrorDTO : BaseDTO
    {

        /**
         * 错误信息ID
         * @return String
         */
        public String Id_error
        {
            get { return getAttrVal<String>("Id_error", null); }
            set { setAttrVal<String>("Id_error", value); }
        }


        /**
         * 错误信息描述
         * @return String
         */
        public String Descriptionerror
        {
            get { return getAttrVal<String>("Description", null); }
            set { setAttrVal<String>("Description", value); }
        }


        /**
         * 错误信息级别
         * @return String
         */
        public String Level
        {
            get { return getAttrVal<String>("Level", null); }
            set { setAttrVal<String>("Level", value); }
        }

        /**
         * 错误信息扩展
         * @return String
         */
        public FMap2 Extension
        {
            get { return getAttrVal<FMap2>("Extension", null); }
            set { setAttrVal<FMap2>("Extension", value); }
        }
       
    }
}
