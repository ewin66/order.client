package iih.ci.ord.cior.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.cior.d.desc.OrdApBtViewItemDODesc;
import iih.ci.ord.cior.d.OrdApBtViewItemDO;
import iih.ci.ord.cior.i.IOrdApBtViewItemDOCudService;
import iih.ci.ord.cior.i.IOrdApBtViewItemDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 备血申请单主实体CRUD服务实现
 */
@Service(serviceInterfaces={IOrdApBtViewItemDOCudService.class,IOrdApBtViewItemDORService.class}, binding=Binding.JSONRPC)
public class OrdApBtViewItemDOCrudServiceImpl extends BaseDOService<OrdApBtViewItemDO> implements IOrdApBtViewItemDOCudService,IOrdApBtViewItemDORService {

    public OrdApBtViewItemDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(OrdApBtViewItemDODesc.class),IAppFwTempTbl.tmp_iaw_26.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

