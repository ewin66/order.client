using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.mrqc.qapatlist.d;
using xap.mw.core.data;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mrqc.qapatlist.i {
    public interface IQaProcessQryService {
        PagingRtnData<QaPatListDTO> getQaPatListDTOList(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo);
        PagingRtnData<QaPatListDTO> getDeptQcPatListDTOList(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo);
        PagingRtnData<QaPatListDTO> getDeptQcScorePatListDTOList(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo);

        PagingRtnData<QaPatListDTO> getTerminalQcSignOffPatListDTOList(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo);
        PagingRtnData<QaPatListDTO> getTerminalQcPatListDTOList(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo);
        PagingRtnData<QaPatListDTO> getTerminalQcScorePatListDTOList(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo);

    }
}
