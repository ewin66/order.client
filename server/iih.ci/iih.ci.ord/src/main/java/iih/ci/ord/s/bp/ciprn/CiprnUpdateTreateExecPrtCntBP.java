package iih.ci.ord.s.bp.ciprn;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

public class CiprnUpdateTreateExecPrtCntBP {

	/**
	 * 更新打印标识和打印次数
	 * 
	 * @param idors
	 * @return
	 * @throws BizException
	 */
	public FBoolean exec(String[] idors, String sd_ciprnsheettp) throws BizException {
		if (idors == null || idors.length <= 0)
			return FBoolean.TRUE;
		UpdatePrintFgBP bp = new UpdatePrintFgBP();
		bp.exe(idors, sd_ciprnsheettp);
		return FBoolean.TRUE;
	}
}
