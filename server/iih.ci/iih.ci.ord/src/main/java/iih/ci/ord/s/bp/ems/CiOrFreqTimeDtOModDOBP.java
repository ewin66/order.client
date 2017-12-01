package iih.ci.ord.s.bp.ems;

import java.util.ArrayList;

import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdFreqTimeDO;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;

/**
 * 根据医嘱频次执行时刻DTO数据修改对应DO数据操作BP
 */
public class CiOrFreqTimeDtOModDOBP {
	/**
	 * 根据医嘱频次执行时刻DTO数据修改对应DO数据
	 * @param orfreqextime
	 * @return
	 * @throws BizException
	 */
	public  void exec(CiorderAggDO aggdo,FArrayList orfreqextimes)  throws BizException{
/*		//参数设置
		OrdFreqTimeDO[] orfreqtimedos=aggdo.getOrdFreqTimeDO();
		ArrayList<OrdFreqTimeDO> list=new ArrayList<OrdFreqTimeDO>();
		FMap map=CiOrdUtils.array2FMap(orfreqtimedos);
		OrdFreqTimeDO fretimedo=null;
		//遍历
		for(int i=0;i<orfreqextimes.size();i++){
			fretimedo=(OrdFreqTimeDO)orfreqextimes.get(i);
			
		}*/
		//传入的orfreqextimes数据已经含状态应该不用再处理了
		aggdo.setOrdFreqTimeDO((OrdFreqTimeDO[])CiOrdUtils.list2Array(orfreqextimes, OrdFreqTimeDO.class));
		
	}
}
