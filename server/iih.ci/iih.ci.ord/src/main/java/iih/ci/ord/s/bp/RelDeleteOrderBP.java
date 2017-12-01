package iih.ci.ord.s.bp;

import xap.mw.core.data.BizException;

/**
 * 删除医嘱信息
 * @author li_zheng
 *
 */
public class RelDeleteOrderBP {

	public boolean  RelDeleteOrder(String[] id_orders)throws BizException{
		if(id_orders == null) return false;
		 if(id_orders != null && id_orders.length>0){
			 for(String id_order :id_orders){
				 CiOrDeleteBP bp = new CiOrDeleteBP();
				  bp.exec(id_order);
		    }
			 
		/*	 CiorderAggDO[] add =  CiOrdAppUtils.getOrAggQryService().findByIds(id_orders,  FBoolean.FALSE);
			 CiOrdAppUtils.getOrAggService().logicDelete(add);*/
			
			 return true;
		 }
		return false;
		
	}
}
