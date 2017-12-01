package iih.ci.ord.cior.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.cior.d.desc.OrdApOutDODesc;
import iih.ci.ord.cior.d.OrdApOutDO;
import iih.ci.ord.cior.i.ICiorappouthospCudService;
import iih.ci.ord.cior.i.ICiorappouthospRService;


/**
 * 医嘱出院申请AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICiorappouthospCudService.class,ICiorappouthospRService.class}, binding=Binding.JSONRPC)
public class CiorappouthospCrudServiceImpl extends BaseDOService<OrdApOutDO> implements ICiorappouthospCudService,ICiorappouthospRService {

    public CiorappouthospCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(OrdApOutDODesc.class),IAppFwTempTbl.tmp_iaw_21.name()); 
    }
}

