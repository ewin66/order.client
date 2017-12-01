using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.mrqc.qapatlist.d;
using iih.ci.mrqc.qapatlist.i;
using xap.mw.core.data;
using xap.mw.serviceframework;
using xap.rui.appfw;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mrqc.qapatlist.i {
    class IQaProcessQryServiceImpl : IQaProcessQryService {

        private string url = XapSvrConfig.BaseUrl + "iihci.mrqc/iih.ci.mrqc.qapatlist.i.IQaProcessQryService";//ConfigUtil.getServiceUrl();

        private ServiceInvocation si;
        private CacheHelper<QaPatListDTO> ch;
        /// <summary>
        /// 构造函数
        /// </summary>
        public IQaProcessQryServiceImpl() {
            ch = new CacheHelper<QaPatListDTO>();
            si = new ServiceInvocationImpl();
            si.url = url;
        }

        public PagingRtnData<QaPatListDTO> getQaPatListDTOList(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
        {
            List<object> param = new List<object>();
            param.Add(qryRootNodeDTO);
            param.Add(paginationInfo);
            si.url = url;
            PagingRtnData<QaPatListDTO> rtn = si.invokePaging<QaPatListDTO>("getQaPatListDTOList", param.ToArray());
            return rtn;
        }
        public PagingRtnData<QaPatListDTO> getDeptQcPatListDTOList(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
        {
            List<object> param = new List<object>();
            param.Add(qryRootNodeDTO);
            param.Add(paginationInfo);
            si.url = url;
            PagingRtnData<QaPatListDTO> rtn = si.invokePaging<QaPatListDTO>("getDeptQcPatListDTOList", param.ToArray());
            return rtn;
        }

        public PagingRtnData<QaPatListDTO> getTerminalQcSignOffPatListDTOList(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
        {
            List<object> param = new List<object>();
            param.Add(qryRootNodeDTO);
            param.Add(paginationInfo);
            si.url = url;
            PagingRtnData<QaPatListDTO> rtn = si.invokePaging<QaPatListDTO>("getTerminalQcSignOffPatListDTOList", param.ToArray());
            return rtn;
        }

        public PagingRtnData<QaPatListDTO> getTerminalQcPatListDTOList(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
        {
            List<object> param = new List<object>();
            param.Add(qryRootNodeDTO);
            param.Add(paginationInfo);
            si.url = url;
            PagingRtnData<QaPatListDTO> rtn = si.invokePaging<QaPatListDTO>("getTerminalQcPatListDTOList", param.ToArray());
            return rtn;
        }

        public PagingRtnData<QaPatListDTO> getDeptQcScorePatListDTOList(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
        {
            List<object> param = new List<object>();
            param.Add(qryRootNodeDTO);
            param.Add(paginationInfo);
            si.url = url;
            PagingRtnData<QaPatListDTO> rtn = si.invokePaging<QaPatListDTO>("getDeptQcScorePatListDTOList", param.ToArray());
            return rtn;
        }

        public PagingRtnData<QaPatListDTO> getTerminalQcScorePatListDTOList(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
        {
            List<object> param = new List<object>();
            param.Add(qryRootNodeDTO);
            param.Add(paginationInfo);
            si.url = url;
            PagingRtnData<QaPatListDTO> rtn = si.invokePaging<QaPatListDTO>("getTerminalQcScorePatListDTOList", param.ToArray());
            return rtn;
        }

    }
}
