package iih.ci.ord.s.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.app.d.CiAppLisSheetOrDO;
import iih.ci.ord.app.d.CiapplissheetAggDO;
import iih.ci.ord.app.i.ICiAppLisSheetOrDORService;
import iih.ci.ord.app.i.ICiapplissheetCudService;
import iih.ci.ord.app.i.ICiapplissheetRService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class UpdateLisSheet4CancelFeeBP {

	public void exe(String orderIds) throws BizException{
		CiAppLisSheetOrDO[] items=getLisSheetItems(orderIds);
		if(items.length==0)return;
		List<String> lissheetids=new ArrayList<String>();
		Map<String,List<String>> sheetmap=new HashMap<String,List<String>>();
		for(CiAppLisSheetOrDO item:items){
			if(!lissheetids.contains(item.getId_ciapplissheet())){
				List<String> itemids=new ArrayList<String>();
				itemids.add(item.getId_ciapplissheetor());
				sheetmap.put(item.getId_ciapplissheet(), itemids);
				lissheetids.add(item.getId_ciapplissheet());
			}else{
				sheetmap.get(item.getId_ciapplissheet()).add(item.getId_ciapplissheet());
			}
		}
		if(lissheetids.size()==0)return;
		CiapplissheetAggDO[] aggs=getLisAggs(lissheetids.toArray(new String[lissheetids.size()]));
		for(CiapplissheetAggDO agg:aggs){
			String lisid=agg.getParentDO().getId_ciapplissheet();
			if(!sheetmap.containsKey(lisid))continue;
			if(sheetmap.get(lisid).size()==agg.getCiAppLisSheetOrDO().length){
				agg.getParentDO().setStatus(DOStatus.DELETED);
			}else{
				for(String itemids:sheetmap.get(lisid)){
					for(CiAppLisSheetOrDO itemdo:agg.getCiAppLisSheetOrDO()){
						if(itemdo.getId_ciapplissheetor()==itemids){
							itemdo.setStatus(DOStatus.DELETED);
						}
					}
				}
				agg.getParentDO().setStatus(DOStatus.UPDATED);
			}
		}
		saveLisAggs(aggs);

	}
	/**
	 * 医嘱集合
	 * @param  String ids 
	 * @return CiOrderDO[]s
	 * @throws BizException
	 */
	private CiOrderDO[] getCiOrders(String ids)throws BizException{
		if(ids== null)return null;
		String  whereStr = "id_or in ("+ids+") and sd_srvtp like '"+IBdSrvDictCodeConst.SD_SRVTP_LIS+"%'";
		return CiOrdAppUtils.getOrQryService().find(whereStr, "id_or",FBoolean.FALSE);
	}

	private CiAppLisSheetOrDO[] getLisSheetItems(String ids) throws BizException{
		if(ids== null)return null;
		ICiAppLisSheetOrDORService service=ServiceFinder.find(ICiAppLisSheetOrDORService.class);
		String  whereStr = "id_or in ("+ids+") ";
		return service.find(whereStr, "id_ciapplissheet",FBoolean.FALSE);
	}
	
	private CiapplissheetAggDO[] getLisAggs(String[] ids) throws BizException{
		if(ids== null)return null;
		ICiapplissheetRService service=ServiceFinder.find(ICiapplissheetRService.class);
		return service.findByIds(ids, FBoolean.FALSE);
	}
	
	private void saveLisAggs(CiapplissheetAggDO[] aggs) throws BizException{
		ICiapplissheetCudService service=ServiceFinder.find(ICiapplissheetCudService.class);
		service.save(aggs);
		
	}

}
