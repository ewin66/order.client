package iih.ci.ord.cior.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.cior.d.desc.OrdApConsDODesc;
import iih.ci.ord.cior.d.OrdApConsDO;
import iih.ci.ord.cior.i.ICiorappconsultMDOCudService;
import iih.ci.ord.cior.i.ICiorappconsultMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 会诊申请单主实体CRUD服务实现
 */
@Service(serviceInterfaces={ICiorappconsultMDOCudService.class,ICiorappconsultMDORService.class}, binding=Binding.JSONRPC)
public class CiorappconsultMDOCrudServiceImpl extends BaseDOService<OrdApConsDO> implements ICiorappconsultMDOCudService,ICiorappconsultMDORService {

    public CiorappconsultMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(OrdApConsDODesc.class),IAppFwTempTbl.tmp_iaw_12.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

