package iih.ci.mr.i;

import iih.ci.mr.d.MrTplUsageRateDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public interface IMrTplUsageRateService {

	public abstract PagingRtnData<MrTplUsageRateDTO> getMrTplUsageRateDTO(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo) throws BizException;
}
