package iih.ci.ord.s.bp.orsms.lis;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;

/**
 * 临床医嘱分合单时，分合单医嘱过滤与处理操作BP
 */
public class CiOrSmsLisOrFilterHandleBP {
	/**
	 * 临床医嘱分合单时，分合单医嘱过滤与处理
	 * @param ciorder
	 * @param session
	 * @return
	 * @throws BizException
	 */
	public CiOrderDO[] exec(CiOrderDO[] ciorder )throws BizException{
		String code_entp=ciorder[0].getCode_entp();
		if(CiOrdUtils.isEmpty(ciorder) || !CiOrdUtils.isOpUrgentWf(ciorder[0].getCode_entp()))
		{
			

				return null;
			}
		
		
		//返回
		return ciorder;
	}
	

}
