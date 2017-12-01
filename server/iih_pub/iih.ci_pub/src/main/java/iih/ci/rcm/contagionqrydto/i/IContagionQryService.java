package iih.ci.rcm.contagionqrydto.i;

import iih.ci.rcm.contagionqrydto.d.ContagionQryDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public interface IContagionQryService {
	public abstract PagingRtnData<ContagionQryDTO> getContagionQryDTOList(
			QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
			throws BizException;

	public abstract ContagionQryDTO[] getAllPageData() throws BizException;
}
