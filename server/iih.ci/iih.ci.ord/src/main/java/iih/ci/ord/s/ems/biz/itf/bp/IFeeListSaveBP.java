package iih.ci.ord.s.ems.biz.itf.bp;

import iih.ci.ord.d.ems.fee.FeeListRstDTO;
import iih.ci.ord.d.ems.fee.FeeListSaveDTO;
import xap.mw.core.data.BizException;

/**
 * 费用清单数据保存业务处理接口
 * @author wangqingzhu
 *
 */
public interface IFeeListSaveBP {
	
	/**
	 * 保存费用清单数据
	 * @param ems
	 * @return
	 * @throws BizException
	 */
	public abstract FeeListRstDTO save(FeeListSaveDTO ems) throws BizException;
}
