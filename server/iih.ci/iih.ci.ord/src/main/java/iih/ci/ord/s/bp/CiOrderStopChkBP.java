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
 *  临床医嘱的停止核对操作BP
 */
public class CiOrderStopChkBP {
	/**
	 * 临床医嘱的停止核对
	 * @param ciorders
	 * @throws BizException
	 */
	public CiOrderDO[] exec(String[] id_ors) throws BizException{
		//有效性校验
		if(CiOrdUtils.isEmpty(id_ors))return null;
		
		//获得医嘱聚集数据集合
		CiorderAggDO[] aggors = CiOrdAppUtils.getOrAggQryService().findByIds(
				id_ors, FBoolean.FALSE);
		
		CiOrValidateBP validate=new CiOrValidateBP();
		if(!validate.exec(aggors, MethodConstants.CHECK_VALIDATE)){
			throw new CiOrOperatorCheckException();
		}
		CiOrderDO[] ciors=getCiOrderDOs(aggors);
		FDateTime dt_cur=CiOrdAppUtils.getServerDateTime();
		
		//医嘱停止或作废时，执行域进行退药处理
//		CiOrMpRtnDrug4StopCancBP bp=new CiOrMpRtnDrug4StopCancBP();
//		bp.exec(id_ors, ciors[0].getDt_end());
		CiOrMpRtnDrug4StopCanc2BP bp=new CiOrMpRtnDrug4StopCanc2BP();
		bp.exec( getStopMap(ciors));
		//医嘱状态调整为停止核对
		UpdateOrdStatusInfo1BP bp1=new UpdateOrdStatusInfo1BP();
		bp1.exec(ciors, null, ICiDictCodeConst.SD_SU_CHECKSTOP);
		
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
	
	private FMap getStopMap(CiOrderDO[] ciors) throws BizException{
		FMap m=new FMap();
		
		for (CiOrderDO ciOrderDO : ciors) {
			if(ciOrderDO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG))
			m.put(ciOrderDO.getId_or(), ciOrderDO.getDt_end());
		}
		
		return m;
	}

}
