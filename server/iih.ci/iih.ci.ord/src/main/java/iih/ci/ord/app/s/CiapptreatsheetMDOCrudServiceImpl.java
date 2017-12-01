package iih.ci.ord.app.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.app.d.desc.CiAppTreatSheetDODesc;
import iih.ci.ord.app.d.CiAppTreatSheetDO;
import iih.ci.ord.app.i.ICiapptreatsheetMDOCudService;
import iih.ci.ord.app.i.ICiapptreatsheetMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 诊疗申请单主实体CRUD服务实现
 */
@Service(serviceInterfaces={ICiapptreatsheetMDOCudService.class,ICiapptreatsheetMDORService.class}, binding=Binding.JSONRPC)
public class CiapptreatsheetMDOCrudServiceImpl extends BaseDOService<CiAppTreatSheetDO> implements ICiapptreatsheetMDOCudService,ICiapptreatsheetMDORService {

    public CiapptreatsheetMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiAppTreatSheetDODesc.class),IAppFwTempTbl.tmp_iaw_25.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

