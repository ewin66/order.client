using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.mw.serviceframework;
using xap.rui.appfw;
using iih.ci.ord.cior.d;

namespace iih.ci.ord.cior.i
{
    public class ICiRptBtTestServiceImpl : ICiRptBtTestService
    {
        private string url = XapSvrConfig.BaseUrl + "iihci.ord/iih.ci.ord.cior.i.ICiRptBtTestService";//ConfigUtil.getServiceUrl();

        private ServiceInvocation si;
		private CacheHelper<CiordrptbttestAggDO> ch;
        /// <summary>
        /// 构造函数
        /// </summary>
        public ICiRptBtTestServiceImpl()
        {
        	ch = new CacheHelper<CiordrptbttestAggDO>();
            si = new ServiceInvocationImpl();
            si.url = url;
        }
        public CiordrptbttestAggDO getRptBtTestByReqNo(string reqNo)
        {
            List<object> param = new List<object>();
            param.Add(reqNo);
            CiordrptbttestAggDO rtn = si.invoke<CiordrptbttestAggDO>("getRptBtTestByReqNo", param.ToArray());
            return rtn; ;
        }
    }
}
