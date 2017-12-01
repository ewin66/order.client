package iih.ci.rcm.contagion.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.rcm.contagion.d.desc.ContagionDODesc;
import iih.ci.rcm.contagion.d.ContagionDO;
import iih.ci.rcm.contagion.i.IContagionMDOCudService;
import iih.ci.rcm.contagion.i.IContagionMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 传染病报告卡主实体CRUD服务实现
 */
@Service(serviceInterfaces={IContagionMDOCudService.class,IContagionMDORService.class}, binding=Binding.JSONRPC)
public class ContagionMDOCrudServiceImpl extends BaseDOService<ContagionDO> implements IContagionMDOCudService,IContagionMDORService {

    public ContagionMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ContagionDODesc.class),IAppFwTempTbl.tmp_iaw_11.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

