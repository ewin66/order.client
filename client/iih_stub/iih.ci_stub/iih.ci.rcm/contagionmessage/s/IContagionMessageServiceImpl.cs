using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.mw.serviceframework;
using iih.ci.iih.ci.rcm.contagionmessage.i;
using xap.rui.appfw;
using iih.ci.rcm.contagion.d;

namespace iih.ci.iih.ci.rcm.contagionmessage.i
{
    public class IContagionMessageServiceImpl : IContagionMessageService
    {
        private string url = XapSvrConfig.BaseUrl + "iihci.rcm/iih.ci.rcm.contagionmessage.i.IContagionMessageService";

        private ServiceInvocation si;

        public IContagionMessageServiceImpl()
        {
            si = new ServiceInvocationImpl();
            si.url = url;
        }

        public string SendMessage(ContagionDO condo) {
            List<object> param = new List<object>();
            si.url = url;
            param.Add(condo);
            string rtn = si.invokeString("sentMessage", param.ToArray());
            return rtn;
        }
    }

   
}
