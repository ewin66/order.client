package iih.ci.ord.s.bp;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.cior.d.CiOrReactLogDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;

/**
 *  住院已签署未核对临床医嘱的签署撤回操作BP
 */
public class CiOrderSignBack4IpBP {
	/**
	 * 住院已签署未核对临床医嘱的签署撤回
	 * @param id_ors
	 * @param sd_entp
	 * @throws BizException
	 */
	public CiOrderDO[] exec(String[] id_ors) throws BizException{
		//有效性校验
		if(CiOrdUtils.isEmpty(id_ors) )return null;
		
		//获得医嘱聚集数据集合
		CiorderAggDO[] aggors = CiOrdAppUtils.getOrAggQryService().findByIds(
				id_ors, FBoolean.FALSE);
		CiOrderDO[] ciors=getCiOrderDOs(aggors);
		
		//获得排斥日志中获得被排斥医嘱数据信息
		GetReactedOrsInReactlogBP bp=new GetReactedOrsInReactlogBP();
		CiOrReactLogDO[] reactlog=bp.exec(id_ors);
		
		//被排斥医嘱截止时间还原
		ReactedOrsDtEndRestoreBP bp2=new ReactedOrsDtEndRestoreBP();
		bp2.exec(reactlog);
		
		//更新医嘱状态为签署
		UpdateOrdStatusInfo1BP bp1=new UpdateOrdStatusInfo1BP();
		bp1.exec(ciors, null, ICiDictCodeConst.SD_SU_OPEN);
		
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
