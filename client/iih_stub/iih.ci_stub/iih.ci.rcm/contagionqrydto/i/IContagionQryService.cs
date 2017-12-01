using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.mrqc.qapatlist.d;
using iih.ci.rcm.contagionqrydto.d;
using xap.mw.core.data;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.rcm.contagionqrydto.i
{
    public interface IContagionQryService {
        PagingRtnData<ContagionQryDTO> getContagionQryDTOList(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo);
        ContagionQryDTO[] GetAllPageData();
    }
}
