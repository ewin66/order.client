package iih.ci.ord.ordprn.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.ordprn.d.desc.OrdPrintCfgDODesc;
import iih.ci.ord.ordprn.d.OrdPrintCfgDO;
import iih.ci.ord.ordprn.i.IOrdprintcfgCudService;
import iih.ci.ord.ordprn.i.IOrdprintcfgRService;


/**
 * 医嘱打印配置AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IOrdprintcfgCudService.class,IOrdprintcfgRService.class}, binding=Binding.JSONRPC)
public class OrdprintcfgCrudServiceImpl extends BaseDOService<OrdPrintCfgDO> implements IOrdprintcfgCudService,IOrdprintcfgRService {
    public OrdprintcfgCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(OrdPrintCfgDODesc.class),IAppFwTempTbl.tmp_iaw_28.name()); 
    }
}

