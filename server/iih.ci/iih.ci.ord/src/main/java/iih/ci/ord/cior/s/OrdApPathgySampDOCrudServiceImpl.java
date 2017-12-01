package iih.ci.ord.cior.s;
import iih.ci.ord.cior.d.OrdApPathgySampDO;
import iih.ci.ord.cior.d.desc.OrdApPathgySampDODesc;
import iih.ci.ord.cior.i.IOrdApPathgySampDOCudService;
import iih.ci.ord.cior.i.IOrdApPathgySampDORService;
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
@Service(serviceInterfaces={IOrdApPathgySampDOCudService.class,IOrdApPathgySampDORService.class}, binding=Binding.JSONRPC)
public class OrdApPathgySampDOCrudServiceImpl extends BaseDOService<OrdApPathgySampDO> implements IOrdApPathgySampDOCudService,IOrdApPathgySampDORService {

    public OrdApPathgySampDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(OrdApPathgySampDODesc.class),IAppFwTempTbl.tmp_iaw_24.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

