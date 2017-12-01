package iih.ci.ord.s.bp;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;

/**
 *  临床医嘱的停止操作BP
 */
public class CiOrderStopBP {
	/**
	 * 临床医嘱的停止
	 * @param id_ors
	 * @param dt_end
	 * @throws BizException
	 */
	public CiOrderDO[] exec(String[] id_ors,FDateTime dt_end) throws BizException{
		//有效性校验
		if(CiOrdUtils.isEmpty(id_ors))return null;
		
		//获得医嘱聚集数据集合
		CiorderAggDO[] aggors = CiOrdAppUtils.getOrAggQryService().findByIds(
				id_ors, FBoolean.FALSE);
		CiOrderDO[] ciors=getCiOrderDOs(aggors);
		
		//医嘱停止状态相关信息修改操作
		CiOrderStopBasicBP bp=new CiOrderStopBasicBP();
		bp.exec(ciors,dt_end);
		
		return ciors;
	}
	
	/**
	 * 获得医嘱主DO数组
	 * @param aggors
	 * @return
	 */
	private CiOrderDO[] getCiOrderDOs(CiorderAggDO[] aggors){
		CiOrderDO[] rtns=new CiOrderDO[aggors.length];
		for(int i=0;i<aggors.length;i++){
			rtns[i]=aggors[i].getParentDO();
		}
		return  rtns;
	}
}
