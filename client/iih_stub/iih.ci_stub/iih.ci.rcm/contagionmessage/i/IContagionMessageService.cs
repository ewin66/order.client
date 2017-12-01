using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.rcm.contagion.d;

namespace iih.ci.iih.ci.rcm.contagionmessage.i
{
    public interface IContagionMessageService
    {
        string SendMessage(ContagionDO condo);
    }
}
