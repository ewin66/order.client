package iih.ci.ord.cior.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import iih.ci.ord.cior.d.OrdApConsDO;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import iih.ci.ord.cior.d.desc.OrdApConsDODesc;
import iih.ci.ord.cior.d.CiorappconsultAggDO;
import iih.ci.ord.cior.i.ICiorappconsultCudService;
import iih.ci.ord.cior.i.ICiorappconsultRService;


/**
 * 会诊申请单AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICiorappconsultCudService.class,ICiorappconsultRService.class}, binding=Binding.JSONRPC)
public class CiorappconsultCrudServiceImpl extends BaseAggService<CiorappconsultAggDO,OrdApConsDO> implements ICiorappconsultCudService,ICiorappconsultRService {
    public CiorappconsultCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(OrdApConsDODesc.class),IAppFwTempTbl.tmp_iaw_21.name()); 
    }
}
