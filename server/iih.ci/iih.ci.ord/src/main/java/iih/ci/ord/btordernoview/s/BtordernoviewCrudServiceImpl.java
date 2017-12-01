package iih.ci.ord.btordernoview.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.btordernoview.d.desc.BtOrderNoViewDesc;
import iih.ci.ord.btordernoview.d.BtOrderNoView;
import iih.ci.ord.btordernoview.i.IBtordernoviewCudService;
import iih.ci.ord.btordernoview.i.IBtordernoviewRService;


/**
 * 交叉备血申请单号AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBtordernoviewCudService.class,IBtordernoviewRService.class}, binding=Binding.JSONRPC)
public class BtordernoviewCrudServiceImpl extends BaseDOService<BtOrderNoView> implements IBtordernoviewCudService,IBtordernoviewRService {

    public BtordernoviewCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BtOrderNoViewDesc.class),IAppFwTempTbl.tmp_iaw_03.name()); 
    }
}

