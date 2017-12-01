package iih.ci.ord.app.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.app.d.desc.CiAppTreatExecDODesc;
import iih.ci.ord.app.d.CiAppTreatExecDO;
import iih.ci.ord.app.i.ICiapptreatexecMDOCudService;
import iih.ci.ord.app.i.ICiapptreatexecMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 门诊诊疗执行单主实体CRUD服务实现
 */
@Service(serviceInterfaces={ICiapptreatexecMDOCudService.class,ICiapptreatexecMDORService.class}, binding=Binding.JSONRPC)
public class CiapptreatexecMDOCrudServiceImpl extends BaseDOService<CiAppTreatExecDO> implements ICiapptreatexecMDOCudService,ICiapptreatexecMDORService {

    public CiapptreatexecMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiAppTreatExecDODesc.class),IAppFwTempTbl.tmp_iaw_12.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

