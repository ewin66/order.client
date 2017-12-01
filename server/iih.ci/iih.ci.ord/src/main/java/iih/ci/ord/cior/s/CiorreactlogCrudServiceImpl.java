package iih.ci.ord.cior.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.cior.d.desc.CiOrReactLogDODesc;
import iih.ci.ord.cior.d.CiOrReactLogDO;
import iih.ci.ord.cior.i.ICiorreactlogCudService;
import iih.ci.ord.cior.i.ICiorreactlogRService;


/**
 * 医嘱互斥日志记录AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICiorreactlogCudService.class,ICiorreactlogRService.class}, binding=Binding.JSONRPC)
public class CiorreactlogCrudServiceImpl extends BaseDOService<CiOrReactLogDO> implements ICiorreactlogCudService,ICiorreactlogRService {

    public CiorreactlogCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiOrReactLogDODesc.class),IAppFwTempTbl.tmp_iaw_01.name()); 
    }
}

