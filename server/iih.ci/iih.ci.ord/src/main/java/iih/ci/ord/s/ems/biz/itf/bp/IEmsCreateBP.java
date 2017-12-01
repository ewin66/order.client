package iih.ci.ord.s.ems.biz.itf.bp;

import iih.ci.ord.d.ems.ems.EmsCrtDTO;
import iih.ci.ord.d.ems.ems.EmsRstDTO;
import xap.mw.core.data.BizException;

/**
 * 医疗单新建业务逻辑
 * @author wangqingzhu
 *
 */
public interface IEmsCreateBP {
	/**
	 * 创建医疗单UI对象
	 * @param ems
	 * @return
	 */
	public abstract EmsRstDTO[] create(EmsCrtDTO[] ems) throws BizException;
	
}
