package iih.ci.rcm.contagionrecordop.i;

import iih.ci.rcm.contagionrecordop.d.ContagionRecordOpDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public interface IContagionRecordQryService {
	public abstract PagingRtnData<ContagionRecordOpDTO> getOpContagionQryDTOList(
			QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
			throws BizException;

	public abstract ContagionRecordOpDTO[] getAllPageData() throws BizException;
}
