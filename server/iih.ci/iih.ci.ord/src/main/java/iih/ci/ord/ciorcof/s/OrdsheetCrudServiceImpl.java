package iih.ci.ord.ciorcof.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.ciorcof.d.desc.CiOrdSheetDesc;
import iih.ci.ord.ciorcof.d.CiOrdSheet;
import iih.ci.ord.ciorcof.i.IOrdsheetCudService;
import iih.ci.ord.ciorcof.i.IOrdsheetRService;


/**
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IOrdsheetCudService.class,IOrdsheetRService.class}, binding=Binding.JSONRPC)
public class OrdsheetCrudServiceImpl extends BaseDOService<CiOrdSheet> implements IOrdsheetCudService,IOrdsheetRService {

    public OrdsheetCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiOrdSheetDesc.class),IAppFwTempTbl.tmp_iaw_16.name()); 
    }
}

