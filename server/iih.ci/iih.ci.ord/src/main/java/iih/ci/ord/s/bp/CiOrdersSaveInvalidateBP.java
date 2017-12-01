package iih.ci.ord.s.bp;

import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.validate.SrvMutexValidateBP;
import xap.mw.core.data.BizException;

/*
 * 医嘱保存校验操作BP
 */
public class CiOrdersSaveInvalidateBP {
	/**
	 * 医嘱保存校验
	 * @param aggors
	 * @throws BizException
	 */
	public void exec(CiorderAggDO[] aggors) throws BizException{
		//有效性校验
		if(CiOrdUtils.isEmpty(aggors))return;
		CiOrderSaveInvalidateBP bpmutex=new CiOrderSaveInvalidateBP();
		bpmutex.exec(aggors);
	}
}
