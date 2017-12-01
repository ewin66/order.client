package iih.ci.ord.s.ems.cache;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import iih.bd.base.cache.CiTimerCache;
import iih.ci.diag.cidiag.d.CidiagAggDO;
import iih.ci.diag.cidiag.i.ICidiagRService;
import iih.ci.ord.ems.d.CiEnContextDTO;

/**
 * 诊断列表信息缓存处理
 * @author wangqingzhu
 *
 */
public class DiagListCacheAction extends BaseCacheAction {

	@Override
	public boolean prepareCacheL2( CiEnContextDTO ctx) { 
		// 1. 确定缓存关键字
		String sessionKey = L2SessionKeyWith(ctx);
		
		
		// 从应用服务器获取医嘱信息
		if (!this.isHitCahce(sessionKey, DiagList_Cache_Key)){
			// 缓存该就诊下的所有诊断
			try {
				List<CidiagAggDO> diagaggdolist=getDiagList(ctx.getId_en());
				if(diagaggdolist.size()!=0){
					this.putCache(sessionKey, DiagList_Cache_Key, diagaggdolist);
				}
			} catch (BizException e) {
				e.printStackTrace();
			}
			
		}
		return false;
	}

	@Override
	public boolean prepareCacheL3( CiEnContextDTO ctx) {

		String sessionKey = L3SessionKeyWith(ctx);
		
		if (!CiTimerCache.GetInstance().contains(sessionKey, DiagList_Cache_Key)){
			// 缓存该就诊下的所有诊断
		}
		return super.prepareCacheL3(ctx);
	}
	
	private List<CidiagAggDO> getDiagList(String id_en) throws BizException{
		ICidiagRService service=ServiceFinder.find(ICidiagRService.class);
		CidiagAggDO[] aggdos=service.find(" a0.id_en='"+id_en+"'", null, FBoolean.FALSE);
		List<CidiagAggDO> aggdoList=new ArrayList<CidiagAggDO>();
		for(CidiagAggDO aggdo:aggdos){
			aggdoList.add(aggdo);
		}
		return aggdoList;
	}
	
}
