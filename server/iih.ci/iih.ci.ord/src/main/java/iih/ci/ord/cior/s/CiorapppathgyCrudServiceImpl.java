package iih.ci.ord.cior.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import iih.ci.ord.cior.d.OrdApPathgyDO;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import iih.ci.ord.cior.d.desc.OrdApPathgyDODesc;
import iih.ci.ord.cior.d.CiorapppathgyAggDO;
import iih.ci.ord.cior.i.ICiorapppathgyCudService;
import iih.ci.ord.cior.i.ICiorapppathgyRService;


/**
 * 病理申请单AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICiorapppathgyCudService.class,ICiorapppathgyRService.class}, binding=Binding.JSONRPC)
public class CiorapppathgyCrudServiceImpl extends BaseAggService<CiorapppathgyAggDO,OrdApPathgyDO> implements ICiorapppathgyCudService,ICiorapppathgyRService {
    public CiorapppathgyCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(OrdApPathgyDODesc.class),IAppFwTempTbl.tmp_iaw_23.name()); 
    }
}
