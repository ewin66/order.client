package iih.ci.ord.s.bp.mp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.ICiorderMDOCudService;
import iih.ci.ord.ciorder.i.ICiorderRService;
import iih.ci.ord.ciorder.i.IOrdSrvDOCudService;
import iih.ci.ord.ciorder.i.IOrdSrvDORService;
import iih.ci.ord.dto.d.PresOrSrvDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 处方中的医嘱项目费用可退标识更新操作BP （按医嘱项目粒度进行费用可退标识管理的情形） （同时维护该医嘱项目所属医嘱的可退费标识。）
 * （医嘱项目中有一个可退费标识为TRUE，则该医嘱可退费标识为TRUE否则为FALSE）
 */
public class CiOrSrvFgFeeRtnableModBP {
	/**
	 * 处方中的医嘱项目费用可退标识更新
	 * 
	 * @param ors
	 * @param fg_feertnable
	 * @throws BizException
	 */

	private List<String> orlist = new ArrayList<String>();
	private List<String> falseorlist = new ArrayList<String>();

	public void exec(PresOrSrvDTO[] presorsrvdtos, FBoolean fg_feertnable) throws BizException {

		ICiorderRService aggservice = ServiceFinder.find(ICiorderRService.class);
		ICiorderMDOCudService mdcuservice = ServiceFinder.find(ICiorderMDOCudService.class);
		IOrdSrvDORService rservice = ServiceFinder.find(IOrdSrvDORService.class);
		IOrdSrvDOCudService srvcudservice = ServiceFinder.find(IOrdSrvDOCudService.class);

		OrdSrvDO[] srvs = rservice.findByIds(getidorsrvs(presorsrvdtos), FBoolean.FALSE);
		updateordSrv(srvs, fg_feertnable);
		srvcudservice.update(srvs);

		if (orlist.size() > 0) {
			CiorderAggDO[] addors = aggservice.findByIds(orlist.toArray(new String[0]), FBoolean.FALSE);
			CiOrderDO[] ciors = updateciord(addors, fg_feertnable);
			mdcuservice.update(ciors);
		}

		if (falseorlist.size() > 0) {
			CiorderAggDO[] addors = aggservice.findByBIds(falseorlist.toArray(new String[0]), FBoolean.FALSE);
			CiOrderDO[] ciors = updateciord(addors, fg_feertnable);
			mdcuservice.update(ciors);
		}

	}

	private void updateordSrv(OrdSrvDO[] ordsrvs, FBoolean fg_feertnable) {
		Map<String, Object> srvmap = new HashMap<>();
		Map<String, Object> falsesrvmap = new HashMap<>();
		for (OrdSrvDO ordSrvDO : ordsrvs) {

			if (fg_feertnable == FBoolean.TRUE) {
				if (!srvmap.containsKey(ordSrvDO.getId_or())) {
					orlist.add(ordSrvDO.getId_or());
					srvmap.put(ordSrvDO.getId_or(), new Object());
				}
			} else if (fg_feertnable == FBoolean.FALSE) {

				if (!falsesrvmap.containsKey(ordSrvDO.getId_or())) {
					falseorlist.add(ordSrvDO.getId_or());
					falsesrvmap.put(ordSrvDO.getId_or(), new Object());
				}
			}

			ordSrvDO.setFg_feertnable(fg_feertnable);
			ordSrvDO.setStatus(DOStatus.UPDATED);
		}
	}

	private CiOrderDO[] updateciord(CiorderAggDO[] ords, FBoolean fg_feertnable) {
		List<CiOrderDO> ciorlist = new ArrayList<>();
		for (CiorderAggDO ciorderAggDO : ords) {
			if (fg_feertnable == FBoolean.TRUE) {
				ciorderAggDO.getParentDO().setFg_feertnable(fg_feertnable);
				ciorderAggDO.getParentDO().setStatus(DOStatus.UPDATED);
			} else if (fg_feertnable == FBoolean.FALSE) {
				FBoolean tmp = FBoolean.FALSE;
				for (OrdSrvDO ordSrvDO : ciorderAggDO.getOrdSrvDO()) {
					if (ordSrvDO.getFg_feertnable() == FBoolean.TRUE) {
						tmp = FBoolean.TRUE;
						break;
					}
				}
				if (!tmp.booleanValue()) {
					ciorderAggDO.getParentDO().setFg_feertnable(tmp);
					ciorderAggDO.getParentDO().setStatus(DOStatus.UPDATED);
				}
			}
		}

		return ciorlist.toArray(new CiOrderDO[0]);
	}

	private String[] getidorsrvs(PresOrSrvDTO[] presorsrvdtos) {

		List<String> orsrvs = new ArrayList<String>();

		for (PresOrSrvDTO presor : presorsrvdtos) {
			orsrvs.add(presor.getId_orsrv());
		}
		return orsrvs.toArray(new String[0]);
	}

}
