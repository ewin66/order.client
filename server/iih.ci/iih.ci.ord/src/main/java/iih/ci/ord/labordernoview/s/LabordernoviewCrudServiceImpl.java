package iih.ci.ord.labordernoview.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.labordernoview.d.desc.LabOrderNoViewDesc;
import iih.ci.ord.labordernoview.d.LabOrderNoView;
import iih.ci.ord.labordernoview.i.ILabordernoviewCudService;
import iih.ci.ord.labordernoview.i.ILabordernoviewRService;


/**
 * 检验申请单号AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ILabordernoviewCudService.class,ILabordernoviewRService.class}, binding=Binding.JSONRPC)
public class LabordernoviewCrudServiceImpl extends BaseDOService<LabOrderNoView> implements ILabordernoviewCudService,ILabordernoviewRService {

    public LabordernoviewCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(LabOrderNoViewDesc.class),IAppFwTempTbl.tmp_iaw_04.name()); 
    }
}

