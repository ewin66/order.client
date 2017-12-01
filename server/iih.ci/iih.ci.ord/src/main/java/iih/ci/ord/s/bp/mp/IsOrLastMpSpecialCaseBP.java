package iih.ci.ord.s.bp.mp;

import iih.ci.ord.cior.d.CiOrLastMpDTO;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 医嘱执行最后一顿特例情况判断操作BP
 */
public class IsOrLastMpSpecialCaseBP {

	/**
	 * 医嘱执行最后一顿特例情况判断
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public FBoolean exec(CiOrLastMpDTO param) throws BizException{
		//有效性判断
		if(!validateCheck(param))return FBoolean.FALSE;
		
		if(!CiOrdUtils.isIpWf(param.getCode_entp())) return FBoolean.FALSE;
		
		//if(CiOrdUtils.isTrue(param.getFg_long()))return FBoolean.TRUE;  //2016-08-26判断错误
		if(!CiOrdUtils.isTrue(param.getFg_long()))return FBoolean.TRUE;  
		
		if(CiOrdUtils.isTrue(param.getFg_pres_outp()))return FBoolean.TRUE; 
		
		if(CiOrdUtils.isHerbOrder(param.getSd_srvtp()))return FBoolean.TRUE;   //？？
		
		return FBoolean.FALSE;
	}
	
	/**
	 * 有效性校验
	 * @param param
	 * @return
	 */
	private boolean validateCheck(CiOrLastMpDTO param){
		if(CiOrdUtils.isEmpty(param))return false;
		
		return true;
	}

}
