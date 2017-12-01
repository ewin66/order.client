using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.mr.cimr.d;
using iih.ci.mr.cimrfs.d;
using xap.mw.serviceframework;
using xap.rui.appfw;

namespace iih.ci.mr.cimrfs.i
{
    class ICimrPrintServiceImpl : ICimrPrintService
    {
        private string url = XapSvrConfig.BaseUrl + "iihci.mr/iih.ci.mr.cimrfs.i.ICimrPrintService";//ConfigUtil.getServiceUrl();
        private ServiceInvocation si;
        private CacheHelper<CiMrFsDO> ch;
        public ICimrPrintServiceImpl()
        {
            si = new ServiceInvocationImpl();
            ch = new CacheHelper<CiMrFsDO>();
            si.url = url;
        }
        /// <summary>
        /// 获取模板流
        /// </summary>
        /// <param name="dos"> 文书数组</param>
        /// <returns></returns>
        public CiMrFsDO[] getCimrStream(CiMrDO[] dos)
        {
            List<object> param = new List<object>();
            param.Add(dos);
            si.url = url;

            CiMrFsDO[] rtn = si.invokeList<CiMrFsDO>("getCimrStream", param.ToArray());
            return rtn;
        }
    }
}
