package iih.ci.ord.app.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import iih.ci.ord.app.d.CiAppLisSheetDO;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import iih.ci.ord.app.d.desc.CiAppLisSheetDODesc;
import iih.ci.ord.app.d.CiapplissheetAggDO;
import iih.ci.ord.app.i.ICiapplissheetCudService;
import iih.ci.ord.app.i.ICiapplissheetRService;


/**
 * 检验申请单AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICiapplissheetCudService.class,ICiapplissheetRService.class}, binding=Binding.JSONRPC)
public class CiapplissheetCrudServiceImpl extends BaseAggService<CiapplissheetAggDO,CiAppLisSheetDO> implements ICiapplissheetCudService,ICiapplissheetRService {
    public CiapplissheetCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiAppLisSheetDODesc.class),IAppFwTempTbl.tmp_iaw_03.name()); 
    }
}
