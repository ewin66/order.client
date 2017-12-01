using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.cirptlab.d;

namespace iih.ci.ord.cirptlab.i
{
    public interface ICiRptLabService
    {
        CirptlabAggDO getRptLabByReqNo(String reqNo);
    }
}
