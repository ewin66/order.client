package iih.ci.ord.ciprn.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import iih.ci.ord.ciprn.d.CiPrnDO;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import iih.ci.ord.ciprn.d.desc.CiPrnDODesc;
import iih.ci.ord.ciprn.d.CiprintAggDO;
import iih.ci.ord.ciprn.i.ICiprintCudService;
import iih.ci.ord.ciprn.i.ICiprintRService;


/**
 * 临床打印单AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICiprintCudService.class,ICiprintRService.class}, binding=Binding.JSONRPC)
public class CiprintCrudServiceImpl extends BaseAggService<CiprintAggDO,CiPrnDO> implements ICiprintCudService,ICiprintRService {
    public CiprintCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiPrnDODesc.class),IAppFwTempTbl.tmp_iaw_08.name()); 
    }
}
