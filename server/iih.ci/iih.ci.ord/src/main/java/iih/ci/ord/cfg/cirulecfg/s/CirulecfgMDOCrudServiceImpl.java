package iih.ci.ord.cfg.cirulecfg.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.cfg.cirulecfg.d.desc.CiRuleCfgDesc;
import iih.ci.ord.cfg.cirulecfg.d.CiRuleCfg;
import iih.ci.ord.cfg.cirulecfg.i.ICirulecfgMDOCudService;
import iih.ci.ord.cfg.cirulecfg.i.ICirulecfgMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 医嘱规则配置主实体CRUD服务实现
 */
@Service(serviceInterfaces={ICirulecfgMDOCudService.class,ICirulecfgMDORService.class}, binding=Binding.JSONRPC)
public class CirulecfgMDOCrudServiceImpl extends BaseDOService<CiRuleCfg> implements ICirulecfgMDOCudService,ICirulecfgMDORService {

    public CirulecfgMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiRuleCfgDesc.class),IAppFwTempTbl.tmp_iaw_10.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

