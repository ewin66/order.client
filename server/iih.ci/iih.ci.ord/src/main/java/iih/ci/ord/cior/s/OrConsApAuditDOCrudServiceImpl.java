package iih.ci.ord.cior.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.cior.d.desc.OrConsApAuditDODesc;
import iih.ci.ord.cior.d.OrConsApAuditDO;
import iih.ci.ord.cior.i.IOrConsApAuditDOCudService;
import iih.ci.ord.cior.i.IOrConsApAuditDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 会诊申请单主实体CRUD服务实现
 */
@Service(serviceInterfaces={IOrConsApAuditDOCudService.class,IOrConsApAuditDORService.class}, binding=Binding.JSONRPC)
public class OrConsApAuditDOCrudServiceImpl extends BaseDOService<OrConsApAuditDO> implements IOrConsApAuditDOCudService,IOrConsApAuditDORService {

    public OrConsApAuditDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(OrConsApAuditDODesc.class),IAppFwTempTbl.tmp_iaw_07.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

