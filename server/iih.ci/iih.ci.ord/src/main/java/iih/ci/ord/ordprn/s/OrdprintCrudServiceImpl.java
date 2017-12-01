package iih.ci.ord.ordprn.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.ordprn.d.desc.OrdPrintDODesc;
import iih.ci.ord.ordprn.d.OrdPrintDO;
import iih.ci.ord.ordprn.i.IOrdprintCudService;
import iih.ci.ord.ordprn.i.IOrdprintRService;


/**
 * 医嘱打印AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IOrdprintCudService.class,IOrdprintRService.class}, binding=Binding.JSONRPC)
public class OrdprintCrudServiceImpl extends BaseDOService<OrdPrintDO> implements IOrdprintCudService,IOrdprintRService {
    public OrdprintCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(OrdPrintDODesc.class),IAppFwTempTbl.tmp_iaw_07.name()); 
    }
}
