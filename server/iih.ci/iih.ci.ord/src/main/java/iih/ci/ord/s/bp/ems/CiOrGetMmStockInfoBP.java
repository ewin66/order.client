package iih.ci.ord.s.bp.ems;

import iih.ci.ord.pub.CiOrdAppUtils;
import iih.mm.itf.material.d.GetStockReqDTO;
import iih.mm.itf.material.d.MaterialStockDTO;
import xap.mw.core.data.BizException;

/*
 * 获得物品结存相关信息（价、结存量）
 */
public class CiOrGetMmStockInfoBP {
	/**
	 * 获得物品结存相关信息（价、结存量）
	 * @param id_dep
	 * @param id_mm
	 * @param id_unit
	 * @return
	 * @throws BizException
	 */
	public  MaterialStockDTO[] exec(String id_dep,String id_mm,String id_unit)  throws BizException{
		GetStockReqDTO  reqdto=new GetStockReqDTO();
		reqdto.setId_dep(id_dep);
		reqdto.setId_mm(id_mm);
		reqdto.setReq_unit_id(id_unit);
		//获得对应仓库物品结存与价格信息  
		//特别注意传入的条数与传出的条数可能不一致
		MaterialStockDTO[] stockdtos=CiOrdAppUtils.getMaterialStockQryService().getMaterialStocks(new GetStockReqDTO[]{reqdto}); 
		return stockdtos;
	}
}
