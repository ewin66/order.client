package iih.ci.ord.app.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.app.d.desc.CiAppTreatExecOrDODesc;
import iih.ci.ord.app.d.CiAppTreatExecOrDO;
import iih.ci.ord.app.i.ICiAppTreatExecOrDOCudService;
import iih.ci.ord.app.i.ICiAppTreatExecOrDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 门诊诊疗执行单主实体CRUD服务实现
 */
@Service(serviceInterfaces={ICiAppTreatExecOrDOCudService.class,ICiAppTreatExecOrDORService.class}, binding=Binding.JSONRPC)
public class CiAppTreatExecOrDOCrudServiceImpl extends BaseDOService<CiAppTreatExecOrDO> implements ICiAppTreatExecOrDOCudService,ICiAppTreatExecOrDORService {

    public CiAppTreatExecOrDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiAppTreatExecOrDODesc.class),IAppFwTempTbl.tmp_iaw_02.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

