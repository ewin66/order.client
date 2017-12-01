package iih.ci.mr.i;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;

public interface ICiMrOutQryServices
{
	
	/**
	 * 根据就诊号获取现病史，如果没有数据则返回""
	 * @param idEnt
	 * @return
	 */
	public abstract String getCiMrHistoryOfPresentIllness(String idEnt)  throws BizException;

	/**
	 * 根据就诊号获取最后一次病程FMap，如果没有数据则返回new FMap();
	 * @param idEnt
	 * @return
	 * @throws BizException
	 */
	public abstract FMap2 getCiMrCourseOfLastDisease(String idEnt,FBoolean isFirst) throws BizException; 
	
	/**
	 * 根据就诊号获取所有门诊病历
	 * @param strIdEnts
	 * @return
	 * @throws BizException
	 */
	public abstract FMap2 getOPCiMrByIdEnts(String[] strIdEnts) throws BizException;
}
