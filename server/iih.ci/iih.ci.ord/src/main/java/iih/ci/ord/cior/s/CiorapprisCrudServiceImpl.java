package iih.ci.ord.cior.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.cior.d.desc.OrdApObsDODesc;
import iih.ci.ord.cior.d.OrdApObsDO;
import iih.ci.ord.cior.i.ICiorapprisCudService;
import iih.ci.ord.cior.i.ICiorapprisRService;


/**
 * 医嘱检查申请单AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICiorapprisCudService.class,ICiorapprisRService.class}, binding=Binding.JSONRPC)
public class CiorapprisCrudServiceImpl extends BaseDOService<OrdApObsDO> implements ICiorapprisCudService,ICiorapprisRService {
    public CiorapprisCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(OrdApObsDODesc.class),IAppFwTempTbl.tmp_iaw_03.name()); 
    }
}
