package iih.ci.ord.s.bp.operableords;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.s.bp.validate.CiOrOpenEntStatusValidateBP;
/**
 * 医嘱校验的控制类
 * @author Administrator
 *
 */
public class JudgeOrderStatusInMultiUserBP {
	public FMap2 exec(CiOrderDO[] orders,String id_dep_phy,String id_dep_nur,String validateType) throws BizException{
		if(ICiDictCodeConst.ORD_VALIDATE_TYPE_SIGN.equals(validateType)){
			JudgeSignOrderStatusBP bp = new JudgeSignOrderStatusBP();
			return bp.exec(orders, id_dep_phy,id_dep_nur);
		}else if(ICiDictCodeConst.ORD_VALIDATE_TYPE_BACK.equals(validateType)){
			JudgeBackOrderStatusBP bp = new JudgeBackOrderStatusBP();
			return bp.exec(orders, id_dep_phy,id_dep_nur);
		}else if(ICiDictCodeConst.ORD_VALIDATE_TYPE_CANCEL.equals(validateType)){
			JudgeCancelOrderStatusBP bp = new JudgeCancelOrderStatusBP();
			return bp.exec(orders, id_dep_phy,id_dep_nur);
		}else if(ICiDictCodeConst.ORD_VALIDATE_TYPE_STOP.equals(validateType)){
			JudgeStopOrderStatusBP bp = new JudgeStopOrderStatusBP();
			bp.exec(orders, id_dep_phy,id_dep_nur);
		}else if(ICiDictCodeConst.ORD_VALIDATE_TYPE_OPEN.equals(validateType)){
			JudgeOpenOrderStatusBP bp = new JudgeOpenOrderStatusBP();
			bp.exec(orders, id_dep_phy,id_dep_nur);
		}
		return null;
	}
}
