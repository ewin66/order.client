package iih.ci.ord.cior.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import iih.ci.ord.cior.d.desc.OrdApRptOpDODesc;
import iih.ci.ord.cior.d.OrdApRptOpDO;
import iih.ci.ord.cior.d.OrdrptopAggDO;
import iih.ci.ord.cior.i.IOrdrptopCudService;
import iih.ci.ord.cior.i.IOrdrptopRService;


/**
 * 医嘱手术记录AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IOrdrptopCudService.class,IOrdrptopRService.class}, binding=Binding.JSONRPC)
public class OrdrptopCrudServiceImpl extends BaseAggService<OrdrptopAggDO,OrdApRptOpDO> implements IOrdrptopCudService,IOrdrptopRService {

    public OrdrptopCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(OrdApRptOpDODesc.class),IAppFwTempTbl.tmp_iaw_17.name()); 
    }
}

