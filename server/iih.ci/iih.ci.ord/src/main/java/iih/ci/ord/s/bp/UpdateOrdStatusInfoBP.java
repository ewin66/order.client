package iih.ci.ord.s.bp;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.dto.d.OrSuModRtnInfoDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;

/**
 * 更新临床医嘱状态及相关信息操作BP
 */
public class UpdateOrdStatusInfoBP {
	/**
	 * 更新临床医嘱状态及相关信息
	 * MM
	 * @param id_ors
	 * @param dt_end
	 * @param sd_su_or
	 * @return
	 * @throws BizException
	 */
	public  OrSuModRtnInfoDTO[] exec(String[] id_ors,FDateTime dt_end,String sd_su_or)  throws BizException{
		//有效性校验
		validateCheck(id_ors,dt_end,sd_su_or);
		
		//获得医嘱
		CiOrderDO[] orders=CiOrdAppUtils.getOrQryService().findByIds(id_ors, new FBoolean(false));
		
		UpdateOrdStatusInfo1BP bp=new UpdateOrdStatusInfo1BP();
		return bp.exec(orders, dt_end, sd_su_or);
	}
	
	/**
	 * 有效性校验
	 * @param id_ors
	 * @param dt_end
	 * @param sd_su_or
	 * @throws BizException
	 */
	private void validateCheck(String[] id_ors,FDateTime dt_end,String sd_su_or) throws BizException{
		if(id_ors==null || id_ors.length==0)return;
		
		//状态校验
		if(!CiOrdUtils.orStatusValidateCheck4Mod(sd_su_or)){
			throw new BizException("传入的状态值不正确！");
		}
	}
}
