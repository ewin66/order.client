using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.ciorder.d;
using xap.mw.core.data;

namespace iih.ci.ord.cior.d
{
    public class CiorderAggExtDO: BaseDTO
    {

        public int? Reacttype
        {
            get { return getAttrVal<int?>("Reacttype", null); }
            set { setAttrVal<int?>("Reacttype", value); }
        }

        public string Id_reacts
        {
            get { return getAttrVal<string>("Id_reacts", null); }
            set { setAttrVal<string>("Id_reacts", value); }
        }

        public string Id_srvs
        {
            get { return getAttrVal<string>("Id_srvs", null); }
            set { setAttrVal<string>("Id_srvs", value); }
        }

        public CiorderAggDO Aggdo
        {
            get { return getAttrVal<CiorderAggDO>("Aggdo", null); }
            set { setAttrVal<CiorderAggDO>("Aggdo", value); }
        }



    }
}
