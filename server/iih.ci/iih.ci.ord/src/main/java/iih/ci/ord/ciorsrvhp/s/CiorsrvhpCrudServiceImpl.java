package iih.ci.ord.ciorsrvhp.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.ciorsrvhp.d.desc.CiOrSrvHpDODesc;
import iih.ci.ord.ciorsrvhp.d.CiOrSrvHpDO;
import iih.ci.ord.ciorsrvhp.i.ICiorsrvhpCudService;
import iih.ci.ord.ciorsrvhp.i.ICiorsrvhpRService;


/**
 * 医嘱项目的医保信息AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICiorsrvhpCudService.class,ICiorsrvhpRService.class}, binding=Binding.JSONRPC)
public class CiorsrvhpCrudServiceImpl extends BaseDOService<CiOrSrvHpDO> implements ICiorsrvhpCudService,ICiorsrvhpRService {
    public CiorsrvhpCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiOrSrvHpDODesc.class),IAppFwTempTbl.tmp_iaw_12.name()); 
    }
}
