package iih.ci.ord.pres.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.pres.d.desc.CiPresDODesc;
import iih.ci.ord.pres.d.CiPresDO;
import iih.ci.ord.pres.i.IPresCudService;
import iih.ci.ord.pres.i.IPresRService;


/**
 * 药品处方AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IPresCudService.class,IPresRService.class}, binding=Binding.JSONRPC)
public class PresCrudServiceImpl extends BaseDOService<CiPresDO> implements IPresCudService,IPresRService {
    public PresCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiPresDODesc.class),IAppFwTempTbl.tmp_iaw_12.name()); 
    }
}
