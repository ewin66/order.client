package iih.ci.ord.i.ems;

import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.d.ems.thr.ThirdRstDTO;
import xap.mw.core.data.BizException;

public interface ICiOrderThirdService {
	/**
	 * 医技补录医嘱
	 * @param szOrderAggInfo
	 * @return
	 */
	public abstract ThirdRstDTO save(CiorderAggDO[] szOrderAggInfo) throws BizException ;
	/**
	 * 批量删除医技补录医嘱
	 * @param szId_or
	 * @return
	 * @throws BizException
	 */
	public abstract ThirdRstDTO delete(String[] szId_or) throws BizException ;
}
