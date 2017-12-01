package iih.ci.mrqc.serviceext.i;

import iih.ci.mrqc.dto.rfmnotice.d.QaNoticeDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public interface IQcNoticeTraceQryService {

	
	    /**
		*  获取环节整改DTO列表
		*/
	    public abstract  PagingRtnData<QaNoticeDTO> getIntermediateQcCorrectNoticeDtos(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo) throws BizException;
	    /**
	   	*  获取科室整改DTO
	   	*/
	    public abstract  PagingRtnData<QaNoticeDTO> getDeptQcCorrectNoticeDtos(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo) throws BizException;
	     /**
	     *  获取终末整改DTO
	     */
	    public abstract  PagingRtnData<QaNoticeDTO> getTerminalQcCorrectNoticeDtos(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo) throws BizException;
	       
	   /**
	   *  获取环节质控追踪通知书列表DTO
	   */
	    public abstract  PagingRtnData<QaNoticeDTO> getIntermediateQcTraceDtos(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo) throws BizException;
	    /**
	   	*  获取部门质控追踪通知书列表DTO
	   	*/
	    public abstract  PagingRtnData<QaNoticeDTO> getDeptQcTraceDtos(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo) throws BizException;
	    /**
	   	*  获取终末质控追踪通知书列表DTO
	   	*/
	    public abstract  PagingRtnData<QaNoticeDTO> getTerminalQcTraceDtos(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo) throws BizException;
	    /**
	   	*  获取超时整改申请列表
	   	*/
	    public abstract  PagingRtnData<QaNoticeDTO> getDeadApplyQcNoticeDtos(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo) throws BizException;
	   
}
