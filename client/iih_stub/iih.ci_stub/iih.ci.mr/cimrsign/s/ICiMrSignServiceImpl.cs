using System;
using System.Collections.Generic;
using iih.bd.srv.emrtpl.d;
using iih.ci.mr.d;
using xap.mw.core.data;
using xap.mw.serviceframework;
using xap.rui.appfw;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mr.cimrsign.i
{
    public  class ICiMrSignServiceImpl : ICiMrSignService
    {
        private string url = XapSvrConfig.BaseUrl + "iihci.mr/iih.ci.mr.i.ICiMrSignService";//ConfigUtil.getServiceUrl();
        private ServiceInvocation si;
        private CacheHelper<EmrTplDO> ch;
        public ICiMrSignServiceImpl()
        {
            si = new ServiceInvocationImpl();
            ch = new CacheHelper<EmrTplDO>();
            si.url = url;
        }
       
        /// <summary>
        /// 根据当前登录用用户的ID及状态获取审签的任务
        /// </summary>
        /// <param name="id_user"> 登录用户的ID</param>
        /// <param name="state"> 状态</param> 
        /// <returns>MrSginDTO[] </returns>
        public PagingRtnData<MrSginDTO> getMrSignDTO(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo) 
        {
            List<object> param = new List<object>();
            param.Add(qryRootNodeDTO);
            param.Add(paginationInfo);
            si.url = url;

            PagingRtnData<MrSginDTO> rtn = si.invokePaging<MrSginDTO>("getMrSignDTO", param.ToArray());
            return rtn;
        }

        //public MrSginDTO[] getMrSigndto(QryRootNodeDTO qryRootNodeDTO)
        //{
        //    List<object> param = new List<object>();
        //    param.Add(qryRootNodeDTO);
        //    si.url = url;

        //    MrSginDTO[] rtn = si.invokeList<MrSginDTO>("getMrSigndto", param.ToArray());
        //    return rtn;
        //}
    }
}
