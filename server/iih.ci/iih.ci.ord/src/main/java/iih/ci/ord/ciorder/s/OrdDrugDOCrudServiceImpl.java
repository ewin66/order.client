package iih.ci.ord.ciorder.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.ciorder.d.desc.OrdDrugDODesc;
import iih.ci.ord.ciorder.d.OrdDrugDO;
import iih.ci.ord.ciorder.i.IOrdDrugDOCudService;
import iih.ci.ord.ciorder.i.IOrdDrugDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 临床医嘱主实体CRUD服务实现
 */
@Service(serviceInterfaces={IOrdDrugDOCudService.class,IOrdDrugDORService.class}, binding=Binding.JSONRPC)
public class OrdDrugDOCrudServiceImpl extends BaseDOService<OrdDrugDO> implements IOrdDrugDOCudService,IOrdDrugDORService {

    public OrdDrugDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(OrdDrugDODesc.class),IAppFwTempTbl.tmp_iaw_16.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

