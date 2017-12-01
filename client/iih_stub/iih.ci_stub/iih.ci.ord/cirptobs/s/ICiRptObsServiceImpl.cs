using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.cirptobs.i;
using xap.mw.serviceframework;
using iih.ci.ord.cirptobs.d;
using xap.rui.appfw;

namespace iih.ci.ord.cirptobs.i
{
    public class ICiRptObsServiceImpl : ICiRptObsService
    {
        private string url = XapSvrConfig.BaseUrl + "iihci.ord/iih.ci.ord.cirptobs.i.ICiRptObsService";//ConfigUtil.getServiceUrl();

         private ServiceInvocation si;
         private CacheHelper<CiRptObsDO> ch;
        /// <summary>
        /// 构造函数
        /// </summary>
         public ICiRptObsServiceImpl()
        {
            ch = new CacheHelper<CiRptObsDO>();
            si = new ServiceInvocationImpl();
            si.url = url;
        }
        public CiRptObsDO getRptObsByReqNo(string reqNo)
        {
            List<object> param = new List<object>();
            param.Add(reqNo);
            CiRptObsDO rtn = si.invoke<CiRptObsDO>("getRptObsByReqNo", param.ToArray());
            return rtn;
        }
    }
}
