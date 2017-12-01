using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.mw.core.data;

namespace iih.ci.diag_stub.iih.ci.diag.dto.d
{
    public class ENTypeDTO:BaseDO
    {

        public ENTypeDTO()
        {
        }

        public string Di_type
        {
            get { return getAttrVal<string>("Di_type", null); }
            set { setAttrVal<string>("Di_type", value); }
        }
        public string Di_type_code
        {
            get { return getAttrVal<string>("Di_type_code", null); }
            set { setAttrVal<string>("Di_type_code", value); }
        }
    }
}
