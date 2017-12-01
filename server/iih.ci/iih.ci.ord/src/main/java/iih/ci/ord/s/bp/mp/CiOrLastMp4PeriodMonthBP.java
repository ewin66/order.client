package iih.ci.ord.s.bp.mp;

import java.util.Hashtable;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;
import iih.bd.srv.freqdef.d.FreqTimeDO;
import iih.ci.ord.cior.d.CiOrLastMpDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.orsrvsplit.GetFreqTimeDOsBP;
import iih.ci.ord.s.bp.orsrvsplit.OrSrvSplitUtil;

/**
 * 获得频次类型为周期性月时，最后一顿执行判断逻辑数据结果操作BP
 * （不含特例情况处理情形）
 */
public class CiOrLastMp4PeriodMonthBP {
	/**
	 * 获得频次类型为周期性月时
	 * 最后一顿执行判断逻辑数据结果
	 * @param param
	 * @return
	 * @throws BizException 
	 */
	public CiOrLastMpDTO exec(CiOrLastMpDTO param,Hashtable freqHt) throws BizException{
		//有效性判断  应该是不会存在
		if(CiOrdUtils.isEmpty(param))return null;
		
		//最后一顿判断
		if(FDateTime.getHoursBetween(param.getDt_mp_plan(), param.getDt_end())>=CiOrdUtils.HOURS_PER_MONTH){
			return LastMpHelper.getNotLastMpInfoDTO(param);
		}else{
			FreqTimeDO[] freqtimedos = getFreqTimeDOs(param.getId_freq(), freqHt);
			if(CiOrdUtils.isEmpty(getDateArray(param.getDt_mp_plan(),param.getDt_end(),freqtimedos)))
				return LastMpHelper.getLastMpInfoDTO(param);
			else
				return LastMpHelper.getNotLastMpInfoDTO(param);
		}
	}
	
	/**
	 * 获得起止时间内满足的日时刻集合数组
	 * @param dt_mp
	 * @param freqtimedos
	 * @throws BizException 
	 */
	private FDateTime[] getDateArray(FDateTime dt_b,FDateTime dt_e,FreqTimeDO[] freqtimedos){
		return OrSrvSplitUtil.getDateArrayByMonth(dt_b.addSeconds(1), dt_e, freqtimedos);
	}
	
	/***
	 * 获得医嘱频次时刻DO集合数据
	 * 
	 * @param id_freq
	 * @param freqHt
	 * @return
	 * @throws BizException
	 */
	private FreqTimeDO[] getFreqTimeDOs(String id_freq, Hashtable freqHt) throws BizException {
		GetFreqTimeDOsBP bp = new GetFreqTimeDOsBP();
		return bp.exec(id_freq, freqHt);
	}

}
