package iih.ci.ord.s.ems.biz.itf.bp;

import iih.ci.ord.d.ems.ems.EmsRstDTO;
import iih.ci.ord.d.ems.ems.EmsSaveDTO;
import xap.mw.core.data.BizException;

/**
 * 医疗单保存业务逻辑
 * @author wangqingzhu
 *
 */
public interface IEmsSaveBP {
	/**
	 * 保存医疗单
	 * @param ems
	 * @return
	 */
	public abstract EmsRstDTO save(EmsSaveDTO ems) throws BizException;
}
