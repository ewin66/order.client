package iih.ci.ord.cirptlab.s;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.cirptlab.d.CiRptLabDO;
import iih.ci.ord.cirptlab.d.CirptlabAggDO;
import iih.ci.ord.cirptlab.d.desc.CiRptLabDODesc;
import iih.ci.ord.cirptlab.i.ICirptlabCudService;
import iih.ci.ord.cirptlab.i.ICirptlabRService;
import iih.mm.comm.i.IUdiHelperService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.service.constant.Binding;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.bizrule.IRule;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.handler.CompareAroundProcesser;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.xbd.udi.d.UdidocDO;


/**
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICirptlabCudService.class,ICirptlabRService.class}, binding=Binding.JSONRPC)
public class CirptlabCrudServiceImpl extends BaseAggService<CirptlabAggDO,CiRptLabDO> implements ICirptlabCudService,ICirptlabRService {

    public CirptlabCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiRptLabDODesc.class),IAppFwTempTbl.tmp_iaw_15.name()); 
    }
    
	@SuppressWarnings("unchecked")
	@Override
	protected void addInsertBeforeRule(AroundProcesser<CirptlabAggDO> processer) {
		super.addInsertBeforeRule(processer);
		processer.addBeforeRule(new IRule<CirptlabAggDO>() {
			@Override
			public void process(CirptlabAggDO... dos) throws BizException {
				for (CirptlabAggDO cirptlabAggDO : dos) {
					processBeforeInsertOrUpdate(cirptlabAggDO);
				}
			}
		});
	}  
	
	@Override
	protected void addUpdateBeforeRule(
			CompareAroundProcesser<CirptlabAggDO> processer,
			CirptlabAggDO[] originvos) {
		super.addUpdateBeforeRule(processer, originvos);
		processer.addBeforeRule(new IRule<CirptlabAggDO>() {
			@Override
			public void process(CirptlabAggDO... dos) throws BizException {
				for (CirptlabAggDO cirptlabAggDO : dos) {
					processBeforeInsertOrUpdate(cirptlabAggDO);
				}
			}
		});
	}
	
	protected void processBeforeInsertOrUpdate(CirptlabAggDO cirptlabAggDO)
			throws BizException {
		CiRptLabDO ciRptLabDO = cirptlabAggDO.getParentDO();
		
		//设置检验报告状态
		IUdiHelperService udiService = ServiceFinder.find(IUdiHelperService.class);
		String orgId = Context.get().getOrgId();
		UdidocDO udidocDO = udiService.getUdidocByCode(orgId, "ci.or.0715", ICiDictCodeConst.SD_CI_RPT_LAB_FBBG);
		if (udidocDO != null) {
			ciRptLabDO.setId_su_lab(udidocDO.getId_udidoc());
			ciRptLabDO.setSd_su_lab(ICiDictCodeConst.SD_CI_RPT_LAB_FBBG);
		}
	}	    
}

