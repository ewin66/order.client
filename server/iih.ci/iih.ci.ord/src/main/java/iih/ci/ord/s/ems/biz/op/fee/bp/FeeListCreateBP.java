package iih.ci.ord.s.ems.biz.op.fee.bp;

import iih.bd.base.cache.CacheContext;
import iih.ci.ord.d.ems.fee.FeeListCrtDTO;
import iih.ci.ord.d.ems.fee.FeeListRstDTO;
import iih.ci.ord.s.ems.biz.itf.bp.IFeeListCreateBP;
import xap.mw.core.data.BizException;

/**
 * 创建费用清单项目
 * @author wangqingzhu
 *
 */
public class FeeListCreateBP extends CacheContext implements IFeeListCreateBP {

	@Override
	public FeeListRstDTO create(FeeListCrtDTO ems) throws BizException {
		// 解析 参数 FeeListCrtDTO 数据，并转化为bp内部使用数据结构
		
		// 获取基础服务信息，并组装主题费用清单UI行数据
		
		// 补充主服务信息的不足（执行科室的参照过滤、价格、医保信息等等）
		
		// 组装返回数据，或者错误信息数据（ErrorEmsList 暂用-日后改名)
		FeeListRstDTO feeListRstDTO = new FeeListRstDTO();
		return feeListRstDTO;
	}

}
