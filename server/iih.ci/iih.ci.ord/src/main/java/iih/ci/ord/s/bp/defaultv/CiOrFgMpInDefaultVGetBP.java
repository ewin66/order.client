package iih.ci.ord.s.bp.defaultv;

import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 临床医嘱在院执行默认值获取操作BP
 */
public class CiOrFgMpInDefaultVGetBP implements IFgMpInDefaultVGet {
	/**
	 * 临床医嘱在院执行默认值获取操作
	 * @param emsdto
	 * @throws BizException
	 */
	public FBoolean exec(CiEmsDTO emsdto)  throws BizException{
		//医疗单对象为空判断，为空时直接返回
		if(CiOrdUtils.isEmpty(emsdto))return null;
		
		//在院执行对象为空判断，不为空时无需设置值直接返回
		if(!CiOrdUtils.isEmpty(emsdto.getFg_mp_in()))return null;
		
		//住院情形时，默认值设置
		String code_entp=emsdto.getCode_entp();
		if(CiOrdUtils.isIpWf(code_entp)){
			return FBoolean.TRUE;
			//emsdto.setFg_mp_in(FBoolean.TRUE);
		}
		
		//门诊情形时，默认值设置处理
		if(CiOrdUtils.isOpWf(code_entp)){
			return opDefaultVHandle(emsdto);
		}

		return null;
	}
	
	/**
	 * 门诊默认值处理
	 * @param emsdto
	 * @throws BizException 
	 */
	private FBoolean opDefaultVHandle(CiEmsDTO emsdto) throws BizException{
		String sd_srvtp=emsdto.getSd_srvtp();
		
		//非药品医嘱时
		if(!CiOrdUtils.isPharmacy(sd_srvtp)){
			return FBoolean.TRUE;
			//emsdto.setFg_mp_in(FBoolean.TRUE);
		}
		
		//草药医嘱时
		if(CiOrdUtils.isHerbOrder(sd_srvtp)){
			return FBoolean.FALSE;
			//emsdto.setFg_mp_in(FBoolean.FALSE);
		}
		
		//西成药医嘱时
		if(isOrIV(emsdto)){
			//西成药IV医嘱时
			return FBoolean.TRUE;
			//emsdto.setFg_mp_in(FBoolean.TRUE);
		}else{
			//西成药非IV医嘱时
			return FBoolean.FALSE;
			//emsdto.setFg_mp_in(FBoolean.FALSE);
		}
	}
	
	/**
	 * 西成药医嘱时，是否为IV医嘱的判断逻辑
	 * @param emsdto
	 * @return
	 * @throws BizException 
	 */
	private boolean isOrIV(CiEmsDTO emsdto) throws BizException{
		return CiOrdUtils.isWesternMedicineIVOr(emsdto.getId_route());
	}
}
