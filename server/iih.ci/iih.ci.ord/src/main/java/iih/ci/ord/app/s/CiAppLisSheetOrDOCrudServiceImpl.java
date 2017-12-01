package iih.ci.ord.app.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.app.d.desc.CiAppLisSheetOrDODesc;
import iih.ci.ord.app.d.CiAppLisSheetOrDO;
import iih.ci.ord.app.i.ICiAppLisSheetOrDOCudService;
import iih.ci.ord.app.i.ICiAppLisSheetOrDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 检验申请单主实体CRUD服务实现
 */
@Service(serviceInterfaces={ICiAppLisSheetOrDOCudService.class,ICiAppLisSheetOrDORService.class}, binding=Binding.JSONRPC)
public class CiAppLisSheetOrDOCrudServiceImpl extends BaseDOService<CiAppLisSheetOrDO> implements ICiAppLisSheetOrDOCudService,ICiAppLisSheetOrDORService {

    public CiAppLisSheetOrDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiAppLisSheetOrDODesc.class),IAppFwTempTbl.tmp_iaw_17.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

