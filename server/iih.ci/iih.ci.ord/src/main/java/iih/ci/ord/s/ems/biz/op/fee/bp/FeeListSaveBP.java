package iih.ci.ord.s.ems.biz.op.fee.bp;

import iih.bd.base.cache.CacheContext;
import iih.ci.ord.d.ems.fee.FeeListRstDTO;
import iih.ci.ord.d.ems.fee.FeeListSaveDTO;
import iih.ci.ord.s.ems.biz.itf.IEmsValidate;
import iih.ci.ord.s.ems.biz.itf.bp.IFeeListSaveBP;
import xap.mw.core.data.BizException;

/**
 * 保存费用清单数据
 * @author wangqingzhu
 *
 */
public class FeeListSaveBP extends CacheContext implements IFeeListSaveBP {

	/**
	 * 费用清单保存逻辑校验接口
	 */
	private IEmsValidate feeListValidate;
	
	public FeeListSaveBP(IEmsValidate feeListValidate){
		this.feeListValidate = feeListValidate;
	}
	@Override
	public FeeListRstDTO save(FeeListSaveDTO ems) throws BizException {
		// 解析参数 FeeListSaveDTO 并转化为内部保存逻辑使用参数（注意参数的生命周期）
		
		// 分拣出需要保存的费用数据，并进行数据校验
		
		
		// 将保存数据转化为DO对象，并进行数据库保存前数据校验
		
		// 执行数据库保存
		
		// 处理返回值结果或者错误信息
		FeeListRstDTO feeListRstDTO = new FeeListRstDTO();
		return feeListRstDTO;
	}

}
