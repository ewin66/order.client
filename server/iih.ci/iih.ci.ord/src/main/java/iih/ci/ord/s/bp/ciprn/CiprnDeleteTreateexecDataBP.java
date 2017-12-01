package iih.ci.ord.s.bp.ciprn;

import iih.ci.ord.app.d.CiAppTreatExecOrDO;
import iih.ci.ord.app.d.CiapptreatexecAggDO;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 删除诊疗执行单数据
 * 
 * @author YANG
 *
 */
public class CiprnDeleteTreateexecDataBP {
	public FBoolean exec(String[] idors) throws BizException {
		if (idors == null || idors.length <= 0)
			return FBoolean.TRUE;
		CiAppTreatExecOrDO[] treatExecOrDOs = CiprnUtils.GetTreatExecOrDOByIdor(idors);
		if (treatExecOrDOs == null || treatExecOrDOs.length <= 0)
			return FBoolean.TRUE;
		List<String> lstIdapptreatexec = new ArrayList<String>();
		for (CiAppTreatExecOrDO treatExecOrDO : treatExecOrDOs) {
			if (!lstIdapptreatexec.contains(treatExecOrDO.getId_ciapptreatexec()))
				lstIdapptreatexec.add(treatExecOrDO.getId_ciapptreatexec());
		}
		//删除打印明细
		CiprnUtils.DeleteCiAppTreatExecOrDO(treatExecOrDOs);
		//如果单据内明细已空，则删除单据
		CiapptreatexecAggDO[] aggDOs = CiprnUtils.GetCiapptreatexecAggDOs(lstIdapptreatexec
				.toArray(new String[lstIdapptreatexec.size()]));
		List<CiapptreatexecAggDO> lstAggDOs = new ArrayList<CiapptreatexecAggDO>();
		if (aggDOs != null && aggDOs.length > 0) {
			for (CiapptreatexecAggDO aggDO : aggDOs) {
				if (aggDO.getCiAppTreatExecOrDO().length <= 0)
					lstAggDOs.add(aggDO);
			}
		}
		if (lstAggDOs == null || lstAggDOs.size() <= 0)
			return FBoolean.TRUE;
		CiprnUtils.DeleteCiapptreatexecAggDO(lstAggDOs.toArray(new CiapptreatexecAggDO[lstAggDOs.size()]));
		return FBoolean.TRUE;
	}
}
