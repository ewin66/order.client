/**
 * 
 */
package iih.ci.ord.s.bp;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.s.bp.exception.CiOrderFreqSynchronizationCiOrSrvException;
import xap.mw.core.data.BizException;

/**
 * @ClassName: CiOrderFreqSynchronizationCiOrSrvBP
 * @Description:  医嘱频次同步到医嘱项目，（医嘱项目的频次和医嘱频次基本保持一致）
 * @author Comsys-li_zheng
 * @date 2016年5月10日 下午2:20:50
 * @Package iih.ci.ord.s.bp
 * Copyright: Copyright (c) 2011 
 * Company: 北大医疗信息技术有限责任公司
 */
public class CiOrderFreqSynchronizationCiOrSrvBP {
    //医嘱项目的频次要和医嘱保持一致
	/*@Deprecated
	public void exe(FreqdefDO freqdo,OrdSrvDO[] ordSrvDO) throws BizException{
		if(ciorder == null || ordSrvDO ==  null ||ordSrvDO.length == 0) throw new CiOrderFreqSynchronizationCiOrSrvException();
	    for(OrdSrvDO ordsrv:ordSrvDO){
	    	ordsrv.setId_freq(freqdo.getId_freq());
	    	//ordsrv.setSd_frequnitct(freqdo.getSd_frequnitct);
	    }
	}*/
    //医嘱项目的频次要和医嘱保持一致
	public void exe(String id_freq,OrdSrvDO ordSrvDO)throws BizException{
		if(id_freq == null || ordSrvDO ==  null) throw new CiOrderFreqSynchronizationCiOrSrvException();
		 ordSrvDO.setId_freq(id_freq);
	}
}
