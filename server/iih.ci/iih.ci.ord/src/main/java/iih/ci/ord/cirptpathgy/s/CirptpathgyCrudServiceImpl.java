package iih.ci.ord.cirptpathgy.s;
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
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.xbd.udi.d.UdidocDO;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.cior.d.CiorapppathgyAggDO;
import iih.ci.ord.cior.d.OrdApPathgyDO;
import iih.ci.ord.cior.i.ICiorapppathgyRService;
import iih.ci.ord.cirptpathgy.d.desc.CiRptPathgyDODesc;
import iih.ci.ord.cirptpathgy.d.CiRptPathgyDO;
import iih.ci.ord.cirptpathgy.i.ICirptpathgyCudService;
import iih.ci.ord.cirptpathgy.i.ICirptpathgyRService;
import iih.mm.comm.i.IUdiHelperService;


/**
 * 病理报告单AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICirptpathgyCudService.class,ICirptpathgyRService.class}, binding=Binding.JSONRPC)
public class CirptpathgyCrudServiceImpl extends BaseDOService<CiRptPathgyDO> implements ICirptpathgyCudService,ICirptpathgyRService {
    public CirptpathgyCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiRptPathgyDODesc.class),IAppFwTempTbl.tmp_iaw_09.name()); 
    }
    
    @SuppressWarnings("unchecked")
  	@Override
  	protected void addInsertBeforeRule(AroundProcesser<CiRptPathgyDO> processer) {
  		super.addInsertBeforeRule(processer);
  		processer.addBeforeRule(new IRule<CiRptPathgyDO>() {
  			@Override
  			public void process(CiRptPathgyDO... dos) throws BizException {
  				for (CiRptPathgyDO cirptlabAggDO : dos) {
  					processBeforeInsertOrUpdate(cirptlabAggDO);
  				}
  			}
  		});
  	}  
      
      @Override
  	protected void addUpdateBeforeRule(
  			CompareAroundProcesser<CiRptPathgyDO> processer,
  			CiRptPathgyDO[] originvos) {
  		super.addUpdateBeforeRule(processer, originvos);
  		processer.addBeforeRule(new IRule<CiRptPathgyDO>() {
  			@Override
  			public void process(CiRptPathgyDO... dos) throws BizException {
  				for (CiRptPathgyDO ciRptObsDO : dos) {
  					processBeforeInsertOrUpdate(ciRptObsDO);
  				}
  			}
  		});
  	}
      
      protected void processBeforeInsertOrUpdate(CiRptPathgyDO ciRptPaDO)
  			throws BizException {
  		//设置病理报告状态
  		IUdiHelperService udiService = ServiceFinder.find(IUdiHelperService.class);
  		String orgId = Context.get().getOrgId();
  		UdidocDO udidocDO = udiService.getUdidocByCode(orgId, "ic.or.0710", ICiDictCodeConst.SD_SU_OBSRPT_FINALDEPLOY);
  		if (udidocDO != null) {
  			ciRptPaDO.setId_su_rpt(udidocDO.getId_udidoc());
  			ciRptPaDO.setSd_su_rpt(ICiDictCodeConst.SD_SU_OBSRPT_FINALDEPLOY);
  		}
  	}  
      
      @SuppressWarnings("unchecked")
  	@Override
  	protected void addInsertAfterRule(AroundProcesser<CiRptPathgyDO> processor) {
  		super.addInsertAfterRule(processor);
  		processor.addAfterRule(new IRule<CiRptPathgyDO>() {
  			@Override
  			public void process(CiRptPathgyDO... dos) throws BizException {
  				for (CiRptPathgyDO ciRptPaDO : dos) {
  					processAfterInsertOrUpdate(ciRptPaDO);
  				}
  			}
  		});
  	}
      
      protected void processAfterInsertOrUpdate(CiRptPathgyDO ciRptPaDO)
  			throws BizException {
  		String appaId = ciRptPaDO.getId_appathgy();
  		ICiorapppathgyRService ciorapprisRService = 
  				ServiceFinder.find(ICiorapppathgyRService.class);
  		CiorapppathgyAggDO apppathAggDO = ciorapprisRService.findById(appaId);
  		OrdApPathgyDO ordApPaDO = apppathAggDO.getParentDO();
  		
  		if (ordApPaDO != null) {
  			//更新病理申请单状态为[4 报告]			
  			ordApPaDO.setId_su_pathgy(ICiDictCodeConst.ID_SU_PATHGY_BG);
  			ordApPaDO.setSd_su_pathgy(ICiDictCodeConst.SD_SU_PATHGY_BG);			
  		}
  	}    
}
