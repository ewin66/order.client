package iih.ci.ord.s.ems.biz.itf.bp;

import iih.ci.ord.d.ems.fee.FeeListLoadDTO;
import iih.ci.ord.d.ems.fee.FeeListRstDTO;
import xap.mw.core.data.BizException;
/**
 * 费用清单数据加载业务处理接口
 * @author wangqingzhu
 *
 */
public interface IFeeListLoadBP {
	/**
	 * 加载费用清单数据
	 * @param ems
	 * @return
	 * @throws BizException
	 */
	public abstract FeeListRstDTO load(FeeListLoadDTO ems) throws BizException;
}
