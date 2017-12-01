package iih.ci.ord.ordmp.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.ordmp.d.desc.CimpDODesc;
import iih.ci.ord.ordmp.d.CimpDO;
import iih.ci.ord.ordmp.i.IOrdmpCudService;
import iih.ci.ord.ordmp.i.IOrdmpRService;


/**
 * 医嘱关键执行事件及状态AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IOrdmpCudService.class,IOrdmpRService.class}, binding=Binding.JSONRPC)
public class OrdmpCrudServiceImpl extends BaseDOService<CimpDO> implements IOrdmpCudService,IOrdmpRService {

    public OrdmpCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CimpDODesc.class),IAppFwTempTbl.tmp_iaw_19.name()); 
    }
}

