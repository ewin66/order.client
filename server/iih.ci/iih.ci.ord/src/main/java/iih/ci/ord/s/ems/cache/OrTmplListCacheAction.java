package iih.ci.ord.s.ems.cache;

import java.util.List;

import iih.bd.base.cache.CiTimerCache;
import iih.ci.diag.cidiag.d.CidiagAggDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.s.bp.getSrvortplitemAggDOSBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;

/**
 * 医嘱模板缓存
 * @author wangqingzhu
 *
 */
public class OrTmplListCacheAction extends BaseCacheAction {

	@Override
	public boolean prepareCacheL2(CiEnContextDTO ctx) {
		// 1. 确定缓存关键字
		String sessionKey = L2SessionKeyWith(ctx);
		// 从应用服务器获取医嘱信息
		if (!this.isHitCahce(sessionKey, OrTempl_Cache_key)) {
			String Id_pripat = ctx.getEnt4BannerDTO().getId_pripat();
			String id_hp = ctx.getEnt4BannerDTO().getId_hp();
			String code_entp = ctx.getEnt4BannerDTO().getCode_entp();
			// 缓存该就诊下的所有模板信息
			try {
				getSrvortplitemAggDOSBP bp = new getSrvortplitemAggDOSBP(ctx);
				FMap templMap = bp.getNewOrderTemplateDTO2(Id_pripat,id_hp,code_entp);
				if(templMap.size()!=0){
					CiTimerCache.GetInstance().put(sessionKey, OrTempl_Cache_key, templMap);
				}
			} catch (BizException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	@Override
	public boolean prepareCacheL3(CiEnContextDTO ctx) {
		// TODO Auto-generated method stub
		return super.prepareCacheL3(ctx);
	}

}
