package iih.ci.ord.s.ems.biz.op.fee;

import iih.ci.ord.d.ems.fee.FeeListRstDTO;
import iih.ci.ord.d.ems.fee.FeeListSaveDTO;
import iih.ci.ord.s.ems.biz.itf.bp.IFeeListSaveBP;
import xap.mw.core.data.BizException;

/**
 * 费用清单保存服务
 * @author wangqingzhu
 *
 */
public class FeeListSaveAction implements IFeeListSaveBP{

	private IFeeListSaveBP feeListSaveBP;
	
	/**
	 * 构造方法
	 * @param feeListSaveBP
	 */
	public FeeListSaveAction(IFeeListSaveBP feeListSaveBP){
		this.feeListSaveBP = feeListSaveBP;
	}
	@Override
	public FeeListRstDTO save(FeeListSaveDTO ems) throws BizException {
		// TODO Auto-generated method stub
		return feeListSaveBP.save(ems);
	}

}
