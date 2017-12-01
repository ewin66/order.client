package iih.ci.ord.ordsrvset.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.ordsrvset.d.desc.OrdSrvSetDODesc;
import iih.ci.ord.ordsrvset.d.OrdSrvSetDO;
import iih.ci.ord.ordsrvset.i.IOrdsrvsetCudService;
import iih.ci.ord.ordsrvset.i.IOrdsrvsetRService;


/**
 * 医嘱服务服务套AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IOrdsrvsetCudService.class,IOrdsrvsetRService.class}, binding=Binding.JSONRPC)
public class OrdsrvsetCrudServiceImpl extends BaseDOService<OrdSrvSetDO> implements IOrdsrvsetCudService,IOrdsrvsetRService {

    public OrdsrvsetCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(OrdSrvSetDODesc.class),IAppFwTempTbl.tmp_iaw_13.name()); 
    }
}

