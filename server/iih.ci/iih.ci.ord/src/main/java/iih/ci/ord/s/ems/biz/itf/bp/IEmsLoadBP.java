package iih.ci.ord.s.ems.biz.itf.bp;

import iih.ci.ord.d.ems.ems.EmsCrtDTO;
import iih.ci.ord.d.ems.ems.EmsLoadDTO;
import iih.ci.ord.d.ems.ems.EmsRstDTO;
import xap.mw.core.data.BizException;

/**
 * 医疗单加载业务逻辑
 * @author wangqingzhu
 *
 */
public interface IEmsLoadBP {
	
	/**
	 * 从医嘱加载医疗单
	 * @param arg
	 * @return
	 * @throws BizException
	 */
	public abstract EmsRstDTO[] load(EmsLoadDTO[] args) throws BizException;
}
