using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.cirptobs.d;

namespace iih.ci.ord.cirptobs.i
{
    public interface ICiRptObsService
    {
        CiRptObsDO getRptObsByReqNo(String reqNo);
    }
}
