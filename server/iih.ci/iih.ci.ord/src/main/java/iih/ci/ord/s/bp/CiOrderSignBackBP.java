package iih.ci.ord.s.bp;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;

/**
 *  已签署未核对临床医嘱的签署撤回操作BP
 */
public class CiOrderSignBackBP {
	/**
	 * 已签署未核对临床医嘱的签署撤回
	 * @param id_ors
	 * @param sd_entp
	 * @throws BizException
	 */
	public CiOrderDO[] exec(String[] ids,String sd_entp) throws BizException{
		//有效性校验
		if(CiOrdUtils.isEmpty(ids) || CiOrdUtils.isEmpty(sd_entp))return null;
		
		//门诊签署撤销操作处理流程
		if(CiOrdUtils.isOpUrgentWf(sd_entp)){ 
			CiOderSignBack4OpBP bp1=new CiOderSignBack4OpBP();
			return bp1.exec(ids);
		}
		
		//住院签署撤销操作处理流程
		else if(CiOrdUtils.isIpWf(sd_entp)){
			CiOrderSignBack4IpBP bp2=new CiOrderSignBack4IpBP();
			return bp2.exec(ids);
		}
		
		return null;
	}

}
