using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.cirptlab.d;
using xap.mw.serviceframework;
using xap.rui.appfw;

namespace iih.ci.ord.cirptlab.i
{
    public class ICiRptLabServiceImpl:ICiRptLabService
    {
        private string url = XapSvrConfig.BaseUrl + "iihci.ord/iih.ci.ord.cirptlab.i.ICiRptLabService";//ConfigUtil.getServiceUrl();

         private ServiceInvocation si;
         private CacheHelper<CirptlabAggDO> ch;
        /// <summary>
        /// 构造函数
        /// </summary>
         public ICiRptLabServiceImpl()
        {
            ch = new CacheHelper<CirptlabAggDO>();
            si = new ServiceInvocationImpl();
            si.url = url;
        }
        public CirptlabAggDO getRptLabByReqNo(string reqNo)
        {
            List<object> param = new List<object>();
            param.Add(reqNo);
            CirptlabAggDO rtn = si.invoke<CirptlabAggDO>("getRptLabByReqNo", param.ToArray());
            return rtn;
        }
    }
}
