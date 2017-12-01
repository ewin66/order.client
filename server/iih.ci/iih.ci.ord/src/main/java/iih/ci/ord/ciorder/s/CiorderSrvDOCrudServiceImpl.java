package iih.ci.ord.ciorder.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.ciorder.d.desc.CiOrderDODesc;
import iih.ci.ord.ciorder.d.desc.OrdSrvDODesc;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.ICiorderMDOCudService;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.ci.ord.ciorder.i.ICiorderSrvDOCudService;
import iih.ci.ord.ciorder.i.ICiorderSrvDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 临床医嘱AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICiorderSrvDOCudService.class,ICiorderSrvDORService.class}, binding=Binding.JSONRPC)
public class CiorderSrvDOCrudServiceImpl extends BaseDOService<OrdSrvDO> implements ICiorderSrvDOCudService,ICiorderSrvDORService {

    public CiorderSrvDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(OrdSrvDODesc.class),IAppFwTempTbl.tmp_iaw_29.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

