package iih.ci.ord.app.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import iih.ci.ord.app.d.CiAppTreatExecDO;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import iih.ci.ord.app.d.desc.CiAppTreatExecDODesc;
import iih.ci.ord.app.d.CiapptreatexecAggDO;
import iih.ci.ord.app.i.ICiapptreatexecCudService;
import iih.ci.ord.app.i.ICiapptreatexecRService;


/**
 * 门诊诊疗执行单AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICiapptreatexecCudService.class,ICiapptreatexecRService.class}, binding=Binding.JSONRPC)
public class CiapptreatexecCrudServiceImpl extends BaseAggService<CiapptreatexecAggDO,CiAppTreatExecDO> implements ICiapptreatexecCudService,ICiapptreatexecRService {
    public CiapptreatexecCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiAppTreatExecDODesc.class),IAppFwTempTbl.tmp_iaw_22.name()); 
    }
}
