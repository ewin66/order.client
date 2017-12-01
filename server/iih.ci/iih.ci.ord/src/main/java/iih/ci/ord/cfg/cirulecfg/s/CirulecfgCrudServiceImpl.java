package iih.ci.ord.cfg.cirulecfg.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import iih.ci.ord.cfg.cirulecfg.d.CiRuleCfg;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import iih.ci.ord.cfg.cirulecfg.d.desc.CiRuleCfgDesc;
import iih.ci.ord.cfg.cirulecfg.d.CirulecfgAggDO;
import iih.ci.ord.cfg.cirulecfg.i.ICirulecfgCudService;
import iih.ci.ord.cfg.cirulecfg.i.ICirulecfgRService;


/**
 * 医嘱规则配置AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICirulecfgCudService.class,ICirulecfgRService.class}, binding=Binding.JSONRPC)
public class CirulecfgCrudServiceImpl extends BaseAggService<CirulecfgAggDO,CiRuleCfg> implements ICirulecfgCudService,ICirulecfgRService {
    public CirulecfgCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiRuleCfgDesc.class),IAppFwTempTbl.tmp_iaw_29.name()); 
    }
}
