using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.mrqc.dto.rfmnotice.d;
using iih.ci.mrqc.serviceext.i;
using xap.mw.core.data;
using xap.mw.serviceframework;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mrqc.serviceext.i
{
    class IQcNoticeTraceQryServiceImpl : IQcNoticeTraceQryService
    {
        private string url = XapSvrConfig.BaseUrl + "iih.ci.mrqc/iih.ci.mrqc.serviceext.i.IQcNoticeTraceQryService";
        private ServiceInvocation si;

        public IQcNoticeTraceQryServiceImpl()
        {
            si = new ServiceInvocationImpl();
            si.url = url;
        }
        /*
         整改部分 获取 通知书列表
 */

        //获取环节整改DTO
        public PagingRtnData<QaNoticeDTO> getIntermediateQcCorrectNoticeDtos(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
        {
            List<object> param = new List<object>();
            param.Add(qryRootNodeDTO);
            param.Add(paginationInfo);
            si.url = url;
            PagingRtnData<QaNoticeDTO> rtn = si.invokePaging<QaNoticeDTO>("getIntermediateQcCorrectNoticeDtos", param.ToArray());
            return rtn;
        }
        //获取科室整改DTO
        public PagingRtnData<QaNoticeDTO> getDeptQcCorrectNoticeDtos(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
        {
            List<object> param = new List<object>();
            param.Add(qryRootNodeDTO);
            param.Add(paginationInfo);
            si.url = url;
            PagingRtnData<QaNoticeDTO> rtn = si.invokePaging<QaNoticeDTO>("getDeptQcCorrectNoticeDtos", param.ToArray());
            return rtn;
        }
        //获取终末整改DTO
        public PagingRtnData<QaNoticeDTO> getTerminalQcCorrectNoticeDtos(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
        {
            List<object> param = new List<object>();
            param.Add(qryRootNodeDTO);
            param.Add(paginationInfo);
            si.url = url;
            PagingRtnData<QaNoticeDTO> rtn = si.invokePaging<QaNoticeDTO>("getTerminalQcCorrectNoticeDtos", param.ToArray());
            return rtn;
        }

        /*
   追踪部分 dto 分页 查询 
*/
        //获取环节质控追踪通知书列表DTO
        public PagingRtnData<QaNoticeDTO> getIntermediateQcTraceDtos(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
        {
            List<object> param = new List<object>();
            param.Add(qryRootNodeDTO);
            param.Add(paginationInfo);
            si.url = url;
            PagingRtnData<QaNoticeDTO> rtn = si.invokePaging<QaNoticeDTO>("getIntermediateQcTraceDtos", param.ToArray());
            return rtn;
        }
        //获取科室质控追踪通知书列表DTO
        public PagingRtnData<QaNoticeDTO> getDeptQcTraceDtos(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
        {
            List<object> param = new List<object>();
            param.Add(qryRootNodeDTO);
            param.Add(paginationInfo);
            si.url = url;
            PagingRtnData<QaNoticeDTO> rtn = si.invokePaging<QaNoticeDTO>("getDeptQcTraceDtos", param.ToArray());
            return rtn;
        }
        //获取终末质控追踪通知书列表DTO
        public PagingRtnData<QaNoticeDTO> getTerminalQcTraceDtos(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
        {
            List<object> param = new List<object>();
            param.Add(qryRootNodeDTO);
            param.Add(paginationInfo);
            si.url = url;
            PagingRtnData<QaNoticeDTO> rtn = si.invokePaging<QaNoticeDTO>("getTerminalQcTraceDtos", param.ToArray());
            return rtn;
        }
        //超时整改申请
        public PagingRtnData<QaNoticeDTO> getDeadApplyQcNoticeDtos(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
        {
            List<object> param = new List<object>();
            param.Add(qryRootNodeDTO);
            param.Add(paginationInfo);
            si.url = url;
            PagingRtnData<QaNoticeDTO> rtn = si.invokePaging<QaNoticeDTO>("getDeadApplyQcNoticeDtos", param.ToArray());
            return rtn;
        }
    }
}
