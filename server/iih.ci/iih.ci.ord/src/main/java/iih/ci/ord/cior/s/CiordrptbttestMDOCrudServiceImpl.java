package iih.ci.ord.cior.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.cior.d.desc.CiOrdBtTestDODesc;
import iih.ci.ord.cior.d.CiOrdBtTestDO;
import iih.ci.ord.cior.i.ICiordrptbttestMDOCudService;
import iih.ci.ord.cior.i.ICiordrptbttestMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 备血检验结果主实体CRUD服务实现
 */
@Service(serviceInterfaces={ICiordrptbttestMDOCudService.class,ICiordrptbttestMDORService.class}, binding=Binding.JSONRPC)
public class CiordrptbttestMDOCrudServiceImpl extends BaseDOService<CiOrdBtTestDO> implements ICiordrptbttestMDOCudService,ICiordrptbttestMDORService {

    public CiordrptbttestMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiOrdBtTestDODesc.class),IAppFwTempTbl.tmp_iaw_24.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

