package iih.ci.ord.s.ortmpl.bp;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import iih.bd.base.cache.CacheContext;
import iih.ci.ord.dto.newordertemplatedto.d.OrderTemplateRstDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;

/**
 * 医嘱模板明细查询
 * @author Young
 *
 */
public class GetOrTplNItmDTOsCacheBP extends CacheContext {

	public OrderTemplateRstDTO exec(String[] id_ortmpls, CiEnContextDTO ctx) throws BizException{
		GetOrTplNItmDTOsBP bp = new GetOrTplNItmDTOsBP(ctx);
		OrderTemplateRstDTO tempLRst = new OrderTemplateRstDTO();
		//缓存存在，但可能医嘱模板不全，缓存中存在的模板取出来，在查询数据库
		FMap ortmplMap =  getCache(L2SessionKeyWith(ctx), OrTempl_Cache_key);
		if (null != ortmplMap)
		{
			List<String> unContainsIds = new ArrayList<String>();
			for (String id_ortmpl : id_ortmpls) {
				if (!ortmplMap.containsKey(id_ortmpl))
					unContainsIds.add(id_ortmpl);
			}
			if (unContainsIds.size() > 0) {
				FMap unOrtmplMap = bp.getOrderTemplateDTO(unContainsIds.toArray(new String[unContainsIds.size()]));
				ortmplMap.putAll(unOrtmplMap);
				putCache(L2SessionKeyWith(ctx), OrTempl_Cache_key, ortmplMap);
			}
		} else {
			//缓存中不存在，需要查询数据库
			ortmplMap = bp.getOrderTemplateDTO(id_ortmpls);
			putCache(L1SessionKeyWith(ctx), OrTempl_Cache_key, ortmplMap);
		}
		tempLRst.setTemplItm(ortmplMap);
		tempLRst.setFreqdefdo(bp.getFreqDefDO());
		return tempLRst;
	}
}
