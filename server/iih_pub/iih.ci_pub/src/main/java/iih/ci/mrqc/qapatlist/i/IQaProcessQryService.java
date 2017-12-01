package iih.ci.mrqc.qapatlist.i;

import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import iih.ci.mrqc.qapatlist.d.QaPatListDTO;
import iih.ci.mrqc.qapatlist.d.QaRecordDTO;

public interface IQaProcessQryService{
	public abstract PagingRtnData<QaPatListDTO> getQaPatListDTOList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo) throws BizException;
	public abstract PagingRtnData<QaPatListDTO> getDeptQcPatListDTOList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo) throws BizException;
	public abstract PagingRtnData<QaPatListDTO> getDeptQcScorePatListDTOList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo) throws BizException;
	public abstract PagingRtnData<QaPatListDTO> getTerminalQcSignOffPatListDTOList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo) throws BizException;
	public abstract PagingRtnData<QaPatListDTO> getTerminalQcPatListDTOList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo) throws BizException;
	public abstract PagingRtnData<QaPatListDTO> getTerminalQcScorePatListDTOList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo) throws BizException;
		
	
}