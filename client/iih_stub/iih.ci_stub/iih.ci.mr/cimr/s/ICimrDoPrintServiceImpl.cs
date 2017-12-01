using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.mr.cimr.d;
using xap.mw.serviceframework;
using xap.rui.appfw;

namespace iih.ci.mr.cimr.i
{
    class ICimrDoPrintServiceImpl : ICimrDoPrintService
    {
        private string url = XapSvrConfig.BaseUrl + "iihci.mr/iih.ci.mr.cimr.i.ICimrDoPrintService";//ConfigUtil.getServiceUrl();
        private ServiceInvocation si;
        private CacheHelper<CiMrDO> ch;
        public ICimrDoPrintServiceImpl()
        {
            si = new ServiceInvocationImpl();
            ch = new CacheHelper<CiMrDO>();
            si.url = url;
        }
        /// <summary>
        /// 获取模板流
        /// </summary>
        /// <param name="Id_basemrtpl"> 基础模板id</param>
        /// <param name="sd_su_mrptl">模板状态</param>
        /// <returns></returns>
        public CiMrDO[] getCimrDo(String id_ent, String Id_mrcactm)
        {
            List<object> param = new List<object>();
            param.Add(id_ent);
            param.Add(Id_mrcactm);
            si.url = url;

            CiMrDO[] rtn = si.invokeList<CiMrDO>("getCimrDo", param.ToArray());
            return rtn;
        }
    }
}
