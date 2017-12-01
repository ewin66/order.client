package iih.ci.ord.s.ems;

import iih.bd.base.cache.BizCacheType;
import iih.bd.base.cache.CiTimerCache;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.ems.ICiSysCacheService;
import iih.ci.ord.s.ems.biz.base.BaseSysCacheService;
import iih.ci.ord.s.ems.cache.BaseCacheAction;
import iih.ci.ord.s.ems.cache.DiagListCacheAction;
import iih.ci.ord.s.ems.cache.EmsListCacheAction;
import iih.ci.ord.s.ems.cache.OrTmplListCacheAction;
import iih.ci.ord.s.ems.cache.OrderListCacheAction;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;

@Service(serviceInterfaces = { ICiSysCacheService.class }, binding = Binding.JSONRPC)
public class CiSysCacheServiceImpl extends BaseSysCacheService implements ICiSysCacheService{
	
	private BaseCacheAction orderListCacheAction = new OrderListCacheAction();

	private BaseCacheAction emsListCacheAction = new EmsListCacheAction();
	
	private BaseCacheAction diagListCacheAction = new DiagListCacheAction(); 
	
	private BaseCacheAction orTmplListCacheAction = new OrTmplListCacheAction();
	/**
	 * 二级缓存
	 * @param ctx
	 * @return
	 * @throws BizException
	 */
	@Override
	public FBoolean prepareL2Cache(CiEnContextDTO ctx) throws BizException {
		
		orderListCacheAction.prepareCacheL2( ctx);
		emsListCacheAction.prepareCacheL2(ctx);
		diagListCacheAction.prepareCacheL2(ctx);
		orTmplListCacheAction.prepareCacheL2(ctx);
		return FBoolean.TRUE;
	}

	/**
	 * 三级缓存
	 * @param ctx
	 * @return
	 * @throws BizException
	 */
	@Override
	public FBoolean prepareL3Cache(CiEnContextDTO ctx) throws BizException {
		
		// 缓存该就诊下的所有医嘱
		orderListCacheAction.prepareCacheL3( ctx);
		emsListCacheAction.prepareCacheL3( ctx);
		diagListCacheAction.prepareCacheL3(ctx);
		orTmplListCacheAction.prepareCacheL3(ctx);
		return FBoolean.TRUE;
	}

	@Override
	public FBoolean clearL1Cache(CiEnContextDTO ctx) throws BizException {
		CiTimerCache.GetInstance().clear(BizCacheType.CacheType_L1);
		return FBoolean.TRUE;
	}

	@Override
	public FBoolean clearL2Cache(CiEnContextDTO ctx) throws BizException {
		CiTimerCache.GetInstance().clear(BizCacheType.CacheType_L2);
		return FBoolean.TRUE;
	}

	@Override
	public FBoolean clearL3Cache(CiEnContextDTO ctx) throws BizException {
		CiTimerCache.GetInstance().clear(BizCacheType.CacheType_L3);
		return FBoolean.TRUE;
	}

	@Override
	public FBoolean clearCache(String cacheType, String keyword) throws BizException {
		CiTimerCache.GetInstance().clear(cacheType, keyword);
		return null;
	}


}
