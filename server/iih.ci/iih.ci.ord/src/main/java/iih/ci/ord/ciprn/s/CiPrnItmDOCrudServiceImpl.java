package iih.ci.ord.ciprn.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.ciprn.d.desc.CiPrnItmDODesc;
import iih.ci.ord.ciprn.d.CiPrnItmDO;
import iih.ci.ord.ciprn.i.ICiPrnItmDOCudService;
import iih.ci.ord.ciprn.i.ICiPrnItmDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 临床打印单主实体CRUD服务实现
 */
@Service(serviceInterfaces={ICiPrnItmDOCudService.class,ICiPrnItmDORService.class}, binding=Binding.JSONRPC)
public class CiPrnItmDOCrudServiceImpl extends BaseDOService<CiPrnItmDO> implements ICiPrnItmDOCudService,ICiPrnItmDORService {

    public CiPrnItmDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiPrnItmDODesc.class),IAppFwTempTbl.tmp_iaw_29.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

