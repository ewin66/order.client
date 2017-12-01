package iih.ci.ord.cior.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.cior.d.desc.OrdApOpDODesc;
import iih.ci.ord.cior.d.OrdApOpDO;
import iih.ci.ord.cior.i.ICiorappsurgeryMDOCudService;
import iih.ci.ord.cior.i.ICiorappsurgeryMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 手术申请主实体CRUD服务实现
 */
@Service(serviceInterfaces={ICiorappsurgeryMDOCudService.class,ICiorappsurgeryMDORService.class}, binding=Binding.JSONRPC)
public class CiorappsurgeryMDOCrudServiceImpl extends BaseDOService<OrdApOpDO> implements ICiorappsurgeryMDOCudService,ICiorappsurgeryMDORService {

    public CiorappsurgeryMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(OrdApOpDODesc.class),IAppFwTempTbl.tmp_iaw_24.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

