package iih.ci.ord.ciprn.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.ciprn.d.desc.CiPrnDODesc;
import iih.ci.ord.ciprn.d.CiPrnDO;
import iih.ci.ord.ciprn.i.ICiprintMDOCudService;
import iih.ci.ord.ciprn.i.ICiprintMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 临床打印单主实体CRUD服务实现
 */
@Service(serviceInterfaces={ICiprintMDOCudService.class,ICiprintMDORService.class}, binding=Binding.JSONRPC)
public class CiprintMDOCrudServiceImpl extends BaseDOService<CiPrnDO> implements ICiprintMDOCudService,ICiprintMDORService {

    public CiprintMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiPrnDODesc.class),IAppFwTempTbl.tmp_iaw_18.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

