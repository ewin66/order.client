package iih.ci.ord.cior.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.cior.d.desc.OrdApRptOpDODesc;
import iih.ci.ord.cior.d.OrdApRptOpDO;
import iih.ci.ord.cior.i.IOrdrptopMDOCudService;
import iih.ci.ord.cior.i.IOrdrptopMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 医嘱手术记录主实体CRUD服务实现
 */
@Service(serviceInterfaces={IOrdrptopMDOCudService.class,IOrdrptopMDORService.class}, binding=Binding.JSONRPC)
public class OrdrptopMDOCrudServiceImpl extends BaseDOService<OrdApRptOpDO> implements IOrdrptopMDOCudService,IOrdrptopMDORService {

    public OrdrptopMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(OrdApRptOpDODesc.class),IAppFwTempTbl.tmp_iaw_05.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

