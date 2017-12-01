package iih.ci.ord.s.bp.ciprn;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

public class CiprnUpdateFeeBillsPrtCntBP {

	/**
	 * 更新打印标识和打印次数
	 * 
	 * @param idors
	 * @return
	 * @throws BizException
	 */
	public FBoolean exec(String[] idors) throws BizException {
		if (idors == null || idors.length <= 0)
			return FBoolean.TRUE;
		UpdatePrintFgBP bp = new UpdatePrintFgBP();
		bp.exe(idors, ICiDictCodeConst.SD_CIPRNSHEETTP_COSTBILL);
		return FBoolean.TRUE;
	}
}
