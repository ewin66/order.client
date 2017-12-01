package iih.ci.ord.cior.s;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.cior.d.CiOrdBtTestDO;
import iih.ci.ord.cior.d.CiordrptbttestAggDO;
import iih.ci.ord.cior.d.desc.CiOrdBtTestDODesc;
import iih.ci.ord.cior.i.ICiordrptbttestCudService;
import iih.ci.ord.cior.i.ICiordrptbttestRService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.ci.ord.dto.blexorder.d.OrSrvSplitParamDTO;
import iih.ci.ord.s.bp.ordbttest.OrdBtTestSaveBp;
import iih.mp.nr.dto.d.ComParamDTO;
import iih.mp.nr.i.IMpSetEusuOrFgdggetService;
import iih.mp.nr.i.IMporInternalService;
import iih.mp.nr.mporplan.d.ExecuteStatusEnum;
import iih.mp.nr.splitplan.i.IMpPlanRequestService;
import iih.mp.nr.splitplan.splitrequest.d.ComSpQueParamDTO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.bizrule.IRule;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.handler.CompareAroundProcesser;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;

/**
 * 备血检验结果AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { ICiordrptbttestCudService.class, ICiordrptbttestRService.class }, binding = Binding.JSONRPC)
public class CiordrptbttestCrudServiceImpl extends BaseAggService<CiordrptbttestAggDO,CiOrdBtTestDO> implements ICiordrptbttestCudService, ICiordrptbttestRService {

	public CiordrptbttestCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(CiOrdBtTestDODesc.class), IAppFwTempTbl.tmp_iaw_22.name());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void addInsertAfterRule(AroundProcesser<CiordrptbttestAggDO> processer) {
		super.addInsertAfterRule(processer);
		processer.addAfterRule(new IRule<CiordrptbttestAggDO>() {
			@Override
			public void process(CiordrptbttestAggDO... dos) throws BizException {
				for (CiordrptbttestAggDO ciordRptbttestAggDO : dos) {
					processAfterInsertOrUpdate(ciordRptbttestAggDO);
				}
			}
		});
	}

	@Override
	protected void addUpdateAfterRule(CompareAroundProcesser<CiordrptbttestAggDO> processer, CiordrptbttestAggDO[] originvos) {
		super.addUpdateAfterRule(processer, originvos);
		processer.addAfterRule(new IRule<CiordrptbttestAggDO>() {
			@Override
			public void process(CiordrptbttestAggDO... dos) throws BizException {
				for (CiordrptbttestAggDO ciordRptbttestAggDO : dos) {
					processAfterInsertOrUpdate(ciordRptbttestAggDO);
				}
			}
		});
	}



	protected void processAfterInsertOrUpdate(CiordrptbttestAggDO ciordRptbttestAggDO) {
		// TODO Auto-generated method stub
	}
}
