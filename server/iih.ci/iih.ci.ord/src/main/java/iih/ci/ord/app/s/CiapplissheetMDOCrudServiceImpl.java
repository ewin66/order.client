package iih.ci.ord.app.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.app.d.desc.CiAppLisSheetDODesc;
import iih.ci.ord.app.d.CiAppLisSheetDO;
import iih.ci.ord.app.i.ICiapplissheetMDOCudService;
import iih.ci.ord.app.i.ICiapplissheetMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 检验申请单主实体CRUD服务实现
 */
@Service(serviceInterfaces={ICiapplissheetMDOCudService.class,ICiapplissheetMDORService.class}, binding=Binding.JSONRPC)
public class CiapplissheetMDOCrudServiceImpl extends BaseDOService<CiAppLisSheetDO> implements ICiapplissheetMDOCudService,ICiapplissheetMDORService {

    public CiapplissheetMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiAppLisSheetDODesc.class),IAppFwTempTbl.tmp_iaw_14.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

