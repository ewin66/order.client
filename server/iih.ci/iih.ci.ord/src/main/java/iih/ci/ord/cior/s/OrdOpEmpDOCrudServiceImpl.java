package iih.ci.ord.cior.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.cior.d.desc.OrdOpEmpDODesc;
import iih.ci.ord.cior.d.OrdOpEmpDO;
import iih.ci.ord.cior.i.IOrdOpEmpDOCudService;
import iih.ci.ord.cior.i.IOrdOpEmpDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 手术申请主实体CRUD服务实现
 */
@Service(serviceInterfaces={IOrdOpEmpDOCudService.class,IOrdOpEmpDORService.class}, binding=Binding.JSONRPC)
public class OrdOpEmpDOCrudServiceImpl extends BaseDOService<OrdOpEmpDO> implements IOrdOpEmpDOCudService,IOrdOpEmpDORService {

    public OrdOpEmpDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(OrdOpEmpDODesc.class),IAppFwTempTbl.tmp_iaw_12.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

