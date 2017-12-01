package iih.ci.ord.ciorder.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import iih.ci.ord.ciorder.d.CiOrderDO;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import iih.ci.ord.ciorder.d.desc.CiOrderDODesc;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.i.ICiorderCudService;
import iih.ci.ord.ciorder.i.ICiorderRService;


/**
 * 临床医嘱AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICiorderCudService.class,ICiorderRService.class}, binding=Binding.JSONRPC)
public class CiorderCrudServiceImpl extends BaseAggService<CiorderAggDO,CiOrderDO> implements ICiorderCudService,ICiorderRService {
    public CiorderCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiOrderDODesc.class),IAppFwTempTbl.tmp_iaw_25.name()); 
    }
}
