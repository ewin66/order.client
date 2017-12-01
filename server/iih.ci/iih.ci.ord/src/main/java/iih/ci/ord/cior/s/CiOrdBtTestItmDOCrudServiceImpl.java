package iih.ci.ord.cior.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.cior.d.desc.CiOrdBtTestItmDODesc;
import iih.ci.ord.cior.d.CiOrdBtTestItmDO;
import iih.ci.ord.cior.i.ICiOrdBtTestItmDOCudService;
import iih.ci.ord.cior.i.ICiOrdBtTestItmDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 备血检验结果主实体CRUD服务实现
 */
@Service(serviceInterfaces={ICiOrdBtTestItmDOCudService.class,ICiOrdBtTestItmDORService.class}, binding=Binding.JSONRPC)
public class CiOrdBtTestItmDOCrudServiceImpl extends BaseDOService<CiOrdBtTestItmDO> implements ICiOrdBtTestItmDOCudService,ICiOrdBtTestItmDORService {

    public CiOrdBtTestItmDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiOrdBtTestItmDODesc.class),IAppFwTempTbl.tmp_iaw_02.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

