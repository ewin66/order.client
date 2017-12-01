package iih.ci.ord.cior.s;
import iih.ci.ord.cior.d.OrdApPathgyDO;
import iih.ci.ord.cior.d.desc.OrdApPathgyDODesc;
import iih.ci.ord.cior.i.ICiorapppathgyMDOCudService;
import iih.ci.ord.cior.i.ICiorapppathgyMDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 病理申请单主实体CRUD服务实现
 */
@Service(serviceInterfaces={ICiorapppathgyMDOCudService.class,ICiorapppathgyMDORService.class}, binding=Binding.JSONRPC)
public class CiorapppathgyMDOCrudServiceImpl extends BaseDOService<OrdApPathgyDO> implements ICiorapppathgyMDOCudService,ICiorapppathgyMDORService {

    public CiorapppathgyMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(OrdApPathgyDODesc.class),IAppFwTempTbl.tmp_iaw_27.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

