using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.mrqc.dto.rfmnotice.d;
using xap.mw.core.data;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mrqc.serviceext.i
{
    public interface IQcNoticeTraceQryService
    {
/*
 整改部分 获取 通知书列表
 */
        //获取环节质控整改通知书列表DTO
        PagingRtnData<QaNoticeDTO> getIntermediateQcCorrectNoticeDtos(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo);
        //获取科室质控整改通知书列表DTO
        PagingRtnData<QaNoticeDTO> getDeptQcCorrectNoticeDtos(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo);
        //获取终末质控整改通知书列表DTO
        PagingRtnData<QaNoticeDTO> getTerminalQcCorrectNoticeDtos(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo);
/*
   追踪部分 dto 分页 查询 
*/
        //获取环节质控追踪通知书列表DTO
        PagingRtnData<QaNoticeDTO> getIntermediateQcTraceDtos(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo);
        //获取科室质控追踪通知书列表DTO
        PagingRtnData<QaNoticeDTO> getDeptQcTraceDtos(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo);
        //获取终末质控追踪通知书列表DTO
        PagingRtnData<QaNoticeDTO> getTerminalQcTraceDtos(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo);

        /*
   超时整改查询
*/

        PagingRtnData<QaNoticeDTO> getDeadApplyQcNoticeDtos(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo);
    }
}
