package iih.ci.ord.s.bp.mp;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;
import iih.ci.ord.cior.d.CiOrLastMpDTO;
import iih.ci.ord.ciorder.d.OrdFreqTimeDO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.orsrvsplit.OrSrvSplitUtil;

/**
 * 获得频次类型为计划时，最后一顿执行判断逻辑数据结果操作BP
 * （不含特例情况处理情形）
 */
public class CiOrLastMp4PlanBP {
	/**
	 * 获得频次类型为计划时
	 * 最后一顿执行判断逻辑数据结果
	 * @param param
	 * @param freqtimedos
	 * @return
	 * @throws BizException 
	 */
	public CiOrLastMpDTO exec(CiOrLastMpDTO param) throws BizException{
		//有效性判断  应该是不会存在
		if(CiOrdUtils.isEmpty(param))return null;
		
		//最后一顿判断
		OrdFreqTimeDO[] dts=OrSrvSplitUtil.getOrdFreqTimeDOs(param.getId_or(),param.getDt_mp_plan());
		if(CiOrdUtils.isEmpty(dts)){//应该不会出现
			return LastMpHelper.getLastMpInfoDTO(param);
		}else{
			if(isLastMp(dts,param.getDt_mp_plan())){
				return LastMpHelper.getLastMpInfoDTO(param);
			}else{
				return LastMpHelper.getNotLastMpInfoDTO(param);
			}
		}
	}
	
	/**
	 * 是否是最后一顿的判断
	 * @param dts
	 * @param dt_mp
	 * @return
	 */
	private boolean isLastMp(OrdFreqTimeDO[] dts,FDateTime dt_mp){
		FDateTime dt=null;
		for(int i=0;i<dts.length;i++){
			dt=new FDateTime(dts[i].getWdno(),dts[i].getTime_mp());
			if(dt.after(dt_mp))return false;
		}
		return true;
	}
	
}
