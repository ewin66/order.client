package iih.ci.ord.s.bp.ciprn;

import java.util.ArrayList;
import java.util.List;

import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciprn.d.CiPrnItmDO;
import iih.ci.ord.ciprn.d.CiprintAggDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 删除费用清单数据
 * 
 * @author YANG
 *
 */
public class CiprnDeleteFeeBillsDataBP {

	public FBoolean exec(String[] idors, boolean isAll) throws BizException {
		if (idors == null || idors.length <= 0)
			return FBoolean.TRUE;
		OrdSrvDO[] srvDOs = CiprnUtils.GetOrdSrvDOByIdor(idors);
		if (srvDOs == null || srvDOs.length <= 0)
			return FBoolean.TRUE;
		List<String> lstIdorsrvs = new ArrayList<String>();
		for (OrdSrvDO srvDO : srvDOs) {
			lstIdorsrvs.add(srvDO.getId_orsrv());
		}
		CiPrnItmDO[] ciPrnItmDOs = isAll ? CiprnUtils.GetCiPrnItmDOByIdorsrv(lstIdorsrvs) 
				: CiprnUtils.GetCiPrnItmDOByIdorsrv(lstIdorsrvs, false);
		List<String> lstIdciprn = new ArrayList<String>();
		if (ciPrnItmDOs == null || ciPrnItmDOs.length <= 0)
			return FBoolean.TRUE;
		for (CiPrnItmDO ciPrnItmDO : ciPrnItmDOs) {
			if (!lstIdciprn.contains(ciPrnItmDO.getId_ciprn()))
				lstIdciprn.add(ciPrnItmDO.getId_ciprn());
		}
		//删除打印明细（对应费用服务）
		CiprnUtils.DeleteCiPrnItmDO(ciPrnItmDOs);
		//如果单据内明细已空，则删除单据
		CiprintAggDO[] aggDOs = CiprnUtils.GetCiprintAggDOs(lstIdciprn.toArray(new String[lstIdciprn.size()]));
		List<CiprintAggDO> lstAggDOs = new ArrayList<CiprintAggDO>();
		if (aggDOs != null && aggDOs.length > 0) {
			for (CiprintAggDO aggDO : aggDOs) {
				if (aggDO.getCiPrnItmDO().length <= 0)
					lstAggDOs.add(aggDO);
			}
		}
		if (lstAggDOs == null || lstAggDOs.size() <= 0)
			return FBoolean.TRUE;
		CiprnUtils.DeleteCiprintAggDO(lstAggDOs.toArray(new CiprintAggDO[lstAggDOs.size()]));
		return FBoolean.TRUE;
	}
}
