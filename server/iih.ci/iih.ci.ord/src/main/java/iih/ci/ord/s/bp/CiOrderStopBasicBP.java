package iih.ci.ord.s.bp;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;

/**
 *  临床医嘱的停止操作BP
 */
public class CiOrderStopBasicBP {
	/**
	 * 临床医嘱的停止
	 * @param ciorders
	 * @throws BizException
	 */
	public void exec(CiOrderDO[] ciorders,FDateTime dt_end) throws BizException{
		//有效性校验
		if(CiOrdUtils.isEmpty(ciorders))return ;
	
		//医嘱状态调整为停止
		UpdateOrdStatusInfo1BP bp1=new UpdateOrdStatusInfo1BP();
		bp1.exec(ciorders, dt_end, ICiDictCodeConst.SD_SU_DOCTORSTOP);
	}


}
