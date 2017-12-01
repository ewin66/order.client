package iih.ci.ord.s.bp.ems;

import iih.mm.itf.material.d.MaterialStockDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDouble;

/*
 * 获得物品结存价
 */
public class CiOrGetMmPriceBP {
	/**
	 * 获得物品结存价
	 * @param id_dep
	 * @param id_mm
	 * @param id_unit
	 * @return
	 * @throws BizException
	 */
	public  FDouble exec(String id_dep,String id_mm,String id_unit)  throws BizException{
		CiOrGetMmStockInfoBP bp=new CiOrGetMmStockInfoBP();
		MaterialStockDTO[] stockdtos=bp.exec(id_dep, id_mm, id_unit);
		if(stockdtos==null || stockdtos.length==0)return null;
		return stockdtos[0].getPrice_act();
	}
}
