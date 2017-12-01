using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.mw.core.data;
using iih.ci.mr.d;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.iih.ci.mrqry.mrtplusagerate.i
{
    public interface IMrTplUsageRateService
    {
        PagingRtnData<MrTplUsageRateDTO> GetMrTplUsageRateDTO(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo);
    }
}
