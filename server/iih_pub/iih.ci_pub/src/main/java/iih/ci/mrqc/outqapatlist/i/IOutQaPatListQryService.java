package iih.ci.mrqc.outqapatlist.i;

import iih.ci.mrqc.outqapatlist.d.OutQaPatListDTO;
import iih.ci.mrqc.qrydto.d.OutQaPatQryDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public interface IOutQaPatListQryService {
    /**
	*  获取门诊质控患者列表
	*/
    public abstract  PagingRtnData<OutQaPatListDTO> getOutQaPatListDtos(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo) throws BizException;

    /**
	*  获取门诊抽查患者列表
	*/
    public abstract  PagingRtnData<OutQaPatListDTO> getOutQaToRandomPatListDtos(OutQaPatQryDTO qryDTO,PaginationInfo paginationInfo) throws BizException;
    /**
	*  获取门诊抽查患者列表
	*/
    public abstract  PagingRtnData<OutQaPatListDTO> getOutQaHasRandomPatListDtos(OutQaPatQryDTO qryDTO,PaginationInfo paginationInfo) throws BizException;
    /**
	*  获取门诊抽查患者列表
	*/
    public abstract  PagingRtnData<OutQaPatListDTO> getOutQaTracePatListDtos(OutQaPatQryDTO qryDTO,PaginationInfo paginationInfo) throws BizException;
}
