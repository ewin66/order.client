package iih.ci.ord.s.bp;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.exception.CiOrOperatorCheckException;
import iih.ci.ord.s.bp.exception.GrpInReactExistMultiOrException;
import iih.ci.ord.s.bp.validate.CiOrValidateBP;
import iih.ci.ord.s.bp.validate.MethodConstants;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 *  临床医嘱的核对操作BP
 */
public class CiOrderCheckBP {
	/**
	 * 临床医嘱的核对
	 * @param ciorders
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
		//医嘱状态调整为停止
		UpdateOrdStatusInfo1BP bp1=new UpdateOrdStatusInfo1BP();
		bp1.exec(ciors, null, ICiDictCodeConst.SD_SU_CHECKTHROUGH);
		
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
