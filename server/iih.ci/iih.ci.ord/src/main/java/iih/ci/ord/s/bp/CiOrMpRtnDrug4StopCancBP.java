package iih.ci.ord.s.bp;

import iih.ci.ord.pub.CiOrdAppUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;

/*
 * 医嘱停止或作废时，执行域进行退药处理逻辑操作BP
 */
public class CiOrMpRtnDrug4StopCancBP {
	/**
	 * 医嘱停止或作废时，执行域进行退药处理
	 * @param id_ors
	 * @param dt_cur
	 * @throws BizException
	 */
	public void exec(String[] id_ors,FDateTime dt_cur) throws BizException{
		CiOrdAppUtils.getMpDrugOutService().returnMedWhenStopOrder(id_ors, dt_cur);
	}
}
