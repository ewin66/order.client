package iih.ci.ord.ciorcof.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.ciorcof.d.desc.CiOrSrvVsSheetDesc;
import iih.ci.ord.ciorcof.d.CiOrSrvVsSheet;
import iih.ci.ord.ciorcof.i.ISrvvssheetCudService;
import iih.ci.ord.ciorcof.i.ISrvvssheetRService;


/**
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ISrvvssheetCudService.class,ISrvvssheetRService.class}, binding=Binding.JSONRPC)
public class SrvvssheetCrudServiceImpl extends BaseDOService<CiOrSrvVsSheet> implements ISrvvssheetCudService,ISrvvssheetRService {

    public SrvvssheetCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiOrSrvVsSheetDesc.class),IAppFwTempTbl.tmp_iaw_20.name()); 
    }
}

