package iih.ci.ord.s.bp.mp;

import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.ICiorderCudService;
import iih.ci.ord.ciorder.i.ICiorderRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 临床医嘱费用可退标识更新操作BP （按医嘱粒度进行费用可退标识管理的情形） （同时同步更新该医嘱下的医嘱项目的可退费标识）
 */
public class CiOrFgFeeRtnableModBP {
	/**
	 * 临床医嘱费用可退标识更新 （按医嘱粒度进行管理的情形） （同时同步更新该医嘱下的医嘱项目的可退费标识）
	 * 
	 * @param ors
	 * @param fg_feertnable
	 * @throws BizException
	 */
	public void exec(String[] ors, FBoolean fg_feertnable) throws BizException {

		ICiorderRService service = ServiceFinder.find(ICiorderRService.class);
		ICiorderCudService cudservice = ServiceFinder.find(ICiorderCudService.class);
		CiorderAggDO[] agg = service.findByBIds(ors, FBoolean.FALSE);

		updateciordAndSrv(agg, fg_feertnable);

		cudservice.update(agg);
	}

	private void updateciordAndSrv(CiorderAggDO[] agg, FBoolean fg_feertnable) {

		for (CiorderAggDO ciorderAggDO : agg) {
			ciorderAggDO.getParentDO().setFg_feertnable(fg_feertnable);
			ciorderAggDO.getParentDO().setStatus(DOStatus.UPDATED);

			for (OrdSrvDO ordSrvDO : ciorderAggDO.getOrdSrvDO()) {
				ordSrvDO.setFg_feertnable(fg_feertnable);
				ordSrvDO.setStatus(DOStatus.UPDATED);
			}
		}

	}

}
