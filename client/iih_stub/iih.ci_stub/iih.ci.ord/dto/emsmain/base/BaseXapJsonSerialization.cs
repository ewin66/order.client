using iih.ci.ord.ems.d;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.mw.core.data;

namespace iih.ci.ord.dto.emsmain
{
    /**
 * 前后台数据传输Json序列化与反序列化类型
 * @author wangqingzhu
 *
 */
    public class BaseXapJsonSerialization : BaseDTO
    {
        /**
         * 扩展信息
         * @return String
         */
        public FMap2 Extension
        {
            get { return getAttrVal<FMap2>("Extension", null); }
            set { setAttrVal<FMap2>("Extension", value); }
        }

    }
}
