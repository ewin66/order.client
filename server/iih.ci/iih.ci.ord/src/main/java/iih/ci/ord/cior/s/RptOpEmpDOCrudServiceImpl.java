package iih.ci.ord.cior.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.cior.d.desc.RptOpEmpDODesc;
import iih.ci.ord.cior.d.RptOpEmpDO;
import iih.ci.ord.cior.i.IRptOpEmpDOCudService;
import iih.ci.ord.cior.i.IRptOpEmpDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 医嘱手术记录主实体CRUD服务实现
 */
@Service(serviceInterfaces={IRptOpEmpDOCudService.class,IRptOpEmpDORService.class}, binding=Binding.JSONRPC)
public class RptOpEmpDOCrudServiceImpl extends BaseDOService<RptOpEmpDO> implements IRptOpEmpDOCudService,IRptOpEmpDORService {

    public RptOpEmpDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(RptOpEmpDODesc.class),IAppFwTempTbl.tmp_iaw_03.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

