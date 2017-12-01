package iih.ci.ord.s.bp.oporsplit;

import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import iih.ci.ord.dto.oporsplit.d.OpOrSplitParamDTO;
import iih.ci.ord.dto.oporsplit.d.OpOrderSplitDTO;

/**
 * 门急诊医嘱拆分主逻辑
 * 
 * @author xuxing2016-09-28
 *
 */
public class getOpOrSplitSqlRsBp {

	/**
	 * 主入口
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */

	public BaseDTO[] exec(OpOrSplitParamDTO param) throws BizException {

		// 1、检索即将拆分的医嘱
		BaseDTO[] splitOrders = queryData(param);

		// 2、拆分
		BaseDTO[] rtn = split(splitOrders, param);

		return rtn;
	}

	/**
	 * 检索即将拆分的医嘱
	 * 
	 * @param param
	 * @throws BizException
	 */
	private BaseDTO[] queryData(OpOrSplitParamDTO param) throws BizException {

		GetOrSplitSqlBp bp = new GetOrSplitSqlBp();

		return bp.exec(param);
	}

	/**
	 * 拆分
	 * 
	 * @param splitDTOS
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private BaseDTO[] split(BaseDTO[] splitDTOS, OpOrSplitParamDTO param) throws BizException {

		OpOrderSplitBp bp = new OpOrderSplitBp();

		return bp.exec((OpOrderSplitDTO[]) splitDTOS, param.getInterfacetp());
	}

}
