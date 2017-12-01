package iih.ci.ord.s.utils;

import iih.bd.mm.meterial.d.MMPackageUnitDO;
import iih.bd.mm.meterial.d.MeterialAggDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDouble;

public class GetDrugSaleFactor {
	/**
	 * 获取物品总量单位的换算系数
	 * @param meterial
	 * @param id_unit_sale
	 * @return
	 * @throws BizException 
	 */
	public FDouble exec(String id_mm ,String id_unit_sale) throws BizException{
		MeterialAggDO meterial = CiOrdAppUtils.getIMeterialRService().findById(id_mm);
		 
		if(meterial != null && id_unit_sale != null)
		{
			for (MMPackageUnitDO item : meterial.getMMPackageUnitDO()){
				if(item.getId_unit_pkg().equals(id_unit_sale)){
					return item.getFactor();
				}
			}
		}
		return FDouble.ONE_DBL;
	}
}
