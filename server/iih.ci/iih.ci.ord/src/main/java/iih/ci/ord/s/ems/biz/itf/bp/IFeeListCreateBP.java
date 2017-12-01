package iih.ci.ord.s.ems.biz.itf.bp;

import iih.ci.ord.d.ems.fee.FeeListCrtDTO;
import iih.ci.ord.d.ems.fee.FeeListRstDTO;
import xap.mw.core.data.BizException;

/**
 * 费用清单创建费用数据业务处理接口
 * @author wangqingzhu
 *
 */
public interface IFeeListCreateBP {
	/**
	 * 创建费用数据
	 * @param ems
	 * @return
	 * @throws BizException
	 */
	public abstract FeeListRstDTO create(FeeListCrtDTO ems) throws BizException;
}
