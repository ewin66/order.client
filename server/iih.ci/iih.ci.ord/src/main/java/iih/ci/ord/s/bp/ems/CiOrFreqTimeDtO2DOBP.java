package iih.ci.ord.s.bp.ems;

import iih.ci.ord.ciorder.d.OrdFreqTimeDO;
import iih.ci.ord.ems.d.CiOrFreqTimeDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;

/**
 * 医嘱频次执行时刻DTO数据转换为DO数据操作BP
 */
public class CiOrFreqTimeDtO2DOBP {
	/**
	 * 
	 * @param orfreqextime
	 * @return
	 * @throws BizException
	 */
	public  OrdFreqTimeDO[] exec(FArrayList orfreqextimes)  throws BizException{
		if(orfreqextimes==null || orfreqextimes.size()==0)return null;
		OrdFreqTimeDO[] rtn=new OrdFreqTimeDO[orfreqextimes.size()];
		for(int i=0;i<orfreqextimes.size();i++){
			rtn[i]=getCiOrFreqTimeDO((CiOrFreqTimeDTO)orfreqextimes.get(i),i);
		}
		return rtn;
	}
	
	/**
	 * 获得医嘱执行时刻DO数据
	 * @param dto
	 * @param i
	 * @return
	 */
	private OrdFreqTimeDO getCiOrFreqTimeDO(CiOrFreqTimeDTO dto,int i){
		OrdFreqTimeDO rtn=new OrdFreqTimeDO();
		//rtn.setId_orfreqtime(Id_orfreqtime);
		//rtn.setId_or(Id_or);
		rtn.setSortno(i);
		rtn.setWdno(dto.getWdno());
		rtn.setTime_mp(dto.getTime_mp());
		rtn.setDes_mp(dto.getDes_mp());
		rtn.setStatus(DOStatus.NEW);
		return rtn;
	}
}
