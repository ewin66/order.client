package iih.ci.ord.s.bp.orsrvsplit;

import iih.bd.srv.freqdef.d.FreqTimeDO;

import java.util.Hashtable;

import xap.mw.core.data.BizException;

/***
 * 获得医嘱频次时刻数据信息集合操作BP
 */
public class GetFreqTimeDOsBP {
	/***
	 *  获得医嘱频次时刻数据信息集合
	 * @param id_freq
	 * @param freqHt
	 * @return
	 * @throws BizException
	 */
	public FreqTimeDO[] exec(String id_freq,Hashtable freqHt) throws BizException{
		FreqTimeDO[] freqtimedos=null;
		if(freqHt.containsKey(id_freq)){
			freqtimedos=(FreqTimeDO[])freqHt.get(id_freq);
		}else{
			freqtimedos=OrSrvSplitUtil.getFreqTimeDOs(id_freq);
			freqHt.put(id_freq, freqtimedos);
		}
		
		return freqtimedos;
	}
}
