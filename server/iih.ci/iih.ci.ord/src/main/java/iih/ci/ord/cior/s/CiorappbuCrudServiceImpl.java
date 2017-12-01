package iih.ci.ord.cior.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.cior.d.desc.OrdAppBtUseDODesc;
import iih.ci.ord.cior.d.OrdAppBtUseDO;
import iih.ci.ord.cior.i.ICiorappbuCudService;
import iih.ci.ord.cior.i.ICiorappbuRService;


/**
 * 医嘱用血申请AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICiorappbuCudService.class,ICiorappbuRService.class}, binding=Binding.JSONRPC)
public class CiorappbuCrudServiceImpl extends BaseDOService<OrdAppBtUseDO> implements ICiorappbuCudService,ICiorappbuRService {
    public CiorappbuCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(OrdAppBtUseDODesc.class),IAppFwTempTbl.tmp_iaw_05.name()); 
    }
}
