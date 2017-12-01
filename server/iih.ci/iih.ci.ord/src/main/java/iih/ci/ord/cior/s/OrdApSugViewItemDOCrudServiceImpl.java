package iih.ci.ord.cior.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.cior.d.desc.OrdApSugViewItemDODesc;
import iih.ci.ord.cior.d.OrdApSugViewItemDO;
import iih.ci.ord.cior.i.IOrdApSugViewItemDOCudService;
import iih.ci.ord.cior.i.IOrdApSugViewItemDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 手术申请主实体CRUD服务实现
 */
@Service(serviceInterfaces={IOrdApSugViewItemDOCudService.class,IOrdApSugViewItemDORService.class}, binding=Binding.JSONRPC)
public class OrdApSugViewItemDOCrudServiceImpl extends BaseDOService<OrdApSugViewItemDO> implements IOrdApSugViewItemDOCudService,IOrdApSugViewItemDORService {

    public OrdApSugViewItemDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(OrdApSugViewItemDODesc.class),IAppFwTempTbl.tmp_iaw_01.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

