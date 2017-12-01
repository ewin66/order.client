package iih.ci.ord.cior.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.cior.d.desc.CiordInviteConsDODesc;
import iih.ci.ord.cior.d.CiordInviteConsDO;
import iih.ci.ord.cior.i.ICiordInviteConsDOCudService;
import iih.ci.ord.cior.i.ICiordInviteConsDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 会诊申请单主实体CRUD服务实现
 */
@Service(serviceInterfaces={ICiordInviteConsDOCudService.class,ICiordInviteConsDORService.class}, binding=Binding.JSONRPC)
public class CiordInviteConsDOCrudServiceImpl extends BaseDOService<CiordInviteConsDO> implements ICiordInviteConsDOCudService,ICiordInviteConsDORService {

    public CiordInviteConsDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiordInviteConsDODesc.class),IAppFwTempTbl.tmp_iaw_04.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

