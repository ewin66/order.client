package iih.ci.mrqc.cimrrecallresultdto.i;

import iih.ci.mrqc.cimrrecallresultdto.d.CiMrRecallResultDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public interface ICiMrRecallResultService {
	
	 PagingRtnData<CiMrRecallResultDTO> getCiMrRecallResults(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo) throws BizException;
	 
	 PagingRtnData<CiMrRecallResultDTO> getCiMrRecallResults4MySelf(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo) throws BizException;
}
