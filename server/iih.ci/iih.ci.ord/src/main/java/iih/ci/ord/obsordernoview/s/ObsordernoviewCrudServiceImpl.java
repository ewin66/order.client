package iih.ci.ord.obsordernoview.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.obsordernoview.d.desc.ObsOrderNoViewDesc;
import iih.ci.ord.obsordernoview.d.ObsOrderNoView;
import iih.ci.ord.obsordernoview.i.IObsordernoviewCudService;
import iih.ci.ord.obsordernoview.i.IObsordernoviewRService;


/**
 * 检查申请单号AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IObsordernoviewCudService.class,IObsordernoviewRService.class}, binding=Binding.JSONRPC)
public class ObsordernoviewCrudServiceImpl extends BaseDOService<ObsOrderNoView> implements IObsordernoviewCudService,IObsordernoviewRService {

    public ObsordernoviewCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ObsOrderNoViewDesc.class),IAppFwTempTbl.tmp_iaw_21.name()); 
    }
}

