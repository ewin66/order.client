using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.cior.d;

namespace iih.ci.ord.cior.i
{
    public interface ICiRptBtTestService
    {
        CiordrptbttestAggDO getRptBtTestByReqNo(String reqNo);
    }
}
