package iih.ci.ord.app.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import iih.ci.ord.app.d.CiAppTreatSheetDO;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import iih.ci.ord.app.d.desc.CiAppTreatSheetDODesc;
import iih.ci.ord.app.d.CiapptreatsheetAggDO;
import iih.ci.ord.app.i.ICiapptreatsheetCudService;
import iih.ci.ord.app.i.ICiapptreatsheetRService;


/**
 * 诊疗申请单AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICiapptreatsheetCudService.class,ICiapptreatsheetRService.class}, binding=Binding.JSONRPC)
public class CiapptreatsheetCrudServiceImpl extends BaseAggService<CiapptreatsheetAggDO,CiAppTreatSheetDO> implements ICiapptreatsheetCudService,ICiapptreatsheetRService {
    public CiapptreatsheetCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiAppTreatSheetDODesc.class),IAppFwTempTbl.tmp_iaw_07.name()); 
    }
}
