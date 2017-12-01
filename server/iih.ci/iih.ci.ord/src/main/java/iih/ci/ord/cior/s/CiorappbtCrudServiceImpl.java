package iih.ci.ord.cior.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import iih.ci.ord.cior.d.OrdApBtDO;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import iih.ci.ord.cior.d.desc.OrdApBtDODesc;
import iih.ci.ord.cior.d.CiorappbtAggDO;
import iih.ci.ord.cior.i.ICiorappbtCudService;
import iih.ci.ord.cior.i.ICiorappbtRService;


/**
 * 备血申请单AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICiorappbtCudService.class,ICiorappbtRService.class}, binding=Binding.JSONRPC)
public class CiorappbtCrudServiceImpl extends BaseAggService<CiorappbtAggDO,OrdApBtDO> implements ICiorappbtCudService,ICiorappbtRService {
    public CiorappbtCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(OrdApBtDODesc.class),IAppFwTempTbl.tmp_iaw_25.name()); 
    }
}
