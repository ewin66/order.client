package iih.ci.ord.cior.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.cior.d.desc.OrdApLabDODesc;
import iih.ci.ord.cior.d.OrdApLabDO;
import iih.ci.ord.cior.i.ICiorapplisCudService;
import iih.ci.ord.cior.i.ICiorapplisRService;


/**
 * 医嘱检验申请AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICiorapplisCudService.class,ICiorapplisRService.class}, binding=Binding.JSONRPC)
public class CiorapplisCrudServiceImpl extends BaseDOService<OrdApLabDO> implements ICiorapplisCudService,ICiorapplisRService {
    public CiorapplisCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(OrdApLabDODesc.class),IAppFwTempTbl.tmp_iaw_12.name()); 
    }
}
