package iih.ci.ord.ciorder.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.ciorder.d.desc.OrdSrvDODesc;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.IOrdSrvDOCudService;
import iih.ci.ord.ciorder.i.IOrdSrvDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 临床医嘱主实体CRUD服务实现
 */
@Service(serviceInterfaces={IOrdSrvDOCudService.class,IOrdSrvDORService.class}, binding=Binding.JSONRPC)
public class OrdSrvDOCrudServiceImpl extends BaseDOService<OrdSrvDO> implements IOrdSrvDOCudService,IOrdSrvDORService {

    public OrdSrvDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(OrdSrvDODesc.class),IAppFwTempTbl.tmp_iaw_15.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

