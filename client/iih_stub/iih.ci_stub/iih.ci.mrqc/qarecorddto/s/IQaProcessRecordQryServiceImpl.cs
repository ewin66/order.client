using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.iih.ci.mrqc.qarecorddto.i;
using iih.ci.mrqc.qapatlist.d;
using xap.mw.core.data;
using xap.mw.serviceframework;
using xap.rui.appfw;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.iih.ci.mrqc.qarecorddto.i
{
    class IQaProcessRecordQryServiceImpl : IQaProcessRecordQryService
    {
        private string url = XapSvrConfig.BaseUrl + "iihci.mrqc/iih.ci.mrqc.qapatlist.i.IQaProcessRecordQryService";//ConfigUtil.getServiceUrl();

        private ServiceInvocation si;
        private CacheHelper<QaRecordDTO> ch;
        /// <summary>
        /// 构造函数
        /// </summary>
        public IQaProcessRecordQryServiceImpl()
        {
            ch = new CacheHelper<QaRecordDTO>();
            si = new ServiceInvocationImpl();
            si.url = url;
        }

        public PagingRtnData<QaRecordDTO> getIntermediateqcQryRecordList(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
        {
            List<object> param = new List<object>();
            param.Add(qryRootNodeDTO);
            param.Add(paginationInfo);
            si.url = url;
            PagingRtnData<QaRecordDTO> rtn = si.invokePaging<QaRecordDTO>("getIntermediateqcQryRecordList", param.ToArray());
            return rtn;
        }

        public PagingRtnData<QaRecordDTO> getDeptqcQryRecordList(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
        {
            List<object> param = new List<object>();
            param.Add(qryRootNodeDTO);
            param.Add(paginationInfo);
            si.url = url;
            PagingRtnData<QaRecordDTO> rtn = si.invokePaging<QaRecordDTO>("getDeptqcQryRecordList", param.ToArray());
            return rtn;
        }

        public PagingRtnData<QaRecordDTO> getTerminalqcQryRecordList(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
        {
            List<object> param = new List<object>();
            param.Add(qryRootNodeDTO);
            param.Add(paginationInfo);
            si.url = url;
            PagingRtnData<QaRecordDTO> rtn = si.invokePaging<QaRecordDTO>("getTerminalqcQryRecordList", param.ToArray());
            return rtn;
        }
    }
}
