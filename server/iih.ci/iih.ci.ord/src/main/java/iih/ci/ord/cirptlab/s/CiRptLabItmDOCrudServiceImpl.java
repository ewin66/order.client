package iih.ci.ord.cirptlab.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.cirptlab.d.desc.CiRptLabItmDODesc;
import iih.ci.ord.cirptlab.d.CiRptLabItmDO;
import iih.ci.ord.cirptlab.i.ICiRptLabItmDOCudService;
import iih.ci.ord.cirptlab.i.ICiRptLabItmDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 组件主实体CRUD服务实现
 */
@Service(serviceInterfaces={ICiRptLabItmDOCudService.class,ICiRptLabItmDORService.class}, binding=Binding.JSONRPC)
public class CiRptLabItmDOCrudServiceImpl extends BaseDOService<CiRptLabItmDO> implements ICiRptLabItmDOCudService,ICiRptLabItmDORService {

    public CiRptLabItmDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiRptLabItmDODesc.class),IAppFwTempTbl.tmp_iaw_10.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

