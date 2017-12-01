package iih.ci.ord.cfg.cirulecfg.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.cfg.cirulecfg.d.desc.CiRuleEntityDesc;
import iih.ci.ord.cfg.cirulecfg.d.CiRuleEntity;
import iih.ci.ord.cfg.cirulecfg.i.IRuleentityCudService;
import iih.ci.ord.cfg.cirulecfg.i.IRuleentityRService;


/**
 * 医嘱规则配置AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IRuleentityCudService.class,IRuleentityRService.class}, binding=Binding.JSONRPC)
public class RuleentityCrudServiceImpl extends BaseDOService<CiRuleEntity> implements IRuleentityCudService,IRuleentityRService {
    public RuleentityCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiRuleEntityDesc.class),IAppFwTempTbl.tmp_iaw_28.name()); 
    }
}
