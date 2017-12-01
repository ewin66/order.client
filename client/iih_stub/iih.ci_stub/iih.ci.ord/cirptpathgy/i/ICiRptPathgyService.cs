using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.cirptpathgy.d;

namespace iih.ci.ord.cirptpathgy.i
{
    public interface ICiRptPathgyService
    {
        CiRptPathgyDO getRptPathgyByReqNo(CiRptPathgyDO reqNo);
    }
}
