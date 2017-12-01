package iih.ci.ord.cior.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.cior.d.desc.OrdOpMmDODesc;
import iih.ci.ord.cior.d.OrdOpMmDO;
import iih.ci.ord.cior.i.IOrdOpMmDOCudService;
import iih.ci.ord.cior.i.IOrdOpMmDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 手术申请主实体CRUD服务实现
 */
@Service(serviceInterfaces={IOrdOpMmDOCudService.class,IOrdOpMmDORService.class}, binding=Binding.JSONRPC)
public class OrdOpMmDOCrudServiceImpl extends BaseDOService<OrdOpMmDO> implements IOrdOpMmDOCudService,IOrdOpMmDORService {

    public OrdOpMmDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(OrdOpMmDODesc.class),IAppFwTempTbl.tmp_iaw_06.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

