package iih.ci.ord.ordsrvdose.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.ordsrvdose.d.desc.OrdSrvDoseDODesc;
import iih.ci.ord.ordsrvdose.d.OrdSrvDoseDO;
import iih.ci.ord.ordsrvdose.i.IOrdsrvdoseCudService;
import iih.ci.ord.ordsrvdose.i.IOrdsrvdoseRService;


/**
 * 医嘱服务项目剂量AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IOrdsrvdoseCudService.class,IOrdsrvdoseRService.class}, binding=Binding.JSONRPC)
public class OrdsrvdoseCrudServiceImpl extends BaseDOService<OrdSrvDoseDO> implements IOrdsrvdoseCudService,IOrdsrvdoseRService {

    public OrdsrvdoseCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(OrdSrvDoseDODesc.class),IAppFwTempTbl.tmp_iaw_08.name()); 
    }
}

