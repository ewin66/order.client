package iih.ci.ord.ordsrvmm.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.ordsrvmm.d.desc.OrdSrvMmDODesc;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.ordsrvmm.i.IOrdsrvmmCudService;
import iih.ci.ord.ordsrvmm.i.IOrdsrvmmRService;


/**
 * 医嘱服务项目物品AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IOrdsrvmmCudService.class,IOrdsrvmmRService.class}, binding=Binding.JSONRPC)
public class OrdsrvmmCrudServiceImpl extends BaseDOService<OrdSrvMmDO> implements IOrdsrvmmCudService,IOrdsrvmmRService {

    public OrdsrvmmCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(OrdSrvMmDODesc.class),IAppFwTempTbl.tmp_iaw_17.name()); 
    }
}

