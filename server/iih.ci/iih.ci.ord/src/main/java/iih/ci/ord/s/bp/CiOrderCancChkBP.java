package iih.ci.ord.s.bp;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.exception.CiOrOperatorCheckException;
import iih.ci.ord.s.bp.validate.CiOrValidateBP;
import iih.ci.ord.s.bp.validate.MethodConstants;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;

/**
 *  临床医嘱的作废核对操作BP
 */
public class CiOrderCancChkBP {
	/**
	 * 临床医嘱的作废核对
	 * @param id_ors
	 * @throws BizException
	 */
	public CiOrderDO[] exec(String[] id_ors) throws BizException{
		//有效性校验
		if(CiOrdUtils.isEmpty(id_ors))return null;
		
		//获得医嘱聚集数据集合
		CiorderAggDO[] aggors = CiOrdAppUtils.getOrAggQryService().findByIds(
				id_ors, FBoolean.FALSE);
		CiOrderDO[] ciors=getCiOrderDOs(aggors);
		CiOrValidateBP validate=new CiOrValidateBP();
		if(!validate.exec(aggors, MethodConstants.CHECK_VALIDATE)){
			throw new CiOrOperatorCheckException();
		}
		FDateTime dt_cur=CiOrdAppUtils.getServerDateTime();
		
		
		
		//医嘱停止或作废时，执行域进行退药处理
//		CiOrMpRtnDrug4StopCancBP bp=new CiOrMpRtnDrug4StopCancBP();
//		bp.exec(id_ors, ciors[0].getDt_effe());
		CiOrMpRtnDrug4StopCanc2BP bp=new CiOrMpRtnDrug4StopCanc2BP();
		bp.exec( getCancelMap(ciors));
		//医嘱状态调整为作废核对
		UpdateOrdStatusInfo1BP bp1=new UpdateOrdStatusInfo1BP();
		bp1.exec(ciors, null, ICiDictCodeConst.SD_SU_CHECKCANCEL);
		
		return ciors;
	}
	
	private FMap getCancelMap(CiOrderDO[] ciors) throws BizException{
		FMap m=new FMap();
		
		for (CiOrderDO ciOrderDO : ciors) {
			if(ciOrderDO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG))
			m.put(ciOrderDO.getId_or(), ciOrderDO.getDt_canc());
		}
		
		return m;
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
