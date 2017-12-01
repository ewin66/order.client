package iih.ci.ord.cior.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import iih.ci.ord.cior.d.OrdApOpDO;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import iih.ci.ord.cior.d.desc.OrdApOpDODesc;
import iih.ci.ord.cior.d.CiorappsurgeryAggDO;
import iih.ci.ord.cior.i.ICiorappsurgeryCudService;
import iih.ci.ord.cior.i.ICiorappsurgeryRService;


/**
 * 手术申请AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICiorappsurgeryCudService.class,ICiorappsurgeryRService.class}, binding=Binding.JSONRPC)
public class CiorappsurgeryCrudServiceImpl extends BaseAggService<CiorappsurgeryAggDO,OrdApOpDO> implements ICiorappsurgeryCudService,ICiorappsurgeryRService {
    public CiorappsurgeryCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(OrdApOpDODesc.class),IAppFwTempTbl.tmp_iaw_10.name()); 
    }
}
