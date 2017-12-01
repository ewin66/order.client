package iih.ci.ord.app.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.app.d.desc.CiAppPathgySheetSampDODesc;
import iih.ci.ord.app.d.CiAppPathgySheetSampDO;
import iih.ci.ord.app.i.ICiAppPathgySheetSampDOCudService;
import iih.ci.ord.app.i.ICiAppPathgySheetSampDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 病理打印申请单主实体CRUD服务实现
 */
@Service(serviceInterfaces={ICiAppPathgySheetSampDOCudService.class,ICiAppPathgySheetSampDORService.class}, binding=Binding.JSONRPC)
public class CiAppPathgySheetSampDOCrudServiceImpl extends BaseDOService<CiAppPathgySheetSampDO> implements ICiAppPathgySheetSampDOCudService,ICiAppPathgySheetSampDORService {

    public CiAppPathgySheetSampDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiAppPathgySheetSampDODesc.class),IAppFwTempTbl.tmp_iaw_09.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

