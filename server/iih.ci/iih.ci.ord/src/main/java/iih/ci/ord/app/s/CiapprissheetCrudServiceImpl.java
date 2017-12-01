package iih.ci.ord.app.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.app.d.desc.CiAppRisSheetDODesc;
import iih.ci.ord.app.d.CiAppRisSheetDO;
import iih.ci.ord.app.i.ICiapprissheetCudService;
import iih.ci.ord.app.i.ICiapprissheetRService;


/**
 * 检查打印申请单AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICiapprissheetCudService.class,ICiapprissheetRService.class}, binding=Binding.JSONRPC)
public class CiapprissheetCrudServiceImpl extends BaseDOService<CiAppRisSheetDO> implements ICiapprissheetCudService,ICiapprissheetRService {
    public CiapprissheetCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiAppRisSheetDODesc.class),IAppFwTempTbl.tmp_iaw_25.name()); 
    }
}
