package iih.ci.ord.s.bp.mp;

import iih.ci.ord.cior.d.CiOrLastMpDTO;
import iih.ci.ord.cior.d.LastOfMpRstTp;
import iih.ci.ord.pub.CiOrdUtils;

/**
 * 获得频次类型为周期性小时时，最后一顿执行判断逻辑数据结果操作BP
 * （不含特例情况处理情形）
 */
public class CiOrLastMp4PeriodHourBP {
	/**
	 * 获得频次类型为周期性小时时
	 * 最后一顿执行判断逻辑数据结果
	 * @param param
	 * @return
	 */
	public CiOrLastMpDTO exec(CiOrLastMpDTO param){
		//有效性判断  应该是不会存在
		if(CiOrdUtils.isEmpty(param))return null;
		
		//最后一顿判断
		if(CiOrdUtils.isLastMp(param.getDt_mp_plan(), param.getDt_end(), param.getFrequnitct())){
			return LastMpHelper.getLastMpInfoDTO(param);
		}
		
		//其它情况处理
		return LastMpHelper.getNotLastMpInfoDTO(param);
	}


}
