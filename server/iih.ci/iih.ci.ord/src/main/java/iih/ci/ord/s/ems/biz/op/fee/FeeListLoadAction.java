package iih.ci.ord.s.ems.biz.op.fee;

import iih.ci.ord.d.ems.fee.FeeListLoadDTO;
import iih.ci.ord.d.ems.fee.FeeListRstDTO;
import iih.ci.ord.s.ems.biz.itf.bp.IFeeListLoadBP;
import xap.mw.core.data.BizException;

/**
 * 费用清单加载服务
 * @author wangqingzhu
 *
 */
public class FeeListLoadAction implements IFeeListLoadBP {

	/**
	 * 费用清单数据加载业务逻辑处理接口
	 */
	private IFeeListLoadBP feeListLoadBP;
	
	/**
	 * 构造方法
	 * @param feeListLoadBP
	 */
	public FeeListLoadAction(IFeeListLoadBP feeListLoadBP){
		this.feeListLoadBP = feeListLoadBP;
	}
	@Override
	public FeeListRstDTO load(FeeListLoadDTO ems) throws BizException {
		// TODO Auto-generated method stub
		return feeListLoadBP.load(ems);
	}

}
