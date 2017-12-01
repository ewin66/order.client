package iih.ci.ord.cirptobs.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.service.constant.Binding;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.bizrule.IRule;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.handler.CompareAroundProcesser;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.xbd.udi.d.UdidocDO;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.cior.d.OrdApObsDO;
import iih.ci.ord.cior.i.ICiorapprisRService;
import iih.ci.ord.cirptobs.d.desc.CiRptObsDODesc;
import iih.ci.ord.cirptobs.d.CiRptObsDO;
import iih.ci.ord.cirptobs.i.ICirptobsCudService;
import iih.ci.ord.cirptobs.i.ICirptobsRService;
import iih.mm.comm.i.IUdiHelperService;


/**
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICirptobsCudService.class,ICirptobsRService.class}, binding=Binding.JSONRPC)
public class CirptobsCrudServiceImpl extends BaseDOService<CiRptObsDO> implements ICirptobsCudService,ICirptobsRService {

    public CirptobsCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiRptObsDODesc.class),IAppFwTempTbl.tmp_iaw_18.name()); 
    }
    
	@SuppressWarnings("unchecked")
	@Override
	protected void addInsertBeforeRule(AroundProcesser<CiRptObsDO> processer) {
		super.addInsertBeforeRule(processer);
		processer.addBeforeRule(new IRule<CiRptObsDO>() {
			@Override
			public void process(CiRptObsDO... dos) throws BizException {
				for (CiRptObsDO cirptlabAggDO : dos) {
					processBeforeInsertOrUpdate(cirptlabAggDO);
				}
			}
		});
	}  
	
	@Override
	protected void addUpdateBeforeRule(
			CompareAroundProcesser<CiRptObsDO> processer,
			CiRptObsDO[] originvos) {
		super.addUpdateBeforeRule(processer, originvos);
		processer.addBeforeRule(new IRule<CiRptObsDO>() {
			@Override
			public void process(CiRptObsDO... dos) throws BizException {
				for (CiRptObsDO ciRptObsDO : dos) {
					processBeforeInsertOrUpdate(ciRptObsDO);
				}
			}
		});
	}
	
	protected void processBeforeInsertOrUpdate(CiRptObsDO ciRptObsDO)
			throws BizException {
		//设置检查报告状态
		IUdiHelperService udiService = ServiceFinder.find(IUdiHelperService.class);
		String orgId = Context.get().getOrgId();
		UdidocDO udidocDO = udiService.getUdidocByCode(orgId, "ic.or.0710", ICiDictCodeConst.SD_SU_OBSRPT_FINALDEPLOY);
		if (udidocDO != null) {
			ciRptObsDO.setId_su(udidocDO.getId_udidoc());
			ciRptObsDO.setSd_su(ICiDictCodeConst.SD_SU_OBSRPT_FINALDEPLOY);
		}
	}    
    
	@SuppressWarnings("unchecked")
	@Override
	protected void addInsertAfterRule(AroundProcesser<CiRptObsDO> processor) {
		super.addInsertAfterRule(processor);
		processor.addAfterRule(new IRule<CiRptObsDO>() {
			@Override
			public void process(CiRptObsDO... dos) throws BizException {
				for (CiRptObsDO ciRptObsDO : dos) {
					processAfterInsertOrUpdate(ciRptObsDO);
				}
			}
		});
	}

	@Override
	protected void addUpdateAfterRule(
			CompareAroundProcesser<CiRptObsDO> processer,
			CiRptObsDO[] originvos) {
		super.addUpdateAfterRule(processer, originvos);
		processer.addAfterRule(new IRule<CiRptObsDO>() {
			@Override
			public void process(CiRptObsDO... dos) throws BizException {
				for (CiRptObsDO ciRptObsDO : dos) {
					processAfterInsertOrUpdate(ciRptObsDO);
				}
			}
		});
	}    
    
	protected void processAfterInsertOrUpdate(CiRptObsDO ciRptObsDO)
			throws BizException {
		String orobsId = ciRptObsDO.getId_orobs();
		ICiorapprisRService ciorapprisRService = 
				ServiceFinder.find(ICiorapprisRService.class);
		OrdApObsDO ordApObsDO = ciorapprisRService.findById(orobsId);
		if (ordApObsDO != null) {
			//更新检查申请单状态为[4 报告]
			IUdiHelperService udiService = ServiceFinder.find(IUdiHelperService.class);
			String orgId = Context.get().getOrgId();
			UdidocDO udidocDO = udiService.getUdidocByCode(orgId, "CI.OR.0560", ICiDictCodeConst.SD_CI_OBS_BG);
			if (udidocDO != null) {
				ciRptObsDO.setId_su(udidocDO.getId_udidoc());
				ciRptObsDO.setSd_su(ICiDictCodeConst.SD_CI_OBS_BG);
			}
			
		}
	}    
}

