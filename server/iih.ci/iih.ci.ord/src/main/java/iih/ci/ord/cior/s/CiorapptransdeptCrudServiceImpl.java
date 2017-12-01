package iih.ci.ord.cior.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.cior.d.desc.OrdApTransDODesc;
import iih.ci.ord.cior.d.OrdApTransDO;
import iih.ci.ord.cior.i.ICiorapptransdeptCudService;
import iih.ci.ord.cior.i.ICiorapptransdeptRService;


/**
 * 医嘱转科申请AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICiorapptransdeptCudService.class,ICiorapptransdeptRService.class}, binding=Binding.JSONRPC)
public class CiorapptransdeptCrudServiceImpl extends BaseDOService<OrdApTransDO> implements ICiorapptransdeptCudService,ICiorapptransdeptRService {

    public CiorapptransdeptCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(OrdApTransDODesc.class),IAppFwTempTbl.tmp_iaw_14.name()); 
    }
}

