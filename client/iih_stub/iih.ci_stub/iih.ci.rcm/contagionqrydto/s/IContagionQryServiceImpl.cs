using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.mrqc.qapatlist.d;
using iih.ci.mrqc.qapatlist.i;
using iih.ci.rcm.contagionqrydto.d;
using xap.mw.core.data;
using xap.mw.serviceframework;
using xap.rui.appfw;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.rcm.contagionqrydto.i
{
    class IContagionQryServiceImpl : IContagionQryService {

        private string url = XapSvrConfig.BaseUrl + "iihci.rcm/iih.ci.rcm.contagionqrydto.i.IContagionQryService";//ConfigUtil.getServiceUrl();

        private ServiceInvocation si;
        private CacheHelper<QaPatListDTO> ch;
        /// <summary>
        /// 构造函数
        /// </summary>
        public IContagionQryServiceImpl()
        {
            ch = new CacheHelper<QaPatListDTO>();
            si = new ServiceInvocationImpl();
            si.url = url;
        }


        public PagingRtnData<ContagionQryDTO> getContagionQryDTOList(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
        {
            List<object> param = new List<object>();
            param.Add(qryRootNodeDTO);
            param.Add(paginationInfo);
            si.url = url;
            PagingRtnData<ContagionQryDTO> rtn = si.invokePaging<ContagionQryDTO>("getContagionQryDTOList", param.ToArray());
            return rtn;
        }

        public ContagionQryDTO[] GetAllPageData()
        {
            si.url = url;
            List<object> param = new List<object>();
            ContagionQryDTO[] rtn = si.invokeList<ContagionQryDTO>("getAllPageData", param.ToArray());
            return rtn;
        }
    }
}
