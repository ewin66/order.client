package iih.ci.ord.ciorder.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.ciorder.d.desc.OrdApMtDODesc;
import iih.ci.ord.ciorder.d.OrdApMtDO;
import iih.ci.ord.ciorder.i.IOrdApMtDOCudService;
import iih.ci.ord.ciorder.i.IOrdApMtDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 临床医嘱主实体CRUD服务实现
 */
@Service(serviceInterfaces={IOrdApMtDOCudService.class,IOrdApMtDORService.class}, binding=Binding.JSONRPC)
public class OrdApMtDOCrudServiceImpl extends BaseDOService<OrdApMtDO> implements IOrdApMtDOCudService,IOrdApMtDORService {

    public OrdApMtDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(OrdApMtDODesc.class),IAppFwTempTbl.tmp_iaw_03.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

