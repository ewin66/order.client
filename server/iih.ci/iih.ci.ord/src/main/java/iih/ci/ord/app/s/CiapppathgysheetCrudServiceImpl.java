package iih.ci.ord.app.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import iih.ci.ord.app.d.CiAppPathgySheetDO;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import iih.ci.ord.app.d.desc.CiAppPathgySheetDODesc;
import iih.ci.ord.app.d.CiapppathgysheetAggDO;
import iih.ci.ord.app.i.ICiapppathgysheetCudService;
import iih.ci.ord.app.i.ICiapppathgysheetRService;


/**
 * 病理打印申请单AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICiapppathgysheetCudService.class,ICiapppathgysheetRService.class}, binding=Binding.JSONRPC)
public class CiapppathgysheetCrudServiceImpl extends BaseAggService<CiapppathgysheetAggDO,CiAppPathgySheetDO> implements ICiapppathgysheetCudService,ICiapppathgysheetRService {
    public CiapppathgysheetCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiAppPathgySheetDODesc.class),IAppFwTempTbl.tmp_iaw_18.name()); 
    }
}
