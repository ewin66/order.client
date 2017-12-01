using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography.X509Certificates;
using System.Text;
using iih.ci.mrqc.qapatlist.d;
using xap.mw.core.data;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mrqc.qapatlist.i
{
    public interface IMrManagePatQryService
    {
        //病案待签收
        PagingRtnData<QaPatListDTO> getMrNeedSignOffPatList(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo);
        //病案待编目
        PagingRtnData<QaPatListDTO> getMrNeedCataloguePatList(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo);
        //待归档
        PagingRtnData<QaPatListDTO> getMrNeedPigeonholePatList(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo);
        //待归档
        PagingRtnData<QaPatListDTO> getMrHasPigeonholedPatList(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo);
        //返修列表
        PagingRtnData<QaPatListDTO> getMrNeedRepairPatList(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo);
        //病案检索列表
        PagingRtnData<QaPatListDTO> getMrRetrievalPatList(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo);
        //定时执行更新状态
        void TimingExecutionToUpdateAmrBorrowApply();
    }
}
