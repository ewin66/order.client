package iih.ci.ord.cior.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.cior.d.desc.OrdApRptOpItemDODesc;
import iih.ci.ord.cior.d.OrdApRptOpItemDO;
import iih.ci.ord.cior.i.IOrdApRptOpItemDOCudService;
import iih.ci.ord.cior.i.IOrdApRptOpItemDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 医嘱手术记录主实体CRUD服务实现
 */
@Service(serviceInterfaces={IOrdApRptOpItemDOCudService.class,IOrdApRptOpItemDORService.class}, binding=Binding.JSONRPC)
public class OrdApRptOpItemDOCrudServiceImpl extends BaseDOService<OrdApRptOpItemDO> implements IOrdApRptOpItemDOCudService,IOrdApRptOpItemDORService {

    public OrdApRptOpItemDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(OrdApRptOpItemDODesc.class),IAppFwTempTbl.tmp_iaw_26.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

