package iih.ci.ord.s.ems.cache;

import iih.bd.base.cache.CiTimerCache;
import iih.ci.ord.ems.d.CiEnContextDTO;

/**
 * 医嘱列表缓存处理
 * @author wangqingzhu
 *
 */
public class OrderListCacheAction extends BaseCacheAction {

	@Override
	public boolean prepareCacheL2( CiEnContextDTO ctx) {
		// 1. 确定缓存关键字
		String sessionKey = L2SessionKeyWith(ctx);
		
		
		// 从应用服务器获取医嘱信息
		if (!CiTimerCache.GetInstance().contains(sessionKey, OrderList_Cache_Key)){
			// 缓存该就诊下的所有医嘱
			
		}
		return false;
	}

	@Override
	public boolean prepareCacheL3( CiEnContextDTO ctx) {
		
		String sessionKey = L3SessionKeyWith(ctx);

		// 从应用服务器获取医嘱信息
		if (!this.isHitCahce(sessionKey, OrderList_Cache_Key)){
			// 缓存该就诊下的所有医嘱
			
		}
		return super.prepareCacheL3( ctx);
	}

	
}
