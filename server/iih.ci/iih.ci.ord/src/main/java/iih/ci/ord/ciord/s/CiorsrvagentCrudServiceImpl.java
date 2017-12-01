package iih.ci.ord.ciord.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.ciord.d.desc.OrSrvAgentInfoDODesc;
import iih.ci.ord.ciord.d.OrSrvAgentInfoDO;
import iih.ci.ord.ciord.i.ICiorsrvagentCudService;
import iih.ci.ord.ciord.i.ICiorsrvagentRService;


/**
 * 医嘱项目患者与代理人信息核对登录AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICiorsrvagentCudService.class,ICiorsrvagentRService.class}, binding=Binding.JSONRPC)
public class CiorsrvagentCrudServiceImpl extends BaseDOService<OrSrvAgentInfoDO> implements ICiorsrvagentCudService,ICiorsrvagentRService {

    public CiorsrvagentCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(OrSrvAgentInfoDODesc.class),IAppFwTempTbl.tmp_iaw_11.name()); 
    }
}

