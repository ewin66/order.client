using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.cirptpathgy.d;
using iih.ci.ord.cirptpathgy.i;
using xap.mw.serviceframework;
using xap.rui.appfw;

namespace iih.ci.ord.cirptpathgy.i
{
    public class ICiRptPathgyServiceImpl : ICiRptPathgyService
    {
        private string url = XapSvrConfig.BaseUrl + "iihci.ord/iih.ci.ord.cirptpathgy.i.ICiRptPathgyService";//ConfigUtil.getServiceUrl();

         private ServiceInvocation si;
         private CacheHelper<CiRptPathgyDO> ch;
        /// <summary>
        /// 构造函数
        /// </summary>
         public ICiRptPathgyServiceImpl()
        {
            ch = new CacheHelper<CiRptPathgyDO>();
            si = new ServiceInvocationImpl();
            si.url = url;
        }
         public CiRptPathgyDO getRptPathgyByReqNo(CiRptPathgyDO reqNo)
        {
            List<object> param = new List<object>();
            param.Add(reqNo);
            CiRptPathgyDO rtn = si.invoke<CiRptPathgyDO>("getRptPathgyByReqNo", param.ToArray());
            return rtn;
        }
    }
}
