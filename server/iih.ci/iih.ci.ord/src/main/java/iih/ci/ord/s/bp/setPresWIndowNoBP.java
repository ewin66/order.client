package iih.ci.ord.s.bp;

import iih.ci.ord.pres.d.CiPresDO;
import iih.ci.ord.pub.CiOrdAppUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;

/**
 * 记账时，回写处方的窗口号
 * @author li_zheng
 *
 */
public class setPresWIndowNoBP {
    /**
     * 记账时，回写处方的窗口号
     * @param map
     * @throws BizException
     */
	public void exec(Map<String,String> map)throws BizException{
		if(map != null && map.size() >0){
		  String[] id_pres = (String[]) map.keySet().toArray(new String[map.size()]);	
		  CiPresDO[] cipresDO = findByIds(id_pres,FBoolean.FALSE);
		  if(cipresDO != null && cipresDO.length > 0){
			  List<CiPresDO> list = new ArrayList();
			 for(CiPresDO cipres:cipresDO){
				 if(map.containsKey(cipres.getId_pres())){
					 cipres.setNo_drugwin(map.get(cipres.getId_pres()));
					 cipres.setStatus(DOStatus.UPDATED);
					 list.add(cipres);
				 }
			 }
			 setCipresDO(list.toArray(new CiPresDO[list.size()]));
		  }
		}
	}
	
	private CiPresDO[] findByIds(String[] ids, FBoolean isLazy)throws BizException{
		return CiOrdAppUtils.getCiPresQryService().findByBIds(ids, isLazy);
	}
	
	private CiPresDO[] setCipresDO(CiPresDO[] aggdos)throws BizException{
		return CiOrdAppUtils.getCiPresService().save(aggdos);
	}
}
