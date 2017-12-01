package iih.ci.rcm.contagion.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import iih.ci.rcm.contagion.d.ContagionDO;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import iih.ci.rcm.contagion.d.desc.ContagionDODesc;
import iih.ci.rcm.contagion.d.ContagionAggDO;
import iih.ci.rcm.contagion.i.IContagionCudService;
import iih.ci.rcm.contagion.i.IContagionRService;


/**
 * 传染病报告卡AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IContagionCudService.class,IContagionRService.class}, binding=Binding.JSONRPC)
public class ContagionCrudServiceImpl extends BaseAggService<ContagionAggDO,ContagionDO> implements IContagionCudService,IContagionRService {
    public ContagionCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ContagionDODesc.class),IAppFwTempTbl.tmp_iaw_28.name()); 
    }
}
