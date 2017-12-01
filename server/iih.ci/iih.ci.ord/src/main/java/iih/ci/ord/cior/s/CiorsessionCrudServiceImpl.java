package iih.ci.ord.cior.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.cior.d.desc.CiOrSessionDODesc;
import iih.ci.ord.cior.d.CiOrSessionDO;
import iih.ci.ord.cior.i.ICiorsessionCudService;
import iih.ci.ord.cior.i.ICiorsessionRService;


/**
 * 门诊医嘱开立区间AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICiorsessionCudService.class,ICiorsessionRService.class}, binding=Binding.JSONRPC)
public class CiorsessionCrudServiceImpl extends BaseDOService<CiOrSessionDO> implements ICiorsessionCudService,ICiorsessionRService {

    public CiorsessionCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiOrSessionDODesc.class),IAppFwTempTbl.tmp_iaw_21.name()); 
    }
}

