package iih.ci.ord.app.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.app.d.desc.CiAppPathgySheetDODesc;
import iih.ci.ord.app.d.CiAppPathgySheetDO;
import iih.ci.ord.app.i.ICiapppathgysheetMDOCudService;
import iih.ci.ord.app.i.ICiapppathgysheetMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 病理打印申请单主实体CRUD服务实现
 */
@Service(serviceInterfaces={ICiapppathgysheetMDOCudService.class,ICiapppathgysheetMDORService.class}, binding=Binding.JSONRPC)
public class CiapppathgysheetMDOCrudServiceImpl extends BaseDOService<CiAppPathgySheetDO> implements ICiapppathgysheetMDOCudService,ICiapppathgysheetMDORService {

    public CiapppathgysheetMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiAppPathgySheetDODesc.class),IAppFwTempTbl.tmp_iaw_03.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

