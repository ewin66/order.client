using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.mrqc.qapatlist.d;
using xap.mw.core.data;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.iih.ci.mrqc.qarecorddto.i
{
    public interface IQaProcessRecordQryService
    {
        PagingRtnData<QaRecordDTO> getIntermediateqcQryRecordList(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo);
        PagingRtnData<QaRecordDTO> getDeptqcQryRecordList(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo);
        PagingRtnData<QaRecordDTO> getTerminalqcQryRecordList(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo);
    }
}
