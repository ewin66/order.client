using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.mw.core.data;
using xap.sys.xbd.udi.d;

namespace iih.ci.mr.cimrvt.i
{
    public interface IUdidocServiceExt
    {
        UdidocDO[] findByUdidoclistCode(string code);

        UdidocDO[] findByUdidoclistCodes(FArrayList codeArry);
    }
}
