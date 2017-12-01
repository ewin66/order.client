package iih.ci.ord.cirptlab.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.cirptlab.d.desc.CiRptLabDODesc;
import iih.ci.ord.cirptlab.d.CiRptLabDO;
import iih.ci.ord.cirptlab.i.ICirptlabMDOCudService;
import iih.ci.ord.cirptlab.i.ICirptlabMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 组件主实体CRUD服务实现
 */
@Service(serviceInterfaces={ICirptlabMDOCudService.class,ICirptlabMDORService.class}, binding=Binding.JSONRPC)
public class CirptlabMDOCrudServiceImpl extends BaseDOService<CiRptLabDO> implements ICirptlabMDOCudService,ICirptlabMDORService {

    public CirptlabMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiRptLabDODesc.class),IAppFwTempTbl.tmp_iaw_12.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

