using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.mrqc.qapatlist.d;
using xap.mw.core.data;
using xap.mw.serviceframework;
using xap.rui.appfw;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mrqc.qapatlist.i
{
    class IMrManagePatQryServiceImpl : IMrManagePatQryService
    {
        private string url = XapSvrConfig.BaseUrl + "iihci.mrqc/iih.ci.mrqc.qapatlist.i.IMrManagePatQryService";//ConfigUtil.getServiceUrl();
        private ServiceInvocation si;
        private CacheHelper<QaPatListDTO> ch;
        /// <summary>
        /// 构造函数
        /// </summary>
        public IMrManagePatQryServiceImpl()
        {
            ch = new CacheHelper<QaPatListDTO>();
            si = new ServiceInvocationImpl();
            si.url = url;
        }
        //待签收
        public PagingRtnData<QaPatListDTO> getMrNeedSignOffPatList(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
        {
            List<object> param = new List<object>();
            param.Add(qryRootNodeDTO);
            param.Add(paginationInfo);
            si.url = url;
            PagingRtnData<QaPatListDTO> rtn = si.invokePaging<QaPatListDTO>("getMrNeedSignOffPatList", param.ToArray());
            return rtn;
        }
        //待编目
        public PagingRtnData<QaPatListDTO> getMrNeedCataloguePatList(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
        {
            List<object> param = new List<object>();
            param.Add(qryRootNodeDTO);
            param.Add(paginationInfo);
            si.url = url;
            PagingRtnData<QaPatListDTO> rtn = si.invokePaging<QaPatListDTO>("getMrNeedCataloguePatList", param.ToArray());
            return rtn;
        }
        //待归档
        public PagingRtnData<QaPatListDTO> getMrNeedPigeonholePatList(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
        {
            List<object> param = new List<object>();
            param.Add(qryRootNodeDTO);
            param.Add(paginationInfo);
            si.url = url;
            PagingRtnData<QaPatListDTO> rtn = si.invokePaging<QaPatListDTO>("getMrNeedPigeonholePatList", param.ToArray());
            return rtn;
        }
        //已归档
        public PagingRtnData<QaPatListDTO> getMrHasPigeonholedPatList(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
        {
            List<object> param = new List<object>();
            param.Add(qryRootNodeDTO);
            param.Add(paginationInfo);
            si.url = url;
            PagingRtnData<QaPatListDTO> rtn = si.invokePaging<QaPatListDTO>("getMrHasPigeonholedPatList", param.ToArray());
            return rtn;
        }
        /// <summary>
        /// 返修
        /// </summary>
        /// <param name="qryRootNodeDTO"></param>
        /// <param name="paginationInfo"></param>
        /// <returns></returns>
        public PagingRtnData<QaPatListDTO> getMrNeedRepairPatList(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
        {
            List<object> param = new List<object>();
            param.Add(qryRootNodeDTO);
            param.Add(paginationInfo);
            si.url = url;
            PagingRtnData<QaPatListDTO> rtn = si.invokePaging<QaPatListDTO>("getMrNeedRepairPatList", param.ToArray());
            return rtn;
        }
        // 病案检索
        public PagingRtnData<QaPatListDTO> getMrRetrievalPatList(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
        {
            List<object> param = new List<object>();
            param.Add(qryRootNodeDTO);
            param.Add(paginationInfo);
            si.url = url;
            PagingRtnData<QaPatListDTO> rtn = si.invokePaging<QaPatListDTO>("getMrRetrievalPatList", param.ToArray());
            return rtn;
        }

        public void TimingExecutionToUpdateAmrBorrowApply()
        {
            si.url = url;
            si.invoke<object>("TimingExecutionToUpdateAmrBorrowApply");
        }
    }
}
