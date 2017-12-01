using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.mrqc.outqapatlist.d;
using iih.ci.mrqc.qrydto.d;
using xap.mw.core.data;
using xap.mw.serviceframework;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.iih.ci.mrqc.outqapatlist.i
{
    class IOutQaPatListQryServiceImpl : IOutQaPatListQryService
    {
        private string url = XapSvrConfig.BaseUrl + "iih.ci.mrqc/iih.ci.mrqc.outqapatlist.i.IOutQaPatListQryService";
        private ServiceInvocation si;

        public IOutQaPatListQryServiceImpl()
        {
            si = new ServiceInvocationImpl();
            si.url = url;
        }
        public PagingRtnData<OutQaPatListDTO> getOutQaPatListDtos(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
        {
            List<object> param = new List<object>();
            param.Add(qryRootNodeDTO);
            param.Add(paginationInfo);
            si.url = url;
            PagingRtnData<OutQaPatListDTO> rtn = si.invokePaging<OutQaPatListDTO>("getOutQaPatListDtos", param.ToArray());
            return rtn;
        }

        public PagingRtnData<OutQaPatListDTO> getOutQaToRandomPatListDtos(OutQaPatQryDTO qryDTO, PaginationInfo paginationInfo)
        {
            List<object> param = new List<object>();
            param.Add(qryDTO);
            param.Add(paginationInfo);
            si.url = url;
            PagingRtnData<OutQaPatListDTO> rtn = si.invokePaging<OutQaPatListDTO>("getOutQaToRandomPatListDtos", param.ToArray());
            return rtn;
        }

        public PagingRtnData<OutQaPatListDTO> getOutQaHasRandomPatListDtos(OutQaPatQryDTO qryDTO, PaginationInfo paginationInfo)
        {
            List<object> param = new List<object>();
            param.Add(qryDTO);
            param.Add(paginationInfo);
            si.url = url;
            PagingRtnData<OutQaPatListDTO> rtn = si.invokePaging<OutQaPatListDTO>("getOutQaHasRandomPatListDtos", param.ToArray());
            return rtn;
        }

        public PagingRtnData<OutQaPatListDTO> getOutQaTracePatListDtos(OutQaPatQryDTO qryDTO, PaginationInfo paginationInfo)
        {
            List<object> param = new List<object>();
            param.Add(qryDTO);
            param.Add(paginationInfo);
            si.url = url;
            PagingRtnData<OutQaPatListDTO> rtn = si.invokePaging<OutQaPatListDTO>("getOutQaTracePatListDtos", param.ToArray());
            return rtn;
        }
    }
}
