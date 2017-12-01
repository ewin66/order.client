package iih.ci.ord.consrpt.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.consrpt.d.desc.CiOrdConsRptDODesc;
import iih.ci.ord.consrpt.d.CiOrdConsRptDO;
import iih.ci.ord.consrpt.i.IConsrptCudService;
import iih.ci.ord.consrpt.i.IConsrptRService;


/**
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IConsrptCudService.class,IConsrptRService.class}, binding=Binding.JSONRPC)
public class ConsrptCrudServiceImpl extends BaseDOService<CiOrdConsRptDO> implements IConsrptCudService,IConsrptRService {

    public ConsrptCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiOrdConsRptDODesc.class),IAppFwTempTbl.tmp_iaw_15.name()); 
    }

	@Override
	public CiOrdConsRptDO[] findByAttrValString(String attr, String value,
			FBoolean isIncludeNullReturn) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CiOrdConsRptDO[] findByAttrValStrings(String attr, String[] values,
			FBoolean isIncludeNullReturn) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CiOrdConsRptDO[] findByAttrValList(String attr, FArrayList values,
			FBoolean isIncludeNullReturn) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}
}

