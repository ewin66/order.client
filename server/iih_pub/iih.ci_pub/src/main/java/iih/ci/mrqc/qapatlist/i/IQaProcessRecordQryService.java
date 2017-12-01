package iih.ci.mrqc.qapatlist.i;

import iih.ci.mrqc.qapatlist.d.QaRecordDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public interface IQaProcessRecordQryService {
	
	public abstract PagingRtnData<QaRecordDTO> getIntermediateqcQryRecordList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo) throws BizException;
	public abstract PagingRtnData<QaRecordDTO> getDeptqcQryRecordList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo) throws BizException;
	public abstract PagingRtnData<QaRecordDTO> getTerminalqcQryRecordList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo) throws BizException;
}
